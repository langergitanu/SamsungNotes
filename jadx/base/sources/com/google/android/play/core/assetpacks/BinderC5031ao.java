package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.ao */
/* JADX INFO: loaded from: classes5.dex */
final class BinderC5031ao extends BinderC5027ak<Void> {

    /* JADX INFO: renamed from: c */
    final int f2551c;

    /* JADX INFO: renamed from: d */
    final String f2552d;

    /* JADX INFO: renamed from: e */
    final int f2553e;

    /* JADX INFO: renamed from: f */
    final /* synthetic */ C5034ar f2554f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderC5031ao(C5034ar c5034ar, C5345i<Void> c5345i, int i, String str, int i2) {
        super(c5034ar, c5345i);
        this.f2554f = c5034ar;
        this.f2551c = i;
        this.f2552d = str;
        this.f2553e = i2;
    }

    @Override // com.google.android.play.core.assetpacks.BinderC5027ak, com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: a */
    public final void mo3635a(Bundle bundle) {
        this.f2554f.f2563e.m3896a();
        C5034ar.f2559a.m3877b("onError(%d), retrying notifyModuleCompleted...", Integer.valueOf(bundle.getInt("error_code")));
        int i = this.f2553e;
        if (i > 0) {
            this.f2554f.m3648a(this.f2551c, this.f2552d, i - 1);
        }
    }
}
