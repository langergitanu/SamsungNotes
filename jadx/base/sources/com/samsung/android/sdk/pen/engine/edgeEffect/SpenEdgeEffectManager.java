package com.samsung.android.sdk.pen.engine.edgeEffect;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J6\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0014J&\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fJ\u0010\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010%R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006("}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/edgeEffect/SpenEdgeEffectManager;", "", "context", "Landroid/content/Context;", "owner", "Landroid/view/View;", "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "mEdgeEffect", "Lcom/samsung/android/sdk/pen/engine/edgeEffect/SpenEdgeEffect;", "close", "", "draw", "canvas", "Landroid/graphics/Canvas;", "onTouch", "event", "Landroid/view/MotionEvent;", "showEdgeEffect", "left", "", "top", "right", "bottom", "velocityX", "", "velocityY", "setEffectEnabled", "enabled", "setScreenInfo", "width", "", "height", "startX", "startY", "attachToParentView", "viewParent", "Landroid/view/ViewParent;", "isAnimationsFinished", "()Z", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenEdgeEffectManager {

    @Nullable
    private SpenEdgeEffect mEdgeEffect;

    public SpenEdgeEffectManager(@Nullable Context context, @NotNull View owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.mEdgeEffect = Build.VERSION.SDK_INT > 30 ? new SpenStretchEdgeEffect(context, owner) : new SpenGlowEdgeEffect(context, owner);
    }

    public final void attachToParentView(@Nullable ViewParent viewParent) {
        SpenEdgeEffect spenEdgeEffect = this.mEdgeEffect;
        if (spenEdgeEffect instanceof SpenGlowEdgeEffect) {
            Intrinsics.checkNotNull(spenEdgeEffect, "null cannot be cast to non-null type com.samsung.android.sdk.pen.engine.edgeEffect.SpenGlowEdgeEffect");
            ((SpenGlowEdgeEffect) spenEdgeEffect).attachToParentView(viewParent);
        }
    }

    public final void close() {
        SpenEdgeEffect spenEdgeEffect = this.mEdgeEffect;
        if (spenEdgeEffect != null) {
            spenEdgeEffect.close();
        }
    }

    public final void draw(@Nullable Canvas canvas) {
        SpenEdgeEffect spenEdgeEffect = this.mEdgeEffect;
        if (spenEdgeEffect != null) {
            spenEdgeEffect.drawEffect(canvas);
        }
    }

    public final boolean isAnimationsFinished() {
        SpenEdgeEffect spenEdgeEffect = this.mEdgeEffect;
        if (spenEdgeEffect != null) {
            return spenEdgeEffect.isFinished();
        }
        return true;
    }

    public final void onTouch(@Nullable MotionEvent event) {
        SpenEdgeEffect spenEdgeEffect = this.mEdgeEffect;
        if (spenEdgeEffect != null) {
            spenEdgeEffect.onTouch(event);
        }
    }

    public final void setEffectEnabled(boolean enabled) {
        SpenEdgeEffect spenEdgeEffect = this.mEdgeEffect;
        if (spenEdgeEffect != null) {
            spenEdgeEffect.setEffectEnabled(enabled);
        }
    }

    public final void setScreenInfo(int width, int height, int startX, int startY) {
        SpenEdgeEffect spenEdgeEffect = this.mEdgeEffect;
        if (spenEdgeEffect != null) {
            spenEdgeEffect.setScreenInfo(width, height, startX, startY);
        }
    }

    public final void showEdgeEffect(boolean left, boolean top, boolean right, boolean bottom, float velocityX, float velocityY) {
        SpenEdgeEffect spenEdgeEffect = this.mEdgeEffect;
        if (spenEdgeEffect != null) {
            spenEdgeEffect.showEdgeEffect(left, top, right, bottom, velocityX, velocityY);
        }
    }
}
