package JDKFeaturesApplication.genericsUsage;

import java.util.ArrayList;
import java.util.List;
//在没有使用泛型的情况下，如果要实现参数“任意化”，
// 通常会定义成Object类型来接受，然后强制类型转换使用；
// 而强制类型转换有明显的缺点，就是必须要知道实际参数的具体类型的情况才可以进行转换，
// 同时在强制转换的过程中，编译器不会报错提示的，只有在运行阶段才会出现异常，一定程度上存在安全隐患。
public class GenericBasics {
    ArrayList<String> s;
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
