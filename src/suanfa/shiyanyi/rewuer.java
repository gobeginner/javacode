package suanfa.shiyanyi;

import java.util.Scanner;

public class rewuer {
    public static int gcd(int m, int n) {
        /*if(n==0)return m;
        return gcd(n,m%n);*/
        while (n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        int m = sc.nextInt();
        System.out.println("请输入第二个数：");
        int n = sc.nextInt();
        System.out.println("最大公约数："+gcd(m,n));
    }
}


