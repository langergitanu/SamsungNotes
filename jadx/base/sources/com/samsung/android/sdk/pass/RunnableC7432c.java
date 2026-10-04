package com.samsung.android.sdk.pass;

import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;

/* JADX INFO: renamed from: com.samsung.android.sdk.pass.c */
/* JADX INFO: loaded from: classes7.dex */
final class RunnableC7432c implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ SpassFingerprint f4925a;

    /* JADX INFO: renamed from: b */
    private final /* synthetic */ Handler f4926b;

    public RunnableC7432c(SpassFingerprint spassFingerprint, Handler handler) {
        this.f4925a = spassFingerprint;
        this.f4926b = handler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FingerprintManager fingerprintManager = (FingerprintManager) this.f4925a.f4896b.getSystemService("fingerprint");
        CancellationSignal cancellationSignal = new CancellationSignal();
        fingerprintManager.authenticate(null, cancellationSignal, 0, new C7433d(this), this.f4926b);
        cancellationSignal.cancel();
    }
}
