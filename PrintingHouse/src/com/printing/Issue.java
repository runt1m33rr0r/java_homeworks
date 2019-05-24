package com.printing;

import java.io.Serializable;

public class Issue implements Serializable {
    private String title;
    private int pagesCount;
    private PageSize pageSize;

    public Issue(String title, int pagesCount, PageSize pageSize) {
        this.title = title;
        this.pagesCount = pagesCount;
        this.pageSize = pageSize;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPagesCount() {
        return this.pagesCount;
    }

    public PageSize getPageSize() {
        return this.pageSize;
    }

    @Override
    public String toString() {
        return this.getTitle() + ", " + this.getPagesCount() + " pages long with " + this.getPageSize() +
                " size.";
    }
}
