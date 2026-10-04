package com.google.android.gms.internal.auth;

import androidx.compose.runtime.AbstractC1974b;
import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzdm implements Serializable, zzdj {
    final Object zza;

    public zzdm(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof zzdm)) {
            return false;
        }
        Object obj2 = this.zza;
        Object obj3 = ((zzdm) obj).zza;
        return obj2 == obj3 || obj2.equals(obj3);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        return AbstractC1974b.m1320m(new StringBuilder("Suppliers.ofInstance("), this.zza, ")");
    }

    @Override // com.google.android.gms.internal.auth.zzdj
    public final Object zza() {
        return this.zza;
    }
}
