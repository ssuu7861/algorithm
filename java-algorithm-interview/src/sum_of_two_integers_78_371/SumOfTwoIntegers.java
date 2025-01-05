package sum_of_two_integers_78_371;

public class SumOfTwoIntegers {

    public static void main(String[] args) {
        int a = 15, b = 40;
        System.out.println(getSum(a, b));
    }

    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a ^=  b;
            b = carry;
        }
        return a;
    }
}
