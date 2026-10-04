package com.samsung.android.support.senl.p145cm.base.framework.media;

import android.media.MediaPlayer;
import com.samsung.android.support.senl.p145cm.base.framework.sem.media.MediaPlayerCompatImpl;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/media/MediaPlayerCompat;", "", "<init>", "()V", "SEEK_TYPE_ACCURATE_FRAME", "", "getSEEK_TYPE_ACCURATE_FRAME", "()I", "setSeekTo", "", "mediaPlayer", "Landroid/media/MediaPlayer;", "msec", "type", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MediaPlayerCompat {

    @NotNull
    public static final MediaPlayerCompat INSTANCE = new MediaPlayerCompat();
    private static final int SEEK_TYPE_ACCURATE_FRAME = MediaPlayerCompatImpl.INSTANCE.getSEEK_TYPE_ACCURATE_FRAME();

    private MediaPlayerCompat() {
    }

    public final int getSEEK_TYPE_ACCURATE_FRAME() {
        return SEEK_TYPE_ACCURATE_FRAME;
    }

    public final void setSeekTo(@Nullable MediaPlayer mediaPlayer, int msec, int type) {
        MediaPlayerCompatImpl.INSTANCE.setSeekTo(mediaPlayer, msec, type);
    }
}
