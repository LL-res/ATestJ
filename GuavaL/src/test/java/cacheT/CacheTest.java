package cacheT;

import com.google.common.base.Ticker;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.Weigher;
import org.junit.jupiter.api.Test;

public class CacheTest {
    @Test
    public void t1() {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .weigher(new Weigher<String, String>() {
                    @Override
                    public int weigh(String key, String value) {
                        if (key.startsWith("high")) {
                            return 2;
                        }
                        return 1;
                    }
                }).maximumWeight(2).ticker(new Ticker() {
                    @Override
                    public long read() {
                        return 0;
                    }
                }).
                build();
        cache.put("highKey", "highVal");
        cache.put("lowKey", "lowVal");
        cache.asMap().forEach((k,v)-> System.out.println(k+" : "+v));
    }
}
