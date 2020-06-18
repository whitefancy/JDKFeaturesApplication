package javacore2.stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 约简是一种终结操作 terminal operation
 */
public class Terminal {
    public static void main(String[] args) {
        //获得流中的最小值
        Optional<String> minest = Stream.of("dfadsfad", "dfs").min(String::compareToIgnoreCase);
        /*
        获得第一个以q开头的单词
        如果不是findfirst，而是findAny，可以用并行流处理，更加高效
         */
        Optional<String> Qstart = Stream.of("dfadsfad", "dfs").filter(s -> s.startsWith("Q")).findAny();
        Optional<String> Qstart1 = Stream.of("dfadsfad", "dfs").parallel().filter(s -> s.startsWith("Q")).findAny();
        boolean isExistQstart = Stream.of("dfadsfad", "dfs").parallel().anyMatch(s -> s.startsWith("Q"));

    }
}
