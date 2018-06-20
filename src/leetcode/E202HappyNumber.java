package leetcode;

import java.util.HashMap;

public class E202HappyNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean isHappy(int n) {
        HashMap<Integer, Object> map = new HashMap<Integer, Object>();
        Object o = new Object();
        while (n != 1) {
            int result = 0; 
            while (n != 0) {
                int rem = n % 10;
                result += rem * rem;
                n = (n - rem) / 10;
            }
            if (result == 1) {
                return true;
            }
            if (map.containsKey(result)) {
                return false;
            }
            map.put(result, o);
            n = result;
        }
        return true;
    }

}
