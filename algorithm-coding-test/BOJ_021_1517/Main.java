package BOJ_021_1517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long result;
    public static int[] arr, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tmp = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        mergeSort(0, n - 1);
        System.out.println(result);
    }

    public static void mergeSort(int start, int end) {
        if(start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        for(int i = start ; i <= end ; i++) tmp[i] = arr[i];

        int i = start, j = mid + 1;
        int index = start;
        while(i <= mid && j <= end) {
            if (tmp[i] > tmp[j]) {
                result += j - index;
                arr[index++] = tmp[j++];
            } else arr[index++] = tmp[i++];
        }
        while (i <= mid) arr[index++] = tmp[i++];
        while (j <= end) arr[index++] = tmp[j++];
    }
}
