package valid_palindrome_1_125;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "Do geese see god?";
        System.err.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            } else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }else{
                if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
