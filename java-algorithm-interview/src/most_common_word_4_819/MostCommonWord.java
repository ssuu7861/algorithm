package most_common_word_4_819;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
    }

    public static String mostCommonWord(String p, String[] banned){
        Set<String> banList = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordMap = new HashMap<>();
        String[] words = p.replaceAll("[^A-z]+", " ").toLowerCase().split(" ");
        for(String s : words){
            if(!banList.contains(s))
                wordMap.put(s, wordMap.getOrDefault(s, 0) + 1);
        }
        return Collections.max(wordMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
