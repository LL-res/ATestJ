package collectionT;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapTest {
    @Test
    public void t1(){
        HashMap<Integer, Integer> targetMap = new HashMap<>();
        putValIntoMap(targetMap);
        targetMap.forEach((k,v)->{
            System.out.println(k+"+"+v);
        });
    }
    @Test
    public void t2(){
        HashMap<Integer, Integer> targetMap = new LinkedHashMap<>();
        putValIntoMap(targetMap);
        targetMap.forEach((k,v)->{
            System.out.println(k+"+"+v);
        });
    }

    private void putValIntoMap(HashMap<Integer,Integer> targetMap){
        targetMap.put(1,1);
        targetMap.put(2,3);
        targetMap.put(6,6);
        targetMap.put(4,5);
        targetMap.put(5,3);
    }
}
