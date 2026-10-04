package com.microsoft.identity.common.java.nativeauth.util;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.providers.IApiResponse;
import com.microsoft.identity.common.java.util.ObjectMapper;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/util/ApiResultUtil;", "", "()V", "logExposedFieldsOfObject", "", "tag", "", CoeditServiceConstants.Element.NAME_OBJECT, "logResponse", "response", "Lcom/microsoft/identity/common/java/nativeauth/providers/IApiResponse;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ApiResultUtil {

    @NotNull
    public static final ApiResultUtil INSTANCE = new ApiResultUtil();

    private ApiResultUtil() {
    }

    private final void logExposedFieldsOfObject(String tag, Object object) {
        Logger.warn(tag + ':' + object.getClass().getSimpleName(), ObjectMapper.serializeExposedFieldsOfObjectToJsonString(object));
    }

    public final void logResponse(@NotNull String tag, @NotNull IApiResponse response) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(response, "response");
        String str = tag + ':' + response.getClass().getSimpleName();
        if (response.getStatusCode() == 200) {
            Logger.info(str, "Success Result");
        } else {
            Logger.warn(str, "Failure Result (Status Code: " + response.getStatusCode() + PropertyUtils.MAPPED_DELIM2);
        }
        logExposedFieldsOfObject(str, response);
    }
}
