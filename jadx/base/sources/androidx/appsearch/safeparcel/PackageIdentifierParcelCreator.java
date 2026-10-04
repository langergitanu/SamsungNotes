package androidx.appsearch.safeparcel;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class PackageIdentifierParcelCreator implements Parcelable.Creator<PackageIdentifierParcel> {
    private static final String PACKAGE_NAME_FIELD = "packageName";
    private static final String SHA256_CERTIFICATE_FIELD = "sha256Certificate";

    private static Bundle createBundleFromPackageIdentifier(PackageIdentifierParcel packageIdentifierParcel) {
        Objects.requireNonNull(packageIdentifierParcel);
        Bundle bundle = new Bundle();
        bundle.putString("packageName", packageIdentifierParcel.getPackageName());
        bundle.putByteArray(SHA256_CERTIFICATE_FIELD, packageIdentifierParcel.getSha256Certificate());
        return bundle;
    }

    private static PackageIdentifierParcel createPackageIdentifierFromBundle(Bundle bundle) {
        Objects.requireNonNull(bundle);
        return new PackageIdentifierParcel((String) Preconditions.checkNotNull(bundle.getString("packageName")), (byte[]) Preconditions.checkNotNull(bundle.getByteArray(SHA256_CERTIFICATE_FIELD)));
    }

    public static void writeToParcel(PackageIdentifierParcel packageIdentifierParcel, Parcel parcel, int i) {
        parcel.writeBundle(createBundleFromPackageIdentifier(packageIdentifierParcel));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PackageIdentifierParcel createFromParcel(Parcel parcel) {
        return createPackageIdentifierFromBundle((Bundle) Preconditions.checkNotNull(parcel.readBundle(getClass().getClassLoader())));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PackageIdentifierParcel[] newArray(int i) {
        return new PackageIdentifierParcel[i];
    }
}
