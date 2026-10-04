package com.microsoft.identity.common.java.logging;

import com.google.gson.Gson;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RequestContext extends HashMap<String, String> implements IRequestContext {
    private static final Gson mGson = new Gson();
    private static final long serialVersionUID = -2239604897244277047L;

    @Override // com.microsoft.identity.common.java.logging.IRequestContext
    public String toJsonString() {
        return mGson.toJson(this);
    }
}
