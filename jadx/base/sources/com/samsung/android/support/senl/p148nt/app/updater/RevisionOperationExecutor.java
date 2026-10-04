package com.samsung.android.support.senl.p148nt.app.updater;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.converter.FolderConverterResources;
import com.samsung.android.support.senl.p148nt.app.updater.restore.DummyDocumentDetector;
import com.samsung.android.support.senl.p148nt.app.updater.version.VersionChecker;
import com.samsung.android.support.senl.p148nt.base.common.access.folder.FolderAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.tag.NotesTagRepository;
import com.samsung.android.support.senl.p148nt.model.collector.CollectController;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.updater.SDocSearchDataUpdater;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.category.CategoryColorConvertTask;
import com.samsung.android.support.senl.p148nt.model.executor.ModelThreadPoolExecutor;
import com.samsung.android.support.senl.p148nt.model.restore.document.RestoreCorruptDataManager;
import com.samsung.android.support.senl.p148nt.model.restore.folder.OldFolderSDocXDetector;
import p079T.AbstractC0299q;
import p079T.RunnableC0284b;
import p079T.RunnableC0286d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class RevisionOperationExecutor {
    private static final String TAG = "RevisionOperationExecutor";
    private final SharedPreferencesCompat mPreference = SharedPreferencesCompat.getInstance("APP_UPDATE_PREFERENCE");
    private final VersionChecker mVersionChecker;

    public RevisionOperationExecutor(VersionChecker versionChecker) {
        this.mVersionChecker = versionChecker;
    }

    private void checkSdocXInOldFolder(Context context) {
        execute(new RunnableC0286d(context, 3));
    }

    private void convertCategoryColor(Context context) {
        if (this.mVersionChecker.getMLastVersionCode() == -1) {
            Logger.m8702i(TAG, "convertCategoryColor, skip, first launch");
            return;
        }
        if (FolderAccessHandler.getContract() == null) {
            PostLaunchManager.getInstance().executeBaseLogic(1);
        }
        if (FolderAccessHandler.getContract() == null) {
            return;
        }
        int i = this.mPreference.getInt("KEY_CATEGORY_COLOR_CONVERSION", 1);
        AbstractC4539a.m3212v(i, "convertCategoryColor, count : ", TAG);
        if (i > 0) {
            this.mPreference.putInt("KEY_CATEGORY_COLOR_CONVERSION", i - 1);
            execute(new CategoryColorConvertTask(FolderAccessHandler.getContract().getResourceInjector(context.getResources())));
        }
    }

    private void deleteDummyDbData(Context context) {
        execute(new RunnableC0286d(context, 6));
    }

    private void deleteDummyFile(Context context) {
        execute(new RunnableC0286d(context, 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkSdocXInOldFolder$2(Context context) {
        TaskState.Companion companion = TaskState.INSTANCE;
        companion.getInstance().setIsRunning("RESTORE_TASK", true);
        boolean zExecute = new OldFolderSDocXDetector(context, new FolderConverterResources(context.getResources())).execute();
        companion.getInstance().setIsRunning("RESTORE_TASK", false);
        if (zExecute) {
            RequestToSyncManager.INSTANCE.requestSyncBackground();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteDummyDbData$3(Context context) {
        TaskState.Companion companion = TaskState.INSTANCE;
        companion.getInstance().setIsRunning("DELETE_DATA", true);
        context.deleteDatabase(DataConstants.SPEED_PROFILE_DB_NAME);
        NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(context);
        notesDataRepositoryFactoryNewInstance.createNotesDocumentPageRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createPageSearchInfoRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createDocumentContentRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createSearchRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createDocumentStrokeRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createDocumentRetryRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createDocumentTagRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createDocumentCoverRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createSuggestedCoverRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createOrganizedDocumentRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createSttContentRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createDocumentTempDataRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createDocumentExtraRepository().deleteDummy();
        NotesDatabaseManager.getInstance().getHashtagContentDao().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createCategoryTreeClosureRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createStickyNoteRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createExternalSharedDocumentsRepository().deleteDummy();
        notesDataRepositoryFactoryNewInstance.createDocumentThumbnailRepository().deleteDummy();
        companion.getInstance().setIsRunning("DELETE_DATA", false);
        new NotesTagRepository(context).notifyTagBoard();
        if (WidgetAccessHandler.getWidgetAccessContract() != null) {
            WidgetAccessHandler.getWidgetAccessContract().sendDeleteDummyWidgetBroadcast(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$recognizeSDocs$1() {
        SDocSearchDataUpdater.execute();
        CollectController.getInstance().postCollectorTask(new CollectParam.CollectParamBuilder().setActionType(ICollectParam.ActionType.UPDATE_NOTE_DOC_OBJECT_RECOGNITION.getValue()).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$removeSesSkipItems$5(Context context) {
        SharedPreferences.Editor editorEdit;
        synchronized (AbstractC0299q.class) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SesSkipItemManagerPref", 0);
            if (sharedPreferences != null && (editorEdit = sharedPreferences.edit()) != null) {
                editorEdit.remove("SesSkipItemManagerPref_Key_FileNames");
                editorEdit.apply();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$restoreCorruptData$0() {
        new RestoreCorruptDataManager().execute();
    }

    private void recognizeSDocs(Context context) {
        if (this.mVersionChecker.getMCurrentVersionCode() >= 410302000) {
            int i = this.mPreference.getInt("KEY_RECOGNIZE_SDOC", 0);
            AbstractC4539a.m3212v(i, "recognizeSDocs, version : ", TAG);
            if (i == 0) {
                if (RecognitionUtil.isSupported(context)) {
                    DataRepositoryScheduler.runnable(new RunnableC0284b(21)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
                } else {
                    this.mPreference.putInt("KEY_RECOGNIZE_SDOC", 1);
                }
            }
        }
    }

    private void removeSesSkipItems(Context context) {
        execute(new RunnableC0286d(context, 4));
    }

    private void restoreCorruptData() {
        execute(new RunnableC0284b(22));
    }

    private void restoreDummyNote(Context context) {
        if (TaskState.INSTANCE.getInstance().isRunning("RESTORE_TASK")) {
            return;
        }
        DummyDocumentDetector.checkBrokenDatabase(context);
    }

    private void restoreReservedFolders(Context context) {
    }

    public void execute(Context context) {
        restoreCorruptData();
        convertCategoryColor(context);
        recognizeSDocs(context);
        checkSdocXInOldFolder(context);
        deleteDummyDbData(context);
        deleteDummyFile(context);
        removeSesSkipItems(context);
        restoreReservedFolders(context);
        restoreDummyNote(context);
    }

    private void execute(@NonNull Runnable runnable) {
        ModelThreadPoolExecutor.getSingleThreadExecutor().execute(runnable);
    }
}
