package org.apache.commons.lang3.time;

import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FastTimeZone {
    private static final Pattern GMT_PATTERN = Pattern.compile("^(?:(?i)GMT)?([+-])?(\\d\\d?)?(:?(\\d\\d?))?$");
    private static final TimeZone GREENWICH = new GmtTimeZone(false, 0, 0);

    private FastTimeZone() {
    }

    public static TimeZone getGmtTimeZone() {
        return GREENWICH;
    }

    public static TimeZone getTimeZone(String str) {
        TimeZone gmtTimeZone = getGmtTimeZone(str);
        return gmtTimeZone != null ? gmtTimeZone : TimeZone.getTimeZone(str);
    }

    private static int parseInt(String str) {
        if (str != null) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    private static boolean parseSign(String str) {
        return str != null && str.charAt(0) == '-';
    }

    public static TimeZone getGmtTimeZone(String str) {
        if ("Z".equals(str) || "UTC".equals(str)) {
            return GREENWICH;
        }
        Matcher matcher = GMT_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        int i = parseInt(matcher.group(2));
        int i2 = parseInt(matcher.group(4));
        return (i == 0 && i2 == 0) ? GREENWICH : new GmtTimeZone(parseSign(matcher.group(1)), i, i2);
    }
}
