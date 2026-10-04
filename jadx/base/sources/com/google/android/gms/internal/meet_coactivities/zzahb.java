package com.google.android.gms.internal.meet_coactivities;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.apache.commons.lang3.SystemProperties;
import org.apache.commons.text.lookup.StringLookupFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahb extends zzaam {

    @VisibleForTesting
    static final boolean zza;

    @VisibleForTesting
    static final boolean zzb;

    @VisibleForTesting
    protected static final boolean zzc;
    private static final Logger zzg;
    private static final Set zzh;
    private static final String zzi;
    private static final String zzj;
    private static final String zzk;
    private static final zzaha zzl;
    private static String zzm;
    private boolean zzA;
    private zzaai zzB;

    @VisibleForTesting
    final zzaat zzd;
    protected boolean zzf;
    private final String zzp;
    private final String zzq;
    private final int zzr;
    private final zzaoo zzs;
    private final long zzt;
    private final zzabl zzu;
    private final Stopwatch zzv;
    private boolean zzw;
    private Executor zzx;
    private final boolean zzy;
    private final zzaal zzz;
    private final Random zzn = new Random();
    protected volatile zzagt zze = zzagw.INSTANCE;
    private final AtomicReference zzo = new AtomicReference();

    static {
        Logger logger = Logger.getLogger(zzahb.class.getName());
        zzg = logger;
        zzh = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        zzi = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        zzj = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        zzk = property3;
        zza = Boolean.parseBoolean(property);
        zzb = Boolean.parseBoolean(property2);
        zzc = Boolean.parseBoolean(property3);
        zzaha zzahaVar = null;
        try {
            try {
                try {
                    zzaha zzahaVar2 = (zzaha) Class.forName("io.grpc.internal.JndiResourceResolverFactory", true, zzahb.class.getClassLoader()).asSubclass(zzaha.class).getConstructor(null).newInstance(null);
                    if (zzahaVar2.zzb() != null) {
                        logger.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "JndiResourceResolverFactory not available, skipping.", zzahaVar2.zzb());
                    } else {
                        zzahaVar = zzahaVar2;
                    }
                } catch (Exception e) {
                    zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e);
                }
            } catch (Exception e2) {
                zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e2);
            }
        } catch (ClassCastException e3) {
            zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e3);
        } catch (ClassNotFoundException e5) {
            zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e5);
        }
        zzl = zzahaVar;
    }

    public zzahb(@Nullable String str, String str2, zzaaf zzaafVar, zzaoo zzaooVar, Stopwatch stopwatch, boolean z) {
        Preconditions.checkNotNull(zzaafVar, "args");
        this.zzs = zzaooVar;
        URI uriCreate = URI.create("//".concat(String.valueOf((String) Preconditions.checkNotNull(str2, "name"))));
        Preconditions.checkArgument(uriCreate.getHost() != null, "Invalid DNS name: %s", str2);
        this.zzp = (String) Preconditions.checkNotNull(uriCreate.getAuthority(), "nameUri (%s) doesn't have an authority", uriCreate);
        this.zzq = uriCreate.getHost();
        if (uriCreate.getPort() == -1) {
            this.zzr = zzaafVar.zza();
        } else {
            this.zzr = uriCreate.getPort();
        }
        this.zzd = (zzaat) Preconditions.checkNotNull(zzaafVar.zzd(), "proxyDetector");
        long nanos = 0;
        if (!z) {
            String property = System.getProperty(SystemProperties.NETWORK_ADDRESS_CACHE_TTL);
            long j = 30;
            if (property != null) {
                try {
                    j = Long.parseLong(property);
                } catch (NumberFormatException unused) {
                    zzg.logp(Level.WARNING, "io.grpc.internal.DnsNameResolver", "getNetworkAddressCacheTtlNanos", "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{SystemProperties.NETWORK_ADDRESS_CACHE_TTL, property, 30L});
                }
            }
            nanos = j > 0 ? TimeUnit.SECONDS.toNanos(j) : j;
        }
        this.zzt = nanos;
        this.zzv = (Stopwatch) Preconditions.checkNotNull(stopwatch, NotificationCompat.CATEGORY_STOPWATCH);
        this.zzu = (zzabl) Preconditions.checkNotNull(zzaafVar.zze(), "syncContext");
        Executor executorZzf = zzaafVar.zzf();
        this.zzx = executorZzf;
        this.zzy = executorZzf == null;
        this.zzz = (zzaal) Preconditions.checkNotNull(zzaafVar.zzc(), "serviceConfigParser");
    }

    public static /* bridge */ /* synthetic */ zzxm zzg(zzahb zzahbVar) {
        zzaas zzaasVarZza = zzahbVar.zzd.zza(InetSocketAddress.createUnresolved(zzahbVar.zzq, zzahbVar.zzr));
        if (zzaasVarZza == null) {
            return null;
        }
        return new zzxm(Collections.singletonList(zzaasVarZza), zzvy.zza);
    }

    private static String zzm() {
        if (zzm == null) {
            try {
                zzm = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }
        return zzm;
    }

    private final void zzn() {
        if (this.zzA || this.zzw) {
            return;
        }
        if (this.zzf) {
            long j = this.zzt;
            if (j != 0 && (j <= 0 || this.zzv.elapsed(TimeUnit.NANOSECONDS) <= this.zzt)) {
                return;
            }
        }
        this.zzA = true;
        this.zzx.execute(new zzagy(this, this.zzB));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaam
    public final String zza() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaam
    public final void zzb() {
        Preconditions.checkState(this.zzB != null, "not started");
        zzn();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaam
    public final void zzc() {
        if (this.zzw) {
            return;
        }
        this.zzw = true;
        Executor executor = this.zzx;
        if (executor == null || !this.zzy) {
            return;
        }
        zzaop.zzc(this.zzs, executor);
        this.zzx = null;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.util.concurrent.Executor] */
    @Override // com.google.android.gms.internal.meet_coactivities.zzaam
    public final void zzd(zzaai zzaaiVar) {
        Preconditions.checkState(this.zzB == null, "already started");
        if (this.zzy) {
            this.zzx = zzaop.zza(this.zzs);
        }
        this.zzB = (zzaai) Preconditions.checkNotNull(zzaaiVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        zzn();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[LOOP:2: B:67:0x012f->B:160:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0193 A[Catch: RuntimeException -> 0x015f, TryCatch #4 {RuntimeException -> 0x015f, blocks: (B:70:0x013b, B:71:0x0143, B:73:0x0149, B:76:0x0162, B:78:0x016a, B:80:0x0170, B:81:0x0174, B:83:0x017a, B:87:0x018b, B:89:0x0193, B:94:0x01a0, B:97:0x01ac, B:99:0x01b4, B:101:0x01ba, B:102:0x01be, B:104:0x01c4, B:106:0x01d0, B:111:0x01da, B:112:0x01e9), top: B:141:0x013b }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01ac A[Catch: RuntimeException -> 0x015f, TryCatch #4 {RuntimeException -> 0x015f, blocks: (B:70:0x013b, B:71:0x0143, B:73:0x0149, B:76:0x0162, B:78:0x016a, B:80:0x0170, B:81:0x0174, B:83:0x017a, B:87:0x018b, B:89:0x0193, B:94:0x01a0, B:97:0x01ac, B:99:0x01b4, B:101:0x01ba, B:102:0x01be, B:104:0x01c4, B:106:0x01d0, B:111:0x01da, B:112:0x01e9), top: B:141:0x013b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzagv zzi(boolean z) {
        zzagz zzagzVarZza;
        zzaha zzahaVar;
        zzaag zzaagVarZzb;
        ArrayList<Map> arrayList;
        List listZzi;
        Double dZzb;
        Exception exc = null;
        zzaagVarZzb = null;
        zzaag zzaagVarZzb2 = null;
        exc = null;
        zzagv zzagvVar = new zzagv(null);
        try {
            try {
                try {
                    List listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(this.zzq)));
                    ArrayList arrayList2 = new ArrayList(listUnmodifiableList.size());
                    Iterator it = listUnmodifiableList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new zzxm(Collections.singletonList(new InetSocketAddress((InetAddress) it.next(), this.zzr)), zzvy.zza));
                    }
                    zzagvVar.zzb = Collections.unmodifiableList(arrayList2);
                    if (zzc) {
                        String str = this.zzq;
                        List<String> listZza = Collections.EMPTY_LIST;
                        boolean z2 = zza;
                        boolean z3 = zzb;
                        if (z2) {
                            if (!StringLookupFactory.KEY_LOCALHOST.equalsIgnoreCase(str)) {
                                if (!str.contains(":")) {
                                    boolean z4 = true;
                                    int i = 0;
                                    while (i < str.length()) {
                                        char cCharAt = str.charAt(i);
                                        if (cCharAt != '.') {
                                            z4 = (z4 ? 1 : 0) & (cCharAt >= '0' && cCharAt <= '9');
                                        }
                                        i++;
                                        z4 = z4;
                                    }
                                    if (z4) {
                                    }
                                }
                                zzagzVarZza = null;
                            } else if (z3) {
                                zzagzVarZza = (zzagz) this.zzo.get();
                                if (zzagzVarZza == null && (zzahaVar = zzl) != null) {
                                    zzagzVarZza = zzahaVar.zza();
                                }
                            } else {
                                zzagzVarZza = null;
                            }
                            if (zzagzVarZza != null) {
                                try {
                                    listZza = zzagzVarZza.zza();
                                } catch (Exception e) {
                                    zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "resolveServiceConfig", "ServiceConfig resolution failure", (Throwable) e);
                                }
                            }
                            if (listZza.isEmpty()) {
                                zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "resolveServiceConfig", "No TXT records found for {0}", new Object[]{this.zzq});
                            } else {
                                Random random = this.zzn;
                                String strZzm = zzm();
                                try {
                                    arrayList = new ArrayList();
                                } catch (IOException e2) {
                                    e = e2;
                                    zzaagVarZzb = zzaag.zzb(zzabd.zzc.zze("failed to parse TXT records").zzd(e));
                                } catch (RuntimeException e3) {
                                    e = e3;
                                    zzaagVarZzb = zzaag.zzb(zzabd.zzc.zze("failed to parse TXT records").zzd(e));
                                }
                                for (String str2 : listZza) {
                                    if (str2.startsWith("grpc_config=")) {
                                        Object objZza = zzait.zza(str2.substring(12));
                                        if (!(objZza instanceof List)) {
                                            throw new ClassCastException("wrong type ".concat(String.valueOf(objZza)));
                                        }
                                        List list = (List) objZza;
                                        zzaiu.zzf(list);
                                        arrayList.addAll(list);
                                        if (zzaagVarZzb != null) {
                                            zzaagVarZzb2 = zzaagVarZzb.zzc() != null ? zzaag.zzb(zzaagVarZzb.zzc()) : this.zzz.zza((Map) zzaagVarZzb.zzd());
                                        }
                                    } else {
                                        zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "parseTxtResults", "Ignoring non service config {0}", new Object[]{str2});
                                    }
                                }
                                Map map = null;
                                for (Map map2 : arrayList) {
                                    try {
                                        for (Map.Entry entry : map2.entrySet()) {
                                            Verify.verify(zzh.contains(entry.getKey()), "Bad key: %s", entry);
                                        }
                                        listZzi = zzaiu.zzi(map2, "clientLanguage");
                                    } catch (RuntimeException e5) {
                                        zzaagVarZzb = zzaag.zzb(zzabd.zzc.zze("failed to pick service config choice").zzd(e5));
                                    }
                                    if (listZzi == null || listZzi.isEmpty()) {
                                        dZzb = zzaiu.zzb(map2, "percentage");
                                        if (dZzb == null) {
                                            List listZzi2 = zzaiu.zzi(map2, "clientHostname");
                                            if (listZzi2 != null && !listZzi2.isEmpty()) {
                                                Iterator it2 = listZzi2.iterator();
                                                while (it2.hasNext()) {
                                                    if (((String) it2.next()).equals(strZzm)) {
                                                    }
                                                }
                                                map = null;
                                                if (map == null) {
                                                    break;
                                                }
                                            }
                                            Map mapZzj = zzaiu.zzj(map2, "serviceConfig");
                                            if (mapZzj == null) {
                                                throw new VerifyException(String.format("key '%s' missing in '%s'", map2, "serviceConfig"));
                                            }
                                            map = mapZzj;
                                            if (map == null) {
                                            }
                                            if (zzaagVarZzb != null) {
                                            }
                                        } else {
                                            int iIntValue = dZzb.intValue();
                                            Verify.verify(iIntValue >= 0 && iIntValue <= 100, "Bad percentage: %s", dZzb);
                                            if (random.nextInt(100) >= iIntValue) {
                                            }
                                            map = null;
                                            if (map == null) {
                                            }
                                        }
                                    } else {
                                        Iterator it3 = listZzi.iterator();
                                        while (it3.hasNext()) {
                                            if (StringLookupFactory.KEY_JAVA.equalsIgnoreCase((String) it3.next())) {
                                                dZzb = zzaiu.zzb(map2, "percentage");
                                                if (dZzb == null) {
                                                }
                                            }
                                        }
                                        map = null;
                                        if (map == null) {
                                        }
                                    }
                                }
                                zzaagVarZzb = map == null ? null : zzaag.zza(map);
                                if (zzaagVarZzb != null) {
                                }
                            }
                            zzagvVar.zzc = zzaagVarZzb2;
                        }
                    }
                    return zzagvVar;
                } catch (Exception e6) {
                    exc = e6;
                    Throwables.throwIfUnchecked(exc);
                    throw new RuntimeException(exc);
                }
            } catch (Throwable th) {
                Exception exc2 = exc;
                if (exc2 != null) {
                    zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "resolveAddresses", "Address resolution failure", (Throwable) exc2);
                }
                throw th;
            }
        } catch (Exception e7) {
            zzagvVar.zza = zzabd.zzk.zze("Unable to resolve host ".concat(String.valueOf(this.zzq))).zzd(e7);
            return zzagvVar;
        }
    }
}
