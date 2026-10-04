package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import androidx.credentials.playservices.controllers.CreatePublicKeyCredential.CredentialProviderCreatePublicKeyCredentialController;
import org.json.JSONException;

/* JADX INFO: renamed from: androidx.credentials.playservices.controllers.CreatePublicKeyCredential.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2540b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1411a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CredentialProviderCreatePublicKeyCredentialController f1412b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ JSONException f1413c;

    public /* synthetic */ RunnableC2540b(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, JSONException jSONException, int i) {
        this.f1411a = i;
        this.f1412b = credentialProviderCreatePublicKeyCredentialController;
        this.f1413c = jSONException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1411a) {
            case 0:
                C2532xb96e2c3a.invoke$lambda$0(this.f1412b, this.f1413c);
                break;
            default:
                CredentialProviderCreatePublicKeyCredentialController.C25341.invoke$lambda$0(this.f1412b, this.f1413c);
                break;
        }
    }
}
