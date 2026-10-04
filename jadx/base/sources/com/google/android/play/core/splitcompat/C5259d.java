package com.google.android.play.core.splitcompat;

import java.io.File;

/* JADX INFO: renamed from: com.google.android.play.core.splitcompat.d */
/* JADX INFO: loaded from: classes5.dex */
final class C5259d implements InterfaceC5264i {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C5260e f3034a;

    public C5259d(C5260e c5260e) {
        this.f3034a = c5260e;
    }

    @Override // com.google.android.play.core.splitcompat.InterfaceC5264i
    /* JADX INFO: renamed from: a */
    public final void mo4087a(C5265j c5265j, File file, boolean z) {
        this.f3034a.f3036b.add(file);
        if (z) {
            return;
        }
        this.f3034a.f3037c.set(false);
    }
}
