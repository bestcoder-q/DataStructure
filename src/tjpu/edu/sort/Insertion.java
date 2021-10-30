package tjpu.edu.sort;

/**
 * Created by Lwq on 2021/7/11 15:08
 * 插入排序
 * 时间复杂度 O(n^2)
 * 插入排序是稳定的
 * 原理：
 * 1.把所有的元素分为两组，已经排序的和未排序的
 * 2.找到未排序的组中的第一个元素，向已经排序的组中进行插入
 * 3.倒叙遍历已经排序的元素，依次和待插入的元素进行比较，直到找到一个元素<=待插入元素，将待插入元素放到这个位置，其它元素向后移动一位
 */
public class Insertion {
    
    /*
        对数组a中的元素进行排序
     */
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; ++i) {
            for (int j = i; j > 0; --j) {
                if (greater(a[j-1],a[j])) {
                    exchange(a, j-1, j);
                } else {
                    break;
                }
            }
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
