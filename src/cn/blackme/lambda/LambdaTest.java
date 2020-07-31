package cn.blackme.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("启动普通线程");
            }
        };
        test1();
        test2();
        test3();
        test4();
        test5();

        ArrayList<Integer> result = getNumList(10, () -> (int)(Math.random() * 100));
        System.out.println(result);

        // Function函数式接口
        String newStr = strHandler("abc", (str) -> str.toUpperCase());
        System.out.println(newStr);

        // Predicate 断言式接口
        List<String> list = Arrays.asList("Java", "Go", "R");
        List<String> res = filterStr(list, (str) -> str.length() > 2);
        System.out.println(res);
    }

    // 没有参数，没有返回值
    public static void test1() {
        // -> 左边只有（），表示没有参数，右边是Lambda体，相当于实现了匿名内部类里面的方法，就是一个可用的接口实现类
        Runnable runnable = () -> System.out.println("Lambda表达式方式启动线程");
        runnable.run();
    }

    // 一个参数，没有返回值，Consumer消费性接口： void accept(T t);
    public static  void test2() {
        // e代表所实现的接口的方法参数
        Consumer<String> consumer = e -> System.out.println("Lambda表达式方式：" + e);
        consumer.accept("传参");
    }

    // 两个参数以上，有返回值，Lambda体里面有多条语句
    public static void test3() {
        Comparator<Integer> comp = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
        int result = comp.compare(100, 244);
        System.out.println("两个参数， 有返回值：" + result);
    }

    // Lambda体中只有一条语句，return 和 大括号都可以省略不写
    public static void test4() {
        Comparator<Integer> comp1 = (x, y) -> Integer.compare(x, y);
        int result = comp1.compare(200, 100);
        System.out.println("省略：" + result);
    }

    /**
     * 方法引用与构造器引用
     * 有时候我们已经实现了Lambda体的功能，就可以通过方法引用来精简代码
     * 条件：
     * 1.方法引用所引用的方法的参数列表必须要和函数式接口中抽象方法的参数列表相同
     * 2.方法引用所引用的方法的返回值必须要和函数式接口中抽象方法的返回值相同
     * 引用格式：
     * 使用“::”将类与方法分隔开
     * 对象::实例方法名
     * 类::静态方法名
     * 类::实例方法名
     * 构造器引用的语法格式：
     * 类名::new
     * 传统lambda, Supplier<ClassName> supplier = () -> new ClassNmae();
     * 构造器引用, supplier = ClassName::new; Class class = supplier.get();
     */
    public static void test5() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println("compare:" + comparator.compare(1, 2));
        System.out.println("compare1:" + comparator1.compare(1, 2));
    }

    // Supplier供给型接口： T get();
    public static ArrayList<Integer> getNumList(int num, Supplier<Integer> sup) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer e = sup.get();
            list.add(e);
        }
        return list;
    }

    // Function函数式接口： R apply(T t);
    public static String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    // Predicate 断言式接口： boolean test(T t);
    public static List<String> filterStr(List<String> list, Predicate<String> pre) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str:list) {
            if (pre.test(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
