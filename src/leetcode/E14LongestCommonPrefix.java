/**
 * ychen. Copyright (c) 2018年4月13日.
 */
package leetcode;

/**
 * 
 * @author racing
 * @version $Id: Fourteen14LongestCommonPrefix.java, v 0.1 2018年4月13日 下午4:31:35 racing Exp $
 */
public class E14LongestCommonPrefix {

    public static void main(String[] args) {
    }

    /**
     * 寻找一组字符串的最长公共前缀。
     * 
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = "";
        if (strs[0].length() < 1) {
            return result;
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String current = strs[j];
                if (current.length() < i + 1 || current.charAt(i) != c) {
                    return result;
                }
            }
            result += c;
        }
        return result;
    }

    /**
     * 寻找一组字符串的最长公共子串。
     * 
     * @param strs
     * @return
     */
    public static String longestCommonSub(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String currentScannedItem = strs[i];
            String tempResult = "";
            int j = result.length() - 1, k = currentScannedItem.length() - 1;
            if (j == -1 || k == -1) {
                return "";
            }
            if (result.charAt(j) == currentScannedItem.charAt(k)) {
                String resultSub = result.substring(0, j);
                String tempSub = currentScannedItem.substring(0, k);
                String subCom = longestCommonSub(new String[] { resultSub, tempSub });
                if (subCom != null && resultSub.endsWith(subCom) && tempSub.endsWith(subCom)) {
                    result = subCom + result.charAt(j);
                    continue;
                }
                tempResult += result.charAt(j);
                if (tempResult.length() < subCom.length()) {
                    tempResult = subCom;
                }
                result = tempResult;
                continue;
            }
            String resultSub = result.substring(0, j);
            String tempSub = currentScannedItem.substring(0, k);
            String candidate1 = longestCommonSub(new String[] { result, tempSub });
            String candidate2 = longestCommonSub(new String[] { resultSub, currentScannedItem });
            if (candidate1 != null) {
                if (candidate1.length() > tempResult.length()) {
                    tempResult = candidate1;
                }
            }
            if (candidate2 != null) {
                if (candidate2.length() > tempResult.length()) {
                    tempResult = candidate2;
                }
            }
            result = tempResult;
        }
        return result;
    }

}
