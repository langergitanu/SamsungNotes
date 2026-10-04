package androidx.appsearch.app;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.appsearch.app.aidl.AppSearchBatchResultParcelV2;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.core.util.Preconditions;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
@SafeParcelable.Class(creator = "OpenBlobForReadResponseCreator")
public final class OpenBlobForReadResponse extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<OpenBlobForReadResponse> CREATOR = new StubCreators.OpenBlobForReadResponseCreator();

    @AbstractSafeParcelable.Field(m1109id = 1)
    final AppSearchBatchResultParcelV2<AppSearchBlobHandle, ParcelFileDescriptor> mResultParcel;

    public OpenBlobForReadResponse(AppSearchBatchResult<AppSearchBlobHandle, ParcelFileDescriptor> appSearchBatchResult) {
        this(AppSearchBatchResultParcelV2.fromBlobHandleToPfd(appSearchBatchResult));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Iterator<ParcelFileDescriptor> it = this.mResultParcel.getResult().getSuccesses().values().iterator();
        while (it.hasNext()) {
            try {
                it.next().close();
            } catch (IOException unused) {
            }
        }
    }

    public AppSearchBatchResult<AppSearchBlobHandle, ParcelFileDescriptor> getResult() {
        return this.mResultParcel.getResult();
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    @AbstractSafeParcelable.Constructor
    public OpenBlobForReadResponse(@AbstractSafeParcelable.Param(m1110id = 1) AppSearchBatchResultParcelV2<AppSearchBlobHandle, ParcelFileDescriptor> appSearchBatchResultParcelV2) {
        this.mResultParcel = (AppSearchBatchResultParcelV2) Preconditions.checkNotNull(appSearchBatchResultParcelV2);
    }
}
