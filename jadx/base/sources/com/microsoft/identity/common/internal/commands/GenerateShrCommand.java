package com.microsoft.identity.common.internal.commands;

import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.java.commands.BaseCommand;
import com.microsoft.identity.common.java.commands.CommandCallback;
import com.microsoft.identity.common.java.commands.parameters.GenerateShrCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.UiRequiredException;
import com.microsoft.identity.common.java.result.GenerateShrResult;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class GenerateShrCommand extends BaseCommand<GenerateShrResult> {
    private static final String TAG = "GenerateShrCommand";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class GenerateShrCommandBuilder<C extends GenerateShrCommand, B extends GenerateShrCommandBuilder<C, B>> extends BaseCommand.BaseCommandBuilder<GenerateShrResult, C, B> {
        @Override // com.microsoft.identity.common.java.commands.BaseCommand.BaseCommandBuilder
        public abstract C build();

        @Override // com.microsoft.identity.common.java.commands.BaseCommand.BaseCommandBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.commands.BaseCommand.BaseCommandBuilder
        public String toString() {
            return AbstractC0622a.m1170p(super.toString(), ")", new StringBuilder("GenerateShrCommand.GenerateShrCommandBuilder(super="));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class GenerateShrCommandBuilderImpl extends GenerateShrCommandBuilder<GenerateShrCommand, GenerateShrCommandBuilderImpl> {
        private GenerateShrCommandBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.internal.commands.GenerateShrCommand.GenerateShrCommandBuilder, com.microsoft.identity.common.java.commands.BaseCommand.BaseCommandBuilder
        public GenerateShrCommand build() {
            return new GenerateShrCommand(this);
        }

        @Override // com.microsoft.identity.common.internal.commands.GenerateShrCommand.GenerateShrCommandBuilder, com.microsoft.identity.common.java.commands.BaseCommand.BaseCommandBuilder
        public GenerateShrCommandBuilderImpl self() {
            return this;
        }
    }

    public GenerateShrCommand(GenerateShrCommandBuilder<?, ?> generateShrCommandBuilder) {
        super(generateShrCommandBuilder);
    }

    public static GenerateShrCommandBuilder<?, ?> builder() {
        return new GenerateShrCommandBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    public boolean canEqual(Object obj) {
        return obj instanceof GenerateShrCommand;
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof GenerateShrCommand) && ((GenerateShrCommand) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForEstsTelemetry() {
        return false;
    }

    public GenerateShrCommand(@NonNull GenerateShrCommandParameters generateShrCommandParameters, @NonNull IControllerFactory iControllerFactory, @NonNull CommandCallback<GenerateShrResult, BaseException> commandCallback, @NonNull String str) {
        super(generateShrCommandParameters, iControllerFactory, commandCallback, str);
    }

    @Override // com.microsoft.identity.common.java.commands.BaseCommand, com.microsoft.identity.common.java.commands.ICommand
    public GenerateShrResult execute() throws UiRequiredException, ClientException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":execute", new StringBuilder());
        GenerateShrCommandParameters generateShrCommandParameters = (GenerateShrCommandParameters) getParameters();
        List<BaseController> allControllers = getControllerFactory().getAllControllers();
        GenerateShrResult generateShrResult = null;
        int i = 0;
        while (i < allControllers.size()) {
            BaseController baseController = allControllers.get(i);
            Logger.verbose(strM1170p, "Executing with controller: ".concat(baseController.getClass().getSimpleName()));
            GenerateShrResult generateShrResultGenerateSignedHttpRequest = baseController.generateSignedHttpRequest(generateShrCommandParameters);
            if (generateShrResultGenerateSignedHttpRequest.getErrorCode() == null) {
                com.microsoft.identity.common.java.logging.Logger.verbose(strM1170p, "Executing with controller: " + baseController.getClass().getSimpleName() + ": Succeeded");
                return generateShrResultGenerateSignedHttpRequest;
            }
            String errorCode = generateShrResultGenerateSignedHttpRequest.getErrorCode();
            String errorMessage = generateShrResultGenerateSignedHttpRequest.getErrorMessage();
            if (!"no_account_found".equalsIgnoreCase(errorCode)) {
                throw new ClientException(errorCode, errorMessage);
            }
            i++;
            if (allControllers.size() <= i) {
                throw new UiRequiredException(errorCode, errorMessage);
            }
            generateShrResult = generateShrResultGenerateSignedHttpRequest;
        }
        return generateShrResult;
    }
}
