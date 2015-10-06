package ctci.chapter11;

/**
 * 有序的字符串数组，其中插入了若干个空字符串，查找某个字符串
 * @author racing
 * @version $Id: Question11_5.java, v 0.1 Oct 6, 2015 12:26:22 PM racing Exp $
 */
public class Question11_5 {

    public static void main(String[] args) {
        String[] strs = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "", "tail" };
        System.out.println(getIndexOfString(strs, 0, strs.length - 1, "ball"));
        System.out.println(getIndexOfString(strs, 0, strs.length - 1, "dad"));
        System.out.println(getIndexOfString(strs, 0, strs.length - 1, "ddd"));
        System.out.println(getIndexOfString(strs, 0, strs.length - 1, "tail"));
    }

    public static int getIndexOfString(String[] strs, int start, int end, String target) {
        if (start <= end) {
            int middle = (start + end) / 2;

            int newMiddle = middle;
            while (newMiddle >= start) {
                if (!strs[newMiddle].equals(""))
                    break;
                newMiddle--;
            }
            if (newMiddle < start)
                return getIndexOfString(strs, middle + 1, end, target);

            int newComp = strs[newMiddle].compareTo(target);
            if (newComp < 0)
                return getIndexOfString(strs, middle + 1, end, target);
            else if (newComp == 0)
                return newMiddle;
            else
                return getIndexOfString(strs, start, newMiddle - 1, target);
        }
        return -1;
    }

}
