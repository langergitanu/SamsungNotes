package com.microsoft.identity.common.java.nativeauth.providers.responses.signup;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
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
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\t\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u0082\u0001\t\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiResult;", "AuthNotSupported", "InvalidAttributes", "InvalidPassword", "InvalidUsername", "Redirect", "Success", "UnknownError", "UnsupportedChallengeType", "UsernameAlreadyExists", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$AuthNotSupported;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$InvalidAttributes;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$InvalidPassword;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$InvalidUsername;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$Success;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$UnsupportedChallengeType;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$UsernameAlreadyExists;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface SignUpStartApiResult extends ApiResult {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$AuthNotSupported;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "error", "", "errorDescription", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class AuthNotSupported extends ApiErrorResult implements SignUpStartApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthNotSupported(@NotNull String error, @NotNull String errorDescription, @NotNull String correlationId) {
            super(error, errorDescription, null, correlationId, 4, null);
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = error;
            this.errorDescription = errorDescription;
            this.correlationId = correlationId;
        }

        public static /* synthetic */ AuthNotSupported copy$default(AuthNotSupported authNotSupported, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = authNotSupported.getError();
            }
            if ((i & 2) != 0) {
                str2 = authNotSupported.getErrorDescription();
            }
            if ((i & 4) != 0) {
                str3 = authNotSupported.getCorrelationId();
            }
            return authNotSupported.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return getError();
        }

        @NotNull
        public final String component2() {
            return getErrorDescription();
        }

        @NotNull
        public final String component3() {
            return getCorrelationId();
        }

        @NotNull
        public final AuthNotSupported copy(@NotNull String error, @NotNull String errorDescription, @NotNull String correlationId) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new AuthNotSupported(error, errorDescription, correlationId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthNotSupported)) {
                return false;
            }
            AuthNotSupported authNotSupported = (AuthNotSupported) other;
            return Intrinsics.areEqual(getError(), authNotSupported.getError()) && Intrinsics.areEqual(getErrorDescription(), authNotSupported.getErrorDescription()) && Intrinsics.areEqual(getCorrelationId(), authNotSupported.getCorrelationId());
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
            return getCorrelationId().hashCode() + ((getErrorDescription().hashCode() + (getError().hashCode() * 31)) * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "AuthNotSupported(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "AuthNotSupported(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(@NotNull SignUpStartApiResult signUpStartApiResult) {
            return ApiResult.DefaultImpls.containsPii(signUpStartApiResult);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$InvalidAttributes;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "correlationId", "", "error", "errorDescription", "invalidAttributes", "", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getInvalidAttributes", "()Ljava/util/List;", "getSubError", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class InvalidAttributes extends ApiErrorResult implements SignUpStartApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        @NotNull
        private final List<String> invalidAttributes;

        @NotNull
        private final String subError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidAttributes(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<String> invalidAttributes, @NotNull String subError) {
            super(error, errorDescription, null, correlationId, 4, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(invalidAttributes, "invalidAttributes");
            Intrinsics.checkNotNullParameter(subError, "subError");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.invalidAttributes = invalidAttributes;
            this.subError = subError;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidAttributes copy$default(InvalidAttributes invalidAttributes, String str, String str2, String str3, List list, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidAttributes.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = invalidAttributes.getError();
            }
            if ((i & 4) != 0) {
                str3 = invalidAttributes.getErrorDescription();
            }
            if ((i & 8) != 0) {
                list = invalidAttributes.invalidAttributes;
            }
            if ((i & 16) != 0) {
                str4 = invalidAttributes.subError;
            }
            String str5 = str4;
            String str6 = str3;
            return invalidAttributes.copy(str, str2, str6, list, str5);
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
        public final List<String> component4() {
            return this.invalidAttributes;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSubError() {
            return this.subError;
        }

        @NotNull
        public final InvalidAttributes copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<String> invalidAttributes, @NotNull String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(invalidAttributes, "invalidAttributes");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new InvalidAttributes(correlationId, error, errorDescription, invalidAttributes, subError);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidAttributes)) {
                return false;
            }
            InvalidAttributes invalidAttributes = (InvalidAttributes) other;
            return Intrinsics.areEqual(getCorrelationId(), invalidAttributes.getCorrelationId()) && Intrinsics.areEqual(getError(), invalidAttributes.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidAttributes.getErrorDescription()) && Intrinsics.areEqual(this.invalidAttributes, invalidAttributes.invalidAttributes) && Intrinsics.areEqual(this.subError, invalidAttributes.subError);
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
        public final List<String> getInvalidAttributes() {
            return this.invalidAttributes;
        }

        @NotNull
        public final String getSubError() {
            return this.subError;
        }

        public int hashCode() {
            return this.subError.hashCode() + AbstractC0622a.m1159e(this.invalidAttributes, (getErrorDescription().hashCode() + ((getError().hashCode() + (getCorrelationId().hashCode() * 31)) * 31)) * 31, 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "InvalidPassword(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("InvalidAttributes(correlationId=");
            sb.append(getCorrelationId());
            sb.append(", invalidAttributes=");
            sb.append(this.invalidAttributes);
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
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$InvalidPassword;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "correlationId", "", "error", "errorDescription", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class InvalidPassword extends ApiErrorResult implements SignUpStartApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        @NotNull
        private final String subError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidPassword(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
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

        public static /* synthetic */ InvalidPassword copy$default(InvalidPassword invalidPassword, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidPassword.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = invalidPassword.getError();
            }
            if ((i & 4) != 0) {
                str3 = invalidPassword.getErrorDescription();
            }
            if ((i & 8) != 0) {
                str4 = invalidPassword.subError;
            }
            return invalidPassword.copy(str, str2, str3, str4);
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
        public final InvalidPassword copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new InvalidPassword(correlationId, error, errorDescription, subError);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidPassword)) {
                return false;
            }
            InvalidPassword invalidPassword = (InvalidPassword) other;
            return Intrinsics.areEqual(getCorrelationId(), invalidPassword.getCorrelationId()) && Intrinsics.areEqual(getError(), invalidPassword.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidPassword.getErrorDescription()) && Intrinsics.areEqual(this.subError, invalidPassword.subError);
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
            return "InvalidPassword(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "InvalidPassword(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$InvalidUsername;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "error", "", "errorDescription", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class InvalidUsername extends ApiErrorResult implements SignUpStartApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidUsername(@NotNull String error, @NotNull String errorDescription, @NotNull String correlationId) {
            super(error, errorDescription, null, correlationId, 4, null);
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = error;
            this.errorDescription = errorDescription;
            this.correlationId = correlationId;
        }

        public static /* synthetic */ InvalidUsername copy$default(InvalidUsername invalidUsername, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidUsername.getError();
            }
            if ((i & 2) != 0) {
                str2 = invalidUsername.getErrorDescription();
            }
            if ((i & 4) != 0) {
                str3 = invalidUsername.getCorrelationId();
            }
            return invalidUsername.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return getError();
        }

        @NotNull
        public final String component2() {
            return getErrorDescription();
        }

        @NotNull
        public final String component3() {
            return getCorrelationId();
        }

        @NotNull
        public final InvalidUsername copy(@NotNull String error, @NotNull String errorDescription, @NotNull String correlationId) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new InvalidUsername(error, errorDescription, correlationId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidUsername)) {
                return false;
            }
            InvalidUsername invalidUsername = (InvalidUsername) other;
            return Intrinsics.areEqual(getError(), invalidUsername.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidUsername.getErrorDescription()) && Intrinsics.areEqual(getCorrelationId(), invalidUsername.getCorrelationId());
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
            return getCorrelationId().hashCode() + ((getErrorDescription().hashCode() + (getError().hashCode() * 31)) * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "InvalidUsername(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "InvalidUsername(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "correlationId", "", "(Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class Redirect implements SignUpStartApiResult {

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
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$Success;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "continuationToken", "", "correlationId", "(Ljava/lang/String;Ljava/lang/String;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class Success implements SignUpStartApiResult {

        @NotNull
        private final String continuationToken;

        @NotNull
        private final String correlationId;

        public Success(@NotNull String continuationToken, @NotNull String correlationId) {
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.continuationToken = continuationToken;
            this.correlationId = correlationId;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.continuationToken;
            }
            if ((i & 2) != 0) {
                str2 = success.getCorrelationId();
            }
            return success.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @NotNull
        public final String component2() {
            return getCorrelationId();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return DefaultImpls.containsPii(this);
        }

        @NotNull
        public final Success copy(@NotNull String continuationToken, @NotNull String correlationId) {
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new Success(continuationToken, correlationId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.continuationToken, success.continuationToken) && Intrinsics.areEqual(getCorrelationId(), success.getCorrelationId());
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
            return getCorrelationId().hashCode() + (this.continuationToken.hashCode() * 31);
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
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "error", "", "errorDescription", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class UnknownError extends ApiErrorResult implements SignUpStartApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownError(@NotNull String error, @NotNull String errorDescription, @NotNull String correlationId) {
            super(error, errorDescription, null, correlationId, 4, null);
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = error;
            this.errorDescription = errorDescription;
            this.correlationId = correlationId;
        }

        public static /* synthetic */ UnknownError copy$default(UnknownError unknownError, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknownError.getError();
            }
            if ((i & 2) != 0) {
                str2 = unknownError.getErrorDescription();
            }
            if ((i & 4) != 0) {
                str3 = unknownError.getCorrelationId();
            }
            return unknownError.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return getError();
        }

        @NotNull
        public final String component2() {
            return getErrorDescription();
        }

        @NotNull
        public final String component3() {
            return getCorrelationId();
        }

        @NotNull
        public final UnknownError copy(@NotNull String error, @NotNull String errorDescription, @NotNull String correlationId) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new UnknownError(error, errorDescription, correlationId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnknownError)) {
                return false;
            }
            UnknownError unknownError = (UnknownError) other;
            return Intrinsics.areEqual(getError(), unknownError.getError()) && Intrinsics.areEqual(getErrorDescription(), unknownError.getErrorDescription()) && Intrinsics.areEqual(getCorrelationId(), unknownError.getCorrelationId());
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
            return getCorrelationId().hashCode() + ((getErrorDescription().hashCode() + (getError().hashCode() * 31)) * 31);
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
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$UnsupportedChallengeType;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "error", "", "errorDescription", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class UnsupportedChallengeType extends ApiErrorResult implements SignUpStartApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnsupportedChallengeType(@NotNull String error, @NotNull String errorDescription, @NotNull String correlationId) {
            super(error, errorDescription, null, correlationId, 4, null);
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = error;
            this.errorDescription = errorDescription;
            this.correlationId = correlationId;
        }

        public static /* synthetic */ UnsupportedChallengeType copy$default(UnsupportedChallengeType unsupportedChallengeType, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unsupportedChallengeType.getError();
            }
            if ((i & 2) != 0) {
                str2 = unsupportedChallengeType.getErrorDescription();
            }
            if ((i & 4) != 0) {
                str3 = unsupportedChallengeType.getCorrelationId();
            }
            return unsupportedChallengeType.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return getError();
        }

        @NotNull
        public final String component2() {
            return getErrorDescription();
        }

        @NotNull
        public final String component3() {
            return getCorrelationId();
        }

        @NotNull
        public final UnsupportedChallengeType copy(@NotNull String error, @NotNull String errorDescription, @NotNull String correlationId) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new UnsupportedChallengeType(error, errorDescription, correlationId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnsupportedChallengeType)) {
                return false;
            }
            UnsupportedChallengeType unsupportedChallengeType = (UnsupportedChallengeType) other;
            return Intrinsics.areEqual(getError(), unsupportedChallengeType.getError()) && Intrinsics.areEqual(getErrorDescription(), unsupportedChallengeType.getErrorDescription()) && Intrinsics.areEqual(getCorrelationId(), unsupportedChallengeType.getCorrelationId());
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
            return getCorrelationId().hashCode() + ((getErrorDescription().hashCode() + (getError().hashCode() * 31)) * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "UnsupportedChallengeType(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "UnsupportedChallengeType(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$UsernameAlreadyExists;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "error", "", "errorDescription", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class UsernameAlreadyExists extends ApiErrorResult implements SignUpStartApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UsernameAlreadyExists(@NotNull String error, @NotNull String errorDescription, @NotNull String correlationId) {
            super(error, errorDescription, null, correlationId, 4, null);
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = error;
            this.errorDescription = errorDescription;
            this.correlationId = correlationId;
        }

        public static /* synthetic */ UsernameAlreadyExists copy$default(UsernameAlreadyExists usernameAlreadyExists, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = usernameAlreadyExists.getError();
            }
            if ((i & 2) != 0) {
                str2 = usernameAlreadyExists.getErrorDescription();
            }
            if ((i & 4) != 0) {
                str3 = usernameAlreadyExists.getCorrelationId();
            }
            return usernameAlreadyExists.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return getError();
        }

        @NotNull
        public final String component2() {
            return getErrorDescription();
        }

        @NotNull
        public final String component3() {
            return getCorrelationId();
        }

        @NotNull
        public final UsernameAlreadyExists copy(@NotNull String error, @NotNull String errorDescription, @NotNull String correlationId) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new UsernameAlreadyExists(error, errorDescription, correlationId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UsernameAlreadyExists)) {
                return false;
            }
            UsernameAlreadyExists usernameAlreadyExists = (UsernameAlreadyExists) other;
            return Intrinsics.areEqual(getError(), usernameAlreadyExists.getError()) && Intrinsics.areEqual(getErrorDescription(), usernameAlreadyExists.getErrorDescription()) && Intrinsics.areEqual(getCorrelationId(), usernameAlreadyExists.getCorrelationId());
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
            return getCorrelationId().hashCode() + ((getErrorDescription().hashCode() + (getError().hashCode() * 31)) * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "UsernameAlreadyExists(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "UsernameAlreadyExists(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + PropertyUtils.MAPPED_DELIM2;
        }
    }
}
