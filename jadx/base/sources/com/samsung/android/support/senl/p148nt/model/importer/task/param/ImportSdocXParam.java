package com.samsung.android.support.senl.p148nt.model.importer.task.param;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ImportSdocXParam extends ImportSDocXBaseParam<ImportSdocXParam> {
    private boolean mClearCanvasCache;
    private boolean mIsCoEditNote;
    private boolean mSkipEmptyNote;

    public boolean clearCanvasCache() {
        return this.mClearCanvasCache;
    }

    public boolean isCoEditNote() {
        return this.mIsCoEditNote;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportBaseParam
    public ImportSdocXParam self() {
        return this;
    }

    public ImportSdocXParam setClearCanvasCache(boolean z) {
        this.mClearCanvasCache = z;
        return this;
    }

    public ImportSdocXParam setIsCoEditNote(boolean z) {
        this.mIsCoEditNote = z;
        return self();
    }

    public ImportSdocXParam setSkipEmptyNote(boolean z) {
        this.mSkipEmptyNote = z;
        return this;
    }

    public boolean skipEmptyNote() {
        return this.mSkipEmptyNote;
    }
}
