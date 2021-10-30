package tjpu.edu.linear;

import java.util.Iterator;

/**
 * Created by Lwq on 2021/7/22 10:31
 * 链表
 */
public class LinkList<T> implements Iterable<T> {
    
    private Node head;  //记录头结点
    private int N;  //记录链表的长度

    //结点类
    private class Node {
        T item;  //存储数据
        Node next;  //下一个结点

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList() {
        //初始化头结点
        this.head = new Node(null, null);
        //初始化元素个数
        this.N = 0;
    }
    
    /*
        清空链表
     */
    public void clear() {
        head.next = null;
        this.N = 0;
    }
    /*
        获取链表的长度
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
        获取指定位置i处的元素
     */
    public T get(int i) {
        //通过循环，从头结点开始向后找，依次找i次，就能找到对应的元素
        Node n = head.next;
        for (int index = 0; index < i; ++index) {
            n = n.next;
        }
        return n.item;
    }
    
    /*
        向链表中插入元素t    
     */
    public void insert(T t) {
        //找到当前最后一个结点
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        //创建新结点，保存元素t
        Node newNode = new Node(t, null);
        //让当前最后一个结点指向新结点
        n.next = newNode;
        //元素个数+1
        N++;
    }
    
    /*
        在指定位置i处，添加元素t
     */
    public void insert(int i, T t) {
        //找到i位置前一个结点
        Node pre = head;
        for (int index = 0; index < i; ++index) {
            pre = pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //创建新结点，并且新结点需要指向原来i位置的结点
        Node newNode = new Node(t, curr);
        //原来i位置的前一个结点指向新结点
        pre.next = newNode;
        //元素个数+1
        N++;
    }
    
    /*
        删除指定位置i处的元素
     */
    public T remove(int i) {
        //找到i位置的前一个结点
        Node pre = head;
        for (int index = 0; index < i; ++index) {
            pre = pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //i位置的前一个结点指向i位置的后一个结点
        pre.next = pre.next.next;
        //元素个数-1
        N--;
        return curr.item;
    }
    
    /*
        查找元素t在链表中第一个出现的位置
     */
    public int indexOf(T t) {
        Node curr = head;
        for (int i = 0; curr.next != null; ++i) {
            curr = curr.next;
            if (curr.item == t) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    /**
     * 上面的iterator()方法需要返回Iterator<T>对象
     * Iterator是接口，因此创建下面的内部类
     */
    private class LIterator implements Iterator {

        private Node n;
        public LIterator() {
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

    /**
     * 实现链表反转
     * 使用递归
     */
    //反转整个链表
    public void reverse() {
        //判断当前链表是否为空链表，空链表则结束运行，如果不是，则调用重载的reverse()方法完成反转
        if (isEmpty()) {
            return;
        }
        reverse(head.next);
    }
    
    //重载的reverse方法，反转指定的结点curr,并把反转后的结点返回
    public Node reverse(Node curr) {
        //递归出口，（当前结点是最后一个结点，让头结点指向这个结点，并结束递归调用）
        if (curr.next == null) {
            head.next = curr;
            return curr;
        }
        //递归地反转当前结点curr的下一个结点，返回值就是链表反转后当前结点的上一个结点
        Node pre = reverse(curr.next);
        //让返回的结点的写一个结点变为当前结点curr
        pre.next = curr;
        //把当前结点的下一个结点变为null
        curr.next = null;
        return curr;
    }


}
