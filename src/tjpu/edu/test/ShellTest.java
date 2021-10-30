package tjpu.edu.test;

import tjpu.edu.sort.Shell;

import java.util.Arrays;

/**
 * Created by Lwq on 2021/7/11 18:53
 */
public class ShellTest {

    public static void main(String[] args) {
        Integer[] a = {9,1,2,5,7,4,8,6,3,5};
        Shell shell = new Shell();
        shell.sort(a);
        System.out.println(Arrays.toString(a));
    }
    
}
