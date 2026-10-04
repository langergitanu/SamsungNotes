package com.samsung.android.sdk.pen.setting;

import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.Key;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u0019J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H$J \u0010$\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H$J\b\u0010'\u001a\u00020\u0019H&R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u001c\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0011\u0010\u001f\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b \u0010\rR\u0011\u0010!\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\"\u0010\r¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushNextMovement;", "", "target", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mStrategy", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveAniStrategy;", "mTarget", "value", "", "currentDegree", "getCurrentDegree", "()F", "nextDegree", "getNextDegree", "", "fromAlignment", "getFromAlignment", "()I", "toAlignment", "getToAlignment", "decideDirection", "", "applyStrategy", "", "strategy", "needLeftRightFlip", Key.ROTATION, "getRotation", "hasSameDegree", "aniRotation", "getAniRotation", "viewRotation", "getViewRotation", "decideCurrentDegree", "decideNextDegree", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveStrategy;", "layoutDirection", "needTopDownFlip", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenBrushNextMovement {

    @NotNull
    private static final String TAG = "SpenBrushNextMovement";
    private float currentDegree;
    private int fromAlignment;

    @Nullable
    private SpenBrushMoveAniStrategy mStrategy;

    @NotNull
    private final View mTarget;
    private float nextDegree;
    private int toAlignment;

    public SpenBrushNextMovement(@NotNull View target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.mTarget = target;
        this.mStrategy = null;
        this.currentDegree = 0.0f;
        this.nextDegree = 0.0f;
        this.fromAlignment = 0;
        this.toAlignment = 0;
    }

    public final boolean applyStrategy(@NotNull SpenBrushMoveAniStrategy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        if (this.fromAlignment == 0 && this.toAlignment == 0) {
            return false;
        }
        this.mStrategy = strategy;
        this.currentDegree = decideCurrentDegree(this.mTarget);
        SpenBrushMoveAniStrategy spenBrushMoveAniStrategy = this.mStrategy;
        Intrinsics.checkNotNull(spenBrushMoveAniStrategy, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.SpenBrushMoveStrategy");
        float fDecideNextDegree = decideNextDegree((SpenBrushMoveStrategy) spenBrushMoveAniStrategy, this.toAlignment, this.mTarget.getResources().getConfiguration().getLayoutDirection());
        this.nextDegree = fDecideNextDegree;
        Log.d(TAG, AbstractC0541b.m770l("Degree[", this.currentDegree, " -> ", fDecideNextDegree, "]"));
        return true;
    }

    public abstract float decideCurrentDegree(@NotNull View target);

    public final void decideDirection(int fromAlignment, int toAlignment) {
        this.fromAlignment = fromAlignment;
        this.toAlignment = toAlignment;
    }

    public abstract float decideNextDegree(@NotNull SpenBrushMoveStrategy strategy, int toAlignment, int layoutDirection);

    public final float getAniRotation() {
        SpenBrushMoveAniStrategy spenBrushMoveAniStrategy = this.mStrategy;
        if (spenBrushMoveAniStrategy != null) {
            return spenBrushMoveAniStrategy.getAniRotation();
        }
        return 0.0f;
    }

    public final float getCurrentDegree() {
        return this.currentDegree;
    }

    public final int getFromAlignment() {
        return this.fromAlignment;
    }

    public final float getNextDegree() {
        return this.nextDegree;
    }

    public final float getRotation() {
        return (hasSameDegree() && this.fromAlignment != this.toAlignment && getAniRotation() == 0.0f) ? 180.0f : 0.0f;
    }

    public final int getToAlignment() {
        return this.toAlignment;
    }

    public final float getViewRotation() {
        return this.mTarget.getRotation();
    }

    public final boolean hasSameDegree() {
        return this.currentDegree == this.nextDegree;
    }

    public final boolean needLeftRightFlip() {
        return !hasSameDegree();
    }

    public abstract boolean needTopDownFlip();
}
