package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.listener.AbstractC5244b;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.r */
/* JADX INFO: loaded from: classes5.dex */
final class C5317r implements InterfaceC5302d {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ SplitInstallSessionState f3142a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ Intent f3143b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ Context f3144c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ C5319t f3145d;

    public C5317r(C5319t c5319t, SplitInstallSessionState splitInstallSessionState, Intent intent, Context context) {
        this.f3145d = c5319t;
        this.f3142a = splitInstallSessionState;
        this.f3143b = intent;
        this.f3144c = context;
    }

    @Override // com.google.android.play.core.splitinstall.InterfaceC5302d
    /* JADX INFO: renamed from: a */
    public final void mo4131a() {
        C5319t c5319t = this.f3145d;
        c5319t.f3151d.post(new RunnableC5318s(c5319t, this.f3142a, 5, 0));
    }

    @Override // com.google.android.play.core.splitinstall.InterfaceC5302d
    /* JADX INFO: renamed from: b */
    public final void mo4133b() {
        if (this.f3143b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            ((AbstractC5244b) this.f3145d).f2996a.m3877b("Splits copied and verified more than once.", new Object[0]);
        } else {
            this.f3143b.putExtra("triggered_from_app_after_verification", true);
            this.f3144c.sendBroadcast(this.f3143b);
        }
    }

    @Override // com.google.android.play.core.splitinstall.InterfaceC5302d
    /* JADX INFO: renamed from: a */
    public final void mo4132a(@SplitInstallErrorCode int i) {
        C5319t c5319t = this.f3145d;
        c5319t.f3151d.post(new RunnableC5318s(c5319t, this.f3142a, 6, i));
    }
}
