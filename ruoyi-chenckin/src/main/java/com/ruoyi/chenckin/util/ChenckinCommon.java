package com.ruoyi.chenckin.util;

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
     * @param account
     */
    public static void chenckin(ChenckinAccount account) {
        // 阿里云签到
        if (account.getTypes() == 1) {
            String resultStr = ChenckinUtils.checkInAliYunDriver(account.getToken());
            JSONObject result = JSONObject.parseObject(resultStr);
            Boolean success = result.getBoolean("success");
            account.setLastStatus(success == null ? 2 : success ? 1 : 2);
            account.setLastResult(resultStr);
            return;
        }

        // BMW 签到
        if (account.getTypes() == 2) {
            String resultStr = ChenckinUtils.checkInMyBMW(account.getToken());
            account.setLastStatus(resultStr.contains("GIF") ? 1 : 2);
            account.setLastResult(resultStr);
            return;
        }
        // 万词王
        if (account.getTypes() == 3) {
            String resultStr = ChenckinUtils.checkInWanCiWang(account.getToken());
            JSONObject result = JSONObject.parseObject(resultStr);
            Integer code = result.getInteger("code");
            account.setLastStatus(code == 200 ? 1 : 2);
            account.setLastResult(resultStr);
            return;
        }

        // CSDN
        if (account.getTypes() == 4) {
            String resultStr = ChenckinUtils.checkInCSDN(account.getToken());
            JSONObject result = JSONObject.parseObject(resultStr);
            Integer code = result.getInteger("code");
            account.setLastStatus(code == 200 ? 1 : 2);
            account.setLastResult(resultStr);
            return;
        }

    }

}
