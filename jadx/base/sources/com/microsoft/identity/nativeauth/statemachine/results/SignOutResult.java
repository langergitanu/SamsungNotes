package com.microsoft.identity.nativeauth.statemachine.results;

import com.microsoft.identity.nativeauth.statemachine.errors.Error;
import com.microsoft.identity.nativeauth.statemachine.results.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignOutResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "Complete", "UnexpectedError", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface SignOutResult extends Result {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignOutResult$Complete;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$CompleteResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignOutResult;", "()V", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Complete extends Result.CompleteResult implements SignOutResult {

        @NotNull
        public static final Complete INSTANCE = new Complete();

        private Complete() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(@NotNull SignOutResult signOutResult) {
            return Result.DefaultImpls.isComplete(signOutResult);
        }

        public static boolean isError(@NotNull SignOutResult signOutResult) {
            return Result.DefaultImpls.isError(signOutResult);
        }

        public static boolean isSuccess(@NotNull SignOutResult signOutResult) {
            return Result.DefaultImpls.isSuccess(signOutResult);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignOutResult$UnexpectedError;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$ErrorResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignOutResult;", "error", "Lcom/microsoft/identity/nativeauth/statemachine/errors/Error;", "(Lcom/microsoft/identity/nativeauth/statemachine/errors/Error;)V", "getError", "()Lcom/microsoft/identity/nativeauth/statemachine/errors/Error;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class UnexpectedError extends Result.ErrorResult implements SignOutResult {

        @NotNull
        private final Error error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnexpectedError(@NotNull Error error) {
            super(error);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.ErrorResult
        @NotNull
        public Error getError() {
            return this.error;
        }
    }
}
