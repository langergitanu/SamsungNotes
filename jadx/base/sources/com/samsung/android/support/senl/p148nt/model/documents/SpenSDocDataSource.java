package com.samsung.android.support.senl.p148nt.model.documents;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface SpenSDocDataSource {
    @NonNull
    DocumentDataSource getDocument();

    @NonNull
    String getPath();

    @NonNull
    ISpenDocument getSpenSDoc();

    @NonNull
    String getUuid();

    boolean isUsed(@NonNull DocumentSubscriptionId documentSubscriptionId);
}
