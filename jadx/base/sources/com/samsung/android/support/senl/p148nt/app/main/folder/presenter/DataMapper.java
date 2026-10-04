package com.samsung.android.support.senl.p148nt.app.main.folder.presenter;

import android.os.Bundle;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.main.folder.adapter.FolderAdapter;
import com.samsung.android.support.senl.p148nt.app.main.folder.model.FolderAnimateMap;
import com.samsung.android.support.senl.p148nt.app.main.folder.model.FolderCheckMap;
import com.samsung.android.support.senl.p148nt.app.main.folder.model.FolderModel;
import com.samsung.android.support.senl.p148nt.app.main.folder.model.FolderMoveMap;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DataMapper {
    protected FolderAdapter mFolderAdapter;
    protected final FolderModel mFolderModel = new FolderModel();
    protected final FolderCheckMap mFolderCheckMap = new FolderCheckMap();
    protected final FolderMoveMap mFolderMoveMap = new FolderMoveMap();
    protected final FolderAnimateMap mFolderAnimateMap = new FolderAnimateMap();

    public void addAnimateItem(String str) {
        this.mFolderAnimateMap.addAnimateItem(str);
    }

    public void addCheckedItem(String str) {
        if (this.mFolderCheckMap.isCheckedItem(str)) {
            return;
        }
        this.mFolderCheckMap.addCheckedItem(str, Boolean.FALSE);
    }

    public void addDimStatusItem(NotesFolder notesFolder) {
        if (notesFolder == null) {
            return;
        }
        this.mFolderMoveMap.addDimStatusItem(notesFolder.getUuid());
        Iterator<NotesFolder> it = notesFolder.getChildren().iterator();
        while (it.hasNext()) {
            addDimStatusItem(it.next());
        }
    }

    public void attachAddFolderItem(boolean z, boolean z2) {
        this.mFolderModel.attachAddFolderItem(z);
        if (z) {
            if (z2) {
                addDimStatusItem(this.mFolderModel.getFolderData("addFolder:///"));
            } else {
                this.mFolderMoveMap.clearDimStatusItems();
            }
        }
    }

    public void clearAnimateItems() {
        this.mFolderAnimateMap.clearAnimateItems();
    }

    public void clearCheckedItems() {
        this.mFolderCheckMap.clearCheckedItems();
    }

    public ArrayList<String> getCheckedItemUuidList() {
        return this.mFolderCheckMap.getCheckedItemUuidList();
    }

    public ArrayList<String> getCheckedRootItemUuidList() {
        return this.mFolderCheckMap.getCheckedRootItemUuidList();
    }

    public int getDimFolderCount() {
        return this.mFolderModel.getFolderData(FolderConstants.MyFolders.UUID) != null ? 1 : 0;
    }

    public int getFolderCount() {
        List<NotesFolder> folderDisplayDataList = this.mFolderModel.getFolderDisplayDataList();
        if (folderDisplayDataList == null) {
            return 0;
        }
        return folderDisplayDataList.size() - (this.mFolderModel.getFolderData("addFolder:///") != null ? 1 : 0);
    }

    public NotesFolder getFolderData(String str) {
        return this.mFolderModel.getFolderData(str);
    }

    public List<NotesFolder> getFolderDisplayDataList() {
        return this.mFolderModel.getFolderDisplayDataList();
    }

    public FolderMoveMap getFolderMoveMap() {
        return this.mFolderMoveMap;
    }

    public int getSelectedItemCount() {
        return this.mFolderCheckMap.getCheckedItemCount();
    }

    public String getSelectedUuid() {
        return this.mFolderModel.getSelectedUuid();
    }

    public boolean isAnimateItem(String str) {
        return this.mFolderAnimateMap.isAnimateItem(str);
    }

    public boolean isCheckedItem(String str) {
        return this.mFolderCheckMap.isCheckedItem(str);
    }

    public void onReplaceCheckedItems() {
        List<NotesFolder> folderDisplayDataList = this.mFolderModel.getFolderDisplayDataList();
        if (folderDisplayDataList == null) {
            return;
        }
        for (int i = 0; i < folderDisplayDataList.size(); i++) {
            NotesFolder folderDisplayData = this.mFolderModel.getFolderDisplayData(i);
            if (folderDisplayData != null) {
                String uuid = folderDisplayData.getUuid();
                if (folderDisplayData.getViewType() != 4 && isCheckedItem(uuid) && (!folderDisplayData.hasParent() || !isCheckedItem(folderDisplayData.getParent().getUuid()))) {
                    this.mFolderCheckMap.addCheckedItem(uuid, Boolean.TRUE);
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.mFolderCheckMap.saveCheckedItem(bundle);
        this.mFolderModel.onSaveInstanceState(bundle);
    }

    public void onSelectAll(boolean z) {
        List<NotesFolder> folderDisplayDataList = this.mFolderModel.getFolderDisplayDataList();
        if (folderDisplayDataList == null) {
            return;
        }
        for (int i = 0; i < folderDisplayDataList.size(); i++) {
            NotesFolder folderDisplayData = this.mFolderModel.getFolderDisplayData(i);
            if (folderDisplayData != null && folderDisplayData.getViewType() == 0) {
                String uuid = folderDisplayData.getUuid();
                if (z) {
                    addCheckedItem(uuid);
                } else {
                    removeCheckedItem(uuid);
                }
            }
        }
    }

    public void removeCheckedItem(String str) {
        if (this.mFolderCheckMap.isCheckedItem(str)) {
            this.mFolderCheckMap.removeCheckedItem(str);
        }
    }

    public void restoreInstanceState(Bundle bundle) {
        this.mFolderCheckMap.loadCheckedItem(bundle);
        this.mFolderModel.restoreInstanceState(bundle);
    }

    public void setSelectedUuid(String str) {
        this.mFolderModel.setSelectedUuid(str);
    }
}
