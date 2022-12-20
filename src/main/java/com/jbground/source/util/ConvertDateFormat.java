package com.jbground.source.util;

/**
 * Created by jsjeong on 2022. 12. 20.
 * <pre>
 *  설정한 날짜 포맷으로 날짜 포맷 변경 기능
 * </pre>
 */
public class ConvertDateFormat {
    private String convertFormat(String value) {
        String year = "";
        String month = "";
        String day = "";

        if (!value.isEmpty()) {

            String[] arr = {};

            if (value.length() > 6) {

                // 안에 비교문자가 있는지 없는지 여부
                if (value.contains("-") || value.contains("/") || value.contains(".")) {
                    arr = splitFormat(value, true);
                } else
                    arr = splitFormat(value, false);


                // 년월일 비교하여 추출
                if(arr[0].length() == 4) {
                    year = arr[0];

                    int mon = Integer.parseInt(arr[1]);
                    if(mon <= 12) {
                        month = arr[1];
                        day = arr[2];
                    } else {
                        month = arr[2];
                        day = arr[1];
                    }
                } else {
                    if(arr[0].length() == 2) {
                        int mon = Integer.parseInt(arr[0]);
                        if(mon <= 12) {
                            year = arr[2];
                            month = arr[0];
                            day = arr[1];
                        } else {
                            year = arr[2];
                            month = arr[1];
                            day = arr[0];
                        }
                    }
                }
            }else {
                return null;
            }
        }
        return year+"-"+month+"-"+day;
    }

    /**
     * 구분자 여부에 따른 배열 변환
     * @return String[]
     */
    public String[] splitFormat(String input, boolean flag) {
        String year = "";
        String month = "";
        String day = "";

        if (flag) {
            return input.substring(0, 10).split("/|-|\\.");
        } else {

            int since = Integer.parseInt(input.substring(0, 4));
            int mon = Integer.parseInt(input.substring(0, 2));
            if (1900 < since && since < 2100) {
                year = input.substring(0, 4);
                month = input.substring(4, 6);
                day = input.substring(6, 8);

            } else {

                if (mon <= 12) {
                    month = input.substring(0, 2);
                    day = input.substring(2, 4);
                    year = input.substring(4, 8);
                } else {
                    day = input.substring(0, 2);
                    month = input.substring(2, 4);
                    year = input.substring(4, 8);
                }

            }

        }

        return new String[] { year, month, day };
    }

}
