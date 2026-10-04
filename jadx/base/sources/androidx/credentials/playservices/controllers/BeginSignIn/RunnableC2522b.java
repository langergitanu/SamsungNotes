package androidx.credentials.playservices.controllers.BeginSignIn;

import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import kotlin.jvm.internal.Ref;

/* JADX INFO: renamed from: androidx.credentials.playservices.controllers.BeginSignIn.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2522b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1396a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CredentialProviderBeginSignInController f1397b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1398c;

    public /* synthetic */ RunnableC2522b(CredentialProviderBeginSignInController credentialProviderBeginSignInController, Object obj, int i) {
        this.f1396a = i;
        this.f1397b = credentialProviderBeginSignInController;
        this.f1398c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1396a) {
            case 0:
                CredentialProviderBeginSignInController$handleResponse$3.invoke$lambda$0(this.f1397b, (GetCredentialResponse) this.f1398c);
                break;
            case 1:
                CredentialProviderBeginSignInController$handleResponse$4.invoke$lambda$0(this.f1397b, (Ref.ObjectRef) this.f1398c);
                break;
            default:
                CredentialProviderBeginSignInController$handleResponse$6.invoke$lambda$0(this.f1397b, (GetCredentialUnknownException) this.f1398c);
                break;
        }
    }
}
