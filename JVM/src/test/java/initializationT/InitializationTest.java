package initializationT;

import initializationP.Pojo1;
import org.junit.jupiter.api.Test;

public class InitializationTest {
    @Test
    public void t1(){
        Pojo1 pojo1 = new Pojo1();
    }
    @Test
    public void t2() throws ClassNotFoundException {
        Class<?> aClass = Class.forName(Pojo1.class.getName());
    }
    @Test
    public void t3() throws ClassNotFoundException {
        Class<?> aClass = Class.forName(Pojo1.class.getName(), false, Pojo1.class.getClassLoader());
        Class<Pojo1> aClass1 = (Class<Pojo1>) aClass;
        System.out.println(Pojo1.staticObject);
    }
    @Test
    public void t4() throws ClassNotFoundException {
        System.out.println(Pojo1.staticFinalNative);
    }
    @Test
    public void t5() throws ClassNotFoundException {
        System.out.println(Pojo1.staticFinalObject);
    }
}
