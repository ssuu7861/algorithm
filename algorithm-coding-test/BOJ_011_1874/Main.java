package BOJ_011_1874;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> result = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        int stackNum = 1;
        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(br.readLine());

            if(curr >= stackNum) {
                while (curr >= stackNum) {
                    stack.push(stackNum++);
                    result.add('+');
                }
                stack.pop();
                result.add('-');
            } else {
                if(!stack.isEmpty() && stack.peek() == curr) {
                    stack.pop();
                    result.add('-');
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        for(char c : result) {
            System.out.println(c);
        }
    }
}
