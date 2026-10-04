package com.samsung.android.support.senl.p148nt.composer.main.base.model.data;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.common.ExecuteCallback;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface DocContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SavedListener {
        void onSuccess();
    }

    void addSavedListener(SavedListener savedListener);

    void cancelSaveToDevice();

    void changeDocument(String str, String str2);

    boolean isSavingState();

    void requestDiscard();

    void requestSave(@NonNull NotesDocument<SpenWordDocument> notesDocument, boolean z, boolean z2);

    void requestSaveCache(@NonNull NotesDocument<SpenWordDocument> notesDocument, boolean z, boolean z2);

    void requestSaveToDevice(ExecuteCallback executeCallback, String str);

    void requestSnapSave(@NonNull NotesDocument<SpenWordDocument> notesDocument, boolean z, boolean z2);

    void setRunnableAfterCompletedSave(Runnable runnable);
}
