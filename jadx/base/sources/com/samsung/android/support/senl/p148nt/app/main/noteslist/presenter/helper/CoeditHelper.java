package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.controllers.C6666b;
import com.samsung.android.app.notes.sync.coedit.sharelogic.C6679d;
import com.samsung.android.app.notes.sync.contentsharing.controllers.C6684b;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.CoeditInvitationMenuBadgeUpdater;
import com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.NotesModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckedNoteInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.p149sa.NotesListSALogModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.presenter.GcsGroupNetworkUtils;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.CoeditLaunchNotification;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.CoeditNotificationConstants;
import com.samsung.android.support.senl.p148nt.app.sync.receiver.CoeditInviteReceivedReceiver;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.AnchorViewUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.coedit.caller.CoeditNoteUpDownloader;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.ImportResult;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p012C1.CallableC0047c;
import p020E.C0073a;
import p028G.InterfaceC0102a;
import p042J1.C0145c;
import p052M.C0171a;
import p075S.AbstractC0267s;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditHelper {
    private static final int COEDIT_SHARE_WITH_COLLABORATORS = 0;
    private static final int COEDIT_START_WITH_SPACE = 1;
    private static final String KEY_INVITATION_LINK = "invitation_link";
    private static final String KEY_PROGRESS_STATE = "progress_state";
    private static final String KEY_STANDALONE = "standalone";
    private static final int START_COEDIT = 1;
    private static final String TAG = "CoeditHelper";
    private static InterfaceC0102a mImportProgressListeners;
    protected final CoeditInviteReceivedReceiver mCoeditInviteReceivedReceiver = new CoeditInviteReceivedReceiver() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.CoeditHelper.1
        private void notifyAcceptInviteNotification(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("group_id");
            String stringExtra2 = intent.getStringExtra("group_name");
            String stringExtra3 = intent.getStringExtra(CoeditNotificationConstants.EXTRA_GROUP_REQUESTR_NAME);
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra3)) {
                StringBuilder sbM16m = AbstractC0000a.m16m("notifyAcceptInviteNotification# Null ", stringExtra, " ", stringExtra2, " ");
                sbM16m.append(stringExtra3);
                MainCoeditLogger.m7250d(CoeditHelper.TAG, sbM16m.toString());
            } else {
                MainCoeditLogger.m7250d(CoeditHelper.TAG, "notifyAcceptInviteNotification#");
                CoeditInvitationMenuBadgeUpdater.setInvitationListHasBadgePref(stringExtra, true);
                CoeditHelper.this.mViewParams.getNotesView().updateDrawerIconWithBadge();
                if (FeatureUtils.isCoeditMode(CoeditHelper.this.mViewParams.getModeIndex())) {
                    return;
                }
                new CoeditLaunchNotification(context).launchInvitationNotification(stringExtra, stringExtra2, stringExtra3);
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.app.sync.receiver.CoeditInviteReceivedReceiver
        public void onGroupInvitationReceived(Context context, Intent intent) {
            MainCoeditLogger.m7253i(CoeditHelper.TAG, "onGroupInvitationReceived");
            if (CoeditHelper.this.mViewParams.getNotesView().getSpaceImpl().onGroupInvitationReceived()) {
                return;
            }
            notifyAcceptInviteNotification(context, intent);
        }

        @Override // com.samsung.android.support.senl.p148nt.app.sync.receiver.CoeditInviteReceivedReceiver
        public void onNotificationOperated(String str) {
            MainCoeditLogger.m7253i(CoeditHelper.TAG, "onNotificationOperated# groupId: " + str);
            CoeditHelper.this.mPresenter.removeCoeditInvitation(str);
            CoeditInvitationMenuBadgeUpdater.setInvitationListHasBadgePref(str, false);
            CoeditHelper.this.mViewParams.getNotesView().updateDrawerIconWithBadge();
        }
    };
    private CoeditTypeMenu mCoeditPopupMenu;
    private InterfaceC0102a mDeleteProgressListener;
    private final DocumentMap mDocumentMap;
    private final AbsFragment mFragment;
    private String mInvitationLink;
    private boolean mIsStandalone;
    private final NotesModel mNotesModel;
    private final IPresenter mPresenter;
    private final StateInfo mStateInfo;
    private final ViewParams mViewParams;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CoeditTypeMenu extends AbsPopupMenu {
        private static final String TAG = Logger.createTag("CoeditTypeMenu");
        protected LinkedHashMap<Integer, String> mCoeditTypeItems = null;
        private LinkedHashMap<Integer, String> mSATypeItems = null;
        private int mType = 0;

        public CoeditTypeMenu() {
        }

        public int getCoeditType() {
            return this.mType;
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
        public ArrayList<String> getMenuItems() {
            return new ArrayList<>(this.mCoeditTypeItems.values());
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
        public View.OnClickListener getOnClickListener() {
            return new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.CoeditHelper.CoeditTypeMenu.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int iIntValue = ((Integer) view.getTag()).intValue();
                    if (iIntValue < CoeditTypeMenu.this.mCoeditTypeItems.size()) {
                        CoeditTypeMenu coeditTypeMenu = CoeditTypeMenu.this;
                        coeditTypeMenu.mType = ((Integer) coeditTypeMenu.mCoeditTypeItems.keySet().toArray()[iIntValue]).intValue();
                        String tag = CoeditTypeMenu.this.getTag();
                        StringBuilder sb = new StringBuilder("onClick# which: ");
                        CoeditTypeMenu coeditTypeMenu2 = CoeditTypeMenu.this;
                        AbstractC8014b.m7213o(sb, coeditTypeMenu2.mCoeditTypeItems.get(Integer.valueOf(coeditTypeMenu2.mType)), tag);
                        ComposerSA.insertLog(NotesListSALogModel.getSALogScreenIdOnEditMode(CoeditHelper.this.mViewParams.getModeIndex(), CoeditHelper.this.mStateInfo.getFolderUuid()), (String) CoeditTypeMenu.this.mSATypeItems.get(Integer.valueOf(CoeditTypeMenu.this.mType)));
                        if (((AbsPopupMenu) CoeditTypeMenu.this).mOnItemClickListener != null) {
                            ((AbsPopupMenu) CoeditTypeMenu.this).mOnItemClickListener.onItemClick();
                        }
                    }
                    ((AbsPopupMenu) CoeditTypeMenu.this).mPopupMenu.dismiss();
                }
            };
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
        public String getTag() {
            return TAG;
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
        public void initShareTypeItems(Activity activity) {
            if (this.mCoeditTypeItems != null) {
                return;
            }
            LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
            this.mCoeditTypeItems = linkedHashMap;
            linkedHashMap.put(0, activity.getString(C8003R.string.coedit_share_with_collaborators));
            this.mCoeditTypeItems.put(1, activity.getString(C8003R.string.co_edit_start_with_space));
            LinkedHashMap<Integer, String> linkedHashMap2 = new LinkedHashMap<>();
            this.mSATypeItems = linkedHashMap2;
            linkedHashMap2.put(0, NotesSAConstants.EVENT_COEDIT_LIST_INVITE_COLLABORATORS);
            this.mSATypeItems.put(1, NotesSAConstants.EVENT_COEDIT_LIST_ADD_TO_SHARED_NOTEBOOK);
        }

        public void showPopupMenu(Activity activity, View view) {
            super.showPopupMenu(activity, view, activity.getString(C8003R.string.coedit_opt_share_note));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void createUnlockConfirmDialog(Context context, int i, DialogViewContract.IUnlockConfirmDialog iUnlockConfirmDialog);

        void notifyDataSetChangedWithViewPageChange(String str);

        void onTaskFinished();

        void removeCoeditInvitation(String str);

        void verifyLockedNote(int i, Intent intent, String... strArr);
    }

    public CoeditHelper(ViewParams viewParams, StateInfo stateInfo, DocumentMap documentMap, NotesModel notesModel, IPresenter iPresenter) {
        this.mViewParams = viewParams;
        this.mStateInfo = stateInfo;
        this.mDocumentMap = documentMap;
        this.mNotesModel = notesModel;
        this.mPresenter = iPresenter;
        this.mFragment = viewParams.getAbsFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDeleteDialog() {
        DialogViewContract.IDialogFragment iDialogFragment;
        if (this.mFragment.isAdded() && (iDialogFragment = (DialogViewContract.IDialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(NotesConstants.DialogTag.DELETE_COEDIT_NOTE_DIALOG)) != null) {
            iDialogFragment.dismissAllowingStateLoss();
        }
    }

    @Nullable
    private View getAnchorView(@NonNull View view) {
        View viewFindViewById = view.findViewById(C8003R.id.action_start_coedit);
        return viewFindViewById == null ? view.findViewById(C8003R.id.bottom_overflow) : viewFindViewById;
    }

    @Nullable
    private View getCoeditDialogAnchorView() {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            MainLogger.m7255e(TAG, "getCoeditDialogAnchorView# activity is invalid");
            return null;
        }
        if (!FeatureUtils.isEditMode(this.mViewParams.getModeIndex())) {
            return AnchorViewUtils.getAnchorView((ViewGroup) this.mViewParams.getAbsFragment().getView());
        }
        View viewFindViewById = activity.findViewById(C8003R.id.floating_bottom_layout);
        if (viewFindViewById != null) {
            return getAnchorView(viewFindViewById);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void importErrorHandler(ImportResult importResult) {
        if (importResult == null) {
            return;
        }
        MainCoeditLogger.m7253i(TAG, "importErrorHandler# result : " + importResult.ret);
        int i = importResult.ret;
        switch (i) {
            case 110:
                ToastHandler.show(BaseUtils.getApplicationContext(), C8003R.string.composer_failed_to_copy, 0);
                break;
            case 111:
            case 112:
            case 113:
                ToastHandler.show(BaseUtils.getApplicationContext(), C8003R.string.coedit_fail_to_share_as_too_big, 0);
                break;
            default:
                switch (i) {
                    case 203:
                        ToastHandler.show(BaseUtils.getApplicationContext(), C8003R.string.co_edit_connect_to_wifi_or_allow_mobile_data, 0);
                        break;
                    case 204:
                        ToastHandler.show(BaseUtils.getApplicationContext(), C8003R.string.sync_import_dialog_server_error, 0);
                        break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImportResult lambda$requestImport$0(List list, Context context, String str) {
        if (list != null && list.get(0) != null) {
            return CoeditNoteUpDownloader.getInstance().importNoteToCoedit(context.getApplicationContext(), list, str, mImportProgressListeners);
        }
        MainCoeditLogger.m7251e(TAG, "requestImport# importNotesUuid is null");
        return new ImportResult(null, null, 201);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeImportProgress() {
        DialogFragment dialogFragment;
        if (this.mFragment.isAdded() && (dialogFragment = (DialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(NotesConstants.DialogTag.IMPORT_NOTE_TO_COEDIT_PROGRESS_DIALOG)) != null) {
            MainCoeditLogger.m7250d(TAG, "removeImportProgress#");
            dialogFragment.dismissAllowingStateLoss();
        }
    }

    public static void removeImportProgressListener() {
        MainCoeditLogger.m7250d(TAG, "removeImportProgressListener#");
        mImportProgressListeners = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceDeleteBtnToProgress() {
        DialogViewContract.IDialogFragment iDialogFragment = (DialogViewContract.IDialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(NotesConstants.DialogTag.DELETE_COEDIT_NOTE_DIALOG);
        if (iDialogFragment == null) {
            return;
        }
        iDialogFragment.replaceBtnToProgress();
    }

    public static void restoreImportProgressListener(InterfaceC0102a interfaceC0102a) {
        if (mImportProgressListeners == null) {
            return;
        }
        MainCoeditLogger.m7250d(TAG, "restoreImportProgressListener#");
        mImportProgressListeners = interfaceC0102a;
    }

    public static void setImportProgressListener(InterfaceC0102a interfaceC0102a) {
        StringBuilder sb = new StringBuilder("setImportProgressListener# Already has a registered listener: ");
        sb.append(mImportProgressListeners != null);
        MainCoeditLogger.m7250d(TAG, sb.toString());
        mImportProgressListeners = interfaceC0102a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartCoeditProgressListener() {
        MainLogger.m7254d(TAG, "setStartCoeditProgressListener");
        setImportProgressListener(new InterfaceC0102a() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.CoeditHelper.6
            @Override // p028G.InterfaceC0102a
            public void onEnded(String str, int i) {
                StringBuilder sbM780v = AbstractC0541b.m780v("setStartCoeditProgressListener#onEnded# spaceId : ", i, str, ", errorCode: ", ", hashCode ");
                sbM780v.append(hashCode());
                MainCoeditLogger.m7250d(CoeditHelper.TAG, sbM780v.toString());
                CoeditHelper.removeImportProgressListener();
                CoeditHelper.this.removeImportProgress();
                if (i != 200) {
                    return;
                }
                ToastHandler.show(CoeditHelper.this.mFragment.getContext(), CoeditHelper.this.mIsStandalone ? C8003R.string.co_edit_start_success : C8003R.string.co_edit_start_with_space_success, 0);
                if (TextUtils.isEmpty(CoeditHelper.this.mInvitationLink)) {
                    return;
                }
                Intent intentForShareViaInvitationLink = new OpenSessionApi().getIntentForShareViaInvitationLink(BaseUtils.getApplicationContext(), 501, SesCoeditShareReadResolver.getInstance().getSpaceTitleWithPrefix(str), CoeditHelper.this.mInvitationLink);
                CoeditHelper.this.mInvitationLink = null;
                CoeditHelper.this.mIsStandalone = false;
                CoeditHelper.this.mFragment.startActivity(intentForShareViaInvitationLink);
            }

            @Override // p028G.InterfaceC0102a
            public void onProgress(int i, int i2) {
                MainCoeditLogger.m7250d(CoeditHelper.TAG, "setStartCoeditProgressListener#onProgress# currentCount: " + i + " totalCount: " + i2);
            }

            @Override // p028G.InterfaceC0102a
            public void onStarted(String str) {
                MainCoeditLogger.m7250d(CoeditHelper.TAG, "setStartCoeditProgressListener#onStarted# " + str);
                CoeditHelper.this.showImportProgress();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showImportProgress() {
        if (this.mFragment == null) {
            MainCoeditLogger.m7250d(TAG, "showImportProgress# fragment is null");
            return;
        }
        DialogFragment dialogFragmentCreateProgressDialogFragment = DialogUtils.createProgressDialogFragment();
        dialogFragmentCreateProgressDialogFragment.setCancelable(false);
        ((DialogUtils.ProgressDialogFragment) dialogFragmentCreateProgressDialogFragment).showAllowingStateLoss(this.mFragment.getChildFragmentManager(), NotesConstants.DialogTag.IMPORT_NOTE_TO_COEDIT_PROGRESS_DIALOG);
    }

    public boolean canCreateNewCoeditNote() {
        if (!C0145c.m334s(this.mFragment.getContext())) {
            MainCoeditLogger.m7250d(TAG, "canCreateNewCoeditNote# false - network is not available");
            ToastHandler.show(this.mFragment.getContext(), GcsConstants.RequestType.Create.standaloneNetworkFail, 1);
            return false;
        }
        if (CoeditUtils.isWiFiSyncOnlyAndNotWiFiConnected()) {
            MainCoeditLogger.m7250d(TAG, "canCreateNewCoeditNote# false - wifi only");
            GcsGroupNetworkUtils.showGoToSettingsDialog(new WeakReference(this.mFragment.getActivity()));
            return false;
        }
        if (!AbstractC0267s.m544b()) {
            return true;
        }
        MainCoeditLogger.m7250d(TAG, "canCreateNewCoeditNote# false - storage full");
        ToastHandler.show(this.mFragment.getContext(), C8003R.string.co_edit_cannot_create_shared_note_storage_full, 1);
        return false;
    }

    public boolean importNoteToSpace(Context context, final String str, final boolean z) {
        if (!StorageUtils.isAvailableMinimumMemory()) {
            DialogUtils.showNotEnoughStorageDialogFragment(this.mFragment.getActivity(), this.mFragment.getChildFragmentManager());
            return false;
        }
        int checkedNotesCount = this.mNotesModel.getCheckedNotesCount();
        int lockedNotesCount = this.mNotesModel.getCheckNotesCountInfo().getLockedNotesCount();
        final ArrayList<String> checkedNotesUUID = this.mNotesModel.getCheckedNotesUUID();
        if (checkedNotesCount == 0) {
            return false;
        }
        MainCoeditLogger.m7250d(TAG, "importNoteToSpace# checkedCount : " + checkedNotesCount + ", lockedNotesCount : " + lockedNotesCount);
        if (lockedNotesCount != 0) {
            this.mPresenter.createUnlockConfirmDialog(context, lockedNotesCount, new DialogViewContract.IUnlockConfirmDialog() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.CoeditHelper.2
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IUnlockConfirmDialog
                public void unLock() {
                    Intent intent = new Intent();
                    intent.putExtra("spaceId", str);
                    CoeditHelper.this.mPresenter.verifyLockedNote(z ? 115 : 114, intent, (String[]) checkedNotesUUID.toArray(new String[0]));
                }
            });
            return false;
        }
        requestImport(context, str, checkedNotesUUID, z);
        return true;
    }

    public void onCoeditInvitationUpdate() {
        if (FeatureUtils.isCoeditMode(this.mViewParams.getModeIndex())) {
            if (this.mDocumentMap.initCommonDisplayList()) {
                this.mPresenter.notifyDataSetChangedWithViewPageChange("Space Invitation Received");
            }
            this.mViewParams.getNotesView().onDataChanged(this.mDocumentMap.getCommonDisplayListSize(new String[0]), "onCoeditInvitationUpdate");
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.mInvitationLink = bundle.getString("invitation_link");
            this.mIsStandalone = bundle.getBoolean("standalone", false);
            if (1 == bundle.getInt(KEY_PROGRESS_STATE)) {
                setStartCoeditProgressListener();
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("invitation_link", this.mInvitationLink);
        bundle.putBoolean("standalone", this.mIsStandalone);
        if (this.mFragment.getChildFragmentManager().findFragmentByTag(NotesConstants.DialogTag.IMPORT_NOTE_TO_COEDIT_PROGRESS_DIALOG) != null) {
            bundle.putInt(KEY_PROGRESS_STATE, 1);
        }
    }

    public boolean onSpaceSelected(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return false;
        }
        MainLogger.m7254d(TAG, "onSpaceSelected# groupId: " + str + ", spaceId: " + str2);
        this.mStateInfo.setGroupId(str);
        this.mStateInfo.setSpaceId(str2);
        this.mViewParams.getNotesView().setMode(14);
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE);
        return true;
    }

    public void registerInviteReceiver() {
        Context context = this.mFragment.getContext();
        if (context == null) {
            MainLogger.m7259w(TAG, "registerInviteReceiver, ignore, context is null");
        } else {
            CoeditInviteReceivedReceiver.registerReceiver(context, this.mCoeditInviteReceivedReceiver);
        }
    }

    public void release() {
        if (this.mDeleteProgressListener != null) {
            C0073a.m194g().m207m(this.mDeleteProgressListener);
            this.mDeleteProgressListener = null;
        }
        unregisterInviteReceiver();
    }

    public void requestImport(Context context, final String str, List<String> list, boolean z) {
        if (z) {
            C6684b c6684b = C0171a.m429a().f543a;
            c6684b.getClass();
            c6684b.m4777a(new C6742k(str, list));
        } else {
            InterfaceC0102a interfaceC0102a = mImportProgressListeners;
            if (interfaceC0102a != null) {
                interfaceC0102a.onStarted(str);
            }
            DataRepositoryScheduler.callable(new CallableC0047c(list, 8, context, str)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).observe(new OnCompletionListener<ImportResult>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.CoeditHelper.3
                private void onEnd(ImportResult importResult) {
                    if (CoeditHelper.mImportProgressListeners == null) {
                        return;
                    }
                    CoeditHelper.mImportProgressListeners.onEnded(str, importResult != null ? importResult.ret : 201);
                    CoeditHelper.mImportProgressListeners = null;
                }

                @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
                public void onFail(@NonNull Exception exc) {
                    AbstractC4539a.m3204n(exc, new StringBuilder("requestImport# e: "), CoeditHelper.TAG);
                    onEnd(null);
                    CoeditHelper.this.importErrorHandler(null);
                }

                @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
                public void onComplete(@androidx.annotation.Nullable ImportResult importResult) {
                    onEnd(importResult);
                    CoeditHelper.this.importErrorHandler(importResult);
                }
            }).observeOn(NotesDataTaskExecutor.getMainThreadExecutor()).execute();
            this.mPresenter.onTaskFinished();
        }
    }

    public void setNoteDeleteProgressListener() {
        if (this.mDeleteProgressListener == null) {
            this.mDeleteProgressListener = new InterfaceC0102a() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.CoeditHelper.7
                @Override // p028G.InterfaceC0102a
                public void onEnded(String str, int i) {
                    MainCoeditLogger.m7253i(CoeditHelper.TAG, "DeleteProgressListener# onEnded " + str + " errorCode " + i);
                    CoeditHelper.this.dismissDeleteDialog();
                    if (CoeditHelper.this.mDeleteProgressListener != null) {
                        C0073a.m194g().m207m(CoeditHelper.this.mDeleteProgressListener);
                        CoeditHelper.this.mDeleteProgressListener = null;
                    }
                }

                @Override // p028G.InterfaceC0102a
                public void onProgress(int i, int i2) {
                }

                @Override // p028G.InterfaceC0102a
                public void onStarted(String str) {
                    MainCoeditLogger.m7253i(CoeditHelper.TAG, "DeleteProgressListener# onStarted " + str);
                    CoeditHelper.this.replaceDeleteBtnToProgress();
                }
            };
        }
        C0073a c0073aM194g = C0073a.m194g();
        InterfaceC0102a interfaceC0102a = this.mDeleteProgressListener;
        ((C6666b) c0073aM194g.f254b).getClass();
        C6679d.m4774b(interfaceC0102a);
    }

    public void showStartCoeditNote() {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            MainLogger.m7255e(TAG, "showStartCoeditNote# activity is invalid");
            return;
        }
        if (!StorageUtils.isAvailableMinimumMemory()) {
            DialogUtils.showNotEnoughStorageDialogFragment(activity, this.mFragment.getChildFragmentManager());
            return;
        }
        if (this.mNotesModel.getCheckedNotesCount() == 0) {
            MainLogger.m7254d(TAG, "showStartCoeditNote# checkCount 0");
            return;
        }
        View coeditDialogAnchorView = getCoeditDialogAnchorView();
        if (coeditDialogAnchorView == null) {
            MainLogger.m7255e(TAG, "showStartCoeditNote# anchorView is null");
            return;
        }
        coeditDialogAnchorView.clearFocus();
        if (this.mCoeditPopupMenu == null) {
            this.mCoeditPopupMenu = new CoeditTypeMenu();
        }
        this.mCoeditPopupMenu.setOnItemClickListener(new AbsPopupMenu.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.CoeditHelper.8
            @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.AbsPopupMenu.OnItemClickListener
            public void onItemClick() {
                MainCoeditLogger.m7250d(CoeditHelper.TAG, "onItemClick# type: " + CoeditHelper.this.mCoeditPopupMenu.getCoeditType());
                CoeditHelper coeditHelper = CoeditHelper.this;
                coeditHelper.startCoeditWithUnlock(coeditHelper.mCoeditPopupMenu.getCoeditType() == 0);
            }
        });
        this.mCoeditPopupMenu.showPopupMenu(activity, coeditDialogAnchorView);
    }

    public void startCoedit(final boolean z) {
        NotesActivityResultCallback notesActivityResultCallback = new NotesActivityResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.CoeditHelper.5
            @Override // com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback
            public void onActivityResult(int i, @androidx.annotation.Nullable Intent intent) {
                if (intent == null || i != -1) {
                    return;
                }
                String stringExtra = intent.getStringExtra(ComposerConstants.ARG_MDE_SPACE_ID);
                if (TextUtils.isEmpty(stringExtra)) {
                    MainCoeditLogger.m7253i(CoeditHelper.TAG, "importNoteToCoedit# fail - spaceId is null or empty.");
                    return;
                }
                CoeditHelper.this.mInvitationLink = intent.getStringExtra(ComposerConstants.ARG_MDE_COEDIT_INVITE_URL);
                CoeditHelper.this.mIsStandalone = z;
                CoeditHelper.this.setStartCoeditProgressListener();
                CoeditHelper coeditHelper = CoeditHelper.this;
                coeditHelper.requestImport(coeditHelper.mFragment.getContext(), stringExtra, CoeditHelper.this.mNotesModel.getCheckedNotesUUID(), false);
            }
        };
        if (z) {
            Intent intent = new Intent(this.mFragment.getContext(), NoteListAccessHandler.getSocialPickerClass());
            intent.putExtra(PopOverActivityWrapper.KEY_ANCHOR_TYPE, 102);
            this.mViewParams.getNotesView().launchActivity(intent, notesActivityResultCallback);
        } else {
            Intent intent2 = new Intent(this.mFragment.getContext(), NoteListAccessHandler.getCoeditSpacePickerClass());
            intent2.putExtra(NotesConstants.KEY_OPENED_BY_LIST, true);
            this.mViewParams.getNotesView().launchPopOverActivity(intent2, 102, notesActivityResultCallback);
        }
    }

    public void startCoeditWithUnlock(final boolean z) {
        if (!GcsGroupNetworkUtils.checkCoeditNetworkConnection(this.mFragment.getActivity(), GcsConstants.RequestType.Create, true)) {
            MainCoeditLogger.m7253i(TAG, "startCoedit# fail - network is not connected");
            return;
        }
        if (!StorageUtils.isAvailableMinimumMemory()) {
            DialogUtils.showNotEnoughStorageDialogFragment(this.mFragment.getActivity(), this.mFragment.getChildFragmentManager());
            return;
        }
        if (!this.mNotesModel.getCheckedNotesUUID().isEmpty()) {
            Iterator<CheckedNoteInfo> it = this.mNotesModel.getSharableCheckedNoteMap().values().iterator();
            while (it.hasNext()) {
                if (it.next().getUnknownMinVersion() != 0) {
                    ToastHandler.show(this.mFragment.getContext(), C8003R.string.co_edit_has_unknown_object, 0);
                    return;
                }
            }
        }
        int lockedNotesCount = this.mNotesModel.getCheckNotesCountInfo().getLockedNotesCount();
        if (lockedNotesCount != 0) {
            this.mPresenter.createUnlockConfirmDialog(this.mFragment.getContext(), lockedNotesCount, new DialogViewContract.IUnlockConfirmDialog() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.CoeditHelper.4
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IUnlockConfirmDialog
                public void unLock() {
                    Intent intent = new Intent();
                    intent.putExtra(NotesConstants.KEY_COEDIT_STANDALONE, z);
                    CoeditHelper.this.mPresenter.verifyLockedNote(116, intent, (String[]) CoeditHelper.this.mNotesModel.getCheckedNotesUUID().toArray(new String[0]));
                }
            });
        } else {
            startCoedit(z);
        }
    }

    public void unregisterInviteReceiver() {
        Context context = this.mFragment.getContext();
        if (context == null) {
            MainLogger.m7259w(TAG, "unregisterInviteReceiver, ignore, context is null");
        } else {
            CoeditInviteReceivedReceiver.unregisterReceiver(context, this.mCoeditInviteReceivedReceiver);
        }
    }
}
