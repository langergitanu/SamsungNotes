package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;
import java.util.Map;
import javax.annotation.Nullable;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressFBWarnings({"EI_EXPOSE_REP2"})
public class SignUpStartCommandParameters extends BaseNativeAuthCommandParameters {
    private static final String TAG = "SignUpStartCommandParameters";

    @Nullable
    public final char[] password;

    @Nullable
    public final Map<String, String> userAttributes;

    @NonNull
    public final String username;

    public SignUpStartCommandParameters(SignUpStartCommandParametersBuilder<?, ?> signUpStartCommandParametersBuilder) {
        super(signUpStartCommandParametersBuilder);
        String str = ((SignUpStartCommandParametersBuilder) signUpStartCommandParametersBuilder).username;
        this.username = str;
        if (str == null) {
            throw new NullPointerException("username is marked non-null but is null");
        }
        this.userAttributes = ((SignUpStartCommandParametersBuilder) signUpStartCommandParametersBuilder).userAttributes;
        this.password = ((SignUpStartCommandParametersBuilder) signUpStartCommandParametersBuilder).password;
    }

    public static SignUpStartCommandParametersBuilder<?, ?> builder() {
        return new SignUpStartCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof SignUpStartCommandParameters;
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
        if (!(obj instanceof SignUpStartCommandParameters)) {
            return false;
        }
        SignUpStartCommandParameters signUpStartCommandParameters = (SignUpStartCommandParameters) obj;
        if (!signUpStartCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String username = getUsername();
        String username2 = signUpStartCommandParameters.getUsername();
        if (username != null ? username.equals(username2) : username2 == null) {
            return Arrays.equals(getPassword(), signUpStartCommandParameters.getPassword());
        }
        return false;
    }

    @Nullable
    public char[] getPassword() {
        return this.password;
    }

    @Nullable
    public Map<String, String> getUserAttributes() {
        return this.userAttributes;
    }

    @NonNull
    public String getUsername() {
        return this.username;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String username = getUsername();
        return Arrays.hashCode(getPassword()) + (((iHashCode * 59) + (username == null ? 43 : username.hashCode())) * 59);
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("SignUpStartCommandParameters(authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("SignUpStartCommandParameters(username=");
        sb.append(this.username);
        sb.append(", userAttributes=");
        sb.append(this.userAttributes);
        sb.append(", authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SignUpStartCommandParametersBuilder<C extends SignUpStartCommandParameters, B extends SignUpStartCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private char[] password;
        private Map<String, String> userAttributes;
        private String username;

        private static void $fillValuesFromInstanceIntoBuilder(SignUpStartCommandParameters signUpStartCommandParameters, SignUpStartCommandParametersBuilder<?, ?> signUpStartCommandParametersBuilder) {
            signUpStartCommandParametersBuilder.username(signUpStartCommandParameters.username);
            signUpStartCommandParametersBuilder.userAttributes(signUpStartCommandParameters.userAttributes);
            signUpStartCommandParametersBuilder.password(signUpStartCommandParameters.password);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B password(@Nullable char[] cArr) {
            this.password = cArr;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "SignUpStartCommandParameters.SignUpStartCommandParametersBuilder(super=" + super.toString() + ", username=" + this.username + ", userAttributes=" + this.userAttributes + ", password=" + Arrays.toString(this.password) + ")";
        }

        public B userAttributes(@Nullable Map<String, String> map) {
            this.userAttributes = map;
            return (B) self();
        }

        public B username(@NonNull String str) {
            if (str == null) {
                throw new NullPointerException("username is marked non-null but is null");
            }
            this.username = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SignUpStartCommandParameters) c, (SignUpStartCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SignUpStartCommandParametersBuilderImpl extends SignUpStartCommandParametersBuilder<SignUpStartCommandParameters, SignUpStartCommandParametersBuilderImpl> {
        private SignUpStartCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpStartCommandParameters.SignUpStartCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpStartCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpStartCommandParameters.SignUpStartCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SignUpStartCommandParameters build() {
            return new SignUpStartCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SignUpStartCommandParametersBuilder<?, ?> toBuilder() {
        return new SignUpStartCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
