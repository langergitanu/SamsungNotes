package com.microsoft.identity.common.java.nativeauth.providers.responses;

import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\b&\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0011"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiResult;", "error", "", "errorDescription", "errorCodes", "", "", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public abstract class ApiErrorResult implements ApiResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String INVALID_STATE = ErrorTypes.INVALID_STATE;

    @NotNull
    private final String correlationId;

    @Nullable
    private final String error;

    @Nullable
    private final List<Integer> errorCodes;

    @Nullable
    private final String errorDescription;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult$Companion;", "", "()V", "INVALID_STATE", "", "getINVALID_STATE", "()Ljava/lang/String;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getINVALID_STATE() {
            return ApiErrorResult.INVALID_STATE;
        }

        private Companion() {
        }
    }

    public ApiErrorResult(@Nullable String str, @Nullable String str2, @Nullable List<Integer> list, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.error = str;
        this.errorDescription = str2;
        this.errorCodes = list;
        this.correlationId = correlationId;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return ApiResult.DefaultImpls.containsPii(this);
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
    @NotNull
    public String getCorrelationId() {
        return this.correlationId;
    }

    @Nullable
    public String getError() {
        return this.error;
    }

    @Nullable
    public List<Integer> getErrorCodes() {
        return this.errorCodes;
    }

    @Nullable
    public String getErrorDescription() {
        return this.errorDescription;
    }

    public /* synthetic */ ApiErrorResult(String str, String str2, List list, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : list, str3);
    }
}
