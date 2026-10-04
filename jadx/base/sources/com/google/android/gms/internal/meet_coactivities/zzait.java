package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzait {
    private static final Logger zza = Logger.getLogger(zzait.class.getName());

    private zzait() {
    }

    public static Object zza(String str) {
        zzpt zzptVar = new zzpt(new StringReader(str));
        try {
            Object objZzb = zzb(zzptVar);
            try {
                zzptVar.close();
                return objZzb;
            } catch (IOException e) {
                zza.logp(Level.WARNING, "io.grpc.internal.JsonParser", "parse", "Failed to close", (Throwable) e);
                return objZzb;
            }
        } finally {
        }
    }

    private static Object zzb(zzpt zzptVar) throws IOException {
        Preconditions.checkState(zzptVar.zzl(), "unexpected end of JSON");
        int iZzn = zzptVar.zzn() - 1;
        if (iZzn == 0) {
            zzptVar.zzg();
            ArrayList arrayList = new ArrayList();
            while (zzptVar.zzl()) {
                arrayList.add(zzb(zzptVar));
            }
            Preconditions.checkState(zzptVar.zzn() == 2, "Bad token: ".concat(zzptVar.zzc()));
            zzptVar.zzi();
            return Collections.unmodifiableList(arrayList);
        }
        if (iZzn == 2) {
            zzptVar.zzh();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (zzptVar.zzl()) {
                linkedHashMap.put(zzptVar.zze(), zzb(zzptVar));
            }
            Preconditions.checkState(zzptVar.zzn() == 4, "Bad token: ".concat(zzptVar.zzc()));
            zzptVar.zzj();
            return Collections.unmodifiableMap(linkedHashMap);
        }
        if (iZzn == 5) {
            return zzptVar.zzf();
        }
        if (iZzn == 6) {
            return Double.valueOf(zzptVar.zza());
        }
        if (iZzn == 7) {
            return Boolean.valueOf(zzptVar.zzm());
        }
        if (iZzn != 8) {
            throw new IllegalStateException("Bad token: ".concat(zzptVar.zzc()));
        }
        zzptVar.zzk();
        return null;
    }
}
