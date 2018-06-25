/**
 * ychen. Copyright (c) 2018年4月17日.
 */
package leetcode;

/**
 * 
 * @author racing
 * @version $Id: Twenty20ValidParentheses.java, v 0.1 2018年4月17日 下午6:50:30 racing Exp $
 */
public class E20ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.equals(""))
            return true;
        if (s.length() % 2 != 0)
            return false;
        char[] pas = new char[s.length()];
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                pas[++index] = s.charAt(i);
                continue;
            }
            if (index < 0) {
                return false;
            }
            char com = 'a';
            switch (s.charAt(i)) {
                case '}':
                    com = '{';
                    break;
                case ']':
                    com = '[';
                    break;
                case ')':
                    com = '(';
                    break;
            }
            if (pas[index--] != com) {
                return false;
            }
        }
        return index < 0;
    }

}
