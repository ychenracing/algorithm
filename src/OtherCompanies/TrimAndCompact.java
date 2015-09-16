package OtherCompanies;

/**
 * <pre>Trim the spaces at both ends of input string,
 * and change one or more spaces between words to only one space.
 * 
 * Such as: 
 *  input: '  i love    meituan    '
 * output: 'i love meituan'
 * </pre>
 * @author racing
 * @version $Id: TrimAndCompact.java, v 0.1 Sep 10, 2015 11:47:59 PM racing Exp $
 */
public class TrimAndCompact {

    public static void main(String[] args) {
        System.out.println(transform(" i       love   meituan "));
        System.out.println(simpleTransform(" i       love   meituan "));
    }

    public static String transform(String canString) {
        char[] canChars = canString.toCharArray();
        int index = 0, begin = 0;
        while (canChars[index] == ' ')
            index++;

        while (index < canChars.length) {
            while (index < canChars.length && canChars[index] != ' ') {
                canChars[begin++] = canChars[index++];
            }
            while (index < canChars.length && canChars[index] == ' ') {
                index++;
            }
            if (index < canChars.length) {
                canChars[begin++] = ' ';
            }
        }

        return new String(canChars, 0, begin);
    }

    public static String simpleTransform(String canString) {
        return canString.trim().replaceAll("\\s+", " ");
    }

}
