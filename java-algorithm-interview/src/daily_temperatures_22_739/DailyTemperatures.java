package daily_temperatures_22_739;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {23, 24, 25, 21, 19, 22, 26, 23};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        
        for(int i = 0 ; i < temperatures.length ; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int temp = stack.pop();
                result[temp] = i - temp;
            }
            stack.push(i);
        }

        return result;
    }
}
