package longest_substring_without_repeating_characters_32_3;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbbc";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> check = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;
        for(char ch : s.toCharArray()) {
            if(check.containsKey(ch) && check.get(ch) >= left) {
                left = check.get(ch) + 1;
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            check.put(ch, right);
            right++;
        }
        return maxLength;
    }
}
