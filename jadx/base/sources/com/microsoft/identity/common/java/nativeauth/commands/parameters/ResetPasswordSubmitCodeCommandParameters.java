package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ResetPasswordSubmitCodeCommandParameters extends BaseNativeAuthCommandParameters {

    @NonNull
    public final String code;

    @NonNull
    public final String continuationToken;

    public ResetPasswordSubmitCodeCommandParameters(ResetPasswordSubmitCodeCommandParametersBuilder<?, ?> resetPasswordSubmitCodeCommandParametersBuilder) {
        super(resetPasswordSubmitCodeCommandParametersBuilder);
        String str = ((ResetPasswordSubmitCodeCommandParametersBuilder) resetPasswordSubmitCodeCommandParametersBuilder).code;
        this.code = str;
        if (str == null) {
            throw new NullPointerException("code is marked non-null but is null");
        }
        String str2 = ((ResetPasswordSubmitCodeCommandParametersBuilder) resetPasswordSubmitCodeCommandParametersBuilder).continuationToken;
        this.continuationToken = str2;
        if (str2 == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static ResetPasswordSubmitCodeCommandParametersBuilder<?, ?> builder() {
        return new ResetPasswordSubmitCodeCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof ResetPasswordSubmitCodeCommandParameters;
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
        if (!(obj instanceof ResetPasswordSubmitCodeCommandParameters)) {
            return false;
        }
        ResetPasswordSubmitCodeCommandParameters resetPasswordSubmitCodeCommandParameters = (ResetPasswordSubmitCodeCommandParameters) obj;
        if (!resetPasswordSubmitCodeCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String code = getCode();
        String code2 = resetPasswordSubmitCodeCommandParameters.getCode();
        if (code != null ? !code.equals(code2) : code2 != null) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = resetPasswordSubmitCodeCommandParameters.getContinuationToken();
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

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
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
        StringBuilder sb = new StringBuilder("ResetPasswordSubmitCodeCommandParameters(authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ResetPasswordSubmitCodeCommandParametersBuilder<C extends ResetPasswordSubmitCodeCommandParameters, B extends ResetPasswordSubmitCodeCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private String code;
        private String continuationToken;

        private static void $fillValuesFromInstanceIntoBuilder(ResetPasswordSubmitCodeCommandParameters resetPasswordSubmitCodeCommandParameters, ResetPasswordSubmitCodeCommandParametersBuilder<?, ?> resetPasswordSubmitCodeCommandParametersBuilder) {
            resetPasswordSubmitCodeCommandParametersBuilder.code(resetPasswordSubmitCodeCommandParameters.code);
            resetPasswordSubmitCodeCommandParametersBuilder.continuationToken(resetPasswordSubmitCodeCommandParameters.continuationToken);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
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

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("ResetPasswordSubmitCodeCommandParameters.ResetPasswordSubmitCodeCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", code=");
            sb.append(this.code);
            sb.append(", continuationToken=");
            return AbstractC0622a.m1170p(this.continuationToken, ")", sb);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((ResetPasswordSubmitCodeCommandParameters) c, (ResetPasswordSubmitCodeCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ResetPasswordSubmitCodeCommandParametersBuilderImpl extends ResetPasswordSubmitCodeCommandParametersBuilder<ResetPasswordSubmitCodeCommandParameters, ResetPasswordSubmitCodeCommandParametersBuilderImpl> {
        private ResetPasswordSubmitCodeCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitCodeCommandParameters.ResetPasswordSubmitCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public ResetPasswordSubmitCodeCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitCodeCommandParameters.ResetPasswordSubmitCodeCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public ResetPasswordSubmitCodeCommandParameters build() {
            return new ResetPasswordSubmitCodeCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public ResetPasswordSubmitCodeCommandParametersBuilder<?, ?> toBuilder() {
        return new ResetPasswordSubmitCodeCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
