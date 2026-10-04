package io.grpc.internal;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.common.math.LongMath;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class JsonUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long DURATION_SECONDS_MAX = 315576000000L;
    private static final long DURATION_SECONDS_MIN = -315576000000L;
    private static final long NANOS_PER_SECOND = TimeUnit.SECONDS.toNanos(1);

    /* JADX WARN: Multi-variable type inference failed */
    public static List<Map<String, ?>> checkObjectList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i) instanceof Map)) {
                throw new ClassCastException(String.format(Locale.US, "value %s for idx %d in %s is not object", list.get(i), Integer.valueOf(i), list));
            }
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List<String> checkStringList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i) instanceof String)) {
                throw new ClassCastException(String.format(Locale.US, "value '%s' for idx %d in '%s' is not string", list.get(i), Integer.valueOf(i), list));
            }
        }
        return list;
    }

    private static boolean durationIsValid(long j, int i) {
        if (j >= DURATION_SECONDS_MIN && j <= DURATION_SECONDS_MAX) {
            long j2 = i;
            if (j2 >= -999999999 && j2 < NANOS_PER_SECOND) {
                if (j >= 0 && i >= 0) {
                    return true;
                }
                if (j <= 0 && i <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public static Boolean getBoolean(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", obj, str, map));
    }

    @Nullable
    public static List<?> getList(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof List) {
            return (List) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", obj, str, map));
    }

    @Nullable
    public static List<Map<String, ?>> getListOfObjects(Map<String, ?> map, String str) {
        List<?> list = getList(map, str);
        if (list == null) {
            return null;
        }
        return checkObjectList(list);
    }

    @Nullable
    public static List<String> getListOfStrings(Map<String, ?> map, String str) {
        List<?> list = getList(map, str);
        if (list == null) {
            return null;
        }
        return checkStringList(list);
    }

    @Nullable
    public static Double getNumberAsDouble(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException(String.format("value '%s' for key '%s' in '%s' is not a number", obj, str, map));
        }
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not a double", obj, str));
        }
    }

    @Nullable
    public static Float getNumberAsFloat(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Float) {
            return (Float) obj;
        }
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException(String.format("value %s for key '%s' is not a float", obj, str));
        }
        try {
            return Float.valueOf(Float.parseFloat((String) obj));
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException(String.format("string value '%s' for key '%s' cannot be parsed as a float", obj, str));
        }
    }

    @Nullable
    public static Integer getNumberAsInteger(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (!(obj instanceof Double)) {
            if (!(obj instanceof String)) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
            }
            try {
                return Integer.valueOf(Integer.parseInt((String) obj));
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
            }
        }
        Double d = (Double) obj;
        int iIntValue = d.intValue();
        if (iIntValue == d.doubleValue()) {
            return Integer.valueOf(iIntValue);
        }
        throw new ClassCastException("Number expected to be integer: " + d);
    }

    public static Long getNumberAsLong(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (!(obj instanceof Double)) {
            if (!(obj instanceof String)) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not a long integer", obj, str));
            }
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not a long integer", obj, str));
            }
        }
        Double d = (Double) obj;
        long jLongValue = d.longValue();
        if (jLongValue == d.doubleValue()) {
            return Long.valueOf(jLongValue);
        }
        throw new ClassCastException("Number expected to be long: " + d);
    }

    @Nullable
    public static Map<String, ?> getObject(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", obj, str, map));
    }

    @Nullable
    public static String getString(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", obj, str, map));
    }

    public static Long getStringAsDuration(Map<String, ?> map, String str) {
        String string = getString(map, str);
        if (string == null) {
            return null;
        }
        try {
            return Long.valueOf(parseDuration(string));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static long normalizedDuration(long j, int i) {
        long j2 = i;
        long j3 = NANOS_PER_SECOND;
        if (j2 <= (-j3) || j2 >= j3) {
            j = LongMath.checkedAdd(j, j2 / j3);
            i = (int) (j2 % j3);
        }
        if (j > 0 && i < 0) {
            i = (int) (((long) i) + j3);
            j--;
        }
        if (j < 0 && i > 0) {
            i = (int) (((long) i) - j3);
            j++;
        }
        if (durationIsValid(j, i)) {
            return saturatedAdd(TimeUnit.SECONDS.toNanos(j), i);
        }
        throw new IllegalArgumentException("Duration is not valid. See proto definition for valid values. Seconds (" + j + ") must be in range [-315,576,000,000, +315,576,000,000]. Nanos (" + i + ") must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds");
    }

    private static long parseDuration(String str) throws ParseException {
        boolean z;
        String strSubstring;
        if (str.isEmpty() || AbstractC0000a.m4a(1, str) != 's') {
            throw new ParseException("Invalid duration string: ".concat(str), 0);
        }
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            z = true;
        } else {
            z = false;
        }
        String strM1614d = AbstractC2322a.m1614d(1, 0, str);
        int iIndexOf = strM1614d.indexOf(46);
        if (iIndexOf != -1) {
            strSubstring = strM1614d.substring(iIndexOf + 1);
            strM1614d = strM1614d.substring(0, iIndexOf);
        } else {
            strSubstring = "";
        }
        long j = Long.parseLong(strM1614d);
        int nanos = strSubstring.isEmpty() ? 0 : parseNanos(strSubstring);
        if (j < 0) {
            throw new ParseException("Invalid duration string: ".concat(str), 0);
        }
        if (z) {
            j = -j;
            nanos = -nanos;
        }
        try {
            return normalizedDuration(j, nanos);
        } catch (IllegalArgumentException unused) {
            throw new ParseException("Duration value is out of range.", 0);
        }
    }

    private static int parseNanos(String str) throws ParseException {
        int iCharAt = 0;
        for (int i = 0; i < 9; i++) {
            iCharAt *= 10;
            if (i < str.length()) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
                iCharAt = (str.charAt(i) - '0') + iCharAt;
            }
        }
        return iCharAt;
    }

    private static long saturatedAdd(long j, long j2) {
        long j3 = j + j2;
        return (((j2 ^ j) > 0L ? 1 : ((j2 ^ j) == 0L ? 0 : -1)) < 0) | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }
}
