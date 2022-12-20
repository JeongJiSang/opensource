package com.jbground.source.util;

import java.util.ArrayList;

/**
 * Created by jsjeong on 2022. 12. 20.
 * <pre>
 *  문자열 설정한 길이만큼 자르기 기능
 * </pre>
 */
public class LimitString {

    /**
     * @param str 대상 문자열
     * @param maxLen 최대 길이 지정
     * @return String
     */
    public String getMaxByteString(String str, int maxLen) {
        StringBuilder sb = new StringBuilder();
        int curLen = 0;
        String curChar;
        for (int i = 0; i < str.length(); i++) {
            curChar = str.substring(i, i + 1);
            curLen += curChar.getBytes().length;
            if (curLen > maxLen) break;
            else sb.append(curChar);
        }
        return sb.toString();
    }

    public String[] getMaxByteStringArray(String str, int maxLen) {
        return getMaxByteStringArray(str, maxLen, -1);
    }

    /**
     * @param str 대상 문자열
     * @param maxLen 최대 길이 지정
     * @param maxArrays 최대 배열 길이 지정
     * @return String[]
     */
    public String[] getMaxByteStringArray(String str, int maxLen, int maxArrays) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> strList = new ArrayList();
        int curLen = 0;
        String curChar;
        for (int i = 0; i < str.length(); i++) {
            curChar = str.substring(i, i + 1);
            curLen += curChar.getBytes().length;
            if (curLen > maxLen) {
                if (maxArrays == -1 || strList.size() <= maxArrays - 2) {
                    strList.add(sb.toString());
                    sb = new StringBuilder();
                    curLen = 0;
                    i--;
                } else break;
            } else sb.append(curChar);
        }
        strList.add(sb.toString());
        String[] strArr = new String[strList.size()];
        for (int i = 0; i < strList.size(); i++) {
            strArr[i] = strList.get(i);
        }
        return strArr;
    }

}
