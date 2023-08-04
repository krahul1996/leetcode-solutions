package com.company.programs;

public class SearchInRotatedSortedArray {

  public int search(int[] nums, int target) {
    int pivot = findPivot(0, nums.length -1, nums );
    if(pivot == -1) pivot = nums.length-1;

    int lResult = binarySearch(0, pivot, nums, target);

    if( lResult != -1) return lResult;

    int rResult = binarySearch(pivot + 1, nums.length-1, nums, target);

    if( rResult != -1) return rResult;

    return -1;
  }
  
  public int binarySearch(int left, int right, int [] nums, int target) {

    while (left <= right) {
      int mid = (left + right) / 2;

      if( nums[mid] == target) return mid;
      else if( nums[mid] > target) right = mid -1;
      else left = mid+1;
    }
    return -1;
  }

  public int findPivot(int left, int right, int[] nums) {

    if( left == right) return -1;

    int mid = (left + right) / 2;

    if( nums[mid] > nums[mid+1]) return mid;

    int lResult = findPivot(left, mid, nums);
    if( lResult != -1) return lResult;

    int rResult = findPivot(mid+1, right, nums);
    if( rResult != -1) return rResult;

    return -1;
  }
}
