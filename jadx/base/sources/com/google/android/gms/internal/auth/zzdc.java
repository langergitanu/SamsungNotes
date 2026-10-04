package com.google.android.gms.internal.auth;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzdc {
    public static final /* synthetic */ int zzd = 0;

    @Nullable
    private static volatile zzda zze = null;
    private static volatile boolean zzf = false;
    final zzcz zzb;
    final String zzc;
    private final Object zzj;
    private volatile int zzk = -1;
    private volatile Object zzl;
    private final boolean zzm;
    private static final Object zza = new Object();
    private static final AtomicReference zzg = new AtomicReference();
    private static final zzde zzh = new zzde(zzcu.zza, null);
    private static final AtomicInteger zzi = new AtomicInteger();

    public /* synthetic */ zzdc(zzcz zzczVar, String str, Object obj, boolean z, zzdb zzdbVar) {
        if (zzczVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zzb = zzczVar;
        this.zzc = str;
        this.zzj = obj;
        this.zzm = true;
    }

    public static void zzd() {
        zzi.incrementAndGet();
    }

    public static void zze(final Context context) {
        if (zze == null) {
            Object obj = zza;
            synchronized (obj) {
                try {
                    if (zze == null) {
                        synchronized (obj) {
                            zzda zzdaVar = zze;
                            Context applicationContext = context.getApplicationContext();
                            if (applicationContext != null) {
                                context = applicationContext;
                            }
                            if (zzdaVar == null || zzdaVar.zza() != context) {
                                zzcg.zzd();
                                zzdd.zzc();
                                zzco.zze();
                                zze = new zzcd(context, zzdn.zza(new zzdj() { // from class: com.google.android.gms.internal.auth.zzct
                                    @Override // com.google.android.gms.internal.auth.zzdj
                                    public final Object zza() {
                                        Context context2 = context;
                                        int i = zzdc.zzd;
                                        return zzcp.zza(context2);
                                    }
                                }));
                                zzi.incrementAndGet();
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                } finally {
                }
            }
        }
    }

    public abstract Object zza(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:41:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzb() {
        zzcl zzclVarZza;
        Object objZzb;
        if (!this.zzm && this.zzc == null) {
            throw new NullPointerException("flagName must not be null");
        }
        int i = zzi.get();
        if (this.zzk < i) {
            synchronized (this) {
                try {
                    if (this.zzk < i) {
                        zzda zzdaVar = zze;
                        if (zzdaVar == null) {
                            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                        }
                        zzcz zzczVar = this.zzb;
                        boolean z = zzczVar.zzf;
                        if (zzczVar.zzb == null) {
                            Context contextZza = zzdaVar.zza();
                            String str = this.zzb.zza;
                            zzclVarZza = zzdd.zza(contextZza, null, new Runnable() { // from class: com.google.android.gms.internal.auth.zzcs
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzdc.zzd();
                                }
                            });
                        } else if (zzcq.zza(zzdaVar.zza(), this.zzb.zzb)) {
                            boolean z2 = this.zzb.zzh;
                            zzclVarZza = zzcg.zza(zzdaVar.zza().getContentResolver(), this.zzb.zzb, new Runnable() { // from class: com.google.android.gms.internal.auth.zzcs
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzdc.zzd();
                                }
                            });
                        } else {
                            zzclVarZza = null;
                        }
                        Object objZza = (zzclVarZza == null || (objZzb = zzclVarZza.zzb(zzc())) == null) ? null : zza(objZzb);
                        if (objZza == null) {
                            if (!this.zzb.zze) {
                                String strZzc = zzco.zza(zzdaVar.zza()).zzb(this.zzb.zze ? null : this.zzc);
                                objZza = strZzc != null ? zza(strZzc) : null;
                                if (objZza == null) {
                                    objZza = this.zzj;
                                }
                            }
                        }
                        zzdh zzdhVar = (zzdh) zzdaVar.zzb().zza();
                        if (zzdhVar.zzb()) {
                            zzci zzciVar = (zzci) zzdhVar.zza();
                            zzcz zzczVar2 = this.zzb;
                            String strZza = zzciVar.zza(zzczVar2.zzb, null, zzczVar2.zzd, this.zzc);
                            objZza = strZza == null ? this.zzj : zza(strZza);
                        }
                        this.zzl = objZza;
                        this.zzk = i;
                    }
                } finally {
                }
            }
        }
        return this.zzl;
    }

    public final String zzc() {
        String str = this.zzb.zzd;
        return this.zzc;
    }
}
