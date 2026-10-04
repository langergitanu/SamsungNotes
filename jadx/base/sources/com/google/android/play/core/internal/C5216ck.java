package com.google.android.play.core.internal;

/* JADX INFO: renamed from: com.google.android.play.core.internal.ck */
/* JADX INFO: loaded from: classes5.dex */
public final class C5216ck<T> implements InterfaceC5219cn<T> {

    /* JADX INFO: renamed from: a */
    private InterfaceC5219cn<T> f2982a;

    @Override // com.google.android.play.core.internal.InterfaceC5219cn
    /* JADX INFO: renamed from: a */
    public final T mo3591a() {
        InterfaceC5219cn<T> interfaceC5219cn = this.f2982a;
        if (interfaceC5219cn != null) {
            return interfaceC5219cn.mo3591a();
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: renamed from: a */
    public static <T> void m3980a(InterfaceC5219cn<T> interfaceC5219cn, InterfaceC5219cn<T> interfaceC5219cn2) {
        C5195bq.m3944a(interfaceC5219cn2);
        C5216ck c5216ck = (C5216ck) interfaceC5219cn;
        if (c5216ck.f2982a != null) {
            throw new IllegalStateException();
        }
        c5216ck.f2982a = interfaceC5219cn2;
    }
}
