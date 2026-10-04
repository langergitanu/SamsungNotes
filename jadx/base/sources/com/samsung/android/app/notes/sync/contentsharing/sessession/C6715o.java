package com.samsung.android.app.notes.sync.contentsharing.sessession;

import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sessession.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6715o extends AbstractC6714n {

    /* JADX INFO: renamed from: n */
    public static C6715o f4051n;

    /* JADX INFO: renamed from: q */
    public static synchronized C6715o m4808q() {
        try {
            if (f4051n == null) {
                C6715o c6715o = new C6715o();
                c6715o.f4040b = CommonUtils.getNewNotesServiceId();
                c6715o.m4800h();
                f4051n = c6715o;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4051n;
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6714n
    /* JADX INFO: renamed from: a */
    public final String mo4794a() {
        return "SesSession$SesSessionCoEdit";
    }
}
