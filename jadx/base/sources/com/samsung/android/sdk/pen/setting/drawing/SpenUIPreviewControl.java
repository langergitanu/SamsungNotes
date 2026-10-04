package com.samsung.android.sdk.pen.setting.drawing;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J*\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000eH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000eH&J\b\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenUIPreviewControl;", "", "release", "", "makePreview", "Landroid/view/View;", "context", "Landroid/content/Context;", "setPenInfo", "penType", "", "strokeSize", "", "color", "", "particleDensity", "setSize", "setAlpha", "alpha", "setParticleDensity", "density", "hasAdaptiveBackgroundColor", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenUIPreviewControl {
    boolean hasAdaptiveBackgroundColor();

    @NotNull
    View makePreview(@NotNull Context context);

    void release();

    void setAlpha(int alpha);

    void setParticleDensity(int density);

    void setPenInfo(@Nullable String penType, float strokeSize, int color, int particleDensity);

    void setSize(float strokeSize);
}
