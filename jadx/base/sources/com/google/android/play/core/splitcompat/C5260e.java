package com.google.android.play.core.splitcompat;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.google.android.play.core.splitcompat.e */
/* JADX INFO: loaded from: classes5.dex */
final class C5260e implements InterfaceC5263h {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C5272q f3035a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ Set f3036b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ AtomicBoolean f3037c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ C5266k f3038d;

    public C5260e(C5266k c5266k, C5272q c5272q, Set set, AtomicBoolean atomicBoolean) {
        this.f3038d = c5266k;
        this.f3035a = c5272q;
        this.f3036b = set;
        this.f3037c = atomicBoolean;
    }

    @Override // com.google.android.play.core.splitcompat.InterfaceC5263h
    /* JADX INFO: renamed from: a */
    public final void mo4088a(ZipFile zipFile, Set<C5265j> set) {
        this.f3038d.m4092a(this.f3035a, set, new C5259d(this));
    }
}
