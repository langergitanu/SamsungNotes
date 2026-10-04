package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zad implements zah {
    final /* synthetic */ FrameLayout zaa;
    final /* synthetic */ LayoutInflater zab;
    final /* synthetic */ ViewGroup zac;
    final /* synthetic */ Bundle zad;
    final /* synthetic */ DeferredLifecycleHelper zae;

    public zad(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.zae = deferredLifecycleHelper;
        this.zaa = frameLayout;
        this.zab = layoutInflater;
        this.zac = viewGroup;
        this.zad = bundle;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 2;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void zab(LifecycleDelegate lifecycleDelegate) {
        this.zaa.removeAllViews();
        this.zaa.addView(this.zae.zaa.onCreateView(this.zab, this.zac, this.zad));
    }
}
