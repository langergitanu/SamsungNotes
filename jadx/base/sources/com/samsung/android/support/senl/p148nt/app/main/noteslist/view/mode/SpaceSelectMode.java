package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.util.SeslKoreanGeneralizer;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.app.notes.sync.contentsharing.controllers.C6684b;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6727e;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6728f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6900c;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceResult;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.data.RepositoryManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker.CoeditSpacePickerActivity;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.view.CustomImageMarginSpan;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.IntentFactory;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.CoeditHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.tipcard.TipCardHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.GcsImpl;
import com.samsung.android.support.senl.p148nt.app.nativecomposer.ComposerActivity;
import com.samsung.android.support.senl.p148nt.app.sync.receiver.GcsSpaceDeleteReceivedReceiver;
import com.samsung.android.support.senl.p148nt.app.sync.receiver.GcsSpaceMemberUpdateReceivedReceiver;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import p028G.InterfaceC0102a;
import p032H.C0110a;
import p042J1.C0145c;
import p052M.C0171a;
import p063P.InterfaceC0192a;
import p075S.AbstractC0248O;
import p079T.AbstractC0294l;
import p079T.C0283a;
import p258y.AbstractC14516b;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SpaceSelectMode extends GcsBaseMode implements GcsImpl {
    private static final String TAG = "SpaceSelectMode";
    private InterfaceC0192a mGcsSpaceDeleteProgressListener;
    private InterfaceC0192a mGcsSpaceImportProgressListener;
    private final InterfaceC0102a mImportProgressListener;
    private String mInvitationLink;
    protected boolean mIsEditMode;
    private DialogFragment mProgressDialog;
    private ShareSyncResultCallback mShareSyncResultCallback;
    protected final GcsSpaceDeleteReceivedReceiver mSpaceDeleteReceivedReceiver;
    protected final GcsSpaceMemberUpdateReceivedReceiver mSpaceMemberUpdateRecivedReceiver;
    private SpaceResultCallback mSpaceResultCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ShareSyncResultCallback implements ShareApi.ShareSyncResultCallback {
        private static final String TAG = "ShareSyncResultCallback";

        public /* synthetic */ ShareSyncResultCallback(int i) {
            this();
        }

        @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareSyncResultCallback
        public void onResult(BooleanResult booleanResult) {
            if (booleanResult.getResult()) {
                MainLogger.m7258i(TAG, "Share Service is updated!");
            } else {
                MainLogger.m7258i(TAG, "Share Service is not updated!");
            }
        }

        private ShareSyncResultCallback() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SpaceResultCallback implements ShareApi.SpaceResultCallback {
        private static final String TAG = "SpaceResultCallback";
        private WeakReference<SpaceSelectMode> mModeWeakReference;

        public SpaceResultCallback(SpaceSelectMode spaceSelectMode) {
            this.mModeWeakReference = new WeakReference<>(spaceSelectMode);
        }

        @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceResultCallback
        public void onResult(SpaceResult spaceResult) {
            WeakReference<SpaceSelectMode> weakReference = this.mModeWeakReference;
            if (weakReference == null) {
                return;
            }
            SpaceSelectMode spaceSelectMode = weakReference.get();
            int code = spaceResult.getStatus().getCode();
            if (code == 107) {
                MainLogger.m7258i(TAG, "SpaceResultCallback onResult(). invalid space, finished");
                spaceSelectMode.onBackKeyDown();
            } else if (code == 102) {
                MainLogger.m7258i(TAG, "SpaceResultCallback onResult(). invalid access(permission), finished");
                spaceSelectMode.onBackKeyDown();
            }
        }

        public void release() {
            WeakReference<SpaceSelectMode> weakReference = this.mModeWeakReference;
            if (weakReference != null) {
                weakReference.clear();
                this.mModeWeakReference = null;
            }
        }
    }

    public SpaceSelectMode(ModeParams modeParams) {
        super(modeParams);
        this.mIsEditMode = false;
        this.mSpaceDeleteReceivedReceiver = new GcsSpaceDeleteReceivedReceiver() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.SpaceSelectMode.1
            @Override // com.samsung.android.support.senl.p148nt.app.sync.receiver.GcsSpaceDeleteReceivedReceiver
            public void onSpaceDeleted(String str, String str2) {
                if (!CommonUtil.isNotAvailableActivity(SpaceSelectMode.this.mFragment.getActivity()) && SpaceSelectMode.this.mPresenter.getStateInfo().getGroupId().equals(str)) {
                    MainLogger.m7258i(SpaceSelectMode.TAG, "onSpaceDeleted# " + str + ", groupName: " + str2);
                    SpaceSelectMode.this.onBackKeyDown();
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    ToastHandler.show(SpaceSelectMode.this.mContext, new SeslKoreanGeneralizer().naturalizeText(SpaceSelectMode.this.mAppContext.getResources().getString(C8003R.string.gcs_space_deleted_body, str2)), 1, false);
                }
            }
        };
        this.mSpaceMemberUpdateRecivedReceiver = new GcsSpaceMemberUpdateReceivedReceiver() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.SpaceSelectMode.2
            @Override // com.samsung.android.support.senl.p148nt.app.sync.receiver.GcsSpaceMemberUpdateReceivedReceiver
            public void onSpaceMemberUpdated(final String str) {
                MainLogger.m7258i(SpaceSelectMode.TAG, "onSpaceMemberUpdated# " + str);
                new Handler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.SpaceSelectMode.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SpaceSelectMode.this.updateSubTitle(str);
                    }
                }, 1000L);
            }
        };
        this.mImportProgressListener = new InterfaceC0102a() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.SpaceSelectMode.3
            @Override // p028G.InterfaceC0102a
            public void onEnded(final String str, int i) {
                MainCoeditLogger.m7253i(SpaceSelectMode.TAG, "ImportProgressListener onEnded# " + str + " errorCode: " + i);
                SpaceSelectMode.this.removeImportProgress();
                SpaceSelectMode.this.removeCircleProgressDialog();
                if (i != 200) {
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.SpaceSelectMode.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SpaceSelectMode spaceSelectMode = SpaceSelectMode.this;
                        ToastHandler.show(spaceSelectMode.mContext, spaceSelectMode.mAppContext.getResources().getString(C8003R.string.gcs_save_to_new_coedit_success_message, SesCoeditShareReadResolver.getInstance().getSpaceTitle(str)), 1);
                        if (TextUtils.isEmpty(SpaceSelectMode.this.mInvitationLink)) {
                            return;
                        }
                        MainCoeditLogger.m7253i(SpaceSelectMode.TAG, "ImportProgressListener onEnded# openShareViaInvitationLink");
                        String spaceTitleWithPrefix = SesCoeditShareReadResolver.getInstance().getSpaceTitleWithPrefix(str);
                        OpenSessionApi openSessionApi = new OpenSessionApi();
                        SpaceSelectMode spaceSelectMode2 = SpaceSelectMode.this;
                        SpaceSelectMode.this.mFragment.startActivity(openSessionApi.getIntentForShareViaInvitationLink(spaceSelectMode2.mAppContext, 501, spaceTitleWithPrefix, spaceSelectMode2.mInvitationLink));
                        SpaceSelectMode.this.mInvitationLink = null;
                    }
                });
            }

            @Override // p028G.InterfaceC0102a
            public void onProgress(int i, int i2) {
            }

            @Override // p028G.InterfaceC0102a
            public void onStarted(String str) {
                MainCoeditLogger.m7253i(SpaceSelectMode.TAG, "ImportProgressListener onStarted# " + str);
                SpaceSelectMode.this.showImportProgress();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissMDEDeleteDialog() {
        DialogViewContract.IDialogFragment iDialogFragment;
        MainLogger.m7258i(TAG, "replaceDeleteBtnToProgress - tag: DeleteGcsSpaceDialog");
        if (this.mFragment.isAdded() && (iDialogFragment = (DialogViewContract.IDialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(NotesConstants.DialogTag.DELETE_GCS_SPACE_DIALOG)) != null) {
            iDialogFragment.dismissAllowingStateLoss();
        }
    }

    private void editGroupMember(String str, String str2) {
        Intent intentM575b;
        if (TextUtils.isEmpty(str)) {
            MainLogger.m7258i(TAG, "editGroupMember(). groupId is null or empty");
            return;
        }
        if (SesGroupReadResolver.getInstance().isLocalGroupType(str)) {
            intentM575b = AbstractC0294l.m575b(str, str2);
        } else {
            ExecutorService executorService = AbstractC0294l.f760a;
            Intent intent = new Intent();
            intent.setAction("com.samsung.android.mobileservice.action.ACTION_GROUP_DETAIL");
            intent.putExtra("group_id", str);
            intent.setPackage("com.samsung.android.mobileservice");
            intent.setFlags(603979776);
            intentM575b = intent;
        }
        try {
            this.mFragment.startActivity(intentM575b);
        } catch (ActivityNotFoundException e) {
            MainLogger.m7255e(TAG, "editGroupMember(). ActivityNotFoundException " + e.getMessage());
        }
    }

    private boolean hasOwnership(MainListDocumentData mainListDocumentData) {
        if (mainListDocumentData == null || mainListDocumentData.getMdeItemId().isEmpty()) {
            return true;
        }
        return AbstractC14517a.m15166z(this.mContext, mainListDocumentData.getUuid());
    }

    private void launchSpacePickerActivity(String str) {
        Intent intent = new Intent(this.mFragment.getActivity(), NoteListAccessHandler.getNotePickerClass());
        intent.putExtra("spaceId", str);
        intent.putExtra("mode", 8);
        intent.setAction(NotesConstants.ACTION_PICK_NOTES_FROM_SPACE);
        this.mFragment.startActivity(intent);
    }

    private void onOptionsItemSelectedSALogging(int i) {
        if (i == C8003R.id.action_edit) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_SPACE_SELECT, NotesSAConstants.EVENT_GCS_SPACE_EDIT);
        } else if (i == C8003R.id.action_group_member_list) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_SPACE_SELECT, NotesSAConstants.EVENT_GCS_SPACE_SHARED_MEMBER);
        } else if (i == C8003R.id.action_import_notes) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_SPACE_SELECT, NotesSAConstants.EVENT_GCS_SPACE_IMPORT_NOTES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeImportProgress() {
        if (this.mProgressDialog != null) {
            MainCoeditLogger.m7253i(TAG, "removeImportProgress#");
            this.mProgressDialog.dismissAllowingStateLoss();
            this.mProgressDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeProgress() {
        this.mPresenter.showProgressCircle(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceDeleteBtnToProgress() {
        DialogViewContract.IDialogFragment iDialogFragment;
        MainLogger.m7258i(TAG, "replaceDeleteBtnToProgress - tag: DeleteGcsSpaceDialog");
        if (this.mFragment.isAdded() && (iDialogFragment = (DialogViewContract.IDialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(NotesConstants.DialogTag.DELETE_GCS_SPACE_DIALOG)) != null) {
            iDialogFragment.replaceBtnToProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSesShareSync() {
        try {
            if (this.mShareSyncResultCallback == null) {
                this.mShareSyncResultCallback = new ShareSyncResultCallback(0);
            }
            AbstractC0248O.m534h(this.mShareSyncResultCallback);
        } catch (Exception e) {
            AbstractC14516b.m15115c(e, new StringBuilder("[CS1-2] Exception : "), TAG);
        }
    }

    private void setGcsSpaceDeleteProgressListener() {
        this.mGcsSpaceDeleteProgressListener = new InterfaceC0192a() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.SpaceSelectMode.6
            @Override // p063P.InterfaceC0192a
            public void onEnded(String str, int i) {
                MainLogger.m7258i(SpaceSelectMode.TAG, "setGcsSpaceDeleteProgressListener# onEnded " + str + " errorCode " + i);
                SpaceSelectMode.this.dismissMDEDeleteDialog();
                SpaceSelectMode.this.requestSesShareSync();
            }

            @Override // p063P.InterfaceC0192a
            public void onStarted(String str) {
                AbstractC8014b.m7209k("setGcsSpaceDeleteProgressListener# onStarted ", str, SpaceSelectMode.TAG);
                SpaceSelectMode.this.replaceDeleteBtnToProgress();
            }
        };
        C0171a c0171aM429a = C0171a.m429a();
        InterfaceC0192a interfaceC0192a = this.mGcsSpaceDeleteProgressListener;
        c0171aM429a.f543a.getClass();
        C6727e.m4818b(interfaceC0192a);
    }

    private void setGcsSpaceImportProgressListener() {
        if (C0171a.m429a().m430b()) {
            showProgress();
        }
        this.mGcsSpaceImportProgressListener = new InterfaceC0192a() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.SpaceSelectMode.5
            @Override // p063P.InterfaceC0192a
            public void onEnded(String str, int i) {
                MainLogger.m7258i(SpaceSelectMode.TAG, "onEnded " + str + " errorCode " + i);
                SpaceSelectMode.this.removeProgress();
                SpaceSelectMode.this.requestSesShareSync();
            }

            @Override // p063P.InterfaceC0192a
            public void onStarted(String str) {
                AbstractC8014b.m7209k("onStarted ", str, SpaceSelectMode.TAG);
                SpaceSelectMode.this.showProgress();
            }
        };
        C0171a c0171aM429a = C0171a.m429a();
        InterfaceC0192a interfaceC0192a = this.mGcsSpaceImportProgressListener;
        c0171aM429a.f543a.getClass();
        C6728f.m4820b(interfaceC0192a);
    }

    private void setSpaceListLayout() {
        if (((AppCompatActivity) this.mFragment.getActivity()).getSupportActionBar() != null) {
            this.mActionMenuController.setDisplayHomeAsUpEnabled(true);
            String spaceId = this.mPresenter.getStateInfo().getSpaceId();
            String groupId = this.mPresenter.getStateInfo().getGroupId();
            this.mActionMenuController.setToolbarTitle(SesShareReadResolver.getInstance().getSpaceTitle(spaceId));
            updateSubTitle(groupId);
        } else {
            this.mActionMenuController.initExtendedToolbar();
        }
        this.mBottomMenuController.showBottomNavigation(false);
        updateBasicEffect(false);
    }

    private void setTipCard(int i) {
        AbstractC8014b.m7201c(i, "setTipCard# caller : ", getTag());
        TipCardHelper tipCardHelper = this.mPresenter.getTipCardHelper();
        if (i == 0) {
            tipCardHelper.setSyncTipCardProgressListener();
            return;
        }
        if (i == 1) {
            tipCardHelper.clearTipCard(true);
            tipCardHelper.loadSyncTipCard(getModeIndex());
        } else {
            if (i != 2) {
                return;
            }
            tipCardHelper.loadSyncTipCard(getModeIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showImportProgress() {
        if (this.mProgressDialog != null) {
            MainCoeditLogger.m7253i(TAG, "showImportProgress# already showing");
            return;
        }
        MainCoeditLogger.m7253i(TAG, "showImportProgress#");
        DialogFragment dialogFragmentCreateProgressDialogFragment = DialogUtils.createProgressDialogFragment();
        this.mProgressDialog = dialogFragmentCreateProgressDialogFragment;
        dialogFragmentCreateProgressDialogFragment.setCancelable(false);
        ((DialogUtils.ProgressDialogFragment) this.mProgressDialog).showAllowingStateLoss(this.mFragment.getChildFragmentManager(), TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgress() {
        this.mPresenter.showProgressCircle(100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubTitle(String str) {
        int groupCount = SesGroupReadResolver.getInstance().getGroupCount(str);
        String spaceId = this.mPresenter.getStateInfo().getSpaceId();
        Editable editableNewEditable = Editable.Factory.getInstance().newEditable(this.mAppContext.getResources().getQuantityString(C8003R.plurals.plurals_shared_with_n_members, groupCount, Integer.valueOf(groupCount)));
        if (SesShareReadResolver.getInstance().isSpaceOwner(spaceId)) {
            Drawable drawable = ResourcesCompat.getDrawable(this.mAppContext.getResources(), C8003R.drawable.ic_gcs_space_sub_title_owner, null);
            if (LocaleUtils.isRTLMode()) {
                editableNewEditable.insert(0, UnicodeUtils.RLM);
            } else {
                editableNewEditable.insert(0, "\u200e");
            }
            editableNewEditable.setSpan(new CustomImageMarginSpan(0, drawable, (int) this.mAppContext.getResources().getDimension(C8003R.dimen.gcs_space_sub_title_crown_padding_end), (int) this.mAppContext.getResources().getDimension(C8003R.dimen.gcs_group_list_item_count_icon_size), false, 0), 0, 1, 33);
        }
        this.mActionMenuController.setToolbarSubTitle(editableNewEditable);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public Intent getIntentForNoteSelected(MainEntryParam mainEntryParam) {
        Intent intentMakeIntent = IntentFactory.makeIntent(3, this.mActivity, mainEntryParam);
        intentMakeIntent.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, this.mPresenter.getStateInfo().getSpaceId());
        intentMakeIntent.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, this.mPresenter.getStateInfo().getGroupId());
        return intentMakeIntent;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 10;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        C0171a.m429a().f543a.getClass();
        if (C6727e.m4819c()) {
            MainLogger.m7254d(TAG, "onBackKeyDown# isMdeDeleting");
            C6684b c6684b = C0171a.m429a().f543a;
            c6684b.getClass();
            Debugger.m8607d("ShareOldServiceController", "stopDelete()");
            c6684b.m4777a(new C6900c());
            return true;
        }
        if (C0171a.m429a().m430b()) {
            MainLogger.m7254d(TAG, "onBackKeyDown# isMdeImporting");
            C6684b c6684b2 = C0171a.m429a().f543a;
            c6684b2.getClass();
            Debugger.m8607d("ShareOldServiceController", "stopImport()");
            c6684b2.m4777a(new C0110a());
            return true;
        }
        if (!NotesUtils.isTabletLayout(this.mContext) && super.onBackKeyDown()) {
            return true;
        }
        this.mNotesView.setIsScrollToTop(true, 0);
        this.mNotesView.setMode(24);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onBindViewHolder(CommonHolderInfo commonHolderInfo, CheckBox checkBox, TextView textView) {
        super.onBindViewHolder(commonHolderInfo, checkBox, textView);
        MainListDocumentData noteData = this.mPresenter.getDocumentMap().getNoteData(commonHolderInfo.getUuid());
        if (noteData == null) {
            return;
        }
        commonHolderInfo.setGcsExtraVisible(hasOwnership(noteData), noteData.getIsDirty() == 1, noteData.getFirstOpenedAt() == 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onContextClick(final CommonHolderInfo commonHolderInfo) {
        PopupMenu popupMenuCreateContextPopupMenu = createContextPopupMenu(commonHolderInfo);
        if (popupMenuCreateContextPopupMenu == null) {
            return false;
        }
        MainLogger.m7254d(TAG, "onContextClick " + commonHolderInfo.getUuid());
        popupMenuCreateContextPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.SpaceSelectMode.7
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                SpaceSelectMode.this.mPresenter.updateCheckedData(commonHolderInfo, true);
                int itemId = menuItem.getItemId();
                if (itemId == C8003R.id.action_delete) {
                    SpaceSelectMode.this.mPresenter.showDeleteGcsSpaceNotesDialog(1);
                } else if (itemId == C8003R.id.action_save_to_device) {
                    SpaceSelectMode.this.mPresenter.duplicateToDevice();
                } else {
                    if (itemId != C8003R.id.action_save_to_new_coedit) {
                        SpaceSelectMode.this.mPresenter.updateCheckedData(commonHolderInfo, false);
                        return false;
                    }
                    SpaceSelectMode.this.showCoeditSpacePicker();
                }
                return true;
            }
        });
        popupMenuCreateContextPopupMenu.show();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Drawable icon;
        menuInflater.inflate(C8003R.menu.gcs_spacelist_select, menu);
        MenuItem menuItemFindItem = menu.findItem(C8003R.id.action_group_member_list);
        if (menuItemFindItem == null || (icon = menuItemFindItem.getIcon()) == null) {
            return;
        }
        icon.setTintList(ColorStateList.valueOf(ContextCompat.getColor(this.mContext, C8003R.color.notes_toolbar_action_menu_color)));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        if (i != 42) {
            return super.onCustomKeyEvent(i, keyEvent);
        }
        if (keyEvent.getAction() == 0 || (keyEvent.getMetaState() & 4096) != 4096) {
            return false;
        }
        this.mNotesView.onNewNote(FolderConstants.SharedNotes.UUID, 1);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        super.onDataChangedViewUpdate(i);
        if (hasCreatePostLogic()) {
            return;
        }
        setTipCard(2);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDestroy() {
        super.onDestroy();
        C0171a.m429a().m431c(this.mGcsSpaceDeleteProgressListener);
        C0171a c0171aM429a = C0171a.m429a();
        InterfaceC0192a interfaceC0192a = this.mGcsSpaceImportProgressListener;
        c0171aM429a.f543a.getClass();
        C6728f.m4821c(interfaceC0192a);
        GcsSpaceDeleteReceivedReceiver.unregisterReceiver(this.mContext, this.mSpaceDeleteReceivedReceiver);
        GcsSpaceMemberUpdateReceivedReceiver.unregisterReceiver(this.mContext, this.mSpaceMemberUpdateRecivedReceiver);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_SPACE_SELECT, NotesSAConstants.EVENT_GCS_SPACE_SELECTION_MODE);
        setEditMode(true);
        super.onItemLongPressed(str);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.GcsBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        Intent intent;
        super.onLayout();
        setSpaceListLayout();
        setTipCard(1);
        this.mActivity.findViewById(C8003R.id.main_view_block).setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.SpaceSelectMode.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return view.getVisibility() == 0;
            }
        });
        if (this.mPresenter.getStateInfo().getSpaceId() == null && (intent = this.mActivity.getIntent()) != null) {
            this.mPresenter.getStateInfo().setSpaceId(intent.getStringExtra(ComposerConstants.ARG_MDE_SPACE_ID));
            this.mPresenter.getStateInfo().setGroupId(intent.getStringExtra(ComposerConstants.ARG_MDE_GROUP_ID));
        }
        if (SesShareReadResolver.getInstance().getGroupId(this.mPresenter.getStateInfo().getSpaceId()).isEmpty()) {
            MainLogger.m7255e(TAG, "onLayout() finish - groupId is null.");
            onBackKeyDown();
        }
        setGcsSpaceDeleteProgressListener();
        setGcsSpaceImportProgressListener();
        GcsSpaceDeleteReceivedReceiver.registerReceiver(this.mContext, this.mSpaceDeleteReceivedReceiver);
        GcsSpaceMemberUpdateReceivedReceiver.registerReceiver(this.mContext, this.mSpaceMemberUpdateRecivedReceiver);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.GcsBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        super.onModeEnd();
        if (this.mShareSyncResultCallback != null) {
            this.mShareSyncResultCallback = null;
        }
        SpaceResultCallback spaceResultCallback = this.mSpaceResultCallback;
        if (spaceResultCallback != null) {
            spaceResultCallback.release();
            this.mSpaceResultCallback = null;
        }
        C0171a.m429a().m431c(this.mGcsSpaceDeleteProgressListener);
        C0171a c0171aM429a = C0171a.m429a();
        InterfaceC0192a interfaceC0192a = this.mGcsSpaceImportProgressListener;
        c0171aM429a.f543a.getClass();
        C6728f.m4821c(interfaceC0192a);
        GcsSpaceDeleteReceivedReceiver.unregisterReceiver(this.mContext, this.mSpaceDeleteReceivedReceiver);
        GcsSpaceMemberUpdateReceivedReceiver.unregisterReceiver(this.mContext, this.mSpaceMemberUpdateRecivedReceiver);
        FragmentActivity activity = this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        activity.invalidateOptionsMenu();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.GcsImpl
    public void onNewNote(String str, int i) {
        Intent intent = new Intent(this.mAppContext, (Class<?>) ComposerActivity.class);
        intent.setAction(ComposerConstants.ACTION_NEW_MEMO);
        intent.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, this.mPresenter.getStateInfo().getSpaceId());
        intent.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, this.mPresenter.getStateInfo().getGroupId());
        C0283a.m562d().getClass();
        intent.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, C0283a.m561c());
        intent.putExtra(ComposerConstants.ARG_MDE_WRITER, "test");
        intent.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, 1);
        intent.putExtra("tool_type", i);
        intent.putExtra(ComposerConstants.ARG_PAGE_TYPE, SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1));
        intent.putExtra("category_id", FolderConstants.SharedNotes.UUID);
        this.mActivity.startActivityForResult(intent, 7);
        if (WindowManagerCompat.getInstance().isFreeFormWindow(this.mActivity)) {
            return;
        }
        this.mActivity.overridePendingTransition(C8003R.anim.new_activity_from_bottom_to_top, C8003R.anim.prev_activity_exit_with_dim);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_SPACE_SELECT, NotesSAConstants.EVENT_GCS_SPACE_VIEW_SHARED_NOTES);
        super.onNoteSelected(mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.MemoList;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        String spaceId = this.mPresenter.getStateInfo().getSpaceId();
        int itemId = menuItem.getItemId();
        MainLogger.m7254d(TAG, "onOptionsItemSelected# " + ((Object) menuItem.getTitle()));
        onOptionsItemSelectedSALogging(itemId);
        if (itemId == C8003R.id.action_edit) {
            setEditMode(true);
            return true;
        }
        if (itemId == C8003R.id.action_group_member_list) {
            editGroupMember(this.mPresenter.getStateInfo().getGroupId(), SesShareReadResolver.getInstance().getSpaceTitle(spaceId));
            return true;
        }
        if (itemId == C8003R.id.action_sortby) {
            this.mPresenter.showSortByDialog();
            return true;
        }
        if (itemId == C8003R.id.action_import_notes) {
            launchSpacePickerActivity(spaceId);
            return true;
        }
        if (itemId != C8003R.id.action_upload_now) {
            return false;
        }
        C0171a c0171aM429a = C0171a.m429a();
        FragmentActivity fragmentActivity = this.mActivity;
        c0171aM429a.getClass();
        c0171aM429a.f545c = new WeakReference(fragmentActivity);
        if (C0145c.m333r(fragmentActivity.getApplicationContext())) {
            c0171aM429a.m434f();
            return true;
        }
        c0171aM429a.m433e(spaceId, true);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPostResume() {
        super.onPostResume();
        if (this.mIsEditMode) {
            return;
        }
        setTipCard(0);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareOptionsMenu(Menu menu) {
        String spaceId = this.mPresenter.getStateInfo().getSpaceId();
        int commonDisplayListSize = this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0]);
        SyncNoteDataRepository syncNoteDataRepository = RepositoryManager.getInstance().getSyncNoteDataRepository();
        C0283a.m562d().getClass();
        int gcsOwnerNoteCount = syncNoteDataRepository.getGcsOwnerNoteCount(spaceId, C0283a.m561c());
        if (commonDisplayListSize == 0) {
            menu.removeItem(C8003R.id.action_edit);
            menu.removeItem(C8003R.id.action_upload_now);
            menu.removeItem(C8003R.id.action_sortby);
        } else if (RepositoryManager.getInstance().getSyncNoteDataRepository().getCountIsDirty(1, spaceId) == 0) {
            menu.removeItem(C8003R.id.action_upload_now);
        }
        if (gcsOwnerNoteCount == 0) {
            menu.removeItem(C8003R.id.action_edit);
        }
        if (DataManager.getInstance().getAllUsedNoteCount() == 0) {
            menu.removeItem(C8003R.id.action_import_notes);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mProgressDialog = (DialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(TAG);
        CoeditHelper.restoreImportProgressListener(this.mImportProgressListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.GcsBaseMode
    public boolean onSesSessionConnected() {
        boolean zOnSesSessionConnected = super.onSesSessionConnected();
        try {
            if (this.mSpaceResultCallback == null) {
                this.mSpaceResultCallback = new SpaceResultCallback(this);
            }
            AbstractC0248O.m532f(this.mPresenter.getStateInfo().getSpaceId(), this.mSpaceResultCallback);
        } catch (Exception e) {
            AbstractC14516b.m15115c(e, new StringBuilder("[CS1-2] onSesSessionConnected# requestSpace e : "), TAG);
        }
        C0171a c0171aM429a = C0171a.m429a();
        String spaceId = this.mPresenter.getStateInfo().getSpaceId();
        FragmentActivity fragmentActivity = this.mActivity;
        c0171aM429a.getClass();
        c0171aM429a.f545c = new WeakReference(fragmentActivity);
        if (C0145c.m333r(fragmentActivity.getApplicationContext())) {
            c0171aM429a.m434f();
        } else {
            c0171aM429a.m432d(spaceId);
        }
        return zOnSesSessionConnected;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean setEditMode(boolean z) {
        super.setEditMode(z);
        return this.mNotesView.setMode(11);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void setNoHolderLayout() {
        TextView textView = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_note);
        TextView textView2 = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_note_sub);
        TextView textView3 = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_result);
        textView.setVisibility(0);
        textView.setText(this.mFragment.getResources().getString(C8003R.string.no_gcs_notes));
        textView2.setVisibility(8);
        textView3.setVisibility(8);
    }

    public void showCoeditSpacePicker() {
        CoeditHelper.setImportProgressListener(this.mImportProgressListener);
        Intent intent = new Intent(this.mAppContext, (Class<?>) CoeditSpacePickerActivity.class);
        intent.putExtra(NotesConstants.KEY_OPENED_BY_LIST, true);
        this.mFragmentContract.launchPopOverActivity(intent, 102, new NotesActivityResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.SpaceSelectMode.8
            @Override // com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback
            public void onActivityResult(int i, @Nullable Intent intent2) {
                if (intent2 == null || i != -1) {
                    return;
                }
                String stringExtra = intent2.getStringExtra(ComposerConstants.ARG_MDE_SPACE_ID);
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                SpaceSelectMode.this.mInvitationLink = intent2.getStringExtra(ComposerConstants.ARG_MDE_COEDIT_INVITE_URL);
                SpaceSelectMode.this.mPresenter.getCoeditHelper().importNoteToSpace(SpaceSelectMode.this.mContext, stringExtra, false);
            }
        });
    }
}
