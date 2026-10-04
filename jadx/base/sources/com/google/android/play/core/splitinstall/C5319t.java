package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.listener.AbstractC5244b;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.t */
/* JADX INFO: loaded from: classes5.dex */
public final class C5319t extends AbstractC5244b<SplitInstallSessionState> {

    /* JADX INFO: renamed from: c */
    @Nullable
    private static C5319t f3150c;

    /* JADX INFO: renamed from: d */
    private final Handler f3151d;

    /* JADX INFO: renamed from: e */
    private final InterfaceC5303e f3152e;

    public C5319t(Context context, InterfaceC5303e interfaceC5303e) {
        super(new C5157af("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.f3151d = new Handler(Looper.getMainLooper());
        this.f3152e = interfaceC5303e;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C5319t m4153a(Context context) {
        try {
            if (f3150c == null) {
                f3150c = new C5319t(context, EnumC5310l.f3133a);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3150c;
    }

    @Override // com.google.android.play.core.listener.AbstractC5244b
    /* JADX INFO: renamed from: a */
    public final void mo3590a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra(MicrosoftAuthorizationResponse.SESSION_STATE);
        if (bundleExtra == null) {
            return;
        }
        SplitInstallSessionState splitInstallSessionStateM4103a = SplitInstallSessionState.m4103a(bundleExtra);
        this.f2996a.m3875a("ListenerRegistryBroadcastReceiver.onReceive: %s", splitInstallSessionStateM4103a);
        InterfaceC5304f interfaceC5304fMo4134a = this.f3152e.mo4134a();
        if (splitInstallSessionStateM4103a.status() != 3 || interfaceC5304fMo4134a == null) {
            m4034a(splitInstallSessionStateM4103a);
        } else {
            interfaceC5304fMo4134a.mo3904a(splitInstallSessionStateM4103a.mo4106c(), new C5317r(this, splitInstallSessionStateM4103a, intent, context));
        }
    }
}
