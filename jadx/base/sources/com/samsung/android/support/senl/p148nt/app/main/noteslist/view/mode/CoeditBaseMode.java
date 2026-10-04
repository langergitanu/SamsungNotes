package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.AppTaskCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnectorImpl;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.AdapterManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.DataTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.CoeditNameDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.CoeditSpaceLeaveAndDeleteDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.CoeditSpaceLeaveDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.DeleteDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.ModeContract;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.presenter.GcsGroupNetworkUtils;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.livesharing.LiveSharingManager;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.coedit.caller.CoeditNoteUpDownloader;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadResponse;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditNetworkManager;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.model.service.RestoreCacheManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import p044K.C0158a;
import p079T.AbstractC0291i;
import p079T.AbstractC0294l;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CoeditBaseMode extends BaseMode {
    private static final long AUTO_REFRESH_DELAY = 5000;
    private static final int SWIPE_REFRESH_DELAY = 3000;
    private final Executor mCoeditExecutor;
    private CoeditNetworkManager.Callback mCoeditNetworkManagerCallback;
    private final Runnable mCoeditSyncRunnable;
    private final Object mKey;
    protected final CoeditSessionConnector mSessionConnector;
    private final DialogViewContract.IDeleteDialog mSpaceDeleteDialogResultListener;
    private final DialogViewContract.IDeleteDialog mSpaceLeaveDialogResultListener;
    private final IEditDialogResult mSpaceRenameDialogResultListener;
    private final CoeditSessionConnector.ActionResult mSpaceRenameResultListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DownloadResponseWithLogging implements DownloadResponse {
        private final String mCaller;
        private final String mTag;

        public DownloadResponseWithLogging(@NonNull String str, @NonNull String str2) {
            this.mTag = str;
            this.mCaller = str2;
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadResponse
        public void onCompleted(String str, String str2, boolean z) {
            String str3 = this.mTag;
            StringBuilder sb = new StringBuilder();
            AbstractC2821a.m2207B(sb, this.mCaller, ", onCompleted, uuid: ", str2, ", isSuccess: ");
            sb.append(z);
            MainCoeditLogger.m7250d(str3, sb.toString());
        }
    }

    public CoeditBaseMode(ModeParams modeParams) {
        super(modeParams);
        this.mKey = new Object();
        this.mSpaceRenameResultListener = new CoeditSessionConnector.ActionResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditBaseMode.1
            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActionResult
            public void onFail() {
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActionResult
            public void onSuccess() {
                MainCoeditLogger.m7253i(CoeditBaseMode.this.getTag(), "SpaceUpdateResultListener# onSuccess");
                CoeditBaseMode.this.onSpaceRenameSuccess();
            }
        };
        this.mSpaceRenameDialogResultListener = new IEditDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditBaseMode.2
            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
            public void onEditDialogDismiss() {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
            public void onEditDialogResult(int i, String str, String str2, int i2) {
                CoeditBaseMode coeditBaseMode = CoeditBaseMode.this;
                coeditBaseMode.mSessionConnector.requestSpaceUpdate(str, str2, coeditBaseMode.mSpaceRenameResultListener);
            }
        };
        this.mSpaceLeaveDialogResultListener = new DialogViewContract.IDeleteDialog() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditBaseMode.3
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
            public void onBackPressed() {
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
            public void onCancel() {
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
            public void onConfirm(boolean z) {
                CoeditBaseMode.this.onSpaceLeave();
            }
        };
        this.mSpaceDeleteDialogResultListener = new DialogViewContract.IDeleteDialog() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditBaseMode.4
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
            public void onBackPressed() {
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
            public void onCancel() {
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
            public void onConfirm(boolean z) {
                CoeditBaseMode.this.onSpaceDelete();
            }
        };
        this.mCoeditSyncRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditBaseMode.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    MainCoeditLogger.m7251e(CoeditBaseMode.this.getTag(), "CoeditSyncRunnable, InterruptedException, " + e.getMessage());
                }
                int modeIndex = CoeditBaseMode.this.mPresenter.getStateInfo().getModeIndex();
                if (FeatureUtils.isCoeditMode(modeIndex) || FeatureUtils.isCoeditSpaceMode(modeIndex)) {
                    CoeditBaseMode.this.requestSync(true, "CoeditSyncRunnable");
                    return;
                }
                MainLogger.m7259w(CoeditBaseMode.this.getTag(), "CoeditSyncRunnable, mode is change to " + modeIndex + " ignore requestSync");
            }
        };
        this.mCoeditNetworkManagerCallback = null;
        this.mCoeditExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(getTag()));
        this.mSessionConnector = new CoeditSessionConnectorImpl(this.mAppContext, getTag(), new CoeditSessionConnector.ActivityContract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditBaseMode.7
            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public void finishActivity() {
                CoeditBaseMode.this.finishCoeditMode();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public FragmentActivity getActivity() {
                return CoeditBaseMode.this.mFragment.getActivity();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public void launchActivity(Intent intent, NotesActivityResultCallback notesActivityResultCallback) {
                CoeditBaseMode.this.mFragmentContract.launchActivity(intent, notesActivityResultCallback);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public void onSessionConnected(boolean z) {
                if (z) {
                    CoeditBaseMode.this.onCoeditSessionConnected();
                }
            }
        });
        NotificationUtils.checkedNotificationPermissions(this.mFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRequestedDownload(String str) {
        if (C0158a.m409d(this.mAppContext)) {
            MainLogger.m7259w(getTag(), "cancelRequestedDownload, caller: " + str);
            CoeditNoteUpDownloader.getInstance().cancelRequestedDownload();
            return;
        }
        MainCoeditLogger.m7250d(getTag(), "cancelRequestedDownload, caller: " + str + ", ignore, coedit feature is not supported");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRequestedSync(String str) {
        if (C0158a.m409d(this.mAppContext)) {
            MainLogger.m7259w(getTag(), "cancelRequestedSync, caller: " + str);
            CoeditNoteUpDownloader.getInstance().cancelRequestedSync();
            return;
        }
        MainCoeditLogger.m7250d(getTag(), "cancelRequestedSync, caller: " + str + ", ignore, coedit feature is not supported");
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        PermissionHelper.isPermissionGranted(this.mFragment.getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditBaseMode.8
            @Override // java.lang.Runnable
            public void run() {
                PermissionHelper.requestPermissions(CoeditBaseMode.this.mFragment, 204, "android.permission.READ_PHONE_STATE");
            }
        }, "android.permission.READ_PHONE_STATE");
    }

    private CoeditNetworkManager.Callback createCallback() {
        return new CoeditNetworkManager.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditBaseMode.6
            private void updateNoteList(final String str) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditBaseMode.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CoeditBaseMode.this.mPresenter.notifyDataSetChangedWithViewPageChange("CoeditNetworkManagerCallback [" + str + "]");
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.coedit.common.CoeditNetworkManager.Callback
            public void onAvailable() {
                CoeditLogger.m8919d(CoeditBaseMode.this.getTag(), "onAvailable");
                CoeditBaseMode.this.requestDownload("CoeditNetworkManagerCallback, onAvailable");
                CoeditBaseMode.this.requestSync(true, "CoeditNetworkManagerCallback, onAvailable");
                CoeditBaseMode.this.startTitleAndDatePolling("CoeditNetworkManagerCallback, onAvailableNetwork");
                updateNoteList("CoeditNetworkManagerCallback, onAvailableNetwork");
            }

            @Override // com.samsung.android.support.senl.nt.coedit.common.CoeditNetworkManager.Callback
            public void onLost() {
                CoeditLogger.m8919d(CoeditBaseMode.this.getTag(), "onLost");
                CoeditBaseMode.this.cancelRequestedSync("CoeditNetworkManagerCallback, onLostNetwork");
                CoeditBaseMode.this.cancelRequestedDownload("CoeditNetworkManagerCallback, onLostNetwork");
                CoeditBaseMode.this.finishTitleAndDatePolling("CoeditNetworkManagerCallback, onLostNetwork");
                updateNoteList("CoeditNetworkManagerCallback, onLostNetwork");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishCoeditMode() {
        MainCoeditLogger.m7250d(getTag(), "finishCoeditMode#");
        ModeContract.IView iView = this.mNotesView;
        String str = FolderConstants.AllNotes.UUID;
        iView.onFolderSelected(str);
        Bundle arguments = this.mFragment.getArguments();
        if (arguments == null || !arguments.getString(NotesConstants.KEY_FOLDER_UUID, NotesUtils.getLastSelectedFolder()).equals(FolderConstants.Coedit.UUID)) {
            return;
        }
        arguments.putString(NotesConstants.KEY_FOLDER_UUID, str);
    }

    private void leaveAndDeleteSpace(String str) {
        CoeditSpaceLeaveAndDeleteDialogFragment coeditSpaceLeaveAndDeleteDialogFragment = new CoeditSpaceLeaveAndDeleteDialogFragment(SesCoeditShareReadResolver.getInstance().getSpaceTitle(str), getModeIndex());
        coeditSpaceLeaveAndDeleteDialogFragment.setContract(this.mSpaceDeleteDialogResultListener);
        coeditSpaceLeaveAndDeleteDialogFragment.show(this.mFragment.getChildFragmentManager(), GcsConstants.DialogTag.DELETE_NOTEBOOK);
    }

    private void setTipCard() {
        this.mPresenter.getTipCardHelper().clearTipCard(false);
        int mTipCardType = LiveSharingManager.getInstance().getMTipCardType();
        if (mTipCardType != LiveSharingManager.NONE) {
            this.mPresenter.getTipCardHelper().setMeetTipCard(mTipCardType);
        }
    }

    public boolean decorateFakeNote(CommonHolderInfo commonHolderInfo, @NonNull CoeditMainListEntry coeditMainListEntry) {
        boolean z = coeditMainListEntry.getType() == 2;
        commonHolderInfo.setCoeditLoadProgressVisible(z, GcsGroupNetworkUtils.checkCoeditNetworkConnection(this.mFragment.getActivity(), GcsConstants.RequestType.None, false));
        return z;
    }

    public void deleteSpace() {
        DeleteDialogFragment deleteDialogFragment = new DeleteDialogFragment(C8003R.string.co_edit_delete_space_dialog_title, C8003R.string.co_edit_delete_space_dialog_message, C8003R.string.dialog_delete, 1, 0, 0, false, getModeIndex(), true);
        deleteDialogFragment.setContract(this.mSpaceDeleteDialogResultListener);
        deleteDialogFragment.show(this.mFragment.getChildFragmentManager(), GcsConstants.DialogTag.DELETE_NOTEBOOK);
    }

    public void dismissDeleteDialog() {
        if (this.mFragment.isAdded()) {
            CoeditNameDialogFragment coeditNameDialogFragment = (CoeditNameDialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(GcsConstants.DialogTag.RENAME_NOTEBOOK);
            if (coeditNameDialogFragment != null) {
                coeditNameDialogFragment.dismissAllowingStateLoss();
            }
            DeleteDialogFragment deleteDialogFragment = (DeleteDialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(GcsConstants.DialogTag.LEAVE_NOTEBOOK);
            if (deleteDialogFragment != null) {
                deleteDialogFragment.dismissAllowingStateLoss();
            }
            DeleteDialogFragment deleteDialogFragment2 = (DeleteDialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(GcsConstants.DialogTag.DELETE_NOTEBOOK);
            if (deleteDialogFragment2 != null) {
                deleteDialogFragment2.dismissAllowingStateLoss();
            }
        }
    }

    public void finishActivity() {
        AbsFragment absFragment = this.mFragment;
        if (absFragment == null) {
            return;
        }
        FragmentActivity activity = absFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        activity.finish();
    }

    public void finishTitleAndDatePolling(String str) {
        MainCoeditLogger.m7250d(getTag(), "finishTitleAndDatePolling, caller: " + str);
        CoeditNoteUpDownloader.getInstance().finishPolling();
    }

    public List<String> getSyncRequiredSpaceIds() {
        CoeditMainListEntry coeditMainListEntry;
        ArrayList arrayList = new ArrayList();
        for (Common common : new ArrayList(this.mPresenter.getDocumentMap().getCommonDisplayList())) {
            if (common.type == 2048 && (coeditMainListEntry = common.coeditNotes) != null && coeditMainListEntry.getType() != 2 && common.coeditNotes.isSnapShotUpdateRequired()) {
                arrayList.add(common.coeditNotes.getMainListDocumentData().getMdeSpaceId());
            }
        }
        return arrayList;
    }

    @Nullable
    public Set<String> getSyncRequiredUuid() {
        CoeditMainListEntry coeditMainListEntry;
        HashSet hashSet = new HashSet();
        List<Common> commonDisplayList = this.mPresenter.getDocumentMap().getCommonDisplayList();
        if (commonDisplayList == null) {
            return null;
        }
        for (Common common : commonDisplayList) {
            if (common.type == 2048 && (coeditMainListEntry = common.coeditNotes) != null && coeditMainListEntry.getType() != 2 && common.coeditNotes.isSnapShotUpdateRequired()) {
                hashSet.add(common.coeditNotes.getMainListDocumentData().getUuid());
            }
        }
        return hashSet;
    }

    public void leaveSharedNote() {
    }

    public void leaveSpace(String str, String str2, boolean z) {
        if (SesCoeditGroupReadResolver.getInstance().getGroupCount(str) == 1) {
            MainCoeditLogger.m7250d(getTag(), "leaveSpace# can't leave because I'm the only member.");
            leaveAndDeleteSpace(str2);
        } else {
            CoeditSpaceLeaveDialogFragment coeditSpaceLeaveDialogFragment = new CoeditSpaceLeaveDialogFragment(z, getModeIndex());
            coeditSpaceLeaveDialogFragment.setContract(this.mSpaceLeaveDialogResultListener);
            coeditSpaceLeaveDialogFragment.show(this.mFragment.getChildFragmentManager(), GcsConstants.DialogTag.LEAVE_NOTEBOOK);
        }
    }

    public void onCoeditSessionConnected() {
        MainCoeditLogger.m7253i(getTag(), "onCoeditSessionConnected#");
        if (!C0158a.f490j) {
            C0158a.f489i = false;
        }
        startTitleAndDatePolling("onCoeditSessionConnected");
        requestDownload("onSessionConnected");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onContextClick(final CommonHolderInfo commonHolderInfo) {
        PopupMenu popupMenuCreateContextPopupMenu = createContextPopupMenu(commonHolderInfo);
        if (popupMenuCreateContextPopupMenu == null) {
            return false;
        }
        popupMenuCreateContextPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditBaseMode.9
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                CoeditBaseMode.this.mPresenter.updateCheckedData(commonHolderInfo, true);
                int itemId = menuItem.getItemId();
                if (itemId == C8003R.id.action_delete) {
                    CoeditBaseMode.this.mPresenter.showDeleteCoeditNotesDialog();
                } else if (itemId == C8003R.id.action_save_to_device) {
                    CoeditBaseMode.this.mPresenter.duplicateToDevice();
                } else if (itemId == C8003R.id.action_save_as_file) {
                    CoeditBaseMode.this.mPresenter.showExportOptionPopup(true);
                } else if (itemId == C8003R.id.action_share) {
                    CoeditBaseMode.this.mPresenter.showExportOptionPopup(false);
                } else {
                    if (itemId != C8003R.id.action_leave_shared_note) {
                        return false;
                    }
                    CoeditBaseMode.this.leaveSharedNote();
                }
                return true;
            }
        });
        popupMenuCreateContextPopupMenu.show();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public AdapterManager.DataState onDataChangedByMode(List<MainListDocumentData> list) {
        return AdapterManager.DataState.NOT_USED;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDestroy() {
        super.onDestroy();
        dismissDeleteDialog();
        this.mSessionConnector.disconnect();
        CoeditNetworkManager.getInstance().unregisterNetworkCallback(String.valueOf(this.mKey.hashCode()));
        this.mCoeditNetworkManagerCallback = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        boolean z = getModeIndex() == 12 || getModeIndex() == 14;
        if (z) {
            checkPermission();
        }
        this.mSessionConnector.connect();
        super.onLayout();
        this.mCoeditExecutor.execute(this.mCoeditSyncRunnable);
        this.mNotesView.setSwipeRefreshLayoutEnabled(z);
        if (z) {
            this.mNotesView.setSwipeRefreshLayoutDuration(3000);
        }
        setTipCard();
        if (this.mCoeditNetworkManagerCallback == null) {
            this.mCoeditNetworkManagerCallback = createCallback();
        }
        CoeditNetworkManager.getInstance().registerNetworkCallback(String.valueOf(this.mKey.hashCode()), this.mCoeditNetworkManagerCallback);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        super.onModeEnd();
        this.mSessionConnector.disconnect();
        this.mNotesView.setSwipeRefreshLayoutEnabled(false);
        CoeditNetworkManager.getInstance().unregisterNetworkCallback(String.valueOf(this.mKey.hashCode()));
        this.mCoeditNetworkManagerCallback = null;
        finishTitleAndDatePolling("onModeEnd");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        String uuid = mainEntryParam.getUuid();
        if (CoeditHandlerManager.getInstance().isCoeditWithUpDownloaderRunning(uuid)) {
            ToastHandler.show(this.mContext, C8003R.string.co_edit_can_not_open_note_try_again_later, 0);
            return;
        }
        if (CoeditHandlerManager.getInstance().isCoeditWithComposerRunning(uuid)) {
            MainCoeditLogger.m7250d(getTag(), "onNoteSelected# try to open running coedit note");
            Activity composerActivity = ComposerManager.getInstance().getComposerActivity(uuid);
            if (composerActivity == null || composerActivity.isFinishing() || composerActivity.isDestroyed()) {
                ToastHandler.show(this.mContext, C8003R.string.co_edit_can_not_open_note_try_again_later, 0);
                return;
            } else {
                AppTaskCompat.getInstance().moveToFront(this.mContext, composerActivity.getTaskId());
                ToastHandler.show(this.mContext, C8003R.string.composer_editing, 0);
                return;
            }
        }
        if (CoeditHandlerManager.getInstance().isCoeditWithUpDownloaderRunning(uuid) || AbstractC0291i.m569f(uuid) || RestoreCacheManager.isRestoring(uuid)) {
            ToastHandler.show(this.mContext, C8003R.string.updating_note_try_again_later, 0);
            return;
        }
        CoeditMainListEntry coeditNoteData = this.mPresenter.getDocumentMap().getCoeditNoteData(uuid);
        if (coeditNoteData != null && coeditNoteData.getType() == 2) {
            ToastHandler.show(this.mContext, C8003R.string.co_edit_can_not_open_note_try_again_later, 0);
            return;
        }
        cancelRequestedDownload("onNoteSelected");
        cancelRequestedSync("onNoteSelected");
        super.onNoteSelected(mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        CoeditNameDialogFragment coeditNameDialogFragment = (CoeditNameDialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(GcsConstants.DialogTag.RENAME_NOTEBOOK);
        if (coeditNameDialogFragment != null) {
            coeditNameDialogFragment.setEditDialogResultListener(this.mSpaceRenameDialogResultListener);
        }
        DeleteDialogFragment deleteDialogFragment = (DeleteDialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(GcsConstants.DialogTag.LEAVE_NOTEBOOK);
        if (deleteDialogFragment != null) {
            deleteDialogFragment.setContract(this.mSpaceLeaveDialogResultListener);
        }
        DeleteDialogFragment deleteDialogFragment2 = (DeleteDialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(GcsConstants.DialogTag.DELETE_NOTEBOOK);
        if (deleteDialogFragment2 != null) {
            deleteDialogFragment2.setContract(this.mSpaceDeleteDialogResultListener);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onResume() {
        super.onResume();
        if (NotesUtils.isCoeditFeatureEnabled(this.mAppContext)) {
            startTitleAndDatePolling("onResume");
            requestDownload("onResume");
        } else {
            MainCoeditLogger.m7253i(getTag(), "onResume# CoeditFeatureEnabled false");
            finishCoeditMode();
        }
    }

    public void onSpaceDelete() {
    }

    public void onSpaceLeave() {
    }

    public void onSpaceRenameSuccess() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onSwipeRefresh() {
        super.onSwipeRefresh();
        if (!GcsGroupNetworkUtils.checkCoeditNetworkConnection(this.mFragment.getActivity(), GcsConstants.RequestType.Invite, false) || CoeditNoteUpDownloader.getInstance().isExistRunningNoteUuids()) {
            return false;
        }
        requestSync(false, "onSwipeRefresh");
        return true;
    }

    public void registerExternalSnap(String str, String str2) {
        CoeditNoteUpDownloader.getInstance().registerExternalSnap(str, str2);
    }

    public void renameSpace(String str) {
        CoeditNameDialogFragment coeditNameDialogFragment = new CoeditNameDialogFragment(str, SesCoeditShareReadResolver.getInstance().getSpaceTitle(str));
        coeditNameDialogFragment.setEditDialogResultListener(this.mSpaceRenameDialogResultListener);
        coeditNameDialogFragment.show(this.mFragment.getChildFragmentManager(), GcsConstants.DialogTag.RENAME_NOTEBOOK);
    }

    public void replaceDeleteBtnToProgress(String str) {
        DialogViewContract.IDialogFragment iDialogFragment = (DialogViewContract.IDialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(str);
        if (iDialogFragment == null) {
            return;
        }
        iDialogFragment.replaceBtnToProgress();
    }

    public abstract void requestDownload(String str);

    public void requestDownload(@Nullable final String str, final String str2) {
        if (!C0158a.m409d(this.mAppContext)) {
            MainLogger.m7259w(getTag(), "requestDownload, caller: " + str2 + ", ignore, coedit feature is not supported");
            return;
        }
        if (CoeditUtils.isWiFiSyncOnlyAndNotWiFiConnected()) {
            MainLogger.m7259w(getTag(), "requestDownload, caller: " + str2 + ", ignore, wifi only mode");
            return;
        }
        if (this.mSessionConnector.isConnected()) {
            new DataTask(this.mFragment.getActivity()).run(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditBaseMode.11
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        MainCoeditLogger.m7250d(CoeditBaseMode.this.getTag(), "[CS2] requestDownload, requestDownloadStandalone, caller: " + str2);
                        CoeditNoteUpDownloader.getInstance().requestDownloadStandalone(new DownloadResponseWithLogging(CoeditBaseMode.this.getTag(), "requestDownloadStandalone"));
                        return;
                    }
                    MainCoeditLogger.m7250d(CoeditBaseMode.this.getTag(), "[CS2] requestDownload, spaceId: " + str + ", caller: " + str2);
                    CoeditNoteUpDownloader.getInstance().requestDownload(str, new DownloadResponseWithLogging(CoeditBaseMode.this.getTag(), "requestDownload"));
                }
            });
            return;
        }
        MainLogger.m7259w(getTag(), "requestDownload, caller: " + str2 + ", ignore, session is not connected");
    }

    public void requestDownloadByPush(String str, boolean z) {
        if (z) {
            MainCoeditLogger.m7253i(getTag(), "requestDownloadByPush, closeComposer Before requestDownloadByPush");
            ComposerManager.getInstance().closeCoeditComposer(this.mFragment, null);
        }
        CoeditNoteUpDownloader.getInstance().requestDownloadByPush(str, new DownloadResponseWithLogging(getTag(), "requestDownloadByPush"));
    }

    public void requestSync(@NonNull List<String> list, boolean z, String str) {
        if (!C0158a.m409d(this.mAppContext)) {
            MainLogger.m7259w(getTag(), "requestSync, caller: " + str + ", ignore, coedit feature is not supported");
            return;
        }
        if (CoeditUtils.isWiFiSyncOnlyAndNotWiFiConnected()) {
            MainLogger.m7259w(getTag(), "requestSync, caller: " + str + ", ignore, wifi only mode");
            return;
        }
        if (!this.mSessionConnector.isConnected()) {
            MainLogger.m7259w(getTag(), "requestSync, caller: " + str + ", ignore, session is not connected");
            return;
        }
        Set<String> syncRequiredUuid = getSyncRequiredUuid();
        if (syncRequiredUuid.isEmpty()) {
            MainLogger.m7259w(getTag(), "requestSync, caller: " + str + ", ignore, syncRequiredUuids is empty");
            return;
        }
        if (!z && CoeditHandlerManager.getInstance().isCoeditWithComposerRunning()) {
            MainCoeditLogger.m7253i(getTag(), "requestSync, close coeditComposer before, request sync, caller: " + str);
            ComposerManager.getInstance().closeCoeditComposer(null, null);
        }
        MainCoeditLogger.m7250d(getTag(), "requestSync, auto: " + z + ", caller: " + str);
        CoeditNoteUpDownloader.getInstance().requestSync(list, syncRequiredUuid);
    }

    public abstract void requestSync(boolean z, String str);

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public boolean setNoNoteLayoutVisibility(int i, String str) {
        if (this.mNoHolderLayout == null) {
            this.mNoHolderLayout = (ViewGroup) ViewModeUtils.getInflatedView(this.mFragment.getView(), C8003R.id.no_note_layout, C8003R.id.inflate_no_note_layout);
        }
        ViewGroup viewGroup = this.mNoHolderLayout;
        if (viewGroup == null) {
            return false;
        }
        this.mActionMenuController.setVerticalView(viewGroup);
        this.mNoHolderLayout.setVisibility(i);
        return true;
    }

    public void showCoeditMemberManage(final String str, final String str2, final boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            MainCoeditLogger.m7251e(getTag(), "showCoeditMemberManage# groupId or spaceId is empty");
            return;
        }
        MainCoeditLogger.m7253i(getTag(), "showCoeditMemberManage#");
        dismissDeleteDialog();
        try {
            this.mFragmentContract.launchPopOverActivity(AbstractC0294l.m574a(str, SesCoeditShareReadResolver.getInstance().getSpaceTitle(str2), z), 0, new NotesActivityResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditBaseMode.10
                @Override // com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback
                public void onActivityResult(int i, @Nullable Intent intent) {
                    if (z && i == -1) {
                        CoeditBaseMode.this.mSessionConnector.requestSpaceLeaveAfterLeaderAssignSuccess(str, str2, null);
                        if (CoeditBaseMode.this.getModeIndex() == 14) {
                            CoeditBaseMode.this.onBackKeyDown();
                        }
                    }
                }
            });
        } catch (ActivityNotFoundException e) {
            MainCoeditLogger.m7251e(getTag(), "showCoeditMemberManage# ActivityNotFoundException " + e.getMessage());
        }
    }

    public abstract void startTitleAndDatePolling(String str);

    public void startTitleAndDatePolling(String str, String str2) {
        if (!this.mSessionConnector.isConnected()) {
            MainLogger.m7259w(getTag(), "startTitleAndDatePolling, ignore, session is not connected, spaceId: " + str + ", caller: " + str2);
            return;
        }
        if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
            MainLogger.m7259w(getTag(), "startTitleAndDatePolling, ignore, data network failed or wifi mode enabled, spaceId: " + str + ", caller: " + str2);
            return;
        }
        MainCoeditLogger.m7250d(getTag(), "startTitleAndDatePolling, spaceId: " + str + ", caller: " + str2);
        CoeditNoteUpDownloader.getInstance().startPolling(str);
    }
}
