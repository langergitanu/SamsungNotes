package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationListResult;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.data.SearchUseCaseManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMapContract;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchParam;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.model.domain.search.SearchNoteUseCase;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NoteMap implements DocumentMapContract.Coedit {
    private static final String TAG = "NoteMap";
    private Map<String, MainListDocumentData> mConvertedNoteDataMap;
    private final DocumentMapContract.Note mDocMapContract;
    private Map<String, NotesDocumentCountEntry> mDocumentCountMap;
    private Map<String, MainListDocumentData> mOldNoteDataMap;
    private final StateInfo mStateInfo;
    private final Map<String, MainListDocumentData> mNoteDataMap = new LinkedHashMap();
    private final CoeditSpaceMap mCoeditSpaceMap = new CoeditSpaceMap(this);

    public NoteMap(StateInfo stateInfo, DocumentMapContract.Note note) {
        this.mStateInfo = stateInfo;
        this.mDocMapContract = note;
    }

    private void addSearchDivider(List<Common> list) {
        putHolderInfoMap(7, true);
        list.add(new Common.SubHeader(-30L));
    }

    private void addSearchFooter(List<Common> list) {
        if (list.isEmpty()) {
            putHolderInfoMap(8, false);
        } else {
            putHolderInfoMap(8, true);
            list.add(new Common.SubHeader(-31L));
        }
    }

    private void addTimeSubHeader(int i, List<Common> list) {
        if (i == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        boolean zIsPinFavorites = NotesUtils.isPinFavorites();
        for (Common common : list) {
            if (zIsPinFavorites && common.isFavorite == 1) {
                arrayList.add(new Common.SubHeader(-29L));
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setFirstDayOfWeek(2);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(common.time);
                calendar2.setFirstDayOfWeek(2);
                long timeCategory = getTimeCategory(calendar, calendar2);
                if (timeCategory == -27) {
                    arrayList.add(new Common.SubHeader(timeCategory, calendar2.get(2)));
                } else if (timeCategory == -28) {
                    arrayList.add(new Common.SubHeader(timeCategory, calendar2.get(1)));
                } else {
                    arrayList.add(new Common.SubHeader(timeCategory));
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Common common2 = (Common) arrayList.get(size);
            if (size == 0 || isDiffentType(common2, (Common) arrayList.get(size - 1))) {
                putHolderInfoMap(6, true);
                list.add(size, common2);
            }
        }
    }

    private long determineDeviceTime(int i, MainListDocumentData mainListDocumentData) {
        return i == 1 ? mainListDocumentData.getCreatedAt() : mainListDocumentData.getLastModifiedAt();
    }

    private List<Common> getAllNotesList() {
        ArrayList arrayList = new ArrayList();
        int sortType = NotesUtils.getSortType();
        for (MainListDocumentData mainListDocumentData : this.mNoteDataMap.values()) {
            if (!FolderConstants.Coedit.UUID.equals(mainListDocumentData.getCategoryUuid())) {
                arrayList.add(new Common.Note(mainListDocumentData, determineDeviceTime(sortType, mainListDocumentData)));
            }
        }
        addTimeSubHeader(sortType, arrayList);
        MainLogger.m7258i(TAG, "getAllNotesList# note size : " + arrayList.size());
        return arrayList;
    }

    private List<Common> getCoeditCommonDisplayList() {
        ArrayList arrayList = new ArrayList();
        this.mCoeditSpaceMap.initCoeditDisplayData(this.mNoteDataMap, arrayList);
        return arrayList;
    }

    private List<Common> getCoeditSpaceModeCommonDisplayList(String str) {
        ArrayList arrayList = new ArrayList();
        this.mCoeditSpaceMap.initCoeditSpaceModeDisplayData(this.mNoteDataMap, arrayList, str);
        return arrayList;
    }

    private List<Common> getFilterFolderTypeCommonDisplayList() {
        ArrayList arrayList = new ArrayList();
        if (this.mNoteDataMap.isEmpty()) {
            MainLogger.m7254d(TAG, "getFilterFolderTypeCommonDisplayList# NoteDataMap is empty");
            return arrayList;
        }
        String folderUuid = this.mStateInfo.getFolderUuid();
        int sortType = NotesUtils.getSortType();
        if ("favorite:///".equals(folderUuid)) {
            for (MainListDocumentData mainListDocumentData : this.mNoteDataMap.values()) {
                if (mainListDocumentData.getIsFavorite() == 1) {
                    arrayList.add(new Common.Note(mainListDocumentData, determineDeviceTime(sortType, mainListDocumentData)));
                }
            }
            addTimeSubHeader(sortType, arrayList);
        } else if ("lock:///".equals(folderUuid)) {
            for (MainListDocumentData mainListDocumentData2 : this.mNoteDataMap.values()) {
                if (!LockUtils.isUnLockedDocType(mainListDocumentData2.getIsLock())) {
                    arrayList.add(new Common.Note(mainListDocumentData2, determineDeviceTime(sortType, mainListDocumentData2)));
                }
            }
            addTimeSubHeader(sortType, arrayList);
        } else if ("recentlyImported:///".equals(folderUuid)) {
            for (MainListDocumentData mainListDocumentData3 : DataManager.getInstance().getRecentlyImportedEntry()) {
                arrayList.add(new Common.Note(mainListDocumentData3, determineDeviceTime(sortType, mainListDocumentData3)));
            }
        }
        MainLogger.m7258i(TAG, "getFilterFolderTypeCommonDisplayList# note size : " + arrayList.size());
        return arrayList;
    }

    private List<Common> getGcsSpaceModeCommonDisplayList() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (MainListDocumentData mainListDocumentData : this.mNoteDataMap.values()) {
            if (mainListDocumentData.isSDoc()) {
                arrayList2.add(new Common.Note(mainListDocumentData));
            } else {
                arrayList3.add(new Common.Note(mainListDocumentData));
            }
        }
        if (!arrayList3.isEmpty()) {
            if (!arrayList2.isEmpty()) {
                arrayList.add(new Common.SubHeader(-15L));
                this.mDocMapContract.putHolderInfoMap(4, true);
            }
            MainLogger.m7258i(TAG, "getGcsSpaceModeCommonDisplayList# note size : " + arrayList3.size());
            arrayList.addAll(arrayList3);
        }
        if (!arrayList2.isEmpty()) {
            if (!arrayList3.isEmpty()) {
                arrayList.add(new Common.SubHeader(-14L));
                this.mDocMapContract.putHolderInfoMap(3, true);
            }
            MainLogger.m7258i(TAG, "getGcsSpaceModeCommonDisplayList# old note size : " + arrayList2.size());
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    private List<Common> getHashTagModeCommonDisplayList() {
        ArrayList arrayList = new ArrayList();
        Iterator<MainListDocumentData> it = this.mNoteDataMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(new Common.Note(it.next()));
        }
        MainLogger.m7258i(TAG, "getHashTagModeCommonDisplayList# note size : " + arrayList.size());
        return arrayList;
    }

    private List<Common> getPickModeCommonDisplayList() {
        int caller = this.mStateInfo.getCaller();
        String folderUuid = this.mStateInfo.getFolderUuid();
        ArrayList arrayList = new ArrayList();
        if (!CommonUtil.initSpenSdk(BaseUtils.getApplicationContext())) {
            return arrayList;
        }
        int sortType = NotesUtils.getSortType();
        for (MainListDocumentData mainListDocumentData : this.mNoteDataMap.values()) {
            if (!NotesUtils.needToHidePickDisplayData(caller, folderUuid, mainListDocumentData)) {
                arrayList.add(new Common.Note(mainListDocumentData, determineDeviceTime(sortType, mainListDocumentData)));
            }
        }
        addTimeSubHeader(sortType, arrayList);
        MainLogger.m7258i(TAG, "getPickModeCommonDisplayList# note size : " + arrayList.size());
        return arrayList;
    }

    private List<Common> getRecycleBinNotesList() {
        ArrayList arrayList = new ArrayList();
        for (MainListDocumentData mainListDocumentData : this.mNoteDataMap.values()) {
            if (FolderConstants.RecycleBin.UUID.equals(mainListDocumentData.getCategoryUuid())) {
                arrayList.add(new Common.Note(mainListDocumentData));
            }
        }
        MainLogger.m7258i(TAG, "getRecycleBinNotesList# note size : " + arrayList.size());
        return arrayList;
    }

    private List<Common> getSearchModeCommonDisplayList() {
        int caller = this.mStateInfo.getCaller();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, MainListDocumentData> entry : this.mNoteDataMap.entrySet()) {
            String key = entry.getKey();
            MainListDocumentData value = entry.getValue();
            if (!FeatureUtils.needToHideDisplayData(caller, value)) {
                if (key.equals(NotesConstants.KEY_SEARCH_DIVIDER)) {
                    addSearchDivider(arrayList);
                } else {
                    arrayList.add(new Common.Note(value));
                }
            }
        }
        addSearchFooter(arrayList);
        return arrayList;
    }

    public static long getTimeCategory(Calendar calendar, Calendar calendar2) {
        if (isSameDay(calendar2, calendar)) {
            return -24L;
        }
        if (calendar2.get(1) == calendar.get(1) && calendar2.get(3) == calendar.get(3)) {
            return -25L;
        }
        if (calendar2.get(1) == calendar.get(1) && calendar2.get(2) == calendar.get(2)) {
            return -26L;
        }
        if (calendar2.get(1) != calendar.get(1) || calendar2.get(2) >= calendar.get(2)) {
            return calendar2.get(1) < calendar.get(1) ? -28L : -23L;
        }
        return -27L;
    }

    private List<Common> getUserFolderNotesList(String str) {
        ArrayList arrayList = new ArrayList();
        int sortType = NotesUtils.getSortType();
        for (MainListDocumentData mainListDocumentData : this.mNoteDataMap.values()) {
            if (mainListDocumentData != null && !FolderConstants.Coedit.UUID.equals(mainListDocumentData.getCategoryUuid()) && mainListDocumentData.getCategoryUuid().equals(str)) {
                arrayList.add(new Common.Note(mainListDocumentData, determineDeviceTime(sortType, mainListDocumentData)));
            }
        }
        addTimeSubHeader(sortType, arrayList);
        StringBuilder sbM15l = AbstractC0000a.m15l("getUserFolderNotesList# folderUuid : ", str, ", note size : ");
        sbM15l.append(arrayList.size());
        MainLogger.m7258i(TAG, sbM15l.toString());
        return arrayList;
    }

    private boolean isDiffentType(Common common, Common common2) {
        long j = common.f6179id;
        if (j != common2.f6179id) {
            return true;
        }
        return (j == -27 || j == -28 || j == -29) && common.time != common2.time;
    }

    private static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    private void removeSearchDivider() {
        putHolderInfoMap(7, false);
    }

    public void addNoteMap(List<Common> list, String str) {
        if (this.mStateInfo.isOldMode()) {
            this.mDocMapContract.initOldCommonDisplayData("old_converted_notes".equals(this.mStateInfo.getCategoryUuid()));
            return;
        }
        if (this.mStateInfo.isSearchMode()) {
            list.addAll(getSearchModeCommonDisplayList());
            return;
        }
        if (this.mStateInfo.isPickMode()) {
            list.addAll(getPickModeCommonDisplayList());
            return;
        }
        if (this.mStateInfo.isGcsSpaceMode()) {
            list.addAll(getGcsSpaceModeCommonDisplayList());
            return;
        }
        if (this.mStateInfo.isCoeditMode()) {
            list.addAll(getCoeditCommonDisplayList());
            return;
        }
        if (this.mStateInfo.isCoeditSpaceMode()) {
            list.addAll(getCoeditSpaceModeCommonDisplayList(this.mStateInfo.getSpaceId()));
            return;
        }
        if (this.mStateInfo.isHashTagMode()) {
            list.addAll(getHashTagModeCommonDisplayList());
            return;
        }
        if (FolderConstants.AllNotes.UUID.equals(str)) {
            list.addAll(getAllNotesList());
            return;
        }
        if (FeatureUtils.isFilterFolderType(str)) {
            list.addAll(getFilterFolderTypeCommonDisplayList());
        } else if (FolderConstants.RecycleBin.UUID.equals(str)) {
            list.addAll(getRecycleBinNotesList());
        } else {
            list.addAll(getUserFolderNotesList(str));
        }
    }

    public void addOldNoteMap(List<Common> list, boolean z, String str) {
        if (this.mOldNoteDataMap == null) {
            this.mOldNoteDataMap = new LinkedHashMap();
        }
        if (this.mConvertedNoteDataMap == null) {
            this.mConvertedNoteDataMap = new LinkedHashMap();
        }
        this.mNoteDataMap.clear();
        this.mNoteDataMap.putAll(z ? this.mConvertedNoteDataMap : this.mOldNoteDataMap);
        if (z) {
            Iterator<MainListDocumentData> it = this.mConvertedNoteDataMap.values().iterator();
            while (it.hasNext()) {
                list.add(new Common.Note(it.next()));
            }
            MainLogger.m7258i(TAG, "addOldNoteMap# converted note size : " + this.mConvertedNoteDataMap.size());
            return;
        }
        for (MainListDocumentData mainListDocumentData : this.mOldNoteDataMap.values()) {
            if (mainListDocumentData.getCategoryUuid().equals(str)) {
                list.add(new Common.Note(mainListDocumentData));
            }
        }
        MainLogger.m7258i(TAG, "addOldNoteMap# old note size : " + this.mOldNoteDataMap.size());
    }

    public Set<Map.Entry<String, MainListDocumentData>> entrySet() {
        return this.mNoteDataMap.entrySet();
    }

    @Nullable
    public MainListDocumentData get(String str) {
        return this.mNoteDataMap.get(str);
    }

    public List<Common> getCoeditInvitationDisplayData() {
        ArrayList arrayList = new ArrayList();
        this.mCoeditSpaceMap.initCoeditInvitationDisplayData(arrayList);
        return arrayList;
    }

    @Nullable
    public CoeditMainListEntry getCoeditNote(String str) {
        return this.mCoeditSpaceMap.getNote(str);
    }

    public List<Common> getCoeditSpaceDisplayData() {
        ArrayList arrayList = new ArrayList();
        this.mCoeditSpaceMap.initCoeditSpaceDisplayData(arrayList);
        return arrayList;
    }

    public int getDocumentCount(String str) {
        Map<String, NotesDocumentCountEntry> map = this.mDocumentCountMap;
        if (map == null) {
            return 0;
        }
        NotesDocumentCountEntry notesDocumentCountEntry = map.get(str);
        int documentCount = notesDocumentCountEntry != null ? notesDocumentCountEntry.getDocumentCount() : 0;
        MainLogger.m7258i(TAG, "getDocumentCount# folderUuid : " + str + ", document count : " + documentCount);
        return documentCount;
    }

    public int getInvitationCount() {
        return this.mCoeditSpaceMap.getInvitationDisplayListSize();
    }

    public Map<String, MainListDocumentData> getMap() {
        return this.mNoteDataMap;
    }

    public int getNoteCount() {
        return this.mNoteDataMap.size();
    }

    public List<Common> getSearchDisplayListAsMode(int i) {
        return FeatureUtils.isPickMode(i) ? getPickModeCommonDisplayList() : getSearchModeCommonDisplayList();
    }

    public int getSpaceCount() {
        return this.mCoeditSpaceMap.getSpaceDisplayList().size();
    }

    public void initCoeditInvitationMap(List<GroupInvitationListResult.GroupInvitation> list) {
        this.mCoeditSpaceMap.initCoeditInvitationMap(list);
    }

    public void initCoeditMap(List<CoeditMainListEntry> list) {
        this.mCoeditSpaceMap.initCoeditMap(list);
    }

    public boolean initConvertedNoteMap(List<MainListDocumentData> list) {
        if (list == null) {
            MainLogger.m7259w(TAG, "initConvertedNoteMap# list is null");
            return false;
        }
        MainLogger.m7258i(TAG, "initConvertedNoteMap# list : " + list.size());
        if (this.mConvertedNoteDataMap == null) {
            this.mConvertedNoteDataMap = new LinkedHashMap();
        }
        this.mConvertedNoteDataMap.clear();
        for (MainListDocumentData mainListDocumentData : list) {
            this.mConvertedNoteDataMap.put(mainListDocumentData.getUuid(), mainListDocumentData);
        }
        return this.mDocMapContract.initOldCommonDisplayData(true);
    }

    public void initNoteMap(@Nullable List<MainListDocumentData> list) {
        MainLogger.m7254d(TAG, "initNoteMap# modeIndex : " + this.mStateInfo.getModeIndex());
        this.mNoteDataMap.clear();
        if (list == null) {
            MainLogger.m7255e(TAG, "initNoteMap# data list is null");
            return;
        }
        for (MainListDocumentData mainListDocumentData : list) {
            this.mNoteDataMap.put(mainListDocumentData.getUuid(), mainListDocumentData);
        }
        MainLogger.m7258i(TAG, "initNoteMap# NoteDataMap : " + this.mNoteDataMap.size());
    }

    public boolean initNoteMapWithoutFolder(List<MainListDocumentData> list) {
        if (list == null) {
            MainLogger.m7259w(TAG, "initNoteMapWithoutFolder# list is null");
            return false;
        }
        MainLogger.m7258i(TAG, "initNoteMapWithoutFolder# size : " + list.size() + ", modeIndex : " + this.mStateInfo.getModeIndex());
        this.mNoteDataMap.clear();
        for (MainListDocumentData mainListDocumentData : list) {
            this.mNoteDataMap.put(mainListDocumentData.getUuid(), mainListDocumentData);
        }
        return this.mDocMapContract.initCommonDisplayList();
    }

    public boolean initOldNoteMap(List<MainListDocumentData> list) {
        if (list == null) {
            MainLogger.m7259w(TAG, "initOldNoteMap# list is null");
            return false;
        }
        MainLogger.m7258i(TAG, "initOldNoteMap# list : " + list.size());
        if (this.mOldNoteDataMap == null) {
            this.mOldNoteDataMap = new LinkedHashMap();
        }
        this.mOldNoteDataMap.clear();
        for (MainListDocumentData mainListDocumentData : list) {
            this.mOldNoteDataMap.put(mainListDocumentData.getUuid(), mainListDocumentData);
        }
        return this.mDocMapContract.initOldCommonDisplayData(false);
    }

    public void initSearchMap(List<MainListDocumentData> list, List<MainListDocumentData> list2) {
        if (list == null) {
            MainLogger.m7259w(TAG, "initSearchMap# notesBasedKeywordList is null");
            return;
        }
        MainLogger.m7258i(TAG, "initSearchMap# notesBasedKeywordList.size : " + list.size() + ", notesRelatedKeywordList.size : " + list2.size() + ", modeIndex : " + this.mStateInfo.getModeIndex());
        this.mNoteDataMap.clear();
        for (MainListDocumentData mainListDocumentData : list) {
            this.mNoteDataMap.put(mainListDocumentData.getUuid(), mainListDocumentData);
        }
        if (list2.isEmpty()) {
            removeSearchDivider();
            return;
        }
        this.mNoteDataMap.put(NotesConstants.KEY_SEARCH_DIVIDER, null);
        for (MainListDocumentData mainListDocumentData2 : list2) {
            this.mNoteDataMap.put(mainListDocumentData2.getUuid(), mainListDocumentData2);
        }
    }

    public boolean nonNullDocumentCountMap() {
        return this.mDocumentCountMap != null;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.model.DocumentMapContract.Coedit
    public void putHolderInfoMap(int i, boolean z) {
        this.mDocMapContract.putHolderInfoMap(i, z);
    }

    public boolean removeCoeditInvitationMap(String str) {
        return this.mCoeditSpaceMap.removeCoeditInvitationMap(str);
    }

    public List<MainListDocumentData> restoreNoteMap() {
        int modeIndex = this.mStateInfo.getModeIndex();
        if (modeIndex == 3 || modeIndex == 4) {
            if (!TextUtils.isEmpty(this.mStateInfo.getSearchCoverData())) {
                return DataManager.getInstance().getAllWithCover(this.mStateInfo.getSearchCoverData());
            }
            SearchNoteUseCase searchNoteUseCaseCreateSearchNoteUseCase = SearchUseCaseManager.getInstance().createSearchNoteUseCase();
            if (searchNoteUseCaseCreateSearchNoteUseCase != null) {
                return searchNoteUseCaseCreateSearchNoteUseCase.invoke(new SearchParam(this.mStateInfo.getSavedSearchText()).setSortParam(NotesUtils.getSortParam())).getTotalNotes();
            }
            return null;
        }
        if (modeIndex == 5 || modeIndex == 6) {
            return DataManager.getInstance().getAllRecycleBinDataList();
        }
        if (modeIndex != 26) {
            switch (modeIndex) {
                case 9:
                    break;
                case 10:
                case 11:
                    return DataManager.getInstance().getAllContentShare(this.mStateInfo.getSpaceId());
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 21:
                case 22:
                    return null;
                case 18:
                case 19:
                case 20:
                    return this.mStateInfo.getSelectedTags().isEmpty() ? DataManager.getInstance().getAllWithTag() : DataManager.getInstance().getAllByTagNormalizedNames(this.mStateInfo.getSelectedTags());
                default:
                    return DataManager.getInstance().getAll();
            }
        }
        SearchNoteUseCase searchNoteUseCaseCreateSearchNoteUseCase2 = SearchUseCaseManager.getInstance().createSearchNoteUseCase();
        if (searchNoteUseCaseCreateSearchNoteUseCase2 != null) {
            return searchNoteUseCaseCreateSearchNoteUseCase2.invoke(new SearchParam(this.mStateInfo.getSavedSearchText()).setSortParam(NotesUtils.getSortParam())).getTotalNotes();
        }
        return null;
    }

    public void restoreOldNoteMap() {
        if ("old_converted_notes".equals(this.mStateInfo.getCategoryUuid())) {
            initConvertedNoteMap(DataManager.getInstance().getAll_Converted());
        } else {
            initOldNoteMap(DataManager.getInstance().getAll_OldNotes());
        }
    }

    public void updateDocumentCountMap(Map<String, NotesDocumentCountEntry> map) {
        this.mDocumentCountMap = map;
    }

    public Collection<MainListDocumentData> values() {
        return this.mNoteDataMap.values();
    }
}
