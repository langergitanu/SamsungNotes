package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@KeepForSdk
public abstract class DataHolderResult implements Result, Releasable {

    @NonNull
    @KeepForSdk
    protected final DataHolder mDataHolder;

    @NonNull
    @KeepForSdk
    protected final Status mStatus;

    @KeepForSdk
    public DataHolderResult(@NonNull DataHolder dataHolder, @NonNull Status status) {
        this.mStatus = status;
        this.mDataHolder = dataHolder;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    @KeepForSdk
    public Status getStatus() {
        return this.mStatus;
    }

    @Override // com.google.android.gms.common.api.Releasable
    @KeepForSdk
    public void release() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @KeepForSdk
    public DataHolderResult(@NonNull DataHolder dataHolder) {
        this(dataHolder, new Status(dataHolder.getStatusCode()));
    }
}
