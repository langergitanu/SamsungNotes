package com.samsung.android.support.senl.p145cm.base.framework.media;

import android.content.Context;
import android.media.session.MediaSession;
import com.samsung.android.support.senl.p145cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.media.AudioManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/media/AudioManagerCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$IAudioManagerCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$IAudioManagerCompatImpl;)V", "isRecordActive", "", "context", "Landroid/content/Context;", "setFlagsToMediaSession", "", "mediaSession", "Landroid/media/session/MediaSession;", "createShutterSound", "Lcom/samsung/android/support/senl/cm/base/framework/media/AudioManagerCompat$SoundManager;", "soundResId", "", "createHapticDetachSound", "SoundManager", "ShutterSoundManagerImpl", "HapticSoundManagerImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AudioManagerCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "AudioManagerCompat";

    @Nullable
    private static AudioManagerCompat mInstance;

    @NotNull
    private final AbsAudioManagerCompatImplFactory.IAudioManagerCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/media/AudioManagerCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/media/AudioManagerCompat;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/media/AudioManagerCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized AudioManagerCompat getInstance() {
            AudioManagerCompat audioManagerCompat;
            try {
                if (AudioManagerCompat.mInstance == null) {
                    AudioManagerCompat.mInstance = new AudioManagerCompat(new AudioManagerCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                audioManagerCompat = AudioManagerCompat.mInstance;
                Intrinsics.checkNotNull(audioManagerCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.media.AudioManagerCompat");
            } catch (Throwable th) {
                throw th;
            }
            return audioManagerCompat;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/media/AudioManagerCompat$HapticSoundManagerImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/media/AudioManagerCompat$SoundManager;", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$ISoundManagerImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$ISoundManagerImpl;)V", "play", "", "release", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class HapticSoundManagerImpl implements SoundManager {

        @NotNull
        private final AbsAudioManagerCompatImplFactory.ISoundManagerImpl mImpl;

        public HapticSoundManagerImpl(@NotNull AbsAudioManagerCompatImplFactory.ISoundManagerImpl mImpl) {
            Intrinsics.checkNotNullParameter(mImpl, "mImpl");
            this.mImpl = mImpl;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.ISoundManagerImpl
        public boolean play() {
            return this.mImpl.play();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.ISoundManagerImpl
        public void release() {
            this.mImpl.release();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/media/AudioManagerCompat$ShutterSoundManagerImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/media/AudioManagerCompat$SoundManager;", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$ISoundManagerImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$ISoundManagerImpl;)V", "play", "", "release", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ShutterSoundManagerImpl implements SoundManager {

        @NotNull
        private final AbsAudioManagerCompatImplFactory.ISoundManagerImpl mImpl;

        public ShutterSoundManagerImpl(@NotNull AbsAudioManagerCompatImplFactory.ISoundManagerImpl mImpl) {
            Intrinsics.checkNotNullParameter(mImpl, "mImpl");
            this.mImpl = mImpl;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.ISoundManagerImpl
        public boolean play() {
            return this.mImpl.play();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.media.AbsAudioManagerCompatImplFactory.ISoundManagerImpl
        public void release() {
            this.mImpl.release();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/media/AudioManagerCompat$SoundManager;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/media/AbsAudioManagerCompatImplFactory$ISoundManagerImpl;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SoundManager extends AbsAudioManagerCompatImplFactory.ISoundManagerImpl {
    }

    public /* synthetic */ AudioManagerCompat(AbsAudioManagerCompatImplFactory.IAudioManagerCompatImpl iAudioManagerCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iAudioManagerCompatImpl);
    }

    @NotNull
    public static final synchronized AudioManagerCompat getInstance() {
        return INSTANCE.getInstance();
    }

    @NotNull
    public final SoundManager createHapticDetachSound(@Nullable Context context) {
        return new HapticSoundManagerImpl(new AudioManagerCompatImplFactory().createHapticSoundManagerImpl(DeviceInfo.getDeviceType(), context));
    }

    @NotNull
    public final SoundManager createShutterSound(@Nullable Context context, int soundResId) {
        return new ShutterSoundManagerImpl(new AudioManagerCompatImplFactory().createShutterSoundManagerImpl(DeviceInfo.getDeviceType(), context, soundResId));
    }

    public final boolean isRecordActive(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        return this.mImpl.isRecordActive(context);
    }

    public final void setFlagsToMediaSession(@Nullable MediaSession mediaSession) {
        if (mediaSession == null) {
            return;
        }
        this.mImpl.setFlagsToMediaSession(mediaSession);
    }

    private AudioManagerCompat(AbsAudioManagerCompatImplFactory.IAudioManagerCompatImpl iAudioManagerCompatImpl) {
        this.mImpl = iAudioManagerCompatImpl;
    }
}
