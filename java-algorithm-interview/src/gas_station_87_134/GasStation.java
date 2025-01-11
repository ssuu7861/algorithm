import java.util.Arrays;

public class GasStation {

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) return -1; // 반복문을 사용해 계산하는게 더 빠름.
        int fuel = 0;
        int start = 0;
        for(int i = 0 ; i < gas.length ; i++) {
            fuel += gas[i] - cost[i];
            if(fuel < 0) {
                fuel = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
