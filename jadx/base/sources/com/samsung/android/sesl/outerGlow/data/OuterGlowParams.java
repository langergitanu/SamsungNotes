package com.samsung.android.sesl.outerGlow.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sesl/outerGlow/data/OuterGlowParams;", "", "viewParams", "Lcom/samsung/android/sesl/outerGlow/data/ViewParams;", "animationParams", "Lcom/samsung/android/sesl/outerGlow/data/AnimationParams;", "colorParams", "Lcom/samsung/android/sesl/outerGlow/data/ColorParams;", "blurParams", "Lcom/samsung/android/sesl/outerGlow/data/BlurParams;", "imageAdjustmentParams", "Lcom/samsung/android/sesl/outerGlow/data/ImageAdjustmentParams;", "(Lcom/samsung/android/sesl/outerGlow/data/ViewParams;Lcom/samsung/android/sesl/outerGlow/data/AnimationParams;Lcom/samsung/android/sesl/outerGlow/data/ColorParams;Lcom/samsung/android/sesl/outerGlow/data/BlurParams;Lcom/samsung/android/sesl/outerGlow/data/ImageAdjustmentParams;)V", "getAnimationParams", "()Lcom/samsung/android/sesl/outerGlow/data/AnimationParams;", "getBlurParams", "()Lcom/samsung/android/sesl/outerGlow/data/BlurParams;", "getColorParams", "()Lcom/samsung/android/sesl/outerGlow/data/ColorParams;", "getImageAdjustmentParams", "()Lcom/samsung/android/sesl/outerGlow/data/ImageAdjustmentParams;", "getViewParams", "()Lcom/samsung/android/sesl/outerGlow/data/ViewParams;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class OuterGlowParams {

    @NotNull
    private final AnimationParams animationParams;

    @NotNull
    private final BlurParams blurParams;

    @NotNull
    private final ColorParams colorParams;

    @Nullable
    private final ImageAdjustmentParams imageAdjustmentParams;

    @NotNull
    private final ViewParams viewParams;

    public OuterGlowParams(@NotNull ViewParams viewParams, @NotNull AnimationParams animationParams, @NotNull ColorParams colorParams, @NotNull BlurParams blurParams, @Nullable ImageAdjustmentParams imageAdjustmentParams) {
        Intrinsics.checkNotNullParameter(viewParams, "viewParams");
        Intrinsics.checkNotNullParameter(animationParams, "animationParams");
        Intrinsics.checkNotNullParameter(colorParams, "colorParams");
        Intrinsics.checkNotNullParameter(blurParams, "blurParams");
        this.viewParams = viewParams;
        this.animationParams = animationParams;
        this.colorParams = colorParams;
        this.blurParams = blurParams;
        this.imageAdjustmentParams = imageAdjustmentParams;
    }

    public static /* synthetic */ OuterGlowParams copy$default(OuterGlowParams outerGlowParams, ViewParams viewParams, AnimationParams animationParams, ColorParams colorParams, BlurParams blurParams, ImageAdjustmentParams imageAdjustmentParams, int i, Object obj) {
        if ((i & 1) != 0) {
            viewParams = outerGlowParams.viewParams;
        }
        if ((i & 2) != 0) {
            animationParams = outerGlowParams.animationParams;
        }
        if ((i & 4) != 0) {
            colorParams = outerGlowParams.colorParams;
        }
        if ((i & 8) != 0) {
            blurParams = outerGlowParams.blurParams;
        }
        if ((i & 16) != 0) {
            imageAdjustmentParams = outerGlowParams.imageAdjustmentParams;
        }
        ImageAdjustmentParams imageAdjustmentParams2 = imageAdjustmentParams;
        ColorParams colorParams2 = colorParams;
        return outerGlowParams.copy(viewParams, animationParams, colorParams2, blurParams, imageAdjustmentParams2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ViewParams getViewParams() {
        return this.viewParams;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AnimationParams getAnimationParams() {
        return this.animationParams;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ColorParams getColorParams() {
        return this.colorParams;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final BlurParams getBlurParams() {
        return this.blurParams;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ImageAdjustmentParams getImageAdjustmentParams() {
        return this.imageAdjustmentParams;
    }

    @NotNull
    public final OuterGlowParams copy(@NotNull ViewParams viewParams, @NotNull AnimationParams animationParams, @NotNull ColorParams colorParams, @NotNull BlurParams blurParams, @Nullable ImageAdjustmentParams imageAdjustmentParams) {
        Intrinsics.checkNotNullParameter(viewParams, "viewParams");
        Intrinsics.checkNotNullParameter(animationParams, "animationParams");
        Intrinsics.checkNotNullParameter(colorParams, "colorParams");
        Intrinsics.checkNotNullParameter(blurParams, "blurParams");
        return new OuterGlowParams(viewParams, animationParams, colorParams, blurParams, imageAdjustmentParams);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OuterGlowParams)) {
            return false;
        }
        OuterGlowParams outerGlowParams = (OuterGlowParams) other;
        return Intrinsics.areEqual(this.viewParams, outerGlowParams.viewParams) && Intrinsics.areEqual(this.animationParams, outerGlowParams.animationParams) && Intrinsics.areEqual(this.colorParams, outerGlowParams.colorParams) && Intrinsics.areEqual(this.blurParams, outerGlowParams.blurParams) && Intrinsics.areEqual(this.imageAdjustmentParams, outerGlowParams.imageAdjustmentParams);
    }

    @NotNull
    public final AnimationParams getAnimationParams() {
        return this.animationParams;
    }

    @NotNull
    public final BlurParams getBlurParams() {
        return this.blurParams;
    }

    @NotNull
    public final ColorParams getColorParams() {
        return this.colorParams;
    }

    @Nullable
    public final ImageAdjustmentParams getImageAdjustmentParams() {
        return this.imageAdjustmentParams;
    }

    @NotNull
    public final ViewParams getViewParams() {
        return this.viewParams;
    }

    public int hashCode() {
        int iHashCode = (this.blurParams.hashCode() + ((this.colorParams.hashCode() + ((this.animationParams.hashCode() + (this.viewParams.hashCode() * 31)) * 31)) * 31)) * 31;
        ImageAdjustmentParams imageAdjustmentParams = this.imageAdjustmentParams;
        return iHashCode + (imageAdjustmentParams == null ? 0 : imageAdjustmentParams.hashCode());
    }

    @NotNull
    public String toString() {
        return "OuterGlowParams(viewParams=" + this.viewParams + ", animationParams=" + this.animationParams + ", colorParams=" + this.colorParams + ", blurParams=" + this.blurParams + ", imageAdjustmentParams=" + this.imageAdjustmentParams + ")";
    }

    public /* synthetic */ OuterGlowParams(ViewParams viewParams, AnimationParams animationParams, ColorParams colorParams, BlurParams blurParams, ImageAdjustmentParams imageAdjustmentParams, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewParams, animationParams, colorParams, blurParams, (i & 16) != 0 ? null : imageAdjustmentParams);
    }
}
