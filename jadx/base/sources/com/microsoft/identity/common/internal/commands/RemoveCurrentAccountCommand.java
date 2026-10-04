package com.microsoft.identity.common.internal.commands;

import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.commands.BaseCommand;
import com.microsoft.identity.common.java.commands.CommandCallback;
import com.microsoft.identity.common.java.commands.parameters.RemoveAccountCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RemoveCurrentAccountCommand extends BaseCommand<Boolean> {
    private static final String TAG = "RemoveCurrentAccountCommand";

    public RemoveCurrentAccountCommand(@NonNull RemoveAccountCommandParameters removeAccountCommandParameters, @NonNull IControllerFactory iControllerFactory, @NonNull CommandCallback commandCallback, @NonNull String str) {
        super(removeAccountCommandParameters, iControllerFactory, commandCallback, str);
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    public boolean canEqual(Object obj) {
        return obj instanceof RemoveCurrentAccountCommand;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof RemoveCurrentAccountCommand) && ((RemoveCurrentAccountCommand) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return true;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public Boolean execute() {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":execute", new StringBuilder());
        for (BaseController baseController : getControllerFactory().getAllControllers()) {
            Logger.verbose(strM1170p, "Executing with controller: ".concat(baseController.getClass().getSimpleName()));
            if (baseController.removeCurrentAccount((RemoveAccountCommandParameters) getParameters())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
