package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: renamed from: com.google.android.play.core.internal.ao */
/* JADX INFO: loaded from: classes5.dex */
final class ServiceConnectionC5166ao implements ServiceConnection {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C5167ap f2942a;

    public /* synthetic */ ServiceConnectionC5166ao(C5167ap c5167ap) {
        this.f2942a = c5167ap;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2942a.f2945c.m3878c("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f2942a.m3886b(new C5164am(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f2942a.f2945c.m3878c("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f2942a.m3886b(new C5165an(this));
    }
}
