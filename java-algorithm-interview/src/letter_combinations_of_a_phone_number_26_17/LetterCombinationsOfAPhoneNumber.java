import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        String digits = "24";
        System.out.println(letterCombinations(digits).toString());
    }

    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;

        Map<Character, List<Character>> dictionary = new HashMap<>() {{
            put('0', List.of());
            put('1', List.of());
            put('2', List.of('a', 'b', 'c'));
            put('3', List.of('d', 'e', 'f'));
            put('4', List.of('g', 'h', 'i'));
            put('5', List.of('j', 'k', 'l'));
            put('6', List.of('m', 'n', 'o'));
            put('7', List.of('p', 'q', 'r', 's'));
            put('8', List.of('t', 'u', 'v'));
            put('9', List.of('w', 'x', 'y', 'z'));
        }};

        dfs(new StringBuilder(), digits, 0, dictionary, result);
        return result;

    }

    public static void dfs(StringBuilder sb, String digits, int index, Map<Character, List<Character>> dictionary, List<String> result) {
        
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for(Character ch : dictionary.get(digits.charAt(index))) {
            dfs(new StringBuilder(sb).append(ch), digits, index + 1, dictionary, result);
            // sb값은 바뀌지 않은 상태로 ch를 추가하는 dfs를 리스트 전체 실행해야 하므로 new StringBuilder(sb.append(ch))가 아닌 new StringBuilder(sb).append(ch)
        }
    }
}
