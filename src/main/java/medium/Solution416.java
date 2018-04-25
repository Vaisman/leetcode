package medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Solution416 {
  public boolean canPartition(int[] nums) {
    int sum = 0;

    for (int num : nums) {
      sum += num;
    }

    if ((sum & 1) == 1) {
      return false;
    }

    sum /= 2;

    boolean[] dp = new boolean[sum + 1];
    Arrays.fill(dp, false);
    dp[0] = true;

    for (int num : nums) {
      for (int i = sum; i > 0; i--) {
        if (i >= num) {
          dp[i] = dp[i] || dp[i - num];
        }
      }
    }
    return dp[sum];
  }

    public boolean canPartition1(int[] nums) {
        if(nums==null || nums.length==0){
            return false;
        }

        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }

        if(sum%2!=0) return false;
        int[] dp=new int[sum/2];

        return doDp(sum/2,0,0,nums,dp);

    }

    public boolean doDp(int max,int cur, int index,int[] nums, int[] dp){
        if(cur>max || index >= nums.length){
            return false;
        }else if(cur == max){
            return true;
        }
        if(dp[cur] == 1){
            return true;
        }else if(dp[cur]==-1){
            return false;
        }
        boolean res = doDp(max, cur+nums[index],index+1,nums,dp) || doDp(max, cur,index+1,nums,dp);
        dp[cur] = res ? 1 : -1;
        return res;
    }

  @Test
  public void test() {
    assertEquals(canPartition(new int[] {1, 5, 11, 5}), true);
  }
}
