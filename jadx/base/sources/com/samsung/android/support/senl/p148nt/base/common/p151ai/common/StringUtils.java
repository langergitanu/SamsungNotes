package com.samsung.android.support.senl.p148nt.base.common.p151ai.common;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\u001c\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/common/StringUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DEBUG", "", "SIMILARITY_DIST_RATIO", "", "extractString", "input", "maxSize", "", "findSliceIndex", "lastIndex", "convertUnicodeToChar", "value", "convertUnexpectedChars", "isSimilarStrings", "source", "target", "getLevenshteinDistance", "getMinimum", "val1", "val2", "val3", "isAllLineFeeds", "str", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StringUtils {
    public static final boolean DEBUG = true;

    @NotNull
    public static final StringUtils INSTANCE = new StringUtils();
    private static final float SIMILARITY_DIST_RATIO = 0.35f;

    @NotNull
    private static final String TAG = "Ai$StringUtils";

    private StringUtils() {
    }

    @JvmStatic
    @NotNull
    public static final String convertUnexpectedChars(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String strConvertUnicodeToChar = INSTANCE.convertUnicodeToChar(StringsKt.m14139M(StringsKt.m14139M(StringsKt.m14139M(value, "\\\\n", ""), "\u200b", ""), "\\n", " "));
        if (!Intrinsics.areEqual(value, strConvertUnicodeToChar)) {
            Logger.m8697d(TAG, "convertUnexpectedChars: value and replacedValue are not same");
        }
        return strConvertUnicodeToChar;
    }

    private final String convertUnicodeToChar(String value) {
        StringBuilder sb = new StringBuilder(value.length());
        int i = 0;
        while (i < value.length()) {
            int i2 = i + 5;
            if (i2 < value.length() && value.charAt(i) == '\\' && value.charAt(i + 1) == 'u') {
                try {
                    String strSubstring = value.substring(i + 2, i + 6);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    sb.append((char) Integer.parseInt(strSubstring, CharsKt.checkRadix(16)));
                    i = i2;
                } catch (NumberFormatException e) {
                    Logger.m8698e(TAG, "convertUnicodeToChar# " + e.getMessage());
                    sb.append(value.charAt(i));
                }
            } else {
                sb.append(value.charAt(i));
            }
            i++;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    @NotNull
    public static final String extractString(@NotNull String input, int maxSize) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.length() <= maxSize) {
            return input;
        }
        String strSubstring = input.substring(0, INSTANCE.findSliceIndex(input, maxSize - 1));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        Logger.m8697d(TAG, "sliceString " + input.length() + " to " + strSubstring.length());
        return strSubstring;
    }

    private final int findSliceIndex(String input, int lastIndex) {
        int iMax = (int) Math.max((int) Math.max(StringsKt.m14131E(Extension.DOT, lastIndex, 4, input), Math.min(StringsKt.m14131E(org.apache.commons.lang3.StringUtils.f9761CR, lastIndex, 4, input), StringsKt.m14131E("\n\r", lastIndex, 4, input))), Math.min(StringsKt.m14131E("\n", lastIndex, 4, input), StringsKt.m14131E("\r\n", lastIndex, 4, input)));
        return iMax < 0 ? lastIndex : iMax;
    }

    @JvmStatic
    @VisibleForTesting
    public static final int getLevenshteinDistance(@NotNull String source, @NotNull String target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        int length = source.length();
        int length2 = target.length();
        int i = length + 1;
        int[][] iArr = new int[i][];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = new int[length2 + 1];
        }
        for (int i4 = 1; i4 < length; i4++) {
            iArr[i4][0] = i4;
        }
        for (int i5 = 1; i5 < length2; i5++) {
            iArr[0][i5] = i5;
        }
        for (int i6 = 1; i6 < length2; i6++) {
            for (int i7 = 1; i7 < length; i7++) {
                int i8 = i7 - 1;
                int i9 = i6 - 1;
                if (source.charAt(i8) == target.charAt(i9)) {
                    iArr[i7][i6] = iArr[i8][i9];
                } else {
                    int[] iArr2 = iArr[i7];
                    StringUtils stringUtils = INSTANCE;
                    int[] iArr3 = iArr[i8];
                    iArr2[i6] = stringUtils.getMinimum(iArr3[i6], iArr2[i9], iArr3[i9]) + 1;
                }
            }
        }
        return iArr[length - 1][length2 - 1];
    }

    private final int getMinimum(int val1, int val2, int val3) {
        if (val1 > val2) {
            val1 = val2;
        }
        return val1 > val3 ? val3 : val1;
    }

    @JvmStatic
    public static final boolean isAllLineFeeds(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.isEmpty(str != null ? StringsKt.m14139M(str, "\n", "") : null);
    }

    @JvmStatic
    public static final boolean isSimilarStrings(@Nullable String source, @Nullable String target) {
        boolean zIsEmpty = TextUtils.isEmpty(source);
        boolean zIsEmpty2 = TextUtils.isEmpty(target);
        if (zIsEmpty && zIsEmpty2) {
            return true;
        }
        if (!zIsEmpty && !zIsEmpty2) {
            Intrinsics.checkNotNull(source);
            Intrinsics.checkNotNull(target);
            if (getLevenshteinDistance(source, target) / ((int) Math.min(source.length(), target.length())) < 0.35f) {
                return true;
            }
        }
        return false;
    }
}
