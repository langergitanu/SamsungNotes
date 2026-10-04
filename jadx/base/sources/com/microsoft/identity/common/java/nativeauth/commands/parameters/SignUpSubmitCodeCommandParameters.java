package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SignUpSubmitCodeCommandParameters extends SignUpContinueCommandParameters {
    private static final String TAG = "SignUpSubmitCodeCommandParameters";

    @NonNull
    public final String code;

    public SignUpSubmitCodeCommandParameters(SignUpSubmitCodeCommandParametersBuilder<?, ?> signUpSubmitCodeCommandParametersBuilder) {
        super(signUpSubmitCodeCommandParametersBuilder);
        String str = ((SignUpSubmitCodeCommandParametersBuilder) signUpSubmitCodeCommandParametersBuilder).code;
        this.code = str;
        if (str == null) {
            throw new NullPointerException("code is marked non-null but is null");
        }
    }

    public static SignUpSubmitCodeCommandParametersBuilder<?, ?> builder() {
        return new SignUpSubmitCodeCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof SignUpSubmitCodeCommandParameters;
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
        if (!(obj instanceof SignUpSubmitCodeCommandParameters)) {
            return false;
        }
        SignUpSubmitCodeCommandParameters signUpSubmitCodeCommandParameters = (SignUpSubmitCodeCommandParameters) obj;
        if (!signUpSubmitCodeCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String code = getCode();
        String code2 = signUpSubmitCodeCommandParameters.getCode();
        return code != null ? code.equals(code2) : code2 == null;
    }

    @NonNull
    public String getCode() {
        return this.code;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String code = getCode();
        return (iHashCode * 59) + (code == null ? 43 : code.hashCode());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toString() {
        return toUnsanitizedString();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("SignUpSubmitCodeCommandParameters(authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SignUpSubmitCodeCommandParametersBuilder<C extends SignUpSubmitCodeCommandParameters, B extends SignUpSubmitCodeCommandParametersBuilder<C, B>> extends SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder<C, B> {
        private String code;

        private static void $fillValuesFromInstanceIntoBuilder(SignUpSubmitCodeCommandParameters signUpSubmitCodeCommandParameters, SignUpSubmitCodeCommandParametersBuilder<?, ?> signUpSubmitCodeCommandParametersBuilder) {
            signUpSubmitCodeCommandParametersBuilder.code(signUpSubmitCodeCommandParameters.code);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B code(@NonNull String str) {
            if (str == null) {
                throw new NullPointerException("code is marked non-null but is null");
            }
            this.code = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("SignUpSubmitCodeCommandParameters.SignUpSubmitCodeCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", code=");
            return AbstractC0622a.m1170p(this.code, ")", sb);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignUpSubmitCodeCommandParameters) c, (SignUpSubmitCodeCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SignUpSubmitCodeCommandParametersBuilderImpl extends SignUpSubmitCodeCommandParametersBuilder<SignUpSubmitCodeCommandParameters, SignUpSubmitCodeCommandParametersBuilderImpl> {
        private SignUpSubmitCodeCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitCodeCommandParameters.SignUpSubmitCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpSubmitCodeCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitCodeCommandParameters.SignUpSubmitCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters.SignUpContinueCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpSubmitCodeCommandParameters build() {
            return new SignUpSubmitCodeCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpContinueCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignUpSubmitCodeCommandParametersBuilder<?, ?> toBuilder() {
        return new SignUpSubmitCodeCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
