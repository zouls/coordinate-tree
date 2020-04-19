package com.zoulshell.algorithm.算法题.栈_队列;

//给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
//
//
// 二叉树的根是数组中的最大元素。
// 左子树是通过数组中最大值左边部分构造出的最大二叉树。
// 右子树是通过数组中最大值右边部分构造出的最大二叉树。
//
//
// 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
//
//
//
// 示例 ：
//
// 输入：[3,2,1,6,0,5]
//输出：返回下面这棵树的根节点：
//
//      6
//    /   \
//   3     5
//    \    /
//     2  0
//       \
//        1
//
//
//
//
// 提示：
//
//
// 给定的数组的大小在 [1, 1000] 之间。
//
// Related Topics 树
public class _654_最大二叉树 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return getRoot(nums, 0, nums.length);
    }

    private TreeNode getRoot(int[] nums, int left, int right) {

        // 思路:拆解成三个部分
        // 1.找到最大值作为root
        // 2.设置左边部分
        // 3.设置右边部分

        // 左边和右边的数组还是用1的方法,直接递归调用


        // 递归结束条件
        if (left == right) return null;

        int maxIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = getRoot(nums, left, maxIndex);
        root.right = getRoot(nums, maxIndex + 1, right);
        return root;
    }


    /**
     * 返回一个数组,这个数组中放着每个节点的父节点的索引
     */
}
