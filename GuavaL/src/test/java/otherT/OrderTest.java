package otherT;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    public void t1(){
        Ordering<String> byLengthOrdering = new Ordering<>() {
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };

    }
}
