package com.google.firebase.installations;

/* JADX INFO: renamed from: com.google.firebase.installations.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC5977a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3505a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FirebaseInstallations f3506b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ boolean f3507c;

    public /* synthetic */ RunnableC5977a(FirebaseInstallations firebaseInstallations, boolean z, int i) {
        this.f3505a = i;
        this.f3506b = firebaseInstallations;
        this.f3507c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3505a) {
            case 0:
                this.f3506b.lambda$doRegistrationOrRefresh$3(this.f3507c);
                break;
            default:
                this.f3506b.lambda$getToken$2(this.f3507c);
                break;
        }
    }
}
