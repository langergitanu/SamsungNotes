package androidx.credentials.playservices;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.credentials.playservices.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2516a implements OnSuccessListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1383a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Function1 f1384b;

    public /* synthetic */ C2516a(Function1 function1, int i) {
        this.f1383a = i;
        this.f1384b = function1;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        switch (this.f1383a) {
            case 0:
                CredentialProviderPlayServicesImpl.onClearCredential$lambda$0(this.f1384b, obj);
                break;
            case 1:
                HiddenActivity.handleCreatePublicKeyCredential$lambda$2$lambda$0(this.f1384b, obj);
                break;
            case 2:
                HiddenActivity.handleCreatePassword$lambda$14$lambda$12(this.f1384b, obj);
                break;
            case 3:
                HiddenActivity.handleGetSignInIntent$lambda$6$lambda$4(this.f1384b, obj);
                break;
            default:
                HiddenActivity.handleBeginSignIn$lambda$10$lambda$8(this.f1384b, obj);
                break;
        }
    }
}
