package com.nb.myijklibrary.bean;

/**
 *  * 描 述：使用默认的视频地址对象
 */
public class VideoijkBean {
    /**
     * id
     */
    int id;
    /**
     * 分辨率名称
     */
    String stream;
    /**
     * 分辨率对应视频地址
     */
    String url;
    /**
     * 备注备用
     */
    String remarks;
    /**
     * 当前选中的
     */
    boolean select;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
