package leetcode;

import java.util.ArrayList;
import java.util.List;

public class E89GrayCode {

    public static void main(String[] args) {
        System.out.println(grayCode(4).toString());
    }

    public static List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        List<Integer> pre = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        List<Integer> result = new ArrayList<Integer>(pre);
        for (int k = pre.size() - 1; k >= 0; k--) {
            result.add(addNumber + pre.get(k));
        }

        return result;
    }

}
