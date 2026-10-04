package androidx.credentials.playservices.controllers.GetSignInIntent;

import androidx.credentials.exceptions.GetCredentialException;

/* JADX INFO: renamed from: androidx.credentials.playservices.controllers.GetSignInIntent.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2549a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1422a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CredentialProviderGetSignInIntentController f1423b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ GetCredentialException f1424c;

    public /* synthetic */ RunnableC2549a(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController, GetCredentialException getCredentialException, int i) {
        this.f1422a = i;
        this.f1423b = credentialProviderGetSignInIntentController;
        this.f1424c = getCredentialException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1422a) {
            case 0:
                CredentialProviderGetSignInIntentController$handleResponse$2.invoke$lambda$0(this.f1423b, this.f1424c);
                break;
            default:
                CredentialProviderGetSignInIntentController$handleResponse$5.invoke$lambda$0(this.f1423b, this.f1424c);
                break;
        }
    }
}
