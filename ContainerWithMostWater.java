package com.company.programs;

public class ContainerWithMostWater {

  public int maxArea(int[] height) {

    int left = 0;
    int right = height.length -1;
    int max_area = Integer.MIN_VALUE;

    while(left < right) {
      int current_area = Math.min(height[left], height[right]) * (right - left );
      max_area = Math.max(max_area, current_area);

      if( height[left] < height[right]) left++;
      else right--;
    }
    return max_area;
  }
}
