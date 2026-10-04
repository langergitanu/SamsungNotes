package com.samsung.android.sdk.pass;

import android.hardware.fingerprint.FingerprintManager;
import android.util.Log;

/* JADX INFO: renamed from: com.samsung.android.sdk.pass.d */
/* JADX INFO: loaded from: classes7.dex */
final class C7433d extends FingerprintManager.AuthenticationCallback {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ RunnableC7432c f4927a;

    public C7433d(RunnableC7432c runnableC7432c) {
        this.f4927a = runnableC7432c;
    }

    public final void onAuthenticationAcquired(int i) {
        Log.v(SpassFingerprint.TAG, "updateActiveUser : onAuthenticationAcquired");
        synchronized (this.f4927a.f4925a.f4914y) {
            this.f4927a.f4925a.f4914y.notifyAll();
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationError(int i, CharSequence charSequence) {
        Log.v(SpassFingerprint.TAG, "updateActiveUser : onAuthenticationError");
        synchronized (this.f4927a.f4925a.f4914y) {
            this.f4927a.f4925a.f4914y.notifyAll();
        }
    }
}
