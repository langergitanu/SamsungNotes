package com.samsung.android.support.senl.p148nt.data.database.core.sync.entity;

import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NoteSyncEntry extends NotesDocumentEntity {
    private long clientModifiedTime;
    private String serverId;

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity, com.samsung.android.support.senl.p148nt.data.database.core.document.entity.AbsNotesDocumentEntity
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NoteSyncEntry) || !super.equals(obj)) {
            return false;
        }
        NoteSyncEntry noteSyncEntry = (NoteSyncEntry) obj;
        return getClientModifiedTime() == noteSyncEntry.getClientModifiedTime() && Objects.equals(getServerId(), noteSyncEntry.getServerId());
    }

    public long getClientModifiedTime() {
        return this.clientModifiedTime;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.entity.AbsNotesDocumentEntity
    public String getServerId() {
        return this.serverId;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity, com.samsung.android.support.senl.p148nt.data.database.core.document.entity.AbsNotesDocumentEntity
    public int hashCode() {
        return super.hashCode();
    }

    public void setClientModifiedTime(long j) {
        this.clientModifiedTime = j;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.entity.AbsNotesDocumentEntity
    public void setServerId(String str) {
        this.serverId = str;
    }
}
