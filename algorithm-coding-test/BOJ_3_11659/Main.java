package BOJ_3_11659;

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
        int[] sum = new int[n + 1];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++) sum[i] = sum[i - 1] + Integer.parseInt(tokenizer.nextToken());
        for(int i = 0 ; i < m ; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            System.out.println(-sum[Integer.parseInt(tokenizer.nextToken()) - 1] + sum[Integer.parseInt(tokenizer.nextToken())]);
        }
    }
}
