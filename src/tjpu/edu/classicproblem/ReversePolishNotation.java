package tjpu.edu.classicproblem;

import tjpu.edu.linear.Stack;

/**
 * Created by Lwq on 2021/7/31 18:57
 * 逆波兰表达式（后缀表达式）
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        //中缀表达式 3*(17-15)+18/6 的逆波兰表达式如下
        String[] notation = {"3","17","15","-","*","18","6","/","+"};
        ReversePolishNotation rpn = new ReversePolishNotation();
        System.out.println(rpn.calculate(notation));
    }

    /**
     * 
     * @param notation 逆波兰表达式的数组表示方式
     * @return 逆波兰表达式的计算结果
     * 
     * 利用栈计算逆波兰表达式
     * 思路：遇到数字入栈，遇到符号出栈 x2，将计算结果入栈
     * 
     */
    public int calculate(String[] notation) {
        
        //1.定义一个栈，用来存储操作数
        Stack<Integer> operands = new Stack<>();
        //2.从左向右遍历逆波兰表达式，得到每一个元素
        for (int i = 0; i < notation.length; ++i) {
            if (notation[i].equals("+")||notation[i].equals("-")||notation[i].equals("*")||notation[i].equals("/")) {
                Integer number_top = operands.pop();
                Integer number_bottom = operands.pop();
                int result = 0;
                if (notation[i].equals("+")) {
                    result = number_bottom + number_top;
                } else if (notation[i].equals("-")) {
                    result = number_bottom - number_top;
                } else if (notation[i].equals("*")) {
                    result = number_bottom * number_top;
                } else if (notation[i].equals("/")) {
                    result = number_bottom / number_top;
                }
                operands.push(result);
            } else {
                operands.push(Integer.valueOf(notation[i]));
            }
        }
        //得到栈中最后一个元素，就是逆波兰表达式的结果
        return operands.pop();
    }
    
    
}
