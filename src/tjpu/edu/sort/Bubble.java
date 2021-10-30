package tjpu.edu.sort;

/**
 * Created by Lwq on 2021/4/20 22:31
 * 冒泡排序
 * 冒泡排序是稳定的（排序的稳定性在需要多次排序时很重要）
 */
public class Bubble {
    
    /*
        对数组a中的元素进行排序
     */
    public void sort(Comparable[] a) {
        for (int i = a.length - 1;i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                //比较索引j和索引j+1处的值（如果a[j]>a[j+1]则交换）
                if (greater(a[j],a[j+1])) {
                    exchange(a, j, j+1);
                }
            }
        }
    }
    
    /*
        比较v元素是否大于w元素
     */
    private boolean greater(Comparable v, Comparable w) {
        //compareTo()返回整型结果, >0 代表 v > w  此时greater方法返回true
        //int result = v.compareTo(w);
        return v.compareTo(w) > 0;  
    }
    
    /*
        数组元素i和j交换位置
     */
    private void exchange(Comparable[] a, int i, int j) { //交换数组a中i和j处的元素
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    
}
