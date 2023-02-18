package com.ruoyi.chenckin.util;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;

/**
 * @author:
 * @Date: 2023-02-08 21:32
 * @Description: < 描述 >
 */
class ChenckinUtils {


    /**
     * 阿里云签到
     */
    public static String[] checkInAliYunDriver(String token) {
        String[] returnArray = new String[2];
        // 刷新Token获取Token
        HttpRequest refreshPost = HttpRequest.post("https://auth.aliyundrive.com/v2/account/token");
        JSONObject refreshJson = new JSONObject();
        refreshJson.put("grant_type", "refresh_token");
        refreshJson.put("app_id", "pJZInNHN2dZWk8qg");
        refreshJson.put("refresh_token", token);
        refreshPost.body(refreshJson.toJSONString());
        String refreshBody = refreshPost.execute().body();
        JSONObject refreshResultJson = JSONObject.parseObject(refreshBody);
        String accessToken = refreshResultJson.getString("access_token");
        // 下一次获取新Token用的
        String refreshToken = refreshResultJson.getString("refresh_token");
        // 签到
        HttpRequest post = HttpRequest.post("https://member.aliyundrive.com/v1/activity/sign_in_list");
        post.header("Host", "member.aliyundrive.com").header("Accept", "application/json, text/plain, */*").header("Authorization", accessToken).body("{}");
        String body = post.execute().body();
        returnArray[0] = refreshToken;
        returnArray[1] = body;
        return returnArray;
    }

    /**
     * BMW 签到
     */
    public static String checkInMyBMW(String token) {
        return HttpRequest.post("https://stm-collect.cn.miaozhen.com/track_ajax?" + token).execute().body();
    }

    /**
     * 万词王
     */
    public static String checkInWanCiWang(String token) {
        HttpRequest post = HttpRequest.post("https://recite.perfectlingo.com/api/recite/user-stat/v1/report-daily-registration?clientTime=" + System.currentTimeMillis());
        post.header("X-Eng-Auth", token);
        String body = post.execute().body();
        return body;
    }


    /**
     * CSDN
     */
    public static String checkInCSDN(String token) {
        HttpRequest post = HttpRequest.post("https://miniapp-api.csdn.net/points/api/task/activity/signin/addSignin");
        String[] split = token.split("\n");
        for (String s : split) {
            String[] split1 = s.split(":");
            if (split1.length >= 2) {
                post.header(split1[0], split1[1]);
            }
        }
        post.body("{\"activityId\":1005,\"pageNum\":2,\"pageSize\":4,\"queryType\":\"noCash\"}");
        return post.execute().body();
    }


}
