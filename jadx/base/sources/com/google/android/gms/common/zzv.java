package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzv extends zzx {
    private final Callable zze;

    public /* synthetic */ zzv(Callable callable, zzu zzuVar) {
        super();
        this.zze = callable;
    }

    @Override // com.google.android.gms.common.zzx
    public final String zza() {
        try {
            return (String) this.zze.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
