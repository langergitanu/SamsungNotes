package com.microsoft.identity.common.internal.commands;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.commands.BaseCommand;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import com.microsoft.identity.common.java.result.VoidResult;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RefreshOnCommand extends BaseCommand<VoidResult> {
    private static final String TAG = "RefreshOnCommand";

    public RefreshOnCommand(@NonNull CommandParameters commandParameters, @NonNull IControllerFactory iControllerFactory, @NonNull String str) {
        super(commandParameters, iControllerFactory, new RefreshOnCallback(), str);
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForCaching() {
        return false;
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return false;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public VoidResult execute() throws ServiceException, ClientException {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        String strM1170p = AbstractC0622a.m1170p(str, ":execute", sb);
        BaseController defaultController = getControllerFactory().getDefaultController();
        Logger.verbose(strM1170p, "Executing with controller: ".concat(defaultController.getClass().getSimpleName()));
        TokenResult tokenResultRenewAccessToken = defaultController.renewAccessToken((SilentTokenCommandParameters) getParameters());
        if (!tokenResultRenewAccessToken.getSuccess()) {
            Log.e(str, tokenResultRenewAccessToken.getErrorResponse().getError());
        }
        return new VoidResult();
    }
}
