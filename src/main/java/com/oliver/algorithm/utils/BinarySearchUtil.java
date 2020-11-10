package com.oliver.algorithm.utils;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/11/10
 * @since
 */
public class BinarySearchUtil {

  public static void main(String[] args) {
    System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 7));
  }

    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }

    private static int binarySearch(int[] nums,int start,int end,int target){
        if (start > end){
            return start;
        }
        int middle = (start + end) >> 1;
        if (nums[middle] == target){
            return middle;
        }else if(nums[middle] < target){
            return binarySearch(nums, middle + 1, end, target);
        }else {
            return binarySearch(nums, start, middle -1, target);
        }
    }
}
