package com.microsoft.identity.common.java.nativeauth.providers.responses.signup;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.UserAttributeApiResult;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\n\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\u0082\u0001\n\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiResult;", "AttributesRequired", "CredentialRequired", "ExpiredToken", "InvalidAttributes", "InvalidOOBValue", "InvalidPassword", "Redirect", "Success", "UnknownError", "UsernameAlreadyExists", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$AttributesRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$CredentialRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$ExpiredToken;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$InvalidAttributes;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$InvalidOOBValue;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$InvalidPassword;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$Success;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$UsernameAlreadyExists;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface SignUpContinueApiResult extends ApiResult {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$AttributesRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "continuationToken", "error", "errorDescription", "requiredAttributes", "", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/UserAttributeApiResult;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "getError", "getErrorDescription", "getRequiredAttributes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class AttributesRequired extends ApiErrorResult implements SignUpContinueApiResult {

        @NotNull
        private final String continuationToken;

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        @NotNull
        private final List<UserAttributeApiResult> requiredAttributes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AttributesRequired(@NotNull String correlationId, @NotNull String continuationToken, @NotNull String error, @NotNull String errorDescription, @NotNull List<UserAttributeApiResult> requiredAttributes) {
            super(error, errorDescription, null, correlationId, 4, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(requiredAttributes, "requiredAttributes");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
            this.error = error;
            this.errorDescription = errorDescription;
            this.requiredAttributes = requiredAttributes;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AttributesRequired copy$default(AttributesRequired attributesRequired, String str, String str2, String str3, String str4, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = attributesRequired.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = attributesRequired.continuationToken;
            }
            if ((i & 4) != 0) {
                str3 = attributesRequired.getError();
            }
            if ((i & 8) != 0) {
                str4 = attributesRequired.getErrorDescription();
            }
            if ((i & 16) != 0) {
                list = attributesRequired.requiredAttributes;
            }
            List list2 = list;
            String str5 = str3;
            return attributesRequired.copy(str, str2, str5, str4, list2);
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

        @NotNull
        public final String component3() {
            return getError();
        }

        @NotNull
        public final String component4() {
            return getErrorDescription();
        }

        @NotNull
        public final List<UserAttributeApiResult> component5() {
            return this.requiredAttributes;
        }

        @NotNull
        public final AttributesRequired copy(@NotNull String correlationId, @NotNull String continuationToken, @NotNull String error, @NotNull String errorDescription, @NotNull List<UserAttributeApiResult> requiredAttributes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(requiredAttributes, "requiredAttributes");
            return new AttributesRequired(correlationId, continuationToken, error, errorDescription, requiredAttributes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AttributesRequired)) {
                return false;
            }
            AttributesRequired attributesRequired = (AttributesRequired) other;
            return Intrinsics.areEqual(getCorrelationId(), attributesRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, attributesRequired.continuationToken) && Intrinsics.areEqual(getError(), attributesRequired.getError()) && Intrinsics.areEqual(getErrorDescription(), attributesRequired.getErrorDescription()) && Intrinsics.areEqual(this.requiredAttributes, attributesRequired.requiredAttributes);
        }

        @NotNull
        public final String getContinuationToken() {
            return this.continuationToken;
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
        public final List<UserAttributeApiResult> getRequiredAttributes() {
            return this.requiredAttributes;
        }

        public int hashCode() {
            return this.requiredAttributes.hashCode() + ((getErrorDescription().hashCode() + ((getError().hashCode() + AbstractC1038a.m1202c(getCorrelationId().hashCode() * 31, 31, this.continuationToken)) * 31)) * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("AttributesRequired(correlationId=");
            sb.append(getCorrelationId());
            sb.append(", requiredAttributes=");
            return AbstractC1974b.m1321n(sb, this.requiredAttributes, PropertyUtils.MAPPED_DELIM2);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("AttributesRequired(correlationId=");
            sb.append(getCorrelationId());
            sb.append(", error=");
            sb.append(getError());
            sb.append(", errorDescription=");
            sb.append(getErrorDescription());
            sb.append(", requiredAttributes=");
            return AbstractC1974b.m1321n(sb, this.requiredAttributes, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$CredentialRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "continuationToken", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "getError", "getErrorDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class CredentialRequired extends ApiErrorResult implements SignUpContinueApiResult {

        @NotNull
        private final String continuationToken;

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CredentialRequired(@NotNull String correlationId, @NotNull String continuationToken, @NotNull String error, @NotNull String errorDescription) {
            super(error, errorDescription, null, correlationId, 4, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
            this.error = error;
            this.errorDescription = errorDescription;
        }

        public static /* synthetic */ CredentialRequired copy$default(CredentialRequired credentialRequired, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = credentialRequired.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = credentialRequired.continuationToken;
            }
            if ((i & 4) != 0) {
                str3 = credentialRequired.getError();
            }
            if ((i & 8) != 0) {
                str4 = credentialRequired.getErrorDescription();
            }
            return credentialRequired.copy(str, str2, str3, str4);
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

        @NotNull
        public final String component3() {
            return getError();
        }

        @NotNull
        public final String component4() {
            return getErrorDescription();
        }

        @NotNull
        public final CredentialRequired copy(@NotNull String correlationId, @NotNull String continuationToken, @NotNull String error, @NotNull String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            return new CredentialRequired(correlationId, continuationToken, error, errorDescription);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CredentialRequired)) {
                return false;
            }
            CredentialRequired credentialRequired = (CredentialRequired) other;
            return Intrinsics.areEqual(getCorrelationId(), credentialRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, credentialRequired.continuationToken) && Intrinsics.areEqual(getError(), credentialRequired.getError()) && Intrinsics.areEqual(getErrorDescription(), credentialRequired.getErrorDescription());
        }

        @NotNull
        public final String getContinuationToken() {
            return this.continuationToken;
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
            return getErrorDescription().hashCode() + ((getError().hashCode() + AbstractC1038a.m1202c(getCorrelationId().hashCode() * 31, 31, this.continuationToken)) * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "CredentialRequired(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "CredentialRequired(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(@NotNull SignUpContinueApiResult signUpContinueApiResult) {
            return ApiResult.DefaultImpls.containsPii(signUpContinueApiResult);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$ExpiredToken;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class ExpiredToken extends ApiErrorResult implements SignUpContinueApiResult {

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
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$InvalidAttributes;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "invalidAttributes", "", "error", "errorDescription", "subError", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getInvalidAttributes", "()Ljava/util/List;", "getSubError", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class InvalidAttributes extends ApiErrorResult implements SignUpContinueApiResult {

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
        public InvalidAttributes(@NotNull String correlationId, @NotNull List<String> invalidAttributes, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
            super(error, errorDescription, null, correlationId, 4, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(invalidAttributes, "invalidAttributes");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            this.correlationId = correlationId;
            this.invalidAttributes = invalidAttributes;
            this.error = error;
            this.errorDescription = errorDescription;
            this.subError = subError;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidAttributes copy$default(InvalidAttributes invalidAttributes, String str, List list, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidAttributes.getCorrelationId();
            }
            if ((i & 2) != 0) {
                list = invalidAttributes.invalidAttributes;
            }
            if ((i & 4) != 0) {
                str2 = invalidAttributes.getError();
            }
            if ((i & 8) != 0) {
                str3 = invalidAttributes.getErrorDescription();
            }
            if ((i & 16) != 0) {
                str4 = invalidAttributes.subError;
            }
            String str5 = str4;
            String str6 = str2;
            return invalidAttributes.copy(str, list, str6, str3, str5);
        }

        @NotNull
        public final String component1() {
            return getCorrelationId();
        }

        @NotNull
        public final List<String> component2() {
            return this.invalidAttributes;
        }

        @NotNull
        public final String component3() {
            return getError();
        }

        @NotNull
        public final String component4() {
            return getErrorDescription();
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSubError() {
            return this.subError;
        }

        @NotNull
        public final InvalidAttributes copy(@NotNull String correlationId, @NotNull List<String> invalidAttributes, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(invalidAttributes, "invalidAttributes");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new InvalidAttributes(correlationId, invalidAttributes, error, errorDescription, subError);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidAttributes)) {
                return false;
            }
            InvalidAttributes invalidAttributes = (InvalidAttributes) other;
            return Intrinsics.areEqual(getCorrelationId(), invalidAttributes.getCorrelationId()) && Intrinsics.areEqual(this.invalidAttributes, invalidAttributes.invalidAttributes) && Intrinsics.areEqual(getError(), invalidAttributes.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidAttributes.getErrorDescription()) && Intrinsics.areEqual(this.subError, invalidAttributes.subError);
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
            return this.subError.hashCode() + ((getErrorDescription().hashCode() + ((getError().hashCode() + AbstractC0622a.m1159e(this.invalidAttributes, getCorrelationId().hashCode() * 31, 31)) * 31)) * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "InvalidAttributes(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
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
            sb.append(", subError=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.subError, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$InvalidOOBValue;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "error", "errorDescription", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class InvalidOOBValue extends ApiErrorResult implements SignUpContinueApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        @NotNull
        private final String subError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidOOBValue(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
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

        public static /* synthetic */ InvalidOOBValue copy$default(InvalidOOBValue invalidOOBValue, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidOOBValue.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = invalidOOBValue.getError();
            }
            if ((i & 4) != 0) {
                str3 = invalidOOBValue.getErrorDescription();
            }
            if ((i & 8) != 0) {
                str4 = invalidOOBValue.subError;
            }
            return invalidOOBValue.copy(str, str2, str3, str4);
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
        public final InvalidOOBValue copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new InvalidOOBValue(correlationId, error, errorDescription, subError);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidOOBValue)) {
                return false;
            }
            InvalidOOBValue invalidOOBValue = (InvalidOOBValue) other;
            return Intrinsics.areEqual(getCorrelationId(), invalidOOBValue.getCorrelationId()) && Intrinsics.areEqual(getError(), invalidOOBValue.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidOOBValue.getErrorDescription()) && Intrinsics.areEqual(this.subError, invalidOOBValue.subError);
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
            return "InvalidOOBValue(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("InvalidOOBValue(correlationId=");
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
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$InvalidPassword;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "error", "errorDescription", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class InvalidPassword extends ApiErrorResult implements SignUpContinueApiResult {

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
            StringBuilder sb = new StringBuilder("InvalidPassword(correlationId=");
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
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "(Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class Redirect implements SignUpContinueApiResult {

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
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ0\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$Success;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "continuationToken", IdentityApiContract.Token.EXPIRES_IN, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "getExpiresIn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$Success;", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class Success implements SignUpContinueApiResult {

        @Nullable
        private final String continuationToken;

        @NotNull
        private final String correlationId;

        @Nullable
        private final Integer expiresIn;

        public Success(@NotNull String correlationId, @Nullable String str, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.correlationId = correlationId;
            this.continuationToken = str;
            this.expiresIn = num;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, String str2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = success.continuationToken;
            }
            if ((i & 4) != 0) {
                num = success.expiresIn;
            }
            return success.copy(str, str2, num);
        }

        @NotNull
        public final String component1() {
            return getCorrelationId();
        }

        @Nullable
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
        public final Success copy(@NotNull String correlationId, @Nullable String continuationToken, @Nullable Integer expiresIn) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new Success(correlationId, continuationToken, expiresIn);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(getCorrelationId(), success.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, success.continuationToken) && Intrinsics.areEqual(this.expiresIn, success.expiresIn);
        }

        @Nullable
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
            int iHashCode = getCorrelationId().hashCode() * 31;
            String str = this.continuationToken;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.expiresIn;
            return iHashCode2 + (num != null ? num.hashCode() : 0);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return toUnsanitizedString();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "Success(correlationId=" + getCorrelationId() + ", expiresIn=" + this.expiresIn + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class UnknownError extends ApiErrorResult implements SignUpContinueApiResult {

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
            return "UnknownError(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$UsernameAlreadyExists;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class UsernameAlreadyExists extends ApiErrorResult implements SignUpContinueApiResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UsernameAlreadyExists(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            super(error, errorDescription, null, correlationId, 4, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
        }

        public static /* synthetic */ UsernameAlreadyExists copy$default(UsernameAlreadyExists usernameAlreadyExists, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = usernameAlreadyExists.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = usernameAlreadyExists.getError();
            }
            if ((i & 4) != 0) {
                str3 = usernameAlreadyExists.getErrorDescription();
            }
            return usernameAlreadyExists.copy(str, str2, str3);
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
        public final UsernameAlreadyExists copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            return new UsernameAlreadyExists(correlationId, error, errorDescription);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UsernameAlreadyExists)) {
                return false;
            }
            UsernameAlreadyExists usernameAlreadyExists = (UsernameAlreadyExists) other;
            return Intrinsics.areEqual(getCorrelationId(), usernameAlreadyExists.getCorrelationId()) && Intrinsics.areEqual(getError(), usernameAlreadyExists.getError()) && Intrinsics.areEqual(getErrorDescription(), usernameAlreadyExists.getErrorDescription());
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
            return "UsernameAlreadyExists(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "UsernameAlreadyExists(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + PropertyUtils.MAPPED_DELIM2;
        }
    }
}
