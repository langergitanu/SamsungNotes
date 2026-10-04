package com.google.android.meet.addons;

import androidx.annotation.NonNull;
import com.google.android.meet.addons.annotations.PublicApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@PublicApi
public interface CoDoingClient {
    public static final int MAX_CODOING_BLOB_BYTES = 16384;
    public static final int PREFERRED_MAX_CODOING_BLOB_BYTES = 1024;

    void setGlobalState(@NonNull CoDoingState coDoingState);
}
