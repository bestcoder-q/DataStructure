package tjpu.edu.test;

import tjpu.edu.sort.Insertion;

import java.util.Arrays;

/**
 * Created by Lwq on 2021/7/11 15:50
 */
public class InsertionTest {

    public static void main(String[] args) {
        Integer[] a = {4,3,2,10,12,1,5,6};
        Insertion insertion = new Insertion();
        insertion.sort(a);
        System.out.println(Arrays.toString(a));
    }
    
}
