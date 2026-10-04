package com.google.api.client.googleapis.extensions.android.gms.auth;

import android.content.Intent;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.api.client.util.Beta;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class UserRecoverableAuthIOException extends GoogleAuthIOException {
    private static final long serialVersionUID = 1;

    public UserRecoverableAuthIOException(UserRecoverableAuthException userRecoverableAuthException) {
        super(userRecoverableAuthException);
    }

    public final Intent getIntent() {
        return getCause().getIntent();
    }

    @Override // com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAuthIOException, java.lang.Throwable
    public UserRecoverableAuthException getCause() {
        return (UserRecoverableAuthException) super.getCause();
    }
}
