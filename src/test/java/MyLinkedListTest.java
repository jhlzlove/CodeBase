import jhlz.code.structure.MyLinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("123");
        list.add("hahaha");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.size());
        System.out.println("诗酒趁年华");
    }
}
