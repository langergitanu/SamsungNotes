package com.samsung.android.app.notes.sync.importing.core.types;

import com.google.api.services.drive.Drive;
import com.samsung.android.app.notes.sync.items.ImportItem;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SnoteGoogleDriveImportType extends AbstractImportType {
    private Drive mDrive;
    private String mGoogleAccontName;

    public SnoteGoogleDriveImportType(List<ImportItem> list, String str, Drive drive) {
        setImportItems(list);
        this.mDrive = drive;
        this.mGoogleAccontName = str;
    }

    public Drive getDrive() {
        return this.mDrive;
    }

    public String getGoogleAccountName() {
        return this.mGoogleAccontName;
    }
}
