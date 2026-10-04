package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.an */
/* JADX INFO: loaded from: classes5.dex */
final class BinderC5030an extends BinderC5027ak<Void> {

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5034ar f2550c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderC5030an(C5034ar c5034ar, C5345i<Void> c5345i) {
        super(c5034ar, c5345i);
        this.f2550c = c5034ar;
    }

    @Override // com.google.android.play.core.assetpacks.BinderC5027ak, com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: a */
    public final void mo3636a(Bundle bundle, Bundle bundle2) {
        super.mo3636a(bundle, bundle2);
        if (!this.f2550c.f2565g.compareAndSet(true, false)) {
            C5034ar.f2559a.m3879d("Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.f2550c.mo3667a();
        }
    }
}
