package com.samsung.android.sdk.pass;

import com.samsung.android.fingerprint.FingerprintEvent;
import com.samsung.android.sdk.pass.SpassFingerprint;

/* JADX INFO: renamed from: com.samsung.android.sdk.pass.g */
/* JADX INFO: loaded from: classes7.dex */
final class RunnableC7436g implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ SpassFingerprint.C7429b f4933a;

    /* JADX INFO: renamed from: b */
    private final /* synthetic */ FingerprintEvent f4934b;

    /* JADX INFO: renamed from: c */
    private final /* synthetic */ SpassFingerprint.IdentifyListener f4935c;

    public RunnableC7436g(SpassFingerprint.C7429b c7429b, FingerprintEvent fingerprintEvent, SpassFingerprint.IdentifyListener identifyListener) {
        this.f4933a = c7429b;
        this.f4934b = fingerprintEvent;
        this.f4935c = identifyListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f4934b.eventId == 13) {
            SpassFingerprint.this.f4897c = this.f4934b.getFingerIndex();
            if (this.f4934b.eventStatus == 12) {
                SpassFingerprint.this.f4898d = this.f4934b.getImageQualityFeedback();
                SpassFingerprint.this.f4899e = SpassFingerprint.this.f4895a.getImageQualityAnimation(this.f4934b.getImageQuality(), SpassFingerprint.this.f4896b);
            }
            this.f4935c.onFinished(SpassFingerprint.m5798a(this.f4934b.eventStatus));
            this.f4935c.onCompleted();
            SpassFingerprint.this.f4897c = -1;
            SpassFingerprint.this.f4898d = null;
            SpassFingerprint.this.f4899e = null;
            if (SpassFingerprint.this.f4909t != null) {
                SpassFingerprint.this.f4909t = null;
            }
            if (SpassFingerprint.this.f4908n) {
                return;
            }
            SpassFingerprint.this.f4908n = true;
            SpassFingerprint.m5800a(SpassFingerprint.this.f4896b, "IdentifyListener.onFinished");
        }
    }
}
