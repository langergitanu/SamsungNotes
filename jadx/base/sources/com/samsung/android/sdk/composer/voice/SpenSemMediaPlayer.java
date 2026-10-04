package com.samsung.android.sdk.composer.voice;

import android.media.PlaybackParams;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.media.SemFragmentedBackgroundMusic;
import com.samsung.android.media.SemMediaPlayer;
import com.samsung.android.sdk.composer.voice.MediaPlayerInterface;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b*\b\u0000\u0018\u0000 V2\u00020\u0001:\u0001VB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u001cH\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0014H\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0014H\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0014H\u0016J \u0010)\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010+\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0014H\u0016J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020-H\u0016J\u0012\u00101\u001a\u00020\u00182\b\u00102\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u00103\u001a\u00020\u0014H\u0016J\b\u00104\u001a\u00020*H\u0016J\b\u00105\u001a\u00020*H\u0016J\b\u00106\u001a\u00020*H\u0016J \u00107\u001a\u00020*2\u0006\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u0018H\u0016J \u0010;\u001a\u00020\u00182\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010,\u001a\u00020\u0014H\u0016J \u0010=\u001a\u00020\u00182\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010,\u001a\u00020\u0014H\u0016J\u001a\u0010>\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u00142\b\u0010?\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010@\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0014H\u0016J\b\u0010A\u001a\u00020*H\u0016J\u0010\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020\tH\u0016J\b\u0010D\u001a\u00020\tH\u0016J\u000e\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020\u0018J\u000e\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020\u001cJ\u0010\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020\u000bH\u0002J\n\u0010K\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010L\u001a\u0004\u0018\u00010\u000e2\u0006\u0010,\u001a\u00020\u0014H\u0002J\u0010\u0010M\u001a\u00020*2\u0006\u00108\u001a\u00020\u0018H\u0002J\b\u0010N\u001a\u00020*H\u0002J\b\u0010O\u001a\u00020*H\u0002J\b\u0010P\u001a\u00020*H\u0002J\b\u0010Q\u001a\u00020*H\u0002J\u0010\u0010R\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0014H\u0002J\u0010\u0010S\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0014H\u0002J\u0010\u0010T\u001a\u00020*2\u0006\u0010J\u001a\u00020\u000bH\u0002J\u0010\u0010U\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u001cH\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/SpenSemMediaPlayer;", "Lcom/samsung/android/sdk/composer/voice/MediaPlayerInterface;", "mMediaPlayerListener", "Lcom/samsung/android/sdk/composer/voice/MediaPlayerInterface$MediaPlayerListener;", "<init>", "(Lcom/samsung/android/sdk/composer/voice/MediaPlayerInterface$MediaPlayerListener;)V", "getMMediaPlayerListener", "()Lcom/samsung/android/sdk/composer/voice/MediaPlayerInterface$MediaPlayerListener;", "mSpeed", "", "mMediaPlayer", "Lcom/samsung/android/media/SemMediaPlayer;", "mVoiceDataList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "mSpenObjectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "mVoiceDataTimeList", "Ljava/util/Vector;", "Lkotlin/Pair;", "", "mCurrentIndex", "mSeekTime", "mInitState", "", "mIsPausedBeforeSeek", "mAudioEraserEnabled", "mAudioEraserCachePath", "", "mOnInitCompleteListener", "Lcom/samsung/android/media/SemMediaPlayer$OnInitCompleteListener;", "mOnInfoListener", "Lcom/samsung/android/media/SemMediaPlayer$OnInfoListener;", "mOnPlaybackCompleteListener", "Lcom/samsung/android/media/SemMediaPlayer$OnPlaybackCompleteListener;", "mOnSeekCompleteListener", "Lcom/samsung/android/media/SemMediaPlayer$OnSeekCompleteListener;", "mOnErrorListener", "Lcom/samsung/android/media/SemMediaPlayer$OnErrorListener;", "initMediaPlayer", "path", "seekTo", "", "time", "index", "", "mode", "requestSeekToByTimeStamp", "timeStamp", "play", "voice", "getPlayProgress", "pausePlaying", "stopPlaying", "resumePlaying", "stopMediaPlayer", "isSwitchVoiceData", "isReleaseCurrentPlayer", "isReleaseNextPlayer", "initVoicePlayer", XmlErrorCodes.LIST, "playVoiceList", "insertVoiceData", "voiceData", "removeVoiceData", "updatePlayProgress", "setSpeed", "speed", "getSpeed", "setAudioEraserEnabled", "enabled", "setAudioEraserCachePath", "eraserCachePath", "initFragmentedBackgroundMusic", "mediaPlayer", "getCurrentVoiceData", "getVoiceDataByIndex", "pauseMediaPlayer", "resetMediaPlayer", "releaseMediaPlayer", "clearVoiceList", "releaseData", "getStartPlayTime", "getDurationPlayTime", "updateCurrentVoiceIndex", "canRequestAudioEraserCachePath", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSemMediaPlayer implements MediaPlayerInterface {
    private static final int AUDIO_ERASER_DISABLED = 0;
    private static final int AUDIO_ERASER_ENABLED = 1;
    private static final int BGM_SET_COMPLETED = 10975;
    private static final int INITIAL_SEEK_TIME = -1;
    private static final int KEY_PARAMETER_ENABLE_AUDIO_ERASER = 36001;
    private static final int KEY_PARAMETER_ENABLE_AUDIO_ERASER_CACHE = 36002;
    private static final float NORMAL_PLAYBACK_SPEED = 1.0f;

    @NotNull
    private static final String TAG = "SemMediaPlayer";

    @Nullable
    private String mAudioEraserCachePath;
    private boolean mAudioEraserEnabled;
    private int mCurrentIndex;
    private boolean mInitState;
    private boolean mIsPausedBeforeSeek;

    @Nullable
    private SemMediaPlayer mMediaPlayer;

    @Nullable
    private final MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener;

    @Nullable
    private SpenObjectVoice mSpenObjectVoice;

    @Nullable
    private ArrayList<SpenVoiceData> mVoiceDataList;
    private float mSpeed = 1.0f;

    @NotNull
    private Vector<Pair<Integer, Integer>> mVoiceDataTimeList = new Vector<>();
    private int mSeekTime = -1;

    @NotNull
    private final SemMediaPlayer.OnInitCompleteListener mOnInitCompleteListener = new SemMediaPlayer.OnInitCompleteListener() { // from class: com.samsung.android.sdk.composer.voice.SpenSemMediaPlayer$mOnInitCompleteListener$1
        public void onInitComplete(SemMediaPlayer mediaPlayer, SemMediaPlayer.TrackInfo[] p1) throws IOException {
            SpenVoiceData currentVoiceData;
            Intrinsics.checkNotNullParameter(mediaPlayer, "mediaPlayer");
            Intrinsics.checkNotNullParameter(p1, "p1");
            this.this$0.initFragmentedBackgroundMusic(mediaPlayer);
            int duration = mediaPlayer.getDuration();
            Log.i("SemMediaPlayer", "onInitComplete() duration: " + duration + ", object voice: " + this.this$0.mSpenObjectVoice);
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
                mediaPlayer.start();
                MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener2 = this.this$0.getMMediaPlayerListener();
                if (mMediaPlayerListener2 != null) {
                    mMediaPlayerListener2.onStarted(false);
                    return;
                }
                return;
            }
            if (this.this$0.mVoiceDataList == null || (currentVoiceData = this.this$0.getCurrentVoiceData()) == null) {
                return;
            }
            AbstractC2322a.m1631u(this.this$0.mSeekTime, "onInitComplete() seekTime: ", "SemMediaPlayer");
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
            if (this.this$0.mInitState) {
                return;
            }
            mediaPlayer.start();
            MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener5 = this.this$0.getMMediaPlayerListener();
            if (mMediaPlayerListener5 != null) {
                mMediaPlayerListener5.onStarted(false);
            }
        }
    };

    @NotNull
    private final SemMediaPlayer.OnInfoListener mOnInfoListener = new SemMediaPlayer.OnInfoListener() { // from class: com.samsung.android.sdk.composer.voice.SpenSemMediaPlayer$mOnInfoListener$1
        public boolean onInfo(SemMediaPlayer mediaPlayer, int what, int extra) {
            Intrinsics.checkNotNullParameter(mediaPlayer, "mediaPlayer");
            StringBuilder sb = new StringBuilder("onInfo() what: ");
            sb.append(what);
            sb.append(" extra:");
            AbstractC0000a.m26w(sb, "SemMediaPlayer", extra);
            MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener = this.this$0.getMMediaPlayerListener();
            if (mMediaPlayerListener != null) {
                mMediaPlayerListener.onInfo(what);
            }
            if (what != 10975 || this.this$0.mSeekTime < 0) {
                return true;
            }
            SpenSemMediaPlayer spenSemMediaPlayer = this.this$0;
            spenSemMediaPlayer.seekTo(spenSemMediaPlayer.mSeekTime);
            this.this$0.mSeekTime = -1;
            if (!this.this$0.mIsPausedBeforeSeek) {
                return true;
            }
            this.this$0.pauseMediaPlayer(false);
            this.this$0.mIsPausedBeforeSeek = false;
            return true;
        }
    };

    @NotNull
    private final SemMediaPlayer.OnPlaybackCompleteListener mOnPlaybackCompleteListener = new SemMediaPlayer.OnPlaybackCompleteListener() { // from class: com.samsung.android.sdk.composer.voice.SpenSemMediaPlayer$mOnPlaybackCompleteListener$1
        public void onPlaybackComplete(SemMediaPlayer mediaPlayer) {
            Intrinsics.checkNotNullParameter(mediaPlayer, "mediaPlayer");
            int currentPosition = mediaPlayer.getCurrentPosition();
            int duration = mediaPlayer.getDuration();
            int iHashCode = mediaPlayer.hashCode();
            int i = this.this$0.mCurrentIndex;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(currentPosition, duration, "onPlaybackComplete() position: ", ", duration: ", " mediaPlayer= ");
            sbM1173s.append(iHashCode);
            sbM1173s.append(" mCurrentIndex= ");
            sbM1173s.append(i);
            Log.i("SemMediaPlayer", sbM1173s.toString());
            MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener = this.this$0.getMMediaPlayerListener();
            if (mMediaPlayerListener != null) {
                mMediaPlayerListener.onComplete();
            }
            this.this$0.releaseMediaPlayer();
            this.this$0.releaseData();
        }
    };

    @NotNull
    private final SemMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener = new SemMediaPlayer.OnSeekCompleteListener() { // from class: com.samsung.android.sdk.composer.voice.SpenSemMediaPlayer$mOnSeekCompleteListener$1
        public void onSeekComplete(SemMediaPlayer mediaPlayer) {
            Intrinsics.checkNotNullParameter(mediaPlayer, "mediaPlayer");
            int currentPosition = mediaPlayer.getCurrentPosition();
            SpenSemMediaPlayer spenSemMediaPlayer = this.this$0;
            int startPlayTime = spenSemMediaPlayer.getStartPlayTime(spenSemMediaPlayer.mCurrentIndex);
            if (startPlayTime >= 0) {
                currentPosition -= startPlayTime;
            }
            AbstractC2322a.m1631u(currentPosition, "onSeekComplete() position: ", "SemMediaPlayer");
            MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener = this.this$0.getMMediaPlayerListener();
            if (mMediaPlayerListener != null) {
                mMediaPlayerListener.onSeekComplete(currentPosition);
            }
        }
    };

    @NotNull
    private final SemMediaPlayer.OnErrorListener mOnErrorListener = new SemMediaPlayer.OnErrorListener() { // from class: com.samsung.android.sdk.composer.voice.SpenSemMediaPlayer$mOnErrorListener$1
        public boolean onError(SemMediaPlayer mediaPlayer, int what, int extra) {
            Intrinsics.checkNotNullParameter(mediaPlayer, "mediaPlayer");
            if (what == 1) {
                AbstractC0541b.m758D(extra, "onError: MEDIA_ERROR_UNKNOWN extra : ", "SemMediaPlayer");
            } else if (what == 100) {
                AbstractC0541b.m758D(extra, "onError: MEDIA_ERROR_SERVER_DIED extra : ", "SemMediaPlayer");
            }
            int i = what == 1 ? SpenVoiceListenerManager.ERROR_UNSUPPORTED_FILE_TYPE : SpenVoiceListenerManager.ERROR_MEDIA_PLAYER;
            MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener = this.this$0.getMMediaPlayerListener();
            if (mMediaPlayerListener != null) {
                mMediaPlayerListener.onError(i);
            }
            this.this$0.releaseMediaPlayer();
            this.this$0.releaseData();
            return false;
        }
    };

    public SpenSemMediaPlayer(@Nullable MediaPlayerInterface.MediaPlayerListener mediaPlayerListener) {
        this.mMediaPlayerListener = mediaPlayerListener;
    }

    private final boolean canRequestAudioEraserCachePath(String eraserCachePath) {
        File file = new File(eraserCachePath);
        if (file.exists() || file.mkdirs()) {
            return true;
        }
        Log.i(TAG, "construct - Failed to mkdirs");
        return false;
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
        if (this.mVoiceDataList == null) {
            Log.e(TAG, "getCurrentVoiceData() list is null");
            return null;
        }
        AbstractC2322a.m1631u(this.mCurrentIndex, "getCurrentVoiceData() mCurrentIndex: ", TAG);
        int i = this.mCurrentIndex;
        if (i >= 0) {
            ArrayList<SpenVoiceData> arrayList = this.mVoiceDataList;
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

    private final int getDurationPlayTime(int index) {
        if (!this.mVoiceDataTimeList.isEmpty() && index >= 0 && index < this.mVoiceDataTimeList.size()) {
            return this.mVoiceDataTimeList.get(index).getSecond().intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getStartPlayTime(int index) {
        if (!this.mVoiceDataTimeList.isEmpty() && index >= 0 && index < this.mVoiceDataTimeList.size()) {
            return this.mVoiceDataTimeList.get(index).getFirst().intValue();
        }
        return -1;
    }

    private final SpenVoiceData getVoiceDataByIndex(int index) {
        ArrayList<SpenVoiceData> arrayList = this.mVoiceDataList;
        if (arrayList == null) {
            Log.e(TAG, "getVoiceDataByIndex() list is null");
            return null;
        }
        if (index >= 0) {
            Intrinsics.checkNotNull(arrayList);
            if (index < arrayList.size()) {
                ArrayList<SpenVoiceData> arrayList2 = this.mVoiceDataList;
                Intrinsics.checkNotNull(arrayList2);
                return arrayList2.get(index);
            }
        }
        AbstractC0541b.m758D(index, "getVoiceDataByIndex() index is invalid ", TAG);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initFragmentedBackgroundMusic(SemMediaPlayer mediaPlayer) throws IOException {
        ArrayList<SpenVoiceData> arrayList = this.mVoiceDataList;
        int size = arrayList != null ? arrayList.size() : -1;
        AbstractC2322a.m1631u(size, "initFragmentedBackgroundMusic voiceDataSize: ", TAG);
        this.mVoiceDataTimeList.clear();
        if (size <= 0) {
            return;
        }
        try {
            SemFragmentedBackgroundMusic semFragmentedBackgroundMusic = new SemFragmentedBackgroundMusic();
            boolean z = false;
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                SpenVoiceData voiceDataByIndex = getVoiceDataByIndex(i2);
                String attachedFile = voiceDataByIndex != null ? voiceDataByIndex.getAttachedFile() : null;
                if (attachedFile == null) {
                    Log.e(TAG, "initFragmentedBackgroundMusic voicePath[" + i2 + "] = null");
                } else {
                    FileDescriptor fd = new FileInputStream(new File(attachedFile)).getFD();
                    int playTime = SpenNoteVoiceManager.getPlayTime(attachedFile);
                    if (z) {
                        semFragmentedBackgroundMusic.addBody(fd, 0, playTime);
                    } else {
                        semFragmentedBackgroundMusic.setIntro(fd, 0, playTime);
                        z = true;
                    }
                    this.mVoiceDataTimeList.add(new Pair<>(Integer.valueOf(i), Integer.valueOf(playTime)));
                    i += playTime;
                }
            }
            semFragmentedBackgroundMusic.setPlaybackRule(1, 0, false);
            mediaPlayer.setBackgroundMusic(semFragmentedBackgroundMusic);
            Log.i(TAG, "initFragmentedBackgroundMusic completed");
        } catch (IllegalStateException e) {
            Log.e(TAG, "initFragmentedBackgroundMusic error " + e);
            this.mVoiceDataTimeList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pauseMediaPlayer(boolean isSwitchVoiceData) {
        SemMediaPlayer semMediaPlayer = this.mMediaPlayer;
        if (semMediaPlayer == null || !SpenNoteVoiceManager.INSTANCE.isPlaying()) {
            return;
        }
        semMediaPlayer.pause();
        MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
        if (mediaPlayerListener != null) {
            mediaPlayerListener.onPaused(isSwitchVoiceData);
        }
        this.mSeekTime = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseData() {
        clearVoiceList();
        this.mSpenObjectVoice = null;
        this.mVoiceDataTimeList.clear();
        this.mSeekTime = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseMediaPlayer() {
        Log.i(TAG, "releaseMediaPlayer() current player: " + this.mMediaPlayer);
        SemMediaPlayer semMediaPlayer = this.mMediaPlayer;
        if (semMediaPlayer != null) {
            semMediaPlayer.release();
        }
        this.mMediaPlayer = null;
    }

    private final void resetMediaPlayer() {
        Log.i(TAG, "resetMediaPlayer() current player: " + this.mMediaPlayer);
        SemMediaPlayer semMediaPlayer = this.mMediaPlayer;
        if (semMediaPlayer != null) {
            semMediaPlayer.reset();
        }
    }

    private final void updateCurrentVoiceIndex(SemMediaPlayer mediaPlayer) {
        int currentPosition = mediaPlayer.getCurrentPosition();
        int startPlayTime = getStartPlayTime(this.mCurrentIndex + 1);
        if (startPlayTime < 0 || currentPosition < startPlayTime) {
            return;
        }
        int i = this.mCurrentIndex + 1;
        this.mCurrentIndex = i;
        MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
        if (mediaPlayerListener != null) {
            mediaPlayerListener.onPrepared(getDurationPlayTime(i), null, getCurrentVoiceData(), false);
        }
        MediaPlayerInterface.MediaPlayerListener mediaPlayerListener2 = this.mMediaPlayerListener;
        if (mediaPlayerListener2 != null) {
            mediaPlayerListener2.onStarted(false);
        }
    }

    @Nullable
    public final MediaPlayerInterface.MediaPlayerListener getMMediaPlayerListener() {
        return this.mMediaPlayerListener;
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public int getPlayProgress() {
        SemMediaPlayer semMediaPlayer = this.mMediaPlayer;
        if (semMediaPlayer != null) {
            if (this.mSpenObjectVoice != null) {
                return semMediaPlayer.getCurrentPosition();
            }
            if (this.mVoiceDataList != null) {
                updateCurrentVoiceIndex(semMediaPlayer);
                int startPlayTime = getStartPlayTime(this.mCurrentIndex);
                return semMediaPlayer.getCurrentPosition() - (startPlayTime >= 0 ? startPlayTime : 0);
            }
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public float getSpeed() {
        PlaybackParams playbackParams;
        SemMediaPlayer semMediaPlayer = this.mMediaPlayer;
        return (semMediaPlayer == null || (playbackParams = semMediaPlayer.getPlaybackParams()) == null) ? this.mSpeed : playbackParams.getSpeed();
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public boolean initMediaPlayer(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Log.i(TAG, "initMediaPlayer() Start Init current player: " + this.mMediaPlayer);
        try {
            if (this.mMediaPlayer == null) {
                this.mMediaPlayer = new SemMediaPlayer();
            } else {
                resetMediaPlayer();
            }
            SemMediaPlayer semMediaPlayer = this.mMediaPlayer;
            if (semMediaPlayer != null) {
                if (this.mAudioEraserEnabled) {
                    semMediaPlayer.setParameter(KEY_PARAMETER_ENABLE_AUDIO_ERASER, 1);
                }
                String str = this.mAudioEraserCachePath;
                if (str != null) {
                    Intrinsics.checkNotNull(str);
                    if (canRequestAudioEraserCachePath(str)) {
                        semMediaPlayer.setParameter(KEY_PARAMETER_ENABLE_AUDIO_ERASER_CACHE, this.mAudioEraserCachePath);
                    }
                }
                semMediaPlayer.setOnInitCompleteListener(this.mOnInitCompleteListener);
                semMediaPlayer.setOnInfoListener(this.mOnInfoListener);
                semMediaPlayer.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
                semMediaPlayer.setOnPlaybackCompleteListener(this.mOnPlaybackCompleteListener);
                semMediaPlayer.setOnErrorListener(this.mOnErrorListener);
                semMediaPlayer.init(new FileInputStream(new File(path)).getFD());
                PlaybackParams playbackParams = semMediaPlayer.getPlaybackParams();
                Intrinsics.checkNotNullExpressionValue(playbackParams, "getPlaybackParams(...)");
                semMediaPlayer.setPlaybackParams(playbackParams.setSpeed(this.mSpeed));
            }
            SemMediaPlayer semMediaPlayer2 = this.mMediaPlayer;
            Log.i(TAG, "initMediaPlayer mMediaPlayer: " + (semMediaPlayer2 != null ? semMediaPlayer2.hashCode() : 0));
            return true;
        } catch (Exception e) {
            Log.e(TAG, "initMediaPlayer exception: " + e);
            e.printStackTrace();
            releaseMediaPlayer();
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
            this.mSeekTime = index > 0 ? 0 : -1;
            SpenVoiceData voiceDataByIndex = getVoiceDataByIndex(index);
            this.mInitState = true;
            MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
            if (mediaPlayerListener != null && mediaPlayerListener.init(null, voiceDataByIndex)) {
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
            stopMediaPlayer(false, false, false);
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
            this.mSeekTime = index > 0 ? 0 : -1;
            this.mInitState = false;
            SpenVoiceData voiceDataByIndex = getVoiceDataByIndex(index);
            MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
            if (mediaPlayerListener != null && mediaPlayerListener.play(null, voiceDataByIndex)) {
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
                    SpenVoiceData voiceDataByIndex = getVoiceDataByIndex(this.mCurrentIndex + 1);
                    ArrayList<SpenVoiceData> arrayList4 = this.mVoiceDataList;
                    Intrinsics.checkNotNull(arrayList4);
                    arrayList4.remove(index);
                    MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
                    if (mediaPlayerListener != null) {
                        mediaPlayerListener.play(null, voiceDataByIndex);
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
                            seekTo(i, playingTime);
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
        SemMediaPlayer semMediaPlayer = this.mMediaPlayer;
        if (semMediaPlayer != null) {
            Log.i(TAG, "resumePlaying() current player: " + semMediaPlayer);
            semMediaPlayer.start();
            MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
            if (mediaPlayerListener != null) {
                mediaPlayerListener.onResumed();
            }
        }
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void seekTo(int time) {
        SemMediaPlayer semMediaPlayer = this.mMediaPlayer;
        if (semMediaPlayer != null) {
            if (this.mSpenObjectVoice != null) {
                semMediaPlayer.seekTo(time);
                return;
            }
            if (this.mVoiceDataList != null) {
                int startPlayTime = getStartPlayTime(this.mCurrentIndex);
                if (startPlayTime < 0) {
                    startPlayTime = 0;
                }
                int i = startPlayTime + time;
                StringBuilder sbM1173s = AbstractC0622a.m1173s(this.mCurrentIndex, time, "seekTo() mCurrentIndex=", " index: ", ", seekTime: ");
                sbM1173s.append(i);
                Log.i(TAG, sbM1173s.toString());
                semMediaPlayer.seekTo(i);
            }
        }
    }

    public final void setAudioEraserCachePath(@NotNull String eraserCachePath) {
        Intrinsics.checkNotNullParameter(eraserCachePath, "eraserCachePath");
        if (Intrinsics.areEqual(this.mAudioEraserCachePath, eraserCachePath)) {
            return;
        }
        AbstractC6670b.m4756q("setAudioEraserCachePath() eraserCachePath:", eraserCachePath, TAG);
        this.mAudioEraserCachePath = eraserCachePath;
    }

    public final void setAudioEraserEnabled(boolean enabled) {
        AbstractC6670b.m4758s("setAudioEraserEnabled() mAudioEraserEnabled: ", " enabled: ", TAG, this.mAudioEraserEnabled, enabled);
        if (this.mAudioEraserEnabled == enabled) {
            return;
        }
        this.mAudioEraserEnabled = enabled;
        if (enabled) {
            SemMediaPlayer semMediaPlayer = this.mMediaPlayer;
            if (semMediaPlayer != null) {
                semMediaPlayer.setParameter(KEY_PARAMETER_ENABLE_AUDIO_ERASER, 1);
                return;
            }
            return;
        }
        SemMediaPlayer semMediaPlayer2 = this.mMediaPlayer;
        if (semMediaPlayer2 != null) {
            semMediaPlayer2.setParameter(KEY_PARAMETER_ENABLE_AUDIO_ERASER, 0);
        }
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void setSpeed(float speed) {
        SemMediaPlayer semMediaPlayer;
        Log.i(TAG, "setSpeed() mSpeed: " + this.mSpeed + " speed: " + speed);
        if (this.mSpeed == speed) {
            return;
        }
        this.mSpeed = speed;
        if (SpenNoteVoiceManager.INSTANCE.isPlayingActivated() && (semMediaPlayer = this.mMediaPlayer) != null) {
            PlaybackParams playbackParams = semMediaPlayer.getPlaybackParams();
            Intrinsics.checkNotNullExpressionValue(playbackParams, "getPlaybackParams(...)");
            semMediaPlayer.setPlaybackParams(playbackParams.setSpeed(speed));
        }
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void stopMediaPlayer(boolean isSwitchVoiceData, boolean isReleaseCurrentPlayer, boolean isReleaseNextPlayer) {
        SemMediaPlayer semMediaPlayer;
        AbstractC6670b.m4758s("stopMediaPlayer() isReleaseCurrentPlayer: ", ", isReleaseNextPlayer: ", TAG, isReleaseCurrentPlayer, isReleaseNextPlayer);
        if (!SpenNoteVoiceManager.INSTANCE.isPlayingActivated() || (semMediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        Log.i(TAG, "stopMediaPlayer() current player: " + semMediaPlayer);
        semMediaPlayer.pause();
        semMediaPlayer.reset();
        MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
        if (mediaPlayerListener != null) {
            mediaPlayerListener.onStopped(isSwitchVoiceData);
        }
        if (isReleaseCurrentPlayer) {
            releaseMediaPlayer();
        }
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void stopPlaying() {
        stopMediaPlayer(false, true, false);
        releaseData();
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void updatePlayProgress() {
        SemMediaPlayer semMediaPlayer = this.mMediaPlayer;
        if (semMediaPlayer != null) {
            if (this.mSpenObjectVoice != null) {
                MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
                if (mediaPlayerListener != null) {
                    mediaPlayerListener.onSeekComplete(semMediaPlayer.getCurrentPosition());
                    return;
                }
                return;
            }
            if (this.mVoiceDataList != null) {
                updateCurrentVoiceIndex(semMediaPlayer);
                int startPlayTime = getStartPlayTime(this.mCurrentIndex);
                int currentPosition = semMediaPlayer.getCurrentPosition();
                if (startPlayTime < 0) {
                    startPlayTime = 0;
                }
                int i = currentPosition - startPlayTime;
                MediaPlayerInterface.MediaPlayerListener mediaPlayerListener2 = this.mMediaPlayerListener;
                if (mediaPlayerListener2 != null) {
                    mediaPlayerListener2.onSeekComplete(i);
                }
            }
        }
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void seekTo(int index, int time) {
        SpenVoiceData currentVoiceData;
        AbstractC6670b.m4744e(index, time, "seekTo() index: ", ", time: ", TAG);
        ArrayList<SpenVoiceData> arrayList = this.mVoiceDataList;
        if (arrayList == null) {
            Log.e(TAG, "seekTo() list is null");
            return;
        }
        if (index >= 0) {
            Intrinsics.checkNotNull(arrayList);
            if (index < arrayList.size()) {
                if (this.mCurrentIndex != index) {
                    this.mCurrentIndex = index;
                    int durationPlayTime = getDurationPlayTime(index);
                    if (durationPlayTime < 0 || (currentVoiceData = getCurrentVoiceData()) == null) {
                        return;
                    }
                    MediaPlayerInterface.MediaPlayerListener mediaPlayerListener = this.mMediaPlayerListener;
                    if (mediaPlayerListener != null) {
                        mediaPlayerListener.onPrepared(durationPlayTime, null, currentVoiceData, false);
                    }
                    MediaPlayerInterface.MediaPlayerListener mediaPlayerListener2 = this.mMediaPlayerListener;
                    if (mediaPlayerListener2 != null) {
                        mediaPlayerListener2.onStarted(false);
                    }
                }
                if (SpenNoteVoiceManager.INSTANCE.isPlayingActivated()) {
                    seekTo(time);
                    return;
                } else {
                    this.mSeekTime = time;
                    return;
                }
            }
        }
        AbstractC0541b.m758D(index, "seekTo() index is invalid ", TAG);
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void seekTo(long time, int mode) {
        Log.i(TAG, "seekTo() time: " + time + " mode: " + mode);
        SemMediaPlayer semMediaPlayer = this.mMediaPlayer;
        if (semMediaPlayer != null) {
            semMediaPlayer.seekTo((int) time, mode);
        }
    }

    @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface
    public void seekTo(int index, long time, int mode) {
        Log.i(TAG, "seekTo() index: " + index + ", time: " + time + " mode: " + mode);
        seekTo(index, (int) time);
    }
}
