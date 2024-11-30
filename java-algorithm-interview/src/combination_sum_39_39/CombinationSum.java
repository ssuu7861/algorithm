package combination_sum_39_39;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5, 8};
        int target = 8;
        for(List<Integer> list : combinationSum(candidates, target)) System.out.println(list);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void dfs(int[] candidates, int target, int start, List<Integer> currentList, List<List<Integer>> result) {

        if(target < 0) return;
        
        if(target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        } 

        for(int i = start; i < candidates.length; i++) {
            int tmp = candidates[i];
            currentList.add(tmp);
            dfs(candidates, target - tmp, i, currentList, result);
            currentList.remove(currentList.size() - 1);
        }
    }
}
