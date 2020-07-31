package cn.blackme.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambda {

    public static void main(String[] args) {
        // lambda表达式对集合进行迭代
        List<String> list = Arrays.asList("java", "python", "golang");
        list.forEach(x -> System.out.println("lambda, " + x));

        // lambaa表达式实现map
        List<Double> list1 = Arrays.asList(10.0, 20.0, 30.0);
        list1.stream().map(x -> x + x * 0.05).forEach(x -> System.out.println(x));

        // lambda表达式实现map和reduce
        // java8 之前
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
        double sum = 0;
        for (double each : cost) {
            each += each * 0.05;
            sum += each;
        }
        System.out.println("before java8: " + sum);
        // java8 之后
        List<Double> list2 = Arrays.asList(10.0, 20.0, 30.0);
        double sum2 = list2.stream().map(x -> x + x * 0.05).reduce((sum1, x) -> sum1 + x).get();
        System.out.println("after java8: " + sum2);

        // lambda表达式实现filter
        List<Double> list3 = Arrays.asList(10.0, 20.0, 30.0, 40.0);
        List<Double> filteredList3  = list3.stream().filter(x -> x > 25.0).collect(Collectors.toList());
        filteredList3.forEach(x -> System.out.println(x));

        // 与函数式接口Predicate配合，可以向API方法添加逻辑，用更少的代码支持更多的动态行为，非常适用于过滤
        List<String> languages = Arrays.asList("Java", "Python", "Golang", "Shell", "PHP", "Scala");
        filterTest(languages, x -> x.startsWith("J"));
        filterTest(languages, x -> x.endsWith("a"));
        filterTest(languages, x -> true);
        filterTest(languages, x -> false);
        filterTest(languages, x -> x.length() > 4);
    }

    public static void filterTest(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(x -> condition.test(x)).forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

}
