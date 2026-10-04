package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMapContract;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesCategoryTreeSortUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderMap {
    private static final String TAG = "FolderMap";
    private final DocumentMapContract.Folder mDocMapContract;
    private final StateInfo mStateInfo;
    private Map<String, NotesFolder> mFolderDataMap = new LinkedHashMap();
    private final Map<String, NotesCategoryTreeEntity> mSearchFolderDataMap = new LinkedHashMap();
    private final List<Common> mDefaultData = new ArrayList();
    private final List<Common> mConcealTargetData = new ArrayList();

    public FolderMap(StateInfo stateInfo, DocumentMapContract.Folder folder) {
        this.mStateInfo = stateInfo;
        this.mDocMapContract = folder;
    }

    private void addSALogOnBackKeyDown(String str) {
        if (this.mStateInfo.getModeIndex() == 7) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_PICK);
            return;
        }
        if (FolderConstants.RecycleBin.UUID.equals(str)) {
            CommonSamsungAnalytics.insertLog("531");
            return;
        }
        if (FolderConstants.AllNotes.UUID.equals(str)) {
            CommonSamsungAnalytics.insertLog("101");
        } else if (FolderConstants.Coedit.UUID.equals(str)) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN);
        } else {
            CommonSamsungAnalytics.insertLog("201");
        }
    }

    private void clearSubFolderInfo() {
        this.mDefaultData.clear();
        this.mConcealTargetData.clear();
    }

    private int getChildFolderCountWithoutIgnoreFolder(String str) {
        NotesFolder notesFolder = this.mFolderDataMap.get(str);
        if (notesFolder == null) {
            return 0;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(notesFolder.getChildren());
        for (NotesFolder notesFolder2 : notesFolder.getChildren()) {
            if (FolderUtils.isIgnoreFolder(notesFolder2)) {
                copyOnWriteArrayList.remove(notesFolder2);
            }
        }
        return copyOnWriteArrayList.size();
    }

    private List<String> getCurrentFolderUuids() {
        ArrayList arrayList = new ArrayList();
        Iterator<Common> it = this.mDefaultData.iterator();
        while (it.hasNext()) {
            for (NotesFolder notesFolder : it.next().folders) {
                if (notesFolder != null) {
                    arrayList.add(notesFolder.getUuid());
                }
            }
        }
        Iterator<Common> it2 = this.mConcealTargetData.iterator();
        while (it2.hasNext()) {
            for (NotesFolder notesFolder2 : it2.next().folders) {
                if (notesFolder2 != null) {
                    arrayList.add(notesFolder2.getUuid());
                }
            }
        }
        return arrayList;
    }

    private void updateSubFolderInfo(List<NotesFolder> list, int i, List<String> list2) {
        int size = list.size();
        int subFoldersSpan = this.mStateInfo.getSubFoldersSpan();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (i2 < size) {
            ArrayList arrayList3 = new ArrayList(Collections.nCopies(subFoldersSpan, null));
            ArrayList arrayList4 = new ArrayList(Collections.nCopies(subFoldersSpan, null));
            int i4 = 0;
            while (i4 < subFoldersSpan) {
                int i5 = i2 + i4;
                if (i5 >= size) {
                    break;
                }
                NotesFolder notesFolder = list.get(i5);
                if (notesFolder.getIsDeleted() != i || FolderUtils.isIgnoreFolder(notesFolder)) {
                    i2++;
                } else {
                    if (list2.contains(notesFolder.getUuid())) {
                        arrayList3.set(i4, Boolean.valueOf(this.mStateInfo.isShowSubFolderWithAnimation()));
                    } else {
                        arrayList3.set(i4, Boolean.TRUE);
                    }
                    arrayList4.set(i4, notesFolder);
                    i4++;
                }
            }
            if (arrayList4.get(0) != null) {
                Common.Folder folder = new Common.Folder(arrayList4, subFoldersSpan, arrayList3);
                if (arrayList.size() >= 3) {
                    folder.showWithExpandAnimation = this.mStateInfo.isShowSubFolderWithAnimation();
                    folder.isExpandableSubFolder = true;
                    arrayList2.add(folder);
                } else {
                    folder.showWithExpandAnimation = false;
                    folder.isExpandableSubFolder = false;
                    arrayList.add(folder);
                }
            }
            i2 += subFoldersSpan;
        }
        this.mDefaultData.addAll(arrayList);
        this.mConcealTargetData.addAll(arrayList2);
    }

    @Nullable
    public NotesFolder get(String str) {
        return this.mFolderDataMap.get(str);
    }

    public String getBackFolderHistory() {
        NotesFolder notesFolder;
        String folderUuid = this.mStateInfo.getFolderUuid();
        Stack<String> folderBackHistory = this.mStateInfo.getFolderBackHistory();
        if (folderBackHistory == null) {
            return null;
        }
        while (!folderBackHistory.isEmpty()) {
            String strPop = folderBackHistory.pop();
            if (FolderConstants.AllNotes.UUID.equals(folderUuid) || FolderConstants.MyFolders.UUID.equals(folderUuid)) {
                this.mStateInfo.clearFolderBackHistory();
                break;
            }
            if (!isIgnoreFolder(folderUuid) && !strPop.equals(folderUuid) && (!FeatureUtils.isFilterFolderType(strPop) || this.mDocMapContract.getDocumentCount(strPop) >= 1)) {
                if (!isIgnoreFolder(strPop) && (notesFolder = this.mFolderDataMap.get(strPop)) != null && notesFolder.getIsDeleted() == 0) {
                    this.mStateInfo.setBackFolder(true);
                    addSALogOnBackKeyDown(strPop);
                    return strPop;
                }
            }
        }
        return null;
    }

    public List<Common> getConcealList() {
        return this.mConcealTargetData;
    }

    public List<Common> getDefaultList() {
        return this.mDefaultData;
    }

    public int getFolderCount() {
        if (FeatureUtils.isSubFolderExist(this.mStateInfo.getModeIndex(), this.mStateInfo.getFolderUuid())) {
            return getChildFolderCountWithoutIgnoreFolder(this.mStateInfo.getFolderUuid());
        }
        return 0;
    }

    public int getFolderDepth(String str) {
        NotesFolder notesFolder = this.mFolderDataMap.get(str);
        if (notesFolder == null) {
            return 0;
        }
        return notesFolder.getDepth();
    }

    public List<Common> getFolderDisplayData() {
        List<String> currentFolderUuids = getCurrentFolderUuids();
        clearSubFolderInfo();
        String folderUuid = this.mStateInfo.getFolderUuid();
        if (!FeatureUtils.isSubFolderExist(this.mStateInfo.getModeIndex(), folderUuid)) {
            AbstractC8014b.m7209k("getFolderDisplayData# subfolder not exist mode, folderUuid : ", folderUuid, TAG);
            return Collections.EMPTY_LIST;
        }
        NotesFolder notesFolder = this.mFolderDataMap.get(folderUuid);
        if (notesFolder == null) {
            MainLogger.m7254d(TAG, "getFolderDisplayData# folderUuid : " + folderUuid + ", folder is null");
            return Collections.EMPTY_LIST;
        }
        String str = FolderConstants.RecycleBin.UUID;
        NotesCategoryTreeSortUtils.sort(notesFolder, str.equals(folderUuid) ? NotesUtils.getDeleteSortParam() : NotesCategoryTreeSortUtils.getSortParam());
        updateSubFolderInfo(notesFolder.getChildren(), str.equals(folderUuid) ? 2 : 0, currentFolderUuids);
        List<Common> runtimeFolderDisplayData = getRuntimeFolderDisplayData();
        this.mStateInfo.setShowSubFolderWithAnimation(false);
        MainLogger.m7258i(TAG, "getFolderDisplayData# folderUuid : " + folderUuid + ", subfolder size : " + runtimeFolderDisplayData.size());
        return runtimeFolderDisplayData;
    }

    public Map<String, NotesFolder> getMap() {
        return this.mFolderDataMap;
    }

    public List<Common> getRuntimeFolderDisplayData() {
        boolean zIsExpandedFolderBar = this.mStateInfo.isExpandedFolderBar();
        ArrayList arrayList = new ArrayList(this.mDefaultData);
        if (zIsExpandedFolderBar) {
            Iterator<Common> it = this.mConcealTargetData.iterator();
            while (it.hasNext()) {
                it.next().showWithExpandAnimation = this.mStateInfo.isShowSubFolderWithAnimation();
            }
            arrayList.addAll(this.mConcealTargetData);
        }
        if (this.mConcealTargetData.isEmpty() && arrayList.size() <= 3) {
            this.mDocMapContract.putHolderInfoMap(12, false);
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_FOLDER_EXPAND_BAR, "c");
            return arrayList;
        }
        this.mDocMapContract.putHolderInfoMap(12, true);
        arrayList.add(new Common.ExpandBar(-22L));
        CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_FOLDER_EXPAND_BAR, zIsExpandedFolderBar ? "b" : "a");
        return arrayList;
    }

    public List<Common> getSearchDisplayListAsMode() {
        List<String> currentFolderUuids = getCurrentFolderUuids();
        clearSubFolderInfo();
        ArrayList arrayList = new ArrayList();
        Iterator<NotesCategoryTreeEntity> it = this.mSearchFolderDataMap.values().iterator();
        while (it.hasNext()) {
            NotesFolder notesFolder = this.mFolderDataMap.get(it.next().getUuid());
            if (notesFolder != null && !FolderUtils.isIgnoreFolder(notesFolder)) {
                arrayList.add(notesFolder);
            }
        }
        updateSubFolderInfo(arrayList, 0, currentFolderUuids);
        List<Common> runtimeFolderDisplayData = getRuntimeFolderDisplayData();
        this.mStateInfo.setShowSubFolderWithAnimation(false);
        return runtimeFolderDisplayData;
    }

    public int getSearchFolderCount() {
        return this.mSearchFolderDataMap.size();
    }

    public void initFolderDataMap() {
        if (DataManager.getInstance().isInitFolderMapNeed()) {
            MainLogger.m7258i(TAG, "initFolderDataMap isInitFolderMapNeed");
        }
        this.mFolderDataMap = DataManager.getInstance().getFolderDataMap();
        if (FolderConstants.MyFolders.UUID.equals(this.mStateInfo.getFolderUuid())) {
            DataManager.getInstance().screenOffMemoOrdering(this.mFolderDataMap);
        }
    }

    public void initSearchMap(List<NotesCategoryTreeEntity> list) {
        MainLogger.m7258i(TAG, "initSearchMap# size : " + list.size() + ", modeIndex : " + this.mStateInfo.getModeIndex());
        this.mSearchFolderDataMap.clear();
        for (NotesCategoryTreeEntity notesCategoryTreeEntity : list) {
            this.mSearchFolderDataMap.put(notesCategoryTreeEntity.getUuid(), notesCategoryTreeEntity);
        }
    }

    public boolean isDeletedFolder(String str) {
        NotesFolder notesFolder = this.mFolderDataMap.get(str);
        return notesFolder != null && notesFolder.getIsDeleted() == 2;
    }

    public boolean isIgnoreFolder(String str) {
        NotesFolder notesFolder = this.mFolderDataMap.get(str);
        if (notesFolder == null) {
            return true;
        }
        return FolderUtils.isIgnoreFolder(notesFolder);
    }

    public void updateScaleAnimation() {
        for (int i = 0; i < this.mConcealTargetData.size(); i++) {
            Collections.fill(this.mConcealTargetData.get(i).showWithScaleAnimation, Boolean.TRUE);
        }
    }
}
