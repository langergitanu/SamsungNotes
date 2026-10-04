package com.microsoft.identity.common.internal.logging;

import com.google.gson.Gson;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class RequestContext extends HashMap<String, String> implements IRequestContext {
    private static final String TAG = "RequestContext";
    private static final Gson mGson = new Gson();
    private static boolean sLogDeprecationWarning = true;

    @Override // com.microsoft.identity.common.java.logging.IRequestContext
    @SuppressFBWarnings({"ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD"})
    public String toJsonString() {
        if (sLogDeprecationWarning) {
            sLogDeprecationWarning = false;
            com.microsoft.identity.common.logging.Logger.warn(TAG + ":toJsonString", "This class is deprecated. Migrate usage to: com.microsoft.identity.common.logging.RequestContext");
        }
        return mGson.toJson(this);
    }
}
