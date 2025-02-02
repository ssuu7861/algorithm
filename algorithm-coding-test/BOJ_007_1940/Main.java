package BOJ_007_1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) arr[i] = Integer.parseInt(tokenizer.nextToken());
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        int result = 0;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if(sum == m) {
                result++;
                i++;
                j--;
            } else if(sum > m) j--;
            else i++;
        }
        System.out.println(result);
    }
}
