package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.util.JsonUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import cz.msebera.android.httpclient.extras.Base64;
import java.io.Serializable;
import java.util.Map;
import lombok.NonNull;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ClientInfo implements Serializable {
    private static final String UNIQUE_IDENTIFIER = "uid";
    private static final String UNIQUE_TENANT_IDENTIFIER = "utid";
    private static final long serialVersionUID = 3326461566190095403L;
    private String mRawClientInfo;
    private String mUid;
    private String mUtid;

    public ClientInfo(@NonNull String str) throws ServiceException {
        if (str == null) {
            throw new NullPointerException("rawClientInfo is marked non-null but is null");
        }
        if (StringUtil.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("ClientInfo cannot be null or blank.");
        }
        try {
            Map<String, String> mapExtractJsonObjectIntoMap = JsonUtil.extractJsonObjectIntoMap(StringUtil.fromByteArray(Base64.decode(str, 8)));
            this.mUid = mapExtractJsonObjectIntoMap.get("uid");
            this.mUtid = mapExtractJsonObjectIntoMap.get(UNIQUE_TENANT_IDENTIFIER);
            this.mRawClientInfo = str;
        } catch (JSONException e) {
            throw new ServiceException("", "invalid_jwt", e);
        }
    }

    public String getRawClientInfo() {
        return this.mRawClientInfo;
    }

    public String getUid() {
        return this.mUid;
    }

    public String getUtid() {
        return this.mUtid;
    }
}
