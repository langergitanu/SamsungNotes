package com.google.api.client.googleapis.extensions.android.gms.auth;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class GoogleAuthIOException extends IOException {
    private static final long serialVersionUID = 1;

    public GoogleAuthIOException(GoogleAuthException googleAuthException) {
        initCause((Throwable) Preconditions.checkNotNull(googleAuthException));
    }

    @Override // java.lang.Throwable
    public GoogleAuthException getCause() {
        return (GoogleAuthException) super.getCause();
    }
}
