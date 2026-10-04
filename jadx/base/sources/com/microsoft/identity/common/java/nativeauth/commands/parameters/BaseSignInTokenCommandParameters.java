package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseSignInTokenCommandParameters extends BaseNativeAuthCommandParameters {
    private static final String TAG = "BaseSignInTokenCommandParameters";
    private final AbstractAuthenticationScheme authenticationScheme;
    public final List<String> scopes;

    public BaseSignInTokenCommandParameters(BaseSignInTokenCommandParametersBuilder<?, ?> baseSignInTokenCommandParametersBuilder) {
        super(baseSignInTokenCommandParametersBuilder);
        this.scopes = ((BaseSignInTokenCommandParametersBuilder) baseSignInTokenCommandParametersBuilder).scopes;
        this.authenticationScheme = ((BaseSignInTokenCommandParametersBuilder) baseSignInTokenCommandParametersBuilder).authenticationScheme;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof BaseSignInTokenCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseSignInTokenCommandParameters)) {
            return false;
        }
        BaseSignInTokenCommandParameters baseSignInTokenCommandParameters = (BaseSignInTokenCommandParameters) obj;
        if (!baseSignInTokenCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        List<String> scopes = getScopes();
        List<String> scopes2 = baseSignInTokenCommandParameters.getScopes();
        if (scopes != null ? !scopes.equals(scopes2) : scopes2 != null) {
            return false;
        }
        AbstractAuthenticationScheme authenticationScheme = getAuthenticationScheme();
        AbstractAuthenticationScheme authenticationScheme2 = baseSignInTokenCommandParameters.getAuthenticationScheme();
        return authenticationScheme != null ? authenticationScheme.equals(authenticationScheme2) : authenticationScheme2 == null;
    }

    public AbstractAuthenticationScheme getAuthenticationScheme() {
        return this.authenticationScheme;
    }

    public List<String> getScopes() {
        return this.scopes;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        List<String> scopes = getScopes();
        int iHashCode2 = (iHashCode * 59) + (scopes == null ? 43 : scopes.hashCode());
        AbstractAuthenticationScheme authenticationScheme = getAuthenticationScheme();
        return (iHashCode2 * 59) + (authenticationScheme != null ? authenticationScheme.hashCode() : 43);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class BaseSignInTokenCommandParametersBuilder<C extends BaseSignInTokenCommandParameters, B extends BaseSignInTokenCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private AbstractAuthenticationScheme authenticationScheme;
        private List<String> scopes;

        private static void $fillValuesFromInstanceIntoBuilder(BaseSignInTokenCommandParameters baseSignInTokenCommandParameters, BaseSignInTokenCommandParametersBuilder<?, ?> baseSignInTokenCommandParametersBuilder) {
            baseSignInTokenCommandParametersBuilder.scopes(baseSignInTokenCommandParameters.scopes);
            baseSignInTokenCommandParametersBuilder.authenticationScheme(baseSignInTokenCommandParameters.authenticationScheme);
        }

        public B authenticationScheme(AbstractAuthenticationScheme abstractAuthenticationScheme) {
            this.authenticationScheme = abstractAuthenticationScheme;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B scopes(List<String> list) {
            this.scopes = list;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder(super=" + super.toString() + ", scopes=" + this.scopes + ", authenticationScheme=" + this.authenticationScheme + ")";
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((BaseSignInTokenCommandParameters) c, (BaseSignInTokenCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }
}
