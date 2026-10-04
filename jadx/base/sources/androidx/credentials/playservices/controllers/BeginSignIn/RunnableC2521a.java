package androidx.credentials.playservices.controllers.BeginSignIn;

import androidx.credentials.exceptions.GetCredentialException;

/* JADX INFO: renamed from: androidx.credentials.playservices.controllers.BeginSignIn.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2521a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1393a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CredentialProviderBeginSignInController f1394b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ GetCredentialException f1395c;

    public /* synthetic */ RunnableC2521a(CredentialProviderBeginSignInController credentialProviderBeginSignInController, GetCredentialException getCredentialException, int i) {
        this.f1393a = i;
        this.f1394b = credentialProviderBeginSignInController;
        this.f1395c = getCredentialException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1393a) {
            case 0:
                CredentialProviderBeginSignInController$handleResponse$2.invoke$lambda$0(this.f1394b, this.f1395c);
                break;
            default:
                CredentialProviderBeginSignInController$handleResponse$5.invoke$lambda$0(this.f1394b, this.f1395c);
                break;
        }
    }
}
