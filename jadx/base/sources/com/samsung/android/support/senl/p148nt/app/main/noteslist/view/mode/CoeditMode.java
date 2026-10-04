package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.SeslMenuItem;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6875b;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6880g;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationListResult;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.Space;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceListResult;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.account.AccountHelper;
import com.samsung.android.support.senl.p148nt.app.common.CoeditInvitationMenuBadgeUpdater;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.GcsInvitationMenuBadgeUpdater;
import com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.data.RepositoryManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditPickerInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.samsunganalytics.NotesListSALoggingHelper;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.TabletActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.CoeditFirstJoinDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.CoeditNameDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.CoeditSpaceEditMenuDialog;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.CoeditNotificationManager;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.FTUConstants;
import com.samsung.android.support.senl.p148nt.base.common.livesharing.LiveSharingManager;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.TokenManager;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.coedit.caller.CoeditNoteEventManager;
import com.samsung.android.support.senl.p148nt.coedit.caller.Event;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.SmartTipPopup;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.livesharing.ILiveSharingClient;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.EventManager;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import p001A.AbstractC0000a;
import p033H0.C0112b;
import p044K.C0158a;
import p075S.AbstractC0256h;
import p075S.AbstractC0267s;
import p079T.AbstractC0291i;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditMode extends CoeditBaseMode implements CoeditSpaceImpl {
    private static final String TAG = "CoeditMode";
    private static final CoeditSessionConnector.ActionResult actionResult = new CoeditSessionConnector.ActionResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.3
        @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActionResult
        public void onFail() {
            MainCoeditLogger.m7251e(CoeditMode.TAG, "[CS1-2] onCoeditSessionConnected# request sync onFail");
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActionResult
        public void onSuccess() {
            MainCoeditLogger.m7250d(CoeditMode.TAG, "[CS1-1] onCoeditSessionConnected# request sync onSuccess");
        }
    };
    private View mCoeditNoNoteLayout;
    private final Runnable mCoeditSessionConnected;
    private final IEditDialogResult mCreateSpaceDialogListener;
    private final Listenable mEventListener;
    private final Listenable mEventListenerStandaloneReceive;
    private final CoeditSessionConnector.CoeditCreateResult mInvitationAcceptResultListener;
    private final CoeditSessionConnector.InvitationResult mInvitationResult;
    private int mIsCoeditNoNoteVisibility;
    private boolean mIsNeedToOnLayoutLogging;
    private final Handler mMainHandler;
    private int mOrientation;
    private final CoeditSessionConnector.ActionResult mRequestOldSharedNotebooksResult;
    protected String mSelectedGroupId;
    protected String mSelectedSpaceId;
    private SmartTipPopup mSmartTipPopup;
    private final CoeditSpaceEditMenuDialog.IGroupEditMenuDialog mSpaceMenuDialogContract;
    private final CoeditSessionConnector.ActionResult mSpaceRemoveResultListener;
    private final Executor mWorkerExecutor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoeditModeActionResult implements CoeditSessionConnector.ActionResult {
        private final WeakReference<AbsFragment> mAbsFragmentWeakReference;

        public CoeditModeActionResult(AbsFragment absFragment) {
            this.mAbsFragmentWeakReference = new WeakReference<>(absFragment);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActionResult
        public void onFail() {
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActionResult
        public void onSuccess() {
            final AbsFragment absFragment = this.mAbsFragmentWeakReference.get();
            if (absFragment != null) {
                ViewModeUtils.runOnUiThread(absFragment.getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.CoeditModeActionResult.1
                    @Override // java.lang.Runnable
                    public void run() {
                        absFragment.filteredInvalidateOptionsMenu();
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LinkInvitationEventLister implements com.samsung.android.support.senl.p148nt.coedit.caller.Listenable {
        private final Callback mCallback;
        private final String mGroupId;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface Callback {
            void onDownloadFinished(String str);
        }

        public LinkInvitationEventLister(String str, @NonNull Callback callback) {
            this.mGroupId = str;
            this.mCallback = callback;
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.caller.Listenable
        public String requestName() {
            return CoeditNoteEventManager.LINK_EVENT_STRING + this.mGroupId;
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.caller.Listenable
        public void run(Event event) {
            this.mCallback.onDownloadFinished((String) event.getEventData());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class OldSharedNotebooksSmartTipPopup extends SmartTipPopup {
        public OldSharedNotebooksSmartTipPopup(View view, String str) {
            super(view, str);
        }
    }

    public CoeditMode(ModeParams modeParams) {
        super(modeParams);
        this.mSmartTipPopup = null;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mWorkerExecutor = AbstractC4539a.m3201k(TAG);
        this.mInvitationResult = new CoeditSessionConnector.InvitationResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.1
            private boolean isActionMenuEnable() {
                return NotesUtils.isTabletLayout(CoeditMode.this.mContext) == TabletActionMenuController.TAG.equals(CoeditMode.this.mActionMenuController.getTag());
            }

            private List<GroupInvitationListResult.GroupInvitation> removeAlreadyJoinedInvitation(List<GroupInvitationListResult.GroupInvitation> list) {
                ArrayList arrayList = new ArrayList(list);
                for (GroupInvitationListResult.GroupInvitation groupInvitation : list) {
                    if (groupInvitation.getGroupId().equals(CoeditMode.this.mPresenter.getStateInfo().getGroupId())) {
                        arrayList.remove(groupInvitation);
                        return arrayList;
                    }
                }
                return list;
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.InvitationResult
            public void onResult(List<GroupInvitationListResult.GroupInvitation> list) {
                CoeditMode coeditMode = CoeditMode.this;
                if (coeditMode.mContext == null) {
                    return;
                }
                coeditMode.mPresenter.getDocumentMap().initCoeditInvitationMap(removeAlreadyJoinedInvitation(list));
                if (isActionMenuEnable()) {
                    CoeditMode.this.mPresenter.getCoeditHelper().onCoeditInvitationUpdate();
                }
            }
        };
        this.mRequestOldSharedNotebooksResult = new CoeditModeActionResult(this.mFragment);
        this.mCoeditSessionConnected = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.2
            @Override // java.lang.Runnable
            public void run() {
                MainCoeditLogger.m7250d(CoeditMode.TAG, "[CS1] onCoeditSessionConnected# request sync");
                if (C0158a.m409d(CoeditMode.this.mAppContext)) {
                    CoeditMode.this.mSessionConnector.requestSync(CoeditMode.actionResult);
                }
                CoeditMode.this.executeSyncForSessionConnected();
            }
        };
        this.mSpaceMenuDialogContract = new CoeditSpaceEditMenuDialog.IGroupEditMenuDialog() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.4
            private boolean checkInvalidation() {
                return TextUtils.isEmpty(CoeditMode.this.mSelectedGroupId) || TextUtils.isEmpty(CoeditMode.this.mSelectedSpaceId);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.CoeditSpaceEditMenuDialog.IGroupEditMenuDialog
            public void delete() {
                if (checkInvalidation()) {
                    MainCoeditLogger.m7251e(CoeditMode.TAG, "delete# groupId or spaceId is empty");
                } else {
                    CoeditMode.this.deleteSpace();
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.CoeditSpaceEditMenuDialog.IGroupEditMenuDialog
            public void leave() {
                if (checkInvalidation()) {
                    MainCoeditLogger.m7251e(CoeditMode.TAG, "leave# groupId or spaceId is empty");
                } else {
                    CoeditMode coeditMode = CoeditMode.this;
                    coeditMode.leaveSpace(coeditMode.mSelectedGroupId, coeditMode.mSelectedSpaceId, SesCoeditShareReadResolver.getInstance().isSpaceOwner(CoeditMode.this.mSelectedSpaceId));
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.CoeditSpaceEditMenuDialog.IGroupEditMenuDialog
            public void rename() {
                if (checkInvalidation()) {
                    MainCoeditLogger.m7251e(CoeditMode.TAG, "rename# groupId or spaceId is empty");
                } else {
                    CoeditMode coeditMode = CoeditMode.this;
                    coeditMode.renameSpace(coeditMode.mSelectedSpaceId);
                }
            }
        };
        this.mSpaceRemoveResultListener = new CoeditSessionConnector.ActionResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.5
            private void releaseEditMode() {
                CoeditMode.this.dismissDeleteDialog();
                if (FeatureUtils.isEditMode(CoeditMode.this.getModeIndex())) {
                    CoeditMode.this.onBackKeyDown();
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActionResult
            public void onFail() {
                MainCoeditLogger.m7253i(CoeditMode.TAG, "SpaceRemoveResultListener# onFail");
                releaseEditMode();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActionResult
            public void onSuccess() {
                MainCoeditLogger.m7253i(CoeditMode.TAG, "SpaceRemoveResultListener# onSuccess");
                releaseEditMode();
            }
        };
        this.mInvitationAcceptResultListener = new CoeditSessionConnector.CoeditCreateResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.6
            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.CoeditCreateResult
            public void onFail() {
                CoeditMode.this.removeCircleProgressDialog();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.CoeditCreateResult
            public void onSuccess(String str, String str2, boolean z) {
                StringBuilder sbM16m = AbstractC0000a.m16m("InvitationAcceptActionResult onSuccess# groupId: ", str, ", spaceId: ", str2, ", isStandalone: ");
                sbM16m.append(z);
                MainCoeditLogger.m7250d(CoeditMode.TAG, sbM16m.toString());
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                CoeditMode.this.landingInvitationLink(str, str2, z, true, "noti");
            }
        };
        this.mCreateSpaceDialogListener = new IEditDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.7
            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
            public void onEditDialogDismiss() {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
            public void onEditDialogResult(int i, String str, String str2, int i2) {
                final CoeditPickerInfo activityFinishedListener = new CoeditPickerInfo.CreateSpace(str2).setActivityFinishedListener(new CoeditPickerInfo.ActivityFinishedListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.7.1
                    @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditPickerInfo.ActivityFinishedListener
                    public void onActivityFinished(boolean z) {
                        CoeditMode.this.showCircleProgressDialog();
                    }
                });
                activityFinishedListener.setResultCallback(new CoeditSessionConnector.CoeditCreateResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.7.2
                    @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.CoeditCreateResult
                    public void onFail() {
                        CoeditMode.this.removeCircleProgressDialog();
                    }

                    @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.CoeditCreateResult
                    public void onSuccess(String str3, String str4, boolean z) {
                        CoeditMode.this.removeCircleProgressDialog();
                        if (activityFinishedListener.getInvitationLink() != null) {
                            MainCoeditLogger.m7253i(CoeditMode.TAG, "createNewSpace# openShareViaInvitationLink");
                            CoeditMode.this.mFragment.startActivity(new OpenSessionApi().getIntentForShareViaInvitationLink(CoeditMode.this.mContext, 501, activityFinishedListener.getSpaceName(), activityFinishedListener.getInvitationLink().getUrl()));
                        }
                    }
                });
                CoeditMode.this.mSessionConnector.launchSocialPicker(activityFinishedListener);
            }
        };
        this.mEventListener = new Listenable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.19
            @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable
            public String requestName() {
                return "COEDIT_I_INVITE_EVENT";
            }

            @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable
            public void run(com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Event event) {
                MainCoeditLogger.m7250d(CoeditMode.TAG, "[CS2] mEventListener coedit");
                String spaceIdByGroupId = SesCoeditShareReadResolver.getInstance().getSpaceIdByGroupId((String) event.getEventData());
                MainCoeditLogger.m7250d(CoeditMode.TAG, "[CS2] mEventListener coedit 1-1");
                if (TextUtils.isEmpty(spaceIdByGroupId)) {
                    return;
                }
                MainCoeditLogger.m7250d(CoeditMode.TAG, "[CS2] mEventListener coedit 1-2");
                CoeditMode.this.requestDownloadByPush(spaceIdByGroupId, false);
            }
        };
        this.mEventListenerStandaloneReceive = new Listenable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.20
            @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable
            public String requestName() {
                return "COEDIT_ITEM_EVENT";
            }

            @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable
            public void run(com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Event event) {
                if (event.getEventData() instanceof String) {
                    CoeditMode.this.requestDownloadByPush((String) event.getEventData(), false);
                }
            }
        };
    }

    private void clearCoeditNoNoteLayout() {
        View viewFindViewById;
        ViewGroup viewGroup = this.mNoHolderLayout;
        if (viewGroup != null && (viewFindViewById = viewGroup.findViewById(C8003R.id.coedit_nonote_layout_container)) != null) {
            this.mNoHolderLayout.removeView(viewFindViewById);
        }
        this.mCoeditNoNoteLayout = null;
    }

    private void clearInvitationNotifications() {
        new CoeditNotificationManager(this.mContext).cancelAllInvitationNotification();
        CoeditInvitationMenuBadgeUpdater.clearInvitationListHasBadgePref();
    }

    private void createNewSpace() {
        CoeditNameDialogFragment coeditNameDialogFragment = new CoeditNameDialogFragment();
        coeditNameDialogFragment.setAnchorViewId(C8003R.id.action_create_notebook);
        coeditNameDialogFragment.setEditDialogResultListener(this.mCreateSpaceDialogListener);
        coeditNameDialogFragment.show(this.mFragment.getChildFragmentManager(), GcsConstants.DialogTag.ADD_NOTEBOOK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnectLiveSharing() {
        if (LiveSharingManager.getInstance().disconnectMeeting(null) == ILiveSharingClient.ErrorState.NONE) {
            ViewModeUtils.runOnUiThread(this.mFragment.getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.10
                @Override // java.lang.Runnable
                public void run() {
                    CoeditMode coeditMode = CoeditMode.this;
                    ToastHandler.show(coeditMode.mContext, coeditMode.mAppContext.getString(C8003R.string.live_sharing_fail_join), 0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeSyncForSessionConnected() {
        this.mWorkerExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.9
            @Override // java.lang.Runnable
            public void run() {
                MainCoeditLogger.m7250d(CoeditMode.TAG, "executeSyncForSessionConnected# execute");
                CoeditMode coeditMode = CoeditMode.this;
                coeditMode.mSessionConnector.requestOldSharedNotebooks(coeditMode.mRequestOldSharedNotebooksResult);
                if (C0158a.m409d(CoeditMode.this.mAppContext) && !FeatureUtils.isCoeditSearchMode(CoeditMode.this.getModeIndex())) {
                    CoeditMode coeditMode2 = CoeditMode.this;
                    coeditMode2.mSessionConnector.requestInvitationList(coeditMode2.mInvitationResult);
                }
                CoeditMode.this.requestDownload("executeSyncForSessionConnected - runnable");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToInvitedNote(final String str, final String str2, final boolean z, final boolean z2, final String str3) {
        FragmentActivity activity = this.mFragment.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.12
                @Override // java.lang.Runnable
                public void run() {
                    if (!z) {
                        MainCoeditLogger.m7250d(CoeditMode.TAG, "goToInvitedNote#onSpaceSelected groupId : " + str + ", spaceId : " + str2);
                        CoeditMode.this.removeCircleProgressDialog();
                        CoeditMode.this.onSpaceSelected(str, str2);
                        return;
                    }
                    String uuidByGroupIdStandAlone = RepositoryManager.getInstance().getSyncNoteDataRepository().getUuidByGroupIdStandAlone(str);
                    MainCoeditLogger.m7250d(CoeditMode.TAG, "goToInvitedNote#onStandaloneSelected groupId : " + str + ", spaceId : " + str2 + ", uuid : " + uuidByGroupIdStandAlone);
                    if (!TextUtils.isEmpty(uuidByGroupIdStandAlone)) {
                        CoeditMode.this.removeCircleProgressDialog();
                        CoeditMode.this.onInvitedNoteSelected(uuidByGroupIdStandAlone, str3);
                    } else {
                        CoeditNoteEventManager.getEventBus().register(new LinkInvitationEventLister(str, new LinkInvitationEventLister.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.12.1
                            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.LinkInvitationEventLister.Callback
                            public void onDownloadFinished(String str4) {
                                MainCoeditLogger.m7250d(CoeditMode.TAG, "goToInvitedNote#onDownloadFinished uuid : " + str4);
                                CoeditMode.this.removeCircleProgressDialog();
                                if (TextUtils.isEmpty(str4)) {
                                    CoeditMode.this.disconnectLiveSharing();
                                } else {
                                    RunnableC862412 runnableC862412 = RunnableC862412.this;
                                    CoeditMode.this.onInvitedNoteSelected(str4, str3);
                                }
                            }
                        }));
                        if (z2) {
                            CoeditMode.this.requestDownloadByPush(str2, true);
                        }
                    }
                }
            });
        } else {
            removeCircleProgressDialog();
            disconnectLiveSharing();
        }
    }

    private void handleLandingInvitationLinkAction() {
        FragmentActivity activity = this.mFragment.getActivity();
        if (activity == null) {
            return;
        }
        if (!Constants.ACTION_START_COEDIT.equals(activity.getIntent().getAction())) {
            MainCoeditLogger.m7250d(TAG, "handleLandingInvitationLinkAction# not matched action : " + activity.getIntent().getAction());
            return;
        }
        if (TextUtils.isEmpty(this.mPresenter.getStateInfo().getGroupId())) {
            MainCoeditLogger.m7250d(TAG, "handleLandingInvitationLinkAction# not group id : " + activity.getIntent().getAction());
            return;
        }
        MainCoeditLogger.m7250d(TAG, "handleLandingInvitationLinkAction#");
        activity.getIntent().setAction("android.intent.action.VIEW");
        String groupName = this.mPresenter.getStateInfo().getGroupName();
        if (FTUConstants.isFirstTimeToCoeditJoin(true)) {
            showFirstJoinDialog(this.mPresenter.getStateInfo().getGroupId(), groupName, AbstractC0291i.m570g(groupName));
        } else if (this.mPresenter.getStateInfo().isInvitationAcceptedByNotification()) {
            showAADCJoinDialog(this.mPresenter.getStateInfo().getGroupId(), groupName, AbstractC0291i.m570g(groupName));
            this.mPresenter.getStateInfo().setInvitationAcceptedByNotification(false);
        } else {
            showCircleProgressDialog();
            landingInvitationLink(this.mPresenter.getStateInfo().getGroupId(), this.mPresenter.getStateInfo().getSpaceId(), AbstractC0291i.m570g(groupName), true, "social");
        }
    }

    private void initNoNoteLayout() {
        clearCoeditNoNoteLayout();
        MainCoeditLogger.m7250d(TAG, "initNoNoteLayout# orientation : " + this.mOrientation);
        View viewInflate = LayoutInflater.from(this.mContext).inflate(C8003R.layout.coedit_nonote_layout, (ViewGroup) null);
        this.mCoeditNoNoteLayout = viewInflate;
        viewInflate.findViewById(C8003R.id.coedit_start_button).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserInputSkipper.Tag tag = UserInputSkipper.Tag.OpenActivity;
                if (UserInputSkipper.isValidSingleActionEvent(false, tag)) {
                    UserInputSkipper.setHoldingSingleActionEventTime(1000L, tag);
                    MainCoeditLogger.m7253i(CoeditMode.TAG, "startCoeditButton onClick#");
                    CoeditMode.this.launchSocialPickerForNewStandaloneNote(1);
                }
            }
        });
        if (DeviceInfo.isVSTModel()) {
            this.mCoeditNoNoteLayout.setBackgroundColor(ContextCompat.getColor(this.mContext, C8003R.color.noteslist_fragment_bg_color_for_vst));
        }
        updateNoNoteLayout();
    }

    private void initOrientation() {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        this.mOrientation = context.getResources().getConfiguration().orientation;
    }

    private boolean isNeedToHideOldSharedNotebooksMenu() {
        boolean zIsMDEFeatureEnabled = NotesUtils.isMDEFeatureEnabled();
        boolean invitationListHasBadgePref = GcsInvitationMenuBadgeUpdater.getInvitationListHasBadgePref();
        int spaceCount = SesShareReadResolver.getInstance().getSpaceCount();
        StringBuilder sbM2230u = AbstractC2821a.m2230u("isNeedToHideOldSharedNotebooksMenu# isMDENotSupported: ", ", hasNoInvitation: ", ", oldSharedSpaceCount: ", !zIsMDEFeatureEnabled, !invitationListHasBadgePref);
        sbM2230u.append(spaceCount);
        MainCoeditLogger.m7250d(TAG, sbM2230u.toString());
        if (zIsMDEFeatureEnabled) {
            return !invitationListHasBadgePref && spaceCount == 0;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void landingInvitationLink(final String str, String str2, final boolean z, final boolean z2, final String str3) {
        StringBuilder sbM16m = AbstractC0000a.m16m("landingInvitationLink# groupId : ", str, ", spaceId : ", str2, ", isStandalone : ");
        AbstractC2821a.m2208C(sbM16m, z, ", isForceDownload : ", z2, ", caller : ");
        sbM16m.append(str3);
        MainCoeditLogger.m7253i(TAG, sbM16m.toString());
        if (!TextUtils.isEmpty(str2)) {
            goToInvitedNote(str, str2, z, z2, str3);
            return;
        }
        try {
            AbstractC0267s.m543a().requestSpaceList(str, new ShareApi.SpaceListResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.11
                @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceListResultCallback
                public void onResult(SpaceListResult spaceListResult) {
                    boolean z3 = spaceListResult.getStatus().getCode() == 1;
                    List<Space> result = spaceListResult.getResult();
                    String spaceId = result != null ? result.get(0).getSpaceId() : "";
                    MainCoeditLogger.m7253i(CoeditMode.TAG, "landingInvitationLink#onResult result : " + z3 + ", spaceId : " + spaceId + ", isForceDownload : " + z2);
                    if (!TextUtils.isEmpty(spaceId)) {
                        CoeditMode.this.goToInvitedNote(str, spaceId, z, z2, str3);
                    } else {
                        CoeditMode.this.removeCircleProgressDialog();
                        CoeditMode.this.disconnectLiveSharing();
                    }
                }
            });
        } catch (Exception e) {
            MainCoeditLogger.m7251e(TAG, "landingInvitationLink#onResult exception : " + e.getMessage());
            removeCircleProgressDialog();
            disconnectLiveSharing();
        }
    }

    private void onCoeditModeEnd() {
        unregisterEventListeners();
        clearCoeditNoNoteLayout();
        SmartTipPopup smartTipPopup = this.mSmartTipPopup;
        if (smartTipPopup == null || !smartTipPopup.isShowing()) {
            return;
        }
        this.mSmartTipPopup.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInvitedNoteSelected(String str, String str2) {
        MainCoeditLogger.m7250d(TAG, "onInvitedNoteSelected# uuid : " + str + ", caller : " + str2);
        MainListDocumentData documentData = DataManager.getInstance().getDocumentData(str);
        if (documentData == null) {
            MainCoeditLogger.m7251e(TAG, "onInvitedNoteSelected# return - mainListDocumentData is null");
            disconnectLiveSharing();
        } else {
            if (GcsConstants.MEET.equals(str2)) {
                LiveSharingManager.getInstance().setCoEditNoteUuid(str);
            }
            onNoteSelected(new MainEntryParam.Builder().setDocumentData(documentData).setGuid(C13541h.m14287e().m14294h()).setModeIndex(12).setToolType(1).build());
        }
    }

    private void onOptionsItemSelectedSALogging(int i) {
        if (i == C8003R.id.action_old_shared_notebook) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_OLD_SHARED_NOTEBOOK);
            return;
        }
        if (i == C8003R.id.action_create_notebook) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_CREATE_SHARED_NOTEBOOK);
            return;
        }
        if (i == C8003R.id.action_edit) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_EDIT);
            return;
        }
        if (i == C8003R.id.action_search) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_SEARCH);
        } else if (i == C8003R.id.action_viewby) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_VIEW_TYPE);
        } else if (i == C8003R.id.action_mark_all_as_read) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_MARK_ALL_AS_READ);
        }
    }

    private void setGcsMode() {
        MainCoeditLogger.m7253i(TAG, "setGcsMode");
        this.mNotesView.setMode(24);
        this.mPresenter.onFolderSelected(FolderConstants.SharedNotes.UUID, true);
    }

    private void showAADCJoinDialog(final String str, String str2, final boolean z) {
        MainCoeditLogger.m7250d(TAG, "showAADCJoinDialog# isStandalone: " + z);
        CoeditFirstJoinDialogFragment coeditFirstJoinDialogFragment = new CoeditFirstJoinDialogFragment(z ? C8003R.string.gcs_invitations_join_shared_note_dialog_title : C8003R.string.gcs_invitations_join_shared_notebook_dialog_title, z ? C8003R.string.gcs_invitations_join_shared_note_dialog_body_1 : C8003R.string.gcs_invitations_join_shared_notebook_dialog_body_1, 0);
        coeditFirstJoinDialogFragment.setResultListener(new CoeditFirstJoinDialogFragment.DialogResultListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.18
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.CoeditFirstJoinDialogFragment.DialogResultListener
            public void onDecline() {
                CoeditMode.this.mSessionConnector.requestInvitationDecline(str);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.CoeditFirstJoinDialogFragment.DialogResultListener
            public void onJoin() {
                CoeditMode.this.showCircleProgressDialog();
                CoeditMode coeditMode = CoeditMode.this;
                coeditMode.mSessionConnector.requestInvitationAccept(str, z, coeditMode.mInvitationAcceptResultListener);
            }
        });
        coeditFirstJoinDialogFragment.show(this.mFragment.getChildFragmentManager(), CoeditFirstJoinDialogFragment.TAG);
    }

    private void showFirstJoinDialog(final String str, String str2, final boolean z) {
        MainCoeditLogger.m7250d(TAG, "showFirstJoinDialog# isStandalone: " + z);
        CoeditFirstJoinDialogFragment coeditFirstJoinDialogFragment = new CoeditFirstJoinDialogFragment(z ? C8003R.string.gcs_invitations_join_shared_note_dialog_title : C8003R.string.gcs_invitations_join_shared_notebook_dialog_title, z ? C8003R.string.gcs_invitations_join_shared_note_dialog_body_1 : C8003R.string.gcs_invitations_join_shared_notebook_dialog_body_1, z ? C8003R.string.gcs_invitations_join_shared_note_dialog_body_2 : C8003R.string.gcs_invitations_join_shared_notebook_dialog_body_2);
        coeditFirstJoinDialogFragment.setResultListener(new CoeditFirstJoinDialogFragment.DialogResultListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.17
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.CoeditFirstJoinDialogFragment.DialogResultListener
            public void onDecline() {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_INVITE_FIRST_DECLINE);
                CoeditMode.this.mSessionConnector.requestInvitationDecline(str);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.CoeditFirstJoinDialogFragment.DialogResultListener
            public void onJoin() {
                CoeditMode.this.showCircleProgressDialog();
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_INVITE_FIRST_JOIN);
                CoeditMode coeditMode = CoeditMode.this;
                coeditMode.mSessionConnector.requestInvitationAccept(str, z, coeditMode.mInvitationAcceptResultListener);
            }
        });
        coeditFirstJoinDialogFragment.show(this.mFragment.getChildFragmentManager(), CoeditFirstJoinDialogFragment.TAG);
    }

    private void showSmartTipForOldSharedNotebooks() {
        if (this.mSmartTipPopup != null) {
            return;
        }
        View viewFindViewById = this.mFragment.getActivity().findViewById(C8003R.id.sesl_action_bar_overflow_button);
        if (viewFindViewById == null) {
            MainCoeditLogger.m7250d(TAG, "showSmartTipIfNeeded# target view is null");
        } else {
            viewFindViewById.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (CommonUtil.isNotAvailableActivity(CoeditMode.this.mFragment.getActivity())) {
                            return;
                        }
                        View viewFindViewById2 = CoeditMode.this.mFragment.getActivity().findViewById(C8003R.id.sesl_action_bar_overflow_button);
                        if (viewFindViewById2 == null) {
                            MainCoeditLogger.m7250d(CoeditMode.TAG, "showSmartTipIfNeeded# target view is null");
                            return;
                        }
                        CoeditMode.this.mSmartTipPopup = new OldSharedNotebooksSmartTipPopup(viewFindViewById2, CoeditMode.this.mFragment.getActivity().getResources().getString(C8003R.string.co_edit_smart_tip_for_old_shared_notebooks));
                        CoeditMode.this.mSmartTipPopup.setOnDismissListener(new SmartTipPopup.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.8.1
                            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.util.SmartTipPopup.OnDismissListener
                            public void onDismissed() {
                                MainCoeditLogger.m7250d(CoeditMode.TAG, "showSmartTipIfNeeded# onDismissed");
                                CoeditMode.this.mSmartTipPopup = null;
                            }
                        });
                        if (CoeditMode.this.mSmartTipPopup.show()) {
                            MainCoeditLogger.m7250d(CoeditMode.TAG, "showSmartTipIfNeeded# show");
                            SharedPreferencesCompat.getInstance(NotesConstants.PREF_NOTES_FRAGMENT).putBoolean(NotesConstants.KEY_OLD_SHARED_NOTEBOOKS_SMART_TIP, false);
                        }
                    } catch (InstantiationException e) {
                        MainCoeditLogger.m7251e(CoeditMode.TAG, "showSmartTipIfNeeded " + e.getMessage());
                    }
                }
            });
        }
    }

    private void unregisterEventListeners() {
        EventManager.getEventBus().unregister(this.mEventListener);
        EventManager.getEventBus().unregister(this.mEventListenerStandaloneReceive);
        CoeditNoteEventManager.getEventBus().unregisterAll();
    }

    private void updateNoNoteLayout() {
        View view = this.mCoeditNoNoteLayout;
        if (view == null) {
            return;
        }
        view.findViewById(C8003R.id.coedit_nonote_item_image_layout).setVisibility((ResourceUtils.isTabletLayout(this.mContext) || !WindowManagerCompat.getInstance().isMultiWindowMode(this.mFragment.getActivity())) ? 0 : 8);
        CharUtils.applyTextSizeUntilLargeSize(this.mContext, (TextView) this.mCoeditNoNoteLayout.findViewById(C8003R.id.no_note), 17.0f);
        CharUtils.applyTextSizeUntilLargeSize(this.mContext, (TextView) this.mCoeditNoNoteLayout.findViewById(C8003R.id.no_note_sub), 13.0f);
        CharUtils.applyTextSizeUntilLargeSize(this.mContext, (TextView) this.mCoeditNoNoteLayout.findViewById(C8003R.id.coedit_start_button), 15.0f);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public void deleteStandaloneSpace(List<String> list, List<String> list2) {
        MainCoeditLogger.m7250d(TAG, "[CS8] deleteStandaloneSpace# " + list.size());
        Iterator<String> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            MainListDocumentData noteData = this.mPresenter.getDocumentMap().getNoteData(it.next());
            if (noteData != null) {
                this.mSessionConnector.requestSpaceDelete(noteData.getMdeGroupId(), noteData.getMdeSpaceId(), true, null, i < list2.size() ? list2.get(i) : "", noteData.getCreatedAt());
                i++;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 12;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public void handleMeetJoinAction() {
        FragmentActivity activity = this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            disconnectLiveSharing();
            return;
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
            disconnectLiveSharing();
            return;
        }
        if (!NotesConstants.ACTION_OPEN_CO_EDIT_BY_MEET_URL.equals(intent.getAction())) {
            MainCoeditLogger.m7250d(TAG, "handleMeetJoinAction# not matched action : " + intent.getAction());
            disconnectLiveSharing();
            return;
        }
        String stringExtra = intent.getStringExtra("group_id");
        String stringExtra2 = intent.getStringExtra("space_id");
        MainCoeditLogger.m7250d(TAG, "handleMeetJoinAction# groupId : " + stringExtra + ", spaceId : " + stringExtra2);
        if (TextUtils.isEmpty(stringExtra)) {
            disconnectLiveSharing();
            return;
        }
        intent.setAction("android.intent.action.VIEW");
        showCircleProgressDialog();
        landingInvitationLink(stringExtra, stringExtra2, true, false, GcsConstants.MEET);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public boolean isEnabledStatus() {
        if (this.mSessionConnector.isLatestNotesVersion()) {
            return true;
        }
        MainCoeditLogger.m7253i(getTag(), "onLayout# isLatestNotesVersion false");
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public void launchSocialPickerForNewStandaloneNote(final int i) {
        ((C6880g) ((C0112b) C13541h.m14287e().f9589b).f363b).getClass();
        if (C6875b.m5062c().f4377c.booleanValue()) {
            MainCoeditLogger.m7250d(TAG, "launchSocialPickerForNewStandaloneNote InvalidLoggedIn");
            this.mFragmentContract.launchActivity(AccountHelper.getRequestAccessTokenIntent(this.mContext), new NotesActivityResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.13
                @Override // com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback
                public void onActivityResult(int i2, @Nullable Intent intent) {
                    MainCoeditLogger.m7250d(CoeditMode.TAG, "launchSocialPickerForNewStandaloneNote result# " + i2);
                    if (i2 == -1) {
                        C13541h.m14287e().m14290c();
                        TokenManager.requestAuthInfo();
                        CoeditMode.this.launchSocialPickerForNewStandaloneNote(i);
                    }
                }
            });
            return;
        }
        final CoeditPickerInfo activityFinishedListener = new CoeditPickerInfo.CreateStandalone("Group://Standalone " + this.mAppContext.getString(C8003R.string.co_edit_note_auto_title, AbstractC0256h.m542b(), LocaleUtils.getTitleTime(System.currentTimeMillis()))).setActivityFinishedListener(new CoeditPickerInfo.ActivityFinishedListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.14
            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditPickerInfo.ActivityFinishedListener
            public void onActivityFinished(boolean z) {
                CoeditMode.this.showCircleProgressDialog();
            }
        });
        activityFinishedListener.setResultCallback(new CoeditSessionConnector.CoeditCreateResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditMode.15
            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.CoeditCreateResult
            public void onFail() {
                CoeditMode.this.removeCircleProgressDialog();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.CoeditCreateResult
            public void onSuccess(String str, String str2, boolean z) {
                CoeditMode.this.removeCircleProgressDialog();
                if (activityFinishedListener.getInvitationLink() != null) {
                    CoeditMode.this.mFragmentContract.onNewCoeditNote(str, str2, activityFinishedListener.getInvitationLink().getUrl(), i);
                } else {
                    CoeditMode.this.mFragmentContract.onNewCoeditNote(str, str2, null, i);
                }
            }
        });
        this.mSessionConnector.launchSocialPicker(activityFinishedListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode
    public void leaveSharedNote() {
        MainListDocumentData noteData;
        ArrayList<String> checkedNotesUUID = this.mPresenter.getCheckedNotesUUID();
        if (checkedNotesUUID.size() == 1 && (noteData = this.mPresenter.getDocumentMap().getNoteData(checkedNotesUUID.get(0))) != null) {
            this.mSelectedGroupId = noteData.getMdeGroupId();
            this.mSelectedSpaceId = noteData.getMdeSpaceId();
            MainCoeditLogger.m7250d(TAG, "leaveSharedNote# groupId: " + this.mSelectedGroupId + ", spaceId: " + this.mSelectedSpaceId);
            leaveSpace(this.mSelectedGroupId, this.mSelectedSpaceId, false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        if (!NotesUtils.isTabletLayout(this.mContext) && super.onBackKeyDown()) {
            return true;
        }
        String backFolderHistory = this.mPresenter.getDocumentMap().getBackFolderHistory();
        MainCoeditLogger.m7250d(TAG, "onBackKeyDown# nextFolderUuid: " + backFolderHistory);
        if (backFolderHistory == null || this.mPresenter.getDocumentMap().getFolderData(backFolderHistory) == null) {
            backFolderHistory = FolderConstants.AllNotes.UUID;
        }
        this.mNotesView.onFolderSelected(backFolderHistory);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onBindViewHolder(CommonHolderInfo commonHolderInfo, CheckBox checkBox, TextView textView) {
        super.onBindViewHolder(commonHolderInfo, checkBox, textView);
        String uuid = commonHolderInfo.getUuid();
        CoeditMainListEntry coeditNoteData = this.mPresenter.getDocumentMap().getCoeditNoteData(uuid);
        if (coeditNoteData == null || decorateFakeNote(commonHolderInfo, coeditNoteData)) {
            return;
        }
        boolean zIsSnapShotUpdateRequired = coeditNoteData.isSnapShotUpdateRequired();
        commonHolderInfo.setCoeditExtraVisible(zIsSnapShotUpdateRequired, coeditNoteData.getMainListDocumentData().getFirstOpenedAt() == 0);
        commonHolderInfo.setCoeditSpaceExtraVisible(LocaleUtils.convertToArabicNumber(coeditNoteData.getMemberCount()), SesCoeditShareReadResolver.getInstance().isSpaceOwner(coeditNoteData.getMainListDocumentData().getMdeSpaceId()));
        if (zIsSnapShotUpdateRequired) {
            registerExternalSnap(uuid, coeditNoteData.getMainListDocumentData().getMdeSpaceId());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode
    public void onCoeditSessionConnected() {
        super.onCoeditSessionConnected();
        this.mMainHandler.removeCallbacks(this.mCoeditSessionConnected);
        this.mMainHandler.post(this.mCoeditSessionConnected);
        handleMeetJoinAction();
        handleLandingInvitationLinkAction();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.orientation;
        if (i != this.mOrientation) {
            this.mOrientation = i;
            setCoeditNoNoteVisibility();
        } else if (this.mIsCoeditNoNoteVisibility == 0) {
            updateNoNoteLayout();
        }
        SmartTipPopup smartTipPopup = this.mSmartTipPopup;
        if (smartTipPopup == null || !smartTipPopup.isShowing()) {
            return;
        }
        this.mSmartTipPopup.update();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C8003R.menu.notelist_coedit_menu, menu);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        if (i != 34) {
            if (i != 42) {
                if (i == 84) {
                    return this.mNotesView.setMode(16);
                }
            } else {
                if (keyEvent.getAction() == 0 || (keyEvent.getMetaState() & 4096) != 4096) {
                    return false;
                }
                launchSocialPickerForNewStandaloneNote(1);
            }
        } else if ((keyEvent.getMetaState() & 4096) == 4096) {
            return this.mNotesView.setMode(16);
        }
        return super.onCustomKeyEvent(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        super.onDataChangedViewUpdate(i);
        setNoNotesLayoutVisibility();
        setSubTitle(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDestroy() {
        super.onDestroy();
        onCoeditModeEnd();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public boolean onGroupInvitationReceived() {
        this.mSessionConnector.requestInvitationList(this.mInvitationResult);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public void onInvitationAccepted(String str, String str2) {
        boolean zM570g = AbstractC0291i.m570g(str2);
        if (FTUConstants.isFirstTimeToCoeditJoin(true)) {
            showFirstJoinDialog(str, str2, zM570g);
        } else {
            showAADCJoinDialog(str, str2, zM570g);
        }
        MainCoeditLogger.m7250d(TAG, "onInvitationAccepted");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public void onInvitationDeclined(String str) {
        this.mSessionConnector.requestInvitationDecline(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        setEditMode(true);
        super.onItemLongPressed(str);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        super.onLayout();
        this.mIsCoeditNoNoteVisibility = 8;
        clearInvitationNotifications();
        initOrientation();
        this.mActionMenuController.setDisplayHomeAsUpEnabled(true);
        this.mActionMenuController.setToolbarTitle(C8003R.string.co_edit_title);
        setSubTitle(true);
        EventManager.getEventBus().register(this.mEventListener);
        EventManager.getEventBus().register(this.mEventListenerStandaloneReceive);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        super.onModeEnd();
        onCoeditModeEnd();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        super.onNoteSelected(mainEntryParam);
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_OPEN_STANDALONE_NOTE, SesCoeditShareReadResolver.getInstance().isSpaceOwner(mainEntryParam.getSpaceId()) ? "a" : "b");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        MainCoeditLogger.m7250d(TAG, "onOptionsItemSelected# onClick : " + ((Object) menuItem.getTitle()));
        int itemId = menuItem.getItemId();
        onOptionsItemSelectedSALogging(itemId);
        if (itemId == C8003R.id.action_old_shared_notebook) {
            setGcsMode();
            BadgeHelper.setGcsHasMoreBadge(false);
        } else if (itemId == C8003R.id.action_create_notebook) {
            createNewSpace();
        } else if (itemId == C8003R.id.action_edit) {
            setEditMode(true);
        } else if (itemId == C8003R.id.action_search) {
            this.mNotesView.setMode(16);
        } else if (itemId == C8003R.id.action_viewby) {
            this.mPresenter.showViewByPopupMenu();
        } else if (itemId == C8003R.id.action_sortby) {
            this.mPresenter.showSortByDialog();
        } else if (itemId == C8003R.id.action_mark_all_as_read) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            SharedPreferencesCompat.getInstance("CoeditPref").putLong("CoeditPrefKeyReadAllTime", jCurrentTimeMillis);
            RepositoryManager.getInstance().getSyncNoteDataRepository().updateAllCoeditNotesAsRead(jCurrentTimeMillis);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareOptionsMenu(Menu menu) {
        SeslMenuItem seslMenuItem;
        if (this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0]) == 0) {
            menu.removeItem(C8003R.id.action_edit);
            menu.removeItem(C8003R.id.action_viewby);
            menu.removeItem(C8003R.id.action_sortby);
        }
        if (isNeedToHideOldSharedNotebooksMenu()) {
            menu.removeItem(C8003R.id.action_old_shared_notebook);
        } else {
            boolean z = SharedPreferencesCompat.getInstance(NotesConstants.PREF_NOTES_FRAGMENT).getBoolean(NotesConstants.KEY_OLD_SHARED_NOTEBOOKS_SMART_TIP, true);
            MainCoeditLogger.m7250d(TAG, "showSmartTipIfNeeded# needToShowSmartTip: " + z);
            if (z) {
                showSmartTipForOldSharedNotebooks();
            }
            if (BadgeHelper.hasGcsMoreBadge() && (seslMenuItem = (SeslMenuItem) menu.findItem(C8003R.id.action_old_shared_notebook)) != null) {
                seslMenuItem.setBadgeText("");
            }
        }
        if (RepositoryManager.getInstance().getSyncNoteDataRepository().getUnreadCoeditNoteCount() == 0) {
            menu.removeItem(C8003R.id.action_mark_all_as_read);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mSelectedGroupId = bundle.getString(GcsConstants.KEY_SELECTED_GROUP_ID);
        this.mSelectedSpaceId = bundle.getString(GcsConstants.KEY_SELECTED_SPACE_ID);
        CoeditNameDialogFragment coeditNameDialogFragment = (CoeditNameDialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(GcsConstants.DialogTag.ADD_NOTEBOOK);
        if (coeditNameDialogFragment != null) {
            coeditNameDialogFragment.onViewStateRestored(bundle);
            coeditNameDialogFragment.setEditDialogResultListener(this.mCreateSpaceDialogListener);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onResume() {
        super.onResume();
        clearInvitationNotifications();
        initOrientation();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(GcsConstants.KEY_SELECTED_GROUP_ID, this.mSelectedGroupId);
        bundle.putString(GcsConstants.KEY_SELECTED_SPACE_ID, this.mSelectedSpaceId);
        CoeditNameDialogFragment coeditNameDialogFragment = (CoeditNameDialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(GcsConstants.DialogTag.ADD_NOTEBOOK);
        if (coeditNameDialogFragment != null) {
            coeditNameDialogFragment.onSaveInstanceState(bundle);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode
    public void onSpaceDelete() {
        if (this.mSessionConnector.requestSpaceDelete(this.mSelectedGroupId, this.mSelectedSpaceId, false, this.mSpaceRemoveResultListener, null, 0L)) {
            replaceDeleteBtnToProgress(GcsConstants.DialogTag.DELETE_NOTEBOOK);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode
    public void onSpaceLeave() {
        if (SesCoeditShareReadResolver.getInstance().isSpaceOwner(this.mSelectedSpaceId)) {
            showCoeditMemberManage(this.mSelectedGroupId, this.mSelectedSpaceId, true);
        } else if (this.mSessionConnector.requestSpaceLeave(this.mSelectedGroupId, this.mSelectedSpaceId, this.mSpaceRemoveResultListener)) {
            replaceDeleteBtnToProgress(GcsConstants.DialogTag.LEAVE_NOTEBOOK);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public boolean onSpaceLongPressed(String str, String str2) {
        MainCoeditLogger.m7250d(TAG, "onSpaceLongPressed# spaceId: " + str2);
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        this.mSelectedGroupId = str;
        this.mSelectedSpaceId = str2;
        new CoeditSpaceEditMenuDialog(this.mContext, SesCoeditShareReadResolver.getInstance().getSpaceTitle(str2), SesCoeditShareReadResolver.getInstance().isSpaceOwner(str2), this.mSpaceMenuDialogContract).show();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public void onSpaceSelected(String str, String str2) {
        MainCoeditLogger.m7250d(TAG, "onSpaceSelected# spaceId: " + str2);
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_ENTER_SPACE, SesCoeditShareReadResolver.getInstance().isSpaceOwner(str2) ? "a" : "b");
        this.mSessionConnector.requestSpace(str2);
        this.mNotesView.setIsScrollToTop(true, 0);
        this.mPresenter.getCoeditHelper().onSpaceSelected(str, str2);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode
    public void requestDownload(String str) {
        requestDownload(null, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode
    public void requestSync(boolean z, String str) {
        requestSync(getSyncRequiredSpaceIds(), z, str);
    }

    public void setCoeditNoNoteVisibility() {
        ViewGroup viewGroup = this.mNoHolderLayout;
        if (viewGroup == null) {
            return;
        }
        int visibility = viewGroup.getVisibility();
        this.mIsCoeditNoNoteVisibility = visibility;
        if (visibility != 0) {
            clearCoeditNoNoteLayout();
        } else {
            initNoNoteLayout();
            this.mNoHolderLayout.addView(this.mCoeditNoNoteLayout);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean setEditMode(boolean z) {
        super.setEditMode(z);
        return this.mNotesView.setMode(13);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void setNoHolderLayout() {
        TextView textView = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_note);
        TextView textView2 = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_note_sub);
        TextView textView3 = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_result);
        textView.setVisibility(8);
        textView2.setVisibility(8);
        textView3.setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public boolean setNoNoteLayoutVisibility(int i, String str) {
        if (!super.setNoNoteLayoutVisibility(i, str) || this.mIsCoeditNoNoteVisibility == i) {
            return false;
        }
        setCoeditNoNoteVisibility();
        return true;
    }

    public void setSubTitle(boolean z) {
        String str = "";
        if (getModeIndex() != 12) {
            this.mActionMenuController.setToolbarSubTitle("");
            return;
        }
        Resources resources = this.mAppContext.getResources();
        int coeditNoteCount = this.mPresenter.getDocumentMap().getCoeditNoteCount();
        String quantityString = coeditNoteCount <= 0 ? "" : resources.getQuantityString(C8003R.plurals.plurals_count_notes, coeditNoteCount, Integer.valueOf(coeditNoteCount));
        int coeditSpaceCount = this.mPresenter.getDocumentMap().getCoeditSpaceCount();
        String quantityString2 = coeditSpaceCount <= 0 ? "" : resources.getQuantityString(C8003R.plurals.plurals_count_spaces, coeditSpaceCount, Integer.valueOf(coeditSpaceCount));
        if (coeditNoteCount > 0 && coeditSpaceCount > 0) {
            str = resources.getString(C8003R.string.string_comma) + " ";
        }
        String strM757C = AbstractC0541b.m757C(quantityString2, str, quantityString);
        MainCoeditLogger.m7253i(TAG, "setSubTitle# " + strM757C);
        Editable editableNewEditable = Editable.Factory.getInstance().newEditable(strM757C);
        int length = strM757C.length();
        if (length > 0) {
            if (LocaleUtils.isRTLMode()) {
                editableNewEditable.insert(length, UnicodeUtils.RLM);
            } else {
                editableNewEditable.insert(length, "\u200e");
            }
            int dimensionPixelSize = resources.getDimensionPixelSize(C8003R.dimen.co_edit_beta_view_margin_top);
            Drawable drawable = ResourcesCompat.getDrawable(resources, C8003R.drawable.ic_beta, null);
            drawable.setBounds(0, dimensionPixelSize, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight() + dimensionPixelSize);
            editableNewEditable.setSpan(new ImageSpan(drawable), length, length + 1, 33);
            editableNewEditable.insert(length, "\n");
        }
        this.mActionMenuController.setToolbarSubTitle(editableNewEditable);
        this.mActionMenuController.setCoeditBetaView();
        if (this.mIsNeedToOnLayoutLogging) {
            NotesListSALoggingHelper notesListSALoggingHelper = new NotesListSALoggingHelper();
            notesListSALoggingHelper.setCoeditSpaceCount(coeditSpaceCount);
            notesListSALoggingHelper.setCoeditNoteCount(coeditNoteCount);
        }
        this.mIsNeedToOnLayoutLogging = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode
    public void startTitleAndDatePolling(String str) {
        startTitleAndDatePolling(null, str);
    }
}
