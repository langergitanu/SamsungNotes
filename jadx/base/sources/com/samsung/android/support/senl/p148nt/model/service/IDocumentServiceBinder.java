package com.samsung.android.support.senl.p148nt.model.service;

import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface IDocumentServiceBinder extends IBinder {
    IDocumentServiceWrapper subscribe(@NonNull String str, @Nullable DocumentSubscriptionId documentSubscriptionId);

    IDocumentServiceWrapper subscribe(@NonNull String str, @Nullable DocumentSubscriptionId documentSubscriptionId, boolean z);
}
