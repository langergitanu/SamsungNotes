package com.samsung.android.support.senl.p148nt.app.main.drawer.model;

import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TabletDrawerModel extends DrawerModel {
    private static final String TAG = "TabletDrawerModel";

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.model.DrawerModel
    public void collectingDrawerData(NotesFolder notesFolder) {
        if ("settings:///".equals(notesFolder.getUuid())) {
            return;
        }
        super.collectingDrawerData(notesFolder);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.model.DrawerModel
    public void updateFilterDrawer(Map<String, NotesDocumentCountEntry> map) {
        if (isInitFolderMapNeed()) {
            return;
        }
        if (this.mDrawerDisplayDataList == null) {
            initDrawerDisplayDataList();
        }
        MainLogger.m7254d(TAG, "updateFilterDrawer");
        List<NotesFolder> listInitFilterDrawerDisplayList = initFilterDrawerDisplayList();
        updateFilterPreDefineDrawerDisplayList(map);
        this.mDrawerDisplayDataList.addAll(listInitFilterDrawerDisplayList);
        updateFolderInfoPreference(map);
    }
}
