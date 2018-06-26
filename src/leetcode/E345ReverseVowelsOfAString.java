/**
 * ychen. Copyright (c) 2018年6月25日.
 */
package leetcode;

/**
 * 
 * @author racing
 * @version $Id: E345ReverseVowelsOfAString.java, v 0.1 2018年6月25日 下午7:33:45 racing Exp $
 */
public class E345ReverseVowelsOfAString {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));
        System.out.println(reverseVowels("hello"));
    }

    public static String reverseVowels(String s) {
        if (s == null)
            return "";
        StringBuilder sb = new StringBuilder();
        int vowelIndex = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o'
                && s.charAt(i) != 'u' && s.charAt(i) != 'A' && s.charAt(i) != 'E'
                && s.charAt(i) != 'I' && s.charAt(i) != 'O' && s.charAt(i) != 'U') {
                sb.append(s.charAt(i));
            } else {
                while (vowelIndex >= 0 && s.charAt(vowelIndex) != 'a' && s.charAt(vowelIndex) != 'e'
                       && s.charAt(vowelIndex) != 'i' && s.charAt(vowelIndex) != 'o'
                       && s.charAt(vowelIndex) != 'u' && s.charAt(vowelIndex) != 'A'
                       && s.charAt(vowelIndex) != 'E' && s.charAt(vowelIndex) != 'I'
                       && s.charAt(vowelIndex) != 'O' && s.charAt(vowelIndex) != 'U') {
                    vowelIndex--;
                }
                if (i == vowelIndex) {
                    sb.append(s.charAt(i));
                } else {
                    sb.append(s.charAt(vowelIndex));
                }
                vowelIndex--;
            }
        }
        return sb.toString();
    }

}
