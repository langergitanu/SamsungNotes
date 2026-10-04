package com.microsoft.identity.client;

import android.util.Base64;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.internal.MsalUtils;
import java.nio.charset.Charset;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
final class ClientInfo {
    private final String mUniqueIdentifier;
    private final String mUniqueTenantIdentifier;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ClientInfoClaim {
        static final String UNIQUE_IDENTIFIER = "uid";
        static final String UNIQUE_TENANT_IDENTIFIER = "utid";
    }

    public ClientInfo(String str) throws MsalClientException {
        if (MsalUtils.isEmpty(str)) {
            this.mUniqueIdentifier = "";
            this.mUniqueTenantIdentifier = "";
        } else {
            try {
                Map<String, String> mapExtractJsonObjectIntoMap = MsalUtils.extractJsonObjectIntoMap(new String(Base64.decode(str, 8), Charset.forName("UTF-8")));
                this.mUniqueIdentifier = mapExtractJsonObjectIntoMap.get("uid");
                this.mUniqueTenantIdentifier = mapExtractJsonObjectIntoMap.get("utid");
            } catch (JSONException unused) {
                throw new MsalClientException("json_parse_failure", "Failed to parse the returned raw client info.");
            }
        }
    }

    public String getUniqueIdentifier() {
        return MsalUtils.isEmpty(this.mUniqueIdentifier) ? "" : this.mUniqueIdentifier;
    }

    public String getUniqueTenantIdentifier() {
        return MsalUtils.isEmpty(this.mUniqueTenantIdentifier) ? "" : this.mUniqueTenantIdentifier;
    }
}
