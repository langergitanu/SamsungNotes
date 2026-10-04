package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.o */
/* JADX INFO: loaded from: classes5.dex */
final class BinderC5005o extends BinderC5003m<AppUpdateInfo> {

    /* JADX INFO: renamed from: d */
    final /* synthetic */ C5006p f2446d;

    /* JADX INFO: renamed from: e */
    private final String f2447e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderC5005o(C5006p c5006p, C5345i<AppUpdateInfo> c5345i, String str) {
        super(c5006p, new C5157af("OnRequestInstallCallback"), c5345i);
        this.f2446d = c5006p;
        this.f2447e = str;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.play.core.appupdate.BinderC5003m, com.google.android.play.core.internal.InterfaceC5232p
    /* JADX INFO: renamed from: a */
    public final void mo3596a(Bundle bundle) {
        super.mo3596a(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f2444b.m4200b(new InstallException(bundle.getInt("error.code", -2)));
            return;
        }
        this.f2444b.m4201b((T) AppUpdateInfo.m3581a(this.f2447e, bundle.getInt("version.code", -1), bundle.getInt("update.availability"), bundle.getInt("install.status", 0), bundle.getInt("client.version.staleness", -1) == -1 ? null : Integer.valueOf(bundle.getInt("client.version.staleness")), bundle.getInt("in.app.update.priority", 0), bundle.getLong("bytes.downloaded"), bundle.getLong("total.bytes.to.download"), bundle.getLong("additional.size.required"), this.f2446d.f2453f.m3609a(), (PendingIntent) bundle.getParcelable("blocking.intent"), (PendingIntent) bundle.getParcelable("nonblocking.intent"), (PendingIntent) bundle.getParcelable("blocking.destructive.intent"), (PendingIntent) bundle.getParcelable("nonblocking.destructive.intent")));
    }
}
