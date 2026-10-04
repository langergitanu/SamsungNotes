package com.google.android.play.core.splitinstall.testing;

import android.content.Intent;
import com.google.android.play.core.splitinstall.InterfaceC5302d;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.testing.i */
/* JADX INFO: loaded from: classes5.dex */
final class C5328i implements InterfaceC5302d {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ List f3194a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ List f3195b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ long f3196c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ boolean f3197d;

    /* JADX INFO: renamed from: e */
    final /* synthetic */ List f3198e;

    /* JADX INFO: renamed from: f */
    final /* synthetic */ FakeSplitInstallManager f3199f;

    public C5328i(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2, long j, boolean z, List list3) {
        this.f3199f = fakeSplitInstallManager;
        this.f3194a = list;
        this.f3195b = list2;
        this.f3196c = j;
        this.f3197d = z;
        this.f3198e = list3;
    }

    @Override // com.google.android.play.core.splitinstall.InterfaceC5302d
    /* JADX INFO: renamed from: a */
    public final void mo4131a() {
        this.f3199f.f3164l.addAll(this.f3194a);
        this.f3199f.f3165m.addAll(this.f3195b);
        this.f3199f.m4165a(5, 0, Long.valueOf(this.f3196c), Long.valueOf(this.f3196c), null, null, null);
    }

    @Override // com.google.android.play.core.splitinstall.InterfaceC5302d
    /* JADX INFO: renamed from: b */
    public final void mo4133b() {
        if (this.f3197d) {
            return;
        }
        this.f3199f.m4163a((List<Intent>) this.f3198e, (List<String>) this.f3194a, (List<String>) this.f3195b, this.f3196c, true);
    }

    @Override // com.google.android.play.core.splitinstall.InterfaceC5302d
    /* JADX INFO: renamed from: a */
    public final void mo4132a(int i) {
        this.f3199f.m4164a(i);
    }
}
