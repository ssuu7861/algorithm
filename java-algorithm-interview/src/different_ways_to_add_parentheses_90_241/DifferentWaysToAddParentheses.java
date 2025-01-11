package different_ways_to_add_parentheses_90_241;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        String expression = "2*3-4*5";
        System.out.println(diffWaysToCompute(expression));
    }

    static Map<String, List<Integer>> memoization = new HashMap<>();
    public static List<Integer> diffWaysToCompute(String expression) {
        if(memoization.containsKey(expression)) return memoization.get(expression);

        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i < expression.length() ; i++) {
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i)); // 해당 operator 제외
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));// 해당 operator 제외
            
                for(int l : left) {
                    for (int r : right) {
                        if(c == '+') result.add(l + r);
                        else if(c == '-') result.add(l - r);
                        else if(c == '*') result.add(l * r);
                    }
                }
            }
        }
        if(result.isEmpty()) result.add(Integer.parseInt(expression));
        memoization.put(expression, result);
        return result;
    }
}
