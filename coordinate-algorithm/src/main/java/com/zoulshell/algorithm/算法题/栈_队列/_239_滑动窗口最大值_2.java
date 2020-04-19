package com.zoulshell.algorithm.算法题.栈_队列;

import java.util.Deque;
import java.util.LinkedList;

//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//
// 返回滑动窗口中的最大值。
//
//
//
// 进阶：
//
// 你能在线性时间复杂度内解决此题吗？
//
//
//
// 示例:
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 1 <= k <= nums.length
//
// Related Topics 堆 Sliding Window
public class _239_滑动窗口最大值_2 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (k == 1) return nums;

        int[] maxes = new int[nums.length - k + 1];

        // 当前滑动窗口的最大值对应的索引
        int maxIndex = 0;

        // 求出前k个元素的最大索引
        for (int i = 1; i < k; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }

        // 窗口最左索引
        for (int left = 0; left < maxes.length; left++) {
            int right = left + k - 1;// 窗口最右索引
            if (maxIndex < left) {// 判断最大索引是否超出窗口的有效范围,如果超出的话就要将窗口中的元素进行遍历比较得到最大索引
                maxIndex = left;
                for (int i = left + 1; i <= right; i++) {
                    if (nums[i] > nums[maxIndex]) maxIndex = i;
                }
            } else if (nums[right] > nums[maxIndex]) {// 如果没超过窗口范围就直接用之前的最大值跟这次窗口滑动新加入的元素比较
                maxIndex = right;
            }
            maxes[left] = nums[maxIndex];
        }

        return maxes;

    }
}
