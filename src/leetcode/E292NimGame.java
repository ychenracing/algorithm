/**
 * ychen. Copyright (c) 2018年6月25日.
 */
package leetcode;

/**
 * 
 * @author racing
 * @version $Id: E292NimGame.java, v 0.1 2018年6月25日 上午11:41:52 racing Exp $
 */
public class E292NimGame {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(canWinNim(5));
    }

    public static boolean canWinNim(int n) {
        boolean[] f = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (i < 3) {
                f[i] = true;
                continue;
            }
            f[i] = !(canWinNim(i - 1) && canWinNim(i - 2) && canWinNim(i - 3));
        }
        return f[n - 1];
    }

    public static boolean canWinNim2(int n) {
        boolean[] f = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (i < 3) {
                f[i] = true;
                continue;
            }
            f[i] = !(canWinNim(i - 1) && canWinNim(i - 2) && canWinNim(i - 3));
        }
        return f[n - 1];
    }

    public static boolean canWinNim3(int n) {
        return n % 4 != 0;
    }

}
