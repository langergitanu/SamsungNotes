package com.samsung.android.support.senl.p145cm.base.framework.sem.media;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.session.MediaSession;
import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.C7968R;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0005\u000e\u000f\u0010\u0011\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AudioManagerCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$IAudioManagerCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "createShutterSoundManagerImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$ISoundManagerImpl;", "context", "Landroid/content/Context;", "soundResId", "createHapticSoundManagerImpl", "AudioManagerCompatSemImpl", "ShutterSoundSemImpl", "HapticSoundSemSOsImpl", "HapticSoundSemImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AudioManagerCompatImplFactory extends AbsAudioManagerCompatImplFactory {

    @NotNull
    private static final String TAG = "AudioManagerCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AudioManagerCompatImplFactory$AudioManagerCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$IAudioManagerCompatImpl;", "<init>", "()V", "isRecordActive", "", "context", "Landroid/content/Context;", "setFlagsToMediaSession", "", "mediaSession", "Landroid/media/session/MediaSession;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class AudioManagerCompatSemImpl implements AbsAudioManagerCompatImplFactory.IAudioManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.IAudioManagerCompatImpl
        public boolean isRecordActive(@Nullable Context context) {
            Object systemService;
            if (context != null) {
                try {
                    systemService = context.getSystemService("audio");
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("isRecordActive: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, AudioManagerCompatImplFactory.TAG);
                    return false;
                }
            } else {
                systemService = null;
            }
            AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
            if (audioManager != null) {
                return audioManager.semIsRecordActive(-1);
            }
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.IAudioManagerCompatImpl
        public void setFlagsToMediaSession(@Nullable MediaSession mediaSession) {
            if (mediaSession != null) {
                mediaSession.setFlags(268435456);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AudioManagerCompatImplFactory$HapticSoundSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$ISoundManagerImpl;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mAudioManager", "Landroid/media/AudioManager;", "getMAudioManager", "()Landroid/media/AudioManager;", "setMAudioManager", "(Landroid/media/AudioManager;)V", "mSoundPool", "Landroid/media/SoundPool;", "getMSoundPool", "()Landroid/media/SoundPool;", "setMSoundPool", "(Landroid/media/SoundPool;)V", "mSoundResId", "", "getMSoundResId", "()I", "setMSoundResId", "(I)V", "play", "", "release", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nAudioManagerCompatImplFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioManagerCompatImplFactory.kt\ncom/samsung/android/support/senl/cm/base/framework/sem/media/AudioManagerCompatImplFactory$HapticSoundSemImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,191:1\n1#2:192\n*E\n"})
    public static final class HapticSoundSemImpl implements AbsAudioManagerCompatImplFactory.ISoundManagerImpl {

        @Nullable
        private AudioManager mAudioManager;

        @Nullable
        private SoundPool mSoundPool;
        private int mSoundResId;

        public HapticSoundSemImpl(@Nullable Context context) {
            SoundPool soundPoolBuild = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(new AudioAttributes.Builder().setContentType(4).setUsage(5).build()).build();
            this.mSoundPool = soundPoolBuild;
            this.mSoundResId = soundPoolBuild != null ? soundPoolBuild.load(context, C7968R.raw.detach, 0) : 0;
            Object systemService = context != null ? context.getSystemService("audio") : null;
            this.mAudioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        }

        @Nullable
        public final AudioManager getMAudioManager() {
            return this.mAudioManager;
        }

        @Nullable
        public final SoundPool getMSoundPool() {
            return this.mSoundPool;
        }

        public final int getMSoundResId() {
            return this.mSoundResId;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.ISoundManagerImpl
        public boolean play() {
            Float fValueOf;
            AudioManager audioManager = this.mAudioManager;
            if (audioManager == null || this.mSoundPool == null) {
                return false;
            }
            if (audioManager != null) {
                try {
                    fValueOf = Float.valueOf(audioManager.getStreamVolume(1));
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("HapticSoundSemImpl#playHapticSound: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, AudioManagerCompatImplFactory.TAG);
                    return false;
                }
            } else {
                fValueOf = null;
            }
            if (fValueOf != null) {
                float fFloatValue = fValueOf.floatValue();
                SoundPool soundPool = this.mSoundPool;
                if (soundPool != null) {
                    soundPool.play(this.mSoundResId, fFloatValue, fValueOf.floatValue(), 0, 0, 1.0f);
                }
            }
            return true;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.ISoundManagerImpl
        public void release() {
            this.mAudioManager = null;
            SoundPool soundPool = this.mSoundPool;
            if (soundPool != null) {
                soundPool.unload(this.mSoundResId);
            }
            this.mSoundResId = -1;
            SoundPool soundPool2 = this.mSoundPool;
            if (soundPool2 != null) {
                soundPool2.release();
            }
            this.mSoundPool = null;
        }

        public final void setMAudioManager(@Nullable AudioManager audioManager) {
            this.mAudioManager = audioManager;
        }

        public final void setMSoundPool(@Nullable SoundPool soundPool) {
            this.mSoundPool = soundPool;
        }

        public final void setMSoundResId(int i) {
            this.mSoundResId = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AudioManagerCompatImplFactory$HapticSoundSemSOsImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$ISoundManagerImpl;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mAudioManager", "Landroid/media/AudioManager;", "getMAudioManager", "()Landroid/media/AudioManager;", "setMAudioManager", "(Landroid/media/AudioManager;)V", "play", "", "release", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class HapticSoundSemSOsImpl implements AbsAudioManagerCompatImplFactory.ISoundManagerImpl {
        private static final int FLAG_SEC_SOUND_EFFECT_BASE = 99;
        private static final int SEM_SOUND_DRAG_AND_DROP = 106;

        @Nullable
        private AudioManager mAudioManager;

        public HapticSoundSemSOsImpl(@Nullable Context context) {
            Object systemService = context != null ? context.getSystemService("audio") : null;
            this.mAudioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        }

        @Nullable
        public final AudioManager getMAudioManager() {
            return this.mAudioManager;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.ISoundManagerImpl
        public boolean play() {
            try {
                AudioManager audioManager = this.mAudioManager;
                if (audioManager == null) {
                    return true;
                }
                audioManager.playSoundEffect(106);
                return true;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("HapticSoundSemSOsImpl#playHapticSound: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, AudioManagerCompatImplFactory.TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.ISoundManagerImpl
        public void release() {
            this.mAudioManager = null;
        }

        public final void setMAudioManager(@Nullable AudioManager audioManager) {
            this.mAudioManager = audioManager;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AudioManagerCompatImplFactory$ShutterSoundSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$ISoundManagerImpl;", "context", "Landroid/content/Context;", "soundResId", "", "<init>", "(Landroid/content/Context;I)V", "mSoundPool", "Landroid/media/SoundPool;", "mShutterSoundId", "mAudioManager", "Landroid/media/AudioManager;", "play", "", "release", "", "isForcedShutterSoundSupported", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nAudioManagerCompatImplFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioManagerCompatImplFactory.kt\ncom/samsung/android/support/senl/cm/base/framework/sem/media/AudioManagerCompatImplFactory$ShutterSoundSemImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,191:1\n1#2:192\n*E\n"})
    public static final class ShutterSoundSemImpl implements AbsAudioManagerCompatImplFactory.ISoundManagerImpl {

        @Nullable
        private AudioManager mAudioManager;
        private int mShutterSoundId;

        @Nullable
        private SoundPool mSoundPool;

        public ShutterSoundSemImpl(@Nullable Context context, int i) {
            if (context != null) {
                try {
                    AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(4).setUsage(5);
                    if (isForcedShutterSoundSupported()) {
                        usage.setLegacyStreamType(AudioManager.semGetStreamType(5));
                    } else {
                        usage.setLegacyStreamType(1);
                    }
                    SoundPool soundPoolBuild = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(usage.build()).build();
                    this.mSoundPool = soundPoolBuild;
                    this.mShutterSoundId = soundPoolBuild != null ? soundPoolBuild.load(context, i, 0) : 0;
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("ShutterSoundSemImpl: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, AudioManagerCompatImplFactory.TAG);
                }
                Object systemService = context.getSystemService("audio");
                this.mAudioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
            }
        }

        private final boolean isForcedShutterSoundSupported() {
            SystemPropertiesCompat companion = SystemPropertiesCompat.INSTANCE.getInstance();
            return companion.isKoreaModel() || companion.isJapanModel();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.ISoundManagerImpl
        public boolean play() {
            SoundPool soundPool;
            if (this.mAudioManager != null && (soundPool = this.mSoundPool) != null) {
                try {
                    if (Build.VERSION.SDK_INT > 29 && soundPool != null) {
                        soundPool.semSetSituationType(this.mShutterSoundId, "stv_shutter");
                    }
                    AudioManager audioManager = this.mAudioManager;
                    Float fValueOf = audioManager != null ? Float.valueOf(audioManager.semGetSituationVolume(3, 0)) : null;
                    if (fValueOf == null) {
                        return true;
                    }
                    float fFloatValue = fValueOf.floatValue();
                    SoundPool soundPool2 = this.mSoundPool;
                    if (soundPool2 == null) {
                        return true;
                    }
                    soundPool2.play(this.mShutterSoundId, fFloatValue, fValueOf.floatValue(), 0, 0, 1.0f);
                    return true;
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("playShutterSound: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, AudioManagerCompatImplFactory.TAG);
                }
            }
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.ISoundManagerImpl
        public void release() {
            this.mAudioManager = null;
            SoundPool soundPool = this.mSoundPool;
            if (soundPool != null) {
                soundPool.unload(this.mShutterSoundId);
            }
            this.mShutterSoundId = -1;
            SoundPool soundPool2 = this.mSoundPool;
            if (soundPool2 != null) {
                soundPool2.release();
            }
            this.mSoundPool = null;
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory
    @NotNull
    public AbsAudioManagerCompatImplFactory.IAudioManagerCompatImpl create(int deviceType) {
        return deviceType == 2 ? new AudioManagerCompatSemImpl() : super.create(deviceType);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory
    @NotNull
    public AbsAudioManagerCompatImplFactory.ISoundManagerImpl createHapticSoundManagerImpl(int deviceType, @Nullable Context context) {
        return deviceType == 2 ? Build.VERSION.SDK_INT > 30 ? new HapticSoundSemSOsImpl(context) : new HapticSoundSemImpl(context) : super.createHapticSoundManagerImpl(deviceType, context);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory
    @NotNull
    public AbsAudioManagerCompatImplFactory.ISoundManagerImpl createShutterSoundManagerImpl(int deviceType, @Nullable Context context, int soundResId) {
        return deviceType == 2 ? new ShutterSoundSemImpl(context, soundResId) : super.createShutterSoundManagerImpl(deviceType, context, soundResId);
    }
}
