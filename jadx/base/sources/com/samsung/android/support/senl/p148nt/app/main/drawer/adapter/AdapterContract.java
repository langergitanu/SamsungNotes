package com.samsung.android.support.senl.p148nt.app.main.drawer.adapter;

import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.drawer.model.DrawerModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface AdapterContract {
    String getFolderUuid();

    DrawerModel getModel();

    boolean isFreeFormWindow();

    void onFolderSelected(FolderHolderInfo folderHolderInfo, int i, boolean z);

    void onItemLongPressed(FolderHolderInfo folderHolderInfo);

    void setDragListener(DrawerHolder drawerHolder);

    void updateNewBadge();
}
