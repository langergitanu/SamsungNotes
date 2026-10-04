package com.samsung.android.app.notes.reflect;

import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DocumentSaveParamBuilderImpl implements DocumentSaveParamBuilder {
    private static final String TAG = "DocumentSaveParamBuilderImpl";
    private boolean mIsNew;
    private final NotesDocumentEntity mNotesDocumentEntity = new NotesDocumentEntity();
    private SpenSDoc mSpenSDoc;
    private SpenWNote mSpenWNote;

    public NotesDocumentEntity build() {
        return this.mNotesDocumentEntity;
    }

    public SpenSDoc getSpenSDoc() {
        return this.mSpenSDoc;
    }

    public SpenWNote getSpenWNote() {
        return this.mSpenWNote;
    }

    public boolean isNew() {
        return this.mIsNew;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder
    public DocumentSaveParamBuilder setCategoryUuid(String str) {
        this.mNotesDocumentEntity.setCategoryUuid(str);
        return this;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder
    public DocumentSaveParamBuilder setCloseDocAfterSave(boolean z) {
        return this;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder
    public DocumentSaveParamBuilder setCreatedAtTime(Long l) {
        this.mNotesDocumentEntity.getTimeSaveParam().setCreatedTime(l);
        return this;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder
    public DocumentSaveParamBuilder setDocFilePath(String str) {
        this.mNotesDocumentEntity.setFilePath(str);
        return this;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder
    public DocumentSaveParamBuilder setFavorite(Boolean bool) {
        this.mNotesDocumentEntity.setIsFavorite(bool.booleanValue() ? 1 : 0);
        return this;
    }

    public DocumentSaveParamBuilder setImported() {
        this.mNotesDocumentEntity.setImported(true);
        this.mNotesDocumentEntity.setImportedAt(System.currentTimeMillis());
        return this;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder
    public DocumentSaveParamBuilder setLastModifiedAtTime(Long l) {
        this.mNotesDocumentEntity.getTimeSaveParam().setLastModifiedTime(l);
        return this;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder
    public DocumentSaveParamBuilder setLockType(Integer num) {
        this.mNotesDocumentEntity.setIsLock(num.intValue());
        return this;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder
    public DocumentSaveParamBuilder setNew(boolean z) {
        this.mIsNew = z;
        return this;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder
    public DocumentSaveParamBuilder setSPenSDoc(SpenSDoc spenSDoc) {
        Logger.m8697d(TAG, "setSPenSDoc, spenSDoc : " + spenSDoc);
        this.mSpenSDoc = spenSDoc;
        return this;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder
    public DocumentSaveParamBuilder setSaveDoc(boolean z) {
        return this;
    }

    public DocumentSaveParamBuilder setSpenWNote(SpenWNote spenWNote) {
        Logger.m8697d(TAG, "setSpenWNote, spenWNote : " + spenWNote);
        this.mSpenWNote = spenWNote;
        return this;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder
    public DocumentSaveParamBuilder setUpdateStrokeInWorkerThread(boolean z) {
        return this;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder
    public DocumentSaveParamBuilder setUuid(String str) {
        this.mNotesDocumentEntity.setUuid(str);
        return this;
    }
}
