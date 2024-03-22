package typeT;

import org.junit.jupiter.api.Test;

public class TypeTest {
    @Test
    public void t1(){
        //这个是用来获取环境变量的
        Integer integer = Integer.getInteger("0");
        System.out.println(integer);
    }
}
