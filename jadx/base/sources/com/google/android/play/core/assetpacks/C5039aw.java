package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.C5146a;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.InterfaceC5215cj;
import com.google.android.play.core.listener.AbstractC5244b;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.aw */
/* JADX INFO: loaded from: classes5.dex */
final class C5039aw extends AbstractC5244b<AssetPackState> {

    /* JADX INFO: renamed from: c */
    private final C5086cp f2575c;

    /* JADX INFO: renamed from: d */
    private final C5066bw f2576d;

    /* JADX INFO: renamed from: e */
    private final InterfaceC5215cj<InterfaceC5141w> f2577e;

    /* JADX INFO: renamed from: f */
    private final C5057bn f2578f;

    /* JADX INFO: renamed from: g */
    private final C5069bz f2579g;

    /* JADX INFO: renamed from: h */
    private final C5146a f2580h;

    /* JADX INFO: renamed from: i */
    private final InterfaceC5215cj<Executor> f2581i;

    /* JADX INFO: renamed from: j */
    private final InterfaceC5215cj<Executor> f2582j;

    /* JADX INFO: renamed from: k */
    private final Handler f2583k;

    public C5039aw(Context context, C5086cp c5086cp, C5066bw c5066bw, InterfaceC5215cj<InterfaceC5141w> interfaceC5215cj, C5069bz c5069bz, C5057bn c5057bn, C5146a c5146a, InterfaceC5215cj<Executor> interfaceC5215cj2, InterfaceC5215cj<Executor> interfaceC5215cj3) {
        super(new C5157af("AssetPackServiceListenerRegistry"), new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE"), context);
        this.f2583k = new Handler(Looper.getMainLooper());
        this.f2575c = c5086cp;
        this.f2576d = c5066bw;
        this.f2577e = interfaceC5215cj;
        this.f2579g = c5069bz;
        this.f2578f = c5057bn;
        this.f2580h = c5146a;
        this.f2581i = interfaceC5215cj2;
        this.f2582j = interfaceC5215cj3;
    }

    @Override // com.google.android.play.core.listener.AbstractC5244b
    /* JADX INFO: renamed from: a */
    public final void mo3590a(Context context, Intent intent) {
        final Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
        if (bundleExtra == null) {
            this.f2996a.m3877b("Empty bundle received from broadcast.", new Object[0]);
            return;
        }
        ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("pack_names");
        if (stringArrayList == null || stringArrayList.size() != 1) {
            this.f2996a.m3877b("Corrupt bundle received from broadcast.", new Object[0]);
            return;
        }
        Bundle bundleExtra2 = intent.getBundleExtra("com.google.android.play.core.FLAGS");
        if (bundleExtra2 != null) {
            this.f2580h.m3857a(bundleExtra2);
        }
        final AssetPackState assetPackStateM3623a = AssetPackState.m3623a(bundleExtra, stringArrayList.get(0), this.f2579g, C5041ay.f2593a);
        this.f2996a.m3875a("ListenerRegistryBroadcastReceiver.onReceive: %s", assetPackStateM3623a);
        PendingIntent pendingIntent = (PendingIntent) bundleExtra.getParcelable("confirmation_intent");
        if (pendingIntent != null) {
            this.f2578f.m3730a(pendingIntent);
        }
        this.f2582j.m3979a().execute(new Runnable(this, bundleExtra, assetPackStateM3623a) { // from class: com.google.android.play.core.assetpacks.au

            /* JADX INFO: renamed from: a */
            private final C5039aw f2570a;

            /* JADX INFO: renamed from: b */
            private final Bundle f2571b;

            /* JADX INFO: renamed from: c */
            private final AssetPackState f2572c;

            {
                this.f2570a = this;
                this.f2571b = bundleExtra;
                this.f2572c = assetPackStateM3623a;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2570a.m3675a(this.f2571b, this.f2572c);
            }
        });
        this.f2581i.m3979a().execute(new Runnable(this, bundleExtra) { // from class: com.google.android.play.core.assetpacks.av

            /* JADX INFO: renamed from: a */
            private final C5039aw f2573a;

            /* JADX INFO: renamed from: b */
            private final Bundle f2574b;

            {
                this.f2573a = this;
                this.f2574b = bundleExtra;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2573a.m3674a(this.f2574b);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void m3674a(Bundle bundle) {
        if (this.f2575c.m3755a(bundle)) {
            this.f2576d.m3739a();
        }
    }

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void m3675a(Bundle bundle, AssetPackState assetPackState) {
        if (this.f2575c.m3760b(bundle)) {
            m3676a(assetPackState);
            this.f2577e.m3979a().mo3667a();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3676a(final AssetPackState assetPackState) {
        this.f2583k.post(new Runnable(this, assetPackState) { // from class: com.google.android.play.core.assetpacks.at

            /* JADX INFO: renamed from: a */
            private final C5039aw f2568a;

            /* JADX INFO: renamed from: b */
            private final AssetPackState f2569b;

            {
                this.f2568a = this;
                this.f2569b = assetPackState;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2568a.m4034a(this.f2569b);
            }
        });
    }
}
