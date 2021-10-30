package tjpu.edu.linear;

import java.util.Iterator;

/**
 * Created by Lwq on 2021/7/30 16:30
 * 使用链表实现栈
 */
public class Stack<T> implements Iterable<T> {
    
    private Node head;  //记录首结点
    private int N;  //记录元素个数

    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack() {
        this.head = new Node(null,null);
        this.N = 0;
    }
    
    /*
    判断栈中元素个数是否为0
     */
    public boolean isEmpty() {
        return N == 0;
    }
    /*
    获取栈中元素的个数
     */
    public int size() {
        return N;
    }
    
    /*
    把t元素压入栈
    (使用头插法)
     */
    public void push(T t) {
        //下面4句是我的写法
        Node newNode = new Node(t, null);
        //链表头插法
        newNode.next = head.next;
        head.next = newNode;
        //元素个数+1
        N++;
        
        //课程的写法
//        Node oldFirst = head.next;
//        Node newNode = new Node(t, null);
//        head.next = newNode;
//        newNode.next = oldFirst;
//        N++;
    }
    /*
    弹出栈顶元素
     */
    public T pop() {
        //栈空则不能出栈，返回null
        if (head.next == null) {
            return null;
        }
        //下面就是单链表的删除操作
        Node top = head.next;
        head.next = top.next;
        N--;
        return top.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    
    private class SIterator implements Iterator {

        private Node n;

        public SIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
    
    
}
