package com.zoulshell.algorithm;
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
//
//
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针
public class _88_合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 三个指针
        // nums1的最后一个元素索引,遍历nums1的有元素的部分的指针
        int i1 = m - 1;
        // nums2的最后一个元素的索引,遍历nums2的指针
        int i2 = n - 1;
        // nums1的最后一位,用于存放比较后的元素的指针
        int cur = nums1.length - 1;

        // nums2的指针i2没有走完的时候继续,i2走完,说明nums2全部处理完了,都插入到了nums1里面去了,直接结束
        while (i2 >= 0) {
            // 判断nums1是否走完
            if (i1 >= 0 && nums1[i1] > nums2[i2]) {
                nums1[cur--] = nums1[i1--];
            } else {// i1<0->nums1全部走完 或者 nums1[i1]<=nums2[i2]
                nums1[cur--] = nums2[i2--];
            }
        }
    }
}
