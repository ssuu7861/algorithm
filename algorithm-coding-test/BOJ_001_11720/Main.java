package BOJ_001_11720;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for(char c : br.readLine().toCharArray()) sum += c - '0';
        System.out.println(sum);
    }
}
