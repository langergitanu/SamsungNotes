package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@VisibleForTesting
public final class zzanz extends zzaal {
    private final boolean zza;
    private final zzaec zzb;

    public zzanz(boolean z, int i, int i2, zzaec zzaecVar) {
        this.zza = z;
        this.zzb = (zzaec) Preconditions.checkNotNull(zzaecVar, "autoLoadBalancerFactory");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaal
    public final zzaag zza(Map map) {
        Object objZzd;
        zzanq zzanqVar;
        zzala zzalaVar;
        Map mapZzj;
        try {
            zzaag zzaagVarZzc = this.zzb.zzc(map);
            zzakx zzakxVar = null;
            if (zzaagVarZzc == null) {
                objZzd = null;
            } else {
                if (zzaagVarZzc.zzc() != null) {
                    return zzaag.zzb(zzaagVarZzc.zzc());
                }
                objZzd = zzaagVarZzc.zzd();
            }
            boolean z = this.zza;
            if (!z || map == null || (mapZzj = zzaiu.zzj(map, "retryThrottling")) == null) {
                zzanqVar = null;
            } else {
                float fFloatValue = zzaiu.zzb(mapZzj, "maxTokens").floatValue();
                float fFloatValue2 = zzaiu.zzb(mapZzj, "tokenRatio").floatValue();
                Preconditions.checkState(fFloatValue > 0.0f, "maxToken should be greater than zero");
                Preconditions.checkState(fFloatValue2 > 0.0f, "tokenRatio should be greater than zero");
                zzanqVar = new zzanq(fFloatValue, fFloatValue2);
            }
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            Map mapZzj2 = map == null ? null : zzaiu.zzj(map, "healthCheckConfig");
            List<Map> listZzh = zzaiu.zzh(map, "methodConfig");
            if (listZzh == null) {
                zzalaVar = new zzala(null, map2, map3, zzanqVar, objZzd, mapZzj2);
            } else {
                for (Map map4 : listZzh) {
                    zzakx zzakxVar2 = new zzakx(map4, z, 5, 5);
                    List<Map> listZzh2 = zzaiu.zzh(map4, "name");
                    if (listZzh2 != null && !listZzh2.isEmpty()) {
                        for (Map map5 : listZzh2) {
                            String strZze = zzaiu.zze(map5, "service");
                            String strZze2 = zzaiu.zze(map5, "method");
                            if (Strings.isNullOrEmpty(strZze)) {
                                Preconditions.checkArgument(Strings.isNullOrEmpty(strZze2), "missing service name for method %s", strZze2);
                                Preconditions.checkArgument(zzakxVar == null, "Duplicate default method config in service config %s", map);
                                zzakxVar = zzakxVar2;
                            } else if (Strings.isNullOrEmpty(strZze2)) {
                                Preconditions.checkArgument(!map3.containsKey(strZze), "Duplicate service %s", strZze);
                                map3.put(strZze, zzakxVar2);
                            } else {
                                String strZze3 = zzaab.zze(strZze, strZze2);
                                Preconditions.checkArgument(!map2.containsKey(strZze3), "Duplicate method name %s", strZze3);
                                map2.put(strZze3, zzakxVar2);
                            }
                        }
                    }
                }
                zzalaVar = new zzala(zzakxVar, map2, map3, zzanqVar, objZzd, mapZzj2);
            }
            return zzaag.zza(zzalaVar);
        } catch (RuntimeException e) {
            return zzaag.zzb(zzabd.zzc.zze("failed to parse service config").zzd(e));
        }
    }
}
