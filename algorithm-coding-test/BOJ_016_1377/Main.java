package BOJ_016_1377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        Num[] arr = new Num[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Num(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a.value));
        for(int i = 0; i < n; i++) {
            max = Math.max(max, arr[i].index - i);
        }
        System.out.println(max + 1);
    }
}
class Num {
    int value;
    int index;

    public Num(int value, int index) {
        this.value = value;
        this.index = index;
    }
}