package tjpu.edu.classicproblem;

import tjpu.edu.linear.Stack;

/**
 * Created by Lwq on 2021/7/30 19:41
 * 案例：给定一个字符串，里边可能包含"()"小括号和其他字符，请编写程序检查该字符串的中的小括号是否成对出现。
 * 例如：
 * "(上海)(长安)"：正确匹配
 * "上海((长安))"：正确匹配
 * "上海(长安(北京)(深圳)南京)":正确匹配
 * "上海(长安))"：错误匹配
 * "((上海)长安"：错误匹配
 */
public class BracketsMatch {

    public static void main(String[] args) {
        String str = "(上海)(长安)";
        BracketsMatch bracketsMatch = new BracketsMatch();
        boolean match = bracketsMatch.isMatch(str);
        System.out.println(str + "中的括号是否匹配：" + match);
    }

    /**
     * 判断str中的括号是否匹配
     * @param str 括号组或字符串
     * @return 如果匹配，返回true,如果不匹配，返回false
     */
    public boolean isMatch(String str) {
        
        //1.创建栈对象，用来存储左括号
        Stack<String> chars = new Stack<>();
        //2.从左到右遍历字符串，拿到每一个字符
        for (int i = 0; i < str.length(); ++i) {
            //charAt()可以取出字符串中的每个字符，为了方便对比，在后面拼接了空字符串 +""
            String currChar = str.charAt(i)+"";
            //3.判断当前字符是否为左括号，如果是，则入栈
            if (currChar.equals("(")) {
                chars.push(currChar);
            } else if (currChar.equals(")")) {
                //4.继续判断当前字符是否为右括号，如果是，则从栈中弹出一个左括号，并判断弹出的结果是否为null,如果为null证明没有匹配的左括号
                String pop = chars.pop();
                if (pop == null) {
                    return false;
                }
            }
        }
        //5.判断栈中还有没有剩余的左括号，如果有，则证明括号不匹配
        if (chars.size() == 0) {
            return true;
        } else {
            return false;
        }

        //简单写法
        //return chars.size() == 0;
        
    }
    
    
}
