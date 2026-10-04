package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapl {
    static final zzwb zza;
    private static final Logger zzb = Logger.getLogger(zzapl.class.getName());

    static {
        if (!Strings.isNullOrEmpty(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"))) {
            Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"));
        }
        zza = zzwb.zza("internal-stub-type");
    }

    private zzapl() {
    }

    public static zzapn zza(zzwi zzwiVar, zzapn zzapnVar) {
        Preconditions.checkNotNull(zzapnVar, "responseObserver");
        zzapg zzapgVar = new zzapg(zzwiVar, true);
        zze(zzwiVar, new zzapj(zzapnVar, zzapgVar));
        return zzapgVar;
    }

    public static void zzb(zzwi zzwiVar, Object obj, zzapn zzapnVar) {
        Preconditions.checkNotNull(zzapnVar, "responseObserver");
        zzd(zzwiVar, obj, new zzapj(zzapnVar, new zzapg(zzwiVar, false)));
    }

    private static RuntimeException zzc(zzwi zzwiVar, Throwable th) {
        try {
            zzwiVar.zza(null, th);
        } catch (Error | RuntimeException e) {
            zzb.logp(Level.SEVERE, "io.grpc.stub.ClientCalls", "cancelThrow", "RuntimeException encountered while closing call", e);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new AssertionError(th);
    }

    private static void zzd(zzwi zzwiVar, Object obj, zzapi zzapiVar) {
        zze(zzwiVar, zzapiVar);
        try {
            zzwiVar.zzd(obj);
            zzwiVar.zzb();
        } catch (Error | RuntimeException e) {
            throw zzc(zzwiVar, e);
        }
    }

    private static void zze(zzwi zzwiVar, zzapi zzapiVar) {
        zzwiVar.zze(zzapiVar, new zzzv());
        zzapiVar.zze();
    }
}
