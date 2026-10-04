package com.samsung.scsp.framework.core.api;

import com.google.gson.Gson;
import com.samsung.scsp.common.Header;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.Network;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p122b2.C4183f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ResponsiveJob extends SimpleJob implements Network.StreamListener {
    private final Class<?> responseClass;

    public ResponsiveJob(HttpRequest.Method method, String str, String str2, Class<?> cls) {
        super(method, str, str2);
        this.responseClass = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onStream$0(HttpRequest httpRequest, String str) {
        return "[onStream] : " + httpRequest.hashCode() + ":" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onStream$1(Map map) {
        return (String) ((List) map.get(Header.ETAG)).get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onStream$2() {
        return "check DrsSupportableResponse";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onStream$3(Map map) {
        return (String) ((List) map.get(Header.DRS_ROUTED)).get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onStream$4(Map map) {
        return (String) ((List) map.get(Header.DRS_TICKET_ID)).get(0);
    }

    @Override // com.samsung.scsp.framework.core.api.SimpleJob
    public Network.StreamListener getStreamListener() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStream(HttpRequest httpRequest, final Map<String, List<String>> map, InputStream inputStream) {
        Object objFromJson;
        this.responseClass.getClass();
        int i = Integer.parseInt(map.get(Network.HTTP_STATUS).get(0));
        if (i == 200 || i == 202 || i == 207) {
            String string = new Response(inputStream).toString();
            Logger.get(httpRequest.getName()).m12931d(new C4183f(httpRequest, string, 7));
            objFromJson = string;
            if (this.responseClass != String.class) {
                objFromJson = new Gson().fromJson(string, (Class<Object>) this.responseClass);
            }
        } else {
            Class<?> cls = this.responseClass;
            Objects.requireNonNull(cls);
            objFromJson = FaultBarrier.get(new C11638b(cls, 1), null).obj;
        }
        if (objFromJson instanceof CacheableResponse) {
            final int i2 = 0;
            ((CacheableResponse) objFromJson).update(i, (String) FaultBarrier.get(new FaultBarrier.ThrowableSupplier() { // from class: com.samsung.scsp.framework.core.api.e
                @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
                public final Object get() {
                    switch (i2) {
                        case 0:
                            return ResponsiveJob.lambda$onStream$1(map);
                        case 1:
                            return ResponsiveJob.lambda$onStream$3(map);
                        default:
                            return ResponsiveJob.lambda$onStream$4(map);
                    }
                }
            }, null, true).obj);
        }
        if (objFromJson instanceof DrsSupportableResponse) {
            Logger.get(httpRequest.getName()).m12931d(new C11642f());
            final int i4 = 1;
            final int i5 = 2;
            ((DrsSupportableResponse) objFromJson).update(Boolean.parseBoolean((String) FaultBarrier.get(new FaultBarrier.ThrowableSupplier() { // from class: com.samsung.scsp.framework.core.api.e
                @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
                public final Object get() {
                    switch (i4) {
                        case 0:
                            return ResponsiveJob.lambda$onStream$1(map);
                        case 1:
                            return ResponsiveJob.lambda$onStream$3(map);
                        default:
                            return ResponsiveJob.lambda$onStream$4(map);
                    }
                }
            }, "false", true).obj), (String) FaultBarrier.get(new FaultBarrier.ThrowableSupplier() { // from class: com.samsung.scsp.framework.core.api.e
                @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
                public final Object get() {
                    switch (i5) {
                        case 0:
                            return ResponsiveJob.lambda$onStream$1(map);
                        case 1:
                            return ResponsiveJob.lambda$onStream$3(map);
                        default:
                            return ResponsiveJob.lambda$onStream$4(map);
                    }
                }
            }, null, true).obj);
        }
        httpRequest.getResponseListener().onResponse(objFromJson, map);
    }
}
