package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\bHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, m13886d2 = {"Landroidx/work/multiprocess/parcelable/ParcelableInterruptRequest;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "stopReason", "", "(Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getStopReason", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "work-multiprocess_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final /* data */ class ParcelableInterruptRequest implements Parcelable {

    @NotNull
    private final String id;
    private final int stopReason;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ParcelableInterruptRequest> CREATOR = new Parcelable.Creator<ParcelableInterruptRequest>() { // from class: androidx.work.multiprocess.parcelable.ParcelableInterruptRequest$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ParcelableInterruptRequest createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ParcelableInterruptRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ParcelableInterruptRequest[] newArray(int size) {
            return new ParcelableInterruptRequest[size];
        }
    };

    public ParcelableInterruptRequest(@NotNull String id, int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.stopReason = i;
    }

    public static /* synthetic */ ParcelableInterruptRequest copy$default(ParcelableInterruptRequest parcelableInterruptRequest, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = parcelableInterruptRequest.id;
        }
        if ((i2 & 2) != 0) {
            i = parcelableInterruptRequest.stopReason;
        }
        return parcelableInterruptRequest.copy(str, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStopReason() {
        return this.stopReason;
    }

    @NotNull
    public final ParcelableInterruptRequest copy(@NotNull String id, int stopReason) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new ParcelableInterruptRequest(id, stopReason);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParcelableInterruptRequest)) {
            return false;
        }
        ParcelableInterruptRequest parcelableInterruptRequest = (ParcelableInterruptRequest) other;
        return Intrinsics.areEqual(this.id, parcelableInterruptRequest.id) && this.stopReason == parcelableInterruptRequest.stopReason;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getStopReason() {
        return this.stopReason;
    }

    public int hashCode() {
        return Integer.hashCode(this.stopReason) + (this.id.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("ParcelableInterruptRequest(id=");
        sb.append(this.id);
        sb.append(", stopReason=");
        return AbstractC0000a.m13j(sb, this.stopReason, PropertyUtils.MAPPED_DELIM2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeInt(this.stopReason);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ParcelableInterruptRequest(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        Intrinsics.checkNotNull(string);
        this(string, parcel.readInt());
    }
}
