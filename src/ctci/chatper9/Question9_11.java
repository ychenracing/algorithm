package ctci.chatper9;

import java.util.Scanner;

public class Question9_11 {

    public static void main(String[] args) {

    }

    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        String exression = scanner.next();
        boolean expect = scanner.nextBoolean();
        if (!getResult(exression, expect))
            System.out.println("no result");
    }

    public static boolean getResult(String expression, boolean expect) {
        if (expression.length() == 1) {
            int num = Integer.parseInt(expression);
            return (expect ? 1 : 0) == num;
        }

        return false;
    }
}
