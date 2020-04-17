package com.zoulshell.algorithm;

//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
//
//
//
// 示例 1：
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//
//
// 示例 2：
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 10000
// -10000 <= A[i] <= 10000
// A 已按非递减顺序排序。
//
// Related Topics 数组 双指针
public class _977_有序数组的平方 {

    public static void main(String[] args) {
        int[] arr = new int[]{-7, -3, 2, 3, 11};
        int[] ints = new _977_有序数组的平方().sortedSquares(arr);
        for (int i : ints) {
            System.out.print(i + ",");
        }
    }

    public int[] sortedSquares(int[] A) {
        int[] temp = new int[A.length];
        int l = 0;
        int r = A.length - 1, cur = A.length - 1;
        while (A[l] < 0 && A[r] > 0) {
            if (-A[l] < A[r]) {
                temp[cur--] = A[r] * A[r--];
            } else {
                temp[cur--] = A[l] * A[l++];
            }
        }
        while (l <= r && A[l] <= 0) {
            temp[cur--] = A[l] * A[l++];
        }
        while (l <= r && A[r] > 0) {
            temp[cur--] = A[r] * A[r--];
        }
        return temp;
    }

//    private void swap(int head, int tail,int[] A) {
//        A[head]=
//
//    }
}
