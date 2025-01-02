import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4, 6};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) { // 한쪽을 Sorting, 한쪽을 Binary search
        Set<Integer> result = new HashSet<>();
        Arrays.sort(nums2);
        for(int n1 : nums1) if(Arrays.binarySearch(nums2, n1) >= 0) result.add(n1);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] > nums2[j]) j++;
            else if(nums1[i] < nums2[j]) i++;
            else {
                result.add(nums1[i]);
                i++;
                j++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
