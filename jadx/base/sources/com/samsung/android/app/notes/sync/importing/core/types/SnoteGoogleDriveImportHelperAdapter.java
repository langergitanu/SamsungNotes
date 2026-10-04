package com.samsung.android.app.notes.sync.importing.core.types;

import com.samsung.android.app.notes.sync.importing.core.ImportHelper;
import com.samsung.android.app.notes.sync.importing.core.SnoteGoogleImportHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SnoteGoogleDriveImportHelperAdapter extends BasicImportHelperAdapter {
    public SnoteGoogleDriveImportHelperAdapter(ImportHelper importHelper) {
        super(importHelper);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.types.BasicImportHelperAdapter
    public void configureImportHelper(AbstractImportType abstractImportType) {
        SnoteGoogleImportHelper snoteGoogleImportHelper = (SnoteGoogleImportHelper) getImportHelper();
        SnoteGoogleDriveImportType snoteGoogleDriveImportType = (SnoteGoogleDriveImportType) abstractImportType;
        snoteGoogleImportHelper.setDrive(snoteGoogleDriveImportType.getDrive());
        snoteGoogleImportHelper.setCurrentAccountName(snoteGoogleDriveImportType.getGoogleAccountName());
    }
}
