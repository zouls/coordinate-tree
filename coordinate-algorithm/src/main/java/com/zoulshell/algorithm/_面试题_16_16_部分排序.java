package com.zoulshell.algorithm;

//给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短
//序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
// 示例：
// 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
//输出： [3,9]
//
// 提示：
//
// 0 <= len(array) <= 1000000
//
// Related Topics 排序 数组
public class _面试题_16_16_部分排序 {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] ints = new _面试题_16_16_部分排序().subSort(array);
        for (int i : ints) {
            System.out.print(i+",");
        }
    }

    public int[] subSort(int[] array) {
        if (array.length == 0) return new int[]{-1, -1};
        // 确定逆序对

        // 分两个逻辑
        // 1.从左到右确定最后一个小的逆序对
        // 2.从右到左确定最后一个大的逆序对

        // 怎么确定逆序对
        // 确定小逆序对:遍历过程中保存最大值,同时拿每个值与最大值比较,
        // 如果小于最大值就记录该元素的索引位置,
        // 反之则更新最大值,
        // 相等时不做记录索引位置的操作,因为没有必要对相等的元素进行排序


        int max = array[0];
        int minIndex = -1;

        int min = array[array.length - 1];
        int maxIndex = -1;
        for (int i = 1, j = array.length - 2; i < array.length; i++, j--) {
            if (max > array[i]) {
                minIndex = i;
            } else {
                max = array[i];
            }
            if (min < array[j]) {
                maxIndex = j;
            } else {
                min = array[j];
            }
        }
        return new int[]{maxIndex, minIndex};

    }
}
