package tjpu.edu.test;

import tjpu.edu.sort.Bubble;

import java.util.Arrays;

/**
 * Created by Lwq on 2021/7/7 21:28
 */
public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr = {4,5,6,3,2,1};
        Bubble bubble = new Bubble();
        bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
