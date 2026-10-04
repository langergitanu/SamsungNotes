package com.samsung.scsp.framework.core.identity;

import com.google.gson.JsonObject;
import com.samsung.scsp.common.ContentType;
import com.samsung.scsp.common.Holder;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.SContext;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.api.Response;
import com.samsung.scsp.framework.core.ers.ScspErs;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.HttpRequestImpl;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class AbstractTokenApi {
    private static final String BASE_URI = "/identity/v2/";
    private static final String TOKEN_RENEW_URI = "/token/renew";
    private final String featureUri;
    protected final Logger logger;
    protected final SContext scontext;
    protected final SContextHolder scontextHolder;
    private final String tag;

    public AbstractTokenApi(SContextHolder sContextHolder, String str) {
        String simpleName = getClass().getSimpleName();
        this.tag = simpleName;
        this.logger = Logger.get(simpleName);
        this.scontextHolder = sContextHolder;
        this.scontext = sContextHolder.scontext;
        this.featureUri = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$renew$0(JsonObject jsonObject) {
        return "[onStream] : " + jsonObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$renew$1(Holder holder, HttpRequest httpRequest, Map map, InputStream inputStream) throws ScspException {
        JsonObject jsonObject = (JsonObject) new Response(inputStream).create(JsonObject.class);
        this.logger.m12931d(new C11657b(jsonObject, 1));
        String asString = jsonObject.get("accessToken").getAsString();
        if (StringUtil.isEmpty(asString)) {
            throw new ScspException(ScspException.Code.RUNTIME_ENVIRONMENT, "token is null or empty.");
        }
        holder.hold(IdentityApiContract.Token.BEARER_ + asString);
        saveToken((String) holder.get(), (jsonObject.get(IdentityApiContract.Token.EXPIRES_IN).getAsLong() * 1000) + System.currentTimeMillis());
    }

    public Map<String, String> makeRequestHeader(SContextHolder sContextHolder) throws ScspException {
        HashMap map = new HashMap();
        map.put("User-Agent", sContextHolder.userAgent);
        map.put("x-sc-app-id", sContextHolder.scontext.getAppId());
        map.put(IdentityApiContract.Header.X_SC_APP_VERSION, this.scontext.getAppVersion());
        String str = ScspCorePreferences.get().dvcId.get();
        if (StringUtil.isEmpty(str)) {
            ScspCorePreferences.get().clear();
            throw new ScspException(ScspException.Code.RUNTIME_POLICY, "There is no dvcId. Registration is needed.");
        }
        map.put(IdentityApiContract.Header.X_SC_DVC_ID, str);
        return map;
    }

    public String renew(String str) throws ScspException {
        String str2 = ScspErs.getDomain(this.scontextHolder).playUrl + BASE_URI + this.featureUri + "/token/renew?deviceCurrentTime=" + System.currentTimeMillis();
        Map<String, String> mapMakeRequestHeader = makeRequestHeader(this.scontextHolder);
        JsonObject jsonObject = new JsonObject();
        if (str.startsWith(IdentityApiContract.Token.BEARER_)) {
            str = str.substring(7);
        }
        jsonObject.addProperty(IdentityApiContract.Parameter.PREVIOUS_TOKEN, str);
        String string = jsonObject.toString();
        SContextHolder sContextHolder = this.scontextHolder;
        HttpRequest httpRequestBuild = new HttpRequestImpl.HttpRequestBuilder(mapMakeRequestHeader, str2, sContextHolder.requestTimeOut, sContextHolder.isAccountRequiredFeature).name(this.tag).payload(ContentType.JSON, string).build();
        Holder holder = new Holder();
        this.scontextHolder.network.post(httpRequestBuild, new C11658c(this, holder, 3));
        return (String) holder.get();
    }

    public abstract void saveToken(String str, long j);
}
