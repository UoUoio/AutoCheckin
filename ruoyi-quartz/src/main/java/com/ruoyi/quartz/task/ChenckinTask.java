package com.ruoyi.quartz.task;

import com.ruoyi.chenckin.service.IChenckinAccountService;
import com.ruoyi.chenckin.util.ChenckinCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author:
 * @Date: 2023-02-08 21:38
 * @Description: < 描述 >
 */
@Component("chenckinTask")
public class ChenckinTask {

    @Autowired
    private IChenckinAccountService chenckinAccountService;

    /**
     * 签到
     */
    public void checkIn() {
        chenckinAccountService.chenckinAll();
    }
}
