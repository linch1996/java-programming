package cn.blackme.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("张三丰");
        list.add("李肆");
        list.add("王开");

        // Collection体系可以通过strem()方法生成流，过滤张开头且名字长度为3的姓名
        // list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> System.out.println(s));
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);

        Stream<String> stream = list.stream();

        // Map体系间接生成流
        Map<String, Integer> map = new HashMap<>();
        Stream<String> keyStrema = map.keySet().stream();
        Stream<Integer> valueStrem = map.values().stream();
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();

        // 数组可以通过Stream接口的静态方法of (T... values)生成流
        String[] array = {"test", "stream"};
        Stream<String> strArrayStream = Stream.of(array);
        Stream<String> strArrayStream2 = Stream.of("array", "array");
        Stream<Integer> integerStream = Stream.of(1, 2, 3);

        System.out.println("-------------------");

        // limit, skip
        // 输出前三个
        list.stream().limit(3).forEach(System.out::println);
        // 跳过三个元素
        list.stream().skip(3).forEach(System.out::println);
        // 跳过两个元素后输出前两个
        list.stream().skip(2).limit(2).forEach(System.out::println);

        System.out.println("--------------------");

        // concat distinct
        Stream<String> s1 = list.stream().limit(4);
        Stream<String> s2 = list.stream().skip(2);
        // 合并两个流
        // Stream.concat(s1, s2).forEach(System.out::println);
        // 去重
        Stream.concat(s1, s2).distinct().forEach(System.out::println);

        System.out.println("-------------------");
        // sorted
        list.stream().sorted().forEach(System.out::println);
        // 按字符串长度
        // list.stream().sorted((str1, str2) ->str1.length() - str2.length()).forEach(System.out::println);
        list.stream().sorted((str1, str2) -> {
            int num = str1.length() - str2.length();
            int num2 = num == 0 ? str1.compareTo(str2) : num;
            return num2;
        }).forEach(System.out::println);

        System.out.println("---------------------");

        List<String> intList = new ArrayList<>();
        intList.add("10");
        intList.add("20");
        intList.add("30");
        intList.add("40");
        intList.add("50");

        // map, mapToInt
        intList.stream().map(s -> Integer.parseInt(s)).forEach(System.out::println);
        intList.stream().mapToInt(Integer::parseInt).forEach(System.out::println);
        int res = intList.stream().mapToInt(Integer::parseInt).sum();
        System.out.println(res);

        System.out.println("---------------------");
        // count
        // 统计姓张的人数并输出
        System.out.println(list.stream().filter(s -> s.startsWith("张")).count());;

    }

}
