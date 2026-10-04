package com.samsung.android.app.notes.sync.importing.core;

import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractImportFTUListener implements ImportBaseTask.Listener {
    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onDownloaded(DocTypeConstants docTypeConstants, ImportItem importItem, int i) {
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onImportEnded(DocTypeConstants docTypeConstants, List<ImportItem> list) {
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onImportError(DocTypeConstants docTypeConstants, int i, String str, Exception exc) {
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onImportStart(DocTypeConstants docTypeConstants) {
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onItemImportFinished(DocTypeConstants docTypeConstants, int i, int i2, int i4) {
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onUpdated(DocTypeConstants docTypeConstants, int i, int i2, ImportItem importItem) {
    }
}
