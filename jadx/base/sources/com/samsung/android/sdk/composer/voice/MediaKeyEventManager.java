package com.samsung.android.sdk.composer.voice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioTrack;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.util.Log;
import android.view.KeyEvent;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 %2\u00020\u0001:\u0002$%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bJ\b\u0010\u0018\u001a\u00020\u000bH\u0002J\u0006\u0010\u0019\u001a\u00020\u000bJ\u001e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u000fJ\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/MediaKeyEventManager;", "", "<init>", "()V", "mContextHashCode", "", "mMediaSession", "Landroid/media/session/MediaSession;", "mMediaStateBuilder", "Landroid/media/session/PlaybackState$Builder;", "createMediaSession", "", "context", "Landroid/content/Context;", "isRecord", "", "addInnerStateListener", "removeInnerStateListener", "mListener", "Lcom/samsung/android/sdk/composer/voice/SpenVoiceListenerManager$OnInnerStateChanged;", "getMListener", "()Lcom/samsung/android/sdk/composer/voice/SpenVoiceListenerManager$OnInnerStateChanged;", "setMListener", "(Lcom/samsung/android/sdk/composer/voice/SpenVoiceListenerManager$OnInnerStateChanged;)V", "initMediaSession", "releaseMediaSession", "updateMediaSessionState", "state", "position", "", "speed", "", "isActive", "triggerMediaSessionCallback", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "MediaSessionCallback", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class MediaKeyEventManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "Voice_MediaKeyEventManager";

    @SuppressLint({"StaticFieldLeak"})
    @Nullable
    private static MediaKeyEventManager mInstance;
    private int mContextHashCode;

    @NotNull
    private SpenVoiceListenerManager.OnInnerStateChanged mListener;

    @Nullable
    private MediaSession mMediaSession;

    @Nullable
    private PlaybackState.Builder mMediaStateBuilder;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/MediaKeyEventManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/sdk/composer/voice/MediaKeyEventManager;", "getInstance", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final MediaKeyEventManager getInstance() {
            if (MediaKeyEventManager.mInstance == null) {
                MediaKeyEventManager.mInstance = new MediaKeyEventManager(null);
            }
            MediaKeyEventManager mediaKeyEventManager = MediaKeyEventManager.mInstance;
            Intrinsics.checkNotNull(mediaKeyEventManager);
            return mediaKeyEventManager;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/MediaKeyEventManager$MediaSessionCallback;", "Landroid/media/session/MediaSession$Callback;", "<init>", "(Lcom/samsung/android/sdk/composer/voice/MediaKeyEventManager;)V", "onMediaButtonEvent", "", "mediaButtonIntent", "Landroid/content/Intent;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class MediaSessionCallback extends MediaSession.Callback {
        public MediaSessionCallback() {
        }

        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(@NotNull Intent mediaButtonIntent) {
            int keyCode;
            Intrinsics.checkNotNullParameter(mediaButtonIntent, "mediaButtonIntent");
            KeyEvent keyEvent = (KeyEvent) mediaButtonIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            if (keyEvent == null) {
                return false;
            }
            AbstractC0541b.m783y(keyEvent.getAction(), keyEvent.getKeyCode(), "onMediaButtonEvent - action : ", " key code : ", MediaKeyEventManager.TAG);
            if (keyEvent.getAction() == 0 && ((keyCode = keyEvent.getKeyCode()) == 79 || keyCode == 85 || keyCode == 126 || keyCode == 127)) {
                Log.d(MediaKeyEventManager.TAG, "onMediaButtonEvent] KeyEvent.ACTION_DOWN start ");
                if (VoiceManager.isRecording()) {
                    Log.d(MediaKeyEventManager.TAG, "onMediaButtonEvent] KeyEvent.ACTION_DOWN] isRecording ");
                    VoiceManager.stopRecording();
                } else if (VoiceManager.isRecordingPaused()) {
                    Log.d(MediaKeyEventManager.TAG, "onMediaButtonEvent] KeyEvent.ACTION_DOWN] isRecordingPaused ");
                    VoiceManager.stopRecording();
                } else if (VoiceManager.isPlaying()) {
                    Log.d(MediaKeyEventManager.TAG, "onMediaButtonEvent] KeyEvent.ACTION_DOWN] isPlaying ");
                    VoiceManager.pausePlaying();
                } else if (VoiceManager.isPlayingPaused()) {
                    Log.d(MediaKeyEventManager.TAG, "onMediaButtonEvent] KeyEvent.ACTION_DOWN] isPaused ");
                    VoiceManager.resumePlaying();
                }
                Log.d(MediaKeyEventManager.TAG, "onMediaButtonEvent] KeyEvent.ACTION_DOWN end ");
            }
            return super.onMediaButtonEvent(mediaButtonIntent);
        }
    }

    public /* synthetic */ MediaKeyEventManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final MediaKeyEventManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final void initMediaSession() {
        if (VoiceManager.isPlaying() || VoiceManager.isRecording()) {
            updateMediaSessionState(3, 0L, 0.0f);
        } else if (VoiceManager.isPlayingPaused() || VoiceManager.isRecordingPaused()) {
            updateMediaSessionState(2, 0L, 0.0f);
        } else {
            updateMediaSessionState(0, 0L, 0.0f);
        }
    }

    public final void addInnerStateListener() {
        SpenNoteVoiceManager.INSTANCE.addInnerStateListener(this.mListener);
    }

    public final void createMediaSession(@Nullable Context context, boolean isRecord) {
        if (context == null) {
            return;
        }
        if (this.mMediaSession != null) {
            if (context.hashCode() == this.mContextHashCode) {
                return;
            } else {
                releaseMediaSession();
            }
        }
        this.mContextHashCode = context.hashCode();
        MediaSession mediaSession = new MediaSession(context, TAG);
        this.mMediaSession = mediaSession;
        mediaSession.setCallback(new MediaSessionCallback());
        PlaybackState.Builder builder = new PlaybackState.Builder();
        this.mMediaStateBuilder = builder;
        MediaSession mediaSession2 = this.mMediaSession;
        if (mediaSession2 != null) {
            mediaSession2.setPlaybackState(builder.build());
        }
        if (isRecord) {
            AudioTrack audioTrack = new AudioTrack(3, 48000, 12, 2, AudioTrack.getMinBufferSize(48000, 12, 2), 1);
            try {
                try {
                    audioTrack.play();
                    audioTrack.stop();
                    Unit unit = Unit.INSTANCE;
                } catch (IllegalStateException e) {
                    Log.e(TAG, "createMediaSession exp: " + e.getMessage());
                }
                audioTrack.release();
            } catch (Throwable th) {
                audioTrack.release();
                throw th;
            }
        }
        initMediaSession();
    }

    @NotNull
    public final SpenVoiceListenerManager.OnInnerStateChanged getMListener() {
        return this.mListener;
    }

    public final boolean isActive() {
        MediaSession mediaSession = this.mMediaSession;
        return mediaSession != null && mediaSession.isActive();
    }

    public final void releaseMediaSession() {
        MediaSession mediaSession = this.mMediaSession;
        if (mediaSession != null) {
            mediaSession.setCallback(null);
            mediaSession.release();
        }
        this.mMediaSession = null;
        this.mMediaStateBuilder = null;
        this.mContextHashCode = 0;
    }

    public final void removeInnerStateListener() {
        SpenNoteVoiceManager.INSTANCE.removeInnerStateListener(this.mListener);
    }

    public final void setMListener(@NotNull SpenVoiceListenerManager.OnInnerStateChanged onInnerStateChanged) {
        Intrinsics.checkNotNullParameter(onInnerStateChanged, "<set-?>");
        this.mListener = onInnerStateChanged;
    }

    public final void triggerMediaSessionCallback(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        new MediaSessionCallback().onMediaButtonEvent(intent);
    }

    public final void updateMediaSessionState(int state, long position, float speed) {
        PlaybackState.Builder builder;
        if (this.mMediaSession == null || (builder = this.mMediaStateBuilder) == null) {
            return;
        }
        Intrinsics.checkNotNull(builder);
        builder.setState(state, position, speed);
        if (state == 2 || state == 3) {
            MediaSession mediaSession = this.mMediaSession;
            Intrinsics.checkNotNull(mediaSession);
            mediaSession.setActive(true);
            Log.i(TAG, "updateMediaSessionState - state : " + state + " setActive true");
        } else {
            MediaSession mediaSession2 = this.mMediaSession;
            Intrinsics.checkNotNull(mediaSession2);
            mediaSession2.setActive(false);
            Log.i(TAG, "updateMediaSessionState - state : " + state + " setActive false");
        }
        MediaSession mediaSession3 = this.mMediaSession;
        Intrinsics.checkNotNull(mediaSession3);
        PlaybackState.Builder builder2 = this.mMediaStateBuilder;
        Intrinsics.checkNotNull(builder2);
        mediaSession3.setPlaybackState(builder2.build());
    }

    private MediaKeyEventManager() {
        this.mListener = new SpenVoiceListenerManager.OnInnerStateChanged() { // from class: com.samsung.android.sdk.composer.voice.MediaKeyEventManager$mListener$1
            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onInfo(SpenObjectVoice objectVoice, int what) {
                Intrinsics.checkNotNullParameter(objectVoice, "objectVoice");
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onPlayComplete(SpenObjectVoice objectVoice, SpenVoiceData voiceData) {
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onPlayError(SpenObjectVoice objectVoice, SpenVoiceData voiceData, int errorCode) {
                this.this$0.updateMediaSessionState(0, 0L, 0.0f);
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onPlayInfo(SpenObjectVoice objectVoice, SpenVoiceData voiceData, int mediaInfo) {
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onPlayPaused(SpenObjectVoice objectVoice, SpenVoiceData voiceData) {
                this.this$0.updateMediaSessionState(2, 0L, 0.0f);
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onPlayPrepared(SpenObjectVoice objectVoice, SpenVoiceData voiceData, int duration) {
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onPlayResumed(SpenObjectVoice objectVoice, SpenVoiceData voiceData) {
                this.this$0.updateMediaSessionState(3, 0L, 0.0f);
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onPlaySeekComplete(SpenObjectVoice objectVoice, SpenVoiceData voiceData, int position) {
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onPlayStarted(SpenObjectVoice objectVoice, SpenVoiceData voiceData) {
                this.this$0.updateMediaSessionState(3, 0L, 0.0f);
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onPlayStopped(SpenObjectVoice objectVoice, SpenVoiceData voiceData) {
                this.this$0.updateMediaSessionState(0, 0L, 0.0f);
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onRecordCancelled(SpenVoiceData voiceData) {
                Intrinsics.checkNotNullParameter(voiceData, "voiceData");
                this.this$0.updateMediaSessionState(0, 0L, 0.0f);
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onRecordError(SpenVoiceData voiceData, int errorCode) {
                Intrinsics.checkNotNullParameter(voiceData, "voiceData");
                this.this$0.updateMediaSessionState(0, 0L, 0.0f);
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onRecordPaused(SpenVoiceData voiceData) {
                Intrinsics.checkNotNullParameter(voiceData, "voiceData");
                this.this$0.updateMediaSessionState(2, 0L, 0.0f);
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onRecordResumed(SpenVoiceData voiceData) {
                Intrinsics.checkNotNullParameter(voiceData, "voiceData");
                this.this$0.updateMediaSessionState(3, 0L, 0.0f);
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onRecordStarted(SpenVoiceData voiceData, String cachePath) {
                Intrinsics.checkNotNullParameter(voiceData, "voiceData");
                Intrinsics.checkNotNullParameter(cachePath, "cachePath");
                this.this$0.updateMediaSessionState(3, 0L, 0.0f);
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onRecordStopped(SpenVoiceData voiceData) {
                Intrinsics.checkNotNullParameter(voiceData, "voiceData");
                this.this$0.updateMediaSessionState(0, 0L, 0.0f);
            }

            @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
            public void onRecordUpdateTime(SpenVoiceData voiceData, int timeInSecond) {
                Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            }
        };
    }
}
