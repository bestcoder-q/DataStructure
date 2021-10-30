package tjpu.edu.tree;

import java.util.Queue;

/**
 * Created by Lwq on 2021/4/27 19:22
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {
    
    private Node root; //记录根结点
    private int N; //记录树中元素的个数
    
    //结点类（内部类）
    private class Node {
        public Key key; //存储键
        private Value value; //存储值
        public Node left; //记录左子结点
        public Node right; //记录右子结点

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    
    //获取树中元素的个数
    public int size() {
        return N;
    }
    
    //向树中添加元素 key-value
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }
    
    //向指定的树x中添加 key-value,并返回添加元素后的新的树
    private Node put(Node x, Key key, Value value) {
        //如果x子树为空
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        //如果x子树不为空
        //比较x结点的键和key的大小，
        int cmp = key.compareTo(x.key);
        if (cmp < 0) { //如果key小于x结点的键，则继续找x结点的左子树
            x.left = put(x.left, key, value); //递归查找x的左子树
        } else if (cmp > 0) { //如果key大于x结点的键，则继续找x结点的右子树
            x.right = put(x.right, key, value);
        } else { //cmp==0 如果key等于x结点的键（说明已经存在该键的结点），则替换x结点的值为value即可
            x.value = value;
        }
        return x;
    }
    
    //查询树中指定key对应的value
    public Value get(Key key) {
        return get(root, key);
    }
    
    //从指定的树x中，查找key对应的值
    public Value get(Node x, Key key) {
        //x树为null
        if (x == null) {
            return null;
        }
        //x树不为null
        //比较key和x结点的键的大小
        int cmp = key.compareTo(x.key);
        if (cmp < 0) { //如果key的值小于x的键，则继续找x的左子树
            return get(x.left, key);
        } else if (cmp > 0) { //如果key的值大于x的键，则继续寻找x的右子树
            return get(x.right, key);
        } else { //如果key的值等于x的键，说明找到了x的位置，返回x.value即可
            return x.value;
        }
    }

    /**
     * 注:
     * 删除操作是二叉查找树中最麻烦的操作，要保证删除某个结点后，剩下的部分仍然是一个二叉查找树
     */
    //删除树中key对应的value
    public void delete(Key key) {
        delete(root, key);
    }
    
    //删除指定树x中key对应的value，并返回删除后的新树
    public Node delete(Node x, Key key) {
        //x树为null
        if (x == null) {
            return null;
        }
        //x树不为null
        int cmp = key.compareTo(x.key);
        if (cmp < 0) { //如果key小于x结点的键，则继续寻找x结点的左子树
            x.left = delete(x.left, key);
        } else if (cmp > 0) { //如果key大于x结点的键，则继续寻找x结点的右子树
            x.right = delete(x.right,key);
        } else { //如果key等于x结点的键，完成真正的删除结点的动作（要删除的结点就是x）
            //元素个数-1
            N--;
            
            //1.找到右子树中的最小的结点（用来替换需要删除的结点）
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node minNode = x.right; //minNode用来记录右子树中的最小结点（初始化为右子树的根结点）
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //2.删除右子树中最小的结点（他这个算法没有考虑到minNode有右子树的情况）
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }
            //3.
//            x = minNode; 这样不行吗？？
            minNode.left = x.left; //让x结点的左子树成为minNode的左子树
            minNode.right = x.right; //让x结点的右子树成为minNode的右子树
            x = minNode; //让x结点的父结点指向minNode
            
        }
        return x;
    }
    
    /*
        查找整个树中最小的键
     */
    public Key min() {
        return min(root).key;
    }
    /*
        在指定树x中找到最小键所在结点
     */
    private Node min(Node x) {
        //需要判断x还有没有左子结点，如果有，则继续向左找，如果没有，则x就是最小键所在的结点
        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }
    
    /*
        查找整个树中最大的键
     */
    public Key max() {
        return max(root).key;
    }
    //在指定树x中找出最大的键所在的结点
    private Node max(Node x) {
        if (x.right != null) {
            return max(x.right);
        } else {
            return x;
        }
    }
    
    /*
        获取整个树中所有的键
     */
//    public Queue<Key> preErgodic() {
//        Queue<Key> keys = new Queue<>();
//        return preErgodic(root, )
//    }
    //获取指定树x中所有的键，并放到keys队列中
    private void preErgodic(Node x, Queue<Key> keys) {
        
    }
    
    
    
}
