package com.samsung.android.support.senl.p148nt.composer.main.base.model.voice;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceConstants;", "", "<init>", "()V", "AUDIO_PROGRESS", "", "RECORD_TIME", "RECORD_PLAYING_INDEX", "RECORD_PLAYING_PROGRESS", "VOICE_STATE", "VOICE_VIEW_STATE", "RECORD_DELETE_ITEM_INDEX", "VOICE_PLAY_SPEED", "VOICE_SYNC_ENABLE", "VOICE_SELECT_MODE", "PLAY_RECORDING_START", "AUDIO_ERASER_STATE", "VOICE_TEXT_ICON_ALPHA", "", "AUDIO_ERASER_MIN_VOICE_SUPPORT", "MEDIA_INFO_AUDIO_ERASER_INIT_COMPLETED", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceConstants {
    public static final int AUDIO_ERASER_MIN_VOICE_SUPPORT = 2;

    @NotNull
    public static final String AUDIO_ERASER_STATE = "AudioEraserState";

    @NotNull
    public static final String AUDIO_PROGRESS = "AudioProgress";

    @NotNull
    public static final VoiceConstants INSTANCE = new VoiceConstants();
    public static final int MEDIA_INFO_AUDIO_ERASER_INIT_COMPLETED = 10982;

    @NotNull
    public static final String PLAY_RECORDING_START = "PlayRecordingStart";

    @NotNull
    public static final String RECORD_DELETE_ITEM_INDEX = "RecordDeleteItemIndex";

    @NotNull
    public static final String RECORD_PLAYING_INDEX = "RecordPayingIndex";

    @NotNull
    public static final String RECORD_PLAYING_PROGRESS = "RecordPlayingProgress";

    @NotNull
    public static final String RECORD_TIME = "RecordTime";

    @NotNull
    public static final String VOICE_PLAY_SPEED = "VoicePlaySpeed";

    @NotNull
    public static final String VOICE_SELECT_MODE = "VoiceSelectMode";

    @NotNull
    public static final String VOICE_STATE = "VoiceState";

    @NotNull
    public static final String VOICE_SYNC_ENABLE = "VoiceSyncEnable";
    public static final int VOICE_TEXT_ICON_ALPHA = 230;

    @NotNull
    public static final String VOICE_VIEW_STATE = "VoiceViewState";

    private VoiceConstants() {
    }
}
