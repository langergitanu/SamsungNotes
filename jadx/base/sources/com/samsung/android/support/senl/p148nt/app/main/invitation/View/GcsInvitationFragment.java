package com.samsung.android.support.senl.p148nt.app.main.invitation.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.appbar.AppBarLayout;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.contentsharing.sessession.SesInviteReceivedReceiver;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.GcsInvitationMenuBadgeUpdater;
import com.samsung.android.support.senl.p148nt.app.common.listener.OffsetUpdateListener;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.invitation.View.dialog.InvitationJoinDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.invitation.adapter.GcsInvitationAdapter;
import com.samsung.android.support.senl.p148nt.app.main.invitation.presenter.GcsInvitationPresenter;
import com.samsung.android.support.senl.p148nt.app.main.invitation.presenter.ViewContract;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsInvitationFragment extends Fragment {
    public static final String TAG = "GcsInvitationFragment";
    private InvitationJoinDialogFragment mInvitationJoinDialog;
    private PenRecyclerView mInvitationList;
    private TextView mNoInviteView;
    private GcsInvitationPresenter mPresenter;
    private final InvitationJoinDialogFragment.IInvitationJoinDialogResultListener mInvitationJoinDialogResultListener = new InvitationJoinDialogFragment.IInvitationJoinDialogResultListener() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.View.GcsInvitationFragment.1
        @Override // com.samsung.android.support.senl.nt.app.main.invitation.View.dialog.InvitationJoinDialogFragment.IInvitationJoinDialogResultListener
        public void onAccept(int i, String str) {
            GcsInvitationFragment.this.mPresenter.requestInvitationAcceptance(i, str);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.invitation.View.dialog.InvitationJoinDialogFragment.IInvitationJoinDialogResultListener
        public void onDecline(int i, String str) {
            GcsInvitationFragment.this.mPresenter.requestInvitationRejection(i, str);
        }
    };
    private final SesInviteReceivedReceiver receivedReceiver = new SesInviteReceivedReceiver() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.View.GcsInvitationFragment.2
        @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.SesInviteReceivedReceiver
        public void onGroupInvitationReceived() {
            MainLogger.m7258i(GcsInvitationFragment.TAG, "[CS2] onGcsInvitationReceived");
            GcsInvitationFragment.this.onGcsInvitationReceived();
        }
    };

    private void initInvitationJoinDialog() {
        InvitationJoinDialogFragment invitationJoinDialogFragment = new InvitationJoinDialogFragment();
        this.mInvitationJoinDialog = invitationJoinDialogFragment;
        invitationJoinDialogFragment.setOnResultListener(this.mInvitationJoinDialogResultListener);
    }

    private void initLayout() {
        this.mNoInviteView = (TextView) getActivity().findViewById(C8003R.id.nonote);
        AppBarLayout appBarLayout = (AppBarLayout) getActivity().findViewById(C8003R.id.appbar_layout);
        if (appBarLayout != null) {
            OffsetUpdateListener offsetUpdateListener = new OffsetUpdateListener(getContext());
            offsetUpdateListener.setVerticalView(this.mNoInviteView);
            appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) offsetUpdateListener);
        }
        PenRecyclerView penRecyclerView = (PenRecyclerView) getActivity().findViewById(C8003R.id.recyclerview_invitationlist);
        this.mInvitationList = penRecyclerView;
        penRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()), 1);
        this.mInvitationList.seslSetGoToTopEnabled(true);
        this.mPresenter.initializeListAdapter();
        setNoInvitationViewVisibility(this.mPresenter.getInvitationsCount() == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGcsInvitationReceived() {
        this.mPresenter.requestInvitationList();
    }

    private void onRestoreInstanceState() {
        InvitationJoinDialogFragment invitationJoinDialogFragment = (InvitationJoinDialogFragment) getChildFragmentManager().findFragmentByTag(InvitationJoinDialogFragment.TAG);
        if (invitationJoinDialogFragment != null) {
            invitationJoinDialogFragment.setOnResultListener(this.mInvitationJoinDialogResultListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNoInvitationViewVisibility(boolean z) {
        if (this.mNoInviteView == null) {
            return;
        }
        AbstractC6670b.m4739D("setNoInvitationViewVisibility ", TAG, z);
        if (z) {
            this.mNoInviteView.setVisibility(0);
        } else {
            this.mNoInviteView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInvitationJoinDialog(int i, String str) {
        if (this.mInvitationJoinDialog == null) {
            initInvitationJoinDialog();
        }
        if (this.mInvitationJoinDialog.isAdded()) {
            return;
        }
        MainLogger.m7258i(TAG, "showInvitationJoinDialog()");
        try {
            this.mInvitationJoinDialog.setGroupId(i, str);
            this.mInvitationJoinDialog.showAllowingStateLoss(getChildFragmentManager(), InvitationJoinDialogFragment.TAG);
        } catch (IllegalStateException e) {
            MainLogger.m7255e(TAG, "IllegalStateException :" + e.getMessage());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        initLayout();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mPresenter = new GcsInvitationPresenter(getContext(), new ViewContract.IView() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.View.GcsInvitationFragment.3
            @Override // com.samsung.android.support.senl.nt.app.main.invitation.presenter.ViewContract.IView
            public void setNoInvitationViewVisibility(boolean z) {
                GcsInvitationFragment.this.setNoInvitationViewVisibility(z);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.invitation.presenter.ViewContract.IView
            public void showInvitationJoinDialog(int i, String str) {
                GcsInvitationFragment.this.showInvitationJoinDialog(i, str);
            }
        }, new ViewContract.IRecyclerView() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.View.GcsInvitationFragment.4
            @Override // com.samsung.android.support.senl.nt.app.main.invitation.presenter.ViewContract.IRecyclerView
            public void setAdapter(GcsInvitationAdapter gcsInvitationAdapter) {
                GcsInvitationFragment.this.mInvitationList.setAdapter(gcsInvitationAdapter);
            }
        });
        onRestoreInstanceState();
        SesInviteReceivedReceiver.registerReceiver(getContext(), this.receivedReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(C8003R.layout.gcs_invitation_list_fragment, (ViewGroup) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        GcsInvitationMenuBadgeUpdater.setInvitationListHasBadgePref(false);
        if (getContext() != null) {
            SesInviteReceivedReceiver.unregisterReceiver(getContext(), this.receivedReceiver);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        GcsInvitationMenuBadgeUpdater.setInvitationListHasBadgePref(false);
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_INVITATIONS);
    }

    public void onSesSessionConnected() {
        this.mPresenter.requestInvitationList();
    }
}
