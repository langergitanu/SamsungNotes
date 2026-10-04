package com.google.android.play.core.appupdate;

import android.os.Bundle;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.n */
/* JADX INFO: loaded from: classes5.dex */
final class BinderC5004n extends BinderC5003m<Void> {
    public BinderC5004n(C5006p c5006p, C5345i<Void> c5345i) {
        super(c5006p, new C5157af("OnCompleteUpdateCallback"), c5345i);
    }

    @Override // com.google.android.play.core.appupdate.BinderC5003m, com.google.android.play.core.internal.InterfaceC5232p
    /* JADX INFO: renamed from: b */
    public final void mo3597b(Bundle bundle) {
        super.mo3597b(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f2444b.m4200b(new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.f2444b.m4201b((Object) null);
        }
    }
}
