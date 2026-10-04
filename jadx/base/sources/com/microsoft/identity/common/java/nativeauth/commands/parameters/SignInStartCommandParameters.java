package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;
import javax.annotation.Nullable;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressFBWarnings({"EI_EXPOSE_REP2"})
public class SignInStartCommandParameters extends BaseSignInTokenCommandParameters {
    private static final String TAG = "SignInStartCommandParameters";

    @Nullable
    public final char[] password;

    @NonNull
    public final String username;

    public SignInStartCommandParameters(SignInStartCommandParametersBuilder<?, ?> signInStartCommandParametersBuilder) {
        super(signInStartCommandParametersBuilder);
        String str = ((SignInStartCommandParametersBuilder) signInStartCommandParametersBuilder).username;
        this.username = str;
        if (str == null) {
            throw new NullPointerException("username is marked non-null but is null");
        }
        this.password = ((SignInStartCommandParametersBuilder) signInStartCommandParametersBuilder).password;
    }

    public static SignInStartCommandParametersBuilder<?, ?> builder() {
        return new SignInStartCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof SignInStartCommandParameters;
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
        if (!(obj instanceof SignInStartCommandParameters)) {
            return false;
        }
        SignInStartCommandParameters signInStartCommandParameters = (SignInStartCommandParameters) obj;
        if (!signInStartCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String username = getUsername();
        String username2 = signInStartCommandParameters.getUsername();
        if (username != null ? username.equals(username2) : username2 == null) {
            return Arrays.equals(getPassword(), signInStartCommandParameters.getPassword());
        }
        return false;
    }

    @Nullable
    public char[] getPassword() {
        return this.password;
    }

    @NonNull
    public String getUsername() {
        return this.username;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String username = getUsername();
        return Arrays.hashCode(getPassword()) + (((iHashCode * 59) + (username == null ? 43 : username.hashCode())) * 59);
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("SignInStartCommandParameters(scopes=");
        sb.append(this.scopes);
        sb.append(", authenticationScheme=");
        sb.append(getAuthenticationScheme());
        sb.append(", authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("SignInStartCommandParameters(scopes=");
        sb.append(this.scopes);
        sb.append(", authenticationScheme=");
        sb.append(getAuthenticationScheme());
        sb.append(", username=");
        sb.append(this.username);
        sb.append(", authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignInStartCommandParametersBuilder<?, ?> toBuilder() {
        return new SignInStartCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SignInStartCommandParametersBuilder<C extends SignInStartCommandParameters, B extends SignInStartCommandParametersBuilder<C, B>> extends BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder<C, B> {
        private char[] password;
        private String username;

        private static void $fillValuesFromInstanceIntoBuilder(SignInStartCommandParameters signInStartCommandParameters, SignInStartCommandParametersBuilder<?, ?> signInStartCommandParametersBuilder) {
            signInStartCommandParametersBuilder.username(signInStartCommandParameters.username);
            signInStartCommandParametersBuilder.password(signInStartCommandParameters.password);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B password(@Nullable char[] cArr) {
            this.password = cArr;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "SignInStartCommandParameters.SignInStartCommandParametersBuilder(super=" + super.toString() + ", username=" + this.username + ", password=" + Arrays.toString(this.password) + ")";
        }

        public B username(@NonNull String str) {
            if (str == null) {
                throw new NullPointerException("username is marked non-null but is null");
            }
            this.username = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignInStartCommandParameters) c, (SignInStartCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SignInStartCommandParametersBuilderImpl extends SignInStartCommandParametersBuilder<SignInStartCommandParameters, SignInStartCommandParametersBuilderImpl> {
        private SignInStartCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInStartCommandParameters.SignInStartCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInStartCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInStartCommandParameters.SignInStartCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInStartCommandParameters build() {
            return new SignInStartCommandParameters(this);
        }
    }
}
