package org.code.test;

import org.code.struct.DoublyLinkedList;

/**
 * @author jhlz
 * @version x.x.x
 */
public class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        list.insert(0, "123");
        list.insert(1, "345");
        list.insert(2, "诗酒趁年华");
        list.insert(3, "烟雨暗千家");

        list.remove(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
