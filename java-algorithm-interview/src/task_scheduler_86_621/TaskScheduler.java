package task_scheduler_86_621;

import java.util.Arrays;

public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char task : tasks) map[task - 'A']++;
        Arrays.sort(map);
        int max = map[25];
        int idle = (max - 1) * n; // MAX IDLE 수 : 가장 많은 갯수의 알파벳 사이를 모두 IDLE 이라 가정
        for(int i = 0 ; i < 25 ; i++) {
            idle -= Math.min(max - 1, map[i]); // IDLE 공간을 채워넣음. 
        }
        return idle > 0 ? tasks.length + idle : tasks.length; // IDLE로 채웠던 공간이 0보다 작으면 가장 끝에 넣음.
    }
}
