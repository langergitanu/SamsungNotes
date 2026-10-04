package com.samsung.android.app.notes.sync.synchronization.core.tasks;

import android.content.Context;
import android.os.SystemClock;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p012C1.C0052h;
import p234q1.C14433b;
import p253w1.InterfaceC14510a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RecoveryTask extends SyncBaseTask {
    private static final String TAG = "SyncProcessTask";
    private InterfaceC14510a mSyncTaskContact;

    public RecoveryTask(Context context, String str, InterfaceC6897a interfaceC6897a) {
        super(context, str, interfaceC6897a, 1);
        this.mSyncTaskContact = new C14433b(this, 10);
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.core.tasks.SyncBaseTask
    public int syncProgress() {
        Debugger.m8615i(TAG, "Start syncProgress()[" + hashCode() + "] SyncMsgType = " + this.mSyncRequestInfo.f322a);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int iPerformPreJobs = performPreJobs();
        if (iPerformPreJobs != 0) {
            return iPerformPreJobs;
        }
        printCurrentInfo();
        new C0052h(this.mSyncInfoSDocx, this.mSyncOperationSDocx, this.mSyncOperationSDoc, this.mSyncTaskContact, this.mSyncProgressListener).m100i(true);
        Debugger.m8615i(TAG, "Finish syncProgress()[" + hashCode() + "] : et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return 0;
    }
}
