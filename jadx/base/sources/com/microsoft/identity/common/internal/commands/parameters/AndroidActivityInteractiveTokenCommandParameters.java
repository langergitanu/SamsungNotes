package com.microsoft.identity.common.internal.commands.parameters;

import android.app.Activity;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidActivityInteractiveTokenCommandParameters extends InteractiveTokenCommandParameters {
    private final transient Activity activity;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AndroidActivityInteractiveTokenCommandParametersBuilder<C extends AndroidActivityInteractiveTokenCommandParameters, B extends AndroidActivityInteractiveTokenCommandParametersBuilder<C, B>> extends InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder<C, B> {
        private Activity activity;

        private static void $fillValuesFromInstanceIntoBuilder(AndroidActivityInteractiveTokenCommandParameters androidActivityInteractiveTokenCommandParameters, AndroidActivityInteractiveTokenCommandParametersBuilder<?, ?> androidActivityInteractiveTokenCommandParametersBuilder) {
            androidActivityInteractiveTokenCommandParametersBuilder.activity(androidActivityInteractiveTokenCommandParameters.activity);
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((AndroidActivityInteractiveTokenCommandParameters) c, (AndroidActivityInteractiveTokenCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B activity(Activity activity) {
            this.activity = activity;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "AndroidActivityInteractiveTokenCommandParameters.AndroidActivityInteractiveTokenCommandParametersBuilder(super=" + super.toString() + ", activity=" + this.activity + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class AndroidActivityInteractiveTokenCommandParametersBuilderImpl extends AndroidActivityInteractiveTokenCommandParametersBuilder<AndroidActivityInteractiveTokenCommandParameters, AndroidActivityInteractiveTokenCommandParametersBuilderImpl> {
        private AndroidActivityInteractiveTokenCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.internal.commands.parameters.AndroidActivityInteractiveTokenCommandParameters.AndroidActivityInteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public AndroidActivityInteractiveTokenCommandParameters build() {
            return new AndroidActivityInteractiveTokenCommandParameters(this);
        }

        @Override // com.microsoft.identity.common.internal.commands.parameters.AndroidActivityInteractiveTokenCommandParameters.AndroidActivityInteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public AndroidActivityInteractiveTokenCommandParametersBuilderImpl self() {
            return this;
        }
    }

    public AndroidActivityInteractiveTokenCommandParameters(AndroidActivityInteractiveTokenCommandParametersBuilder<?, ?> androidActivityInteractiveTokenCommandParametersBuilder) {
        super(androidActivityInteractiveTokenCommandParametersBuilder);
        this.activity = ((AndroidActivityInteractiveTokenCommandParametersBuilder) androidActivityInteractiveTokenCommandParametersBuilder).activity;
    }

    public static AndroidActivityInteractiveTokenCommandParametersBuilder<?, ?> builder() {
        return new AndroidActivityInteractiveTokenCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof AndroidActivityInteractiveTokenCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof AndroidActivityInteractiveTokenCommandParameters) && ((AndroidActivityInteractiveTokenCommandParameters) obj).canEqual(this) && super.equals(obj);
    }

    public Activity getActivity() {
        return this.activity;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public AndroidActivityInteractiveTokenCommandParametersBuilder<?, ?> toBuilder() {
        return new AndroidActivityInteractiveTokenCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
