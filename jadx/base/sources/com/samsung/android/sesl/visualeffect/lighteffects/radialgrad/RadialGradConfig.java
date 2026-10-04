package com.samsung.android.sesl.visualeffect.lighteffects.radialgrad;

import android.graphics.Bitmap;
import android.util.Size;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sesl.visualeffect.lighteffects.common.config.BaseVibeEffectConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\u0019\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eHÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/RadialGradConfig;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/config/BaseVibeEffectConfig;", "backgroundColor", "", "radialMap", "Landroid/graphics/Bitmap;", "drawingBufferSize", "Landroid/util/Size;", "blurRadius", "ditherVariation", "", "spotConfigs", "Ljava/util/ArrayList;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/SpotConfig;", "Lkotlin/collections/ArrayList;", "<init>", "(ILandroid/graphics/Bitmap;Landroid/util/Size;IFLjava/util/ArrayList;)V", "getBackgroundColor", "()I", "getRadialMap", "()Landroid/graphics/Bitmap;", "getDrawingBufferSize", "()Landroid/util/Size;", "getBlurRadius", "getDitherVariation", "()F", "getSpotConfigs", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class RadialGradConfig extends BaseVibeEffectConfig {
    private final int backgroundColor;
    private final int blurRadius;
    private final float ditherVariation;

    @Nullable
    private final Size drawingBufferSize;

    @Nullable
    private final Bitmap radialMap;

    @NotNull
    private final ArrayList<SpotConfig> spotConfigs;

    public RadialGradConfig() {
        this(0, null, null, 0, 0.0f, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RadialGradConfig copy$default(RadialGradConfig radialGradConfig, int i, Bitmap bitmap, Size size, int i2, float f, ArrayList arrayList, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = radialGradConfig.backgroundColor;
        }
        if ((i4 & 2) != 0) {
            bitmap = radialGradConfig.radialMap;
        }
        if ((i4 & 4) != 0) {
            size = radialGradConfig.drawingBufferSize;
        }
        if ((i4 & 8) != 0) {
            i2 = radialGradConfig.blurRadius;
        }
        if ((i4 & 16) != 0) {
            f = radialGradConfig.ditherVariation;
        }
        if ((i4 & 32) != 0) {
            arrayList = radialGradConfig.spotConfigs;
        }
        float f4 = f;
        ArrayList arrayList2 = arrayList;
        return radialGradConfig.copy(i, bitmap, size, i2, f4, arrayList2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Bitmap getRadialMap() {
        return this.radialMap;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Size getDrawingBufferSize() {
        return this.drawingBufferSize;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBlurRadius() {
        return this.blurRadius;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getDitherVariation() {
        return this.ditherVariation;
    }

    @NotNull
    public final ArrayList<SpotConfig> component6() {
        return this.spotConfigs;
    }

    @NotNull
    public final RadialGradConfig copy(@ColorInt int backgroundColor, @Nullable Bitmap radialMap, @Nullable Size drawingBufferSize, int blurRadius, float ditherVariation, @NotNull ArrayList<SpotConfig> spotConfigs) {
        Intrinsics.checkNotNullParameter(spotConfigs, "spotConfigs");
        return new RadialGradConfig(backgroundColor, radialMap, drawingBufferSize, blurRadius, ditherVariation, spotConfigs);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RadialGradConfig)) {
            return false;
        }
        RadialGradConfig radialGradConfig = (RadialGradConfig) other;
        return this.backgroundColor == radialGradConfig.backgroundColor && Intrinsics.areEqual(this.radialMap, radialGradConfig.radialMap) && Intrinsics.areEqual(this.drawingBufferSize, radialGradConfig.drawingBufferSize) && this.blurRadius == radialGradConfig.blurRadius && Float.compare(this.ditherVariation, radialGradConfig.ditherVariation) == 0 && Intrinsics.areEqual(this.spotConfigs, radialGradConfig.spotConfigs);
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBlurRadius() {
        return this.blurRadius;
    }

    public final float getDitherVariation() {
        return this.ditherVariation;
    }

    @Nullable
    public final Size getDrawingBufferSize() {
        return this.drawingBufferSize;
    }

    @Nullable
    public final Bitmap getRadialMap() {
        return this.radialMap;
    }

    @NotNull
    public final ArrayList<SpotConfig> getSpotConfigs() {
        return this.spotConfigs;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.backgroundColor) * 31;
        Bitmap bitmap = this.radialMap;
        int iHashCode2 = (iHashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
        Size size = this.drawingBufferSize;
        return this.spotConfigs.hashCode() + AbstractC0622a.m1156b(this.ditherVariation, AbstractC0622a.m1157c(this.blurRadius, (iHashCode2 + (size != null ? size.hashCode() : 0)) * 31, 31), 31);
    }

    @NotNull
    public String toString() {
        return "RadialGradConfig(backgroundColor=" + this.backgroundColor + ", radialMap=" + this.radialMap + ", drawingBufferSize=" + this.drawingBufferSize + ", blurRadius=" + this.blurRadius + ", ditherVariation=" + this.ditherVariation + ", spotConfigs=" + this.spotConfigs + ")";
    }

    public /* synthetic */ RadialGradConfig(int i, Bitmap bitmap, Size size, int i2, float f, ArrayList arrayList, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? -1 : i, (i4 & 2) != 0 ? null : bitmap, (i4 & 4) != 0 ? null : size, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0.07f : f, (i4 & 32) != 0 ? new ArrayList() : arrayList);
    }

    public RadialGradConfig(@ColorInt int i, @Nullable Bitmap bitmap, @Nullable Size size, int i2, float f, @NotNull ArrayList<SpotConfig> spotConfigs) {
        Intrinsics.checkNotNullParameter(spotConfigs, "spotConfigs");
        this.backgroundColor = i;
        this.radialMap = bitmap;
        this.drawingBufferSize = size;
        this.blurRadius = i2;
        this.ditherVariation = f;
        this.spotConfigs = spotConfigs;
    }
}
