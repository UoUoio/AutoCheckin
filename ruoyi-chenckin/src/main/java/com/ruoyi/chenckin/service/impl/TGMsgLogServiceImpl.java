package com.ruoyi.chenckin.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chenckin.mapper.TGMsgLogMapper;
import com.ruoyi.chenckin.domain.TGMsgLog;
import com.ruoyi.chenckin.service.ITGMsgLogService;

/**
 * tg消息发送日志Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
@Service
public class TGMsgLogServiceImpl implements ITGMsgLogService 
{
    @Autowired
    private TGMsgLogMapper tGMsgLogMapper;

    /**
     * 查询tg消息发送日志
     * 
     * @param id tg消息发送日志主键
     * @return tg消息发送日志
     */
    @Override
    public TGMsgLog selectTGMsgLogById(Long id)
    {
        return tGMsgLogMapper.selectTGMsgLogById(id);
    }

    /**
     * 查询tg消息发送日志列表
     * 
     * @param tGMsgLog tg消息发送日志
     * @return tg消息发送日志
     */
    @Override
    public List<TGMsgLog> selectTGMsgLogList(TGMsgLog tGMsgLog)
    {
        return tGMsgLogMapper.selectTGMsgLogList(tGMsgLog);
    }

    /**
     * 新增tg消息发送日志
     * 
     * @param tGMsgLog tg消息发送日志
     * @return 结果
     */
    @Override
    public int insertTGMsgLog(TGMsgLog tGMsgLog)
    {
        tGMsgLog.setCreateTime(DateUtils.getNowDate());
        return tGMsgLogMapper.insertTGMsgLog(tGMsgLog);
    }

    /**
     * 修改tg消息发送日志
     * 
     * @param tGMsgLog tg消息发送日志
     * @return 结果
     */
    @Override
    public int updateTGMsgLog(TGMsgLog tGMsgLog)
    {
        tGMsgLog.setUpdateTime(DateUtils.getNowDate());
        return tGMsgLogMapper.updateTGMsgLog(tGMsgLog);
    }

    /**
     * 批量删除tg消息发送日志
     * 
     * @param ids 需要删除的tg消息发送日志主键
     * @return 结果
     */
    @Override
    public int deleteTGMsgLogByIds(Long[] ids)
    {
        return tGMsgLogMapper.deleteTGMsgLogByIds(ids);
    }

    /**
     * 删除tg消息发送日志信息
     * 
     * @param id tg消息发送日志主键
     * @return 结果
     */
    @Override
    public int deleteTGMsgLogById(Long id)
    {
        return tGMsgLogMapper.deleteTGMsgLogById(id);
    }
}
