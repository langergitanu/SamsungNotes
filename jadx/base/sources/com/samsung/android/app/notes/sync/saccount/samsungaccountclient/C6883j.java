package com.samsung.android.app.notes.sync.saccount.samsungaccountclient;

import com.samsung.android.app.notes.sync.saccount.SAccountException;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.ResultConsentData;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6883j extends AbstractC6884k {

    /* JADX INFO: renamed from: b */
    public int f4418b;

    /* JADX INFO: renamed from: c */
    public Object f4419c;

    /* JADX INFO: renamed from: d */
    public Future f4420d;

    /* JADX INFO: renamed from: e */
    public InterfaceC6874a f4421e;

    /* JADX INFO: renamed from: e */
    public void m5080e(Exception exc) {
        CompletableFuture completableFuture = (CompletableFuture) this.f4420d;
        if (!(exc instanceof SAccountException)) {
            completableFuture.complete(new ResultConsentData("900", ""));
            return;
        }
        String exceptionCode = ((SAccountException) exc).getExceptionCode();
        Debugger.m8609e("TaskRequestRequiredConsent", "[SA] handleException() : exceptionCode = " + exceptionCode);
        completableFuture.complete(new ResultConsentData(exceptionCode, ""));
    }
}
