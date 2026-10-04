package com.microsoft.identity.common.java.nativeauth.controllers.results;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordSubmitCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordSubmitNewPasswordCommandResult;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\bf\u0018\u00002\u00020\u0001:\t\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n¨\u0006\u000b"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult;", "", "CodeRequired", "Complete", "EmailNotVerified", "IncorrectCode", "PasswordNotAccepted", "PasswordNotSet", "PasswordRequired", "PasswordResetFailed", "UserNotFound", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface ResetPasswordCommandResult {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult$CodeRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordResendCodeCommandResult;", "correlationId", "", "continuationToken", "codeLength", "", "challengeTargetLabel", "challengeChannel", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getChallengeChannel", "()Ljava/lang/String;", "getChallengeTargetLabel", "getCodeLength", "()I", "getContinuationToken", "getCorrelationId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class CodeRequired implements ResetPasswordStartCommandResult, ResetPasswordResendCodeCommandResult {

        @NotNull
        private final String challengeChannel;

        @NotNull
        private final String challengeTargetLabel;
        private final int codeLength;

        @NotNull
        private final String continuationToken;

        @NotNull
        private final String correlationId;

        public CodeRequired(@NotNull String correlationId, @NotNull String continuationToken, int i, @NotNull String challengeTargetLabel, @NotNull String challengeChannel) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(challengeTargetLabel, "challengeTargetLabel");
            Intrinsics.checkNotNullParameter(challengeChannel, "challengeChannel");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
            this.codeLength = i;
            this.challengeTargetLabel = challengeTargetLabel;
            this.challengeChannel = challengeChannel;
        }

        public static /* synthetic */ CodeRequired copy$default(CodeRequired codeRequired, String str, String str2, int i, String str3, String str4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = codeRequired.getCorrelationId();
            }
            if ((i2 & 2) != 0) {
                str2 = codeRequired.continuationToken;
            }
            if ((i2 & 4) != 0) {
                i = codeRequired.codeLength;
            }
            if ((i2 & 8) != 0) {
                str3 = codeRequired.challengeTargetLabel;
            }
            if ((i2 & 16) != 0) {
                str4 = codeRequired.challengeChannel;
            }
            String str5 = str4;
            int i4 = i;
            return codeRequired.copy(str, str2, i4, str3, str5);
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

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getCodeLength() {
            return this.codeLength;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getChallengeTargetLabel() {
            return this.challengeTargetLabel;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getChallengeChannel() {
            return this.challengeChannel;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return ResetPasswordStartCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final CodeRequired copy(@NotNull String correlationId, @NotNull String continuationToken, int codeLength, @NotNull String challengeTargetLabel, @NotNull String challengeChannel) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(challengeTargetLabel, "challengeTargetLabel");
            Intrinsics.checkNotNullParameter(challengeChannel, "challengeChannel");
            return new CodeRequired(correlationId, continuationToken, codeLength, challengeTargetLabel, challengeChannel);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CodeRequired)) {
                return false;
            }
            CodeRequired codeRequired = (CodeRequired) other;
            return Intrinsics.areEqual(getCorrelationId(), codeRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, codeRequired.continuationToken) && this.codeLength == codeRequired.codeLength && Intrinsics.areEqual(this.challengeTargetLabel, codeRequired.challengeTargetLabel) && Intrinsics.areEqual(this.challengeChannel, codeRequired.challengeChannel);
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
            return this.challengeChannel.hashCode() + AbstractC1038a.m1202c(AbstractC0622a.m1157c(this.codeLength, AbstractC1038a.m1202c(getCorrelationId().hashCode() * 31, 31, this.continuationToken), 31), 31, this.challengeTargetLabel);
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
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ0\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult$Complete;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitNewPasswordCommandResult;", "correlationId", "", "continuationToken", IdentityApiContract.Token.EXPIRES_IN, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "getExpiresIn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult$Complete;", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class Complete implements ResetPasswordSubmitNewPasswordCommandResult {

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
            return ResetPasswordSubmitNewPasswordCommandResult.DefaultImpls.containsPii(this);
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
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult$EmailNotVerified;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordStartCommandResult;", "correlationId", "", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class EmailNotVerified implements ResetPasswordStartCommandResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        public EmailNotVerified(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
        }

        public static /* synthetic */ EmailNotVerified copy$default(EmailNotVerified emailNotVerified, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = emailNotVerified.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = emailNotVerified.error;
            }
            if ((i & 4) != 0) {
                str3 = emailNotVerified.errorDescription;
            }
            return emailNotVerified.copy(str, str2, str3);
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
            return ResetPasswordStartCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final EmailNotVerified copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            return new EmailNotVerified(correlationId, error, errorDescription);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmailNotVerified)) {
                return false;
            }
            EmailNotVerified emailNotVerified = (EmailNotVerified) other;
            return Intrinsics.areEqual(getCorrelationId(), emailNotVerified.getCorrelationId()) && Intrinsics.areEqual(this.error, emailNotVerified.error) && Intrinsics.areEqual(this.errorDescription, emailNotVerified.errorDescription);
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
            return "EmailNotVerified(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("EmailNotVerified(correlationId=");
            sb.append(getCorrelationId());
            sb.append(", error=");
            sb.append(this.error);
            sb.append(", errorDescription=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.errorDescription, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult$IncorrectCode;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitCodeCommandResult;", "correlationId", "", "error", "errorDescription", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class IncorrectCode implements ResetPasswordSubmitCodeCommandResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        @NotNull
        private final String subError;

        public IncorrectCode(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.subError = subError;
        }

        public static /* synthetic */ IncorrectCode copy$default(IncorrectCode incorrectCode, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = incorrectCode.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = incorrectCode.error;
            }
            if ((i & 4) != 0) {
                str3 = incorrectCode.errorDescription;
            }
            if ((i & 8) != 0) {
                str4 = incorrectCode.subError;
            }
            return incorrectCode.copy(str, str2, str3, str4);
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
            return ResetPasswordSubmitCodeCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final IncorrectCode copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new IncorrectCode(correlationId, error, errorDescription, subError);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IncorrectCode)) {
                return false;
            }
            IncorrectCode incorrectCode = (IncorrectCode) other;
            return Intrinsics.areEqual(getCorrelationId(), incorrectCode.getCorrelationId()) && Intrinsics.areEqual(this.error, incorrectCode.error) && Intrinsics.areEqual(this.errorDescription, incorrectCode.errorDescription) && Intrinsics.areEqual(this.subError, incorrectCode.subError);
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
            return "IncorrectCode(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("IncorrectCode(correlationId=");
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
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult$PasswordNotAccepted;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitNewPasswordCommandResult;", "correlationId", "", "error", "errorDescription", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class PasswordNotAccepted implements ResetPasswordSubmitNewPasswordCommandResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        @NotNull
        private final String subError;

        public PasswordNotAccepted(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.subError = subError;
        }

        public static /* synthetic */ PasswordNotAccepted copy$default(PasswordNotAccepted passwordNotAccepted, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = passwordNotAccepted.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = passwordNotAccepted.error;
            }
            if ((i & 4) != 0) {
                str3 = passwordNotAccepted.errorDescription;
            }
            if ((i & 8) != 0) {
                str4 = passwordNotAccepted.subError;
            }
            return passwordNotAccepted.copy(str, str2, str3, str4);
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
            return ResetPasswordSubmitNewPasswordCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final PasswordNotAccepted copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new PasswordNotAccepted(correlationId, error, errorDescription, subError);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PasswordNotAccepted)) {
                return false;
            }
            PasswordNotAccepted passwordNotAccepted = (PasswordNotAccepted) other;
            return Intrinsics.areEqual(getCorrelationId(), passwordNotAccepted.getCorrelationId()) && Intrinsics.areEqual(this.error, passwordNotAccepted.error) && Intrinsics.areEqual(this.errorDescription, passwordNotAccepted.errorDescription) && Intrinsics.areEqual(this.subError, passwordNotAccepted.subError);
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
            return "PasswordNotAccepted(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("PasswordNotAccepted(correlationId=");
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
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult$PasswordNotSet;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordStartCommandResult;", "correlationId", "", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class PasswordNotSet implements ResetPasswordStartCommandResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        public PasswordNotSet(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
        }

        public static /* synthetic */ PasswordNotSet copy$default(PasswordNotSet passwordNotSet, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = passwordNotSet.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = passwordNotSet.error;
            }
            if ((i & 4) != 0) {
                str3 = passwordNotSet.errorDescription;
            }
            return passwordNotSet.copy(str, str2, str3);
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
            return ResetPasswordStartCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final PasswordNotSet copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            return new PasswordNotSet(correlationId, error, errorDescription);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PasswordNotSet)) {
                return false;
            }
            PasswordNotSet passwordNotSet = (PasswordNotSet) other;
            return Intrinsics.areEqual(getCorrelationId(), passwordNotSet.getCorrelationId()) && Intrinsics.areEqual(this.error, passwordNotSet.error) && Intrinsics.areEqual(this.errorDescription, passwordNotSet.errorDescription);
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
            return "PasswordNotSet(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("PasswordNotSet(correlationId=");
            sb.append(getCorrelationId());
            sb.append(", error=");
            sb.append(this.error);
            sb.append(", errorDescription=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.errorDescription, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult$PasswordRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitCodeCommandResult;", "correlationId", "", "continuationToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class PasswordRequired implements ResetPasswordSubmitCodeCommandResult {

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
            return ResetPasswordSubmitCodeCommandResult.DefaultImpls.containsPii(this);
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
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult$PasswordResetFailed;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitNewPasswordCommandResult;", "correlationId", "", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class PasswordResetFailed implements ResetPasswordSubmitNewPasswordCommandResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        public PasswordResetFailed(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
        }

        public static /* synthetic */ PasswordResetFailed copy$default(PasswordResetFailed passwordResetFailed, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = passwordResetFailed.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = passwordResetFailed.error;
            }
            if ((i & 4) != 0) {
                str3 = passwordResetFailed.errorDescription;
            }
            return passwordResetFailed.copy(str, str2, str3);
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
            return ResetPasswordSubmitNewPasswordCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final PasswordResetFailed copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            return new PasswordResetFailed(correlationId, error, errorDescription);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PasswordResetFailed)) {
                return false;
            }
            PasswordResetFailed passwordResetFailed = (PasswordResetFailed) other;
            return Intrinsics.areEqual(getCorrelationId(), passwordResetFailed.getCorrelationId()) && Intrinsics.areEqual(this.error, passwordResetFailed.error) && Intrinsics.areEqual(this.errorDescription, passwordResetFailed.errorDescription);
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
            return "PasswordResetFailed(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("PasswordResetFailed(correlationId=");
            sb.append(getCorrelationId());
            sb.append(", error=");
            sb.append(this.error);
            sb.append(", errorDescription=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.errorDescription, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult$UserNotFound;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitNewPasswordCommandResult;", "correlationId", "", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class UserNotFound implements ResetPasswordStartCommandResult, ResetPasswordSubmitNewPasswordCommandResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final String errorDescription;

        public UserNotFound(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
        }

        public static /* synthetic */ UserNotFound copy$default(UserNotFound userNotFound, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userNotFound.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = userNotFound.error;
            }
            if ((i & 4) != 0) {
                str3 = userNotFound.errorDescription;
            }
            return userNotFound.copy(str, str2, str3);
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
            return ResetPasswordStartCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final UserNotFound copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            return new UserNotFound(correlationId, error, errorDescription);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserNotFound)) {
                return false;
            }
            UserNotFound userNotFound = (UserNotFound) other;
            return Intrinsics.areEqual(getCorrelationId(), userNotFound.getCorrelationId()) && Intrinsics.areEqual(this.error, userNotFound.error) && Intrinsics.areEqual(this.errorDescription, userNotFound.errorDescription);
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
            return "UserNotFound(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("UserNotFound(correlationId=");
            sb.append(getCorrelationId());
            sb.append(", error=");
            sb.append(this.error);
            sb.append(", errorDescription=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.errorDescription, sb);
        }
    }
}
