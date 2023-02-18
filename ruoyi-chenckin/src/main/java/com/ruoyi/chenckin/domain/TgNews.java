package com.ruoyi.chenckin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * TG每日新闻对象 t_tg_news
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
public class TgNews extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 新闻内容 */
    @Excel(name = "新闻内容")
    private String content;

    /** 发送状态 */
    @Excel(name = "发送状态")
    private Integer statu;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setStatu(Integer statu) 
    {
        this.statu = statu;
    }

    public Integer getStatu() 
    {
        return statu;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("content", getContent())
            .append("statu", getStatu())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
