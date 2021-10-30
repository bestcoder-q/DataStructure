package tjpu.edu.test;

import tjpu.edu.symbol.SymbolTable;

/**
 * Created by Lwq on 2021/8/3 17:07
 */
public class SymbolTableTest {

    public static void main(String[] args) {
        //创建符号表对象
        SymbolTable<Integer, String> symbolTable = new SymbolTable<>();

        //测试put方法（插入、替换）
        symbolTable.put(1, "a");
        symbolTable.put(2, "b");
        symbolTable.put(3, "c");
        symbolTable.put(4, "d");
        symbolTable.put(5, "e");

        System.out.println("插入完毕后元素个数：" + symbolTable.size());

        //测试替换,同时测试get
        System.out.println("替换前键2的value:" + symbolTable.get(2));
        symbolTable.put(2,"bbb");
        System.out.println("替换后键2的value:" + symbolTable.get(2));
        
        //测试删除方法
        symbolTable.delete(2);
        System.out.println("删除键2后元素个数：" + symbolTable.size());
        System.out.println("删除后尝试获取2：" + symbolTable.get(2));
        
    }
    
}
