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
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "ReportUsageRequestCreator")
public final class ReportUsageRequest extends AbstractSafeParcelable {

    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<ReportUsageRequest> CREATOR = new StubCreators.ReportUsageRequestCreator();

    @AbstractSafeParcelable.Field(getter = "getDocumentId", m1109id = 2)
    private final String mDocumentId;

    @AbstractSafeParcelable.Field(getter = "getNamespace", m1109id = 1)
    private final String mNamespace;

    @AbstractSafeParcelable.Field(getter = "getUsageTimestampMillis", m1109id = 3)
    private final long mUsageTimestampMillis;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private final String mDocumentId;
        private final String mNamespace;
        private Long mUsageTimestampMillis;

        public Builder(String str, String str2) {
            this.mNamespace = (String) Preconditions.checkNotNull(str);
            this.mDocumentId = (String) Preconditions.checkNotNull(str2);
        }

        public ReportUsageRequest build() {
            if (this.mUsageTimestampMillis == null) {
                this.mUsageTimestampMillis = Long.valueOf(System.currentTimeMillis());
            }
            return new ReportUsageRequest(this.mNamespace, this.mDocumentId, this.mUsageTimestampMillis.longValue());
        }

        @CanIgnoreReturnValue
        public Builder setUsageTimestampMillis(long j) {
            this.mUsageTimestampMillis = Long.valueOf(j);
            return this;
        }
    }

    @AbstractSafeParcelable.Constructor
    public ReportUsageRequest(@AbstractSafeParcelable.Param(m1110id = 1) String str, @AbstractSafeParcelable.Param(m1110id = 2) String str2, @AbstractSafeParcelable.Param(m1110id = 3) long j) {
        Objects.requireNonNull(str);
        this.mNamespace = str;
        Objects.requireNonNull(str2);
        this.mDocumentId = str2;
        this.mUsageTimestampMillis = j;
    }

    public String getDocumentId() {
        return this.mDocumentId;
    }

    public String getNamespace() {
        return this.mNamespace;
    }

    public long getUsageTimestampMillis() {
        return this.mUsageTimestampMillis;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }
}
