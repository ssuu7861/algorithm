package longest_palindrome_substring_6_5;
// brute force, dp, sliding window, manacher's algorithm

public class LongestPalindromeSubstring {

    public static int left, max;
    public static void main(String[] args) {
        String s = "addcbabcdd";
        System.out.println(longestPalindrome(s));
    }

    public static void extendPalindrome(String s, int j, int k){
        
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        if(max < k - j - 1){
            left = j + 1;
            max = k - j - 1;
        }
    }

    public static String longestPalindrome(String s){
        
        int length = s.length();
        if(length < 2) return s;

        for(int i = 0 ; i < length - 1 ; i++){
            extendPalindrome(s, i, i + 1);
            extendPalindrome(s, i, i + 2);
        }
        
        // substring : first parameter ~ last parameter - 1
        return s.substring(left, left + max);
    }
}
