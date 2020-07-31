package cn.blackme.annotation;

import java.lang.reflect.Method;

/**
 * 注解
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 概念：Java提供了一种原程序中的元素关联任何信息和任何元数据的途径和方法
 * JDK自带注解：
 * @Override 重写父类方法
 * @Deprecated 方法已过时
 * @Suppvisewarnings 忽略警告
 *
 * ------------------------------------------------------------------------------------------------
 * 注解的分类
 * 按照运行机制分：
 * 源码注解：注解只在源码中存在，编译成.class文件就不存在了
 * 编译时注解：注解在源码和.class文件中都存在，如上面三个注解
 * 运行时注解：在运行阶段还起作用，甚至会影响逻辑的注解(@Autowired)
 *
 * 按照来源分：
 * 来自JDK的注解：
 * 来自第三方的注解：
 * 我们自己定义的注解：
 *
 * 元注解
 * 给注解进行注解
 *
 * -------------------------------------------------------------------------------------------------
 * 自定义注解的语法
 * 下面四个注解是元注解
 * @Target({ElementType.METHOD, ElementType.TYPE}) // 注解的作用域，CONSTRUCTOR构造方法声明 FIELD字段声明 LOCAL_VARIABLE局部变量声明 METHOD方法声明 PACKAGE包声明 PARAMETER参数声明 TYPE类，接口
 * @Retention(RetentionPolicy.RUNTIME) // 生命周期，SOURCE只在源码显示，编译时会丢弃 CLASS编译时会记录到class中，运行时忽略 RUNTIME运行时存在，可以通过反射读取
 * @Inherited // 允许子类继承
 * @Documented // 生成javadoc时会包含注解的信息
 * public @interface Description { // 使用@interface关键字定义注解
 *
 *     // 成员的类型是受限的，合法的类型包括原始类型、String、Class、Annotation、Enumeration
 *     // 如果注解只有一个成员，则成员名必须取名为value(),在使用时可以忽略成员和赋值号(=)
 *     // 注解类可以没有成员，称为标识注解
 *     String desc(); // 成员以无参无异常方式声明
 *
 *     String author();
 *
 *     int age() default 18; // 用default为成员指定一个默认值
 *
 * }
 *
 * 使用注解的语法
 * @<注解名>(<成员名1>=<成员值1>,<成员名>=<成员值>,...)
 * @Description(desc="desc", author="linch", age=22)
 *
 * ---------------------------------------------------------------------------------------------------
 * 解析注解
 * 通过反射获取类、函数或成员上的运行时注解信息，从而实现动态控制程序运行的逻辑
 *
 * ---------------------------------------------------------------------------------------------------
 * 注解的继承
 * @Inherited只对类继承有效，对接口实现无效
 * 只会继承类上的注解不会继承方法上的注解
 *
 * ---------------------------------------------------------------------------------------------------
 * 简单实现类似Hibernate的注解，@table @Column 实现通过对象进行增删改查
 * 主要是通过反射获取类名，变量名，再反射调用get方法获取值，重要的是拼装sql
 *
 */
public class Annotation {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try {
            // 使用类加载器加载类
            Class c = Class.forName("cn.blackme.annotation.Child");
            // 找到类上面的注解
            boolean isExist = c.isAnnotationPresent(Description.class);
             if (isExist) {
                 // 获取注解实例
                 Description d = (Description) c.getAnnotation(Description.class);
                 System.out.println(d.value());
             }

             // 获取方法上的注解
             Method[] ms = c.getMethods();
             for (Method m : ms) {
                 boolean isMExist = m.isAnnotationPresent(Description.class);
                 if (isMExist) {
                     Description d= (Description) m.getAnnotation(Description.class);
                     System.out.println(d.value());
                 }
             }

             // 另一种解析方法
            for (Method m : ms) {
                java.lang.annotation.Annotation[] as = m.getAnnotations();
                for (java.lang.annotation.Annotation a : as) {
                    if (a instanceof Description) {
                        Description d = (Description)a;
                        System.out.println(d.value());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
