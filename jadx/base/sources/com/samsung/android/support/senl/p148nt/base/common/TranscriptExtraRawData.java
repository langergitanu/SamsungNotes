package com.samsung.android.support.senl.p148nt.base.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/TranscriptExtraRawData;", "", "<init>", "()V", "VERSION", "", "getVERSION", "()I", "paragraphInfo", "", "getParagraphInfo", "()Ljava/lang/String;", "setParagraphInfo", "(Ljava/lang/String;)V", "timeStamp", "getTimeStamp", "setTimeStamp", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TranscriptExtraRawData {
    private final int VERSION = 1;

    @NotNull
    private String paragraphInfo = "";

    @NotNull
    private String timeStamp = "";

    @NotNull
    public final String getParagraphInfo() {
        return this.paragraphInfo;
    }

    @NotNull
    public final String getTimeStamp() {
        return this.timeStamp;
    }

    public final int getVERSION() {
        return this.VERSION;
    }

    public final void setParagraphInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.paragraphInfo = str;
    }

    public final void setTimeStamp(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeStamp = str;
    }
}
