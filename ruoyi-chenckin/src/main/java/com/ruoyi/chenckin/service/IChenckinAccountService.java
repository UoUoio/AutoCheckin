package com.ruoyi.chenckin.service;

import java.util.List;

import com.ruoyi.chenckin.domain.ChenckinAccount;

/**
 * 签到列表Service接口
 *
 * @author ruoyi
 * @date 2023-02-09
 */
public interface IChenckinAccountService {
    /**
     * 查询签到列表
     *
     * @param id 签到列表主键
     * @return 签到列表
     */
    public ChenckinAccount selectChenckinAccountById(Long id);

    /**
     * 查询签到列表列表
     *
     * @param chenckinAccount 签到列表
     * @return 签到列表集合
     */
    public List<ChenckinAccount> selectChenckinAccountList(ChenckinAccount chenckinAccount);

    /**
     * 新增签到列表
     *
     * @param chenckinAccount 签到列表
     * @return 结果
     */
    public int insertChenckinAccount(ChenckinAccount chenckinAccount);

    /**
     * 修改签到列表
     *
     * @param chenckinAccount 签到列表
     * @return 结果
     */
    public int updateChenckinAccount(ChenckinAccount chenckinAccount);

    /**
     * 批量删除签到列表
     *
     * @param ids 需要删除的签到列表主键集合
     * @return 结果
     */
    public int deleteChenckinAccountByIds(Long[] ids);

    /**
     * 删除签到列表信息
     *
     * @param id 签到列表主键
     * @return 结果
     */
    public int deleteChenckinAccountById(Long id);

    /**
     * 批量签到
     */
    public int chenckinAll();

    /**
     * 执行某个任务
     */
    int handleRun(Long id);
}
