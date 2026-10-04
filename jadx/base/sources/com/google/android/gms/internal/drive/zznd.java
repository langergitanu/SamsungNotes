package com.google.android.gms.internal.drive;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes5.dex */
final class zznd {
    private static final Logger logger = Logger.getLogger(zznd.class.getName());
    private static final Class<?> zzni;
    private static final boolean zzog;
    private static final Unsafe zzuc;
    private static final boolean zzvy;
    private static final boolean zzvz;
    private static final zzd zzwa;
    private static final boolean zzwb;
    private static final long zzwc;
    private static final long zzwd;
    private static final long zzwe;
    private static final long zzwf;
    private static final long zzwg;
    private static final long zzwh;
    private static final long zzwi;
    private static final long zzwj;
    private static final long zzwk;
    private static final long zzwl;
    private static final long zzwm;
    private static final long zzwn;
    private static final long zzwo;
    private static final long zzwp;
    private static final int zzwq;
    static final boolean zzwr;

    public static final class zzc extends zzd {
        public zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zzws.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zze(Object obj, long j, byte b) {
            this.zzws.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final boolean zzl(Object obj, long j) {
            return this.zzws.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final float zzm(Object obj, long j) {
            return this.zzws.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final double zzn(Object obj, long j) {
            return this.zzws.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final byte zzx(Object obj, long j) {
            return this.zzws.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, float f) {
            this.zzws.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, double d) {
            this.zzws.putDouble(obj, j, d);
        }
    }

    public static abstract class zzd {
        Unsafe zzws;

        public zzd(Unsafe unsafe) {
            this.zzws = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, int i) {
            this.zzws.putInt(obj, j, i);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public final int zzj(Object obj, long j) {
            return this.zzws.getInt(obj, j);
        }

        public final long zzk(Object obj, long j) {
            return this.zzws.getLong(obj, j);
        }

        public abstract boolean zzl(Object obj, long j);

        public abstract float zzm(Object obj, long j);

        public abstract double zzn(Object obj, long j);

        public abstract byte zzx(Object obj, long j);

        public final void zza(Object obj, long j, long j2) {
            this.zzws.putLong(obj, j, j2);
        }
    }

    static {
        Unsafe unsafeZzff = zzff();
        zzuc = unsafeZzff;
        zzni = zzix.zzbs();
        boolean zZzk = zzk(Long.TYPE);
        zzvy = zZzk;
        boolean zZzk2 = zzk(Integer.TYPE);
        zzvz = zZzk2;
        zzd zzcVar = null;
        if (unsafeZzff != null) {
            if (!zzix.zzbr()) {
                zzcVar = new zzc(unsafeZzff);
            } else if (zZzk) {
                zzcVar = new zzb(unsafeZzff);
            } else if (zZzk2) {
                zzcVar = new zza(unsafeZzff);
            }
        }
        zzwa = zzcVar;
        zzwb = zzfh();
        zzog = zzfg();
        long jZzi = zzi(byte[].class);
        zzwc = jZzi;
        zzwd = zzi(boolean[].class);
        zzwe = zzj(boolean[].class);
        zzwf = zzi(int[].class);
        zzwg = zzj(int[].class);
        zzwh = zzi(long[].class);
        zzwi = zzj(long[].class);
        zzwj = zzi(float[].class);
        zzwk = zzj(float[].class);
        zzwl = zzi(double[].class);
        zzwm = zzj(double[].class);
        zzwn = zzi(Object[].class);
        zzwo = zzj(Object[].class);
        Field fieldZzfi = zzfi();
        zzwp = (fieldZzfi == null || zzcVar == null) ? -1L : zzcVar.zzws.objectFieldOffset(fieldZzfi);
        zzwq = (int) (jZzi & 7);
        zzwr = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zznd() {
    }

    public static void zza(Object obj, long j, int i) {
        zzwa.zza(obj, j, i);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : (byte) 0);
    }

    public static boolean zzfd() {
        return zzog;
    }

    public static boolean zzfe() {
        return zzwb;
    }

    public static Unsafe zzff() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzne());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzfg() {
        Unsafe unsafe = zzuc;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (zzix.zzbr()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzfh() {
        Unsafe unsafe = zzuc;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (zzfi() == null) {
                return false;
            }
            if (zzix.zzbr()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static Field zzfi() {
        Field fieldZzb;
        if (zzix.zzbr() && (fieldZzb = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldZzb;
        }
        Field fieldZzb2 = zzb(Buffer.class, "address");
        if (fieldZzb2 == null || fieldZzb2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzb2;
    }

    public static <T> T zzh(Class<T> cls) {
        try {
            return (T) zzuc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzi(Class<?> cls) {
        if (zzog) {
            return zzwa.zzws.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzj(Class<?> cls) {
        if (zzog) {
            return zzwa.zzws.arrayIndexScale(cls);
        }
        return -1;
    }

    public static long zzk(Object obj, long j) {
        return zzwa.zzk(obj, j);
    }

    public static boolean zzl(Object obj, long j) {
        return zzwa.zzl(obj, j);
    }

    public static float zzm(Object obj, long j) {
        return zzwa.zzm(obj, j);
    }

    public static double zzn(Object obj, long j) {
        return zzwa.zzn(obj, j);
    }

    public static Object zzo(Object obj, long j) {
        return zzwa.zzws.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzp(Object obj, long j) {
        return (byte) (zzj(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzj(obj, (-4) & j) >>> ((int) ((j & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzr(Object obj, long j) {
        return zzp(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    public static void zza(Object obj, long j, long j2) {
        zzwa.zza(obj, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj(obj, j2) & (~(255 << i))));
    }

    private static boolean zzk(Class<?> cls) {
        if (!zzix.zzbr()) {
            return false;
        }
        try {
            Class<?> cls2 = zzni;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final class zza extends zzd {
        public zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zznd.zzwr) {
                zznd.zzb(obj, j, z);
            } else {
                zznd.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zznd.zzwr) {
                zznd.zza(obj, j, b);
            } else {
                zznd.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final boolean zzl(Object obj, long j) {
            return zznd.zzwr ? zznd.zzr(obj, j) : zznd.zzs(obj, j);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final byte zzx(Object obj, long j) {
            return zznd.zzwr ? zznd.zzp(obj, j) : zznd.zzq(obj, j);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    public static final class zzb extends zzd {
        public zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zznd.zzwr) {
                zznd.zzb(obj, j, z);
            } else {
                zznd.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zznd.zzwr) {
                zznd.zza(obj, j, b);
            } else {
                zznd.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final boolean zzl(Object obj, long j) {
            return zznd.zzwr ? zznd.zzr(obj, j) : zznd.zzs(obj, j);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final byte zzx(Object obj, long j) {
            return zznd.zzwr ? zznd.zzp(obj, j) : zznd.zzq(obj, j);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    public static void zza(Object obj, long j, boolean z) {
        zzwa.zza(obj, j, z);
    }

    public static int zzj(Object obj, long j) {
        return zzwa.zzj(obj, j);
    }

    public static void zza(Object obj, long j, float f) {
        zzwa.zza(obj, j, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : (byte) 0);
    }

    public static void zza(Object obj, long j, double d) {
        zzwa.zza(obj, j, d);
    }

    public static void zza(Object obj, long j, Object obj2) {
        zzwa.zzws.putObject(obj, j, obj2);
    }

    public static byte zza(byte[] bArr, long j) {
        return zzwa.zzx(bArr, zzwc + j);
    }

    public static void zza(byte[] bArr, long j, byte b) {
        zzwa.zze(bArr, zzwc + j, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int iZzj = zzj(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (iZzj & (~(255 << i))));
    }
}
