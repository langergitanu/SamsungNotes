package com.samsung.android.support.senl.p145cm.base.framework.sem.media;

import android.media.MediaPlayer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/media/MediaPlayerCompatImpl;", "", "<init>", "()V", "SEEK_TYPE_ACCURATE_FRAME", "", "getSEEK_TYPE_ACCURATE_FRAME", "()I", "setSEEK_TYPE_ACCURATE_FRAME", "(I)V", "setSeekTo", "", "mediaPlayer", "Landroid/media/MediaPlayer;", "msec", "type", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MediaPlayerCompatImpl {

    @NotNull
    public static final MediaPlayerCompatImpl INSTANCE = new MediaPlayerCompatImpl();
    private static int SEEK_TYPE_ACCURATE_FRAME = 1;

    private MediaPlayerCompatImpl() {
    }

    public final int getSEEK_TYPE_ACCURATE_FRAME() {
        return SEEK_TYPE_ACCURATE_FRAME;
    }

    public final void setSEEK_TYPE_ACCURATE_FRAME(int i) {
        SEEK_TYPE_ACCURATE_FRAME = i;
    }

    public final void setSeekTo(@Nullable MediaPlayer mediaPlayer, int msec, int type) {
        if (mediaPlayer != null) {
            mediaPlayer.semSeekTo(msec, type);
        }
    }
}
