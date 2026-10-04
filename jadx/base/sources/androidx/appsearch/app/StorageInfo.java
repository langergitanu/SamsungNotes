package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "StorageInfoCreator")
public final class StorageInfo extends AbstractSafeParcelable {

    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<StorageInfo> CREATOR = new StubCreators.StorageInfoCreator();

    @AbstractSafeParcelable.Field(getter = "getAliveDocumentsCount", m1109id = 2)
    private int mAliveDocumentsCount;

    @AbstractSafeParcelable.Field(getter = "getAliveNamespacesCount", m1109id = 3)
    private int mAliveNamespacesCount;

    @AbstractSafeParcelable.Field(getter = "getBlobCount", m1109id = 5)
    private int mBlobCount;

    @AbstractSafeParcelable.Field(getter = "getBlobSizeBytes", m1109id = 4)
    private long mBlobSizeBytes;

    @AbstractSafeParcelable.Field(getter = "getSizeBytes", m1109id = 1)
    private long mSizeBytes;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private int mAliveDocumentsCount;
        private int mAliveNamespacesCount;
        private int mBlobCount;
        private long mBlobSizeBytes;
        private long mSizeBytes;

        public StorageInfo build() {
            return new StorageInfo(this.mSizeBytes, this.mAliveDocumentsCount, this.mAliveNamespacesCount, this.mBlobSizeBytes, this.mBlobCount);
        }

        @CanIgnoreReturnValue
        public Builder setAliveDocumentsCount(int i) {
            this.mAliveDocumentsCount = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setAliveNamespacesCount(int i) {
            this.mAliveNamespacesCount = i;
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
        public Builder setBlobCount(int i) {
            this.mBlobCount = i;
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
        public Builder setBlobSizeBytes(long j) {
            this.mBlobSizeBytes = j;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSizeBytes(long j) {
            this.mSizeBytes = j;
            return this;
        }
    }

    @AbstractSafeParcelable.Constructor
    public StorageInfo(@AbstractSafeParcelable.Param(m1110id = 1) long j, @AbstractSafeParcelable.Param(m1110id = 2) int i, @AbstractSafeParcelable.Param(m1110id = 3) int i2, @AbstractSafeParcelable.Param(m1110id = 4) long j2, @AbstractSafeParcelable.Param(m1110id = 5) int i4) {
        this.mSizeBytes = j;
        this.mAliveDocumentsCount = i;
        this.mAliveNamespacesCount = i2;
        this.mBlobSizeBytes = j2;
        this.mBlobCount = i4;
    }

    public int getAliveDocumentsCount() {
        return this.mAliveDocumentsCount;
    }

    public int getAliveNamespacesCount() {
        return this.mAliveNamespacesCount;
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    public int getBlobCount() {
        return this.mBlobCount;
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    public long getBlobSizeBytes() {
        return this.mBlobSizeBytes;
    }

    public long getSizeBytes() {
        return this.mSizeBytes;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }
}
