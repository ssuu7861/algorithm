package hamming_distance_77_461;

public class HammingDistance {

    public static void main(String[] args) {
        int x = 1, y = 6;
        System.out.println(hammingDistance(x, y));
    }

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
