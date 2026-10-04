package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressFBWarnings({"EI_EXPOSE_REP2"})
public class SignInSubmitPasswordCommandParameters extends BaseSignInTokenCommandParameters {
    private static final String TAG = "SignInSubmitCodeCommandParameters";

    @NonNull
    public final String continuationToken;

    @NonNull
    public final char[] password;

    public SignInSubmitPasswordCommandParameters(SignInSubmitPasswordCommandParametersBuilder<?, ?> signInSubmitPasswordCommandParametersBuilder) {
        super(signInSubmitPasswordCommandParametersBuilder);
        char[] cArr = ((SignInSubmitPasswordCommandParametersBuilder) signInSubmitPasswordCommandParametersBuilder).password;
        this.password = cArr;
        if (cArr == null) {
            throw new NullPointerException("password is marked non-null but is null");
        }
        String str = ((SignInSubmitPasswordCommandParametersBuilder) signInSubmitPasswordCommandParametersBuilder).continuationToken;
        this.continuationToken = str;
        if (str == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static SignInSubmitPasswordCommandParametersBuilder<?, ?> builder() {
        return new SignInSubmitPasswordCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof SignInSubmitPasswordCommandParameters;
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
        if (!(obj instanceof SignInSubmitPasswordCommandParameters)) {
            return false;
        }
        SignInSubmitPasswordCommandParameters signInSubmitPasswordCommandParameters = (SignInSubmitPasswordCommandParameters) obj;
        if (!signInSubmitPasswordCommandParameters.canEqual(this) || !super.equals(obj) || !Arrays.equals(getPassword(), signInSubmitPasswordCommandParameters.getPassword())) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = signInSubmitPasswordCommandParameters.getContinuationToken();
        return continuationToken != null ? continuationToken.equals(continuationToken2) : continuationToken2 == null;
    }

    @NonNull
    public String getContinuationToken() {
        return this.continuationToken;
    }

    @NonNull
    public char[] getPassword() {
        return this.password;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = Arrays.hashCode(getPassword()) + (super.hashCode() * 59);
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
        StringBuilder sb = new StringBuilder("SignInSubmitPasswordCommandParameters(authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignInSubmitPasswordCommandParametersBuilder<?, ?> toBuilder() {
        return new SignInSubmitPasswordCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SignInSubmitPasswordCommandParametersBuilder<C extends SignInSubmitPasswordCommandParameters, B extends SignInSubmitPasswordCommandParametersBuilder<C, B>> extends BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder<C, B> {
        private String continuationToken;
        private char[] password;

        private static void $fillValuesFromInstanceIntoBuilder(SignInSubmitPasswordCommandParameters signInSubmitPasswordCommandParameters, SignInSubmitPasswordCommandParametersBuilder<?, ?> signInSubmitPasswordCommandParametersBuilder) {
            signInSubmitPasswordCommandParametersBuilder.password(signInSubmitPasswordCommandParameters.password);
            signInSubmitPasswordCommandParametersBuilder.continuationToken(signInSubmitPasswordCommandParameters.continuationToken);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B continuationToken(@NonNull String str) {
            if (str == null) {
                throw new NullPointerException("continuationToken is marked non-null but is null");
            }
            this.continuationToken = str;
            return (B) self();
        }

        public B password(@NonNull char[] cArr) {
            if (cArr == null) {
                throw new NullPointerException("password is marked non-null but is null");
            }
            this.password = cArr;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", password=");
            sb.append(Arrays.toString(this.password));
            sb.append(", continuationToken=");
            return AbstractC0622a.m1170p(this.continuationToken, ")", sb);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignInSubmitPasswordCommandParameters) c, (SignInSubmitPasswordCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SignInSubmitPasswordCommandParametersBuilderImpl extends SignInSubmitPasswordCommandParametersBuilder<SignInSubmitPasswordCommandParameters, SignInSubmitPasswordCommandParametersBuilderImpl> {
        private SignInSubmitPasswordCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInSubmitPasswordCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitPasswordCommandParameters.SignInSubmitPasswordCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInSubmitPasswordCommandParameters build() {
            return new SignInSubmitPasswordCommandParameters(this);
        }
    }
}
