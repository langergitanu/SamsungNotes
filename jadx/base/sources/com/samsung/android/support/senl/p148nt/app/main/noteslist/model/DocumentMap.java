package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationListResult;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMapContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.DataTask;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DocumentMap implements DocumentMapContract.Note, DocumentMapContract.Folder {
    private static final String TAG = "DocumentMap";
    private List<Common> mCommonDisplayList;
    private final FolderMap mFolderMap;
    private final HolderInfoMap mHolderInfoMap;
    private final NoteMap mNoteMap;
    private final StateInfo mStateInfo;
    private DataTask mRestoreListTask = null;
    private List<MainListDocumentData> mRestoreList = null;

    public DocumentMap(StateInfo stateInfo) {
        this.mStateInfo = stateInfo;
        this.mNoteMap = new NoteMap(stateInfo, this);
        this.mFolderMap = new FolderMap(stateInfo, this);
        this.mHolderInfoMap = new HolderInfoMap(stateInfo);
    }

    private int getSubFolderLineCount() {
        return this.mFolderMap.getDefaultList().size() + (this.mStateInfo.isExpandedFolderBar() ? this.mFolderMap.getConcealList().size() : 0);
    }

    private boolean initSearchDisplayList(int i) {
        String folderUuid = this.mStateInfo.getFolderUuid();
        int caller = this.mStateInfo.getCaller();
        putHolderInfoMap(11, true);
        putHolderInfoMap(6, false);
        putHolderInfoMap(5, false);
        MainLogger.m7254d(TAG, "initSearchDisplayList# ModeIndex : " + this.mStateInfo.getModeIndex() + ", FolderUuid : " + folderUuid + ", HashTagNames : " + this.mStateInfo.getSelectedTags().toString() + ", SpaceId : " + this.mStateInfo.getSpaceId() + ", Caller : " + caller);
        if (this.mCommonDisplayList == null) {
            this.mCommonDisplayList = new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mFolderMap.getSearchDisplayListAsMode());
        arrayList.addAll(this.mNoteMap.getSearchDisplayListAsMode(i));
        if (isEquals(arrayList)) {
            setTopHolderInfoMap();
            return false;
        }
        this.mCommonDisplayList.clear();
        setTopHolderInfoMap();
        this.mCommonDisplayList.addAll(arrayList);
        MainLogger.m7258i(TAG, "initSearchDisplayList# commonDisplayList size " + this.mCommonDisplayList.size());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseRestoreTask() {
        this.mRestoreListTask = null;
        this.mRestoreList = null;
    }

    private void setTopHolderInfoMap() {
        sortTopHolderDisplayList(13);
        sortTopHolderDisplayList(14);
        sortTopHolderDisplayList(0);
        sortTopHolderDisplayList(10);
        sortTopHolderDisplayList(1);
        sortTopHolderDisplayList(2);
        sortTopHolderDisplayList(11);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.model.DocumentMapContract.Note
    public void addCommonDisplayList(List<Common> list) {
        if (this.mCommonDisplayList == null) {
            this.mCommonDisplayList = new ArrayList();
        }
        this.mCommonDisplayList.addAll(list);
    }

    public void addFolderData(String str, String str2, String str3, int i) {
        MainLogger.m7258i(TAG, "addFolderData# folderName : " + MainLogger.getEncode(str3) + ", parentUuid : " + str2);
        NotesFolder folderData = getFolderData(str2);
        DataManager.getInstance().insertFolder(str2, str3, i, folderData != null ? folderData.getChildren().size() : 0);
    }

    public void cancelRestoreListTask() {
        DataTask dataTask = this.mRestoreListTask;
        if (dataTask != null) {
            dataTask.cancel();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.model.DocumentMapContract.Note
    public void clearCommonDisplayList() {
        List<Common> list = this.mCommonDisplayList;
        if (list != null) {
            list.clear();
        }
    }

    public void clearSyncProgressInfoMap() {
        this.mHolderInfoMap.clearSyncProgressInfoMap();
    }

    public int findScrollIndexOfDisplayData(String str) {
        if (this.mCommonDisplayList == null) {
            initCommonDisplayList();
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        for (int i = 0; i < this.mCommonDisplayList.size(); i++) {
            String str2 = this.mCommonDisplayList.get(i).uuid;
            if (str2 != null && str2.contains(str)) {
                int i2 = i - 1;
                if (i2 >= 0) {
                    long j = this.mCommonDisplayList.get(i2).f6179id;
                    if (j <= -23 && j >= -29) {
                        return i2;
                    }
                }
                return i;
            }
        }
        return -1;
    }

    public int findTimeSubHeaderPosition(String str) {
        List<Common> commonDisplayList = getCommonDisplayList();
        if (commonDisplayList == null) {
            return -1;
        }
        boolean z = false;
        for (int size = commonDisplayList.size() - 1; size >= 0; size--) {
            Common common = commonDisplayList.get(size);
            if (str.equals(common.uuid)) {
                z = true;
            } else if (z) {
                long j = common.f6179id;
                if (j <= -23 && j >= -29) {
                    return size;
                }
            } else {
                continue;
            }
        }
        return -1;
    }

    public List<Integer> findTimeSubHeaderPositionList() {
        List<Common> commonDisplayList = getCommonDisplayList();
        if (commonDisplayList == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int size = commonDisplayList.size() - 1; size >= 0; size--) {
            long j = commonDisplayList.get(size).f6179id;
            if (j <= -23 && j >= -29) {
                arrayList.add(Integer.valueOf(size));
            }
        }
        return arrayList;
    }

    public String getBackFolderHistory() {
        return this.mFolderMap.getBackFolderHistory();
    }

    public ChildDeletableData getChildDeletableList(String str) {
        NotesFolder notesFolder = this.mFolderMap.get(str);
        ChildDeletableData childDeletableData = new ChildDeletableData();
        childDeletableData.addTotalFolders();
        if (notesFolder != null) {
            Iterator<NotesFolder> it = notesFolder.getChildren().iterator();
            while (it.hasNext()) {
                childDeletableData.addAll(getChildDeletableList(it.next().getUuid()));
            }
            for (MainListDocumentData mainListDocumentData : this.mNoteMap.values()) {
                if (mainListDocumentData.getCategoryUuid().equals(str)) {
                    childDeletableData.addTotalNotes();
                    childDeletableData.addFilePath(mainListDocumentData.getFilePath());
                    if (!NotesUtils.isDeletableWithoutVerify(mainListDocumentData.getIsLock())) {
                        childDeletableData.addDeletableWithVerifyCount();
                    }
                }
            }
        }
        return childDeletableData;
    }

    public int getCoeditNoteCount() {
        return (getNoteDataCount() - this.mNoteMap.getSpaceCount()) - this.mNoteMap.getInvitationCount();
    }

    public CoeditMainListEntry getCoeditNoteData(String str) {
        NoteMap noteMap = this.mNoteMap;
        if (noteMap == null) {
            return null;
        }
        return noteMap.getCoeditNote(str);
    }

    public int getCoeditSpaceCount() {
        return this.mNoteMap.getSpaceCount();
    }

    public Common getCommonDisplayData(int i) {
        List<Common> commonDisplayList = getCommonDisplayList();
        if (commonDisplayList == null || i < 0 || commonDisplayList.size() <= i) {
            return null;
        }
        return commonDisplayList.get(i);
    }

    public List<Common> getCommonDisplayList() {
        if (this.mCommonDisplayList == null) {
            initCommonDisplayList();
        }
        return this.mCommonDisplayList;
    }

    public int getCommonDisplayListSize(String... strArr) {
        return getCommonDisplayListSize(getCommonDisplayList(), strArr);
    }

    public List<Common> getConcealList() {
        return this.mFolderMap.getConcealList();
    }

    public HashSet<String> getDisplayNoteUuidSet() {
        HashSet<String> hashSet = new HashSet<>();
        List<Common> list = this.mCommonDisplayList;
        int size = list == null ? 0 : list.size();
        for (int i = 0; i < size; i++) {
            hashSet.add(this.mCommonDisplayList.get(i).uuid);
        }
        return hashSet;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.model.DocumentMapContract.Folder
    public int getDocumentCount(String str) {
        return this.mNoteMap.getDocumentCount(str);
    }

    public int getFolderCount() {
        return this.mFolderMap.getFolderCount();
    }

    public NotesFolder getFolderData(String str) {
        FolderMap folderMap = this.mFolderMap;
        if (folderMap == null) {
            return null;
        }
        return folderMap.get(str);
    }

    public int getFolderDepth(String str) {
        return this.mFolderMap.getFolderDepth(str);
    }

    public Map<String, NotesFolder> getFolderMap() {
        return this.mFolderMap.getMap();
    }

    public int getHolderInfoDisplayedCount() {
        return this.mHolderInfoMap.getHolderInfoDisplayedCount();
    }

    public MainListDocumentData getNoteData(String str) {
        NoteMap noteMap = this.mNoteMap;
        if (noteMap == null) {
            return null;
        }
        return noteMap.get(str);
    }

    public int getNoteDataCount() {
        int holderInfoDisplayedCount = this.mHolderInfoMap.getHolderInfoDisplayedCount();
        int subFolderLineCount = getSubFolderLineCount();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(holderInfoDisplayedCount, subFolderLineCount, "getNoteDataCount# defaultHolderCount : ", ", subFolderLineCount : ", ", commonDisplayList : ");
        sbM1173s.append(getCommonDisplayList().size());
        MainLogger.m7254d(TAG, sbM1173s.toString());
        return !FeatureUtils.isSubFolderExist(this.mStateInfo.getModeIndex(), this.mStateInfo.getFolderUuid()) ? getCommonDisplayList().size() - holderInfoDisplayedCount : (getCommonDisplayList().size() - subFolderLineCount) - holderInfoDisplayedCount;
    }

    public Map<String, MainListDocumentData> getNoteMap() {
        return this.mNoteMap.getMap();
    }

    public int getSelectableDataCount() {
        return FeatureUtils.isPickEditMode(this.mStateInfo.getModeIndex()) ? getNoteDataCount() : getCommonDisplayListSize(FolderUtils.sStaticFolders);
    }

    public Map<String, MainListDocumentData> getSubHeaderUuidList(boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, MainListDocumentData> entry : this.mNoteMap.entrySet()) {
            if (z != entry.getValue().isSDoc() && entry.getValue().getMdeSpaceId().equals(this.mStateInfo.getSpaceId())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public boolean hasHolderInfo(int i) {
        return this.mHolderInfoMap.hasHolderInfo(i);
    }

    public int indexOfDefaultDisplayData(int i) {
        return this.mHolderInfoMap.indexOfHolderInfoMap(this.mCommonDisplayList, i);
    }

    public int indexOfDisplayData(String str) {
        if (this.mCommonDisplayList == null) {
            initCommonDisplayList();
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        for (int i = 0; i < this.mCommonDisplayList.size(); i++) {
            String str2 = this.mCommonDisplayList.get(i).uuid;
            if (str2 != null && str2.contains(str)) {
                return i;
            }
        }
        return -1;
    }

    public int indexOfSortTopHolder(int i) {
        return this.mHolderInfoMap.indexOfSortTopHolder(this.mCommonDisplayList, i);
    }

    public int indexOfSpanSubFolderDisplayData(String str) {
        if (this.mCommonDisplayList == null) {
            initCommonDisplayList();
        }
        for (int i = 0; i < this.mCommonDisplayList.size(); i++) {
            List<NotesFolder> list = this.mCommonDisplayList.get(i).folders;
            if (list != null) {
                int i2 = 0;
                for (NotesFolder notesFolder : list) {
                    if (notesFolder != null && !TextUtils.isEmpty(str) && str.equals(notesFolder.getUuid())) {
                        return i2;
                    }
                    i2++;
                }
            }
        }
        return -1;
    }

    public int indexOfSubFolderDisplayData(String str) {
        if (this.mCommonDisplayList == null) {
            initCommonDisplayList();
        }
        for (int i = 0; i < this.mCommonDisplayList.size(); i++) {
            List<NotesFolder> list = this.mCommonDisplayList.get(i).folders;
            if (list != null) {
                for (NotesFolder notesFolder : list) {
                    if (notesFolder != null && !TextUtils.isEmpty(str) && str.equals(notesFolder.getUuid())) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public boolean initCoeditGroupMap(List<CoeditMainListEntry> list) {
        this.mNoteMap.initCoeditMap(list);
        return initCommonDisplayList();
    }

    public void initCoeditInvitationMap(List<GroupInvitationListResult.GroupInvitation> list) {
        this.mNoteMap.initCoeditInvitationMap(list);
    }

    public void initCoeditMap(List<CoeditMainListEntry> list) {
        this.mNoteMap.initCoeditMap(list);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.model.DocumentMapContract.Note
    public boolean initCommonDisplayList() {
        String folderUuid = this.mStateInfo.getFolderUuid();
        MainLogger.m7254d(TAG, "initCommonDisplayList# ModeIndex : " + this.mStateInfo.getModeIndex() + ", FolderUuid : " + folderUuid + ", HashTagNames : " + this.mStateInfo.getSelectedTags().toString() + ", SpaceId : " + this.mStateInfo.getSpaceId() + ", Caller : " + this.mStateInfo.getCaller());
        if (this.mCommonDisplayList == null) {
            this.mCommonDisplayList = new ArrayList();
        }
        this.mHolderInfoMap.initHolderInfoMap();
        ArrayList arrayList = new ArrayList(this.mFolderMap.getFolderDisplayData());
        if (this.mStateInfo.isCoeditMode()) {
            arrayList.addAll(this.mNoteMap.getCoeditInvitationDisplayData());
            arrayList.addAll(this.mNoteMap.getCoeditSpaceDisplayData());
        } else if (this.mStateInfo.isHashTagMode()) {
            arrayList.addAll(this.mHolderInfoMap.getRelatedTagDisplayData());
        }
        this.mNoteMap.addNoteMap(arrayList, folderUuid);
        if (isEquals(arrayList)) {
            setTopHolderInfoMap();
            MainLogger.m7258i(TAG, "initCommonDisplayList# new displayData and old displayData are same, commonDisplayList size : " + this.mCommonDisplayList.size());
            return false;
        }
        this.mCommonDisplayList.clear();
        setTopHolderInfoMap();
        this.mCommonDisplayList.addAll(arrayList);
        MainLogger.m7258i(TAG, "initCommonDisplayList# commonDisplayList size " + this.mCommonDisplayList.size());
        return true;
    }

    public boolean initConvertedNoteMap(List<MainListDocumentData> list) {
        return this.mNoteMap.initConvertedNoteMap(list);
    }

    public void initFolderDataMap() {
        this.mFolderMap.initFolderDataMap();
    }

    public boolean initNoteMap(@Nullable List<MainListDocumentData> list) {
        this.mNoteMap.initNoteMap(list);
        return initCommonDisplayList();
    }

    public boolean initNoteMapWithoutFolder(List<MainListDocumentData> list) {
        return this.mNoteMap.initNoteMapWithoutFolder(list);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.model.DocumentMapContract.Note
    public boolean initOldCommonDisplayData(boolean z) {
        String categoryUuid = this.mStateInfo.getCategoryUuid();
        MainLogger.m7258i(TAG, "initOldCommonDisplayData# isConverted : " + z + ", categoryUuid : " + categoryUuid);
        ArrayList arrayList = new ArrayList();
        this.mNoteMap.addOldNoteMap(arrayList, z, categoryUuid);
        if (isEquals(arrayList)) {
            MainLogger.m7258i(TAG, "initOldCommonDisplayData# new displayData and old displayData are same");
            setTopHolderInfoMap();
            return false;
        }
        clearCommonDisplayList();
        this.mHolderInfoMap.initHolderInfoMap();
        setTopHolderInfoMap();
        addCommonDisplayList(arrayList);
        return true;
    }

    public boolean initOldNoteMap(List<MainListDocumentData> list) {
        return this.mNoteMap.initOldNoteMap(list);
    }

    public boolean initSearchMap(List<NotesCategoryTreeEntity> list, List<MainListDocumentData> list2, List<MainListDocumentData> list3, int i) {
        this.mFolderMap.initSearchMap(list);
        this.mNoteMap.initSearchMap(list2, list3);
        return initSearchDisplayList(i);
    }

    public boolean isConcealFolderData(String str) {
        String str2;
        List<Common> concealList = this.mFolderMap.getConcealList();
        int size = concealList == null ? 0 : concealList.size();
        if (size != 0 && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < size; i++) {
                if (concealList.get(i).type <= 1024 && (str2 = concealList.get(i).uuid) != null && str2.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isDeletedFolder(String str) {
        return this.mFolderMap.isDeletedFolder(str);
    }

    public boolean isDisplayedFolderData(String str) {
        String str2;
        List<Common> list = this.mCommonDisplayList;
        int size = list == null ? 0 : list.size();
        if (size != 0 && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < size; i++) {
                if (this.mCommonDisplayList.get(i).type <= 1024 && (str2 = this.mCommonDisplayList.get(i).uuid) != null && str2.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.model.DocumentMapContract.Note
    public boolean isEquals(List<Common> list) {
        int size;
        int iIndexOfHolderInfoMap;
        List<Common> list2 = this.mCommonDisplayList;
        if (list2 == null || list2.isEmpty() || list == null || list.isEmpty()) {
            return false;
        }
        for (int i : FeatureUtils.getTopHolderInfoMapOrder()) {
            if (this.mHolderInfoMap.hasHolderInfo(i) && (iIndexOfHolderInfoMap = this.mHolderInfoMap.indexOfHolderInfoMap(this.mCommonDisplayList, i)) != -1) {
                this.mCommonDisplayList.remove(iIndexOfHolderInfoMap);
            }
        }
        if (this.mStateInfo.isGcsSpaceMode() || list.size() != (size = this.mCommonDisplayList.size())) {
            return false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.mCommonDisplayList.get(i2).equals(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public boolean isIgnoreFolder(String str) {
        return this.mFolderMap.isIgnoreFolder(str);
    }

    public boolean isRestoreListTasking() {
        DataTask dataTask = this.mRestoreListTask;
        if (dataTask != null) {
            return (dataTask.isCompleted() && this.mRestoreListTask.isCancelled()) ? false : true;
        }
        return false;
    }

    public boolean nonNullDocumentCountMap() {
        return this.mNoteMap.nonNullDocumentCountMap();
    }

    public void onRestoreInstanceState(final Activity activity, Bundle bundle) {
        if (bundle.getBoolean(NotesConstants.KEY_HAS_SSM_PROGRESS_BAR)) {
            putHolderInfoMap(0, true);
        }
        this.mFolderMap.initFolderDataMap();
        if (FeatureUtils.isOldMode(this.mStateInfo.getModeIndex())) {
            this.mNoteMap.restoreOldNoteMap();
            return;
        }
        DataTask dataTask = new DataTask(activity);
        this.mRestoreListTask = dataTask;
        dataTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.model.DocumentMap.1
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onEnd(@NonNull WorkerTask.Result result) {
                ViewModeUtils.runOnUiThread(activity, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.model.DocumentMap.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DocumentMap.this.mRestoreListTask != null && DocumentMap.this.mRestoreListTask.isCancelled()) {
                            MainLogger.m7254d(DocumentMap.TAG, "onEnd# RestoreListTask is cancelled.");
                            DocumentMap.this.releaseRestoreTask();
                        } else {
                            DocumentMap documentMap = DocumentMap.this;
                            documentMap.initNoteMap(documentMap.mRestoreList);
                            DocumentMap.this.releaseRestoreTask();
                        }
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onStart(@NonNull WorkerTask<?> workerTask) {
            }
        });
        this.mRestoreListTask.run(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.model.DocumentMap.2
            @Override // java.lang.Runnable
            public void run() {
                DocumentMap documentMap = DocumentMap.this;
                documentMap.mRestoreList = documentMap.mNoteMap.restoreNoteMap();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putBoolean(NotesConstants.KEY_HAS_SSM_PROGRESS_BAR, this.mHolderInfoMap.hasHolderInfo(0));
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.model.DocumentMapContract.Note, com.samsung.android.support.senl.nt.app.main.noteslist.model.DocumentMapContract.Folder
    public void putHolderInfoMap(int i, boolean z) {
        this.mHolderInfoMap.putHolderInfoMap(i, z);
    }

    public void putSyncProgressInfoMap(long j) {
        this.mHolderInfoMap.putSyncProgressInfoMap(j);
    }

    public boolean removeCoeditInvitationMap(String str) {
        return this.mNoteMap.removeCoeditInvitationMap(str);
    }

    public void removeHolderInfoMap(int i) {
        this.mHolderInfoMap.removeHolderInfoMap(i);
    }

    public void removeSyncProgressInfoMap(long j) {
        this.mHolderInfoMap.removeSyncProgressInfoMap(j);
    }

    public void setFolderUuid(String str) {
        Stack<String> folderBackHistory;
        String folderUuid = this.mStateInfo.getFolderUuid();
        if (folderUuid.equals(str)) {
            return;
        }
        if (!this.mStateInfo.isBackFolder() && (folderBackHistory = this.mStateInfo.getFolderBackHistory()) != null) {
            folderBackHistory.push(folderUuid);
        }
        this.mStateInfo.setBackFolder(false);
        this.mStateInfo.setFolderUuid(str);
    }

    public void setSyncProgressInfoCount(long j, int i) {
        this.mHolderInfoMap.setSyncProgressInfoCount(j, i);
    }

    public int sortTopHolderDisplayList(int i) {
        return this.mHolderInfoMap.sortTopHolderDisplayList(this.mCommonDisplayList, i);
    }

    public void updateDocumentCountMap(Map<String, NotesDocumentCountEntry> map) {
        this.mNoteMap.updateDocumentCountMap(map);
    }

    public void updateFolderDisplayList() {
        String folderUuid = this.mStateInfo.getFolderUuid();
        MainLogger.m7254d(TAG, "initCommonDisplayList# ModeIndex : " + this.mStateInfo.getModeIndex() + ", FolderUuid : " + folderUuid + ", HashTagNames : " + this.mStateInfo.getSelectedTags().toString() + ", SpaceId : " + this.mStateInfo.getSpaceId() + ", Caller : " + this.mStateInfo.getCaller());
        if (this.mCommonDisplayList == null) {
            this.mCommonDisplayList = new ArrayList();
        }
        this.mHolderInfoMap.initHolderInfoMap();
        ArrayList arrayList = new ArrayList(this.mFolderMap.getRuntimeFolderDisplayData());
        this.mFolderMap.updateScaleAnimation();
        this.mStateInfo.setShowSubFolderWithAnimation(false);
        if (this.mStateInfo.isCoeditMode()) {
            arrayList.addAll(this.mNoteMap.getCoeditInvitationDisplayData());
            arrayList.addAll(this.mNoteMap.getCoeditSpaceDisplayData());
        } else if (this.mStateInfo.isHashTagMode()) {
            arrayList.addAll(this.mHolderInfoMap.getRelatedTagDisplayData());
        }
        this.mNoteMap.addNoteMap(arrayList, folderUuid);
        if (isEquals(arrayList)) {
            setTopHolderInfoMap();
            MainLogger.m7258i(TAG, "initCommonDisplayList# new displayData and old displayData are same, commonDisplayList size : " + this.mCommonDisplayList.size());
            return;
        }
        this.mCommonDisplayList.clear();
        setTopHolderInfoMap();
        this.mCommonDisplayList.addAll(arrayList);
        MainLogger.m7258i(TAG, "initCommonDisplayList# commonDisplayList size " + this.mCommonDisplayList.size());
    }

    public int getCommonDisplayListSize(List<Common> list, String... strArr) {
        String folderUuid = this.mStateInfo.getFolderUuid();
        int holderInfoDisplayedCount = this.mHolderInfoMap.getHolderInfoDisplayedCount();
        if (FeatureUtils.isCoeditMode(this.mStateInfo.getModeIndex())) {
            return (list.size() - holderInfoDisplayedCount) - (this.mNoteMap.getInvitationCount() + this.mNoteMap.getSpaceCount());
        }
        if (FeatureUtils.isSearchMode(this.mStateInfo.getModeIndex())) {
            return this.mFolderMap.getSearchFolderCount() + this.mNoteMap.getNoteCount();
        }
        if (!FeatureUtils.isSubFolderExist(this.mStateInfo.getModeIndex(), folderUuid)) {
            return list.size() - holderInfoDisplayedCount;
        }
        NotesFolder notesFolder = this.mFolderMap.get(folderUuid);
        List<NotesFolder> children = notesFolder == null ? null : notesFolder.getChildren();
        int i = 0;
        if (children != null) {
            int size = children.size();
            int size2 = children.size();
            for (NotesFolder notesFolder2 : children) {
                if (size - size2 == strArr.length) {
                    break;
                }
                for (String str : strArr) {
                    size2 -= notesFolder2.getUuid().equals(str) ? 1 : 0;
                }
            }
            i = size2;
        }
        return ((list.size() - getSubFolderLineCount()) + i) - holderInfoDisplayedCount;
    }

    @NonNull
    public List<String> getSubHeaderUuidList(int i) {
        List<Common> commonDisplayList = getCommonDisplayList();
        if (commonDisplayList == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int size = commonDisplayList.size();
        while (true) {
            i++;
            if (i >= size) {
                break;
            }
            long j = commonDisplayList.get(i).f6179id;
            if (j <= -23 && j >= -29) {
                break;
            }
            arrayList.add(commonDisplayList.get(i).uuid);
        }
        return arrayList;
    }

    public int indexOfDisplayData(long j) {
        if (this.mCommonDisplayList == null) {
            initCommonDisplayList();
        }
        for (int i = 0; i < this.mCommonDisplayList.size(); i++) {
            if (this.mCommonDisplayList.get(i).f6179id == j) {
                return i;
            }
        }
        return -1;
    }
}
