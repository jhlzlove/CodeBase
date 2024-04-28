package org.code.struct;

import java.util.StringJoiner;

/**
 * 实现一个带头节点的单链表，这样第一个节点的处理和后面的节点处理均保持一致
 *
 * @author jhlz
 * @version x.x.x
 */
public class MyLinkedList<T> {
    // 头结点
    Node<T> head;
    // 链表长度
    int size;

    public MyLinkedList() {
        // 带头结点的单链表
        this.head = new Node<>(null);
        this.size = 0;
    }

    public void add(T value) {
        this.insert(size, value);
    }

    /**
     * 获取指定节点的数据
     *
     * @param index 获取位置的索引数据
     * @return 节点数据
     */
    public Node<T> get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> temp = head.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 删除节点，删除节点的上一个引用指向删除节点的下一个节点
     */
    public Node<T> remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> temp = head.next;
        Node<T> prev = head;
        // 循环找到需要删除的节点位置，没有找到就向后移动
        for (int i = 0; i < index; i++) {
            temp = temp.next;
            prev = prev.next;
        }
        // 上一个引用指向下一个节点
        prev.next = temp.next;
        this.size--;
        return temp;
    }

    /**
     * 插入指定数据
     *
     * @param index 插入的索引位置
     * @param data  插入的数据
     */
    public void insert(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = new Node<>(data);
        // 插入第一个位置
        if (index == 0) {
            node.next = head.next;
            head.next = node;
        } else {
            // 插入其它位置，首先需要找到插入位置的索引（找到当前节点），新增节点的引用指向当前节点的后面的节点，当前节点的引用指向新增节点
            // 当前节点
            Node<T> cur = head.next;
            for (int i = 1; i < index; i++) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
        // 链表长度增加
        this.size++;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Node<T> cur = head.next;
        while (cur != null) {
            joiner.add(cur.toString());
            cur = cur.next;
        }
        return joiner.toString();
    }
}

/**
 * 定义节点
 *
 * @param <T> 泛型数据
 */
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}