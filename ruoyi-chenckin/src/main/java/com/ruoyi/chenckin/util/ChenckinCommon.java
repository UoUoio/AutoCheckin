package com.ruoyi.chenckin.util;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.chenckin.domain.ChenckinAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author:
 * @Date: 2023-02-09 16:45
 * @Description: < 描述 >
 */
public class ChenckinCommon {
    private static final Logger log = LoggerFactory.getLogger(ChenckinCommon.class);

    /**
     * 批量签到任务执行
     *
     * @param list
     */
    public static void chenckinAll(List<ChenckinAccount> list) {
        list.forEach(account -> {
            try {
                chenckin(account);
            } catch (Exception e) {
                log.error(e.toString());
            }
        });
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
