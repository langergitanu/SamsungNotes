package com.microsoft.identity.common.java.nativeauth.providers.responses;

import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "correlationId", "", "getCorrelationId", "()Ljava/lang/String;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface ApiResult extends ILoggable {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(@NotNull ApiResult apiResult) {
            return ILoggable.DefaultImpls.containsPii(apiResult);
        }
    }

    @NotNull
    String getCorrelationId();
}
