package com.google.android.gms.internal.fido;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbr implements Comparator {
    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public zzbr zza() {
        return new zzbw(this);
    }
}
