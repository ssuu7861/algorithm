package BOJ_009_12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] checkArr;
    public static int[] countArr;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int result = 0;
        char[] password = br.readLine().toCharArray();
        tokenizer = new StringTokenizer(br.readLine());
        checkArr = new int[4];
        countArr = new int[4];
        count = 0;
        for(int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(tokenizer.nextToken());
            if(checkArr[i] == 0) count++;
        }

        for(int i = 0; i < m; i++) {
            add(password[i]);
        }
        if(count == 4) result++;

        for(int i = m ; i < n ; i++) {
            add(password[i]);
            remove(password[i - m]);
            if(count == 4) result++;
        }
        System.out.println(result);


    }

    public static void add(char ch) {
        switch(ch) {
            case 'A': 
                countArr[0]++;
                if(countArr[0] == checkArr[0]) count++;
                break;
            case 'C':
                countArr[1]++;
                if(countArr[1] == checkArr[1]) count++;
                break;
            case 'G':
                countArr[2]++;
                if(countArr[2] == checkArr[2]) count++;
                break;
            case 'T':
                countArr[3]++;
                if(countArr[3] == checkArr[3]) count++;
                break;
        }
    }

    public static void remove(char ch) {
        switch (ch) {
            case 'A':
                if(countArr[0] == checkArr[0]) count--;
                countArr[0]--;
                break;

            case 'C':
                if(countArr[1] == checkArr[1]) count--;
                countArr[1]--;
                break;
            case 'G':
                if(countArr[2] == checkArr[2]) count--;
                countArr[2]--;
                break;
            case 'T':
                if(countArr[3] == checkArr[3]) count--;
                countArr[3]--;
                break;
        }
    }
}