package com.zouls.coordinate_design_pattern.behavioral.observer.guavatest2;

import com.google.common.eventbus.Subscribe;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 被观察对象
 * 继承了Observable之后就可以被观察
 */
@Data
@AllArgsConstructor
public class Course {
    private String courseName;

    @Subscribe
    public void produceQuestion(Course course, Question question) {
        System.out.println(question.getUserName() + "在" + course.getCourseName() + "提交了一个问题");
    }
}
