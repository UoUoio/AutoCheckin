package com.ruoyi.chenckin.util;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.chenckin.domain.ChenckinAccount;

import java.util.List;

/**
 * @author:
 * @Date: 2023-02-08 21:32
 * @Description: < 描述 >
 */
class ChenckinUtils {


    /**
     * 阿里云签到
     */
    public static String checkInAliYunDriver(String token) {
        // 使用hutool创建post请求,并设置请求头内容
        HttpRequest post = HttpRequest.post("https://member.aliyundrive.com/v1/activity/sign_in_list");
        post.header("Host", "member.aliyundrive.com")
                .header("Accept", "application/json, text/plain, */*")
                .header("Authorization", token)
                .body("{}");
        String body = post.execute().body();
        return body;
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
