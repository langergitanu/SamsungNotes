package com.samsung.scsp.framework.core.api;

import com.samsung.scsp.framework.core.SContext;
import com.samsung.scsp.framework.core.SContextHolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ApiContext {
    public Api api;
    public Object content;
    public String etag;
    public String invoker;
    public String name;
    public SCHashMap parameters = new SCHashMap();
    public String payload;
    public SContext scontext;
    public SContextHolder scontextHolder;

    private ApiContext(SContextHolder sContextHolder, String str) {
        this.scontextHolder = sContextHolder;
        this.scontext = sContextHolder.scontext;
        this.name = str;
    }

    public static ApiContext create(SContextHolder sContextHolder, String str) {
        return new ApiContext(sContextHolder, str);
    }
}
