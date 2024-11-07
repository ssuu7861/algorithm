package valid_parentheses_20_20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

// hashmap 이용한 풀이
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "{}[]()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> table = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        for(char ch : s.toCharArray()){
            if(!table.containsKey(ch)) {
                stack.push(ch);
            } else if(stack.isEmpty() || table.get(ch) != stack.pop()) {
                return false;
            }
        }
        return stack.size() == 0;
    }
}
