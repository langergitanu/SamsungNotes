package com.samsung.android.support.senl.p148nt.app.main.invitation.adapter;

import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationListResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface AdapterContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void onItemSelected(int i, GroupInvitationListResult.GroupInvitation groupInvitation);
    }
}
