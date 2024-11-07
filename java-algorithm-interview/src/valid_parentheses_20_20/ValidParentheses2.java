package valid_parentheses_20_20;

import java.util.ArrayDeque;
import java.util.Deque;

// 일반적인 풀이
public class ValidParentheses2 {
    public static void main(String[] args) {
        String s = "{}[]()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if(stack.isEmpty()) {
                return false;
            } else {
                char pop = stack.pop();
                if((pop == '(' && ch != ')') || (pop == '{' && ch != '}') || (pop == '[' && ch != ']')) return false;
            }
        }
        return stack.isEmpty();
    }
}
