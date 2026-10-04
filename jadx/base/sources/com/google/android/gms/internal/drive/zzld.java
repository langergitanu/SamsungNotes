package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes5.dex */
final class zzld extends zzla {
    private zzld() {
        super();
    }

    private static <E> zzkp<E> zzc(Object obj, long j) {
        return (zzkp) zznd.zzo(obj, j);
    }

    @Override // com.google.android.gms.internal.drive.zzla
    public final void zza(Object obj, long j) {
        zzc(obj, j).zzbp();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.google.android.gms.internal.drive.zzkp, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // com.google.android.gms.internal.drive.zzla
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzkp zzkpVarZzc = zzc(obj, j);
        ?? Zzc = zzc(obj2, j);
        int size = zzkpVarZzc.size();
        int size2 = Zzc.size();
        ?? r02 = zzkpVarZzc;
        r02 = zzkpVarZzc;
        if (size > 0 && size2 > 0) {
            boolean zZzbo = zzkpVarZzc.zzbo();
            ?? Zzr = zzkpVarZzc;
            if (!zZzbo) {
                Zzr = zzkpVarZzc.zzr(size2 + size);
            }
            Zzr.addAll(Zzc);
            r02 = Zzr;
        }
        if (size > 0) {
            Zzc = r02;
        }
        zznd.zza(obj, j, (Object) Zzc);
    }
}
