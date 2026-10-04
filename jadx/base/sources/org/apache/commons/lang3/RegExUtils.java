package org.apache.commons.lang3;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class RegExUtils {
    @Deprecated
    public RegExUtils() {
    }

    public static Pattern dotAll(String str) {
        return Pattern.compile(str, 32);
    }

    public static Matcher dotAllMatcher(String str, CharSequence charSequence) {
        return dotAll(str).matcher(charSequence);
    }

    public static String removeAll(CharSequence charSequence, Pattern pattern) {
        return replaceAll(charSequence, pattern, "");
    }

    public static String removeFirst(CharSequence charSequence, Pattern pattern) {
        return replaceFirst(charSequence, pattern, "");
    }

    public static String removePattern(CharSequence charSequence, String str) {
        return replacePattern(charSequence, str, "");
    }

    public static String replaceAll(CharSequence charSequence, Pattern pattern, String str) {
        return ObjectUtils.anyNull(charSequence, pattern, str) ? toStringOrNull(charSequence) : pattern.matcher(charSequence).replaceAll(str);
    }

    public static String replaceFirst(CharSequence charSequence, Pattern pattern, String str) {
        return (charSequence == null || pattern == null || str == null) ? toStringOrNull(charSequence) : pattern.matcher(charSequence).replaceFirst(str);
    }

    public static String replacePattern(CharSequence charSequence, String str, String str2) {
        return ObjectUtils.anyNull(charSequence, str, str2) ? toStringOrNull(charSequence) : dotAllMatcher(str, charSequence).replaceAll(str2);
    }

    private static String toStringOrNull(CharSequence charSequence) {
        return Objects.toString(charSequence, null);
    }

    @Deprecated
    public static Matcher dotAllMatcher(String str, String str2) {
        return dotAll(str).matcher(str2);
    }

    @Deprecated
    public static String removeAll(String str, Pattern pattern) {
        return replaceAll((CharSequence) str, pattern, "");
    }

    @Deprecated
    public static String removeFirst(String str, Pattern pattern) {
        return replaceFirst(str, pattern, "");
    }

    @Deprecated
    public static String removePattern(String str, String str2) {
        return replacePattern((CharSequence) str, str2, "");
    }

    public static String removeAll(String str, String str2) {
        return replaceAll(str, str2, "");
    }

    public static String removeFirst(String str, String str2) {
        return replaceFirst(str, str2, "");
    }

    @Deprecated
    public static String replaceFirst(String str, Pattern pattern, String str2) {
        return replaceFirst((CharSequence) str, pattern, str2);
    }

    @Deprecated
    public static String replaceAll(String str, Pattern pattern, String str2) {
        return replaceAll((CharSequence) str, pattern, str2);
    }

    public static String replaceFirst(String str, String str2, String str3) {
        return (str == null || str2 == null || str3 == null) ? str : str.replaceFirst(str2, str3);
    }

    @Deprecated
    public static String replacePattern(String str, String str2, String str3) {
        return replacePattern((CharSequence) str, str2, str3);
    }

    public static String replaceAll(String str, String str2, String str3) {
        return ObjectUtils.anyNull(str, str2, str3) ? str : str.replaceAll(str2, str3);
    }
}
