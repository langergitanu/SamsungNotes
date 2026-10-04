package com.samsung.android.support.senl.p148nt.app.main.common.coedit;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationListResult;
import com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface CoeditSessionConnector {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ActionResult {
        void onFail();

        void onSuccess();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ActivityContract {
        void finishActivity();

        FragmentActivity getActivity();

        void launchActivity(Intent intent, NotesActivityResultCallback notesActivityResultCallback);

        void onSessionConnected(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CoeditCreateResult {
        void onFail();

        void onSuccess(String str, String str2, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InvitationResult {
        void onResult(List<GroupInvitationListResult.GroupInvitation> list);
    }

    boolean connect();

    void disconnect();

    boolean isConnected();

    boolean isLatestNotesVersion();

    boolean isStorageFull();

    void launchSocialPicker(CoeditPickerInfo coeditPickerInfo);

    void releaseSpaceDeleteActionResult();

    void requestInvitationAccept(String str, boolean z, CoeditCreateResult coeditCreateResult);

    void requestInvitationDecline(String str);

    void requestInvitationList(InvitationResult invitationResult);

    void requestMember();

    void requestMember(String str);

    void requestMemberRemove(String str, String str2);

    void requestOldSharedNotebooks(ActionResult actionResult);

    void requestSpace(String str);

    void requestSpaceCreateWithLink(CoeditPickerInfo coeditPickerInfo);

    boolean requestSpaceDelete(String str, String str2, boolean z, ActionResult actionResult, String str3, long j);

    boolean requestSpaceLeave(String str, String str2, ActionResult actionResult);

    void requestSpaceLeaveAfterLeaderAssignSuccess(String str, String str2, ActionResult actionResult);

    void requestSpaceMove(String str, String str2, boolean z);

    void requestSpaceUpdate(String str, String str2, ActionResult actionResult);

    void requestSync();

    void requestSync(ActionResult actionResult);
}
