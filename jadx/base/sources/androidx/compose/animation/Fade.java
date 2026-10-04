package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m13886d2 = {"Landroidx/compose/animation/Fade;", "", "alpha", "", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(FLandroidx/compose/animation/core/FiniteAnimationSpec;)V", "getAlpha", "()F", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class Fade {
    public static final int $stable = 0;
    private final float alpha;

    @NotNull
    private final FiniteAnimationSpec<Float> animationSpec;

    public Fade(float f, @NotNull FiniteAnimationSpec<Float> finiteAnimationSpec) {
        this.alpha = f;
        this.animationSpec = finiteAnimationSpec;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Fade copy$default(Fade fade, float f, FiniteAnimationSpec finiteAnimationSpec, int i, Object obj) {
        if ((i & 1) != 0) {
            f = fade.alpha;
        }
        if ((i & 2) != 0) {
            finiteAnimationSpec = fade.animationSpec;
        }
        return fade.copy(f, finiteAnimationSpec);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    @NotNull
    public final FiniteAnimationSpec<Float> component2() {
        return this.animationSpec;
    }

    @NotNull
    public final Fade copy(float alpha, @NotNull FiniteAnimationSpec<Float> animationSpec) {
        return new Fade(alpha, animationSpec);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Fade)) {
            return false;
        }
        Fade fade = (Fade) other;
        return Float.compare(this.alpha, fade.alpha) == 0 && Intrinsics.areEqual(this.animationSpec, fade.animationSpec);
    }

    public final float getAlpha() {
        return this.alpha;
    }

    @NotNull
    public final FiniteAnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public int hashCode() {
        return this.animationSpec.hashCode() + (Float.hashCode(this.alpha) * 31);
    }

    @NotNull
    public String toString() {
        return "Fade(alpha=" + this.alpha + ", animationSpec=" + this.animationSpec + PropertyUtils.MAPPED_DELIM2;
    }
}
