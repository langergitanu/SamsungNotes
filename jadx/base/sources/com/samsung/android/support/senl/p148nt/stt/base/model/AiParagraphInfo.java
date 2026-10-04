package com.samsung.android.support.senl.p148nt.stt.base.model;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/AiParagraphInfo;", "", "speakerId", "", "startTime", "", "endTime", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "getSpeakerId", "()Ljava/lang/Integer;", "setSpeakerId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStartTime", "()Ljava/lang/Long;", "setStartTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getEndTime", "setEndTime", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiParagraphInfo {

    @Nullable
    private Long endTime;

    @Nullable
    private Integer speakerId;

    @Nullable
    private Long startTime;

    public AiParagraphInfo(@Nullable Integer num, @Nullable Long l, @Nullable Long l2) {
        this.speakerId = num;
        this.startTime = l;
        this.endTime = l2;
    }

    @Nullable
    public final Long getEndTime() {
        return this.endTime;
    }

    @Nullable
    public final Integer getSpeakerId() {
        return this.speakerId;
    }

    @Nullable
    public final Long getStartTime() {
        return this.startTime;
    }

    public final void setEndTime(@Nullable Long l) {
        this.endTime = l;
    }

    public final void setSpeakerId(@Nullable Integer num) {
        this.speakerId = num;
    }

    public final void setStartTime(@Nullable Long l) {
        this.startTime = l;
    }
}
