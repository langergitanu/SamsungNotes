package com.samsung.android.support.senl.p148nt.model.helper;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.helper.BaseDocumentHelper;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper;
import com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J \u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\r\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¨\u0006\u000e"}, m13886d2 = {"com/samsung/android/support/senl/nt/model/helper/BaseDocumentHelper$execute$documentListener$1", "Lcom/samsung/android/support/senl/nt/model/service/callback/NotesDocumentCompletionListener;", "Lcom/samsung/android/support/senl/nt/model/documents/data/ISpenDocument;", "completed", "", ExternalDataConstants.DOCUMENT_TABLE_NAME, "Lcom/samsung/android/support/senl/nt/model/repository/data/NotesDocument;", "uuid", "", "saveDocument", TelemetryEventStrings.Value.FAILED, "exc", "", "close", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BaseDocumentHelper$execute$documentListener$1 extends NotesDocumentCompletionListener<ISpenDocument> {
    final /* synthetic */ BaseDocumentHelper this$0;

    public BaseDocumentHelper$execute$documentListener$1(BaseDocumentHelper baseDocumentHelper) {
        this.this$0 = baseDocumentHelper;
    }

    public final void close(NotesDocument<ISpenDocument> document) {
        Intrinsics.checkNotNullParameter(document, "document");
        IDocumentServiceWrapper iDocumentServiceWrapper = this.this$0.service;
        Intrinsics.checkNotNull(iDocumentServiceWrapper);
        iDocumentServiceWrapper.close(document, null);
        this.this$0.disconnect();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
    public void completed(NotesDocument<ISpenDocument> document, String uuid) {
        Intrinsics.checkNotNullParameter(document, "document");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        AbstractC0000a.m2C("open$completed, uuid : ", uuid, this.this$0.getTag());
        BaseDocumentHelper.Listener listener = this.this$0.listener;
        if (listener != null) {
            listener.onOpen(document, uuid);
        }
        saveDocument(document);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
    public void failed(Throwable exc, String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        DataLogger.m12307i(this.this$0.getTag(), "open$failed, uuid : " + uuid + ", exc : " + exc);
        BaseDocumentHelper.Listener listener = this.this$0.listener;
        if (listener != null) {
            listener.onFailed(uuid);
        }
    }

    public final void saveDocument(final NotesDocument<ISpenDocument> document) {
        Intrinsics.checkNotNullParameter(document, "document");
        IDocumentServiceWrapper iDocumentServiceWrapper = this.this$0.service;
        Intrinsics.checkNotNull(iDocumentServiceWrapper);
        final BaseDocumentHelper baseDocumentHelper = this.this$0;
        iDocumentServiceWrapper.save(document, false, false, new NotesDocumentCompletionListener<ISpenDocument>() { // from class: com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper$execute$documentListener$1$saveDocument$1
            @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
            public void completed(NotesDocument<ISpenDocument> document2, String uuid) {
                Intrinsics.checkNotNullParameter(document2, "document");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                AbstractC0000a.m2C("save$completed, uuid : ", uuid, baseDocumentHelper.getTag());
                BaseDocumentHelper.Listener listener = baseDocumentHelper.listener;
                if (listener != null) {
                    listener.onSave(document2, uuid);
                }
                this.close(document2);
            }

            @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
            public void failed(Throwable exc, String uuid) {
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                DataLogger.m12307i(baseDocumentHelper.getTag(), "save$failed, uuid : " + uuid + ", exc : " + exc);
                BaseDocumentHelper.Listener listener = baseDocumentHelper.listener;
                if (listener != null) {
                    listener.onFailed(uuid);
                }
                this.close(document);
            }
        });
    }
}
