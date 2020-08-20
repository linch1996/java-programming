package cn.blackme.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("张三丰");
        list.add("李肆");
        list.add("王开");

        List<String> names = list.stream().filter(s -> s.length() == 3).collect(Collectors.toList());
        for (String name : names) {
            System.out.println(name);
        }

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        Set<Integer> nums = set.stream().filter(num -> num > 3).collect(Collectors.toSet());

        for (Integer num : nums) {
            System.out.println(num);
        }

        String[] array = {"张三，1", "李四，2", "王五，3"};
        Stream<String> stream = Stream.of(array).filter((s -> Integer.parseInt(s.split("，")[1]) > 1));

        // 收集到map中
        Map<String, Integer> map = stream.collect(Collectors.toMap(s -> s.split("，")[0], s -> Integer.parseInt(s.split("，")[1])));
        Set<String> strSet = map.keySet();
        for (String str : strSet) {
            System.out.println(map.get(str));
        }
    }

}
