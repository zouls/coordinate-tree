package com.zouls.design.pattern.behavioral.iterator;

/**
 * Created by geely.
 */
public interface CourseIterator {
    /**
     * 获取下一个课程
     */
    Course nextCourse();

    /**
     * 判断是否是最后一个课程
     */
    boolean isLastCourse();

}
