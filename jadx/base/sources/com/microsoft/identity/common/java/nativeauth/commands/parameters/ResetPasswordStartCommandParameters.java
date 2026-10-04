package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ResetPasswordStartCommandParameters extends BaseNativeAuthCommandParameters {
    private static final String TAG = "ResetPasswordStartCommandParameters";

    @NonNull
    public final String username;

    public ResetPasswordStartCommandParameters(ResetPasswordStartCommandParametersBuilder<?, ?> resetPasswordStartCommandParametersBuilder) {
        super(resetPasswordStartCommandParametersBuilder);
        String str = ((ResetPasswordStartCommandParametersBuilder) resetPasswordStartCommandParametersBuilder).username;
        this.username = str;
        if (str == null) {
            throw new NullPointerException("username is marked non-null but is null");
        }
    }

    public static ResetPasswordStartCommandParametersBuilder<?, ?> builder() {
        return new ResetPasswordStartCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof ResetPasswordStartCommandParameters;
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
        if (!(obj instanceof ResetPasswordStartCommandParameters)) {
            return false;
        }
        ResetPasswordStartCommandParameters resetPasswordStartCommandParameters = (ResetPasswordStartCommandParameters) obj;
        if (!resetPasswordStartCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String username = getUsername();
        String username2 = resetPasswordStartCommandParameters.getUsername();
        return username != null ? username.equals(username2) : username2 == null;
    }

    @NonNull
    public String getUsername() {
        return this.username;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String username = getUsername();
        return (iHashCode * 59) + (username == null ? 43 : username.hashCode());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("ResetPasswordStartCommandParameters(authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("ResetPasswordStartCommandParameters(username=");
        sb.append(this.username);
        sb.append(", authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ResetPasswordStartCommandParametersBuilder<C extends ResetPasswordStartCommandParameters, B extends ResetPasswordStartCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private String username;

        private static void $fillValuesFromInstanceIntoBuilder(ResetPasswordStartCommandParameters resetPasswordStartCommandParameters, ResetPasswordStartCommandParametersBuilder<?, ?> resetPasswordStartCommandParametersBuilder) {
            resetPasswordStartCommandParametersBuilder.username(resetPasswordStartCommandParameters.username);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("ResetPasswordStartCommandParameters.ResetPasswordStartCommandParametersBuilder(super=");
            sb.append(super.toString());
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

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((ResetPasswordStartCommandParameters) c, (ResetPasswordStartCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ResetPasswordStartCommandParametersBuilderImpl extends ResetPasswordStartCommandParametersBuilder<ResetPasswordStartCommandParameters, ResetPasswordStartCommandParametersBuilderImpl> {
        private ResetPasswordStartCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordStartCommandParameters.ResetPasswordStartCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public ResetPasswordStartCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordStartCommandParameters.ResetPasswordStartCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public ResetPasswordStartCommandParameters build() {
            return new ResetPasswordStartCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public ResetPasswordStartCommandParametersBuilder<?, ?> toBuilder() {
        return new ResetPasswordStartCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
