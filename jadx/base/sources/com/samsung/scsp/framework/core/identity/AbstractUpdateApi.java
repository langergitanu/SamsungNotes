package com.samsung.scsp.framework.core.identity;

import androidx.collection.AbstractC0622a;
import com.google.gson.JsonObject;
import com.samsung.scsp.common.ContentType;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.ers.DomainVo;
import com.samsung.scsp.framework.core.ers.ScspErs;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.HttpRequestImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class AbstractUpdateApi {
    private static final String BASE_URI = "/identity/v2/";
    private static final String UPDATE_URI = "/update";
    private final String featureUri;
    protected final Logger logger;
    protected final SContextHolder scontextHolder;
    private final String tag;
    private final FaultBarrier.ThrowableSupplier<String> token;

    public AbstractUpdateApi(SContextHolder sContextHolder, String str, FaultBarrier.ThrowableSupplier<String> throwableSupplier) {
        String simpleName = getClass().getSimpleName();
        this.tag = simpleName;
        this.logger = Logger.get(simpleName);
        this.scontextHolder = sContextHolder;
        this.featureUri = str;
        this.token = throwableSupplier;
    }

    private Map<String, String> getRequestHeader() {
        HashMap map = new HashMap();
        map.put("User-Agent", this.scontextHolder.userAgent);
        map.put("Authorization", this.token.get());
        return map;
    }

    private String getUrl() {
        DomainVo domain = ScspErs.getDomain(this.scontextHolder);
        StringBuilder sb = new StringBuilder();
        sb.append(domain.playUrl);
        sb.append(BASE_URI);
        return AbstractC0622a.m1170p(this.featureUri, UPDATE_URI, sb);
    }

    public void addDeviceProperties(JsonObject jsonObject, DeviceInfo deviceInfo) {
        if (deviceInfo == null || deviceInfo.isAllFieldsNull()) {
            return;
        }
        JsonObject jsonObject2 = new JsonObject();
        if (deviceInfo.getAlias() != null) {
            jsonObject2.addProperty(IdentityApiContract.Parameter.ALIAS, deviceInfo.getAlias());
        }
        if (deviceInfo.getSimMcc() != null) {
            jsonObject2.addProperty(IdentityApiContract.Parameter.SIM_MCC, deviceInfo.getSimMcc());
        }
        if (deviceInfo.getSimMnc() != null) {
            jsonObject2.addProperty(IdentityApiContract.Parameter.SIM_MNC, deviceInfo.getSimMnc());
        }
        jsonObject.add("device", jsonObject2);
    }

    public HttpRequest getHttpRequest(JsonObject jsonObject) {
        Map<String, String> requestHeader = getRequestHeader();
        String url = getUrl();
        SContextHolder sContextHolder = this.scontextHolder;
        return new HttpRequestImpl.HttpRequestBuilder(requestHeader, url, sContextHolder.requestTimeOut, sContextHolder.isAccountRequiredFeature).name(this.tag).payload(ContentType.JSON, jsonObject.toString()).build();
    }

    public void saveDeviceProperties(DeviceInfo deviceInfo) {
        if (deviceInfo != null) {
            if (deviceInfo.getSimMcc() != null) {
                ScspCorePreferences.get().simMcc.accept(deviceInfo.getSimMcc());
            }
            if (deviceInfo.getSimMnc() != null) {
                ScspCorePreferences.get().simMnc.accept(deviceInfo.getSimMnc());
            }
            if (deviceInfo.getAlias() != null) {
                ScspCorePreferences.get().deviceAlias.accept(deviceInfo.getAlias());
            }
        }
    }
}
