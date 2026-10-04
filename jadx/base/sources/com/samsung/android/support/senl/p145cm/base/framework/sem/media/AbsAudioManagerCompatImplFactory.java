package com.samsung.android.support.senl.p145cm.base.framework.sem.media;

import android.content.Context;
import android.media.MediaActionSound;
import android.media.session.MediaSession;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u00132\u00020\u0001:\u0006\u000e\u000f\u0010\u0011\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$IAudioManagerCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "createShutterSoundManagerImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$ISoundManagerImpl;", "context", "Landroid/content/Context;", "soundResId", "createHapticSoundManagerImpl", "IAudioManagerCompatImpl", "ISoundManagerImpl", "AudioManagerCompatPureImpl", "ShutterSoundPureImpl", "HapticSoundPureImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsAudioManagerCompatImplFactory {

    @NotNull
    private static final String TAG = "AudioManagerCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$AudioManagerCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$IAudioManagerCompatImpl;", "<init>", "()V", "isRecordActive", "", "context", "Landroid/content/Context;", "setFlagsToMediaSession", "", "mediaSession", "Landroid/media/session/MediaSession;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class AudioManagerCompatPureImpl implements IAudioManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.IAudioManagerCompatImpl
        public boolean isRecordActive(@Nullable Context context) {
            Object systemService;
            if (context != null) {
                try {
                    systemService = context.getSystemService("audio");
                } catch (ClassNotFoundException e) {
                    AbstractC0000a.m23t("isAudioManagerIsRecordingActive: ClassNotFoundException] ", e.getMessage(), LoggerBase.INSTANCE, AbsAudioManagerCompatImplFactory.TAG);
                } catch (IllegalAccessException e2) {
                    AbstractC0000a.m23t("isAudioManagerIsRecordingActive: IllegalAccessException] ", e2.getMessage(), LoggerBase.INSTANCE, AbsAudioManagerCompatImplFactory.TAG);
                } catch (IllegalArgumentException e3) {
                    LoggerBase.INSTANCE.m7132d(AbsAudioManagerCompatImplFactory.TAG, "isAudioManagerIsRecordingActive: IllegalArgumentException] " + e3.getMessage());
                } catch (NoSuchMethodException e5) {
                    AbstractC0000a.m23t("isAudioManagerIsRecordingActive: NoSuchMethodException] ", e5.getMessage(), LoggerBase.INSTANCE, AbsAudioManagerCompatImplFactory.TAG);
                } catch (InvocationTargetException e6) {
                    AbstractC0000a.m23t("isAudioManagerIsRecordingActive: InvocationTargetException] ", e6.getMessage(), LoggerBase.INSTANCE, AbsAudioManagerCompatImplFactory.TAG);
                }
            } else {
                systemService = null;
            }
            Method declaredMethod = Class.forName("android.media.AudioManager").getDeclaredMethod("isRecordActive", null);
            if (declaredMethod != null) {
                Object objInvoke = declaredMethod.invoke(systemService, null);
                LoggerBase.Companion companion = LoggerBase.INSTANCE;
                Boolean bool = Boolean.TRUE;
                companion.m7132d(AbsAudioManagerCompatImplFactory.TAG, "isAudioManagerIsRecordingActive: " + Intrinsics.areEqual(bool, objInvoke));
                return Intrinsics.areEqual(bool, objInvoke);
            }
            LoggerBase.INSTANCE.m7132d(AbsAudioManagerCompatImplFactory.TAG, "isAudioManagerIsRecordingActive: error");
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.IAudioManagerCompatImpl
        public void setFlagsToMediaSession(@Nullable MediaSession mediaSession) {
            if (mediaSession != null) {
                mediaSession.setFlags(1);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$HapticSoundPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$ISoundManagerImpl;", "<init>", "()V", "play", "", "release", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class HapticSoundPureImpl implements ISoundManagerImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.ISoundManagerImpl
        public boolean play() {
            LoggerBase.INSTANCE.m7133e(AbsAudioManagerCompatImplFactory.TAG, "playHapticSound : not supported");
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.ISoundManagerImpl
        public void release() {
            LoggerBase.INSTANCE.m7133e(AbsAudioManagerCompatImplFactory.TAG, "releaseHapticSound : not supported");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$IAudioManagerCompatImpl;", "", "isRecordActive", "", "context", "Landroid/content/Context;", "setFlagsToMediaSession", "", "mediaSession", "Landroid/media/session/MediaSession;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IAudioManagerCompatImpl {
        boolean isRecordActive(@Nullable Context context);

        void setFlagsToMediaSession(@Nullable MediaSession mediaSession);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$ISoundManagerImpl;", "", "play", "", "release", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ISoundManagerImpl {
        boolean play();

        void release();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$ShutterSoundPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$ISoundManagerImpl;", "<init>", "()V", "mActionSound", "Landroid/media/MediaActionSound;", "play", "", "release", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ShutterSoundPureImpl implements ISoundManagerImpl {

        @Nullable
        private MediaActionSound mActionSound;

        public ShutterSoundPureImpl() {
            MediaActionSound mediaActionSound = new MediaActionSound();
            this.mActionSound = mediaActionSound;
            mediaActionSound.load(0);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.ISoundManagerImpl
        public boolean play() {
            MediaActionSound mediaActionSound = this.mActionSound;
            if (mediaActionSound == null) {
                return false;
            }
            Intrinsics.checkNotNull(mediaActionSound);
            mediaActionSound.play(0);
            return true;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.ISoundManagerImpl
        public void release() {
            MediaActionSound mediaActionSound = this.mActionSound;
            if (mediaActionSound != null) {
                mediaActionSound.release();
            }
            this.mActionSound = null;
        }
    }

    @NotNull
    public IAudioManagerCompatImpl create(int deviceType) {
        return new AudioManagerCompatPureImpl();
    }

    @NotNull
    public ISoundManagerImpl createHapticSoundManagerImpl(int deviceType, @Nullable Context context) {
        return new HapticSoundPureImpl();
    }

    @NotNull
    public ISoundManagerImpl createShutterSoundManagerImpl(int deviceType, @Nullable Context context, int soundResId) {
        return new ShutterSoundPureImpl();
    }
}
