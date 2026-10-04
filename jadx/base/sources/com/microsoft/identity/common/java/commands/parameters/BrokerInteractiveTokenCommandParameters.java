package com.microsoft.identity.common.java.commands.parameters;

import com.google.gson.annotations.Expose;
import com.microsoft.identity.common.java.broker.IBrokerAccount;
import com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.request.BrokerRequestType;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrokerInteractiveTokenCommandParameters extends InteractiveTokenCommandParameters implements IHasExtraParameters, IBrokerTokenCommandParameters {
    private final IBrokerAccount brokerAccount;

    @Expose
    private final String brokerVersion;

    @Expose
    private final String callerAppVersion;

    @Expose
    private final int callerUid;
    private final String enrollmentId;
    private final Iterable<Map.Entry<String, String>> extraParameters;
    private final String homeAccountId;

    @Expose
    private final String homeTenantId;
    private final boolean isATv2Request;
    private final String localAccountId;

    @Expose
    private final String negotiatedBrokerProtocolVersion;

    @Expose
    private final boolean pKeyAuthHeaderAllowed;

    @Expose
    private final BrokerRequestType requestType;

    @Expose
    private final boolean shouldResolveInterrupt;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class BrokerInteractiveTokenCommandParametersBuilder<C extends BrokerInteractiveTokenCommandParameters, B extends BrokerInteractiveTokenCommandParametersBuilder<C, B>> extends InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder<C, B> {
        private IBrokerAccount brokerAccount;
        private String brokerVersion;
        private String callerAppVersion;
        private int callerUid;
        private String enrollmentId;
        private Iterable<Map.Entry<String, String>> extraParameters;
        private String homeAccountId;
        private String homeTenantId;
        private boolean isATv2Request;
        private String localAccountId;
        private String negotiatedBrokerProtocolVersion;
        private boolean pKeyAuthHeaderAllowed;
        private BrokerRequestType requestType;
        private boolean shouldResolveInterrupt;

        private static void $fillValuesFromInstanceIntoBuilder(BrokerInteractiveTokenCommandParameters brokerInteractiveTokenCommandParameters, BrokerInteractiveTokenCommandParametersBuilder<?, ?> brokerInteractiveTokenCommandParametersBuilder) {
            brokerInteractiveTokenCommandParametersBuilder.callerUid(brokerInteractiveTokenCommandParameters.callerUid);
            brokerInteractiveTokenCommandParametersBuilder.callerAppVersion(brokerInteractiveTokenCommandParameters.callerAppVersion);
            brokerInteractiveTokenCommandParametersBuilder.brokerVersion(brokerInteractiveTokenCommandParameters.brokerVersion);
            brokerInteractiveTokenCommandParametersBuilder.shouldResolveInterrupt(brokerInteractiveTokenCommandParameters.shouldResolveInterrupt);
            brokerInteractiveTokenCommandParametersBuilder.requestType(brokerInteractiveTokenCommandParameters.requestType);
            brokerInteractiveTokenCommandParametersBuilder.negotiatedBrokerProtocolVersion(brokerInteractiveTokenCommandParameters.negotiatedBrokerProtocolVersion);
            brokerInteractiveTokenCommandParametersBuilder.extraParameters(brokerInteractiveTokenCommandParameters.extraParameters);
            brokerInteractiveTokenCommandParametersBuilder.enrollmentId(brokerInteractiveTokenCommandParameters.enrollmentId);
            brokerInteractiveTokenCommandParametersBuilder.brokerAccount(brokerInteractiveTokenCommandParameters.brokerAccount);
            brokerInteractiveTokenCommandParametersBuilder.homeAccountId(brokerInteractiveTokenCommandParameters.homeAccountId);
            brokerInteractiveTokenCommandParametersBuilder.localAccountId(brokerInteractiveTokenCommandParameters.localAccountId);
            brokerInteractiveTokenCommandParametersBuilder.pKeyAuthHeaderAllowed(brokerInteractiveTokenCommandParameters.pKeyAuthHeaderAllowed);
            brokerInteractiveTokenCommandParametersBuilder.homeTenantId(brokerInteractiveTokenCommandParameters.homeTenantId);
            brokerInteractiveTokenCommandParametersBuilder.isATv2Request(brokerInteractiveTokenCommandParameters.isATv2Request);
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((BrokerInteractiveTokenCommandParameters) c, (BrokerInteractiveTokenCommandParametersBuilder<?, ?>) this);
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

        @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B callerAppVersion(String str) {
            this.callerAppVersion = str;
            return (B) self();
        }

        public B callerUid(int i) {
            this.callerUid = i;
            return (B) self();
        }

        public B enrollmentId(String str) {
            this.enrollmentId = str;
            return (B) self();
        }

        public B extraParameters(Iterable<Map.Entry<String, String>> iterable) {
            this.extraParameters = iterable;
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

        public B isATv2Request(boolean z) {
            this.isATv2Request = z;
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

        @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        public B shouldResolveInterrupt(boolean z) {
            this.shouldResolveInterrupt = z;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("BrokerInteractiveTokenCommandParameters.BrokerInteractiveTokenCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", callerUid=");
            sb.append(this.callerUid);
            sb.append(", callerAppVersion=");
            sb.append(this.callerAppVersion);
            sb.append(", brokerVersion=");
            sb.append(this.brokerVersion);
            sb.append(", shouldResolveInterrupt=");
            sb.append(this.shouldResolveInterrupt);
            sb.append(", requestType=");
            sb.append(this.requestType);
            sb.append(", negotiatedBrokerProtocolVersion=");
            sb.append(this.negotiatedBrokerProtocolVersion);
            sb.append(", extraParameters=");
            sb.append(this.extraParameters);
            sb.append(", enrollmentId=");
            sb.append(this.enrollmentId);
            sb.append(", brokerAccount=");
            sb.append(this.brokerAccount);
            sb.append(", homeAccountId=");
            sb.append(this.homeAccountId);
            sb.append(", localAccountId=");
            sb.append(this.localAccountId);
            sb.append(", pKeyAuthHeaderAllowed=");
            sb.append(this.pKeyAuthHeaderAllowed);
            sb.append(", homeTenantId=");
            sb.append(this.homeTenantId);
            sb.append(", isATv2Request=");
            return AbstractC0000a.m14k(sb, this.isATv2Request, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class BrokerInteractiveTokenCommandParametersBuilderImpl extends BrokerInteractiveTokenCommandParametersBuilder<BrokerInteractiveTokenCommandParameters, BrokerInteractiveTokenCommandParametersBuilderImpl> {
        private BrokerInteractiveTokenCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.BrokerInteractiveTokenCommandParameters.BrokerInteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public BrokerInteractiveTokenCommandParameters build() {
            return new BrokerInteractiveTokenCommandParameters(this);
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.BrokerInteractiveTokenCommandParameters.BrokerInteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters.InteractiveTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public BrokerInteractiveTokenCommandParametersBuilderImpl self() {
            return this;
        }
    }

    public BrokerInteractiveTokenCommandParameters(BrokerInteractiveTokenCommandParametersBuilder<?, ?> brokerInteractiveTokenCommandParametersBuilder) {
        super(brokerInteractiveTokenCommandParametersBuilder);
        this.callerUid = ((BrokerInteractiveTokenCommandParametersBuilder) brokerInteractiveTokenCommandParametersBuilder).callerUid;
        this.callerAppVersion = ((BrokerInteractiveTokenCommandParametersBuilder) brokerInteractiveTokenCommandParametersBuilder).callerAppVersion;
        this.brokerVersion = ((BrokerInteractiveTokenCommandParametersBuilder) brokerInteractiveTokenCommandParametersBuilder).brokerVersion;
        this.shouldResolveInterrupt = ((BrokerInteractiveTokenCommandParametersBuilder) brokerInteractiveTokenCommandParametersBuilder).shouldResolveInterrupt;
        this.requestType = ((BrokerInteractiveTokenCommandParametersBuilder) brokerInteractiveTokenCommandParametersBuilder).requestType;
        this.negotiatedBrokerProtocolVersion = ((BrokerInteractiveTokenCommandParametersBuilder) brokerInteractiveTokenCommandParametersBuilder).negotiatedBrokerProtocolVersion;
        this.extraParameters = ((BrokerInteractiveTokenCommandParametersBuilder) brokerInteractiveTokenCommandParametersBuilder).extraParameters;
        this.enrollmentId = ((BrokerInteractiveTokenCommandParametersBuilder) brokerInteractiveTokenCommandParametersBuilder).enrollmentId;
        this.brokerAccount = ((BrokerInteractiveTokenCommandParametersBuilder) brokerInteractiveTokenCommandParametersBuilder).brokerAccount;
        this.homeAccountId = ((BrokerInteractiveTokenCommandParametersBuilder) brokerInteractiveTokenCommandParametersBuilder).homeAccountId;
        this.localAccountId = ((BrokerInteractiveTokenCommandParametersBuilder) brokerInteractiveTokenCommandParametersBuilder).localAccountId;
        this.pKeyAuthHeaderAllowed = ((BrokerInteractiveTokenCommandParametersBuilder) brokerInteractiveTokenCommandParametersBuilder).pKeyAuthHeaderAllowed;
        this.homeTenantId = ((BrokerInteractiveTokenCommandParametersBuilder) brokerInteractiveTokenCommandParametersBuilder).homeTenantId;
        this.isATv2Request = ((BrokerInteractiveTokenCommandParametersBuilder) brokerInteractiveTokenCommandParametersBuilder).isATv2Request;
    }

    public static BrokerInteractiveTokenCommandParametersBuilder<?, ?> builder() {
        return new BrokerInteractiveTokenCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof BrokerInteractiveTokenCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BrokerInteractiveTokenCommandParameters)) {
            return false;
        }
        BrokerInteractiveTokenCommandParameters brokerInteractiveTokenCommandParameters = (BrokerInteractiveTokenCommandParameters) obj;
        if (!brokerInteractiveTokenCommandParameters.canEqual(this) || !super.equals(obj) || getCallerUid() != brokerInteractiveTokenCommandParameters.getCallerUid() || isShouldResolveInterrupt() != brokerInteractiveTokenCommandParameters.isShouldResolveInterrupt() || isPKeyAuthHeaderAllowed() != brokerInteractiveTokenCommandParameters.isPKeyAuthHeaderAllowed() || isATv2Request() != brokerInteractiveTokenCommandParameters.isATv2Request()) {
            return false;
        }
        String callerAppVersion = getCallerAppVersion();
        String callerAppVersion2 = brokerInteractiveTokenCommandParameters.getCallerAppVersion();
        if (callerAppVersion != null ? !callerAppVersion.equals(callerAppVersion2) : callerAppVersion2 != null) {
            return false;
        }
        String brokerVersion = getBrokerVersion();
        String brokerVersion2 = brokerInteractiveTokenCommandParameters.getBrokerVersion();
        if (brokerVersion != null ? !brokerVersion.equals(brokerVersion2) : brokerVersion2 != null) {
            return false;
        }
        BrokerRequestType requestType = getRequestType();
        BrokerRequestType requestType2 = brokerInteractiveTokenCommandParameters.getRequestType();
        if (requestType != null ? !requestType.equals(requestType2) : requestType2 != null) {
            return false;
        }
        String negotiatedBrokerProtocolVersion = getNegotiatedBrokerProtocolVersion();
        String negotiatedBrokerProtocolVersion2 = brokerInteractiveTokenCommandParameters.getNegotiatedBrokerProtocolVersion();
        if (negotiatedBrokerProtocolVersion != null ? !negotiatedBrokerProtocolVersion.equals(negotiatedBrokerProtocolVersion2) : negotiatedBrokerProtocolVersion2 != null) {
            return false;
        }
        Iterable<Map.Entry<String, String>> extraParameters = getExtraParameters();
        Iterable<Map.Entry<String, String>> extraParameters2 = brokerInteractiveTokenCommandParameters.getExtraParameters();
        if (extraParameters != null ? !extraParameters.equals(extraParameters2) : extraParameters2 != null) {
            return false;
        }
        String enrollmentId = getEnrollmentId();
        String enrollmentId2 = brokerInteractiveTokenCommandParameters.getEnrollmentId();
        if (enrollmentId != null ? !enrollmentId.equals(enrollmentId2) : enrollmentId2 != null) {
            return false;
        }
        IBrokerAccount brokerAccount = getBrokerAccount();
        IBrokerAccount brokerAccount2 = brokerInteractiveTokenCommandParameters.getBrokerAccount();
        if (brokerAccount != null ? !brokerAccount.equals(brokerAccount2) : brokerAccount2 != null) {
            return false;
        }
        String homeAccountId = getHomeAccountId();
        String homeAccountId2 = brokerInteractiveTokenCommandParameters.getHomeAccountId();
        if (homeAccountId != null ? !homeAccountId.equals(homeAccountId2) : homeAccountId2 != null) {
            return false;
        }
        String localAccountId = getLocalAccountId();
        String localAccountId2 = brokerInteractiveTokenCommandParameters.getLocalAccountId();
        if (localAccountId != null ? !localAccountId.equals(localAccountId2) : localAccountId2 != null) {
            return false;
        }
        String homeTenantId = getHomeTenantId();
        String homeTenantId2 = brokerInteractiveTokenCommandParameters.getHomeTenantId();
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

    public String getEnrollmentId() {
        return this.enrollmentId;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters
    public Iterable<Map.Entry<String, String>> getExtraParameters() {
        return this.extraParameters;
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

    @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int callerUid = (((((getCallerUid() + (super.hashCode() * 59)) * 59) + (isShouldResolveInterrupt() ? 79 : 97)) * 59) + (isPKeyAuthHeaderAllowed() ? 79 : 97)) * 59;
        int i = isATv2Request() ? 79 : 97;
        String callerAppVersion = getCallerAppVersion();
        int iHashCode = ((callerUid + i) * 59) + (callerAppVersion == null ? 43 : callerAppVersion.hashCode());
        String brokerVersion = getBrokerVersion();
        int iHashCode2 = (iHashCode * 59) + (brokerVersion == null ? 43 : brokerVersion.hashCode());
        BrokerRequestType requestType = getRequestType();
        int iHashCode3 = (iHashCode2 * 59) + (requestType == null ? 43 : requestType.hashCode());
        String negotiatedBrokerProtocolVersion = getNegotiatedBrokerProtocolVersion();
        int iHashCode4 = (iHashCode3 * 59) + (negotiatedBrokerProtocolVersion == null ? 43 : negotiatedBrokerProtocolVersion.hashCode());
        Iterable<Map.Entry<String, String>> extraParameters = getExtraParameters();
        int iHashCode5 = (iHashCode4 * 59) + (extraParameters == null ? 43 : extraParameters.hashCode());
        String enrollmentId = getEnrollmentId();
        int iHashCode6 = (iHashCode5 * 59) + (enrollmentId == null ? 43 : enrollmentId.hashCode());
        IBrokerAccount brokerAccount = getBrokerAccount();
        int iHashCode7 = (iHashCode6 * 59) + (brokerAccount == null ? 43 : brokerAccount.hashCode());
        String homeAccountId = getHomeAccountId();
        int iHashCode8 = (iHashCode7 * 59) + (homeAccountId == null ? 43 : homeAccountId.hashCode());
        String localAccountId = getLocalAccountId();
        int iHashCode9 = (iHashCode8 * 59) + (localAccountId == null ? 43 : localAccountId.hashCode());
        String homeTenantId = getHomeTenantId();
        return (iHashCode9 * 59) + (homeTenantId != null ? homeTenantId.hashCode() : 43);
    }

    public boolean isATv2Request() {
        return this.isATv2Request;
    }

    public boolean isPKeyAuthHeaderAllowed() {
        return this.pKeyAuthHeaderAllowed;
    }

    public boolean isShouldResolveInterrupt() {
        return this.shouldResolveInterrupt;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters
    public void setExtraParameters(Iterable<Map.Entry<String, String>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters
    public void validate() throws ArgumentException {
        super.validate();
        if (getAuthority() == null) {
            throw new ArgumentException("acquireToken", "mAuthority", "Authority Url is not set");
        }
        if (getScopes() == null || getScopes().isEmpty()) {
            throw new ArgumentException("acquireToken", "mScopes", "Scope or resource is not set");
        }
        if (StringUtil.isNullOrEmpty(getClientId())) {
            throw new ArgumentException("acquireToken", "mClientId", "Client Id is not set");
        }
        if (isRequestFromBroker()) {
            return;
        }
        if (this.callerUid == 0) {
            throw new ArgumentException("acquireToken", "mCallerUId", "Caller Uid is not set");
        }
        if (!(getOAuth2TokenCache() instanceof BrokerOAuth2TokenCache)) {
            throw new ArgumentException("acquireToken", "AcquireTokenSilentOperationParameters", "OAuth2Cache not an instance of BrokerOAuth2TokenCache");
        }
        if (!getPlatformComponents().getPlatformUtil().isValidCallingApp(getRedirectUri(), getCallerPackageName())) {
            throw new ArgumentException("acquireToken", "redirect_uri", "The redirect URI doesn't match the uri generated with caller package name and signature");
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public BrokerInteractiveTokenCommandParametersBuilder<?, ?> toBuilder() {
        return new BrokerInteractiveTokenCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
