package com.zouls.coordinate_design_pattern.behavioral.chainofresponsibility;

public class Test {
    public static void main(String[] args) {
        // 两个审核员 一个审核手记 一个审核视频
        Approver articleApprover = new ArticleApprover();
        Approver videoApprover = new VideoApprover();

        Course course = new Course();
        course.setName("课程1");
        course.setArticle("课程1文章");
//        course.setVideo("课程1视频");

        // 文章不通过就没有必要审核视频了,审核完文章之后再审核视频
        articleApprover.setNextApprover(videoApprover);
        articleApprover.deploy(course);
    }
}