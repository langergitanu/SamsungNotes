package com.samsung.android.support.senl.p148nt.model.utils;

import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class NotesDocumentSyncUtils {
    public static NotesDocumentEntity setDocumentEntitySyncSkipped(NotesDocumentEntity notesDocumentEntity) {
        if (notesDocumentEntity.getServerTimestamp().longValue() > 1464416139847L) {
            notesDocumentEntity.setKeepServerTimestamp(true);
        }
        notesDocumentEntity.setDirtySkipped(true);
        return notesDocumentEntity;
    }
}
