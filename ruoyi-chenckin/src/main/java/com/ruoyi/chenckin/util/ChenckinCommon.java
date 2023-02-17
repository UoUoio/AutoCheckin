package com.ruoyi.chenckin.util;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.chenckin.domain.ChenckinAccount;

import java.util.List;

/**
 * @author:
 * @Date: 2023-02-09 16:45
 * @Description: < 描述 >
 */
public class ChenckinCommon {

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
     */
    public static String stayAliYun() {
        HttpRequest post = HttpRequest.post("https://api.aliyundrive.com/users/v1/users/device/create_session");
        post

                .header("content-type", "application/json; charset=UTF-8")
                .header("authorization", "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI4NDM2MTFmZDFjODA0Y2UyOWUyZTdkNTllNTVhNDAxMCIsImN1c3RvbUpzb24iOiJ7XCJjbGllbnRJZFwiOlwicEpaSW5OSE4yZFpXazhxZ1wiLFwiZG9tYWluSWRcIjpcImJqMjlcIixcInNjb3BlXCI6W1wiRFJJVkUuQUxMXCIsXCJGSUxFLkFMTFwiLFwiVklFVy5BTExcIixcIlNIQVJFLkFMTFwiLFwiU1RPUkFHRS5BTExcIixcIlNUT1JBR0VGSUxFLkxJU1RcIixcIlVTRVIuQUxMXCIsXCJCQVRDSFwiLFwiQUNDT1VOVC5BTExcIixcIklNQUdFLkFMTFwiLFwiSU5WSVRFLkFMTFwiLFwiU1lOQ01BUFBJTkcuTElTVFwiXSxcInJvbGVcIjpcInVzZXJcIixcInJlZlwiOlwiXCIsXCJkZXZpY2VfaWRcIjpcIjdkNGFiOTFlMDdjOTQ3MzE4ZDM3OGE4Njg2ZTRmMzc0XCJ9IiwiZXhwIjoxNjc2NjUwNTMxLCJpYXQiOjE2NzY2NDMyNzF9.XWxj8pbNok9PrzlcJLyaOZQKmUWh7MvOn9-e15Mn5eSFfuxSGUgqbjIkyrTs7x_Enkqr14brpQbe183YaOznKOKhUa-GvGuRCR5_MXG-WSLOBqbFQeU7oxpIdfn6S_i8Rw5aWW4lyai4V5XFFkV5agAxzOm4MHYwkg1m2e7XszE")
                .header("accept", "*/*")
                .header("x-signature", "3f6beacef82c23d56540989a3499941ff42f466f8c5e782432fbfe583f335708062f0a4750ef5025edb043ebe8c687f73b938bdd48a2f2bdae8e3a66b42c05db00")
                .header("x-umt", "p/oBacZLPPGzkBKGX+T9tO4buv5s7gwy")
                .header("x-sign", "izK9q4002xAAJgIkJgphr9o+m0HCtgImDjqfYCjvx2a4WaIwnkKx6RkfAw5n2E39TMe5ieTo4uUhZMZKUh9GYdAR0IYCNgImAjYCJg")
                .header("x-canary", "client=iOS,app=adrive,version=v4.1.1")
                .header("x-sgext", "JAcUPKOZPnMVTb0Ilbs+pDwhDCUfLQgnCTcFNx8lCiMKIggnDywNNwwkDCQMJAwkDCQMJAwkDCQfJB8kHyQMNwwkDCQfJB8kHyQfJB8kHyQfJB8kHyQMJAwk")
                .header("accept-language", "zh-CN,zh-Hans;q=0.9")
                .header("accept-encoding", "gzip, deflate, br")
                .header("x-mini-wua", "icgRF2/GxqBRntJVkDtwSFwL8O/8PjHILV05bSvTVC5/QDAVYfDddr+AhBSEx2kZz9Idg/CxTSwEriFb1F2fUAVSh2s1bIELnMsIqoGRQBBIIRLFrEQTjElMZkI3T241yvYq40tocQ8jG1j6JLZXTpApv0cW69qo6CtbJYUyohsAqtA==")
                .header("content-length", "318")
                .header("user-agent", "AliApp(AYSD/4.1.1) com.alicloud.smartdrive/4.1.1 Version/16.3 Channel/201200 Language/zh-Hans-US /iOS Mobile/iPhone14,3")
                .header("x-device-id", "063ccaa52992cc5a93f28adc4d6417785ffd58a51d03c985ca03eaf770225343")
                .header("referer", "https://aliyundrive.com/")
                .header("cookie", "isg=BL-_Qpn34BmRIOQK7cyOVNUERJdJpBNGJHSIM1GMW261YN_iWXSjlj1ipLaeI-u-")
                .header("cookie", "_nk_=t-2209796631244-52")
                .header("cookie", "_tb_token_=d5e0e4de7eb8")
                .header("cookie", "cookie2=175fa1821be8b27db1522747e4b7ab77")
                .header("cookie", "csg=bd8b6a5d")
                .header("cookie", "munb=2209796631244")
                .header("cookie", "t=8d55fe29b73f18f5b9dc7807ccb83c47")
                .header("cookie", "l=AmlpRYqG-TF4hfpFZQe24FMKeQ7DNl1o")
                .header("cookie", "cna=oILlG+jnJQMCAXpgIaX/Js6H")


                .body("{\"pubKey\":\"0415bddac30fd38b8c1da3a46adfd422278e88b66b7a04eaa05b79a49e843fac924c21d4a01e70fd7dd08f580840a1b4aa039cc8468ef1c9f4f73d1b1e7eb87f69\",\"utdid\":\"YaBn2FDTpF4DAOPOIEO+INzA\",\"umid\":\"p\\/oBacZLPPGzkBKGX+T9tO4buv5s7gwy\",\"deviceName\":\"iPhone\",\"refreshToken\":\"7d4ab91e07c947318d378a8686e4f374\",\"modelName\":\"iPhone14,3\"}");


        String body = post.execute().body();
        return body;
    }

    public static ChenckinAccount chenckin(ChenckinAccount account) {
        // 阿里云签到
        if (account.getTypes() == 1) {
            String resultStr = ChenckinUtils.checkInAliYunDriver(account.getToken());
            JSONObject result = JSONObject.parseObject(resultStr);
            Boolean success = result.getBoolean("success");
            account.setLastStatus(success == null ? 2 : success ? 1 : 2);
            account.setLastResult(resultStr);
            return account;
        }

        // BMW 签到
        if (account.getTypes() == 2) {
            String resultStr = ChenckinUtils.checkInMyBMW(account.getToken());
            account.setLastStatus(resultStr.contains("GIF") ? 1 : 2);
            account.setLastResult(resultStr);
            return account;
        }
        // 万词王
        if (account.getTypes() == 3) {
            String resultStr = ChenckinUtils.checkInWanCiWang(account.getToken());
            JSONObject result = JSONObject.parseObject(resultStr);
            Integer code = result.getInteger("code");
            account.setLastStatus(code == 0 ? 1 : 2);
            account.setLastResult(resultStr);
            return account;
        }

        // CSDN
        if (account.getTypes() == 4) {
            String resultStr = ChenckinUtils.checkInCSDN(account.getToken());
            JSONObject result = JSONObject.parseObject(resultStr);
            Integer code = result.getInteger("code");
            account.setLastStatus(code == 200 ? 1 : 2);
            account.setLastResult(resultStr);
            return account;
        }
        return null;
    }

}
