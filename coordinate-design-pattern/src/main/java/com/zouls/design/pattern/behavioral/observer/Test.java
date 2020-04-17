package com.zouls.design.pattern.behavioral.observer;

public class Test {
    public static void main(String[] args) {
        Course course = new Course("java相关的课程");
        Teacher teacher1 = new Teacher("alpha");
        Teacher teacher2 = new Teacher("beta");
        course.addObserver(teacher1);
        course.addObserver(teacher2);

        Question question = new Question();
        question.setUserName("feng");
        question.setQuestionContent("java 相关问题");

        course.produceQuestion(course, question);
    }
}