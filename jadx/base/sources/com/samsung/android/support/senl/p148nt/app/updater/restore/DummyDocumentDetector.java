package com.samsung.android.support.senl.p148nt.app.updater.restore;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.AbstractC0622a;
import androidx.work.multiprocess.C4148a;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.scs.p140ai.sdkcommon.asr.C7233a;
import com.samsung.android.support.senl.addons.base.utils.FileUtils;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data.ImportDocument;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentExtensionUtils;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.temp.domain.model.DeletedNote;
import com.samsung.android.support.senl.p148nt.data.database.temp.p165di.ExtraDbRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.restore.folder.RestoreFolderCreator;
import com.samsung.android.support.senl.p148nt.model.utils.NotesDocumentDeleteUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import p006B.C0017a;
import p009B3.C0035a;
import p084U0.AbstractC0311c;
import p084U0.C0312d;
import p127c3.RunnableC4208a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DummyDocumentDetector {
    private static final int MAX_THREAD_POOL_COUNT = 3;
    public static final String NEED_TO_BE_RESTORED = "restore_db";
    public static final String PREF_KEY_PENDING_PATH_SET = "pending_path_set";
    private static final int RESTORE_DOCUMENT_THRESHOLD = 10;
    private static final String TAG = "DummyDocumentDetector";
    private static final AtomicBoolean sIsDummyFileDeleted = new AtomicBoolean(false);
    private final Context mAppContext;
    private C0312d mImportDocumentManager;
    private final NotesDocumentRepository mNotesDocumentRepository;
    private OnRestoreListener mOnRestoreListener;
    private final Set<String> mPendingPath = new ConcurrentSkipListSet();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnRestoreListener {
        void onFinish();

        void onStart();
    }

    public DummyDocumentDetector(@NonNull Context context) {
        this.mAppContext = context.getApplicationContext();
        this.mNotesDocumentRepository = new NotesDocumentRepository(context);
    }

    public static void checkBrokenDatabase(Context context) {
        int noteFileCount = getNoteFileCount(context);
        int noteCountInDatabase = getNoteCountInDatabase(context);
        Logger.m8702i(TAG, "checkBrokenDatabase: file/db: " + noteFileCount + "/" + noteCountInDatabase);
        if (isDatabaseBroken(noteCountInDatabase, noteFileCount)) {
            SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putBoolean(NEED_TO_BE_RESTORED, true);
        }
    }

    @WorkerThread
    public static void checkNeedToRestore(Context context) {
        deleteDummyFile(context);
        int noteFileCount = getNoteFileCount(context);
        int noteCountInDatabase = getNoteCountInDatabase(context);
        Logger.m8700f(TAG, "checkNeedToRestore: file/db: " + noteFileCount + "/" + noteCountInDatabase);
        if (isDatabaseBroken(noteCountInDatabase, noteFileCount) || dummyFileExists(noteCountInDatabase, noteFileCount)) {
            SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putBoolean(NEED_TO_BE_RESTORED, true);
        }
    }

    @WorkerThread
    public static void deleteDummyFile(Context context) {
        if (sIsDummyFileDeleted.get()) {
            return;
        }
        Logger.m8697d(TAG, "deleteDummyFile, start");
        TaskState.INSTANCE.getInstance().setIsRunning("DELETE_DATA", true);
        List<DeletedNote> deletedNotes = ExtraDbRepositoryFactory.createDeletedNoteRepository().getDeletedNotes();
        Set<DeletedNote> set = (Set) deletedNotes.stream().filter(new C7233a(NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().fetchActiveFilePaths((List) deletedNotes.stream().map(new C4662f(25)).collect(Collectors.toList())), 3)).collect(Collectors.toSet());
        int size = set.size();
        CountDownLatch countDownLatch = new CountDownLatch(set.size());
        C4148a c4148a = new C4148a(countDownLatch, size, 3);
        StringBuilder sb = new StringBuilder();
        for (DeletedNote deletedNote : set) {
            sb.append(SQLKeyword.COMMA);
            sb.append(Logger.getEncode(deletedNote.getFilePath()));
            NotesDocumentDeleteUtils.deleteDocumentFile(context, deletedNote.getUuid(), deletedNote.getFilePath(), true, false, 0, c4148a);
        }
        try {
            countDownLatch.await();
            TaskState.INSTANCE.getInstance().setIsRunning("DELETE_DATA", false);
            Logger.m8697d(TAG, "deleteDummyFile, end, total: " + size + ((Object) sb));
            sIsDummyFileDeleted.set(true);
        } catch (InterruptedException e) {
            Logger.m8698e(TAG, "deleteDummyFile, e: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static boolean dummyFileExists(int i, int i2) {
        return i2 >= i + 10;
    }

    private List<String> findRestorePath(Cursor cursor) {
        int columnIndex;
        ArrayList arrayList = new ArrayList();
        File[] sPenDocument = getSPenDocument(getContext());
        if (sPenDocument != null && sPenDocument.length != 0) {
            HashSet<String> hashSet = new HashSet();
            for (File file : sPenDocument) {
                String path = file.getPath();
                if (path.endsWith(".sdoc")) {
                    hashSet.add(path);
                } else {
                    arrayList.add(path);
                }
            }
            for (String str : hashSet) {
                if (arrayList.contains(str.substring(0, str.lastIndexOf(".sdoc")) + ".sdocx")) {
                    NotesDataTaskExecutor.getIOThreadExecutor().execute(new RunnableC4208a(str, 1));
                } else {
                    arrayList.add(str);
                }
            }
            if (cursor.getCount() > 0 && (columnIndex = cursor.getColumnIndex("filePath")) >= 0 && cursor.moveToFirst()) {
                do {
                    arrayList.remove(cursor.getString(columnIndex));
                } while (cursor.moveToNext());
            }
        }
        return arrayList;
    }

    private static int getNoteCountInDatabase(Context context) {
        Cursor cursorQuery = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().query("SELECT COUNT(*) FROM sdoc WHERE isDeleted != 1", null);
        int i = 0;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    i = cursorQuery.getInt(0);
                }
            } catch (Throwable th) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return i;
    }

    private static int getNoteFileCount(Context context) {
        File[] sPenDocument = getSPenDocument(context);
        if (sPenDocument != null) {
            return sPenDocument.length;
        }
        return 0;
    }

    private static File[] getSPenDocument(Context context) {
        return new File(WDocUtils.getNoteFilePath(context)).listFiles(new C0035a(5));
    }

    private void internalExecute(List<ImportDocument> list) {
        if (getOnRestoreListener() != null) {
            getOnRestoreListener().onStart();
        }
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(3, new SenlThreadFactory(TAG));
        C0312d c0312d = new C0312d(getContext(), list, TAG);
        c0312d.f807l = true;
        c0312d.f808m = new AbstractC0311c() { // from class: com.samsung.android.support.senl.nt.app.updater.restore.DummyDocumentDetector.1
            @Override // p084U0.InterfaceC0313e
            public void onFinish(int i, int i2, @NonNull Map<String, Integer> map, int i4) {
                if (DummyDocumentDetector.this.getOnRestoreListener() != null) {
                    DummyDocumentDetector.this.getOnRestoreListener().onFinish();
                }
                DummyDocumentDetector.this.mImportDocumentManager.m669h();
            }

            @Override // com.samsung.android.support.senl.nt.model.importer.task.ImportTask.ListerImpl, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
            public void onStart(@NonNull String str, @NonNull String str2) {
                DummyDocumentDetector.this.mPendingPath.remove(str2);
            }
        };
        this.mImportDocumentManager = c0312d;
        c0312d.f804i = executorServiceNewFixedThreadPool;
        c0312d.m664c(true);
    }

    private static boolean isDatabaseBroken(int i, int i2) {
        return i == 0 && i2 > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$deleteDummyFile$3(List list, DeletedNote deletedNote) {
        return !list.contains(deletedNote.getFilePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteDummyFile$4(CountDownLatch countDownLatch, int i, String str) {
        countDownLatch.countDown();
        Logger.m8702i(TAG, "deleteDummyFile: " + countDownLatch.getCount() + "/" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$findRestorePath$0(String str) {
        return Boolean.valueOf(FileUtils.deleteFile(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$findRestorePath$1(String str) {
        try {
            DocumentFileManager.getInstance().delete(str, new C0017a(str, 1));
            Logger.m8700f(TAG, "findRestorePath, delete dummy old doc, path: " + Logger.getEncode(str));
        } catch (IOException e) {
            Logger.m8698e(TAG, "findRestorePath, delete, path: " + Logger.getEncode(str) + ", e: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getSPenDocument$2(File file, String str) {
        return str.endsWith(".sdoc") || str.endsWith(".sdocx");
    }

    private void makeRestoreFolder(boolean z, boolean z2) {
        new RestoreFolderCreator(this.mAppContext).createFolders(z, z2);
    }

    public Set<String> cancel() {
        C0312d c0312d = this.mImportDocumentManager;
        if (c0312d != null) {
            Logger.m8702i(TAG, "cancel, remains : " + c0312d.m669h());
        }
        return this.mPendingPath;
    }

    public boolean execute() {
        return execute(getRestorePath());
    }

    public Context getContext() {
        return this.mAppContext;
    }

    public OnRestoreListener getOnRestoreListener() {
        return this.mOnRestoreListener;
    }

    public Set<String> getRestorePath() {
        ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet();
        Cursor cursorQuery = this.mNotesDocumentRepository.query("SELECT filePath FROM sdoc WHERE filePath LIKE '%.sdoc' OR filePath LIKE '%.sdocx'", null);
        try {
            Logger.m8702i(TAG, "getRestorePath, count : " + cursorQuery.getCount());
            concurrentSkipListSet.addAll(findRestorePath(cursorQuery));
            cursorQuery.close();
            Logger.m8702i(TAG, "getRestorePath, restore count : " + concurrentSkipListSet.size());
            return concurrentSkipListSet;
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

    public DummyDocumentDetector setOnRestoreListener(OnRestoreListener onRestoreListener) {
        this.mOnRestoreListener = onRestoreListener;
        return this;
    }

    public boolean execute(Set<String> set) {
        String str;
        if (set.isEmpty()) {
            return false;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(getNoteFileCount(this.mAppContext), getNoteCountInDatabase(this.mAppContext), "execute: file/db/remain: ", "/", "/");
        sbM1173s.append(set.size());
        Logger.m8702i(TAG, sbM1173s.toString());
        this.mPendingPath.clear();
        this.mPendingPath.addAll(set);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (String str2 : set) {
            if (DocumentExtensionUtils.isSdoc(str2)) {
                i2++;
                str = CategoryConstants.OldRestored.UUID;
            } else {
                i++;
                str = CategoryConstants.Restored.UUID;
            }
            arrayList.add(new ImportDocument(str2, str));
        }
        try {
            makeRestoreFolder(i > 0, i2 > 0);
            internalExecute(arrayList);
            return true;
        } catch (InvalidParentFolderException e) {
            Logger.m8698e(TAG, "fail to make restored folders, e : " + e.getMessage());
            return false;
        }
    }
}
