package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes5.dex */
final class zzlh implements zzlp {
    private zzlp[] zztt;

    public zzlh(zzlp... zzlpVarArr) {
        this.zztt = zzlpVarArr;
    }

    @Override // com.google.android.gms.internal.drive.zzlp
    public final boolean zzb(Class<?> cls) {
        for (zzlp zzlpVar : this.zztt) {
            if (zzlpVar.zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.drive.zzlp
    public final zzlo zzc(Class<?> cls) {
        for (zzlp zzlpVar : this.zztt) {
            if (zzlpVar.zzb(cls)) {
                return zzlpVar.zzc(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
