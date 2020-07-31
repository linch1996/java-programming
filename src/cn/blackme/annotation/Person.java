package cn.blackme.annotation;

public interface Person {

    String name();

    int age();

    @Deprecated
    void say();
}
