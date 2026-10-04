package com.samsung.android.app.notes.sync.contentsharing.sessession;

import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sessession.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6716p extends AbstractC6714n {

    /* JADX INFO: renamed from: n */
    public static C6716p f4052n;

    /* JADX INFO: renamed from: q */
    public static synchronized C6716p m4809q() {
        try {
            if (f4052n == null) {
                C6716p c6716p = new C6716p();
                c6716p.f4040b = CommonUtils.getOldNotesServiceId();
                c6716p.m4800h();
                f4052n = c6716p;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4052n;
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6714n
    /* JADX INFO: renamed from: a */
    public final String mo4794a() {
        return "SesSession$SesSessionOld";
    }
}
