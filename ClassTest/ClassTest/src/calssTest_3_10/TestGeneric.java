package calssTest_3_10;

import java.util.ArrayList;
import java.util.List;

/*
    通配符：
       <? extends E> 固定上界
            1. 生产者，只读
                因为如果操作的话，但无法确定传入对象是E的哪一个子类,故无法修改

       <? super E> 固定下届
            2. 消费者，只写
                如果获取对象的话，获取到的对象不一定当前类，可能是他的父类，向下转型有风险

       <?> 无限定
*/

public class TestGeneric {

    void test() {
        // 定义一个集合
        // List<Animal> animalList = new ArrayList<>();
        //animalList.add(new Animal());
        //animalList.add(new Tiger());    // 向上转型，合法的

        // 对上面的集合做一个改进，泛型，
        // 属于extends，只读，不可修改，生产者，固定上界(固定上界最高为Animal)
        List<? extends Animal> list = new ArrayList<>();
        //
        // list.add(new Tiger());  // 错误，因为上面要求继承Animal，但无法确定, 无法修改

        Animal a = list.get(0); // 可读


        // 属于super，固定下界，最低为Animal，或者为Animal的父类， 只能写，不能读
        List<? super Animal> list1 = new ArrayList<>();
        list1.add(new Tiger()); // 这里编译器，把Tiger向上转型为了Animal，所以是合法的
        // Animal a1 = list1.get(0);        // 获取到的对象不一定是Animal对象，可能是他的父类，向下转型有风险
    }

}


class Animal {

}

class Tiger extends Animal {
}

class Dog extends Animal {
}