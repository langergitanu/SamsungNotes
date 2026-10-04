package com.samsung.scsp.pam.kps.lite;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.google.gson.Gson;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.C11634a;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.api.Response;
import com.samsung.scsp.framework.core.api.ResponsiveJob;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.Network;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import p122b2.C4194q;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class KpsGetPolicyJobImpl extends ResponsiveJob {
    private static final Logger logger = Logger.get("KpsGetPolicyJobImpl");

    public KpsGetPolicyJobImpl(HttpRequest.Method method, String str, String str2, Class<?> cls) {
        super(method, str, str2, cls);
    }

    private KpsPolicies getCachedPolicies(String str) throws ScspException {
        try {
            return (KpsPolicies) new Gson().fromJson(str, KpsPolicies.class);
        } catch (Exception e) {
            logger.m12932e(e.getMessage());
            KpsLitePreferences.get().clear();
            throw new ScspException(ScspException.Code.RUNTIME_ENVIRONMENT, e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long getMaxAge(Map<String, List<String>> map) {
        return ((Long) FaultBarrier.get(new C11253j(map.get("Cache-Control"), 13), 0L).obj).longValue() * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$getMaxAge$3(List list) {
        return Long.valueOf(Long.parseLong(((String) list.get(0)).split(MarketingConstants.REFERRER_DELIMITER_U003D)[1]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onStream$0(long j) {
        return AbstractC0622a.m1169o("max-age : ", j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onStream$1(Map map) {
        return (String) ((List) map.get("ETag")).get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onStream$2(String str) {
        return AbstractC0541b.m772n("eTag : ", str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.scsp.framework.core.api.ResponsiveJob, com.samsung.scsp.framework.core.network.Network.StreamListener
    public void onStream(HttpRequest httpRequest, Map<String, List<String>> map, InputStream inputStream) {
        KpsPolicies cachedPolicies;
        int i = Integer.parseInt(map.get(Network.HTTP_STATUS).get(0));
        if (i == 200) {
            Response response = new Response(inputStream);
            KpsLitePreferences.get().policies.accept(response.toString());
            cachedPolicies = (KpsPolicies) response.create(KpsPolicies.class);
        } else {
            cachedPolicies = i == 304 ? getCachedPolicies(KpsLitePreferences.get().policies.get()) : null;
        }
        final long maxAge = getMaxAge(map);
        Logger logger2 = logger;
        logger2.m12931d(new Supplier() { // from class: com.samsung.scsp.pam.kps.lite.d
            @Override // java.util.function.Supplier
            public final Object get() {
                return KpsGetPolicyJobImpl.lambda$onStream$0(maxAge);
            }
        });
        KpsLitePreferences.get().expiredTime.accept(Long.valueOf(System.currentTimeMillis() + maxAge));
        String str = (String) FaultBarrier.get(new C11634a(map, 1), "").obj;
        logger2.m12931d(new C4194q(str, 4));
        KpsLitePreferences.get().eTag.accept(str);
        httpRequest.getResponseListener().onResponse(cachedPolicies);
    }
}
