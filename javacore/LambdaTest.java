package javacore;

import JavaBasics.Person;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java中有很多封装代码块的接口，lambda表达式与这些接口兼容
 * 对于只有一个抽象方法的接口，就可以用lambda表达式，称为函数式接口
 * 最好吧lambda表达式看做一个函数，而不是对象，另外要接受它可以传递到函数式接口
 * lambda表达式可以转换为接口
 */
public class LambdaTest {
    /*
    在sort方法中，compare方法会和其余的排序逻辑集成，来进行排序，你不想改变其他逻辑
    actionperformed和compare方法的共同之处，都是一个代码块传递到某个对象里，这个代码块将在某个时间调用
    java传递一段代码必现要构造一个对象，而那些能直接处理代码块的语言，API更一致而且更强大。
    函数式编程
     */
    public LambdaTest() {
        //必须实现为函数式接口，而不是返回值
        ToIntBiFunction<String, String> stringComparator = (String first, String second) -> first.length() - second.length();
        stringComparator = (String first, String second) -> {
            if (first.length() < second.length()) {
                return -1;
            } else if (first.length() > second.length()) {
                return 1;
            } else {
                return 0;
            }
        };
        /*
        如果可以根据接口推断出参数类型，则可以忽略其类型,
        如果只有一个参数，还可以省略()
         */
        Comparator<String> comp = (first, second) -> first.length() - second.length();
        ActionListener listener = event -> System.out.println("this time is" + new Date());
        /*
        无需指定返回值的类型，会根据上下文自动推断
        但是不能有些分支返回值，有些不返回，要一致
         */
        /*
        lambda表达式的形式为 （参数）->{表达式}
        如果有｛｝必须显式return 否则像方法一样即可
        即使没有参数，也要提供（）
         */
        /*
        没有返回值的lambda，要实现为runnable接口
         */
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        };
        /*
            两个有用的接口
            BiFunction<T,U,R>描述了参数类型为T和U，返回类型为R的函数
            Predicate<T> 描述了过滤符合条件
         */
        BiFunction<String, Integer, Boolean> old = (name, year) -> {
            if (name == "I") {
                return true;
            } else if (year < 30) {
                return true;
            } else {
                return false;
            }
        };
        Predicate<Object> predicate = e -> e == null;
        ArrayList list = new ArrayList();
        list.removeIf(e -> e == null);//删除所有的null值

        /*
        方法引用
        可以省略方法，只写对象名和函数体
        继而可以省略参数，只写方法名
        继而使用object，class，this，super来代替对象名
         */
        Timer t = new Timer(1000, event -> System.out.println(event));
        t = new Timer(1000, System.out::println);//等价于 上面
        BiFunction<Double, Double, Double> pow = Math::pow;
        pow = (x, y) -> Math.pow(x, y);//等价于上面
        BiFunction<String, String, Integer> compareToIgnoreCase = String::compareToIgnoreCase;
        compareToIgnoreCase = (x, y) -> x.compareToIgnoreCase(y);

        /*
        构造器引用

         */
        IntConsumer aNew = int[]::new;// 等价于 x -> new Object[x];
        ArrayList<String> names = new ArrayList<>();
        Stream<Person> stream = names.stream().map(Person::new);
        List<Person> people1 = stream.collect(Collectors.toList());
        //等价于
        Object[] people = stream.toArray();
        Person[] people2 = stream.toArray(Person[]::new);
        //使用toArray来构造一个正确类型的数组并返回，而不是只能由steam转成object

        /*
        变量作用域
        lambda表达式有3个部分 一个代码块 参数 自由变量的值（返回值）
        这里称为闭包 Java也有闭包了，lambda表达式就是闭包
        在lambda表达式里，只能引用值不会改变的变量，即最终变量，否则并发不安全。
        所以值既不能在内部改变，也不能在外部改变
         */

        /*
        编写lambda表达式
        重点是延迟执行（在一个单独的线程中运行代码 多次运行代码 算法的适当位置运行代码 发生某种情况触发代码 只在必要时才运行）
        如果要立即执行，无需把它包装成lambda
        将lambda表达式声明为Runnable接口，调用action.run（） 来执行lambda表达式的主体
         */
        // Arrays.sort(people, Comparator.comparing(Person::getLastName).thenComparing(person -> person.getFirstName()));
    }
}
