package com.microsoft.identity.common.java.nativeauth.providers.responses.signin;

import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiResult;", "Redirect", "Success", "UnknownError", "UserNotFound", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult$Success;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult$UserNotFound;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface SignInInitiateApiResult extends ApiResult {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(@NotNull SignInInitiateApiResult signInInitiateApiResult) {
            return ApiResult.DefaultImpls.containsPii(signInInitiateApiResult);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult;", "correlationId", "", "(Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class Redirect implements SignInInitiateApiResult {

        @NotNull
        private final String correlationId;

        public Redirect(@NotNull String correlationId) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.correlationId = correlationId;
        }

        public static /* synthetic */ Redirect copy$default(Redirect redirect, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = redirect.getCorrelationId();
            }
            return redirect.copy(str);
        }

        @NotNull
        public final String component1() {
            return getCorrelationId();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return DefaultImpls.containsPii(this);
        }

        @NotNull
        public final Redirect copy(@NotNull String correlationId) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new Redirect(correlationId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Redirect) && Intrinsics.areEqual(getCorrelationId(), ((Redirect) other).getCorrelationId());
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        public int hashCode() {
            return getCorrelationId().hashCode();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return toUnsanitizedString();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "Redirect(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult$Success;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult;", "correlationId", "", "continuationToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class Success implements SignInInitiateApiResult {

        @NotNull
        private final String continuationToken;

        @NotNull
        private final String correlationId;

        public Success(@NotNull String correlationId, @NotNull String continuationToken) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = success.continuationToken;
            }
            return success.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return getCorrelationId();
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return DefaultImpls.containsPii(this);
        }

        @NotNull
        public final Success copy(@NotNull String correlationId, @NotNull String continuationToken) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            return new Success(correlationId, continuationToken);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(getCorrelationId(), success.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, success.continuationToken);
        }

        @NotNull
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        public int hashCode() {
            return this.continuationToken.hashCode() + (getCorrelationId().hashCode() * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return toUnsanitizedString();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "Success(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class UnknownError extends ApiErrorResult implements SignInInitiateApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final List<Integer> errorCodes;

        @NotNull
        private final String errorDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownError(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes) {
            super(error, errorDescription, errorCodes, correlationId);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.errorCodes = errorCodes;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UnknownError copy$default(UnknownError unknownError, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknownError.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = unknownError.getError();
            }
            if ((i & 4) != 0) {
                str3 = unknownError.getErrorDescription();
            }
            if ((i & 8) != 0) {
                list = unknownError.getErrorCodes();
            }
            return unknownError.copy(str, str2, str3, list);
        }

        @NotNull
        public final String component1() {
            return getCorrelationId();
        }

        @NotNull
        public final String component2() {
            return getError();
        }

        @NotNull
        public final String component3() {
            return getErrorDescription();
        }

        @NotNull
        public final List<Integer> component4() {
            return getErrorCodes();
        }

        @NotNull
        public final UnknownError copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            return new UnknownError(correlationId, error, errorDescription, errorCodes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnknownError)) {
                return false;
            }
            UnknownError unknownError = (UnknownError) other;
            return Intrinsics.areEqual(getCorrelationId(), unknownError.getCorrelationId()) && Intrinsics.areEqual(getError(), unknownError.getError()) && Intrinsics.areEqual(getErrorDescription(), unknownError.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), unknownError.getErrorCodes());
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult, com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        @NotNull
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        @NotNull
        public List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        @NotNull
        public String getErrorDescription() {
            return this.errorDescription;
        }

        public int hashCode() {
            return getErrorCodes().hashCode() + ((getErrorDescription().hashCode() + ((getError().hashCode() + (getCorrelationId().hashCode() * 31)) * 31)) * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "UnknownError(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "UnknownError(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult$UserNotFound;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class UserNotFound extends ApiErrorResult implements SignInInitiateApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final List<Integer> errorCodes;

        @NotNull
        private final String errorDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserNotFound(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes) {
            super(error, errorDescription, errorCodes, correlationId);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.errorCodes = errorCodes;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UserNotFound copy$default(UserNotFound userNotFound, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userNotFound.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = userNotFound.getError();
            }
            if ((i & 4) != 0) {
                str3 = userNotFound.getErrorDescription();
            }
            if ((i & 8) != 0) {
                list = userNotFound.getErrorCodes();
            }
            return userNotFound.copy(str, str2, str3, list);
        }

        @NotNull
        public final String component1() {
            return getCorrelationId();
        }

        @NotNull
        public final String component2() {
            return getError();
        }

        @NotNull
        public final String component3() {
            return getErrorDescription();
        }

        @NotNull
        public final List<Integer> component4() {
            return getErrorCodes();
        }

        @NotNull
        public final UserNotFound copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            return new UserNotFound(correlationId, error, errorDescription, errorCodes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserNotFound)) {
                return false;
            }
            UserNotFound userNotFound = (UserNotFound) other;
            return Intrinsics.areEqual(getCorrelationId(), userNotFound.getCorrelationId()) && Intrinsics.areEqual(getError(), userNotFound.getError()) && Intrinsics.areEqual(getErrorDescription(), userNotFound.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), userNotFound.getErrorCodes());
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult, com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        @NotNull
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        @NotNull
        public List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        @NotNull
        public String getErrorDescription() {
            return this.errorDescription;
        }

        public int hashCode() {
            return getErrorCodes().hashCode() + ((getErrorDescription().hashCode() + ((getError().hashCode() + (getCorrelationId().hashCode() * 31)) * 31)) * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "UserNotFound(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "UserNotFound(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + PropertyUtils.MAPPED_DELIM2;
        }
    }
}
