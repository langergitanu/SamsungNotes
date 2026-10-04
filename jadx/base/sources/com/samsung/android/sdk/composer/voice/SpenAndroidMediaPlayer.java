package com.samsung.android.sdk.composer.voice;

import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.voice.MediaPlayerInterface;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b(\b\u0000\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0019H\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0019H\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u0019H\u0016J \u0010)\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u0019H\u0016J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u001bH\u0016J\u0012\u00100\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u00102\u001a\u00020\u0019H\u0016J\b\u00103\u001a\u00020*H\u0016J\b\u00104\u001a\u00020*H\u0016J\b\u00105\u001a\u00020*H\u0016J \u00106\u001a\u00020*2\u0006\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u0016H\u0016J \u0010:\u001a\u00020\u00162\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010,\u001a\u00020\u0019H\u0016J \u0010<\u001a\u00020\u00162\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010,\u001a\u00020\u0019H\u0016J\u001a\u0010=\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00192\b\u0010>\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010?\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0019H\u0016J\b\u0010@\u001a\u00020*H\u0016J\u0010\u0010A\u001a\u00020*2\u0006\u0010B\u001a\u00020\u0014H\u0016J\b\u0010C\u001a\u00020\u0014H\u0016J\u0012\u0010D\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\n\u0010E\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010F\u001a\u0004\u0018\u00010\u000e2\u0006\u0010G\u001a\u00020\u0019H\u0002J\u0012\u0010H\u001a\u00020*2\b\u0010>\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010I\u001a\u00020*2\u0006\u00107\u001a\u00020\u0016H\u0002J\b\u0010J\u001a\u00020*H\u0002J\b\u0010K\u001a\u00020*H\u0002J\b\u0010L\u001a\u00020*H\u0002J\b\u0010M\u001a\u00020*H\u0002J\b\u0010N\u001a\u00020*H\u0002J\b\u0010O\u001a\u00020*H\u0002J\b\u0010P\u001a\u00020*H\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/SpenAndroidMediaPlayer;", "Lcom/samsung/android/sdk/composer/voice/MediaPlayerInterface;", "mMediaPlayerListener", "Lcom/samsung/android/sdk/composer/voice/MediaPlayerInterface$MediaPlayerListener;", "<init>", "(Lcom/samsung/android/sdk/composer/voice/MediaPlayerInterface$MediaPlayerListener;)V", "getMMediaPlayerListener", "()Lcom/samsung/android/sdk/composer/voice/MediaPlayerInterface$MediaPlayerListener;", "mMediaPlayer", "Landroid/media/MediaPlayer;", "mNextMediaPlayer", "mTempMediaPlayer", "mVoiceDataList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "mSpenObjectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "mMediaState", "Lcom/samsung/android/sdk/composer/voice/MediaPlayerInterface$MediaState;", "mSpeed", "", "mInitState", "", "mIsPausedBeforeSeek", "mCurrentIndex", "", "mSeekTime", "", "mOnPreparedListener", "Landroid/media/MediaPlayer$OnPreparedListener;", "mOnInfoListener", "Landroid/media/MediaPlayer$OnInfoListener;", "mOnSeekCompleteListener", "Landroid/media/MediaPlayer$OnSeekCompleteListener;", "mOnCompletionListener", "Landroid/media/MediaPlayer$OnCompletionListener;", "mOnErrorListener", "Landroid/media/MediaPlayer$OnErrorListener;", "initMediaPlayer", "path", "", "seekTo", "", "time", "index", "mode", "requestSeekToByTimeStamp", "timeStamp", "play", "voice", "getPlayProgress", "pausePlaying", "stopPlaying", "resumePlaying", "stopMediaPlayer", "isSwitchVoiceData", "isReleaseCurrentPlayer", "isReleaseNextPlayer", "initVoicePlayer", XmlErrorCodes.LIST, "playVoiceList", "insertVoiceData", "voiceData", "removeVoiceData", "updatePlayProgress", "setSpeed", "speed", "getSpeed", "initNextMediaPlayer", "getCurrentVoiceData", "getNextVoiceData", "currentIndex", "setNextPlayer", "pauseMediaPlayer", "resetMediaPlayer", "resetNextMediaPlayer", "releasePlayers", "releaseMediaPlayer", "releaseNextMediaPlayer", "clearVoiceList", "handleOnCompleted", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenAndroidMediaPlayer implements MediaPlayerInterface {
    private static final float NORMAL_PLAYBACK_SPEED = 1.0f;

    @NotNull
    private static final String TAG = "AndroidMediaPlayer";
    private int mCurrentIndex;
    private boolean mInitState;
    private boolean mIsPausedBeforeSeek;

    @Nullable
    private MediaPlayer mMediaPlayer;

    @Nullable
    private final MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener;

    @Nullable
    private MediaPlayer mNextMediaPlayer;

    @Nullable
    private SpenObjectVoice mSpenObjectVoice;

    @Nullable
    private MediaPlayer mTempMediaPlayer;

    @Nullable
    private ArrayList<SpenVoiceData> mVoiceDataList;

    @NotNull
    private MediaPlayerInterface.MediaState mMediaState = MediaPlayerInterface.MediaState.MEDIA_STATE_PREPARED;
    private float mSpeed = 1.0f;
    private long mSeekTime = -1;

    @NotNull
    private final MediaPlayer.OnPreparedListener mOnPreparedListener = new MediaPlayer.OnPreparedListener() { // from class: com.samsung.android.sdk.composer.voice.SpenAndroidMediaPlayer$mOnPreparedListener$1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mp) {
            if (mp == null) {
                return;
            }
            if (mp == this.this$0.mMediaPlayer) {
                MediaPlayer mediaPlayer = this.this$0.mMediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer);
                int duration = mediaPlayer.getDuration();
                Log.i("AndroidMediaPlayer", "onPrepared() duration: " + duration + ", object voice: " + this.this$0.mSpenObjectVoice);
                if (duration <= 0) {
                    this.this$0.stopPlaying();
                    return;
                }
                if (this.this$0.mSpenObjectVoice != null) {
                    this.this$0.clearVoiceList();
                    MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener = this.this$0.getMMediaPlayerListener();
                    if (mMediaPlayerListener != null) {
                        mMediaPlayerListener.onPrepared(duration, this.this$0.mSpenObjectVoice, null, false);
                    }
                    MediaPlayer mediaPlayer2 = this.this$0.mMediaPlayer;
                    if (mediaPlayer2 != null) {
                        mediaPlayer2.start();
                    }
                    MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener2 = this.this$0.getMMediaPlayerListener();
                    if (mMediaPlayerListener2 != null) {
                        mMediaPlayerListener2.onStarted(false);
                    }
                } else if (this.this$0.mVoiceDataList != null) {
                    SpenVoiceData currentVoiceData = this.this$0.getCurrentVoiceData();
                    if (currentVoiceData == null) {
                        return;
                    }
                    Log.i("AndroidMediaPlayer", "onPrepared() seekTime: " + this.this$0.mSeekTime);
                    if (this.this$0.mSeekTime >= 0) {
                        MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener3 = this.this$0.getMMediaPlayerListener();
                        if (mMediaPlayerListener3 != null) {
                            mMediaPlayerListener3.onPrepared(duration, null, currentVoiceData, true);
                        }
                    } else {
                        MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener4 = this.this$0.getMMediaPlayerListener();
                        if (mMediaPlayerListener4 != null) {
                            mMediaPlayerListener4.onPrepared(duration, null, currentVoiceData, false);
                        }
                    }
                    if (!this.this$0.mInitState) {
                        MediaPlayer mediaPlayer3 = this.this$0.mMediaPlayer;
                        Intrinsics.checkNotNull(mediaPlayer3);
                        mediaPlayer3.start();
                        MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener5 = this.this$0.getMMediaPlayerListener();
                        if (mMediaPlayerListener5 != null) {
                            mMediaPlayerListener5.onStarted(false);
                        }
                    }
                    if (this.this$0.mSeekTime >= 0) {
                        VoiceManager.seekTo((int) this.this$0.mSeekTime);
                        this.this$0.mSeekTime = -1L;
                        if (this.this$0.mIsPausedBeforeSeek) {
                            this.this$0.pauseMediaPlayer(false);
                            this.this$0.mIsPausedBeforeSeek = false;
                        }
                    }
                    SpenAndroidMediaPlayer spenAndroidMediaPlayer = this.this$0;
                    SpenVoiceData nextVoiceData = spenAndroidMediaPlayer.getNextVoiceData(spenAndroidMediaPlayer.mCurrentIndex);
                    if (nextVoiceData == null) {
                        Log.e("AndroidMediaPlayer", "onPrepared() next voice is null");
                        return;
                    }
                    this.this$0.setNextPlayer(nextVoiceData);
                }
            } else if (mp == this.this$0.mNextMediaPlayer) {
                Log.i("AndroidMediaPlayer", "onPrepared() current: " + this.this$0.mMediaPlayer + ", next: " + this.this$0.mNextMediaPlayer);
                if (this.this$0.mMediaPlayer != null && this.this$0.mMediaPlayer != this.this$0.mNextMediaPlayer) {
                    MediaPlayer mediaPlayer4 = this.this$0.mMediaPlayer;
                    Intrinsics.checkNotNull(mediaPlayer4);
                    mediaPlayer4.setNextMediaPlayer(this.this$0.mNextMediaPlayer);
                }
            }
            this.this$0.mMediaState = MediaPlayerInterface.MediaState.MEDIA_STATE_PREPARED;
        }
    };

    @NotNull
    private final MediaPlayer.OnInfoListener mOnInfoListener = new MediaPlayer.OnInfoListener() { // from class: com.samsung.android.sdk.composer.voice.SpenAndroidMediaPlayer$mOnInfoListener$1
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int what, int extra) {
            MediaPlayer mediaPlayer2 = this.this$0.mNextMediaPlayer;
            MediaPlayerInterface.MediaState mediaState = this.this$0.mMediaState;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(what, extra, "onInfo()what: ", ", extra: ", ", mediaPlayer: ");
            sbM1173s.append(mediaPlayer);
            sbM1173s.append(", next player: ");
            sbM1173s.append(mediaPlayer2);
            sbM1173s.append(", state: ");
            sbM1173s.append(mediaState);
            Log.i("AndroidMediaPlayer", sbM1173s.toString());
            MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener = this.this$0.getMMediaPlayerListener();
            if (mMediaPlayerListener != null) {
                mMediaPlayerListener.onInfo(what);
            }
            if (mediaPlayer == null || mediaPlayer != this.this$0.mNextMediaPlayer || what != 2) {
                return true;
            }
            if (this.this$0.mMediaState != MediaPlayerInterface.MediaState.MEDIA_STATE_COMPLETED) {
                this.this$0.handleOnCompleted();
            }
            PlaybackParams playbackParams = mediaPlayer.getPlaybackParams();
            Intrinsics.checkNotNullExpressionValue(playbackParams, "getPlaybackParams(...)");
            mediaPlayer.setPlaybackParams(playbackParams.setSpeed(this.this$0.mSpeed));
            MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener2 = this.this$0.getMMediaPlayerListener();
            if (mMediaPlayerListener2 != null) {
                mMediaPlayerListener2.onPrepared(mediaPlayer.getDuration(), null, this.this$0.getCurrentVoiceData(), false);
            }
            MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener3 = this.this$0.getMMediaPlayerListener();
            if (mMediaPlayerListener3 != null) {
                mMediaPlayerListener3.onStarted(false);
            }
            AbstractC2322a.m1631u(this.this$0.mCurrentIndex, "onInfo() current index: ", "AndroidMediaPlayer");
            SpenAndroidMediaPlayer spenAndroidMediaPlayer = this.this$0;
            SpenVoiceData nextVoiceData = spenAndroidMediaPlayer.getNextVoiceData(spenAndroidMediaPlayer.mCurrentIndex);
            if (nextVoiceData != null) {
                this.this$0.setNextPlayer(nextVoiceData);
            } else {
                this.this$0.mNextMediaPlayer = null;
            }
            this.this$0.mMediaState = MediaPlayerInterface.MediaState.NEXT_MEDIA_STATE_STARTED;
            return true;
        }
    };

    @NotNull
    private final MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener = new MediaPlayer.OnSeekCompleteListener() { // from class: com.samsung.android.sdk.composer.voice.SpenAndroidMediaPlayer$mOnSeekCompleteListener$1
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (mediaPlayer == null) {
                return;
            }
            int currentPosition = mediaPlayer.getCurrentPosition();
            AbstractC2322a.m1631u(currentPosition, "onSeekComplete() position: ", "AndroidMediaPlayer");
            MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener = this.this$0.getMMediaPlayerListener();
            if (mMediaPlayerListener != null) {
                mMediaPlayerListener.onSeekComplete(currentPosition);
            }
        }
    };

    @NotNull
    private final MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.samsung.android.sdk.composer.voice.SpenAndroidMediaPlayer$mOnCompletionListener$1
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (mediaPlayer == null) {
                return;
            }
            AbstractC6670b.m4744e(mediaPlayer.getCurrentPosition(), mediaPlayer.getDuration(), "onCompletion() position: ", ", duration: ", "AndroidMediaPlayer");
            if (this.this$0.mSpenObjectVoice != null) {
                this.this$0.clearVoiceList();
                MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener = this.this$0.getMMediaPlayerListener();
                if (mMediaPlayerListener != null) {
                    mMediaPlayerListener.onComplete();
                }
                this.this$0.releasePlayers();
                this.this$0.mSpenObjectVoice = null;
                return;
            }
            if (this.this$0.mVoiceDataList != null) {
                Log.i("AndroidMediaPlayer", "onCompletion() current index: " + this.this$0.mCurrentIndex + ", mediaPlayer: " + mediaPlayer + "mState: " + this.this$0.mMediaState);
                int i = this.this$0.mCurrentIndex;
                Intrinsics.checkNotNull(this.this$0.mVoiceDataList);
                if (i == r0.size() - 1) {
                    MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener2 = this.this$0.getMMediaPlayerListener();
                    if (mMediaPlayerListener2 != null) {
                        mMediaPlayerListener2.onComplete();
                    }
                    this.this$0.releasePlayers();
                    this.this$0.clearVoiceList();
                    this.this$0.mSpenObjectVoice = null;
                } else if (this.this$0.mMediaState == MediaPlayerInterface.MediaState.MEDIA_STATE_PREPARED) {
                    this.this$0.handleOnCompleted();
                }
                this.this$0.mMediaState = MediaPlayerInterface.MediaState.MEDIA_STATE_COMPLETED;
            }
        }
    };

    @NotNull
    private final MediaPlayer.OnErrorListener mOnErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.samsung.android.sdk.composer.voice.SpenAndroidMediaPlayer$mOnErrorListener$1
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
            if (what == 1) {
                AbstractC0541b.m758D(extra, "onError: MEDIA_ERROR_UNKNOWN extra : ", "AndroidMediaPlayer");
            } else if (what == 100) {
                AbstractC0541b.m758D(extra, "onError: MEDIA_ERROR_SERVER_DIED extra : ", "AndroidMediaPlayer");
            }
            int i = what == 1 ? SpenVoiceListenerManager.ERROR_UNSUPPORTED_FILE_TYPE : SpenVoiceListenerManager.ERROR_MEDIA_PLAYER;
            MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener = this.this$0.getMMediaPlayerListener();
            if (mMediaPlayerListener != null) {
                mMediaPlayerListener.onError(i);
            }
            this.this$0.releasePlayers();
            this.this$0.clearVoiceList();
            this.this$0.mSpenObjectVoice = null;
            return false;
        }
    };

    public SpenAndroidMediaPlayer(@Nullable MediaPlayerInterface.MediaPlayerListener mediaPlayerListener) {
        this.mMediaPlayerListener = mediaPlayerListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearVoiceList() {
        ArrayList<SpenVoiceData> arrayList = this.mVoiceDataList;
        Log.i(TAG, "clearVoiceList() voice list: " + (arrayList != null ? Integer.valueOf(arrayList.size()) : null));
        ArrayList<SpenVoiceData> arrayList2 = this.mVoiceDataList;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        this.mVoiceDataList = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpenVoiceData getCurrentVoiceData() {
        ArrayList<SpenVoiceData> arrayList = this.mVoiceDataList;
        if (arrayList == null) {
            Log.e(TAG, "getCurrentVoiceData() list is null");
            return null;
        }
        int i = this.mCurrentIndex;
        if (i >= 0) {
            Intrinsics.checkNotNull(arrayList);
            if (i < arrayList.size()) {
                ArrayList<SpenVoiceData> arrayList2 = this.mVoiceDataList;
                Intrinsics.checkNotNull(arrayList2);
                return arrayList2.get(this.mCurrentIndex);
            }
        }
        Log.e(TAG, "getCurrentVoiceData() index is invalid");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpenVoiceData getNextVoiceData(int currentIndex) {
        ArrayList<SpenVoiceData> arrayList = this.mVoiceDataList;
        if (arrayList == null) {
            Log.e(TAG, "getNextVoiceData() list is null");
            return null;
        }
        int i = currentIndex + 1;
        if (i >= 0) {
            Intrinsics.checkNotNull(arrayList);
            if (i < arrayList.size()) {
                ArrayList<SpenVoiceData> arrayList2 = this.mVoiceDataList;
                Intrinsics.checkNotNull(arrayList2);
                return arrayList2.get(i);
            }
        }
        AbstractC0541b.m758D(i, "getNextVoiceData() index is invalid ", TAG);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleOnCompleted() {
        ArrayList<SpenVoiceData> arrayList = this.mVoiceDataList;
        if (arrayList != null) {
            AbstractC6670b.m4744e(this.mCurrentIndex, arrayList.size(), "handleOnCompleted() index: ", ", size: ", TAG);
            MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
            if (mediaPlayerListener != null) {
                mediaPlayerListener.onComplete();
            }
            if (this.mCurrentIndex == arrayList.size() - 1 || this.mCurrentIndex == arrayList.size() - 2) {
                releaseMediaPlayer();
                this.mTempMediaPlayer = null;
            } else {
                this.mTempMediaPlayer = this.mMediaPlayer;
            }
            Log.i(TAG, "handleOnCompleted() current player: " + this.mMediaPlayer + ", next player: " + this.mNextMediaPlayer + ", temp player: " + this.mTempMediaPlayer);
            int i = this.mCurrentIndex;
            if (i >= 0 && i < arrayList.size() - 1) {
                this.mCurrentIndex++;
            }
            this.mMediaPlayer = this.mNextMediaPlayer;
        }
    }

    private final boolean initNextMediaPlayer(String path) {
        Log.i(TAG, "initNextMediaPlayer() current player: " + this.mNextMediaPlayer + ", temp player: " + this.mTempMediaPlayer);
        try {
            if (this.mNextMediaPlayer == null) {
                this.mNextMediaPlayer = new MediaPlayer();
                this.mTempMediaPlayer = null;
            } else {
                MediaPlayer mediaPlayer = this.mTempMediaPlayer;
                if (mediaPlayer != null) {
                    this.mNextMediaPlayer = mediaPlayer;
                    this.mTempMediaPlayer = null;
                }
                resetNextMediaPlayer();
            }
            MediaPlayer mediaPlayer2 = this.mNextMediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setOnPreparedListener(this.mOnPreparedListener);
                mediaPlayer2.setOnInfoListener(this.mOnInfoListener);
                mediaPlayer2.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
                mediaPlayer2.setOnErrorListener(this.mOnErrorListener);
                mediaPlayer2.setOnCompletionListener(this.mOnCompletionListener);
                mediaPlayer2.setDataSource(path);
                mediaPlayer2.prepareAsync();
                PlaybackParams playbackParams = mediaPlayer2.getPlaybackParams();
                Intrinsics.checkNotNullExpressionValue(playbackParams, "getPlaybackParams(...)");
                mediaPlayer2.setPlaybackParams(playbackParams.setSpeed(this.mSpeed));
            }
            Log.i(TAG, "initNextMediaPlayer() new player: " + this.mNextMediaPlayer);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "initNextMediaPlayer exception: " + e);
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pauseMediaPlayer(boolean isSwitchVoiceData) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !VoiceManager.isPlaying()) {
            return;
        }
        mediaPlayer.pause();
        MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
        if (mediaPlayerListener != null) {
            mediaPlayerListener.onPaused(isSwitchVoiceData);
        }
        this.mSeekTime = -1L;
    }

    private final void releaseMediaPlayer() {
        Log.i(TAG, "releaseMediaPlayer() current player: " + this.mMediaPlayer);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.mMediaPlayer = null;
    }

    private final void releaseNextMediaPlayer() {
        Log.i(TAG, "releaseNextMediaPlayer() next player: " + this.mNextMediaPlayer);
        MediaPlayer mediaPlayer = this.mNextMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.mNextMediaPlayer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releasePlayers() {
        Log.i(TAG, "releasePlayers() all player");
        releaseMediaPlayer();
        releaseNextMediaPlayer();
    }

    private final void resetMediaPlayer() {
        Log.i(TAG, "resetMediaPlayer() current player: " + this.mMediaPlayer);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
    }

    private final void resetNextMediaPlayer() {
        Log.i(TAG, "resetNextMediaPlayer() next player: " + this.mNextMediaPlayer);
        MediaPlayer mediaPlayer = this.mNextMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setNextPlayer(SpenVoiceData voiceData) {
        Log.i(TAG, "setNextPlayer() next player: " + this.mNextMediaPlayer + ", voiceData: " + voiceData);
        if (voiceData == null || initNextMediaPlayer(voiceData.getAttachedFile())) {
            return;
        }
        releaseNextMediaPlayer();
    }

    @Nullable
    public final MediaPlayerInterface.MediaPlayerListener getMMediaPlayerListener() {
        return this.mMediaPlayerListener;
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public int getPlayProgress() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public float getSpeed() {
        PlaybackParams playbackParams;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        return (mediaPlayer == null || (playbackParams = mediaPlayer.getPlaybackParams()) == null) ? this.mSpeed : playbackParams.getSpeed();
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public boolean initMediaPlayer(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Log.i(TAG, "initMediaPlayer() current player: " + this.mMediaPlayer);
        try {
            if (this.mMediaPlayer == null) {
                this.mMediaPlayer = new MediaPlayer();
            } else {
                resetMediaPlayer();
            }
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setOnPreparedListener(this.mOnPreparedListener);
                mediaPlayer.setOnInfoListener(this.mOnInfoListener);
                mediaPlayer.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
                mediaPlayer.setOnCompletionListener(this.mOnCompletionListener);
                mediaPlayer.setOnErrorListener(this.mOnErrorListener);
                mediaPlayer.setDataSource(path);
                mediaPlayer.prepareAsync();
                PlaybackParams playbackParams = mediaPlayer.getPlaybackParams();
                Intrinsics.checkNotNullExpressionValue(playbackParams, "getPlaybackParams(...)");
                mediaPlayer.setPlaybackParams(playbackParams.setSpeed(this.mSpeed));
            }
            Log.i(TAG, "initMediaPlayer() new player: " + this.mMediaPlayer);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "initMediaPlayer exception: " + e);
            e.printStackTrace();
            releasePlayers();
            return false;
        }
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public boolean initVoicePlayer(@Nullable ArrayList<SpenVoiceData> list, int index) {
        if (list == null) {
            Log.e(TAG, "initVoicePlayer() list is null");
            return false;
        }
        AbstractC6670b.m4744e(index, list.size(), "initVoicePlayer() index: ", ", size: ", TAG);
        if (index >= 0 && index < list.size()) {
            if (SpenNoteVoiceManager.INSTANCE.isPlayingActivated()) {
                stopMediaPlayer(false, false, true);
            }
            clearVoiceList();
            this.mSpenObjectVoice = null;
            this.mVoiceDataList = list;
            this.mCurrentIndex = index;
            this.mSeekTime = -1L;
            SpenVoiceData currentVoiceData = getCurrentVoiceData();
            this.mInitState = true;
            MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
            if (mediaPlayerListener != null && mediaPlayerListener.init(null, currentVoiceData)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public boolean insertVoiceData(int index, @Nullable SpenVoiceData voiceData) {
        if (voiceData == null) {
            Log.e(TAG, "insertVoiceData() voiceData is null");
            return false;
        }
        if (this.mVoiceDataList == null) {
            Log.e(TAG, "insertVoiceData() list is null");
            return false;
        }
        Log.i(TAG, "insertVoiceData() index: " + index + ", voiceData: " + voiceData);
        if (index >= 0) {
            ArrayList<SpenVoiceData> arrayList = this.mVoiceDataList;
            Intrinsics.checkNotNull(arrayList);
            if (index <= arrayList.size()) {
                if (!SpenNoteVoiceManager.INSTANCE.isPlayingActivated()) {
                    Log.e(TAG, "insertVoiceData() voice is not activated");
                    return false;
                }
                ArrayList<SpenVoiceData> arrayList2 = this.mVoiceDataList;
                Intrinsics.checkNotNull(arrayList2);
                arrayList2.add(index, voiceData);
                int i = this.mCurrentIndex;
                if (index <= i) {
                    this.mCurrentIndex = i + 1;
                } else if (index == i + 1) {
                    setNextPlayer(voiceData);
                }
                return true;
            }
        }
        AbstractC0541b.m758D(index, "insertVoiceData() index is invalid ", TAG);
        return false;
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void pausePlaying() {
        pauseMediaPlayer(false);
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public boolean play(@Nullable SpenObjectVoice voice) {
        if (voice == null) {
            return false;
        }
        if (SpenNoteVoiceManager.INSTANCE.isPlayingActivated()) {
            stopMediaPlayer(false, false, true);
        }
        clearVoiceList();
        this.mSpenObjectVoice = voice;
        MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
        return mediaPlayerListener != null && mediaPlayerListener.play(voice, null);
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public boolean playVoiceList(@Nullable ArrayList<SpenVoiceData> list, int index) {
        if (list == null) {
            Log.e(TAG, "playVoiceList() list is null");
            return false;
        }
        AbstractC6670b.m4744e(index, list.size(), "playVoiceList() index: ", ", size: ", TAG);
        if (index >= 0 && index < list.size()) {
            if (SpenNoteVoiceManager.INSTANCE.isPlayingActivated()) {
                stopMediaPlayer(false, false, true);
            }
            clearVoiceList();
            this.mSpenObjectVoice = null;
            this.mVoiceDataList = list;
            this.mCurrentIndex = index;
            this.mSeekTime = -1L;
            this.mInitState = false;
            SpenVoiceData currentVoiceData = getCurrentVoiceData();
            MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
            if (mediaPlayerListener != null && mediaPlayerListener.play(null, currentVoiceData)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public boolean removeVoiceData(int index) {
        if (this.mVoiceDataList == null) {
            Log.e(TAG, "removeVoiceData() list is null");
            return false;
        }
        AbstractC6670b.m4744e(index, this.mCurrentIndex, "removeVoiceData() index: ", ", current index: ", TAG);
        if (index >= 0) {
            ArrayList<SpenVoiceData> arrayList = this.mVoiceDataList;
            Intrinsics.checkNotNull(arrayList);
            if (index < arrayList.size()) {
                SpenNoteVoiceManager spenNoteVoiceManager = SpenNoteVoiceManager.INSTANCE;
                if (!spenNoteVoiceManager.isPlayingActivated()) {
                    Log.e(TAG, "removeVoiceData() voice is not activated");
                    return false;
                }
                int i = this.mCurrentIndex;
                if (index < i) {
                    this.mCurrentIndex = i - 1;
                    ArrayList<SpenVoiceData> arrayList2 = this.mVoiceDataList;
                    Intrinsics.checkNotNull(arrayList2);
                    arrayList2.remove(index);
                } else if (index == i) {
                    if (spenNoteVoiceManager.isPlayingActivated()) {
                        ArrayList<SpenVoiceData> arrayList3 = this.mVoiceDataList;
                        Intrinsics.checkNotNull(arrayList3);
                        if (index == arrayList3.size() - 1) {
                            stopMediaPlayer(false, true, true);
                        } else {
                            stopMediaPlayer(false, false, true);
                        }
                    }
                    SpenVoiceData nextVoiceData = getNextVoiceData(this.mCurrentIndex);
                    ArrayList<SpenVoiceData> arrayList4 = this.mVoiceDataList;
                    Intrinsics.checkNotNull(arrayList4);
                    arrayList4.remove(index);
                    MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
                    if (mediaPlayerListener != null) {
                        mediaPlayerListener.play(null, nextVoiceData);
                    }
                } else if (index == i + 1) {
                    ArrayList<SpenVoiceData> arrayList5 = this.mVoiceDataList;
                    Intrinsics.checkNotNull(arrayList5);
                    if (index == arrayList5.size() - 1) {
                        MediaPlayer mediaPlayer = this.mMediaPlayer;
                        if (mediaPlayer != null) {
                            mediaPlayer.setNextMediaPlayer(null);
                        }
                        releaseNextMediaPlayer();
                        ArrayList<SpenVoiceData> arrayList6 = this.mVoiceDataList;
                        Intrinsics.checkNotNull(arrayList6);
                        Intrinsics.checkNotNull(arrayList6.remove(index));
                    } else {
                        ArrayList<SpenVoiceData> arrayList7 = this.mVoiceDataList;
                        Intrinsics.checkNotNull(arrayList7);
                        arrayList7.remove(index);
                        setNextPlayer(getNextVoiceData(this.mCurrentIndex + 1));
                    }
                }
                return true;
            }
        }
        AbstractC0541b.m758D(index, "removeVoiceData() index is invalid ", TAG);
        return false;
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void requestSeekToByTimeStamp(long timeStamp) {
        ArrayList<SpenVoiceData.VoiceProperty> voicePropertyList;
        long timeStamp2;
        long timeStamp3;
        Log.i(TAG, "requestSeekToByTimeStamp() timeStamp: " + timeStamp);
        if (timeStamp < 0) {
            Log.e(TAG, "requestSeekToByTimeStamp() timeStamp was negative");
            return;
        }
        ArrayList<SpenVoiceData> arrayList = this.mVoiceDataList;
        if (arrayList == null) {
            Log.e(TAG, "requestSeekToByTimeStamp() list is null");
            return;
        }
        Intrinsics.checkNotNull(arrayList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ArrayList<SpenVoiceData> arrayList2 = this.mVoiceDataList;
            Intrinsics.checkNotNull(arrayList2);
            SpenVoiceData spenVoiceData = arrayList2.get(i);
            if (spenVoiceData != null && (voicePropertyList = spenVoiceData.getVoicePropertyList()) != null) {
                int size2 = voicePropertyList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    SpenVoiceData.VoiceProperty voiceProperty = voicePropertyList.get(i2);
                    Intrinsics.checkNotNullExpressionValue(voiceProperty, "get(...)");
                    SpenVoiceData.VoiceProperty voiceProperty2 = voiceProperty;
                    int i4 = voiceProperty2.action;
                    if (i4 == 1) {
                        timeStamp2 = voiceProperty2.getTimeStamp();
                        timeStamp3 = 0;
                    } else if (i4 != 4) {
                        timeStamp2 = 0;
                        timeStamp3 = 0;
                    } else {
                        timeStamp3 = voiceProperty2.getTimeStamp();
                        timeStamp2 = 0;
                    }
                    if (timeStamp >= timeStamp2 && timeStamp <= timeStamp3) {
                        int playingTime = SpenNoteVoiceManager.getPlayingTime(spenVoiceData, timeStamp);
                        if (playingTime > 0) {
                            VoiceManager.seekTo(i, playingTime);
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void resumePlaying() {
        if (AudioFocus.isCalling()) {
            SpenNoteVoiceManager.toastVoiceMessage(SpenVoiceListenerManager.ERROR_IS_CALLING_PLAY);
            return;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            Log.i(TAG, "resumePlaying() current player: " + mediaPlayer);
            PlaybackParams playbackParams = mediaPlayer.getPlaybackParams();
            Intrinsics.checkNotNullExpressionValue(playbackParams, "getPlaybackParams(...)");
            float speed = playbackParams.getSpeed();
            float f = this.mSpeed;
            if (speed != f) {
                mediaPlayer.setPlaybackParams(playbackParams.setSpeed(f));
            }
            mediaPlayer.start();
            MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
            if (mediaPlayerListener != null) {
                mediaPlayerListener.onResumed();
            }
        }
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void seekTo(int time) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(time);
        }
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void setSpeed(float speed) {
        AbstractC4539a.m3205o("setSpeed() ", TAG, speed);
        if (this.mSpeed == speed) {
            return;
        }
        this.mSpeed = speed;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !SpenNoteVoiceManager.INSTANCE.isPlaying()) {
            return;
        }
        PlaybackParams playbackParams = mediaPlayer.getPlaybackParams();
        Intrinsics.checkNotNullExpressionValue(playbackParams, "getPlaybackParams(...)");
        mediaPlayer.setPlaybackParams(playbackParams.setSpeed(speed));
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void stopMediaPlayer(boolean isSwitchVoiceData, boolean isReleaseCurrentPlayer, boolean isReleaseNextPlayer) {
        MediaPlayer mediaPlayer;
        AbstractC6670b.m4758s("stopMediaPlayer() isReleaseCurrentPlayer: ", ", isReleaseNextPlayer: ", TAG, isReleaseCurrentPlayer, isReleaseNextPlayer);
        if (!SpenNoteVoiceManager.INSTANCE.isPlayingActivated() || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        Log.i(TAG, "stopMediaPlayer() current player: " + mediaPlayer + ", next player: " + this.mNextMediaPlayer);
        mediaPlayer.stop();
        MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
        if (mediaPlayerListener != null) {
            mediaPlayerListener.onStopped(isSwitchVoiceData);
        }
        if (isReleaseCurrentPlayer) {
            releaseMediaPlayer();
        }
        if (isReleaseNextPlayer) {
            releaseNextMediaPlayer();
        }
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void stopPlaying() {
        stopMediaPlayer(false, true, true);
        clearVoiceList();
        this.mSpenObjectVoice = null;
        this.mSeekTime = -1L;
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void updatePlayProgress() {
        MediaPlayerInterface.MediaPlayerListener mediaPlayerListener;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || (mediaPlayerListener = this.mMediaPlayerListener) == null) {
            return;
        }
        Intrinsics.checkNotNull(mediaPlayer);
        mediaPlayerListener.onSeekComplete(mediaPlayer.getCurrentPosition());
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void seekTo(int index, int time) {
        AbstractC6670b.m4744e(index, time, "seekTo() index: ", ", time: ", TAG);
        ArrayList<SpenVoiceData> arrayList = this.mVoiceDataList;
        if (arrayList == null) {
            Log.e(TAG, "seekTo() list is null");
            return;
        }
        if (index >= 0) {
            Intrinsics.checkNotNull(arrayList);
            if (index < arrayList.size()) {
                if (index == this.mCurrentIndex) {
                    if (SpenNoteVoiceManager.INSTANCE.isPlayingActivated()) {
                        seekTo(time);
                        return;
                    } else {
                        this.mSeekTime = time;
                        return;
                    }
                }
                SpenNoteVoiceManager spenNoteVoiceManager = SpenNoteVoiceManager.INSTANCE;
                if (spenNoteVoiceManager.isPlayingActivated()) {
                    this.mIsPausedBeforeSeek = spenNoteVoiceManager.isPlayingPaused();
                    ArrayList<SpenVoiceData> arrayList2 = this.mVoiceDataList;
                    Intrinsics.checkNotNull(arrayList2);
                    if (index == arrayList2.size() - 1) {
                        stopMediaPlayer(true, false, true);
                    } else {
                        stopMediaPlayer(true, false, false);
                    }
                }
                this.mCurrentIndex = index;
                SpenVoiceData currentVoiceData = getCurrentVoiceData();
                MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
                if (mediaPlayerListener != null) {
                    mediaPlayerListener.play(null, currentVoiceData);
                }
                this.mSeekTime = time;
                return;
            }
        }
        AbstractC0541b.m758D(index, "seekTo() index is invalid ", TAG);
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void seekTo(long time, int mode) {
        Log.i(TAG, "seekTo() time: " + time + " mode: " + mode);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(time, mode);
        }
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void seekTo(int index, long time, int mode) {
        Log.i(TAG, "seekTo() index: " + index + ", time: " + time + " mode: " + mode);
        ArrayList<SpenVoiceData> arrayList = this.mVoiceDataList;
        if (arrayList == null) {
            Log.e(TAG, "seekTo() list is null");
            return;
        }
        if (index >= 0) {
            Intrinsics.checkNotNull(arrayList);
            if (index < arrayList.size()) {
                if (index == this.mCurrentIndex) {
                    if (SpenNoteVoiceManager.INSTANCE.isPlayingActivated()) {
                        seekTo(time, mode);
                        return;
                    } else {
                        this.mSeekTime = time;
                        return;
                    }
                }
                SpenNoteVoiceManager spenNoteVoiceManager = SpenNoteVoiceManager.INSTANCE;
                if (spenNoteVoiceManager.isPlayingActivated()) {
                    this.mIsPausedBeforeSeek = spenNoteVoiceManager.isPlayingPaused();
                    ArrayList<SpenVoiceData> arrayList2 = this.mVoiceDataList;
                    Intrinsics.checkNotNull(arrayList2);
                    if (index == arrayList2.size() - 1) {
                        stopMediaPlayer(true, false, true);
                    } else {
                        stopMediaPlayer(true, false, false);
                    }
                }
                this.mCurrentIndex = index;
                SpenVoiceData currentVoiceData = getCurrentVoiceData();
                MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
                if (mediaPlayerListener != null) {
                    mediaPlayerListener.play(null, currentVoiceData);
                }
                this.mSeekTime = time;
                return;
            }
        }
        AbstractC0541b.m758D(index, "seekTo() index is invalid ", TAG);
    }
}
