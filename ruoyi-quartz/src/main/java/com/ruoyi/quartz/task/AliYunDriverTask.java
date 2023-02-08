package com.ruoyi.quartz.task;

import com.ruoyi.chenckin.service.IChenckinAliyundriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author:
 * @Date: 2023-02-08 21:38
 * @Description: < 描述 >
 */
@Component("aliYunDriverTask")
public class AliYunDriverTask {

    @Autowired
    private IChenckinAliyundriveService chenckinAliyundriveService;

    /**
     * 签到
     */
    public void checkIn() {
        chenckinAliyundriveService.checkIn();
    }

}
