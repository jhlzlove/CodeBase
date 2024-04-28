package org.code.struct;

import java.util.StringJoiner;

/**
 * 双向带头结点的链表实现
 *
 * @author jhlz
 * @version x.x.x
 */
public class DoublyLinkedList<T> {
    // 头结点
    DoublyNode<T> head;
    // 链表长度
    int size;

    public DoublyLinkedList() {
        this.head = new DoublyNode<>(null);
        this.size = 0;
    }

    public DoublyNode get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        DoublyNode<T> node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public DoublyNode<T> remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        DoublyNode<T> cur = head.next;
        DoublyNode<T> prev = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
            prev = prev.next;
        }
        // 修改指向
        prev.next = cur.next;
        this.size--;
        return cur;
    }

    /**
     * 插入
     *
     * @param index 插入索引位置
     * @param value 插入数据
     */
    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        DoublyNode<T> node = new DoublyNode<>(value);
        /*
         * 头插法，插入节点的顺序和输出节点的顺序正好相反
         */
        // node.next = head.next;
        // node.prev = head;
        // if (head.next != null) {
        //     head.next.prev = node;
        // }
        // head.next = node;

        /*
         * 尾插法，每次插入都把元素作为最后一个节点
         */
        // DoublyNode<T> temp = head;
        // while (temp.next != null) {
        //     temp = temp.next;
        // }
        // temp.next = node;
        // node.prev = temp;

        if (index == 0) {
            node.prev = head;
            head.next = node;
        } else {
            DoublyNode<T> cur = head.next;
            DoublyNode<T> prev = cur.prev;
            for (int i = 1; i < index; i++) {
                cur = cur.next;
                prev = prev.next;
            }
            node.prev = prev;
            cur.next = node;
        }
        this.size++;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        DoublyNode<T> next = head.next;
        while (next != null) {
            joiner.add(next.toString());
            next = next.next;
        }
        return joiner.toString();
    }
}

class DoublyNode<T> {
    T data;
    // 前驱
    DoublyNode<T> prev;
    // 后继
    DoublyNode<T> next;

    public DoublyNode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}