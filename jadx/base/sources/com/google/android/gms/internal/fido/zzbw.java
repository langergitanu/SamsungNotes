package com.google.android.gms.internal.fido;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzbw extends zzbr implements Serializable {
    final zzbr zza;

    public zzbw(zzbr zzbrVar) {
        this.zza = zzbrVar;
    }

    @Override // com.google.android.gms.internal.fido.zzbr, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbw) {
            return this.zza.equals(((zzbw) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return -this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString().concat(".reverse()");
    }

    @Override // com.google.android.gms.internal.fido.zzbr
    public final zzbr zza() {
        return this.zza;
    }
}
