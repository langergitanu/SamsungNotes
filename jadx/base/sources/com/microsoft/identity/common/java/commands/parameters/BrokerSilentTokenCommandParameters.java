package com.microsoft.identity.common.java.commands.parameters;

import androidx.collection.AbstractC0622a;
import com.google.gson.annotations.Expose;
import com.microsoft.identity.common.java.broker.IBrokerAccount;
import com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.request.BrokerRequestType;
import com.microsoft.identity.common.java.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrokerSilentTokenCommandParameters extends SilentTokenCommandParameters implements IBrokerTokenCommandParameters {
    private final IBrokerAccount brokerAccount;

    @Expose
    private final String brokerVersion;

    @Expose
    private final String callerAppVersion;

    @Expose
    private final int callerUid;
    private final String homeAccountId;

    @Expose
    private final String homeTenantId;
    private final String localAccountId;

    @Expose
    private final String negotiatedBrokerProtocolVersion;

    @Expose
    private final boolean pKeyAuthHeaderAllowed;

    @Expose
    private final BrokerRequestType requestType;
    private final int sleepTimeBeforePrtAcquisition;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class BrokerSilentTokenCommandParametersBuilder<C extends BrokerSilentTokenCommandParameters, B extends BrokerSilentTokenCommandParametersBuilder<C, B>> extends SilentTokenCommandParameters.SilentTokenCommandParametersBuilder<C, B> {
        private IBrokerAccount brokerAccount;
        private String brokerVersion;
        private String callerAppVersion;
        private int callerUid;
        private String homeAccountId;
        private String homeTenantId;
        private String localAccountId;
        private String negotiatedBrokerProtocolVersion;
        private boolean pKeyAuthHeaderAllowed;
        private BrokerRequestType requestType;
        private int sleepTimeBeforePrtAcquisition;

        private static void $fillValuesFromInstanceIntoBuilder(BrokerSilentTokenCommandParameters brokerSilentTokenCommandParameters, BrokerSilentTokenCommandParametersBuilder<?, ?> brokerSilentTokenCommandParametersBuilder) {
            brokerSilentTokenCommandParametersBuilder.callerUid(brokerSilentTokenCommandParameters.callerUid);
            brokerSilentTokenCommandParametersBuilder.callerAppVersion(brokerSilentTokenCommandParameters.callerAppVersion);
            brokerSilentTokenCommandParametersBuilder.brokerVersion(brokerSilentTokenCommandParameters.brokerVersion);
            brokerSilentTokenCommandParametersBuilder.brokerAccount(brokerSilentTokenCommandParameters.brokerAccount);
            brokerSilentTokenCommandParametersBuilder.homeAccountId(brokerSilentTokenCommandParameters.homeAccountId);
            brokerSilentTokenCommandParametersBuilder.localAccountId(brokerSilentTokenCommandParameters.localAccountId);
            brokerSilentTokenCommandParametersBuilder.sleepTimeBeforePrtAcquisition(brokerSilentTokenCommandParameters.sleepTimeBeforePrtAcquisition);
            brokerSilentTokenCommandParametersBuilder.negotiatedBrokerProtocolVersion(brokerSilentTokenCommandParameters.negotiatedBrokerProtocolVersion);
            brokerSilentTokenCommandParametersBuilder.pKeyAuthHeaderAllowed(brokerSilentTokenCommandParameters.pKeyAuthHeaderAllowed);
            brokerSilentTokenCommandParametersBuilder.requestType(brokerSilentTokenCommandParameters.requestType);
            brokerSilentTokenCommandParametersBuilder.homeTenantId(brokerSilentTokenCommandParameters.homeTenantId);
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters.SilentTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((BrokerSilentTokenCommandParameters) c, (BrokerSilentTokenCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B brokerAccount(IBrokerAccount iBrokerAccount) {
            this.brokerAccount = iBrokerAccount;
            return (B) self();
        }

        public B brokerVersion(String str) {
            this.brokerVersion = str;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters.SilentTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B callerAppVersion(String str) {
            this.callerAppVersion = str;
            return (B) self();
        }

        public B callerUid(int i) {
            this.callerUid = i;
            return (B) self();
        }

        public B homeAccountId(String str) {
            this.homeAccountId = str;
            return (B) self();
        }

        public B homeTenantId(String str) {
            this.homeTenantId = str;
            return (B) self();
        }

        public B localAccountId(String str) {
            this.localAccountId = str;
            return (B) self();
        }

        public B negotiatedBrokerProtocolVersion(String str) {
            this.negotiatedBrokerProtocolVersion = str;
            return (B) self();
        }

        public B pKeyAuthHeaderAllowed(boolean z) {
            this.pKeyAuthHeaderAllowed = z;
            return (B) self();
        }

        public B requestType(BrokerRequestType brokerRequestType) {
            this.requestType = brokerRequestType;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters.SilentTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        public B sleepTimeBeforePrtAcquisition(int i) {
            this.sleepTimeBeforePrtAcquisition = i;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters.SilentTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("BrokerSilentTokenCommandParameters.BrokerSilentTokenCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", callerUid=");
            sb.append(this.callerUid);
            sb.append(", callerAppVersion=");
            sb.append(this.callerAppVersion);
            sb.append(", brokerVersion=");
            sb.append(this.brokerVersion);
            sb.append(", brokerAccount=");
            sb.append(this.brokerAccount);
            sb.append(", homeAccountId=");
            sb.append(this.homeAccountId);
            sb.append(", localAccountId=");
            sb.append(this.localAccountId);
            sb.append(", sleepTimeBeforePrtAcquisition=");
            sb.append(this.sleepTimeBeforePrtAcquisition);
            sb.append(", negotiatedBrokerProtocolVersion=");
            sb.append(this.negotiatedBrokerProtocolVersion);
            sb.append(", pKeyAuthHeaderAllowed=");
            sb.append(this.pKeyAuthHeaderAllowed);
            sb.append(", requestType=");
            sb.append(this.requestType);
            sb.append(", homeTenantId=");
            return AbstractC0622a.m1170p(this.homeTenantId, ")", sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class BrokerSilentTokenCommandParametersBuilderImpl extends BrokerSilentTokenCommandParametersBuilder<BrokerSilentTokenCommandParameters, BrokerSilentTokenCommandParametersBuilderImpl> {
        private BrokerSilentTokenCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.BrokerSilentTokenCommandParameters.BrokerSilentTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters.SilentTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public BrokerSilentTokenCommandParameters build() {
            return new BrokerSilentTokenCommandParameters(this);
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.BrokerSilentTokenCommandParameters.BrokerSilentTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters.SilentTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public BrokerSilentTokenCommandParametersBuilderImpl self() {
            return this;
        }
    }

    public BrokerSilentTokenCommandParameters(BrokerSilentTokenCommandParametersBuilder<?, ?> brokerSilentTokenCommandParametersBuilder) {
        super(brokerSilentTokenCommandParametersBuilder);
        this.callerUid = ((BrokerSilentTokenCommandParametersBuilder) brokerSilentTokenCommandParametersBuilder).callerUid;
        this.callerAppVersion = ((BrokerSilentTokenCommandParametersBuilder) brokerSilentTokenCommandParametersBuilder).callerAppVersion;
        this.brokerVersion = ((BrokerSilentTokenCommandParametersBuilder) brokerSilentTokenCommandParametersBuilder).brokerVersion;
        this.brokerAccount = ((BrokerSilentTokenCommandParametersBuilder) brokerSilentTokenCommandParametersBuilder).brokerAccount;
        this.homeAccountId = ((BrokerSilentTokenCommandParametersBuilder) brokerSilentTokenCommandParametersBuilder).homeAccountId;
        this.localAccountId = ((BrokerSilentTokenCommandParametersBuilder) brokerSilentTokenCommandParametersBuilder).localAccountId;
        this.sleepTimeBeforePrtAcquisition = ((BrokerSilentTokenCommandParametersBuilder) brokerSilentTokenCommandParametersBuilder).sleepTimeBeforePrtAcquisition;
        this.negotiatedBrokerProtocolVersion = ((BrokerSilentTokenCommandParametersBuilder) brokerSilentTokenCommandParametersBuilder).negotiatedBrokerProtocolVersion;
        this.pKeyAuthHeaderAllowed = ((BrokerSilentTokenCommandParametersBuilder) brokerSilentTokenCommandParametersBuilder).pKeyAuthHeaderAllowed;
        this.requestType = ((BrokerSilentTokenCommandParametersBuilder) brokerSilentTokenCommandParametersBuilder).requestType;
        this.homeTenantId = ((BrokerSilentTokenCommandParametersBuilder) brokerSilentTokenCommandParametersBuilder).homeTenantId;
    }

    public static BrokerSilentTokenCommandParametersBuilder<?, ?> builder() {
        return new BrokerSilentTokenCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof BrokerSilentTokenCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BrokerSilentTokenCommandParameters)) {
            return false;
        }
        BrokerSilentTokenCommandParameters brokerSilentTokenCommandParameters = (BrokerSilentTokenCommandParameters) obj;
        if (!brokerSilentTokenCommandParameters.canEqual(this) || !super.equals(obj) || getCallerUid() != brokerSilentTokenCommandParameters.getCallerUid() || getSleepTimeBeforePrtAcquisition() != brokerSilentTokenCommandParameters.getSleepTimeBeforePrtAcquisition() || isPKeyAuthHeaderAllowed() != brokerSilentTokenCommandParameters.isPKeyAuthHeaderAllowed()) {
            return false;
        }
        String callerAppVersion = getCallerAppVersion();
        String callerAppVersion2 = brokerSilentTokenCommandParameters.getCallerAppVersion();
        if (callerAppVersion != null ? !callerAppVersion.equals(callerAppVersion2) : callerAppVersion2 != null) {
            return false;
        }
        String brokerVersion = getBrokerVersion();
        String brokerVersion2 = brokerSilentTokenCommandParameters.getBrokerVersion();
        if (brokerVersion != null ? !brokerVersion.equals(brokerVersion2) : brokerVersion2 != null) {
            return false;
        }
        IBrokerAccount brokerAccount = getBrokerAccount();
        IBrokerAccount brokerAccount2 = brokerSilentTokenCommandParameters.getBrokerAccount();
        if (brokerAccount != null ? !brokerAccount.equals(brokerAccount2) : brokerAccount2 != null) {
            return false;
        }
        String homeAccountId = getHomeAccountId();
        String homeAccountId2 = brokerSilentTokenCommandParameters.getHomeAccountId();
        if (homeAccountId != null ? !homeAccountId.equals(homeAccountId2) : homeAccountId2 != null) {
            return false;
        }
        String localAccountId = getLocalAccountId();
        String localAccountId2 = brokerSilentTokenCommandParameters.getLocalAccountId();
        if (localAccountId != null ? !localAccountId.equals(localAccountId2) : localAccountId2 != null) {
            return false;
        }
        String negotiatedBrokerProtocolVersion = getNegotiatedBrokerProtocolVersion();
        String negotiatedBrokerProtocolVersion2 = brokerSilentTokenCommandParameters.getNegotiatedBrokerProtocolVersion();
        if (negotiatedBrokerProtocolVersion != null ? !negotiatedBrokerProtocolVersion.equals(negotiatedBrokerProtocolVersion2) : negotiatedBrokerProtocolVersion2 != null) {
            return false;
        }
        BrokerRequestType requestType = getRequestType();
        BrokerRequestType requestType2 = brokerSilentTokenCommandParameters.getRequestType();
        if (requestType != null ? !requestType.equals(requestType2) : requestType2 != null) {
            return false;
        }
        String homeTenantId = getHomeTenantId();
        String homeTenantId2 = brokerSilentTokenCommandParameters.getHomeTenantId();
        return homeTenantId != null ? homeTenantId.equals(homeTenantId2) : homeTenantId2 == null;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public IBrokerAccount getBrokerAccount() {
        return this.brokerAccount;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public String getBrokerVersion() {
        return this.brokerVersion;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public String getCallerAppVersion() {
        return this.callerAppVersion;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public int getCallerUid() {
        return this.callerUid;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public String getHomeAccountId() {
        return this.homeAccountId;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public String getHomeTenantId() {
        return this.homeTenantId;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public String getLocalAccountId() {
        return this.localAccountId;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public String getNegotiatedBrokerProtocolVersion() {
        return this.negotiatedBrokerProtocolVersion;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IBrokerTokenCommandParameters
    public BrokerRequestType getRequestType() {
        return this.requestType;
    }

    public int getSleepTimeBeforePrtAcquisition() {
        return this.sleepTimeBeforePrtAcquisition;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int sleepTimeBeforePrtAcquisition = ((getSleepTimeBeforePrtAcquisition() + ((getCallerUid() + (super.hashCode() * 59)) * 59)) * 59) + (isPKeyAuthHeaderAllowed() ? 79 : 97);
        String callerAppVersion = getCallerAppVersion();
        int iHashCode = (sleepTimeBeforePrtAcquisition * 59) + (callerAppVersion == null ? 43 : callerAppVersion.hashCode());
        String brokerVersion = getBrokerVersion();
        int iHashCode2 = (iHashCode * 59) + (brokerVersion == null ? 43 : brokerVersion.hashCode());
        IBrokerAccount brokerAccount = getBrokerAccount();
        int iHashCode3 = (iHashCode2 * 59) + (brokerAccount == null ? 43 : brokerAccount.hashCode());
        String homeAccountId = getHomeAccountId();
        int iHashCode4 = (iHashCode3 * 59) + (homeAccountId == null ? 43 : homeAccountId.hashCode());
        String localAccountId = getLocalAccountId();
        int iHashCode5 = (iHashCode4 * 59) + (localAccountId == null ? 43 : localAccountId.hashCode());
        String negotiatedBrokerProtocolVersion = getNegotiatedBrokerProtocolVersion();
        int iHashCode6 = (iHashCode5 * 59) + (negotiatedBrokerProtocolVersion == null ? 43 : negotiatedBrokerProtocolVersion.hashCode());
        BrokerRequestType requestType = getRequestType();
        int iHashCode7 = (iHashCode6 * 59) + (requestType == null ? 43 : requestType.hashCode());
        String homeTenantId = getHomeTenantId();
        return (iHashCode7 * 59) + (homeTenantId != null ? homeTenantId.hashCode() : 43);
    }

    public boolean isPKeyAuthHeaderAllowed() {
        return this.pKeyAuthHeaderAllowed;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters
    public void validate() throws ArgumentException {
        if (this.callerUid == 0) {
            throw new ArgumentException("acquireTokenSilent", "mCallerUId", "Caller Uid is not set");
        }
        if (getAuthority() == null) {
            throw new ArgumentException("acquireTokenSilent", "mAuthority", "Authority Url is not set");
        }
        if (getScopes() == null || getScopes().isEmpty()) {
            throw new ArgumentException("acquireTokenSilent", "mScopes", "Scope or resource is not set");
        }
        if (StringUtil.isNullOrEmpty(getClientId())) {
            throw new ArgumentException("acquireTokenSilent", "mClientId", "Client Id is not set");
        }
        if (!getPlatformComponents().getPlatformUtil().isValidCallingApp(getRedirectUri(), getCallerPackageName())) {
            throw new ArgumentException("acquireTokenSilent", "mRedirectUri", "The redirect URI doesn't match the uri generated with caller package name and signature");
        }
        if (!(getOAuth2TokenCache() instanceof BrokerOAuth2TokenCache)) {
            throw new ArgumentException("acquireTokenSilent", "AcquireTokenSilentOperationParameters", "OAuth2Cache not an instance of BrokerOAuth2TokenCache");
        }
        if (this.brokerAccount == null) {
            throw new ArgumentException("acquireTokenSilent", "mCallerPackageName", "Broker Account is null");
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public BrokerSilentTokenCommandParametersBuilder<?, ?> toBuilder() {
        return new BrokerSilentTokenCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
