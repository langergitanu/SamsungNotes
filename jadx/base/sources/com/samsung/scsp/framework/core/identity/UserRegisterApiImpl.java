package com.samsung.scsp.framework.core.identity;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.gson.JsonObject;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.ers.ErsPreferences;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.HttpRequestImpl;
import com.samsung.scsp.framework.core.util.HashUtil;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class UserRegisterApiImpl extends AbstractRegisterApi {
    private static final String DEREGISTER_URI = "/deregister";
    private static final String USER = "user";

    public UserRegisterApiImpl(SContextHolder sContextHolder) {
        super(sContextHolder, "user");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deregister$0(HttpRequest httpRequest, Map map, InputStream inputStream) {
        this.logger.m12934i("Success deregister");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$makeAppPayload$1(E2eeInfoSupplier e2eeInfoSupplier) {
        return E2eeInfoSupplier.TYPES[e2eeInfoSupplier.getType()];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$saveRequestHeader$2(Map map) {
        return HashUtil.getStringSHA256((String) map.get(IdentityApiContract.Header.X_SC_UID));
    }

    public void deregister(String str) {
        String str2 = ErsPreferences.get().playUrl.get();
        if (StringUtil.isEmpty(str2)) {
            return;
        }
        String strM756B = AbstractC0541b.m756B(str2, "/identity/v2/user/deregister");
        HashMap map = new HashMap();
        map.put("Authorization", str);
        map.put("User-Agent", this.scontextHolder.userAgent);
        SContextHolder sContextHolder = this.scontextHolder;
        this.scontextHolder.network.post(new HttpRequestImpl.HttpRequestBuilder(map, strM756B, sContextHolder.requestTimeOut, sContextHolder.isAccountRequiredFeature).name("UserRegisterApiImpl").silent().build(), new C11666k(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.scsp.framework.core.identity.AbstractRegisterApi
    public JsonObject makeAppPayload() {
        JsonObject jsonObjectMakeAppPayload = super.makeAppPayload();
        E2eeInfoSupplier e2eeInfoSupplier = this.scontext.getE2eeInfoSupplier();
        if (e2eeInfoSupplier != null && !StringUtil.isEmpty(e2eeInfoSupplier.getSakUid())) {
            jsonObjectMakeAppPayload.addProperty(IdentityApiContract.Parameter.E2EE_TYPE, (String) FaultBarrier.get(new C11665j(e2eeInfoSupplier, 1), "non").obj);
        }
        PushInfoSupplier pushInfoSupplier = this.scontext.getPushInfoSupplier();
        if (pushInfoSupplier != null && pushInfoSupplier.has()) {
            AccountInfoSupplier accountInfoSupplier = this.scontext.getAccountInfoSupplier();
            if (accountInfoSupplier != null && accountInfoSupplier.has()) {
                jsonObjectMakeAppPayload.add(IdentityApiContract.Parameter.PUSHES, new PushInfoList(pushInfoSupplier.getPushInfo()).toJsonArray());
                return jsonObjectMakeAppPayload;
            }
            this.logger.m12932e("Skipping push registration because there is no account information in AccountInfoSupplier");
        }
        return jsonObjectMakeAppPayload;
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractRegisterApi
    public Map<String, String> makeRequestHeader(SContextHolder sContextHolder) {
        Map<String, String> mapMakeRequestHeader = super.makeRequestHeader(sContextHolder);
        AccountInfoSupplier accountInfoSupplier = sContextHolder.scontext.getAccountInfoSupplier();
        mapMakeRequestHeader.put(IdentityApiContract.Header.X_SC_ACCESS_TOKEN, accountInfoSupplier.getAccessToken());
        mapMakeRequestHeader.put(IdentityApiContract.Header.X_SC_UID, accountInfoSupplier.getUserId());
        return mapMakeRequestHeader;
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractRegisterApi
    public void saveAppPayload(JsonObject jsonObject) {
        super.saveAppPayload(jsonObject);
        if (jsonObject.has(IdentityApiContract.Parameter.E2EE_TYPE)) {
            ScspCorePreferences.get().e2eeType.accept(jsonObject.get(IdentityApiContract.Parameter.E2EE_TYPE).getAsString());
        }
        if (jsonObject.has(IdentityApiContract.Parameter.PUSHES)) {
            ScspCorePreferences.get().pushInfos.accept(jsonObject.getAsJsonArray(IdentityApiContract.Parameter.PUSHES).toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.scsp.framework.core.identity.AbstractRegisterApi
    public void saveRequestHeader(Map<String, String> map) {
        ScspCorePreferences.get().hashedUid.accept((String) FaultBarrier.get(new C11656a(map, 5), "").obj);
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractRegisterApi
    public void saveToken(String str, String str2, long j) {
        if ("device".equals(str)) {
            ScspCorePreferences.get().deviceToken.accept(str2);
            ScspCorePreferences.get().deviceTokenExpiredOn.accept(Long.valueOf(j));
        } else if ("user".equals(str)) {
            ScspCorePreferences.get().userToken.accept(str2);
            ScspCorePreferences.get().userTokenExpiredOn.accept(Long.valueOf(j));
        }
    }
}
