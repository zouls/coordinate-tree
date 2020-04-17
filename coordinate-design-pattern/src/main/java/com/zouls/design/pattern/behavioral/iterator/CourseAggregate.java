package com.zouls.design.pattern.behavioral.iterator;

public interface CourseAggregate {

    /**
     * 增加课程
     */
    void addCourse(Course course);

    /**
     * 删除课程
     */
    void removeCourse(Course course);

    /**
     * 获取迭代器
     */
    CourseIterator getCourseIterator();
}
