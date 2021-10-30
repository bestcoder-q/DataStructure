package tjpu.edu.test;

import tjpu.edu.linear.TwoWayLinkList;

/**
 * Created by Lwq on 2021/7/20 22:07
 */
public class TwoWayLinkListTest {
    public static void main(String[] args) {
        //创建双向链表对象
        TwoWayLinkList<String> twl = new TwoWayLinkList<>();

        //测试插入
        twl.insert("姚明");
        twl.insert("科比");
        twl.insert("库里");
        
        twl.insert(1,"杜兰特");

        for (String s : twl) {
            System.out.println(s);
        }
        System.out.println("------------------------------------");

        System.out.println("第一个元素是" + twl.getFirst());
        System.out.println("最后一个元素是" + twl.getLast());
        
        //测试获取
        String getResult = twl.get(1);
        System.out.println("获取索引1处的结果为：" + getResult);
        
        //测试删除
        String removeResult = twl.remove(0);
        System.out.println("删除的索引0处的元素是：" + removeResult);
        
        //测试清空
        twl.clear();
        System.out.println("清空后的线性表中元素个数为：" + twl.length());
        
    }
    
}
