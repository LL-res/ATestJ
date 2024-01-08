package optionT;

import org.junit.jupiter.api.Test;
import pojo.User;

import java.util.Optional;

public class OptionTest {
    @Test
    public void t1(){
        User user1 = User.builder().name("user1").build();
        t1Internal(user1);
        User user2 = User.builder().name("user2").age(19).build();
        t1Internal(user2);
    }
    private void t1Internal(User user){
        Optional.ofNullable(user).map(User::getAge).filter(a->a>18).ifPresentOrElse(System.out::println,()->{
            System.out.println("no user found");
        });
    }
    @Test
    public void t2(){
        //t2Internal(null);
        User i = User.builder().age(1).name("I").build();
        t2Internal(i);
    }
    private void t2Internal(User user){
        //此处注意有坑，orElse无论如何都会被执行
        User user1 = Optional.ofNullable(user).orElse(new User());
        System.out.println(user1);
        System.out.println("======================");
        User user2 = Optional.ofNullable(user).orElseGet(User::new);
        System.out.println(user2);
    }
}
