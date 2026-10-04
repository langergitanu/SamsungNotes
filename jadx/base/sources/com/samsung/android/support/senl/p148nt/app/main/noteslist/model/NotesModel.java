package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckNotesCountInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckedNoteInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p044K.C0158a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesModel {
    private static final String FILE_NAME_FOR_SAVED_INSTANCE = "saved_instance_check_notes_list";
    private static final String KEY_CHECKED_DIMMED_LIST = "key_checked_dim_list";
    private static final String KEY_CHECKED_SUB_FOLDER_LIST = "key_checked_sub_folder_list";
    private static final String KEY_SAVE_EXPORT_ITEMS = "key_saving_item_list";
    private static final String KEY_SAVE_EXPORT_TYPE = "key_saving_type";
    private static final String TAG = "NotesModel";
    private Runnable mAnimationRunnable;
    private boolean mIsScrolling;
    private boolean mItemLongPressed;
    private int mLastDisplay;
    private String mLastOpenedSDocXUuid;
    private String mPostDragAndDropUuid;
    private boolean mPostNotifyDataSetChanged;
    private ArrayList<CheckedNoteInfo> mSaveExportNoteList;
    private final HashMap<String, Boolean> mConvertingStateHashMap = new HashMap<>();
    private LinkedHashMap<String, CheckedNoteInfo> mCheckedNotes = new LinkedHashMap<>();
    private HashMap<String, Object> mCheckedDimmedNotes = new LinkedHashMap();
    private HashMap<String, Object> mCheckedFolders = new LinkedHashMap();
    private int mSaveExportType = -1;
    private int mExportPdfType = 0;
    private int mToolType = 1;
    private int mRequestCodeForOtherApp = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MovingFolder {
        public int duplCount;
        public int moveCount;
        public ArrayList<String> sdocUuidList;
    }

    private void loadCheckedDimmedNotes(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        HashMap<String, Object> map = (HashMap) bundle.getSerializable(KEY_CHECKED_DIMMED_LIST);
        this.mCheckedDimmedNotes = map;
        if (map == null) {
            this.mCheckedDimmedNotes = new LinkedHashMap();
        }
    }

    private void loadCheckedFolders(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        HashMap<String, Object> map = (HashMap) bundle.getSerializable(KEY_CHECKED_SUB_FOLDER_LIST);
        this.mCheckedFolders = map;
        if (map == null) {
            this.mCheckedFolders = new LinkedHashMap();
        }
    }

    private void loadCheckedNotes(Context context) {
        byte[] bArr;
        File file = new File(context.getCacheDir() + "/saved_instance_check_notes_list");
        if (file.exists()) {
            bArr = new byte[(int) file.length()];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    if (fileInputStream.read(bArr) <= 0) {
                        MainLogger.m7255e(TAG, "loadCheckedNotes# failed to read paragraph list from file Stream ended unexpectedly");
                    }
                    if (!file.delete()) {
                        MainLogger.m7255e(TAG, "loadCheckedNotes# file is not successfully deleted");
                    }
                    fileInputStream.close();
                } finally {
                }
            } catch (IOException e) {
                MainLogger.m7255e(TAG, "loadCheckedNotes# failed to read paragraph list from file " + e.getMessage());
            }
        } else {
            bArr = null;
        }
        if (bArr != null && bArr.length > 0) {
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            parcelObtain.readMap(this.mCheckedNotes, getClass().getClassLoader());
            parcelObtain.recycle();
        }
        if (this.mCheckedNotes == null) {
            this.mCheckedNotes = new LinkedHashMap<>();
        }
    }

    private void loadSaveExportItemInfo(Bundle bundle) {
        this.mSaveExportType = bundle.getInt(KEY_SAVE_EXPORT_TYPE);
        ArrayList<CheckedNoteInfo> parcelableArrayList = bundle.getParcelableArrayList(KEY_SAVE_EXPORT_ITEMS);
        this.mSaveExportNoteList = parcelableArrayList;
        if (parcelableArrayList == null) {
            this.mSaveExportNoteList = new ArrayList<>();
        }
    }

    private void saveCheckedDimmedNotes(Bundle bundle) {
        if (bundle == null || this.mCheckedDimmedNotes.isEmpty()) {
            return;
        }
        bundle.putSerializable(KEY_CHECKED_DIMMED_LIST, this.mCheckedDimmedNotes);
    }

    private void saveCheckedFolders(Bundle bundle) {
        if (bundle == null || this.mCheckedFolders.isEmpty()) {
            return;
        }
        bundle.putSerializable(KEY_CHECKED_SUB_FOLDER_LIST, this.mCheckedFolders);
    }

    private void saveCheckedNotes(Context context) {
        deleteCheckedNoteDataFile(context);
        if (this.mCheckedNotes.isEmpty()) {
            MainLogger.m7254d(TAG, "saveCheckedNotes# CheckedNotes empty");
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeMap(this.mCheckedNotes);
        parcelObtain.setDataPosition(0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        File file = new File(AbstractC11014a.m12320e(context.getCacheDir(), "/saved_instance_check_notes_list"));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                if (!file.createNewFile()) {
                    MainLogger.m7254d(TAG, "saveCheckedNotes# the named file already exists");
                }
                fileOutputStream.write(bArrMarshall);
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            MainLogger.m7255e(TAG, "onSaveInstanceState# failed to save paragraph list into file " + e.getMessage());
        }
    }

    private void saveSaveExportItemInfo(Bundle bundle) {
        bundle.putInt(KEY_SAVE_EXPORT_TYPE, this.mSaveExportType);
        bundle.putParcelableArrayList(KEY_SAVE_EXPORT_ITEMS, this.mSaveExportNoteList);
    }

    public void addCheckedDimmedNote(String str) {
        this.mCheckedDimmedNotes.put(str, Boolean.TRUE);
    }

    public void addCheckedFolder(String str) {
        if (str != null) {
            this.mCheckedFolders.put(str, Boolean.TRUE);
        }
    }

    public void addCheckedNote(MainListDocumentData mainListDocumentData) {
        String uuid = mainListDocumentData.getUuid();
        this.mCheckedNotes.put(uuid, new CheckedNoteInfo.CheckInfoBuilder(uuid).setFolderUuid(mainListDocumentData.getCategoryUuid()).setFilePath(mainListDocumentData.getFilePath()).setTitle(mainListDocumentData.getTitle()).setIsSdoc(mainListDocumentData.isSDoc()).setIsFavorite(mainListDocumentData.getIsFavorite() == 1).setCorrupted(mainListDocumentData.getCorrupted()).setLockType(mainListDocumentData.getIsLock()).setCreatedTime(mainListDocumentData.getCreatedAt()).setIsCoverEnabled(mainListDocumentData.isCoverEnabled()).setModifiedTime(mainListDocumentData.getLastModifiedAt()).setPageMode(mainListDocumentData.getPageMode()).setUnknownMinVersion(mainListDocumentData.getUnknownMinVersion()).setFormatVersion(mainListDocumentData.getFormatVersion()).setGetHasSticky(mainListDocumentData.getHasSticky()).build());
    }

    public void clearCheckedDimmedNotes() {
        this.mCheckedDimmedNotes.clear();
    }

    public void clearCheckedFolders() {
        this.mCheckedFolders.clear();
    }

    public void clearCheckedNotes() {
        this.mCheckedNotes.clear();
    }

    public void clearSaveExportNoteList() {
        this.mSaveExportNoteList = null;
    }

    public void deleteCheckedNoteDataFile(Context context) {
        MainLogger.m7254d(TAG, "deleteCheckedNoteDataFile#");
        File file = new File(AbstractC11014a.m12320e(context.getCacheDir(), "/saved_instance_check_notes_list"));
        if (!file.exists() || file.delete()) {
            return;
        }
        MainLogger.m7254d(TAG, "deleteCheckedNoteDataFile# file is not successfully deleted");
    }

    public CheckNotesCountInfo getCheckNotesCountInfo() {
        return new CheckNotesCountInfo().getCheckNotesCountInfo(this.mCheckedNotes);
    }

    public int getCheckedDataCount() {
        return getCheckedFoldersCount() + getCheckedNotesCount();
    }

    public int getCheckedDimmedNotesCount() {
        return this.mCheckedDimmedNotes.size();
    }

    public int getCheckedDimmedNotesInFolderCount() {
        Iterator<Map.Entry<String, Object>> it = this.mCheckedDimmedNotes.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (this.mCheckedNotes.get(it.next().getKey()) != null) {
                i++;
            }
        }
        return i;
    }

    public int getCheckedFoldersCount() {
        return this.mCheckedFolders.size();
    }

    public ArrayList<String> getCheckedFoldersUUID() {
        return new ArrayList<>(this.mCheckedFolders.keySet());
    }

    public ArrayList<CheckedNoteInfo> getCheckedNotes() {
        return new ArrayList<>(this.mCheckedNotes.values());
    }

    public int getCheckedNotesCount() {
        return this.mCheckedNotes.size();
    }

    public Set<Map.Entry<String, CheckedNoteInfo>> getCheckedNotesEntrySet() {
        return this.mCheckedNotes.entrySet();
    }

    public ArrayList<String> getCheckedNotesUUID() {
        return new ArrayList<>(this.mCheckedNotes.keySet());
    }

    public ArrayList<String> getCheckedNotesUUIDForWidgetList() {
        ArrayList<String> arrayList = new ArrayList<>(this.mCheckedNotes.keySet());
        for (Map.Entry<String, Object> entry : this.mCheckedDimmedNotes.entrySet()) {
            if (this.mCheckedNotes.get(entry.getKey()) == null) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public int getExportPdfType() {
        return this.mExportPdfType;
    }

    public int getLastDisplay() {
        return this.mLastDisplay;
    }

    public String getLastOpenedSDocXUuid() {
        return this.mLastOpenedSDocXUuid;
    }

    public boolean getLongPressFlag() {
        return this.mItemLongPressed;
    }

    public ArrayList<String> getNonCorruptedNotesUuid() {
        ArrayList<String> checkedNotesUUID = getCheckedNotesUUID();
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : checkedNotesUUID) {
            if (!NotesUtils.isWarning(this.mCheckedNotes.get(str).getCorrupted())) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public String getPostDragAndDropUuid() {
        return this.mPostDragAndDropUuid;
    }

    public int getRequestCodeForOtherApp() {
        return this.mRequestCodeForOtherApp;
    }

    public ArrayList<CheckedNoteInfo> getSaveExportNoteList() {
        ArrayList<CheckedNoteInfo> arrayList = this.mSaveExportNoteList;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public int getSaveExportType() {
        return this.mSaveExportType;
    }

    public Map<String, CheckedNoteInfo> getSharableCheckedNoteMap() {
        boolean zIsSupportedFileProvider = DeviceUtils.isSupportedFileProvider();
        HashMap map = new HashMap();
        for (Map.Entry<String, CheckedNoteInfo> entry : this.mCheckedNotes.entrySet()) {
            if (zIsSupportedFileProvider) {
                if (!entry.getValue().isLock() || entry.getValue().getLockType() == 5) {
                    map.put(entry.getKey(), entry.getValue());
                }
            } else if (!entry.getValue().isLock()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }

    public ArrayList<CheckedNoteInfo> getSharableCheckedOldNotes() {
        boolean zIsSupportedFileProvider = DeviceUtils.isSupportedFileProvider();
        ArrayList<CheckedNoteInfo> arrayList = new ArrayList<>();
        for (CheckedNoteInfo checkedNoteInfo : this.mCheckedNotes.values()) {
            if (zIsSupportedFileProvider) {
                if (!checkedNoteInfo.isLock() || checkedNoteInfo.getLockType() == 1) {
                    arrayList.add(checkedNoteInfo);
                }
            } else if (!checkedNoteInfo.isLock()) {
                arrayList.add(checkedNoteInfo);
            }
        }
        return arrayList;
    }

    public int getToolType() {
        return this.mToolType;
    }

    public boolean hasCoeditUnsupportedFormatVersion() {
        if (C0158a.m409d(BaseUtils.getApplicationContext())) {
            for (CheckedNoteInfo checkedNoteInfo : this.mCheckedNotes.values()) {
                if (FeatureUtils.needToHideSharedNoteDisplayData(checkedNoteInfo.getUuid(), checkedNoteInfo.getPageMode(), checkedNoteInfo.getFormatVersion(), checkedNoteInfo.isCoverEnabled(), checkedNoteInfo.getFilePath(), checkedNoteInfo.isSdoc(), checkedNoteInfo.getHasSticky() > 0)) {
                }
            }
            return false;
        }
        return true;
    }

    public boolean hasGenUuidNote(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (UUIDUtils.isGenUuid(it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTemplateUuid(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (UUIDUtils.isDynamicTemplateUuid(it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean isScrolling() {
        return this.mIsScrolling;
    }

    public boolean isSubHeaderAllDimmed(List<String> list) {
        if (list == null || this.mCheckedDimmedNotes.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!this.mCheckedDimmedNotes.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean isSubHeaderChecked(Map<String, MainListDocumentData> map) {
        if (map == null) {
            return false;
        }
        Iterator<Map.Entry<String, MainListDocumentData>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!isUuidInCheckedNotes(it.next().getKey())) {
                return false;
            }
        }
        return true;
    }

    public boolean isUUIDInConvertingState(String str) {
        return this.mConvertingStateHashMap.get(str) != null;
    }

    public boolean isUnlockConverting(String str) {
        return this.mConvertingStateHashMap.get(str) != null && Boolean.TRUE.equals(this.mConvertingStateHashMap.get(str));
    }

    public boolean isUuidInCheckedData(String str) {
        return isUuidInCheckedNotes(str) || isUuidInCheckedFolder(str);
    }

    public boolean isUuidInCheckedDimmedNotes(String str) {
        return this.mCheckedDimmedNotes.get(str) != null;
    }

    public boolean isUuidInCheckedFolder(String str) {
        return this.mCheckedFolders.get(str) != null;
    }

    public boolean isUuidInCheckedNotes(String str) {
        return this.mCheckedNotes.get(str) != null;
    }

    public MovingFolder moveFolder(String str) {
        MovingFolder movingFolder = new MovingFolder();
        movingFolder.moveCount = 0;
        movingFolder.duplCount = 0;
        movingFolder.sdocUuidList = new ArrayList<>();
        for (CheckedNoteInfo checkedNoteInfo : this.mCheckedNotes.values()) {
            if (str.equals(checkedNoteInfo.getFolderUuid())) {
                movingFolder.duplCount++;
            } else {
                movingFolder.moveCount++;
                movingFolder.sdocUuidList.add(checkedNoteInfo.getUuid());
            }
        }
        return movingFolder;
    }

    public void onRestoreInstanceState(Bundle bundle, Context context) {
        loadCheckedNotes(context);
        loadCheckedDimmedNotes(bundle);
        loadCheckedFolders(bundle);
        loadSaveExportItemInfo(bundle);
    }

    public void onSaveInstanceState(Bundle bundle, Context context) {
        saveCheckedNotes(context);
        saveCheckedDimmedNotes(bundle);
        saveCheckedFolders(bundle);
        saveSaveExportItemInfo(bundle);
    }

    public void postNotifyDataSetChanged() {
        this.mPostNotifyDataSetChanged = true;
    }

    public void registerNoteAnimation(Runnable runnable) {
        this.mAnimationRunnable = runnable;
    }

    public void releaseNoteAnimation() {
        Runnable runnable = this.mAnimationRunnable;
        if (runnable != null) {
            runnable.run();
            this.mAnimationRunnable = null;
        }
    }

    public void removeCheckedFolder(String str) {
        this.mCheckedFolders.remove(str);
    }

    public void removeCheckedNote(String str) {
        this.mCheckedNotes.remove(str);
    }

    public void removeUnlockConvertingState(String str) {
        this.mConvertingStateHashMap.remove(str);
    }

    public void selectAll(boolean z, List<Common> list) {
        if (list == null) {
            return;
        }
        if (!z) {
            clearCheckedNotes();
            clearCheckedFolders();
            return;
        }
        for (Common common : list) {
            int i = common.type;
            if (i == 2048) {
                addCheckedNote(common.notes);
            } else if (i <= 1024) {
                for (NotesFolder notesFolder : common.folders) {
                    if (notesFolder != null && !FolderUtils.isStaticFolder(notesFolder.getUuid())) {
                        addCheckedFolder(notesFolder.getUuid());
                    }
                }
            }
        }
    }

    public void selectAllForListWidget(boolean z, List<Common> list, int i) {
        if (list == null) {
            return;
        }
        MainLogger.m7255e(TAG, "selectAllForListWidget maxListWidgetItem: " + i);
        if (!z) {
            clearCheckedNotes();
            return;
        }
        int i2 = 0;
        for (Common common : list) {
            if (i <= 0 || i2 == i) {
                return;
            }
            if (common.type == 2048 && !isUuidInCheckedNotes(common.notes.getUuid())) {
                i2++;
                addCheckedNote(common.notes);
            }
        }
    }

    public void selectAllNotes(boolean z, List<Common> list) {
        if (!z) {
            clearCheckedNotes();
            return;
        }
        if (list == null) {
            return;
        }
        for (Common common : list) {
            if (common.type == 2048) {
                addCheckedNote(common.notes);
            }
        }
    }

    public void selectAllWithSubHeader(boolean z, List<Common> list, boolean z2) {
        if (list == null) {
            return;
        }
        boolean z3 = false;
        for (Common common : list) {
            int i = common.type;
            if (i == 4096) {
                if (z3) {
                    if ((z2 && common.f6179id == -14) || (!z2 && common.f6179id == -15)) {
                        z3 = false;
                    }
                } else if ((z2 && common.f6179id == -15) || (!z2 && common.f6179id == -14)) {
                    z3 = true;
                }
            }
            if (z3 && i == 2048) {
                if (z) {
                    addCheckedNote(common.notes);
                } else {
                    removeCheckedNote(common.notes.getUuid());
                }
            }
        }
    }

    public void setCheckedDimmedNotes(Bundle bundle, int i) {
        ArrayList<String> stringArrayList;
        if ((i == 8 || i == 14) && (stringArrayList = bundle.getStringArrayList(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST)) != null) {
            setSavedCheckedNotes(stringArrayList);
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                addCheckedDimmedNote(it.next());
            }
        }
    }

    public void setExportPdfType(int i) {
        this.mExportPdfType = i;
    }

    public boolean setIsScrolling(boolean z) {
        boolean z2 = !z && this.mPostNotifyDataSetChanged;
        this.mIsScrolling = z;
        if (z2) {
            this.mPostNotifyDataSetChanged = false;
        }
        return z2;
    }

    public void setLastDisplay(int i) {
        this.mLastDisplay = i;
    }

    public void setLastOpenedSDocXUuid(String str) {
        this.mLastOpenedSDocXUuid = str;
    }

    public void setLongPressFlag(boolean z) {
        this.mItemLongPressed = z;
    }

    public void setPostDragAndDropUuid(String str) {
        this.mPostDragAndDropUuid = str;
    }

    public void setRequestCodeForOtherApp(int i) {
        this.mRequestCodeForOtherApp = i;
    }

    public void setSaveExportNoteList(ArrayList<CheckedNoteInfo> arrayList) {
        this.mSaveExportNoteList = arrayList;
    }

    public void setSaveExportType(int i) {
        this.mSaveExportType = i;
    }

    public void setSavedCheckedNotes(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            MainListDocumentData documentData = DataManager.getInstance().getDocumentData(it.next());
            if (documentData != null && documentData.getIsDeleted() != 1 && !documentData.isSDoc()) {
                addCheckedNote(documentData);
            }
        }
    }

    public void setToolType(int i) {
        this.mToolType = i;
    }

    public void setUnlockConvertingState(String str, boolean z) {
        this.mConvertingStateHashMap.put(str, Boolean.valueOf(z));
    }

    public void toggleCheckedFolder(String str) {
        if (isUuidInCheckedFolder(str)) {
            removeCheckedFolder(str);
        } else {
            addCheckedFolder(str);
        }
    }

    public void toggleCheckedNote(MainListDocumentData mainListDocumentData) {
        String uuid = mainListDocumentData.getUuid();
        if (isUuidInCheckedNotes(uuid)) {
            removeCheckedNote(uuid);
        } else {
            addCheckedNote(mainListDocumentData);
        }
    }

    public boolean isSubHeaderChecked(List<String> list) {
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!isUuidInCheckedNotes(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void toggleCheckedFolder(boolean z, String str) {
        if (z && !isUuidInCheckedFolder(str)) {
            addCheckedFolder(str);
        } else {
            if (z || !isUuidInCheckedFolder(str)) {
                return;
            }
            removeCheckedFolder(str);
        }
    }

    public void toggleCheckedNote(boolean z, MainListDocumentData mainListDocumentData) {
        String uuid = mainListDocumentData.getUuid();
        if (z && !isUuidInCheckedNotes(uuid)) {
            addCheckedNote(mainListDocumentData);
        } else {
            if (z || !isUuidInCheckedNotes(uuid)) {
                return;
            }
            removeCheckedNote(uuid);
        }
    }

    public void selectAllWithSubHeader(boolean z, List<Common> list, int i) {
        if (list == null) {
            return;
        }
        int size = list.size();
        while (true) {
            i++;
            if (i >= size) {
                return;
            }
            if (list.get(i).type == 2048) {
                if (z) {
                    addCheckedNote(list.get(i).notes);
                } else {
                    removeCheckedNote(list.get(i).notes.getUuid());
                }
            } else if (list.get(i).type == 4096) {
                return;
            }
        }
    }

    public boolean selectAllWithSubHeader(boolean z, List<Common> list, int i, int i2) {
        if (list == null) {
            return false;
        }
        int size = list.size();
        for (int i4 = i + 1; i4 < size; i4++) {
            if (list.get(i4).type != 2048) {
                if (list.get(i4).type == 4096) {
                    break;
                }
            } else if (z) {
                if (isUuidInCheckedNotes(list.get(i4).notes.getUuid())) {
                    continue;
                } else {
                    if (i2 == getCheckedDataCount()) {
                        return true;
                    }
                    addCheckedNote(list.get(i4).notes);
                }
            } else {
                String uuid = list.get(i4).notes.getUuid();
                if (!this.mCheckedDimmedNotes.containsKey(uuid)) {
                    removeCheckedNote(uuid);
                }
            }
        }
        return false;
    }
}
