package com.samsung.android.support.senl.p148nt.app.main;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.CollectionHelper;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.AppLaunchManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.folder.FolderListActivity;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.NotesFragment;
import com.samsung.android.support.senl.p148nt.app.nativecomposer.ComposerActivity;
import com.samsung.android.support.senl.p148nt.app.settings.SettingsActivity;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentType;
import com.samsung.android.support.senl.p148nt.model.service.DocumentServiceConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p079T.C0283a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MainView implements AppLaunchManager.IMainView {
    private AppLaunchManager mLaunchManager;
    protected AbsAppCompatActivity mMainActivity;
    protected NotesFragment mNotesFragment;
    private final String TAG = "MainView";
    protected boolean mHasSavedInstanceState = false;
    protected final Runnable mBlockViewFinishRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.MainView.1
        @Override // java.lang.Runnable
        public void run() {
            View viewFindViewById = MainView.this.mMainActivity.findViewById(C8003R.id.main_view_block);
            if (viewFindViewById != null) {
                MainLogger.m7258i("MainView", "blockView - gone");
                viewFindViewById.setVisibility(8);
            }
        }
    };

    private boolean isMoveToBackCalledWhenBackPressed() {
        return Build.VERSION.SDK_INT > 30;
    }

    private void launchSettingsActivity() {
        Intent intent = new Intent(this.mMainActivity.getApplicationContext(), (Class<?>) SettingsActivity.class);
        intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_MAINLIST);
        Intent intent2 = this.mMainActivity.getIntent();
        if (intent2 != null && (Constants.ACTION_START_SIGNOUT_MS_FEED.equals(intent2.getAction()) || Constants.ACTION_START_MS_SETTINGS.equals(intent2.getAction()))) {
            intent.setAction(intent2.getAction());
        }
        PopOverActivityWrapper.startActivityForResult(this.mMainActivity, intent, 16384, 4);
    }

    private void setCoeditInfo(MainEntryParam mainEntryParam, Intent intent) {
        String groupId = mainEntryParam.getGroupId();
        String spaceId = mainEntryParam.getSpaceId();
        MainCoeditLogger.m7253i("MainView", "onNoteSelected - groupId : " + groupId + ", spaceId : " + spaceId);
        if (TextUtils.isEmpty(groupId) || TextUtils.isEmpty(spaceId)) {
            return;
        }
        intent.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, mainEntryParam.getSpaceId());
        intent.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, mainEntryParam.getGroupId());
        intent.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, mainEntryParam.getMdeOwnerId());
        intent.putExtra(ComposerConstants.ARG_MDE_WRITER, "test");
        String mdeOwnerId = mainEntryParam.getMdeOwnerId();
        C0283a.m562d().getClass();
        intent.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, AbstractC14517a.m15116A(mdeOwnerId, C0283a.m561c()) ? 1 : 2);
        intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, DocumentServiceConstants.LockGuid.FROM_SHARED_NOTES_GUID);
        intent.setAction(ComposerConstants.ACTION_OPEN_MEMO);
    }

    public abstract void changedGcsEnableStatus();

    public abstract boolean closeDrawer(boolean z, int i);

    public void createView(AbsAppCompatActivity absAppCompatActivity, boolean z, int i, Bundle bundle) {
        this.mHasSavedInstanceState = z;
        this.mMainActivity = absAppCompatActivity;
        this.mLaunchManager = new AppLaunchManager(absAppCompatActivity, this);
        onViewCreated(i, bundle);
    }

    public abstract View getDrawerView();

    public abstract View getNoteParentView();

    public abstract void initDrawer(Bundle bundle);

    public boolean isRunningAnimator() {
        return false;
    }

    public boolean isScrolling() {
        return this.mNotesFragment.isScrolling();
    }

    public abstract boolean isTabletLayoutMode();

    public void launchEditorByIntent(final Intent intent) {
        final DocumentType documentType = (DocumentType) intent.getSerializableExtra(Constants.MAIN_EXECUTION_EDITOR_DOC_TYPE);
        if (documentType == null) {
            return;
        }
        PostLaunchManager.getInstance().addLogic(this.mMainActivity.getPostLaunchToken(), 108, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.MainView.3
            @Override // java.lang.Runnable
            public void run() {
                MainLogger.m7258i("MainView", "launchEditorByIntent : " + documentType);
                if (documentType == DocumentType.SPEN_SDOCX) {
                    String stringExtra = intent.getStringExtra(Constants.MAIN_EXECUTION_COMPOSER_DOC_UUID);
                    NotesFragment notesFragment = (NotesFragment) MainView.this.mMainActivity.getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
                    if (notesFragment != null) {
                        notesFragment.onVerifyLockedNote(stringExtra, 1);
                    }
                }
            }
        });
    }

    public boolean needViewChange() {
        Context applicationContext = this.mMainActivity.getApplicationContext();
        NotesFragment notesFragment = this.mNotesFragment;
        if (notesFragment != null) {
            applicationContext = notesFragment.getContext();
        }
        return NotesUtils.isTabletLayout(applicationContext) != isTabletLayoutMode();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        NotesFragment notesFragment;
        NotesFragment notesFragment2 = this.mNotesFragment;
        if ((notesFragment2 == null || !notesFragment2.onActivityResultFromLockManager(i, i2, intent)) && (notesFragment = (NotesFragment) this.mMainActivity.getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG)) != null) {
            notesFragment.onActivityResultAfterVerify(i, i2, intent);
        }
    }

    public void onBackPressed() {
        NotesFragment notesFragment;
        MainLogger.m7254d("MainView", "onBackPressed");
        DataManager.getInstance().saveCurrentFolderExpandState();
        if (!isMoveToBackCalledWhenBackPressed() || (notesFragment = this.mNotesFragment) == null) {
            return;
        }
        notesFragment.startSALogging();
    }

    public void onDestroy() {
        DataManager.getInstance().saveCurrentFolderExpandState();
        WeakReference weakReference = AbstractC6784f.f4180a.f4187g;
        if (weakReference != null) {
            weakReference.clear();
        }
        NotesFragment notesFragment = this.mNotesFragment;
        if (notesFragment != null) {
            notesFragment.startSALogging();
        }
        AppLaunchManager appLaunchManager = this.mLaunchManager;
        if (appLaunchManager != null) {
            appLaunchManager.release();
        }
    }

    public void onExecuteItemSelected(int i) {
        AbstractC8014b.m7201c(i, "onExecuteItemSelected viewType : ", "MainView");
        if (i == 5) {
            this.mMainActivity.startActivityForResult(new Intent(this.mMainActivity.getApplicationContext(), (Class<?>) FolderListActivity.class), 49152);
        } else {
            if (i == 1001) {
                launchSettingsActivity();
                return;
            }
            MainLogger.m7255e("MainView", "onExecuteItemSelected# unexpected ViewType" + i);
        }
    }

    public abstract void onFolderDeleteVerifySuccess();

    public void onFolderSelected(String str) {
        if (str == null) {
            MainLogger.m7255e("MainView", "onFolderSelected# folderUuid is null");
        }
        NotesFragment notesFragment = (NotesFragment) this.mMainActivity.getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        if (notesFragment != null) {
            notesFragment.onFolderSelected(str);
        }
    }

    public abstract void onFoldersDataMove(ArrayList<String> arrayList, String str);

    public void onImportPdf(String str, int i, List<Uri> list) {
        StringBuilder sbM780v = AbstractC0541b.m780v("onImportPdf# folderUuid : ", i, str, ", toolType : ", ", uri : ");
        sbM780v.append(MainLogger.getEncode(list.toString()));
        MainLogger.m7258i("MainView", sbM780v.toString());
        Intent intent = new Intent(this.mMainActivity.getApplicationContext(), (Class<?>) ComposerActivity.class);
        intent.putExtra("tool_type", i);
        intent.putParcelableArrayListExtra(ComposerConstants.ARG_PDF_OPEN_URI, CollectionHelper.toArrayList(list));
        intent.putExtra(ComposerConstants.ARG_PAGE_TYPE, SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1));
        if (FeatureUtils.isPreDefinedFolderUuid(str)) {
            str = FolderConstants.MyFolders.UUID;
        }
        intent.putExtra("category_id", str);
        this.mMainActivity.startActivityForResult(intent, 7);
    }

    public abstract void onModeChanged(int i);

    public void onNewCoeditNote(String str, String str2, String str3, int i) {
        MainCoeditLogger.m7253i("MainView", "onNewCoeditNote# groupId : " + MainLogger.getEncode(str) + ", spaceId : " + MainLogger.getEncode(str2) + ", inviteUrl : " + MainLogger.getEncode(str3) + ", toolType : " + i);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Intent intent = new Intent(this.mMainActivity.getApplicationContext(), (Class<?>) ComposerActivity.class);
        intent.setAction(ComposerConstants.ACTION_NEW_MEMO);
        intent.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, str2);
        intent.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, str);
        C0283a.m562d().getClass();
        intent.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, C0283a.m561c());
        intent.putExtra(ComposerConstants.ARG_MDE_WRITER, "test");
        intent.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, 1);
        intent.putExtra("tool_type", i);
        intent.putExtra(ComposerConstants.ARG_PAGE_TYPE, SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1));
        intent.putExtra("category_id", FolderConstants.Coedit.UUID);
        intent.putExtra(ComposerConstants.ARG_MDE_COEDIT_INVITE_URL, str3);
        this.mMainActivity.startActivityForResult(intent, 7);
    }

    public void onNewNote(String str, int i) {
        MainLogger.m7258i("MainView", "onNewNote - folderUuid : " + str + ", toolType : " + i);
        Intent intent = new Intent(this.mMainActivity.getApplicationContext(), (Class<?>) ComposerActivity.class);
        intent.putExtra("tool_type", i);
        intent.putExtra(ComposerConstants.ARG_PAGE_TYPE, SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1));
        intent.putExtra("category_id", str);
        intent.putExtra(ComposerConstants.ARG_USE_VIEW_MODE, false);
        this.mMainActivity.startActivityForResult(intent, 7);
    }

    public void onNewNoteStyleNote(Intent intent) {
        MainLogger.m7258i("MainView", "onNewNoteStyleNote");
        String strNewUUID = UUIDUtils.newUUID(this.mMainActivity.getApplicationContext());
        Intent intent2 = new Intent(this.mMainActivity.getApplicationContext(), (Class<?>) ComposerActivity.class);
        intent2.putExtras(intent);
        intent2.putExtra("sdoc_uuid", strNewUUID);
        intent2.putExtra(ComposerConstants.ARG_PAGE_TYPE, SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1));
        intent2.putExtra(ComposerConstants.ARG_USE_VIEW_MODE, false);
        intent2.putExtra("new_doc", true);
        boolean booleanExtra = intent.getBooleanExtra(CoverData.KEY_IS_CHANGED, false);
        CoverData coverData = (CoverData) intent.getParcelableExtra(CoverData.KEY_COVER_DATA);
        if (booleanExtra && coverData != null && coverData.isEnabled()) {
            coverData.setNoteUuid(strNewUUID);
            CoverEditorUtils.savePreviewJpg(this.mNotesFragment.getContext(), coverData.getSummary(), coverData.getCategoryUuid(), coverData.getTemplateUuid(), coverData.getColorId(), coverData.getNoteUuid(), coverData.getState());
            intent2.putExtra(CoverData.KEY_IS_CHANGED, true);
            intent2.putExtra(CoverData.KEY_COVER_DATA, coverData);
        }
        this.mMainActivity.startActivityForResult(intent2, 7);
    }

    public void onNoteSelected(MainEntryParam mainEntryParam) {
        int i;
        Intent intentForNoteSelected = this.mNotesFragment.getMode().getIntentForNoteSelected(mainEntryParam);
        String uuid = mainEntryParam.getUuid();
        int lockType = mainEntryParam.getLockType();
        if (UUIDUtils.isCoeditUuid(mainEntryParam.getUuid())) {
            setCoeditInfo(mainEntryParam, intentForNoteSelected);
        }
        try {
            if (LockUtils.isLockedSdocType(lockType)) {
                i = 901;
                this.mNotesFragment.verifyLockedNote(901, intentForNoteSelected, uuid);
            } else if (lockType == 5) {
                if (intentForNoteSelected.getComponent() != null) {
                    intentForNoteSelected.putExtra(NotesConstants.COMPONENT_NAME, intentForNoteSelected.getComponent().getClassName());
                }
                i = 104;
                this.mNotesFragment.verifyLockedNoteWithMultiAccount(104, intentForNoteSelected, uuid);
            } else if (lockType > 0) {
                i = 110;
                this.mNotesFragment.verifyLockedNote(110, intentForNoteSelected, uuid);
            } else {
                i = 4;
                if (mainEntryParam.getRequestCode() == 4) {
                    this.mMainActivity.startActivityForResult(intentForNoteSelected, 4);
                } else {
                    i = 3;
                    this.mMainActivity.startActivityForResult(intentForNoteSelected, 3);
                }
            }
            MainLogger.m7258i("MainView", "onNoteSelected# requestCode : " + i + ", lockType : " + lockType);
        } catch (ActivityNotFoundException e) {
            MainLogger.m7254d("MainView", "onNoteSelected# ActivityNotFoundException " + e.getMessage());
        }
    }

    public void onNotesDataMove(String str) {
        NotesFragment notesFragment = (NotesFragment) this.mMainActivity.getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        if (notesFragment != null) {
            notesFragment.onNotesDataMove(str);
        }
    }

    public void onViewChangeRestoreInstanceState(Bundle bundle) {
        this.mNotesFragment.onViewChangeRestoreInstanceState(bundle);
    }

    public abstract void onViewCreated(int i, Bundle bundle);

    public abstract void onViewLayoutModeEnd();

    public abstract void openDrawer(int i);

    public void removeUnsupportedDrawerFragment() {
        if (!this.mHasSavedInstanceState) {
            MainLogger.m7258i("MainView", "removeUnsupportedDrawerFragment# do not need if view is not recreated");
            return;
        }
        FragmentManager supportFragmentManager = this.mMainActivity.getSupportFragmentManager();
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(!isTabletLayoutMode() ? FolderConstants.FragmentTag.TABLET_DRAWER_FRAGMENT : FolderConstants.FragmentTag.PHONE_DRAWER_FRAGMENT);
        if (fragmentFindFragmentByTag == null) {
            MainLogger.m7255e("MainView", "removeUnsupportedDrawerFragment# Can not find Fragment");
        } else {
            supportFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
            supportFragmentManager.popBackStack();
        }
    }

    public void setBlockTouchEvent() {
        View viewFindViewById = this.mMainActivity.findViewById(C8003R.id.main_view_block);
        if (viewFindViewById == null || viewFindViewById.getVisibility() != 0) {
            return;
        }
        viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.app.main.MainView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                MainLogger.m7258i("MainView", "blockView - onTouch()");
                return true;
            }
        });
    }

    public abstract void setDrawerIconDimDragStatus(boolean z, ArrayList<String> arrayList);

    public abstract void setDrawerTitleBold(String str);

    public void setNotesFragment(int i, Bundle bundle) {
        FragmentManager supportFragmentManager = this.mMainActivity.getSupportFragmentManager();
        NotesFragment notesFragment = (NotesFragment) supportFragmentManager.findFragmentByTag(NotesFragment.TAG);
        this.mNotesFragment = notesFragment;
        if (notesFragment != null) {
            supportFragmentManager.beginTransaction().remove(this.mNotesFragment).commitNow();
        } else {
            bundle.putInt("mode", bundle.getInt("mode", 1));
            bundle.putInt(NotesConstants.KEY_CALLER, i);
            this.mNotesFragment = new NotesFragment(bundle);
        }
        this.mNotesFragment.setContract(this.mMainActivity);
        supportFragmentManager.beginTransaction().replace(C8003R.id.notes_fragment_container, this.mNotesFragment, NotesFragment.TAG).commitNow();
    }

    public void swapLayoutMode(Bundle bundle) {
        NotesFragment notesFragment = this.mNotesFragment;
        if (notesFragment == null || !notesFragment.isAdded()) {
            MainLogger.m7255e("MainView", "swapLayoutMode# mNotesFragment not found");
            return;
        }
        MainLogger.m7258i("MainView", "swapLayoutMode# onConfigurationChanged");
        this.mNotesFragment.onViewChangeSaveInstanceState(bundle);
        onViewLayoutModeEnd();
        this.mMainActivity.setSupportActionBar(null);
    }

    public void updateDocumentCountMap(Map<String, NotesDocumentCountEntry> map) {
        NotesFragment notesFragment = (NotesFragment) this.mMainActivity.getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        if (notesFragment != null) {
            notesFragment.updateDocumentCountMap(map);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.AppLaunchManager.IMainView
    public abstract void updateDrawerDisplayData();

    @Override // com.samsung.android.support.senl.nt.app.main.AppLaunchManager.IMainView
    public void updateDrawerIconWithBadge() {
        this.mNotesFragment.updateDrawerIconWithBadge();
    }
}
