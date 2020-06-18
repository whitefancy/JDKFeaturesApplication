package JavaBasics;

public interface InterfaceBasic {
    // 抽象
    // 定义了某一批嘞所需要遵守的规范
    // 不提供任何实现 体现了规范和实现分类的设计哲学

    // 接口只能继承接口，不能继承类
    // 接口支持多继承

    public abstract void test();// 只能用public abstract修饰 不能有方法体

    int max = 33;// 实际上 等同于public static final int

    public abstract void java8();
        // 允许在接口中定义默认方法
}
