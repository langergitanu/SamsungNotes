package com.microsoft.identity.nativeauth.statemachine.errors;

import com.microsoft.identity.nativeauth.statemachine.results.SignInResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f¢\u0006\u0002\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\"\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/errors/SignInContinuationError;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "Lcom/microsoft/identity/nativeauth/statemachine/errors/Error;", "error", "", "errorMessage", "correlationId", "errorCodes", "", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Exception;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorMessage", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public class SignInContinuationError extends Error implements SignInResult {

    @NotNull
    private final String correlationId;

    @Nullable
    private final String error;

    @Nullable
    private final List<Integer> errorCodes;

    @Nullable
    private final String errorMessage;

    @Nullable
    private Exception exception;

    public /* synthetic */ SignInContinuationError(String str, String str2, String str3, List list, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, str2, str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : exc);
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.errors.Error
    @NotNull
    public String getCorrelationId() {
        return this.correlationId;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.errors.Error
    @Nullable
    public String getError() {
        return this.error;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.errors.Error
    @Nullable
    public List<Integer> getErrorCodes() {
        return this.errorCodes;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.errors.Error
    @Nullable
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.errors.Error
    @Nullable
    public Exception getException() {
        return this.exception;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
    public boolean isComplete() {
        return SignInResult.DefaultImpls.isComplete(this);
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
    public boolean isError() {
        return SignInResult.DefaultImpls.isError(this);
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
    public boolean isSuccess() {
        return SignInResult.DefaultImpls.isSuccess(this);
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.errors.Error
    public void setException(@Nullable Exception exc) {
        this.exception = exc;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignInContinuationError(@Nullable String str, @Nullable String str2, @NotNull String correlationId, @Nullable List<Integer> list, @Nullable Exception exc) {
        super(null, str, str2, correlationId, exc, list);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.error = str;
        this.errorMessage = str2;
        this.correlationId = correlationId;
        this.errorCodes = list;
        this.exception = exc;
    }
}
