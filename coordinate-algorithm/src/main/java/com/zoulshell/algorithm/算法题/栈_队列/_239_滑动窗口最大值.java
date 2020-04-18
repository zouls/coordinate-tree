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
public class _239_滑动窗口最大值 {

    @SuppressWarnings("ConstantConditions")
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (k == 1) return nums;

        int[] maxes = new int[nums.length - k + 1];

        // 双端队列放索引
        // 索引对应的值是从头到尾是从大到小的 单调队列
        Deque<Integer> deque = new LinkedList<>();

        //
        for (int r = 0; r < nums.length; r++) {

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[r]) {
                // 移除队列尾部的值
                deque.pollLast();
            }
            deque.offerLast(r);

            int left = r - k + 1;
            if (left < 0) {
                continue;
            }

            if (deque.peekFirst() < left) {
                deque.pollFirst();
            }

            maxes[left] = nums[deque.peekFirst()];
        }

        return maxes;

    }
}
