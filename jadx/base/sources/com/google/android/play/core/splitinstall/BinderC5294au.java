package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import com.google.android.play.core.internal.AbstractBinderC5200bv;
import com.google.android.play.core.tasks.C5345i;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.au */
/* JADX INFO: loaded from: classes5.dex */
class BinderC5294au<T> extends AbstractBinderC5200bv {

    /* JADX INFO: renamed from: a */
    final C5345i<T> f3102a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5295av f3103b;

    public BinderC5294au(C5295av c5295av, C5345i<T> c5345i) {
        this.f3103b = c5295av;
        this.f3102a = c5345i;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5201bw
    /* JADX INFO: renamed from: a */
    public final void mo3959a() {
        this.f3103b.f3106a.m3896a();
        C5295av.f3104b.m3878c("onCompleteInstallForAppUpdate", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5201bw
    /* JADX INFO: renamed from: b */
    public final void mo3964b() {
        this.f3103b.f3106a.m3896a();
        C5295av.f3104b.m3878c("onGetSplitsForAppUpdate", new Object[0]);
    }

    /* JADX INFO: renamed from: c */
    public void mo3967c(int i, Bundle bundle) {
        this.f3103b.f3106a.m3896a();
        C5295av.f3104b.m3878c("onStartInstall(%d)", Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: d */
    public void mo3969d(Bundle bundle) {
        this.f3103b.f3106a.m3896a();
        C5295av.f3104b.m3878c("onDeferredUninstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5201bw
    /* JADX INFO: renamed from: e */
    public final void mo3970e(Bundle bundle) {
        this.f3103b.f3106a.m3896a();
        int i = bundle.getInt("error_code");
        C5295av.f3104b.m3877b("onError(%d)", Integer.valueOf(i));
        this.f3102a.m4200b(new SplitInstallException(i));
    }

    @Override // com.google.android.play.core.internal.InterfaceC5201bw
    /* JADX INFO: renamed from: a */
    public final void mo3960a(int i) {
        this.f3103b.f3106a.m3896a();
        C5295av.f3104b.m3878c("onCompleteInstall(%d)", Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: b */
    public void mo3965b(int i, Bundle bundle) {
        this.f3103b.f3106a.m3896a();
        C5295av.f3104b.m3878c("onGetSession(%d)", Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: c */
    public void mo3968c(Bundle bundle) {
        this.f3103b.f3106a.m3896a();
        C5295av.f3104b.m3878c("onDeferredLanguageUninstall", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public void mo3961a(int i, Bundle bundle) {
        this.f3103b.f3106a.m3896a();
        C5295av.f3104b.m3878c("onCancelInstall(%d)", Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: b */
    public void mo3966b(Bundle bundle) {
        this.f3103b.f3106a.m3896a();
        C5295av.f3104b.m3878c("onDeferredLanguageInstall", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public void mo3962a(Bundle bundle) {
        this.f3103b.f3106a.m3896a();
        C5295av.f3104b.m3878c("onDeferredInstall", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public void mo3963a(List<Bundle> list) {
        this.f3103b.f3106a.m3896a();
        C5295av.f3104b.m3878c("onGetSessionStates", new Object[0]);
    }
}
