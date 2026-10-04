package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* JADX INFO: loaded from: classes5.dex */
public final class zzaa extends Metadata {
    private final MetadataBundle zzdt;

    public zzaa(MetadataBundle metadataBundle) {
        this.zzdt = metadataBundle;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Metadata freeze() {
        return new zzaa(this.zzdt.zzbf());
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return this.zzdt != null;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzdt);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 17);
        sb.append("Metadata [mImpl=");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.gms.drive.Metadata
    public final <T> T zza(MetadataField<T> metadataField) {
        return (T) this.zzdt.zza(metadataField);
    }
}
