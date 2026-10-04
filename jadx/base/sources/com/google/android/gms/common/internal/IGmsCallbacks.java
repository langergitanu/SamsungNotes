package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface IGmsCallbacks extends IInterface {
    void onPostInitComplete(int i, @NonNull IBinder iBinder, @NonNull Bundle bundle);

    void zzb(int i, @NonNull Bundle bundle);

    void zzc(int i, IBinder iBinder, zzk zzkVar);
}
