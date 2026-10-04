package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C5345i;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.am */
/* JADX INFO: loaded from: classes5.dex */
final class BinderC5029am extends BinderC5027ak<List<String>> {

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5034ar f2549c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderC5029am(C5034ar c5034ar, C5345i<List<String>> c5345i) {
        super(c5034ar, c5345i);
        this.f2549c = c5034ar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.play.core.assetpacks.BinderC5027ak, com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: a */
    public final void mo3637a(List<Bundle> list) {
        super.mo3637a(list);
        this.f2547a.m4201b((T) C5034ar.m3647a(this.f2549c, list));
    }
}
