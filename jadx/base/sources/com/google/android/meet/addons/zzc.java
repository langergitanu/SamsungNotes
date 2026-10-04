package com.google.android.meet.addons;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzc extends zzb {
    private String zza;

    @Override // com.google.android.meet.addons.zzb
    public final zzb zza(String str) {
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.zza = str;
        return this;
    }

    @Override // com.google.android.meet.addons.zzb
    public final AddonExceptionMetadata zzb() {
        String str = this.zza;
        if (str != null) {
            return new zze(str, null);
        }
        throw new IllegalStateException("Missing required properties: packageName");
    }
}
