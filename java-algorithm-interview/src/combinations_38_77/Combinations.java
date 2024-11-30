package combinations_38_77;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        for(List<Integer> list : combine(n, k)) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), result);
        return result;
    }

    public static void dfs(int start, int n, int k, List<Integer> currentCombination, List<List<Integer>> result) {

        if(currentCombination.size() == k) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for(int i = start ; i <= n ; i++) {
            currentCombination.add(i);
            dfs(i + 1, n, k, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}