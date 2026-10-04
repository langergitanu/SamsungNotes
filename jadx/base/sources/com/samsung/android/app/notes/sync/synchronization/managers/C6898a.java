package com.samsung.android.app.notes.sync.synchronization.managers;

import android.content.ContentResolver;
import android.content.SyncStatusObserver;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import p044K.C0158a;
import p244u1.C14477a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.managers.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6898a {

    /* JADX INFO: renamed from: d */
    public static C6898a f4462d;

    /* JADX INFO: renamed from: a */
    public int f4463a;

    /* JADX INFO: renamed from: b */
    public Object f4464b;

    /* JADX INFO: renamed from: c */
    public final SyncStatusObserver f4465c = new SyncStatusObserver() { // from class: com.samsung.android.app.notes.sync.synchronization.managers.MasterSyncManager$1
        @Override // android.content.SyncStatusObserver
        public void onStatusChanged(int i) {
            C6898a c6898a = this.this$0;
            c6898a.getClass();
            int i2 = ContentResolver.getMasterSyncAutomatically() ? 1 : 2;
            if (c6898a.f4463a == i2) {
                Debugger.m8607d("MasterSyncManager", "onStatusUpdated() : No change!");
                return;
            }
            c6898a.f4463a = i2;
            Debugger.m8615i("MasterSyncManager", "onStatusUpdated() : ".concat(i2 == 1 ? "On" : "Off"));
            if (c6898a.f4463a != 2) {
                if (C0158a.m407a().m413c()) {
                    C14477a.m15065b().m15071g("requestSyncBackground by masterSync");
                }
            } else if (DeviceUtils.isSupportedSync(C0158a.m407a().f492a)) {
                Debugger.m8615i("MasterSyncManager", "StopSync by masterSync");
                C14477a.m15065b().m15076l(104);
            }
        }
    };
}
