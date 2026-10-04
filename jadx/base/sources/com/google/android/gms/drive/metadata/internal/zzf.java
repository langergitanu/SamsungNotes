package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.drive.zzhs;
import com.google.android.gms.internal.drive.zzid;
import com.google.android.gms.internal.drive.zzif;
import com.google.android.gms.internal.drive.zzin;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class zzf {
    private static final Map<String, MetadataField<?>> zzjf = new HashMap();
    private static final Map<String, zzg> zzjg = new HashMap();

    static {
        zzb(zzhs.zzjl);
        zzb(zzhs.zzkr);
        zzb(zzhs.zzki);
        zzb(zzhs.zzkp);
        zzb(zzhs.zzks);
        zzb(zzhs.zzjy);
        zzb(zzhs.zzjx);
        zzb(zzhs.zzjz);
        zzb(zzhs.zzka);
        zzb(zzhs.zzkb);
        zzb(zzhs.zzjv);
        zzb(zzhs.zzkd);
        zzb(zzhs.zzke);
        zzb(zzhs.zzkf);
        zzb(zzhs.zzkn);
        zzb(zzhs.zzjm);
        zzb(zzhs.zzkk);
        zzb(zzhs.zzjo);
        zzb(zzhs.zzjw);
        zzb(zzhs.zzjp);
        zzb(zzhs.zzjq);
        zzb(zzhs.zzjr);
        zzb(zzhs.zzjs);
        zzb(zzhs.zzkh);
        zzb(zzhs.zzkc);
        zzb(zzhs.zzkj);
        zzb(zzhs.zzkl);
        zzb(zzhs.zzkm);
        zzb(zzhs.zzko);
        zzb(zzhs.zzkt);
        zzb(zzhs.zzku);
        zzb(zzhs.zzju);
        zzb(zzhs.zzjt);
        zzb(zzhs.zzkq);
        zzb(zzhs.zzkg);
        zzb(zzhs.zzjn);
        zzb(zzhs.zzkv);
        zzb(zzhs.zzkw);
        zzb(zzhs.zzkx);
        zzb(zzhs.zzky);
        zzb(zzhs.zzkz);
        zzb(zzhs.zzla);
        zzb(zzhs.zzlb);
        zzb(zzif.zzld);
        zzb(zzif.zzlf);
        zzb(zzif.zzlg);
        zzb(zzif.zzlh);
        zzb(zzif.zzle);
        zzb(zzif.zzli);
        zzb(zzin.zzlk);
        zzb(zzin.zzll);
        zza(zzo.zzjk);
        zza(zzid.zzlc);
    }

    public static void zza(DataHolder dataHolder) {
        Iterator<zzg> it = zzjg.values().iterator();
        while (it.hasNext()) {
            it.next().zzb(dataHolder);
        }
    }

    private static void zzb(MetadataField<?> metadataField) {
        Map<String, MetadataField<?>> map = zzjf;
        if (map.containsKey(metadataField.getName())) {
            String strValueOf = String.valueOf(metadataField.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Duplicate field name registered: ".concat(strValueOf) : new String("Duplicate field name registered: "));
        }
        map.put(metadataField.getName(), metadataField);
    }

    public static Collection<MetadataField<?>> zzbc() {
        return Collections.unmodifiableCollection(zzjf.values());
    }

    public static MetadataField<?> zzf(String str) {
        return zzjf.get(str);
    }

    private static void zza(zzg zzgVar) {
        if (zzjg.put(zzgVar.zzbd(), zzgVar) == null) {
            return;
        }
        String strZzbd = zzgVar.zzbd();
        StringBuilder sb = new StringBuilder(AbstractC4539a.m3194d(46, strZzbd));
        sb.append("A cleaner for key ");
        sb.append(strZzbd);
        sb.append(" has already been registered");
        throw new IllegalStateException(sb.toString());
    }
}
