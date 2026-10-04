package androidx.appsearch.safeparcel;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.core.util.Preconditions;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
@SafeParcelable.Class(creator = "PackageIdentifierParcelCreator")
public final class PackageIdentifierParcel extends AbstractSafeParcelable implements Parcelable {
    public static final Parcelable.Creator<PackageIdentifierParcel> CREATOR = new PackageIdentifierParcelCreator();

    @AbstractSafeParcelable.Field(getter = "getPackageName", m1109id = 1)
    private final String mPackageName;

    @AbstractSafeParcelable.Field(getter = "getSha256Certificate", m1109id = 2)
    private final byte[] mSha256Certificate;

    @AbstractSafeParcelable.Constructor
    public PackageIdentifierParcel(@AbstractSafeParcelable.Param(m1110id = 1) String str, @AbstractSafeParcelable.Param(m1110id = 2) byte[] bArr) {
        this.mPackageName = (String) Preconditions.checkNotNull(str);
        this.mSha256Certificate = (byte[]) Preconditions.checkNotNull(bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PackageIdentifierParcel)) {
            return false;
        }
        PackageIdentifierParcel packageIdentifierParcel = (PackageIdentifierParcel) obj;
        return this.mPackageName.equals(packageIdentifierParcel.mPackageName) && Arrays.equals(this.mSha256Certificate, packageIdentifierParcel.mSha256Certificate);
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public byte[] getSha256Certificate() {
        return this.mSha256Certificate;
    }

    public int hashCode() {
        return Objects.hash(this.mPackageName, Integer.valueOf(Arrays.hashCode(this.mSha256Certificate)));
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    public void writeToParcel(Parcel parcel, int i) {
        PackageIdentifierParcelCreator.writeToParcel(this, parcel, i);
    }
}
