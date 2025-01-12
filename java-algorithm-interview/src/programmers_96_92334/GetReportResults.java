package programmers_96_92334;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GetReportResults {

    public static void main(String[] args) {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        System.out.println(Arrays.toString(getReportResults(id_list, report, k)));
    }

    public static int[] getReportResults(String[] id_list, String[] report, int k) {
        Set<String> reportSet = new HashSet<>(Arrays.asList(report)); // 중복 제거
        Map<String, List<String>> reportLog = new HashMap<>(); // key : 피신고자, value : 신고자
        for(String s : reportSet) {
            String[] splitLog = s.split(" ");
            List<String> list = reportLog.getOrDefault(splitLog[1], new ArrayList<>());
            list.add(splitLog[0]);
            reportLog.put(splitLog[1], list); // 위 getOrDefault에서 key가 없어 new ArrayList가 생성되면 add한 list가 반영이 안되므로 put 해줘야함.
        }

        List<String> reportees = new ArrayList<>();
        for(Map.Entry<String, List<String>> log : reportLog.entrySet()) if(log.getValue().size() >= k) reportees.add(log.getKey());
        
        int[] result = new int[id_list.length];
        List<String> idList = Arrays.asList(id_list);
        for(String s : reportSet) {
            String[] log = s.split(" ");
            for(String reportee : reportees) {
                if(reportee.equals(log[1])) result[idList.indexOf(log[0])]++;
            }
        }

        return result;
    }
}
