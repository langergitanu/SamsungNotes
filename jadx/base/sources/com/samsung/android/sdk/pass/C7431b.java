package com.samsung.android.sdk.pass;

import android.util.Log;
import com.samsung.android.fingerprint.FingerprintManager;
import com.samsung.android.sdk.pass.SpassFingerprint;

/* JADX INFO: renamed from: com.samsung.android.sdk.pass.b */
/* JADX INFO: loaded from: classes7.dex */
final class C7431b implements FingerprintManager.EnrollFinishListener {

    /* JADX INFO: renamed from: a */
    private final /* synthetic */ SpassFingerprint.RegisterListener f4924a;

    public C7431b(SpassFingerprint.RegisterListener registerListener) {
        this.f4924a = registerListener;
    }

    public final void onEnrollFinish() {
        Log.d(SpassFingerprint.TAG, "onEnrollFinish called");
        this.f4924a.onFinished();
    }
}
