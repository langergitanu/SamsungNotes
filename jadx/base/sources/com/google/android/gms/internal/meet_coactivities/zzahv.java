package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.samsung.android.support.senl.p148nt.coedit.control.serverspis.SCloudServerConstants;
import io.grpc.internal.GrpcUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahv {
    public static final zzzq zza;
    public static final zzzq zzb;
    public static final zzzq zzc;
    public static final zzzq zzd;
    public static final zzzq zze;
    static final zzzq zzf;
    public static final zzaat zzg;
    public static final zzwb zzh;
    public static final zzaoo zzi;
    public static final zzaoo zzj;
    public static final Supplier zzk;
    private static final Logger zzl = Logger.getLogger(zzahv.class.getName());
    private static final Set zzm = Collections.unmodifiableSet(EnumSet.of(zzaay.OK, zzaay.INVALID_ARGUMENT, zzaay.NOT_FOUND, zzaay.ALREADY_EXISTS, zzaay.FAILED_PRECONDITION, zzaay.ABORTED, zzaay.OUT_OF_RANGE, zzaay.DATA_LOSS));
    private static final zzwq zzn;

    static {
        Charset.forName("US-ASCII");
        zza = zzzq.zzc(GrpcUtil.TIMEOUT, new zzahu());
        zzzo zzzoVar = zzzv.zza;
        zzb = zzzq.zzc(GrpcUtil.MESSAGE_ENCODING, zzzoVar);
        zzc = zzyk.zzb(GrpcUtil.MESSAGE_ACCEPT_ENCODING, new zzaht(null));
        zzd = zzzq.zzc(GrpcUtil.CONTENT_ENCODING, zzzoVar);
        zze = zzyk.zzb(GrpcUtil.CONTENT_ACCEPT_ENCODING, new zzaht(null));
        zzf = zzzq.zzc("content-length", zzzoVar);
        zzzq.zzc("content-type", zzzoVar);
        zzzq.zzc("te", zzzoVar);
        zzzq.zzc(SCloudServerConstants.USER_AGENT_HEADER, zzzoVar);
        Splitter.m4272on(',').trimResults();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        timeUnit.toNanos(20L);
        TimeUnit.HOURS.toNanos(2L);
        timeUnit.toNanos(20L);
        zzg = new zzamb();
        zzh = zzwb.zza("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        zzn = new zzaho();
        zzi = new zzahp();
        zzj = new zzahq();
        zzk = new zzahr();
    }

    private zzahv() {
    }

    public static zzabd zza(zzabd zzabdVar) {
        Preconditions.checkArgument(zzabdVar != null);
        if (!zzm.contains(zzabdVar.zza())) {
            return zzabdVar;
        }
        return zzabd.zzj.zze("Inappropriate status code from control plane: " + String.valueOf(zzabdVar.zza()) + " " + zzabdVar.zzg()).zzd(zzabdVar.zzh());
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.google.android.gms.internal.meet_coactivities.zzaox, java.lang.Object] */
    @Nullable
    public static zzaev zzb(zzyv zzyvVar, boolean z) {
        zzza zzzaVarZze = zzyvVar.zze();
        zzaev zzaevVarZzh = zzzaVarZze != null ? zzzaVarZze.zza().zzh() : null;
        if (zzaevVarZzh != null) {
            return zzaevVarZzh;
        }
        if (!zzyvVar.zzf().zzj()) {
            if (zzyvVar.zzg()) {
                return new zzahg(zza(zzyvVar.zzf()), zzaet.DROPPED);
            }
            if (!z) {
                return new zzahg(zza(zzyvVar.zzf()), zzaet.PROCESSED);
            }
        }
        return null;
    }

    public static String zzc(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", null).invoke(inetSocketAddress, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static ThreadFactory zzd(String str, boolean z) {
        return new ThreadFactoryBuilder().setDaemon(true).setNameFormat(str).build();
    }

    public static void zze(zzaot zzaotVar) {
        while (true) {
            InputStream inputStreamZzf = zzaotVar.zzf();
            if (inputStreamZzf == null) {
                return;
            } else {
                zzf(inputStreamZzf);
            }
        }
    }

    public static void zzf(@Nullable Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            zzl.logp(Level.WARNING, "io.grpc.internal.GrpcUtil", "closeQuietly", "exception caught in closeQuietly", (Throwable) e);
        }
    }

    public static boolean zzg(String str, boolean z) {
        String strTrim = System.getenv(str);
        if (strTrim == null) {
            strTrim = System.getProperty(str);
        }
        if (strTrim != null) {
            strTrim = strTrim.trim();
        }
        return !Strings.isNullOrEmpty(strTrim) && Boolean.parseBoolean(strTrim);
    }

    public static zzwq[] zzh(zzwd zzwdVar, zzzv zzzvVar, int i, boolean z) {
        List listZzm = zzwdVar.zzm();
        int size = listZzm.size();
        zzwq[] zzwqVarArr = new zzwq[size + 1];
        zzwo zzwoVarZza = zzwp.zza();
        zzwoVarZza.zza(zzwdVar);
        zzwoVarZza.zzc(i);
        zzwoVarZza.zzb(z);
        zzwp zzwpVarZzd = zzwoVarZza.zzd();
        for (int i2 = 0; i2 < listZzm.size(); i2++) {
            zzwqVarArr[i2] = ((zzwn) listZzm.get(i2)).zza(zzwpVarZzd, zzzvVar);
        }
        zzwqVarArr[size] = zzn;
        return zzwqVarArr;
    }
}
