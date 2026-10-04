package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.aidl.AppSearchBatchResultParcelV2;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
@SafeParcelable.Class(creator = "CommitBlobResponseCreator")
public final class CommitBlobResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CommitBlobResponse> CREATOR = new StubCreators.CommitBlobResponseCreator();

    @AbstractSafeParcelable.Field(getter = "getResponseParcel", m1109id = 1)
    private final AppSearchBatchResultParcelV2<AppSearchBlobHandle, Void> mResultParcel;

    public CommitBlobResponse(AppSearchBatchResult<AppSearchBlobHandle, Void> appSearchBatchResult) {
        this(AppSearchBatchResultParcelV2.fromBlobHandleToVoid(appSearchBatchResult));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public AppSearchBatchResultParcelV2<AppSearchBlobHandle, Void> getResponseParcel() {
        return this.mResultParcel;
    }

    public AppSearchBatchResult<AppSearchBlobHandle, Void> getResult() {
        return this.mResultParcel.getResult();
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    @AbstractSafeParcelable.Constructor
    public CommitBlobResponse(@AbstractSafeParcelable.Param(m1110id = 1) AppSearchBatchResultParcelV2<AppSearchBlobHandle, Void> appSearchBatchResultParcelV2) {
        this.mResultParcel = (AppSearchBatchResultParcelV2) Preconditions.checkNotNull(appSearchBatchResultParcelV2);
    }
}
