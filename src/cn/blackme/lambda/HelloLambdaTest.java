package cn.blackme.lambda;

public class HelloLambdaTest {

    public static void main(String[] args) {
        // 不使用Lambda表达式,使用匿名类
        HelloLambda helloLambda = new HelloLambda() {
            @Override
            public void sayHello() {
                System.out.println("Hello Lambda");
            }
        };
        helloLambda.sayHello();

        // 使用Lambda表达式实现HelloLambda接口
        HelloLambda helloLambda1 = () -> {
            System.out.println("Hello Lambda");
        };
        helloLambda1.sayHello();
    }

}
