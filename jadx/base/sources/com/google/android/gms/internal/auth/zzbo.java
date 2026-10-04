package com.google.android.gms.internal.auth;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.AuthProxy;
import com.google.android.gms.auth.api.AuthProxyOptions;
import com.google.android.gms.auth.api.proxy.ProxyClient;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.samsung.android.sdk.pen.setting.pencommon.SpenCanvasUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbo extends GoogleApi implements ProxyClient {
    public zzbo(@NonNull Activity activity, @Nullable AuthProxyOptions authProxyOptions) {
        super(activity, AuthProxy.API, authProxyOptions == null ? AuthProxyOptions.zza : authProxyOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.auth.api.proxy.ProxyClient
    public final Task<String> getSpatulaHeader() {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.auth.zzbk
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzbh) ((zzbe) obj).getService()).zzd(new zzbn(this.zza, (TaskCompletionSource) obj2));
            }
        }).setMethodKey(SpenCanvasUtil.SCREEN_WIDTH_WQHD_TB).build());
    }

    @Override // com.google.android.gms.auth.api.proxy.ProxyClient
    public final Task<ProxyResponse> performProxyRequest(@NonNull final ProxyRequest proxyRequest) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.auth.zzbl
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzbo zzboVar = this.zza;
                ProxyRequest proxyRequest2 = proxyRequest;
                ((zzbh) ((zzbe) obj).getService()).zze(new zzbm(zzboVar, (TaskCompletionSource) obj2), proxyRequest2);
            }
        }).setMethodKey(1518).build());
    }

    public zzbo(@NonNull Context context, @Nullable AuthProxyOptions authProxyOptions) {
        super(context, AuthProxy.API, authProxyOptions == null ? AuthProxyOptions.zza : authProxyOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
