package arrayT;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayTest {
    @Test
    public void t1() {
        int[][] ints = new int[3][3];
        System.out.println(Arrays.deepToString(ints));

    }

    @Test
    public void t2() {
        int[][] array = IntStream.range(0, 3)
                .mapToObj(row -> IntStream.range(0, 3)
                        .map(col -> row * 3 + col)
                        .toArray())
                .toArray(int[][]::new);

    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
                dp[i] = Math.max(dp[i], j * (i - j));
            }
        }
        return dp[n];
    }

    @Test
    public void t3() {
        System.out.println(integerBreak(10));
    }
}
