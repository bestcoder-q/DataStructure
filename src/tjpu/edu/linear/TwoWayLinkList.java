package tjpu.edu.linear;

import java.util.Iterator;

/**
 * Created by Lwq on 2021/7/23 22:18
 * 双向链表
 */
public class TwoWayLinkList<T> implements Iterable<T> {
    
    private Node head;  //首结点
    private Node last;  //尾结点
    
    private int N;  //链表的长度

    /*
        结点类（成员内部类）
     */
    private class Node {
        
        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

        public T item;  //存储数据
        public Node pre;  //指向上一个结点
        public Node next;  //指向下一个结点
        
    }
    
    public TwoWayLinkList() {
        //初始化头结点
        this.head = new Node(null, null, null);
        //初始化尾结点
        this.last = null;
        //初始化元素个数
        this.N = 0;
    }
    
    /*
        清空链表
     */
    public void clear() {
        this.head.next = null;
        this.last = null;
        this.N = 0;
    }
    /*
        获取链表长度
     */
    public int length() {
        return N;
    }
    /*
        判断链表是否为空
     */
    public boolean isEmpty() {
        return N == 0;
    }
    /*
        获取第一个元素
     */
    public T getFirst() {
        if (isEmpty()) { //如果链表为空，返回null即可
            return null;
        }
        return head.next.item;
    }
    /*
        获取最后一个元素
     */
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.item;
    }
    /*
        插入元素t
     */
    public void insert(T t) {
        //如果链表为空
        if (isEmpty()) {
            //创建新结点
            Node newNode = new Node(t, head, null);
            //让新结点成为尾结点
            last = newNode;
            //让头结点指向尾结点
            head.next = last;
        } else {    //如果链表不为空
            //创建新结点
            Node oldLast = last;
            Node newNode = new Node(t, oldLast, null);
            //让当前的尾结点指向新节点
            oldLast.next = newNode;
            //让新结点成为尾结点
            last = newNode;
        }
        //元素个数+1
        N++;
    }
    
    /*
        在指定位置i处插入元素
     */
    public void insert(int i, T t) {
        //找到i位置的前一个结点
        Node pre = head;
        for (int index = 0; index < i; ++index) {
            pre = pre.next;
        }
        //找到i位置的结点
        Node currNode = pre.next;
        //创建新结点
        Node newNode = new Node(t, pre, currNode);
        //让i位置的前一个结点指向新结点
        pre.next = newNode;
        //让i位置的前一个结点变为新节点
        currNode.pre = newNode;
        //元素个数+1
        N++;
    }
    
    /*
        获取指定位置i处的元素
     */
    public T get(int i) {
        Node n = head.next;
        for (int index = 0; index < i; ++index) {
            n = n.next;
        }
        return n.item;
    }
    
    /*
        找到元素t在链表中第一次出现的位置
     */
    public int indexOf(T t) {
        Node n = head;
        for (int index = 0; n.next != null; ++index) {
            if (t.equals(n.item)) {
                return index;
            }
        }
        return -1;
    }
    
    /*
        删除位置i处的元素，并返回该元素
     */
    public T remove(int i) {
        //找到位置i的前一个元素
        Node pre = head;
        for (int index = 0; index < i; ++index) {
            pre = pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        pre.next = curr.next;
        curr.next.pre = pre;
        //元素个数-1
        N--;
        return curr.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new TWLIterator();
    }
    
    private class TWLIterator implements Iterator {
        
        private Node n;

        public TWLIterator() {
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
