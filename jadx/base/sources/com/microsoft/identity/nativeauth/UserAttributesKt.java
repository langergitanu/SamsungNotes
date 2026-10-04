package com.microsoft.identity.nativeauth;

import com.microsoft.identity.common.java.util.ObjectMapper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000¨\u0006\u0004"}, m13886d2 = {"toMap", "", "", "Lcom/microsoft/identity/nativeauth/UserAttributes;", "msal_distRelease"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class UserAttributesKt {
    @NotNull
    public static final Map<String, String> toMap(@NotNull UserAttributes userAttributes) {
        Intrinsics.checkNotNullParameter(userAttributes, "<this>");
        Map<String, String> mapConstructMapFromObject = ObjectMapper.constructMapFromObject(userAttributes.getUserAttributes$msal_distRelease());
        Intrinsics.checkNotNullExpressionValue(mapConstructMapFromObject, "constructMapFromObject(userAttributes)");
        return mapConstructMapFromObject;
    }
}
