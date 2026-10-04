package com.samsung.android.support.senl.p148nt.app.main.noteslist;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.synchronization.managers.AbstractC6905h;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.app.notes.sync.synchronization.managers.SyncStateManager$SyncFailState;
import com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async;
import com.samsung.android.support.notes.bixby.bixby2.aid.ActionResult;
import com.samsung.android.support.notes.bixby.bixby2.aid.AppState;
import com.samsung.android.support.notes.bixby.bixby2.aid.BixbyAiParam;
import com.samsung.android.support.notes.bixby.bixby2.aid.BixbySearchParam;
import com.samsung.android.support.notes.bixby.bixby2.aid.ContextNoteInfo;
import com.samsung.android.support.notes.bixby.bixby2.aid.FolderInfo;
import com.samsung.android.support.notes.bixby.bixby2.aid.MainListValue;
import com.samsung.android.support.notes.bixby.bixby2.aid.NoteInfo;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound;
import com.samsung.android.support.notes.bixby.bixby2.contract.IDrawerFragmentBixby2;
import com.samsung.android.support.notes.bixby.bixby2.contract.INoteFragmentBixby2;
import com.samsung.android.support.notes.bixby.bixby2.contract.INoteListActivityBixby2;
import com.samsung.android.support.senl.p145cm.base.common.constants.WebConstants;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.AppTaskCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.data.RepositoryManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.RunnableC8212b;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.BixbyNoteListInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckedNoteInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.NotesView;
import com.samsung.android.support.senl.p148nt.app.nativecomposer.ComposerActivity;
import com.samsung.android.support.senl.p148nt.app.trigger.OpaqueDocOpenTriggerActivity;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayData;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayDataHelper;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend.ActionSendHelperAppFunction;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.PdfWriterActivity;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.DocumentTextData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchFilterParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.model.domain.folder.AddFolderUseCase;
import com.samsung.android.support.senl.p148nt.model.domain.folder.DeleteFolderUseCase;
import com.samsung.android.support.senl.p148nt.model.domain.folder.UpdateFolderUseCase;
import com.samsung.android.support.senl.p148nt.model.domain.note.UpdateNoteUseCase;
import com.samsung.android.support.senl.p148nt.model.domain.search.SearchFolderUseCase;
import com.samsung.android.support.senl.p148nt.model.domain.search.SearchNoteUseCase;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.service.NotesWordDocumentServiceIntent;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import p001A.AbstractC0000a;
import p042J1.C0145c;
import p192j1.C12936a;
import p207n1.C13541h;
import p244u1.C14477a;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class Bixby2 {
    private static final String TAG = "Bixby2";
    private static final long UPDATE_NOTE_TIME_OUT = 3000;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Bixby2ActionBackground implements IBixby2ActionBackgound {
        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound
        public void createFolder(@NonNull AbsBixby2Async.AsyncParam asyncParam, @Nullable String str) {
            new CreateFolderAsync(asyncParam, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound
        public void deleteFolders(@NonNull AbsBixby2Async.AsyncParam asyncParam, @Nullable String[] strArr) {
            if (strArr == null) {
                return;
            }
            new DeleteFoldersAsync(asyncParam, new ArrayList(Arrays.asList(strArr))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound
        public void deleteNotes(String[] strArr, @NonNull AbsBixby2Async.AsyncParam asyncParam, Runnable runnable) {
            if (strArr == null || !Bixby2.isValidUUIDs(strArr)) {
                return;
            }
            if (LockUtils.isUnLockedDocType(NotesUtils.isLockedNotes(strArr))) {
                new DeleteAsync(asyncParam, new ArrayList(Arrays.asList(strArr))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                MainLogger.m7258i(Bixby2.TAG, "deleteNotes - not used");
            }
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound
        public void diagnoseTroubleShooting(String str, @NonNull AbsBixby2Async.AsyncParam asyncParam) {
            new DiagnoseTroubleShootingAsync(str, asyncParam).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound
        public void getAppState(@NonNull AbsBixby2Async.AsyncParam asyncParam) {
            new GetAppStateAsync(asyncParam).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound
        public void isNoteEmpty(@NonNull AbsBixby2Async.AsyncParam asyncParam) {
            new IsNoteEmptyAsync(asyncParam).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound
        public boolean isValidUUIDs(String[] strArr) {
            if (strArr == null) {
                return false;
            }
            return Bixby2.isValidUUIDs(strArr);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound
        public void saveNotes(String str, String str2, String str3, @NonNull AbsBixby2Async.AsyncParam asyncParam) {
            new SaveAsync(asyncParam, str, str2, str3).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound
        public void searchFolders(@NonNull AbsBixby2Async.AsyncParam asyncParam, String str) {
            new SearchFoldersAsync(asyncParam, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound
        public void searchNotes(@NonNull BixbySearchParam bixbySearchParam, @NonNull AbsBixby2Async.AsyncParam asyncParam) {
            new SearchAsync(asyncParam, bixbySearchParam).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound
        public void showRecentNotes(int i, @NonNull AbsBixby2Async.AsyncParam asyncParam) {
            new ShowRecentNotesAsync(i, asyncParam).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound
        public void updateFolder(@NonNull AbsBixby2Async.AsyncParam asyncParam, @Nullable String str, @Nullable String str2) {
            new UpdateFolderAsync(asyncParam, str, str2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound
        public void updateNotes(String str, String str2, String str3, @NonNull AbsBixby2Async.AsyncParam asyncParam) {
            new UpdateAsync(asyncParam, str, str2, str3).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CreateFolderAsync extends AbsBixby2Async {
        private final String mFolderName;

        public CreateFolderAsync(AbsBixby2Async.AsyncParam asyncParam, String str) {
            super(asyncParam);
            this.mFolderName = str;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async
        public ActionResult backgroundOperation() {
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_createFolderThread start");
            ActionResult actionResult = new ActionResult();
            actionResult.setResult(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            actionResult.setDescription(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            if (this.mFolderName == null) {
                MainLogger.m7258i(AbsBixby2Async.TAG, "folder name is null");
                return actionResult;
            }
            NotesCategoryTreeEntity notesCategoryTreeEntity = new NotesCategoryTreeEntity(UUIDUtils.newUUID(this.mContext), "uncategorized:///", this.mFolderName, null);
            if (new AddFolderUseCase().execute(notesCategoryTreeEntity)) {
                ArrayList<FolderInfo> arrayList = new ArrayList<>();
                FolderInfo folderInfo = new FolderInfo();
                folderInfo.setFolderID(notesCategoryTreeEntity.getUuid());
                folderInfo.setFolderName(notesCategoryTreeEntity.getDisplayName());
                arrayList.add(folderInfo);
                actionResult.setFolderInfo(arrayList);
                actionResult.setResult("success");
                actionResult.setDescription("success");
            } else {
                MainLogger.m7258i(AbsBixby2Async.TAG, "Folder creation failure!");
            }
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_createFolderThread end");
            return actionResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DeleteAsync extends AbsBixby2Async {
        private final List<String> mUuidList;

        public DeleteAsync(AbsBixby2Async.AsyncParam asyncParam, List<String> list) {
            super(asyncParam);
            this.mUuidList = list;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async
        public ActionResult backgroundOperation() {
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_deleteThread start");
            ActionResult actionResult = new ActionResult();
            actionResult.setResult(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            actionResult.setDescription(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            List<String> list = this.mUuidList;
            if (list == null || list.isEmpty()) {
                MainLogger.m7258i(AbsBixby2Async.TAG, "delete param is null");
                return actionResult;
            }
            for (String str : this.mUuidList) {
                if (ComposerManager.getInstance().isOpen(str, null)) {
                    AbstractC8014b.m7209k("is opened : ", str, AbsBixby2Async.TAG);
                    return actionResult;
                }
            }
            DocumentWriteResolver.delete(this.mContext, this.mUuidList, 2, AbsBixby2Async.TAG);
            actionResult.setResult("success");
            actionResult.setDescription("success");
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_deleteThread end");
            return actionResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DeleteFoldersAsync extends AbsBixby2Async {
        private final List<String> mFolderIdList;

        public DeleteFoldersAsync(AbsBixby2Async.AsyncParam asyncParam, List<String> list) {
            super(asyncParam);
            this.mFolderIdList = list;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async
        public ActionResult backgroundOperation() {
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_deleteFoldersThread start");
            ActionResult actionResult = new ActionResult();
            actionResult.setResult(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            actionResult.setDescription(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            List<String> list = this.mFolderIdList;
            if (list == null || list.isEmpty()) {
                MainLogger.m7258i(AbsBixby2Async.TAG, "delete param is null");
                return actionResult;
            }
            DeleteFolderUseCase.Result resultExecute = new DeleteFolderUseCase(NotesDataRepositoryFactory.newInstance(this.mContext).createCategoryTreeClosureRepository()).execute(this.mFolderIdList);
            if (resultExecute == null || resultExecute.getDeletedFolders().isEmpty()) {
                MainLogger.m7258i(AbsBixby2Async.TAG, "delete result is null");
            } else {
                actionResult.setResult("success");
                actionResult.setDescription("success");
            }
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_deleteFoldersThread end");
            return actionResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DiagnoseTroubleShootingAsync extends AbsBixby2Async {
        private final String mCategory;

        public DiagnoseTroubleShootingAsync(String str, AbsBixby2Async.AsyncParam asyncParam) {
            super(asyncParam);
            this.mCategory = str;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async
        public ActionResult backgroundOperation() {
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_diagnoseTroubleShootingThread start");
            ActionResult actionResult = new ActionResult();
            if (this.mCategory.equals(Bixby2Constants.BIXBY_PARAM_NOTE_SYNCHRONIZATION_FAILED)) {
                C14477a.m15065b().getClass();
                C6906i c6906iM5136c = C6906i.m5136c();
                c6906iM5136c.getClass();
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext == null) {
                    Debugger.m8609e("SyncStateManager", "getCurrentSyncFailState() : appContext is null!");
                    c6906iM5136c.f4483b = SyncStateManager$SyncFailState.UNKNOWN;
                } else if (C0145c.m299G(applicationContext) && !C0145c.m298F(applicationContext)) {
                    c6906iM5136c.f4483b = SyncStateManager$SyncFailState.WIFI_ONLY;
                } else if (DeviceUtils.isPowerSavingMode(applicationContext)) {
                    c6906iM5136c.f4483b = SyncStateManager$SyncFailState.POWER_SAVING;
                } else if (ContentResolver.getMasterSyncAutomatically()) {
                    C12936a.m13839c().getClass();
                    if (!C12936a.m13842g()) {
                        c6906iM5136c.f4483b = SyncStateManager$SyncFailState.PHONE_PERMISSION;
                    } else if (C0145c.m334s(applicationContext)) {
                        Debugger.m8615i("SyncStateManager", "getCurrentSyncFailState() : Not matched!");
                        c6906iM5136c.f4483b = SyncStateManager$SyncFailState.UNKNOWN;
                    } else {
                        c6906iM5136c.f4483b = SyncStateManager$SyncFailState.NETWORK;
                    }
                } else {
                    c6906iM5136c.f4483b = SyncStateManager$SyncFailState.MASTER_SYNC;
                }
                int i = AbstractC6905h.f4480a[((SyncStateManager$SyncFailState) c6906iM5136c.f4483b).ordinal()];
                int i2 = 1;
                if (i != 1) {
                    i2 = 2;
                    if (i != 2) {
                        i2 = 3;
                        if (i != 3) {
                            i2 = 4;
                            if (i != 4) {
                                if (i != 5) {
                                    Debugger.m8615i("SyncStateManager", "convertSyncFailStateForBixby() : UNKNOWN");
                                } else {
                                    Debugger.m8615i("SyncStateManager", "convertSyncFailStateForBixby() : NETWORK");
                                }
                                i2 = 0;
                            } else {
                                Debugger.m8615i("SyncStateManager", "convertSyncFailStateForBixby() : PHONE_PERMISSION");
                            }
                        } else {
                            Debugger.m8615i("SyncStateManager", "convertSyncFailStateForBixby() : MASTER_SYNC");
                        }
                    } else {
                        Debugger.m8615i("SyncStateManager", "convertSyncFailStateForBixby() : POWER_SAVING");
                    }
                } else {
                    Debugger.m8615i("SyncStateManager", "convertSyncFailStateForBixby() : WIFI_ONLY");
                }
                MainLogger.m7258i(AbsBixby2Async.TAG, "DiagnoseTroubleShootingAsync# " + this.mCategory + SQLKeyword.COMMA + i2);
                CommonSamsungAnalytics.insertLog(Bixby2Constants.EVENT_BIXBY_DEVICE_QNA_SYNC_PROBLEM, String.valueOf(i2));
                actionResult.setContentIdx(i2);
                actionResult.setResult("success");
                actionResult.setDescription("success");
            } else {
                actionResult.setResult(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
                actionResult.setDescription(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            }
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_diagnoseTroubleShootingThread end");
            return actionResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DrawerFragmentBixby2 implements IDrawerFragmentBixby2 {
        private static DrawerFragmentBixby2 mInstance;
        private DrawerLayout mDrawerLayout;

        public static synchronized DrawerFragmentBixby2 getInstance() {
            try {
                if (mInstance == null) {
                    mInstance = new DrawerFragmentBixby2();
                }
            } catch (Throwable th) {
                throw th;
            }
            return mInstance;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.IDrawerFragmentBixby2
        public void closeDrawer() {
            if (this.mDrawerLayout != null) {
                MainLogger.m7254d(Bixby2.TAG, "closeDrawer");
                this.mDrawerLayout.close();
            }
        }

        public void release() {
            if (this.mDrawerLayout != null) {
                this.mDrawerLayout = null;
            }
            if (mInstance != null) {
                mInstance = null;
            }
        }

        public void setDrawerLayout(DrawerLayout drawerLayout) {
            this.mDrawerLayout = drawerLayout;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GetAppStateAsync extends AbsBixby2Async {
        public GetAppStateAsync(AbsBixby2Async.AsyncParam asyncParam) {
            super(asyncParam);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async
        public ActionResult backgroundOperation() {
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_getAppStateThread start");
            ActionResult actionResult = new ActionResult();
            AppState appState = new AppState();
            appState.setExistEditingNote("false");
            actionResult.setAppState(appState);
            actionResult.setResult(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            Activity composerToAddContent = ComposerManager.getInstance().getComposerToAddContent(0);
            if (composerToAddContent == null) {
                actionResult.setDescription("failure - activity is null");
                return actionResult;
            }
            if (AppTaskCompat.getInstance().getAppTask(BaseUtils.getApplicationContext(), composerToAddContent.getTaskId()) == null) {
                actionResult.setDescription("failure - appTask is null");
                return actionResult;
            }
            appState.setExistEditingNote("true");
            actionResult.setAppState(appState);
            actionResult.setResult("success");
            actionResult.setDescription("success");
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_getAppStateThread end");
            return actionResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IsNoteEmptyAsync extends AbsBixby2Async {
        public IsNoteEmptyAsync(AbsBixby2Async.AsyncParam asyncParam) {
            super(asyncParam);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async
        public ActionResult backgroundOperation() {
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_isNoteEmptyThread start");
            ActionResult actionResult = new ActionResult();
            actionResult.setResult(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            actionResult.setDescription(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            boolean z = !NotesDataRepositoryFactory.newInstance(this.mContext).createSearchRepository().isEmptyForSearchLatestNotes();
            MainLogger.m7258i(AbsBixby2Async.TAG, "isEmpty : " + z);
            actionResult.setResult("success");
            actionResult.setDescription("success");
            actionResult.setNoteEmpty(Boolean.valueOf(z));
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_isNoteEmptyThread end");
            return actionResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SaveAsync extends AbsBixby2Async {
        String mContent;
        String mFolderPath;
        String mNoteTitle;

        public SaveAsync(AbsBixby2Async.AsyncParam asyncParam, String str, String str2, String str3) {
            super(asyncParam);
            this.mNoteTitle = str;
            this.mContent = str2;
            this.mFolderPath = str3;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async
        public ActionResult backgroundOperation() {
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_saveThread start");
            ActionResult actionResult = new ActionResult();
            actionResult.setResult(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            actionResult.setDescription(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            if (this.mNoteTitle == null && this.mContent == null) {
                MainLogger.m7258i(AbsBixby2Async.TAG, "title & content is null");
                return actionResult;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(FolderConstants.MyFolders.PATH);
            String str = this.mFolderPath;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            this.mFolderPath = sb.toString();
            Context context = this.mContext;
            String strSaveMemo = NotesWordDocumentServiceIntent.saveMemo(context, UUIDUtils.newUUID(context), null, this.mNoteTitle, this.mContent, null, null, this.mFolderPath);
            MainLogger.m7258i(AbsBixby2Async.TAG, "backgroundOperation - uuid : " + strSaveMemo);
            ArrayList<NoteInfo> arrayList = new ArrayList<>();
            NoteInfo noteInfo = new NoteInfo();
            noteInfo.setNoteID(strSaveMemo);
            String str2 = this.mNoteTitle;
            if (str2 == null) {
                str2 = "";
            }
            noteInfo.setNoteTitle(str2);
            String str3 = this.mContent;
            noteInfo.setContent(str3 != null ? str3 : "");
            noteInfo.setFavorite(false);
            noteInfo.setLocked(false);
            noteInfo.setCategory(this.mFolderPath);
            arrayList.add(noteInfo);
            actionResult.setNoteInfo(arrayList);
            actionResult.setResult("success");
            actionResult.setDescription("success");
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_saveThread end");
            return actionResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SearchAsync extends AbsBixby2Async {
        private static final String TRUE = "true";
        private String mFolderName;
        private final String mIsFavorite;
        private final String mIsLocked;
        private final String mIsScreenOffMemo;
        private final String mKeyTimeFrom;
        private final String mKeyTimeTo;
        private String mKeyword;

        public SearchAsync(AbsBixby2Async.AsyncParam asyncParam, BixbySearchParam bixbySearchParam) {
            super(asyncParam);
            this.mKeyword = bixbySearchParam.getKeyword();
            this.mFolderName = bixbySearchParam.getCategory();
            this.mIsFavorite = bixbySearchParam.getIsFavorite();
            this.mIsLocked = bixbySearchParam.getIsLocked();
            this.mIsScreenOffMemo = bixbySearchParam.getIsScreenOffMemo();
            this.mKeyTimeFrom = bixbySearchParam.getKeyTimeFrom();
            this.mKeyTimeTo = bixbySearchParam.getKeyTimeTo();
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x0141  */
        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ActionResult backgroundOperation() {
            String content;
            DisplayData displayData;
            String str;
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_searchThread start");
            ActionResult actionResult = new ActionResult();
            actionResult.setResult(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            actionResult.setDescription(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            String str2 = this.mKeyword;
            if (str2 == null && this.mFolderName == null && this.mIsFavorite == null && this.mIsLocked == null && this.mIsScreenOffMemo == null && this.mKeyTimeFrom == null && this.mKeyTimeTo == null) {
                MainLogger.m7258i(AbsBixby2Async.TAG, "searching param is null");
                return actionResult;
            }
            if (str2 == null) {
                this.mKeyword = "";
            }
            if ("true".equals(this.mIsScreenOffMemo)) {
                this.mFolderName = PredefinedCategory.SCREEN_OFF_MEMO.getDisplayName();
            } else if (this.mFolderName == null) {
                this.mFolderName = "";
            }
            long j = 0;
            try {
                str = this.mKeyTimeFrom;
            } catch (NumberFormatException e) {
                MainLogger.m7255e(AbsBixby2Async.TAG, "TimeFrom is invalid, e: " + e.getMessage());
            }
            long j2 = str != null ? Long.parseLong(str) : 0L;
            try {
                String str3 = this.mKeyTimeTo;
                if (str3 != null) {
                    j = Long.parseLong(str3);
                }
            } catch (NumberFormatException e2) {
                MainLogger.m7255e(AbsBixby2Async.TAG, "TimeTo is invalid, e: " + e2.getMessage());
            }
            SearchParam filterParam = new SearchParam(this.mKeyword).setSortParam(NotesUtils.getSortParam()).setSearchMode(1).setQueryFolderName(this.mFolderName).setFavoriteNoteOnly("true".equals(this.mIsFavorite)).setLockedNoteOnly("true".equals(this.mIsLocked)).setFilterParam(new SearchFilterParam().setFromTime(j2).setToTime(j));
            NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(this.mContext);
            List<MainListDocumentData> totalNotes = new SearchNoteUseCase(notesDataRepositoryFactoryNewInstance.createSearchRepository(), notesDataRepositoryFactoryNewInstance.createMainListDocumentDataRepository()).invoke(filterParam).getTotalNotes();
            if (totalNotes.isEmpty()) {
                actionResult.setResult("success");
                actionResult.setDescription("Note count is 0");
                return actionResult;
            }
            ArrayList<NoteInfo> arrayList = new ArrayList<>();
            ArrayList<NoteInfo> arrayList2 = new ArrayList<>();
            for (MainListDocumentData mainListDocumentData : totalNotes) {
                byte[] displayContent = mainListDocumentData.getDisplayContent();
                if (displayContent != null) {
                    try {
                        displayData = (DisplayData) DisplayDataHelper.unmarshall(displayContent, DisplayData.CREATOR);
                    } catch (Exception e3) {
                        AbstractC14516b.m15115c(e3, new StringBuilder("backgroundOperation# DisplayData e : "), AbsBixby2Async.TAG);
                    }
                    content = displayData != null ? displayData.getContent() : "";
                    if (content == null) {
                        content = "";
                    }
                }
                NotesFolder notesFolder = FolderManager.getInstance().getNotesFolder(mainListDocumentData.getCategoryUuid(), false);
                if (notesFolder != null) {
                    String displayName = notesFolder.getDisplayName();
                    NoteInfo noteInfo = new NoteInfo();
                    noteInfo.setNoteID(mainListDocumentData.getUuid());
                    noteInfo.setNoteTitle(mainListDocumentData.getTitle());
                    noteInfo.setContent(content.toString());
                    noteInfo.setFavorite(mainListDocumentData.getIsFavorite() == 1);
                    noteInfo.setLocked(mainListDocumentData.getIsLock() == 5 || LockUtils.isLockedSdocType(mainListDocumentData.getIsLock()));
                    noteInfo.setCategory(displayName);
                    String str4 = this.mFolderName;
                    if (str4 == null || str4.equals(displayName)) {
                        arrayList.add(noteInfo);
                    } else {
                        arrayList2.add(noteInfo);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                actionResult.setNoteInfo(arrayList2);
            } else {
                actionResult.setNoteInfo(arrayList);
            }
            actionResult.setResult("success");
            actionResult.setDescription("success");
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_searchThread end, notes:" + totalNotes.size());
            return actionResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SearchFoldersAsync extends AbsBixby2Async {
        private final String mFolderName;

        public SearchFoldersAsync(AbsBixby2Async.AsyncParam asyncParam, String str) {
            super(asyncParam);
            this.mFolderName = str;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async
        public ActionResult backgroundOperation() {
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_searchFoldersThread start");
            ActionResult actionResult = new ActionResult();
            actionResult.setResult(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            actionResult.setDescription(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            String str = this.mFolderName;
            if (str == null) {
                MainLogger.m7258i(AbsBixby2Async.TAG, "folder name is null");
                return actionResult;
            }
            List<NotesCategoryTreeEntity> listInvoke = new SearchFolderUseCase(NotesDataRepositoryFactory.newInstance(this.mContext).createSearchRepository()).invoke(new SearchParam(str).addStrategy(4));
            if (listInvoke.isEmpty()) {
                actionResult.setResult("success");
                actionResult.setDescription("Folder count is 0");
                return actionResult;
            }
            ArrayList<FolderInfo> arrayList = new ArrayList<>();
            for (NotesCategoryTreeEntity notesCategoryTreeEntity : listInvoke) {
                FolderInfo folderInfo = new FolderInfo();
                folderInfo.setFolderID(notesCategoryTreeEntity.getUuid());
                folderInfo.setFolderName(notesCategoryTreeEntity.getDisplayName());
                arrayList.add(folderInfo);
            }
            actionResult.setFolderInfo(arrayList);
            actionResult.setResult("success");
            actionResult.setDescription("success");
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_searchFoldersThread end, folders:" + listInvoke.size());
            return actionResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ShowRecentNotesAsync extends AbsBixby2Async {
        private static final int MAX_COUNT = 20;
        private int mMaxCount;

        public ShowRecentNotesAsync(int i, AbsBixby2Async.AsyncParam asyncParam) {
            super(asyncParam);
            this.mMaxCount = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ActionResult backgroundOperation() {
            String content;
            DisplayData displayData;
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_showRecentNotesThread start");
            ActionResult actionResult = new ActionResult();
            actionResult.setResult(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            actionResult.setDescription(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            int iMin = Math.min(20, this.mMaxCount);
            this.mMaxCount = iMin;
            if (iMin < 1) {
                AbstractC8014b.m7212n(new StringBuilder("max count was wrong! : "), AbsBixby2Async.TAG, this.mMaxCount);
                return actionResult;
            }
            SearchParam maxCount = new SearchParam("").setSearchMode(2).setMaxCount(this.mMaxCount);
            NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(this.mContext);
            List<MainListDocumentData> totalNotes = new SearchNoteUseCase(notesDataRepositoryFactoryNewInstance.createSearchRepository(), notesDataRepositoryFactoryNewInstance.createMainListDocumentDataRepository()).invoke(maxCount).getTotalNotes();
            if (totalNotes.isEmpty()) {
                actionResult.setResult("success");
                actionResult.setDescription("Note count is 0");
                return actionResult;
            }
            ArrayList<NoteInfo> arrayList = new ArrayList<>();
            for (MainListDocumentData mainListDocumentData : totalNotes) {
                byte[] displayContent = mainListDocumentData.getDisplayContent();
                if (displayContent != null) {
                    try {
                        displayData = (DisplayData) DisplayDataHelper.unmarshall(displayContent, DisplayData.CREATOR);
                    } catch (Exception e) {
                        AbstractC14516b.m15115c(e, new StringBuilder("backgroundOperation# DisplayData e : "), AbsBixby2Async.TAG);
                    }
                    content = displayData != null ? displayData.getContent() : "";
                    if (content == null) {
                        content = "";
                    }
                }
                NotesFolder notesFolder = FolderManager.getInstance().getNotesFolder(mainListDocumentData.getCategoryUuid(), false);
                if (notesFolder != null) {
                    String displayName = notesFolder.getDisplayName();
                    NoteInfo noteInfo = new NoteInfo();
                    noteInfo.setNoteID(mainListDocumentData.getUuid());
                    noteInfo.setNoteTitle(mainListDocumentData.getTitle());
                    noteInfo.setContent(content.toString());
                    noteInfo.setFavorite(mainListDocumentData.getIsFavorite() == 1);
                    noteInfo.setLocked(mainListDocumentData.getIsLock() == 5 || LockUtils.isLockedSdocType(mainListDocumentData.getIsLock()));
                    noteInfo.setCategory(displayName);
                    arrayList.add(noteInfo);
                    MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_showRecentNotesThread : " + mainListDocumentData.getUuid() + SQLKeyword.COMMA + mainListDocumentData.getTitle());
                }
            }
            if (!arrayList.isEmpty()) {
                actionResult.setNoteInfo(arrayList);
            }
            actionResult.setResult("success");
            actionResult.setDescription("success");
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_showRecentNotesThread end");
            return actionResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UpdateAsync extends AbsBixby2Async {
        String mContent;
        String mNoteId;
        String mNoteTitle;

        public UpdateAsync(AbsBixby2Async.AsyncParam asyncParam, String str, String str2, String str3) {
            super(asyncParam);
            this.mNoteId = str;
            this.mNoteTitle = str2;
            this.mContent = str3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$backgroundOperation$0(UpdateNoteUseCase.UpdateNoteParam updateNoteParam) {
            Activity composerToAddContent = ComposerManager.getInstance().getComposerToAddContent(0);
            if (composerToAddContent == null) {
                MainLogger.m7254d(AbsBixby2Async.TAG, "UpdateAsync - activity is null");
                return;
            }
            ActivityManager.AppTask appTask = AppTaskCompat.getInstance().getAppTask(BaseUtils.getApplicationContext(), composerToAddContent.getTaskId());
            if (appTask == null) {
                MainLogger.m7254d(AbsBixby2Async.TAG, "UpdateAsync - appTask is null");
                return;
            }
            Intent intent = new Intent(BaseUtils.getApplicationContext(), (Class<?>) ComposerActivity.class);
            intent.setAction("android.intent.action.SEND");
            intent.putExtra(Bixby2Constants.BIXBY_ACTION, Bixby2Constants.BIXBY_ACTION_ADD_CONTENT_TO_EDITING_NOTE);
            intent.putExtra(ActionSendHelperAppFunction.AI_ACTION_UPDATE_EDITING_NOTE, true);
            intent.putExtra("noteId", this.mNoteId);
            String str = this.mNoteTitle;
            if (str != null) {
                intent.putExtra("android.intent.extra.SUBJECT", str);
            }
            if (this.mContent != null) {
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", this.mContent);
            }
            appTask.startActivity(BaseUtils.getApplicationContext(), intent, null);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async
        public ActionResult backgroundOperation() {
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_updateThread start");
            ActionResult actionResult = new ActionResult();
            actionResult.setResult(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            actionResult.setDescription(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            String str = this.mNoteId;
            if (str == null) {
                MainLogger.m7258i(AbsBixby2Async.TAG, "noteId is null");
                return actionResult;
            }
            if (this.mNoteTitle == null && this.mContent == null) {
                MainLogger.m7258i(AbsBixby2Async.TAG, "title & content is null");
                return actionResult;
            }
            UpdateNoteUseCase.UpdateNoteParam title = new UpdateNoteUseCase.UpdateNoteParam(str).setFolderUuid("").setTitle(this.mNoteTitle);
            String str2 = this.mContent;
            if (str2 == null) {
                str2 = "";
            }
            UpdateNoteUseCase.UpdateNoteParam timeout = title.setBodyText(str2).setTimeout(3000L);
            NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(this.mContext);
            if (new UpdateNoteUseCase(notesDataRepositoryFactoryNewInstance.createDocumentDataRepository(), new C8358c(this, 2)).execute(this.mContext, timeout).getUpdatedNotes().isEmpty()) {
                MainLogger.m7254d(AbsBixby2Async.TAG, "UpdateAsync - updatedNote is empty");
                return actionResult;
            }
            List<DocumentTextData> documentTextData = notesDataRepositoryFactoryNewInstance.createSearchRepository().getDocumentTextData(Collections.singleton(this.mNoteId));
            if (documentTextData.isEmpty()) {
                MainLogger.m7254d(AbsBixby2Async.TAG, "UpdateAsync - textData is empty");
                return actionResult;
            }
            DocumentTextData documentTextData2 = documentTextData.get(0);
            MainListDocumentDataRepository mainListRepository = RepositoryManager.getInstance().getMainListRepository();
            if (mainListRepository == null) {
                return actionResult;
            }
            MainListDocumentData mainListDocumentData = mainListRepository.get(this.mNoteId);
            NotesFolder notesFolder = FolderManager.getInstance().getNotesFolder(mainListDocumentData.getCategoryUuid(), false);
            ArrayList<NoteInfo> arrayList = new ArrayList<>();
            NoteInfo noteInfo = new NoteInfo();
            noteInfo.setNoteID(this.mNoteId);
            String title2 = this.mNoteTitle;
            if (title2 == null) {
                title2 = documentTextData2.getTitle();
            }
            noteInfo.setNoteTitle(title2);
            noteInfo.setContent(documentTextData2.getStrippedContent() + timeout.getBodyText());
            noteInfo.setFavorite(mainListDocumentData.getIsFavorite() == 1);
            noteInfo.setLocked(mainListDocumentData.getIsLock() == 5 || LockUtils.isLockedSdocType(mainListDocumentData.getIsLock()));
            noteInfo.setCategory(notesFolder != null ? notesFolder.getDisplayName() : "");
            arrayList.add(noteInfo);
            actionResult.setNoteInfo(arrayList);
            actionResult.setResult("success");
            actionResult.setDescription("success");
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_updateThread end");
            return actionResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UpdateFolderAsync extends AbsBixby2Async {
        private final String mFolderId;
        private String mFolderName;

        public UpdateFolderAsync(AbsBixby2Async.AsyncParam asyncParam, String str, String str2) {
            super(asyncParam);
            this.mFolderId = str;
            this.mFolderName = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$backgroundOperation$0(NotesCategoryTreeEntity notesCategoryTreeEntity) {
            notesCategoryTreeEntity.setDisplayName(this.mFolderName);
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async
        public ActionResult backgroundOperation() {
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_updateFoldersThread start");
            ActionResult actionResult = new ActionResult();
            actionResult.setResult(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            actionResult.setDescription(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
            if (this.mFolderId == null) {
                MainLogger.m7258i(AbsBixby2Async.TAG, "folder id is null");
                return actionResult;
            }
            if (this.mFolderName == null) {
                this.mFolderName = "";
            }
            if (new UpdateFolderUseCase().execute(this.mFolderId, new Consumer() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f6176a.lambda$backgroundOperation$0((NotesCategoryTreeEntity) obj);
                }
            })) {
                ArrayList<FolderInfo> arrayList = new ArrayList<>();
                FolderInfo folderInfo = new FolderInfo();
                folderInfo.setFolderID(this.mFolderId);
                folderInfo.setFolderName(this.mFolderName);
                arrayList.add(folderInfo);
                actionResult.setFolderInfo(arrayList);
                actionResult.setResult("success");
                actionResult.setDescription("success");
            } else {
                MainLogger.m7258i(AbsBixby2Async.TAG, "Folder update failure!");
            }
            MainLogger.m7258i(AbsBixby2Async.TAG, "Bixby_updateFoldersThread end");
            return actionResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidUUIDs(String[] strArr) {
        for (String str : strArr) {
            if (DataManager.getInstance().getDocumentData(str) == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NoteFragmentBixby2 implements INoteFragmentBixby2 {
        private static NoteFragmentBixby2 mInstance;
        private Activity mActivity;
        private NotesView mNotesView;
        private NotesPresenter mPresenter;

        public static synchronized NoteFragmentBixby2 getInstance() {
            try {
                if (mInstance == null) {
                    mInstance = new NoteFragmentBixby2();
                }
            } catch (Throwable th) {
                throw th;
            }
            return mInstance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$search$0() {
            if (CommonUtil.isNotAvailableActivity(this.mActivity)) {
                return;
            }
            this.mPresenter.setSearchMode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$shareNotes$1(int i, int i2, Map map) {
            if (i != 0 || (i2 != 0 && i2 != 1)) {
                this.mPresenter.showExportOptionPopup(false);
            } else {
                MainLogger.m7258i(Bixby2.TAG, "shareNotes, MultipleShareTask start");
                this.mPresenter.executeShareTask(new ArrayList<>(map.values()), i2);
            }
        }

        private boolean setCheckNotes(String[] strArr, boolean z, boolean z2) {
            this.mPresenter.clearCheckedData();
            if (strArr == null || strArr.length == 0) {
                MainLogger.m7258i(Bixby2.TAG, "list invalid");
                return false;
            }
            for (String str : strArr) {
                MainListDocumentData documentData = DataManager.getInstance().getDocumentData(str);
                if (documentData != null && ((!z2 || documentData.getIsDeleted() == 1) && (!z || !documentData.isSDoc()))) {
                    this.mPresenter.addCheckedNote(documentData);
                }
            }
            return this.mPresenter.getCheckedNotesCount() > 0;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.INoteFragmentBixby2
        public boolean deleteNotes(String[] strArr) {
            this.mNotesView.initFolderForBixby();
            if (!setCheckNotes(strArr, false, this.mPresenter.getStateInfo().isRecyclebinMode())) {
                return false;
            }
            if (!this.mPresenter.setEditMode(false)) {
                this.mNotesView.getMode().onLayout();
            }
            this.mPresenter.showDeleteDialog();
            return true;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.INoteFragmentBixby2
        public MainListValue getNoteListInfo() {
            MainListValue mainListValue = new MainListValue();
            NotesPresenter notesPresenter = this.mPresenter;
            if (notesPresenter == null) {
                MainLogger.m7258i(Bixby2.TAG, "mPresenter is null!!");
                return mainListValue;
            }
            BixbyNoteListInfo noteListInfo = notesPresenter.getNoteListInfo();
            if (noteListInfo == null) {
                MainLogger.m7258i(Bixby2.TAG, "noteListInfo is null!!");
                return mainListValue;
            }
            ArrayList<MainListDocumentData> entryList = noteListInfo.getEntryList();
            ArrayList<ContextNoteInfo> arrayList = new ArrayList<>();
            if (entryList != null) {
                for (MainListDocumentData mainListDocumentData : entryList) {
                    NotesFolder notesFolder = FolderManager.getInstance().getNotesFolder(mainListDocumentData.getCategoryUuid(), false);
                    if (notesFolder != null) {
                        String displayName = notesFolder.getDisplayName();
                        ContextNoteInfo contextNoteInfo = new ContextNoteInfo();
                        contextNoteInfo.setNoteID(mainListDocumentData.getUuid());
                        contextNoteInfo.setNoteTitle(mainListDocumentData.getTitle());
                        contextNoteInfo.setCategory(displayName);
                        arrayList.add(contextNoteInfo);
                    }
                }
            }
            mainListValue.setCategoryName(noteListInfo.getFolderDisplayName());
            mainListValue.setNoteInfo(arrayList);
            return mainListValue;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.INoteFragmentBixby2
        public boolean isPdfWriterActivityResumed() {
            return ComposerManager.getInstance().isActivityResumed(PdfWriterActivity.class.getName());
        }

        public void release() {
            if (this.mActivity != null) {
                this.mActivity = null;
            }
            if (this.mPresenter != null) {
                this.mPresenter = null;
            }
            if (mInstance != null) {
                mInstance = null;
            }
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.INoteFragmentBixby2
        public boolean search() {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC8331a(this, 0), 100L);
            return false;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.INoteFragmentBixby2
        public void setAction() {
            this.mActivity.getIntent().setAction(null);
        }

        public void setActivity(Activity activity) {
            this.mActivity = activity;
        }

        public void setNoteListObject(NotesView notesView, NotesPresenter notesPresenter) {
            this.mNotesView = notesView;
            this.mPresenter = notesPresenter;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.INoteFragmentBixby2
        public boolean shareNotes(@NonNull String[] strArr, String str) {
            if (strArr.length > 1) {
                this.mNotesView.initFolderForBixby();
                if (setCheckNotes(strArr, true, this.mPresenter.getStateInfo().isRecyclebinMode())) {
                    if (!this.mPresenter.setEditMode(false)) {
                        this.mNotesView.getMode().onLayout();
                    }
                    return shareNotes(str);
                }
                this.mPresenter.clearCheckedData();
            }
            return false;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.INoteFragmentBixby2
        public boolean showAllNotes() {
            MainLogger.m7254d(Bixby2.TAG, "showAllNotes");
            this.mNotesView.initFolderForBixby();
            return true;
        }

        private boolean shareNotes(String str) {
            int i;
            Map<String, CheckedNoteInfo> sharableCheckedNoteMap = this.mPresenter.getSharableCheckedNoteMap();
            int size = sharableCheckedNoteMap.size();
            AbstractC8014b.m7201c(size, "shareNotes, selectedSize: ", Bixby2.TAG);
            int i2 = 0;
            if (size == 0) {
                return false;
            }
            int deletableCheckedLockNotesCount = this.mPresenter.getCheckNotesCountInfo().getDeletableCheckedLockNotesCount();
            if (Bixby2Constants.SLOT_VALUE_SHARE_AS_SDOC.equalsIgnoreCase(str)) {
                i = i2;
            } else if ("PDF".equalsIgnoreCase(str)) {
                i = 1;
            } else {
                i2 = -1;
                i = i2;
            }
            this.mPresenter.setSaveExportType(i);
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC8212b(this, deletableCheckedLockNotesCount, i, sharableCheckedNoteMap, 1), 1000L);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NoteListActivityBixby2 implements INoteListActivityBixby2 {
        private static NoteListActivityBixby2 mInstance;
        private AbsAppCompatActivity mActivity;
        private String mBixbyAction;
        private String mShareType;

        public static synchronized NoteListActivityBixby2 getInstance() {
            try {
                if (mInstance == null) {
                    mInstance = new NoteListActivityBixby2();
                }
            } catch (Throwable th) {
                throw th;
            }
            return mInstance;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.INoteListActivityBixby2
        public boolean addContentToComposer(String str, @Nullable String str2, String str3, String str4, String str5) {
            StringBuilder sbM16m = AbstractC0000a.m16m("addContentToComposer# ", str, SQLKeyword.COMMA, str2, SQLKeyword.COMMA);
            sbM16m.append(MainLogger.getEncode(str3));
            sbM16m.append(SQLKeyword.COMMA);
            sbM16m.append(MainLogger.getEncode(str4));
            sbM16m.append(SQLKeyword.COMMA);
            sbM16m.append(MainLogger.getEncode(str5));
            MainLogger.m7258i(Bixby2.TAG, sbM16m.toString());
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext == null) {
                MainLogger.m7259w(Bixby2.TAG, "appContext == null");
                return false;
            }
            Intent intent = new Intent(applicationContext, (Class<?>) ComposerActivity.class);
            intent.putExtra(Bixby2Constants.BIXBY_ACTION, str);
            if (str3 != null && !str3.isEmpty()) {
                if (str3.startsWith("https://") || str3.startsWith(WebConstants.HTTP_PROTOCOL)) {
                    MainLogger.m7254d(Bixby2.TAG, "addContentToComposer# unexpected imageUri");
                    return false;
                }
                Uri uri = Uri.parse(str3);
                intent.setType(Constants.MIME_IMAGE_START);
                intent.putExtra("android.intent.extra.STREAM", uri);
            }
            if (str4 != null && !str4.isEmpty()) {
                intent.putExtra("android.intent.extra.SUBJECT", str4);
            }
            if (str5 != null && !str5.isEmpty()) {
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", str5);
            }
            intent.setAction("android.intent.action.SEND");
            if (Bixby2Constants.BIXBY_ACTION_ADD_CONTENT_TO_EDITING_NOTE.equals(str)) {
                Activity composerToAddContent = ComposerManager.getInstance().getComposerToAddContent(this.mActivity.getTaskId());
                if (composerToAddContent == null) {
                    this.mActivity.startActivity(intent);
                    return true;
                }
                ActivityManager.AppTask appTask = AppTaskCompat.getInstance().getAppTask(BaseUtils.getApplicationContext(), composerToAddContent.getTaskId());
                if (appTask == null) {
                    this.mActivity.startActivity(intent);
                    return true;
                }
                intent.addFlags(524288);
                appTask.startActivity(BaseUtils.getApplicationContext(), intent, null);
            } else if (Bixby2Constants.BIXBY_ACTION_ADD_CONTENT.equals(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                String strM14294h = C13541h.m14287e().m14294h();
                MainListDocumentData documentData = DataManager.getInstance().getDocumentData(str2);
                if (documentData == null) {
                    return false;
                }
                this.mBixbyAction = str;
                intent.putExtra("sdoc_uuid", str2);
                intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, strM14294h);
                if (LockUtils.isUnLockedDocType(documentData.getIsLock())) {
                    if (documentData.isSDoc()) {
                        intent.setComponent(new ComponentName(BaseUtils.getApplicationContext(), (Class<?>) OpaqueDocOpenTriggerActivity.class));
                        this.mActivity.startActivity(intent);
                    } else {
                        this.mActivity.startActivityForResult(intent, 3);
                    }
                }
            } else {
                if (Bixby2Constants.BIXBY_ACTION_SELECT_AND_ADD_CONTENT.equals(str)) {
                    if (NoteListAccessHandler.getNotePickerClass() == null) {
                        PostLaunchManager.getInstance().executeBaseLogic(1);
                    }
                    intent.setComponent(new ComponentName(BaseUtils.getApplicationContext(), NoteListAccessHandler.getNotePickerClass()));
                    this.mActivity.startActivity(intent);
                    return true;
                }
                this.mActivity.startActivity(intent);
            }
            return true;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.INoteListActivityBixby2
        public String getBixbyAction() {
            return this.mBixbyAction;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.INoteListActivityBixby2
        public String getShareType() {
            return this.mShareType;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.INoteListActivityBixby2
        public boolean openComposer(String str, String str2, String str3, String str4, String str5, String str6) {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext == null) {
                MainLogger.m7255e(Bixby2.TAG, "context is null");
                return false;
            }
            if (str2 == null) {
                MainLogger.m7255e(Bixby2.TAG, "noteId is null");
                return false;
            }
            String strM14294h = C13541h.m14287e().m14294h();
            MainListDocumentData documentData = DataManager.getInstance().getDocumentData(str2);
            StringBuilder sbM16m = AbstractC0000a.m16m("openComposer - ", str, SQLKeyword.COMMA, str2, SQLKeyword.COMMA);
            AbstractC2821a.m2207B(sbM16m, str3, SQLKeyword.COMMA, strM14294h, SQLKeyword.COMMA);
            sbM16m.append(MainLogger.getEncode(str5));
            sbM16m.append(SQLKeyword.COMMA);
            sbM16m.append(MainLogger.getEncode(str6));
            MainLogger.m7258i(Bixby2.TAG, sbM16m.toString());
            if (documentData == null) {
                return false;
            }
            this.mBixbyAction = str;
            this.mShareType = str3;
            Intent intent = new Intent(BaseUtils.getApplicationContext(), (Class<?>) ComposerActivity.class);
            intent.putExtra("sdoc_uuid", str2);
            intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, strM14294h);
            intent.putExtra("doc_path", documentData.getFilePath());
            intent.putExtra(Bixby2Constants.BIXBY_ACTION, str);
            intent.putExtra(Bixby2Constants.BIXBY_ACTION_SHARE, str3);
            intent.putExtra("highlighttext", str4);
            intent.putExtra("packageName", str5);
            intent.putExtra(Bixby2Constants.BIXBY_PARAM_ACTIVITY_NAME, str6);
            if (!LockUtils.isUnLockedDocType(documentData.getIsLock())) {
                return true;
            }
            if (!documentData.isSDoc()) {
                this.mActivity.startActivityForResult(intent, 3);
                return true;
            }
            intent.setAction(ComposerConstants.ACTION_OPEN_MEMO);
            intent.setComponent(new ComponentName(applicationContext, (Class<?>) OpaqueDocOpenTriggerActivity.class));
            this.mActivity.startActivity(intent);
            return true;
        }

        public void release() {
            if (this.mActivity != null) {
                this.mActivity = null;
            }
            if (mInstance != null) {
                mInstance = null;
            }
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.INoteListActivityBixby2
        public boolean sendActionToComposer(BixbyAiParam bixbyAiParam) {
            Intent intent;
            if (bixbyAiParam == null) {
                return false;
            }
            MainLogger.m7258i(Bixby2.TAG, "sendActionToComposer# " + bixbyAiParam);
            Activity composerToAddContent = ComposerManager.getInstance().getComposerToAddContent(this.mActivity.getTaskId());
            if (composerToAddContent == null) {
                MainLogger.m7254d(Bixby2.TAG, "sendActionToComposer - activity is null");
                return false;
            }
            MainLogger.m7258i(Bixby2.TAG, "sendActionToComposer - " + composerToAddContent.getClass().getSimpleName() + SQLKeyword.COMMA + composerToAddContent.getTaskId());
            if (composerToAddContent.getClass().equals(PdfWriterActivity.class)) {
                MainLogger.m7254d(Bixby2.TAG, "sendActionToComposer - intent for PdfWriterActivity");
                intent = new Intent(BaseUtils.getApplicationContext(), (Class<?>) PdfWriterActivity.class);
            } else {
                MainLogger.m7254d(Bixby2.TAG, "sendActionToComposer - intent for ComposerActivity");
                intent = new Intent(BaseUtils.getApplicationContext(), (Class<?>) ComposerActivity.class);
            }
            ActivityManager.AppTask appTask = AppTaskCompat.getInstance().getAppTask(BaseUtils.getApplicationContext(), composerToAddContent.getTaskId());
            if (appTask == null) {
                MainLogger.m7254d(Bixby2.TAG, "sendActionToComposer - appTask is null");
                return false;
            }
            String actionName = bixbyAiParam.getActionName();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra(Bixby2Constants.BIXBY_ACTION, actionName);
            if (actionName != null) {
                if (actionName.equals(Bixby2Constants.BIXBY_ACTION_CHANGE_SPEECH_TO_TEXT)) {
                    intent.putExtra(Bixby2Constants.BIXBY_PARAM_INDEX, bixbyAiParam.getIndex());
                } else if (actionName.equals(Bixby2Constants.BIXBY_ACTION_TRANSLATE_NOTE_PAGE)) {
                    intent.putExtra(Bixby2Constants.BIXBY_PARAM_TARGET_LANGUAGE_CODE, bixbyAiParam.getTargetLanguage());
                }
            }
            intent.putExtra(Bixby2Constants.BIXBY_ACTION_ADD_ACTION, bixbyAiParam.getAddAction());
            intent.putExtra(Bixby2Constants.BIXBY_PARAM_RANGE, bixbyAiParam.getRange());
            intent.addFlags(524288);
            appTask.startActivity(BaseUtils.getApplicationContext(), intent, null);
            this.mActivity.finish();
            return true;
        }

        public void setActivity(AbsAppCompatActivity absAppCompatActivity) {
            this.mActivity = absAppCompatActivity;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.contract.INoteListActivityBixby2
        public boolean sendActionToComposer(String str, String str2) {
            MainLogger.m7258i(Bixby2.TAG, "sendActionToComposer# " + str + SQLKeyword.COMMA + str2);
            Activity composerToAddContent = ComposerManager.getInstance().getComposerToAddContent(this.mActivity.getTaskId());
            if (composerToAddContent == null) {
                MainLogger.m7254d(Bixby2.TAG, "sendActionToComposer - activity is null");
                return false;
            }
            MainLogger.m7258i(Bixby2.TAG, "sendActionToComposer - " + composerToAddContent.getClass().getSimpleName() + SQLKeyword.COMMA + composerToAddContent.getTaskId());
            if (composerToAddContent.getClass().equals(PdfWriterActivity.class)) {
                MainLogger.m7254d(Bixby2.TAG, "sendActionToComposer - PdfWriterActivity is not support.");
                return false;
            }
            ActivityManager.AppTask appTask = AppTaskCompat.getInstance().getAppTask(BaseUtils.getApplicationContext(), composerToAddContent.getTaskId());
            if (appTask == null) {
                MainLogger.m7254d(Bixby2.TAG, "sendActionToComposer - appTask is null");
                return false;
            }
            Intent intent = new Intent(BaseUtils.getApplicationContext(), (Class<?>) ComposerActivity.class);
            intent.setAction("android.intent.action.SEND");
            intent.putExtra(Bixby2Constants.BIXBY_ACTION, str);
            str.getClass();
            if (str.equals(Bixby2Constants.BIXBY_ACTION_SEARCH_IN_NOTE)) {
                intent.putExtra(Bixby2Constants.BIXBY_PARAM_KEYWORD, str2);
            } else if (str.equals(Bixby2Constants.BIXBY_ACTION_CHANGE_TITLE)) {
                intent.putExtra("title", str2);
            }
            intent.addFlags(524288);
            appTask.startActivity(BaseUtils.getApplicationContext(), intent, null);
            this.mActivity.finish();
            return true;
        }
    }
}
