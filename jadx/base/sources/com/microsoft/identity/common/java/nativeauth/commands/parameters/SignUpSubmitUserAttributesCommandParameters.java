package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SignUpSubmitUserAttributesCommandParameters extends SignUpContinueCommandParameters {
    private static final String TAG = "SignUpSubmitUserAttributesCommandParameters";

    @NonNull
    public final Map<String, String> userAttributes;

    public SignUpSubmitUserAttributesCommandParameters(SignUpSubmitUserAttributesCommandParametersBuilder<?, ?> signUpSubmitUserAttributesCommandParametersBuilder) {
        super(signUpSubmitUserAttributesCommandParametersBuilder);
        Map<String, String> map = ((SignUpSubmitUserAttributesCommandParametersBuilder) signUpSubmitUserAttributesCommandParametersBuilder).userAttributes;
        this.userAttributes = map;
        if (map == null) {
            throw new NullPointerException("userAttributes is marked non-null but is null");
        }
    }

    public static SignUpSubmitUserAttributesCommandParametersBuilder<?, ?> builder() {
        return new SignUpSubmitUserAttributesCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof SignUpSubmitUserAttributesCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return !toString().equals(toUnsanitizedString());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignUpSubmitUserAttributesCommandParameters)) {
            return false;
        }
        SignUpSubmitUserAttributesCommandParameters signUpSubmitUserAttributesCommandParameters = (SignUpSubmitUserAttributesCommandParameters) obj;
        if (!signUpSubmitUserAttributesCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        Map<String, String> userAttributes = getUserAttributes();
        Map<String, String> userAttributes2 = signUpSubmitUserAttributesCommandParameters.getUserAttributes();
        return userAttributes != null ? userAttributes.equals(userAttributes2) : userAttributes2 == null;
    }

    @NonNull
    public Map<String, String> getUserAttributes() {
        return this.userAttributes;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        Map<String, String> userAttributes = getUserAttributes();
        return (iHashCode * 59) + (userAttributes == null ? 43 : userAttributes.hashCode());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("SignUpSubmitUserAttributesCommandParameters(authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("SignUpSubmitUserAttributesCommandParameters(userAttributes=");
        sb.append(this.userAttributes);
        sb.append(", authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SignUpSubmitUserAttributesCommandParametersBuilder<C extends SignUpSubmitUserAttributesCommandParameters, B extends SignUpSubmitUserAttributesCommandParametersBuilder<C, B>> extends SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder<C, B> {
        private Map<String, String> userAttributes;

        private static void $fillValuesFromInstanceIntoBuilder(SignUpSubmitUserAttributesCommandParameters signUpSubmitUserAttributesCommandParameters, SignUpSubmitUserAttributesCommandParametersBuilder<?, ?> signUpSubmitUserAttributesCommandParametersBuilder) {
            signUpSubmitUserAttributesCommandParametersBuilder.userAttributes(signUpSubmitUserAttributesCommandParameters.userAttributes);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "SignUpSubmitUserAttributesCommandParameters.SignUpSubmitUserAttributesCommandParametersBuilder(super=" + super.toString() + ", userAttributes=" + this.userAttributes + ")";
        }

        public B userAttributes(@NonNull Map<String, String> map) {
            if (map == null) {
                throw new NullPointerException("userAttributes is marked non-null but is null");
            }
            this.userAttributes = map;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignUpSubmitUserAttributesCommandParameters) c, (SignUpSubmitUserAttributesCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SignUpSubmitUserAttributesCommandParametersBuilderImpl extends SignUpSubmitUserAttributesCommandParametersBuilder<SignUpSubmitUserAttributesCommandParameters, SignUpSubmitUserAttributesCommandParametersBuilderImpl> {
        private SignUpSubmitUserAttributesCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitUserAttributesCommandParameters.SignUpSubmitUserAttributesCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpSubmitUserAttributesCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitUserAttributesCommandParameters.SignUpSubmitUserAttributesCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpSubmitUserAttributesCommandParameters build() {
            return new SignUpSubmitUserAttributesCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignUpSubmitUserAttributesCommandParametersBuilder<?, ?> toBuilder() {
        return new SignUpSubmitUserAttributesCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
