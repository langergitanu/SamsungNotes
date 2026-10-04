package com.samsung.android.app.notes.sync.migration.importer.task;

import android.content.Context;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.types.SSLMemoSync;
import com.samsung.android.app.notes.sync.items.ImportItem;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ConvertLMemoTask extends SSLMemoSync {
    public ConvertLMemoTask(Context context, ImportBaseTask.Listener listener, int i, List<ImportItem> list, boolean z) {
        super(context, listener, i, list, z);
    }
}
