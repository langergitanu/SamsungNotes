package com.samsung.android.support.senl.p148nt.app.main.invitation.presenter;

import com.samsung.android.support.senl.p148nt.app.main.invitation.adapter.GcsInvitationAdapter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface ViewContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IRecyclerView {
        void setAdapter(GcsInvitationAdapter gcsInvitationAdapter);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        void setNoInvitationViewVisibility(boolean z);

        void showInvitationJoinDialog(int i, String str);
    }
}
