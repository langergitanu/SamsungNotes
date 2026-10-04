package com.samsung.android.support.senl.p148nt.model.restore.document;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.restore.NotesRestoreRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class RestoreCorruptDataManager {
    private static final String CORRUPTED_RESTORE_KEY = "restore_corruption_count";
    private static final String CORRUPTED_RESTORE_PROF_V1 = "restore_corruption_prof_v1";
    private static final int RESTORE_REPEAT_COUNT = 2;
    private static final String TAG = ModelLogger.createTag("RestoreCorruptDataManager");

    private void restore(@NonNull Context context) {
        NotesRestoreRepository notesRestoreRepositoryCreateNotesRestoreRepository = NotesDataRepositoryFactory.newInstance(context).createNotesRestoreRepository();
        List<NotesDocumentEntity> corruptNotes = notesRestoreRepositoryCreateNotesRestoreRepository.getCorruptNotes();
        DataLogger.m12307i(TAG, "execute, corruptNotes count : " + corruptNotes.size());
        if (corruptNotes.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("restoreCorruptData#, /// ");
        for (NotesDocumentEntity notesDocumentEntity : corruptNotes) {
            String filePath = notesDocumentEntity.getFilePath();
            if (AbstractC2322a.m1607A(filePath) && filePath.endsWith(".sdocx")) {
                restoreEntity(notesDocumentEntity, filePath);
                notesRestoreRepositoryCreateNotesRestoreRepository.update(notesDocumentEntity);
            } else {
                sb.append("Invalid : ");
                sb.append(notesDocumentEntity);
                sb.append('/');
            }
        }
        DataLogger.m12305f(TAG, sb.toString());
    }

    private void restoreEntity(NotesDocumentEntity notesDocumentEntity, String str) {
        long jConvertSdkTimeToAppTime = TimeManager.convertSdkTimeToAppTime(SpenWNoteFile.getLastModifiedTime(str));
        notesDocumentEntity.setCreatedAt(TimeManager.convertSdkTimeToAppTime(SpenWNoteFile.getCreatedTime(str)));
        notesDocumentEntity.setLastModifiedAt(jConvertSdkTimeToAppTime);
        notesDocumentEntity.setLastMappedAt(0L);
        notesDocumentEntity.setServerTimestamp(Long.valueOf(jConvertSdkTimeToAppTime));
        notesDocumentEntity.setCategoryServerTimeStamp(0L);
        notesDocumentEntity.setCategoryUuid(PredefinedCategory.UNCATEGORIZED.getUuid());
        notesDocumentEntity.setCategoryIsDirty(0);
        notesDocumentEntity.setRecycleBinTimeMoved(0L);
        notesDocumentEntity.setIsFavorite(0);
        notesDocumentEntity.setIsLock(SpenWNoteFile.isLocked(str) ? 5 : 0);
    }

    public void execute() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance(CORRUPTED_RESTORE_PROF_V1);
        int i = sharedPreferencesCompat.getInt(CORRUPTED_RESTORE_KEY, 2);
        String str = TAG;
        DataLogger.m12302d(str, "restore, current repeat count : " + i);
        if (i <= 0) {
            DataLogger.m12302d(str, "restore, count invalid");
            return;
        }
        sharedPreferencesCompat.putInt(CORRUPTED_RESTORE_KEY, i - 1);
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null || !SpenSdkInitializer.initialize(applicationContext)) {
            return;
        }
        restore(applicationContext);
    }
}
