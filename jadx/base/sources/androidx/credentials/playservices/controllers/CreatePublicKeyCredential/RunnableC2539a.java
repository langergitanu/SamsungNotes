package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.exceptions.CreateCredentialException;

/* JADX INFO: renamed from: androidx.credentials.playservices.controllers.CreatePublicKeyCredential.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2539a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1408a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CredentialProviderCreatePublicKeyCredentialController f1409b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1410c;

    public /* synthetic */ RunnableC2539a(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, Object obj, int i) {
        this.f1408a = i;
        this.f1409b = credentialProviderCreatePublicKeyCredentialController;
        this.f1410c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1408a) {
            case 0:
                C2529xb96e2c36.invoke$lambda$0(this.f1409b, (CreateCredentialException) this.f1410c);
                break;
            case 1:
                C2530xb96e2c38.invoke$lambda$0(this.f1409b, (CreateCredentialException) this.f1410c);
                break;
            default:
                C2531xb96e2c39.invoke$lambda$0(this.f1409b, (CreateCredentialResponse) this.f1410c);
                break;
        }
    }
}
