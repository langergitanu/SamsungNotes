package com.samsung.android.support.senl.p148nt.base.common.util;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.text.TextUtilsCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J!\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u0016JO\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u001fJ0\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020!2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/HighlightTextUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "setHighlightText", "Landroid/text/SpannableString;", "content", "highlightText", "textPaint", "Landroid/text/TextPaint;", "highlightBgColor", "", "originText", "highlightTexts", "", "paint", "createSearchHighlightPattern", "", "Ljava/util/regex/Pattern;", "searchString", "(Ljava/lang/String;)[Ljava/util/regex/Pattern;", "startHighlightingFrom", "highlightMessage", "Landroid/text/SpannableStringBuilder;", "highlights", "smileyStart", "", "smileyEnd", "buf", "([Ljava/util/regex/Pattern;[I[ILandroid/text/SpannableStringBuilder;ILandroid/text/TextPaint;)Landroid/text/SpannableStringBuilder;", "highlightRegional", "", "m", "Ljava/util/regex/Matcher;", "isBufTextReplaced", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHighlightTextUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HighlightTextUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/HighlightTextUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,225:1\n739#2,9:226\n37#3:235\n36#3,3:236\n*S KotlinDebug\n*F\n+ 1 HighlightTextUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/HighlightTextUtils\n*L\n81#1:226,9\n81#1:235\n81#1:236,3\n*E\n"})
public final class HighlightTextUtils {

    @NotNull
    public static final HighlightTextUtils INSTANCE = new HighlightTextUtils();

    @NotNull
    private static final String TAG = "HighlightTextUtils";
    private static int startHighlightingFrom;

    private HighlightTextUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pattern[] createSearchHighlightPattern(String searchString) {
        String[] strArr;
        List listM13999t;
        List listEmptyList;
        Pattern[] patternArr = null;
        if (TextUtils.isEmpty(searchString)) {
            return null;
        }
        if (searchString == null || (listM13999t = AbstractC12991c.m13999t(0, "\\s+", searchString)) == null) {
            strArr = null;
        } else if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
            if (listEmptyList == null) {
            }
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
            if (listEmptyList == null) {
                strArr = (String[]) listEmptyList.toArray(new String[0]);
            }
        }
        if (strArr != null) {
            patternArr = new Pattern[strArr.length];
            Iterator it = ArrayIteratorKt.iterator(strArr);
            int i = 0;
            while (it.hasNext()) {
                String str = (String) it.next();
                boolean z = str.length() != 1;
                Pattern patternCompile = Pattern.compile("[$*()+|<>?{}\\[\\]\\{\\}\\^\\\\\\.]");
                StringBuilder sb = new StringBuilder(str);
                for (int length = str.length() - 1; -1 < length; length--) {
                    if (patternCompile.matcher(str.subSequence(length, length + 1)).find()) {
                        sb.insert(length, "\\");
                    }
                    if (z && !Character.isLowSurrogate(str.charAt(length)) && length != 0) {
                        sb.insert(length, "[\\s]{0,}");
                    }
                }
                patternArr[i] = Pattern.compile(sb.toString(), 2);
                i++;
            }
        }
        return patternArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00ec A[Catch: IllegalArgumentException -> 0x010f, TryCatch #1 {IllegalArgumentException -> 0x010f, blocks: (B:12:0x001f, B:14:0x002a, B:16:0x002f, B:18:0x0036, B:20:0x003b, B:22:0x003f, B:25:0x0044, B:27:0x004c, B:34:0x0065, B:29:0x0054, B:31:0x005c, B:36:0x006a, B:38:0x0074, B:39:0x008c, B:43:0x00c1, B:54:0x00ec, B:55:0x00f2, B:57:0x00fd, B:59:0x0101, B:50:0x00ce), top: B:66:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SpannableStringBuilder highlightMessage(Pattern[] highlights, int[] smileyStart, int[] smileyEnd, SpannableStringBuilder buf, int highlightBgColor, TextPaint textPaint) {
        Matcher matcher;
        TextPaint textPaint2;
        char[] cArrSemGetPrefixCharForSpan;
        if (highlights != null && smileyStart != null && smileyEnd != null && buf != null) {
            Iterator it = ArrayIteratorKt.iterator(highlights);
            while (it.hasNext()) {
                Pattern pattern = (Pattern) it.next();
                if (pattern != null) {
                    try {
                        matcher = pattern.matcher(buf.toString());
                    } catch (IllegalArgumentException unused) {
                        Logger.m8698e(TAG, "IllegalArgumentException");
                    }
                } else {
                    matcher = null;
                }
                startHighlightingFrom = 0;
                while (matcher != null && matcher.find()) {
                    int length = smileyStart.length;
                    boolean z = false;
                    for (int i = 0; i < length && (smileyStart[i] != 0 || smileyEnd[i] != 0); i++) {
                        if ((matcher.start() >= smileyStart[i] && matcher.start() < smileyEnd[i]) || (matcher.end() > smileyStart[i] && matcher.end() <= smileyEnd[i])) {
                            z = true;
                        }
                    }
                    if (!z) {
                        int iEnd = matcher.end();
                        if (buf.length() < iEnd) {
                            iEnd = buf.length();
                            Logger.m8698e(TAG, "highligh end=" + iEnd);
                        }
                        int iStart = iEnd;
                        if (DeviceInfo.isSemDevice()) {
                            try {
                                TextUtilsCompat textUtilsCompat = TextUtilsCompat.INSTANCE;
                                String string = buf.toString();
                                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                                String strSubstring = string.substring(matcher.start());
                                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                String strGroup = matcher.group();
                                Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
                                char[] charArray = strGroup.toCharArray();
                                Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
                                textPaint2 = textPaint;
                                try {
                                    cArrSemGetPrefixCharForSpan = textUtilsCompat.semGetPrefixCharForSpan(textPaint2, strSubstring, charArray);
                                } catch (NoSuchMethodError e) {
                                    e = e;
                                    Logger.m8698e(TAG, "highlightMessage: NoSuchMethodError] " + e.getMessage());
                                    cArrSemGetPrefixCharForSpan = null;
                                }
                            } catch (IllegalArgumentException unused2) {
                                Logger.m8698e(TAG, "IllegalArgumentException");
                            } catch (NoSuchMethodError e2) {
                                e = e2;
                                textPaint2 = textPaint;
                            }
                            if (cArrSemGetPrefixCharForSpan != null) {
                                iStart = matcher.start() + cArrSemGetPrefixCharForSpan.length;
                            }
                            int i2 = iStart;
                            if (highlightRegional(buf, matcher, false, textPaint2, highlightBgColor) && startHighlightingFrom <= 0) {
                                buf.setSpan(new ForegroundColorSpan(highlightBgColor), matcher.start(), i2, 0);
                            }
                        } else {
                            textPaint2 = textPaint;
                        }
                        cArrSemGetPrefixCharForSpan = null;
                        if (cArrSemGetPrefixCharForSpan != null) {
                        }
                        int i22 = iStart;
                        if (highlightRegional(buf, matcher, false, textPaint2, highlightBgColor)) {
                        }
                    }
                }
            }
        }
        return buf;
    }

    private final boolean highlightRegional(SpannableStringBuilder buf, Matcher m, boolean isBufTextReplaced, TextPaint textPaint, int highlightBgColor) {
        char[] cArrSemGetPrefixCharForSpan;
        if (!DeviceInfo.isSemDevice()) {
            return false;
        }
        try {
            if (startHighlightingFrom <= 0) {
                TextUtilsCompat textUtilsCompat = TextUtilsCompat.INSTANCE;
                String string = buf.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                String strGroup = m.group();
                Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
                char[] charArray = strGroup.toCharArray();
                Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
                cArrSemGetPrefixCharForSpan = textUtilsCompat.semGetPrefixCharForSpan(textPaint, string, charArray);
            } else {
                TextUtilsCompat textUtilsCompat2 = TextUtilsCompat.INSTANCE;
                String string2 = buf.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                String strSubstring = string2.substring(startHighlightingFrom);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String strGroup2 = m.group();
                Intrinsics.checkNotNullExpressionValue(strGroup2, "group(...)");
                char[] charArray2 = strGroup2.toCharArray();
                Intrinsics.checkNotNullExpressionValue(charArray2, "toCharArray(...)");
                cArrSemGetPrefixCharForSpan = textUtilsCompat2.semGetPrefixCharForSpan(textPaint, strSubstring, charArray2);
            }
        } catch (NoSuchMethodError e) {
            AbstractC4539a.m3214x("highlightRegional: NoSuchMethodError] ", e.getMessage(), TAG);
            cArrSemGetPrefixCharForSpan = null;
        }
        if (cArrSemGetPrefixCharForSpan == null) {
            return false;
        }
        Pattern[] patternArrCreateSearchHighlightPattern = createSearchHighlightPattern(new String(cArrSemGetPrefixCharForSpan));
        if (patternArrCreateSearchHighlightPattern != null) {
            Iterator it = ArrayIteratorKt.iterator(patternArrCreateSearchHighlightPattern);
            while (it.hasNext()) {
                Pattern pattern = (Pattern) it.next();
                Matcher matcher = pattern != null ? pattern.matcher(buf.toString()) : null;
                while (true) {
                    if (matcher == null || !matcher.find()) {
                        break;
                    }
                    if (matcher.start() >= startHighlightingFrom) {
                        int iStart = matcher.start();
                        int iEnd = matcher.end();
                        if (isBufTextReplaced) {
                            buf.setSpan(new BackgroundColorSpan(highlightBgColor), iStart, (int) Math.min(buf.length(), iEnd), 0);
                        } else {
                            buf.setSpan(new BackgroundColorSpan(highlightBgColor), iStart, iEnd, 0);
                        }
                        startHighlightingFrom = iEnd;
                    }
                }
            }
        }
        return true;
    }

    @JvmStatic
    @NotNull
    public static final SpannableString setHighlightText(@NotNull SpannableString content, @Nullable String highlightText, @NotNull TextPaint textPaint, int highlightBgColor) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        if (TextUtils.isEmpty(highlightText)) {
            return content;
        }
        HighlightTextUtils highlightTextUtils = INSTANCE;
        Pattern[] patternArrCreateSearchHighlightPattern = highlightTextUtils.createSearchHighlightPattern(highlightText);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) content);
        SpannableString spannableStringValueOf = SpannableString.valueOf(highlightTextUtils.highlightMessage(patternArrCreateSearchHighlightPattern, new int[0], new int[0], spannableStringBuilder, highlightBgColor, textPaint));
        Intrinsics.checkNotNullExpressionValue(spannableStringValueOf, "valueOf(...)");
        return spannableStringValueOf;
    }

    @JvmStatic
    @NotNull
    public static final SpannableString setHighlightText(@NotNull SpannableString originText, @NotNull List<String> highlightTexts, @NotNull TextPaint paint, int highlightBgColor) {
        Intrinsics.checkNotNullParameter(originText, "originText");
        Intrinsics.checkNotNullParameter(highlightTexts, "highlightTexts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (highlightTexts.isEmpty()) {
            return originText;
        }
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        List<String> mutableList = CollectionsKt.toMutableList((Collection) highlightTexts);
        int length = 0;
        for (String str : mutableList) {
            if (!TextUtils.isEmpty(str)) {
                length += str.length();
            }
        }
        Pattern[] patternArr = new Pattern[length];
        Iterator it = mutableList.iterator();
        int i = 0;
        while (it.hasNext()) {
            Pattern[] patternArrCreateSearchHighlightPattern = INSTANCE.createSearchHighlightPattern((String) it.next());
            if (patternArrCreateSearchHighlightPattern != null) {
                for (Pattern pattern : patternArrCreateSearchHighlightPattern) {
                    if (length > i) {
                        patternArr[i] = pattern;
                        i++;
                    }
                }
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) originText);
        SpannableString spannableStringValueOf = SpannableString.valueOf(INSTANCE.highlightMessage(patternArr, iArr, iArr2, spannableStringBuilder, highlightBgColor, paint));
        Intrinsics.checkNotNullExpressionValue(spannableStringValueOf, "valueOf(...)");
        return spannableStringValueOf;
    }
}
