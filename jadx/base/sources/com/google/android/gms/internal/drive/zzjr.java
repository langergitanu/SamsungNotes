package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public abstract class zzjr extends zzjb {
    private static final Logger logger = Logger.getLogger(zzjr.class.getName());
    private static final boolean zzog = zznd.zzfd();
    zzjt zzoh;

    public static class zza extends zzjr {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        public zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i2) | i2) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.buffer = bArr;
            this.offset = 0;
            this.position = 0;
            this.limit = i2;
        }

        private final void write(byte[] bArr, int i, int i2) throws zzb {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zza(int i, long j) throws zzb {
            zzb(i, 0);
            zzl(j);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzaa(int i) throws zzb {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i4 = i2 + 1;
                this.position = i4;
                bArr[i2] = (byte) i;
                int i5 = i2 + 2;
                this.position = i5;
                bArr[i4] = (byte) (i >> 8);
                int i6 = i2 + 3;
                this.position = i6;
                bArr[i5] = (byte) (i >> 16);
                this.position = i2 + 4;
                bArr[i6] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzb(int i, int i2) throws zzb {
            zzy((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzc(int i, int i2) throws zzb {
            zzb(i, 0);
            zzx(i2);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final int zzca() {
            return this.limit - this.position;
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzd(int i, int i2) throws zzb {
            zzb(i, 0);
            zzy(i2);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzf(int i, int i2) throws zzb {
            zzb(i, 5);
            zzaa(i2);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzl(long j) throws zzb {
            if (zzjr.zzog && zzca() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    zznd.zza(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                zznd.zza(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    bArr3[i4] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr4[i5] = (byte) j;
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzn(long j) throws zzb {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                int i2 = i + 1;
                this.position = i2;
                bArr[i] = (byte) j;
                int i4 = i + 2;
                this.position = i4;
                bArr[i2] = (byte) (j >> 8);
                int i5 = i + 3;
                this.position = i5;
                bArr[i4] = (byte) (j >> 16);
                int i6 = i + 4;
                this.position = i6;
                bArr[i5] = (byte) (j >> 24);
                int i7 = i + 5;
                this.position = i7;
                bArr[i6] = (byte) (j >> 32);
                int i8 = i + 6;
                this.position = i8;
                bArr[i7] = (byte) (j >> 40);
                int i9 = i + 7;
                this.position = i9;
                bArr[i8] = (byte) (j >> 48);
                this.position = i + 8;
                bArr[i9] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzx(int i) throws zzb {
            if (i >= 0) {
                zzy(i);
            } else {
                zzl(i);
            }
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzy(int i) throws zzb {
            if (!zzjr.zzog || zzix.zzbr() || zzca() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i2 = this.position;
                        this.position = i2 + 1;
                        bArr[i2] = (byte) ((i & 127) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr2[i4] = (byte) i;
                return;
            }
            if ((i & (-128)) == 0) {
                byte[] bArr3 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zznd.zza(bArr3, i5, (byte) i);
                return;
            }
            byte[] bArr4 = this.buffer;
            int i6 = this.position;
            this.position = i6 + 1;
            zznd.zza(bArr4, i6, (byte) (i | 128));
            int i7 = i >>> 7;
            if ((i7 & (-128)) == 0) {
                byte[] bArr5 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zznd.zza(bArr5, i8, (byte) i7);
                return;
            }
            byte[] bArr6 = this.buffer;
            int i9 = this.position;
            this.position = i9 + 1;
            zznd.zza(bArr6, i9, (byte) (i7 | 128));
            int i10 = i >>> 14;
            if ((i10 & (-128)) == 0) {
                byte[] bArr7 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zznd.zza(bArr7, i11, (byte) i10);
                return;
            }
            byte[] bArr8 = this.buffer;
            int i12 = this.position;
            this.position = i12 + 1;
            zznd.zza(bArr8, i12, (byte) (i10 | 128));
            int i13 = i >>> 21;
            if ((i13 & (-128)) == 0) {
                byte[] bArr9 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zznd.zza(bArr9, i14, (byte) i13);
                return;
            }
            byte[] bArr10 = this.buffer;
            int i15 = this.position;
            this.position = i15 + 1;
            zznd.zza(bArr10, i15, (byte) (i13 | 128));
            byte[] bArr11 = this.buffer;
            int i16 = this.position;
            this.position = i16 + 1;
            zznd.zza(bArr11, i16, (byte) (i >>> 28));
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzb(int i, boolean z) throws zzb {
            zzb(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zza(int i, String str) throws zzb {
            zzb(i, 2);
            zzl(str);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzc(int i, long j) throws zzb {
            zzb(i, 1);
            zzn(j);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzd(byte[] bArr, int i, int i2) throws zzb {
            zzy(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzb(int i, zzjc zzjcVar) throws zzb {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzjcVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zza(int i, zzjc zzjcVar) throws zzb {
            zzb(i, 2);
            zza(zzjcVar);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzc(byte b) throws zzb {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zza(zzjc zzjcVar) throws zzb {
            zzy(zzjcVar.size());
            zzjcVar.zza(this);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzb(zzlq zzlqVar) throws zzb {
            zzy(zzlqVar.zzcx());
            zzlqVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zzl(String str) throws zzb {
            int i = this.position;
            try {
                int iZzad = zzjr.zzad(str.length() * 3);
                int iZzad2 = zzjr.zzad(str.length());
                if (iZzad2 == iZzad) {
                    int i2 = i + iZzad2;
                    this.position = i2;
                    int iZza = zznf.zza(str, this.buffer, i2, zzca());
                    this.position = i;
                    zzy((iZza - i) - iZzad2);
                    this.position = iZza;
                    return;
                }
                zzy(zznf.zza(str));
                this.position = zznf.zza(str, this.buffer, this.position, zzca());
            } catch (zznj e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zza(int i, zzlq zzlqVar, zzmf zzmfVar) throws zzb {
            zzb(i, 2);
            zzit zzitVar = (zzit) zzlqVar;
            int iZzbm = zzitVar.zzbm();
            if (iZzbm == -1) {
                iZzbm = zzmfVar.zzn(zzitVar);
                zzitVar.zzo(iZzbm);
            }
            zzy(iZzbm);
            zzmfVar.zza(zzlqVar, this.zzoh);
        }

        @Override // com.google.android.gms.internal.drive.zzjr
        public final void zza(int i, zzlq zzlqVar) throws zzb {
            zzb(1, 3);
            zzd(2, i);
            zzb(3, 2);
            zzb(zzlqVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.drive.zzjb
        public final void zza(byte[] bArr, int i, int i2) throws zzb {
            write(bArr, i, i2);
        }
    }

    public static class zzb extends IOException {
        public zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public zzb(String str, Throwable th) {
            String strValueOf = String.valueOf(str);
            super(strValueOf.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(strValueOf) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
        }
    }

    private zzjr() {
    }

    public static int zzab(int i) {
        return zzad(i << 3);
    }

    public static int zzac(int i) {
        if (i >= 0) {
            return zzad(i);
        }
        return 10;
    }

    public static int zzad(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzae(int i) {
        return zzad(zzai(i));
    }

    public static int zzaf(int i) {
        return 4;
    }

    public static int zzag(int i) {
        return 4;
    }

    public static int zzah(int i) {
        return zzac(i);
    }

    private static int zzai(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzaj(int i) {
        return zzad(i);
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzd(boolean z) {
        return 1;
    }

    public static int zzf(int i, long j) {
        return zzp(zzt(j)) + zzab(i);
    }

    public static int zzg(int i, int i2) {
        return zzac(i2) + zzab(i);
    }

    public static int zzh(int i, int i2) {
        return zzad(i2) + zzab(i);
    }

    public static int zzi(int i, int i2) {
        return zzad(zzai(i2)) + zzab(i);
    }

    public static int zzj(int i, int i2) {
        return zzab(i) + 4;
    }

    public static int zzk(int i, int i2) {
        return zzab(i) + 4;
    }

    public static int zzl(int i, int i2) {
        return zzac(i2) + zzab(i);
    }

    public static int zzo(long j) {
        return zzp(j);
    }

    public static int zzp(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int zzq(long j) {
        return zzp(zzt(j));
    }

    public static int zzr(long j) {
        return 8;
    }

    public static int zzs(long j) {
        return 8;
    }

    private static long zzt(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public final void zza(int i, float f) {
        zzf(i, Float.floatToRawIntBits(f));
    }

    public abstract void zza(int i, long j);

    public abstract void zza(int i, zzjc zzjcVar);

    public abstract void zza(int i, zzlq zzlqVar);

    public abstract void zza(int i, zzlq zzlqVar, zzmf zzmfVar);

    public abstract void zza(int i, String str);

    public abstract void zza(zzjc zzjcVar);

    public abstract void zzaa(int i);

    public abstract void zzb(int i, int i2);

    public abstract void zzb(int i, zzjc zzjcVar);

    public abstract void zzb(int i, boolean z);

    public abstract void zzb(zzlq zzlqVar);

    public abstract void zzc(byte b);

    public abstract void zzc(int i, int i2);

    public abstract void zzc(int i, long j);

    public final void zzc(boolean z) {
        zzc(z ? (byte) 1 : (byte) 0);
    }

    public abstract int zzca();

    public final void zzcb() {
        if (zzca() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void zzd(int i, int i2);

    public abstract void zzd(byte[] bArr, int i, int i2);

    public final void zze(int i, int i2) {
        zzd(i, zzai(i2));
    }

    public abstract void zzf(int i, int i2);

    public abstract void zzl(long j);

    public abstract void zzl(String str);

    public final void zzm(long j) {
        zzl(zzt(j));
    }

    public abstract void zzn(long j);

    public abstract void zzx(int i);

    public abstract void zzy(int i);

    public final void zzz(int i) {
        zzy(zzai(i));
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzc(int i, boolean z) {
        return zzab(i) + 1;
    }

    public static int zzd(int i, long j) {
        return zzp(j) + zzab(i);
    }

    public static int zze(int i, long j) {
        return zzp(j) + zzab(i);
    }

    public static int zzg(int i, long j) {
        return zzab(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzab(i) + 8;
    }

    public static int zzm(String str) {
        int length;
        try {
            length = zznf.zza(str);
        } catch (zznj unused) {
            length = str.getBytes(zzkm.UTF_8).length;
        }
        return zzad(length) + length;
    }

    public final void zza(int i, double d) {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public static zzjr zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzc(int i, zzjc zzjcVar) {
        int iZzab = zzab(i);
        int size = zzjcVar.size();
        return zzad(size) + size + iZzab;
    }

    public final void zza(float f) {
        zzaa(Float.floatToRawIntBits(f));
    }

    public static int zzd(int i, zzjc zzjcVar) {
        return zzc(3, zzjcVar) + zzh(2, i) + (zzab(1) << 1);
    }

    public final void zza(double d) {
        zzn(Double.doubleToRawLongBits(d));
    }

    public static int zza(int i, zzkx zzkxVar) {
        int iZzab = zzab(i);
        int iZzcx = zzkxVar.zzcx();
        return zzad(iZzcx) + iZzcx + iZzab;
    }

    public final void zzb(int i, long j) {
        zza(i, zzt(j));
    }

    public static int zzb(int i, float f) {
        return zzab(i) + 4;
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        return zzad(length) + length;
    }

    public static int zzb(int i, double d) {
        return zzab(i) + 8;
    }

    @Deprecated
    public static int zzd(zzlq zzlqVar) {
        return zzlqVar.zzcx();
    }

    public static int zza(zzkx zzkxVar) {
        int iZzcx = zzkxVar.zzcx();
        return zzad(iZzcx) + iZzcx;
    }

    public static int zzb(int i, String str) {
        return zzm(str) + zzab(i);
    }

    public static int zzc(zzlq zzlqVar) {
        int iZzcx = zzlqVar.zzcx();
        return zzad(iZzcx) + iZzcx;
    }

    public static int zzb(int i, zzlq zzlqVar, zzmf zzmfVar) {
        return zza(zzlqVar, zzmfVar) + zzab(i);
    }

    public static int zza(zzlq zzlqVar, zzmf zzmfVar) {
        zzit zzitVar = (zzit) zzlqVar;
        int iZzbm = zzitVar.zzbm();
        if (iZzbm == -1) {
            iZzbm = zzmfVar.zzn(zzitVar);
            zzitVar.zzo(iZzbm);
        }
        return zzad(iZzbm) + iZzbm;
    }

    public static int zzb(int i, zzlq zzlqVar) {
        return zzc(zzlqVar) + zzab(3) + zzh(2, i) + (zzab(1) << 1);
    }

    @Deprecated
    public static int zzc(int i, zzlq zzlqVar, zzmf zzmfVar) {
        int iZzab = zzab(i) << 1;
        zzit zzitVar = (zzit) zzlqVar;
        int iZzbm = zzitVar.zzbm();
        if (iZzbm == -1) {
            iZzbm = zzmfVar.zzn(zzitVar);
            zzitVar.zzo(iZzbm);
        }
        return iZzab + iZzbm;
    }

    public static int zzb(int i, zzkx zzkxVar) {
        return zza(3, zzkxVar) + zzh(2, i) + (zzab(1) << 1);
    }

    public final void zza(String str, zznj zznjVar) throws zzb {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zznjVar);
        byte[] bytes = str.getBytes(zzkm.UTF_8);
        try {
            zzy(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (zzb e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzb(e2);
        }
    }

    public static int zzb(zzjc zzjcVar) {
        int size = zzjcVar.size();
        return zzad(size) + size;
    }
}
