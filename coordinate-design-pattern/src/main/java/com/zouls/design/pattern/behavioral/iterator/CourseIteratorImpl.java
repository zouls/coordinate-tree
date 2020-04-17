package com.zouls.design.pattern.behavioral.iterator;

import java.util.List;

/**
 *
 */
public class CourseIteratorImpl implements CourseIterator {

    /**
     * 要迭代的资源集合
     */
    private List<Course> courseList;
    /**
     * 当前迭代到哪个位置了
     */
    private int position;
    /**
     * 当前迭代出来的资源
     */
    private Course course;

    CourseIteratorImpl(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public Course nextCourse() {
        System.out.println("返回课程,位置是: " + position);
        course = courseList.get(position);
        position++;
        return course;
    }

    @Override
    public boolean isLastCourse() {
        return position >= courseList.size();
    }
}
