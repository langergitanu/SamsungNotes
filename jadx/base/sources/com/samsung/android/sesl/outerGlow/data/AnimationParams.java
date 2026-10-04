package com.samsung.android.sesl.outerGlow.data;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sesl/outerGlow/data/AnimationParams;", "", "speed", "", "tailLength", "headThin", "tailThin", "feather", "tailFadePower", "segments", "(FFFFFFF)V", "getFeather", "()F", "getHeadThin", "getSegments", "getSpeed", "getTailFadePower", "getTailLength", "getTailThin", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class AnimationParams {
    private final float feather;
    private final float headThin;
    private final float segments;
    private final float speed;
    private final float tailFadePower;
    private final float tailLength;
    private final float tailThin;

    public AnimationParams() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 127, null);
    }

    public static /* synthetic */ AnimationParams copy$default(AnimationParams animationParams, float f, float f4, float f5, float f6, float f7, float f8, float f9, int i, Object obj) {
        if ((i & 1) != 0) {
            f = animationParams.speed;
        }
        if ((i & 2) != 0) {
            f4 = animationParams.tailLength;
        }
        if ((i & 4) != 0) {
            f5 = animationParams.headThin;
        }
        if ((i & 8) != 0) {
            f6 = animationParams.tailThin;
        }
        if ((i & 16) != 0) {
            f7 = animationParams.feather;
        }
        if ((i & 32) != 0) {
            f8 = animationParams.tailFadePower;
        }
        if ((i & 64) != 0) {
            f9 = animationParams.segments;
        }
        float f10 = f8;
        float f11 = f9;
        float f12 = f7;
        float f13 = f5;
        return animationParams.copy(f, f4, f13, f6, f12, f10, f11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getSpeed() {
        return this.speed;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getTailLength() {
        return this.tailLength;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getHeadThin() {
        return this.headThin;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getTailThin() {
        return this.tailThin;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getFeather() {
        return this.feather;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getTailFadePower() {
        return this.tailFadePower;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getSegments() {
        return this.segments;
    }

    @NotNull
    public final AnimationParams copy(float speed, float tailLength, float headThin, float tailThin, float feather, float tailFadePower, float segments) {
        return new AnimationParams(speed, tailLength, headThin, tailThin, feather, tailFadePower, segments);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimationParams)) {
            return false;
        }
        AnimationParams animationParams = (AnimationParams) other;
        return Float.compare(this.speed, animationParams.speed) == 0 && Float.compare(this.tailLength, animationParams.tailLength) == 0 && Float.compare(this.headThin, animationParams.headThin) == 0 && Float.compare(this.tailThin, animationParams.tailThin) == 0 && Float.compare(this.feather, animationParams.feather) == 0 && Float.compare(this.tailFadePower, animationParams.tailFadePower) == 0 && Float.compare(this.segments, animationParams.segments) == 0;
    }

    public final float getFeather() {
        return this.feather;
    }

    public final float getHeadThin() {
        return this.headThin;
    }

    public final float getSegments() {
        return this.segments;
    }

    public final float getSpeed() {
        return this.speed;
    }

    public final float getTailFadePower() {
        return this.tailFadePower;
    }

    public final float getTailLength() {
        return this.tailLength;
    }

    public final float getTailThin() {
        return this.tailThin;
    }

    public int hashCode() {
        return Float.hashCode(this.segments) + AbstractC0622a.m1156b(this.tailFadePower, AbstractC0622a.m1156b(this.feather, AbstractC0622a.m1156b(this.tailThin, AbstractC0622a.m1156b(this.headThin, AbstractC0622a.m1156b(this.tailLength, Float.hashCode(this.speed) * 31, 31), 31), 31), 31), 31);
    }

    @NotNull
    public String toString() {
        float f = this.speed;
        float f4 = this.tailLength;
        float f5 = this.headThin;
        float f6 = this.tailThin;
        float f7 = this.feather;
        float f8 = this.tailFadePower;
        float f9 = this.segments;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("AnimationParams(speed=", f, ", tailLength=", f4, ", headThin=");
        AbstractC11014a.m12337v(sbM1176v, f5, ", tailThin=", f6, ", feather=");
        AbstractC11014a.m12337v(sbM1176v, f7, ", tailFadePower=", f8, ", segments=");
        return AbstractC1038a.m1217r(sbM1176v, ")", f9);
    }

    public AnimationParams(float f, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.speed = f;
        this.tailLength = f4;
        this.headThin = f5;
        this.tailThin = f6;
        this.feather = f7;
        this.tailFadePower = f8;
        this.segments = f9;
    }

    public /* synthetic */ AnimationParams(float f, float f4, float f5, float f6, float f7, float f8, float f9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.4f : f, (i & 2) != 0 ? 0.5f : f4, (i & 4) != 0 ? 0.2f : f5, (i & 8) != 0 ? 0.0f : f6, (i & 16) != 0 ? 0.2f : f7, (i & 32) != 0 ? 0.5f : f8, (i & 64) != 0 ? 30.0f : f9);
    }
}
