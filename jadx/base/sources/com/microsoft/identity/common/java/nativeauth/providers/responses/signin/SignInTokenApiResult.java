package com.microsoft.identity.common.java.nativeauth.providers.responses.signin;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult;
import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002:\u0007\u0003\u0004\u0005\u0006\u0007\b\t\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "CodeIncorrect", "InvalidAuthenticationType", "InvalidCredentials", "MFARequired", "Success", "UnknownError", "UserNotFound", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$CodeIncorrect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$InvalidAuthenticationType;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$InvalidCredentials;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$MFARequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$Success;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$UserNotFound;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface SignInTokenApiResult extends ApiResult, ILoggable {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006 "}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$CodeIncorrect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class CodeIncorrect extends ApiErrorResult implements SignInTokenApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final List<Integer> errorCodes;

        @NotNull
        private final String errorDescription;

        @NotNull
        private final String subError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CodeIncorrect(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes, @NotNull String subError) {
            super(error, errorDescription, errorCodes, correlationId);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            Intrinsics.checkNotNullParameter(subError, "subError");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.errorCodes = errorCodes;
            this.subError = subError;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CodeIncorrect copy$default(CodeIncorrect codeIncorrect, String str, String str2, String str3, List list, String str4, int i, Object obj) {
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
                list = codeIncorrect.getErrorCodes();
            }
            if ((i & 16) != 0) {
                str4 = codeIncorrect.subError;
            }
            String str5 = str4;
            String str6 = str3;
            return codeIncorrect.copy(str, str2, str6, list, str5);
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
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSubError() {
            return this.subError;
        }

        @NotNull
        public final CodeIncorrect copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes, @NotNull String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new CodeIncorrect(correlationId, error, errorDescription, errorCodes, subError);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CodeIncorrect)) {
                return false;
            }
            CodeIncorrect codeIncorrect = (CodeIncorrect) other;
            return Intrinsics.areEqual(getCorrelationId(), codeIncorrect.getCorrelationId()) && Intrinsics.areEqual(getError(), codeIncorrect.getError()) && Intrinsics.areEqual(getErrorDescription(), codeIncorrect.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), codeIncorrect.getErrorCodes()) && Intrinsics.areEqual(this.subError, codeIncorrect.subError);
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

        @NotNull
        public final String getSubError() {
            return this.subError;
        }

        public int hashCode() {
            return this.subError.hashCode() + ((getErrorCodes().hashCode() + ((getErrorDescription().hashCode() + ((getError().hashCode() + (getCorrelationId().hashCode() * 31)) * 31)) * 31)) * 31);
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
            sb.append(", errorCodes=");
            sb.append(getErrorCodes());
            sb.append(", subError=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.subError, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(@NotNull SignInTokenApiResult signInTokenApiResult) {
            return ApiResult.DefaultImpls.containsPii(signInTokenApiResult);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$InvalidAuthenticationType;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class InvalidAuthenticationType extends ApiErrorResult implements SignInTokenApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final List<Integer> errorCodes;

        @NotNull
        private final String errorDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidAuthenticationType(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes) {
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
        public static /* synthetic */ InvalidAuthenticationType copy$default(InvalidAuthenticationType invalidAuthenticationType, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidAuthenticationType.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = invalidAuthenticationType.getError();
            }
            if ((i & 4) != 0) {
                str3 = invalidAuthenticationType.getErrorDescription();
            }
            if ((i & 8) != 0) {
                list = invalidAuthenticationType.getErrorCodes();
            }
            return invalidAuthenticationType.copy(str, str2, str3, list);
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
        public final InvalidAuthenticationType copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            return new InvalidAuthenticationType(correlationId, error, errorDescription, errorCodes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidAuthenticationType)) {
                return false;
            }
            InvalidAuthenticationType invalidAuthenticationType = (InvalidAuthenticationType) other;
            return Intrinsics.areEqual(getCorrelationId(), invalidAuthenticationType.getCorrelationId()) && Intrinsics.areEqual(getError(), invalidAuthenticationType.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidAuthenticationType.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), invalidAuthenticationType.getErrorCodes());
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
            return "InvalidAuthenticationType(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "InvalidAuthenticationType(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$InvalidCredentials;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class InvalidCredentials extends ApiErrorResult implements SignInTokenApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final List<Integer> errorCodes;

        @NotNull
        private final String errorDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidCredentials(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes) {
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
        public static /* synthetic */ InvalidCredentials copy$default(InvalidCredentials invalidCredentials, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidCredentials.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = invalidCredentials.getError();
            }
            if ((i & 4) != 0) {
                str3 = invalidCredentials.getErrorDescription();
            }
            if ((i & 8) != 0) {
                list = invalidCredentials.getErrorCodes();
            }
            return invalidCredentials.copy(str, str2, str3, list);
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
        public final InvalidCredentials copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            return new InvalidCredentials(correlationId, error, errorDescription, errorCodes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidCredentials)) {
                return false;
            }
            InvalidCredentials invalidCredentials = (InvalidCredentials) other;
            return Intrinsics.areEqual(getCorrelationId(), invalidCredentials.getCorrelationId()) && Intrinsics.areEqual(getError(), invalidCredentials.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidCredentials.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), invalidCredentials.getErrorCodes());
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
            return "InvalidCredentials(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "InvalidCredentials(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$MFARequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class MFARequired extends ApiErrorResult implements SignInTokenApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final List<Integer> errorCodes;

        @NotNull
        private final String errorDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MFARequired(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes) {
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
        public static /* synthetic */ MFARequired copy$default(MFARequired mFARequired, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mFARequired.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = mFARequired.getError();
            }
            if ((i & 4) != 0) {
                str3 = mFARequired.getErrorDescription();
            }
            if ((i & 8) != 0) {
                list = mFARequired.getErrorCodes();
            }
            return mFARequired.copy(str, str2, str3, list);
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
        public final MFARequired copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            return new MFARequired(correlationId, error, errorDescription, errorCodes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MFARequired)) {
                return false;
            }
            MFARequired mFARequired = (MFARequired) other;
            return Intrinsics.areEqual(getCorrelationId(), mFARequired.getCorrelationId()) && Intrinsics.areEqual(getError(), mFARequired.getError()) && Intrinsics.areEqual(getErrorDescription(), mFARequired.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), mFARequired.getErrorCodes());
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
            return "MFARequired(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "MFARequired(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$Success;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "tokenResponse", "Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsTokenResponse;", "(Ljava/lang/String;Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsTokenResponse;)V", "getCorrelationId", "()Ljava/lang/String;", "getTokenResponse", "()Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsTokenResponse;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class Success implements SignInTokenApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final MicrosoftStsTokenResponse tokenResponse;

        public Success(@NotNull String correlationId, @NotNull MicrosoftStsTokenResponse tokenResponse) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(tokenResponse, "tokenResponse");
            this.correlationId = correlationId;
            this.tokenResponse = tokenResponse;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, MicrosoftStsTokenResponse microsoftStsTokenResponse, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.getCorrelationId();
            }
            if ((i & 2) != 0) {
                microsoftStsTokenResponse = success.tokenResponse;
            }
            return success.copy(str, microsoftStsTokenResponse);
        }

        @NotNull
        public final String component1() {
            return getCorrelationId();
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MicrosoftStsTokenResponse getTokenResponse() {
            return this.tokenResponse;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return DefaultImpls.containsPii(this);
        }

        @NotNull
        public final Success copy(@NotNull String correlationId, @NotNull MicrosoftStsTokenResponse tokenResponse) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(tokenResponse, "tokenResponse");
            return new Success(correlationId, tokenResponse);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(getCorrelationId(), success.getCorrelationId()) && Intrinsics.areEqual(this.tokenResponse, success.tokenResponse);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        @NotNull
        public final MicrosoftStsTokenResponse getTokenResponse() {
            return this.tokenResponse;
        }

        public int hashCode() {
            return this.tokenResponse.hashCode() + (getCorrelationId().hashCode() * 31);
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
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class UnknownError extends ApiErrorResult implements SignInTokenApiResult {

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
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$UserNotFound;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class UserNotFound extends ApiErrorResult implements SignInTokenApiResult {

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
