package memoryLeakP;

import java.util.ArrayList;
import java.util.List;

public class Leak1 {
    public List<String> makeList(){
        ArrayList<String> strList = new ArrayList<>(){
            {
                add("1");
                add("2");
            }
        };
        return strList;
    }

    public static void main(String[] args) {
        Leak1 leak1 = new Leak1();
        leak1.makeList();
    }
}
