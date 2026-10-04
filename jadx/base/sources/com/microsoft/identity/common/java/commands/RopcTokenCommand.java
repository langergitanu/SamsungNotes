package com.microsoft.identity.common.java.commands;

import com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RopcTokenCommand extends TokenCommand {
    private static final String TAG = "RopcTokenCommand";

    public RopcTokenCommand(@NonNull RopcTokenCommandParameters ropcTokenCommandParameters, @NonNull IControllerFactory iControllerFactory, @NonNull CommandCallback commandCallback, @NonNull String str) {
        super(ropcTokenCommandParameters, iControllerFactory, commandCallback, str);
        if (ropcTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        if (iControllerFactory == null) {
            throw new NullPointerException("controllerFactory is marked non-null but is null");
        }
        if (commandCallback == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("publicApiId is marked non-null but is null");
        }
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForCaching() {
        return true;
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return false;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public AcquireTokenResult execute() {
        if (!(getParameters() instanceof RopcTokenCommandParameters)) {
            throw new IllegalArgumentException("Invalid operation parameters");
        }
        Logger.info(TAG + ":execute", "Executing ROPC token command...");
        return getControllerFactory().getDefaultController().acquireTokenWithPassword((RopcTokenCommandParameters) getParameters());
    }
}
