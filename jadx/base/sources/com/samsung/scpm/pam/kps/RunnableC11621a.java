package com.samsung.scpm.pam.kps;

import android.content.Intent;
import com.samsung.scpm.pam.kps.ScpmKps;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.scpm.pam.kps.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC11621a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8123a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Consumer f8124b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f8125c;

    public /* synthetic */ RunnableC11621a(Intent intent, Consumer consumer) {
        this.f8125c = intent;
        this.f8124b = consumer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8123a) {
            case 0:
                ScpmKps.C116201.lambda$onReceive$0((Intent) this.f8125c, this.f8124b);
                break;
            default:
                this.f8124b.accept((ScpmKpsResult) this.f8125c);
                break;
        }
    }

    public /* synthetic */ RunnableC11621a(Consumer consumer, ScpmKpsResult scpmKpsResult) {
        this.f8124b = consumer;
        this.f8125c = scpmKpsResult;
    }
}
