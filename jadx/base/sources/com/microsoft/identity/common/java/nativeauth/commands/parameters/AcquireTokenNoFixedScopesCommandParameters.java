package com.microsoft.identity.common.java.nativeauth.commands.parameters;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.exception.TerminalException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryCloud;
import java.io.IOException;
import java.net.URISyntaxException;
import lombok.NonNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AcquireTokenNoFixedScopesCommandParameters extends BaseNativeAuthCommandParameters {
    private static final String TAG = "AcquireTokenNoFixedScopesCommandParameters";
    private static final Object sLock = new Object();
    private final IAccountRecord account;

    @NonNull
    private final AbstractAuthenticationScheme authenticationScheme;
    private final boolean forceRefresh;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AcquireTokenNoFixedScopesCommandParametersBuilder<C extends AcquireTokenNoFixedScopesCommandParameters, B extends AcquireTokenNoFixedScopesCommandParametersBuilder<C, B>> extends BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder<C, B> {
        private IAccountRecord account;
        private AbstractAuthenticationScheme authenticationScheme;
        private boolean forceRefresh;

        private static void $fillValuesFromInstanceIntoBuilder(AcquireTokenNoFixedScopesCommandParameters acquireTokenNoFixedScopesCommandParameters, AcquireTokenNoFixedScopesCommandParametersBuilder<?, ?> acquireTokenNoFixedScopesCommandParametersBuilder) {
            acquireTokenNoFixedScopesCommandParametersBuilder.account(acquireTokenNoFixedScopesCommandParameters.account);
            acquireTokenNoFixedScopesCommandParametersBuilder.authenticationScheme(acquireTokenNoFixedScopesCommandParameters.authenticationScheme);
            acquireTokenNoFixedScopesCommandParametersBuilder.forceRefresh(acquireTokenNoFixedScopesCommandParameters.forceRefresh);
        }

        public B account(IAccountRecord iAccountRecord) {
            this.account = iAccountRecord;
            return (B) self();
        }

        public B authenticationScheme(@NonNull AbstractAuthenticationScheme abstractAuthenticationScheme) {
            if (abstractAuthenticationScheme == null) {
                throw new NullPointerException("authenticationScheme is marked non-null but is null");
            }
            this.authenticationScheme = abstractAuthenticationScheme;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        public B forceRefresh(boolean z) {
            this.forceRefresh = z;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            StringBuilder sb = new StringBuilder("AcquireTokenNoFixedScopesCommandParameters.AcquireTokenNoFixedScopesCommandParametersBuilder(super=");
            sb.append(super.toString());
            sb.append(", account=");
            sb.append(this.account);
            sb.append(", authenticationScheme=");
            sb.append(this.authenticationScheme);
            sb.append(", forceRefresh=");
            return AbstractC0000a.m14k(sb, this.forceRefresh, ")");
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((AcquireTokenNoFixedScopesCommandParameters) c, (AcquireTokenNoFixedScopesCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class AcquireTokenNoFixedScopesCommandParametersBuilderImpl extends AcquireTokenNoFixedScopesCommandParametersBuilder<AcquireTokenNoFixedScopesCommandParameters, AcquireTokenNoFixedScopesCommandParametersBuilderImpl> {
        private AcquireTokenNoFixedScopesCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.AcquireTokenNoFixedScopesCommandParameters.AcquireTokenNoFixedScopesCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public AcquireTokenNoFixedScopesCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.AcquireTokenNoFixedScopesCommandParameters.AcquireTokenNoFixedScopesCommandParametersBuilder, com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters.BaseNativeAuthCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public AcquireTokenNoFixedScopesCommandParameters build() {
            return new AcquireTokenNoFixedScopesCommandParameters(this);
        }
    }

    public AcquireTokenNoFixedScopesCommandParameters(AcquireTokenNoFixedScopesCommandParametersBuilder<?, ?> acquireTokenNoFixedScopesCommandParametersBuilder) {
        super(acquireTokenNoFixedScopesCommandParametersBuilder);
        this.account = ((AcquireTokenNoFixedScopesCommandParametersBuilder) acquireTokenNoFixedScopesCommandParametersBuilder).account;
        AbstractAuthenticationScheme abstractAuthenticationScheme = ((AcquireTokenNoFixedScopesCommandParametersBuilder) acquireTokenNoFixedScopesCommandParametersBuilder).authenticationScheme;
        this.authenticationScheme = abstractAuthenticationScheme;
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authenticationScheme is marked non-null but is null");
        }
        this.forceRefresh = ((AcquireTokenNoFixedScopesCommandParametersBuilder) acquireTokenNoFixedScopesCommandParametersBuilder).forceRefresh;
    }

    private boolean authorityMatchesAccountEnvironment() {
        String str;
        try {
            if (!AzureActiveDirectory.isInitialized()) {
                performCloudDiscovery();
            }
            AzureActiveDirectoryCloud azureActiveDirectoryCloudFromHostName = AzureActiveDirectory.getAzureActiveDirectoryCloudFromHostName(getAccount().getEnvironment());
            if (azureActiveDirectoryCloudFromHostName != null) {
                return azureActiveDirectoryCloudFromHostName.getPreferredNetworkHostName().equals(getAuthority().getAuthorityURL().getAuthority());
            }
            return false;
        } catch (IOException e) {
            e = e;
            str = "io_error";
            Logger.error(TAG + ":authorityMatchesAccountEnvironment", "Unable to perform cloud discovery", e);
            throw new TerminalException("Unable to perform cloud discovery in order to validate request authority", e, str);
        } catch (URISyntaxException e2) {
            e = e2;
            str = "malformed_url";
            Logger.error(TAG + ":authorityMatchesAccountEnvironment", "Unable to perform cloud discovery", e);
            throw new TerminalException("Unable to perform cloud discovery in order to validate request authority", e, str);
        }
    }

    public static AcquireTokenNoFixedScopesCommandParametersBuilder<?, ?> builder() {
        return new AcquireTokenNoFixedScopesCommandParametersBuilderImpl();
    }

    private static void performCloudDiscovery() {
        AbstractC4539a.m3216z(new StringBuilder(), TAG, ":performCloudDiscovery", "Performing cloud discovery...");
        synchronized (sLock) {
            AzureActiveDirectory.performCloudDiscovery();
        }
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof AcquireTokenNoFixedScopesCommandParameters;
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
        if (!(obj instanceof AcquireTokenNoFixedScopesCommandParameters)) {
            return false;
        }
        AcquireTokenNoFixedScopesCommandParameters acquireTokenNoFixedScopesCommandParameters = (AcquireTokenNoFixedScopesCommandParameters) obj;
        if (!acquireTokenNoFixedScopesCommandParameters.canEqual(this) || !super.equals(obj) || isForceRefresh() != acquireTokenNoFixedScopesCommandParameters.isForceRefresh()) {
            return false;
        }
        IAccountRecord account = getAccount();
        IAccountRecord account2 = acquireTokenNoFixedScopesCommandParameters.getAccount();
        if (account != null ? !account.equals(account2) : account2 != null) {
            return false;
        }
        AbstractAuthenticationScheme authenticationScheme = getAuthenticationScheme();
        AbstractAuthenticationScheme authenticationScheme2 = acquireTokenNoFixedScopesCommandParameters.getAuthenticationScheme();
        return authenticationScheme != null ? authenticationScheme.equals(authenticationScheme2) : authenticationScheme2 == null;
    }

    public IAccountRecord getAccount() {
        return this.account;
    }

    @NonNull
    public AbstractAuthenticationScheme getAuthenticationScheme() {
        return this.authenticationScheme;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = (super.hashCode() * 59) + (isForceRefresh() ? 79 : 97);
        IAccountRecord account = getAccount();
        int iHashCode2 = (iHashCode * 59) + (account == null ? 43 : account.hashCode());
        AbstractAuthenticationScheme authenticationScheme = getAuthenticationScheme();
        return (iHashCode2 * 59) + (authenticationScheme != null ? authenticationScheme.hashCode() : 43);
    }

    public boolean isForceRefresh() {
        return this.forceRefresh;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("AcquireTokenNoFixedScopesCommandParameters(authenticationScheme=");
        sb.append(getAuthenticationScheme());
        sb.append(", forceRefresh=");
        sb.append(this.forceRefresh);
        sb.append(", authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NonNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("AcquireTokenNoFixedScopesCommandParameters(account=");
        sb.append(this.account);
        sb.append(", authenticationScheme=");
        sb.append(getAuthenticationScheme());
        sb.append(", forceRefresh=");
        sb.append(this.forceRefresh);
        sb.append(", authority=");
        sb.append(this.authority);
        sb.append(", challengeTypes=");
        return AbstractC0541b.m777s(sb, this.challengeType, ")");
    }

    public void validate() throws ArgumentException {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        AbstractC4539a.m3216z(sb, str, ":validate", "Validating operation params...");
        if (this.authenticationScheme == null) {
            throw new ArgumentException(ArgumentException.ACQUIRE_TOKEN_NO_FIXED_SCOPE_OPERATION_NAME, ArgumentException.AUTHENTICATION_SCHEME_ARGUMENT_NAME, "authentication scheme is undefined");
        }
        if (getAccount() == null) {
            Logger.warn(str, "The account set on silent operation parameters is NULL.");
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public AcquireTokenNoFixedScopesCommandParametersBuilder<?, ?> toBuilder() {
        return new AcquireTokenNoFixedScopesCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
