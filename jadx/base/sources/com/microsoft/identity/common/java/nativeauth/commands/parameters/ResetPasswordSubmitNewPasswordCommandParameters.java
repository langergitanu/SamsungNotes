package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressFBWarnings({"EI_EXPOSE_REP2"})
public class ResetPasswordSubmitNewPasswordCommandParameters extends BaseNativeAuthCommandParameters {
    private static final String TAG = "ResetPasswordSubmitNewPasswordCommandParameters";

    @NonNull
    public final String continuationToken;

    @NonNull
    public final char[] newPassword;

    public ResetPasswordSubmitNewPasswordCommandParameters(ResetPasswordSubmitNewPasswordCommandParametersBuilder<?, ?> resetPasswordSubmitNewPasswordCommandParametersBuilder) {
        super(resetPasswordSubmitNewPasswordCommandParametersBuilder);
        char[] cArr = ((ResetPasswordSubmitNewPasswordCommandParametersBuilder) resetPasswordSubmitNewPasswordCommandParametersBuilder).newPassword;
        this.newPassword = cArr;
        if (cArr == null) {
            throw new NullPointerException("newPassword is marked non-null but is null");
        }
        String str = ((ResetPasswordSubmitNewPasswordCommandParametersBuilder) resetPasswordSubmitNewPasswordCommandParametersBuilder).continuationToken;
        this.continuationToken = str;
        if (str == null) {
            throw new NullPointerException("continuationToken is marked non-null but is null");
        }
    }

    public static ResetPasswordSubmitNewPasswordCommandParametersBuilder<?, ?> builder() {
        return new ResetPasswordSubmitNewPasswordCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof ResetPasswordSubmitNewPasswordCommandParameters;
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
        if (!(obj instanceof ResetPasswordSubmitNewPasswordCommandParameters)) {
            return false;
        }
        ResetPasswordSubmitNewPasswordCommandParameters resetPasswordSubmitNewPasswordCommandParameters = (ResetPasswordSubmitNewPasswordCommandParameters) obj;
        if (!resetPasswordSubmitNewPasswordCommandParameters.canEqual(this) || !super.equals(obj) || !Arrays.equals(getNewPassword(), resetPasswordSubmitNewPasswordCommandParameters.getNewPassword())) {
            return false;
        }
        String continuationToken = getContinuationToken();
        String continuationToken2 = resetPasswordSubmitNewPasswordCommandParameters.getContinuationToken();
        return continuationToken != null ? continuationToken.equals(continuationToken2) : continuationToken2 == null;
    }

    @NonNull
    public String getContinuationToken() {
        return this.continuationToken;
    }

    @NonNull
    public char[] getNewPassword() {
        return this.newPassword;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = Arrays.hashCode(getNewPassword()) + (super.hashCode() * 59);
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
        StringBuilder sb = new StringBuilder("ResetPasswordSubmitNewPasswordCommandParameters(authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ResetPasswordSubmitNewPasswordCommandParametersBuilder<C extends ResetPasswordSubmitNewPasswordCommandParameters, B extends ResetPasswordSubmitNewPasswordCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private String continuationToken;
        private char[] newPassword;

        private static void $fillValuesFromInstanceIntoBuilder(ResetPasswordSubmitNewPasswordCommandParameters resetPasswordSubmitNewPasswordCommandParameters, ResetPasswordSubmitNewPasswordCommandParametersBuilder<?, ?> resetPasswordSubmitNewPasswordCommandParametersBuilder) {
            resetPasswordSubmitNewPasswordCommandParametersBuilder.newPassword(resetPasswordSubmitNewPasswordCommandParameters.newPassword);
            resetPasswordSubmitNewPasswordCommandParametersBuilder.continuationToken(resetPasswordSubmitNewPasswordCommandParameters.continuationToken);
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

        public B newPassword(@NonNull char[] cArr) {
            if (cArr == null) {
                throw new NullPointerException("newPassword is marked non-null but is null");
            }
            this.newPassword = cArr;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("ResetPasswordSubmitNewPasswordCommandParameters.ResetPasswordSubmitNewPasswordCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", newPassword=");
            sb.append(Arrays.toString(this.newPassword));
            sb.append(", continuationToken=");
            return AbstractC0622a.m1170p(this.continuationToken, ")", sb);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((ResetPasswordSubmitNewPasswordCommandParameters) c, (ResetPasswordSubmitNewPasswordCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ResetPasswordSubmitNewPasswordCommandParametersBuilderImpl extends ResetPasswordSubmitNewPasswordCommandParametersBuilder<ResetPasswordSubmitNewPasswordCommandParameters, ResetPasswordSubmitNewPasswordCommandParametersBuilderImpl> {
        private ResetPasswordSubmitNewPasswordCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitNewPasswordCommandParameters.ResetPasswordSubmitNewPasswordCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public ResetPasswordSubmitNewPasswordCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitNewPasswordCommandParameters.ResetPasswordSubmitNewPasswordCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public ResetPasswordSubmitNewPasswordCommandParameters build() {
            return new ResetPasswordSubmitNewPasswordCommandParameters(this);
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public ResetPasswordSubmitNewPasswordCommandParametersBuilder<?, ?> toBuilder() {
        return new ResetPasswordSubmitNewPasswordCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
