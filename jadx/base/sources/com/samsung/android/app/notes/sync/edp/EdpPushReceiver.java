package com.samsung.android.app.notes.sync.edp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p211o0.C13567a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class EdpPushReceiver extends BroadcastReceiver {
    private static final String EDP_PUSH_ACTION_JOIN = "com.samsung.android.scpm.kps.JOIN_COMPLETED";
    private static final String EDP_PUSH_ACTION_LEAVE = "com.samsung.android.scpm.kps.LEAVE_COMPLETED";
    private static final String TAG = "EdpPushReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Debugger.m8615i(TAG, "[EDP] onReceive()");
        if (context == null) {
            Debugger.m8609e(TAG, "[EDP] onReceive() : Invalid context");
            return;
        }
        if (intent == null) {
            Debugger.m8609e(TAG, "[EDP] onReceive() : intent is null!");
            return;
        }
        String action = intent.getAction();
        if (EDP_PUSH_ACTION_JOIN.equals(action)) {
            Debugger.m8615i(TAG, "[EDP] onReceive() : Joined!");
            C13567a.m14371a().m14374e(NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON);
        } else if (EDP_PUSH_ACTION_LEAVE.equals(action)) {
            Debugger.m8615i(TAG, "[EDP] onReceive() : Leaved!");
            C13567a.m14371a().m14374e(NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_OFF);
        } else {
            Debugger.m8609e(TAG, "[EDP] onReceive() : invalid action = " + action);
        }
    }
}
