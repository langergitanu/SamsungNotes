package com.google.android.gms.internal.meet_coactivities;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzst extends zzrb {
    private final zzsy zza;

    public zzst(zzsy zzsyVar) {
        this.zza = zzsyVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzul
    public final /* synthetic */ Object zzb(zzrw zzrwVar, zzsj zzsjVar) throws zzti {
        int i = zzsy.zzd;
        zzsy zzsyVarZzD = this.zza.zzD();
        try {
            zzuq zzuqVarZzb = zzum.zza().zzb(zzsyVarZzD.getClass());
            zzuqVarZzb.zzh(zzsyVarZzD, zzrx.zzq(zzrwVar), zzsjVar);
            zzuqVarZzb.zzf(zzsyVarZzD);
            return zzsyVarZzD;
        } catch (zzti e) {
            if (e.zzk()) {
                throw new zzti(e);
            }
            throw e;
        } catch (zzvd e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzti) {
                throw ((zzti) e3.getCause());
            }
            throw new zzti(e3);
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzti) {
                throw ((zzti) e5.getCause());
            }
            throw e5;
        }
    }
}
