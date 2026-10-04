package com.google.android.gms.internal.fido;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdp extends zzdr {
    private final String zza;

    public zzdp(String str) {
        this.zza = str;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        int length;
        int length2;
        zzdr zzdrVar = (zzdr) obj;
        if (zzdr.zzd(SprAttributeBase.TYPE_DURATION) != zzdrVar.zza()) {
            length2 = zzdrVar.zza();
            length = zzdr.zzd(SprAttributeBase.TYPE_DURATION);
        } else {
            String str = this.zza;
            int length3 = str.length();
            String str2 = ((zzdp) zzdrVar).zza;
            if (length3 == str2.length()) {
                return str.compareTo(str2);
            }
            length = str.length();
            length2 = str2.length();
        }
        return length - length2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzdp.class == obj.getClass()) {
            return this.zza.equals(((zzdp) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzdr.zzd(SprAttributeBase.TYPE_DURATION)), this.zza});
    }

    public final String toString() {
        return AbstractC0541b.m773o("\"", this.zza, "\"");
    }

    @Override // com.google.android.gms.internal.fido.zzdr
    public final int zza() {
        return zzdr.zzd(SprAttributeBase.TYPE_DURATION);
    }
}
