package com.microsoft.identity.common.nativeauth.internal.commands;

import com.microsoft.identity.common.java.commands.BaseCommand;
import com.microsoft.identity.common.java.commands.CommandCallback;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters;
import com.microsoft.identity.common.nativeauth.internal.controllers.BaseNativeAuthController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/microsoft/identity/common/nativeauth/internal/commands/BaseNativeAuthCommand;", "T", "Lcom/microsoft/identity/common/java/commands/BaseCommand;", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/BaseNativeAuthCommandParameters;", "controller", "Lcom/microsoft/identity/common/nativeauth/internal/controllers/BaseNativeAuthController;", "publicApiId", "", "(Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/BaseNativeAuthCommandParameters;Lcom/microsoft/identity/common/nativeauth/internal/controllers/BaseNativeAuthController;Ljava/lang/String;)V", "isEligibleForEstsTelemetry", "", "willReachTokenEndpoint", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public abstract class BaseNativeAuthCommand<T> extends BaseCommand<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseNativeAuthCommand(@NotNull BaseNativeAuthCommandParameters parameters, @NotNull BaseNativeAuthController controller, @NotNull String publicApiId) {
        super(parameters, controller.asControllerFactory(), new CommandCallback<T, BaseException>() { // from class: com.microsoft.identity.common.nativeauth.internal.commands.BaseNativeAuthCommand.1
            @Override // com.microsoft.identity.common.java.commands.CommandCallback
            public void onCancel() {
                onError((BaseException) new ClientException("onCancel not supported in native authentication flows"));
            }

            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
            public void onError(@NotNull BaseException error) {
                Intrinsics.checkNotNullParameter(error, "error");
            }

            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
            public void onTaskCompleted(T t) {
            }
        }, publicApiId);
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(publicApiId, "publicApiId");
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return true;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public boolean willReachTokenEndpoint() {
        return false;
    }
}
