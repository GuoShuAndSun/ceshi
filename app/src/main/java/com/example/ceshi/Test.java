package com.example.ceshi;

public class Test {

    public Test(String 标题, String 标题链接, String 图片, String 时间, String 查看, String 价格) {
        this.标题 = 标题;
        this.标题链接 = 标题链接;
        this.图片 = 图片;
        this.时间 = 时间;
        this.查看 = 查看;
        this.价格 = 价格;
    }

    private String 标题;

    private String 标题链接;

    private String 图片;

    private String 时间;

    private String 查看;

    private String 价格;

    public void set标题(String 标题) {
        this.标题 = 标题;
    }

    public String get标题() {
        return this.标题;
    }

    public void set标题链接(String 标题链接) {
        this.标题链接 = 标题链接;
    }

    public String get标题链接() {
        return this.标题链接;
    }

    public void set图片(String 图片) {
        this.图片 = 图片;
    }

    public String get图片() {
        return this.图片;
    }

    public void set时间(String 时间) {
        this.时间 = 时间;
    }

    public String get时间() {
        return this.时间;
    }

    public void set查看(String 查看) {
        this.查看 = 查看;
    }

    public String get查看() {
        return this.查看;
    }

    public void set价格(String 价格) {
        this.价格 = 价格;
    }

    public String get价格() {
        return this.价格;
    }

    @Override
    public String toString() {
        return "Test{" +
                "标题='" + 标题 + '\'' +
                ", 标题链接='" + 标题链接 + '\'' +
                ", 图片='" + 图片 + '\'' +
                ", 时间='" + 时间 + '\'' +
                ", 查看='" + 查看 + '\'' +
                ", 价格='" + 价格 + '\'' +
                '}';
    }


}
