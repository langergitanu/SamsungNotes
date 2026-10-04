package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0000J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J1\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/SpotConfig;", "", "index", "", "color", WiggleAnimationConfig.KEY_SCALE, "", "position", "Landroid/graphics/PointF;", "<init>", "(IIFLandroid/graphics/PointF;)V", "getIndex", "()I", "getColor", "setColor", "(I)V", "getScale", "()F", "setScale", "(F)V", "getPosition", "()Landroid/graphics/PointF;", "setPosition", "(Landroid/graphics/PointF;)V", "validate", "", "validated", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class SpotConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int color;
    private final int index;

    @NotNull
    private PointF position;
    private float scale;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/SpotConfig$Companion;", "", "<init>", "()V", "createDefault", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/SpotConfig;", "index", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SpotConfig createDefault(int index) {
            return new SpotConfig(index, -1, 1.0f, new PointF(0.5f, 0.5f));
        }

        private Companion() {
        }
    }

    public SpotConfig(int i, @ColorInt int i2, float f, @NotNull PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.index = i;
        this.color = i2;
        this.scale = f;
        this.position = position;
    }

    public static /* synthetic */ SpotConfig copy$default(SpotConfig spotConfig, int i, int i2, float f, PointF pointF, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = spotConfig.index;
        }
        if ((i4 & 2) != 0) {
            i2 = spotConfig.color;
        }
        if ((i4 & 4) != 0) {
            f = spotConfig.scale;
        }
        if ((i4 & 8) != 0) {
            pointF = spotConfig.position;
        }
        return spotConfig.copy(i, i2, f, pointF);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getScale() {
        return this.scale;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PointF getPosition() {
        return this.position;
    }

    @NotNull
    public final SpotConfig copy(int index, @ColorInt int color, float scale, @NotNull PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        return new SpotConfig(index, color, scale, position);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpotConfig)) {
            return false;
        }
        SpotConfig spotConfig = (SpotConfig) other;
        return this.index == spotConfig.index && this.color == spotConfig.color && Float.compare(this.scale, spotConfig.scale) == 0 && Intrinsics.areEqual(this.position, spotConfig.position);
    }

    public final int getColor() {
        return this.color;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final PointF getPosition() {
        return this.position;
    }

    public final float getScale() {
        return this.scale;
    }

    public int hashCode() {
        return this.position.hashCode() + AbstractC0622a.m1156b(this.scale, AbstractC0622a.m1157c(this.color, Integer.hashCode(this.index) * 31, 31), 31);
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setPosition(@NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.position = pointF;
    }

    public final void setScale(float f) {
        this.scale = f;
    }

    @NotNull
    public String toString() {
        int i = this.index;
        int i2 = this.color;
        float f = this.scale;
        PointF pointF = this.position;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "SpotConfig(index=", ", color=", ", scale=");
        sbM1173s.append(f);
        sbM1173s.append(", position=");
        sbM1173s.append(pointF);
        sbM1173s.append(")");
        return sbM1173s.toString();
    }

    public final void validate() {
        int i = this.index;
        if (i < 0 || i >= 4) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Spot index must be between 0 and 3, but was ").toString());
        }
        float f = this.scale;
        if (f <= 0.0f) {
            throw new IllegalArgumentException(AbstractC0622a.m1166l("Scale must be positive, but was ", f).toString());
        }
        PointF pointF = this.position;
        float f4 = pointF.x;
        if (0.0f <= f4 && f4 <= 1.0f) {
            float f5 = pointF.y;
            if (0.0f <= f5 && f5 <= 1.0f) {
                return;
            }
        }
        throw new IllegalArgumentException(("Position must be within normalized coordinates (0.0 to 1.0), but was " + pointF).toString());
    }

    @NotNull
    public final SpotConfig validated() {
        SpotConfig spotConfigCopy$default = copy$default(this, 0, 0, 0.0f, null, 15, null);
        spotConfigCopy$default.validate();
        return spotConfigCopy$default;
    }
}
