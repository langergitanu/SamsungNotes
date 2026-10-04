package com.samsung.android.vexfwk.param;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Parcelize
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkImageTagEntity;", "Landroid/os/Parcelable;", "prop", "Lcom/samsung/android/vexfwk/param/VexFwkImageTagEntityProp;", "hierarchy", "", "(Lcom/samsung/android/vexfwk/param/VexFwkImageTagEntityProp;Ljava/util/List;)V", "getHierarchy", "()Ljava/util/List;", "getProp", "()Lcom/samsung/android/vexfwk/param/VexFwkImageTagEntityProp;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class VexFwkImageTagEntity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<VexFwkImageTagEntity> CREATOR = new Creator();

    @NotNull
    private final List<VexFwkImageTagEntityProp> hierarchy;

    @NotNull
    private final VexFwkImageTagEntityProp prop;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Creator implements Parcelable.Creator<VexFwkImageTagEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VexFwkImageTagEntity createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            VexFwkImageTagEntityProp vexFwkImageTagEntityPropCreateFromParcel = VexFwkImageTagEntityProp.CREATOR.createFromParcel(parcel);
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(VexFwkImageTagEntityProp.CREATOR.createFromParcel(parcel));
            }
            return new VexFwkImageTagEntity(vexFwkImageTagEntityPropCreateFromParcel, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VexFwkImageTagEntity[] newArray(int i) {
            return new VexFwkImageTagEntity[i];
        }
    }

    public VexFwkImageTagEntity(@NotNull VexFwkImageTagEntityProp prop, @NotNull List<VexFwkImageTagEntityProp> hierarchy) {
        Intrinsics.checkNotNullParameter(prop, "prop");
        Intrinsics.checkNotNullParameter(hierarchy, "hierarchy");
        this.prop = prop;
        this.hierarchy = hierarchy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VexFwkImageTagEntity copy$default(VexFwkImageTagEntity vexFwkImageTagEntity, VexFwkImageTagEntityProp vexFwkImageTagEntityProp, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            vexFwkImageTagEntityProp = vexFwkImageTagEntity.prop;
        }
        if ((i & 2) != 0) {
            list = vexFwkImageTagEntity.hierarchy;
        }
        return vexFwkImageTagEntity.copy(vexFwkImageTagEntityProp, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final VexFwkImageTagEntityProp getProp() {
        return this.prop;
    }

    @NotNull
    public final List<VexFwkImageTagEntityProp> component2() {
        return this.hierarchy;
    }

    @NotNull
    public final VexFwkImageTagEntity copy(@NotNull VexFwkImageTagEntityProp prop, @NotNull List<VexFwkImageTagEntityProp> hierarchy) {
        Intrinsics.checkNotNullParameter(prop, "prop");
        Intrinsics.checkNotNullParameter(hierarchy, "hierarchy");
        return new VexFwkImageTagEntity(prop, hierarchy);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VexFwkImageTagEntity)) {
            return false;
        }
        VexFwkImageTagEntity vexFwkImageTagEntity = (VexFwkImageTagEntity) other;
        return Intrinsics.areEqual(this.prop, vexFwkImageTagEntity.prop) && Intrinsics.areEqual(this.hierarchy, vexFwkImageTagEntity.hierarchy);
    }

    @NotNull
    public final List<VexFwkImageTagEntityProp> getHierarchy() {
        return this.hierarchy;
    }

    @NotNull
    public final VexFwkImageTagEntityProp getProp() {
        return this.prop;
    }

    public int hashCode() {
        return this.hierarchy.hashCode() + (this.prop.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "VexFwkImageTagEntity(prop=" + this.prop + ", hierarchy=" + this.hierarchy + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.prop.writeToParcel(parcel, flags);
        List<VexFwkImageTagEntityProp> list = this.hierarchy;
        parcel.writeInt(list.size());
        Iterator<VexFwkImageTagEntityProp> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }
}
