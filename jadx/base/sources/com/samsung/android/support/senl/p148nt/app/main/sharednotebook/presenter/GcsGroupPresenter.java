package com.samsung.android.support.senl.p148nt.app.main.sharednotebook.presenter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.deletecore.DeleteLocalSharedSdocTask;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotSupportedApiException;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.group.GroupApi;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationResult;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceListResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceResult;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.DataTask;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.presenter.GcsGroupDialogPresenter;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import p042J1.C0145c;
import p056N.InterfaceC0179a;
import p075S.AbstractC0248O;
import p075S.AbstractC0272x;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsGroupPresenter implements GcsGroupDialogPresenter.IGroupDialogContract {
    private static final String KEY_SPACE_ID = "space_id";
    private static final String KEY_SPACE_NAME = "space_name";
    public static final String TAG = "GcsGroupPresenter";
    private final GcsGroupDialogPresenter mDialogPresenter;
    private final IPresenterContract mIPresenterContract;
    private String mSelectedSpaceId;
    private String mSelectedSpaceName;
    private final SesShareApiTask mSesShareApiTask;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenterContract {
        Activity getActivity();

        FragmentManager getChildFragmentManager();

        Context getContext();

        boolean isAdded();

        void launchSocialPicker(String str);

        void restartLoader();

        void showGoToSettingsDialog();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SesShareApiTask {
        public SesShareApiTask() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void deleteLocalSharedSdoc(DeleteLocalSharedSdocTask.DeleteType deleteType, String str) {
            new DeleteLocalSharedSdocTask(deleteType, str, new InterfaceC0179a() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.SesShareApiTask.6
                @Override // p056N.InterfaceC0179a
                public void onDeleteLocalSharedSdocFinished() {
                    GcsGroupPresenter.this.updateSpaceList();
                }
            }).execute(new Void[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestGroupCreation(final int i, final ArrayList<String> arrayList, final ArrayList<String> arrayList2) {
            new DataTask(GcsGroupPresenter.this.mIPresenterContract.getActivity()).run(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.SesShareApiTask.5
                @Override // java.lang.Runnable
                public void run() {
                    MainLogger.m7258i(GcsGroupPresenter.TAG, "requestGroupCreation()");
                    try {
                        if (GcsGroupNetworkUtils.checkNetworkConnection(GcsGroupPresenter.this.getContext(), GcsConstants.RequestType.Create, false) && C6716p.m4809q().m4801j()) {
                            AbstractC0272x.m550a().requestGroupCreation(new GroupApi.GroupRequest(GcsGroupPresenter.this.mSelectedSpaceName, "UNM1", (Uri) null, (String) null), new GroupApi.InvitationRequest("", i, arrayList, arrayList2), new GroupApi.GroupResultCallback<GroupInvitationResult>() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.SesShareApiTask.5.1
                                @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
                                public void onResult(GroupInvitationResult groupInvitationResult) {
                                    boolean z = groupInvitationResult.getStatus().getCode() == 1;
                                    String displayMessage = groupInvitationResult.getDisplayMessage();
                                    MainLogger.m7258i(GcsGroupPresenter.TAG, "GroupResultCallback(). onResult() " + z + SQLKeyword.COMMA + displayMessage);
                                    if (!z) {
                                        GcsGroupNetworkUtils.showUnknownFailToast(GcsGroupPresenter.this.getContext(), GcsConstants.RequestType.Create, false);
                                    } else {
                                        GcsGroupPresenter.this.showDisplayMessageToast(displayMessage);
                                        GcsGroupPresenter.this.createSharedNotebooks(groupInvitationResult.getGroup().getGroupId());
                                    }
                                }
                            });
                        }
                    } catch (NotAuthorizedException e) {
                        MainLogger.m7255e(GcsGroupPresenter.TAG, "requestGroupCreation(). NotAuthorizedException : " + e.getMessage());
                    } catch (NotConnectedException e2) {
                        MainLogger.m7255e(GcsGroupPresenter.TAG, "requestGroupCreation(). NotConnectedException : " + e2.getMessage());
                    } catch (NotSupportedApiException e3) {
                        MainLogger.m7255e(GcsGroupPresenter.TAG, "requestGroupCreation(). NotSupportedApiException : " + e3.getMessage());
                    } catch (Exception e5) {
                        AbstractC14516b.m15115c(e5, new StringBuilder("requestGroupCreation(). Exception : "), GcsGroupPresenter.TAG);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestSpaceCreation(final String str) {
            new DataTask(GcsGroupPresenter.this.mIPresenterContract.getActivity()).run(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.SesShareApiTask.2
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(GcsGroupPresenter.this.mSelectedSpaceName)) {
                        MainLogger.m7255e(GcsGroupPresenter.TAG, "createSharedNotebooks(). space name is null or empty.");
                        return;
                    }
                    MainLogger.m7258i(GcsGroupPresenter.TAG, "createSharedNotebooks()");
                    try {
                        if (GcsGroupNetworkUtils.checkNetworkConnection(GcsGroupPresenter.this.getContext(), GcsConstants.RequestType.Create, false) && C6716p.m4809q().m4801j()) {
                            String str2 = str;
                            ShareApi.SpaceWithUriRequest spaceWithUriRequest = new ShareApi.SpaceWithUriRequest(GcsGroupPresenter.this.mSelectedSpaceName);
                            ShareApi.SpaceResultCallback spaceResultCallback = new ShareApi.SpaceResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.SesShareApiTask.2.1
                                @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceResultCallback
                                public void onResult(SpaceResult spaceResult) {
                                    boolean z = spaceResult.getStatus().getCode() == 1;
                                    AbstractC6670b.m4739D("createSharedNotebooks(). onResult() ", GcsGroupPresenter.TAG, z);
                                    if (!z) {
                                        GcsGroupNetworkUtils.showUnknownFailToast(GcsGroupPresenter.this.getContext(), GcsConstants.RequestType.Create, false, spaceResult.getStatus().getCode());
                                        return;
                                    }
                                    RunnableC87192 runnableC87192 = RunnableC87192.this;
                                    GcsGroupPresenter.this.updateGroupMemberList(str);
                                    GcsGroupPresenter.this.updateSpaceList();
                                }
                            };
                            if (C0145c.m333r(BaseUtils.getApplicationContext())) {
                                throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestSpaceCreation failed - wifi only");
                            }
                            AbstractC0248O.m527a().requestSpaceCreation(str2, spaceWithUriRequest, spaceResultCallback);
                        }
                    } catch (Exception e) {
                        AbstractC14516b.m15115c(e, new StringBuilder("[CS1-2] createSharedNotebooks() Exception : "), GcsGroupPresenter.TAG);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestSpaceDelete(final String str) {
            new DataTask(GcsGroupPresenter.this.mIPresenterContract.getActivity()).run(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.SesShareApiTask.3
                @Override // java.lang.Runnable
                public void run() {
                    MainLogger.m7258i(GcsGroupPresenter.TAG, "requestSpaceDelete()");
                    try {
                        if (GcsGroupNetworkUtils.checkNetworkConnection(GcsGroupPresenter.this.getContext(), GcsConstants.RequestType.Delete, false) && C6716p.m4809q().m4801j()) {
                            final String groupId = SesShareReadResolver.getInstance().getGroupId(str);
                            if (SesGroupReadResolver.getInstance().isLocalGroupType(groupId)) {
                                AbstractC0272x.m550a().requestGroupDeletion(groupId, new GroupApi.GroupResultCallback<BooleanResult>() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.SesShareApiTask.3.1
                                    @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
                                    public void onResult(BooleanResult booleanResult) {
                                        MainLogger.m7258i(GcsGroupPresenter.TAG, "requestGroupDelete(). onResult() : " + booleanResult.getResult());
                                        if (booleanResult.getResult()) {
                                            SesShareApiTask.this.deleteLocalSharedSdoc(DeleteLocalSharedSdocTask.DeleteType.GROUP, groupId);
                                        } else {
                                            GcsGroupNetworkUtils.showUnknownFailToast(GcsGroupPresenter.this.getContext(), GcsConstants.RequestType.Delete, false);
                                        }
                                    }
                                });
                                return;
                            }
                            String str2 = str;
                            ShareApi.SpaceDeletionResultCallback spaceDeletionResultCallback = new ShareApi.SpaceDeletionResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.SesShareApiTask.3.2
                                @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceDeletionResultCallback
                                public void onResult(BooleanResult booleanResult) {
                                    MainLogger.m7258i(GcsGroupPresenter.TAG, "requestSpaceDelete(). onResult() : " + booleanResult.getResult());
                                    if (!booleanResult.getResult()) {
                                        GcsGroupNetworkUtils.showUnknownFailToast(GcsGroupPresenter.this.getContext(), GcsConstants.RequestType.Delete, false);
                                    } else {
                                        RunnableC87203 runnableC87203 = RunnableC87203.this;
                                        SesShareApiTask.this.deleteLocalSharedSdoc(DeleteLocalSharedSdocTask.DeleteType.SPACE, str);
                                    }
                                }
                            };
                            if (C0145c.m333r(BaseUtils.getApplicationContext())) {
                                throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestSpaceDeletion failed - wifi only");
                            }
                            AbstractC0248O.m527a().requestSpaceDeletion(str2, spaceDeletionResultCallback);
                        }
                    } catch (Exception e) {
                        AbstractC14516b.m15115c(e, new StringBuilder("[CS1-2] requestSpaceDelete(). Exception "), GcsGroupPresenter.TAG);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestSpaceLeave(final String str) {
            new DataTask(GcsGroupPresenter.this.mIPresenterContract.getActivity()).run(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.SesShareApiTask.4
                @Override // java.lang.Runnable
                public void run() {
                    MainLogger.m7258i(GcsGroupPresenter.TAG, "requestSpaceLeave()");
                    try {
                        if (GcsGroupNetworkUtils.checkNetworkConnection(GcsGroupPresenter.this.getContext(), GcsConstants.RequestType.Leave, false) && C6716p.m4809q().m4801j()) {
                            String str2 = str;
                            GroupApi.GroupResultCallback<BooleanResult> groupResultCallback = new GroupApi.GroupResultCallback<BooleanResult>() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.SesShareApiTask.4.1
                                @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
                                public void onResult(BooleanResult booleanResult) {
                                    MainLogger.m7258i(GcsGroupPresenter.TAG, "requestSpaceLeave(). onResult() " + booleanResult.getResult());
                                    if (!booleanResult.getResult()) {
                                        GcsGroupNetworkUtils.showUnknownFailToast(GcsGroupPresenter.this.getContext(), GcsConstants.RequestType.Leave, false);
                                    } else {
                                        RunnableC87214 runnableC87214 = RunnableC87214.this;
                                        SesShareApiTask.this.deleteLocalSharedSdoc(DeleteLocalSharedSdocTask.DeleteType.GROUP, str);
                                    }
                                }
                            };
                            if (C0145c.m333r(BaseUtils.getApplicationContext())) {
                                throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestLeave failed - wifi only");
                            }
                            AbstractC0272x.m550a().requestLeave(str2, groupResultCallback);
                        }
                    } catch (Exception e) {
                        AbstractC14516b.m15115c(e, new StringBuilder("requestSpaceLeave(). Exception "), GcsGroupPresenter.TAG);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestSpaceUpdate(final String str, final String str2) {
            new DataTask(GcsGroupPresenter.this.mIPresenterContract.getActivity()).run(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.SesShareApiTask.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MainLogger.m7258i(GcsGroupPresenter.TAG, "updateSharedNotebooks()");
                        if (GcsGroupNetworkUtils.checkNetworkConnection(GcsGroupPresenter.this.getContext(), GcsConstants.RequestType.Rename, false) && C6716p.m4809q().m4801j()) {
                            if (CoeditUtils.isWiFiSyncOnlyAndNotWiFiConnected()) {
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.SesShareApiTask.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        GcsGroupPresenter.this.mIPresenterContract.showGoToSettingsDialog();
                                    }
                                });
                                return;
                            }
                            AbstractC0248O.m527a().requestSpaceUpdate(str, str2, "", new ShareApi.SpaceResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.SesShareApiTask.1.2
                                @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceResultCallback
                                public void onResult(SpaceResult spaceResult) {
                                    boolean z = spaceResult.getStatus().getCode() == 1;
                                    AbstractC6670b.m4739D("updateSharedNotebooks(). onResult() ", GcsGroupPresenter.TAG, z);
                                    if (z) {
                                        GcsGroupPresenter.this.updateSpaceList();
                                    } else {
                                        GcsGroupNetworkUtils.showUnknownFailToast(GcsGroupPresenter.this.getContext(), GcsConstants.RequestType.Rename, false);
                                    }
                                }
                            });
                        }
                    } catch (Exception e) {
                        AbstractC14516b.m15115c(e, new StringBuilder("[CS1-2] updateSharedNotebooks(). Exception "), GcsGroupPresenter.TAG);
                    }
                }
            });
        }
    }

    public GcsGroupPresenter(IPresenterContract iPresenterContract) {
        this.mIPresenterContract = iPresenterContract;
        GcsGroupDialogPresenter gcsGroupDialogPresenter = new GcsGroupDialogPresenter(this);
        this.mDialogPresenter = gcsGroupDialogPresenter;
        this.mSesShareApiTask = new SesShareApiTask();
        gcsGroupDialogPresenter.restoreInstance();
    }

    private void requestSpaceDelete(String str) {
        if (str == null || str.isEmpty()) {
            MainLogger.m7255e(TAG, "requestSpaceDelete(). spaceId is null or empty.");
        } else {
            this.mSesShareApiTask.requestSpaceDelete(str);
        }
    }

    private void requestSpaceLeave(String str) {
        if (str == null || str.isEmpty()) {
            MainLogger.m7255e(TAG, "requestSpaceLeave(). groupId is null or empty.");
        } else {
            this.mSesShareApiTask.requestSpaceLeave(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDisplayMessageToast(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                ToastHandler.show(GcsGroupPresenter.this.getContext(), str, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGroupMemberList(String str) {
        try {
            if (C6716p.m4809q().m4801j()) {
                AbstractC0272x.m557h(str);
            }
        } catch (Exception e) {
            AbstractC14516b.m15115c(e, new StringBuilder("updateSpaceList() Exception : "), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpaceList() {
        try {
            if (C6716p.m4809q().m4801j()) {
                ShareApi.SpaceListResultCallback spaceListResultCallback = new ShareApi.SpaceListResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.2
                    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceListResultCallback
                    public void onResult(SpaceListResult spaceListResult) {
                        boolean z = spaceListResult.getStatus().getCode() == 1;
                        boolean zM4801j = C6716p.m4809q().m4801j();
                        MainLogger.m7258i(GcsGroupPresenter.TAG, "updateSpaceList(). onResult() " + z + " isConnected " + zM4801j);
                        if (z && zM4801j) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    GcsGroupPresenter.this.mIPresenterContract.restartLoader();
                                }
                            });
                        }
                    }
                };
                if (C0145c.m333r(BaseUtils.getApplicationContext())) {
                    throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestSpaceList failed - wifi only");
                }
                AbstractC0248O.m527a().requestSpaceList(spaceListResultCallback);
            }
        } catch (Exception e) {
            AbstractC14516b.m15115c(e, new StringBuilder("[CS1-2] updateSpaceList() Exception : "), TAG);
        }
    }

    public void addSharedNotebooks() {
        this.mDialogPresenter.addSharedNotebooks();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupDialogPresenter.IGroupDialogContract
    public boolean checkInvalidSpace() {
        return TextUtils.isEmpty(this.mSelectedSpaceId) || TextUtils.isEmpty(this.mSelectedSpaceName);
    }

    public void createSharedNotebooks(String str) {
        if (TextUtils.isEmpty(str)) {
            MainLogger.m7258i(TAG, "createSharedNotebooks(). groupId is null or empty.");
        } else if (TextUtils.isEmpty(this.mSelectedSpaceName)) {
            MainLogger.m7255e(TAG, "createSharedNotebooks(). space name is null or empty.");
        } else {
            this.mSesShareApiTask.requestSpaceCreation(str);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupDialogPresenter.IGroupDialogContract
    public void deleteConfirm() {
        if (SesShareReadResolver.getInstance().isSpaceOwner(this.mSelectedSpaceId)) {
            requestSpaceDelete(this.mSelectedSpaceId);
        } else {
            requestSpaceLeave(SesShareReadResolver.getInstance().getGroupId(this.mSelectedSpaceId));
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupDialogPresenter.IGroupDialogContract
    public FragmentManager getChildFragmentManager() {
        return this.mIPresenterContract.getChildFragmentManager();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupDialogPresenter.IGroupDialogContract
    public Context getContext() {
        return this.mIPresenterContract.getContext();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupDialogPresenter.IGroupDialogContract
    public String getSelectedSpaceId() {
        return this.mSelectedSpaceId;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupDialogPresenter.IGroupDialogContract
    public String getSelectedSpaceName() {
        return this.mSelectedSpaceName;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupDialogPresenter.IGroupDialogContract
    public boolean isAdded() {
        return this.mIPresenterContract.isAdded();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupDialogPresenter.IGroupDialogContract
    public void launchSocialPicker(String str) {
        this.mIPresenterContract.launchSocialPicker(str);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("space_id", this.mSelectedSpaceId);
        bundle.putString("space_name", this.mSelectedSpaceName);
    }

    public void onloadInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        setSelectedInfo(bundle.getString("space_id"), bundle.getString("space_name"));
    }

    public void requestGroupCreation(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.mSesShareApiTask.requestGroupCreation(i, arrayList, arrayList2);
    }

    public void setSelectedInfo(String str, String str2) {
        this.mSelectedSpaceId = str;
        this.mSelectedSpaceName = str2;
    }

    public void showGroupEditMenuDialog(boolean z) {
        this.mDialogPresenter.showGroupEditMenuDialog(z);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupDialogPresenter.IGroupDialogContract
    public void updateSharedNotebooks(String str, String str2) {
        if (str2 == null || str2.length() < 1) {
            MainLogger.m7255e(TAG, "updateSharedNotebooks(). invalid spaceName.");
        } else {
            this.mSesShareApiTask.requestSpaceUpdate(str, str2);
        }
    }

    public void setSelectedInfo(String str) {
        this.mSelectedSpaceName = str;
    }
}
