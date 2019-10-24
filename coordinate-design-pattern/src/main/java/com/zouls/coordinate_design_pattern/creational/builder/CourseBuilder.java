package com.zouls.coordinate_design_pattern.creational.builder;

/**
 * 抽象的
 */
public abstract class CourseBuilder {

    /**
     * 建造课程的各个元素
     */
    public abstract void buildCourseName(String courseName);
    public abstract void buildCoursePPT(String coursePPT);
    public abstract void buildCourseVideo(String courseVideo);
    public abstract void buildCourseArticle(String courseArticle);
    public abstract void buildCourseQA(String courseQA);

    /**
     * 建造完元素之后再构建课程对象
     */
    public abstract Course makeCourse();

}
