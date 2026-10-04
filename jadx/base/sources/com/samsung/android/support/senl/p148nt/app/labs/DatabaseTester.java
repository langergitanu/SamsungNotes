package com.samsung.android.support.senl.p148nt.app.labs;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.restore.folder.FolderArrangeManager;
import java.io.File;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
class DatabaseTester {
    public static final String CORRUPT_END_TAG = "end_tag";
    public static final String CORRUPT_MEDIA_FILES = "@attach";
    private static final String TAG = "DatabaseTester";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$arrange$0(Context context) {
        rearrangeRawFolders(context);
        rearrangeDocumentTable(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$rearrangeDocumentTable$1(Context context) {
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
        List<NotesDocumentEntity> allDataList = notesDocumentRepositoryCreateDocumentDataRepository.getAllDataList(true);
        if (allDataList == null) {
            return;
        }
        for (NotesDocumentEntity notesDocumentEntity : allDataList) {
            notesDocumentEntity.setIsDirty(1);
            notesDocumentEntity.setCategoryServerTimeStamp(Long.valueOf(TimeManager.getCurrentTime()));
            if (FolderManager.getInstance().getCategoryEntity(notesDocumentEntity.getCategoryUuid()) == null) {
                notesDocumentEntity.setCategoryUuid(notesDocumentEntity.getFilePath().endsWith(".sdoc") ? "1" : PredefinedCategory.UNCATEGORIZED.getUuid());
            }
        }
        notesDocumentRepositoryCreateDocumentDataRepository.insert((Collection<NotesDocumentEntity>) allDataList);
        notesDocumentRepositoryCreateDocumentDataRepository.getDatabase().getSyncInfoDao().upsert((Collection) notesDocumentRepositoryCreateDocumentDataRepository.createSyncInfoEntities(allDataList));
        notesDocumentRepositoryCreateDocumentDataRepository.internalUpdateFolderTimeByKeepServerTimestampFlag(allDataList);
    }

    public void arrange(@NonNull final Context context) {
        DataRepositoryScheduler.runnable(new RunnableC8097b(this, context, 0)).observeOn(NotesDataTaskExecutor.getMainThreadExecutor()).observe(new OnCompletionListener<Object>() { // from class: com.samsung.android.support.senl.nt.app.labs.DatabaseTester.1
            @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
            public void onComplete(@Nullable Object obj) {
                Toast.makeText(context, "Success to rearrange database.", 0).show();
            }

            @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
            public void onFail(@NonNull Exception exc) {
                Toast.makeText(context, "fail to rearrange database.", 0).show();
            }
        }).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
    }

    public void clear(Context context) {
        NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().deleteAll();
    }

    public void corruptLastMemo(Context context, String str) {
        boolean z;
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
        Cursor cursorQuery = notesDocumentRepositoryCreateDocumentDataRepository.query("SELECT * FROM sdoc ORDER BY createdAt DESC LIMIT 1", null);
        try {
            int columnIndex = cursorQuery.getColumnIndex("UUID");
            int columnIndex2 = cursorQuery.getColumnIndex("filePath");
            if (cursorQuery.getCount() == 1 && cursorQuery.moveToFirst() && columnIndex >= 0 && columnIndex2 >= 0) {
                String string = cursorQuery.getString(columnIndex);
                String str2 = cursorQuery.getString(columnIndex2) + File.separator;
                if (CORRUPT_MEDIA_FILES.equals(str)) {
                    str2 = str2 + "media";
                }
                File file = new File(str2);
                if (file.exists() && file.isDirectory()) {
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles == null) {
                        cursorQuery.close();
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    z = false;
                    for (File file2 : fileArrListFiles) {
                        if (file2.getName().contains(str)) {
                            boolean zDelete = file2.delete();
                            sb.append("corruptLastMemo, path/isDeleted = ");
                            sb.append(Logger.getEncode(file2.getPath()));
                            sb.append('/');
                            sb.append(zDelete);
                            sb.append('\n');
                            z = true;
                        }
                    }
                    Logger.m8702i(TAG, sb.toString());
                } else {
                    z = false;
                }
                notesDocumentRepositoryCreateDocumentDataRepository.updateCorrupted(string, 1);
                Toast.makeText(context, z ? "Success to corrupt the last memo." : "Fail.", 0).show();
            }
            cursorQuery.close();
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void rearrangeDocumentTable(@NonNull Context context) {
        FolderManager.getInstance().executeOperation(new RunnableC8092a(context, 0));
    }

    public void rearrangeRawFolders(@NonNull Context context) {
        new FolderArrangeManager(context).arrangeFolders();
    }
}
