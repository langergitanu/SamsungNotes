package com.google.android.gms.internal.fido;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import androidx.annotation.Nullable;
import com.google.android.gms.fido.fido2.Fido2PendingIntent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zzi implements Fido2PendingIntent {

    @Nullable
    private final PendingIntent zza;

    public zzi(@Nullable PendingIntent pendingIntent) {
        this.zza = pendingIntent;
    }

    @Override // com.google.android.gms.fido.fido2.Fido2PendingIntent
    public final boolean hasPendingIntent() {
        return this.zza != null;
    }

    @Override // com.google.android.gms.fido.fido2.Fido2PendingIntent
    public final void launchPendingIntent(Activity activity, int i) throws IntentSender.SendIntentException {
        PendingIntent pendingIntent = this.zza;
        if (pendingIntent == null) {
            throw new IllegalStateException("No PendingIntent available");
        }
        activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, null, 0, 0, 0);
    }
}
