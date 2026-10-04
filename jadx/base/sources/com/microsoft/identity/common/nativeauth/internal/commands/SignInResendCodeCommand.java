package com.microsoft.identity.common.nativeauth.internal.commands;

import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInResendCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInResendCodeCommandResult;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/microsoft/identity/common/nativeauth/internal/commands/SignInResendCodeCommand;", "Lcom/microsoft/identity/common/nativeauth/internal/commands/BaseNativeAuthCommand;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInResendCodeCommandResult;", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInResendCodeCommandParameters;", "controller", "Lcom/microsoft/identity/common/nativeauth/internal/controllers/NativeAuthMsalController;", "publicApiId", "", "(Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInResendCodeCommandParameters;Lcom/microsoft/identity/common/nativeauth/internal/controllers/NativeAuthMsalController;Ljava/lang/String;)V", "execute", "Companion", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SignInResendCodeCommand extends BaseNativeAuthCommand<SignInResendCodeCommandResult> {
    private static final String TAG = "SignInResendCodeCommand";

    @NotNull
    private final NativeAuthMsalController controller;

    @NotNull
    private final SignInResendCodeCommandParameters parameters;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignInResendCodeCommand(@NotNull SignInResendCodeCommandParameters parameters, @NotNull NativeAuthMsalController controller, @NotNull String publicApiId) {
        super(parameters, controller, publicApiId);
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(publicApiId, "publicApiId");
        this.parameters = parameters;
        this.controller = controller;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    @NotNull
    public SignInResendCodeCommandResult execute() throws Exception {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".execute", companion, TAG2, this.parameters.getCorrelationId());
        SignInResendCodeCommandResult signInResendCodeCommandResultSignInResendCode = this.controller.signInResendCode(this.parameters);
        Logger.infoWithObject(TAG2, "Returning result: ", signInResendCodeCommandResultSignInResendCode);
        return signInResendCodeCommandResultSignInResendCode;
    }
}
