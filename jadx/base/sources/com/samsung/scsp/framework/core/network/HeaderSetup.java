package com.samsung.scsp.framework.core.network;

import android.content.Context;
import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.common.FeatureConfigurator;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.identity.ScspIdentityFactory;
import com.samsung.scsp.framework.core.util.DeviceUtil;
import com.samsung.scsp.framework.core.util.NetworkUtil;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HeaderSetup {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Key {
        public static final String AUTHORIZATION = "Authorization";
        public static final String MCC = "mcc";
        public static final String MNC = "mnc";
        public static final String MOBILE = "mobile";
        public static final String UNKNOWN = "unknown";
        public static final String USER_AGENT = "User-Agent";
        public static final String WIFI = "wifi";
        public static final String X_SC_APP_ID = "x-sc-app-id";
        public static final String X_SC_DEVICE_CC = "x-sc-device-cc";
        public static final String X_SC_DEVICE_CSC = "x-sc-device-csc";
        public static final String X_SC_DEVICE_MODEL = "x-sc-device-model";
        public static final String X_SC_DRS_CODE = "x-sc-drs-code";
        public static final String X_SC_NETWORK = "x-sc-network";
        public static final String X_SC_NETWORK_MCC = "x-sc-network-mcc";
        public static final String X_SC_NETWORK_MNC = "x-sc-network-mnc";
        public static final String X_SC_OS_TYPE = "x-sc-os-type";
        public static final String X_SC_OS_VERSION = "x-sc-os-version";
    }

    public static Map<String, String> commonHeader(SContextHolder sContextHolder) {
        HashMap map = new HashMap();
        map.put("User-Agent", sContextHolder.userAgent);
        String token = ScspIdentityFactory.getInstance(sContextHolder.isAccountRequiredFeature).getToken();
        if (token.isEmpty()) {
            throw new ScspException(ScspException.Code.RUNTIME_POLICY, "Authorization is invalid.");
        }
        map.put("Authorization", token);
        putDrsCodeHeader(sContextHolder, map);
        return map;
    }

    public static Map<String, String> networkHeader() {
        Context applicationContext = ContextFactory.getApplicationContext();
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder();
        if (NetworkUtil.isWifiOrEthernetConnected(applicationContext)) {
            sb.append(Key.WIFI);
        } else if (NetworkUtil.isMobileConnected(applicationContext)) {
            sb.append("mobile,mcc=");
            sb.append(DeviceUtil.getSimMcc(applicationContext));
            sb.append(",mnc=");
            sb.append(DeviceUtil.getSimMnc(applicationContext));
        } else {
            sb.append("unknown");
        }
        map.put("x-sc-network", sb.toString());
        return map;
    }

    private static void putDrsCodeHeader(SContextHolder sContextHolder, Map<String, String> map) {
        if (sContextHolder.isDrsSupportedFeature) {
            String drsCode = FeatureConfigurator.getDrsCode(ContextFactory.getApplicationContext());
            if (StringUtil.isEmpty(drsCode)) {
                return;
            }
            Logger.get("HeaderSetUp").m12934i("Test with QR Code");
            map.put(Key.X_SC_DRS_CODE, drsCode);
        }
    }
}
