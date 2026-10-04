package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import androidx.credentials.playservices.controllers.CreatePublicKeyCredential.CredentialProviderCreatePublicKeyCredentialController;

/* JADX INFO: renamed from: androidx.credentials.playservices.controllers.CreatePublicKeyCredential.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2541c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1414a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CredentialProviderCreatePublicKeyCredentialController f1415b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Throwable f1416c;

    public /* synthetic */ RunnableC2541c(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, Throwable th, int i) {
        this.f1414a = i;
        this.f1415b = credentialProviderCreatePublicKeyCredentialController;
        this.f1416c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1414a) {
            case 0:
                C2533xb96e2c3b.invoke$lambda$0(this.f1415b, this.f1416c);
                break;
            default:
                CredentialProviderCreatePublicKeyCredentialController.C25352.invoke$lambda$0(this.f1415b, this.f1416c);
                break;
        }
    }
}
