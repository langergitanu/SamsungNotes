package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.ap */
/* JADX INFO: loaded from: classes5.dex */
final class BinderC5032ap extends BinderC5027ak<AssetPackStates> {

    /* JADX INFO: renamed from: c */
    private final C5069bz f2555c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC5042az f2556d;

    public BinderC5032ap(C5034ar c5034ar, C5345i<AssetPackStates> c5345i, C5069bz c5069bz, InterfaceC5042az interfaceC5042az) {
        super(c5034ar, c5345i);
        this.f2555c = c5069bz;
        this.f2556d = interfaceC5042az;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.play.core.assetpacks.BinderC5027ak, com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: c */
    public final void mo3643c(Bundle bundle, Bundle bundle2) {
        super.mo3643c(bundle, bundle2);
        this.f2547a.m4201b((T) AssetPackStates.m3627a(bundle, this.f2555c, this.f2556d));
    }
}
