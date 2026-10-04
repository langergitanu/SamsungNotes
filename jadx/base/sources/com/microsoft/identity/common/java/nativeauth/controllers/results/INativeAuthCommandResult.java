package com.microsoft.identity.common.java.nativeauth.controllers.results;

import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "correlationId", "", "getCorrelationId", "()Ljava/lang/String;", "Error", "InvalidUsername", "Redirect", "UnknownError", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface INativeAuthCommandResult extends ILoggable {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(@NotNull INativeAuthCommandResult iNativeAuthCommandResult) {
            return ILoggable.DefaultImpls.containsPii(iNativeAuthCommandResult);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e:\u0001\u001eB\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\u0014\u001a\u00020\u0010HÆ\u0003J\u0013\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$Error;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInWithContinuationTokenCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitUserAttributesCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordResendCodeCommandResult;", "correlationId", "", "(Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class Redirect extends Error implements SignInStartCommandResult, SignInWithContinuationTokenCommandResult, SignInSubmitCodeCommandResult, SignInResendCodeCommandResult, SignInSubmitPasswordCommandResult, SignUpStartCommandResult, SignUpSubmitCodeCommandResult, SignUpResendCodeCommandResult, SignUpSubmitPasswordCommandResult, SignUpSubmitUserAttributesCommandResult, ResetPasswordStartCommandResult, ResetPasswordSubmitCodeCommandResult, ResetPasswordResendCodeCommandResult {

        @NotNull
        private static final String BROWSER_REQUIRED_ERROR = "browser_required";

        @NotNull
        private static final String BROWSER_REQUIRED_ERROR_DESCRIPTION = "The client's authentication capabilities are insufficient. Please redirect to the browser to complete authentication";

        @NotNull
        private final String correlationId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Redirect(@NotNull String correlationId) {
            super("browser_required", BROWSER_REQUIRED_ERROR_DESCRIPTION, null, correlationId, null, 20, null);
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

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error, com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
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
            return "Redirect(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "Redirect(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u0010Bc\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0016\u0018\u00010\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001c¢\u0006\u0002\u0010\u001dJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u001d\u0010)\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0016\u0018\u00010\u0015HÆ\u0003J\t\u0010*\u001a\u00020\u0012HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0015HÆ\u0003J\u0011\u0010,\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cHÆ\u0003Jm\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0016\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00122\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00152\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cHÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0019HÖ\u0001J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u00020\u0012H\u0016R\u0014\u0010\u0017\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR(\u0010\u0014\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0016\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u001c\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0019\u0010\u001a\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001c¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00065"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$Error;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInWithContinuationTokenCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitUserAttributesCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitNewPasswordCommandResult;", "error", "", "errorDescription", "details", "", "", "correlationId", "errorCodes", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/Exception;)V", "getCorrelationId", "()Ljava/lang/String;", "getDetails", "()Ljava/util/List;", "getError", "getErrorCodes", "getErrorDescription", "getException", "()Ljava/lang/Exception;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class UnknownError extends Error implements INativeAuthCommandResult, SignInStartCommandResult, SignInWithContinuationTokenCommandResult, SignInSubmitCodeCommandResult, SignInResendCodeCommandResult, SignInSubmitPasswordCommandResult, SignUpStartCommandResult, SignUpSubmitUserAttributesCommandResult, SignUpSubmitCodeCommandResult, SignUpResendCodeCommandResult, SignUpSubmitPasswordCommandResult, ResetPasswordStartCommandResult, ResetPasswordSubmitCodeCommandResult, ResetPasswordResendCodeCommandResult, ResetPasswordSubmitNewPasswordCommandResult {

        @NotNull
        private final String correlationId;

        @Nullable
        private final List<Map<String, String>> details;

        @Nullable
        private final String error;

        @Nullable
        private final List<Integer> errorCodes;

        @Nullable
        private final String errorDescription;

        @Nullable
        private final Exception exception;

        public /* synthetic */ UnknownError(String str, String str2, List list, String str3, List list2, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : list, str3, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : exc);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UnknownError copy$default(UnknownError unknownError, String str, String str2, List list, String str3, List list2, Exception exc, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknownError.getError();
            }
            if ((i & 2) != 0) {
                str2 = unknownError.getErrorDescription();
            }
            if ((i & 4) != 0) {
                list = unknownError.getDetails();
            }
            if ((i & 8) != 0) {
                str3 = unknownError.getCorrelationId();
            }
            if ((i & 16) != 0) {
                list2 = unknownError.getErrorCodes();
            }
            if ((i & 32) != 0) {
                exc = unknownError.exception;
            }
            List list3 = list2;
            Exception exc2 = exc;
            return unknownError.copy(str, str2, list, str3, list3, exc2);
        }

        @Nullable
        public final String component1() {
            return getError();
        }

        @Nullable
        public final String component2() {
            return getErrorDescription();
        }

        @Nullable
        public final List<Map<String, String>> component3() {
            return getDetails();
        }

        @NotNull
        public final String component4() {
            return getCorrelationId();
        }

        @Nullable
        public final List<Integer> component5() {
            return getErrorCodes();
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Exception getException() {
            return this.exception;
        }

        @NotNull
        public final UnknownError copy(@Nullable String error, @Nullable String errorDescription, @Nullable List<? extends Map<String, String>> details, @NotNull String correlationId, @Nullable List<Integer> errorCodes, @Nullable Exception exception) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new UnknownError(error, errorDescription, details, correlationId, errorCodes, exception);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnknownError)) {
                return false;
            }
            UnknownError unknownError = (UnknownError) other;
            return Intrinsics.areEqual(getError(), unknownError.getError()) && Intrinsics.areEqual(getErrorDescription(), unknownError.getErrorDescription()) && Intrinsics.areEqual(getDetails(), unknownError.getDetails()) && Intrinsics.areEqual(getCorrelationId(), unknownError.getCorrelationId()) && Intrinsics.areEqual(getErrorCodes(), unknownError.getErrorCodes()) && Intrinsics.areEqual(this.exception, unknownError.exception);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error, com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        @Nullable
        public List<Map<String, String>> getDetails() {
            return this.details;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        @Nullable
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        @Nullable
        public List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        @Nullable
        public String getErrorDescription() {
            return this.errorDescription;
        }

        @Nullable
        public final Exception getException() {
            return this.exception;
        }

        public int hashCode() {
            int iHashCode = (((getCorrelationId().hashCode() + ((((((getError() == null ? 0 : getError().hashCode()) * 31) + (getErrorDescription() == null ? 0 : getErrorDescription().hashCode())) * 31) + (getDetails() == null ? 0 : getDetails().hashCode())) * 31)) * 31) + (getErrorCodes() == null ? 0 : getErrorCodes().hashCode())) * 31;
            Exception exc = this.exception;
            return iHashCode + (exc != null ? exc.hashCode() : 0);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "UnknownError(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "UnknownError(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + "), details=" + getDetails() + ", errorCodes=" + getErrorCodes() + PropertyUtils.MAPPED_DELIM2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public UnknownError(@Nullable String str, @Nullable String str2, @Nullable List<? extends Map<String, String>> list, @NotNull String correlationId, @Nullable List<Integer> list2, @Nullable Exception exc) {
            super(str, str2, list, correlationId, list2);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = str;
            this.errorDescription = str2;
            this.details = list;
            this.correlationId = correlationId;
            this.errorCodes = list2;
            this.exception = exc;
        }
    }

    @NotNull
    String getCorrelationId();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006Be\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u001d\u0010\u001f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\f\u0018\u00010\u000bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\"\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012HÆ\u0003Jm\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u000fHÖ\u0001J\b\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R(\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\f\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001c\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\t\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0019\u0010\u0010\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$InvalidUsername;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$Error;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordStartCommandResult;", "error", "", "errorDescription", "details", "", "", "correlationId", "errorCodes", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/Exception;)V", "getCorrelationId", "()Ljava/lang/String;", "getDetails", "()Ljava/util/List;", "getError", "getErrorCodes", "getErrorDescription", "getException", "()Ljava/lang/Exception;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class InvalidUsername extends Error implements INativeAuthCommandResult, SignInStartCommandResult, SignUpStartCommandResult, SignUpSubmitPasswordCommandResult, ResetPasswordStartCommandResult {

        @NotNull
        private final String correlationId;

        @Nullable
        private final List<Map<String, String>> details;

        @Nullable
        private final String error;

        @Nullable
        private final List<Integer> errorCodes;

        @Nullable
        private final String errorDescription;

        @Nullable
        private final Exception exception;

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ InvalidUsername(String str, String str2, List list, String str3, List list2, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
            list = (i & 4) != 0 ? null : list;
            if ((i & 8) != 0) {
                str3 = DiagnosticContext.INSTANCE.getThreadCorrelationId();
                Intrinsics.checkNotNullExpressionValue(str3, "INSTANCE.threadCorrelationId");
            }
            this(str, str2, list, str3, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : exc);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidUsername copy$default(InvalidUsername invalidUsername, String str, String str2, List list, String str3, List list2, Exception exc, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidUsername.getError();
            }
            if ((i & 2) != 0) {
                str2 = invalidUsername.getErrorDescription();
            }
            if ((i & 4) != 0) {
                list = invalidUsername.getDetails();
            }
            if ((i & 8) != 0) {
                str3 = invalidUsername.getCorrelationId();
            }
            if ((i & 16) != 0) {
                list2 = invalidUsername.getErrorCodes();
            }
            if ((i & 32) != 0) {
                exc = invalidUsername.exception;
            }
            List list3 = list2;
            Exception exc2 = exc;
            return invalidUsername.copy(str, str2, list, str3, list3, exc2);
        }

        @Nullable
        public final String component1() {
            return getError();
        }

        @Nullable
        public final String component2() {
            return getErrorDescription();
        }

        @Nullable
        public final List<Map<String, String>> component3() {
            return getDetails();
        }

        @NotNull
        public final String component4() {
            return getCorrelationId();
        }

        @Nullable
        public final List<Integer> component5() {
            return getErrorCodes();
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Exception getException() {
            return this.exception;
        }

        @NotNull
        public final InvalidUsername copy(@Nullable String error, @Nullable String errorDescription, @Nullable List<? extends Map<String, String>> details, @NotNull String correlationId, @Nullable List<Integer> errorCodes, @Nullable Exception exception) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new InvalidUsername(error, errorDescription, details, correlationId, errorCodes, exception);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidUsername)) {
                return false;
            }
            InvalidUsername invalidUsername = (InvalidUsername) other;
            return Intrinsics.areEqual(getError(), invalidUsername.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidUsername.getErrorDescription()) && Intrinsics.areEqual(getDetails(), invalidUsername.getDetails()) && Intrinsics.areEqual(getCorrelationId(), invalidUsername.getCorrelationId()) && Intrinsics.areEqual(getErrorCodes(), invalidUsername.getErrorCodes()) && Intrinsics.areEqual(this.exception, invalidUsername.exception);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error, com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        @Nullable
        public List<Map<String, String>> getDetails() {
            return this.details;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        @Nullable
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        @Nullable
        public List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        @Nullable
        public String getErrorDescription() {
            return this.errorDescription;
        }

        @Nullable
        public final Exception getException() {
            return this.exception;
        }

        public int hashCode() {
            int iHashCode = (((getCorrelationId().hashCode() + ((((((getError() == null ? 0 : getError().hashCode()) * 31) + (getErrorDescription() == null ? 0 : getErrorDescription().hashCode())) * 31) + (getDetails() == null ? 0 : getDetails().hashCode())) * 31)) * 31) + (getErrorCodes() == null ? 0 : getErrorCodes().hashCode())) * 31;
            Exception exc = this.exception;
            return iHashCode + (exc != null ? exc.hashCode() : 0);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "InvalidUsername(correlationId=" + getCorrelationId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "InvalidUsername(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + "), details=" + getDetails() + ", errorCodes=" + getErrorCodes() + PropertyUtils.MAPPED_DELIM2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public InvalidUsername(@Nullable String str, @Nullable String str2, @Nullable List<? extends Map<String, String>> list, @NotNull String correlationId, @Nullable List<Integer> list2, @Nullable Exception exc) {
            super(str, str2, list, correlationId, list2);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = str;
            this.errorDescription = str2;
            this.details = list;
            this.correlationId = correlationId;
            this.errorCodes = list2;
            this.exception = exc;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bR\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR(\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u0013"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$Error;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "error", "", "errorDescription", "details", "", "", "correlationId", "errorCodes", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getDetails", "()Ljava/util/List;", "getError", "getErrorCodes", "getErrorDescription", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static abstract class Error implements ILoggable {

        @NotNull
        private final String correlationId;

        @Nullable
        private final List<Map<String, String>> details;

        @Nullable
        private final String error;

        @Nullable
        private final List<Integer> errorCodes;

        @Nullable
        private final String errorDescription;

        /* JADX WARN: Multi-variable type inference failed */
        public Error(@Nullable String str, @Nullable String str2, @Nullable List<? extends Map<String, String>> list, @NotNull String correlationId, @Nullable List<Integer> list2) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = str;
            this.errorDescription = str2;
            this.details = list;
            this.correlationId = correlationId;
            this.errorCodes = list2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return ILoggable.DefaultImpls.containsPii(this);
        }

        @NotNull
        public String getCorrelationId() {
            return this.correlationId;
        }

        @Nullable
        public List<Map<String, String>> getDetails() {
            return this.details;
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

        public /* synthetic */ Error(String str, String str2, List list, String str3, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : list, str3, (i & 16) != 0 ? null : list2);
        }
    }
}
