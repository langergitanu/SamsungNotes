package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SignUpResendCodeCommandParameters extends BaseNativeAuthCommandParameters {
    private static final String TAG = "SignUpResendCodeCommandParameters";

    @NonNull
    public final String continuationToken;

    public SignUpResendCodeCommandParameters(SignUpResendCodeCommandParametersBuilder<?, ?> signUpResendCodeCommandParametersBuilder) {
        super(signUpResendCodeCommandParametersBuilder);
        String str = ((SignUpResendCodeCommandParametersBuilder) signUpResendCodeCommandParametersBuilder).continuationToken;
        this.continuationToken = str;
        if (str == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static SignUpResendCodeCommandParametersBuilder<?, ?> builder() {
        return new SignUpResendCodeCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof SignUpResendCodeCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return !toString().equals(toUnsanitizedString());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignUpResendCodeCommandParameters)) {
            return false;
        }
        SignUpResendCodeCommandParameters signUpResendCodeCommandParameters = (SignUpResendCodeCommandParameters) obj;
        if (!signUpResendCodeCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = signUpResendCodeCommandParameters.getContinuationToken();
        return continuationToken != null ? continuationToken.equals(continuationToken2) : continuationToken2 == null;
    }

    @NonNull
    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String continuationToken = getContinuationToken();
        return (iHashCode * 59) + (continuationToken == null ? 43 : continuationToken.hashCode());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toString() {
        return toUnsanitizedString();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("SignUpResendCodeCommandParameters(authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SignUpResendCodeCommandParametersBuilder<C extends SignUpResendCodeCommandParameters, B extends SignUpResendCodeCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private String continuationToken;

        private static void $fillValuesFromInstanceIntoBuilder(SignUpResendCodeCommandParameters signUpResendCodeCommandParameters, SignUpResendCodeCommandParametersBuilder<?, ?> signUpResendCodeCommandParametersBuilder) {
            signUpResendCodeCommandParametersBuilder.continuationToken(signUpResendCodeCommandParameters.continuationToken);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B continuationToken(@NonNull String str) {
            if (str == null) {
                throw new NullPointerException("continuationToken is marked non-null but is null");
            }
            this.continuationToken = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("SignUpResendCodeCommandParameters.SignUpResendCodeCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", continuationToken=");
            return AbstractC0622a.m1170p(this.continuationToken, ")", sb);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignUpResendCodeCommandParameters) c, (SignUpResendCodeCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SignUpResendCodeCommandParametersBuilderImpl extends SignUpResendCodeCommandParametersBuilder<SignUpResendCodeCommandParameters, SignUpResendCodeCommandParametersBuilderImpl> {
        private SignUpResendCodeCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpResendCodeCommandParameters.SignUpResendCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpResendCodeCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpResendCodeCommandParameters.SignUpResendCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpResendCodeCommandParameters build() {
            return new SignUpResendCodeCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignUpResendCodeCommandParametersBuilder<?, ?> toBuilder() {
        return new SignUpResendCodeCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
