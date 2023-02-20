package com.ruoyi.chenckin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * tg消息发送日志对象 t_tg_msg_log
 *
 * @author ruoyi
 * @date 2023-02-18
 */
public class TGMsgLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    private Long id;

    /** 发送状态1正常,2失败 */
    @Excel(name = "发送状态1正常,2失败")
    private Integer statu;

    /** 消息接收人 */
    @Excel(name = "消息接收人")
    private String chatId;

    /** 消息内容 */
    @Excel(name = "消息内容")
    private String content;

    /** 返回消息内容 */
    @Excel(name = "返回消息内容")
    private String resultContent;

    /** 类型-1.每天60秒新闻,2. */
    @Excel(name = "类型-1.每天60秒新闻,2.")
    private Integer types;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public Integer getTypes() {
        return types;
    }

    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("statu", getStatu())
                .append("chatId", getChatId())
                .append("content", getContent())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("types", getTypes())
                .toString();
    }
}
