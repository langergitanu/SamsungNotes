package com.samsung.android.support.senl.p148nt.model.document.save;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.resolver.operation.constants.DocumentType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class NotesDocumentOperationProcessor {
    public static SaveOperation<NotesDocumentEntity, Object> createSaveOperation(@NonNull Context context, @NonNull DocumentType documentType) {
        return documentType == DocumentType.SDOC ? new SDocSaveOperation(context) : new WDocSaveOperation(context);
    }
}
