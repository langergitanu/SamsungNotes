package com.microsoft.identity.common.java.commands.parameters;

import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryB2CAuthority;
import com.microsoft.identity.common.java.authorities.CIAMAuthority;
import com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.exception.TerminalException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryCloud;
import java.io.IOException;
import java.net.URISyntaxException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SilentTokenCommandParameters extends TokenCommandParameters {
    private static final String TAG = "SilentTokenCommandParameters";
    private static final Object sLock = new Object();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SilentTokenCommandParametersBuilder<C extends SilentTokenCommandParameters, B extends SilentTokenCommandParametersBuilder<C, B>> extends TokenCommandParameters.TokenCommandParametersBuilder<C, B> {
        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return AbstractC0622a.m1170p(super.toString(), ")", new StringBuilder("SilentTokenCommandParameters.SilentTokenCommandParametersBuilder(super="));
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((SilentTokenCommandParameters) c, (SilentTokenCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        private static void $fillValuesFromInstanceIntoBuilder(SilentTokenCommandParameters silentTokenCommandParameters, SilentTokenCommandParametersBuilder<?, ?> silentTokenCommandParametersBuilder) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SilentTokenCommandParametersBuilderImpl extends SilentTokenCommandParametersBuilder<SilentTokenCommandParameters, SilentTokenCommandParametersBuilderImpl> {
        private SilentTokenCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters.SilentTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SilentTokenCommandParametersBuilderImpl self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters.SilentTokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters.TokenCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public SilentTokenCommandParameters build() {
            return new SilentTokenCommandParameters(this);
        }
    }

    public SilentTokenCommandParameters(SilentTokenCommandParametersBuilder<?, ?> silentTokenCommandParametersBuilder) {
        super(silentTokenCommandParametersBuilder);
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

    public static SilentTokenCommandParametersBuilder<?, ?> builder() {
        return new SilentTokenCommandParametersBuilderImpl();
    }

    private boolean isAuthorityB2C() {
        return getAuthority() instanceof AzureActiveDirectoryB2CAuthority;
    }

    private boolean isAuthorityCIAM() {
        return getAuthority() instanceof CIAMAuthority;
    }

    private static void performCloudDiscovery() {
        AbstractC4539a.m3216z(new StringBuilder(), TAG, ":performCloudDiscovery", "Performing cloud discovery...");
        synchronized (sLock) {
            AzureActiveDirectory.performCloudDiscovery();
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean canEqual(Object obj) {
        return obj instanceof SilentTokenCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof SilentTokenCommandParameters) && ((SilentTokenCommandParameters) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters
    public void validate() throws ArgumentException {
        super.validate();
        if (getAccount() == null) {
            Logger.warn(TAG, "The account set on silent operation parameters is NULL.");
        } else if (!isAuthorityB2C() && !isAuthorityCIAM() && !authorityMatchesAccountEnvironment()) {
            throw new ArgumentException("acquireTokenSilent", "authority", "Authority passed to silent parameters does not match with the cloud associated to the account.");
        }
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters, com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public SilentTokenCommandParametersBuilder<?, ?> toBuilder() {
        return new SilentTokenCommandParametersBuilderImpl().$fillValuesFrom(this);
    }
}
