package JavaBasics;

public class ClassMumbers {
    // static
    public static int in = 1;//不能写在方法里
    private void staticF(){
// 类成员 包括 静态初始化构造器 和static 修饰的
        // 不属于任何一个实例， 生存范围等同于该类
        //可以通过类来访问
        int a = ClassMumbers.in;
        ClassMumbers cm = null;
        a = cm.in;
        // 也可以通过实例对象访问
        cm = new ClassMumbers();
        a=cm.in;
    }

    //final
    private final int fi = 2;// 一旦获得初始值则不可变。 和单例类一样 值必须由程序员显式指定。
    private void finalF(){
        // final 可用于类成员 也可以用于局部变量
        final int fi = 2;
        System.out.println(fi);//2
        // 等价于 System.out.println(2);  宏替换
    }
    public final void func(){
        //final 方法不可被重写
        // 如果子类定义了同样的方法，属于重新定义了新的方法
        int a = 2;
        boolean b = fi==a;
    }
    private final class Class1{
        // final class 不能被继承
    }
    public void test(){
        finalF();
    }

    // immutable 不可变类 例如 String
    // Integer的缓存数组 是用final实现的，但也可以用immutable模式
    // 控制变得很简单 private 没有set方法
}
