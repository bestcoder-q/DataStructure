package tjpu.edu.symbol;

/**
 * Created by Lwq on 2021/8/2 21:32
 * 符号表(无序)
 */
public class SymbolTable<Key, Value> {
    
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
    
    public SymbolTable() {
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
        //1.符号表中已经存在键为key的键值对
        //这种情况只需找到该结点，替换value即可
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        //2.符号表中不存在键为key的键值对
        //创建新结点，保存要插入的键值对，把新结点插入到链表头部（head.next = 新结点）
        //这种情况需要元素个数 +1
        Node newNode = new Node(key, value, null);
        newNode.next = head.next;
        head.next = newNode;
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
