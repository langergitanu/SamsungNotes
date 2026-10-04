package com.google.android.play.core.appupdate;

import com.google.android.play.core.internal.C5195bq;
import com.google.android.play.core.internal.InterfaceC5219cn;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.h */
/* JADX INFO: loaded from: classes5.dex */
public final class C4998h implements InterfaceC5219cn<AppUpdateManager> {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5219cn<C4995e> f2434a;

    public C4998h(InterfaceC5219cn<C4995e> interfaceC5219cn) {
        this.f2434a = interfaceC5219cn;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ AppUpdateManager mo3591a() {
        C4995e c4995eMo3591a = this.f2434a.mo3591a();
        C5195bq.m3949b(c4995eMo3591a);
        return c4995eMo3591a;
    }
}
