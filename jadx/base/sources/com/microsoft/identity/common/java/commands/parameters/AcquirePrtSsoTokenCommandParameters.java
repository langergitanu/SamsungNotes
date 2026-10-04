package com.microsoft.identity.common.java.commands.parameters;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AcquirePrtSsoTokenCommandParameters extends CommandParameters {
    private final String mAccountName;
    private final String mHomeAccountId;
    private final String mLocalAccountId;
    private final String mRequestAuthority;
    private final String mSsoUrl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AcquirePrtSsoTokenCommandParametersBuilder<C extends AcquirePrtSsoTokenCommandParameters, B extends AcquirePrtSsoTokenCommandParametersBuilder<C, B>> extends CommandParameters.CommandParametersBuilder<C, B> {
        private String accountName;
        private String homeAccountId;
        private String localAccountId;
        private String requestAuthority;
        private String ssoUrl;

        private static void $fillValuesFromInstanceIntoBuilder(AcquirePrtSsoTokenCommandParameters acquirePrtSsoTokenCommandParameters, AcquirePrtSsoTokenCommandParametersBuilder<?, ?> acquirePrtSsoTokenCommandParametersBuilder) {
            acquirePrtSsoTokenCommandParametersBuilder.homeAccountId(acquirePrtSsoTokenCommandParameters.mHomeAccountId);
            acquirePrtSsoTokenCommandParametersBuilder.localAccountId(acquirePrtSsoTokenCommandParameters.mLocalAccountId);
            acquirePrtSsoTokenCommandParametersBuilder.accountName(acquirePrtSsoTokenCommandParameters.mAccountName);
            acquirePrtSsoTokenCommandParametersBuilder.ssoUrl(acquirePrtSsoTokenCommandParameters.mSsoUrl);
            acquirePrtSsoTokenCommandParametersBuilder.requestAuthority(acquirePrtSsoTokenCommandParameters.mRequestAuthority);
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((AcquirePrtSsoTokenCommandParameters) c, (AcquirePrtSsoTokenCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B accountName(String str) {
            this.accountName = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B homeAccountId(String str) {
            this.homeAccountId = str;
            return (B) self();
        }

        public B localAccountId(String str) {
            this.localAccountId = str;
            return (B) self();
        }

        public B requestAuthority(String str) {
            this.requestAuthority = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        public B ssoUrl(String str) {
            this.ssoUrl = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("AcquirePrtSsoTokenCommandParameters.AcquirePrtSsoTokenCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", homeAccountId=");
            sb.append(this.homeAccountId);
            sb.append(", localAccountId=");
            sb.append(this.localAccountId);
            sb.append(", accountName=");
            sb.append(this.accountName);
            sb.append(", ssoUrl=");
            sb.append(this.ssoUrl);
            sb.append(", requestAuthority=");
            return AbstractC0622a.m1170p(this.requestAuthority, ")", sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class AcquirePrtSsoTokenCommandParametersBuilderImpl extends AcquirePrtSsoTokenCommandParametersBuilder<AcquirePrtSsoTokenCommandParameters, AcquirePrtSsoTokenCommandParametersBuilderImpl> {
        private AcquirePrtSsoTokenCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.AcquirePrtSsoTokenCommandParameters.AcquirePrtSsoTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public AcquirePrtSsoTokenCommandParameters build() {
            return new AcquirePrtSsoTokenCommandParameters(this);
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.AcquirePrtSsoTokenCommandParameters.AcquirePrtSsoTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public AcquirePrtSsoTokenCommandParametersBuilderImpl self() {
            return this;
        }
    }

    public AcquirePrtSsoTokenCommandParameters(AcquirePrtSsoTokenCommandParametersBuilder<?, ?> acquirePrtSsoTokenCommandParametersBuilder) {
        super(acquirePrtSsoTokenCommandParametersBuilder);
        this.mHomeAccountId = ((AcquirePrtSsoTokenCommandParametersBuilder) acquirePrtSsoTokenCommandParametersBuilder).homeAccountId;
        this.mLocalAccountId = ((AcquirePrtSsoTokenCommandParametersBuilder) acquirePrtSsoTokenCommandParametersBuilder).localAccountId;
        this.mAccountName = ((AcquirePrtSsoTokenCommandParametersBuilder) acquirePrtSsoTokenCommandParametersBuilder).accountName;
        this.mSsoUrl = ((AcquirePrtSsoTokenCommandParametersBuilder) acquirePrtSsoTokenCommandParametersBuilder).ssoUrl;
        this.mRequestAuthority = ((AcquirePrtSsoTokenCommandParametersBuilder) acquirePrtSsoTokenCommandParametersBuilder).requestAuthority;
    }

    public static AcquirePrtSsoTokenCommandParametersBuilder<?, ?> builder() {
        return new AcquirePrtSsoTokenCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof AcquirePrtSsoTokenCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AcquirePrtSsoTokenCommandParameters)) {
            return false;
        }
        AcquirePrtSsoTokenCommandParameters acquirePrtSsoTokenCommandParameters = (AcquirePrtSsoTokenCommandParameters) obj;
        if (!acquirePrtSsoTokenCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String homeAccountId = getHomeAccountId();
        String homeAccountId2 = acquirePrtSsoTokenCommandParameters.getHomeAccountId();
        if (homeAccountId != null ? !homeAccountId.equals(homeAccountId2) : homeAccountId2 != null) {
            return false;
        }
        String localAccountId = getLocalAccountId();
        String localAccountId2 = acquirePrtSsoTokenCommandParameters.getLocalAccountId();
        if (localAccountId != null ? !localAccountId.equals(localAccountId2) : localAccountId2 != null) {
            return false;
        }
        String accountName = getAccountName();
        String accountName2 = acquirePrtSsoTokenCommandParameters.getAccountName();
        if (accountName != null ? !accountName.equals(accountName2) : accountName2 != null) {
            return false;
        }
        String ssoUrl = getSsoUrl();
        String ssoUrl2 = acquirePrtSsoTokenCommandParameters.getSsoUrl();
        if (ssoUrl != null ? !ssoUrl.equals(ssoUrl2) : ssoUrl2 != null) {
            return false;
        }
        String requestAuthority = getRequestAuthority();
        String requestAuthority2 = acquirePrtSsoTokenCommandParameters.getRequestAuthority();
        return requestAuthority != null ? requestAuthority.equals(requestAuthority2) : requestAuthority2 == null;
    }

    public String getAccountName() {
        return this.mAccountName;
    }

    public String getHomeAccountId() {
        return this.mHomeAccountId;
    }

    public String getLocalAccountId() {
        return this.mLocalAccountId;
    }

    public String getRequestAuthority() {
        return this.mRequestAuthority;
    }

    public String getSsoUrl() {
        return this.mSsoUrl;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        String homeAccountId = getHomeAccountId();
        int iHashCode2 = (iHashCode * 59) + (homeAccountId == null ? 43 : homeAccountId.hashCode());
        String localAccountId = getLocalAccountId();
        int iHashCode3 = (iHashCode2 * 59) + (localAccountId == null ? 43 : localAccountId.hashCode());
        String accountName = getAccountName();
        int iHashCode4 = (iHashCode3 * 59) + (accountName == null ? 43 : accountName.hashCode());
        String ssoUrl = getSsoUrl();
        int iHashCode5 = (iHashCode4 * 59) + (ssoUrl == null ? 43 : ssoUrl.hashCode());
        String requestAuthority = getRequestAuthority();
        return (iHashCode5 * 59) + (requestAuthority != null ? requestAuthority.hashCode() : 43);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public AcquirePrtSsoTokenCommandParametersBuilder<?, ?> toBuilder() {
        return new AcquirePrtSsoTokenCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
