package com.samsung.android.support.senl.p148nt.stt.base.audio;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertState;", "", "<init>", "()V", "IDLE", "", "TRANSLATION", "PAUSED", "PREPARING", "WAITING", "DECODING", "TEXT_CONVERTING", "CONVERT_DONE", "CONVERT_ERROR", "CONVERT_CANCELED", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FastConvertState {
    public static final int CONVERT_CANCELED = 17;
    public static final int CONVERT_DONE = 15;
    public static final int CONVERT_ERROR = 16;
    public static final int DECODING = 13;
    public static final int IDLE = 1;

    @NotNull
    public static final FastConvertState INSTANCE = new FastConvertState();
    public static final int PAUSED = 3;
    public static final int PREPARING = 11;
    public static final int TEXT_CONVERTING = 14;
    public static final int TRANSLATION = 2;
    public static final int WAITING = 12;

    private FastConvertState() {
    }
}
