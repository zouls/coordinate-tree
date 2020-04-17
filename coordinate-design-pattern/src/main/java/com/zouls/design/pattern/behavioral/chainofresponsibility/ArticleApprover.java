package com.zouls.design.pattern.behavioral.chainofresponsibility;

import org.apache.commons.lang3.StringUtils;

public class ArticleApprover extends Approver {

    /**
     * 发布课程
     *
     * @param course
     */
    public void deploy(Course course) {
        // 首先课程的文章不能为空
        if (StringUtils.isNotEmpty(course.getArticle())) {
            System.out.println(course.getName() + "含有手记,批准");

            // 查看是否有下一个审批人, 如果有的话继续审批
            if (approver != null) {
                approver.deploy(course);
            }
        } else {
            System.out.println(course.getName() + "不含有手记,不批准");
        }
    }
}