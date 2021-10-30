package tjpu.edu.sort;

/**
 * Created by Lwq on 2021/7/7 21:52
 * 选择排序
 */
public class Selection {
    /*
        对数组a中的元素进行排序
     */
    public void sort(Comparable[] a) {
        for (int i = 0;i < a.length -1; ++i) {
            //定义一个变量，记录最小元素所在的索引，默认为参与选择排序的第一个元素所在的位置
            int minIndex = i;
            for (int j = i+1; j < a.length; ++j) {
                //比较最小索引处minIndex处的值和j索引处的值
                if (greater(a[minIndex],a[j])) {
                    minIndex = j; //更新最小索引位置
                }
            }
            //完成上面的for循环后找到了本轮快排的最小值位置（用minIndex记录了它的位置）
            //下一步就是交换本轮的最小值(minIndex处)和索引i处的值
            exchange(a, i, minIndex);
        }
    }
    
    /*
        比较v元素是否大于w元素
     */
    private boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }
    
    /*
        数组元素i和j交换位置
     */
    private void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    
}
