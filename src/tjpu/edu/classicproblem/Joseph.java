package tjpu.edu.classicproblem;

/**
 * Created by Lwq on 2021/7/29 18:53
 * 约瑟夫问题
 * 41个人坐一圈，第一个人编号为1，第二个人编号为2，第n个人编号为n。
 * 1.编号为1的人开始从1报数，依次向后，报数为3的那个人退出圈；
 * 2.自退出那个人开始的下一个人再次从1开始报数，以此类推；
 * 3.求出最后退出的那个人的编号。
 *
 * 解题思路
 * 1.构建含有41个结点的单向循环链表，分别存储1~41的值，分别代表这41个人；
 * 2.使用计数器count，记录当前报数的值；
 * 3.遍历链表，每循环一次，count++；
 * 4.判断count的值，如果是3，则从链表中删除这个结点并打印结点的值，把count重置为0；
 */
public class Joseph {

    /*
        结点类
     */
    private static class Node<T> {
        T item;  //存储数据
        Node next;  //下一个结点

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /*
        解决约瑟夫问题
     */
    public static void main(String[] args) {
        
        //1.构建循环链表，包含41个结点，分别存储1-41之间的值
        Node<Integer> first = null;  //记录首结点
        Node<Integer> pre = null;  //记录前一个结点
        
        for (int i = 1; i <= 41; ++i) {
            //如果是第一个结点(i == 1时)
            if (i == 1) {
                first = new Node<>(i, null);
                pre = first;
                continue;
            }
            //不是第一个结点
            Node<Integer> newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = newNode;
            //如果是最后一个结点，需要让最后一个结点的下一个结点变为first(变为循环链表)
            if (i == 41) {
                pre.next = first;
            }
        }
        
        //2.定义计数器
        int count = 0;
        
        //3.遍历循环链表
        Node<Integer> n = first;  //记录每次遍历拿到的结点，默认从首结点开始
        Node<Integer> before = null;  //记录当前结点的上一个结点
        while (n != n.next) {  //n=n.next时，代表循环链表只剩一个元素
            //模拟报数
            count++;
            //判断当前报数是不是3
            if (count == 3) {
                //如果是3，则把当前结点删除，打印当前结点，重置count=0，让当前结点n后移
                before.next = n.next;
                System.out.print(n.item + ",");
                count = 0;
                n = n.next;
            } else {
                //如果不是3，让before变为当前结点，让当前结点后移
                before = n;
                n = n.next;
            }
        }
        //打印剩余的最后一个元素
        System.out.println(n.item);
        
    }
    
    
}
