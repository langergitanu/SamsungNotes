package com.samsung.android.support.senl.p148nt.data.database.core.document.folder;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentCategoryTree {
    private static final String TAG = DataLogger.createTag("DocumentCategoryTree");
    private final Map<String, NotesFolder> mFolders;
    private final boolean mInTrash;

    public DocumentCategoryTree(Collection<NotesFolder> collection) {
        this(collection, false);
    }

    public void addFolder(NotesFolder notesFolder) {
        StringBuilder sb = new StringBuilder();
        if (notesFolder.getParentUuid() != null) {
            NotesFolder notesFolder2 = this.mFolders.get(notesFolder.getParentUuid());
            if (notesFolder2 != null) {
                notesFolder2.addChild(notesFolder);
                sb.append(notesFolder2.getAbsolutePath());
            }
            notesFolder.setParent(notesFolder2);
        }
        PredefinedCategory predefinedCategoryFind = PredefinedCategory.find(notesFolder.getUuid());
        if (predefinedCategoryFind != null) {
            if (!sb.toString().isEmpty() && !sb.toString().endsWith(CategoryConstants.SEPARATOR)) {
                sb.append(File.separator);
            }
            sb.append(predefinedCategoryFind.getPath());
        } else {
            if (!sb.toString().endsWith(CategoryConstants.SEPARATOR)) {
                sb.append(File.separator);
            }
            sb.append(notesFolder.getDisplayName());
        }
        if (this.mInTrash || notesFolder.getIsDeleted() != 2) {
            notesFolder.setAbsolutePath(sb.toString());
        }
        this.mFolders.put(notesFolder.getUuid(), notesFolder);
    }

    public boolean existPath(String str) {
        DataLogger.m12307i(TAG, "existPath, path : " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (NotesFolder notesFolder : this.mFolders.values()) {
            if (str.equals(notesFolder.getAbsolutePath())) {
                boolean z = notesFolder.getIsDeleted() == (this.mInTrash ? 2 : 0);
                AbstractC11014a.m12335t("existPath, result : ", TAG, z);
                return z;
            }
        }
        DataLogger.m12307i(TAG, "existPath, result : false");
        return false;
    }

    public NotesFolder find(String str) {
        if (TextUtils.isEmpty(str)) {
            String uuid = (this.mInTrash ? PredefinedCategory.RECYCLE_BIN : PredefinedCategory.UNCATEGORIZED).getUuid();
            DataLogger.m12307i(TAG, "findCategory, uuid : " + uuid);
            return getFolder(uuid);
        }
        for (NotesFolder notesFolder : this.mFolders.values()) {
            if (str.equals(notesFolder.getAbsolutePath())) {
                DataLogger.m12307i(TAG, "findCategory, uuid : " + notesFolder.getUuid());
                return notesFolder;
            }
        }
        DataLogger.m12307i(TAG, "findCategory, uuid : null");
        return null;
    }

    public NotesFolder getFolder(@NonNull String str) {
        return this.mFolders.get(str);
    }

    public int getFolderCount() {
        return this.mFolders.size();
    }

    public Map<String, NotesFolder> getFolderMap() {
        return this.mFolders;
    }

    public List<String> getFolderUuids() {
        ArrayList arrayList = new ArrayList();
        Iterator<NotesFolder> it = getFolderMap().values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getUuid());
        }
        return arrayList;
    }

    public List<String> getPathList() {
        DataLogger.m12307i(TAG, "getPathList");
        ArrayList arrayList = new ArrayList();
        Iterator<NotesFolder> it = this.mFolders.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAbsolutePath());
        }
        DataLogger.m12307i(TAG, "getPathList, result : " + arrayList);
        return arrayList;
    }

    public DocumentCategoryTree(Collection<NotesFolder> collection, boolean z) {
        this.mFolders = new LinkedHashMap();
        this.mInTrash = z;
        int documentCount = 0;
        for (NotesFolder notesFolder : collection) {
            addFolder(notesFolder);
            documentCount += notesFolder.getDocumentCount();
        }
        DataLogger.m12307i(TAG, "constructor, rootCategories/folderMap/totalDocuments: " + collection.size() + "/" + this.mFolders.size() + "/" + documentCount);
    }
}
