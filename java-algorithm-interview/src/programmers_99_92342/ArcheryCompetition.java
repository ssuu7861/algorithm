package programmers_99_92342;

import java.util.Arrays;

public class ArcheryCompetition {

    int max = 0;
    int[] info;
    int[] answer = new int[11];


    public int[] solution(int n, int[] info) {
        this.info = info;
        dfs(0, new int[11], n);
        
        if(max == 0) return new int[]{-1};
        return answer;
    }

    public void dfs(int index, int[] lion, int arrow) {
        if(index == 11) {
            lion[10] = arrow;
            int score = calculate(lion);
            if(score > max) {
                max = score;
                answer = Arrays.copyOf(lion, lion.length);
            } else if(score == max) {
                for(int i = 10 ; i >= 0 ; i--) {
                    if(lion[i] == answer[i]) continue;
                    if(lion[i] < answer[i]) break;
                    answer = Arrays.copyOf(lion, lion.length);
                }
            }
            return;
        }

        if(info[index] < arrow) {
            lion[index] = info[index] + 1;
            dfs(index + 1, lion, arrow - lion[index]);
        }
        
        lion[index] = 0;
        dfs(index + 1, lion, arrow);
    }

    public int calculate(int[] lion) {
        int diff = 0;
        for(int i = 0 ; i < 11; i++) {
            if(lion[i] == 0 && info[i] == 0) continue;
            diff = lion[i] > info[i] ? diff + 10 - i : diff - 10 + i;
        }
        return diff;
    }
}
