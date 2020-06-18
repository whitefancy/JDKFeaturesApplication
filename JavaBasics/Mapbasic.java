package JavaBasics;

import java.util.*;
import java.util.function.BiFunction;

public class Mapbasic {
    public void test() {
        Map<Integer,Integer> map = new HashMap<>();// 这里不能用Collections.EMPTY_MAP 为什么？
        //java8
        map.put(1,1);
        map.compute(1,(key,value)->(Integer)value+100);
        // 只有元素确定存在，才可以使用compute

        map.computeIfAbsent(3,(key)->(Integer) key*100);
        // 如果元素存在，则使用计算结果的值 如果元素不存在，则新加入一个键值对
        // 此时value为空， 不能作为function的参数

        map.computeIfPresent(2,(key,value)->value>100?null:key+value);
        // 如果该key不存在，则什么也不做，
        // 存在，如果计算结果为空，则删除该entry 否则使用计算结果作为值

        map.remove(3);
        map.replace(2,4);// 如果该key不存在，返回null 什么也不做
        map.replace(2,3,88);

        map.put(23,34);
        map.replaceAll((key,value)->key<10?200:-1);// 对所有键值对做修改数据操作
        map = new HashMap<>();
        for(Map.Entry entry:map.entrySet()){
            entry.getKey();
            entry.getValue();
        }

        String s = map.toString();
        System.out.println(s);

        // LinkedHashMap
        LinkedHashMap map1 = new LinkedHashMap();
        // LinkedHashMap避免了给hashmap排序，又可避免TreeMap所增加的成本
        // 与linkedHashSet相似
        // Set 与 Map 关系： java先实现了Map， 然后令value 为null 实现了Set
        map1.putAll(map);
        //for each 遍历 java8
        map1.forEach((key,value)->System.out.println(key+"->"+value));

        // SortedSet接口 的实现类是TreeMap
        TreeMap map2 = new TreeMap();
        map2.putAll(map);
        map2.firstEntry();
        map2.firstKey();
        Map.Entry a =map2.pollFirstEntry();
        map2.lastEntry();
        Integer k =(Integer) map2.lastKey();
        map2.higherEntry(k);
        map2.lowerKey(k);
        map2.pollLastEntry();
        map2.subMap(1,5); // 等价于tailMap
        System.gc();// 通知系统立即进行垃圾回收

        // treeSet -> toArray -> binarySearch二分查找
        // hashSet和hashMap的负载极限为0.75，之后会rehashing，重新分配对象到新的的桶中
    }
}
