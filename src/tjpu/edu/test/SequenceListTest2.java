package tjpu.edu.test;

import tjpu.edu.linear.SequenceList;

/**
 * Created by Lwq on 2021/7/21 14:09
 * 容量可变的顺序表测试类
 */
public class SequenceListTest2 {
    public static void main(String[] args) {
        SequenceList<String> sl = new SequenceList<>(3);
        sl.insert("库里");
        sl.insert("杜兰特");
        sl.insert("欧文");
        
        //当顺序表容量为3时，再插入元素会出现越界异常
        sl.insert("哈登");

        System.out.println(sl.length());
        System.out.println(sl.get(3));
        
    }
}
