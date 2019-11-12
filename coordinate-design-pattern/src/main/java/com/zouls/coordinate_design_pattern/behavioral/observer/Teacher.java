package com.zouls.coordinate_design_pattern.behavioral.observer;

import lombok.AllArgsConstructor;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 */
@AllArgsConstructor
public class Teacher implements Observer {
    private String teacherName;

    /**
     * 目前这个方法是同步的,并发量大的话应该是要改成异步的
     * 如果这里的并发量比较大的话,建议是放到消息队列中进行处理
     *
     * @param o 被观察的对象
     * @param arg 传递的参数
     */
    @Override
    public void update(Observable o, Object arg) {
        Course course = (Course) o;
        Question question = (Question) arg;
        System.out.println(teacherName + "老师的" +
                course.getCourseName() + "课程接收到一个"
                + question.getUserName() + "提交的问答: "
                + question.getQuestionContent());

    }
}