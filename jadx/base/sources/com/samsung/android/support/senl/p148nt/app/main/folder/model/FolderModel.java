package com.samsung.android.support.senl.p148nt.app.main.folder.model;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.ReservedFolderName;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesCategoryTreeSortUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderModel {
    private static final String TAG = "FolderModel";
    private Map<String, NotesFolder> mFolderDataMap;
    private List<NotesFolder> mFolderDisplayDataList;
    private boolean mIsNeedDataChange;
    private String mNewUuid;
    private String mSelectedUuid;
    private String mToBeDeletedUuid;

    public FolderModel() {
        this(FolderManager.getInstance().getAllDocumentCategoryTree(false).getFolderMap());
    }

    private void collectingFolderData(NotesFolder notesFolder) {
        if (notesFolder == null || FolderUtils.isIgnoreFolder(notesFolder)) {
            return;
        }
        this.mFolderDisplayDataList.add(notesFolder);
        MainLogger.m7258i(TAG, "collectingFolderData : " + MainLogger.getEncode(notesFolder.getDisplayName()));
        if (notesFolder.isExpanded() && notesFolder.getIsDeleted() == 0) {
            Iterator<NotesFolder> it = notesFolder.getChildren().iterator();
            while (it.hasNext()) {
                collectingFolderData(it.next());
            }
        }
    }

    private List<NotesFolder> getChildFolderListWithoutIgnoreFolder(String str) {
        return getChildFolderListWithoutIgnoreFolder(this.mFolderDataMap.get(str));
    }

    public static boolean isExistFolderName(Context context, String str, String str2, List<String> list, boolean z) {
        String strTrim = str.replace('\n', ' ').trim();
        if (TextUtils.isEmpty(strTrim.replaceAll("'", "''"))) {
            return false;
        }
        if (z && ReservedFolderName.isReservedFolderForDataSet(context, strTrim)) {
            return true;
        }
        if (!z && ReservedFolderName.isReservedFolderForLayoutSet(context, strTrim)) {
            return true;
        }
        if (list == null) {
            list = DataManager.getInstance().getFoldersDisplayName(str2, null);
        }
        return list.contains(strTrim);
    }

    private void move(Collection<String> collection, String str) {
        try {
            FolderManager.getInstance().move(collection, str);
        } catch (InvalidParentFolderException e) {
            MainLogger.m7255e(TAG, "move# : " + e.getMessage());
        }
    }

    private void sortFolders(@NonNull Map<String, NotesFolder> map) {
        NotesFolder notesFolder = map.get(FolderConstants.MyFolders.UUID);
        if (notesFolder == null) {
            MainLogger.m7258i(TAG, "sortFolders, myFolders is null");
        } else {
            NotesCategoryTreeSortUtils.sort(notesFolder);
        }
    }

    public String addFolderData(String str, String str2, int i) {
        MainLogger.m7258i(TAG, "addFolderData# folderName : " + MainLogger.getEncode(str2) + ", parentUuid : " + str);
        NotesFolder folderData = getFolderData(str);
        return DataManager.getInstance().insertFolder(str, str2, i, folderData != null ? folderData.getChildren().size() : 0);
    }

    public void attachAddFolderItem(boolean z) {
        if (this.mFolderDataMap == null) {
            return;
        }
        if (this.mFolderDisplayDataList == null) {
            initFolderDisplayDataList();
        }
        AbstractC6670b.m4739D("attachAddFolderItem# attach : ", TAG, z);
        int size = this.mFolderDisplayDataList.size() - 1;
        if (!z) {
            this.mFolderDataMap.remove("addFolder:///");
            if (size < 0 || !this.mFolderDisplayDataList.get(size).getUuid().equals("addFolder:///")) {
                return;
            }
            this.mFolderDisplayDataList.remove(size);
            return;
        }
        if (this.mFolderDataMap.containsKey("addFolder:///")) {
            if (size < 0 || !this.mFolderDisplayDataList.get(size).getUuid().equals("addFolder:///")) {
                this.mFolderDisplayDataList.add(this.mFolderDataMap.get("addFolder:///"));
                return;
            }
            return;
        }
        NotesFolder notesFolder = new NotesFolder("addFolder:///", null, FolderConstants.AddFolder.DISPLAY_NAME, "addFolder:///");
        notesFolder.setViewType(4);
        notesFolder.setId(-12L);
        notesFolder.setDepth(1);
        this.mFolderDataMap.put("addFolder:///", notesFolder);
        this.mFolderDisplayDataList.add(notesFolder);
    }

    public void attachAllNotesItem() {
        if (this.mFolderDataMap == null) {
            return;
        }
        if (this.mFolderDisplayDataList == null) {
            initFolderDisplayDataList();
        }
        MainLogger.m7258i(TAG, "attachAllNotesItem# attach");
        Map<String, NotesFolder> map = this.mFolderDataMap;
        String str = FolderConstants.AllNotes.UUID;
        if (map.containsKey(str)) {
            if (this.mFolderDisplayDataList.isEmpty() || !this.mFolderDisplayDataList.get(0).getUuid().equals(str)) {
                this.mFolderDisplayDataList.add(0, this.mFolderDataMap.get(str));
                return;
            }
            return;
        }
        NotesFolder notesFolder = new NotesFolder(str, null, FolderConstants.AllNotes.DISPLAY_NAME, FolderConstants.AllNotes.PATH);
        notesFolder.setViewType(1002);
        notesFolder.setId(-1L);
        this.mFolderDataMap.put(str, notesFolder);
        this.mFolderDisplayDataList.add(0, notesFolder);
    }

    public void changeColorData(ArrayList<String> arrayList, int i) {
        MainLogger.m7258i(TAG, "changeColorData# uuidCount : " + arrayList.size() + ", color : " + i);
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            NotesFolder folderData = getFolderData(it.next());
            if (folderData != null) {
                folderData.setDisplayNameColor(i);
                arrayList2.add(folderData);
            }
        }
        update(arrayList2);
    }

    public int collapseFolderDisplayData(NotesFolder notesFolder) {
        if (this.mFolderDataMap == null) {
            return 0;
        }
        if (this.mFolderDisplayDataList == null) {
            initFolderDisplayDataList();
        }
        MainLogger.m7258i(TAG, "collapseFolderDisplayData# name : " + notesFolder.getDisplayName());
        List<NotesFolder> childFolderListWithoutIgnoreFolder = getChildFolderListWithoutIgnoreFolder(notesFolder);
        if (childFolderListWithoutIgnoreFolder == null) {
            return 0;
        }
        int size = childFolderListWithoutIgnoreFolder.size();
        for (NotesFolder notesFolder2 : childFolderListWithoutIgnoreFolder) {
            if (notesFolder2.hasChild() && notesFolder2.isExpanded()) {
                size = collapseFolderDisplayData(notesFolder2) + size;
            }
            this.mFolderDisplayDataList.remove(notesFolder2);
            NotesFolder notesFolder3 = this.mFolderDataMap.get(notesFolder2.getUuid());
            if (notesFolder3 != null) {
                notesFolder3.setExpanded(false);
            }
        }
        return size;
    }

    public int expandedFolderDisplayData(String str, int i) {
        List<NotesFolder> childFolderListWithoutIgnoreFolder;
        Map<String, NotesFolder> map = this.mFolderDataMap;
        if (map == null || map.get(str) == null || (childFolderListWithoutIgnoreFolder = getChildFolderListWithoutIgnoreFolder(str)) == null) {
            return 0;
        }
        MainLogger.m7258i(TAG, "expandedFolderDisplayData# children count : " + childFolderListWithoutIgnoreFolder.size());
        this.mFolderDisplayDataList.addAll(i, childFolderListWithoutIgnoreFolder);
        return childFolderListWithoutIgnoreFolder.size();
    }

    public int getExpandedFolderCount(List<NotesFolder> list) {
        int expandedFolderCount = 0;
        for (NotesFolder notesFolder : list) {
            expandedFolderCount = notesFolder.isExpanded() ? getExpandedFolderCount(notesFolder.getChildren()) + 1 + expandedFolderCount : expandedFolderCount + 1;
        }
        return expandedFolderCount;
    }

    public NotesFolder getFolderData(String str) {
        Map<String, NotesFolder> map = this.mFolderDataMap;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Map<String, NotesFolder> getFolderDataMap() {
        Map<String, NotesFolder> map = this.mFolderDataMap;
        return map == null ? new LinkedHashMap() : map;
    }

    public NotesFolder getFolderDisplayData(int i) {
        List<NotesFolder> folderDisplayDataList = getFolderDisplayDataList();
        if (folderDisplayDataList == null || i >= folderDisplayDataList.size() || i == -1) {
            return null;
        }
        return folderDisplayDataList.get(i);
    }

    @Nullable
    public List<NotesFolder> getFolderDisplayDataList() {
        if (this.mFolderDataMap == null) {
            return null;
        }
        if (this.mFolderDisplayDataList == null) {
            initFolderDisplayDataList();
        }
        return this.mFolderDisplayDataList;
    }

    public String getNewUuid() {
        return this.mNewUuid;
    }

    public LiveData<DocumentCategoryTree> getObserver(@NonNull Collection<String> collection) {
        return FolderManager.getInstance().getAllDocumentCategoryTree_LiveData(collection, true);
    }

    public String getParentUuid(String str) {
        NotesFolder folderData;
        NotesFolder parent;
        if (str == null || (folderData = getFolderData(str)) == null || (parent = folderData.getParent()) == null) {
            return null;
        }
        return parent.getUuid();
    }

    public int getPositionExpandedFolderCount(List<NotesFolder> list, String str) {
        int expandedFolderCount = 0;
        for (NotesFolder notesFolder : list) {
            expandedFolderCount = notesFolder.isExpanded() ? getExpandedFolderCount(notesFolder.getChildren()) + 1 + expandedFolderCount : expandedFolderCount + 1;
            if (notesFolder.getUuid().equals(str)) {
                break;
            }
        }
        return expandedFolderCount;
    }

    public String getSelectedUuid() {
        return this.mSelectedUuid;
    }

    public String getToBeDeletedUuid() {
        return this.mToBeDeletedUuid;
    }

    public boolean hasLockedNoteInsideFolder(String str, boolean z) {
        return DataManager.getInstance().hasLockedNoteInsideFolder(str, z);
    }

    public void initFolderDisplayDataList() {
        MainLogger.m7258i(TAG, "initFolderDisplayDataList");
        this.mFolderDisplayDataList = new ArrayList();
        collectingFolderData(this.mFolderDataMap.get(FolderConstants.MyFolders.UUID));
    }

    public boolean isDeletedFolder(String str) {
        NotesFolder folderData = getFolderData(str);
        return folderData == null || folderData.getIsDeleted() != 0;
    }

    public boolean isNeedDataChange() {
        return this.mIsNeedDataChange;
    }

    public int moveFolderData(ArrayList<String> arrayList, String str) {
        NotesFolder folderData = getFolderData(str);
        if (folderData == null) {
            return 1;
        }
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (String str2 : arrayList) {
            NotesFolder folderData2 = getFolderData(str2);
            if (!str2.equals(str) && folderData2 != null && folderData2.getParent() != null && !folderData2.getParent().getUuid().equals(str)) {
                if ((folderData.getDepth() + DataManager.getMaximumFolderDepth(folderData2)) - folderData2.getDepth() >= 50) {
                    i = 2;
                } else {
                    arrayList2.add(str2);
                }
            }
        }
        move(arrayList2, str);
        StringBuilder sb = new StringBuilder("moveFolderData# moveCount : ");
        sb.append(arrayList2.size());
        sb.append(" , to : ");
        sb.append(str);
        sb.append(", result : ");
        AbstractC8014b.m7212n(sb, TAG, i);
        return i;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(NotesConstants.KEY_FOLDER_UUID, this.mToBeDeletedUuid);
    }

    public void renameFolderData(String str, String str2, int i) {
        MainLogger.m7258i(TAG, "renameFolderData# folderName : " + MainLogger.getEncode(str2) + ", selectedUuid : " + str);
        NotesFolder folderData = getFolderData(str);
        if (folderData == null) {
            return;
        }
        folderData.setDisplayName(str2);
        folderData.setDisplayNameColor(i);
        update(folderData);
    }

    public void restoreFolderMsSyncExpandState() {
        String string = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getString(NotesConstants.KEY_FOLDER_MS_SYNC_EXPAND_STATE, null);
        MainLogger.m7254d(TAG, "restoreFolderMsSyncExpandState");
        if (string != null) {
            DataManager.getInstance().setExpandedJSONObject(getFolderDataMap(), string);
            SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putString(NotesConstants.KEY_FOLDER_MS_SYNC_EXPAND_STATE, null);
        } else {
            Iterator<NotesFolder> it = getFolderDataMap().values().iterator();
            while (it.hasNext()) {
                it.next().setExpanded(true);
            }
        }
    }

    public void restoreFolderPickerExpandState() {
        String string = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getString(NotesConstants.KEY_FOLDER_PICKER_EXPAND_STATE, null);
        if (string == null) {
            return;
        }
        MainLogger.m7254d(TAG, "restoreFolderPickerExpandState");
        DataManager.getInstance().setExpandedJSONObject(getFolderDataMap(), string);
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putString(NotesConstants.KEY_FOLDER_PICKER_EXPAND_STATE, null);
    }

    public void restoreInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mToBeDeletedUuid = bundle.getString(NotesConstants.KEY_FOLDER_UUID);
    }

    public void saveFolderMsSyncExpandState() {
        MainLogger.m7254d(TAG, "saveFolderMsSyncExpandState");
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putString(NotesConstants.KEY_FOLDER_MS_SYNC_EXPAND_STATE, null);
    }

    public void saveFolderPickerExpandState() {
        MainLogger.m7254d(TAG, "saveFolderPickerExpandState");
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putString(NotesConstants.KEY_FOLDER_PICKER_EXPAND_STATE, DataManager.getInstance().getExpandedJSONObject(getFolderDataMap()));
    }

    public void setNeedDataChange(boolean z) {
        this.mIsNeedDataChange = z;
    }

    public void setNewUuid(String str) {
        this.mNewUuid = str;
    }

    public void setSelectedUuid(String str) {
        this.mSelectedUuid = str;
    }

    public void setToBeDeletedUuid(String str) {
        this.mToBeDeletedUuid = str;
    }

    public void update(@NonNull NotesCategoryTreeEntity notesCategoryTreeEntity) {
        try {
            FolderManager.getInstance().update(notesCategoryTreeEntity);
        } catch (InvalidParentFolderException e) {
            MainLogger.m7255e(TAG, "update# : " + e.getMessage());
        }
    }

    public void updateFolderData(NotesFolder notesFolder) {
        NotesFolder notesFolder2;
        int iIndexOf;
        Map<String, NotesFolder> map = this.mFolderDataMap;
        if (map == null || (notesFolder2 = map.get(notesFolder.getUuid())) == null) {
            return;
        }
        MainLogger.m7258i(TAG, "updateFolderData# folderName : " + MainLogger.getEncode(notesFolder.getDisplayName()));
        this.mFolderDataMap.put(notesFolder2.getUuid(), notesFolder);
        List<NotesFolder> list = this.mFolderDisplayDataList;
        if (list == null || (iIndexOf = list.indexOf(notesFolder2)) < 0) {
            return;
        }
        this.mFolderDisplayDataList.remove(iIndexOf);
        this.mFolderDisplayDataList.add(iIndexOf, notesFolder);
    }

    public void updateFolderDataMap(Map<String, NotesFolder> map) {
        MainLogger.m7258i(TAG, "updateFolderDataMap# size " + map.size());
        sortFolders(map);
        if (this.mFolderDataMap == null) {
            this.mFolderDataMap = new LinkedHashMap();
        }
        for (NotesFolder notesFolder : map.values()) {
            NotesFolder notesFolder2 = this.mFolderDataMap.get(notesFolder.getUuid());
            if (notesFolder2 != null) {
                notesFolder.setExpanded(notesFolder2.isExpanded());
                notesFolder.setViewType(notesFolder2.getViewType());
                notesFolder.setId(notesFolder2.getId());
            }
        }
        this.mFolderDataMap.clear();
        this.mFolderDataMap.putAll(DataManager.getInstance().drawerOrdering(map));
        initFolderDisplayDataList();
    }

    public FolderModel(Map<String, NotesFolder> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.mFolderDataMap = linkedHashMap;
        this.mToBeDeletedUuid = null;
        this.mSelectedUuid = null;
        this.mNewUuid = null;
        this.mIsNeedDataChange = false;
        linkedHashMap.putAll(map);
        sortFolders(this.mFolderDataMap);
    }

    @Nullable
    private List<NotesFolder> getChildFolderListWithoutIgnoreFolder(NotesFolder notesFolder) {
        if (notesFolder == null) {
            return null;
        }
        List<NotesFolder> children = notesFolder.getChildren();
        if (FolderConstants.MyFolders.UUID.equals(notesFolder.getUuid())) {
            for (String str : FolderUtils.sStaticFolders) {
                NotesFolder notesFolder2 = this.mFolderDataMap.get(str);
                if (FolderUtils.isIgnoreFolder(notesFolder2)) {
                    children.remove(notesFolder2);
                }
            }
        }
        return children;
    }

    private void update(@NonNull List<NotesCategoryTreeEntity> list) {
        try {
            FolderManager.getInstance().update(list);
        } catch (InvalidParentFolderException e) {
            MainLogger.m7255e(TAG, "update# : " + e.getMessage());
        }
    }
}
