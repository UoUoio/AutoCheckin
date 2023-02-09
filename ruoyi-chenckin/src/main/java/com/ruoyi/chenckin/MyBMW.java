package com.ruoyi.chenckin;

import cn.hutool.http.HttpRequest;

/**
 * @author:
 * @Date","2023-02-08 13:13
 * @Description","< 描述 >
 */
public class MyBMW {

    public static void main(String[] args) {

        HttpRequest post = HttpRequest.post("https://miniapp-api.csdn.net/points/api/task/activity/signin/addSignin");


        post.header("Host", "miniapp-api.csdn.net")
                .header("loginUserName", "weixin_42059737")
                .header("X-Access-Token", "48ac213600202abc8487a9d6ff6e4ea7")
                .header("deviceId", "16693719044407671310")
                .header("X-Ca-Nonce", "5595957e-726e-4512-8f1e-b7b2f11e33ec")
                .header("device_id", "16693719044407671310")
                .header("X-Ca-Key", "203816229")
                .header("X-Ca-Signature-Headers", "x-ca-key,x-ca-nonce")
                .header("X-Device-ID", "16693719044407671310")
                .header("X-Ca-Signed-Content-Type", "application/json;charset=UTF-8")
                .header("Accept", "*/*")
                .header("X-Ca-Signature", "Odq77/oaC3NzgwLLrRbmez8H4IN/r/fC3QhTpqpefpM=")
                .header("Cookie", "UserName=weixin_42059737; UserToken=cc5695046bbb4105a7bc5305ecd7b6e1")

                .body("{\"activityId\":1005,\"pageNum\":2,\"pageSize\":4,\"queryType\":\"noCash\"}");

        String body = post.execute().body();
        System.out.println(body);
    }


}
