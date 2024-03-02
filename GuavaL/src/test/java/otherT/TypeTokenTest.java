package otherT;

import com.google.common.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TypeTokenTest {
    @Test
    public void t1(){
        TypeToken<ArrayList<String>> typeToken = new TypeToken<>() {
        };
    }
}
