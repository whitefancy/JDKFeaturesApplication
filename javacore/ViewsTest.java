package javacore;

import JavaBasics.Person;

import java.util.*;

/*
通过视图views 可以获得其他实现了Collection 和Map接口的对象
实际情况是 这个类的方法对原映射进行操作， 这种复合的集合称为视图
 */
public class ViewsTest {
    /*
    轻量级 集合包装器
    Arrays 的asList方法 返回 包装了普通Java数组 的List包装器
    返回的对象并不是ArrayList，而是一个带有访问数组全部方法的视图对象，
    只能用get和set ，不能用ArrayList的add 或remove 但实际上可以用？？？
     */
    private final Person[] people = new Person[20];
    private final List<Person> peoplelist = Arrays.asList(people);

    {
        peoplelist.add(new Person("d"));
        peoplelist.remove(0);
        peoplelist.set(0, new Person("s"));

    /*
    子范围
     */
        peoplelist.subList(0, 1);
        SortedSet<String> set = null;
        SortedSet<String> strings = set.tailSet("i");
        strings = set.headSet("d");
        strings = set.subSet("a", "f");
        /*
        Map也有同样的子范围视图
         */

        /*
        不可修改视图
         */
        List unmodify = Collections.unmodifiableList(peoplelist);// 通过unmodify这个变量的访问，是不可修改的，但peoplelist本身是可以修改的

        /*
        同步视图
         */
        List syn = Collections.synchronizedList(peoplelist);//此时就可以多线程访问了

        /*
        受查视图
         */
        Set safe = Collections.checkedSet(set, String.class);//如果list插入不是Person的元素，可以立即抛出异常，
        // 好处 可以在正确的位置报告问题
    }
}
