package group_anagrams_5_49;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "ant", "cat"};
        groupAnagrams(input).forEach(System.out::println);
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> anagramMap = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            if(!anagramMap.containsKey(str)){
                anagramMap.put(str, new ArrayList<>());
            }
            anagramMap.get(str).add(s);
        }
        return new ArrayList<>(anagramMap.values());
    }
}