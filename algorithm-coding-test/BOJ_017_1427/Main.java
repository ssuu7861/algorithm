package BOJ_017_1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < arr.length; i++) {
            int max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
                if (arr[i] < arr[max]) {
                    int temp = arr[i];
                    arr[i] = arr[max];
                    arr[max] = temp;
                }
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}