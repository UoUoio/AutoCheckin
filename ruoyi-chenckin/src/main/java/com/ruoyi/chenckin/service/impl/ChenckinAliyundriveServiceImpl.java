package com.ruoyi.chenckin.service.impl;

import java.util.List;

import com.ruoyi.chenckin.util.AliyundriveUtils;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chenckin.mapper.ChenckinAliyundriveMapper;
import com.ruoyi.chenckin.domain.ChenckinAliyundrive;
import com.ruoyi.chenckin.service.IChenckinAliyundriveService;

/**
 * 阿里云盘Service业务层处理
 *
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class ChenckinAliyundriveServiceImpl implements IChenckinAliyundriveService {
    @Autowired
    private ChenckinAliyundriveMapper chenckinAliyundriveMapper;

    /**
     * 查询阿里云盘
     *
     * @param id 阿里云盘主键
     * @return 阿里云盘
     */
    @Override
    public ChenckinAliyundrive selectChenckinAliyundriveById(Long id) {
        return chenckinAliyundriveMapper.selectChenckinAliyundriveById(id);
    }

    /**
     * 查询阿里云盘列表
     *
     * @param chenckinAliyundrive 阿里云盘
     * @return 阿里云盘
     */
    @Override
    public List<ChenckinAliyundrive> selectChenckinAliyundriveList(ChenckinAliyundrive chenckinAliyundrive) {
        return chenckinAliyundriveMapper.selectChenckinAliyundriveList(chenckinAliyundrive);
    }

    /**
     * 新增阿里云盘
     *
     * @param chenckinAliyundrive 阿里云盘
     * @return 结果
     */
    @Override
    public int insertChenckinAliyundrive(ChenckinAliyundrive chenckinAliyundrive) {
        chenckinAliyundrive.setCreateTime(DateUtils.getNowDate());
        return chenckinAliyundriveMapper.insertChenckinAliyundrive(chenckinAliyundrive);
    }

    /**
     * 修改阿里云盘
     *
     * @param chenckinAliyundrive 阿里云盘
     * @return 结果
     */
    @Override
    public int updateChenckinAliyundrive(ChenckinAliyundrive chenckinAliyundrive) {
        chenckinAliyundrive.setUpdateTime(DateUtils.getNowDate());
        return chenckinAliyundriveMapper.updateChenckinAliyundrive(chenckinAliyundrive);
    }

    /**
     * 批量删除阿里云盘
     *
     * @param ids 需要删除的阿里云盘主键
     * @return 结果
     */
    @Override
    public int deleteChenckinAliyundriveByIds(Long[] ids) {
        return chenckinAliyundriveMapper.deleteChenckinAliyundriveByIds(ids);
    }

    /**
     * 删除阿里云盘信息
     *
     * @param id 阿里云盘主键
     * @return 结果
     */
    @Override
    public int deleteChenckinAliyundriveById(Long id) {
        return chenckinAliyundriveMapper.deleteChenckinAliyundriveById(id);
    }

    /**
     * 签到
     */
    @Override
    public void checkIn() {
        // 获取所有的阿里云盘Token
        chenckinAliyundriveMapper.list().forEach(aliyundrive -> {
            // 签到
            String result = AliyundriveUtils.checkIn(aliyundrive.getToken());
            aliyundrive.setLastResult(result);
            // 更新签到信息
            chenckinAliyundriveMapper.updateChenckinAliyundrive(aliyundrive);
        });


    }

}
