package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SignInSubmitCodeCommandParameters extends BaseSignInTokenCommandParameters {
    private static final String TAG = "SignInSubmitCodeCommandParameters";

    @NonNull
    public final String code;

    @NonNull
    public final String continuationToken;

    public SignInSubmitCodeCommandParameters(SignInSubmitCodeCommandParametersBuilder<?, ?> signInSubmitCodeCommandParametersBuilder) {
        super(signInSubmitCodeCommandParametersBuilder);
        String str = ((SignInSubmitCodeCommandParametersBuilder) signInSubmitCodeCommandParametersBuilder).code;
        this.code = str;
        if (str == null) {
            throw new NullPointerException("code is marked non-null but is null");
        }
        String str2 = ((SignInSubmitCodeCommandParametersBuilder) signInSubmitCodeCommandParametersBuilder).continuationToken;
        this.continuationToken = str2;
        if (str2 == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static SignInSubmitCodeCommandParametersBuilder<?, ?> builder() {
        return new SignInSubmitCodeCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof SignInSubmitCodeCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return !toString().equals(toUnsanitizedString());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInSubmitCodeCommandParameters)) {
            return false;
        }
        SignInSubmitCodeCommandParameters signInSubmitCodeCommandParameters = (SignInSubmitCodeCommandParameters) obj;
        if (!signInSubmitCodeCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String code = getCode();
        String code2 = signInSubmitCodeCommandParameters.getCode();
        if (code != null ? !code.equals(code2) : code2 != null) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = signInSubmitCodeCommandParameters.getContinuationToken();
        return continuationToken != null ? continuationToken.equals(continuationToken2) : continuationToken2 == null;
    }

    @NonNull
    public String getCode() {
        return this.code;
    }

    @NonNull
    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String code = getCode();
        int iHashCode2 = (iHashCode * 59) + (code == null ? 43 : code.hashCode());
        String continuationToken = getContinuationToken();
        return (iHashCode2 * 59) + (continuationToken != null ? continuationToken.hashCode() : 43);
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toString() {
        return toUnsanitizedString();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("SignInSubmitCodeCommandParameters(authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignInSubmitCodeCommandParametersBuilder<?, ?> toBuilder() {
        return new SignInSubmitCodeCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SignInSubmitCodeCommandParametersBuilder<C extends SignInSubmitCodeCommandParameters, B extends SignInSubmitCodeCommandParametersBuilder<C, B>> extends BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder<C, B> {
        private String code;
        private String continuationToken;

        private static void $fillValuesFromInstanceIntoBuilder(SignInSubmitCodeCommandParameters signInSubmitCodeCommandParameters, SignInSubmitCodeCommandParametersBuilder<?, ?> signInSubmitCodeCommandParametersBuilder) {
            signInSubmitCodeCommandParametersBuilder.code(signInSubmitCodeCommandParameters.code);
            signInSubmitCodeCommandParametersBuilder.continuationToken(signInSubmitCodeCommandParameters.continuationToken);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B code(@NonNull String str) {
            if (str == null) {
                throw new NullPointerException("code is marked non-null but is null");
            }
            this.code = str;
            return (B) self();
        }

        public B continuationToken(@NonNull String str) {
            if (str == null) {
                throw new NullPointerException("continuationToken is marked non-null but is null");
            }
            this.continuationToken = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("SignInSubmitCodeCommandParameters.SignInSubmitCodeCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", code=");
            sb.append(this.code);
            sb.append(", continuationToken=");
            return AbstractC0622a.m1170p(this.continuationToken, ")", sb);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignInSubmitCodeCommandParameters) c, (SignInSubmitCodeCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SignInSubmitCodeCommandParametersBuilderImpl extends SignInSubmitCodeCommandParametersBuilder<SignInSubmitCodeCommandParameters, SignInSubmitCodeCommandParametersBuilderImpl> {
        private SignInSubmitCodeCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters.SignInSubmitCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInSubmitCodeCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters.SignInSubmitCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInSubmitCodeCommandParameters build() {
            return new SignInSubmitCodeCommandParameters(this);
        }
    }
}
