package com.ruoyi.chenckin.service.impl;

import com.ruoyi.chenckin.domain.ChenckinAccount;
import com.ruoyi.chenckin.mapper.ChenckinAccountMapper;
import com.ruoyi.chenckin.service.IChenckinAccountService;
import com.ruoyi.chenckin.util.ChenckinCommon;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 签到列表Service业务层处理
 *
 * @author ruoyi
 * @date 2023-02-09
 */
@Service
public class ChenckinAccountServiceImpl implements IChenckinAccountService {
    @Autowired
    private ChenckinAccountMapper chenckinAccountMapper;

    /**
     * 查询签到列表
     *
     * @param id 签到列表主键
     * @return 签到列表
     */
    @Override
    public ChenckinAccount selectChenckinAccountById(Long id) {
        return chenckinAccountMapper.selectChenckinAccountById(id);
    }

    /**
     * 查询签到列表列表
     *
     * @param chenckinAccount 签到列表
     * @return 签到列表
     */
    @Override
    @DataScope(userAlias = "ca")
    public List<ChenckinAccount> selectChenckinAccountList(ChenckinAccount chenckinAccount) {
        return chenckinAccountMapper.selectChenckinAccountList(chenckinAccount);
    }

    /**
     * 查询签到列表列表
     *
     * @return 签到列表集合
     */
    @Override
    public List<ChenckinAccount> list() {
        return chenckinAccountMapper.list();
    }

    /**
     * 新增签到列表
     *
     * @param chenckinAccount 签到列表
     * @return 结果
     */
    @Override
    public int insertChenckinAccount(ChenckinAccount chenckinAccount) {
        chenckinAccount.setUserId(SecurityUtils.getUserId());
        return chenckinAccountMapper.insertChenckinAccount(chenckinAccount);
    }

    /**
     * 修改签到列表
     *
     * @param chenckinAccount 签到列表
     * @return 结果
     */
    @Override
    public int updateChenckinAccount(ChenckinAccount chenckinAccount) {
        chenckinAccount.setUpdateTime(DateUtils.getNowDate());
        return chenckinAccountMapper.updateChenckinAccount(chenckinAccount);
    }

    /**
     * 批量删除签到列表
     *
     * @param ids 需要删除的签到列表主键
     * @return 结果
     */
    @Override
    public int deleteChenckinAccountByIds(Long[] ids) {
        return chenckinAccountMapper.deleteChenckinAccountByIds(ids);
    }

    /**
     * 删除签到列表信息
     *
     * @param id 签到列表主键
     * @return 结果
     */
    @Override
    public int deleteChenckinAccountById(Long id) {
        return chenckinAccountMapper.deleteChenckinAccountById(id);
    }

    /**
     * 批量签到
     */
    @Override
    public int chenckinAll() {
        List<ChenckinAccount> list = chenckinAccountMapper.list();
        ChenckinCommon.chenckinAll(list);
        return chenckinAccountMapper.updateList(list);
    }

    /**
     * 执行某个任务
     *
     * @param id
     */
    @Override
    public int handleRun(Long id) {
        ChenckinAccount chenckinAccount = chenckinAccountMapper.selectChenckinAccountById(id);
        Long accountUserId = chenckinAccount.getUserId();
        if (!accountUserId.equals(SecurityUtils.getUserId())) {
            throw new ServiceException("有校验你执行的任务的,别乱点", HttpStatus.UNAUTHORIZED);
        }
        ChenckinCommon.chenckin(chenckinAccount);
        return chenckinAccountMapper.updateChenckinAccount(chenckinAccount);
    }
}
