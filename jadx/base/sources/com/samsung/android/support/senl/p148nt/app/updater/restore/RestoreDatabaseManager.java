package com.samsung.android.support.senl.p148nt.app.updater.restore;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.executor.ModelThreadPoolExecutor;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.restore.document.DuplicatedDatabaseDetector;
import com.samsung.android.support.senl.p148nt.model.restore.folder.CircularFolderDetector;
import com.samsung.android.support.senl.p148nt.model.restore.search.RestoreBodyTextManager;
import p042J1.C0145c;
import p079T.RunnableC0284b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class RestoreDatabaseManager {
    private static final String PREF_KEY_GUARANTEED_RESTORE = "key_guaranteed_restore";
    private static final String PREF_KEY_INSERT_TO_EXTERNAL_SHARED_DOC = "PREF_KEY_INSERT_TO_EXTERNAL_SHARED_DOC";
    private static final String PREF_KEY_REPAIR_CIRCULAR_CATEGORY = "key_repair_circular_category";
    private static final String TAG = "RestoreDatabaseManager";

    private static void checkCircularCategory(Context context) {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE);
        if (sharedPreferencesCompat.getInt("key_repair_circular_category", 0) == 0) {
            new CircularFolderDetector(context).execute();
            sharedPreferencesCompat.putInt("key_repair_circular_category", 1);
        }
    }

    private static void insertExternalSharedDocuments() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE);
        if (sharedPreferencesCompat.getInt(PREF_KEY_INSERT_TO_EXTERNAL_SHARED_DOC, 0) > 0) {
            Logger.m8702i(TAG, "insertExternalSharedDocuments, start");
            NotesDatabaseManager.getInstance().getRestoreDao().insertToExternalSharedDocuments();
            sharedPreferencesCompat.putInt(PREF_KEY_INSERT_TO_EXTERNAL_SHARED_DOC, 0);
            Logger.m8702i(TAG, "insertExternalSharedDocuments, end");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$repairScreenOffMemoFolder$3() {
        NotesCategoryTreeEntity categoryEntity = FolderManager.getInstance().getCategoryEntity(CategoryConstants.ScreenOffMemo.UUID);
        if (categoryEntity == null || "uncategorized:///".equals(categoryEntity.getParentUuid())) {
            return;
        }
        try {
            FolderManager.getInstance().move(CategoryConstants.ScreenOffMemo.UUID, "uncategorized:///");
            Logger.m8700f(TAG, "repairScreenOffMemoFolder, folder is restored");
        } catch (InvalidParentFolderException e) {
            Logger.m8698e(TAG, "repairScreenOffMemoFolder, e: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$restore$1(int i) {
        Logger.m8702i(TAG, "restore, started");
        TaskState.Companion companion = TaskState.INSTANCE;
        companion.getInstance().setIsRunning("RESTORE_TASK", true);
        RestoreBodyTextManager.checkAppVersionToRestore(i);
        DuplicatedDatabaseDetector.checkNeedToArrange();
        companion.getInstance().setIsRunning("RESTORE_TASK", false);
        Logger.m8702i(TAG, "restore, finished");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$restoreAfterInit$0() {
        NotesDataRepositoryFactory.newInstance(DataUtils.getContext()).createNotesRestoreRepository().restoreDisplayContent(40960);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$restoreGuaranteed$2(Context context, SharedPreferencesCompat sharedPreferencesCompat) {
        Logger.m8702i(TAG, "restoreGuaranteed, started");
        TaskState.INSTANCE.getInstance().setIsRunning("RESTORE_TASK", true);
        DummyDocumentDetector.checkNeedToRestore(context);
        repairUncategorizedFolder(context);
        repairScreenOffMemoFolder();
        checkCircularCategory(context);
        BaseUtils.getApplicationContext();
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(context).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(context).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        for (String str : syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListBySyncState(32768L)) {
            if (TextUtils.isEmpty(C0145c.m331p("SyncControlLowVersionNote", str, "")) ? true : !r6.equals(C0145c.m322g())) {
                Context applicationContext = BaseUtils.getApplicationContext();
                SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(applicationContext, applicationContext);
                NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                syncNoteDataRepositoryM3196f.removeNoteSyncStateFlag(str, 32768L);
            }
        }
        insertExternalSharedDocuments();
        TaskState.INSTANCE.getInstance().setIsRunning("RESTORE_TASK", false);
        RequestToSyncManager.INSTANCE.requestSyncByModification();
        sharedPreferencesCompat.putInt(PREF_KEY_GUARANTEED_RESTORE, 0);
        Logger.m8702i(TAG, "restoreGuaranteed, finished");
    }

    public static void prepareRestoreGuaranteed() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE);
        sharedPreferencesCompat.putInt(PREF_KEY_GUARANTEED_RESTORE, 1);
        int i = sharedPreferencesCompat.getInt(PREF_KEY_INSERT_TO_EXTERNAL_SHARED_DOC, 1);
        sharedPreferencesCompat.putInt(PREF_KEY_INSERT_TO_EXTERNAL_SHARED_DOC, i);
        Logger.m8702i(TAG, "prepareRestoreGuaranteed, insertToExternalSharedDoc: " + i);
    }

    private static void repairScreenOffMemoFolder() {
        FolderManager.getInstance().executeOperation(new RunnableC0284b(23));
    }

    private static void repairUncategorizedFolder(Context context) {
        NotesDataRepositoryFactory.newInstance(context).createNotesRestoreRepository().repairUncategorizedFolder();
    }

    public static void restore(final int i) {
        ModelThreadPoolExecutor.getSingleThreadExecutor().execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.updater.restore.a
            @Override // java.lang.Runnable
            public final void run() {
                RestoreDatabaseManager.lambda$restore$1(i);
            }
        });
    }

    public static void restoreAfterInit() {
        DataRepositoryScheduler.runnable(new RunnableC0284b(24)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
    }

    public static void restoreGuaranteed(Context context) {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE);
        if (sharedPreferencesCompat.getInt(PREF_KEY_GUARANTEED_RESTORE, 0) == 0) {
            return;
        }
        ModelThreadPoolExecutor.getSingleThreadExecutor().execute(new RunnableC8515c(context, sharedPreferencesCompat, 15));
    }
}
