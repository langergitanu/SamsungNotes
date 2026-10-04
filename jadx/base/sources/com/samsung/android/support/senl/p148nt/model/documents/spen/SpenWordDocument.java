package com.samsung.android.support.senl.p148nt.model.documents.spen;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.SpenDocumentHelper;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.SpenWNoteObjectHelper;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.documents.data.StorageInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SpenWordDocument extends SpenWNote implements ISpenDocument {
    public static final String TAG = ModelLogger.createTag("SpenWordDocument");
    private final ArrayList<String> mChangedPageIdList;
    private boolean mIsClosed;
    private boolean mIsSaveCache;
    private String mPath;

    private SpenWordDocument(Context context, String str, SpenWNote.Orientation orientation, int i, SpenWNote.PageMode pageMode, boolean z) {
        super(context, str, pageMode, orientation, i, z);
        this.mChangedPageIdList = new ArrayList<>();
        initialize(str);
    }

    public static SpenWordDocument create(Context context, String str, SpenWNote.Orientation orientation, int i, SpenWNote.PageMode pageMode, boolean z) {
        SpenWordDocument spenWordDocument = new SpenWordDocument(context, str, orientation, i, pageMode, z);
        SpenDocumentHelper.updateDefaultHeight(spenWordDocument);
        return spenWordDocument;
    }

    private static boolean existChangedObject(List<SpenObjectBase> list) {
        String str = TAG;
        DataLogger.m12307i(str, "existChangedObject");
        if (list == null || list.isEmpty()) {
            DataLogger.m12307i(str, "existChangedObject, objectList is empty");
            return false;
        }
        int size = list.size();
        for (SpenObjectBase spenObjectBase : list) {
            if (spenObjectBase.getType() == 2) {
                if (isChangedTextBoxObject((SpenObjectTextBox) spenObjectBase)) {
                    DataLogger.m12307i(TAG, "existChangedObject, isChangedTextBoxObject - true, object : " + spenObjectBase);
                    return true;
                }
                size--;
            }
        }
        DataLogger.m12307i(TAG, "existChangedObject, changedObjectCount : " + size);
        return size > 0;
    }

    private void initialize(@Nullable String str) {
        this.mPath = str;
        setChangedPageIdList();
    }

    private void internalClose() {
        this.mIsClosed = true;
    }

    private static boolean isChangedTextBoxObject(@NonNull SpenObjectTextBox spenObjectTextBox) {
        return (TextUtils.isEmpty(spenObjectTextBox.getText()) || spenObjectTextBox.getText().matches("\\s*")) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public void clearChangedPageIdList() {
        this.mChangedPageIdList.clear();
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote, com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public void close(boolean z) {
        super.close(z);
        internalClose();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public ArrayList<String> getChangedPageIdList() {
        if (this.mChangedPageIdList.isEmpty()) {
            setChangedPageIdList();
        }
        return this.mChangedPageIdList;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public long getCreatedTime() {
        return TimeManager.convertSdkTimeToAppTime(SpenWNoteFile.getCreatedTime(this.mPath));
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public List<String> getInvalidPageIds(List<String> list) {
        Iterator<SpenWPage> it = getPageList().iterator();
        while (it.hasNext()) {
            list.remove(it.next().getId());
        }
        DataLogger.m12307i(TAG, "getInvalidPageIds, count: " + list.size() + ", IDs: " + list);
        return list;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public long getModifiedTime() {
        return TimeManager.convertSdkTimeToAppTime(SpenWNoteFile.getLastModifiedTime(this.mPath));
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote, com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public String getOwnerId() {
        return LockUtils.getHashedAccountGuid(super.getOwnerId());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public StorageInfo getStorageSize() {
        return new StorageInfo((FileUtils.getStorageSize(this.mPath) - FileUtils.getStorageSize(this.mPath + File.separator + "media")) + getBoundFilesSize());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    @NonNull
    public String getStringBodyText() {
        String text = getBodyText().getText();
        return text == null ? "" : text;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public String getTitleText() {
        return getTitle().getText();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public void insertBody(String str) {
        getBodyText().insertText(str, getStringBodyText().length());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public void insertTitle(String str) {
        DataLogger.m12307i(TAG, "insertTitle, title : " + DataLogger.getEncode(str));
        if (str != null) {
            getTitle().setText(str);
        }
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote, com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public boolean isChangedOnlyThumbnail() {
        return super.isChangedOnlyThumbnail() && !hasSnapSavedData();
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote, com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public boolean isClosed() {
        return this.mIsClosed;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public boolean isContentChanged() {
        return isChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public boolean isContentEmpty() {
        return isContentEmpty(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public boolean isLocked() {
        return !SpenWNote.DocumentType.UNLOCKED_DOC.equals(getDocumentType());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public boolean isSaveCache() {
        DataLogger.m12302d(TAG, "isSaveCache : " + this.mIsSaveCache);
        return this.mIsSaveCache;
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote, com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public void quickSave(String str) {
        setChangedPageIdList();
        super.quickSave(str);
        setSaveCache(true);
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote, com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public void reload() {
        super.reload();
        setSaveCache(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public void save(@NonNull String str) {
        setChangedPageIdList();
        saveAsDirectory(str);
        setSaveCache(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public void setAllPageIdList() {
        Iterator<SpenWPage> it = getPageList().iterator();
        while (it.hasNext()) {
            this.mChangedPageIdList.add(it.next().getId());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public void setChangedPageIdList() {
        for (SpenWPage spenWPage : getPageList()) {
            if (spenWPage.isChanged() && !this.mChangedPageIdList.contains(spenWPage.getId())) {
                this.mChangedPageIdList.add(spenWPage.getId());
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public void setSaveCache(boolean z) {
        DataLogger.m12302d(TAG, "setSaveCache : " + z);
        this.mIsSaveCache = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument
    public void snapSave(String str, boolean z) {
        snapSave(z);
        setSaveCache(true);
    }

    public static boolean isContentEmpty(SpenWNote spenWNote) {
        SpenObjectTextBox title = spenWNote.getTitle();
        if (!TextUtils.isEmpty(title.getText())) {
            DataLogger.m12307i(TAG, "isContentEmpty, title : " + DataLogger.getEncode(title.getText()));
            return false;
        }
        String text = spenWNote.getBodyText().getText();
        if (!TextUtils.isEmpty(text) && !text.matches("\\s*")) {
            DataLogger.m12307i(TAG, "isContentEmpty, bodyTextBox size : " + text.length());
            return false;
        }
        ArrayList<SpenVoiceData> voiceDataList = spenWNote.getVoiceDataList();
        if (voiceDataList != null && !voiceDataList.isEmpty()) {
            DataLogger.m12307i(TAG, "isContentEmpty, voice data size : " + voiceDataList.size());
            return false;
        }
        ArrayList<SpenWPage> pageList = spenWNote.getPageList();
        int size = pageList.size();
        for (int i = 0; i < size; i++) {
            SpenWPage spenWPage = pageList.get(i);
            if (spenWPage != null) {
                if (SpenWNoteObjectHelper.hasPdfObject(spenWPage)) {
                    DataLogger.m12307i(TAG, "isContentEmpty, pdf exists");
                    return false;
                }
                if (existChangedObject(spenWPage.getObjectList())) {
                    DataLogger.m12307i(TAG, "isContentEmpty, existChangedObject");
                    return false;
                }
                if (spenWPage.getCustomObjectCount() > 0) {
                    DataLogger.m12307i(TAG, "isContentEmpty, custom object exists");
                    return false;
                }
            }
        }
        DataLogger.m12307i(TAG, "isContentEmpty, true");
        return true;
    }

    public static SpenWordDocument create(Context context, String str, int i, int i2, boolean z, boolean z2) {
        SpenWordDocument spenWordDocument = new SpenWordDocument(context, str, i, i2, z, z2);
        SpenDocumentHelper.updateDefaultHeight(spenWordDocument);
        return spenWordDocument;
    }

    private SpenWordDocument(Context context, String str, int i, int i2, boolean z, boolean z2) {
        super(context, str, i, i2, z, false, z2);
        this.mChangedPageIdList = new ArrayList<>();
        initialize(str);
    }

    public static SpenWordDocument create(Context context, String str, int i, int i2, boolean z, boolean z2, boolean z3) {
        SpenWordDocument spenWordDocument = new SpenWordDocument(context, str, i, i2, z, z2, z3);
        SpenDocumentHelper.updateDefaultHeight(spenWordDocument);
        return spenWordDocument;
    }

    private SpenWordDocument(Context context, String str, int i, int i2, boolean z, boolean z2, boolean z3) {
        super(context, str, i, i2, z, z2, z3);
        this.mChangedPageIdList = new ArrayList<>();
        initialize(str);
    }
}
