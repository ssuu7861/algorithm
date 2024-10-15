package reorder_log_files_3_937;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderLogFiles {
    
    public static void main(String[] args) {
        String[] strArr = {"id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero"};
        System.out.println(Arrays.toString(reorderLogFiles(strArr)));
    }

    public static String[] reorderLogFiles(String[] logs){
        List<String> letterList = new ArrayList<>();
        List<String> numberList = new ArrayList<>();
        
        for(String s : logs){
            if(Character.isLetter(s.split(" ")[1].charAt(0))){
                letterList.add(s);
            }
            else{
                numberList.add(s);
            }
        }

        letterList.sort((s1, s2) -> {
            String[] s1Arr = s1.split(" ", 2);
            String[] s2Arr = s2.split(" ", 2);
            
            int compared = s1Arr[1].compareTo(s2Arr[1]);
            if(compared == 0){
            return s1Arr[0].compareTo(s2Arr[0]);
            }
            else{
                return compared;
            }
        });

        letterList.addAll(numberList);
        return letterList.toArray(new String[0]);
    }
}
