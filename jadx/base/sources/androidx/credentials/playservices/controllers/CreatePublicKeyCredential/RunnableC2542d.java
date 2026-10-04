package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import androidx.credentials.playservices.controllers.CreatePublicKeyCredential.CredentialProviderCreatePublicKeyCredentialController;

/* JADX INFO: renamed from: androidx.credentials.playservices.controllers.CreatePublicKeyCredential.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2542d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1417a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CredentialProviderCreatePublicKeyCredentialController f1418b;

    public /* synthetic */ RunnableC2542d(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, int i) {
        this.f1417a = i;
        this.f1418b = credentialProviderCreatePublicKeyCredentialController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1417a) {
            case 0:
                CredentialProviderCreatePublicKeyCredentialController.C25363.invoke$lambda$0(this.f1418b);
                break;
            default:
                CredentialProviderCreatePublicKeyCredentialController.handleResponse$lambda$0(this.f1418b);
                break;
        }
    }
}
