package com.stc.sns.visualization.util;

public class StringUtils {

    public static String formatDate(String dateStr) {
        String regEx = "(\\d{4})(\\d{2})(\\d{2})";
        return dateStr.replaceAll(regEx, "$1년$2월$3일");
    }
}
