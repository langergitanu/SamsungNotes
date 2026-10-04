package com.google.android.gms.auth;

import android.content.Intent;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@KeepName
public class UserRecoverableAuthException extends GoogleAuthException {

    @Nullable
    private final Intent zza;

    public UserRecoverableAuthException(@Nullable String str, @Nullable Intent intent) {
        super(str);
        this.zza = intent;
    }

    @Nullable
    public Intent getIntent() {
        Intent intent = this.zza;
        if (intent == null) {
            return null;
        }
        return new Intent(intent);
    }
}
