package javacore2.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Optional<T>被当做一种更加安全的方式，来替代对<T>的引用
 */
public class OptionalTest {
    public static void main(String[] args) throws IOException {
          /*
        ofNullable方法被用来作为可能出现的null值和可选值之间的桥梁
         */
        String contents = new String(Files.readAllBytes(
                Paths.get("test/test.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

        Optional<String> optionalValue = wordList.stream()
                .filter(s -> s.contains("fred"))
                .findFirst();
        System.out.println(optionalValue.orElse("No word") + " contains fred");
        Optional<String> optionalS = Optional.empty();
        String result = optionalS.orElse("otherString");
        String res1 = optionalS.orElseGet(() -> Locale.getDefault().getDisplayName());//中文 (中国)

        String res2 = optionalS.orElseThrow(IllegalAccessError::new);
        System.out.println(res1);
        Optional<String> optionalValue1 = wordList.stream()
                .filter(s -> s.contains("fred"))
                .findFirst();
        /*
        收集结果
         */
        wordList.stream().forEach(System.out::println);
        wordList.stream().toArray();//Object[]
        wordList.stream().toArray(String[]::new);//String[]
        wordList.stream().collect(Collectors.toList());
        wordList.stream().collect(Collectors.toSet());//Set<String>
        wordList.stream().collect(Collectors.toCollection(TreeSet::new));//TreeSet
        //全部连接起来
        wordList.stream().collect(Collectors.joining());
        //增加分隔符
        wordList.stream().collect(Collectors.joining(","));
        //约简为统计结果
        IntSummaryStatistics summaryStatistics = wordList.stream().collect(Collectors.summarizingInt(String::length));
        double avg = summaryStatistics.getAverage();
        double max = summaryStatistics.getMax();
        //收集到映射表中
        Map<Integer, String> idToName = wordList.stream().collect(Collectors.toMap(String::length, String::toString));
        //当有重复元素，收集器会爆出异常 增加处理机制, 只保留第一次出现的值
        idToName = wordList.stream().collect(Collectors.toMap(String::length, String::toString, (existingValuew, newValuew) -> existingValuew));
    }
}
