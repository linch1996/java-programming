package cn.blackme.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class类：任何一个类都是java.lang.Class类的实例对象，这个对象我们称为该类的类类型，这个实例有三种表示方式
 * Class c1 = ClassName.class; // 任何一个类都有一个隐含的静态成员变量class，c1是ClassName类的类类型
 * Class c2 = ClassName.getClass(); // 知道类的对象通过getClass方法获取,
 * Class c3 = null; c3 = Class.ForName("com.ClassName")
 *
 * 通过类的类类型创建该类的对象实例，通过c1创建ClassName的实例
 * (ClassName) c1.newInstance(); // 前提是要有无参数的构造方法，需要调用无参数的构造方法
 *
 * ------------------------------------------------------------------------------------------------------------
 * 动态加载类
 * Class.forName("类的全称") 不仅表示类的类类型，还表示了动态加载类
 * 编译时刻加载类是静态加载类，运行时刻加载类是动态加载类
 * new 创建对象是静态加载类，有编译时刻就需要加载所有的可能使用到的类，类不存在会报错。
 * Class c = Class.forName(args[0]); c.newInstance();
 * 功能性的类使用动态加载
 *
 * ------------------------------------------------------------------------------------------------------------
 * 基本数据类型都存在类类型(void, int)
 * Object.class getClass()是native声明的方法
 *
 * ------------------------------------------------------------------------------------------------------------
 * 方法的反射
 * 知道方法的名称和方法的参数列表才能唯一决定某个方法
 * 反射操作： method.invoke(对象， 参数列表)
 *
 * ------------------------------------------------------------------------------------------------------------
 * 泛型的本质
 * 反射的操作都是编译之后的操作
 * Java中集合的泛型，是防止错误输入的，只在编译阶段有效，绕过编译就无效了
 *
 */
public class Reflect {

    public static void main(String[] args) {

        Class c1 = int.class;
        Class c2 = String.class;

        System.out.println("类的名称：" + c2.getName() + " " + c2.getSimpleName());

        // getMethods()获取类的方法，所有的public函数，包括父类继承的
        // getDeclaredMethods()获取的是所有该类声明的方法
        Method[] methods = c2.getMethods();

        for (Method method : methods) {
            // 方法返回值类型的类类型
            Class returnType = method.getReturnType();
            // 方法的名称
            String methodName = method.getName();
            // 获取参数类型
            Class[] paramTypes = method.getParameterTypes();
            for (Class param : paramTypes) {
                String paramName = param.getName();
            }
        }

        /**
         * 成员变量
         * java.lang.reflect.Field类封装了关于成员变量的操作
         * getFields()方法获取的是所有public的成员变量的信息
         * getDeclaredFields()方法获取是是该类自己声明的成员变量的信息
         */
        // Field[] fs = c1.getFields();
        Field[] fs = c1.getDeclaredFields();
        for (Field field : fs) {
            // 成员变量的类型的类类型
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            // 成员变量的名称
            String fieldName = field.getName();

        }

        /**
         * 获取对象的构造函数的信息
         */
        // Constructor[] cs = c1.getConstructors();
        Constructor[] cs = c1.getDeclaredConstructors();
        for (Constructor constructor : cs) {
            constructor.getName();
            // 获取构造函数的参数列表的类类型
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class c : paramTypes) {
                c.getName();
            }
        }

        // 获取类C的print方法，先获取类类型
        C c = new C();
        Class cc = c.getClass();
        // 获取方法 根据方法名和参数列表
        try {
            // Method m = cc.getMethod("print", new Class[]{int.class, int.class});
            Method m = cc.getMethod("print", int.class, int.class);
            // 方法的反射操作,根c.print()调用效果一样，如果没有返回值返回null
            // Object o = m.invoke(c, new Object[]{1, 2});
            Object o = m.invoke(c, 1, 2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        List<String> list = new ArrayList<>();
        list.add("String");
        Class listClass = list.getClass();
        try {
            Method m = listClass.getMethod("add", Object.class);
            m.invoke(list, 100); // 可以add int 类型数据，无法foreach循环
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}

class C {

    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + " " + b.toLowerCase());
    }

}
