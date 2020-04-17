package com.zouls.design.pattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个类提供对list的增加,删除操作
 * 增加和删除仅仅是使用了list原生的方法
 * 同时还提供了获取迭代器的方法
 */
public class CourseAggregateImpl implements CourseAggregate {

    private List<Course> courseList;

    CourseAggregateImpl() {
        this.courseList = new ArrayList<>();
    }

    @Override
    public void addCourse(Course course) {
        courseList.add(course);
    }

    @Override
    public void removeCourse(Course course) {
        courseList.remove(course);
    }

    @Override
    public CourseIterator getCourseIterator() {
        // 创建一个迭代器类 同时把资源list传进去
        return new CourseIteratorImpl(courseList);
    }
}
