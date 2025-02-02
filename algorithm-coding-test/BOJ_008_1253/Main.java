package BOJ_008_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n < 3) {
            System.out.println(0);
            return;
        }
        
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int result = 0;
        for(int k = 0 ; k < n ; k++) {
            int target = arr[k];
            int i = 0, j = n - 1;
            while (i < j) {
                int sum = arr[i] + arr[j];
                if(sum == target) {
                    if(i != k && j != k) {
                        result++;
                        break;
                    } else if(i == k) i++;
                    else if(j == k) j--;
                } else if(sum > target) {
                    j--;
                } else i++;
            }
        }

        System.out.println(result);  
    }
}
