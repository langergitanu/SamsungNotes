package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice;

import android.content.Context;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p145cm.base.framework.media.AudioManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.ViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0012\u001a\u00020\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/EarphoneButtonManager;", "", "<init>", "()V", "mMediaSession", "Landroid/media/session/MediaSession;", "mPlaybackBuilder", "Landroid/media/session/PlaybackState$Builder;", "updateMediaSession", "", "context", "Landroid/content/Context;", "tag", "", "viewState", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/controller/ViewState;", Profile.PhoneNumberData.TYPE_CALLBACK, "Landroid/media/session/MediaSession$Callback;", "releaseMediaSession", "isValidMediaButtonEvent", "", "()Z", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class EarphoneButtonManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG;

    @Nullable
    private static EarphoneButtonManager mInstance;

    @Nullable
    private MediaSession mMediaSession;

    @NotNull
    private final PlaybackState.Builder mPlaybackBuilder;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/EarphoneButtonManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/EarphoneButtonManager;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/EarphoneButtonManager;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized EarphoneButtonManager getInstance() {
            EarphoneButtonManager earphoneButtonManager;
            try {
                if (EarphoneButtonManager.mInstance == null) {
                    EarphoneButtonManager.mInstance = new EarphoneButtonManager();
                }
                earphoneButtonManager = EarphoneButtonManager.mInstance;
                Intrinsics.checkNotNull(earphoneButtonManager);
            } catch (Throwable th) {
                throw th;
            }
            return earphoneButtonManager;
        }

        private Companion() {
        }
    }

    static {
        String strCreateTag = Logger.createTag("EarphoneButtonManager");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public EarphoneButtonManager() {
        PlaybackState.Builder state = new PlaybackState.Builder().setState(6, 0L, 0.0f, 0L);
        Intrinsics.checkNotNullExpressionValue(state, "setState(...)");
        this.mPlaybackBuilder = state;
    }

    public final boolean isValidMediaButtonEvent() {
        MediaSession mediaSession = this.mMediaSession;
        if (mediaSession == null) {
            return false;
        }
        Intrinsics.checkNotNull(mediaSession);
        if (!mediaSession.isActive()) {
            return false;
        }
        MediaSession mediaSession2 = this.mMediaSession;
        Intrinsics.checkNotNull(mediaSession2);
        if (mediaSession2.getController().getPlaybackState() == null) {
            return false;
        }
        MediaSession mediaSession3 = this.mMediaSession;
        Intrinsics.checkNotNull(mediaSession3);
        PlaybackState playbackState = mediaSession3.getController().getPlaybackState();
        Intrinsics.checkNotNull(playbackState);
        return playbackState.getState() == 6;
    }

    public final void releaseMediaSession() {
        MediaSession mediaSession = this.mMediaSession;
        if (mediaSession != null) {
            Intrinsics.checkNotNull(mediaSession);
            mediaSession.setActive(false);
            MediaSession mediaSession2 = this.mMediaSession;
            Intrinsics.checkNotNull(mediaSession2);
            mediaSession2.setPlaybackState(null);
            MediaSession mediaSession3 = this.mMediaSession;
            Intrinsics.checkNotNull(mediaSession3);
            mediaSession3.setCallback(null);
            MediaSession mediaSession4 = this.mMediaSession;
            Intrinsics.checkNotNull(mediaSession4);
            mediaSession4.release();
            this.mMediaSession = null;
            Logger.m10999d(TAG, "releaseMediaSession");
        }
    }

    public final void updateMediaSession(@Nullable Context context, @NotNull String tag, @NotNull ViewState viewState, @Nullable MediaSession.Callback callback) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        releaseMediaSession();
        if (context == null) {
            Logger.m11000e(TAG, "updateMediaSession fail");
            return;
        }
        if (!viewState.isResumed()) {
            Logger.m11004w(TAG, "updateMediaSession. viewState: " + viewState.getState());
            return;
        }
        MediaSession mediaSession = new MediaSession(context, tag);
        this.mMediaSession = mediaSession;
        mediaSession.setActive(true);
        AudioManagerCompat.INSTANCE.getInstance().setFlagsToMediaSession(this.mMediaSession);
        MediaSession mediaSession2 = this.mMediaSession;
        if (mediaSession2 != null) {
            mediaSession2.setPlaybackState(this.mPlaybackBuilder.build());
        }
        MediaSession mediaSession3 = this.mMediaSession;
        if (mediaSession3 != null) {
            mediaSession3.setCallback(callback);
        }
        AbstractC8014b.m7196B("updateMediaSession. ", tag, TAG);
    }
}
