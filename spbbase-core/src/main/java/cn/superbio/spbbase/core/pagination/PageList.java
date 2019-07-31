package cn.superbio.spbbase.core.pagination;

import java.util.List;

/**
 * 分页列表返回数据
 */
public class PageList<T> {
    /* 查询总的记录数 */
    private int count;
    /* 指定页的数据 */
    private List<T> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
