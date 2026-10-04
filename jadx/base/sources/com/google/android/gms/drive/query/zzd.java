package com.google.android.gms.drive.query;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.internal.zzj;
import com.google.android.gms.drive.query.internal.zzx;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class zzd implements zzj<String> {
    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zza(zzx zzxVar, List<String> list) {
        StringBuilder sb = new StringBuilder(String.valueOf(zzxVar.getTag()).concat("("));
        String str = "";
        for (String str2 : list) {
            sb.append(str);
            sb.append(str2);
            str = ",";
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zzbj() {
        return "ownedByMe()";
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zzbk() {
        return "all()";
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zzc(MetadataField metadataField, Object obj) {
        return String.format("has(%s,%s)", metadataField.getName(), obj);
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zze(MetadataField metadataField) {
        return AbstractC0541b.m773o("fieldOnly(", metadataField.getName(), ")");
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zzi(String str) {
        return AbstractC0541b.m773o("fullTextSearch(", str, ")");
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zza(String str) {
        return AbstractC0541b.m773o("not(", str, ")");
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zza(com.google.android.gms.drive.metadata.zzb zzbVar, Object obj) {
        return String.format("contains(%s,%s)", zzbVar.getName(), obj);
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ String zza(zzx zzxVar, MetadataField metadataField, Object obj) {
        return String.format("cmp(%s,%s,%s)", zzxVar.getTag(), metadataField.getName(), obj);
    }
}
