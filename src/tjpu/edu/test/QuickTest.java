package tjpu.edu.test;

import tjpu.edu.sort.Quick;

import java.util.Arrays;

/**
 * Created by Lwq on 2021/7/14 22:06
 */
public class QuickTest {
    public static void main(String[] args) {
        Integer[] a = {6,1,2,7,9,3,4,5,8};
        Quick quick = new Quick();
        quick.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
