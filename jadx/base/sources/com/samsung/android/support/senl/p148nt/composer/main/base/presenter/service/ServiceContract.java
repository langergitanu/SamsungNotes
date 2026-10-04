package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ServiceContract<T extends ISpenDocument> {
    void clearChangingInfo();

    OpenParam getOpenParam(boolean z);

    String getUuid();

    boolean isAttachedToActivity();

    boolean isInProgressNoteChange();

    boolean needToConflictSyncForComposerEdit(String str);

    boolean needToPendingSyncForComposerBusy(String str);

    void onChangedDoc(NotesDocument<T> notesDocument);

    void onChangedWorkingState(@NonNull String str, SchedulerDataSource.WorkingState workingState, DocumentSubscriptionId documentSubscriptionId);

    void onLoadDocCompleted(NotesDocument<T> notesDocument);

    void onLoadDocFailed(Throwable th, boolean z);

    void onReadyReload(Runnable runnable);

    void onReceiveBroadcastMessage(@NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull Intent intent);

    void onReloadedDocument(NotesDocument<T> notesDocument);

    void onServiceConnected();

    void setChangingUuid(String str);

    void showDebugMessageToast(String str);
}
