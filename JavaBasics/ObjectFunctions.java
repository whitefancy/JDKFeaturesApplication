package JavaBasics;

public class ObjectFunctions {
    public static void test() {
        // toString
        // dfss 实现了toString方法
        String s1 = "dfss";
        Object o = s1;
        String s = o.toString();
        System.out.println(s);
        //JavaBasics.Person@1540e19d 没有实现toString方法 返回 类名@hashCode
        Person p = new Person("d");
        s = p.toString();
        System.out.println(s);

        // equals ==
        // 基本类型可以用==
        // 引用类型必须用equals
        String s2 = new String("hello");
        // 这里一共产生了两个字符串对象。
        // 第一个hello是直接量，在常量池里
        // 第二个使用常量池的直接量构造String对象，保存到堆里
        boolean k = s2 == "hello"; //false
        System.out.println(k);
    }
}
