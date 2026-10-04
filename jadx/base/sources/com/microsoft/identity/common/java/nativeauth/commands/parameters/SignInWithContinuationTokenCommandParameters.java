package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SignInWithContinuationTokenCommandParameters extends BaseSignInTokenCommandParameters {
    private static final String TAG = "SignInWithContinuationTokenCommandParameters";

    @NonNull
    public final String continuationToken;

    @NonNull
    public final String username;

    public SignInWithContinuationTokenCommandParameters(SignInWithContinuationTokenCommandParametersBuilder<?, ?> signInWithContinuationTokenCommandParametersBuilder) {
        super(signInWithContinuationTokenCommandParametersBuilder);
        String str = ((SignInWithContinuationTokenCommandParametersBuilder) signInWithContinuationTokenCommandParametersBuilder).continuationToken;
        this.continuationToken = str;
        if (str == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
        String str2 = ((SignInWithContinuationTokenCommandParametersBuilder) signInWithContinuationTokenCommandParametersBuilder).username;
        this.username = str2;
        if (str2 == null) {
            throw new NullPointerException("username is marked non-null but is null");
        }
    }

    public static SignInWithContinuationTokenCommandParametersBuilder<?, ?> builder() {
        return new SignInWithContinuationTokenCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof SignInWithContinuationTokenCommandParameters;
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
        if (!(obj instanceof SignInWithContinuationTokenCommandParameters)) {
            return false;
        }
        SignInWithContinuationTokenCommandParameters signInWithContinuationTokenCommandParameters = (SignInWithContinuationTokenCommandParameters) obj;
        if (!signInWithContinuationTokenCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = signInWithContinuationTokenCommandParameters.getContinuationToken();
        if (continuationToken != null ? !continuationToken.equals(continuationToken2) : continuationToken2 != null) {
            return false;
        }
        String username = getUsername();
        String username2 = signInWithContinuationTokenCommandParameters.getUsername();
        return username != null ? username.equals(username2) : username2 == null;
    }

    @NonNull
    public String getContinuationToken() {
        return this.continuationToken;
    }

    @NonNull
    public String getUsername() {
        return this.username;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String continuationToken = getContinuationToken();
        int iHashCode2 = (iHashCode * 59) + (continuationToken == null ? 43 : continuationToken.hashCode());
        String username = getUsername();
        return (iHashCode2 * 59) + (username != null ? username.hashCode() : 43);
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("SignInSubmitPasswordCommandParameters(authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("SignInSubmitPasswordCommandParameters(username=");
        sb.append(this.username);
        sb.append(", authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignInWithContinuationTokenCommandParametersBuilder<?, ?> toBuilder() {
        return new SignInWithContinuationTokenCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SignInWithContinuationTokenCommandParametersBuilder<C extends SignInWithContinuationTokenCommandParameters, B extends SignInWithContinuationTokenCommandParametersBuilder<C, B>> extends BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder<C, B> {
        private String continuationToken;
        private String username;

        private static void $fillValuesFromInstanceIntoBuilder(SignInWithContinuationTokenCommandParameters signInWithContinuationTokenCommandParameters, SignInWithContinuationTokenCommandParametersBuilder<?, ?> signInWithContinuationTokenCommandParametersBuilder) {
            signInWithContinuationTokenCommandParametersBuilder.continuationToken(signInWithContinuationTokenCommandParameters.continuationToken);
            signInWithContinuationTokenCommandParametersBuilder.username(signInWithContinuationTokenCommandParameters.username);
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

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("SignInWithContinuationTokenCommandParameters.SignInWithContinuationTokenCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", continuationToken=");
            sb.append(this.continuationToken);
            sb.append(", username=");
            return AbstractC0622a.m1170p(this.username, ")", sb);
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
            $fillValuesFromInstanceIntoBuilder((SignInWithContinuationTokenCommandParameters) c, (SignInWithContinuationTokenCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SignInWithContinuationTokenCommandParametersBuilderImpl extends SignInWithContinuationTokenCommandParametersBuilder<SignInWithContinuationTokenCommandParameters, SignInWithContinuationTokenCommandParametersBuilderImpl> {
        private SignInWithContinuationTokenCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInWithContinuationTokenCommandParameters.SignInWithContinuationTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInWithContinuationTokenCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInWithContinuationTokenCommandParameters.SignInWithContinuationTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters.BaseSignInTokenCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignInWithContinuationTokenCommandParameters build() {
            return new SignInWithContinuationTokenCommandParameters(this);
        }
    }
}
