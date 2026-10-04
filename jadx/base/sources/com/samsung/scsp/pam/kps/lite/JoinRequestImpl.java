package com.samsung.scsp.pam.kps.lite;

import android.annotation.SuppressLint;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.scsp.common.Header;
import com.samsung.scsp.common.Holder;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.api.AbstractApiControl;
import com.samsung.scsp.framework.core.api.ApiContext;
import com.samsung.scsp.framework.core.listeners.Listeners;
import com.samsung.scsp.framework.core.listeners.ListenersHolder;
import com.samsung.scsp.framework.core.listeners.ResponseListener;
import com.samsung.scsp.framework.core.network.Network;
import com.samsung.scsp.framework.core.util.StringUtil;
import com.samsung.scsp.pam.kps.lite.KpsApiContract;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@SuppressLint({WarningType.NewApi})
class JoinRequestImpl extends AbstractApiControl.Request {
    private final Logger logger;

    public JoinRequestImpl() {
        super("JOIN");
        this.logger = Logger.get("GetServiceKeyImpl");
    }

    private void checkEssentialData(String str, ApiContext apiContext) {
        apiContext.name = KpsLiteApiSpec.CHECK_ESSENTIAL_DATA;
        String serviceKeyId = ((KeyManagementLite) apiContext.parameters.get(KpsApiContract.Parameter.KEY_MANAGEMENT)).getServiceKeyId(str);
        if (!StringUtil.isEmpty(serviceKeyId)) {
            apiContext.parameters.put(KpsApiContract.Header.SERVICE_KEY_ID, serviceKeyId);
        }
        apiContext.api.execute(apiContext, ListenersHolder.create().getListeners());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public KpsServiceKeyVo getServiceKey(final ApiContext apiContext, int i, String str) throws ScspException {
        this.logger.m12934i("getServiceKey");
        apiContext.name = "JOIN";
        final Holder holder = new Holder();
        Listeners listeners = new Listeners();
        listeners.responseListener = new ResponseListener<KpsServiceKeyVo>() { // from class: com.samsung.scsp.pam.kps.lite.JoinRequestImpl.1
            @Override // com.samsung.scsp.framework.core.listeners.ResponseListener
            public void onResponse(KpsServiceKeyVo kpsServiceKeyVo) {
            }

            @Override // com.samsung.scsp.framework.core.listeners.ResponseListener
            public /* bridge */ /* synthetic */ void onResponse(KpsServiceKeyVo kpsServiceKeyVo, Map map) {
                onResponse2(kpsServiceKeyVo, (Map<String, List<String>>) map);
            }

            /* JADX INFO: renamed from: onResponse, reason: avoid collision after fix types in other method */
            public void onResponse2(KpsServiceKeyVo kpsServiceKeyVo, Map<String, List<String>> map) {
                int i2 = Integer.parseInt(map.get(Network.HTTP_STATUS).get(0));
                if (i2 == 200) {
                    holder.hold(kpsServiceKeyVo);
                } else if (i2 == 202) {
                    holder.hold(JoinRequestImpl.this.getServiceKey(apiContext, kpsServiceKeyVo.retryAfter, map.get(Header.LOCATION).get(0)));
                }
            }
        };
        this.logger.m12934i(String.format("requestAfter: %d", Integer.valueOf(i)));
        if (!KpsServiceKeyReadyPushHandlerFactory.get().await(i, TimeUnit.SECONDS)) {
            throw new ScspException(ScspException.Code.CANCELED, "User canceled.");
        }
        apiContext.parameters.put(Header.LOCATION, str);
        apiContext.api.execute(apiContext, listeners);
        return (KpsServiceKeyVo) holder.get();
    }

    private void importServiceKey(ApiContext apiContext, String str, KpsServiceKeyVo kpsServiceKeyVo) throws ScspException {
        try {
            ((KeyManagementLite) apiContext.parameters.get(KpsApiContract.Parameter.KEY_MANAGEMENT)).setServiceKey(str, kpsServiceKeyVo.serviceKeyId, Base64.getDecoder().decode(kpsServiceKeyVo.wrappedServiceKey));
        } catch (ScspException e) {
            throw e;
        } catch (Exception e2) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendHasServiceKey$0(ApiContext apiContext, ListenersHolder listenersHolder) {
        apiContext.api.execute(apiContext, listenersHolder.getListeners());
    }

    private KpsRequestKeyVo requestServiceKey(String str, ApiContext apiContext) throws ScspException {
        this.logger.m12934i("requestServiceKey");
        apiContext.name = KpsLiteApiSpec.REQUEST_SERVICE_KEY;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(KpsApiContract.Parameter.SDID, apiContext.scontext.getE2eeInfoSupplier().getSakUid());
        X509Certificate[] wrapKey = ((KeyManagementLite) apiContext.parameters.get(KpsApiContract.Parameter.KEY_MANAGEMENT)).getWrapKey(str);
        try {
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(new String(Base64.getEncoder().encode(wrapKey[0].getEncoded())));
            jsonArray.add(new String(Base64.getEncoder().encode(wrapKey[1].getEncoded())));
            jsonObject.add(KpsApiContract.Parameter.CERTIFICATE_CHAIN, jsonArray);
            apiContext.payload = jsonObject.toString();
            final Holder holder = new Holder();
            Listeners listeners = new Listeners();
            listeners.responseListener = new ResponseListener<KpsRequestKeyVo>() { // from class: com.samsung.scsp.pam.kps.lite.JoinRequestImpl.2
                @Override // com.samsung.scsp.framework.core.listeners.ResponseListener
                public void onResponse(KpsRequestKeyVo kpsRequestKeyVo) {
                }

                @Override // com.samsung.scsp.framework.core.listeners.ResponseListener
                public /* bridge */ /* synthetic */ void onResponse(KpsRequestKeyVo kpsRequestKeyVo, Map map) {
                    onResponse2(kpsRequestKeyVo, (Map<String, List<String>>) map);
                }

                /* JADX INFO: renamed from: onResponse, reason: avoid collision after fix types in other method */
                public void onResponse2(KpsRequestKeyVo kpsRequestKeyVo, Map<String, List<String>> map) {
                    if (Integer.parseInt(map.get(Network.HTTP_STATUS).get(0)) == 202) {
                        kpsRequestKeyVo.location = map.get(Header.LOCATION).get(0);
                        holder.hold(kpsRequestKeyVo);
                    }
                }
            };
            apiContext.api.execute(apiContext, listeners);
            return (KpsRequestKeyVo) holder.get();
        } catch (CertificateEncodingException e) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, e.getMessage());
        }
    }

    private void sendHasServiceKey(ApiContext apiContext, String str) {
        apiContext.name = KpsLiteApiSpec.SET_SERVICE_KEY_SECURED_STATISTICS;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("serviceId", str);
        apiContext.payload = jsonObject.toString();
        FaultBarrier.run(new C11690a(apiContext, ListenersHolder.create(), 0));
    }

    @Override // com.samsung.scsp.framework.core.api.AbstractApiControl.Request
    public void execute(ApiContext apiContext, Listeners listeners) throws ScspException {
        String asString = apiContext.parameters.getAsString("serviceId");
        try {
            checkEssentialData(asString, apiContext);
        } catch (ScspException e) {
            if (e.rcode != 40305006) {
                throw e;
            }
            KeyManagementLite keyManagementLite = (KeyManagementLite) apiContext.parameters.get(KpsApiContract.Parameter.KEY_MANAGEMENT);
            keyManagementLite.onKeySyncStarted();
            KpsRequestKeyVo kpsRequestKeyVoRequestServiceKey = requestServiceKey(asString, apiContext);
            if (kpsRequestKeyVoRequestServiceKey == null || StringUtil.isEmpty(kpsRequestKeyVoRequestServiceKey.location)) {
                return;
            }
            importServiceKey(apiContext, asString, getServiceKey(apiContext, kpsRequestKeyVoRequestServiceKey.requestAfter, kpsRequestKeyVoRequestServiceKey.location));
            sendHasServiceKey(apiContext, asString);
            keyManagementLite.onKeySyncCompleted();
            checkEssentialData(asString, apiContext);
        }
    }
}
