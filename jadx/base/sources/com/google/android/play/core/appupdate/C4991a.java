package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.listener.AbstractC5244b;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.a */
/* JADX INFO: loaded from: classes5.dex */
public final class C4991a extends AbstractC5244b<InstallState> {
    public C4991a(Context context) {
        super(new C5157af("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    @Override // com.google.android.play.core.listener.AbstractC5244b
    /* JADX INFO: renamed from: a */
    public final void mo3590a(Context context, Intent intent) {
        if (!context.getPackageName().equals(intent.getStringExtra("package.name"))) {
            this.f2996a.m3875a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent.getStringExtra("package.name"));
            return;
        }
        this.f2996a.m3875a("List of extras in received intent:", new Object[0]);
        for (String str : intent.getExtras().keySet()) {
            this.f2996a.m3875a("Key: %s; value: %s", str, intent.getExtras().get(str));
        }
        C5157af c5157af = this.f2996a;
        c5157af.m3875a("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
        c5157af.m3875a("Key: %s; value: %s", "install.status", Integer.valueOf(intent.getIntExtra("install.status", 0)));
        c5157af.m3875a("Key: %s; value: %s", "error.code", Integer.valueOf(intent.getIntExtra("error.code", 0)));
        InstallState installStateM3862a = InstallState.m3862a(intent.getIntExtra("install.status", 0), intent.getLongExtra("bytes.downloaded", 0L), intent.getLongExtra("total.bytes.to.download", 0L), intent.getIntExtra("error.code", 0), intent.getStringExtra("package.name"));
        this.f2996a.m3875a("ListenerRegistryBroadcastReceiver.onReceive: %s", installStateM3862a);
        m4034a(installStateM3862a);
    }
}
