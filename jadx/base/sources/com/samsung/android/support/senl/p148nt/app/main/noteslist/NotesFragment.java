package com.samsung.android.support.senl.p148nt.app.main.noteslist;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Trace;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.migration.C6798g;
import com.samsung.android.support.notes.bixby.BixbyManager;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.notes.bixby.bixby2.contract.INoteFragmentBixby2;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.account.AccountHelper;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.addons.AddonsHandler;
import com.samsung.android.support.senl.p148nt.app.addons.IAddonsListener;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.dialog.AppUpdateDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.listener.OnCustomKeyListener;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.lock.helper.ILockHelper;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.MainHandoffManager;
import com.samsung.android.support.senl.p148nt.app.main.common.samsunganalytics.NotesListSALoggingHelper;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.Bixby2;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.p149sa.NotesListSALogModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.listener.ViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.CustomSwipeRefreshLayout;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.NotesView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.menu.ConvertNoteMenu;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.ModeContract;
import com.samsung.android.support.senl.p148nt.app.nativecomposer.ComposerActivity;
import com.samsung.android.support.senl.p148nt.base.common.EntryImprovementManager;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.FTUConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.AppLaunchLog;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareIntentCreationHelper;
import com.samsung.android.support.senl.p148nt.base.widget.search.VoiceButtonHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import p079T.C0283a;
import p122b2.RunnableC4199v;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesFragment extends AbsFragment implements ModeContract.IFragment, OnCustomKeyListener {
    public static final String TAG = "NotesFragment";
    private AbsAppCompatActivity mActivityContract;
    private AddonsHandler mAddonsHandler;
    protected NotesPresenter mNotesPresenter;
    protected NotesView mNotesView;
    private OnBackPressedCallback mOnBackPressedCallback;

    public NotesFragment() {
    }

    private boolean convertOldNote(MainEntryParam mainEntryParam) {
        NotesView notesView = this.mNotesView;
        if (notesView == null || !FeatureUtils.isOldMode(notesView.getModeIndex()) || !DataManager.getInstance().isOldConvertedNote(mainEntryParam.getUuid())) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(mainEntryParam.getUuid());
        this.mNotesPresenter.getDialogHelper().showConvertConfirmDialog(arrayList, false, true, false, mainEntryParam.getLockType() == 1 ? 1 : 0);
        return true;
    }

    private void destroyAddonsHandler() {
        AddonsHandler addonsHandler = this.mAddonsHandler;
        if (addonsHandler == null) {
            return;
        }
        addonsHandler.onDestroy();
        this.mAddonsHandler = null;
    }

    private boolean isGcsForResult(int i) {
        switch (i) {
            case 8:
            case 9:
            case 10:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResultAfterVerify$1() {
        FTUConstants.setSignInFTUNeedToShow();
        this.mNotesView.getMode().checkSignInFTUNeeds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ INoteFragmentBixby2 lambda$onResume$3() {
        Bixby2.NoteFragmentBixby2 noteFragmentBixby2 = Bixby2.NoteFragmentBixby2.getInstance();
        noteFragmentBixby2.setActivity(getActivity());
        noteFragmentBixby2.setNoteListObject(this.mNotesView, this.mNotesPresenter);
        return noteFragmentBixby2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ INoteFragmentBixby2 lambda$onViewCreated$0() {
        Bixby2.NoteFragmentBixby2 noteFragmentBixby2 = Bixby2.NoteFragmentBixby2.getInstance();
        noteFragmentBixby2.setActivity(getActivity());
        noteFragmentBixby2.setNoteListObject(this.mNotesView, this.mNotesPresenter);
        return noteFragmentBixby2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestVerifyForShare$2(ArrayList arrayList) {
        this.mNotesPresenter.showShareDialog(arrayList, false);
    }

    private boolean needToUpdateForSync(MainEntryParam mainEntryParam) {
        if ((mainEntryParam.getSyncState() & 32768) != 32768) {
            return false;
        }
        this.mNotesPresenter.getDialogHelper().showAppUpdateDialog(AppUpdateDialogFragment.FOR_LOW_VERSION_FORMAT_SYNC);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onBackKeyDown() {
        AddonsHandler addonsHandler = this.mAddonsHandler;
        boolean z = (addonsHandler != null && addonsHandler.onBackPressed()) || this.mNotesView.onBackKeyDown();
        AbstractC8014b.m7210l("onBackKeyDown# ", TAG, z);
        return z;
    }

    private void onConvertedNoteSelected(int i, Intent intent) {
        MainListDocumentData noteData;
        if (i != -1 || TextUtils.isEmpty(intent.getStringExtra(ComposerConstants.ARG_SDOC_OLD_UUID)) || (noteData = getNoteData(intent.getStringExtra("sdoc_uuid"))) == null) {
            return;
        }
        this.mActivityContract.onNoteSelected(new MainEntryParam.Builder().setDocumentData(noteData).setGuid(C13541h.m14287e().m14294h()).setModeIndex(getModeIndex()).setToolType(1).build());
    }

    private void openLockedNoteByOtherApps(int i, Bundle bundle) {
        int i2;
        if (bundle == null || (i2 = bundle.getInt(NotesConstants.ACTION_VERIFY_FROM_OTHER_APPS, 0)) == 0) {
            return;
        }
        AbstractC8014b.m7200b(i, i2, "openLockedNoteByOtherApps# caller : ", ", requestCode : ", TAG);
        String string = bundle.getString("sdoc_uuid");
        String string2 = bundle.getString("doc_path");
        Intent intent = new Intent(getContext(), (Class<?>) ComposerActivity.class);
        intent.putExtra("sdoc_uuid", string);
        intent.putExtra("doc_path", string2);
        intent.setAction("android.intent.action.VIEW");
        if (i == 4) {
            intent.putExtra("highlighttext", bundle.getString("highlighttext"));
            if (intent.getComponent() != null) {
                intent.putExtra(NotesConstants.COMPONENT_NAME, intent.getComponent().getClassName());
            }
        } else {
            if (i != 5) {
                return;
            }
            if (Bixby2Constants.BIXBY_ACTION_ADD_CONTENT.equals(bundle.getString(Bixby2Constants.BIXBY_ACTION))) {
                intent.setAction("android.intent.action.SEND");
                intent.setType(Constants.MIME_IMAGE_START);
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(bundle.getString(Bixby2Constants.BIXBY_ACTION_ADD_CONTENT)));
            }
            intent.putExtra(Bixby2Constants.BIXBY_ACTION, bundle.getString(Bixby2Constants.BIXBY_ACTION));
            intent.putExtra(Bixby2Constants.BIXBY_ACTION_SHARE, bundle.getString(Bixby2Constants.BIXBY_ACTION_SHARE));
            if (i2 == 100 && intent.getComponent() != null) {
                intent.putExtra(NotesConstants.COMPONENT_NAME, intent.getComponent().getClassName());
            }
        }
        verifyLockedNote(i2, intent, string);
    }

    private void requestConvertedNoteSelected(int i, Intent intent) {
        requestNoteSelected(i, intent, true);
        onConvertedNoteSelected(i, intent);
    }

    private void requestCoverEditor(int i, Intent intent) {
        CoverData coverData;
        if (intent == null || (coverData = (CoverData) intent.getParcelableExtra(CoverData.KEY_COVER_DATA)) == null || !intent.getBooleanExtra(CoverData.KEY_IS_CHANGED, false)) {
            return;
        }
        if (intent.getBooleanExtra(CoverData.KEY_IS_TITLE_CHANGED, false)) {
            this.mNotesPresenter.getCoverHelper().updateCoverEntityWithTitle(getContext(), coverData);
        } else {
            this.mNotesPresenter.getCoverHelper().updateCoverEntity(getContext(), coverData);
        }
    }

    private void requestDrawerUpdate() {
        NotesFolder folderData = DataManager.getInstance().getFolderData(this.mNotesPresenter.getStateInfo().getFolderUuid());
        if (folderData == null || FolderConstants.RecycleBin.UUID.equals(folderData.getParentUuid())) {
            this.mNotesView.onFolderSelected(FolderConstants.AllNotes.UUID);
        }
    }

    private void requestNewNote(int i, Intent intent) {
        if (intent != null && i == -1) {
            this.mNotesView.onActivityResultFromComposer(intent, false);
            this.mNotesPresenter.setLastOpenedSDocXUuid(intent.getStringExtra("sdoc_uuid"));
        }
        this.mNotesPresenter.requestInAppReview();
    }

    private void requestNewNoteAfterFTU(int i, Intent intent) {
        if (intent == null || i != -1) {
            return;
        }
        int intExtra = intent.getIntExtra("tool_type", 1);
        String stringExtra = intent.getStringExtra("category_id");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        onNewNote(stringExtra, intExtra);
    }

    private void requestNoteSelected(int i, Intent intent, boolean z) {
        if (intent == null) {
            return;
        }
        if (i == -1) {
            this.mNotesView.onActivityResultFromComposer(intent, z);
            this.mNotesPresenter.setLastOpenedSDocXUuid(intent.getStringExtra("sdoc_uuid"));
        } else if (i == 4352) {
            return;
        } else {
            ToastHandler.show(this.mActivityContract, C8003R.string.unable_to_open_note, 0);
        }
        this.mNotesPresenter.requestInAppReview();
    }

    private void requestSpeechToText(int i, Intent intent, boolean z) {
        if (intent == null || i != -1) {
            return;
        }
        String queryFromResult = VoiceButtonHelper.getQueryFromResult(i, intent, z);
        if (!TextUtils.isEmpty(queryFromResult)) {
            this.mNotesPresenter.getSearchHelper().requestSearch(queryFromResult);
        }
        AbstractC8014b.m7210l("requestSpeechToText# svi : ", TAG, z);
    }

    private void requestVerifyForShare(int i, Intent intent) {
        if (i != -1 || intent == null) {
            this.mNotesPresenter.onTaskFinished();
            return;
        }
        MainLogger.m7258i(TAG, "REQUEST_LOCK_CONFIRM_SHARE");
        int saveExportType = this.mNotesPresenter.getSaveExportType();
        if (saveExportType != -1) {
            this.mNotesPresenter.shareNoteBySavedShareType(saveExportType, intent.getParcelableArrayListExtra(NotesConstants.KEY_SHARE_LIST));
        } else {
            new Handler().postDelayed(new RunnableC4199v(this, intent.getParcelableArrayListExtra(NotesConstants.KEY_SHARE_LIST), 25), 400L);
        }
    }

    private void requestVerifyLock(int i, Intent intent) {
        String stringExtra;
        if (intent == null || this.mActivityContract == null || (stringExtra = intent.getStringExtra("sdoc_uuid")) == null) {
            return;
        }
        int intExtra = intent.getIntExtra("mode", 0);
        int iIsDeletedNote = DataManager.getInstance().isDeletedNote(stringExtra);
        StringBuilder sbM1629s = AbstractC2322a.m1629s("requestVerifyLock# modeIndex : ", intExtra, ", uuid : ", stringExtra, ", deleteType : ");
        sbM1629s.append(iIsDeletedNote);
        MainLogger.m7254d(TAG, sbM1629s.toString());
        if (iIsDeletedNote == 2 && !FeatureUtils.isRecyclebinMode(intExtra)) {
            i = 4352;
        }
        if (i != -1) {
            if (i == 4352 || !"android.intent.action.VIEW".equalsIgnoreCase(this.mActivityContract.getIntent().getAction())) {
                return;
            }
            this.mActivityContract.finish();
            return;
        }
        String stringExtra2 = intent.getStringExtra(NotesConstants.COMPONENT_NAME);
        if (stringExtra2 == null) {
            return;
        }
        try {
            intent.setComponent(new ComponentName(this.mActivityContract, Class.forName(stringExtra2)));
        } catch (ClassNotFoundException e) {
            MainLogger.m7255e(TAG, "ClassNotFoundException " + e.getMessage());
        }
        intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, C13541h.m14287e().m14294h());
        this.mActivityContract.startActivityForResult(intent, 3);
    }

    private void requestVerifySaveAs(int i, Intent intent) {
        if (i != -1 || intent == null) {
            this.mNotesPresenter.onTaskFinished();
            return;
        }
        MainLogger.m7258i(TAG, "REQUEST_LOCK_CONFIRM_SAVE");
        final ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(NotesConstants.KEY_SAVE_LIST);
        new Handler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.NotesFragment.2
            @Override // java.lang.Runnable
            public void run() {
                NotesFragment.this.mNotesPresenter.showShareDialog(parcelableArrayListExtra, true);
            }
        }, 400L);
    }

    private boolean restoreCorruptedNote(MainEntryParam mainEntryParam) {
        if (!NotesUtils.isWarning(mainEntryParam.getCorrupted())) {
            return false;
        }
        MainLogger.m7258i(TAG, "restoreCorruptedNote");
        this.mNotesPresenter.restoreCorruptedNote(getActivity(), this.mActivityContract, mainEntryParam);
        return true;
    }

    private void setBackPressedCallback() {
        MainLogger.m7254d(TAG, "setBackPressedCallback");
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.remove();
        }
        this.mOnBackPressedCallback = new OnBackPressedCallback(true) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.NotesFragment.1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                MainLogger.m7254d(NotesFragment.TAG, "setBackPressedCallback# handleOnBackPressed");
                if (NotesFragment.this.onBackKeyDown()) {
                    return;
                }
                setEnabled(false);
                NotesFragment.this.requireActivity().onBackPressed();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, this.mOnBackPressedCallback);
    }

    private void setBackgroundResources(View view) {
        if (DeviceInfo.isVSTModel()) {
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(), C8003R.color.noteslist_fragment_bg_color_for_vst));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean startAddonComposer(MainEntryParam mainEntryParam) {
        if (!mainEntryParam.isSdoc()) {
            return false;
        }
        int lockType = mainEntryParam.getLockType();
        AbstractC8014b.m7201c(lockType, "startAddonComposer# lockType : ", TAG);
        if (lockType == 2) {
            return false;
        }
        int i = 3;
        if (lockType == 3) {
            return false;
        }
        if (mainEntryParam.getIsDeleted() == 2) {
            i = 4;
        } else if (FeatureUtils.isGcsSpaceMode(mainEntryParam.getModeIndex())) {
            C0283a.m562d().getClass();
            if (C0283a.m561c().equals(mainEntryParam.getMdeOwnerId())) {
                i = 1;
            }
        }
        getAddonsHandler().startAddonComposer(mainEntryParam.getUuid(), mainEntryParam.getFilePath(), mainEntryParam.getHighLightText(), i);
        return true;
    }

    private boolean startConvertNoteForSync(MainEntryParam mainEntryParam) {
        return new ConvertNoteMenu(this.mActivityContract).startConvertNoteForSync(mainEntryParam);
    }

    public void addCheckedNote(String str) {
        MainListDocumentData documentData;
        if (TextUtils.isEmpty(str) || (documentData = DataManager.getInstance().getDocumentData(str)) == null) {
            return;
        }
        this.mNotesPresenter.addCheckedNote(documentData);
    }

    public void addImportDownloadingTipCard() {
        this.mNotesPresenter.addImportDownloadingTipCard();
    }

    public void addImportSamsungNoteTipCard() {
        this.mNotesPresenter.addImportSamsungNoteTipCard();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void changedGcsDisable() {
        this.mActivityContract.changedGcsEnableStatus();
    }

    public void checkSOMUnRecognizedCount() {
        this.mNotesPresenter.checkSOMUnRecognizedCount();
    }

    public void clearCheckedNote() {
        NotesPresenter notesPresenter = this.mNotesPresenter;
        if (notesPresenter == null) {
            return;
        }
        notesPresenter.clearCheckedData();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public boolean closeDrawer(boolean z, int i) {
        return this.mActivityContract.closeDrawer(z, i);
    }

    public void closeOtherAppsFromNoteList() {
        int requestCodeForOtherApp;
        FragmentActivity activity;
        NotesPresenter notesPresenter = this.mNotesPresenter;
        if (notesPresenter == null || (requestCodeForOtherApp = notesPresenter.getRequestCodeForOtherApp()) == -1 || (activity = getActivity()) == null) {
            return;
        }
        activity.finishActivity(requestCodeForOtherApp);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void dragAndDropFinished(String str) {
        if (this.mActivityContract != null) {
            if (!StorageUtils.isAvailableMemoryForNewMemo()) {
                AbsAppCompatActivity absAppCompatActivity = this.mActivityContract;
                DialogUtils.showNotEnoughStorageDialogFragment(absAppCompatActivity, absAppCompatActivity.getSupportFragmentManager());
                return;
            } else {
                String str2 = FolderConstants.RecycleBin.UUID;
                if (!str2.equals(this.mNotesPresenter.getStateInfo().getFolderUuid()) && !str2.equals(str)) {
                    this.mActivityContract.onFoldersDataMove(this.mNotesPresenter.getCheckedFolderUUID(), str);
                }
            }
        }
        onNotesDataMove(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment
    public void filteredInvalidateOptionsMenu() {
        NotesView notesView = this.mNotesView;
        if (notesView != null) {
            notesView.filteredInvalidateOptionsMenu();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public AddonsHandler getAddonsHandler() {
        if (this.mAddonsHandler == null) {
            this.mAddonsHandler = new AddonsHandler(this.mActivityContract, new IAddonsListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.NotesFragment.3
                @Override // com.samsung.android.support.senl.p148nt.app.addons.IAddonsListener
                @NonNull
                public ILockHelper getLockHelper() {
                    return NotesFragment.this.mNotesPresenter.getLockHelper();
                }

                @Override // com.samsung.android.support.senl.p148nt.app.addons.IAddonsListener
                public void onRequestOpenNote(boolean z, String str, String str2, String str3) {
                    MainLogger.m7258i(NotesFragment.TAG, "onRequestOpenNote, openOldComposer: " + z);
                    MainEntryParam.Builder builder = new MainEntryParam.Builder();
                    if (z) {
                        builder.setOldUuid(str).setUuid(str2).setFilePath(str3);
                    } else {
                        MainListDocumentData noteData = NotesFragment.this.getNoteData(str2);
                        if (noteData == null) {
                            return;
                        }
                        if (com.samsung.android.support.senl.p148nt.model.utils.FeatureUtils.ENABLE_DELETE_OLD_DOC_AFTER_CONVERTING) {
                            ToastHandler.show(NotesFragment.this.mActivityContract, NotesFragment.this.mActivityContract.getString(C8003R.string.base_string_convert_finish), 0);
                            NotesSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_OLDNOTES, NotesSAConstants.EVENT_OLDNOTES_CONVERT, "old_converted_notes".equals(NotesFragment.this.mNotesPresenter.getStateInfo().getCategoryUuid()) ? "b" : "a");
                        }
                        builder.setDocumentData(noteData);
                    }
                    NotesFragment.this.mActivityContract.onNoteSelected(builder.setGuid(C13541h.m14287e().m14294h()).setModeIndex(NotesFragment.this.getModeIndex()).setToolType(1).setRequestCode(4).build());
                }

                @Override // com.samsung.android.support.senl.p148nt.app.addons.IAddonsListener
                public void onStubUpdateTaskFinished() {
                }

                @Override // com.samsung.android.support.senl.p148nt.app.addons.IAddonsListener
                public void onTaskCanceled() {
                }
            });
        }
        return this.mAddonsHandler;
    }

    public int getCheckedNotesCount() {
        return this.mNotesPresenter.getCheckedNotesUUIDForWidgetList().size();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public View getDrawerView() {
        return this.mActivityContract.getDrawerView();
    }

    public ViewContract.IMode getMode() {
        return this.mNotesView.getMode();
    }

    public int getModeIndex() {
        NotesView notesView = this.mNotesView;
        if (notesView != null) {
            return notesView.getModeIndex();
        }
        return -1;
    }

    @Nullable
    public MainListDocumentData getNoteData(String str) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        MainListDocumentData noteData = this.mNotesPresenter.getDocumentMap().getNoteData(str);
        return noteData == null ? NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().get(str) : noteData;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public View getNoteParentView() {
        return this.mActivityContract.getNoteParentView();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void importNoteToSpace() {
        if (getActivity() != null && this.mNotesPresenter.importNoteToSpace()) {
            getActivity().finish();
        }
    }

    public void initFolderDataMap() {
        NotesPresenter notesPresenter = this.mNotesPresenter;
        if (notesPresenter == null) {
            return;
        }
        notesPresenter.getDocumentMap().initFolderDataMap();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment, com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public boolean isRunningAnimator() {
        return this.mActivityContract.isRunningAnimator();
    }

    public boolean isScrolling() {
        return this.mNotesPresenter.isScrolling();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void launchActivity(Intent intent, @NonNull NotesActivityResultCallback notesActivityResultCallback) {
        this.mActivityContract.launchActivity(intent, notesActivityResultCallback);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void launchPopOverActivity(Intent intent, int i, @NonNull NotesActivityResultCallback notesActivityResultCallback) {
        this.mActivityContract.launchPopOverActivity(intent, i, notesActivityResultCallback);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void onActivityResultAfterVerify(int i, int i2, @Nullable Intent intent) {
        MainLogger.activityResultLog(TAG, i, i2);
        AiCommonUtil.onActivityResult(getActivity(), i, i2, intent);
        if (PermissionHelper.onActivityResult(i, i2, new RunnableC8331a(this, 1))) {
            this.mActivityContract.finish();
            return;
        }
        UserInputSkipper.releaseHoldingSingleActionEventTimeByTag(UserInputSkipper.Tag.OpenActivity);
        this.mNotesPresenter.setLastOpenedSDocXUuid(null);
        this.mNotesPresenter.loadProgressingTaskForTipCard();
        if (getAddonsHandler().onActivityResult(i, i2, intent)) {
            return;
        }
        if (FeatureUtils.isMainListRequestCode(i, 32768)) {
            requestDrawerUpdate();
        } else if (FeatureUtils.isMainListRequestCode(i, 1)) {
            if (i2 != 0 && intent != null) {
                this.mActivityContract.finish();
            }
        } else if (FeatureUtils.isMainListRequestCode(i, 2)) {
            this.mNotesPresenter.requestImportPdf(i2, ContentPickerUtils.getUriListFromResult(intent));
        } else if (FeatureUtils.isMainListRequestCode(i, 3)) {
            requestNoteSelected(i2, intent, false);
        } else if (FeatureUtils.isMainListRequestCode(i, 4)) {
            requestConvertedNoteSelected(i2, intent);
        } else if (FeatureUtils.isMainListRequestCode(i, 5)) {
            requestSpeechToText(i2, intent, false);
        } else if (FeatureUtils.isMainListRequestCode(i, 6)) {
            requestSpeechToText(i2, intent, true);
        } else if (FeatureUtils.isMainListRequestCode(i, 7)) {
            requestNewNote(i2, intent);
        } else if (FeatureUtils.isMainListRequestCode(i, 9)) {
            if (intent != null && i2 == -1) {
                this.mNotesView.onActivityResultForSaveExport(intent);
            }
        } else if (FeatureUtils.isMainListRequestCode(i, 10)) {
            if (intent != null && i2 == -1) {
                this.mNotesPresenter.openSettingsMicrosoftLogin();
            }
        } else if (FeatureUtils.isMainListRequestCode(i, 11)) {
            requestNewNoteAfterFTU(i2, intent);
        } else if (i == 100 || i == 104) {
            requestVerifyLock(i2, intent);
        } else if (i == 102) {
            requestVerifyForShare(i2, intent);
        } else if (i == 103) {
            requestVerifySaveAs(i2, intent);
        } else if (i == 8) {
            requestCoverEditor(i2, intent);
        } else if (i == 14) {
            this.mNotesView.onBackKeyDown();
            if (i2 == -1 && intent != null) {
                this.mActivityContract.onNewNoteStyleNote(intent);
            }
        } else if (i == 15) {
            if (PermissionHelper.isChinaPermissionNeeded() && intent != null && intent.hasExtra(PermissionHelper.KEY_NOTICE_APP_PERMISSION_IS_NOT_CONFIRMED)) {
                this.mActivityContract.finish();
                return;
            } else if (i2 == -1) {
                AccountHelper.loginPopupSamsungAccount(getActivity());
                this.mNotesPresenter.getTipCardHelper().addImportNoteFromAccountTipCardIfNeeds();
            }
        } else if (i == 53) {
            ContentPickerUtils.requestMyFilesAppToPickPath(9, getActivity());
        } else if (i == 113) {
            this.mActivityContract.resultVerifyLockNote(intent);
        } else if (i == ComposerRequestCode.ShareVia.getId()) {
            if (i2 == 0) {
                ShareIntentCreationHelper.deleteSharedDataInIntent(this.mActivityContract);
            }
            this.mNotesPresenter.onTaskFinished();
        } else if (isGcsForResult(i)) {
            this.mNotesView.getGcsImpl().onActivityResult(i, i2, intent);
        } else {
            AbstractC8014b.m7201c(i, "unexpected requestCode: ", TAG);
        }
        super.onActivityResult(i, i2, intent);
    }

    public boolean onActivityResultFromLockManager(int i, int i2, Intent intent) {
        if (this.mNotesView.onActivityResultFromHandoff(i, i2, intent)) {
            return true;
        }
        return this.mNotesPresenter.onActivityResultFromLockManager(i, i2, intent);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void onBackInvoked() {
        if (onBackKeyDown()) {
            return;
        }
        requireActivity().onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        NotesView notesView = this.mNotesView;
        if (notesView == null) {
            return;
        }
        notesView.getMode().onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater menuInflater) {
        MainLogger.m7258i(TAG, "onCreateOptionsMenu");
        this.mNotesView.getMode().onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(C8003R.layout.noteslist_fragment, viewGroup, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.common.listener.OnCustomKeyListener
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        return this.mNotesView.getMode().onCustomKeyEvent(i, keyEvent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        MainLogger.m7258i(TAG, "onDestroy# " + hashCode());
        NotesView notesView = this.mNotesView;
        if (notesView != null) {
            notesView.onDestroy();
        }
        Bixby2.NoteFragmentBixby2.getInstance().release();
        BixbyManager.getInstance().releaseNoteFragment();
        AiCommonUtil.releaseActionStatus(getActivity());
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        MainLogger.m7258i(TAG, "onDestroyView");
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.remove();
            this.mOnBackPressedCallback = null;
        }
        destroyAddonsHandler();
        EntryImprovementManager.getInstance().onDestroy();
        super.onDestroyView();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment
    public void onFolderDeleteVerifySuccess() {
        this.mActivityContract.onFolderDeleteVerifySuccess();
    }

    public void onFolderSelected(String str) {
        this.mNotesView.onFolderSelected(str);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void onImportPdf(String str, int i, List<Uri> list) {
        this.mActivityContract.onImportPdf(str, i, list);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void onModeChanged(int i) {
        this.mActivityContract.onModeChanged(i);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void onNewCoeditNote(String str, String str2, @Nullable String str3, int i) {
        if (this.mNotesPresenter.canCreateNewCoeditNote()) {
            this.mActivityContract.onNewCoeditNote(str, str2, str3, i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void onNewNote(String str, int i) {
        if (FeatureUtils.isGcsSpaceMode(getModeIndex())) {
            this.mNotesView.getGcsImpl().onNewNote(str, i);
            return;
        }
        if (FeatureUtils.isCoeditMode(getModeIndex())) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_CREATE_STANDALONE_NOTE);
            this.mNotesView.getSpaceImpl().launchSocialPickerForNewStandaloneNote(i);
        } else if (FeatureUtils.isCoeditSpaceMode(getModeIndex())) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE, NotesSAConstants.EVENT_COEDIT_SPACE_CREATE_NOTE);
            onNewCoeditNote(this.mNotesPresenter.getStateInfo().getGroupId(), this.mNotesPresenter.getStateInfo().getSpaceId(), null, i);
        } else {
            NotesListSALogModel.addSAlogOnNewNote(NotesUtils.isTabletLayout(getContext()), this.mNotesView.getModeIndex(), i, this.mNotesPresenter.getStateInfo().getFolderUuid());
            if (FeatureUtils.isPreDefinedFolderUuid(str)) {
                str = FolderConstants.MyFolders.UUID;
            }
            this.mActivityContract.onNewNote(str, i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void onNewNoteStyleNote(Intent intent) {
        this.mActivityContract.onNewNoteStyleNote(intent);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.OpenActivity;
        if (UserInputSkipper.isValidSingleActionEvent(false, tag) && UserInputSkipper.isValidEvent(UserInputSkipper.Tag.MemoList)) {
            UserInputSkipper.setHoldingSingleActionEventTime(1000L, tag);
            if (!StorageUtils.hasEnoughSpace(mainEntryParam.getSize())) {
                DialogUtils.showNotEnoughStorageDialogFragment(getContext(), getActivity().getSupportFragmentManager());
                return;
            }
            StringBuilder sb = new StringBuilder("onNoteSelected# uuid : ");
            sb.append(mainEntryParam.getUuid());
            sb.append(", modeIndex : ");
            NotesView notesView = this.mNotesView;
            AbstractC8014b.m7212n(sb, TAG, notesView == null ? -1 : notesView.getModeIndex());
            if (needToUpdateForSync(mainEntryParam) || convertOldNote(mainEntryParam) || startAddonComposer(mainEntryParam) || restoreCorruptedNote(mainEntryParam)) {
                return;
            }
            this.mActivityContract.onNoteSelected(mainEntryParam);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void onNoteSelectedWidget(MainEntryParam mainEntryParam) {
        mainEntryParam.setModeIndex(7);
        mainEntryParam.setToolType(1);
        this.mActivityContract.onNoteSelected(mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void onNotesDataMove(String str) {
        String str2 = FolderConstants.RecycleBin.UUID;
        if (str2.equals(this.mNotesPresenter.getStateInfo().getFolderUuid())) {
            return;
        }
        if (str2.equals(str)) {
            this.mNotesPresenter.showDeleteDialog();
        } else {
            DataManager.getInstance().updateCategory(this.mNotesPresenter.showToastForMove(str), str);
            this.mNotesPresenter.onTaskFinished();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        return this.mNotesView.getMode().onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        MainLogger.m7258i(TAG, "onPause# " + hashCode());
        this.mNotesView.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(@NotNull Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MainLogger.m7258i(TAG, "onPrepareOptionsMenu");
        this.mNotesView.getMode().onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        boolean zVerifyRequestResult = PermissionHelper.verifyRequestResult(activity, i, iArr, strArr);
        MainLogger.m7258i(TAG, "onRequestPermissionsResult# verifyRequestResult : " + zVerifyRequestResult + ", requestCode : " + i);
        if (!zVerifyRequestResult) {
            if (i == 204) {
                MainLogger.m7258i(TAG, "onRequestPermissionsResult# COEDIT permission is not granted.");
                this.mNotesView.onFolderSelected(FolderConstants.AllNotes.UUID);
                return;
            }
            return;
        }
        if (i == 101) {
            if (Constants.ACTION_START_SHARED_NOTES.equals(activity.getIntent().getAction())) {
                this.mNotesView.goToGcsMode(getArguments(), activity.getIntent());
            }
            this.mNotesView.importDemoSamples();
            C6798g.m4962h().m4969n(activity.getClass());
            return;
        }
        if (i == 108) {
            this.mNotesPresenter.runPendingShareDialogTask();
            return;
        }
        if (i == 122) {
            this.mNotesPresenter.setRequestCodeForOtherApp(2);
            ContentPickerUtils.startPdfPickerActivityForResult(this, 122, 2, true, new Runnable[0]);
        } else if (i == 125) {
            this.mNotesPresenter.restoreLockHelperTask();
        } else if (i == 203) {
            this.mNotesView.getGcsImpl().onRequestPermissionsResult(i, strArr, iArr);
        } else {
            if (i != 307) {
                return;
            }
            ContentPickerUtils.startSaveDirectoryPickerActivityForResult(this, 307, 9);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void onRestoreCorruptedNoteSelect(MainEntryParam mainEntryParam) {
        this.mActivityContract.onNoteSelected(mainEntryParam);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MainLogger.m7258i(TAG, "onResume# " + hashCode());
        AppLaunchLog.m8605d(TAG, "onResume() - start");
        Trace.beginSection("NotesFragment onResume(MainList)");
        this.mNotesView.onResume();
        getAddonsHandler().onResume();
        BixbyManager.getInstance().registerNoteFragmentBixby2(new C8358c(this, 1));
        BixbyManager.getInstance().handleAppLink(101, getActivity().getIntent());
        if (this.mOnBackPressedCallback != null) {
            MainLogger.m7254d(TAG, "onResume# backPressedCallback enable : " + this.mOnBackPressedCallback.getIsEnabled());
            this.mOnBackPressedCallback.setEnabled(true);
        }
        Trace.endSection();
        AppLaunchLog.m8605d(TAG, "onResume() - end");
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        MainLogger.m7258i(TAG, NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE);
        this.mNotesView.onSaveInstanceState(bundle);
        getAddonsHandler().onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainLogger.m7258i(TAG, "onStart# " + hashCode());
        this.mNotesView.onStart();
        if (this.mOnBackPressedCallback != null) {
            MainLogger.m7254d(TAG, "onStart# backPressedCallback enable : " + this.mOnBackPressedCallback.getIsEnabled());
            this.mOnBackPressedCallback.setEnabled(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        MainLogger.m7258i(TAG, "onStop# " + hashCode());
        this.mNotesView.onStop();
        MainHandoffManager.INSTANCE.getInstance().releaseHandoffAction(getActivity());
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.setEnabled(false);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void onTagSelectedFromTagActivity(Set<String> set) {
        this.mNotesView.setMode(20);
        this.mNotesPresenter.onHashTagSelected(set);
    }

    public void onVerifyLockedNote(String str, int i) {
        MainListDocumentData noteData = getNoteData(str);
        if (noteData == null) {
            MainLogger.m7255e(TAG, "onVerifyLockedNote, failed, note data is null");
            return;
        }
        Intent intent = new Intent(getContext(), (Class<?>) ComposerActivity.class);
        intent.putExtra("sdoc_uuid", str);
        intent.putExtra("doc_path", noteData.getFilePath());
        intent.putExtra("tool_type", i);
        verifyLockedNote(100, intent, str);
    }

    public void onViewChangeRestoreInstanceState(Bundle bundle) {
        MainLogger.m7258i(TAG, "onViewChangeRestoreInstanceState");
        this.mNotesView.onViewChangeRestoreInstanceState(bundle);
        getAddonsHandler().onViewChangeRestoreInstanceState(bundle);
    }

    public void onViewChangeSaveInstanceState(@NonNull Bundle bundle) {
        MainLogger.m7258i(TAG, "onViewChangeSaveInstanceState");
        this.mNotesView.onViewChangeSaveInstanceState(bundle);
        getAddonsHandler().onViewChangeSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        MainLogger.m7254d(TAG, "onViewCreated - start");
        setHasOptionsMenu(true);
        NotesPresenter notesPresenter = new NotesPresenter();
        this.mNotesPresenter = notesPresenter;
        this.mNotesView = new NotesView((CustomSwipeRefreshLayout) view, this, notesPresenter, bundle);
        BixbyManager.getInstance().registerNoteFragmentBixby2(new C8358c(this, 0));
        int caller = this.mNotesPresenter.getStateInfo().getCaller();
        if (caller == 4 || caller == 5) {
            openLockedNoteByOtherApps(caller, getArguments());
        } else if (caller == 11) {
            startConvertNotes();
        }
        if (!this.mNotesPresenter.getBackPressedHelper().isSupportedPredictiveGesture()) {
            setBackPressedCallback();
        }
        setBackgroundResources(view);
        WindowManagerCompat.getInstance().setResizeFullscreenWindowOnSoftInput(getActivity());
        MainLogger.m7254d(TAG, "onViewCreated - end");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        getAddonsHandler().onRestoreInstanceState(bundle);
    }

    public void onWidthChangedByDrawerMove(float f) {
        if (ResourceUtils.isTabletLayout(getContext())) {
            this.mNotesPresenter.onWidthChangedByDrawerMove(f);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        this.mNotesView.onWindowFocusChanged(z);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void openDrawer(int i) {
        this.mActivityContract.openDrawer(i);
    }

    public void openLockedNoteByBixby(int i, Bundle bundle) {
        this.mNotesPresenter.getStateInfo().setCaller(5);
        openLockedNoteByOtherApps(i, bundle);
    }

    public void setContract(AbsAppCompatActivity absAppCompatActivity) {
        this.mActivityContract = absAppCompatActivity;
        setPostToken(absAppCompatActivity.getPostLaunchToken(), absAppCompatActivity.getPostResumeToken(), absAppCompatActivity.getPostStartToken());
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void setDrawerIconDimDragStatus(boolean z, ArrayList<String> arrayList) {
        this.mActivityContract.setDrawerIconDimDragStatus(z, arrayList);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IFragment
    public void setDrawerTitleBold(String str) {
        this.mActivityContract.setDrawerTitleBold(str);
    }

    public void setLastOpenedSDocXUuid(String str) {
        NotesPresenter notesPresenter = this.mNotesPresenter;
        if (notesPresenter == null) {
            return;
        }
        notesPresenter.setLastOpenedSDocXUuid(str);
    }

    public void showSearchMode(@NonNull String str) {
        if (str.equals(this.mNotesPresenter.getSavedSearchText())) {
            return;
        }
        NotesPresenter notesPresenter = this.mNotesPresenter;
        notesPresenter.setSavedSearchText(str, notesPresenter.getStateInfo().getSearchCoverData());
        this.mNotesPresenter.setIsInAppSearch(false);
        if (this.mNotesView.setMode(3)) {
            return;
        }
        this.mNotesPresenter.getSearchHelper().requestSearch(str);
    }

    public void startConvertNotes() {
        if (this.mNotesView.getModeIndex() == 22) {
            this.mNotesView.onBackKeyDown();
        }
        this.mNotesPresenter.showConvertConfirmDialog(true);
    }

    public void startLandingInvitationLinkAction(String str, String str2, String str3, boolean z) {
        if (this.mNotesView.getModeIndex() == 12) {
            getActivity().getIntent().setAction("android.intent.action.VIEW");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = SesCoeditShareReadResolver.getInstance().getSpaceIdByGroupId(str);
        }
        this.mNotesPresenter.getStateInfo().setGroupId(str);
        this.mNotesPresenter.getStateInfo().setSpaceId(str2);
        this.mNotesPresenter.getStateInfo().setGroupName(str3);
        this.mNotesPresenter.getStateInfo().setInvitationAcceptedByNotification(z);
        MainLogger.m7254d(TAG, "startLandingInvitationLinkAction# groupId : " + str + ", spaceId : " + str2 + ", groupName : " + str3);
        this.mNotesView.onFolderSelected(FolderConstants.Coedit.UUID);
    }

    public void startLiveSharingNotes() {
        if (this.mNotesView.getModeIndex() == 12) {
            this.mNotesView.getSpaceImpl().handleMeetJoinAction();
        } else {
            this.mNotesView.onFolderSelected(FolderConstants.Coedit.UUID);
        }
    }

    public void startSALogging() {
        if (this.mNotesPresenter == null) {
            return;
        }
        new NotesListSALoggingHelper().startStatusLogging(this.mNotesPresenter.getDocumentMap().getFolderMap(), this.mNotesPresenter.getDocumentMap().getNoteMap());
    }

    public void unlockNote(int i, Intent intent, String... strArr) {
        this.mNotesPresenter.unlockNote(i, intent, strArr);
    }

    public void updateDocumentCountMap(Map<String, NotesDocumentCountEntry> map) {
        this.mNotesPresenter.getDocumentMap().updateDocumentCountMap(map);
    }

    public void updateDrawerIconWithBadge() {
        NotesView notesView = this.mNotesView;
        if (notesView == null) {
            return;
        }
        notesView.updateDrawerIconWithBadge();
    }

    public void updateNoteViewByDrawerObserver(boolean z) {
        this.mNotesView.updateNoteViewByDrawerObserver(z);
    }

    public void verifyForDelete() {
        NotesPresenter notesPresenter = this.mNotesPresenter;
        if (notesPresenter == null) {
            return;
        }
        notesPresenter.getLockHelper().verifyForDelete(112);
    }

    public void verifyLockedNote(int i, Intent intent, String... strArr) {
        this.mNotesPresenter.verifyLockedNote(i, intent, strArr);
    }

    public void verifyLockedNoteWithMultiAccount(int i, Intent intent, String... strArr) {
        this.mNotesPresenter.verifyLockedNoteWithMultiAccount(i, intent, strArr);
    }

    public NotesFragment(Bundle bundle) {
        setArguments(bundle);
    }
}
