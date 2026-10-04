package androidx.credentials.playservices.controllers.CreatePassword;

import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.exceptions.CreateCredentialException;

/* JADX INFO: renamed from: androidx.credentials.playservices.controllers.CreatePassword.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2526a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1400a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CredentialProviderCreatePasswordController f1401b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1402c;

    public /* synthetic */ RunnableC2526a(CredentialProviderCreatePasswordController credentialProviderCreatePasswordController, Object obj, int i) {
        this.f1400a = i;
        this.f1401b = credentialProviderCreatePasswordController;
        this.f1402c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1400a) {
            case 0:
                CredentialProviderCreatePasswordController$handleResponse$2.invoke$lambda$0(this.f1401b, (CreateCredentialException) this.f1402c);
                break;
            default:
                CredentialProviderCreatePasswordController$handleResponse$3.invoke$lambda$0(this.f1401b, (CreateCredentialResponse) this.f1402c);
                break;
        }
    }
}
