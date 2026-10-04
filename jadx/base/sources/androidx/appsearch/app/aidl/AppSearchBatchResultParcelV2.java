package androidx.appsearch.app.aidl;

import android.os.ParcelFileDescriptor;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.AppSearchBatchResult;
import androidx.appsearch.app.AppSearchBlobHandle;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAppSearchApi
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AppSearchBatchResultParcelV2<KeyType, ValueType> {
    private final AppSearchBatchResult<KeyType, ValueType> mResult;

    private AppSearchBatchResultParcelV2(AppSearchBatchResult<KeyType, ValueType> appSearchBatchResult) {
        this.mResult = (AppSearchBatchResult) Preconditions.checkNotNull(appSearchBatchResult);
    }

    public static AppSearchBatchResultParcelV2<AppSearchBlobHandle, ParcelFileDescriptor> fromBlobHandleToPfd(AppSearchBatchResult<AppSearchBlobHandle, ParcelFileDescriptor> appSearchBatchResult) {
        return new AppSearchBatchResultParcelV2<>(appSearchBatchResult);
    }

    public static AppSearchBatchResultParcelV2<AppSearchBlobHandle, Void> fromBlobHandleToVoid(AppSearchBatchResult<AppSearchBlobHandle, Void> appSearchBatchResult) {
        return new AppSearchBatchResultParcelV2<>(appSearchBatchResult);
    }

    public AppSearchBatchResult<KeyType, ValueType> getResult() {
        return this.mResult;
    }
}
