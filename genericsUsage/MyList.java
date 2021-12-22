package JDKFeaturesApplication.genericsUsage;

import java.lang.reflect.Array;
import java.util.Arrays;
// 泛型使用练习，构造我的泛型数组列表类
public class MyList<E> {
    E[] list;
    int size;
    int capacity;
    Class<E> type;
    public MyList(int initialCapacity,Class<E> type){
        capacity=initialCapacity;
        this.type=type;
        list= (E[]) Array.newInstance(type,initialCapacity);
    }
    public void add(E elem){
        if(size>=capacity){
            expandList();
        }
        list[size]=elem;
        size++;
    }
    private void expandList() {
        capacity*=2;
        E[] list1=(E[]) Array.newInstance(type,capacity);
        for (int i = 0; i < size; i++) {
            list1[i]=list[i];
        }
        list=list1;
    }
    private int size(){
        return size;
    }
    private E indexOf(int i) throws Exception {
        if(i>=size){
            throw new Exception("out of range");
        }else {
            return list[i];
        }
    }
    @Override
    public String toString() {
        return "MyList{" +
                "list=" + Arrays.toString(list) +
                ", size=" + size +
                ", capacity=" + capacity +
                ", type=" + type +
                '}';
    }

    public static void main(String[] args) throws Exception {
        MyList<String> l=new MyList<>(3,String.class);
        l.add("I");
        l.add("love");
        l.add("honesty");
        System.out.println(l.size());
        System.out.println(l.indexOf(2));
        l.add("and");
        l.add("brave");
        System.out.println(l);
        System.out.println(l.indexOf(6));
    }
}
