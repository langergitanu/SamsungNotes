package com.microsoft.identity.common.java.commands.parameters;

import androidx.glance.AbstractC2821a;
import com.google.gson.annotations.Expose;
import com.microsoft.identity.common.java.broker.IBrokerAccount;
import com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache;
import com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.request.BrokerRequestType;
import com.microsoft.identity.common.java.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrokerDeviceCodeFlowCommandParameters extends DeviceCodeFlowCommandParameters implements IBrokerTokenCommandParameters {
    private final IBrokerAccount brokerAccount;

    @Expose
    private final String brokerVersion;

    @Expose
    private final String callerAppVersion;
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
    public static abstract class BrokerDeviceCodeFlowCommandParametersBuilder<C extends BrokerDeviceCodeFlowCommandParameters, B extends BrokerDeviceCodeFlowCommandParametersBuilder<C, B>> extends DeviceCodeFlowCommandParameters.DeviceCodeFlowCommandParametersBuilder<C, B> {
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

        private static void $fillValuesFromInstanceIntoBuilder(BrokerDeviceCodeFlowCommandParameters brokerDeviceCodeFlowCommandParameters, BrokerDeviceCodeFlowCommandParametersBuilder<?, ?> brokerDeviceCodeFlowCommandParametersBuilder) {
            brokerDeviceCodeFlowCommandParametersBuilder.callerAppVersion(brokerDeviceCodeFlowCommandParameters.callerAppVersion);
            brokerDeviceCodeFlowCommandParametersBuilder.brokerVersion(brokerDeviceCodeFlowCommandParameters.brokerVersion);
            brokerDeviceCodeFlowCommandParametersBuilder.negotiatedBrokerProtocolVersion(brokerDeviceCodeFlowCommandParameters.negotiatedBrokerProtocolVersion);
            brokerDeviceCodeFlowCommandParametersBuilder.pKeyAuthHeaderAllowed(brokerDeviceCodeFlowCommandParameters.pKeyAuthHeaderAllowed);
            brokerDeviceCodeFlowCommandParametersBuilder.requestType(brokerDeviceCodeFlowCommandParameters.requestType);
            brokerDeviceCodeFlowCommandParametersBuilder.homeTenantId(brokerDeviceCodeFlowCommandParameters.homeTenantId);
            brokerDeviceCodeFlowCommandParametersBuilder.brokerAccount(brokerDeviceCodeFlowCommandParameters.brokerAccount);
            brokerDeviceCodeFlowCommandParametersBuilder.homeAccountId(brokerDeviceCodeFlowCommandParameters.homeAccountId);
            brokerDeviceCodeFlowCommandParametersBuilder.localAccountId(brokerDeviceCodeFlowCommandParameters.localAccountId);
            brokerDeviceCodeFlowCommandParametersBuilder.sleepTimeBeforePrtAcquisition(brokerDeviceCodeFlowCommandParameters.sleepTimeBeforePrtAcquisition);
            brokerDeviceCodeFlowCommandParametersBuilder.callerUid(brokerDeviceCodeFlowCommandParameters.callerUid);
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters.DeviceCodeFlowCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((BrokerDeviceCodeFlowCommandParameters) c, (BrokerDeviceCodeFlowCommandParametersBuilder<?, ?>) this);
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

        @Override // com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters.DeviceCodeFlowCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
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

        @Override // com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters.DeviceCodeFlowCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        public B sleepTimeBeforePrtAcquisition(int i) {
            this.sleepTimeBeforePrtAcquisition = i;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters.DeviceCodeFlowCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("BrokerDeviceCodeFlowCommandParameters.BrokerDeviceCodeFlowCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", callerAppVersion=");
            sb.append(this.callerAppVersion);
            sb.append(", brokerVersion=");
            sb.append(this.brokerVersion);
            sb.append(", negotiatedBrokerProtocolVersion=");
            sb.append(this.negotiatedBrokerProtocolVersion);
            sb.append(", pKeyAuthHeaderAllowed=");
            sb.append(this.pKeyAuthHeaderAllowed);
            sb.append(", requestType=");
            sb.append(this.requestType);
            sb.append(", homeTenantId=");
            sb.append(this.homeTenantId);
            sb.append(", brokerAccount=");
            sb.append(this.brokerAccount);
            sb.append(", homeAccountId=");
            sb.append(this.homeAccountId);
            sb.append(", localAccountId=");
            sb.append(this.localAccountId);
            sb.append(", sleepTimeBeforePrtAcquisition=");
            sb.append(this.sleepTimeBeforePrtAcquisition);
            sb.append(", callerUid=");
            return AbstractC2821a.m2223n(sb, ")", this.callerUid);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class BrokerDeviceCodeFlowCommandParametersBuilderImpl extends BrokerDeviceCodeFlowCommandParametersBuilder<BrokerDeviceCodeFlowCommandParameters, BrokerDeviceCodeFlowCommandParametersBuilderImpl> {
        private BrokerDeviceCodeFlowCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.BrokerDeviceCodeFlowCommandParameters.BrokerDeviceCodeFlowCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters.DeviceCodeFlowCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public BrokerDeviceCodeFlowCommandParameters build() {
            return new BrokerDeviceCodeFlowCommandParameters(this);
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.BrokerDeviceCodeFlowCommandParameters.BrokerDeviceCodeFlowCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters.DeviceCodeFlowCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public BrokerDeviceCodeFlowCommandParametersBuilderImpl self() {
            return this;
        }
    }

    public BrokerDeviceCodeFlowCommandParameters(BrokerDeviceCodeFlowCommandParametersBuilder<?, ?> brokerDeviceCodeFlowCommandParametersBuilder) {
        super(brokerDeviceCodeFlowCommandParametersBuilder);
        this.callerAppVersion = ((BrokerDeviceCodeFlowCommandParametersBuilder) brokerDeviceCodeFlowCommandParametersBuilder).callerAppVersion;
        this.brokerVersion = ((BrokerDeviceCodeFlowCommandParametersBuilder) brokerDeviceCodeFlowCommandParametersBuilder).brokerVersion;
        this.negotiatedBrokerProtocolVersion = ((BrokerDeviceCodeFlowCommandParametersBuilder) brokerDeviceCodeFlowCommandParametersBuilder).negotiatedBrokerProtocolVersion;
        this.pKeyAuthHeaderAllowed = ((BrokerDeviceCodeFlowCommandParametersBuilder) brokerDeviceCodeFlowCommandParametersBuilder).pKeyAuthHeaderAllowed;
        this.requestType = ((BrokerDeviceCodeFlowCommandParametersBuilder) brokerDeviceCodeFlowCommandParametersBuilder).requestType;
        this.homeTenantId = ((BrokerDeviceCodeFlowCommandParametersBuilder) brokerDeviceCodeFlowCommandParametersBuilder).homeTenantId;
        this.brokerAccount = ((BrokerDeviceCodeFlowCommandParametersBuilder) brokerDeviceCodeFlowCommandParametersBuilder).brokerAccount;
        this.homeAccountId = ((BrokerDeviceCodeFlowCommandParametersBuilder) brokerDeviceCodeFlowCommandParametersBuilder).homeAccountId;
        this.localAccountId = ((BrokerDeviceCodeFlowCommandParametersBuilder) brokerDeviceCodeFlowCommandParametersBuilder).localAccountId;
        this.sleepTimeBeforePrtAcquisition = ((BrokerDeviceCodeFlowCommandParametersBuilder) brokerDeviceCodeFlowCommandParametersBuilder).sleepTimeBeforePrtAcquisition;
        this.callerUid = ((BrokerDeviceCodeFlowCommandParametersBuilder) brokerDeviceCodeFlowCommandParametersBuilder).callerUid;
    }

    public static BrokerDeviceCodeFlowCommandParametersBuilder<?, ?> builder() {
        return new BrokerDeviceCodeFlowCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof BrokerDeviceCodeFlowCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BrokerDeviceCodeFlowCommandParameters)) {
            return false;
        }
        BrokerDeviceCodeFlowCommandParameters brokerDeviceCodeFlowCommandParameters = (BrokerDeviceCodeFlowCommandParameters) obj;
        if (!brokerDeviceCodeFlowCommandParameters.canEqual(this) || !super.equals(obj) || isPKeyAuthHeaderAllowed() != brokerDeviceCodeFlowCommandParameters.isPKeyAuthHeaderAllowed() || getSleepTimeBeforePrtAcquisition() != brokerDeviceCodeFlowCommandParameters.getSleepTimeBeforePrtAcquisition() || getCallerUid() != brokerDeviceCodeFlowCommandParameters.getCallerUid()) {
            return false;
        }
        String callerAppVersion = getCallerAppVersion();
        String callerAppVersion2 = brokerDeviceCodeFlowCommandParameters.getCallerAppVersion();
        if (callerAppVersion != null ? !callerAppVersion.equals(callerAppVersion2) : callerAppVersion2 != null) {
            return false;
        }
        String brokerVersion = getBrokerVersion();
        String brokerVersion2 = brokerDeviceCodeFlowCommandParameters.getBrokerVersion();
        if (brokerVersion != null ? !brokerVersion.equals(brokerVersion2) : brokerVersion2 != null) {
            return false;
        }
        String negotiatedBrokerProtocolVersion = getNegotiatedBrokerProtocolVersion();
        String negotiatedBrokerProtocolVersion2 = brokerDeviceCodeFlowCommandParameters.getNegotiatedBrokerProtocolVersion();
        if (negotiatedBrokerProtocolVersion != null ? !negotiatedBrokerProtocolVersion.equals(negotiatedBrokerProtocolVersion2) : negotiatedBrokerProtocolVersion2 != null) {
            return false;
        }
        BrokerRequestType requestType = getRequestType();
        BrokerRequestType requestType2 = brokerDeviceCodeFlowCommandParameters.getRequestType();
        if (requestType != null ? !requestType.equals(requestType2) : requestType2 != null) {
            return false;
        }
        String homeTenantId = getHomeTenantId();
        String homeTenantId2 = brokerDeviceCodeFlowCommandParameters.getHomeTenantId();
        if (homeTenantId != null ? !homeTenantId.equals(homeTenantId2) : homeTenantId2 != null) {
            return false;
        }
        IBrokerAccount brokerAccount = getBrokerAccount();
        IBrokerAccount brokerAccount2 = brokerDeviceCodeFlowCommandParameters.getBrokerAccount();
        if (brokerAccount != null ? !brokerAccount.equals(brokerAccount2) : brokerAccount2 != null) {
            return false;
        }
        String homeAccountId = getHomeAccountId();
        String homeAccountId2 = brokerDeviceCodeFlowCommandParameters.getHomeAccountId();
        if (homeAccountId != null ? !homeAccountId.equals(homeAccountId2) : homeAccountId2 != null) {
            return false;
        }
        String localAccountId = getLocalAccountId();
        String localAccountId2 = brokerDeviceCodeFlowCommandParameters.getLocalAccountId();
        return localAccountId != null ? localAccountId.equals(localAccountId2) : localAccountId2 == null;
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

    @Override // com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int callerUid = getCallerUid() + ((getSleepTimeBeforePrtAcquisition() + (((super.hashCode() * 59) + (isPKeyAuthHeaderAllowed() ? 79 : 97)) * 59)) * 59);
        String callerAppVersion = getCallerAppVersion();
        int iHashCode = (callerUid * 59) + (callerAppVersion == null ? 43 : callerAppVersion.hashCode());
        String brokerVersion = getBrokerVersion();
        int iHashCode2 = (iHashCode * 59) + (brokerVersion == null ? 43 : brokerVersion.hashCode());
        String negotiatedBrokerProtocolVersion = getNegotiatedBrokerProtocolVersion();
        int iHashCode3 = (iHashCode2 * 59) + (negotiatedBrokerProtocolVersion == null ? 43 : negotiatedBrokerProtocolVersion.hashCode());
        BrokerRequestType requestType = getRequestType();
        int iHashCode4 = (iHashCode3 * 59) + (requestType == null ? 43 : requestType.hashCode());
        String homeTenantId = getHomeTenantId();
        int iHashCode5 = (iHashCode4 * 59) + (homeTenantId == null ? 43 : homeTenantId.hashCode());
        IBrokerAccount brokerAccount = getBrokerAccount();
        int iHashCode6 = (iHashCode5 * 59) + (brokerAccount == null ? 43 : brokerAccount.hashCode());
        String homeAccountId = getHomeAccountId();
        int iHashCode7 = (iHashCode6 * 59) + (homeAccountId == null ? 43 : homeAccountId.hashCode());
        String localAccountId = getLocalAccountId();
        return (iHashCode7 * 59) + (localAccountId != null ? localAccountId.hashCode() : 43);
    }

    public boolean isPKeyAuthHeaderAllowed() {
        return this.pKeyAuthHeaderAllowed;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters
    public void validate() throws ArgumentException {
        super.validate();
        if (getAuthority() == null) {
            throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_WITH_DEVICE_CODE_OPERATION_NAME, "mAuthority", "Authority Url is not set");
        }
        if (getScopes() == null || getScopes().isEmpty()) {
            throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_WITH_DEVICE_CODE_OPERATION_NAME, "mScopes", "Scope or resource is not set");
        }
        if (StringUtil.isNullOrEmpty(getClientId())) {
            throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_WITH_DEVICE_CODE_OPERATION_NAME, "mClientId", "Client Id is not set");
        }
        if (!(getOAuth2TokenCache() instanceof BrokerOAuth2TokenCache)) {
            throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_WITH_DEVICE_CODE_OPERATION_NAME, "BrokerDeviceCodeFlowCommandParameters", "OAuth2Cache not an instance of BrokerOAuth2TokenCache");
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public BrokerDeviceCodeFlowCommandParametersBuilder<?, ?> toBuilder() {
        return new BrokerDeviceCodeFlowCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
