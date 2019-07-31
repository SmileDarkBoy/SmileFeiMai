package cn.superbio.spbbase.core.pagination;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "分页列表查询条件")
public class PageQuery {
    @ApiModelProperty(value = "当前页码", example = "1")
    private Integer currentPage;
    @ApiModelProperty(value = "每页数量", example = "15")
    private Integer pageSize;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
