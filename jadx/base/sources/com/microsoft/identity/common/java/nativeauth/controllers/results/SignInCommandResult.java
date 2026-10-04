package com.microsoft.identity.common.java.nativeauth.controllers.results;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitCodeCommandResult;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007¨\u0006\b"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult;", "", "CodeRequired", "Complete", "IncorrectCode", "InvalidCredentials", "PasswordRequired", "UserNotFound", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface SignInCommandResult {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$CodeRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInResendCodeCommandResult;", "correlationId", "", "continuationToken", "challengeTargetLabel", "challengeChannel", "codeLength", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getChallengeChannel", "()Ljava/lang/String;", "getChallengeTargetLabel", "getCodeLength", "()I", "getContinuationToken", "getCorrelationId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class CodeRequired implements SignInStartCommandResult, SignInResendCodeCommandResult {

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
            return SignInStartCommandResult.DefaultImpls.containsPii(this);
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
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$Complete;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInWithContinuationTokenCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitPasswordCommandResult;", "correlationId", "", "authenticationResult", "Lcom/microsoft/identity/common/java/result/ILocalAuthenticationResult;", "(Ljava/lang/String;Lcom/microsoft/identity/common/java/result/ILocalAuthenticationResult;)V", "getAuthenticationResult", "()Lcom/microsoft/identity/common/java/result/ILocalAuthenticationResult;", "getCorrelationId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class Complete implements SignInStartCommandResult, SignInWithContinuationTokenCommandResult, SignInSubmitCodeCommandResult, SignInSubmitPasswordCommandResult {

        @NotNull
        private final ILocalAuthenticationResult authenticationResult;

        @NotNull
        private final String correlationId;

        public Complete(@NotNull String correlationId, @NotNull ILocalAuthenticationResult authenticationResult) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(authenticationResult, "authenticationResult");
            this.correlationId = correlationId;
            this.authenticationResult = authenticationResult;
        }

        public static /* synthetic */ Complete copy$default(Complete complete, String str, ILocalAuthenticationResult iLocalAuthenticationResult, int i, Object obj) {
            if ((i & 1) != 0) {
                str = complete.getCorrelationId();
            }
            if ((i & 2) != 0) {
                iLocalAuthenticationResult = complete.authenticationResult;
            }
            return complete.copy(str, iLocalAuthenticationResult);
        }

        @NotNull
        public final String component1() {
            return getCorrelationId();
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ILocalAuthenticationResult getAuthenticationResult() {
            return this.authenticationResult;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return SignInStartCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final Complete copy(@NotNull String correlationId, @NotNull ILocalAuthenticationResult authenticationResult) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(authenticationResult, "authenticationResult");
            return new Complete(correlationId, authenticationResult);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Complete)) {
                return false;
            }
            Complete complete = (Complete) other;
            return Intrinsics.areEqual(getCorrelationId(), complete.getCorrelationId()) && Intrinsics.areEqual(this.authenticationResult, complete.authenticationResult);
        }

        @NotNull
        public final ILocalAuthenticationResult getAuthenticationResult() {
            return this.authenticationResult;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        public int hashCode() {
            return this.authenticationResult.hashCode() + (getCorrelationId().hashCode() * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return toUnsanitizedString();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "Complete(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$IncorrectCode;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitCodeCommandResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class IncorrectCode implements SignInSubmitCodeCommandResult {

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

        public IncorrectCode(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes, @NotNull String subError) {
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
        public static /* synthetic */ IncorrectCode copy$default(IncorrectCode incorrectCode, String str, String str2, String str3, List list, String str4, int i, Object obj) {
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
                list = incorrectCode.errorCodes;
            }
            if ((i & 16) != 0) {
                str4 = incorrectCode.subError;
            }
            String str5 = str4;
            String str6 = str3;
            return incorrectCode.copy(str, str2, str6, list, str5);
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
        public final List<Integer> component4() {
            return this.errorCodes;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSubError() {
            return this.subError;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return SignInSubmitCodeCommandResult.DefaultImpls.containsPii(this);
        }

        @NotNull
        public final IncorrectCode copy(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes, @NotNull String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new IncorrectCode(correlationId, error, errorDescription, errorCodes, subError);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IncorrectCode)) {
                return false;
            }
            IncorrectCode incorrectCode = (IncorrectCode) other;
            return Intrinsics.areEqual(getCorrelationId(), incorrectCode.getCorrelationId()) && Intrinsics.areEqual(this.error, incorrectCode.error) && Intrinsics.areEqual(this.errorDescription, incorrectCode.errorDescription) && Intrinsics.areEqual(this.errorCodes, incorrectCode.errorCodes) && Intrinsics.areEqual(this.subError, incorrectCode.subError);
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
        public final List<Integer> getErrorCodes() {
            return this.errorCodes;
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
            return this.subError.hashCode() + AbstractC0622a.m1159e(this.errorCodes, AbstractC1038a.m1202c(AbstractC1038a.m1202c(getCorrelationId().hashCode() * 31, 31, this.error), 31, this.errorDescription), 31);
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
            sb.append(", errorCodes=");
            sb.append(this.errorCodes);
            sb.append(", subError=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.subError, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$InvalidCredentials;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitPasswordCommandResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class InvalidCredentials implements SignInStartCommandResult, SignInSubmitPasswordCommandResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final List<Integer> errorCodes;

        @NotNull
        private final String errorDescription;

        public InvalidCredentials(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes) {
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
                str2 = invalidCredentials.error;
            }
            if ((i & 4) != 0) {
                str3 = invalidCredentials.errorDescription;
            }
            if ((i & 8) != 0) {
                list = invalidCredentials.errorCodes;
            }
            return invalidCredentials.copy(str, str2, str3, list);
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
        public final List<Integer> component4() {
            return this.errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return SignInStartCommandResult.DefaultImpls.containsPii(this);
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
            return Intrinsics.areEqual(getCorrelationId(), invalidCredentials.getCorrelationId()) && Intrinsics.areEqual(this.error, invalidCredentials.error) && Intrinsics.areEqual(this.errorDescription, invalidCredentials.errorDescription) && Intrinsics.areEqual(this.errorCodes, invalidCredentials.errorCodes);
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
        public final List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        @NotNull
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        public int hashCode() {
            return this.errorCodes.hashCode() + AbstractC1038a.m1202c(AbstractC1038a.m1202c(getCorrelationId().hashCode() * 31, 31, this.error), 31, this.errorDescription);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "InvalidCredentials(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("InvalidCredentials(correlationId=");
            sb.append(getCorrelationId());
            sb.append(", error=");
            sb.append(this.error);
            sb.append(", errorDescription=");
            sb.append(this.errorDescription);
            sb.append(", errorCodes=");
            return AbstractC1974b.m1321n(sb, this.errorCodes, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$PasswordRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "correlationId", "", "continuationToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class PasswordRequired implements SignInStartCommandResult {

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
            return SignInStartCommandResult.DefaultImpls.containsPii(this);
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
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$UserNotFound;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class UserNotFound implements SignInStartCommandResult {

        @NotNull
        private final String correlationId;

        @NotNull
        private final String error;

        @NotNull
        private final List<Integer> errorCodes;

        @NotNull
        private final String errorDescription;

        public UserNotFound(@NotNull String correlationId, @NotNull String error, @NotNull String errorDescription, @NotNull List<Integer> errorCodes) {
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
                str2 = userNotFound.error;
            }
            if ((i & 4) != 0) {
                str3 = userNotFound.errorDescription;
            }
            if ((i & 8) != 0) {
                list = userNotFound.errorCodes;
            }
            return userNotFound.copy(str, str2, str3, list);
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
        public final List<Integer> component4() {
            return this.errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return SignInStartCommandResult.DefaultImpls.containsPii(this);
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
            return Intrinsics.areEqual(getCorrelationId(), userNotFound.getCorrelationId()) && Intrinsics.areEqual(this.error, userNotFound.error) && Intrinsics.areEqual(this.errorDescription, userNotFound.errorDescription) && Intrinsics.areEqual(this.errorCodes, userNotFound.errorCodes);
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
        public final List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        @NotNull
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        public int hashCode() {
            return this.errorCodes.hashCode() + AbstractC1038a.m1202c(AbstractC1038a.m1202c(getCorrelationId().hashCode() * 31, 31, this.error), 31, this.errorDescription);
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
            sb.append(this.errorDescription);
            sb.append(", errorCodes=");
            return AbstractC1974b.m1321n(sb, this.errorCodes, PropertyUtils.MAPPED_DELIM2);
        }
    }
}
