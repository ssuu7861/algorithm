package remove_duplicate_letters_21_316;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "dbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }
    
    public static String removeDuplicateLetters(String s) {
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Boolean> check = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        char[] chArr = s.toCharArray();
        for(char c : chArr) count.put(c, count.getOrDefault(c, 0) + 1);

        for(char c : chArr) {
            
            count.put(c, count.get(c) - 1);
            
            if(check.get(c) != null && check.get(c) == true) continue;

            while (!stack.isEmpty() &&  stack.peek() > c && count.get(stack.peek()) > 0) {
                check.put(stack.pop(), false);
            }
            stack.push(c);
            check.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        
        return sb.toString();
    }
}
