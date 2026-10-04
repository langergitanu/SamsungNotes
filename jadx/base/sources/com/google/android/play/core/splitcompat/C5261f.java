package com.google.android.play.core.splitcompat;

import java.util.Set;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.google.android.play.core.splitcompat.f */
/* JADX INFO: loaded from: classes5.dex */
final class C5261f implements InterfaceC5263h {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Set f3039a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5272q f3040b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ C5266k f3041c;

    public C5261f(C5266k c5266k, Set set, C5272q c5272q) {
        this.f3041c = c5266k;
        this.f3039a = set;
        this.f3040b = c5272q;
    }

    @Override // com.google.android.play.core.splitcompat.InterfaceC5263h
    /* JADX INFO: renamed from: a */
    public final void mo4088a(ZipFile zipFile, Set<C5265j> set) {
        this.f3039a.addAll(C5266k.m4089a(this.f3041c, set, this.f3040b, zipFile));
    }
}
