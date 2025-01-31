package BOJ_2_1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        int num = 0;
        for(int i = 0 ; i < N ; i++){
            num = Integer.parseInt(stringTokenizer.nextToken());
            sum += num;
            if(max < num) max = num;
        }
        System.out.println(sum * 100.0 / max / N);
    }
}