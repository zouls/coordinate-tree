package com.zoulshell.algorithm.算法题.栈_队列;

import java.util.Stack;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。
//
//
// 示例:
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
// Related Topics 栈 设计

/**
 * 这个思路是用单向链表来实现
 * 每次添加元素就在head处增加一个节点 节点里面包含了当前值和最小值
 */
public class _155_最小栈_2 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack);
    }

    static class MinStack {

        private Node head;

        /** initialize your data structure here. */
        public MinStack() {
            head = new Node(0, Integer.MAX_VALUE, null);
        }

        public void push(int x) {
            // new一个节点,这个新节点的next指向之前的head节点
            // head指向这个新的节点
            head = new Node(x, Math.min(x, head.min), head);
        }

        public void pop() {
            // 将head指向head的next节点
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        static class Node {
            /**
             * 该节点中存储的数值
             */
            int val;
            /**
             * 保存该node对应的最小值
             */
            int min;
            /**
             * 下一个节点的指针
             */
            Node next;

            public Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }

            @Override
            public String toString() {
                return "[" + "val=" + val + ", min=" + min + "]->" + next;
            }
        }

        @Override
        public String toString() {
            return head.toString();
        }
    }
}
