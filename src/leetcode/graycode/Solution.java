package leetcode.graycode;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * <pre>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * </pre>
 * @author racing
 * @version $Id: Solution.java, v 0.1 Sep 27, 2015 9:05:44 AM racing Exp $
 */
public class Solution {

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
