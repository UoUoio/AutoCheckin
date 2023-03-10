package com.ruoyi.chenckin.mapper;

import java.util.List;

import com.ruoyi.chenckin.domain.TGMsgLog;

/**
 * tg消息发送日志Mapper接口
 *
 * @author ruoyi
 * @date 2023-02-18
 */
public interface TGMsgLogMapper {

    /**
     * 查询tg消息发送日志
     *
     * @param id tg消息发送日志主键
     * @return tg消息发送日志
     */
    public TGMsgLog selectTGMsgLogById(Long id);

    /**
     * 查询tg消息发送日志列表
     *
     * @param tGMsgLog tg消息发送日志
     * @return tg消息发送日志集合
     */
    public List<TGMsgLog> selectTGMsgLogList(TGMsgLog tGMsgLog);

    /**
     * 新增tg消息发送日志
     *
     * @param tGMsgLog tg消息发送日志
     * @return 结果
     */
    public int insertTGMsgLog(TGMsgLog tGMsgLog);

    /**
     * 修改tg消息发送日志
     *
     * @param tGMsgLog tg消息发送日志
     * @return 结果
     */
    public int updateTGMsgLog(TGMsgLog tGMsgLog);

    /**
     * 删除tg消息发送日志
     *
     * @param id tg消息发送日志主键
     * @return 结果
     */
    public int deleteTGMsgLogById(Long id);

    /**
     * 批量删除tg消息发送日志
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTGMsgLogByIds(Long[] ids);
}
