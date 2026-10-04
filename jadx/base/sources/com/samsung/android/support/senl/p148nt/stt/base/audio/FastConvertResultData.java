package com.samsung.android.support.senl.p148nt.stt.base.audio;

import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertResultData;", "", "textResult", "", "timingInfo", "", "speechInfoList", "", "Lcom/samsung/android/sivs/ai/sdkcommon/asr/SpeechInfo;", "isFinal", "", "mIsNeedGetRawText", "<init>", "(Ljava/lang/String;[ILjava/util/List;ZZ)V", "getTextResult", "()Ljava/lang/String;", "setTextResult", "(Ljava/lang/String;)V", "getTimingInfo", "()[I", "setTimingInfo", "([I)V", "getSpeechInfoList", "()Ljava/util/List;", "setSpeechInfoList", "(Ljava/util/List;)V", "()Z", "setFinal", "(Z)V", "setTimeInfo", "", "timeInfo", "ismIsNeedGetRawText", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FastConvertResultData {
    private boolean isFinal;
    private final boolean mIsNeedGetRawText;

    @Nullable
    private List<? extends SpeechInfo> speechInfoList;

    @Nullable
    private String textResult;

    @Nullable
    private int[] timingInfo;

    public FastConvertResultData(@Nullable String str, @Nullable int[] iArr, @Nullable List<? extends SpeechInfo> list, boolean z, boolean z2) {
        this.textResult = str;
        this.timingInfo = iArr;
        this.speechInfoList = list;
        this.isFinal = z;
        this.mIsNeedGetRawText = z2;
    }

    @Nullable
    public final List<SpeechInfo> getSpeechInfoList() {
        return this.speechInfoList;
    }

    @Nullable
    public final String getTextResult() {
        return this.textResult;
    }

    @Nullable
    public final int[] getTimingInfo() {
        return this.timingInfo;
    }

    /* JADX INFO: renamed from: isFinal, reason: from getter */
    public final boolean getIsFinal() {
        return this.isFinal;
    }

    /* JADX INFO: renamed from: ismIsNeedGetRawText, reason: from getter */
    public final boolean getMIsNeedGetRawText() {
        return this.mIsNeedGetRawText;
    }

    public final void setFinal(boolean z) {
        this.isFinal = z;
    }

    public final void setSpeechInfoList(@Nullable List<? extends SpeechInfo> list) {
        this.speechInfoList = list;
    }

    public final void setTextResult(@Nullable String str) {
        this.textResult = str;
    }

    public final void setTimeInfo(@NotNull int[] timeInfo) {
        Intrinsics.checkNotNullParameter(timeInfo, "timeInfo");
        this.timingInfo = timeInfo;
    }

    public final void setTimingInfo(@Nullable int[] iArr) {
        this.timingInfo = iArr;
    }
}
