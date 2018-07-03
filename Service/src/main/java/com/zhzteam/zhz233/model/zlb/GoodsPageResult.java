package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;

public class GoodsPageResult implements Serializable {
    private Integer TotalCount;//总条数
    private Integer TotalPage;//总页数
    private Integer CurrentPage;//当前页
    private Integer PageSize;//每页条数

    public Integer getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(Integer totalCount) {
        TotalCount = totalCount;
    }

    public Integer getTotalPage() {
        return TotalPage;
    }

    public void setTotalPage(Integer totalPage) {
        TotalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return CurrentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        CurrentPage = currentPage;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }
}
