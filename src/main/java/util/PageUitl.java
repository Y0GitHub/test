package util;

import java.util.List;

/**
 * @Author: ky
 * @Date: 2018/10/6 22:05
 */
public class PageUitl {
    private int page;
    private int size;
    private int count=-1;
    private List<?> list;

    public PageUitl(int page, int size) {
        this.page = page;
        this.size = size;

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
