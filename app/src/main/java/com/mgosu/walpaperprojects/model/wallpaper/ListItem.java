
package com.mgosu.walpaperprojects.model.wallpaper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ListItem implements Serializable {

    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("thumb_sm")
    @Expose
    private String thumbSm;
    @SerializedName("thumb_large")
    @Expose
    private String thumbLarge;
    @SerializedName("file_url")
    @Expose
    private String fileUrl;
    @SerializedName("love_count")
    @Expose
    private Integer loveCount;
    @SerializedName("download")
    @Expose
    private Integer download;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getThumbSm() {
        return thumbSm;
    }

    public void setThumbSm(String thumbSm) {
        this.thumbSm = thumbSm;
    }

    public String getThumbLarge() {
        return thumbLarge;
    }

    public void setThumbLarge(String thumbLarge) {
        this.thumbLarge = thumbLarge;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getLoveCount() {
        return loveCount;
    }

    public void setLoveCount(Integer loveCount) {
        this.loveCount = loveCount;
    }

    public Integer getDownload() {
        return download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }

}
