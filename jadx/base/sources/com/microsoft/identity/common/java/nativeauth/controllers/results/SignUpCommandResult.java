package com.microsoft.identity.common.java.nativeauth.controllers.results;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitCodeCommandResult;
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
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\bf\u0018\u00002\u00020\u0001:\t\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n¨\u0006\u000b"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult;", "", "AttributesRequired", "AuthNotSupported", "CodeRequired", "Complete", "InvalidAttributes", "InvalidCode", "InvalidPassword", "PasswordRequired", "UsernameAlreadyExists", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface SignUpCommandResult {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B3\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$AttributesRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitUserAttributesCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitCodeCommandResult;", "correlationId", "", "continuationToken", "error", "errorDescription", "requiredAttributes", "", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/UserAttributeApiResult;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "getError", "getErrorDescription", "getRequiredAttributes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class AttributesRequired implements SignUpStartCommandResult, SignUpSubmitPasswordCommandResult, SignUpSubmitUserAttributesCommandResult, SignUpSubmitCodeCommandResult {

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

        public AttributesRequired(@NotNull String correlationId, @NotNull String continuationToken, @NotNull String error, @NotNull String errorDescription, @NotNull List<UserAttributeApiResult> requiredAttributes) {
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
                str3 = attributesRequired.error;
            }
            if ((i & 8) != 0) {
                str4 = attributesRequired.errorDescription;
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
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getError() {
            return this.error;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        @NotNull
        public final List<UserAttributeApiResult> component5() {
            return this.requiredAttributes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return SignUpStartCommandResult.DefaultImpls.containsPii(this);
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
            return Intrinsics.areEqual(getCorrelationId(), attributesRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, attributesRequired.continuationToken) && Intrinsics.areEqual(this.error, attributesRequired.error) && Intrinsics.areEqual(this.errorDescription, attributesRequired.errorDescription) && Intrinsics.areEqual(this.requiredAttributes, attributesRequired.requiredAttributes);
        }

        @NotNull
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        @NotNull
        public final String getError() {
            return this.error;
        }

        @NotNull
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        @NotNull
        public final List<UserAttributeApiResult> getRequiredAttributes() {
            return this.requiredAttributes;
        }

        public int hashCode() {
            return this.requiredAttributes.hashCode() + AbstractC1038a.m1202c(AbstractC1038a.m1202c(AbstractC1038a.m1202c(getCorrelationId().hashCode() * 31, 31, this.continuationToken), 31, this.error), 31, this.errorDescription);
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
            sb.append(this.error);
            sb.append(", errorDescription=");
            sb.append(this.errorDescription);
            sb.append(", requiredAttributes=");
            return AbstractC1974b.m1321n(sb, this.requiredAttributes, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$AuthNotSupported;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "correlationId", "", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class AuthNotSupported implements SignUpStartCommandResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        public AuthNotSupported(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
        }

        public static /* synthetic */ AuthNotSupported copy$default(AuthNotSupported authNotSupported, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = authNotSupported.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = authNotSupported.error;
            }
            if ((i & 4) != 0) {
                str3 = authNotSupported.errorDescription;
            }
            return authNotSupported.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return getCorrelationId();
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getError() {
            return this.error;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return SignUpStartCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final AuthNotSupported copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            return new AuthNotSupported(correlationId, error, errorDescription);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthNotSupported)) {
                return false;
            }
            AuthNotSupported authNotSupported = (AuthNotSupported) other;
            return Intrinsics.areEqual(getCorrelationId(), authNotSupported.getCorrelationId()) && Intrinsics.areEqual(this.error, authNotSupported.error) && Intrinsics.areEqual(this.errorDescription, authNotSupported.errorDescription);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        @NotNull
        public final String getError() {
            return this.error;
        }

        @NotNull
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        public int hashCode() {
            return this.errorDescription.hashCode() + AbstractC1038a.m1202c(getCorrelationId().hashCode() * 31, 31, this.error);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "AuthNotSupported(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("AuthNotSupported(correlationId=");
            sb.append(getCorrelationId());
            sb.append(", error=");
            sb.append(this.error);
            sb.append(", errorDescription=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.errorDescription, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$CodeRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpResendCodeCommandResult;", "correlationId", "", "continuationToken", "challengeTargetLabel", "challengeChannel", "codeLength", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getChallengeChannel", "()Ljava/lang/String;", "getChallengeTargetLabel", "getCodeLength", "()I", "getContinuationToken", "getCorrelationId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class CodeRequired implements SignUpStartCommandResult, SignUpResendCodeCommandResult {

        @NotNull
        private final String challengeChannel;

        @NotNull
        private final String challengeTargetLabel;
        private final int codeLength;

        @NotNull
        private final String continuationToken;

        @NotNull
        private final String correlationId;

        public CodeRequired(@NotNull String correlationId, @NotNull String continuationToken, @NotNull String challengeTargetLabel, @NotNull String challengeChannel, int i) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(challengeTargetLabel, "challengeTargetLabel");
            Intrinsics.checkNotNullParameter(challengeChannel, "challengeChannel");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
            this.challengeTargetLabel = challengeTargetLabel;
            this.challengeChannel = challengeChannel;
            this.codeLength = i;
        }

        public static /* synthetic */ CodeRequired copy$default(CodeRequired codeRequired, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = codeRequired.getCorrelationId();
            }
            if ((i2 & 2) != 0) {
                str2 = codeRequired.continuationToken;
            }
            if ((i2 & 4) != 0) {
                str3 = codeRequired.challengeTargetLabel;
            }
            if ((i2 & 8) != 0) {
                str4 = codeRequired.challengeChannel;
            }
            if ((i2 & 16) != 0) {
                i = codeRequired.codeLength;
            }
            int i4 = i;
            String str5 = str3;
            return codeRequired.copy(str, str2, str5, str4, i4);
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
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getChallengeTargetLabel() {
            return this.challengeTargetLabel;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getChallengeChannel() {
            return this.challengeChannel;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getCodeLength() {
            return this.codeLength;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return SignUpStartCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final CodeRequired copy(@NotNull String correlationId, @NotNull String continuationToken, @NotNull String challengeTargetLabel, @NotNull String challengeChannel, int codeLength) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(challengeTargetLabel, "challengeTargetLabel");
            Intrinsics.checkNotNullParameter(challengeChannel, "challengeChannel");
            return new CodeRequired(correlationId, continuationToken, challengeTargetLabel, challengeChannel, codeLength);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CodeRequired)) {
                return false;
            }
            CodeRequired codeRequired = (CodeRequired) other;
            return Intrinsics.areEqual(getCorrelationId(), codeRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, codeRequired.continuationToken) && Intrinsics.areEqual(this.challengeTargetLabel, codeRequired.challengeTargetLabel) && Intrinsics.areEqual(this.challengeChannel, codeRequired.challengeChannel) && this.codeLength == codeRequired.codeLength;
        }

        @NotNull
        public final String getChallengeChannel() {
            return this.challengeChannel;
        }

        @NotNull
        public final String getChallengeTargetLabel() {
            return this.challengeTargetLabel;
        }

        public final int getCodeLength() {
            return this.codeLength;
        }

        @NotNull
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        public int hashCode() {
            return Integer.hashCode(this.codeLength) + AbstractC1038a.m1202c(AbstractC1038a.m1202c(AbstractC1038a.m1202c(getCorrelationId().hashCode() * 31, 31, this.continuationToken), 31, this.challengeTargetLabel), 31, this.challengeChannel);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("CodeRequired(correlationId=");
            sb.append(getCorrelationId());
            sb.append(", codeLength=");
            sb.append(this.codeLength);
            sb.append(", challengeChannel=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.challengeChannel, sb);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("CodeRequired(correlationId=");
            sb.append(getCorrelationId());
            sb.append(", codeLength=");
            sb.append(this.codeLength);
            sb.append(", challengeTargetLabel=");
            sb.append(this.challengeTargetLabel);
            sb.append(", challengeChannel=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.challengeChannel, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000fJ0\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$Complete;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitUserAttributesCommandResult;", "correlationId", "", "continuationToken", IdentityApiContract.Token.EXPIRES_IN, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "getExpiresIn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$Complete;", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class Complete implements SignUpStartCommandResult, SignUpSubmitCodeCommandResult, SignUpSubmitPasswordCommandResult, SignUpSubmitUserAttributesCommandResult {

        @Nullable
        private final String continuationToken;

        @NotNull
        private final String correlationId;

        @Nullable
        private final Integer expiresIn;

        public Complete(@NotNull String correlationId, @Nullable String str, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.correlationId = correlationId;
            this.continuationToken = str;
            this.expiresIn = num;
        }

        public static /* synthetic */ Complete copy$default(Complete complete, String str, String str2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = complete.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = complete.continuationToken;
            }
            if ((i & 4) != 0) {
                num = complete.expiresIn;
            }
            return complete.copy(str, str2, num);
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
            return SignUpStartCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final Complete copy(@NotNull String correlationId, @Nullable String continuationToken, @Nullable Integer expiresIn) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new Complete(correlationId, continuationToken, expiresIn);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Complete)) {
                return false;
            }
            Complete complete = (Complete) other;
            return Intrinsics.areEqual(getCorrelationId(), complete.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, complete.continuationToken) && Intrinsics.areEqual(this.expiresIn, complete.expiresIn);
        }

        @Nullable
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
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
            return "Complete(correlationId=" + getCorrelationId() + ", expiresIn=" + this.expiresIn + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$InvalidAttributes;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitUserAttributesCommandResult;", "correlationId", "", "error", "errorDescription", "invalidAttributes", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getInvalidAttributes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class InvalidAttributes implements SignUpStartCommandResult, SignUpSubmitUserAttributesCommandResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        @NotNull
        private final List<String> invalidAttributes;

        public InvalidAttributes(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<String> invalidAttributes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(invalidAttributes, "invalidAttributes");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.invalidAttributes = invalidAttributes;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidAttributes copy$default(InvalidAttributes invalidAttributes, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidAttributes.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = invalidAttributes.error;
            }
            if ((i & 4) != 0) {
                str3 = invalidAttributes.errorDescription;
            }
            if ((i & 8) != 0) {
                list = invalidAttributes.invalidAttributes;
            }
            return invalidAttributes.copy(str, str2, str3, list);
        }

        @NotNull
        public final String component1() {
            return getCorrelationId();
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getError() {
            return this.error;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        @NotNull
        public final List<String> component4() {
            return this.invalidAttributes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return SignUpStartCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final InvalidAttributes copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<String> invalidAttributes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(invalidAttributes, "invalidAttributes");
            return new InvalidAttributes(correlationId, error, errorDescription, invalidAttributes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidAttributes)) {
                return false;
            }
            InvalidAttributes invalidAttributes = (InvalidAttributes) other;
            return Intrinsics.areEqual(getCorrelationId(), invalidAttributes.getCorrelationId()) && Intrinsics.areEqual(this.error, invalidAttributes.error) && Intrinsics.areEqual(this.errorDescription, invalidAttributes.errorDescription) && Intrinsics.areEqual(this.invalidAttributes, invalidAttributes.invalidAttributes);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        @NotNull
        public final String getError() {
            return this.error;
        }

        @NotNull
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        @NotNull
        public final List<String> getInvalidAttributes() {
            return this.invalidAttributes;
        }

        public int hashCode() {
            return this.invalidAttributes.hashCode() + AbstractC1038a.m1202c(AbstractC1038a.m1202c(getCorrelationId().hashCode() * 31, 31, this.error), 31, this.errorDescription);
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
            sb.append(", error=");
            sb.append(this.error);
            sb.append(", errorDescription=");
            sb.append(this.errorDescription);
            sb.append(", invalidAttributes=");
            return AbstractC1974b.m1321n(sb, this.invalidAttributes, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$InvalidCode;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitCodeCommandResult;", "correlationId", "", "error", "errorDescription", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class InvalidCode implements SignUpSubmitCodeCommandResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        @NotNull
        private final String subError;

        public InvalidCode(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.subError = subError;
        }

        public static /* synthetic */ InvalidCode copy$default(InvalidCode invalidCode, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidCode.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = invalidCode.error;
            }
            if ((i & 4) != 0) {
                str3 = invalidCode.errorDescription;
            }
            if ((i & 8) != 0) {
                str4 = invalidCode.subError;
            }
            return invalidCode.copy(str, str2, str3, str4);
        }

        @NotNull
        public final String component1() {
            return getCorrelationId();
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getError() {
            return this.error;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSubError() {
            return this.subError;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return SignUpSubmitCodeCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final InvalidCode copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new InvalidCode(correlationId, error, errorDescription, subError);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidCode)) {
                return false;
            }
            InvalidCode invalidCode = (InvalidCode) other;
            return Intrinsics.areEqual(getCorrelationId(), invalidCode.getCorrelationId()) && Intrinsics.areEqual(this.error, invalidCode.error) && Intrinsics.areEqual(this.errorDescription, invalidCode.errorDescription) && Intrinsics.areEqual(this.subError, invalidCode.subError);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        @NotNull
        public final String getError() {
            return this.error;
        }

        @NotNull
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        @NotNull
        public final String getSubError() {
            return this.subError;
        }

        public int hashCode() {
            return this.subError.hashCode() + AbstractC1038a.m1202c(AbstractC1038a.m1202c(getCorrelationId().hashCode() * 31, 31, this.error), 31, this.errorDescription);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "InvalidCode(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("InvalidCode(correlationId=");
            sb.append(getCorrelationId());
            sb.append(", error=");
            sb.append(this.error);
            sb.append(", errorDescription=");
            sb.append(this.errorDescription);
            sb.append(", subError=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.subError, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$InvalidPassword;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitPasswordCommandResult;", "correlationId", "", "error", "errorDescription", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class InvalidPassword implements SignUpStartCommandResult, SignUpSubmitPasswordCommandResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        @NotNull
        private final String subError;

        public InvalidPassword(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
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
                str2 = invalidPassword.error;
            }
            if ((i & 4) != 0) {
                str3 = invalidPassword.errorDescription;
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
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getError() {
            return this.error;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSubError() {
            return this.subError;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return SignUpStartCommandResult.DefaultImpls.containsPii(this);
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
            return Intrinsics.areEqual(getCorrelationId(), invalidPassword.getCorrelationId()) && Intrinsics.areEqual(this.error, invalidPassword.error) && Intrinsics.areEqual(this.errorDescription, invalidPassword.errorDescription) && Intrinsics.areEqual(this.subError, invalidPassword.subError);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        @NotNull
        public final String getError() {
            return this.error;
        }

        @NotNull
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        @NotNull
        public final String getSubError() {
            return this.subError;
        }

        public int hashCode() {
            return this.subError.hashCode() + AbstractC1038a.m1202c(AbstractC1038a.m1202c(getCorrelationId().hashCode() * 31, 31, this.error), 31, this.errorDescription);
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
            sb.append(this.error);
            sb.append(", errorDescription=");
            sb.append(this.errorDescription);
            sb.append(", subError=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.subError, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$PasswordRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitCodeCommandResult;", "correlationId", "", "continuationToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class PasswordRequired implements SignUpStartCommandResult, SignUpSubmitCodeCommandResult {

        @NotNull
        private final String continuationToken;

        @NotNull
        private final String correlationId;

        public PasswordRequired(@NotNull String correlationId, @NotNull String continuationToken) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
        }

        public static /* synthetic */ PasswordRequired copy$default(PasswordRequired passwordRequired, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = passwordRequired.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = passwordRequired.continuationToken;
            }
            return passwordRequired.copy(str, str2);
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
            return SignUpStartCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final PasswordRequired copy(@NotNull String correlationId, @NotNull String continuationToken) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            return new PasswordRequired(correlationId, continuationToken);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PasswordRequired)) {
                return false;
            }
            PasswordRequired passwordRequired = (PasswordRequired) other;
            return Intrinsics.areEqual(getCorrelationId(), passwordRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, passwordRequired.continuationToken);
        }

        @NotNull
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
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
            return "PasswordRequired(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u001a"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$UsernameAlreadyExists;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitUserAttributesCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitPasswordCommandResult;", "correlationId", "", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class UsernameAlreadyExists implements SignUpStartCommandResult, SignUpSubmitCodeCommandResult, SignUpSubmitUserAttributesCommandResult, SignUpSubmitPasswordCommandResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        public UsernameAlreadyExists(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
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
                str2 = usernameAlreadyExists.error;
            }
            if ((i & 4) != 0) {
                str3 = usernameAlreadyExists.errorDescription;
            }
            return usernameAlreadyExists.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return getCorrelationId();
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getError() {
            return this.error;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return SignUpStartCommandResult.DefaultImpls.containsPii(this);
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
            return Intrinsics.areEqual(getCorrelationId(), usernameAlreadyExists.getCorrelationId()) && Intrinsics.areEqual(this.error, usernameAlreadyExists.error) && Intrinsics.areEqual(this.errorDescription, usernameAlreadyExists.errorDescription);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        @NotNull
        public final String getError() {
            return this.error;
        }

        @NotNull
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        public int hashCode() {
            return this.errorDescription.hashCode() + AbstractC1038a.m1202c(getCorrelationId().hashCode() * 31, 31, this.error);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "UsernameAlreadyExists(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("UsernameAlreadyExists(correlationId=");
            sb.append(getCorrelationId());
            sb.append(", error=");
            sb.append(this.error);
            sb.append(", errorDescription=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.errorDescription, sb);
        }
    }
}
