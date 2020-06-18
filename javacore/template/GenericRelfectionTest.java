package javacore.template;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;

public class GenericRelfectionTest {
    public static void main(String[] args) {
        //read class from commmand line args or user input
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            try (Scanner in = new Scanner(System.in)) {
                System.out.println("Enter class name(e.g. java.util.Collenctions): ");
                name = in.next();
            }
        }
        try {
            Class<?> cl = Class.forName(name);
            GenericRelfectionTest.printClass(cl);
            for (Method m : cl.getDeclaredMethods()) {
                GenericRelfectionTest.printMethod(m);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printMethod(Method m) {
        String name = m.getName();
        System.out.print(Modifier.toString(m.getModifiers()));
        System.out.print(" ");
        //如果这个方法被声明为泛型方法， 则获得泛型类型变量，否则返回长度为 0 的数组。
        GenericRelfectionTest.printTypes(m.getTypeParameters(), "<", ",", ">", true);
        //获得这个方法被声明的泛型返回类型。
        GenericRelfectionTest.printType(m.getGenericReturnType(), false);
        System.out.print(" " + name + "(");
        //获得这个方法被声明的泛型参数类型。 如果这个方法没有参数，返回长度为 0 的
        //数组。
        GenericRelfectionTest.printTypes(m.getGenericParameterTypes(), "", ",", "", false);
        System.out.println(")");

    }

    public static void printClass(Class<?> cl) {
        System.out.println(cl);
        //如果这个类型被声明为泛型类型，则获得泛型类型变量，否则获得一个长度为 0 的数组。
        GenericRelfectionTest.printTypes(cl.getTypeParameters(), "<", ",", ">", true);
        //获得被声明为这一类型的超类的泛型类型；如果这个类型是 Object 或不是一个类类型
        //( class type), 则返回 null
        Type sc = cl.getGenericSuperclass();
        if (sc != null) {
            System.out.println(" extends ");
            GenericRelfectionTest.printType(sc, false);
        }
        //获得被声明为这个类型的接口的泛型类型（以声明的次序，) 否则， 如果这个类型没有
        //实现接口，返回长度为 0 的数组。
        GenericRelfectionTest.printTypes(cl.getGenericInterfaces(), "implements ", ",", "", false);
        System.out.println();
    }

    private static void printType(Type type, boolean isDefinition) {
        if (type instanceof Class) {
            Class<?> t = (Class<?>) type;
            System.out.print(t.getName());
        } else if (type instanceof TypeVariable) {
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.print(t.getName());
            if (isDefinition) {
                //获得类型变量的子类限定，否则，如果该变量无限定， 则返回长度为 0 的数组。
                GenericRelfectionTest.printTypes(t.getBounds(), "extends ", " & ", "", false);
            }
        } else if (type instanceof WildcardType) {
            WildcardType t = (WildcardType) type;
            System.out.print("?");
            //获得这个类型变量的子类 ( extends) 限定，否则， 如果没有子类限定，则返回长度为
            //0 的数组
            GenericRelfectionTest.printTypes(t.getUpperBounds(), " extends ", " & ", "", false);
//获得这个类型变量的超类（super) 限定，否则， 如果没有超类限定，则返回长度为 0
//的数组。
            GenericRelfectionTest.printTypes(t.getLowerBounds(), " super ", " & ", "", false);
        } else if (type instanceof ParameterizedType) {
            ParameterizedType t = (ParameterizedType) type;
            //如果是内部类型， 则返回其外部类型，如果是一个顶级类型， 则返回 null。
            Type owner = t.getOwnerType();
            if (owner != null) {
                GenericRelfectionTest.printType(owner, false);
                System.out.print(".");
            }
            //获得这个参数化类型的原始类型。
            GenericRelfectionTest.printType(t.getRawType(), false);
            //获得这个参数化类型声明时所使用的类型参数。
            GenericRelfectionTest.printTypes(t.getActualTypeArguments(), "<", ",", ">", false);
        } else if (type instanceof GenericArrayType) {
            GenericArrayType t = (GenericArrayType) type;
            System.out.print("");
            //获得声明该数组类型的泛型组件类型。
            GenericRelfectionTest.printType(t.getGenericComponentType(), isDefinition);
            System.out.print("[]");
        }
    }

    private static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition) {
        if (pre.equals("extends ") && Arrays.equals(types, new Type[]{Object.class})) {
            return;
        }
        if (types.length > 0) {
            System.out.print(pre);
        }
        for (int i = 0; i < types.length; i++) {
            if (i > 0) {
                System.out.print(sep);
            }
            GenericRelfectionTest.printType(types[i], isDefinition);
        }
        if (types.length > 0) {
            System.out.print(suf);
        }
    }
}
