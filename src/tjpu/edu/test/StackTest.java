package tjpu.edu.test;

import tjpu.edu.linear.Stack;

/**
 * Created by Lwq on 2021/7/30 19:18
 */
public class StackTest {

    public static void main(String[] args) {
        //创建栈对象
        Stack<String> stack = new Stack<>();
        
        //测试压栈
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        for (String item : stack) {
            System.out.println(item);
        }
        System.out.println("-----------");
        
        //测试出栈
        String result = stack.pop();
        System.out.println("弹出的元素是：" + result);
        System.out.println("剩余的元素个数：" + stack.size());

    }
    
}
