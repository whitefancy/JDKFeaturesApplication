package JavaBasics;

/*
如果继承了父类，在构造子类时，会调用父类的默认构造方法（无参数）
 */
public class ConstructerDemo extends ClassA {
    ConstructerDemo() {
        System.out.println("b no param");
    }

    ConstructerDemo(String p) {
        System.out.println("b param" + p);
    }

    public static void main(String[] args) {
        ConstructerDemo c = new ConstructerDemo("test");
        /*
        a no param
        b paramtest
         */
    }
}

class ClassA {
    ClassA() {
        System.out.println("a no param");
    }

    ClassA(String p) {
        System.out.println("a param" + p);
    }
}
