package com.samsung.android.vexfwk.param;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.emoji2.text.flatbuffer.C2747a;
import com.samsung.android.vexfwk.Bokeheffect.BokehEffectType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Parcelize
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkBokehEffectParams;", "Landroid/os/Parcelable;", "effectTypeId", "Lcom/samsung/android/vexfwk/Bokeheffect/BokehEffectType;", "effectLevel", "", "imageOrientation", "saveAsFlip", "reLightLevel", "(Lcom/samsung/android/vexfwk/Bokeheffect/BokehEffectType;IIII)V", "getEffectLevel", "()I", "setEffectLevel", "(I)V", "getEffectTypeId", "()Lcom/samsung/android/vexfwk/Bokeheffect/BokehEffectType;", "setEffectTypeId", "(Lcom/samsung/android/vexfwk/Bokeheffect/BokehEffectType;)V", "getImageOrientation", "setImageOrientation", "getReLightLevel", "setReLightLevel", "getSaveAsFlip", "setSaveAsFlip", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkBokehEffectParams implements Parcelable {
    private int effectLevel;

    @NotNull
    private BokehEffectType effectTypeId;
    private int imageOrientation;
    private int reLightLevel;
    private int saveAsFlip;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<VexFwkBokehEffectParams> CREATOR = new Creator();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkBokehEffectParams$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseParcelable;", "Lcom/samsung/android/vexfwk/param/VexFwkBokehEffectParams;", "()V", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion extends VexFwkParamBaseParcelable<VexFwkBokehEffectParams> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
            super(new C2747a(4));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Creator implements Parcelable.Creator<VexFwkBokehEffectParams> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VexFwkBokehEffectParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VexFwkBokehEffectParams(BokehEffectType.valueOf(parcel.readString()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VexFwkBokehEffectParams[] newArray(int i) {
            return new VexFwkBokehEffectParams[i];
        }
    }

    public VexFwkBokehEffectParams(@NotNull BokehEffectType effectTypeId, int i, int i2, int i4, int i5) {
        Intrinsics.checkNotNullParameter(effectTypeId, "effectTypeId");
        this.effectTypeId = effectTypeId;
        this.effectLevel = i;
        this.imageOrientation = i2;
        this.saveAsFlip = i4;
        this.reLightLevel = i5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getEffectLevel() {
        return this.effectLevel;
    }

    @NotNull
    public final BokehEffectType getEffectTypeId() {
        return this.effectTypeId;
    }

    public final int getImageOrientation() {
        return this.imageOrientation;
    }

    public final int getReLightLevel() {
        return this.reLightLevel;
    }

    public final int getSaveAsFlip() {
        return this.saveAsFlip;
    }

    public final void setEffectLevel(int i) {
        this.effectLevel = i;
    }

    public final void setEffectTypeId(@NotNull BokehEffectType bokehEffectType) {
        Intrinsics.checkNotNullParameter(bokehEffectType, "<set-?>");
        this.effectTypeId = bokehEffectType;
    }

    public final void setImageOrientation(int i) {
        this.imageOrientation = i;
    }

    public final void setReLightLevel(int i) {
        this.reLightLevel = i;
    }

    public final void setSaveAsFlip(int i) {
        this.saveAsFlip = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.effectTypeId.name());
        parcel.writeInt(this.effectLevel);
        parcel.writeInt(this.imageOrientation);
        parcel.writeInt(this.saveAsFlip);
        parcel.writeInt(this.reLightLevel);
    }
}
