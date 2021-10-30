package tjpu.edu.test;

import tjpu.edu.linear.LinkList;

/**
 * Created by Lwq on 2021/7/20 22:07
 */
public class LinkListTest {
    public static void main(String[] args) {
        //创建单向链表对象
        LinkList<String> ll = new LinkList<>();

        //测试插入
        ll.insert("姚明");
        ll.insert("科比");
        ll.insert("库里");
        
        ll.insert(1,"杜兰特");

        for (String s : ll) {
            System.out.println(s);
        }
        System.out.println("------------------------------------");
        
        //测试获取
        String getResult = ll.get(1);
        System.out.println("获取索引1处的结果为：" + getResult);
        
        //测试删除
        String removeResult = ll.remove(0);
        System.out.println("删除的索引0处的元素是：" + removeResult);

        //测试清空
        ll.clear();
        System.out.println("清空后的线性表中元素个数为：" + ll.length());
    }
    
}
