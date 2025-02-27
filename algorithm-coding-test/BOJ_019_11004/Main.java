package BOJ_019_11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        quicksort(arr, 0, n - 1, k - 1);
        System.out.println(arr[k - 1]);
    }

    // Quick Sort
    public static void quicksort(int[] arr, int start, int end, int k) {
        if(start >= end) return;
        int pivotIndex = partition(arr, start, end);
        if(pivotIndex == k) return;
        else if (k < pivotIndex) quicksort(arr, start, pivotIndex - 1, k);
        else quicksort(arr, pivotIndex + 1, end, k);

    }

    public static int partition(int[] arr, int start, int end) {
        if(start + 1 == end) {
            if(arr[start] > arr[end]) {
                swap(arr, start, end);
                return start;
            }
        }
        int mid = start + (end - start) / 2;
        swap(arr, mid, start);
        int pivot = arr[start];
        int i = start + 1, j = end;
        while (i <= j) {
            while (j >= start + 1 && arr[j] > pivot) {
                j--;
            }
            while (i <= end && arr[i] < pivot) {
                i++;
            }
            if(i <= j) {
                swap(arr, i++, j--);
            }
        }
        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}