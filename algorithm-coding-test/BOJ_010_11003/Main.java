package BOJ_010_11003;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] arr = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        tokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
            while (!deque.isEmpty() && arr[i] < arr[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if(deque.getFirst() <= i - m) {
                deque.removeFirst();
            }
            bw.write(arr[deque.getFirst()] + " ");
        }
        bw.flush();
        bw.close();
    }
}