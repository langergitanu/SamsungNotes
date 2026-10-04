package androidx.compose.animation;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.Immutable;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\u0019\u0010\"\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0003J]\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0001J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, m13886d2 = {"Landroidx/compose/animation/TransitionData;", "", "fade", "Landroidx/compose/animation/Fade;", "slide", "Landroidx/compose/animation/Slide;", "changeSize", "Landroidx/compose/animation/ChangeSize;", WiggleAnimationConfig.KEY_SCALE, "Landroidx/compose/animation/Scale;", "hold", "", "effectsMap", "", "Landroidx/compose/animation/TransitionEffectKey;", "Landroidx/compose/animation/TransitionEffect;", "(Landroidx/compose/animation/Fade;Landroidx/compose/animation/Slide;Landroidx/compose/animation/ChangeSize;Landroidx/compose/animation/Scale;ZLjava/util/Map;)V", "getChangeSize", "()Landroidx/compose/animation/ChangeSize;", "getEffectsMap", "()Ljava/util/Map;", "getFade", "()Landroidx/compose/animation/Fade;", "getHold", "()Z", "getScale", "()Landroidx/compose/animation/Scale;", "getSlide", "()Landroidx/compose/animation/Slide;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class TransitionData {
    public static final int $stable = 0;

    @Nullable
    private final ChangeSize changeSize;

    @NotNull
    private final Map<TransitionEffectKey<?>, TransitionEffect> effectsMap;

    @Nullable
    private final Fade fade;
    private final boolean hold;

    @Nullable
    private final Scale scale;

    @Nullable
    private final Slide slide;

    public TransitionData() {
        this(null, null, null, null, false, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransitionData copy$default(TransitionData transitionData, Fade fade, Slide slide, ChangeSize changeSize, Scale scale, boolean z, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            fade = transitionData.fade;
        }
        if ((i & 2) != 0) {
            slide = transitionData.slide;
        }
        if ((i & 4) != 0) {
            changeSize = transitionData.changeSize;
        }
        if ((i & 8) != 0) {
            scale = transitionData.scale;
        }
        if ((i & 16) != 0) {
            z = transitionData.hold;
        }
        if ((i & 32) != 0) {
            map = transitionData.effectsMap;
        }
        boolean z2 = z;
        Map map2 = map;
        return transitionData.copy(fade, slide, changeSize, scale, z2, map2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Fade getFade() {
        return this.fade;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Slide getSlide() {
        return this.slide;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ChangeSize getChangeSize() {
        return this.changeSize;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Scale getScale() {
        return this.scale;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getHold() {
        return this.hold;
    }

    @NotNull
    public final Map<TransitionEffectKey<?>, TransitionEffect> component6() {
        return this.effectsMap;
    }

    @NotNull
    public final TransitionData copy(@Nullable Fade fade, @Nullable Slide slide, @Nullable ChangeSize changeSize, @Nullable Scale scale, boolean hold, @NotNull Map<TransitionEffectKey<?>, ? extends TransitionEffect> effectsMap) {
        return new TransitionData(fade, slide, changeSize, scale, hold, effectsMap);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransitionData)) {
            return false;
        }
        TransitionData transitionData = (TransitionData) other;
        return Intrinsics.areEqual(this.fade, transitionData.fade) && Intrinsics.areEqual(this.slide, transitionData.slide) && Intrinsics.areEqual(this.changeSize, transitionData.changeSize) && Intrinsics.areEqual(this.scale, transitionData.scale) && this.hold == transitionData.hold && Intrinsics.areEqual(this.effectsMap, transitionData.effectsMap);
    }

    @Nullable
    public final ChangeSize getChangeSize() {
        return this.changeSize;
    }

    @NotNull
    public final Map<TransitionEffectKey<?>, TransitionEffect> getEffectsMap() {
        return this.effectsMap;
    }

    @Nullable
    public final Fade getFade() {
        return this.fade;
    }

    public final boolean getHold() {
        return this.hold;
    }

    @Nullable
    public final Scale getScale() {
        return this.scale;
    }

    @Nullable
    public final Slide getSlide() {
        return this.slide;
    }

    public int hashCode() {
        Fade fade = this.fade;
        int iHashCode = (fade == null ? 0 : fade.hashCode()) * 31;
        Slide slide = this.slide;
        int iHashCode2 = (iHashCode + (slide == null ? 0 : slide.hashCode())) * 31;
        ChangeSize changeSize = this.changeSize;
        int iHashCode3 = (iHashCode2 + (changeSize == null ? 0 : changeSize.hashCode())) * 31;
        Scale scale = this.scale;
        return this.effectsMap.hashCode() + AbstractC0622a.m1160f(this.hold, (iHashCode3 + (scale != null ? scale.hashCode() : 0)) * 31, 31);
    }

    @NotNull
    public String toString() {
        return "TransitionData(fade=" + this.fade + ", slide=" + this.slide + ", changeSize=" + this.changeSize + ", scale=" + this.scale + ", hold=" + this.hold + ", effectsMap=" + this.effectsMap + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransitionData(@Nullable Fade fade, @Nullable Slide slide, @Nullable ChangeSize changeSize, @Nullable Scale scale, boolean z, @NotNull Map<TransitionEffectKey<?>, ? extends TransitionEffect> map) {
        this.fade = fade;
        this.slide = slide;
        this.changeSize = changeSize;
        this.scale = scale;
        this.hold = z;
        this.effectsMap = map;
    }

    public /* synthetic */ TransitionData(Fade fade, Slide slide, ChangeSize changeSize, Scale scale, boolean z, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : fade, (i & 2) != 0 ? null : slide, (i & 4) != 0 ? null : changeSize, (i & 8) != 0 ? null : scale, (i & 16) != 0 ? false : z, (i & 32) != 0 ? MapsKt.emptyMap() : map);
    }
}
