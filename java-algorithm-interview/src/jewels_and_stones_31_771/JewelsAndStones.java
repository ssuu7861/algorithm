package jewels_and_stones_31_771;

import java.util.HashSet;

public class JewelsAndStones {

    public static void main(String[] args) {
        String jewels = "aA";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, S));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(char ch : jewels.toCharArray()) set.add(ch);
        for(char ch : stones.toCharArray()) if(set.contains(ch)) count++;
        return count;
    }
}
