package com.jundagui.web.vo;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class PageVo<T> {

    /**
     * Long totalCount : 总记录数
     */
    private Integer total;
    /**
     * Integer pageNo : 页码
     */
    private Integer pageNo;
    /**
     * Integer pageLimit : 最大页容量
     */
    private Integer pageLimit;

    /**
     * Collection<T> list :当前记录页数据
     */
    private Collection<T> rows = Lists.newArrayList();

    public PageVo(Integer total, Collection<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageVo() {
    }

    @Override
    public String toString() {
        return "PagedResult [total=" + total + ", rows=" + rows + "]";
    }

}
