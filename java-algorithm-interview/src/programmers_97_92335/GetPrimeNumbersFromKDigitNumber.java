package programmers_97_92335;

public class GetPrimeNumbersFromKDigitNumber {

    public static void main(String[] args) {
        int n = 437674, k = 3;
        System.out.println(getPrimeNumersFromKDigitNumber(n, k));
    }

    public static int getPrimeNumersFromKDigitNumber(int n, int k) {
        String number = Integer.toString(n, k);
        int answer = 0;
        for(String s : number.split("0")){
            if(s.equals("")) continue;
            if(isPrime(Long.parseLong(s))) answer++;
        }
        return answer;
    }

    public static boolean isPrime(Long num) {
        if(num == 1 || (num > 2 && num % 2 == 0)) return false;
        for(int i = 3 ; i <= (int) Math.sqrt(num) ; i += 2) if(num % i == 0) return false;
        return true;
    }
}
