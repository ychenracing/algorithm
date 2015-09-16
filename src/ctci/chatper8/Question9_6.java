package ctci.chatper8;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>打印n对括号的所有合法组合
 * Example:
 * input: 3
 * output: ()()(), (())(), ()()(), ()(()), (()()), ((()))
 * </pre>
 * 
 * @author racing
 * @version $Id: Question9_6.java, v 0.1 Sep 17, 2015 12:05:28 AM racing Exp $
 */
public class Question9_6 {

    public static List<String> getResult(int n) {
        if (n == 1) {
            List<String> result = new ArrayList<String>();
            result.add("()");
            return result;
        }

        List<String> previous = getResult(n - 1);
        List<String> result = new ArrayList<String>();
        for (String item : previous) {
            for (int i = 0; i < item.length() / 2 + 1; i++) {
                String pre = item.substring(0, i);
                String suf = item.substring(i, item.length());
                result.add(pre + "()" + suf);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(getResult(3).toString());
    }

}
