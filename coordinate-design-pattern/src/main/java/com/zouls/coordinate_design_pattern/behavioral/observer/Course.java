package com.zouls.coordinate_design_pattern.behavioral.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Observable;

/**
 * 被观察对象
 * 继承了Observable之后就可以被观察
 */
@Data
@AllArgsConstructor
public class Course extends Observable {
    private String courseName;

    public void produceQuestion(Course course, Question question) {
        System.out.println(question.getUserName() + "在" + course.getCourseName() + "提交了一个问题");
        // 标记这个被观察的对象已经改变了,这个方法是同步的,加了锁
        setChanged();

        // 通知所有观察者
        notifyObservers(question);
    }
}
