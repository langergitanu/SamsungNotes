package com.samsung.android.support.senl.p148nt.app.settings.common.component;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/component/TextureViewPreference;", "Landroidx/preference/Preference;", "context", "Landroid/content/Context;", "mTextureUri", "Landroid/net/Uri;", "<init>", "(Landroid/content/Context;Landroid/net/Uri;)V", "mMediaPlayer", "Landroid/media/MediaPlayer;", "mItemView", "Landroid/view/View;", "mTextureView", "Landroid/view/TextureView;", "init", "", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "initMediaPlayer", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "updateLayout", "width", "", "height", "releaseMediaPlayer", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TextureViewPreference extends Preference {

    @NotNull
    private static final String TAG = "TextureViewPreference";

    @Nullable
    private View mItemView;

    @Nullable
    private MediaPlayer mMediaPlayer;

    @NotNull
    private final Uri mTextureUri;

    @Nullable
    private TextureView mTextureView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureViewPreference(@Nullable Context context, @NotNull Uri mTextureUri) {
        super(context);
        Intrinsics.checkNotNullParameter(mTextureUri, "mTextureUri");
        Intrinsics.checkNotNull(context);
        this.mTextureUri = mTextureUri;
        init();
    }

    private final void init() {
        setLayoutResource(C8003R.layout.settings_textureview_preference_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initMediaPlayer(SurfaceTexture surfaceTexture) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mMediaPlayer = mediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer);
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.samsung.android.support.senl.nt.app.settings.common.component.b
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer2) {
                TextureViewPreference.initMediaPlayer$lambda$0(this.f6289a, mediaPlayer2);
            }
        });
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer2);
        mediaPlayer2.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.samsung.android.support.senl.nt.app.settings.common.component.c
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer3, int i, int i2) {
                TextureViewPreference.initMediaPlayer$lambda$1(this.f6290a, mediaPlayer3, i, i2);
            }
        });
        try {
            MediaPlayer mediaPlayer3 = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer3);
            mediaPlayer3.setLooping(true);
            MediaPlayer mediaPlayer4 = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer4);
            mediaPlayer4.setScreenOnWhilePlaying(false);
            MediaPlayer mediaPlayer5 = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer5);
            mediaPlayer5.setDataSource(getContext(), this.mTextureUri);
            MediaPlayer mediaPlayer6 = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer6);
            mediaPlayer6.prepare();
        } catch (IOException e) {
            MainLogger.m7255e(TAG, "initMediaPlayer, : " + e);
        }
        MediaPlayer mediaPlayer7 = this.mMediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer7);
        mediaPlayer7.setSurface(new Surface(surfaceTexture));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMediaPlayer$lambda$0(TextureViewPreference textureViewPreference, MediaPlayer mediaPlayer) {
        if (mediaPlayer.getVideoHeight() <= 0 || mediaPlayer.getVideoWidth() <= 0) {
            return;
        }
        AbstractC8014b.m7200b(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight(), "initMediaPlayer, onPrepared# width: ", " height: ", TAG);
        textureViewPreference.updateLayout(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        mediaPlayer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMediaPlayer$lambda$1(TextureViewPreference textureViewPreference, MediaPlayer mediaPlayer, int i, int i2) {
        if (mediaPlayer.getVideoHeight() <= 0 || mediaPlayer.getVideoWidth() <= 0) {
            return;
        }
        AbstractC8014b.m7200b(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight(), "initMediaPlayer, onVideoSizeChanged# width: ", " height: ", TAG);
        textureViewPreference.updateLayout(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseMediaPlayer(SurfaceTexture surfaceTexture) {
        MainLogger.m7258i(TAG, "releaseMediaPlayer");
        surfaceTexture.release();
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        Intrinsics.checkNotNull(mediaPlayer);
        mediaPlayer.stop();
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer2);
        mediaPlayer2.release();
        this.mMediaPlayer = null;
    }

    private final void updateLayout(int width, int height) {
        if (this.mItemView == null || this.mTextureView == null || width <= 0 || height <= 0) {
            return;
        }
        AbstractC8014b.m7200b(width, height, "updateLayout# width: ", " height:", TAG);
        View view = this.mItemView;
        Intrinsics.checkNotNull(view);
        int width2 = view.getWidth();
        if (ModelFeature.getFeature().isFoldableModel()) {
            width2 = (int) (((double) width2) * 0.54d);
        }
        View view2 = this.mItemView;
        Intrinsics.checkNotNull(view2);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        int i = (height * width2) / width;
        layoutParams.height = i;
        View view3 = this.mItemView;
        Intrinsics.checkNotNull(view3);
        view3.setLayoutParams(layoutParams);
        TextureView textureView = this.mTextureView;
        Intrinsics.checkNotNull(textureView);
        textureView.setLayoutParams(new FrameLayout.LayoutParams(width2, i, 17));
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(@NotNull PreferenceViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MainLogger.m7258i(TAG, "onBindViewHolder");
        super.onBindViewHolder(holder);
        this.mItemView = holder.itemView;
        View viewFindViewById = holder.findViewById(C8003R.id.settings_textureview);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.TextureView");
        TextureView textureView = (TextureView) viewFindViewById;
        this.mTextureView = textureView;
        Intrinsics.checkNotNull(textureView);
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.samsung.android.support.senl.nt.app.settings.common.component.TextureViewPreference.onBindViewHolder.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
                Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
                StringBuilder sb = new StringBuilder("onSurfaceTextureAvailable# width: ");
                sb.append(width);
                sb.append(" height:");
                AbstractC8014b.m7212n(sb, TextureViewPreference.TAG, height);
                TextureViewPreference.this.initMediaPlayer(surfaceTexture);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
                TextureViewPreference.this.releaseMediaPlayer(surfaceTexture);
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int width, int height) {
                Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
            }
        });
    }
}
