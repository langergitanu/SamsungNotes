package com.samsung.scsp.pam.kps.lite;

import android.util.Pair;
import com.samsung.scsp.common.Header;
import com.samsung.scsp.framework.core.api.AbstractApi;
import com.samsung.scsp.framework.core.api.ApiContext;
import com.samsung.scsp.framework.core.api.ApiSpec;
import com.samsung.scsp.framework.core.util.StringUtil;
import com.samsung.scsp.pam.kps.lite.KpsApiContract;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ApiSpec(KpsLiteApiSpec.class)
class KpsApiImpl extends AbstractApi {
    private static final Function<ApiContext, Pair<String, String>[]> SERVICE_KEY_ID_HEADER = new C11691b();

    public KpsApiImpl() {
        attachHeaderFunction(KpsLiteApiSpec.CHECK_ESSENTIAL_DATA, SERVICE_KEY_ID_HEADER);
        attachUrlFunction("JOIN", new C11692c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$1(ApiContext apiContext, String str) {
        return apiContext.parameters.getAsString(Header.LOCATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Pair[] lambda$static$0(ApiContext apiContext) {
        String asString = apiContext.parameters.getAsString(KpsApiContract.Header.SERVICE_KEY_ID);
        if (StringUtil.isEmpty(asString)) {
            return null;
        }
        return new Pair[]{new Pair(KpsApiContract.Header.SERVICE_KEY_ID, asString)};
    }
}
