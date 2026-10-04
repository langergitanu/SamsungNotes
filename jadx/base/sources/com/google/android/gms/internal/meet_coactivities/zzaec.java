package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.internal.GrpcUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaec {
    private final zzzh zza;
    private final String zzb = (String) Preconditions.checkNotNull(GrpcUtil.DEFAULT_LB_POLICY, "defaultPolicy");

    @VisibleForTesting
    public zzaec(zzzh zzzhVar, String str) {
        this.zza = (zzzh) Preconditions.checkNotNull(zzzhVar, "registry");
    }

    public static /* bridge */ /* synthetic */ zzzf zza(zzaec zzaecVar, String str, String str2) throws zzaeb {
        zzzf zzzfVarZza = zzaecVar.zza.zza(str);
        if (zzzfVarZza != null) {
            return zzzfVarZza;
        }
        throw new zzaeb(AbstractC0541b.m773o("Trying to load '", str, "' because using default policy, but it's unavailable"), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzaag zzc(Map map) {
        List<zzaoi> listUnmodifiableList;
        String strZze;
        if (map != null) {
            try {
                ArrayList arrayList = new ArrayList();
                if (map.containsKey("loadBalancingConfig")) {
                    arrayList.addAll(zzaiu.zzh(map, "loadBalancingConfig"));
                }
                if (arrayList.isEmpty() && (strZze = zzaiu.zze(map, "loadBalancingPolicy")) != null) {
                    arrayList.add(Collections.singletonMap(strZze.toLowerCase(Locale.ROOT), Collections.EMPTY_MAP));
                }
                List<Map> listUnmodifiableList2 = Collections.unmodifiableList(arrayList);
                if (listUnmodifiableList2 == null) {
                    listUnmodifiableList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (Map map2 : listUnmodifiableList2) {
                        if (map2.size() != 1) {
                            throw new RuntimeException("There are " + map2.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + String.valueOf(map2));
                        }
                        String str = (String) ((Map.Entry) map2.entrySet().iterator().next()).getKey();
                        arrayList2.add(new zzaoi(str, zzaiu.zzj(map2, str)));
                    }
                    listUnmodifiableList = Collections.unmodifiableList(arrayList2);
                }
            } catch (RuntimeException e) {
                return zzaag.zzb(zzabd.zzc.zze("can't parse load balancer configuration").zzd(e));
            }
        }
        if (listUnmodifiableList == null || listUnmodifiableList.isEmpty()) {
            return null;
        }
        zzzh zzzhVar = this.zza;
        ArrayList arrayList3 = new ArrayList();
        for (zzaoi zzaoiVar : listUnmodifiableList) {
            String strZza = zzaoiVar.zza();
            zzzf zzzfVarZza = zzzhVar.zza(strZza);
            if (zzzfVarZza != null) {
                if (!arrayList3.isEmpty()) {
                    Logger.getLogger(zzaok.class.getName()).logp(Level.FINEST, "io.grpc.internal.ServiceConfigUtil", "selectLbPolicyFromList", "{0} specified by Service Config are not available", arrayList3);
                }
                zzaag zzaagVarZzc = zzzfVarZza.zzc(zzaoiVar.zzb());
                return zzaagVarZzc.zzc() == null ? zzaag.zza(new zzaoj(zzzfVarZza, zzaagVarZzc.zzd())) : zzaagVarZzc;
            }
            arrayList3.add(strZza);
        }
        return zzaag.zzb(zzabd.zzc.zze("None of " + arrayList3.toString() + " specified by Service Config are available."));
    }
}
