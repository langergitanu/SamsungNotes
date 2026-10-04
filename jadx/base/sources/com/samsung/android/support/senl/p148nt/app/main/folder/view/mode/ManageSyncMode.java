package com.samsung.android.support.senl.p148nt.app.main.folder.view.mode;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomappbar.RunnableC4587a;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BottomMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.FolderPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.folder.presenter.FolderPresenter;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.repository.category.SoftParentFolderChecker;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import p212o1.C13573a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ManageSyncMode extends BaseMode {
    private static final String TAG = "ManageSyncMode";

    public ManageSyncMode(AbsFragment absFragment, FolderPenRecyclerView folderPenRecyclerView, ActionMenuController actionMenuController, BottomMenuController bottomMenuController, FolderPresenter folderPresenter) {
        super(absFragment, folderPenRecyclerView, actionMenuController, bottomMenuController, folderPresenter);
    }

    private void initDescription() {
        View view = this.mFragment.getView();
        if (view != null) {
            TextView textView = (TextView) view.findViewById(C8003R.id.title);
            textView.setText(C8003R.string.settings_sync_to_ms_folder_to_sync_description);
            textView.setVisibility(0);
        }
    }

    private void initIsLogin() {
        Context context;
        if ((this.mFragment.getView() == null || !NotesConstants.ACTION_MICROSOFT_LOGIN.equals(this.mFragment.getActivity().getIntent().getAction())) && (context = this.mFragment.getContext()) != null) {
            C13573a.m14385k(context, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$onOptionsItemSelected$0(View view) {
        view.getContext().getApplicationContext().getApplicationContext();
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
        notesDatabaseManager.getSyncDocumentDao();
        new SyncNoteDataRepository();
        new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
        if (syncCategoryTreeDao.getFeedEnabledFolderCount() > 0) {
            SharedPreferences sharedPreferences = view.getContext().getSharedPreferences("PREF_NAME_ONE_DRIVE_ACCOUNT_LINKING", 0);
            if ((sharedPreferences != null ? sharedPreferences.getInt("PREF_VALUE_TYPE", 0) : 0) == 1) {
                CommonSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_MS_SYNC_FOLDER_DONE, NotesSAConstants.EVENT_FEED_HALFSHEET_GET_STARTED_SETTING_DONE);
            } else {
                SharedPreferences sharedPreferences2 = view.getContext().getSharedPreferences("PREF_NAME_ONE_DRIVE_ACCOUNT_LINKING", 0);
                if ((sharedPreferences2 != null ? sharedPreferences2.getInt("PREF_VALUE_TYPE", 0) : 0) == 2) {
                    CommonSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_MS_SYNC_FOLDER_DONE, NotesSAConstants.EVENT_FEED_TIPS_GET_STARTED_SETTING_DONE);
                }
            }
            C13573a.m14385k(view.getContext(), 0);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public int getModeIndex() {
        return 4;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onBackKeyDown() {
        this.mFragment.getActivity().setResult(0);
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        NotesFolder folderData = this.mPresenter.getFolderData(FolderConstants.MyFolders.UUID);
        if (!NotesConstants.ACTION_MICROSOFT_LOGIN.equals(this.mFragment.getActivity().getIntent().getAction()) || folderData == null || folderData.getChildren().isEmpty()) {
            return;
        }
        menuInflater.inflate(C8003R.menu.manage_sync_menu, menu);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        return super.onCustomKeyEvent(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onFolderSelected(FolderHolderInfo folderHolderInfo, int i) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.ManageCategory;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onLayout() {
        MainLogger.m7258i(TAG, "onLayout");
        this.mActionMenuController.setToolbarTitle(C8003R.string.settings_sync_to_ms_folder_to_sync_title);
        this.mActionMenuController.setDisplayHomeAsUpEnabled(true, true);
        initDescription();
        initIsLogin();
        this.mPresenter.attachAddFolderItem(false, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        if (menuItem.getItemId() != C8003R.id.action_done) {
            return false;
        }
        FragmentActivity activity = this.mFragment.getActivity();
        View view = this.mFragment.getView();
        if (CommonUtil.isNotAvailableActivity(activity) || view == null) {
            return false;
        }
        FolderManager.getInstance().executeOperation(new RunnableC4587a(view, 9));
        CommonSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_MS_SYNC_FOLDER_DONE, SettingsSAConstants.EVENT_SETTINGS_MS_SYNC_FIRST_FOLDER_SET_DONE);
        activity.setResult(-1);
        activity.finish();
        return true;
    }
}
