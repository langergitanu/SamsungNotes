package androidx.credentials.playservices;

import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: renamed from: androidx.credentials.playservices.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2554e implements OnFailureListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1433a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ HiddenActivity f1434b;

    public /* synthetic */ C2554e(HiddenActivity hiddenActivity, int i) {
        this.f1433a = i;
        this.f1434b = hiddenActivity;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        switch (this.f1433a) {
            case 0:
                HiddenActivity.handleCreatePublicKeyCredential$lambda$2$lambda$1(this.f1434b, exc);
                break;
            case 1:
                HiddenActivity.handleCreatePassword$lambda$14$lambda$13(this.f1434b, exc);
                break;
            case 2:
                HiddenActivity.handleGetSignInIntent$lambda$6$lambda$5(this.f1434b, exc);
                break;
            default:
                HiddenActivity.handleBeginSignIn$lambda$10$lambda$9(this.f1434b, exc);
                break;
        }
    }
}
