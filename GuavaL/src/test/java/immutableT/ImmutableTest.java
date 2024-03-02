package immutableT;

import com.google.common.collect.*;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;

public class ImmutableTest {
    @Test
    public void t1(){
        ImmutableMap<String, String> imap = ImmutableMap.<String, String>builder().
                put("1k", "1v").
                put("2k","2v").
                build();
        ImmutableSetMultimap<String, String> multimap = imap.asMultimap();
        System.out.println(multimap);
    }
    @Test
    public void t2(){
        HashBiMap.create();
    }

    @Test
    public void t3(){
        MutableClassToInstanceMap<Object> imap = MutableClassToInstanceMap.create();
        imap.put(Integer.class,0);
        imap.put(Integer.class,2);
        System.out.println(imap.getInstance(Integer.class));

    }
}
