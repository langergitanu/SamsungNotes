package com.samsung.android.app.notes.memolist;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.support.notes.bixby.BixbyManager;
import com.samsung.android.support.notes.bixby.BixbyManagerContract;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.notes.bixby.bixby2.contract.INoteListActivityBixby2;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.AppTaskCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.MainView;
import com.samsung.android.support.senl.p148nt.app.main.PhoneMainView;
import com.samsung.android.support.senl.p148nt.app.main.TabletMainView;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.MainHandoffManager;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.Bixby2;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.NotesFragment;
import com.samsung.android.support.senl.p148nt.app.nativecomposer.ComposerActivity;
import com.samsung.android.support.senl.p148nt.app.trigger.OpaqueDocOpenTriggerActivity;
import com.samsung.android.support.senl.p148nt.base.common.ActivityLifecycleTracker;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.DeveloperMode;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.Migrations;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;
import com.samsung.android.support.senl.p148nt.data.resolver.migration.DatabaseMigrationManager;
import com.samsung.android.support.senl.p148nt.model.collector.updater.CollectUpdateTrigger;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import com.samsung.android.support.senl.p148nt.model.service.DocumentServiceConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p001A.AbstractC0000a;
import p079T.C0283a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MemoListActivity extends AbsAppCompatActivity implements ActivityLifecycleTracker.NoteListSupportOtherApps {
    private static final String TAG = "MemoListActivity";
    private MainView mMainView;

    private void createMainView(Bundle bundle, Bundle bundle2, int i) {
        boolean z = bundle != null;
        this.mMainView = NotesUtils.isTabletLayout(this) ? new TabletMainView(this, i, bundle2, z) : new PhoneMainView(this, i, bundle2, z);
    }

    private boolean executeAppUpdate() {
        return new DatabaseMigrationManager().setOnMigrationListener(new DatabaseMigrationManager.OnMigrationListener() { // from class: com.samsung.android.app.notes.memolist.MemoListActivity.1
            static final String EXECUTE_DB_MIGRATION_PROGRESS_DIALOG = "ExecuteDBMigrationProgress";

            @Override // com.samsung.android.support.senl.nt.data.resolver.migration.DatabaseMigrationManager.OnMigrationListener
            public void onFinish() {
                MainLogger.m7254d(MemoListActivity.TAG, "executeAppUpdate# finish()");
                DialogUtils.ProgressDialogFragment progressDialogFragment = (DialogUtils.ProgressDialogFragment) MemoListActivity.this.getSupportFragmentManager().findFragmentByTag(EXECUTE_DB_MIGRATION_PROGRESS_DIALOG);
                if (progressDialogFragment != null) {
                    progressDialogFragment.dismissAllowingStateLoss();
                }
                MemoListActivity.this.finish();
                MemoListActivity memoListActivity = MemoListActivity.this;
                memoListActivity.startActivity(memoListActivity.getIntent());
            }

            @Override // com.samsung.android.support.senl.nt.data.resolver.migration.DatabaseMigrationManager.OnMigrationListener
            public void onStart() {
                MainLogger.m7254d(MemoListActivity.TAG, "executeAppUpdate# start()");
                DialogUtils.ProgressDialogFragment progressDialogFragment = (DialogUtils.ProgressDialogFragment) DialogUtils.createProgressDialogFragment();
                progressDialogFragment.setTextInProgressDialog(MemoListActivity.this.getString(C8003R.string.progress_dialog_updating));
                progressDialogFragment.setCancelable(false);
                progressDialogFragment.showAllowingStateLoss(MemoListActivity.this.getSupportFragmentManager(), EXECUTE_DB_MIGRATION_PROGRESS_DIALOG);
            }
        }).execute();
    }

    private int getCallerThroughAction(Intent intent, String str, Bundle bundle, int i) {
        MainLogger.m7258i(TAG, "getCallerThroughAction# action : " + str);
        if (Constants.ACTION_VIEW_FROM_FINDER.equalsIgnoreCase(str)) {
            return openNoteByFinder(intent, bundle);
        }
        if ("android.intent.action.VIEW".equalsIgnoreCase(str)) {
            if (i == 1001) {
                return openNoteByBixby(intent, bundle);
            }
        } else {
            if ("android.intent.action.SEARCH".equals(str)) {
                String stringExtra = intent.getStringExtra("query");
                String strRemoveHashSymbol = stringExtra == null ? "" : QueryUtils.removeHashSymbol(stringExtra);
                bundle.putInt("mode", 3);
                bundle.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.AllNotes.UUID);
                bundle.putString(NotesConstants.BUNDLE_KEY_SEARCH, strRemoveHashSymbol);
                bundle.putBoolean(NotesConstants.KEY_IS_IN_APP_SEARCH, false);
                return 4;
            }
            if (Constants.ACTION_START_COEDIT.equals(str)) {
                bundle.putInt("mode", 12);
                bundle.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.Coedit.UUID);
                String stringExtra2 = intent.getStringExtra("group_id");
                String stringExtra3 = intent.getStringExtra("space_id");
                String stringExtra4 = intent.getStringExtra("group_name");
                if (TextUtils.isEmpty(stringExtra3)) {
                    stringExtra3 = SesCoeditShareReadResolver.getInstance().getSpaceIdByGroupId(stringExtra2);
                }
                bundle.putBoolean(GcsConstants.SES_ACCEPTED_BY_NOTIFICATION, intent.getBooleanExtra(GcsConstants.SES_ACCEPTED_BY_NOTIFICATION, false));
                bundle.putString(Constants.KEY_SPACE_ID, stringExtra3);
                bundle.putString(Constants.KEY_GROUP_ID, stringExtra2);
                bundle.putString("group_name", stringExtra4);
                StringBuilder sbM16m = AbstractC0000a.m16m("getCallerThroughAction# START_COEDIT, groupId : ", stringExtra2, ", spaceId : ", stringExtra3, ", groupName : ");
                sbM16m.append(stringExtra4);
                MainLogger.m7254d(TAG, sbM16m.toString());
                return 0;
            }
            if (NotesConstants.ACTION_CONVERT_SDOC_FROM_SETTINGS.equals(str)) {
                return 11;
            }
            MainHandoffManager.Companion companion = MainHandoffManager.INSTANCE;
            if (companion.getInstance().isHandoffAction(intent)) {
                return companion.getInstance().openNoteByHandoff(this, bundle);
            }
            if (ComposerConstants.ACTION_MOVE_TO_MATH_FOLDER.equals(str)) {
                return 12;
            }
        }
        return 0;
    }

    private void goToExecuteTypeActivity(Intent intent, String str) {
        if (Constants.ACTION_START_MS_SETTINGS.equals(str) || Constants.ACTION_START_SIGNOUT_MS_FEED.equals(str)) {
            onExecuteItemSelected(1001);
            intent.setAction("android.intent.action.VIEW");
            MainLogger.m7258i(TAG, "goToExecuteTypeActivity# action : " + str);
        }
    }

    private int handleBixbyAppLink(@Nullable Intent intent) {
        if (intent == null) {
            return 0;
        }
        BixbyManager bixbyManager = BixbyManager.getInstance();
        bixbyManager.registerNoteListActivityBixby2(new BixbyManagerContract.INoteListActivity() { // from class: com.samsung.android.app.notes.memolist.MemoListActivity.2
            @Override // com.samsung.android.support.notes.bixby.BixbyManagerContract.INoteListActivity
            public INoteListActivityBixby2 registerNoteListActivityBixby2() {
                Bixby2.NoteListActivityBixby2 noteListActivityBixby2 = Bixby2.NoteListActivityBixby2.getInstance();
                noteListActivityBixby2.setActivity(MemoListActivity.this);
                return noteListActivityBixby2;
            }
        });
        return bixbyManager.handleAppLink(100, intent);
    }

    private boolean needToClearAppData() {
        int i = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt(Constants.PREFERENCE_NOTICE_FOR_UT, -1);
        int version = NotesDatabaseManager.getInstance().getOpenHelper().getReadableDatabase().getVersion();
        boolean z = i == 5 || Migrations.NEED_TO_BE_CLEARED_DATA.get();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, version, "needToClearAppData, recommendedVersion : ", ", databaseVersion : ", ", result : ");
        sbM1173s.append(z);
        sbM1173s.append(", NEED_TO_BE_CLEARED_DATA : ");
        sbM1173s.append(Migrations.NEED_TO_BE_CLEARED_DATA.get());
        Logger.m11000e(TAG, sbM1173s.toString());
        if (!z) {
            SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt(Constants.PREFERENCE_NOTICE_FOR_UT, 6);
        }
        return z;
    }

    private int openNoteByBixby(@NonNull Intent intent, Bundle bundle) {
        MainLogger.m7254d(TAG, "openNoteByBixby# ");
        Uri data = intent.getData();
        String queryParameter = (data == null || data.getScheme() == null || !data.getScheme().equalsIgnoreCase("applink")) ? null : data.getQueryParameter("noteId");
        MainListDocumentData documentData = queryParameter != null ? DataManager.getInstance().getDocumentData(queryParameter) : null;
        if (documentData == null || TextUtils.isEmpty(queryParameter)) {
            MainLogger.m7254d(TAG, "openNoteByBixby# invalid data! ");
            return 0;
        }
        int isLock = documentData.getIsLock();
        if (LockUtils.isUnLockedDocType(isLock)) {
            MainLogger.m7254d(TAG, "openNoteByBixby# data is unlocked! ");
            return 0;
        }
        BixbyManager bixbyManager = BixbyManager.getInstance();
        bundle.putString("sdoc_uuid", queryParameter);
        bundle.putString("doc_path", documentData.getFilePath());
        bundle.putString(Bixby2Constants.BIXBY_ACTION, bixbyManager.getBixbyAction());
        bundle.putString(Bixby2Constants.BIXBY_ACTION_SHARE, bixbyManager.getShareType());
        bundle.putString(Bixby2Constants.BIXBY_ACTION_ADD_CONTENT, data.getQueryParameter(Bixby2Constants.BIXBY_PARAM_IMAGE_URI));
        if (LockUtils.isLockedSdocType(isLock)) {
            bundle.putInt(NotesConstants.ACTION_VERIFY_FROM_OTHER_APPS, 901);
        } else if (isLock == 5) {
            bundle.putInt(NotesConstants.ACTION_VERIFY_FROM_OTHER_APPS, 100);
        } else if (isLock > 1) {
            bundle.putInt(NotesConstants.ACTION_VERIFY_FROM_OTHER_APPS, 110);
        }
        return 5;
    }

    private int openNoteByFinder(Intent intent, Bundle bundle) {
        String stringExtra = intent.getStringExtra("intent_extra_data_key");
        MainListDocumentData documentData = stringExtra != null ? DataManager.getInstance().getDocumentData(stringExtra) : null;
        if (stringExtra == null || documentData == null || TextUtils.isEmpty(documentData.getFilePath()) || documentData.getIsDeleted() != 0) {
            ToastHandler.show(getApplicationContext(), C8003R.string.no_notes, 0);
            return 4;
        }
        String stringExtra2 = intent.getStringExtra("query");
        String strRemoveHashSymbol = stringExtra2 == null ? "" : QueryUtils.removeHashSymbol(stringExtra2);
        int isLock = documentData.getIsLock();
        if (documentData.isSDoc() && LockUtils.isUnLockedDocType(isLock)) {
            startConverterActivity(stringExtra, strRemoveHashSymbol);
            finish();
            return -1;
        }
        bundle.putString("sdoc_uuid", stringExtra);
        bundle.putString("highlighttext", strRemoveHashSymbol);
        bundle.putString("doc_path", documentData.getFilePath());
        if (isLock != 0) {
            if (LockUtils.isLockedSdocType(isLock)) {
                bundle.putInt(NotesConstants.ACTION_VERIFY_FROM_OTHER_APPS, 901);
                return 4;
            }
            if (isLock == 5) {
                bundle.putInt(NotesConstants.ACTION_VERIFY_FROM_OTHER_APPS, 100);
                return 4;
            }
            if (isLock > 1) {
                bundle.putInt(NotesConstants.ACTION_VERIFY_FROM_OTHER_APPS, 110);
            }
            return 4;
        }
        Intent intent2 = new Intent(getApplicationContext(), (Class<?>) ComposerActivity.class);
        if (UUIDUtils.isCoeditUuid(stringExtra)) {
            intent2.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, documentData.getMdeSpaceId());
            intent2.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, documentData.getMdeGroupId());
            intent2.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, documentData.getMdeOwnerId());
            intent2.putExtra(ComposerConstants.ARG_MDE_WRITER, "test");
            String mdeOwnerId = documentData.getMdeOwnerId();
            C0283a.m562d().getClass();
            intent2.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, AbstractC14517a.m15116A(mdeOwnerId, C0283a.m561c()) ? 1 : 2);
            intent2.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, DocumentServiceConstants.LockGuid.FROM_SHARED_NOTES_GUID);
        }
        intent2.putExtra("sdoc_uuid", stringExtra);
        intent2.putExtra("highlighttext", strRemoveHashSymbol);
        intent2.setAction("android.intent.action.VIEW");
        startActivityForResult(intent2, 3);
        finish();
        return -1;
    }

    private void setStrictMode() {
        if (DeveloperMode.isOnDeveloperMode()) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
        }
    }

    private void startConverterActivity(String str, String str2) {
        if (ConvertTaskManager.getInstance().isConverting(str)) {
            ToastHandler.show(this, C8003R.string.select_converting_note, 0);
            finish();
            return;
        }
        Intent intent = new Intent();
        intent.setAction(ComposerConstants.ACTION_OPEN_MEMO);
        intent.putExtra("sdoc_uuid", str);
        intent.putExtra("highlighttext", str2);
        intent.setComponent(new ComponentName(this, (Class<?>) OpaqueDocOpenTriggerActivity.class));
        startActivity(intent);
        finish();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void changedGcsEnableStatus() {
        this.mMainView.changedGcsEnableStatus();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public boolean closeDrawer(boolean z, int i) {
        return this.mMainView.closeDrawer(z, i);
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.NoteListSupportOtherApps
    public void closeOtherAppsFromNoteList() {
        NotesFragment notesFragment = (NotesFragment) getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        if (notesFragment == null || !notesFragment.isAdded()) {
            return;
        }
        notesFragment.closeOtherAppsFromNoteList();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void dragAndDropFinished(String str) {
        NotesFragment notesFragment = (NotesFragment) getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        if (notesFragment == null || !notesFragment.isAdded()) {
            return;
        }
        notesFragment.dragAndDropFinished(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public View getDrawerView() {
        return this.mMainView.getDrawerView();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public View getNoteParentView() {
        return this.mMainView.getNoteParentView();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void initFolderDataMap() {
        NotesFragment notesFragment = (NotesFragment) getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        if (notesFragment == null || !notesFragment.isAdded()) {
            return;
        }
        notesFragment.initFolderDataMap();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public boolean isRunningAnimator() {
        return this.mMainView.isRunningAnimator();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public boolean isScrolling() {
        return this.mMainView.isScrolling();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        MainView mainView = this.mMainView;
        if (mainView != null) {
            mainView.onActivityResult(i, i2, intent);
        }
        if (i != 51 || i2 == -1) {
            return;
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        MainView mainView = this.mMainView;
        if (mainView != null) {
            mainView.onBackPressed();
        }
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WindowManagerCompat.getInstance().controllIndicatorBar(this, getResources().getConfiguration().orientation);
        MainView mainView = this.mMainView;
        if (mainView == null || !mainView.needViewChange()) {
            MainLogger.m7258i(TAG, "onConfigurationChanged# do not need viewChange, mMainView is null or LayoutMode is not changed or notesFragment is not added");
            return;
        }
        Bundle bundle = new Bundle();
        this.mMainView.swapLayoutMode(bundle);
        this.mMainView = this.mMainView.isTabletLayoutMode() ? new PhoneMainView() : new TabletMainView();
        MainLogger.m7254d(TAG, "onConfigurationChanged# isTabletLayoutMode : " + this.mMainView.isTabletLayoutMode());
        this.mMainView.createView(this, true, 0, bundle);
        this.mMainView.onViewChangeRestoreInstanceState(bundle);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(Constants.VERIFICATION_TAG, "onCreate");
        setStrictMode();
        if (CommonUtils.needToClearAppData() && needToClearAppData()) {
            startActivity(new Intent(getApplicationContext(), (Class<?>) NoticeUTActivity.class));
            finish();
        }
        Intent intent = getIntent();
        String action = intent.getAction();
        boolean booleanExtra = intent.getBooleanExtra(Constants.ARG_UPDATE, false);
        int iHandleBixbyAppLink = handleBixbyAppLink(intent);
        if (intent.getBooleanExtra(ComposerConstants.ARG_COMPOSER_FROM_VOICE_NOTIFICATION, false)) {
            MainLogger.m7258i(TAG, "onCreate# MemoListActivity is called from voice notification.");
            AppTaskCompat.getInstance().moveToFront(getApplicationContext(), ComposerManager.getInstance().findTaskIdByNotification(ComposerConstants.ARG_VOICE_NOTIFICATION_ON).intValue());
            finish();
            return;
        }
        if (intent.getBooleanExtra(ComposerConstants.ARG_COMPOSER_FROM_TRANSLATION_NOTIFICATION, false)) {
            MainLogger.m7258i(TAG, "onCreate# MemoListActivity is called from translation notification.");
            AppTaskCompat.getInstance().moveToFront(getApplicationContext(), ComposerManager.getInstance().findTaskIdByNotification(ComposerConstants.ARG_COMPOSER_FROM_TRANSLATION_NOTIFICATION).intValue());
            finish();
            return;
        }
        if (!booleanExtra && !isTaskRoot() && iHandleBixbyAppLink == 0 && "android.intent.action.MAIN".equals(action)) {
            MainLogger.m7258i(TAG, "onCreate# isTaskRoot finish");
            finish();
            return;
        }
        Bundle bundle2 = new Bundle();
        int callerThroughAction = getCallerThroughAction(intent, action, bundle2, iHandleBixbyAppLink);
        if (executeAppUpdate()) {
            MainLogger.m7254d(TAG, "onCreate#executeAppUpdate - start()");
            return;
        }
        MainLogger.m7254d(TAG, "onCreate# caller : " + callerThroughAction);
        WindowInsetsManager.getInstance().requestApplyInsets(getWindow());
        createMainView(bundle, bundle2, callerThroughAction);
        goToExecuteTypeActivity(intent, action);
        this.mMainView.launchEditorByIntent(getIntent());
        WindowManagerCompat.getInstance().controllIndicatorBar(this, getResources().getConfiguration().orientation);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Bixby2.NoteListActivityBixby2.getInstance().release();
        BixbyManager.getInstance().releaseNoteListActivity();
        MainView mainView = this.mMainView;
        if (mainView != null) {
            mainView.onDestroy();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onExecuteItemSelected(int i) {
        this.mMainView.onExecuteItemSelected(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onFolderDeleteVerifySuccess() {
        this.mMainView.onFolderDeleteVerifySuccess();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onFolderSelected(String str) {
        this.mMainView.onFolderSelected(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onFoldersDataMove(ArrayList<String> arrayList, String str) {
        this.mMainView.onFoldersDataMove(arrayList, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onImportPdf(String str, int i, List<Uri> list) {
        this.mMainView.onImportPdf(str, i, list);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return onKeyDown(i, keyEvent, NotesFragment.TAG);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 84) {
            return true;
        }
        return onKeyUp(i, keyEvent, NotesFragment.TAG);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onModeChanged(int i) {
        this.mMainView.onModeChanged(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onNewCoeditNote(String str, String str2, String str3, int i) {
        this.mMainView.onNewCoeditNote(str, str2, str3, i);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        MainLogger.m7258i(TAG, "onNewIntent# action : " + action);
        NotesFragment notesFragment = (NotesFragment) getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        if (handleBixbyAppLink(intent) == 1001 && notesFragment != null) {
            Bundle arguments = notesFragment.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            int iOpenNoteByBixby = openNoteByBixby(intent, arguments);
            if (iOpenNoteByBixby == 5) {
                notesFragment.openLockedNoteByBixby(iOpenNoteByBixby, arguments);
            }
        }
        if (intent.getBooleanExtra(Constants.ARG_UPDATE, false) && notesFragment != null && notesFragment.isAdded()) {
            notesFragment.setLastOpenedSDocXUuid(intent.getStringExtra("sdoc_uuid"));
        }
        if (intent.getBooleanExtra(MultiTaskManager.INTENT_EXTRA_KEY_RELAUNCH, false)) {
            MultiTaskManager.getInstance().relaunchedActivity(this);
        }
        String stringExtra = intent.getStringExtra("sdoc_uuid");
        intent.removeExtra("sdoc_uuid");
        setIntent(intent);
        if (intent.getBooleanExtra(Constants.PREFERENCE_UPDATED, false) && ApplicationManager.getInstance().getActivityTracker().isActivityRunning(getClass().getSimpleName())) {
            MainLogger.m7258i(TAG, "Recreate activity because of updated preference");
            finish();
            startActivity(intent);
        }
        if (notesFragment == null || action == null) {
            MainLogger.m7255e(TAG, "onNewIntent# NotesFragment or action is null");
            return;
        }
        switch (action) {
            case "action_convert_sdoc_from_settings":
                notesFragment.startConvertNotes();
                break;
            case "com.samsung.android.action.MDE_START_NOTES_BY_MEET_URL":
                notesFragment.startLiveSharingNotes();
                break;
            case "com.samsung.android.app.notes.handoff.ACTION_HANDOFF":
                MainLogger.m7258i(TAG, "Recreate activity because of updated preference");
                finish();
                startActivity(intent);
                break;
            case "action_import_notes":
                notesFragment.addImportDownloadingTipCard();
                break;
            case "action_open_converted_sdoc":
                if (this.mMainView != null) {
                    this.mMainView.onNoteSelected(new MainEntryParam.Builder().setUuid(stringExtra).setFolderUuid(intent.getStringExtra("category_id")).setFilePath(intent.getStringExtra("doc_path")).setGuid(intent.getStringExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID)).setLockType(0).setModeIndex(1).setToolType(intent.getIntExtra("tool_type", 1)).build());
                    break;
                }
                break;
            case "action_import_samsung_notes":
                notesFragment.addImportSamsungNoteTipCard();
                break;
            case "com.samsung.android.app.notes.coedit.action.COEDIT_START":
                notesFragment.startLandingInvitationLinkAction(intent.getStringExtra("group_id"), intent.getStringExtra("space_id"), intent.getStringExtra("group_name"), intent.getBooleanExtra(GcsConstants.SES_ACCEPTED_BY_NOTIFICATION, false));
                break;
            case "android.intent.action.SEARCH":
                String stringExtra2 = intent.getStringExtra("query");
                notesFragment.showSearchMode(stringExtra2 == null ? "" : QueryUtils.removeHashSymbol(stringExtra2));
                break;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onNewNote(String str, int i) {
        this.mMainView.onNewNote(str, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onNewNoteStyleNote(Intent intent) {
        this.mMainView.onNewNoteStyleNote(intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        this.mMainView.onNoteSelected(mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onNotesDataMove(String str) {
        this.mMainView.onNotesDataMove(str);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        CollectUpdateTrigger.INSTANCE.getInstance().onTriggerCollect();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        NotesFragment notesFragment = (NotesFragment) getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        if (notesFragment == null || !notesFragment.isAdded()) {
            return;
        }
        notesFragment.onWindowFocusChanged(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void openDrawer(int i) {
        this.mMainView.openDrawer(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void setDrawerIconDimDragStatus(boolean z, ArrayList<String> arrayList) {
        this.mMainView.setDrawerIconDimDragStatus(z, arrayList);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void setDrawerTitleBold(String str) {
        this.mMainView.setDrawerTitleBold(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void updateDocumentCountMap(Map<String, NotesDocumentCountEntry> map) {
        this.mMainView.updateDocumentCountMap(map);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void updateDrawerIconWithBadge() {
        this.mMainView.updateDrawerIconWithBadge();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void updateNoteViewByDrawerObserver(boolean z) {
        NotesFragment notesFragment = (NotesFragment) getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        if (notesFragment == null || !notesFragment.isAdded()) {
            return;
        }
        notesFragment.updateNoteViewByDrawerObserver(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void verifyForDelete() {
        NotesFragment notesFragment = (NotesFragment) getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        if (notesFragment == null || !notesFragment.isAdded()) {
            return;
        }
        notesFragment.verifyForDelete();
    }
}
