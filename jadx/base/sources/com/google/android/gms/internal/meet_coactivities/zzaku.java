package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import io.grpc.internal.GrpcUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaku extends zzzk {
    private static final Method zzr;
    zzale zzd;
    final zzale zze;
    zzaaq zzf;
    final List zzg;
    final String zzh;
    final String zzi;
    final zzxl zzj;
    final zzww zzk;
    long zzl;
    final zzxz zzm;
    private final List zzs;
    private final zzakp zzt;
    private static final Logger zzn = Logger.getLogger(zzaku.class.getName());

    @VisibleForTesting
    static final long zza = TimeUnit.MINUTES.toMillis(30);
    static final long zzb = TimeUnit.SECONDS.toMillis(1);
    private static final zzale zzo = zzaoq.zzc(zzahv.zzi);
    private static final zzxl zzp = zzxl.zza();
    private static final zzww zzq = zzww.zza();

    @VisibleForTesting
    static final Pattern zzc = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    static {
        Method declaredMethod = null;
        try {
            Class cls = Boolean.TYPE;
            declaredMethod = zzadq.class.getDeclaredMethod("getClientInterceptor", cls, cls, cls, cls);
        } catch (ClassNotFoundException e) {
            zzn.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "<clinit>", "Unable to apply census stats", (Throwable) e);
        } catch (NoSuchMethodException e2) {
            zzn.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "<clinit>", "Unable to apply census stats", (Throwable) e2);
        }
        zzr = declaredMethod;
    }

    public zzaku(String str, @Nullable zzwf zzwfVar, @Nullable zzvz zzvzVar, zzakp zzakpVar, @Nullable zzako zzakoVar) {
        zzale zzaleVar = zzo;
        this.zzd = zzaleVar;
        this.zze = zzaleVar;
        this.zzs = new ArrayList();
        this.zzf = zzaaq.zzb();
        this.zzg = new ArrayList();
        this.zzi = GrpcUtil.DEFAULT_LB_POLICY;
        this.zzj = zzp;
        this.zzk = zzq;
        this.zzl = zza;
        this.zzm = zzxz.zza();
        new ArrayList();
        this.zzh = (String) Preconditions.checkNotNull(null, "target");
        this.zzt = (zzakp) Preconditions.checkNotNull(zzakpVar, "clientTransportFactoryBuilder");
        zzyf.zza(this);
    }

    @VisibleForTesting
    public static zzakt zzb(String str, zzaaq zzaaqVar, Collection collection) {
        URI uri;
        StringBuilder sb = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e) {
            sb.append(e.getMessage());
            uri = null;
        }
        zzaan zzaanVarZza = uri != null ? zzaaqVar.zza(uri.getScheme()) : null;
        if (zzaanVarZza == null && !zzc.matcher(str).matches()) {
            try {
                uri = new URI(zzaaqVar.zzc(), "", "/" + str, null);
                zzaanVarZza = zzaaqVar.zza(uri.getScheme());
            } catch (URISyntaxException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        if (zzaanVarZza == null) {
            throw new IllegalArgumentException(AbstractC0541b.m773o("Could not find a NameResolverProvider for ", str, sb.length() > 0 ? AbstractC0541b.m773o(" (", sb.toString(), ")") : ""));
        }
        if (collection == null || collection.containsAll(zzaanVarZza.zzd())) {
            return new zzakt(uri, zzaanVarZza);
        }
        throw new IllegalArgumentException(AbstractC0541b.m775q("Address types of NameResolver '", uri.getScheme(), "' for '", str, "' not supported by transport"));
    }

    @VisibleForTesting
    public static String zzf(SocketAddress socketAddress) {
        try {
            return new URI("directaddress", "", "/" + socketAddress.toString(), null).toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzk
    public final zzzi zza() {
        zzwj zzwjVar;
        String str = this.zzh;
        zzaex zzaexVarZza = this.zzt.zza();
        zzakt zzaktVarZzb = zzb(str, this.zzf, Collections.singleton(zzabn.class));
        URI uri = zzaktVarZzb.zza;
        zzaan zzaanVar = zzaktVarZzb.zzb;
        zzahd zzahdVar = new zzahd();
        zzaoq zzaoqVarZzc = zzaoq.zzc(zzahv.zzi);
        URI uri2 = zzaktVarZzb.zza;
        Supplier supplier = zzahv.zzk;
        uri2.toString();
        ArrayList arrayList = new ArrayList(this.zzs);
        int i = 0;
        while (true) {
            zzwj zzwjVar2 = null;
            if (i >= arrayList.size()) {
                zzyf.zzb();
                Method method = zzr;
                if (method != null) {
                    try {
                        Boolean bool = Boolean.TRUE;
                        zzwjVar = (zzwj) method.invoke(null, bool, bool, Boolean.FALSE, bool);
                    } catch (IllegalAccessException e) {
                        zzn.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e);
                        zzwjVar = null;
                    } catch (InvocationTargetException e2) {
                        zzn.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e2);
                        zzwjVar = null;
                    }
                } else {
                    zzwjVar = null;
                }
                if (zzwjVar != null) {
                    arrayList.add(0, zzwjVar);
                }
                try {
                    zzwjVar2 = (zzwj) zzadr.class.getDeclaredMethod("getClientInterceptor", null).invoke(null, null);
                } catch (ClassNotFoundException e3) {
                    zzn.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e3);
                } catch (IllegalAccessException e5) {
                    zzn.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e5);
                } catch (NoSuchMethodException e6) {
                    zzn.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e6);
                } catch (InvocationTargetException e7) {
                    zzn.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e7);
                }
                if (zzwjVar2 != null) {
                    arrayList.add(0, zzwjVar2);
                }
                return new zzakw(new zzakn(this, zzaexVarZza, uri, zzaanVar, zzahdVar, zzaoqVarZzc, supplier, arrayList, zzaow.zza));
            }
            if (arrayList.get(i) instanceof zzaks) {
                zzzj zzzjVar = ((zzaks) arrayList.get(i)).zza;
                throw null;
            }
            i++;
        }
    }

    public final zzaku zzc(Executor executor) {
        if (executor != null) {
            this.zzd = new zzahh(executor);
            return this;
        }
        this.zzd = zzo;
        return this;
    }

    public final zzaku zzd(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0, "idle timeout is %s, but must be positive", j);
        if (timeUnit.toDays(j) >= 30) {
            this.zzl = -1L;
            return this;
        }
        this.zzl = Math.max(timeUnit.toMillis(j), zzb);
        return this;
    }

    public final zzale zze() {
        return this.zze;
    }

    public zzaku(SocketAddress socketAddress, String str, @Nullable zzwf zzwfVar, @Nullable zzvz zzvzVar, zzakp zzakpVar, @Nullable zzako zzakoVar) {
        zzale zzaleVar = zzo;
        this.zzd = zzaleVar;
        this.zze = zzaleVar;
        this.zzs = new ArrayList();
        this.zzf = zzaaq.zzb();
        this.zzg = new ArrayList();
        this.zzi = GrpcUtil.DEFAULT_LB_POLICY;
        this.zzj = zzp;
        this.zzk = zzq;
        this.zzl = zza;
        this.zzm = zzxz.zza();
        new ArrayList();
        this.zzh = zzf(socketAddress);
        this.zzt = (zzakp) Preconditions.checkNotNull(zzakpVar, "clientTransportFactoryBuilder");
        zzaaq zzaaqVar = new zzaaq();
        zzaaqVar.zze(new zzakr(socketAddress, str));
        this.zzf = zzaaqVar;
        zzyf.zza(this);
    }
}
