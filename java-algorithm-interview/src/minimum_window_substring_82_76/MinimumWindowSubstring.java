package minimum_window_substring_82_76;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ABDOBECODEBANC" , t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return new String();

        int[] map = new int[122 - 65 + 1];
        for(char c : t.toCharArray()) map[c - 'A']++;
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE;
        int startIndex = 0, endIndex = 0;

        while (end < s.length()) {
            if(map[s.charAt(end++) - 'A']-- > 0) count--;
            while (count == 0) {
                if(end - start < minLen) {
                    startIndex = start;
                    endIndex = end;
                    minLen = end - start;
                }
                if(map[s.charAt(start++) - 'A']++ == 0) count++;
            }
        }
        return minLen == Integer.MAX_VALUE ? new String() : s.substring(startIndex, endIndex);
    }
}
