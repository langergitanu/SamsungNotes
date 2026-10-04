package com.google.android.gms.auth;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class UserRecoverableNotifiedException extends GoogleAuthException {
    public UserRecoverableNotifiedException(@NonNull String str) {
        super(str);
    }

    public UserRecoverableNotifiedException(@NonNull String str, @NonNull Throwable th) {
        super(str, th);
    }
}
