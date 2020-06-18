package JavaBasics;

public class Singleton {
    // 对于数据库引擎访问， 假脱机打印设备 只用一个对象可能更好
    // 单例类
    private static Singleton instance;
    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
    public void test(){
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Boolean b = s1==s2;//true
        System.out.println(b);
    }
}
