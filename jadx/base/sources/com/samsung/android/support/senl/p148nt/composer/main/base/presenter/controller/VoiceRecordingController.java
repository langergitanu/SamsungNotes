package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller;

import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000f\u001a\u00020\rJ\u0010\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0012\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001eJ\u0016\u0010!\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001eJ\u0016\u0010#\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u001eJ\u000e\u0010%\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010&\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010'\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010(\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010)\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u001eJ\u000e\u0010+\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010,\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u001eJ\u0016\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u00100\u001a\u00020\r2\u0006\u0010/\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u00101\u001a\u00020\r2\u0006\u0010/\u001a\u00020\tJ\u000e\u00102\u001a\u00020\r2\u0006\u0010/\u001a\u00020\tJ\u000e\u00103\u001a\u00020\r2\u0006\u0010/\u001a\u00020\tJ\u000e\u00104\u001a\u00020\r2\u0006\u0010/\u001a\u00020\tJ\u0016\u00105\u001a\u00020\r2\u0006\u0010/\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u00106\u001a\u00020\r2\u0006\u0010/\u001a\u00020\tJ\u000e\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\tJ\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/VoiceRecordingController;", "", "<init>", "()V", "mVoiceListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/VoiceRecordingEventListener;", "mVoicePlayPreparedListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/VoiceRecordingController$VoicePlayPreparedListener;", "mPlayObjectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "mFragment", "Landroidx/fragment/app/Fragment;", "onAttachView", "", "fragment", "onDetachView", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setVoicePlayPreparedListener", "onRecordStop", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "onRecordStart", "cachePath", "", "onRecordResume", "onRecordCancel", "onRecordPause", "onRecordError", "i", "", "onUpdateRecordTime", "time", "onRecordPlayError", "errorCode", "onRecordPlayPrepared", XmlErrorCodes.DURATION, "onRecordPlayStart", "onRecordPlayStop", "onRecordPlayPause", "onRecordPlayResume", "onUpdateRecordPlayTime", "position", "onRecordPlayComplete", "onRecordPlayInfo", "mediaInfo", "onPlayError", "spenObjectVoice", "onPlayPrepared", "onPlayStarted", "onPlayPaused", "onPlayResumed", "onPlayStopped", "onPlaySeekComplete", "onPlayComplete", "onPlayClicked", "objectVoice", "onRequestPermissionsResult", "", "requestCode", "VoicePlayPreparedListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVoiceRecordingController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceRecordingController.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/VoiceRecordingController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,154:1\n1#2:155\n*E\n"})
public final class VoiceRecordingController {

    @Nullable
    private Fragment mFragment;

    @Nullable
    private SpenObjectVoice mPlayObjectVoice;

    @Nullable
    private VoiceRecordingEventListener mVoiceListener;

    @Nullable
    private VoicePlayPreparedListener mVoicePlayPreparedListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/VoiceRecordingController$VoicePlayPreparedListener;", "", "onPlayPrepared", "", "spenObjectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "i", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface VoicePlayPreparedListener {
        void onPlayPrepared(@Nullable SpenObjectVoice spenObjectVoice, int i);
    }

    public final void onAttachView(@Nullable Fragment fragment) {
        this.mFragment = fragment;
    }

    public final void onDetachView() {
        this.mFragment = null;
    }

    public final void onPlayClicked(@NotNull SpenObjectVoice objectVoice) {
        Intrinsics.checkNotNullParameter(objectVoice, "objectVoice");
        if (!NotificationUtils.checkedNotificationPermissions(this.mFragment, 130)) {
            this.mPlayObjectVoice = objectVoice;
            return;
        }
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onPlayClicked(objectVoice);
        }
    }

    public final void onPlayComplete(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onPlayComplete(spenObjectVoice);
        }
    }

    public final void onPlayError(@NotNull SpenObjectVoice spenObjectVoice, int i) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onPlayError(spenObjectVoice, i);
        }
    }

    public final void onPlayPaused(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onPlayPaused(spenObjectVoice);
        }
    }

    public final void onPlayPrepared(@NotNull SpenObjectVoice spenObjectVoice, int i) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onPlayPrepared(spenObjectVoice, i);
        }
        VoicePlayPreparedListener voicePlayPreparedListener = this.mVoicePlayPreparedListener;
        if (voicePlayPreparedListener != null) {
            voicePlayPreparedListener.onPlayPrepared(spenObjectVoice, i);
        }
    }

    public final void onPlayResumed(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onPlayResumed(spenObjectVoice);
        }
    }

    public final void onPlaySeekComplete(@NotNull SpenObjectVoice spenObjectVoice, int i) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onPlaySeekComplete(spenObjectVoice, i);
        }
    }

    public final void onPlayStarted(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onPlayStarted(spenObjectVoice);
        }
    }

    public final void onPlayStopped(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onPlayStopped(spenObjectVoice);
        }
    }

    public final void onRecordCancel(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onRecordCancel(voiceData);
        }
    }

    public final void onRecordError(@NotNull SpenVoiceData voiceData, int i) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onRecordError(voiceData, i);
        }
    }

    public final void onRecordPause(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onRecordPause(voiceData);
        }
    }

    public final void onRecordPlayComplete(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onRecordPlayComplete(voiceData);
        }
    }

    public final void onRecordPlayError(@NotNull SpenVoiceData voiceData, int errorCode) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onRecordPlayError(voiceData, errorCode);
        }
    }

    public final void onRecordPlayInfo(@NotNull SpenVoiceData voiceData, int mediaInfo) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onRecordPlayInfo(voiceData, mediaInfo);
        }
    }

    public final void onRecordPlayPause(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onRecordPlayPause(voiceData);
        }
    }

    public final void onRecordPlayPrepared(@NotNull SpenVoiceData voiceData, int duration) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onRecordPlayPrepared(voiceData, duration);
        }
    }

    public final void onRecordPlayResume(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onRecordPlayResume(voiceData);
        }
    }

    public final void onRecordPlayStart(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onRecordPlayStart(voiceData);
        }
    }

    public final void onRecordPlayStop(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onRecordPlayStop(voiceData);
        }
    }

    public final void onRecordResume(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onRecordResume(voiceData);
        }
    }

    public final void onRecordStart(@NotNull SpenVoiceData voiceData, @NotNull String cachePath) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onRecordStart(voiceData, cachePath);
        }
    }

    public final void onRecordStop(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onRecordStop(voiceData);
        }
    }

    public final boolean onRequestPermissionsResult(int requestCode) {
        if (requestCode != 130) {
            return false;
        }
        SpenObjectVoice spenObjectVoice = this.mPlayObjectVoice;
        if (spenObjectVoice != null) {
            onPlayClicked(spenObjectVoice);
        }
        this.mPlayObjectVoice = null;
        return true;
    }

    public final void onUpdateRecordPlayTime(@NotNull SpenVoiceData voiceData, int position) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onUpdateRecordPlayTime(voiceData, position);
        }
    }

    public final void onUpdateRecordTime(@NotNull SpenVoiceData voiceData, int time) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        VoiceRecordingEventListener voiceRecordingEventListener = this.mVoiceListener;
        if (voiceRecordingEventListener != null) {
            voiceRecordingEventListener.onUpdateRecordTime(voiceData, time);
        }
    }

    public final void setListener(@Nullable VoiceRecordingEventListener listener) {
        this.mVoiceListener = listener;
    }

    public final void setVoicePlayPreparedListener(@Nullable VoicePlayPreparedListener listener) {
        this.mVoicePlayPreparedListener = listener;
    }
}
