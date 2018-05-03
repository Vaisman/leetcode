package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution215 {

  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
    return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
  }

  public int findKthLargest(int[] nums, int start, int end, int k) { // quick select: kth smallest
    if (start > end) return Integer.MAX_VALUE;

    int pivot = nums[end]; // Take A[end] as the pivot,

    int left = start;

    for (int i = start; i < end; i++) {
      if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
      swap(nums, left++, i);
    }

    swap(nums, left, end); // Finally, swap A[end] with A[left]

    if (left == k) { // Found kth smallest number
      return nums[left];
    } else if (left < k) { // Check right part
      return findKthLargest(nums, left + 1, end, k);
    } else { // Check left part
      return findKthLargest(nums, start, left - 1, k);
    }
  }

  void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }

  @Test
  public void test() {
    assertEquals(findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2), 5);
  }
}


/*
    // Returns the k-th smallest element of list within left..right inclusive
    // (i.e. left <= k <= right).
    // The search space within the array is changing for each round - but the list
    // is still the same size. Thus, k does not need to be updated with each round.
    function select(list, left, right, k)
     if left = right        // If the list contains only one element,
             return list[left]  // return that element
             pivotIndex  := ...     // select a pivotIndex between left and right,
             // e.g., left + floor(rand() % (right - left + 1))
             pivotIndex  := partition(list, left, right, pivotIndex)
             // The pivot is in its final sorted position
             if k = pivotIndex
             return list[k]
             else if k < pivotIndex
         return select(list, left, pivotIndex - 1, k)
                 else
                 return select(list, pivotIndex + 1, right, k)
*/