package com.zouls.design.pattern.behavioral.command;

public class Test {
    public static void main(String[] args) {
        CourseVideo courseVideo = new CourseVideo("test Course");
        OpenVideoCommand openVideoCommand = new OpenVideoCommand(courseVideo);
        CloseVideoCommand closeVideoCommand = new CloseVideoCommand(courseVideo);
        Staff staff = new Staff();
        staff.addCommand(openVideoCommand);
        staff.addCommand(closeVideoCommand);
        staff.executeCommands();
    }
}
