package com.google.android.gms.internal.meet_coactivities;

import android.os.Parcel;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzact implements zzaot {
    protected final zzacl zza;
    protected final zzvy zzb;
    final int zzc;

    @GuardedBy("this")
    @Nullable
    protected zzadf zzd;

    @GuardedBy("this")
    @Nullable
    protected zzaor zze;

    @GuardedBy("this")
    @Nullable
    protected zzaou zzf;

    @GuardedBy("this")
    @Nullable
    private InputStream zzg;

    @GuardedBy("this")
    private int zzh;

    @GuardedBy("this")
    private int zzi;

    @GuardedBy("this")
    @Nullable
    private ArrayList zzj;

    @GuardedBy("this")
    private boolean zzk;

    @GuardedBy("this")
    private int zzl;

    @GuardedBy("this")
    private int zzm;

    @GuardedBy("this")
    private zzacq zzn = zzacq.UNINITIALIZED;

    @GuardedBy("this")
    private int zzo;

    @GuardedBy("this")
    private int zzp;

    @GuardedBy("this")
    private boolean zzq;

    @GuardedBy("this")
    private boolean zzr;

    public /* synthetic */ zzact(zzacl zzaclVar, zzvy zzvyVar, int i, zzacs zzacsVar) {
        this.zza = zzaclVar;
        this.zzb = zzvyVar;
        this.zzc = i;
    }

    @GuardedBy("this")
    private final void zzp(zzabd zzabdVar, zzabd zzabdVar2, boolean z) {
        if (zzo()) {
            return;
        }
        boolean z2 = this.zzn != zzacq.UNINITIALIZED;
        zzl(zzacq.CLOSED);
        if (z2) {
            this.zze.zzm(zzabdVar2);
        }
        if (!z) {
            this.zza.zzp(this.zzc, zzabdVar);
        }
        if (z2) {
            zza(zzabdVar2);
        }
        this.zza.zzn(this);
    }

    @GuardedBy("this")
    private final void zzq() {
        zzacr zzacrVar;
        if (this.zzi == 0) {
            int i = 0;
            int i2 = 0;
            while (i < this.zzj.size() && (zzacrVar = (zzacr) this.zzj.get(i)) != null) {
                i++;
                i2 += zzacrVar.zzc;
                if (zzacrVar.zzd) {
                    this.zzi = i;
                    zzr(i2);
                    return;
                }
            }
        }
    }

    @GuardedBy("this")
    private final void zzr(int i) {
        Preconditions.checkNotNull(this.zze);
        this.zze.zze(this.zzo);
        long j = i;
        this.zze.zzf(this.zzo, j, j);
        this.zzo++;
    }

    @GuardedBy("this")
    private final boolean zzs() {
        return this.zzg != null || this.zzi > 0;
    }

    @GuardedBy("this")
    private final boolean zzt() {
        return this.zzk && this.zzh >= this.zzl;
    }

    public final synchronized String toString() {
        StringBuilder sb;
        String simpleName = getClass().getSimpleName();
        boolean z = this.zzk;
        String strValueOf = String.valueOf(this.zzn);
        boolean zZzs = zzs();
        zzaou zzaouVar = this.zzf;
        sb = new StringBuilder();
        sb.append(simpleName);
        sb.append("[SfxA=");
        sb.append(z);
        sb.append("/De=");
        sb.append(strValueOf);
        sb.append("/Msg=");
        sb.append(zZzs);
        sb.append("/Lis=");
        sb.append(zzaouVar != null);
        sb.append("]");
        return sb.toString();
    }

    @GuardedBy("this")
    public abstract void zza(zzabd zzabdVar);

    public abstract void zzb();

    @GuardedBy("this")
    public abstract void zzc(int i, Parcel parcel);

    @GuardedBy("this")
    public abstract void zzd(int i, Parcel parcel);

    public boolean zze() {
        throw null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaot
    @Nullable
    public final synchronized InputStream zzf() {
        zzacm zzacmVar;
        try {
            InputStream inputStream = this.zzg;
            if (inputStream != null) {
                this.zzg = null;
            } else if (this.zzp <= 0 || !zzs()) {
                inputStream = null;
            } else {
                int i = this.zzi;
                this.zzi = 0;
                if (i == 1) {
                    zzacr zzacrVar = (zzacr) this.zzj.remove(0);
                    int i2 = zzacrVar.zzc;
                    zzacmVar = new zzacm(zzacrVar.zzb);
                } else {
                    byte[][] bArr = new byte[i][];
                    int length = 0;
                    for (int i4 = 0; i4 < i; i4++) {
                        byte[] bArr2 = (byte[]) Preconditions.checkNotNull(((zzacr) this.zzj.remove(0)).zzb);
                        bArr[i4] = bArr2;
                        length += bArr2.length;
                    }
                    zzacmVar = new zzacm(bArr, length);
                }
                this.zzh += i;
                zzq();
                inputStream = zzacmVar;
            }
            if (inputStream != null) {
                this.zzp--;
            } else {
                this.zzr = false;
                if (zzt() && !zzo()) {
                    zzl(zzacq.ALL_MESSAGES_DELIVERED);
                    zzi();
                    return null;
                }
            }
            return inputStream;
        } catch (Throwable th) {
            throw th;
        }
    }

    @GuardedBy("this")
    public final void zzg(zzabd zzabdVar) {
        zzp(zzabdVar, zzabdVar, false);
    }

    @GuardedBy("this")
    public final void zzh(zzabd zzabdVar) {
        zzp(zzabd.zzb, zzabdVar, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0070, code lost:
    
        r4.zzq = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0073, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x003f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0008 A[SYNTHETIC] */
    @GuardedBy("this")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzi() {
        int iOrdinal;
        if (this.zzq) {
            return;
        }
        this.zzq = true;
        while (true) {
            int iOrdinal2 = this.zzn.ordinal();
            if (iOrdinal2 != 2) {
                if (iOrdinal2 != 3 || this.zzf == null || !this.zzk) {
                    break;
                }
                iOrdinal = this.zzn.ordinal();
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        throw new AssertionError();
                    }
                } else if (!this.zzr) {
                    if (zzs()) {
                        this.zzr = true;
                        this.zzf.zzf(this);
                    } else if (this.zzk) {
                        zzl(zzacq.ALL_MESSAGES_DELIVERED);
                    }
                }
                if (this.zzk) {
                    zzl(zzacq.SUFFIX_DELIVERED);
                    zzb();
                }
            } else {
                if (this.zzf == null || this.zzr) {
                    break;
                }
                if (zzs()) {
                    if (this.zzp == 0) {
                        break;
                    }
                    iOrdinal = this.zzn.ordinal();
                    if (iOrdinal != 2) {
                    }
                    if (this.zzk) {
                    }
                } else {
                    if (!zzt()) {
                        break;
                    }
                    iOrdinal = this.zzn.ordinal();
                    if (iOrdinal != 2) {
                    }
                    if (this.zzk) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x009a A[Catch: all -> 0x0020, zzabe -> 0x0023, TryCatch #1 {zzabe -> 0x0023, blocks: (B:8:0x000a, B:10:0x0017, B:17:0x0026, B:19:0x003a, B:21:0x0044, B:23:0x0049, B:25:0x0053, B:26:0x0056, B:30:0x005d, B:32:0x0061, B:35:0x0067, B:37:0x006b, B:41:0x0072, B:42:0x0080, B:43:0x0089, B:45:0x009a, B:46:0x00a3, B:48:0x00ab, B:50:0x00b8, B:51:0x00be, B:52:0x00c7, B:53:0x00de, B:55:0x00e1, B:56:0x00e8, B:58:0x00ec, B:60:0x00f0, B:63:0x00f8, B:64:0x0100, B:67:0x010f, B:68:0x011d), top: B:77:0x000a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a3 A[Catch: all -> 0x0020, zzabe -> 0x0023, TryCatch #1 {zzabe -> 0x0023, blocks: (B:8:0x000a, B:10:0x0017, B:17:0x0026, B:19:0x003a, B:21:0x0044, B:23:0x0049, B:25:0x0053, B:26:0x0056, B:30:0x005d, B:32:0x0061, B:35:0x0067, B:37:0x006b, B:41:0x0072, B:42:0x0080, B:43:0x0089, B:45:0x009a, B:46:0x00a3, B:48:0x00ab, B:50:0x00b8, B:51:0x00be, B:52:0x00c7, B:53:0x00de, B:55:0x00e1, B:56:0x00e8, B:58:0x00ec, B:60:0x00f0, B:63:0x00f8, B:64:0x0100, B:67:0x010f, B:68:0x011d), top: B:77:0x000a, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zzj(Parcel parcel) {
        int i;
        if (zzo()) {
            return;
        }
        try {
            int i2 = parcel.readInt();
            if (zzado.zzc(i2, 8)) {
                zzabd zzabdVarZza = zzado.zza(i2, parcel);
                zzp(zzabdVarZza, zzabdVarZza, true);
                return;
            }
            int i4 = parcel.readInt();
            boolean zZzc = zzado.zzc(i2, 1);
            boolean zZzc2 = zzado.zzc(i2, 2);
            boolean zZzc3 = zzado.zzc(i2, 4);
            if (zZzc) {
                zzc(i2, parcel);
                zzl(zzacq.PREFIX_DELIVERED);
            }
            if (zZzc2) {
                if ((i2 & 64) != 0) {
                    throw new zzabe(zzabd.zze.zze("Parcelable messages not allowed"), null);
                }
                int i5 = parcel.readInt();
                byte[] bArrZzc = zzacn.zzc(i5);
                if (i5 > 0) {
                    parcel.readByteArray(bArrZzc);
                }
                int i6 = i2 & 128;
                boolean z = i6 == 0;
                if (this.zzj != null) {
                    zzacr zzacrVar = new zzacr(null, bArrZzc, i5, z);
                    i = i4 - this.zzh;
                    if (i >= this.zzj.size()) {
                        this.zzj.set(i, zzacrVar);
                        zzq();
                    } else if (i > this.zzj.size()) {
                        do {
                            this.zzj.add(null);
                        } while (i > this.zzj.size());
                        this.zzj.add(zzacrVar);
                    } else {
                        this.zzj.add(zzacrVar);
                        zzq();
                    }
                } else if (this.zzo == 0 && i6 == 0 && i4 == this.zzh) {
                    Preconditions.checkState(this.zzg == null);
                    this.zzg = new zzacm(bArrZzc);
                    zzr(i5);
                } else {
                    this.zzj = new ArrayList(16);
                    zzacr zzacrVar2 = new zzacr(null, bArrZzc, i5, z);
                    i = i4 - this.zzh;
                    if (i >= this.zzj.size()) {
                    }
                }
            }
            if (zZzc3) {
                zzd(i2, parcel);
                this.zzl = i4;
                this.zzk = true;
            }
            int i7 = this.zzh;
            if (i4 == i7) {
                ArrayList arrayList = this.zzj;
                if (arrayList == null) {
                    this.zzh = i7 + 1;
                } else if (!zZzc2 && !zZzc3) {
                    arrayList.remove(0);
                    this.zzh++;
                }
            }
            int iDataSize = this.zzm + parcel.dataSize();
            this.zzm = iDataSize;
            zzaor zzaorVar = this.zze;
            if (zzaorVar != null && iDataSize != 0) {
                zzaorVar.zzh(iDataSize);
                this.zze.zzg(this.zzm);
                this.zzm = 0;
            }
            zzi();
        } catch (zzabe e) {
            zzabd zzabdVarZza2 = e.zza();
            zzp(zzabdVarZza2, zzabdVarZza2, false);
        }
    }

    @GuardedBy("this")
    public final void zzk(zzadf zzadfVar, zzaou zzaouVar) {
        this.zzd = zzadfVar;
        this.zze = zzadfVar.zzc();
        this.zzf = zzaouVar;
        if (zzo()) {
            return;
        }
        zzl(zzacq.INITIALIZED);
    }

    @GuardedBy("this")
    public final void zzl(zzacq zzacqVar) {
        zzacq zzacqVar2 = this.zzn;
        int iOrdinal = zzacqVar.ordinal();
        if (iOrdinal == 1) {
            Preconditions.checkState(zzacqVar2 == zzacq.UNINITIALIZED, "%s -> %s", zzacqVar2, zzacqVar);
        } else if (iOrdinal == 2) {
            Preconditions.checkState(zzacqVar2 == zzacq.INITIALIZED || zzacqVar2 == zzacq.UNINITIALIZED, "%s -> %s", zzacqVar2, zzacqVar);
        } else if (iOrdinal == 3) {
            Preconditions.checkState(zzacqVar2 == zzacq.PREFIX_DELIVERED, "%s -> %s", zzacqVar2, zzacqVar);
        } else if (iOrdinal == 4) {
            Preconditions.checkState(zzacqVar2 == zzacq.ALL_MESSAGES_DELIVERED, "%s -> %s", zzacqVar2, zzacqVar);
        } else if (iOrdinal != 5) {
            throw new AssertionError();
        }
        this.zzn = zzacqVar;
    }

    public final void zzm() {
        zzadf zzadfVar;
        zzaou zzaouVar;
        synchronized (this) {
            zzadfVar = this.zzd;
            zzaouVar = this.zzf;
        }
        if (zzaouVar != null) {
            zzaouVar.zzg();
        }
        if (zzadfVar != null) {
            try {
                synchronized (zzadfVar) {
                    zzadfVar.zzg();
                }
            } catch (zzabe e) {
                synchronized (this) {
                    zzabd zzabdVarZza = e.zza();
                    zzp(zzabdVarZza, zzabdVarZza, false);
                }
            }
        }
    }

    @GuardedBy("this")
    public final void zzn(int i) {
        this.zzp += i;
        zzi();
    }

    @GuardedBy("this")
    public final boolean zzo() {
        return this.zzn == zzacq.CLOSED;
    }
}
