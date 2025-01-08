package longest_repeating_character_replacement_83_424;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int[] map = new int[26];
        char[] input = s.toCharArray();
        int left = 0, right = 0, result = 0, maxFreq = 0;

        while (right < input.length) {
            maxFreq = Math.max(maxFreq, ++map[input[right++] - 'A']);
            while (right - left - maxFreq > k) map[input[left++] - 'A']--;

            result = Math.max(result, right - left);
        }
        return result;
    }
}
