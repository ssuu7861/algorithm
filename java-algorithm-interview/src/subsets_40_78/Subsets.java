package subsets_40_78;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        for(List<Integer> list : subsets(nums)) System.out.println(list);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new ArrayList<>(), 0, result);
        return result;
    }

    public static void dfs(int[] nums, List<Integer> currentList, int start, List<List<Integer>> result) {
        result.add(new ArrayList<>(currentList));
        for(int i = start; i < nums.length; i++) {
            currentList.add(nums[i]);
            dfs(nums, currentList, i + 1, result);
            currentList.remove(currentList.size() - 1);
        }
    }
}
