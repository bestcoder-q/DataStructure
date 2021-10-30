package tjpu.edu.test;

import tjpu.edu.linear.Queue;

/**
 * Created by Lwq on 2021/8/2 12:00
 */
public class QueueTest {

    public static void main(String[] args) {
        //创建队列
        Queue<String> queue = new Queue<>();
        
        //测试队列的enqueue方法
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        System.out.println(queue.size());
        
        //测试队列的dequeue方法
        String first = queue.dequeue();
        System.out.println("出队列的元素是：" + first);
        System.out.println("剩余的元素个数是：" + queue.size());

    }
    
}
