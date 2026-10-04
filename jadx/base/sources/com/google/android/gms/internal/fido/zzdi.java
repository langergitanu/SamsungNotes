package com.google.android.gms.internal.fido;

import com.adobe.internal.xmp.XMPConst;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdi extends zzdr {
    private final zzaz zza;
    private final int zzb;

    public zzdi(zzaz zzazVar) throws zzdh {
        zzazVar.getClass();
        this.zza = zzazVar;
        int i = 0;
        int i2 = 0;
        while (true) {
            zzaz zzazVar2 = this.zza;
            if (i >= zzazVar2.size()) {
                break;
            }
            int iZzb = ((zzdr) zzazVar2.get(i)).zzb();
            if (i2 < iZzb) {
                i2 = iZzb;
            }
            i++;
        }
        int i4 = i2 + 1;
        this.zzb = i4;
        if (i4 > 4) {
            throw new zzdh("Exceeded cutoff limit for max depth of cbor value");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzdr zzdrVar = (zzdr) obj;
        if (zzdr.zzd((byte) -128) != zzdrVar.zza()) {
            return zzdr.zzd((byte) -128) - zzdrVar.zza();
        }
        zzdi zzdiVar = (zzdi) zzdrVar;
        zzaz zzazVar = this.zza;
        int size = zzazVar.size();
        zzaz zzazVar2 = zzdiVar.zza;
        if (size != zzazVar2.size()) {
            return zzazVar.size() - zzazVar2.size();
        }
        int i = 0;
        while (true) {
            zzaz zzazVar3 = this.zza;
            if (i >= zzazVar3.size()) {
                return 0;
            }
            int iCompareTo = ((zzdr) zzazVar3.get(i)).compareTo((zzdr) zzdiVar.zza.get(i));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzdi.class == obj.getClass()) {
            return this.zza.equals(((zzdi) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzdr.zzd((byte) -128)), this.zza});
    }

    public final String toString() {
        if (this.zza.isEmpty()) {
            return XMPConst.ARRAY_ITEM_NAME;
        }
        ArrayList arrayList = new ArrayList();
        zzaz zzazVar = this.zza;
        int size = zzazVar.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((zzdr) zzazVar.get(i)).toString().replace("\n", "\n  "));
        }
        zzag zzagVarZza = zzag.zza(",\n  ");
        StringBuilder sb = new StringBuilder("[\n  ");
        try {
            zzagVarZza.zzb(sb, arrayList.iterator());
            sb.append("\n]");
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.android.gms.internal.fido.zzdr
    public final int zza() {
        return zzdr.zzd((byte) -128);
    }

    @Override // com.google.android.gms.internal.fido.zzdr
    public final int zzb() {
        return this.zzb;
    }
}
