package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.authorities.NativeAuthCIAMAuthority;
import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseNativeAuthCommandParameters extends CommandParameters implements ILoggable {
    private static final String TAG = "BaseNativeAuthCommandParameters";
    public final NativeAuthCIAMAuthority authority;

    @Nullable
    public final List<String> challengeType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class BaseNativeAuthCommandParametersBuilder<C extends BaseNativeAuthCommandParameters, B extends BaseNativeAuthCommandParametersBuilder<C, B>> extends CommandParameters.CommandParametersBuilder<C, B> {
        private NativeAuthCIAMAuthority authority;
        private List<String> challengeType;

        private static void $fillValuesFromInstanceIntoBuilder(BaseNativeAuthCommandParameters baseNativeAuthCommandParameters, BaseNativeAuthCommandParametersBuilder<?, ?> baseNativeAuthCommandParametersBuilder) {
            baseNativeAuthCommandParametersBuilder.authority(baseNativeAuthCommandParameters.authority);
            baseNativeAuthCommandParametersBuilder.challengeType(baseNativeAuthCommandParameters.challengeType);
        }

        public B authority(NativeAuthCIAMAuthority nativeAuthCIAMAuthority) {
            this.authority = nativeAuthCIAMAuthority;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B challengeType(@Nullable List<String> list) {
            this.challengeType = list;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", authority=");
            sb.append(this.authority);
            sb.append(", challengeType=");
            return AbstractC0541b.m777s(sb, this.challengeType, ")");
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((BaseNativeAuthCommandParameters) c, (BaseNativeAuthCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    public BaseNativeAuthCommandParameters(BaseNativeAuthCommandParametersBuilder<?, ?> baseNativeAuthCommandParametersBuilder) {
        super(baseNativeAuthCommandParametersBuilder);
        this.authority = ((BaseNativeAuthCommandParametersBuilder) baseNativeAuthCommandParametersBuilder).authority;
        this.challengeType = ((BaseNativeAuthCommandParametersBuilder) baseNativeAuthCommandParametersBuilder).challengeType;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof BaseNativeAuthCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseNativeAuthCommandParameters)) {
            return false;
        }
        BaseNativeAuthCommandParameters baseNativeAuthCommandParameters = (BaseNativeAuthCommandParameters) obj;
        if (!baseNativeAuthCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        NativeAuthCIAMAuthority authority = getAuthority();
        NativeAuthCIAMAuthority authority2 = baseNativeAuthCommandParameters.getAuthority();
        if (authority != null ? !authority.equals(authority2) : authority2 != null) {
            return false;
        }
        List<String> challengeType = getChallengeType();
        List<String> challengeType2 = baseNativeAuthCommandParameters.getChallengeType();
        return challengeType != null ? challengeType.equals(challengeType2) : challengeType2 == null;
    }

    public NativeAuthCIAMAuthority getAuthority() {
        return this.authority;
    }

    @Nullable
    public List<String> getChallengeType() {
        return this.challengeType;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        NativeAuthCIAMAuthority authority = getAuthority();
        int iHashCode2 = (iHashCode * 59) + (authority == null ? 43 : authority.hashCode());
        List<String> challengeType = getChallengeType();
        return (iHashCode2 * 59) + (challengeType != null ? challengeType.hashCode() : 43);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public void logParameters(String str, String str2) {
        Logger.infoWithObject(str, null, str2, this);
    }
}
