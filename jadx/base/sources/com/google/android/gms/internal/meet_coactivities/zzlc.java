package com.google.android.gms.internal.meet_coactivities;

import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzlc extends zzlt {
    public zzlc(String str, Class cls, boolean z) {
        super("group_by", cls, true);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzlt
    public final void zza(Iterator it, zzls zzlsVar) {
        if (it.hasNext()) {
            Object next = it.next();
            if (!it.hasNext()) {
                zzlsVar.zza(zzf(), next);
                return;
            }
            StringBuilder sb = new StringBuilder("[");
            sb.append(next);
            do {
                sb.append(',');
                sb.append(it.next());
            } while (it.hasNext());
            String strZzf = zzf();
            sb.append(PropertyUtils.INDEXED_DELIM2);
            zzlsVar.zza(strZzf, sb.toString());
        }
    }
}
