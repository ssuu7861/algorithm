package BOJ_014_11286;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {int x1 = Math.abs(a), x2 = Math.abs(b);
                                                            if(x1 == x2) {return a - b;}
                                                            else {return x1 - x2;}});
        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(br.readLine());
            if (curr != 0) {
                pq.offer(curr);
            } else {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {sb.append(pq.poll()).append("\n");}
            }
        }
        System.out.println(sb);
    }
}