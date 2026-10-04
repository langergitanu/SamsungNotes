package com.google.android.gms.internal.fido;

import com.yubico.yubikit.core.fido.CtapException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdj extends zzdr {
    private final boolean zza;

    public zzdj(boolean z) {
        this.zza = z;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzdr zzdrVar = (zzdr) obj;
        if (zzdr.zzd(CtapException.ERR_EXTENSION_FIRST) != zzdrVar.zza()) {
            return zzdr.zzd(CtapException.ERR_EXTENSION_FIRST) - zzdrVar.zza();
        }
        return (true != this.zza ? 20 : 21) - (true != ((zzdj) zzdrVar).zza ? 20 : 21);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzdj.class == obj.getClass() && this.zza == ((zzdj) obj).zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzdr.zzd(CtapException.ERR_EXTENSION_FIRST)), Boolean.valueOf(this.zza)});
    }

    public final String toString() {
        return Boolean.toString(this.zza);
    }

    @Override // com.google.android.gms.internal.fido.zzdr
    public final int zza() {
        return zzdr.zzd(CtapException.ERR_EXTENSION_FIRST);
    }
}
