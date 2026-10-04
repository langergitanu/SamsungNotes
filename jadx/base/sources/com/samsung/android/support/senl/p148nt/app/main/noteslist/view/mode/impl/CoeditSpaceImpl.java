package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface CoeditSpaceImpl {
    void deleteStandaloneSpace(List<String> list, List<String> list2);

    void handleMeetJoinAction();

    boolean isEnabledStatus();

    void launchSocialPickerForNewStandaloneNote(int i);

    boolean onGroupInvitationReceived();

    void onInvitationAccepted(String str, String str2);

    void onInvitationDeclined(String str);

    boolean onSpaceLongPressed(String str, String str2);

    void onSpaceSelected(String str, String str2);
}
