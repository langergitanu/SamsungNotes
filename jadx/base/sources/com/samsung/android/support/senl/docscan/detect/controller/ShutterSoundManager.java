package com.samsung.android.support.senl.docscan.detect.controller;

import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.support.senl.docscan.C7976R;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.detect.controller.DeviceStatusManager;
import com.samsung.android.support.senl.p145cm.base.framework.media.AudioManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/controller/ShutterSoundManager;", "", "<init>", "()V", "mSoundManager", "Lcom/samsung/android/support/senl/cm/base/framework/media/AudioManagerCompat$SoundManager;", "loadShutterSound", "", "releaseShutterSound", "playShutterSound", "setMuteShutter", "", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ShutterSoundManager {

    @NotNull
    private static final String TAG = "ShutterSoundManager";

    @Nullable
    private AudioManagerCompat.SoundManager mSoundManager;

    private final boolean setMuteShutter() {
        DeviceStatusManager.Companion companion = DeviceStatusManager.INSTANCE;
        DeviceStatusManager companion2 = companion.getInstance();
        Boolean boolValueOf = companion2 != null ? Boolean.valueOf(companion2.getIsPluggedHeadSet()) : null;
        Intrinsics.checkNotNull(boolValueOf);
        boolean z = boolValueOf.booleanValue() && VoiceManager.isRecording();
        DeviceStatusManager companion3 = companion.getInstance();
        if (companion3 != null) {
            companion3.enableSystemSound(1, z);
        }
        Logger.m7145d(TAG, "setMuteShutter : " + z);
        return z;
    }

    public final void loadShutterSound() {
        if (this.mSoundManager == null) {
            this.mSoundManager = AudioManagerCompat.INSTANCE.getInstance().createShutterSound(BaseUtils.getApplicationContext(), C7976R.raw.shutter);
        }
    }

    public final void playShutterSound() {
        if (setMuteShutter()) {
            Logger.m7145d(TAG, "playShutterSound : muted");
            return;
        }
        AudioManagerCompat.SoundManager soundManager = this.mSoundManager;
        if (soundManager != null) {
            soundManager.play();
        }
    }

    public final void releaseShutterSound() {
        AudioManagerCompat.SoundManager soundManager = this.mSoundManager;
        if (soundManager != null) {
            if (soundManager != null) {
                soundManager.release();
            }
            this.mSoundManager = null;
        }
    }
}
