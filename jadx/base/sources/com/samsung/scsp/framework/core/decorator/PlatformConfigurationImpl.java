package com.samsung.scsp.framework.core.decorator;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.gson.JsonObject;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.common.Header;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.api.Response;
import com.samsung.scsp.framework.core.ers.DomainVo;
import com.samsung.scsp.framework.core.ers.ScspErs;
import com.samsung.scsp.framework.core.network.HeaderSetup;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.HttpRequestImpl;
import com.samsung.scsp.framework.core.network.Network;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class PlatformConfigurationImpl {
    private static final String BASE_URI = "/platform-config/v2";
    private static final String EXPIRED_TIME = "expiredTime";
    private static final String E_TAG = "eTag";
    private static final String PLATFORM_CONFIGURATION_URI = "/platform-config/v2/configurations";
    private final SContextHolder scontextHolder;
    private final String TAG = "PlatformConfigurationImpl";
    private final Logger logger = Logger.get("PlatformConfigurationImpl");
    private final Context context = ContextFactory.getApplicationContext();

    public PlatformConfigurationImpl(SContextHolder sContextHolder) {
        this.scontextHolder = sContextHolder;
    }

    private Map<String, String> getHeader(SContextHolder sContextHolder) {
        Map<String, String> mapCommonHeader = HeaderSetup.commonHeader(sContextHolder);
        String string = PlatformConfigurationPreference.getString(this.context, E_TAG);
        if (!StringUtil.isEmpty(string)) {
            mapCommonHeader.put(Header.IF_NONE_MATCH, string);
        }
        return mapCommonHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long getMaxAge(Map<String, List<String>> map) {
        return ((Long) FaultBarrier.get(new C11650c(map.get("Cache-Control"), 2), 86400L, true).obj).longValue() * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$downloadPlatformConfiguration$0(Map map) {
        return (String) ((List) map.get(Header.ETAG)).get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$downloadPlatformConfiguration$1(int i, String str, long j) {
        StringBuilder sbM1629s = AbstractC2322a.m1629s("status : ", i, ", eTag : ", str, ", expiredTime : ");
        sbM1629s.append(j);
        return sbM1629s.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$downloadPlatformConfiguration$2(JsonObject jsonObject) {
        return "[onStream] : " + jsonObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$downloadPlatformConfiguration$3(String str) {
        return AbstractC0541b.m772n("[check] : ", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$downloadPlatformConfiguration$4(HttpRequest httpRequest, Map map, InputStream inputStream) {
        final long jCurrentTimeMillis = System.currentTimeMillis() + getMaxAge(map);
        PlatformConfigurationPreference.putLong(this.context, "expiredTime", jCurrentTimeMillis);
        final String str = (String) FaultBarrier.get(new C11650c(map, 0), null, true).obj;
        PlatformConfigurationPreference.putString(this.context, E_TAG, str);
        final int i = Integer.parseInt((String) ((List) map.get(Network.HTTP_STATUS)).get(0));
        this.logger.m12931d(new Supplier() { // from class: com.samsung.scsp.framework.core.decorator.d
            @Override // java.util.function.Supplier
            public final Object get() {
                return PlatformConfigurationImpl.lambda$downloadPlatformConfiguration$1(i, str, jCurrentTimeMillis);
            }
        });
        if (i == 200) {
            JsonObject jsonObject = (JsonObject) new Response(inputStream).create(JsonObject.class);
            this.logger.m12931d(new C11649b(jsonObject, 2));
            for (String str2 : jsonObject.keySet()) {
                String string = jsonObject.get(str2).getAsJsonArray().toString();
                this.logger.m12931d(new C11649b(string, 1));
                PlatformConfigurationPreference.putString(this.context, str2, string);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$getMaxAge$6(List list) {
        return Long.valueOf(Long.parseLong(((String) list.get(0)).split(MarketingConstants.REFERRER_DELIMITER_U003D)[1]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getPlatformConfiguration$5(String str) {
        return AbstractC0541b.m772n("[value] : ", str);
    }

    public void downloadPlatformConfiguration() {
        this.logger.m12934i("getPlatformConfiguration");
        if (System.currentTimeMillis() > PlatformConfigurationPreference.getLong(this.context, "expiredTime")) {
            DomainVo domain = ScspErs.getDomain(this.scontextHolder);
            String strM1170p = AbstractC0622a.m1170p(domain.playUrl, PLATFORM_CONFIGURATION_URI, new StringBuilder());
            Map<String, String> header = getHeader(this.scontextHolder);
            SContextHolder sContextHolder = this.scontextHolder;
            this.scontextHolder.network.get(new HttpRequestImpl.HttpRequestBuilder(header, strM1170p, sContextHolder.requestTimeOut, sContextHolder.isAccountRequiredFeature).name("PlatformConfigurationImpl").build(), new C11650c(this, 1));
        }
    }

    public Map<String, String> getPlatformConfiguration(String... strArr) throws ScspException {
        if (strArr == null || strArr.length < 1) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, "Null input param");
        }
        HashMap map = new HashMap();
        for (String str : strArr) {
            String string = PlatformConfigurationPreference.getString(this.context, str);
            this.logger.m12931d(new C11649b(string, 0));
            map.put(str, string);
        }
        return map;
    }
}
