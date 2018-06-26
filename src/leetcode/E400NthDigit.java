/**
 * ychen. Copyright (c) 2018年6月26日.
 */
package leetcode;

/**
 * 
 * @author racing
 * @version $Id: E400NthDigit.java, v 0.1 2018年6月26日 上午11:06:21 racing Exp $
 */
public class E400NthDigit {

    public static void main(String[] args) {
        System.out.println(findNthDigit(4)); // 4
        System.out.println(findNthDigit(9)); // 9
        System.out.println(findNthDigit(10)); // 1
        System.out.println(findNthDigit(11)); // 0
        System.out.println(findNthDigit(19));  // 4
        System.out.println(findNthDigit(1000));  // 3
        System.out.println(findNthDigit(1000000000));  // 1
    }

    public static int findNthDigit(int n) {
        /**
         * 算出n位于哪个10进制数的哪个数字，然后返回即可
         */
        // nineCount值表示n那个位置的数字是几位数
        int nineCount = 1;
        long lastRegion = 0;
        long currentRegion = 9;
        long top = lastRegion + currentRegion;
        // bottom值表示n那个位置的数字之前有多少个低位数：
        // 比如，最后bottom为190，表示n为三位数，
        // n所坐落的区间内，前面有190-1=189个数字，1,2,3,4,...,99包含189个数字
        long bottom = 1;
        while (top < n) {
            bottom += currentRegion;
            nineCount++;
            lastRegion = currentRegion;
            // 用int可能溢出
            currentRegion = 9 * nineCount;
            for (int i = 1; i < nineCount; i++) {
                currentRegion *= 10;
            }
            top += currentRegion;
        }
        // currentRegionIndex值表示在n那个位置的数字区间内，n是第几个数字：
        int currentRegionIndex = n - (int)bottom + 1;
        int numberIndex = currentRegionIndex % nineCount;
        int number = 0;
        for (int i = 1; i < nineCount; i++) {
            number = number * 10 + 9;
        }
        number += currentRegionIndex / nineCount + (numberIndex > 0 ? 1 : 0);
        int rem = 0;
        for (int i = 0; i < nineCount; i++) {
            rem = number % 10;
            if (i == ((nineCount - numberIndex) % nineCount)) {
                return rem;
            } else {
                number = (number - rem) / 10;
            }
        }
        return n;
    }

}
