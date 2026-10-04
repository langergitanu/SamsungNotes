package com.microsoft.identity.nativeauth.statemachine.results;

import com.microsoft.identity.nativeauth.RequiredUserAttribute;
import com.microsoft.identity.nativeauth.statemachine.results.Result;
import com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState;
import com.microsoft.identity.nativeauth.statemachine.states.SignUpAttributesRequiredState;
import com.microsoft.identity.nativeauth.statemachine.states.SignUpCodeRequiredState;
import com.microsoft.identity.nativeauth.statemachine.states.SignUpPasswordRequiredState;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "AttributesRequired", "CodeRequired", "Complete", "PasswordRequired", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface SignUpResult extends Result {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult$AttributesRequired;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$SuccessResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitCodeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitAttributesResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitPasswordResult;", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpAttributesRequiredState;", "requiredAttributes", "", "Lcom/microsoft/identity/nativeauth/RequiredUserAttribute;", "(Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpAttributesRequiredState;Ljava/util/List;)V", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpAttributesRequiredState;", "getRequiredAttributes", "()Ljava/util/List;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class AttributesRequired extends Result.SuccessResult implements SignUpResult, SignUpSubmitCodeResult, SignUpSubmitAttributesResult, SignUpSubmitPasswordResult {

        @NotNull
        private final SignUpAttributesRequiredState nextState;

        @NotNull
        private final List<RequiredUserAttribute> requiredAttributes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AttributesRequired(@NotNull SignUpAttributesRequiredState nextState, @NotNull List<RequiredUserAttribute> requiredAttributes) {
            super(nextState);
            Intrinsics.checkNotNullParameter(nextState, "nextState");
            Intrinsics.checkNotNullParameter(requiredAttributes, "requiredAttributes");
            this.nextState = nextState;
            this.requiredAttributes = requiredAttributes;
        }

        @NotNull
        public final List<RequiredUserAttribute> getRequiredAttributes() {
            return this.requiredAttributes;
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.SuccessResult
        @NotNull
        public SignUpAttributesRequiredState getNextState() {
            return this.nextState;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult$CodeRequired;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$SuccessResult;", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpCodeRequiredState;", "codeLength", "", "sentTo", "", NetworkConfig.CLIENTS_CHANNEL, "(Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpCodeRequiredState;ILjava/lang/String;Ljava/lang/String;)V", "getChannel", "()Ljava/lang/String;", "getCodeLength", "()I", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpCodeRequiredState;", "getSentTo", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class CodeRequired extends Result.SuccessResult implements SignUpResult {

        @NotNull
        private final String channel;
        private final int codeLength;

        @NotNull
        private final SignUpCodeRequiredState nextState;

        @NotNull
        private final String sentTo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CodeRequired(@NotNull SignUpCodeRequiredState nextState, int i, @NotNull String sentTo, @NotNull String channel) {
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
        public SignUpCodeRequiredState getNextState() {
            return this.nextState;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult$Complete;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$CompleteWithNextStateResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitCodeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitPasswordResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitAttributesResult;", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState;", "(Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState;)V", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Complete extends Result.CompleteWithNextStateResult implements SignUpResult, SignUpSubmitCodeResult, SignUpSubmitPasswordResult, SignUpSubmitAttributesResult {

        @NotNull
        private final SignInContinuationState nextState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Complete(@NotNull SignInContinuationState nextState) {
            super(null, nextState);
            Intrinsics.checkNotNullParameter(nextState, "nextState");
            this.nextState = nextState;
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.CompleteWithNextStateResult
        @NotNull
        public SignInContinuationState getNextState() {
            return this.nextState;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(@NotNull SignUpResult signUpResult) {
            return Result.DefaultImpls.isComplete(signUpResult);
        }

        public static boolean isError(@NotNull SignUpResult signUpResult) {
            return Result.DefaultImpls.isError(signUpResult);
        }

        public static boolean isSuccess(@NotNull SignUpResult signUpResult) {
            return Result.DefaultImpls.isSuccess(signUpResult);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult$PasswordRequired;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$SuccessResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitCodeResult;", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpPasswordRequiredState;", "(Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpPasswordRequiredState;)V", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpPasswordRequiredState;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class PasswordRequired extends Result.SuccessResult implements SignUpResult, SignUpSubmitCodeResult {

        @NotNull
        private final SignUpPasswordRequiredState nextState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PasswordRequired(@NotNull SignUpPasswordRequiredState nextState) {
            super(nextState);
            Intrinsics.checkNotNullParameter(nextState, "nextState");
            this.nextState = nextState;
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.SuccessResult
        @NotNull
        public SignUpPasswordRequiredState getNextState() {
            return this.nextState;
        }
    }
}
