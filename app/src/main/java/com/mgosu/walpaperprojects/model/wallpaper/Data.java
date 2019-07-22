
package com.mgosu.walpaperprojects.model.wallpaper;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("sub_url")
    @Expose
    private String subUrl;
    @SerializedName("list_items")
    @Expose
    private List<ListItem> listItems = null;
    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("total_page")
    @Expose
    private Integer totalPage;
    @SerializedName("limit")
    @Expose
    private Integer limit;

    public String getSubUrl() {
        return subUrl;
    }

    public void setSubUrl(String subUrl) {
        this.subUrl = subUrl;
    }

    public List<ListItem> getListItems() {
        return listItems;
    }

    public void setListItems(List<ListItem> listItems) {
        this.listItems = listItems;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}
