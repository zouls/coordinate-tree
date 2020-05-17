package com.zouls.design.pattern.behavioral.command;

public class CloseVideoCommand implements Command {

    private CourseVideo courseVideo;

    public CloseVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execute() {
        courseVideo.close();
    }
}
