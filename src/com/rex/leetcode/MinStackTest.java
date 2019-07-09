package com.rex.leetcode;

import java.util.Arrays;

public class MinStackTest {

    public static void main(String[] args) {
        MinStack obj = new MinStack();

        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.push(6);
        obj.push(7);
        obj.push(8);
        obj.push(9);
        obj.push(10);
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());

        obj.pop();

        System.out.println(obj.top());
        System.out.println(obj.getMin());

        //["MinStack","push","push","push","getMin","push","push","push","push","push","top","push","push","getMin","push","getMin","push","push","getMin","push","top","push","getMin","push","push","push","push","getMin","push","push","top","push","push","getMin","pop","getMin","push","push","getMin","getMin","push","getMin","pop","push","push","push","getMin","push","getMin","getMin","getMin","pop","getMin","push","push","getMin","top","getMin","push","getMin","getMin","getMin","getMin","push","getMin","getMin","getMin","push","getMin","push","getMin","push","getMin","getMin","getMin","getMin","pop","getMin","push","getMin","getMin","push","push","pop","push","getMin","push","top","top","push","push","getMin","pop","getMin","push","top","push","getMin","push","getMin","getMin"]
        //[[],[85],[-99],[67],[],[-27],[61],[-97],[-27],[35],[],[99],[-66],[],[-89],[],[4],[-70],[],[52],[],[54],[],[94],[-41],[-75],[-32],[],[5],[29],[],[-78],[-74],[],[],[],[-58],[-44],[],[],[-64],[],[],[-45],[-99],[-27],[],[-96],[],[],[],[],[],[26],[-58],[],[],[],[25],[],[],[],[],[33],[],[],[],[71],[],[-62],[],[-78],[],[],[],[],[],[],[-30],[],[],[85],[-15],[],[-40],[],[72],[],[],[18],[59],[],[],[],[-59],[],[10],[],[9],[],[]]
    }
}

class MinStack {

    private static int INIT_CAPACITY = 10;
    private static final int INIT_ELEMENT_INDEX = -1;

    private int elemIndex;

    private int[] elements;

    /** initialize your data structure here. */
    public MinStack() {
        elemIndex = INIT_ELEMENT_INDEX;
        elements = new int[INIT_CAPACITY];
    }

    private void enableCapacity() {
        if (elemIndex + 1 == INIT_CAPACITY) {
            INIT_CAPACITY = INIT_CAPACITY << 1;
            elements = Arrays.copyOf(elements, INIT_CAPACITY);
        }
    }

    public void push(int x) {
        enableCapacity();
        elements[++elemIndex] = x;
    }

    public void pop() {
        if (elemIndex >= 0) {
            elements[elemIndex--] = 0;
        }
    }

    public int top() {
        if (elemIndex >= 0) {
            return elements[elemIndex];
        }
        return 0;
    }

    public int getMin() {
        if (elemIndex == INIT_ELEMENT_INDEX) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int i = elemIndex; i >= 0; i--) {
            if (min > elements[i]) {
                min = elements[i];
            }
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */