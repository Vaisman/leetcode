package hard;

public class Solution4 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len = nums1.length + nums2.length;
    if (len % 2 == 1) {
      return helper(nums1, 0, nums2, 0, len / 2 + 1);
    } else {
      return (helper(nums1, 0, nums2, 0, len / 2) + helper(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
    }
  }

  private double helper(int[] nums1, int start1, int[] nums2, int start2, int k) {
    if (start1 >= nums1.length) {
      return nums2[start2 + k - 1];
    }
    if (start2 >= nums2.length) {
      return nums1[start1 + k - 1];
    }
    if (k == 1) {
      return Math.min(nums1[start1], nums2[start2]);
    }
    int num1;
    int num2;
    int index1 = start1 + k / 2 - 1;
    int index2 = start2 + k / 2 - 1;
    if (index1 < nums1.length) {
      num1 = nums1[index1];
    } else {
      num1 = Integer.MAX_VALUE;
    }
    if (index2 < nums2.length) {
      num2 = nums2[index2];
    } else {
      num2 = Integer.MAX_VALUE;
    }
    if (num1 < num2) {
      return helper(nums1, start1 + k / 2, nums2, start2, k - k / 2);
    } else {
      return helper(nums1, start1, nums2, start2 + k / 2, k - k / 2);
    }
  }
}
