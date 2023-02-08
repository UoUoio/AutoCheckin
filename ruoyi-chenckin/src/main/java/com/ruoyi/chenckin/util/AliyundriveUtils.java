package com.ruoyi.chenckin.util;

import cn.hutool.http.HttpRequest;

/**
 * @author:
 * @Date: 2023-02-08 21:32
 * @Description: < 描述 >
 */
public class AliyundriveUtils {


    /**
     * 阿里云签到
     */
    public static String checkIn(String token) {
        // 使用hutool创建post请求,并设置请求头内容
        HttpRequest post = HttpRequest.post("https://member.aliyundrive.com/v1/activity/sign_in_list");
        post.header("Host", "member.aliyundrive.com")
                .header("Accept", "application/json, text/plain, */*")
                .header("Authorization", token)
                .body("{}");
        return post.execute().body();
    }

}
