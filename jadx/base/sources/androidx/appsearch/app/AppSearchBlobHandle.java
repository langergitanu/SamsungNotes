package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.appsearch.util.IndentingStringBuilder;
import androidx.core.util.Preconditions;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
@SafeParcelable.Class(creator = "AppSearchBlobHandleCreator")
public final class AppSearchBlobHandle extends AbstractSafeParcelable {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<AppSearchBlobHandle> CREATOR = new StubCreators.AppSearchBlobHandleCreator();
    private static final int SHA_256_DIGEST_BYTE_LENGTH = 32;

    @AbstractSafeParcelable.Field(getter = "getDatabaseName", m1109id = 3)
    private final String mDatabaseName;
    private Integer mHashCode;

    @AbstractSafeParcelable.Field(getter = "getNamespace", m1109id = 4)
    private final String mNamespace;

    @AbstractSafeParcelable.Field(getter = "getPackageName", m1109id = 2)
    private final String mPackageName;

    @AbstractSafeParcelable.Field(getter = "getSha256Digest", m1109id = 1)
    private final byte[] mSha256Digest;

    @AbstractSafeParcelable.Constructor
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public AppSearchBlobHandle(@AbstractSafeParcelable.Param(m1110id = 1) byte[] bArr, @AbstractSafeParcelable.Param(m1110id = 2) String str, @AbstractSafeParcelable.Param(m1110id = 3) String str2, @AbstractSafeParcelable.Param(m1110id = 4) String str3) {
        this.mSha256Digest = (byte[]) Preconditions.checkNotNull(bArr);
        Preconditions.checkState(bArr.length == 32, "The input digest isn't a sha-256 digest.");
        this.mPackageName = (String) Preconditions.checkNotNull(str);
        this.mDatabaseName = (String) Preconditions.checkNotNull(str2);
        this.mNamespace = (String) Preconditions.checkNotNull(str3);
    }

    public static AppSearchBlobHandle createWithSha256(byte[] bArr, String str, String str2, String str3) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkArgument(bArr.length == 32, "The digest is not a SHA-256 digest");
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(str3);
        return new AppSearchBlobHandle(bArr, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSearchBlobHandle)) {
            return false;
        }
        AppSearchBlobHandle appSearchBlobHandle = (AppSearchBlobHandle) obj;
        return Arrays.equals(this.mSha256Digest, appSearchBlobHandle.mSha256Digest) && this.mPackageName.equals(appSearchBlobHandle.mPackageName) && this.mDatabaseName.equals(appSearchBlobHandle.mDatabaseName) && this.mNamespace.equals(appSearchBlobHandle.mNamespace);
    }

    public String getDatabaseName() {
        return this.mDatabaseName;
    }

    public String getNamespace() {
        return this.mNamespace;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public byte[] getSha256Digest() {
        return this.mSha256Digest;
    }

    public int hashCode() {
        if (this.mHashCode == null) {
            this.mHashCode = Integer.valueOf(Objects.hash(Integer.valueOf(Arrays.hashCode(this.mSha256Digest)), this.mPackageName, this.mDatabaseName, this.mNamespace));
        }
        return this.mHashCode.intValue();
    }

    public String toString() {
        IndentingStringBuilder indentingStringBuilder = new IndentingStringBuilder();
        indentingStringBuilder.append("{\n");
        indentingStringBuilder.increaseIndentLevel();
        indentingStringBuilder.append("packageName: \"").append(this.mPackageName).append("\",\n");
        indentingStringBuilder.append("databaseName: \"").append(this.mDatabaseName).append("\",\n");
        indentingStringBuilder.append("namespace: \"").append(this.mNamespace).append("\",\n");
        indentingStringBuilder.append("digest: \"");
        for (byte b : this.mSha256Digest) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                indentingStringBuilder.append((Object) '0');
            }
            indentingStringBuilder.append(hexString);
        }
        indentingStringBuilder.append("\",\n").decreaseIndentLevel();
        indentingStringBuilder.append("}");
        return indentingStringBuilder.toString();
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }
}
