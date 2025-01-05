package programmers_75_43238;

import java.util.Arrays;

public class Immigration {

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(immigration(n, times));
    }

    public static long immigration(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            int completeMember = 0;

            for(int i = 0 ; i < times.length ; i++) completeMember += mid / times[i];
            
            if(completeMember < n) left = mid + 1;
            else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
