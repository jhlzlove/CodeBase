package jhlz.code.structure;

public class MyLinkedList<T> {
    // 首元结点
    MyNode<T> first;
    // 尾结点
    MyNode<T> last;
    // 元素个数
    int size = 0;

    public MyLinkedList() {

    }

    public int size() {
        return size;
    }

    private void linkFirst(T e) {
        final MyNode<T> f = first;

        // 创建结点
        MyNode<T> newNode = new MyNode<>(null, e, f);
        // 赋值
        first = newNode;
        // 如果第一个结点为 null，表示链表没有任何数据，空表。直接把值赋值给 last
        // 如果第一个结点（f）不为空，让其头指针域指向新的结点。
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    public T getFirst() {
        return first.item;
    }

    public T getLast() {
        return last.item;
    }

    public void add(T e) {
        linkFirst(e);
    }


    /**
     * 元素结点结构
     */
    private static class MyNode<E> {
        E item;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(MyNode<E> prev, E element, MyNode<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

}


