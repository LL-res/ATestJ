package optionT;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionTest {
    @Test
    public void t1() {
        User user1 = User.builder().name("user1").build();
        t1Internal(user1);
        User user2 = User.builder().name("user2").age(19).build();
        t1Internal(user2);
    }

    private void t1Internal(User user) {
        Optional.ofNullable(user).map(User::getAge).filter(a -> a > 18).ifPresentOrElse(System.out::println, () -> {
            System.out.println("no user found");
        });
    }

    @Test
    public void t2() {
        //t2Internal(null);
        User i = User.builder().age(1).name("I").build();
        t2Internal(i);
    }

    private void t2Internal(User user) {
        //此处注意有坑，orElse无论如何都会被执行
        User user1 = Optional.ofNullable(user).orElse(new User());
        System.out.println(user1);
        System.out.println("======================");
        User user2 = Optional.ofNullable(user).orElseGet(User::new);
        System.out.println(user2);
    }

    @ParameterizedTest
    @MethodSource("generateOpPOJO")
    public void t3(POJOWithOptionalField pojo) throws JsonProcessingException {
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(new Jdk8Module());
        String s = jsonMapper.writeValueAsString(pojo);
        System.out.println(s);
        POJOWithOptionalField p = jsonMapper.readValue(s, POJOWithOptionalField.class);
    }
    @ParameterizedTest
    @MethodSource("generateOpPOJOJson")
    public void t4(String pojoJson) throws JsonProcessingException {
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(new Jdk8Module());
        POJOWithOptionalField p = jsonMapper.readValue(pojoJson, POJOWithOptionalField.class);
        System.out.println(p);
        System.out.println(p.getOp1() == null);
    }
    //使用Optional作为DTO字段的好处在于能完美的区分出下面这三种情况
    //当json字符串中不包含该字段时，那optional自身本身就为空，可以断定出传值方对该字段完全没有兴趣，不用动该字段
    //而当optional不为空，但其中包含的值为空时，那么就可以判断出，传值方对这个字段是有兴趣的，要把这个字段设置为空
    //正常情况就是optional不为null，且里面包含的值与不为null
    public static List<String>generateOpPOJOJson(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("{\"op1\":\"p1\"}");
        strings.add("{\"op1\":null}");
        strings.add("{}");
        return strings;
    }

    public static List<POJOWithOptionalField> generateOpPOJO() {
        ArrayList<POJOWithOptionalField> list = new ArrayList<>();
        POJOWithOptionalField p1 = new POJOWithOptionalField();
        p1.setOp1(Optional.of("p1"));
        list.add(p1);
        list.add(null);
        list.add(new POJOWithOptionalField());
        return list;
    }

}
