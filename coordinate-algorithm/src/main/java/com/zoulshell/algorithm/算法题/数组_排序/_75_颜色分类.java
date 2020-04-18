package com.zoulshell.algorithm.算法题.数组_排序;

//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
// 注意:
//不能使用代码库中的排序函数来解决这道题。
//
// 示例:
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2]
//
// 进阶：
//
//
// 一个直观的解决方案是使用计数排序的两趟扫描算法。
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
// 你能想出一个仅使用常数空间的一趟扫描算法吗？
//
// Related Topics 排序 数组 双指针
public class _75_颜色分类 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 1};
        new _75_颜色分类().sortColors(arr);
        for (int a : arr) {
            System.out.print(a + ",");
        }
    }

    public void sortColors(int[] nums) {

        // 三个指针
        // 1.头指针 2.尾指针 3.迭代指针
        int head = 0;
        int tail = nums.length - 1;
        int cur = 0;

        // 三种情况
        // 1.nums[cur]=1 cur++
        // 2.nums[cur]=0 交换cur和head的值 cur++ head++
        // 3.nums[cur]=2 交换cur和tail的值 tail-- 再次判断cur的值
        // 不停的重复以上三个步骤,直到cur>tail
        // cur==tail的时候还要继续循环,有一种情况就是tail处是0,然后跟cur交换了之后,cur变成了0,此时cur==tail,
        // 但是cur==0,所以还要跟head继续交换才行,所以cur==tail的时候药要继续进行操作

        while (cur <= tail) {
            if (nums[cur] == 1) {
                cur++;
            } else if (nums[cur] == 0) {
                swap(cur++, head++, nums);
            } else {
                swap(cur, tail--, nums);
            }
        }

    }

    private void swap(int cur, int head, int[] nums) {
        int temp = nums[cur];
        nums[cur] = nums[head];
        nums[head] = temp;
    }


}
