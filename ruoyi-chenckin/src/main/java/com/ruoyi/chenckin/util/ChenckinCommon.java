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

    public static void main(String[] args) {
        stayAliYun();
    }

    /**
     * 单个签到任务执行
     */
    public static String stayAliYun() {

        // 9e15fb2e31ee45dcb6cc159050e3b73b

        HttpRequest post = HttpRequest.post("https://auth.aliyundrive.com/v2/account/token");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("grant_type", "refresh_token");
        jsonObject.put("app_id", "pJZInNHN2dZWk8qg");
        jsonObject.put("refresh_token", "9e15fb2e31ee45dcb6cc159050e3b73b");


        post.body(jsonObject.toJSONString());
        String body = post.execute().body();
        return body;
    }

    public static ChenckinAccount chenckin(ChenckinAccount account) {
        // 阿里云签到
        if (account.getTypes() == 1) {
            // 返回数组中第一个值为下一次要刷新Token用的值,第二个值为签到执行的结果
            String[] resultArray = ChenckinUtils.checkInAliYunDriver(account.getToken());

            JSONObject result = JSONObject.parseObject(resultArray[1]);
            Boolean success = result.getBoolean("success");
            account.setLastStatus(success == null ? 2 : success ? 1 : 2);
            account.setToken(resultArray[0]);
            account.setLastResult(resultArray[1]);
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
