package com.samsung.android.support.senl.p148nt.model.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentServiceWrapperFactory {
    private static final String TAG = ModelLogger.createTag("DocumentServiceWrapperFactory");

    public IDocumentServiceWrapper create(@NonNull IDocumentService iDocumentService, @NonNull String str, @Nullable DocumentSubscriptionId documentSubscriptionId, @Nullable IDocumentServiceWrapper.DocumentSubscriptionListener documentSubscriptionListener) {
        DataLogger.m12307i(TAG, "create, service : " + iDocumentService + ", userName : " + str + ", restoredId : " + documentSubscriptionId + ", listener : " + documentSubscriptionListener);
        return new DocumentServiceWrapper(iDocumentService, DocumentSubscriptionId.create(str, documentSubscriptionId), documentSubscriptionListener);
    }
}
