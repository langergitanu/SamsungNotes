package com.samsung.android.sdk.pen.recogengine.wrapper;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/wrapper/LanguageTool;", "", "<init>", "()V", "isSeparator", "", "c", "", "isDigit", "isEnglish", "isKorean", "isChinese", "isLatin", "str", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class LanguageTool {

    @NotNull
    public static final LanguageTool INSTANCE = new LanguageTool();

    private LanguageTool() {
    }

    public final boolean isChinese(char c) {
        return 19968 <= c && c < 40870;
    }

    public final boolean isDigit(char c) {
        return '0' <= c && c < ':';
    }

    public final boolean isEnglish(char c) {
        if ('A' > c || c >= '[') {
            return 'a' <= c && c < '{';
        }
        return true;
    }

    public final boolean isKorean(char c) {
        return 44032 <= c && c < 55204;
    }

    public final boolean isLatin(char c) {
        return ' ' <= c && c < 128;
    }

    public final boolean isSeparator(char c) {
        return c == ' ' || c == '\n' || c == '\r';
    }

    public final boolean isKorean(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!isKorean(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
