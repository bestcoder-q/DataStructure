package tjpu.edu.test;

import tjpu.edu.linear.LinkList;

/**
 * Created by Lwq on 2021/7/25 18:32
 */
public class LinkListReverseTest {
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
        System.out.println("-------------");
        
        //测试链表反转
        ll.reverse();
        for (String s : ll) {
            System.out.println(s);
        }
        
    }
    
}
