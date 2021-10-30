package tjpu.edu.linear;

import java.util.Iterator;

/**
 * Created by Lwq on 2021/5/12 10:24
 * 队列（单链表实现）
 * 
 */
public class Queue<T> implements Iterable<T>{
    
    private Node head;  //记录首结点
    private Node last;  //记录最后一个结点
    private int N;  //记录队列中元素的个数
    
    
    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Queue() {
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }
    
    /*
    判断队列是否为空
     */
    public boolean isEmpty() {
        return N == 0;
    }
    /*
    返回队列中元素个数
     */
    public int size() {
        return N;
    }
    /*
    向队列中插入元素t
    （单链表的头插法）
     */
    public void enqueue(T t) {
        //当前尾结点last为null
        if (last == null) {
            Node newNode = new Node(t, null);
            last = newNode;
            head.next = last;
        } else {
            //当前尾结点last不为null
            Node newNode = new Node(t, null);
            last.next = newNode;
            last = newNode;
        }
        //元素个数+1
        N++;
    }
    /*
    从队列中取出一个元素
     */
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node targetNode = head.next;
        head.next = targetNode.next;
        N--;
        //因为出队列其实是在删除元素，因此如果队列中的元素删除完了，需要重置last = null
        if (isEmpty()) {
            last = null;
        }
        return targetNode.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }
    
    private class QIterator implements Iterator {
        private Node n;  //记录每一次遍历到的结点
        public QIterator() {
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
