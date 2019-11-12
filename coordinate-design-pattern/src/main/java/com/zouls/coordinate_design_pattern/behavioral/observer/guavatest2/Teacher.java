package com.zouls.coordinate_design_pattern.behavioral.observer.guavatest2;

import lombok.AllArgsConstructor;

import java.util.Observable;

/**
 * 观察者
 */
@AllArgsConstructor
public class Teacher {
    private String teacherName;

    public void update(Observable o, Object arg) {
        Course course = (Course) o;
        Question question = (Question) arg;
        System.out.println(teacherName + "老师的" +
                course.getCourseName() + "课程接收到一个"
                + question.getUserName() + "提交的问答: "
                + question.getQuestionContent());

    }
}