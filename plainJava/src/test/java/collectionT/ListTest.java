package collectionT;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListTest {
    @Test
    public void t1() {
        ArrayList<String> collect = IntStream.rangeClosed(0, 10).mapToObj(i -> {
            char x = (char) (i + 'a');
            return Character.toString(x);
        }).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);

        List<String> collect1 = collect.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect1);
        List<String> collect2 = collect1.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(collect2);

    }
    @Test
    public void t2() {
        //sublist 与原来的list数据是同一份
        ArrayList<String> collect = IntStream.rangeClosed(0, 10).mapToObj(i -> {
            char x = (char) (i + 'a');
            return Character.toString(x);
        }).collect(Collectors.toCollection(ArrayList::new));
        List<String> strings = collect.subList(1, 3);
        System.out.println(strings);
        strings.add("newOne");
        System.out.println(strings);
        System.out.println("origin : " + collect);
        strings.remove(1);
        System.out.println(strings);
        System.out.println("origin : " + collect);
        //要使用一个新的ArrayList来套住才能分离关联
        ArrayList<String> strings1 = new ArrayList<>(strings);
        strings1.add("noEffect");
        System.out.println(strings1);
        System.out.println("origin : " + collect);
        //或者使用stream来创建一个不相关的list
        List<String> list = collect.stream().skip(1).limit(2).toList();
        System.out.println(list);
    }
    @Test
    public void t3() {
        List<Integer> originList = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toCollection(ArrayList::new));
        List<Integer> subList = originList.subList(1, 4);
        //操作原始list会导致原来的list与新生产出的sublist的modcount不同，导致抛出异常
        originList.add(999);
        subList.forEach(System.out::println);
    }
}
