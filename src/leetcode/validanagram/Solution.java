package leetcode.validanagram;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * </pre>
 * @author racing
 * @version $Id: Solution.java, v 0.1 Oct 12, 2015 8:29:11 AM racing Exp $
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else
                map.put(ch, 1);
        }

        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) < 0)
                    return false;
            } else
                return false;
        }
        return true;
    }

}
