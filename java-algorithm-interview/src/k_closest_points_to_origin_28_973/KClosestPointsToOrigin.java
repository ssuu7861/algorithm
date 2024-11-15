package k_closest_points_to_origin_28_973;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = {{3,3}, {6,-1}, {-2,4}};
        int k = 2;
        System.out.println(Arrays.deepToString(kClosest(points, k)));
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>((a, b) -> Long.compare(a.dis, b.dis)); // (p1, p2) -> (int)(p1.dis - p2.dis) 같은 단순 뺄셈이 빠르지만 OverFlow problem
        int[][] result = new int[k][];
        for(int[] point : points) {
            long dis = (long) point[0] * point[0] + (long) point[1] * point[1]; // sqrt를 굳이 하지 않아도 된다! exact distance 구할 필요없음.
            priorityQueue.add(new Point(dis , point));
        }
        for(int i = 0 ; i < k ; i++) result[i] = priorityQueue.poll().point;
        return result;
    }
}
class Point {
    long dis;
    int[] point;

    public Point(long dis, int[] point){this.dis = dis; this.point = point;}
}
