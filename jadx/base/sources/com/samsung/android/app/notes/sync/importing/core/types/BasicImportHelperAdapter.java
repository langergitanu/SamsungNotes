package com.samsung.android.app.notes.sync.importing.core.types;

import com.samsung.android.app.notes.sync.importing.core.ImportHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class BasicImportHelperAdapter {
    protected ImportHelper mImportHelper;

    public BasicImportHelperAdapter(ImportHelper importHelper) {
        this.mImportHelper = importHelper;
    }

    public void configureImportHelper(AbstractImportType abstractImportType) {
    }

    public ImportHelper getImportHelper() {
        return this.mImportHelper;
    }

    public void onDestroy() {
        this.mImportHelper = null;
    }
}
