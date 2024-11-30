import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        for(List<Integer> list : permute(nums)) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> currentPermutation = new ArrayList<>();

        dfs(nums, currentPermutation, visited, result);


        return result;
    }

    public static void dfs(int[] nums, List<Integer> currentPermutation, boolean[] visited, List<List<Integer>> result) {

        if(currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                currentPermutation.add(nums[i]);
                dfs(nums, currentPermutation, visited, result);

                currentPermutation.remove(currentPermutation.size() - 1);
                visited[i] = false;
            }
        }
    }
}
