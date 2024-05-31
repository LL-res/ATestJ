package streamT;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    public void t1(){
        Map<? extends Class<? extends Serializable>, Object> imap = Stream.of(int.class, boolean.class, float.class).collect(Collectors.toMap(
                clazz -> clazz,
                //获取了所有类对应的默认值
                clazz -> Array.get(Array.newInstance(clazz, 1), 0)));
        System.out.println(imap);
    }
}
