package com.samsung.android.sdk.composer.voice;

import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002'(J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH&J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0012\u001a\u00020\tH&J\b\u0010\u0013\u001a\u00020\u0007H&J\b\u0010\u0014\u001a\u00020\u0007H&J\b\u0010\u0015\u001a\u00020\u0007H&J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H&J \u0010\u001a\u001a\u00020\u00032\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\n\u001a\u00020\tH&J \u0010\u001e\u001a\u00020\u00032\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\n\u001a\u00020\tH&J\u001a\u0010\u001f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001dH&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\"\u001a\u00020\u0007H&J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%H&J\b\u0010&\u001a\u00020%H&¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/MediaPlayerInterface;", "", "initMediaPlayer", "", "path", "", "seekTo", "", "time", "", "index", "", "mode", "requestSeekToByTimeStamp", "timeStamp", "play", "voice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "getPlayProgress", "pausePlaying", "stopPlaying", "resumePlaying", "stopMediaPlayer", "isSwitchVoiceData", "isReleaseCurrentPlayer", "isReleaseNextPlayer", "initVoicePlayer", XmlErrorCodes.LIST, "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "playVoiceList", "insertVoiceData", "voiceData", "removeVoiceData", "updatePlayProgress", "setSpeed", "speed", "", "getSpeed", "MediaState", "MediaPlayerListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface MediaPlayerInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0005H&J\u001c\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/MediaPlayerInterface$MediaPlayerListener;", "", "onPrepared", "", XmlErrorCodes.DURATION, "", "objectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "isSwitchVoiceData", "", "onStarted", "onInfo", "mediaInfo", "onStopped", "onPaused", "onResumed", "onComplete", "onSeekComplete", "position", "onError", "errorCode", "play", "init", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface MediaPlayerListener {
        boolean init(@Nullable SpenObjectVoice objectVoice, @Nullable SpenVoiceData voiceData);

        void onComplete();

        void onError(int errorCode);

        void onInfo(int mediaInfo);

        void onPaused(boolean isSwitchVoiceData);

        void onPrepared(int duration, @Nullable SpenObjectVoice objectVoice, @Nullable SpenVoiceData voiceData, boolean isSwitchVoiceData);

        void onResumed();

        void onSeekComplete(int position);

        void onStarted(boolean isSwitchVoiceData);

        void onStopped(boolean isSwitchVoiceData);

        boolean play(@Nullable SpenObjectVoice objectVoice, @Nullable SpenVoiceData voiceData);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/MediaPlayerInterface$MediaState;", "", "<init>", "(Ljava/lang/String;I)V", "MEDIA_STATE_PREPARED", "MEDIA_STATE_COMPLETED", "NEXT_MEDIA_STATE_STARTED", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class MediaState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MediaState[] $VALUES;
        public static final MediaState MEDIA_STATE_PREPARED = new MediaState("MEDIA_STATE_PREPARED", 0);
        public static final MediaState MEDIA_STATE_COMPLETED = new MediaState("MEDIA_STATE_COMPLETED", 1);
        public static final MediaState NEXT_MEDIA_STATE_STARTED = new MediaState("NEXT_MEDIA_STATE_STARTED", 2);

        private static final /* synthetic */ MediaState[] $values() {
            return new MediaState[]{MEDIA_STATE_PREPARED, MEDIA_STATE_COMPLETED, NEXT_MEDIA_STATE_STARTED};
        }

        static {
            MediaState[] mediaStateArr$values = $values();
            $VALUES = mediaStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(mediaStateArr$values);
        }

        private MediaState(String str, int i) {
        }

        @NotNull
        public static EnumEntries<MediaState> getEntries() {
            return $ENTRIES;
        }

        public static MediaState valueOf(String str) {
            return (MediaState) Enum.valueOf(MediaState.class, str);
        }

        public static MediaState[] values() {
            return (MediaState[]) $VALUES.clone();
        }
    }

    int getPlayProgress();

    float getSpeed();

    boolean initMediaPlayer(@NotNull String path);

    boolean initVoicePlayer(@Nullable ArrayList<SpenVoiceData> list, int index);

    boolean insertVoiceData(int index, @Nullable SpenVoiceData voiceData);

    void pausePlaying();

    boolean play(@Nullable SpenObjectVoice voice);

    boolean playVoiceList(@Nullable ArrayList<SpenVoiceData> list, int index);

    boolean removeVoiceData(int index);

    void requestSeekToByTimeStamp(long timeStamp);

    void resumePlaying();

    void seekTo(int time);

    void seekTo(int index, int time);

    void seekTo(int index, long time, int mode);

    void seekTo(long time, int mode);

    void setSpeed(float speed);

    void stopMediaPlayer(boolean isSwitchVoiceData, boolean isReleaseCurrentPlayer, boolean isReleaseNextPlayer);

    void stopPlaying();

    void updatePlayProgress();
}
