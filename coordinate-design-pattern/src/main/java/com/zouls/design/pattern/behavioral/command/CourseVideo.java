package com.zouls.design.pattern.behavioral.command;

import sun.awt.windows.ThemeReader;

public class CourseVideo {
    private String name;

    public CourseVideo(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println(this.name+"视频开放");
    }

    public void close() {
        System.out.println(this.name+"视频关闭");
    }
}
