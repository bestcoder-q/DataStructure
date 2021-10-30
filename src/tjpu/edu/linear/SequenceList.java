package tjpu.edu.linear;

import java.util.Iterator;

/**
 * Created by Lwq on 2021/6/24 22:11
 */
public class SequenceList<T> implements Iterable<T> {
    //存储元素的数组
    private T[] eles;
    
    //记录当前顺序表中的元素个数
    private int N;
    
    //构造方法
    public SequenceList(int capacity) {
        //初始化数组
        this.eles = (T[]) new Object[capacity];
        //初始化长度
        this.N = 0;
    }
    //将一个线性表置为空表
    public void clear() { 
        this.N = 0;
    }
    //判断当前线性表是否为空表
    public boolean isEmpty() {
        return N == 0;
    }
    //获取线性表的长度
    public int length() {
        return N;
    }
    //获取指定位置的元素
    public T get(int i) {
        return eles[i];
    }
    /*
        向线性表中添加元素t
     */
    public void insert(T t) {
        //添加元素时先判断数组是否需要扩容
        if (N == eles.length) {
            resize(2*eles.length);
        }
        eles[N++] = t;
    }
    /*
        在i元素处插入元素t
     */
    public void insert(int i, T t) {
        //添加元素时先判断数组是否需要扩容
        if (N == eles.length) {
            resize(2*eles.length);
        }
        //先把i及其后面的元素依次向后移动一位
        for (int j = N-1; j >= i; --j) {
            eles[j+1] = eles[j];
        }
        //将待插入元素放到i处
        eles[i] = t;
        //元素个数+1
        N++;
    }
    
    /*
        删除指定位置i处的元素，并返回该元素
     */
    public T remove(int i) {
        //记录索引i处的值
        T current = eles[i];
        //索引i后面的元素依次向前移动一位即可
        for (int index = i; index < N-1; ++index) {
            eles[index] = eles[index + 1];
        }
        //元素个数-1
        N--;
        
        //删除元素后判断数组是否需要缩容（判断依据是剩余元素个数是否<数组长度的1/4）
        if (N < eles.length/4) {
            resize(eles.length/2);
        }
        
        return current;
    }
    
    /*
        查找t元素第一次出现的位置
     */
    public int indexOf(T t) {
        int first;
        for (int index = 0; index < N; ++index) {
            if (eles[index] == t) {
                return index;
            }
        }
        //循环结束还没有返回代表没有找到，返回-1
        return -1;
    }
    
    /*
        顺序表的容量变化
        根据canshu重置eles
     */
    public void resize(int newSize) {
        //定义一个临时数组，指向原数组
        T[] temp = eles;
        //创建新数组
        eles = (T[]) new Object[newSize];
        //把原数组中的数据copy到新数组即可
        for (int i = 0; i < N; ++i) {
            eles[i] = temp[i];
        }
        
    }
    

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    
    /*
        内部类
     */
    private class SIterator implements Iterator {
        private int cursor;
        public SIterator() {
            this.cursor = 0; 
        }
        
        @Override
        public boolean hasNext() {
            //cursor<N表示还有元素，否则（cursor>=N）表示没有元素了
            return cursor < N;
        }

        @Override
        public Object next() {
            //使用指针获取当前元素后，指针后移一位，可以使用[cursor++]
            return eles[cursor++];
        }
    }
    
}
