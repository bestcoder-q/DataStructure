package tjpu.edu.test;

import tjpu.edu.sort.Merge;

import java.util.Arrays;

/**
 * Created by Lwq on 2021/7/12 23:08
 */
public class MergeTest {
    public static void main(String[] args) {
        Integer[] a = {8,4,5,7,1,3,6,2};
        Merge merge = new Merge();
        merge.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
