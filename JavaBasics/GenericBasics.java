package JavaBasics;

import java.util.List;

public class GenericBasics {
    public void test(){
        java5();
    }

    private void java5() {
//        java5引入了泛型 参数化类型，以避免元素丢进容器后类型丢失变为object
//        泛型设计原则：代码编译时没有警告，运行时也不会ClassCastException

    }
    private void java7(List<?> c) {
//        java7 开始泛型允许构造器省略泛型信息，只在前面写，即菱形语法
//        泛型中的子类，是逻辑上的，物理上不存在
//       ? 是通配符 可以给任何支持泛型的类的方法
//        这里还可以使用 List<? extends String>
        System.out.println(c.get(0));
    }


}
