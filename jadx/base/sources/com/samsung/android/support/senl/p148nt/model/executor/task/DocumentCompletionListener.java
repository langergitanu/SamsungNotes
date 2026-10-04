package com.samsung.android.support.senl.p148nt.model.executor.task;

import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface DocumentCompletionListener<T extends ISpenDocument> {
    void completed(DocumentDataSource<T, ? extends DocumentEntityContainer> documentDataSource, String str);

    void failed(Throwable th, String str);
}
