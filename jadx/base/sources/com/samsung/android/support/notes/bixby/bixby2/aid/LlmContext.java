package com.samsung.android.support.notes.bixby.bixby2.aid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/aid/LlmContext;", "", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "value", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/AppContextValue;", "getValue", "()Lcom/samsung/android/support/notes/bixby/bixby2/aid/AppContextValue;", "setValue", "(Lcom/samsung/android/support/notes/bixby/bixby2/aid/AppContextValue;)V", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LlmContext {

    @NotNull
    private String type = "none";

    @Nullable
    private AppContextValue value;

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final AppContextValue getValue() {
        return this.value;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final void setValue(@Nullable AppContextValue appContextValue) {
        this.value = appContextValue;
    }
}
