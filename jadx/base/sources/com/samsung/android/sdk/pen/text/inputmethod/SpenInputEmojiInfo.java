package com.samsung.android.sdk.pen.text.inputmethod;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/inputmethod/SpenInputEmojiInfo;", "", "categoryID", "", "emoticonCode", "", "<init>", "(ILjava/lang/String;)V", "getCategoryID", "()I", "getEmoticonCode", "()Ljava/lang/String;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenInputEmojiInfo {
    private final int categoryID;

    @NotNull
    private final String emoticonCode;

    public SpenInputEmojiInfo(int i, @NotNull String emoticonCode) {
        Intrinsics.checkNotNullParameter(emoticonCode, "emoticonCode");
        this.categoryID = i;
        this.emoticonCode = emoticonCode;
    }

    public final int getCategoryID() {
        return this.categoryID;
    }

    @NotNull
    public final String getEmoticonCode() {
        return this.emoticonCode;
    }
}
