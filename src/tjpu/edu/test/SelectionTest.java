package tjpu.edu.test;

import tjpu.edu.sort.Selection;

import java.util.Arrays;

/**
 * Created by Lwq on 2021/7/7 23:02
 */
public class SelectionTest {
    public static void main(String[] args) {
        Integer[] arr = {4,6,8,7,9,2,10,1};
        Selection selection = new Selection();
        selection.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
}
