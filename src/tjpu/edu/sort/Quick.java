package tjpu.edu.sort;

/**
 * Created by Lwq on 2021/7/12 23:27
 * 快速排序
 * 最优情况和平均情况时间复杂度为O(nlogn)，最坏情况O(n^2)
 * 快排有两种方式，指针交换和挖坑，下面的方法是指针交换
 */
public class Quick {
    
    /*
        对数组中的元素进行排序
     */
    public void sort(Comparable[] a) {
        int low = 0;
        int high = a.length-1;
        sort(a, low, high);
    }
    
    /*
        （重载的方法）对数组a中从索引low到high之间的元素进行排序
     */
    private void sort(Comparable[] a, int low, int high) {
        //安全性校验
        if (high <= low) {
            return;
        }
        //1.需要对数组中low到high索引处的元素进行分组（左子组和右子组）
        int partition = partition(a, low, high);  //返回分组的分界值所在的索引，分界值位置变换后的索引
        //2.让左子组有序
        sort(a, low, partition-1);
        //3.让右子组有序
        sort(a, partition+1,high);
    }
    
    /**
     * 快排核心代码
     * 对数组a中，从索引low到high之间的元素进行分组，并返回分组界限对应的索引（分组的分界值所在的索引）
     */
    public int partition(Comparable[] a, int low, int high) {
        //确定分界值
        Comparable key = a[low];
        //定义两个指针，分别指向待切分元素的最小索引处和最大索引处的下一个位置
        int left = low;
        int right = high + 1;
        
        //切分
        while (true) {
            //先从右向左扫描，移动right指针，找到一个比分界值小的元素,停止
            while (less(key, a[--right])) {
                if (right == low) {
                    break;
                }
            }
                
            //再从左向右扫描，移动left指针，找到一个比分界值大的元素，停止
            while (less(a[++left], key)) {
                if (left == high) {
                    break;
                }
            }
            
            //判断当left>=right，元素扫描完毕，结束循环，否则交换元素即可
            if (left >= right) {
                break;
            } else {
                exchange(a, left, right);
            }
        }
        
        //交换分界值
        exchange(a, low, right);
        
        return right;
    }
    
    
    /*
        比较v元素是否小于w元素
     */
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    /*
        数组元素i和j交换位置
     */
    public void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    
}
