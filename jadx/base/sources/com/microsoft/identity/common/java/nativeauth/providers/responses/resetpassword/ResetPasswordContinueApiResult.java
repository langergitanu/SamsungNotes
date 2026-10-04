package com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\f"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiResult;", "CodeIncorrect", "ExpiredToken", "PasswordRequired", "Redirect", "UnknownError", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult$CodeIncorrect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult$ExpiredToken;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult$PasswordRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult$UnknownError;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface ResetPasswordContinueApiResult extends ApiResult {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult$CodeIncorrect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult;", "correlationId", "", "error", "errorDescription", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class CodeIncorrect extends ApiErrorResult implements ResetPasswordContinueApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        @NotNull
        private final String subError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CodeIncorrect(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
            super(error, errorDescription, null, correlationId, 4, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.subError = subError;
        }

        public static /* synthetic */ CodeIncorrect copy$default(CodeIncorrect codeIncorrect, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = codeIncorrect.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = codeIncorrect.getError();
            }
            if ((i & 4) != 0) {
                str3 = codeIncorrect.getErrorDescription();
            }
            if ((i & 8) != 0) {
                str4 = codeIncorrect.subError;
            }
            return codeIncorrect.copy(str, str2, str3, str4);
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
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSubError() {
            return this.subError;
        }

        @NotNull
        public final CodeIncorrect copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new CodeIncorrect(correlationId, error, errorDescription, subError);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CodeIncorrect)) {
                return false;
            }
            CodeIncorrect codeIncorrect = (CodeIncorrect) other;
            return Intrinsics.areEqual(getCorrelationId(), codeIncorrect.getCorrelationId()) && Intrinsics.areEqual(getError(), codeIncorrect.getError()) && Intrinsics.areEqual(getErrorDescription(), codeIncorrect.getErrorDescription()) && Intrinsics.areEqual(this.subError, codeIncorrect.subError);
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
        public String getErrorDescription() {
            return this.errorDescription;
        }

        @NotNull
        public final String getSubError() {
            return this.subError;
        }

        public int hashCode() {
            return this.subError.hashCode() + ((getErrorDescription().hashCode() + ((getError().hashCode() + (getCorrelationId().hashCode() * 31)) * 31)) * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "CodeIncorrect(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("CodeIncorrect(correlationId=");
            sb.append(getCorrelationId());
            sb.append(", error=");
            sb.append(getError());
            sb.append(", errorDescription=");
            sb.append(getErrorDescription());
            sb.append(", subError=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.subError, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(@NotNull ResetPasswordContinueApiResult resetPasswordContinueApiResult) {
            return ApiResult.DefaultImpls.containsPii(resetPasswordContinueApiResult);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult$ExpiredToken;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult;", "correlationId", "", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class ExpiredToken extends ApiErrorResult implements ResetPasswordContinueApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExpiredToken(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            super(error, errorDescription, null, correlationId, 4, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
        }

        public static /* synthetic */ ExpiredToken copy$default(ExpiredToken expiredToken, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = expiredToken.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = expiredToken.getError();
            }
            if ((i & 4) != 0) {
                str3 = expiredToken.getErrorDescription();
            }
            return expiredToken.copy(str, str2, str3);
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
        public final ExpiredToken copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            return new ExpiredToken(correlationId, error, errorDescription);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExpiredToken)) {
                return false;
            }
            ExpiredToken expiredToken = (ExpiredToken) other;
            return Intrinsics.areEqual(getCorrelationId(), expiredToken.getCorrelationId()) && Intrinsics.areEqual(getError(), expiredToken.getError()) && Intrinsics.areEqual(getErrorDescription(), expiredToken.getErrorDescription());
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
        public String getErrorDescription() {
            return this.errorDescription;
        }

        public int hashCode() {
            return getErrorDescription().hashCode() + ((getError().hashCode() + (getCorrelationId().hashCode() * 31)) * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "ExpiredToken(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "ExpiredToken(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult$PasswordRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult;", "correlationId", "", "continuationToken", IdentityApiContract.Token.EXPIRES_IN, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "getExpiresIn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult$PasswordRequired;", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class PasswordRequired implements ResetPasswordContinueApiResult {

        @NotNull
        private final String continuationToken;

        @NotNull
        private final String correlationId;

        @Nullable
        private final Integer expiresIn;

        public PasswordRequired(@NotNull String correlationId, @NotNull String continuationToken, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
            this.expiresIn = num;
        }

        public static /* synthetic */ PasswordRequired copy$default(PasswordRequired passwordRequired, String str, String str2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = passwordRequired.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = passwordRequired.continuationToken;
            }
            if ((i & 4) != 0) {
                num = passwordRequired.expiresIn;
            }
            return passwordRequired.copy(str, str2, num);
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

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getExpiresIn() {
            return this.expiresIn;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return DefaultImpls.containsPii(this);
        }

        @NotNull
        public final PasswordRequired copy(@NotNull String correlationId, @NotNull String continuationToken, @Nullable Integer expiresIn) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            return new PasswordRequired(correlationId, continuationToken, expiresIn);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PasswordRequired)) {
                return false;
            }
            PasswordRequired passwordRequired = (PasswordRequired) other;
            return Intrinsics.areEqual(getCorrelationId(), passwordRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, passwordRequired.continuationToken) && Intrinsics.areEqual(this.expiresIn, passwordRequired.expiresIn);
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

        @Nullable
        public final Integer getExpiresIn() {
            return this.expiresIn;
        }

        public int hashCode() {
            int iM1202c = AbstractC1038a.m1202c(getCorrelationId().hashCode() * 31, 31, this.continuationToken);
            Integer num = this.expiresIn;
            return iM1202c + (num == null ? 0 : num.hashCode());
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return toUnsanitizedString();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "PasswordRequired(correlationId=" + getCorrelationId() + ", expiresIn=" + this.expiresIn + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult;", "correlationId", "", "(Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class Redirect implements ResetPasswordContinueApiResult {

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
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult;", "correlationId", "", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class UnknownError extends ApiErrorResult implements ResetPasswordContinueApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownError(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            super(error, errorDescription, null, correlationId, 4, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
        }

        public static /* synthetic */ UnknownError copy$default(UnknownError unknownError, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknownError.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = unknownError.getError();
            }
            if ((i & 4) != 0) {
                str3 = unknownError.getErrorDescription();
            }
            return unknownError.copy(str, str2, str3);
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
        public final UnknownError copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            return new UnknownError(correlationId, error, errorDescription);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnknownError)) {
                return false;
            }
            UnknownError unknownError = (UnknownError) other;
            return Intrinsics.areEqual(getCorrelationId(), unknownError.getCorrelationId()) && Intrinsics.areEqual(getError(), unknownError.getError()) && Intrinsics.areEqual(getErrorDescription(), unknownError.getErrorDescription());
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
        public String getErrorDescription() {
            return this.errorDescription;
        }

        public int hashCode() {
            return getErrorDescription().hashCode() + ((getError().hashCode() + (getCorrelationId().hashCode() * 31)) * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "UnknownError(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "UnknownError(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + PropertyUtils.MAPPED_DELIM2;
        }
    }
}
