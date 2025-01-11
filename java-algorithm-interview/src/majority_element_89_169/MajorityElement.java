package majority_element_89_169;

import java.util.Arrays;

/* Moore's Voting Algorithm : 과반수 이상의 원소를 찾는 알고리즘. TC : O(n), SC: O(1)
* 하지만 과반수 이상인 원소가 항상 존재한다는 보장이 없다면 결과값이 항상 과반수에 해당하는 원소라는 보장도 없다.
* 과반수 이상인 원소가 존재한다는 것을 보장할 때만 사용가능.
*/

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) { // Moore's Voting Algorithm
        int count = 0, result = 0;
        for(int num : nums) {
            if(count == 0) result = num;
            if(result == num) count++;
            else count--;
        }
        return result; // 과반수 이상의 원소가 없다면 아무값이나 나옴.
    }

    public static int majorityElement2(int[] nums) { // 과반수 이상의 원소가 존재한다는 보장이 있다면, 정렬 후 가운데를 지정하면 반드시 과반수 원소.
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
