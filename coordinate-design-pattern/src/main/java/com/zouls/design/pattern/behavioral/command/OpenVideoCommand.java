package com.zouls.design.pattern.behavioral.command;

public class OpenVideoCommand implements Command {
    private CourseVideo courseVideo;

    public OpenVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }
    @Override
    public void execute() {
        // 前后都可以加逻辑
        courseVideo.open();
    }
}
