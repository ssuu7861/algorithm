package BOJ_020_2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] arr, tmp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        tmp = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(br.readLine());
        mergeSort(1, n);
        for(int i = 1; i <= n; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void mergeSort(int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        int i = start, j = mid + 1;
        int index = start;
        while (i <= mid && j <= end) {
            if(arr[i] <= arr[j]) tmp[index++] = arr[i++];
            else tmp[index++] = arr[j++];
        }
        while(i <= mid) tmp[index++] = arr[i++];
        while(j <= end) tmp[index++] = arr[j++];
        for(int k = start ; k <= end ; k++) {
            arr[k] = tmp[k];
        }
    }
}