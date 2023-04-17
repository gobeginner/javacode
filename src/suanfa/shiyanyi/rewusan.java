package suanfa.shiyanyi;

import java.util.Scanner;

public class rewusan {
    static int twoSum(int n) {
        if (n == 1)
            return 1;
        return (n % 2) + twoSum(n / 2);
    }

    static int tenSum(int n) {
        if (n < 10)
            return n;
        return n % 10 + tenSum(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            if (twoSum(i) == tenSum(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
