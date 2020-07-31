package cn.blackme.annotation;

@Description("class annoation")
public class Child implements Person {

    @Override
    @Description("method annotaion")
    public String name() {
        return null;
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void say() {

    }

}
