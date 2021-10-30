package tjpu.edu.symbol;

/**
 * Created by Lwq on 2021/8/2 21:32
 * 符号表(有序)
 * 有序符号表的构建与无需符号表的差别在put方法上
 */
//有序符号表依赖key的比较规则，为了让key拥有比较规则让其继承Comparable接口
public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    
    private Node head;  //记录首结点
    private int N;  //记录符号表中元素的个数
    
    private class Node {
        public Key key;  //键
        public Value value;  //值
        public Node next;  //下一个结点

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    
    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }
    
    /*
    获取符号表中键值对的个数
     */
    public int size() {
        return N;
    }
    /*
    符号表中插入键值对
     */
    public void put(Key key, Value value) {
        //定义两个Node变量，分别记录当前结点和当前结点的上一个结点
        Node pre = head;
        Node curr = head.next;
        while (curr != null && key.compareTo(curr.key) > 0) {
            pre = curr;
            curr = curr.next;
        }
        //如果当前结点curr的键和要插入的key一样，则替换
        if (curr != null && key.compareTo(curr.key) == 0) {
            curr.value = value;
        }
        //如果当前结点curr的键和要插入的key不一样，把新结点插入到curr之前
        Node newNode = new Node(key, value, null);
        newNode.next = curr;  //课程中未加这行
        pre.next = newNode;

        N++;
    }
    /*
    删除符号表中键为key的键值对
     */
    public void delete(Key key) {
        //找到键为key的结点，把该结点从链表中删除
        Node n = head;
        while (n.next != null) {
            //判断n结点的下一个结点的键是否为key，如果是，就删除该结点
            if (n.next.key.equals(key)) {
                n.next = n.next.next;
                N--;
                return;
            }
            //变换n
            n = n.next;
        }
    }
    /*
    从符号表中获取key对应的值
     */
    public Value get(Key key) {
        Node n = head;
        while (n.next != null) {
            if (n.next.key.equals(key)) {
                return n.next.value;
            }
            n = n.next;
        }
        return null;
    }
    
    
}
