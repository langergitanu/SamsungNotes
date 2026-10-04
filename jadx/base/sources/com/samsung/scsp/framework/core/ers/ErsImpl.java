package com.samsung.scsp.framework.core.ers;

import android.content.Context;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.error.Result;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.api.Response;
import com.samsung.scsp.framework.core.network.HeaderSetup;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.HttpRequestImpl;
import com.samsung.scsp.framework.core.util.DeviceUtil;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class ErsImpl {
    private static final Object LOCK = new Object();
    private static final String PRIMARY_SERVER = "https://ers.samsungcloud.com/ers/v1/endpoints";
    private static final String SECONDARY_SERVER = "https://ers.samsungcloudplatform.com/ers/v1/endpoints";
    private static final int TIMEOUT = 60000;
    private final String TAG = "ScspErs";
    private final Logger logger = Logger.get("ScspErs");

    private void execute(Context context, SContextHolder sContextHolder, String str, String str2) {
        sContextHolder.network.get(new HttpRequestImpl.HttpRequestBuilder(getHeaders(context, str, sContextHolder), str2, 60000, false).name("ScspErs").build(), new C11655d(this));
    }

    private Map<String, String> getHeaders(Context context, String str, SContextHolder sContextHolder) {
        HashMap map = new HashMap();
        map.put("x-sc-app-id", str);
        map.put(HeaderSetup.Key.X_SC_DEVICE_MODEL, DeviceUtil.getModelName());
        map.put(HeaderSetup.Key.X_SC_OS_TYPE, TelemetryEventStrings.C6439Os.OS_NAME);
        map.put(HeaderSetup.Key.X_SC_OS_VERSION, DeviceUtil.getSDKVersion() + "");
        map.put(HeaderSetup.Key.X_SC_NETWORK_MNC, DeviceUtil.getNetworkMnc(context));
        map.put(HeaderSetup.Key.X_SC_NETWORK_MCC, DeviceUtil.getNetworkMcc(context));
        map.put(HeaderSetup.Key.X_SC_DEVICE_CSC, DeviceUtil.getCsc());
        map.put(HeaderSetup.Key.X_SC_DEVICE_CC, DeviceUtil.getIso3CountryCode(context));
        map.put("User-Agent", sContextHolder.userAgent);
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long getMaxAge(Map<String, List<String>> map) {
        return ((Long) FaultBarrier.get(new C11655d(map.get("Cache-Control")), 86400L, true).obj).longValue() * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$execute$3(DomainVo domainVo) {
        return "[onStream] : defaultUrl : " + domainVo.defaultUrl + ", play : " + domainVo.playUrl + ", odm : " + domainVo.odmUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$4(HttpRequest httpRequest, Map map, InputStream inputStream) {
        final DomainVo domainVo = (DomainVo) new Response(inputStream).create(DomainVo.class);
        this.logger.m12931d(new Supplier() { // from class: com.samsung.scsp.framework.core.ers.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return ErsImpl.lambda$execute$3(domainVo);
            }
        });
        if (StringUtil.isEmpty(domainVo.defaultUrl) || StringUtil.isEmpty(domainVo.playUrl) || StringUtil.isEmpty(domainVo.odmUrl)) {
            return;
        }
        ErsPreferences ersPreferences = ErsPreferences.get();
        long maxAge = getMaxAge(map);
        ersPreferences.defaultUrl.accept(domainVo.defaultUrl);
        ersPreferences.playUrl.accept(domainVo.playUrl);
        ersPreferences.odmUrl.accept(domainVo.odmUrl);
        ersPreferences.expiredTime.accept(Long.valueOf(System.currentTimeMillis() + maxAge));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDomain$0(Context context, SContextHolder sContextHolder, String str) {
        execute(context, sContextHolder, str, PRIMARY_SERVER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDomain$1(Context context, SContextHolder sContextHolder, String str) {
        execute(context, sContextHolder, str, SECONDARY_SERVER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDomain$2(final Context context, final SContextHolder sContextHolder, final String str) {
        synchronized (LOCK) {
            try {
                ErsPreferences ersPreferences = ErsPreferences.get();
                if (ersPreferences.expiredTime.get().longValue() < System.currentTimeMillis()) {
                    final int i = 0;
                    Result resultRun = FaultBarrier.run(new FaultBarrier.ThrowableRunnable(this) { // from class: com.samsung.scsp.framework.core.ers.c

                        /* JADX INFO: renamed from: b */
                        public final /* synthetic */ ErsImpl f8191b;

                        {
                            this.f8191b = this;
                        }

                        @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
                        public final void run() {
                            switch (i) {
                                case 0:
                                    this.f8191b.lambda$getDomain$0(context, sContextHolder, str);
                                    break;
                                default:
                                    this.f8191b.lambda$getDomain$1(context, sContextHolder, str);
                                    break;
                            }
                        }
                    });
                    if (!resultRun.success) {
                        this.logger.m12932e("Cannot get ers url from server, So use backup server url");
                        final int i2 = 1;
                        resultRun = FaultBarrier.run(new FaultBarrier.ThrowableRunnable(this) { // from class: com.samsung.scsp.framework.core.ers.c

                            /* JADX INFO: renamed from: b */
                            public final /* synthetic */ ErsImpl f8191b;

                            {
                                this.f8191b = this;
                            }

                            @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
                            public final void run() {
                                switch (i2) {
                                    case 0:
                                        this.f8191b.lambda$getDomain$0(context, sContextHolder, str);
                                        break;
                                    default:
                                        this.f8191b.lambda$getDomain$1(context, sContextHolder, str);
                                        break;
                                }
                            }
                        });
                    }
                    if (!resultRun.success) {
                        ersPreferences.expiredTime.accept(Long.valueOf(System.currentTimeMillis() + 7200000));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$getMaxAge$5(List list) {
        return Long.valueOf(Long.parseLong(((String) list.get(0)).split(MarketingConstants.REFERRER_DELIMITER_U003D)[1]));
    }

    public void getDomain(final Context context, final SContextHolder sContextHolder, final String str) {
        Thread thread = new Thread(new Runnable() { // from class: com.samsung.scsp.framework.core.ers.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f8186a.lambda$getDomain$2(context, sContextHolder, str);
            }
        });
        thread.start();
        FaultBarrier.run(new C11655d(thread));
    }
}
