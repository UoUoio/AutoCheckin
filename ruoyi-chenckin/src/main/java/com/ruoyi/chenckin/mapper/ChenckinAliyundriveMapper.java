package com.ruoyi.chenckin.mapper;

import java.util.List;

import com.ruoyi.chenckin.domain.ChenckinAliyundrive;

/**
 * 阿里云盘Mapper接口
 *
 * @author ruoyi
 * @date 2023-02-08
 */
public interface ChenckinAliyundriveMapper {
    /**
     * 查询阿里云盘
     *
     * @param id 阿里云盘主键
     * @return 阿里云盘
     */
    public ChenckinAliyundrive selectChenckinAliyundriveById(Long id);

    /**
     * 查询阿里云盘列表
     *
     * @param chenckinAliyundrive 阿里云盘
     * @return 阿里云盘集合
     */
    public List<ChenckinAliyundrive> selectChenckinAliyundriveList(ChenckinAliyundrive chenckinAliyundrive);
    /**
     * 查询阿里云盘列表
     *
     * @return 阿里云盘集合
     */
    public List<ChenckinAliyundrive> list();

    /**
     * 新增阿里云盘
     *
     * @param chenckinAliyundrive 阿里云盘
     * @return 结果
     */
    public int insertChenckinAliyundrive(ChenckinAliyundrive chenckinAliyundrive);

    /**
     * 修改阿里云盘
     *
     * @param chenckinAliyundrive 阿里云盘
     * @return 结果
     */
    public int updateChenckinAliyundrive(ChenckinAliyundrive chenckinAliyundrive);

    /**
     * 删除阿里云盘
     *
     * @param id 阿里云盘主键
     * @return 结果
     */
    public int deleteChenckinAliyundriveById(Long id);

    /**
     * 批量删除阿里云盘
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChenckinAliyundriveByIds(Long[] ids);
}
