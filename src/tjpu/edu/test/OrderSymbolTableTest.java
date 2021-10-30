package tjpu.edu.test;

import tjpu.edu.symbol.OrderSymbolTable;

/**
 * Created by Lwq on 2021/8/3 19:32
 */
public class OrderSymbolTableTest {

    public static void main(String[] args) {
        //创建有序符号表对象
        OrderSymbolTable<Integer, String> table = new OrderSymbolTable<>();
        
        table.put(1, "1a");
        table.put(2, "2b");
        table.put(4, "4d");
        table.put(7, "7g");
        
        table.put(3, "3c");

        System.out.println(table.get(1));
    }
    
}
