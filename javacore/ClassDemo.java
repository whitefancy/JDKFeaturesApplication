package javacore;

//文件名必须与public类的名字相匹配
// 在一个源文件里，只能有一个公有类，可以有任意数目的非公有类
// 编译后，会生成class文件
// 每个类都会生成一个class文件
// 即使没有显式编译某个类，但是编译器发现正在编译的类使用了该类，会自动搜索它，对它进行编译
// 如果用到的类版本有新的，也会重新编译
// 可以认为Java编译器内置了unix的make功能
public class ClassDemo {
    private double salary;
    private String name;

    // 每个类变量称为一个实例域
//极不提倡使用public标记实例域，这会完全破坏了封装 强烈建议标记成private
    public ClassDemo(String name1) {
        //不能对一个已经存在的对象调用构造器，会编译错误
        // 构造器没有返回值
        // 和new一起使用
        //所有方法中不要命名与实例域同名的变量
        String name = "sgsd";//错误！
    }

    public ClassDemo() {
        //类是构造对象的模板或蓝图
        // 像是切割饼干的磨具，而对象则是小饼干
        // 由类构造对象 的过程称为 创建类的实例
        // 对象中的数据称为 实例域
        // 实例域值的集合称为对象的当前状态
        // 封装给对象赋予了“黑盒”的特征

        // 每个对象都有唯一的身份 即对象标识
        // 对象三个主要特性 行为 状态 标识
        // 对象的状态影响它的行为

        // 首先从设计 类 开始， 然后再往每个类中 添加方法
        // 找名词与动词 原则，重要的词是类

        //        类之间常见的关系：依赖 use-a 一个类的方法操纵另一个类的对象
        //        应该让相互依赖的类减至最少 术语 为减小耦合度
        //        聚合  类A的对象包含类B的对象 has-a 继承
        // 继承 is-a 表示特殊与一般的关系

    }

    public double getSalary() {
        return salary;
    }

    //name只有访问器方法，因此只在构造时可以设置name，所以name是只读域
// salary有更改器方法 但是更改之前可以执行错误检查
    public String getName() {
        return name;
    }

    public void raiseSalary(double byPercent) {
        //方法由两个参数
        // 隐式参数为方法左边的类名
        // 显式参数为括号里的参数
        double raise = byPercent * 5000;
        // 关键词this表示隐式参数 Java中，
        // 所有的方法必须在类的内部定义
        // 但并不表示它们是内联方法，由即时编译器设置
        salary += raise;
    }
}
