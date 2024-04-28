package org.code.test;

import org.code.struct.MyLinkedList;

/**
 * @author jhlz
 * @version x.x.x
 */
public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("风中捉刀");
        list.add("无情葬月");
        list.add("荻花题叶");
        list.add("玲珑雪霏");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.remove(3);
        System.out.println("list = " + list + ", list size = " + list.size());
    }
}
