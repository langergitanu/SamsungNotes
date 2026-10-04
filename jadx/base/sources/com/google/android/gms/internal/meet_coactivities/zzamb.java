package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.microsoft.identity.common.java.AuthenticationConstants;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzamb implements zzaat {
    private final Supplier zzc;
    private final InetSocketAddress zzd;
    private static final Logger zza = Logger.getLogger(zzamb.class.getName());
    private static final zzalz zze = new zzalz();
    private static final Supplier zzb = new zzama();

    public zzamb() {
        Supplier supplier = zzb;
        zzalz zzalzVar = zze;
        String str = System.getenv("GRPC_PROXY_EXP");
        this.zzc = (Supplier) Preconditions.checkNotNull(supplier);
        if (str == null) {
            this.zzd = null;
            return;
        }
        String[] strArrSplit = str.split(":", 2);
        int i = strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1]) : 80;
        zza.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl", "overrideProxy", "Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        this.zzd = new InetSocketAddress(strArrSplit[0], i);
    }

    private final zzaas zzc(InetSocketAddress inetSocketAddress) {
        try {
            try {
                URI uri = new URI(AuthenticationConstants.HTTPS_PROTOCOL_STRING, null, zzahv.zzc(inetSocketAddress), inetSocketAddress.getPort(), null, null, null);
                ProxySelector proxySelector = (ProxySelector) this.zzc.get();
                if (proxySelector == null) {
                    zza.logp(Level.FINE, "io.grpc.internal.ProxyDetectorImpl", "detectProxy", "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> listSelect = proxySelector.select(uri);
                if (listSelect.size() > 1) {
                    zza.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl", "detectProxy", "More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = listSelect.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) proxy.address();
                PasswordAuthentication passwordAuthenticationZza = zzalz.zza(zzahv.zzc(inetSocketAddress2), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort(), AuthenticationConstants.HTTPS_PROTOCOL_STRING, "", null);
                if (inetSocketAddress2.isUnresolved()) {
                    inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort());
                }
                zzxs zzxsVarZza = zzxu.zza();
                zzxsVarZza.zzc(inetSocketAddress);
                zzxsVarZza.zzb(inetSocketAddress2);
                if (passwordAuthenticationZza == null) {
                    return zzxsVarZza.zze();
                }
                zzxsVarZza.zzd(passwordAuthenticationZza.getUserName());
                zzxsVarZza.zza(passwordAuthenticationZza.getPassword() != null ? new String(passwordAuthenticationZza.getPassword()) : null);
                return zzxsVarZza.zze();
            } catch (URISyntaxException e) {
                zza.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl", "detectProxy", "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e);
                return null;
            }
        } catch (Throwable th) {
            zza.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl", "detectProxy", "Failed to get host for proxy lookup, proceeding without proxy", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaat
    @Nullable
    public final zzaas zza(SocketAddress socketAddress) {
        if (!(socketAddress instanceof InetSocketAddress)) {
            return null;
        }
        InetSocketAddress inetSocketAddress = this.zzd;
        if (inetSocketAddress == null) {
            return zzc((InetSocketAddress) socketAddress);
        }
        zzxs zzxsVarZza = zzxu.zza();
        zzxsVarZza.zzb(inetSocketAddress);
        zzxsVarZza.zzc((InetSocketAddress) socketAddress);
        return zzxsVarZza.zze();
    }
}
