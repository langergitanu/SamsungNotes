package com.samsung.android.support.senl.p148nt.app.main.folder.adapter;

import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface AdapterContract {
    String getFolderUuid();

    int getLayoutMode();

    int getModeIndex();

    boolean isAnimateItem(String str);

    boolean isCheckedItem(String str);

    boolean isDimItem(String str);

    void onFolderSelected(FolderHolderInfo folderHolderInfo, int i, boolean z);

    boolean onItemLongPressed(FolderHolderInfo folderHolderInfo);

    void onItemPressReleased();

    boolean onTouch(FolderHolder folderHolder, int i);

    void setDragListener(FolderHolderInfo folderHolderInfo);

    void toggleFolderSyncSwitch(FolderHolderInfo folderHolderInfo);

    void updateContentDescription(FolderHolderInfo folderHolderInfo);
}
