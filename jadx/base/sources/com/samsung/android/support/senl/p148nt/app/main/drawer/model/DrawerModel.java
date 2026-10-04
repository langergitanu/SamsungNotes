package com.samsung.android.support.senl.p148nt.app.main.drawer.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesCategoryTreeSortUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesLockDocumentRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DrawerModel {
    private static final int NOT_FOUND_INDEX = -1;
    private static final String TAG = "DrawerModel";
    protected List<NotesFolder> mDrawerDisplayDataList;
    protected Map<String, NotesFolder> mFolderDataMap;
    private String mFolderUuid;
    private MainListDocumentDataRepository mMainListRepository;
    private NotesLockDocumentRepository mNotesLockDocumentRepository;
    private String mPrevFolderUuid;
    private final Map<String, NotesDocumentCountEntry> mDocumentCountMap = new LinkedHashMap();
    private final Map<String, NotesDocumentCountEntry> mCoeditCountMap = new LinkedHashMap();
    private final WaitedObservedMap mWaitedObservedMap = new WaitedObservedMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum FilterType {
        Favorite(1, "favorite:///"),
        LockedNotes(2, "lock:///");

        private final int key;
        private final String uuid;

        FilterType(int i, String str) {
            this.key = i;
            this.uuid = str;
        }

        public int getKey() {
            return this.key;
        }

        public String getUuid() {
            return this.uuid;
        }
    }

    public DrawerModel() {
        String str = FolderConstants.AllNotes.UUID;
        this.mFolderUuid = str;
        this.mPrevFolderUuid = str;
    }

    private void addDrawerDisplayList(NotesFolder notesFolder) {
        if (notesFolder == null) {
            return;
        }
        this.mDrawerDisplayDataList.add(notesFolder);
    }

    private int getAllLockedNoteCount() {
        NotesLockDocumentRepository noteLockRepository = getNoteLockRepository();
        if (noteLockRepository == null) {
            return 0;
        }
        return noteLockRepository.getAllLockedDataCount(0);
    }

    private int getFavoriteItemCount() {
        MainListDocumentDataRepository noteRepository = getNoteRepository();
        if (noteRepository == null) {
            return 0;
        }
        return noteRepository.getFavoriteItemCount(0);
    }

    @Nullable
    private NotesLockDocumentRepository getNoteLockRepository() {
        if (BaseUtils.getApplicationContext() == null) {
            return null;
        }
        if (this.mNotesLockDocumentRepository == null) {
            this.mNotesLockDocumentRepository = NotesDataRepositoryFactory.newInstance(BaseUtils.getApplicationContext()).createNotesLockDocumentRepository();
        }
        return this.mNotesLockDocumentRepository;
    }

    private int getPrefFolderDocumentCount(String str, int i) {
        if (1001 >= i || i >= 1010) {
            return 0;
        }
        int i2 = SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt(str, 0);
        MainLogger.m7254d(TAG, "getPrefFolderDocumentCount# entry is null, get count in pref, uuid/count: " + str + i2);
        return i2;
    }

    private void setPrefFolderDocumentCount(NotesFolder notesFolder, NotesDocumentCountEntry notesDocumentCountEntry) {
        int viewType = notesFolder.getViewType();
        String uuid = notesFolder.getUuid();
        if (1001 >= viewType || viewType >= 1010) {
            return;
        }
        int documentCount = (notesDocumentCountEntry != null ? notesDocumentCountEntry.getDocumentCount() : notesFolder.getDocumentCount()) + (FeatureUtils.isNeedFolderCount(viewType) ? notesFolder.getChildren().size() : 0);
        if (documentCount > 0) {
            SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).putInt(uuid, documentCount);
        } else {
            if (notesDocumentCountEntry == null && 1008 == viewType && SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).contains(uuid)) {
                return;
            }
            SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).remove(uuid);
        }
    }

    private void setPrevFolderUuid(String str) {
        this.mPrevFolderUuid = str;
    }

    private void updateFilter(Map<String, NotesDocumentCountEntry> map, int i, String str, String str2, String str3, int i2, long j) {
        updateFilter(map, i > 0, i, str, str2, str3, i2, j);
    }

    private void updateOldNoteFilter(Map<String, NotesDocumentCountEntry> map) {
        boolean zIsOldNotesFolderNeed = DataManager.getInstance().isOldNotesFolderNeed();
        String str = FolderConstants.OldNotes.UUID;
        updateFilter(map, zIsOldNotesFolderNeed, getDocumentCount(str, 1003), str, FolderConstants.OldNotes.DISPLAY_NAME, FolderConstants.OldNotes.PATH, 1003, -2L);
    }

    public void addFolderData(String str, String str2, int i) {
        MainLogger.m7258i(TAG, "addFolderData# folderName : " + MainLogger.getEncode(str2) + ", parentUuid : " + str);
        NotesFolder folderData = getFolderData(str);
        DataManager.getInstance().insertFolder(str, str2, i, folderData != null ? folderData.getChildren().size() : 0);
    }

    public void clearWaitedObservedMap() {
        this.mWaitedObservedMap.clearWaitedObservedMap();
    }

    public int collapseDrawerDisplayData(NotesFolder notesFolder) {
        if (isInitFolderMapNeed()) {
            return 0;
        }
        if (this.mDrawerDisplayDataList == null) {
            initDrawerDisplayDataList();
        }
        MainLogger.m7258i(TAG, "collapseDrawerDisplayData# name : " + notesFolder.getDisplayName());
        List<NotesFolder> childFolderListWithoutIgnoreFolder = getChildFolderListWithoutIgnoreFolder(notesFolder);
        if (childFolderListWithoutIgnoreFolder == null) {
            return 0;
        }
        int size = childFolderListWithoutIgnoreFolder.size();
        for (NotesFolder notesFolder2 : childFolderListWithoutIgnoreFolder) {
            if (notesFolder2.hasChild() && notesFolder2.isExpanded()) {
                size = collapseDrawerDisplayData(notesFolder2) + size;
            }
            this.mDrawerDisplayDataList.remove(notesFolder2);
            NotesFolder notesFolder3 = this.mFolderDataMap.get(notesFolder2.getUuid());
            if (notesFolder3 != null) {
                notesFolder3.setExpanded(false);
            }
        }
        return size;
    }

    public void collectingDrawerData(NotesFolder notesFolder) {
        if (notesFolder == null || FolderUtils.isIgnoreFolder(notesFolder)) {
            return;
        }
        this.mDrawerDisplayDataList.add(notesFolder);
        if (notesFolder.isExpanded() && notesFolder.getIsDeleted() == 0) {
            NotesCategoryTreeSortUtils.sort(notesFolder);
            Iterator<NotesFolder> it = notesFolder.getChildren().iterator();
            while (it.hasNext()) {
                collectingDrawerData(it.next());
            }
        }
    }

    public DocumentCategoryTree dequeueWaitedCategoryObservedMap() {
        return this.mWaitedObservedMap.dequeueWaitedCategoryObservedMap();
    }

    public List<CoeditMainListEntry> dequeueWaitedCoeditObservedMap() {
        return this.mWaitedObservedMap.dequeueWaitedCoeditObservedMap();
    }

    public Map<String, NotesDocumentCountEntry> dequeueWaitedCountObservedMap() {
        return this.mWaitedObservedMap.dequeueWaitedCountObservedMap();
    }

    public void enqueueWaitedObservedMap(Map<String, NotesDocumentCountEntry> map) {
        this.mWaitedObservedMap.enqueueWaitedObservedMap(map);
    }

    public int expandedDrawerDisplayData(String str, int i) {
        List<NotesFolder> childFolderListWithoutIgnoreFolder;
        if (isInitFolderMapNeed() || this.mFolderDataMap.get(str) == null || (childFolderListWithoutIgnoreFolder = getChildFolderListWithoutIgnoreFolder(str)) == null) {
            return 0;
        }
        MainLogger.m7258i(TAG, "expandedDrawerDisplayData# children : " + childFolderListWithoutIgnoreFolder.size());
        this.mDrawerDisplayDataList.addAll(i, childFolderListWithoutIgnoreFolder);
        return childFolderListWithoutIgnoreFolder.size();
    }

    public LiveData<Map<String, NotesDocumentCountEntry>> getAllDocumentCountEntryMap_LiveData() {
        MainListDocumentDataRepository noteRepository = getNoteRepository();
        if (noteRepository == null) {
            return null;
        }
        return noteRepository.getAllDocumentCountEntryMap_LiveData(true);
    }

    @Nullable
    public List<NotesFolder> getChildFolderListWithoutIgnoreFolder(String str) {
        if (isInitFolderMapNeed()) {
            return null;
        }
        return getChildFolderListWithoutIgnoreFolder(this.mFolderDataMap.get(str));
    }

    public int getDocumentCount(String str, int i) {
        if (FolderConstants.OldNotes.UUID.equals(str)) {
            return DataManager.getInstance().getOldNoteCount();
        }
        NotesDocumentCountEntry notesDocumentCountEntry = this.mDocumentCountMap.get(str);
        return notesDocumentCountEntry == null ? getPrefFolderDocumentCount(str, i) : notesDocumentCountEntry.getDocumentCount();
    }

    @Nullable
    public NotesFolder getDrawerDisplayData(int i) {
        List<NotesFolder> drawerDisplayDataList = getDrawerDisplayDataList();
        if (drawerDisplayDataList == null || drawerDisplayDataList.size() <= i || i < 0) {
            return null;
        }
        return drawerDisplayDataList.get(i);
    }

    public NotesFolder getDrawerDisplayDataByItemId(long j) {
        List<NotesFolder> drawerDisplayDataList = getDrawerDisplayDataList();
        if (drawerDisplayDataList == null) {
            return null;
        }
        for (NotesFolder notesFolder : drawerDisplayDataList) {
            if (notesFolder.getId() == j) {
                return notesFolder;
            }
        }
        return null;
    }

    public List<NotesFolder> getDrawerDisplayDataList() {
        if (isInitFolderMapNeed()) {
            return new ArrayList();
        }
        if (this.mDrawerDisplayDataList == null) {
            initDrawerDisplayDataList();
        }
        return this.mDrawerDisplayDataList;
    }

    @Nullable
    public NotesFolder getFolderData(String str) {
        if (!isInitFolderMapNeed()) {
            return this.mFolderDataMap.get(str);
        }
        MainLogger.m7254d(TAG, "getFolderData not init");
        return null;
    }

    public Map<String, NotesFolder> getFolderDataMap() {
        if (!isInitFolderMapNeed()) {
            return this.mFolderDataMap;
        }
        MainLogger.m7254d(TAG, "getFolderDataMap not init");
        return new LinkedHashMap();
    }

    public int getFolderDocumentCount(String str) {
        List<NotesFolder> childFolderListWithoutIgnoreFolder = getChildFolderListWithoutIgnoreFolder(str);
        if (childFolderListWithoutIgnoreFolder == null) {
            return 0;
        }
        return childFolderListWithoutIgnoreFolder.size();
    }

    public String getFolderUuid() {
        if (this.mFolderUuid == null) {
            this.mFolderUuid = NotesUtils.getLastSelectedFolder();
        }
        return this.mFolderUuid;
    }

    public MainListDocumentDataRepository getNoteRepository() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        if (this.mMainListRepository == null) {
            this.mMainListRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createMainListDocumentDataRepository();
        }
        return this.mMainListRepository;
    }

    public String getPrevFolderUuid() {
        return this.mPrevFolderUuid;
    }

    public boolean hasLockedNoteInsideFolder(String str, boolean z) {
        if (getNoteLockRepository() == null) {
            return false;
        }
        return !r0.find(str, z).isEmpty();
    }

    public int indexOfDrawerDisplayData(String str) {
        if (this.mDrawerDisplayDataList == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        if (FolderConstants.SharedNotes.UUID.equals(str)) {
            str = FolderConstants.Coedit.UUID;
        }
        Iterator<NotesFolder> it = this.mDrawerDisplayDataList.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (str.equals(it.next().getUuid())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void initDrawerDisplayDataList() {
        if (isInitFolderMapNeed()) {
            MainLogger.m7254d(TAG, "initDrawerDisplayDataList not init");
            return;
        }
        MainLogger.m7254d(TAG, "initDrawerDisplayDataList");
        if (this.mDrawerDisplayDataList == null) {
            this.mDrawerDisplayDataList = new ArrayList();
        }
        this.mDrawerDisplayDataList.clear();
        NotesFolder notesFolder = this.mFolderDataMap.get(FolderConstants.MyFolders.UUID);
        if (notesFolder == null) {
            MainLogger.m7254d(TAG, "initDrawerDisplayDataList, myFolders is null");
            return;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            MainLogger.m7254d(TAG, "initDrawerDisplayDataList, appContext is null");
            return;
        }
        for (String str : FolderUtils.sStaticFolders) {
            NotesFolder notesFolder2 = this.mFolderDataMap.get(str);
            if (notesFolder2 != null) {
                notesFolder2.setDisplayName(FolderUtils.getPrefixedFolderName(applicationContext, str));
            }
        }
        NotesCategoryTreeSortUtils.sort(notesFolder);
        for (NotesFolder notesFolder3 : this.mFolderDataMap.values()) {
            if (!notesFolder3.hasParent()) {
                collectingDrawerData(notesFolder3);
            }
        }
    }

    public List<NotesFolder> initFilterDrawerDisplayList() {
        ArrayList arrayList = new ArrayList(this.mDrawerDisplayDataList);
        for (NotesFolder notesFolder : this.mDrawerDisplayDataList) {
            if (notesFolder.getViewType() > 1008) {
                break;
            }
            arrayList.remove(notesFolder);
        }
        this.mDrawerDisplayDataList.clear();
        return arrayList;
    }

    @WorkerThread
    public void initFolderMap() {
        DataManager.getInstance().initFolderMap();
        this.mFolderDataMap = DataManager.getInstance().getFolderDataMap();
    }

    public boolean isInitFolderMapNeed() {
        return this.mFolderDataMap == null;
    }

    public void setFolderUuid(String str) {
        AbstractC0000a.m25v("setFolderUuid# ", str, TAG);
        setPrevFolderUuid(this.mFolderUuid);
        this.mFolderUuid = str;
    }

    public void updateAllDocumentCountMap(Map<String, NotesDocumentCountEntry> map) {
        MainLogger.m7258i(TAG, "updateAllDocumentCountMap# countMap : " + map.size());
        updateFilterDrawer(map);
        this.mDocumentCountMap.clear();
        this.mDocumentCountMap.putAll(map);
        this.mDocumentCountMap.putAll(this.mCoeditCountMap);
    }

    public boolean updateCoeditCountMap(int i) {
        Map<String, NotesDocumentCountEntry> map = this.mDocumentCountMap;
        String str = FolderConstants.Coedit.UUID;
        NotesDocumentCountEntry notesDocumentCountEntry = map.get(str);
        if (notesDocumentCountEntry == null) {
            notesDocumentCountEntry = new NotesDocumentCountEntry();
            notesDocumentCountEntry.setCategoryUuid(str);
        } else if (notesDocumentCountEntry.getDocumentCount() == i) {
            return false;
        }
        notesDocumentCountEntry.setDocumentCount(i);
        this.mCoeditCountMap.put(str, notesDocumentCountEntry);
        this.mDocumentCountMap.putAll(this.mCoeditCountMap);
        return true;
    }

    public void updateDrawerData(DocumentCategoryTree documentCategoryTree) {
        MainLogger.m7258i(TAG, "updateDrawerData# size " + documentCategoryTree.getFolderCount());
        if (isInitFolderMapNeed()) {
            return;
        }
        Map<String, NotesFolder> folderMap = documentCategoryTree.getFolderMap();
        for (FilterType filterType : FilterType.values()) {
            NotesFolder notesFolder = this.mFolderDataMap.get(filterType.uuid);
            if (notesFolder != null) {
                folderMap.put(filterType.uuid, notesFolder);
            }
        }
        for (NotesFolder notesFolder2 : folderMap.values()) {
            NotesFolder notesFolder3 = this.mFolderDataMap.get(notesFolder2.getUuid());
            if (notesFolder3 != null && notesFolder3.getViewType() <= 3) {
                notesFolder2.setExpanded(notesFolder3.isExpanded());
                notesFolder2.setViewType(notesFolder3.getViewType());
                notesFolder2.setId(notesFolder3.getId());
            }
        }
        this.mFolderDataMap.clear();
        this.mFolderDataMap.putAll(DataManager.getInstance().drawerOrdering(folderMap));
        initDrawerDisplayDataList();
    }

    public void updateFilterDrawer(Map<String, NotesDocumentCountEntry> map) {
        if (isInitFolderMapNeed()) {
            return;
        }
        if (this.mDrawerDisplayDataList == null) {
            initDrawerDisplayDataList();
        }
        MainLogger.m7254d(TAG, "updateFilterDrawer");
        List<NotesFolder> listInitFilterDrawerDisplayList = initFilterDrawerDisplayList();
        addDrawerDisplayList(this.mFolderDataMap.get("settings:///"));
        updateFilterPreDefineDrawerDisplayList(map);
        this.mDrawerDisplayDataList.addAll(listInitFilterDrawerDisplayList);
        updateFolderInfoPreference(map);
    }

    public void updateFilterPreDefineDrawerDisplayList(Map<String, NotesDocumentCountEntry> map) {
        addDrawerDisplayList(this.mFolderDataMap.get(FolderConstants.AllNotes.UUID));
        updateOldNoteFilter(map);
        updateFilter(map, getFavoriteItemCount(), "favorite:///", FolderConstants.Favorite.DISPLAY_NAME, "favorite:///", 1004, -3L);
        updateFilter(map, getAllLockedNoteCount(), "lock:///", FolderConstants.Lock.DISPLAY_NAME, "lock:///", 1005, -5L);
        this.mDrawerDisplayDataList.addAll(DataManager.getInstance().getSmartFilter(this.mFolderDataMap, this.mDocumentCountMap, map));
        addDrawerDisplayList(this.mFolderDataMap.get(FolderConstants.SharedNotes.UUID));
        addDrawerDisplayList(this.mFolderDataMap.get(FolderConstants.Coedit.UUID));
    }

    public void updateFolderData(NotesFolder notesFolder) {
        int iIndexOfDrawerDisplayData;
        if (isInitFolderMapNeed()) {
            MainLogger.m7254d(TAG, "updateFolderData not init");
            return;
        }
        NotesFolder notesFolder2 = this.mFolderDataMap.get(notesFolder.getUuid());
        if (notesFolder2 == null) {
            return;
        }
        MainLogger.m7258i(TAG, "updateFolderData# folderName : " + MainLogger.getEncode(notesFolder.getDisplayName()));
        this.mFolderDataMap.put(notesFolder2.getUuid(), notesFolder);
        if (this.mDrawerDisplayDataList == null || (iIndexOfDrawerDisplayData = indexOfDrawerDisplayData(notesFolder2.getUuid())) <= -1) {
            return;
        }
        this.mDrawerDisplayDataList.remove(iIndexOfDrawerDisplayData);
        this.mDrawerDisplayDataList.add(iIndexOfDrawerDisplayData, notesFolder);
    }

    public void updateFolderInfoPreference(Map<String, NotesDocumentCountEntry> map) {
        String[] strArr = {FolderConstants.OldNotes.UUID, "favorite:///", "lock:///", "recentlyImported:///"};
        boolean z = false;
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (!map.containsKey(str)) {
                SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).remove(str);
            }
        }
        List<NotesFolder> childFolderListWithoutIgnoreFolder = getChildFolderListWithoutIgnoreFolder(FolderConstants.MyFolders.UUID);
        if (childFolderListWithoutIgnoreFolder != null && !childFolderListWithoutIgnoreFolder.isEmpty()) {
            z = true;
        }
        SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).putBoolean(FolderConstants.PREF_MYFOLDERS_HAS_CHILD, z);
        for (NotesFolder notesFolder : this.mDrawerDisplayDataList) {
            if (notesFolder != null) {
                setPrefFolderDocumentCount(notesFolder, map.get(notesFolder.getUuid()));
            }
        }
    }

    public void updateGcsDoucumentMap() {
        if (isInitFolderMapNeed() || NotesUtils.getPreferenceMDESupported()) {
            return;
        }
        Map<String, NotesFolder> map = this.mFolderDataMap;
        String str = FolderConstants.SharedNotes.UUID;
        NotesFolder notesFolder = map.get(str);
        if (this.mDrawerDisplayDataList != null) {
            this.mFolderDataMap.remove(str);
            this.mDocumentCountMap.remove(str);
            this.mDrawerDisplayDataList.remove(notesFolder);
        }
    }

    private void updateFilter(Map<String, NotesDocumentCountEntry> map, boolean z, int i, String str, String str2, String str3, int i2, long j) {
        NotesFolder notesFolder = this.mFolderDataMap.get(str);
        NotesDocumentCountEntry notesDocumentCountEntry = this.mDocumentCountMap.get(str);
        StringBuilder sbM780v = AbstractC0541b.m780v("updateFilter# name : ", i, str2, ", count : ", ", isFilterNeed : ");
        sbM780v.append(z);
        MainLogger.m7258i(TAG, sbM780v.toString());
        if (z) {
            if (notesFolder == null) {
                notesFolder = new NotesFolder(str, null, str2, str3);
                notesFolder.setViewType(i2);
                notesFolder.setId(j);
                this.mFolderDataMap.put(str, notesFolder);
            }
            if (notesDocumentCountEntry == null) {
                notesDocumentCountEntry = new NotesDocumentCountEntry();
                notesDocumentCountEntry.setCategoryUuid(str);
            }
            notesDocumentCountEntry.setDocumentCount(i);
            this.mDrawerDisplayDataList.add(notesFolder);
        } else if (notesDocumentCountEntry != null) {
            this.mFolderDataMap.remove(str);
            this.mDocumentCountMap.remove(str);
            notesDocumentCountEntry = null;
        }
        if (notesDocumentCountEntry != null) {
            map.put(str, notesDocumentCountEntry);
        }
    }

    public void enqueueWaitedObservedMap(DocumentCategoryTree documentCategoryTree) {
        this.mWaitedObservedMap.enqueueWaitedObservedMap(documentCategoryTree);
    }

    public void enqueueWaitedObservedMap(List<CoeditMainListEntry> list) {
        this.mWaitedObservedMap.enqueueWaitedObservedMap(list);
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
}
