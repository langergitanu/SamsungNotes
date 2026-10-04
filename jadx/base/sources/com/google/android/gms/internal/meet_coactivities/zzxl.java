package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
public final class zzxl {
    static final Joiner zza = Joiner.m4265on(',');
    private static final zzxl zzb = new zzxl(zzwt.zza, false, new zzxl(new zzws(), true, new zzxl()));
    private final Map zzc;
    private final byte[] zzd;

    private zzxl() {
        this.zzc = new LinkedHashMap(0);
        this.zzd = new byte[0];
    }

    public static zzxl zza() {
        return zzb;
    }

    public final byte[] zzb() {
        return this.zzd;
    }

    private zzxl(zzxj zzxjVar, boolean z, zzxl zzxlVar) {
        String strZza = zzxjVar.zza();
        Preconditions.checkArgument(!strZza.contains(","), "Comma is currently not allowed in message encoding");
        int size = zzxlVar.zzc.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(zzxlVar.zzc.containsKey(zzxjVar.zza()) ? size : size + 1);
        for (zzxk zzxkVar : zzxlVar.zzc.values()) {
            String strZza2 = zzxkVar.zza.zza();
            if (!strZza2.equals(strZza)) {
                linkedHashMap.put(strZza2, new zzxk(zzxkVar.zza, zzxkVar.zzb));
            }
        }
        linkedHashMap.put(strZza, new zzxk(zzxjVar, z));
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        this.zzc = mapUnmodifiableMap;
        Joiner joiner = zza;
        HashSet hashSet = new HashSet(mapUnmodifiableMap.size());
        for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
            if (((zzxk) entry.getValue()).zzb) {
                hashSet.add((String) entry.getKey());
            }
        }
        this.zzd = joiner.join(Collections.unmodifiableSet(hashSet)).getBytes(Charset.forName("US-ASCII"));
    }
}
