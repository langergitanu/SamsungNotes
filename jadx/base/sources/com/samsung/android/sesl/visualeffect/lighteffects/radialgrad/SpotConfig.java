package com.samsung.android.sesl.visualeffect.lighteffects.radialgrad;

import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/SpotConfig;", "", "enabled", "", "color", "", "position", "Landroid/graphics/PointF;", WiggleAnimationConfig.KEY_SCALE, "", "wiggle", "Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/WiggleAnimationConfig;", "<init>", "(ZILandroid/graphics/PointF;FLcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/WiggleAnimationConfig;)V", "getEnabled", "()Z", "getColor", "()I", "getPosition", "()Landroid/graphics/PointF;", "getScale", "()F", "getWiggle", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/WiggleAnimationConfig;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class SpotConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int color;
    private final boolean enabled;

    @NotNull
    private final PointF position;
    private final float scale;

    @Nullable
    private final WiggleAnimationConfig wiggle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/SpotConfig$Companion;", "", "<init>", "()V", "createDefaultSpot", "Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/SpotConfig;", "spotIndex", "", "color", "fps", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSpotConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpotConfig.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/SpotConfig$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n1#2:73\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @RequiresApi(26)
        @NotNull
        public final SpotConfig createDefaultSpot(int spotIndex, @ColorInt int color, float fps) {
            float f;
            if (spotIndex < 0 || spotIndex >= 4) {
                throw new IllegalArgumentException("Spot index must be between 0 and 3");
            }
            PointF pos_spot1 = spotIndex != 0 ? spotIndex != 1 ? spotIndex != 2 ? spotIndex != 3 ? Constants.SpotPositions.INSTANCE.getPOS_SPOT1() : Constants.SpotPositions.INSTANCE.getPOS_SPOT4() : Constants.SpotPositions.INSTANCE.getPOS_SPOT3() : Constants.SpotPositions.INSTANCE.getPOS_SPOT2() : Constants.SpotPositions.INSTANCE.getPOS_SPOT1();
            float f4 = 2.5f;
            if (spotIndex == 0) {
                f = f4;
            } else {
                if (spotIndex != 1) {
                    if (spotIndex == 2) {
                        f4 = 0.95f;
                    } else if (spotIndex != 3) {
                    }
                    f = f4;
                }
                f = 2.25f;
            }
            return new SpotConfig(false, color, pos_spot1, f, new WiggleAnimationConfig(Constants.WGL_INTERVAL, Constants.INSTANCE.getCUBIC_BEZIER_INTERPOLATOR(), Float.valueOf(0.35f), Float.valueOf(0.5f), null, fps, 16, null), 1, null);
        }

        private Companion() {
        }
    }

    public SpotConfig(boolean z, @ColorInt int i, @NotNull PointF position, float f, @Nullable WiggleAnimationConfig wiggleAnimationConfig) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.enabled = z;
        this.color = i;
        this.position = position;
        this.scale = f;
        this.wiggle = wiggleAnimationConfig;
    }

    public static /* synthetic */ SpotConfig copy$default(SpotConfig spotConfig, boolean z, int i, PointF pointF, float f, WiggleAnimationConfig wiggleAnimationConfig, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = spotConfig.enabled;
        }
        if ((i2 & 2) != 0) {
            i = spotConfig.color;
        }
        if ((i2 & 4) != 0) {
            pointF = spotConfig.position;
        }
        if ((i2 & 8) != 0) {
            f = spotConfig.scale;
        }
        if ((i2 & 16) != 0) {
            wiggleAnimationConfig = spotConfig.wiggle;
        }
        WiggleAnimationConfig wiggleAnimationConfig2 = wiggleAnimationConfig;
        PointF pointF2 = pointF;
        return spotConfig.copy(z, i, pointF2, f, wiggleAnimationConfig2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PointF getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getScale() {
        return this.scale;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final WiggleAnimationConfig getWiggle() {
        return this.wiggle;
    }

    @NotNull
    public final SpotConfig copy(boolean enabled, @ColorInt int color, @NotNull PointF position, float scale, @Nullable WiggleAnimationConfig wiggle) {
        Intrinsics.checkNotNullParameter(position, "position");
        return new SpotConfig(enabled, color, position, scale, wiggle);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpotConfig)) {
            return false;
        }
        SpotConfig spotConfig = (SpotConfig) other;
        return this.enabled == spotConfig.enabled && this.color == spotConfig.color && Intrinsics.areEqual(this.position, spotConfig.position) && Float.compare(this.scale, spotConfig.scale) == 0 && Intrinsics.areEqual(this.wiggle, spotConfig.wiggle);
    }

    public final int getColor() {
        return this.color;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    @NotNull
    public final PointF getPosition() {
        return this.position;
    }

    public final float getScale() {
        return this.scale;
    }

    @Nullable
    public final WiggleAnimationConfig getWiggle() {
        return this.wiggle;
    }

    public int hashCode() {
        int iM1156b = AbstractC0622a.m1156b(this.scale, (this.position.hashCode() + AbstractC0622a.m1157c(this.color, Boolean.hashCode(this.enabled) * 31, 31)) * 31, 31);
        WiggleAnimationConfig wiggleAnimationConfig = this.wiggle;
        return iM1156b + (wiggleAnimationConfig == null ? 0 : wiggleAnimationConfig.hashCode());
    }

    @NotNull
    public String toString() {
        return "SpotConfig(enabled=" + this.enabled + ", color=" + this.color + ", position=" + this.position + ", scale=" + this.scale + ", wiggle=" + this.wiggle + ")";
    }

    public /* synthetic */ SpotConfig(boolean z, int i, PointF pointF, float f, WiggleAnimationConfig wiggleAnimationConfig, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, i, pointF, f, (i2 & 16) != 0 ? null : wiggleAnimationConfig);
    }
}
