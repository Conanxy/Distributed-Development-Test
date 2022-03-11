package calssTest_3_10;

import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        new TestLambda().testLambda();

        new TestReflection().function();
    }
}
