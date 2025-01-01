package binary_search_70_704;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12, 15};
        int target = 9;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        //return recursionBinarySearch(nums, target, 0, nums.length - 1);
        return iterationBinarySearch(nums, target);
    }
    
    public static int recursionBinarySearch(int[] nums, int target, int left, int right) { // Recursion
        if(left <= right) {
            int mid = left + (right - left) / 2 ;
            if(nums[mid] < target) return recursionBinarySearch(nums, target, mid + 1, right);
            else if( nums[mid] > target) return recursionBinarySearch(nums, target, left, mid - 1);
            else return mid;
        }
        return -1;
    }

    public static int iterationBinarySearch(int[] nums, int target) { // Iteration
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target) right = mid - 1;
            else return mid; 
        }
        return -1;
    }
}
