package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.UidVerifier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zbt extends zbo {
    private final Context zba;

    public zbt(Context context) {
        this.zba = context;
    }

    private final void zbd() {
        if (!UidVerifier.isGooglePlayServicesUid(this.zba, Binder.getCallingUid())) {
            throw new SecurityException(AbstractC0541b.m767i(Binder.getCallingUid(), "Calling UID ", " is not Google Play services."));
        }
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zbp
    public final void zbb() {
        zbd();
        zbn.zbc(this.zba).zbd();
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zbp
    public final void zbc() {
        zbd();
        Storage storage = Storage.getInstance(this.zba);
        GoogleSignInAccount savedDefaultGoogleSignInAccount = storage.getSavedDefaultGoogleSignInAccount();
        GoogleSignInOptions savedDefaultGoogleSignInOptions = GoogleSignInOptions.DEFAULT_SIGN_IN;
        if (savedDefaultGoogleSignInAccount != null) {
            savedDefaultGoogleSignInOptions = storage.getSavedDefaultGoogleSignInOptions();
        }
        GoogleSignInClient client = GoogleSignIn.getClient(this.zba, savedDefaultGoogleSignInOptions);
        if (savedDefaultGoogleSignInAccount != null) {
            client.revokeAccess();
        } else {
            client.signOut();
        }
    }
}
