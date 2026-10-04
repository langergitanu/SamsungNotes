package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.cache.CacheRecord;
import com.microsoft.identity.common.java.eststelemetry.EstsTelemetry;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class CacheEndEvent extends BaseEvent {
    public CacheEndEvent() {
        names(TelemetryEventStrings.Event.CACHE_END_EVENT);
        types(TelemetryEventStrings.EventType.CACHE_EVENT);
    }

    public CacheEndEvent putAtStatus(String str) {
        put("Microsoft.MSAL.at_status", str);
        return this;
    }

    public CacheEndEvent putCacheRecordStatus(CacheRecord cacheRecord) {
        if (cacheRecord == null) {
            return this;
        }
        put("Microsoft.MSAL.at_status", cacheRecord.getAccessToken() == null ? "false" : "true");
        if (cacheRecord.getRefreshToken() != null) {
            put("Microsoft.MSAL.mrrt_status", "true");
            put("Microsoft.MSAL.rt_status", "true");
            put("Microsoft.MSAL.frt_status", StringUtil.isNullOrEmpty(cacheRecord.getRefreshToken().getFamilyId()) ? "false" : "true");
        } else {
            put("Microsoft.MSAL.rt_status", "false");
        }
        put("Microsoft.MSAL.id_token_status", cacheRecord.getIdToken() == null ? "false" : "true");
        put(TelemetryEventStrings.Key.V1_ID_TOKEN_STATUS, cacheRecord.getV1IdToken() == null ? "false" : "true");
        put("Microsoft.MSAL.account_status", cacheRecord.getAccount() != null ? "true" : "false");
        EstsTelemetry.getInstance().emit(getProperties());
        return this;
    }

    public CacheEndEvent putFrtStatus(String str) {
        put("Microsoft.MSAL.frt_status", str);
        return this;
    }

    public CacheEndEvent putRtStatus(String str) {
        put("Microsoft.MSAL.rt_status", str);
        return this;
    }

    public CacheEndEvent putSpeInfo(String str) {
        put(TelemetryEventStrings.Key.SPE_INFO, str);
        return this;
    }
}
