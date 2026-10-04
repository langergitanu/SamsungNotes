package com.samsung.android.sdk.pass;

import android.content.DialogInterface;
import com.samsung.android.sdk.pass.SpassFingerprint;

/* JADX INFO: renamed from: com.samsung.android.sdk.pass.a */
/* JADX INFO: loaded from: classes7.dex */
final class DialogInterfaceOnDismissListenerC7430a implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a */
    private final /* synthetic */ SpassFingerprint.C7429b f4923a;

    public DialogInterfaceOnDismissListenerC7430a(SpassFingerprint.C7429b c7429b) {
        this.f4923a = c7429b;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f4923a.m5825a();
    }
}
