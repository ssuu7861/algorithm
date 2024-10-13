package valid_palindrome_1_125;

public class ValidPalindrome2 {
    
    public static void main(String[] args) {
        String s = "Do geese see God?";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
        String filtered = s.replaceAll("[^A-z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(filtered).reverse().toString();

        return filtered.equals(reversed);
    }
}
