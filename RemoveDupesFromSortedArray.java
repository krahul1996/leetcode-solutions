package com.company.programs;

public class RemoveDupesFromSortedArray {

    private static int run(int[] nums) {
        int i = 0, j = 1;
        while(j <= nums.length-1){
            if(nums[i] == nums[j] ) {
                nums[j] = -101;
                j++;
            }
            else if(nums[i] != nums[j]) {
                i = j;
                j = i+1;
            }
        }

        i = 1;
        int k = -1;
        while(i <= nums.length-1) {
            if(nums[i] == -101) {
                k = i;
                break;
            }
            i++;
        }
        //sorted array
        if(k == -1)  {
            return nums.length;
        } else {
            j = k + 1;
            while( j <= nums.length-1 ) {
                if(nums[j] != -101 ) {
                    nums[k] = nums[j];
                    k++;
                }
                j++;
            }
            return k;
        }
    }
}
