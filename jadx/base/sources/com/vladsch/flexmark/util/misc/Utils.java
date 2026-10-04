package com.vladsch.flexmark.util.misc;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.vladsch.flexmark.util.ast.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p074R1.C0230b;
import p092W3.C0332a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Utils {
    public static int compare(@Nullable Number number, @Nullable Number number2) {
        if (number == null && number2 == null) {
            return 0;
        }
        if (number == null) {
            return -1;
        }
        if (number2 == null) {
            return 1;
        }
        return ((number instanceof Double) || (number2 instanceof Double) || (number instanceof Float) || (number2 instanceof Float)) ? Double.compare(number.doubleValue(), number2.doubleValue()) : Long.compare(number.longValue(), number2.longValue());
    }

    public static <T extends Comparable<T>> int compareNullable(T t, T t2) {
        if (t == null || t2 == null) {
            return 0;
        }
        return t.compareTo(t2);
    }

    public static int count(String str, char c, int i, int i2) {
        int i4 = 0;
        if (str == null) {
            return 0;
        }
        int iMin = Math.min(str.length(), i2);
        while (i >= 0 && i <= iMin) {
            int iIndexOf = str.indexOf(c, i);
            if (iIndexOf < 0) {
                break;
            }
            i4++;
            i = iIndexOf + 1;
        }
        return i4;
    }

    public static boolean endsWith(String str, String... strArr) {
        return endsWith(str, false, strArr);
    }

    @NotNull
    public static String escapeJavaString(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        escapeJavaString(sb, charSequence);
        return sb.toString();
    }

    public static String getAbbreviatedText(String str, int i) {
        if (str == null) {
            return "";
        }
        if (str.length() <= i || i < 6) {
            return str;
        }
        int i2 = i / 2;
        return AbstractC0541b.m757C(str.substring(0, i2), Node.SPLICE, str.substring(str.length() - ((i - 3) - i2)));
    }

    public static String getLongestCommonPrefix(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        if (strArr.length == 1) {
            return strArr[0];
        }
        String str = strArr[0];
        int length = str.length();
        int length2 = strArr.length;
        for (int i = 1; i < length2; i++) {
            length = Math.min(strArr[i].length(), length);
        }
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            for (int i4 = 1; i4 < length2; i4++) {
                if (strArr[i4].charAt(i2) != cCharAt) {
                    return str.substring(0, i2);
                }
            }
        }
        return str.substring(0, length);
    }

    public static <T> T getOrNull(@NotNull List<T> list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static String getResourceAsString(Class<?> cls, String str) {
        InputStream resourceAsStream = cls.getResourceAsStream(str);
        StringBuilder sb = new StringBuilder();
        streamAppend(sb, resourceAsStream);
        return sb.toString();
    }

    public static String ifEmpty(String str, String str2) {
        return (str == null || str.isEmpty()) ? str2 : str;
    }

    public static String ifEmptyNullArgs(String str, String str2, String str3) {
        return (str == null || str.isEmpty()) ? str2 : str3;
    }

    public static <T> T ifNull(T t, T t2) {
        return t == null ? t2 : t;
    }

    public static <T> T ifNullOr(T t, boolean z, T t2) {
        return (t == null || z) ? t2 : t;
    }

    public static String ifNullOrBlank(String str, String str2) {
        return (str == null || isBlank(str)) ? str2 : str;
    }

    public static String ifNullOrEmpty(String str, String str2) {
        return (str == null || str.isEmpty()) ? str2 : str;
    }

    public static <T> T ifNullOrNot(T t, boolean z, T t2) {
        return (t == null || !z) ? t2 : t;
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isIn(String str, String... strArr) {
        if (str == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWhiteSpaceNoEOL(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return false;
            }
        }
        return true;
    }

    public static String join(Collection<String> collection, String str, String str2, String str3, String str4) {
        StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            AbstractC1974b.m1332y(sbM1324q, str3, it.next(), str4);
        }
        sbM1324q.append(str2);
        return sbM1324q.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$removeIf$0(BiFunction biFunction, Map.Entry entry) {
        return (Boolean) biFunction.apply(entry.getKey(), entry.getValue());
    }

    public static int max(int i, int... iArr) {
        for (int i2 : iArr) {
            if (i < i2) {
                i = i2;
            }
        }
        return i;
    }

    public static int maxLimit(int i, int... iArr) {
        return min(i, iArr);
    }

    public static int min(int i, int... iArr) {
        for (int i2 : iArr) {
            if (i > i2) {
                i = i2;
            }
        }
        return i;
    }

    public static int minLimit(int i, int... iArr) {
        return max(i, iArr);
    }

    public static String orEmpty(String str) {
        return str == null ? "" : str;
    }

    public static String prefixWith(String str, char c) {
        return prefixWith(str, c, false);
    }

    public static <K, V> V putIfMissing(Map<K, V> map, K k, Supplier<V> supplier) {
        V v = map.get(k);
        if (v != null) {
            return v;
        }
        V v4 = supplier.get();
        map.put(k, v4);
        return v4;
    }

    @NotNull
    public static String quoteJavaString(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        escapeJavaString(sb, charSequence);
        sb.append("\"");
        return sb.toString();
    }

    public static int rangeLimit(int i, int i2, int i4) {
        return Math.min(Math.max(i, i2), i4);
    }

    public static String regexGroup(String str) {
        return AbstractC0541b.m773o("(?:", orEmpty(str), ")");
    }

    public static boolean regionMatches(CharSequence charSequence, int i, String str, int i2, int i4, boolean z) {
        if (z) {
            for (int i5 = 0; i5 < i4; i5++) {
                if (Character.toLowerCase(charSequence.charAt(i5 + i)) != Character.toLowerCase(str.charAt(i5 + i2))) {
                    return false;
                }
            }
            return true;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            if (charSequence.charAt(i6 + i) != str.charAt(i6 + i2)) {
                return false;
            }
        }
        return true;
    }

    public static String removeAnyPrefix(String str, String... strArr) {
        if (str == null) {
            return "";
        }
        for (String str2 : strArr) {
            if (str.startsWith(String.valueOf(str2))) {
                return str.substring(str2.length());
            }
        }
        return str;
    }

    public static String removeAnySuffix(String str, String... strArr) {
        if (str == null) {
            return "";
        }
        for (String str2 : strArr) {
            if (str.endsWith(String.valueOf(str2))) {
                return str.substring(0, str.length() - str2.length());
            }
        }
        return str;
    }

    public static <K, V> void removeIf(Map<K, V> map, Function<Map.Entry<K, V>, Boolean> function) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (function.apply(entry).booleanValue()) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
    }

    public static String removePrefix(String str, char c) {
        return str != null ? str.startsWith(String.valueOf(c)) ? str.substring(1) : str : "";
    }

    public static String removePrefixIncluding(String str, String str2) {
        if (str == null) {
            return "";
        }
        int iIndexOf = str.indexOf(str2);
        return iIndexOf != -1 ? str.substring(str2.length() + iIndexOf) : str;
    }

    public static String removeSuffix(String str, char c) {
        return str != null ? str.endsWith(String.valueOf(c)) ? AbstractC2322a.m1614d(1, 0, str) : str : "";
    }

    public static String repeat(String str, int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() * i);
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return sb.toString();
            }
            sb.append(str);
            i = i2;
        }
    }

    public static <T> T setOrAdd(@NotNull List<T> list, int i, T t) {
        if (i != list.size()) {
            return list.set(i, t);
        }
        list.add(t);
        return null;
    }

    public static String splice(String[] strArr, String str) {
        StringBuilder sb = new StringBuilder((str.length() + 10) * strArr.length);
        int length = strArr.length;
        String str2 = "";
        int iM2213d = 0;
        while (iM2213d < length) {
            iM2213d = AbstractC2821a.m2213d(sb, iM2213d, 1, str2, strArr[iM2213d]);
            str2 = str;
        }
        return sb.toString();
    }

    public static boolean startsWith(String str, String... strArr) {
        return startsWith(str, false, strArr);
    }

    public static void streamAppend(StringBuilder sb, InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            try {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            return;
                        } else {
                            sb.append(line);
                            sb.append('\n');
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                bufferedReader.close();
                return;
            }
        }
    }

    public static <T> List<? extends T> stringSorted(Collection<? extends T> collection, Function<T, String> function) {
        ArrayList arrayList = new ArrayList(collection);
        arrayList.sort(Comparator.comparing(function));
        return arrayList;
    }

    public static String suffixWith(String str, char c) {
        return suffixWith(str, c, false);
    }

    public static String suffixWithEol(String str) {
        return suffixWith(str, '\n', false);
    }

    public static String urlDecode(String str, String str2) {
        if (str2 == null) {
            str2 = "UTF-8";
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException | IllegalArgumentException unused) {
            return orEmpty(str);
        }
    }

    public static String urlEncode(String str, String str2) {
        if (str2 == null) {
            str2 = "UTF-8";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return orEmpty(str);
        }
    }

    public static <K, V> Map<K, V> withDefaults(Map<K, V> map, Map<K, V> map2) {
        HashMap map3 = new HashMap(map);
        for (Map.Entry<K, V> entry : map2.entrySet()) {
            putIfMissing(map3, entry.getKey(), new C0230b(entry, 4));
        }
        return map3;
    }

    public static String wrapWith(String str, char c) {
        return wrapWith(str, c, c);
    }

    public static boolean endsWith(String str, boolean z, String... strArr) {
        if (str == null) {
            return false;
        }
        if (z) {
            for (String str2 : strArr) {
                if (str.length() >= str2.length() && str.substring(str.length() - str2.length()).equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        } else {
            for (String str3 : strArr) {
                if (str.endsWith(str3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String ifEmpty(String str, String str2, String str3) {
        return (str == null || str.isEmpty()) ? str2 : str3;
    }

    public static <T> T ifNullOr(T t, Function<T, Boolean> function, T t2) {
        return (t == null || function.apply(t).booleanValue()) ? t2 : t;
    }

    public static <T> T ifNullOrNot(T t, Function<T, Boolean> function, T t2) {
        return (t == null || !function.apply(t).booleanValue()) ? t2 : t;
    }

    public static float max(float f, float... fArr) {
        for (float f4 : fArr) {
            if (f < f4) {
                f = f4;
            }
        }
        return f;
    }

    public static float maxLimit(float f, float... fArr) {
        return min(f, fArr);
    }

    public static float min(float f, float... fArr) {
        for (float f4 : fArr) {
            if (f > f4) {
                f = f4;
            }
        }
        return f;
    }

    public static float minLimit(float f, float... fArr) {
        return max(f, fArr);
    }

    public static String prefixWith(String str, char c, boolean z) {
        if (str == null || str.isEmpty() || startsWith(str, String.valueOf(c), z)) {
            return orEmpty(str);
        }
        return c + str;
    }

    public static float rangeLimit(float f, float f4, float f5) {
        return Math.min(Math.max(f, f4), f5);
    }

    public static boolean startsWith(String str, boolean z, String... strArr) {
        if (str == null) {
            return false;
        }
        if (z) {
            for (String str2 : strArr) {
                if (str.length() >= str2.length() && str.substring(0, str2.length()).equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        } else {
            for (String str3 : strArr) {
                if (str.startsWith(str3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String suffixWith(String str, char c, boolean z) {
        if (str == null || str.isEmpty() || endsWith(str, String.valueOf(c), z)) {
            return orEmpty(str);
        }
        return str + c;
    }

    public static String wrapWith(String str, char c, char c2) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        return c + str + c2;
    }

    public static int count(String str, String str2, int i, int i2) {
        int i4 = 0;
        if (str == null) {
            return 0;
        }
        int iMin = Math.min(str.length(), i2);
        while (i >= 0 && i <= iMin) {
            int iIndexOf = str.indexOf(str2, i);
            if (iIndexOf < 0 || iIndexOf > iMin) {
                break;
            }
            i4++;
            i = iIndexOf + 1;
        }
        return i4;
    }

    public static <T, S extends T> S getOrNull(@NotNull List<T> list, int i, Class<S> cls) {
        if (i >= 0 && i < list.size()) {
            T t = list.get(i);
            if (cls.isInstance(t)) {
                return t;
            }
        }
        return null;
    }

    public static String ifEmpty(String str, Supplier<String> supplier) {
        return (str == null || str.isEmpty()) ? supplier.get() : str;
    }

    public static String wrapWith(String str, String str2) {
        return wrapWith(str, str2, str2);
    }

    public static String removePrefix(String str, String str2) {
        if (str != null) {
            return str.startsWith(String.valueOf(str2)) ? str.substring(str2.length()) : str;
        }
        return "";
    }

    public static String wrapWith(String str, String str2, String str3) {
        return (str == null || str.isEmpty()) ? "" : prefixWith(suffixWith(str, str3), str2);
    }

    public static void escapeJavaString(@NotNull StringBuilder sb, @NotNull CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == 0) {
                sb.append("\\0");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt == '\f') {
                sb.append("\\f");
            } else if (cCharAt != '\r') {
                switch (cCharAt) {
                    case '\b':
                        sb.append("\\b");
                        break;
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    default:
                        if (cCharAt < ' ') {
                            sb.append('%');
                            sb.append(String.format("%02x", Integer.valueOf(cCharAt)));
                        } else {
                            sb.append(cCharAt);
                        }
                        break;
                }
            } else {
                sb.append("\\r");
            }
        }
    }

    public static String ifEmpty(String str, Supplier<String> supplier, Supplier<String> supplier2) {
        return (str == null || str.isEmpty()) ? supplier.get() : supplier2.get();
    }

    public static String prefixWith(String str, String str2) {
        return prefixWith(str, str2, false);
    }

    public static String suffixWith(String str, String str2) {
        return suffixWith(str, str2, false);
    }

    public static boolean endsWith(CharSequence charSequence, String str, boolean z) {
        return charSequence.length() >= str.length() && regionMatches(charSequence, charSequence.length() - str.length(), str, 0, str.length(), z);
    }

    public static String prefixWith(String str, String str2, boolean z) {
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty() && !startsWith(str, str2, z)) {
            return str2.concat(str);
        }
        return orEmpty(str);
    }

    public static String removeSuffix(String str, String str2) {
        if (str != null) {
            return str.endsWith(String.valueOf(str2)) ? str.substring(0, str.length() - str2.length()) : str;
        }
        return "";
    }

    public static boolean startsWith(CharSequence charSequence, String str, boolean z) {
        return charSequence.length() >= str.length() && regionMatches(charSequence, 0, str, 0, str.length(), z);
    }

    public static String suffixWith(String str, String str2, boolean z) {
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty() && !endsWith(str, str2, z)) {
            return str.concat(str2);
        }
        return orEmpty(str);
    }

    public static <K, V> void removeIf(Map<K, V> map, BiFunction<K, V, Boolean> biFunction) {
        removeIf(map, new C0332a(biFunction, 10));
    }

    public static String splice(Collection<String> collection, String str, boolean z) {
        StringBuilder sb = new StringBuilder((str.length() + 10) * collection.size());
        String str2 = "";
        for (String str3 : collection) {
            if ((str3 != null && !str3.isEmpty()) || !z) {
                if (!z || (!str3.startsWith(str) && !endsWith(sb.toString(), str))) {
                    sb.append(str2);
                }
                sb.append(orEmpty(str3));
                str2 = str;
            }
        }
        return sb.toString();
    }

    public static String join(String[] strArr, String str, String str2, String str3, String str4) {
        StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
        for (String str5 : strArr) {
            sbM1324q.append(str3);
            sbM1324q.append(str5);
            sbM1324q.append(str4);
        }
        sbM1324q.append(str2);
        return sbM1324q.toString();
    }
}
