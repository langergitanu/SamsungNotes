package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import com.google.android.play.core.tasks.C5345i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.as */
/* JADX INFO: loaded from: classes5.dex */
final class BinderC5292as extends BinderC5294au<List<SplitInstallSessionState>> {
    public BinderC5292as(C5295av c5295av, C5345i<List<SplitInstallSessionState>> c5345i) {
        super(c5295av, c5345i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.play.core.splitinstall.BinderC5294au, com.google.android.play.core.internal.InterfaceC5201bw
    /* JADX INFO: renamed from: a */
    public final void mo3963a(List<Bundle> list) {
        super.mo3963a(list);
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(SplitInstallSessionState.m4103a(list.get(i)));
        }
        this.f3102a.m4201b((T) arrayList);
    }
}
