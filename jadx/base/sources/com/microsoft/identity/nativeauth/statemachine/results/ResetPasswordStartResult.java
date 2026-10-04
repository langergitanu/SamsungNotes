package com.microsoft.identity.nativeauth.statemachine.results;

import com.microsoft.identity.nativeauth.statemachine.results.Result;
import com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordStartResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "CodeRequired", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface ResetPasswordStartResult extends Result {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordStartResult$CodeRequired;", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordStartResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$SuccessResult;", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState;", "codeLength", "", "sentTo", "", NetworkConfig.CLIENTS_CHANNEL, "(Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState;ILjava/lang/String;Ljava/lang/String;)V", "getChannel", "()Ljava/lang/String;", "getCodeLength", "()I", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState;", "getSentTo", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class CodeRequired extends Result.SuccessResult implements ResetPasswordStartResult {

        @NotNull
        private final String channel;
        private final int codeLength;

        @NotNull
        private final ResetPasswordCodeRequiredState nextState;

        @NotNull
        private final String sentTo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CodeRequired(@NotNull ResetPasswordCodeRequiredState nextState, int i, @NotNull String sentTo, @NotNull String channel) {
            super(nextState);
            Intrinsics.checkNotNullParameter(nextState, "nextState");
            Intrinsics.checkNotNullParameter(sentTo, "sentTo");
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.nextState = nextState;
            this.codeLength = i;
            this.sentTo = sentTo;
            this.channel = channel;
        }

        @NotNull
        public final String getChannel() {
            return this.channel;
        }

        public final int getCodeLength() {
            return this.codeLength;
        }

        @NotNull
        public final String getSentTo() {
            return this.sentTo;
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.SuccessResult
        @NotNull
        public ResetPasswordCodeRequiredState getNextState() {
            return this.nextState;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(@NotNull ResetPasswordStartResult resetPasswordStartResult) {
            return Result.DefaultImpls.isComplete(resetPasswordStartResult);
        }

        public static boolean isError(@NotNull ResetPasswordStartResult resetPasswordStartResult) {
            return Result.DefaultImpls.isError(resetPasswordStartResult);
        }

        public static boolean isSuccess(@NotNull ResetPasswordStartResult resetPasswordStartResult) {
            return Result.DefaultImpls.isSuccess(resetPasswordStartResult);
        }
    }
}
