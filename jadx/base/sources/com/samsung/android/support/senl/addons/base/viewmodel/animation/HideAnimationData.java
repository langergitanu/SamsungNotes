package com.samsung.android.support.senl.addons.base.viewmodel.animation;

import android.graphics.Rect;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/animation/HideAnimationData;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/animation/IMenuHideAnimation;", "rect", "Landroid/graphics/Rect;", "isRun", "", "<init>", "(Landroid/graphics/Rect;Z)V", "mLayoutRect", "mHideAnimation", "setLayoutRect", "", "getLayoutRect", "getRunAnimation", "setRunAnimation", "animation", "getAnimationType", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class HideAnimationData implements IMenuHideAnimation {
    private boolean mHideAnimation;

    @Nullable
    private Rect mLayoutRect;

    public HideAnimationData(@Nullable Rect rect, boolean z) {
        this.mLayoutRect = rect;
        this.mHideAnimation = z;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.animation.IMenuHideAnimation
    public int getAnimationType() {
        return this.mHideAnimation ? IMenuHideAnimation.INSTANCE.getTYPE_ANIMATION_HIDE() : IMenuHideAnimation.INSTANCE.getTYPE_ANIMATION_SHOW();
    }

    @Nullable
    /* JADX INFO: renamed from: getLayoutRect, reason: from getter */
    public Rect getMLayoutRect() {
        return this.mLayoutRect;
    }

    /* JADX INFO: renamed from: getRunAnimation, reason: from getter */
    public boolean getMHideAnimation() {
        return this.mHideAnimation;
    }

    public final void setLayoutRect(@Nullable Rect rect) {
        this.mLayoutRect = rect;
    }

    public final void setRunAnimation(boolean animation) {
        this.mHideAnimation = animation;
    }
}
