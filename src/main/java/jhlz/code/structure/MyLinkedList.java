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

    /**
     * 元素个数
     *
     * @return size()
     */
    public int size() {
        return size;
    }

    private void linkLast(T e) {
        final MyNode<T> l = last;
        // 构造新数据结点
        MyNode<T> lastNode = new MyNode<>(l, e, null);
        // 新元素赋值给最后一个结点
        last = lastNode;
        // 如果最后一个元素为 null，那么链表没有任何结点
        if (l == null) {
            //
            first = lastNode.prev;
        } else {
            l.next = lastNode;
        }
        size++;
    }

    /**
     * 添加第一个元素
     *
     * @param e 添加的一个元素
     */
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

    /**
     * 获取第一个元素
     *
     * @return
     */
    public T getFirst() {
        return first.item;
    }

    /**
     * 获取链表第一个元素
     *
     * @return
     */
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


