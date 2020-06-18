package javacore2.stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("test/test.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        Stream<String> words = Stream.of(contents.split("\\PL+"));
        show("words", words);

        Stream<String> song = Stream.of("saaa", "sdds", "dsdfs", "dsfe");
        show("song", song);

        Stream<String> silence = Stream.empty();
        show("silence", silence);

        Stream<String> echos = Stream.generate(() -> "Echo");
        show("echos", echos);

        Stream<Double> randoms = Stream.generate(Math::random);
        show("randoms", randoms);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        show("integers", integers);

        Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(contents);
        show("wordsAnotherWay", wordsAnotherWay);

        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            show("lines", lines);
        }

        /*
        filter 转换会产生一个流，它的元素与某种条件相匹配。它的引元是Predicate<T> ,即 从T到boolean的函数
         */
        Stream<String> longWords = Stream.of(contents.split("\\PL+")).filter(w -> w.length() > 12);
        /*
        map方法 按照某种方式转换流中的值
        使用带有方法引用的map
        或者 使用lambda表达式代替
         */
        Stream<String> lowercasrWords = Stream.of(contents.split("\\PL+")).map(String::toLowerCase);
        Stream<String> firstLetters = Stream.of(contents.split("\\PL+")).map(s -> s.substring(0, 1));
        show("firstLetters", firstLetters);
        /*
        map使用 返回一个包含众多值的流的函数
         */
        Stream<Stream<String>> result = Stream.of(contents.split("\\PL+")).map(w -> letters(w));
        show("result", result);
        /*
        如果想把这个流摊平，即接起来，用flatMap。背后的计算机科学通用概念，单子论
        即，首先应用变换f，然后应用变换g， g（f(G));
         */
        Stream<String> flatResult = Stream.of(contents.split("\\PL+")).flatMap(w -> letters(w));
        show("flatResult", flatResult);
        /*
        concat将两个流连接起来
         */
        Stream<String> combined = Stream.concat(letters("hello"), letters("world"));
        show("combined", combined);
        /*
        distinct()过滤流中的重复元素
         */
        Stream<String> uniqueWords = Stream.of("abc", "e", "abc", "s").distinct();
        show("uniqueWords", uniqueWords);

        /*
        流的排序， sorted方法
        调用Comparable或Comparator
         根据字符串长度，最长的排在前面
         */
        Stream<String> longestFirst = Stream.of(contents.split("\\PL+")).sorted(Comparator.comparing(String::length).reversed());
        show("longestFirst", longestFirst);
        /*
        peek 产生另一个流，可以调用函数，用于调试
        可以让peek调用一个你设置了断点的方法
         */
        Object[] powers = Stream.iterate(1.0, p -> p * 2).peek(e -> System.out.println("Fetching " + e)).limit(20).toArray();

    }

    private static Stream<String> letters(String w) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < w.length(); i++) {
            result.add(w.substring(i, i + 1));
        }
        return result.stream();
    }

    private static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        /*
        调用stream.limit(n)会返回一个新的流，在n个元素之后结束，或更短结束
        用于裁剪无限流的尺寸
        skip则跳过前n个元素
         */
        List<T> firstElements = stream.skip(1).limit(SIZE + 1).collect(Collectors.toList());
        System.out.println(title + ": ");
        for (int i = 0; i < firstElements.size(); i++) {
            if (i > 0) System.out.print(", ");
            if (i < SIZE) System.out.print(firstElements.get(i));
            else System.out.print("...");
        }
        System.out.println();
    }
}
