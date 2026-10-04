package com.samsung.android.support.senl.p148nt.app.main.common.data;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.data.RepositoryManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.smartfilter.SmartFilterController;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.NotesSQLiteConstraintException;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesOrganizedDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.repository.converted.NotesConvertedDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesLockDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesOldDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesOrganizedDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.tag.NotesTagRepository;
import com.samsung.android.support.senl.p148nt.model.domain.folder.AddFolderUseCase;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DataManager {
    private static final String TAG = "DataManager";
    private static DataManager mInstance;
    private Map<String, NotesFolder> mFolderDataMap;
    private SmartFilterController mSmartFilter;

    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void addNotesFolder(Map<String, NotesFolder> map, Map<String, NotesFolder> map2, String str, String str2, long j, int i, String str3) {
        NotesFolder notesFolder = map.get(str);
        boolean zIsOldNotesFolderNeed = false;
        boolean zIsOldNotesFolderNeed2 = true;
        if (notesFolder != null) {
            StringBuilder sbM15l = AbstractC0000a.m15l("addNotesFolder# already has ", str2, ", hasChild : ");
            sbM15l.append(notesFolder.hasChild());
            sbM15l.append(", isExpanded : ");
            sbM15l.append(notesFolder.isExpanded());
            MainLogger.m7258i(TAG, sbM15l.toString());
            if (i == 1009) {
                zIsOldNotesFolderNeed2 = true ^ FloatingFeature.INSTANCE.getInstance().isDisableRecycleBinModel();
            } else if (i == 1003) {
                zIsOldNotesFolderNeed2 = isOldNotesFolderNeed();
            } else if (i == 3) {
                if (notesFolder.hasChild() && notesFolder.isExpanded()) {
                    zIsOldNotesFolderNeed = true;
                }
                notesFolder.setExpanded(zIsOldNotesFolderNeed);
            } else if (i == 1005) {
                if (getAllLockedDataCount() > 0) {
                    zIsOldNotesFolderNeed = true;
                }
                zIsOldNotesFolderNeed2 = zIsOldNotesFolderNeed;
            } else if (i == 1004) {
                if (getFavoriteItemCount() > 0) {
                }
                zIsOldNotesFolderNeed2 = zIsOldNotesFolderNeed;
            }
            notesFolder.setViewType(i);
            notesFolder.setId(j);
            map.remove(str);
            if (!zIsOldNotesFolderNeed2) {
                MainLogger.m7258i(TAG, "addNotesFolder# already has " + str2 + " remove");
                return;
            }
        } else {
            boolean zHasBaseLogic = PostLaunchManager.getInstance().hasBaseLogic(2);
            MainLogger.m7258i(TAG, "addNotesFolder# appLaunching : " + zHasBaseLogic + ", viewType : " + i);
            if (i != 1) {
                if (i != 2) {
                    switch (i) {
                        case 1003:
                            zIsOldNotesFolderNeed = isOldNotesFolderNeed();
                            break;
                        case 1004:
                            if (!zHasBaseLogic) {
                                if (getFavoriteItemCount() > 0) {
                                    zIsOldNotesFolderNeed = true;
                                }
                            } else if (SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt("favorite:///", 0) > 0) {
                                zIsOldNotesFolderNeed = true;
                            }
                            break;
                        case 1005:
                            if (!zHasBaseLogic) {
                                if (getAllLockedDataCount() > 0) {
                                    zIsOldNotesFolderNeed = true;
                                }
                            } else if (SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt("lock:///", 0) > 0) {
                                zIsOldNotesFolderNeed = true;
                            }
                            break;
                        case 1006:
                            if (!zHasBaseLogic) {
                                if (getRecentlyImportedCount() > 0) {
                                    zIsOldNotesFolderNeed = true;
                                }
                            } else if (SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt("recentlyImported:///", 0) > 0) {
                                zIsOldNotesFolderNeed = true;
                            }
                            break;
                        case 1007:
                            if (!zHasBaseLogic) {
                                if (!DeviceUtils.isPowerManageMode(BaseUtils.getApplicationContext()) && !NotesUtils.isCoeditFeatureEnabled(BaseUtils.getApplicationContext()) && NotesUtils.getPreferenceMDESupported()) {
                                    zIsOldNotesFolderNeed = true;
                                }
                            } else if (SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt(FolderConstants.SharedNotes.UUID, 0) > 0) {
                                zIsOldNotesFolderNeed = true;
                            }
                            break;
                        case 1008:
                            if (!zHasBaseLogic) {
                                if (!DeviceUtils.isPowerManageMode(BaseUtils.getApplicationContext()) && NotesUtils.isCoeditFeatureEnabled(BaseUtils.getApplicationContext())) {
                                    zIsOldNotesFolderNeed = true;
                                }
                            } else if (SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt(FolderConstants.Coedit.UUID, -1) >= 0) {
                                zIsOldNotesFolderNeed = true;
                            } else if (!DeviceUtils.isPowerManageMode(BaseUtils.getApplicationContext()) && NotesUtils.isCoeditFeatureEnabled(BaseUtils.getApplicationContext())) {
                                zIsOldNotesFolderNeed = true;
                            }
                            break;
                        case 1009:
                            if (!FloatingFeature.INSTANCE.getInstance().isDisableRecycleBinModel()) {
                                zIsOldNotesFolderNeed = true;
                            }
                            break;
                        default:
                            zIsOldNotesFolderNeed = true;
                            break;
                    }
                } else if (map.get(FolderConstants.MathNotes.UUID) != null) {
                    zIsOldNotesFolderNeed = true;
                }
            } else if (map.get(FolderConstants.ScreenOffMemo.UUID) != null) {
                zIsOldNotesFolderNeed = true;
            }
            if (!zIsOldNotesFolderNeed) {
                AbstractC8014b.m7209k("addNotesFolder# folder isn't needed : ", str2, TAG);
                return;
            }
            notesFolder = new NotesFolder(str, null, str2, str3);
            if (3 == i) {
                notesFolder.setExpanded(notesFolder.hasChild());
            }
            notesFolder.setViewType(i);
            notesFolder.setId(j);
        }
        map2.put(str, notesFolder);
    }

    @Nullable
    private List<NotesFolder> getFolderChildren(String str, Map<String, NotesFolder> map) {
        if (map == null) {
            return null;
        }
        if (str == null) {
            str = FolderConstants.MyFolders.UUID;
        }
        NotesFolder notesFolder = map.get(str);
        if (notesFolder == null) {
            return null;
        }
        return notesFolder.getChildren();
    }

    public static DataManager getInstance() {
        synchronized (DataManager.class) {
            try {
                if (mInstance == null) {
                    mInstance = new DataManager();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mInstance;
    }

    public static int getMaximumFolderDepth(NotesFolder notesFolder) {
        int depth = notesFolder.getDepth();
        Iterator<NotesFolder> it = notesFolder.getChildren().iterator();
        while (it.hasNext()) {
            depth = Math.max(depth, getMaximumFolderDepth(it.next()));
        }
        return depth;
    }

    private SmartFilterController getSmartFilterController() {
        if (this.mSmartFilter == null) {
            this.mSmartFilter = new SmartFilterController();
        }
        return this.mSmartFilter;
    }

    private void initFolderMap(DocumentCategoryTree documentCategoryTree) {
        MainLogger.m7258i(TAG, "initFolderMap# size : " + documentCategoryTree.getFolderCount());
        this.mFolderDataMap = new LinkedHashMap(new LinkedHashMap(drawerOrdering(documentCategoryTree.getFolderMap())));
    }

    public void destroySmartFilter() {
        SmartFilterController smartFilterController = this.mSmartFilter;
        if (smartFilterController == null) {
            return;
        }
        smartFilterController.inactivate();
    }

    public Map<String, NotesFolder> drawerOrdering(Map<String, NotesFolder> map) {
        MainLogger.m7258i(TAG, "drawerOrdering");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        addNotesFolder(map, linkedHashMap, "settings:///", "Settings", -9L, 1001, null);
        addNotesFolder(map, linkedHashMap, FolderConstants.AllNotes.UUID, FolderConstants.AllNotes.DISPLAY_NAME, -1L, 1002, null);
        addNotesFolder(map, linkedHashMap, FolderConstants.OldNotes.UUID, FolderConstants.OldNotes.DISPLAY_NAME, -2L, 1003, null);
        addNotesFolder(map, linkedHashMap, "favorite:///", FolderConstants.Favorite.DISPLAY_NAME, -3L, 1004, null);
        addNotesFolder(map, linkedHashMap, "lock:///", FolderConstants.Lock.DISPLAY_NAME, -5L, 1005, null);
        addNotesFolder(map, linkedHashMap, "recentlyImported:///", FolderConstants.RecentlyImported.DISPLAY_NAME, -6L, 1006, null);
        addNotesFolder(map, linkedHashMap, FolderConstants.SharedNotes.UUID, FolderConstants.SharedNotes.DISPLAY_NAME, -18L, 1007, FolderConstants.SharedNotes.PATH);
        addNotesFolder(map, linkedHashMap, FolderConstants.Coedit.UUID, FolderConstants.Coedit.DISPLAY_NAME, -8L, 1008, FolderConstants.Coedit.PATH);
        addNotesFolder(map, linkedHashMap, FolderConstants.RecycleBin.UUID, FolderConstants.RecycleBin.DISPLAY_NAME, -7L, 1009, FolderConstants.RecycleBin.PATH);
        addNotesFolder(map, linkedHashMap, "divider:///", FolderConstants.Divider.DISPLAY_NAME, -10L, 1010, null);
        addNotesFolder(map, linkedHashMap, FolderConstants.MyFolders.UUID, FolderConstants.MyFolders.DISPLAY_NAME, -4L, 3, null);
        addNotesFolder(map, linkedHashMap, FolderConstants.ScreenOffMemo.UUID, FolderConstants.ScreenOffMemo.DISPLAY_NAME, -13L, 1, null);
        addNotesFolder(map, linkedHashMap, FolderConstants.MathNotes.UUID, FolderConstants.MathNotes.DISPLAY_NAME, -19L, 2, null);
        addNotesFolder(map, linkedHashMap, "folderManage:///", FolderConstants.FolderManage.DISPLAY_NAME, -11L, 5, null);
        linkedHashMap.putAll(map);
        return linkedHashMap;
    }

    @Nullable
    public List<MainListDocumentData> getAll() {
        return getAll(NotesUtils.getSortParam());
    }

    @Nullable
    public List<MainListDocumentData> getAllByTagNormalizedNames(@NonNull Set<String> set) {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return null;
        }
        return mainListRepository.getAllByTagNormalizedNames(NotesUtils.getSortParam(), set);
    }

    @Nullable
    public List<MainListDocumentData> getAllContentShare(@NonNull String str) {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return null;
        }
        return mainListRepository.getAllContentShare(NotesUtils.getSpaceSortParam(), str);
    }

    public LiveData<List<MainListDocumentData>> getAllContentShare_LiveData(@NonNull String str) {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return null;
        }
        return mainListRepository.getAllContentShare_LiveData(NotesUtils.getSpaceSortParam(), str);
    }

    @Nullable
    public LiveData<List<NotesDocumentCountEntry>> getAllDocumentCountEntry_LiveData(boolean z, @NonNull String str) {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return null;
        }
        return mainListRepository.getAllDocumentCountEntry_LiveData(z, str);
    }

    public LiveData<List<MainListDocumentData>> getAllForImportContentShare_LiveData() {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return null;
        }
        return mainListRepository.getAllForImportContentShare_LiveData(NotesUtils.getSortParam());
    }

    public int getAllLockedDataCount() {
        NotesLockDocumentRepository noteLockRepository = RepositoryManager.getInstance().getNoteLockRepository();
        if (noteLockRepository == null) {
            return 0;
        }
        return noteLockRepository.getAllLockedDataCount(0);
    }

    @Nullable
    public LiveData<List<NotesDocumentCountEntry>> getAllOldDocumentCountEntry_LiveData() {
        return getAllDocumentCountEntry_LiveData(false, FolderConstants.OldNotes.UUID);
    }

    @Nullable
    public List<MainListDocumentData> getAllRecycleBinDataList() {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return null;
        }
        return mainListRepository.getAllRecycleBinDataList(NotesUtils.getDeleteSortParam());
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAllRecycleBinData_LiveData() {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return null;
        }
        return mainListRepository.getAllRecycleBinData_LiveData(NotesUtils.getDeleteSortParam());
    }

    public List<NotesTagEntity> getAllTags() {
        NotesTagRepository hashTagRepository = RepositoryManager.getInstance().getHashTagRepository();
        return hashTagRepository == null ? Collections.EMPTY_LIST : hashTagRepository.getAll();
    }

    public List<String> getAllTagsInUse() {
        NotesTagRepository hashTagRepository = RepositoryManager.getInstance().getHashTagRepository();
        return hashTagRepository == null ? Collections.EMPTY_LIST : hashTagRepository.getAllTagsInUse();
    }

    public int getAllUsedNoteCount() {
        return getAllUsedNoteCount(true);
    }

    @Nullable
    public List<MainListDocumentData> getAllWithCover(@NonNull String str) {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return null;
        }
        return mainListRepository.getAllWithCover(NotesUtils.getSortParam(), str, 0);
    }

    @Nullable
    public List<MainListDocumentData> getAllWithTag() {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return null;
        }
        return mainListRepository.getAllWithTag(NotesUtils.getSortParam());
    }

    @Nullable
    public List<MainListDocumentData> getAll_Converted() {
        NotesConvertedDocumentRepository convertedNoteRepository = RepositoryManager.getInstance().getConvertedNoteRepository();
        if (convertedNoteRepository == null) {
            return null;
        }
        return convertedNoteRepository.getAll_Converted(0, NotesUtils.getSortParam());
    }

    public int getAll_ConvertedCount() {
        NotesConvertedDocumentRepository convertedNoteRepository = RepositoryManager.getInstance().getConvertedNoteRepository();
        if (convertedNoteRepository == null) {
            return 0;
        }
        return convertedNoteRepository.getAll_ConvertedCount(0);
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAll_Converted_LiveData() {
        NotesConvertedDocumentRepository convertedNoteRepository = RepositoryManager.getInstance().getConvertedNoteRepository();
        if (convertedNoteRepository == null) {
            return null;
        }
        return convertedNoteRepository.getAll_Converted_LiveData(0, NotesUtils.getSortParam());
    }

    public LiveData<List<MainListDocumentData>> getAll_LiveData() {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return null;
        }
        return mainListRepository.getAll_LiveData(NotesUtils.getSortParam());
    }

    @Nullable
    public List<MainListDocumentData> getAll_OldNotes() {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return null;
        }
        return mainListRepository.getAll_OldNotes(0, NotesUtils.getSortParam());
    }

    public int getAll_OldNotesCount() {
        NotesOldDocumentRepository oldNoteRepository = RepositoryManager.getInstance().getOldNoteRepository();
        if (oldNoteRepository == null) {
            return 0;
        }
        return oldNoteRepository.getAll_OldNotesCount(0);
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAll_OldNotes_LiveData() {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return null;
        }
        return mainListRepository.getAll_OldNotes_LiveData(NotesUtils.getSortParam());
    }

    public int getConvertedOldNoteCount() {
        if (PostLaunchManager.getInstance().hasBaseLogic(2)) {
            return SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt("old_converted_notes", 0);
        }
        int all_ConvertedCount = getAll_ConvertedCount();
        if (all_ConvertedCount <= 0) {
            SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).remove("old_converted_notes");
            return all_ConvertedCount;
        }
        SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).putInt("old_converted_notes", all_ConvertedCount);
        return all_ConvertedCount;
    }

    @Nullable
    public MainListDocumentData getDocumentData(@NonNull String str) {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return null;
        }
        return mainListRepository.get(str);
    }

    @MainThread
    public String getExpandedJSONObject(Map<String, NotesFolder> map) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.isEmpty()) {
            return jSONObject.toString();
        }
        try {
            for (NotesFolder notesFolder : map.values()) {
                if (notesFolder != null && notesFolder.getViewType() <= 3) {
                    jSONObject.put(notesFolder.getUuid(), notesFolder.isExpanded());
                }
            }
        } catch (JSONException e) {
            MainLogger.m7255e(TAG, "getExpandedJSONObject, e: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public int getFavoriteItemCount() {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return 0;
        }
        return mainListRepository.getFavoriteItemCount(0);
    }

    public NotesFolder getFolderData(String str) {
        return isInitFolderMapNeed() ? FolderManager.getInstance().getNotesFolder(str, false) : this.mFolderDataMap.get(str);
    }

    public Map<String, NotesFolder> getFolderDataMap() {
        return isInitFolderMapNeed() ? new LinkedHashMap() : this.mFolderDataMap;
    }

    @NonNull
    public List<String> getFoldersDisplayName(String str, @Nullable Map<String, NotesFolder> map) {
        if (map == null) {
            map = getFolderDataMap();
        }
        List<NotesFolder> folderChildren = getFolderChildren(str, map);
        if (folderChildren == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<NotesFolder> it = folderChildren.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getDisplayName());
        }
        return arrayList;
    }

    public int getOldNoteCount() {
        if (PostLaunchManager.getInstance().hasBaseLogic(2)) {
            return SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt(FolderConstants.OldNotes.UUID, 0);
        }
        int all_OldNotesCount = getAll_OldNotesCount();
        int convertedOldNoteCount = getConvertedOldNoteCount();
        int i = all_OldNotesCount - convertedOldNoteCount;
        AbstractC8014b.m7212n(AbstractC0622a.m1173s(all_OldNotesCount, convertedOldNoteCount, "getOldNoteCount# oldCount : ", ", convertedCount : ", ", count : "), TAG, i);
        if (i <= 0) {
            SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).remove(FolderConstants.OldNotes.UUID);
            return i;
        }
        SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).putInt(FolderConstants.OldNotes.UUID, i);
        return i;
    }

    public List<String> getOldNotesWithConvertedNotesInUse(List<String> list) {
        NotesConvertedDocumentRepository convertedNoteRepository = RepositoryManager.getInstance().getConvertedNoteRepository();
        return convertedNoteRepository == null ? Collections.EMPTY_LIST : convertedNoteRepository.getOldNotesWithConvertedNotesInUse(list);
    }

    public List<NotesOrganizedDocumentEntity> getOrganizedDocumentEntities(Collection<String> collection) {
        NotesOrganizedDocumentRepository notesOrganizedDocumentRepository = RepositoryManager.getInstance().getNotesOrganizedDocumentRepository();
        return notesOrganizedDocumentRepository == null ? Collections.EMPTY_LIST : notesOrganizedDocumentRepository.getEntities(collection);
    }

    @Nullable
    public NotesOrganizedDocumentEntity getOrganizedDocumentEntity(String str) {
        NotesOrganizedDocumentRepository notesOrganizedDocumentRepository = RepositoryManager.getInstance().getNotesOrganizedDocumentRepository();
        if (notesOrganizedDocumentRepository == null) {
            return null;
        }
        return notesOrganizedDocumentRepository.getEntity(str);
    }

    @Nullable
    public List<NotesOrganizedDocumentEntity> getOrganizedDocuments() {
        NotesOrganizedDocumentRepository notesOrganizedDocumentRepository = RepositoryManager.getInstance().getNotesOrganizedDocumentRepository();
        if (notesOrganizedDocumentRepository == null) {
            return null;
        }
        return notesOrganizedDocumentRepository.getAll();
    }

    @Nullable
    public LiveData<List<NotesOrganizedDocumentEntity>> getOrganizedDocumentsLiveData() {
        NotesOrganizedDocumentRepository notesOrganizedDocumentRepository = RepositoryManager.getInstance().getNotesOrganizedDocumentRepository();
        if (notesOrganizedDocumentRepository == null) {
            return null;
        }
        return notesOrganizedDocumentRepository.getAll_LiveData();
    }

    public List<NotesTagEntity> getRecentTagList(int i) {
        NotesTagRepository hashTagRepository = RepositoryManager.getInstance().getHashTagRepository();
        return hashTagRepository == null ? Collections.EMPTY_LIST : hashTagRepository.getRecentTagList(i);
    }

    public int getRecentlyImportedCount() {
        return getSmartFilterController().getRecentlyImportedCount();
    }

    public List<MainListDocumentData> getRecentlyImportedEntry() {
        return getSmartFilterController().getRecentlyImportedEntry();
    }

    public List<String> getRelatedTags(@NonNull Set<String> set) {
        NotesTagRepository hashTagRepository = RepositoryManager.getInstance().getHashTagRepository();
        return hashTagRepository == null ? Collections.EMPTY_LIST : hashTagRepository.getRelatedTags(set);
    }

    public List<NotesFolder> getSmartFilter(Map<String, NotesFolder> map, Map<String, NotesDocumentCountEntry> map2, Map<String, NotesDocumentCountEntry> map3) {
        return getSmartFilterController().getSmartFilter(map, map2, map3);
    }

    public boolean hasConvertedOldNotes(List<String> list) {
        NotesConvertedDocumentRepository convertedNoteRepository = RepositoryManager.getInstance().getConvertedNoteRepository();
        if (convertedNoteRepository == null) {
            return false;
        }
        return convertedNoteRepository.hasConvertedOldNote(list);
    }

    public boolean hasLockedNoteInsideFolder(String str, boolean z) {
        if (RepositoryManager.getInstance().getNoteLockRepository() == null) {
            return false;
        }
        return !r0.find(str, z).isEmpty();
    }

    public boolean hasOldNoteInUse() {
        NotesOldDocumentRepository oldNoteRepository = RepositoryManager.getInstance().getOldNoteRepository();
        if (oldNoteRepository == null) {
            return false;
        }
        return oldNoteRepository.hasOldNoteInUse();
    }

    public String insertFolder(String str, String str2, int i, int i2) {
        String strNewUUID = UUIDUtils.newUUID(BaseUtils.getApplicationContext());
        NotesFolder notesFolder = new NotesFolder(strNewUUID, str, str2, null);
        notesFolder.setReorder(Integer.valueOf(i2));
        notesFolder.setDisplayNameColor(i);
        new AddFolderUseCase().execute(notesFolder, false);
        return strNewUUID;
    }

    public int isDeletedNote(@NonNull String str) {
        MainListDocumentData documentData = getDocumentData(str);
        if (documentData == null) {
            return 1;
        }
        return documentData.getIsDeleted();
    }

    public boolean isExistFolderName(Context context, String str, String str2, List<String> list, boolean z) {
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
            list = getFoldersDisplayName(str2, null);
        }
        return list.contains(strTrim);
    }

    public boolean isInitFolderMapNeed() {
        return this.mFolderDataMap == null;
    }

    public boolean isOldConvertedNote(String str) {
        NotesConvertedDocumentRepository convertedNoteRepository = RepositoryManager.getInstance().getConvertedNoteRepository();
        if (convertedNoteRepository == null) {
            return false;
        }
        return convertedNoteRepository.hasConvertedOldNote(Collections.singleton(str));
    }

    public boolean isOldNotesFolderNeed() {
        return getOldNoteCount() > 0 || getConvertedOldNoteCount() > 0;
    }

    public void restoreFolderExpandState(Map<String, NotesFolder> map) {
        String string = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getString(NotesConstants.KEY_FOLDER_EXPAND_STATE, null);
        if (string == null) {
            return;
        }
        MainLogger.m7254d(TAG, "restoreFolderExpandState");
        setExpandedJSONObject(map, string);
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putString(NotesConstants.KEY_FOLDER_EXPAND_STATE, getExpandedJSONObject(map));
    }

    public void saveCurrentFolderExpandState() {
        saveFolderExpandState(getInstance().getFolderDataMap());
    }

    public void saveFolderExpandState(Map<String, NotesFolder> map) {
        MainLogger.m7254d(TAG, "saveFolderExpandState");
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putString(NotesConstants.KEY_FOLDER_EXPAND_STATE, getExpandedJSONObject(map));
    }

    public void screenOffMemoOrdering(Map<String, NotesFolder> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        addNotesFolder(map, linkedHashMap, FolderConstants.ScreenOffMemo.UUID, FolderConstants.ScreenOffMemo.DISPLAY_NAME, -13L, 1, null);
        linkedHashMap.putAll(map);
    }

    @MainThread
    public void setExpandedJSONObject(Map<String, NotesFolder> map, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map2 = new HashMap();
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                map2.put(jsonReader.nextName(), Boolean.valueOf(jsonReader.nextBoolean()));
            }
            jsonReader.endObject();
            if (!map2.isEmpty() && map != null && !map.isEmpty()) {
                for (NotesFolder notesFolder : map.values()) {
                    Boolean bool = (Boolean) map2.get(notesFolder.getUuid());
                    if (notesFolder.getViewType() <= 3 && bool != null) {
                        notesFolder.setExpanded(bool.booleanValue());
                    }
                }
            }
        } catch (IOException e) {
            e = e;
            AbstractC14516b.m15115c(e, new StringBuilder("setExpandedJSONObject, e: "), TAG);
        } catch (ArrayIndexOutOfBoundsException e2) {
            e = e2;
            AbstractC14516b.m15115c(e, new StringBuilder("setExpandedJSONObject, e: "), TAG);
        }
    }

    public void setOrganizeDocumentEntity(NotesOrganizedDocumentEntity notesOrganizedDocumentEntity) {
        NotesOrganizedDocumentRepository notesOrganizedDocumentRepository = RepositoryManager.getInstance().getNotesOrganizedDocumentRepository();
        if (notesOrganizedDocumentRepository == null) {
            return;
        }
        try {
            notesOrganizedDocumentRepository.insert(notesOrganizedDocumentEntity);
        } catch (NotesSQLiteConstraintException unused) {
        }
    }

    public void updateCategory(String str, String str2) {
        NotesDocumentRepository noteRepository = RepositoryManager.getInstance().getNoteRepository();
        if (noteRepository == null) {
            return;
        }
        noteRepository.updateCategory(str, str2);
    }

    public void updateFavorites(ArrayList<String> arrayList, boolean z) {
        NotesDocumentRepository noteRepository = RepositoryManager.getInstance().getNoteRepository();
        if (noteRepository == null) {
            return;
        }
        noteRepository.updateFavorites(arrayList, z);
    }

    @Nullable
    public List<MainListDocumentData> getAll(SortParam sortParam) {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return null;
        }
        return mainListRepository.getAll(sortParam);
    }

    public int getAllUsedNoteCount(boolean z) {
        MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
        if (mainListRepository == null) {
            return 0;
        }
        return mainListRepository.getAllNoteCount(0, z);
    }

    public void updateCategory(Collection<String> collection, String str) {
        NotesDocumentRepository noteRepository = RepositoryManager.getInstance().getNoteRepository();
        if (noteRepository == null) {
            return;
        }
        noteRepository.updateCategory(collection, str);
    }

    public void initFolderMap() {
        if (isInitFolderMapNeed()) {
            initFolderMap(RepositoryManager.getInstance().getDocumentCategoryTree());
        }
    }
}
