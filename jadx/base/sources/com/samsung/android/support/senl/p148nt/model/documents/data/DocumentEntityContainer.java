package com.samsung.android.support.senl.p148nt.model.documents.data;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class DocumentEntityContainer implements Parcelable {
    public static final String TAG = ModelLogger.createTag("DocumentEntityContainer");
    private NotesDocumentEntity mEntity;
    private NotesDocumentEntity mOriginalEntity;
    private NotesDocumentEntity mRollbackEntity;

    public DocumentEntityContainer(@NonNull NotesDocumentEntity notesDocumentEntity, @NonNull NotesDocumentEntity notesDocumentEntity2) {
        setOriginalEntity(notesDocumentEntity);
        setEntity(notesDocumentEntity2);
    }

    private void setRollbackEntity(NotesDocumentEntity notesDocumentEntity) {
        this.mRollbackEntity = notesDocumentEntity;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NotesDocumentEntity getEntity() {
        return this.mEntity;
    }

    @NonNull
    public NotesDocumentEntity getOriginalEntity() {
        return this.mOriginalEntity;
    }

    public NotesDocumentEntity getRollbackEntity() {
        return this.mRollbackEntity;
    }

    public boolean isChanged() {
        return !Objects.equals(getOriginalEntity(), getEntity());
    }

    public void setEntity(NotesDocumentEntity notesDocumentEntity) {
        this.mEntity = notesDocumentEntity;
    }

    public void setOriginalEntity(NotesDocumentEntity notesDocumentEntity) {
        setRollbackEntity(this.mOriginalEntity);
        this.mOriginalEntity = notesDocumentEntity;
    }

    public abstract void updateOriginalEntityWithLatest();
}
