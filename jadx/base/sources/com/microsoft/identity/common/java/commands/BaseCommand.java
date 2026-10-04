package com.microsoft.identity.common.java.commands;

import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressFBWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NONNULL_VALUE"})
public abstract class BaseCommand<T> implements ICommand<T> {

    @NonNull
    private final CommandCallback callback;

    @NonNull
    private final IControllerFactory controllerFactory;

    @NonNull
    private final CommandParameters parameters;

    @NonNull
    private final String publicApiId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class BaseCommandBuilder<T, C extends BaseCommand<T>, B extends BaseCommandBuilder<T, C, B>> {
        private CommandCallback callback;
        private IControllerFactory controllerFactory;
        private CommandParameters parameters;
        private String publicApiId;

        private static <T> void $fillValuesFromInstanceIntoBuilder(BaseCommand<T> baseCommand, BaseCommandBuilder<T, ?, ?> baseCommandBuilder) {
            baseCommandBuilder.parameters(((BaseCommand) baseCommand).parameters);
            baseCommandBuilder.callback(((BaseCommand) baseCommand).callback);
            baseCommandBuilder.publicApiId(((BaseCommand) baseCommand).publicApiId);
            baseCommandBuilder.controllerFactory(((BaseCommand) baseCommand).controllerFactory);
        }

        public B $fillValuesFrom(C c) {
            $fillValuesFromInstanceIntoBuilder(c, this);
            return (B) self();
        }

        public abstract C build();

        public B callback(@NonNull CommandCallback commandCallback) {
            if (commandCallback == null) {
                throw new NullPointerException("callback is marked non-null but is null");
            }
            this.callback = commandCallback;
            return (B) self();
        }

        public B controllerFactory(@NonNull IControllerFactory iControllerFactory) {
            if (iControllerFactory == null) {
                throw new NullPointerException("controllerFactory is marked non-null but is null");
            }
            this.controllerFactory = iControllerFactory;
            return (B) self();
        }

        public B parameters(@NonNull CommandParameters commandParameters) {
            if (commandParameters == null) {
                throw new NullPointerException("parameters is marked non-null but is null");
            }
            this.parameters = commandParameters;
            return (B) self();
        }

        public B publicApiId(@NonNull String str) {
            if (str == null) {
                throw new NullPointerException("publicApiId is marked non-null but is null");
            }
            this.publicApiId = str;
            return (B) self();
        }

        public abstract B self();

        public String toString() {
            return "BaseCommand.BaseCommandBuilder(parameters=" + this.parameters + ", callback=" + this.callback + ", publicApiId=" + this.publicApiId + ", controllerFactory=" + this.controllerFactory + ")";
        }
    }

    public BaseCommand(BaseCommandBuilder<T, ?, ?> baseCommandBuilder) {
        CommandParameters commandParameters = ((BaseCommandBuilder) baseCommandBuilder).parameters;
        this.parameters = commandParameters;
        if (commandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        CommandCallback commandCallback = ((BaseCommandBuilder) baseCommandBuilder).callback;
        this.callback = commandCallback;
        if (commandCallback == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        String str = ((BaseCommandBuilder) baseCommandBuilder).publicApiId;
        this.publicApiId = str;
        if (str == null) {
            throw new NullPointerException("publicApiId is marked non-null but is null");
        }
        IControllerFactory iControllerFactory = ((BaseCommandBuilder) baseCommandBuilder).controllerFactory;
        this.controllerFactory = iControllerFactory;
        if (iControllerFactory == null) {
            throw new NullPointerException("controllerFactory is marked non-null but is null");
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof BaseCommand;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseCommand)) {
            return false;
        }
        BaseCommand baseCommand = (BaseCommand) obj;
        if (!baseCommand.canEqual(this)) {
            return false;
        }
        CommandParameters parameters = getParameters();
        CommandParameters parameters2 = baseCommand.getParameters();
        return parameters != null ? parameters.equals(parameters2) : parameters2 == null;
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public abstract T execute();

    @NonNull
    public CommandCallback getCallback() {
        return this.callback;
    }

    @NonNull
    public IControllerFactory getControllerFactory() {
        return this.controllerFactory;
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public String getCorrelationId() {
        return getParameters().getCorrelationId();
    }

    @NonNull
    public CommandParameters getParameters() {
        return this.parameters;
    }

    @NonNull
    public String getPublicApiId() {
        return this.publicApiId;
    }

    public int hashCode() {
        CommandParameters parameters = getParameters();
        return 59 + (parameters == null ? 43 : parameters.hashCode());
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean isEligibleForCaching() {
        return false;
    }

    @Override // com.microsoft.identity.common.java.commands.ICommand
    public boolean willReachTokenEndpoint() {
        return false;
    }

    public BaseCommand(@NonNull CommandParameters commandParameters, @NonNull IControllerFactory iControllerFactory, @NonNull CommandCallback commandCallback, @NonNull String str) {
        if (commandParameters == null) {
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
        this.parameters = commandParameters;
        this.callback = commandCallback;
        this.controllerFactory = iControllerFactory;
        this.publicApiId = str;
    }
}
