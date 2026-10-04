package com.samsung.android.sdk.pass;

import com.samsung.android.fingerprint.FingerprintEvent;
import com.samsung.android.sdk.pass.SpassFingerprint;

/* JADX INFO: renamed from: com.samsung.android.sdk.pass.f */
/* JADX INFO: loaded from: classes7.dex */
final class RunnableC7435f implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ SpassFingerprint.C7429b f4931a;

    /* JADX INFO: renamed from: b */
    private final /* synthetic */ FingerprintEvent f4932b;

    public RunnableC7435f(SpassFingerprint.C7429b c7429b, FingerprintEvent fingerprintEvent) {
        this.f4931a = c7429b;
        this.f4932b = fingerprintEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f4931a.f4919a != null) {
            int i = this.f4932b.eventId;
            if (i == 11) {
                this.f4931a.f4919a.onReady();
            } else {
                if (i != 12) {
                    return;
                }
                this.f4931a.f4919a.onStarted();
            }
        }
    }
}
