package com.samsung.android.support.senl.p148nt.app.main.invitation.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.group.GroupApi;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationListResult;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.invitation.adapter.AdapterContract;
import com.samsung.android.support.senl.p148nt.app.main.invitation.adapter.GcsInvitationAdapter;
import com.samsung.android.support.senl.p148nt.app.main.invitation.presenter.ViewContract;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import p042J1.C0145c;
import p075S.AbstractC0272x;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsInvitationPresenter {
    private static final String TAG = "GcsInvitationPresenter";
    private final GcsInvitationAdapter mAdapter;
    private final Context mContext;
    private final ViewContract.IRecyclerView mRecyclerView;
    private final ViewContract.IView mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GroupCallback implements GroupApi.GroupResultCallback<GroupInvitationListResult> {
        private WeakReference<GcsInvitationPresenter> mPresenter;

        public GroupCallback(GcsInvitationPresenter gcsInvitationPresenter) {
            this.mPresenter = new WeakReference<>(gcsInvitationPresenter);
        }

        @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
        public void onResult(GroupInvitationListResult groupInvitationListResult) {
            this.mPresenter.get().initInvitationList(groupInvitationListResult);
            this.mPresenter = null;
        }
    }

    public GcsInvitationPresenter(Context context, ViewContract.IView iView, ViewContract.IRecyclerView iRecyclerView) {
        this.mContext = context;
        this.mView = iView;
        this.mRecyclerView = iRecyclerView;
        this.mAdapter = new GcsInvitationAdapter(context, new AdapterContract.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.presenter.GcsInvitationPresenter.1
            @Override // com.samsung.android.support.senl.nt.app.main.invitation.adapter.AdapterContract.IPresenter
            public void onItemSelected(int i, GroupInvitationListResult.GroupInvitation groupInvitation) {
                GcsInvitationPresenter.this.onItemSelected(i, groupInvitation);
            }
        });
    }

    private boolean checkNetworkConnection() {
        if (C0145c.m334s(this.mContext)) {
            return true;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.presenter.GcsInvitationPresenter.6
            @Override // java.lang.Runnable
            public void run() {
                ToastHandler.show(GcsInvitationPresenter.this.mContext, C8003R.string.gcs_invitations_network_fail, 1);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initInvitationList(GroupInvitationListResult groupInvitationListResult) {
        MainLogger.m7258i(TAG, "initInvitationList()");
        List<GroupInvitationListResult.GroupInvitation> invitationList = groupInvitationListResult.getInvitationList();
        ArrayList arrayList = new ArrayList();
        if (invitationList != null) {
            for (GroupInvitationListResult.GroupInvitation groupInvitation : invitationList) {
                String groupId = groupInvitation.getGroupId();
                if (groupId != null && groupId.startsWith("UNM")) {
                    arrayList.add(groupInvitation);
                }
            }
        }
        this.mAdapter.setInvitationList(arrayList);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.presenter.GcsInvitationPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                GcsInvitationPresenter.this.mAdapter.notifyDataSetChanged();
                GcsInvitationPresenter.this.mView.setNoInvitationViewVisibility(GcsInvitationPresenter.this.mAdapter.getItemCount() == 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemSelected(int i, GroupInvitationListResult.GroupInvitation groupInvitation) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Default;
        if (UserInputSkipper.isValidSingleActionEvent(false, tag)) {
            UserInputSkipper.setHoldingSingleActionEventTime(1000L, tag);
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_INVITATIONS, NotesSAConstants.EVENT_GCS_INVITATIONS_VIEW_INVITATIONS);
            this.mView.showInvitationJoinDialog(i, groupInvitation.getGroupId());
        }
    }

    private void showWifiSyncOnlyToast(ShareException shareException) {
        if (shareException.getExceptionCode() == ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.presenter.GcsInvitationPresenter.5
                @Override // java.lang.Runnable
                public void run() {
                    ToastHandler.show(GcsInvitationPresenter.this.mContext, C8003R.string.sync_network_dialog_wifi_not_available_body, 1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInviteList(int i) {
        this.mAdapter.removeInvitationItemByPosition(i);
        this.mAdapter.notifyItemRemoved(i);
        this.mView.setNoInvitationViewVisibility(this.mAdapter.getItemCount() == 0);
    }

    public int getInvitationsCount() {
        return this.mAdapter.getItemCount();
    }

    public void initializeListAdapter() {
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    public void requestInvitationAcceptance(final int i, String str) {
        try {
            if (checkNetworkConnection() && C6716p.m4809q().m4801j()) {
                AbstractC0272x.m554e(str, new GroupApi.GroupResultCallback<BooleanResult>() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.presenter.GcsInvitationPresenter.3
                    @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
                    public void onResult(BooleanResult booleanResult) {
                        final boolean result = booleanResult.getResult();
                        MainLogger.m7258i(GcsInvitationPresenter.TAG, "requestInvitationAcceptance() onResult " + result);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.presenter.GcsInvitationPresenter.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (result) {
                                    ToastHandler.show(GcsInvitationPresenter.this.mContext, C8003R.string.gcs_invitations_success_message, 1);
                                } else {
                                    ToastHandler.show(GcsInvitationPresenter.this.mContext, C8003R.string.gcs_invitations_already_expired, 1);
                                }
                                C83103 c83103 = C83103.this;
                                GcsInvitationPresenter.this.updateInviteList(i);
                            }
                        });
                    }
                });
            }
        } catch (ShareException e) {
            showWifiSyncOnlyToast(e);
        } catch (Exception e2) {
            AbstractC14516b.m15115c(e2, new StringBuilder("requestInvitationAcceptance() Exception : "), TAG);
        }
    }

    public void requestInvitationList() {
        int iRequestMyInvitationList = -1;
        try {
            if (checkNetworkConnection() && C6716p.m4809q().m4801j()) {
                iRequestMyInvitationList = AbstractC0272x.m550a().requestMyInvitationList(new GroupCallback(this));
            } else {
                MainLogger.m7255e(TAG, "[CS2-2] requestInvitationList() invalid connection!");
            }
        } catch (Exception e) {
            AbstractC14516b.m15115c(e, new StringBuilder("requestInvitationList() Exception : "), TAG);
        }
        if (iRequestMyInvitationList != 1) {
            MainLogger.m7258i(TAG, "[CS2-2] requestInvitationList() Failed to request my invitation list.");
            this.mView.setNoInvitationViewVisibility(true);
        }
    }

    public void requestInvitationRejection(final int i, String str) {
        try {
            if (checkNetworkConnection() && C6716p.m4809q().m4801j()) {
                AbstractC0272x.m556g(str, new GroupApi.GroupResultCallback<BooleanResult>() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.presenter.GcsInvitationPresenter.4
                    @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
                    public void onResult(BooleanResult booleanResult) {
                        boolean result = booleanResult.getResult();
                        AbstractC6670b.m4739D("requestInvitationRejection() onResult ", GcsInvitationPresenter.TAG, result);
                        if (result) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.presenter.GcsInvitationPresenter.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    C83114 c83114 = C83114.this;
                                    GcsInvitationPresenter.this.updateInviteList(i);
                                }
                            });
                        }
                    }
                });
            }
        } catch (ShareException e) {
            showWifiSyncOnlyToast(e);
        } catch (Exception e2) {
            AbstractC14516b.m15115c(e2, new StringBuilder("requestInvitationRejection() Exception : "), TAG);
        }
    }
}
