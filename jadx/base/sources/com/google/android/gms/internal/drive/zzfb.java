package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;

/* JADX INFO: loaded from: classes5.dex */
public final class zzfb extends zzkk<zzfb, zza> implements zzls {
    private static volatile zzmb<zzfb> zzhk;
    private static final zzfb zzhp;
    private int zzhd;
    private byte zzhi = 2;
    private int zzhe = 1;
    private String zzhm = "";
    private long zzhn = -1;
    private long zzhg = -1;
    private int zzho = -1;

    public static final class zza extends zzkk.zza<zzfb, zza> implements zzls {
        private zza() {
            super(zzfb.zzhp);
        }

        public final zza zze(String str) {
            zzdb();
            ((zzfb) this.zzru).zzd(str);
            return this;
        }

        public final zza zzg(long j) {
            zzdb();
            ((zzfb) this.zzru).zzf(j);
            return this;
        }

        public final zza zzh(long j) {
            zzdb();
            ((zzfb) this.zzru).zza(j);
            return this;
        }

        public final zza zzm(int i) {
            zzdb();
            ((zzfb) this.zzru).zzj(1);
            return this;
        }

        public final zza zzn(int i) {
            zzdb();
            ((zzfb) this.zzru).zzl(i);
            return this;
        }

        public /* synthetic */ zza(zzfc zzfcVar) {
            this();
        }
    }

    static {
        zzfb zzfbVar = new zzfb();
        zzhp = zzfbVar;
        zzkk.zza((Class<zzfb>) zzfb.class, zzfbVar);
    }

    private zzfb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(long j) {
        this.zzhd |= 8;
        this.zzhg = j;
    }

    public static zza zzan() {
        return zzhp.zzcw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(String str) {
        str.getClass();
        this.zzhd |= 2;
        this.zzhm = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzf(long j) {
        this.zzhd |= 4;
        this.zzhn = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj(int i) {
        this.zzhd |= 1;
        this.zzhe = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl(int i) {
        this.zzhd |= 16;
        this.zzho = i;
    }

    public final String getResourceId() {
        return this.zzhm;
    }

    public final int getResourceType() {
        return this.zzho;
    }

    public final long zzal() {
        return this.zzhn;
    }

    public final long zzam() {
        return this.zzhg;
    }

    public static zzfb zza(byte[] bArr, zzjx zzjxVar) {
        return (zzfb) zzkk.zza(zzhp, bArr, zzjxVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12, types: [com.google.android.gms.internal.drive.zzkk$zzb, com.google.android.gms.internal.drive.zzmb<com.google.android.gms.internal.drive.zzfb>] */
    @Override // com.google.android.gms.internal.drive.zzkk
    public final Object zza(int i, Object obj, Object obj2) {
        Object obj3;
        zzfc zzfcVar = null;
        switch (zzfc.zzhl[i - 1]) {
            case 1:
                return new zzfb();
            case 2:
                return new zza(zzfcVar);
            case 3:
                return zzkk.zza(zzhp, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0004\u0001Ԅ\u0000\u0002Ԉ\u0001\u0003Ԑ\u0002\u0004Ԑ\u0003\u0005\u0004\u0004", new Object[]{"zzhd", "zzhe", "zzhm", "zzhn", "zzhg", "zzho"});
            case 4:
                return zzhp;
            case 5:
                zzmb<zzfb> zzmbVar = zzhk;
                if (zzmbVar != null) {
                    return zzmbVar;
                }
                synchronized (zzfb.class) {
                    try {
                        zzmb<zzfb> zzmbVar2 = zzhk;
                        obj3 = zzmbVar2;
                        if (zzmbVar2 == null) {
                            ?? zzbVar = new zzkk.zzb(zzhp);
                            zzhk = zzbVar;
                            obj3 = zzbVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return obj3;
            case 6:
                return Byte.valueOf(this.zzhi);
            case 7:
                this.zzhi = (byte) (obj == null ? 0 : 1);
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
