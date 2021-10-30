package tjpu.edu.sort;

/**
 * Created by Lwq on 2021/7/11 21:52
 * 归并排序
 * 时间复杂度 O(nlogn)
 */
public class Merge {
    
    //归并所所需要的辅助数组
    private Comparable[] assist;
    
    /*
        对数组a中的元素进行排序
     */
    public void sort(Comparable[] a) {
        //1.初始化辅助数组assist
        assist = new Comparable[a.length];
        //2.定义一个low变量和high变量，分别记录数组中最小的索引和最大的索引
        int low = 0;
        int high = a.length - 1;
        //3.调用sort重载方法完成数组a中，从索引low到索引high的元素的排序
        sort(a, low, high);
    }
    
    /*
        对数组a中从low到high的元素进行排序
     */
    private void sort(Comparable[] a, int low, int high) {
        //做安全性校验
        if (high <= low) {
            return;
        }
        //对low到high间的数据分为两个组
        int mid = low + (high - low) / 2;  //例：5，9  mid=7
        //分别对每一组数据进行排序
        sort(a, low, mid);
        sort(a, mid+1, high);
        //再把两个组中的数据进行归并
        merge(a, low, mid, high);
    }
    
    /**
     * 关键方法
     * 对排好序的两个数组归并为一个有序数组
     * 对数组中，从low到mid为一组，从mid+1到high为一组，对这两组数据进行归并
     */
    private void merge(Comparable[] a, int low, int mid, int high) {
        //定义三个指针
        int i = low;
        int p1 = low;
        int p2 = mid + 1;
        
        //遍历，移动p1指针和p2指针，比较对应索引处的值，找出较小的放到辅助数组的对应位置
        while (p1 <= mid && p2 <= high) {
            //比较对应索引处的值
            if (less(a[p1],a[p2])) {
                assist[i++] = a[p1++];  //注意这里[]中放的是i++和p1++，目的是赋值之后指针也顺便完成了向后移动的操作
//                assist[i] = a[p1];
            } else {
                assist[i++] = a[p2++];
            }
        }
        
        //遍历结束后，如果p1指针没有走完，那么顺序移动p1指针，把对应的元素放到辅助数组的对应索引处
        //          如果p2指针没有走完，那么顺序移动p2指针，把对应的元素放到辅助数组的对应索引处
        //注意下面两个while循环只会执行其中一个
        while (p1 <= mid) {
            assist[i++] = a[p1++];
        }
        while (p2 <= high) {
            assist[i++] = a[p2++];
        }
        
        //把辅助数组中的元素copy到原数组中
        for (int index = low; index <=high; ++index) {
            a[index] = assist[index];
        }
        
    }
    
    
    
    /*
        比较v元素是否小于w元素
     */
    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    /*
        交换数组i处和j处元素的位置
     */
    private void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    
}
