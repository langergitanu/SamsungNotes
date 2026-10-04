package com.samsung.android.support.senl.p148nt.model.restore.folder;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.access.folder.FolderAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.restore.NotesRestoreRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.category.CategoryColorConverter;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.category.CategoryToFolderConverter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class OldFolderSDocXDetector {
    private static final String TAG = ModelLogger.createTag("OldFolderSDocXDetector");
    private final NotesDatabase mDatabase = NotesDatabaseManager.getInstance();
    private final CategoryToFolderConverter mFolderConverter;
    private final NotesRestoreRepository mRestoreRepository;

    public OldFolderSDocXDetector(@NonNull Context context, @NonNull FolderAccessHandler.FolderColorResourceInjector folderColorResourceInjector) {
        this.mRestoreRepository = NotesDataRepositoryFactory.newInstance(context).createNotesRestoreRepository();
        this.mFolderConverter = new CategoryToFolderConverter(new CategoryColorConverter(folderColorResourceInjector));
    }

    private Map<String, String> getConvertedFolderMap(List<NotesDocumentEntity> list) {
        Set<String> oldCategorySet = getOldCategorySet(list);
        HashMap map = new HashMap();
        for (String str : oldCategorySet) {
            map.put(str, this.mFolderConverter.convert(str));
        }
        return map;
    }

    private Set<String> getOldCategorySet(List<NotesDocumentEntity> list) {
        HashSet hashSet = new HashSet();
        Iterator<NotesDocumentEntity> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getCategoryUuid());
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$execute$0() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<NotesDocumentEntity> sdocXInOldFolder = this.mRestoreRepository.getSdocXInOldFolder();
        Map<String, String> convertedFolderMap = getConvertedFolderMap(sdocXInOldFolder);
        long currentTime = TimeManager.getCurrentTime();
        for (NotesDocumentEntity notesDocumentEntity : sdocXInOldFolder) {
            String str = convertedFolderMap.get(notesDocumentEntity.getCategoryUuid());
            if (UUIDUtils.isCoeditUuid(notesDocumentEntity.getUuid())) {
                str = "coedit:///";
            } else if (!TextUtils.isEmpty(notesDocumentEntity.getMdeSpaceId())) {
                str = "shared:///";
            }
            if (str != null) {
                notesDocumentEntity.setCategoryUuid(str);
                notesDocumentEntity.setCategoryServerTimeStamp(Long.valueOf(currentTime));
                notesDocumentEntity.setCategoryIsDirty(1);
            }
        }
        this.mRestoreRepository.update(sdocXInOldFolder);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        DataLogger.m12307i(TAG, "restore sdocx in old folders, count: " + sdocXInOldFolder.size() + ", executionTime: " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
        return Boolean.valueOf(!sdocXInOldFolder.isEmpty());
    }

    public boolean execute() {
        return ((Boolean) this.mDatabase.runInTransaction(new CallableC11473c(this, 0))).booleanValue();
    }
}
