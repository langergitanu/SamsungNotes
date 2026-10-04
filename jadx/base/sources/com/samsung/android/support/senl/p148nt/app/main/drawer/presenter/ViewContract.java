package com.samsung.android.support.senl.p148nt.app.main.drawer.presenter;

import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface ViewContract {
    void initFolderDataMap();

    boolean isFreeFormWindow();

    boolean isNoteListScrolling();

    boolean isRunningAnimator();

    void onFolderSelected(String str, int i);

    void updateDocumentCountMap(Map<String, NotesDocumentCountEntry> map);

    void updateDrawerBar();

    void updateNewBadge();

    void updateNoteViewByDrawerObserver(boolean z);

    void verifyForDelete();
}
