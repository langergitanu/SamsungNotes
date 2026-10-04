package com.samsung.android.support.senl.document.contract;

import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface DocumentSaveParamBuilder {
    DocumentSaveParamBuilder setCategoryUuid(String str);

    DocumentSaveParamBuilder setCloseDocAfterSave(boolean z);

    DocumentSaveParamBuilder setCreatedAtTime(Long l);

    DocumentSaveParamBuilder setDocFilePath(String str);

    DocumentSaveParamBuilder setFavorite(Boolean bool);

    DocumentSaveParamBuilder setLastModifiedAtTime(Long l);

    DocumentSaveParamBuilder setLockType(Integer num);

    DocumentSaveParamBuilder setNew(boolean z);

    DocumentSaveParamBuilder setSPenSDoc(SpenSDoc spenSDoc);

    DocumentSaveParamBuilder setSaveDoc(boolean z);

    DocumentSaveParamBuilder setUpdateStrokeInWorkerThread(boolean z);

    DocumentSaveParamBuilder setUuid(String str);
}
