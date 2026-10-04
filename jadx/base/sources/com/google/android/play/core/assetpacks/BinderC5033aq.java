package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C5345i;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.aq */
/* JADX INFO: loaded from: classes5.dex */
final class BinderC5033aq extends BinderC5027ak<AssetPackStates> {

    /* JADX INFO: renamed from: c */
    private final List<String> f2557c;

    /* JADX INFO: renamed from: d */
    private final C5069bz f2558d;

    public BinderC5033aq(C5034ar c5034ar, C5345i<AssetPackStates> c5345i, C5069bz c5069bz, List<String> list) {
        super(c5034ar, c5345i);
        this.f2558d = c5069bz;
        this.f2557c = list;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.play.core.assetpacks.BinderC5027ak, com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: a */
    public final void mo3634a(int i, Bundle bundle) {
        super.mo3634a(i, bundle);
        this.f2547a.m4201b((T) AssetPackStates.m3628a(bundle, this.f2558d, this.f2557c));
    }
}
