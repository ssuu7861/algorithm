package course_schedule_43_207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    public static void main(String[] args) {
     
        int numCourses = 3;
        int[][] prerequisites = {{1, 0}, {2, 1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pre : prerequisites) {
            map.putIfAbsent(pre[0], new ArrayList<>());
            map.get(pre[0]).add(pre[1]);
        }

        List<Integer> takes = new ArrayList<>();
        List<Integer> taken = new ArrayList<>();

        for(int finish : map.keySet()) {
            if(!dfs(map, finish, takes, taken)) return false;
        }
        return true;
    }

    public static boolean dfs(Map<Integer, List<Integer>> map, Integer finish, List<Integer> takes, List<Integer> taken) {
        if(takes.contains(finish)) return false;
        if(taken.contains(finish)) return true;

        if(map.containsKey(finish)) {
            takes.add(finish);
            for(Integer take : map.get(finish)) {
                if(!dfs(map, take, takes, taken)) return false;
            }
            takes.remove(finish);
            taken.add(finish);
        }
        return true;
        
    }
}
