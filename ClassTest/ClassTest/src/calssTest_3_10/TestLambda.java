package calssTest_3_10;


import java.util.ArrayList;
import java.util.List;

/*
    Lambda表达式：一种函数式接口的实现对象
        – 函数式接口
            - 仅含一个【抽象】方法
            – 本质上是一个接口的匿名实现类的方法函数
    语法：
        1. (参数列表)->expression
        2. (参数列表)->{statements;}
    举例
        - () -> 5 无参
        - (x) -> 2 * x;  有一个参数
        - (x, y) -> x - y   有两个参数


**/
public class TestLambda {
    // 以前的做法
//    void testInterface() {
//        // 匿名类实现animal接口
//        Animal2 tiger = new Animal2() {
//            @Override
//            public void eat() {
//                System.out.println("老虎吃肉");
//            }
//        };
//    }

    // lambda 方式
    void testLambda() {
        // 因为几口只有一个方法，所以lambda表达式实现的一定是接口的方法
//        Animal2 animal2 = () -> System.out.println("老虎吃肉");

//        f(() -> System.out.println("这里实现的是f函数的 animal2.eat()方法"));

        f((a, b) -> {
            double x;
            return "老虎吃：" + b + "份" + a;
        });
    }

    void f(Animal2 animal2) {
        System.out.println("开饭了");
        animal2.eat("鸡", 2);
    }


    void testLambda3() {
        // 泛型 + lambda表达式
        List<Animal2> list = new ArrayList<>();
        list.add(new Tiger2());
        list.add(new Tiger2());
        // 遍历这个list
        list.forEach(animal2 -> System.out.println(animal2));

    }
}



/*
    这就是一个函数式接口
        有且只有一个抽象方法
        最好加上注解: @FunctionalInterface
*/
@FunctionalInterface
interface Animal2 {
    String eat(String food, int i);
}



class Tiger2 implements Animal2 {
    String name;

    public Tiger2() {
    }

    public Tiger2(String name) {
        this.name = name;
    }


    @Override
    public String eat(String food, int i) {
        int x = 0;
        i = i + x;
        return "老虎吃" + i + "份" + food;
    }

}
