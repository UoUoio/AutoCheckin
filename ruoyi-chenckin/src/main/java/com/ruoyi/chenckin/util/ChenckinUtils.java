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
public class ChenckinUtils {


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
     * 批量签到任务执行
     *
     * @param list
     */
    public static void chenckinAll(List<ChenckinAccount> list) {
        list.forEach(account -> {
            chenckin(account);
        });
    }

    /**
     * 单个签到任务执行
     *
     * @param account
     */
    public static void chenckin(ChenckinAccount account) {
        // 阿里云签到
        if (account.getTypes() == 1) {
            String resultStr = checkInAliYunDriver(account.getToken());
            JSONObject result = JSONObject.parseObject(resultStr);
            Boolean success = result.getBoolean("success");
            account.setLastStatus(success == null ? 2 : success ? 1 : 2);
            account.setLastResult(result.toJSONString());
            return;
        }

        // BMW 签到
        if (account.getTypes() == 2) {
            String resultStr = checkInMyBMW(account.getToken());
            account.setLastStatus(resultStr.contains("GIF") ? 1 : 2);
            account.setLastResult(resultStr);
            return;
        }

    }


}
