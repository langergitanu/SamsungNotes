package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.ar */
/* JADX INFO: loaded from: classes5.dex */
final class BinderC5291ar extends BinderC5294au<SplitInstallSessionState> {
    public BinderC5291ar(C5295av c5295av, C5345i<SplitInstallSessionState> c5345i) {
        super(c5295av, c5345i);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.play.core.splitinstall.BinderC5294au, com.google.android.play.core.internal.InterfaceC5201bw
    /* JADX INFO: renamed from: b */
    public final void mo3965b(int i, Bundle bundle) {
        super.mo3965b(i, bundle);
        this.f3102a.m4201b((T) SplitInstallSessionState.m4103a(bundle));
    }
}
