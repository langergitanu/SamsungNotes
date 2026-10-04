package androidx.credentials.playservices.controllers.GetSignInIntent;

import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.playservices.controllers.GetSignInIntent.CredentialProviderGetSignInIntentController;
import kotlin.jvm.internal.Ref;

/* JADX INFO: renamed from: androidx.credentials.playservices.controllers.GetSignInIntent.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2550b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1425a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CredentialProviderGetSignInIntentController f1426b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1427c;

    public /* synthetic */ RunnableC2550b(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController, Object obj, int i) {
        this.f1425a = i;
        this.f1426b = credentialProviderGetSignInIntentController;
        this.f1427c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1425a) {
            case 0:
                CredentialProviderGetSignInIntentController$handleResponse$3.invoke$lambda$0(this.f1426b, (GetCredentialResponse) this.f1427c);
                break;
            case 1:
                CredentialProviderGetSignInIntentController$handleResponse$4.invoke$lambda$0(this.f1426b, (Ref.ObjectRef) this.f1427c);
                break;
            case 2:
                CredentialProviderGetSignInIntentController$handleResponse$6.invoke$lambda$0(this.f1426b, (GetCredentialUnknownException) this.f1427c);
                break;
            default:
                CredentialProviderGetSignInIntentController.C25461.invoke$lambda$0(this.f1426b, (Exception) this.f1427c);
                break;
        }
    }
}
