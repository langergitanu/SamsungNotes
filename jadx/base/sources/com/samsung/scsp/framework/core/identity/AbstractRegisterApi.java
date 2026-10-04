package com.samsung.scsp.framework.core.identity;

import android.content.Context;
import android.os.Build;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.scsp.common.ContentType;
import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.SContext;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.api.Response;
import com.samsung.scsp.framework.core.ers.ScspErs;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.HttpRequestImpl;
import com.samsung.scsp.framework.core.network.Network;
import com.samsung.scsp.framework.core.util.DeviceUtil;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class AbstractRegisterApi {
    protected static final String BASE_URI = "/identity/v2/";
    private static final String REGISTER_URI = "/register";
    private final DeviceId deviceId;
    private final String featureUri;
    protected final Logger logger;
    protected final SContext scontext;
    protected final SContextHolder scontextHolder;
    private final String tag;

    public AbstractRegisterApi(SContextHolder sContextHolder, String str) {
        String simpleName = getClass().getSimpleName();
        this.tag = simpleName;
        this.logger = Logger.get(simpleName);
        this.deviceId = new DeviceId();
        this.scontextHolder = sContextHolder;
        this.scontext = sContextHolder.scontext;
        this.featureUri = str;
    }

    private String getOsType() {
        return DeviceUtil.isWatch(ContextFactory.getApplicationContext()) ? "wearos" : TelemetryEventStrings.C6439Os.OS_NAME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$makeDevicePayload$4(JsonObject jsonObject) {
        jsonObject.addProperty(IdentityApiContract.Parameter.OS_USER_INFO_FLAG, Integer.toString(DeviceUtil.getUserInfoFlags()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$makeRequestHeader$2(SContextHolder sContextHolder) {
        return this.deviceId.getPhysicalDeviceId(sContextHolder.scontext.getDeviceIdSupplier());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$makeRequestHeader$3(E2eeInfoSupplier e2eeInfoSupplier, Map map) {
        String sakUid = e2eeInfoSupplier.getSakUid();
        if (StringUtil.isEmpty(sakUid)) {
            return;
        }
        map.put(IdentityApiContract.Header.X_SC_SDID, sakUid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$register$0(JsonObject jsonObject) {
        return "[onStream] : " + jsonObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$register$1(Map map, JsonObject jsonObject, HttpRequest httpRequest, Map map2, InputStream inputStream) {
        if (Integer.parseInt((String) ((List) map2.get(Network.HTTP_STATUS)).get(0)) == 200) {
            JsonObject jsonObject2 = (JsonObject) new Response(inputStream).create(JsonObject.class);
            this.logger.m12931d(new C11657b(jsonObject2, 0));
            ScspCorePreferences.get().dvcId.accept(jsonObject2.get("dvcId").getAsString());
            saveTokens(jsonObject2.getAsJsonArray("tokens"));
            saveRequestHeader(map);
            saveAppPayload(jsonObject.getAsJsonObject("app"));
            saveDevicePayload(jsonObject.getAsJsonObject("device"));
        }
    }

    private JsonObject makeDevicePayload() {
        Context applicationContext = ContextFactory.getApplicationContext();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(IdentityApiContract.Parameter.OS_TYPE, getOsType());
        jsonObject.addProperty(IdentityApiContract.Parameter.OS_VERSION, Integer.toString(Build.VERSION.SDK_INT));
        jsonObject.addProperty(IdentityApiContract.Parameter.PLATFORM_VERSION, DeviceUtil.getOneUiVersion());
        jsonObject.addProperty("type", DeviceUtil.getDeviceType());
        jsonObject.addProperty(IdentityApiContract.Parameter.COUNTRY_CODE, DeviceUtil.getIso3CountryCode(applicationContext));
        jsonObject.addProperty(IdentityApiContract.Parameter.MODEL_NAME, DeviceUtil.getModelName());
        jsonObject.addProperty(IdentityApiContract.Parameter.ALIAS, DeviceUtil.getDeviceName(applicationContext));
        jsonObject.addProperty(IdentityApiContract.Parameter.OS_USER_ID, Integer.toString(DeviceUtil.getUserId()));
        FaultBarrier.run(new C11656a(jsonObject, 1), true);
        String modelCode = DeviceUtil.getModelCode();
        if (!StringUtil.isEmpty(modelCode)) {
            jsonObject.addProperty(IdentityApiContract.Parameter.MODEL_CODE, modelCode);
        }
        String simMcc = DeviceUtil.getSimMcc(applicationContext);
        if (!StringUtil.isEmpty(simMcc)) {
            jsonObject.addProperty(IdentityApiContract.Parameter.SIM_MCC, simMcc);
        }
        String simMnc = DeviceUtil.getSimMnc(applicationContext);
        if (!StringUtil.isEmpty(simMnc)) {
            jsonObject.addProperty(IdentityApiContract.Parameter.SIM_MNC, simMnc);
        }
        String csc = DeviceUtil.getCsc();
        if (!StringUtil.isEmpty(csc)) {
            jsonObject.addProperty("csc", csc);
        }
        return jsonObject;
    }

    private void saveDevicePayload(JsonObject jsonObject) {
        ScspCorePreferences.get().osVersion.accept(jsonObject.get(IdentityApiContract.Parameter.OS_VERSION).getAsString());
        ScspCorePreferences.get().deviceAlias.accept(jsonObject.get(IdentityApiContract.Parameter.ALIAS).getAsString());
        ScspCorePreferences.get().platformVersion.accept(jsonObject.get(IdentityApiContract.Parameter.PLATFORM_VERSION).getAsString());
        ScspCorePreferences.get().countryCode.accept(jsonObject.get(IdentityApiContract.Parameter.COUNTRY_CODE).getAsString());
        if (jsonObject.has(IdentityApiContract.Parameter.SIM_MCC)) {
            ScspCorePreferences.get().simMcc.accept(jsonObject.get(IdentityApiContract.Parameter.SIM_MCC).getAsString());
        }
        if (jsonObject.has(IdentityApiContract.Parameter.SIM_MNC)) {
            ScspCorePreferences.get().simMnc.accept(jsonObject.get(IdentityApiContract.Parameter.SIM_MNC).getAsString());
        }
    }

    private void saveTokens(JsonArray jsonArray) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject asJsonObject = jsonArray.get(i).getAsJsonObject();
            saveToken(asJsonObject.get("type").getAsString(), IdentityApiContract.Token.BEARER_ + asJsonObject.get("accessToken").getAsString(), (asJsonObject.get(IdentityApiContract.Token.EXPIRES_IN).getAsLong() * 1000) + System.currentTimeMillis());
        }
    }

    public JsonObject makeAppPayload() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("version", this.scontext.getAppVersion());
        jsonObject.addProperty("sdkVersion", this.scontextHolder.version);
        return jsonObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<String, String> makeRequestHeader(SContextHolder sContextHolder) {
        HashMap map = new HashMap();
        map.put("User-Agent", sContextHolder.userAgent);
        map.put("x-sc-app-id", sContextHolder.scontext.getAppId());
        String clientDeviceId = this.deviceId.getClientDeviceId();
        if (StringUtil.isEmpty(clientDeviceId)) {
            throw new ScspException(ScspException.Code.RUNTIME_POLICY, "There is no cdid.");
        }
        map.put(IdentityApiContract.Header.X_SC_CDID, clientDeviceId);
        String str = (String) FaultBarrier.get(new C11658c(this, sContextHolder, 0), null, true).obj;
        if (!StringUtil.isEmpty(str)) {
            map.put(IdentityApiContract.Header.X_SC_PDID, str);
        }
        E2eeInfoSupplier e2eeInfoSupplier = sContextHolder.scontext.getE2eeInfoSupplier();
        if (e2eeInfoSupplier != null) {
            FaultBarrier.run(new C11658c(e2eeInfoSupplier, map, 1));
        }
        DeviceId deviceId = this.deviceId;
        Objects.requireNonNull(deviceId);
        String str2 = (String) FaultBarrier.get(new C11656a(deviceId, 6), null).obj;
        if (!StringUtil.isEmpty(str2)) {
            map.put(IdentityApiContract.Header.X_SC_SSDID, str2);
        }
        return map;
    }

    public void register() {
        String str = ScspErs.getDomain(this.scontextHolder).playUrl + BASE_URI + this.featureUri + "/register?deviceCurrentTime=" + System.currentTimeMillis();
        Map<String, String> mapMakeRequestHeader = makeRequestHeader(this.scontextHolder);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("app", makeAppPayload());
        jsonObject.add("device", makeDevicePayload());
        String string = jsonObject.toString();
        SContextHolder sContextHolder = this.scontextHolder;
        this.scontextHolder.network.post(new HttpRequestImpl.HttpRequestBuilder(mapMakeRequestHeader, str, sContextHolder.requestTimeOut, sContextHolder.isAccountRequiredFeature).name(this.tag).payload(ContentType.JSON, string).build(), new C11659d(this, 0, mapMakeRequestHeader, jsonObject));
    }

    public void saveAppPayload(JsonObject jsonObject) {
        ScspCorePreferences.get().appVersion.accept(jsonObject.get("version").getAsString());
    }

    public abstract void saveRequestHeader(Map<String, String> map);

    public abstract void saveToken(String str, String str2, long j);
}
