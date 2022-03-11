package calssTest_3_10;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {
    void function() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 利用单设调用Tiger2
        Tiger2 t = new Tiger2();
        // Class Class = t.getClass();  这种方法不好用
        // Class aClass = Tiger2.class;  有限制，需要在代码里写入 明确的类名才可以

        // 获取类型
        String className = "calssTest_3_10.Tiger2";
        Class<?> clazz = Class.forName(className);    // 最灵活。推荐这种方式
        // 通过反射的方式构建Tiger2对象
        Constructor<?> constructor = clazz.getConstructor();// 使用无参构造方法，传入一个空的数组
        Object o = constructor.newInstance();// 无参构造对象

        // 有参构造
        //
        constructor = clazz.getConstructor(String.class);
        o = constructor.newInstance(new Object[]{"big Tiger"});

        Method method = clazz.getMethod("eat", new Class<?>[]{String.class, int.class});
        String result = (String) method.invoke(o, new Object[]{"chick", 2});
        System.out.println(result);
    }
}



