package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zaak implements Runnable {
    final /* synthetic */ zaaw zaa;

    public zaak(zaaw zaawVar) {
        this.zaa = zaawVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zaaw zaawVar = this.zaa;
        zaawVar.zad.cancelAvailabilityErrorNotifications(zaawVar.zac);
    }
}
