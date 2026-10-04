package com.samsung.android.vexfwk.param;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.AbstractC0622a;
import androidx.emoji2.text.flatbuffer.C2747a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.vexfwk.imageeffect.ImageEffectType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Parcelize
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u0001:BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003JY\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001J\u0013\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0005HÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001J\u0019\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016¨\u0006;"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkImageEffectParams;", "Landroid/os/Parcelable;", "effect", "Lcom/samsung/android/vexfwk/imageeffect/ImageEffectType;", "intensity", "", "temperature", "saturation", "contrast", "grain", "radius", "", "applyNegativeSegMap", "", "(Lcom/samsung/android/vexfwk/imageeffect/ImageEffectType;IIIIIFZ)V", "getApplyNegativeSegMap", "()Z", "setApplyNegativeSegMap", "(Z)V", "getContrast", "()I", "setContrast", "(I)V", "getEffect", "()Lcom/samsung/android/vexfwk/imageeffect/ImageEffectType;", "getGrain", "setGrain", "getIntensity", "setIntensity", "getRadius", "()F", "setRadius", "(F)V", "getSaturation", "setSaturation", "getTemperature", "setTemperature", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class VexFwkImageEffectParams implements Parcelable {
    private boolean applyNegativeSegMap;
    private int contrast;

    @NotNull
    private final ImageEffectType effect;
    private int grain;
    private int intensity;
    private float radius;
    private int saturation;
    private int temperature;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<VexFwkImageEffectParams> CREATOR = new Creator();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkImageEffectParams$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseParcelable;", "Lcom/samsung/android/vexfwk/param/VexFwkImageEffectParams;", "()V", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion extends VexFwkParamBaseParcelable<VexFwkImageEffectParams> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
            super(new C2747a(5));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Creator implements Parcelable.Creator<VexFwkImageEffectParams> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VexFwkImageEffectParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VexFwkImageEffectParams(ImageEffectType.valueOf(parcel.readString()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readFloat(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VexFwkImageEffectParams[] newArray(int i) {
            return new VexFwkImageEffectParams[i];
        }
    }

    public VexFwkImageEffectParams(@NotNull ImageEffectType effect, int i, int i2, int i4, int i5, int i6, float f, boolean z) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        this.effect = effect;
        this.intensity = i;
        this.temperature = i2;
        this.saturation = i4;
        this.contrast = i5;
        this.grain = i6;
        this.radius = f;
        this.applyNegativeSegMap = z;
    }

    public static /* synthetic */ VexFwkImageEffectParams copy$default(VexFwkImageEffectParams vexFwkImageEffectParams, ImageEffectType imageEffectType, int i, int i2, int i4, int i5, int i6, float f, boolean z, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            imageEffectType = vexFwkImageEffectParams.effect;
        }
        if ((i7 & 2) != 0) {
            i = vexFwkImageEffectParams.intensity;
        }
        if ((i7 & 4) != 0) {
            i2 = vexFwkImageEffectParams.temperature;
        }
        if ((i7 & 8) != 0) {
            i4 = vexFwkImageEffectParams.saturation;
        }
        if ((i7 & 16) != 0) {
            i5 = vexFwkImageEffectParams.contrast;
        }
        if ((i7 & 32) != 0) {
            i6 = vexFwkImageEffectParams.grain;
        }
        if ((i7 & 64) != 0) {
            f = vexFwkImageEffectParams.radius;
        }
        if ((i7 & 128) != 0) {
            z = vexFwkImageEffectParams.applyNegativeSegMap;
        }
        float f4 = f;
        boolean z2 = z;
        int i8 = i5;
        int i9 = i6;
        return vexFwkImageEffectParams.copy(imageEffectType, i, i2, i4, i8, i9, f4, z2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ImageEffectType getEffect() {
        return this.effect;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getIntensity() {
        return this.intensity;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTemperature() {
        return this.temperature;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSaturation() {
        return this.saturation;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getContrast() {
        return this.contrast;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getGrain() {
        return this.grain;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getRadius() {
        return this.radius;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getApplyNegativeSegMap() {
        return this.applyNegativeSegMap;
    }

    @NotNull
    public final VexFwkImageEffectParams copy(@NotNull ImageEffectType effect, int intensity, int temperature, int saturation, int contrast, int grain, float radius, boolean applyNegativeSegMap) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        return new VexFwkImageEffectParams(effect, intensity, temperature, saturation, contrast, grain, radius, applyNegativeSegMap);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VexFwkImageEffectParams)) {
            return false;
        }
        VexFwkImageEffectParams vexFwkImageEffectParams = (VexFwkImageEffectParams) other;
        return this.effect == vexFwkImageEffectParams.effect && this.intensity == vexFwkImageEffectParams.intensity && this.temperature == vexFwkImageEffectParams.temperature && this.saturation == vexFwkImageEffectParams.saturation && this.contrast == vexFwkImageEffectParams.contrast && this.grain == vexFwkImageEffectParams.grain && Float.compare(this.radius, vexFwkImageEffectParams.radius) == 0 && this.applyNegativeSegMap == vexFwkImageEffectParams.applyNegativeSegMap;
    }

    public final boolean getApplyNegativeSegMap() {
        return this.applyNegativeSegMap;
    }

    public final int getContrast() {
        return this.contrast;
    }

    @NotNull
    public final ImageEffectType getEffect() {
        return this.effect;
    }

    public final int getGrain() {
        return this.grain;
    }

    public final int getIntensity() {
        return this.intensity;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final int getSaturation() {
        return this.saturation;
    }

    public final int getTemperature() {
        return this.temperature;
    }

    public int hashCode() {
        return Boolean.hashCode(this.applyNegativeSegMap) + AbstractC0622a.m1156b(this.radius, AbstractC0622a.m1157c(this.grain, AbstractC0622a.m1157c(this.contrast, AbstractC0622a.m1157c(this.saturation, AbstractC0622a.m1157c(this.temperature, AbstractC0622a.m1157c(this.intensity, this.effect.hashCode() * 31, 31), 31), 31), 31), 31), 31);
    }

    public final void setApplyNegativeSegMap(boolean z) {
        this.applyNegativeSegMap = z;
    }

    public final void setContrast(int i) {
        this.contrast = i;
    }

    public final void setGrain(int i) {
        this.grain = i;
    }

    public final void setIntensity(int i) {
        this.intensity = i;
    }

    public final void setRadius(float f) {
        this.radius = f;
    }

    public final void setSaturation(int i) {
        this.saturation = i;
    }

    public final void setTemperature(int i) {
        this.temperature = i;
    }

    @NotNull
    public String toString() {
        ImageEffectType imageEffectType = this.effect;
        int i = this.intensity;
        int i2 = this.temperature;
        int i4 = this.saturation;
        int i5 = this.contrast;
        int i6 = this.grain;
        float f = this.radius;
        boolean z = this.applyNegativeSegMap;
        StringBuilder sb = new StringBuilder("VexFwkImageEffectParams(effect=");
        sb.append(imageEffectType);
        sb.append(", intensity=");
        sb.append(i);
        sb.append(", temperature=");
        AbstractC2821a.m2235z(sb, i2, i4, ", saturation=", ", contrast=");
        AbstractC2821a.m2235z(sb, i5, i6, ", grain=", ", radius=");
        sb.append(f);
        sb.append(", applyNegativeSegMap=");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.effect.name());
        parcel.writeInt(this.intensity);
        parcel.writeInt(this.temperature);
        parcel.writeInt(this.saturation);
        parcel.writeInt(this.contrast);
        parcel.writeInt(this.grain);
        parcel.writeFloat(this.radius);
        parcel.writeInt(this.applyNegativeSegMap ? 1 : 0);
    }
}
