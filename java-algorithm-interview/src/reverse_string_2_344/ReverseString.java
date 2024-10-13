package reverse_string_2_344;

public class ReverseString {
    public static void main(String[] args) {
        char[] chArr = {'r', 'a', 'c', 'e', 'c', 'a', 'r'};
        System.out.println(chArr);
    }

    public static void reverseString(char[] s){
        int start = 0;
        int end = s.length - 1;
        char temp = ' ';

        while(start < end){
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}
