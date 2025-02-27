package BOJ_018_11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        // Insertion Sort
        for(int i = 1 ; i < n ; i++) {
            int targetIndex = i;
            int targetValue = arr[i];
            for(int j = i - 1 ; j >= 0 ; j--) {
                if(arr[j] < targetValue) {
                    targetIndex = j + 1;
                    break;
                }
                if(j == 0) {
                    targetIndex = 0;
                }
            }
            for(int j = i ; j > targetIndex ; j--) {
                arr[j] = arr[j - 1];
            }
            arr[targetIndex] = targetValue;
        }
        int result = 0;
        for(int i = 0 ; i < n ; i++) {
            result += arr[i] * (n - i);
        }
        System.out.println(result);
    }
}
