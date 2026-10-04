package com.google.android.gms.internal.meet_coactivities;

import android.os.Parcel;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzadd extends zzadf {
    private final zzaab zza;
    private final zzzv zzb;
    private final zzaor zzc;

    public zzadd(zzacl zzaclVar, int i, zzaab zzaabVar, zzzv zzzvVar, zzaor zzaorVar) {
        super(zzaclVar, i, zzaorVar, null);
        this.zza = zzaabVar;
        this.zzb = zzzvVar;
        this.zzc = zzaorVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzadf
    @GuardedBy("this")
    public final int zza(Parcel parcel) {
        int length;
        int i;
        parcel.writeString(this.zza.zzf());
        zzzv zzzvVar = this.zzb;
        int iZza = zzzvVar != null ? zzyk.zza(zzzvVar) : 0;
        if (iZza == 0) {
            parcel.writeInt(0);
        } else {
            Object[] objArrZzd = zzyk.zzd(zzzvVar);
            parcel.writeInt(iZza);
            for (int i2 = 0; i2 < iZza; i2++) {
                int i4 = i2 + i2;
                byte[] bArr = (byte[]) objArrZzd[i4];
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(bArr);
                Object obj = objArrZzd[i4 + 1];
                if (obj instanceof byte[]) {
                    byte[] bArr2 = (byte[]) obj;
                    parcel.writeInt(bArr2.length);
                    parcel.writeByteArray(bArr2);
                } else {
                    if (obj instanceof zzadh) {
                        parcel.writeInt(-1);
                        throw null;
                    }
                    byte[] bArrZzb = zzacn.zzb();
                    try {
                        InputStream inputStream = (InputStream) obj;
                        int i5 = 0;
                        while (true) {
                            length = bArrZzb.length;
                            if (i5 >= length || (i = inputStream.read(bArrZzb, i5, length - i5)) == -1) {
                                break;
                            }
                            i5 += i;
                        }
                        if (i5 == length) {
                            throw new zzabe(zzabd.zzg.zze("Metadata value too large"), null);
                        }
                        parcel.writeInt(i5);
                        if (i5 > 0) {
                            parcel.writeByteArray(bArrZzb, 0, i5);
                        }
                        zzacn.zza(bArrZzb);
                    } catch (Throwable th) {
                        zzacn.zza(bArrZzb);
                        throw th;
                    }
                }
            }
        }
        this.zzc.zzd();
        zzzz zzzzVarZzb = this.zza.zzb();
        return (zzzzVarZzb == zzzz.UNARY || zzzzVarZzb == zzzz.CLIENT_STREAMING) ? 16 : 0;
    }

    @GuardedBy("this")
    public final void zzb(zzxi zzxiVar) {
        zzzv zzzvVar = this.zzb;
        zzzq zzzqVar = zzahv.zza;
        zzzvVar.zzd(zzzqVar);
        this.zzb.zzf(zzzqVar, Long.valueOf(Math.max(0L, zzxiVar.zzb(TimeUnit.NANOSECONDS))));
    }
}
