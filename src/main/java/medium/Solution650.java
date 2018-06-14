package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution650 {
    public int minSteps(int n) {
        int[] dp = new int[n];
        dp [0] = 0; // solve(1) = 0
        for (int i = 1; i < n; i++){
            int f = highestPrimeFactor(i+1);
            dp[i] = dp[f-1] + (i + 1) / f;
        }
        return dp[n-1];
    }

    int highestPrimeFactor(int n){
        for (int i = n/2; i >=1 ; i--){
            if (n % i == 0) return i;
        }
        return 1;
    }

    @Test
    public void test() {
        assertEquals(minSteps(3), 3);
    }
}
