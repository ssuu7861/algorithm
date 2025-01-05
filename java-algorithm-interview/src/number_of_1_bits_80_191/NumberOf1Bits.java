package number_of_1_bits_80_191;

public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println(hammingWeight(2147483645));
    }

    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
