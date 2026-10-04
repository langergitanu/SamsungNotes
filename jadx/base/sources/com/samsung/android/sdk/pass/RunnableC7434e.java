package com.samsung.android.sdk.pass;

import com.samsung.android.fingerprint.FingerprintEvent;
import com.samsung.android.sdk.pass.SpassFingerprint;

/* JADX INFO: renamed from: com.samsung.android.sdk.pass.e */
/* JADX INFO: loaded from: classes7.dex */
final class RunnableC7434e implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ SpassFingerprint.C7428a f4928a;

    /* JADX INFO: renamed from: b */
    private final /* synthetic */ FingerprintEvent f4929b;

    /* JADX INFO: renamed from: c */
    private final /* synthetic */ SpassFingerprint.IdentifyListener f4930c;

    public RunnableC7434e(SpassFingerprint.C7428a c7428a, FingerprintEvent fingerprintEvent, SpassFingerprint.IdentifyListener identifyListener) {
        this.f4928a = c7428a;
        this.f4929b = fingerprintEvent;
        this.f4930c = identifyListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f4929b.eventId;
        if (i == 16) {
            if (SpassFingerprint.f4891p) {
                this.f4930c.onCompleted();
                return;
            }
            return;
        }
        if (i == 100000) {
            this.f4930c.onFinished(7);
            if (SpassFingerprint.f4891p) {
                this.f4930c.onCompleted();
                return;
            }
            return;
        }
        switch (i) {
            case 11:
                this.f4930c.onReady();
                break;
            case 12:
                this.f4930c.onStarted();
                break;
            case 13:
                SpassFingerprint.this.f4897c = this.f4929b.getFingerIndex();
                if (this.f4929b.eventStatus == 12) {
                    SpassFingerprint.this.f4899e = SpassFingerprint.this.f4895a.getImageQualityAnimation(this.f4929b.getImageQuality(), SpassFingerprint.this.f4896b);
                }
                if (this.f4929b.eventStatus == 12 || this.f4929b.eventStatus == 11) {
                    SpassFingerprint.this.f4898d = this.f4929b.getImageQualityFeedback();
                }
                SpassFingerprint.IdentifyListener identifyListener = this.f4930c;
                SpassFingerprint unused = SpassFingerprint.this;
                identifyListener.onFinished(SpassFingerprint.m5798a(this.f4929b.eventStatus));
                SpassFingerprint.this.f4897c = -1;
                SpassFingerprint.this.f4898d = null;
                SpassFingerprint.this.f4899e = null;
                if (!SpassFingerprint.this.f4908n) {
                    SpassFingerprint.this.f4908n = true;
                    SpassFingerprint.m5800a(SpassFingerprint.this.f4896b, "IdentifyListener.onFinished");
                }
                if (!SpassFingerprint.f4891p) {
                    this.f4930c.onCompleted();
                }
                break;
        }
    }
}
