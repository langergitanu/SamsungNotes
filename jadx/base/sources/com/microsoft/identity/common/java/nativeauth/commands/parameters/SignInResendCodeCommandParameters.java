package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SignInResendCodeCommandParameters extends BaseNativeAuthCommandParameters {
    private static final String TAG = "SignInResendCodeCommandParameters";

    @NonNull
    public final String continuationToken;

    public SignInResendCodeCommandParameters(SignInResendCodeCommandParametersBuilder<?, ?> signInResendCodeCommandParametersBuilder) {
        super(signInResendCodeCommandParametersBuilder);
        String str = ((SignInResendCodeCommandParametersBuilder) signInResendCodeCommandParametersBuilder).continuationToken;
        this.continuationToken = str;
        if (str == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static SignInResendCodeCommandParametersBuilder<?, ?> builder() {
        return new SignInResendCodeCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof SignInResendCodeCommandParameters;
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
        if (!(obj instanceof SignInResendCodeCommandParameters)) {
            return false;
        }
        SignInResendCodeCommandParameters signInResendCodeCommandParameters = (SignInResendCodeCommandParameters) obj;
        if (!signInResendCodeCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = signInResendCodeCommandParameters.getContinuationToken();
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
        StringBuilder sb = new StringBuilder("SignInResendCodeCommandParameters(authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SignInResendCodeCommandParametersBuilder<C extends SignInResendCodeCommandParameters, B extends SignInResendCodeCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private String continuationToken;

        private static void $fillValuesFromInstanceIntoBuilder(SignInResendCodeCommandParameters signInResendCodeCommandParameters, SignInResendCodeCommandParametersBuilder<?, ?> signInResendCodeCommandParametersBuilder) {
            signInResendCodeCommandParametersBuilder.continuationToken(signInResendCodeCommandParameters.continuationToken);
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
            StringBuilder sb = new StringBuilder("SignInResendCodeCommandParameters.SignInResendCodeCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", continuationToken=");
            return AbstractC0622a.m1170p(this.continuationToken, ")", sb);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignInResendCodeCommandParameters) c, (SignInResendCodeCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SignInResendCodeCommandParametersBuilderImpl extends SignInResendCodeCommandParametersBuilder<SignInResendCodeCommandParameters, SignInResendCodeCommandParametersBuilderImpl> {
        private SignInResendCodeCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInResendCodeCommandParameters.SignInResendCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInResendCodeCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInResendCodeCommandParameters.SignInResendCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInResendCodeCommandParameters build() {
            return new SignInResendCodeCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignInResendCodeCommandParametersBuilder<?, ?> toBuilder() {
        return new SignInResendCodeCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
