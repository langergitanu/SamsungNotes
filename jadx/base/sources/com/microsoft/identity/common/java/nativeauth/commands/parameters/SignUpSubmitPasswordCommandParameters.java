package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressFBWarnings({"EI_EXPOSE_REP2"})
public class SignUpSubmitPasswordCommandParameters extends SignUpContinueCommandParameters {
    private static final String TAG = "SignUpSubmitPasswordCommandParameters";

    @NonNull
    public final char[] password;

    public SignUpSubmitPasswordCommandParameters(SignUpSubmitPasswordCommandParametersBuilder<?, ?> signUpSubmitPasswordCommandParametersBuilder) {
        super(signUpSubmitPasswordCommandParametersBuilder);
        char[] cArr = ((SignUpSubmitPasswordCommandParametersBuilder) signUpSubmitPasswordCommandParametersBuilder).password;
        this.password = cArr;
        if (cArr == null) {
            throw new NullPointerException("password is marked non-null but is null");
        }
    }

    public static SignUpSubmitPasswordCommandParametersBuilder<?, ?> builder() {
        return new SignUpSubmitPasswordCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof SignUpSubmitPasswordCommandParameters;
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
        if (!(obj instanceof SignUpSubmitPasswordCommandParameters)) {
            return false;
        }
        SignUpSubmitPasswordCommandParameters signUpSubmitPasswordCommandParameters = (SignUpSubmitPasswordCommandParameters) obj;
        return signUpSubmitPasswordCommandParameters.canEqual(this) && super.equals(obj) && Arrays.equals(getPassword(), signUpSubmitPasswordCommandParameters.getPassword());
    }

    @NonNull
    public char[] getPassword() {
        return this.password;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        return Arrays.hashCode(getPassword()) + (super.hashCode() * 59);
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toString() {
        return toUnsanitizedString();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("SignUpSubmitPasswordCommandParameters(authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SignUpSubmitPasswordCommandParametersBuilder<C extends SignUpSubmitPasswordCommandParameters, B extends SignUpSubmitPasswordCommandParametersBuilder<C, B>> extends SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder<C, B> {
        private char[] password;

        private static void $fillValuesFromInstanceIntoBuilder(SignUpSubmitPasswordCommandParameters signUpSubmitPasswordCommandParameters, SignUpSubmitPasswordCommandParametersBuilder<?, ?> signUpSubmitPasswordCommandParametersBuilder) {
            signUpSubmitPasswordCommandParametersBuilder.password(signUpSubmitPasswordCommandParameters.password);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B password(@NonNull char[] cArr) {
            if (cArr == null) {
                throw new NullPointerException("password is marked non-null but is null");
            }
            this.password = cArr;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "SignUpSubmitPasswordCommandParameters.SignUpSubmitPasswordCommandParametersBuilder(super=" + super.toString() + ", password=" + Arrays.toString(this.password) + ")";
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignUpSubmitPasswordCommandParameters) c, (SignUpSubmitPasswordCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SignUpSubmitPasswordCommandParametersBuilderImpl extends SignUpSubmitPasswordCommandParametersBuilder<SignUpSubmitPasswordCommandParameters, SignUpSubmitPasswordCommandParametersBuilderImpl> {
        private SignUpSubmitPasswordCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitPasswordCommandParameters.SignUpSubmitPasswordCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpSubmitPasswordCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitPasswordCommandParameters.SignUpSubmitPasswordCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpSubmitPasswordCommandParameters build() {
            return new SignUpSubmitPasswordCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignUpSubmitPasswordCommandParametersBuilder<?, ?> toBuilder() {
        return new SignUpSubmitPasswordCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
