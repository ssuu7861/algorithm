package programmers_34_42576;

import java.util.HashMap;

public class DidNotFinishTheRace {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(didNotFinishTheRace(participant, completion));
    }

    public static String didNotFinishTheRace(String[] participant, String[] completion) {
        HashMap<String, Integer> participantHashMap = new HashMap<>();
        for(String s : participant) participantHashMap.put(s, participantHashMap.getOrDefault(s, 0) + 1);
        for(String s : completion) {
            int count = participantHashMap.get(s);
            if(count == 1) {
                participantHashMap.remove(s);
            } else {
                participantHashMap.put(s, count - 1);
            }
        }
        return participantHashMap.keySet().toString();
    }
}
