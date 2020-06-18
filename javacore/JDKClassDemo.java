package javacore;

import java.time.LocalDate;
import java.util.Date;

public class JDKClassDemo {
    private JDKClassDemo() {
        //java中，使用构造器（constructor）方法构造新实例
        String s = new Date().toString();
        System.out.println(s);
        Date deadline;//未初始化不能使用它的方法
        //Java对象变量可以看做C++的对象指针
        //初始化对象有两种方式 新构造 或者引用一个已经存在的变量

        // 时间是距离一个固定时间的毫秒数（可正可负）
        // 这个点是纪元epoch 1970-01-01 00:00:00（UTC)
        // java 中时间和日期是分开的，这样有利于个性化历法

        //应当使用静态工厂方法 来代表 你 调用构造器
        LocalDate today = LocalDate.now();//构造一个表示当前日期的对象
        LocalDate birthday = LocalDate.of(1994, 12, 17);
        //构造一个表示给定日期的对象
        LocalDate old1 = birthday.plusDays(365);//原日期不会改变，只是构造一个新日期
        // 只访问对象 而不修改对象的方法 成为 访问器方法
        // 会修改对象的方法，称为 更改器方法
        System.out.println(today + " " + birthday);

        // 最好不要使用标记为废弃不用的方法，因为将来某个版本很有可能将其完全删除
    }

    public static void main(String[] args) {
        new JDKClassDemo();
    }
}
