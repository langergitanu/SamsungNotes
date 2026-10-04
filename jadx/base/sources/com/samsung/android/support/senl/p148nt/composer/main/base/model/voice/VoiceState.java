package com.samsung.android.support.senl.p148nt.composer.main.base.model.voice;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceState;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "RECORD_INIT", "RECORD_STARTED", "RECORD_RESUMED", "RECORD_PROGRESS", "RECORD_PAUSE", "RECORD_IDLE", "PLAY_TOTAL_TIME_UPDATE", "PLAY_STARTED", "PLAY_PROGRESS", "PLAY_RESUMED", "PLAY_PAUSE", "PLAY_IDLE", "CANCEL", "ERROR", "INFO", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VoiceState[] $VALUES;
    public static final VoiceState NONE = new VoiceState(CoverStickerConstants.Category.NONE.NAME, 0);
    public static final VoiceState RECORD_INIT = new VoiceState("RECORD_INIT", 1);
    public static final VoiceState RECORD_STARTED = new VoiceState("RECORD_STARTED", 2);
    public static final VoiceState RECORD_RESUMED = new VoiceState("RECORD_RESUMED", 3);
    public static final VoiceState RECORD_PROGRESS = new VoiceState("RECORD_PROGRESS", 4);
    public static final VoiceState RECORD_PAUSE = new VoiceState("RECORD_PAUSE", 5);
    public static final VoiceState RECORD_IDLE = new VoiceState("RECORD_IDLE", 6);
    public static final VoiceState PLAY_TOTAL_TIME_UPDATE = new VoiceState("PLAY_TOTAL_TIME_UPDATE", 7);
    public static final VoiceState PLAY_STARTED = new VoiceState("PLAY_STARTED", 8);
    public static final VoiceState PLAY_PROGRESS = new VoiceState("PLAY_PROGRESS", 9);
    public static final VoiceState PLAY_RESUMED = new VoiceState("PLAY_RESUMED", 10);
    public static final VoiceState PLAY_PAUSE = new VoiceState("PLAY_PAUSE", 11);
    public static final VoiceState PLAY_IDLE = new VoiceState("PLAY_IDLE", 12);
    public static final VoiceState CANCEL = new VoiceState("CANCEL", 13);
    public static final VoiceState ERROR = new VoiceState("ERROR", 14);
    public static final VoiceState INFO = new VoiceState("INFO", 15);

    private static final /* synthetic */ VoiceState[] $values() {
        return new VoiceState[]{NONE, RECORD_INIT, RECORD_STARTED, RECORD_RESUMED, RECORD_PROGRESS, RECORD_PAUSE, RECORD_IDLE, PLAY_TOTAL_TIME_UPDATE, PLAY_STARTED, PLAY_PROGRESS, PLAY_RESUMED, PLAY_PAUSE, PLAY_IDLE, CANCEL, ERROR, INFO};
    }

    static {
        VoiceState[] voiceStateArr$values = $values();
        $VALUES = voiceStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(voiceStateArr$values);
    }

    private VoiceState(String str, int i) {
    }

    @NotNull
    public static EnumEntries<VoiceState> getEntries() {
        return $ENTRIES;
    }

    public static VoiceState valueOf(String str) {
        return (VoiceState) Enum.valueOf(VoiceState.class, str);
    }

    public static VoiceState[] values() {
        return (VoiceState[]) $VALUES.clone();
    }
}
