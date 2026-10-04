package com.samsung.android.support.senl.p148nt.stt.picker.utils;

import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\tJ6\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\t2\u001e\u0010\u0012\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u0001`\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/utils/InitialKoreanUtil;", "", "<init>", "()V", "initials", "", "checkInitialCharacter", "", "input", "", "isInitialCharacter", "c", "", "getInitialCharacter", "character", "checkInitialTitle", "charArray", "title", "index", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InitialKoreanUtil {

    @NotNull
    public static final InitialKoreanUtil INSTANCE = new InitialKoreanUtil();

    @NotNull
    private static final char[] initials = {12593, 12594, 12596, 12599, 12600, 12601, 12609, 12610, 12611, 12613, 12614, 12615, 12616, 12617, 12618, 12619, 12620, 12621, 12622};

    private InitialKoreanUtil() {
    }

    private final char getInitialCharacter(char character) {
        int i;
        if (character < 44032 || (i = (character - 44032) / 588) >= 19) {
            return character;
        }
        String strSubstring = "ㄱㄲㄴㄷㄸㄹㅁㅂㅃㅅㅆㅇㅈㅉㅊㅋㅌㅍㅎ".substring(i, i + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring.charAt(0);
    }

    private final boolean isInitialCharacter(char c) {
        for (char c2 : initials) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    public final boolean checkInitialCharacter(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        char[] charArray = input.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        for (char c : charArray) {
            if (!isInitialCharacter(c)) {
                return false;
            }
        }
        return true;
    }

    public final boolean checkInitialTitle(@NotNull char[] charArray, @NotNull String title) {
        Intrinsics.checkNotNullParameter(charArray, "charArray");
        Intrinsics.checkNotNullParameter(title, "title");
        if (title.length() == 0 || charArray.length == 0) {
            return false;
        }
        int length = title.length();
        char[] cArr = new char[length];
        int length2 = title.length();
        for (int i = 0; i < length2; i++) {
            cArr[i] = getInitialCharacter(title.charAt(i));
        }
        char c = charArray[0];
        int i2 = 0;
        boolean z = false;
        while (i2 < title.length()) {
            if (c == cArr[i2]) {
                i2++;
                int i4 = 1;
                while (i4 < charArray.length && i2 < length) {
                    if (charArray[i4] != cArr[i2]) {
                        z = false;
                        break;
                    }
                    i4++;
                    i2++;
                }
                z = true;
                if (z) {
                    return z;
                }
            }
            i2++;
        }
        return z;
    }

    public final boolean checkInitialTitle(@NotNull char[] charArray, @NotNull String title, @Nullable ArrayList<Integer> index) {
        Intrinsics.checkNotNullParameter(charArray, "charArray");
        Intrinsics.checkNotNullParameter(title, "title");
        int iM1200a = 0;
        if (index == null) {
            return false;
        }
        index.clear();
        int length = title.length();
        char[] cArr = new char[length];
        int length2 = title.length();
        for (int i = 0; i < length2; i++) {
            cArr[i] = getInitialCharacter(title.charAt(i));
        }
        char c = charArray[0];
        boolean z = false;
        while (iM1200a < title.length()) {
            ArrayList arrayList = new ArrayList();
            if (c == cArr[iM1200a]) {
                iM1200a = AbstractC1038a.m1200a(iM1200a, iM1200a, 1, arrayList);
                int iM1200a2 = 1;
                while (iM1200a2 < charArray.length && iM1200a < length) {
                    if (charArray[iM1200a2] != cArr[iM1200a]) {
                        arrayList.clear();
                        break;
                    }
                    iM1200a2 = AbstractC1038a.m1200a(iM1200a, iM1200a2, 1, arrayList);
                    iM1200a++;
                }
                z = true;
            }
            index.addAll(arrayList);
            iM1200a++;
        }
        return z;
    }
}
