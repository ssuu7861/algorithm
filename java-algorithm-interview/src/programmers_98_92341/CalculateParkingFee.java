package programmers_98_92341;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CalculateParkingFee {

    
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String, Integer> entranceLog = new HashMap<>();
        Map<String, Integer> timeLog = new HashMap<>();
        
        for(String s : records) {
            String[] logs = s.split(" ");
            int[] time = Arrays.stream(logs[0].split(":")).mapToInt(Integer::parseInt).toArray();
            if(logs[2].equals("IN")) entranceLog.put(logs[1], time[0] * 60 + time[1]);
            else {
                timeLog.put(logs[1], timeLog.getOrDefault(logs[1], 0) + time[0] * 60 + time[1] - entranceLog.get(logs[1]));
                entranceLog.remove(logs[1]);
            }
        }
        if(!entranceLog.isEmpty()) {
            for(String s : entranceLog.keySet()) {
                timeLog.put(s, timeLog.getOrDefault(s, 0) + 23 * 60 + 59 - entranceLog.get(s));
                //entranceLog.remove(s); -> ketSet()을 통해 반복문을 돌고 있는데 remove를 하면 동시성 오류가 생길 수 있음.
                // 어차피 out 처리 되지 않은 차를 이곳에서 처리 하므로 remove 시키지 않아도 됨.
            }
        }

        String[] sortingName = timeLog.keySet().toArray(new String[0]);
        int[] result = new int[timeLog.size()];
        Arrays.sort(sortingName);
        for(int i = 0 ; i < sortingName.length ; i++) {
            int time = timeLog.get(sortingName[i]);
            if(time > fees[0]) result[i] = fees[1] + ((int) Math.ceil(((double) time - fees[0]) / fees[2])) * fees[3];
            else result[i] = fees[1];
        }
        return result;

    }
}
