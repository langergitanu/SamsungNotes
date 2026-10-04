package com.microsoft.identity.common.java.commands.parameters;

import com.microsoft.identity.common.java.authscheme.IPoPAuthenticationSchemeParams;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class GenerateShrCommandParameters extends CommandParameters {
    private String mHomeAccountId;
    private IPoPAuthenticationSchemeParams mPopParameters;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class GenerateShrCommandParametersBuilder<C extends GenerateShrCommandParameters, B extends GenerateShrCommandParametersBuilder<C, B>> extends CommandParameters.CommandParametersBuilder<C, B> {
        private String homeAccountId;
        private IPoPAuthenticationSchemeParams popParameters;

        private static void $fillValuesFromInstanceIntoBuilder(GenerateShrCommandParameters generateShrCommandParameters, GenerateShrCommandParametersBuilder<?, ?> generateShrCommandParametersBuilder) {
            generateShrCommandParametersBuilder.homeAccountId(generateShrCommandParameters.mHomeAccountId);
            generateShrCommandParametersBuilder.popParameters(generateShrCommandParameters.mPopParameters);
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B homeAccountId(String str) {
            this.homeAccountId = str;
            return (B) self();
        }

        public B popParameters(IPoPAuthenticationSchemeParams iPoPAuthenticationSchemeParams) {
            this.popParameters = iPoPAuthenticationSchemeParams;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "GenerateShrCommandParameters.GenerateShrCommandParametersBuilder(super=" + super.toString() + ", homeAccountId=" + this.homeAccountId + ", popParameters=" + this.popParameters + ")";
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((GenerateShrCommandParameters) c, (GenerateShrCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class GenerateShrCommandParametersBuilderImpl extends GenerateShrCommandParametersBuilder<GenerateShrCommandParameters, GenerateShrCommandParametersBuilderImpl> {
        private GenerateShrCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.GenerateShrCommandParameters.GenerateShrCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public GenerateShrCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.GenerateShrCommandParameters.GenerateShrCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public GenerateShrCommandParameters build() {
            return new GenerateShrCommandParameters(this);
        }
    }

    public GenerateShrCommandParameters(GenerateShrCommandParametersBuilder<?, ?> generateShrCommandParametersBuilder) {
        super(generateShrCommandParametersBuilder);
        this.mHomeAccountId = ((GenerateShrCommandParametersBuilder) generateShrCommandParametersBuilder).homeAccountId;
        this.mPopParameters = ((GenerateShrCommandParametersBuilder) generateShrCommandParametersBuilder).popParameters;
    }

    public static GenerateShrCommandParametersBuilder<?, ?> builder() {
        return new GenerateShrCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof GenerateShrCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GenerateShrCommandParameters)) {
            return false;
        }
        GenerateShrCommandParameters generateShrCommandParameters = (GenerateShrCommandParameters) obj;
        if (!generateShrCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String homeAccountId = getHomeAccountId();
        String homeAccountId2 = generateShrCommandParameters.getHomeAccountId();
        if (homeAccountId != null ? !homeAccountId.equals(homeAccountId2) : homeAccountId2 != null) {
            return false;
        }
        IPoPAuthenticationSchemeParams popParameters = getPopParameters();
        IPoPAuthenticationSchemeParams popParameters2 = generateShrCommandParameters.getPopParameters();
        return popParameters != null ? popParameters.equals(popParameters2) : popParameters2 == null;
    }

    public String getHomeAccountId() {
        return this.mHomeAccountId;
    }

    public IPoPAuthenticationSchemeParams getPopParameters() {
        return this.mPopParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String homeAccountId = getHomeAccountId();
        int iHashCode2 = (iHashCode * 59) + (homeAccountId == null ? 43 : homeAccountId.hashCode());
        IPoPAuthenticationSchemeParams popParameters = getPopParameters();
        return (iHashCode2 * 59) + (popParameters != null ? popParameters.hashCode() : 43);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public GenerateShrCommandParametersBuilder<?, ?> toBuilder() {
        return new GenerateShrCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
