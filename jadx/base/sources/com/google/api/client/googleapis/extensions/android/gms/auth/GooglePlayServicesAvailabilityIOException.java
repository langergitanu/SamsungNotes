package com.google.api.client.googleapis.extensions.android.gms.auth;

import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.api.client.util.Beta;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class GooglePlayServicesAvailabilityIOException extends UserRecoverableAuthIOException {
    private static final long serialVersionUID = 1;

    public GooglePlayServicesAvailabilityIOException(GooglePlayServicesAvailabilityException googlePlayServicesAvailabilityException) {
        super(googlePlayServicesAvailabilityException);
    }

    public final int getConnectionStatusCode() {
        return getCause().getConnectionStatusCode();
    }

    @Override // com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException, com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAuthIOException, java.lang.Throwable
    public GooglePlayServicesAvailabilityException getCause() {
        return (GooglePlayServicesAvailabilityException) super.getCause();
    }
}
