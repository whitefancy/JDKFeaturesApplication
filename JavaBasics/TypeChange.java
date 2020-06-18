package JavaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TypeChange {
    public void test(){
        int number = 9;
        // int to char
        char cNumber= (char) (number+'0');

        //array to string
        int[][] edges =new int[][]{{0,2},{1,2},{2,0}};
//        [[I@1540e19d, [I@677327b6, [I@14ae5a5]
        String s =Arrays.toString(edges);
        System.out.println(s);
//[[0, 2], [1, 2], [2, 0]]
        s=Arrays.deepToString(edges);
        System.out.println(s);

        //string 2 array


        //list to array
        List<Integer> order = new ArrayList<>();
        int[] a =order.stream().mapToInt((Integer in)-> in).toArray();
    }
    public static void String2Array(String s ){
        s = s.replace('[','{').replace(']','}');
        System.out.println(s);
    }
}
