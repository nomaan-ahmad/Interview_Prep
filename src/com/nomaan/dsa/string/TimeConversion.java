package com.nomaan.dsa.string;

public class TimeConversion {
    public static String timeConversion(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        if (s.charAt(len-2) == 'A') {
            if (s.charAt(0) == '1' && s.charAt(1) == '2') {
                sb.replace(0,2, "00");
            }
        } else {
            String sub = s.substring(0,2);
            if (!sub.equals("12")) sb.replace(0,2, (Integer.parseInt(sub) + 12) + "");
        }

        return sb.delete(len-2, len).toString();
    }
}
