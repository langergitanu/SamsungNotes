package androidx.appsearch.app;

import androidx.annotation.RestrictTo;
import androidx.appsearch.safeparcel.PackageIdentifierParcel;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class PackageIdentifier {
    private final PackageIdentifierParcel mPackageIdentifierParcel;

    public PackageIdentifier(String str, byte[] bArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(bArr);
        this.mPackageIdentifierParcel = new PackageIdentifierParcel(str, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PackageIdentifier) {
            return this.mPackageIdentifierParcel.equals(((PackageIdentifier) obj).getPackageIdentifierParcel());
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PackageIdentifierParcel getPackageIdentifierParcel() {
        return this.mPackageIdentifierParcel;
    }

    public String getPackageName() {
        return this.mPackageIdentifierParcel.getPackageName();
    }

    public byte[] getSha256Certificate() {
        return this.mPackageIdentifierParcel.getSha256Certificate();
    }

    public int hashCode() {
        return this.mPackageIdentifierParcel.hashCode();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PackageIdentifier(PackageIdentifierParcel packageIdentifierParcel) {
        this.mPackageIdentifierParcel = (PackageIdentifierParcel) Preconditions.checkNotNull(packageIdentifierParcel);
    }
}
