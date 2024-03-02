package stringT;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.assertj.core.util.Lists;
import org.checkerframework.framework.qual.Covariant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringTest {
    @Test
    public void t1(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add(null);
        strings.add("5");
        Joiner joiner = Joiner.on("-").skipNulls();
        System.out.println(joiner.join(strings));
    }
    @Test
    public void t2(){
        Iterable<String> split = Splitter.on(',')
                .trimResults()//把每个元素前后的空格去掉
                .omitEmptyStrings()//去掉只有空格的字符串
                .split("foo,bar,,   qu x  ");
        ArrayList<String> strings = Lists.newArrayList(split);
        System.out.println(strings);
    }
    @Test
    public void t3(){
        List<String> strings = Splitter.on(CharMatcher.anyOf(",./?"))
                .splitToList("1,2?3./4");
        System.out.println(strings);
    }
    @Test
    public void t4(){
        List<String> strings = Splitter.on(CharMatcher.forPredicate(Character::isDigit))
                .splitToList("1,2?3./4");
        strings.forEach(System.out::println);
    }

}
