package com.lihebin.learn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lihebin on 2020/8/26.
 *
 * 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 *
 */
public class AddTwoNum {

    private static List<Integer> addTwoNumbers(List<Integer> list1, List<Integer> list2) {
        List<Integer> resultList = new LinkedList<>();
        int carry = 0;
        if (list1.size() > 0 && list2.size() > 0) {
            int size;
            if (list1.size() >= list2.size()) {
                size = list1.size();
            } else {
                size = list2.size();
            }
            for (int i = 0; i < size; i++) {
                if (list1.size() > i && list2.size() > i) {
                    carry = carry + list1.get(i) + list2.get(i);
                } else if (list1.size() > i){
                    carry = carry + list1.get(i);
                } else {
                    carry = carry + list2.get(i);
                }
                int sum = carry;
                carry = carry / 10;
                sum = sum % 10;
                resultList.add(sum);
            }
        }
        return resultList;

    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,0,4,6);
        List<Integer> list2 = Arrays.asList(3,4,7);
        List<Integer> listResult = addTwoNumbers(list1, list2);
        System.out.println(listResult);
    }
}
