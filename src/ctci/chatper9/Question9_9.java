package ctci.chatper9;

/**
 * 给定任意数量的25分、10分、5分、1分的硬币，求n分有多少种组合方式
 * @author racing
 * @version $Id: Question9_9.java, v 0.1 Sep 24, 2015 8:50:11 AM racing Exp $
 */
public class Question9_9 {

    public static void main(String[] args) {
        System.out.println(getNums(100, 25));
    }

    public static int getNums(int n, int money) {
        int next = 0;
        switch (money) {
            case 25:
                next = 10;
                break;
            case 10:
                next = 5;
                break;
            case 5:
                next = 1;
                break;
            case 1:
                return 1;
        }

        int sum = 0;
        for (int i = 0; i * money <= n; i++) {
            sum += getNums(n - i * money, next);
        }

        return sum;

    }

}
