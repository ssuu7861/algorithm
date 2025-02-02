package BOJ_6_2018;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int start = 1, end = 1, sum = 1, result = 0;

        while (end <= n) {
            if(sum == n) {
                result++;
                end++;
                sum += end;
            } else if(sum > n) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }
        System.out.println(result);
    }
}
