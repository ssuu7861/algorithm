package BOJ_005_10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        if(n == 1) {
            System.out.println(Integer.parseInt(br.readLine()) % m == 0 ? 1 : 0);
            return;
        }
        tokenizer = new StringTokenizer(br.readLine());
        long[] sum = new long[n];
        long[] countReminder = new long[m];
        long result = 0;
        sum[0] = Long.parseLong(tokenizer.nextToken()) % m;
        countReminder[(int)sum[0]]++;
        
        for(int i = 1 ; i < n ; i++) {
            sum[i] = (sum[i - 1] + Long.parseLong(tokenizer.nextToken())) % m;
            countReminder[(int)sum[i]]++;
        }
        
        for(int i = 0 ; i < m ; i++) {
            if(countReminder[i] > 1) {
                result += (countReminder[i] * (countReminder[i] - 1) / 2);
            }
        }
        System.out.println(result + countReminder[0]);
    }
}