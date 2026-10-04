package com.microsoft.identity.common.internal.commands;

import com.microsoft.identity.common.java.commands.BaseCommand;
import com.microsoft.identity.common.java.commands.CommandCallback;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.p132ui.PreferredAuthMethod;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/commands/GetPreferredAuthMethodFromAuthenticator;", "Lcom/microsoft/identity/common/java/commands/BaseCommand;", "Lcom/microsoft/identity/common/java/ui/PreferredAuthMethod;", "parameters", "Lcom/microsoft/identity/common/java/commands/parameters/CommandParameters;", "controllerFactory", "Lcom/microsoft/identity/common/java/controllers/IControllerFactory;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/microsoft/identity/common/java/commands/CommandCallback;", "publicApiId", "", "(Lcom/microsoft/identity/common/java/commands/parameters/CommandParameters;Lcom/microsoft/identity/common/java/controllers/IControllerFactory;Lcom/microsoft/identity/common/java/commands/CommandCallback;Ljava/lang/String;)V", "execute", "isEligibleForEstsTelemetry", "", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class GetPreferredAuthMethodFromAuthenticator extends BaseCommand<PreferredAuthMethod> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPreferredAuthMethodFromAuthenticator(@NotNull CommandParameters parameters, @NotNull IControllerFactory controllerFactory, @NotNull CommandCallback<?, ?> callback, @NotNull String publicApiId) {
        super(parameters, controllerFactory, callback, publicApiId);
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(controllerFactory, "controllerFactory");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(publicApiId, "publicApiId");
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return false;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    @NotNull
    public PreferredAuthMethod execute() {
        PreferredAuthMethod preferredAuthMethod = getControllerFactory().getDefaultController().getPreferredAuthMethod();
        Intrinsics.checkNotNullExpressionValue(preferredAuthMethod, "controllerFactory.getDef…ler().preferredAuthMethod");
        return preferredAuthMethod;
    }
}
