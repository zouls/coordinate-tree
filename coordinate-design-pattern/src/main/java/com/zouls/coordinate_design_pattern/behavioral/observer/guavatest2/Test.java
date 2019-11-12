package com.zouls.coordinate_design_pattern.behavioral.observer.guavatest2;

import com.google.common.eventbus.EventBus;

public class Test {
    public static void main(String[] args) {
        Course course = new Course("java相关的课程");
        Teacher teacher1 = new Teacher("alpha");

        Question question = new Question();
        question.setUserName("feng");
        question.setQuestionContent("java 相关问题");

        course.produceQuestion(course, question);



        EventBus eventBus = new EventBus();
        Teacher guavaEvent = new Teacher("aaa");
        eventBus.register(guavaEvent);
        eventBus.post("post的内容");
    }
}