package com.microsoft.identity.common.java.authorities;

import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.authorities.NativeAuthCIAMAuthority;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class Authority {
    public static final String AAD_NA = "AAD_NA";
    private static final String ADFS_PATH_SEGMENT = "adfs";
    public static final String B2C = "B2C";
    private static final String B2C_PATH_SEGMENT = "tfp";
    public static final String CIAM = "CIAM";
    private static final String TAG = "Authority";
    private static final List<Authority> knownAuthorities = new ArrayList();
    private static final Object sLock = new Object();

    @SerializedName("type")
    protected String mAuthorityTypeString;

    @SerializedName("authority_url")
    protected String mAuthorityUrlString;

    @SerializedName("default")
    protected boolean mIsDefault = false;

    @SerializedName(AzureActiveDirectorySlice.SLICE_PARAMETER)
    public AzureActiveDirectorySlice mSlice;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class KnownAuthorityResult {
        private ClientException mClientException;
        private boolean mKnown;

        public KnownAuthorityResult(boolean z, ClientException clientException) {
            this.mKnown = z;
            this.mClientException = clientException;
        }

        public ClientException getClientException() {
            return this.mClientException;
        }

        public boolean getKnown() {
            return this.mKnown;
        }
    }

    @SuppressFBWarnings(justification = "Somehow, spotbugs thinks that BuildConfig.SLICE and BuildConfig.DC are the same values.", value = {"RpC_REPEATED_CONDITIONAL_TEST"})
    public Authority() {
        if (StringUtil.isNullOrEmpty("") && StringUtil.isNullOrEmpty("")) {
            return;
        }
        AzureActiveDirectorySlice azureActiveDirectorySlice = new AzureActiveDirectorySlice();
        azureActiveDirectorySlice.setSlice("");
        azureActiveDirectorySlice.setDataCenter("");
        this.mSlice = azureActiveDirectorySlice;
    }

    public static void addKnownAuthorities(List<Authority> list) {
        synchronized (sLock) {
            knownAuthorities.addAll(list);
        }
    }

    private static boolean authorityIsKnownFromConfiguration(@NonNull String str) {
        if (str != null) {
            return getEquivalentConfiguredAuthority(str) != null;
        }
        throw new NullPointerException("authorityStr is marked non-null but is null");
    }

    private static Authority createAadAuthority(@NonNull CommonURIBuilder commonURIBuilder, @NonNull List<String> list) {
        if (commonURIBuilder == null) {
            throw new NullPointerException("authorityCommonUriBuilder is marked non-null but is null");
        }
        if (list == null) {
            throw new NullPointerException("pathSegments is marked non-null but is null");
        }
        return new AzureActiveDirectoryAuthority(AzureActiveDirectoryAudience.getAzureActiveDirectoryAudience(commonURIBuilder.getScheme() + "://" + commonURIBuilder.getHost(), list.get(0)));
    }

    public static Authority getAuthorityFromAuthorityUrl(String str) {
        try {
            CommonURIBuilder commonURIBuilder = new CommonURIBuilder(str);
            List<String> pathSegments = commonURIBuilder.getPathSegments();
            if (pathSegments.size() == 0 || (pathSegments.size() == 1 && pathSegments.get(0).equals(""))) {
                return str.contains(CIAMAuthority.CIAM_LOGIN_URL_SEGMENT) ? new CIAMAuthority(CIAMAuthority.getTenantNameVariantUrlFromAuthorityWithoutPath(str)) : new UnknownAuthority();
            }
            if (authorityIsKnownFromConfiguration(str)) {
                Authority equivalentConfiguredAuthority = getEquivalentConfiguredAuthority(str);
                String str2 = equivalentConfiguredAuthority.mAuthorityTypeString;
                return "B2C".equalsIgnoreCase(str2) ? new AzureActiveDirectoryB2CAuthority(str) : CIAM.equalsIgnoreCase(str2) ? new CIAMAuthority(str) : (AAD_NA.equalsIgnoreCase(str2) && (equivalentConfiguredAuthority instanceof NativeAuthCIAMAuthority)) ? new NativeAuthCIAMAuthority(str, ((NativeAuthCIAMAuthority) equivalentConfiguredAuthority).getClientId()) : createAadAuthority(commonURIBuilder, pathSegments);
            }
            String lowerCase = pathSegments.get(0).toLowerCase(Locale.ROOT);
            if (lowerCase.equals("adfs")) {
                Logger.verbose(TAG + ":getAuthorityFromAuthorityUrl", "Authority type is ADFS");
                return new ActiveDirectoryFederationServicesAuthority(str);
            }
            if (lowerCase.equals(B2C_PATH_SEGMENT)) {
                Logger.verbose(TAG + ":getAuthorityFromAuthorityUrl", "Authority type is B2C");
                return new AzureActiveDirectoryB2CAuthority(str);
            }
            if (!str.contains(CIAMAuthority.CIAM_LOGIN_URL_SEGMENT)) {
                AbstractC4539a.m3216z(new StringBuilder(), TAG, ":getAuthorityFromAuthorityUrl", "Authority type default: AAD");
                return createAadAuthority(commonURIBuilder, pathSegments);
            }
            Logger.verbose(TAG + ":getAuthorityFromAuthorityUrl", "Authority type is CIAM");
            return new CIAMAuthority(str);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("Invalid authority URL");
        }
    }

    @Nullable
    private static Authority getEquivalentConfiguredAuthority(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("authorityStr is marked non-null but is null");
        }
        try {
            String authority = new URL(str).getAuthority();
            for (Authority authority2 : knownAuthorities) {
                if (!StringUtil.isNullOrEmpty(authority2.mAuthorityUrlString) && authority.equalsIgnoreCase(new URL(authority2.mAuthorityUrlString).getAuthority())) {
                    return authority2;
                }
            }
            return null;
        } catch (MalformedURLException e) {
            Logger.errorPII(TAG, "Error parsing authority", e);
            return null;
        }
    }

    public static KnownAuthorityResult getKnownAuthorityResult(Authority authority) {
        ClientException clientException;
        ClientException clientException2;
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        AbstractC4539a.m3216z(sb, str, ":getKnownAuthorityResult", "Getting known authority result...");
        try {
            Logger.info(str + ":getKnownAuthorityResult", "Performing cloud discovery");
            performCloudDiscovery();
            clientException2 = null;
        } catch (IOException e) {
            clientException = new ClientException("io_error", "Unable to perform cloud discovery", e);
            clientException2 = clientException;
        } catch (URISyntaxException e2) {
            clientException = new ClientException("malformed_url", "Unable to construct cloud discovery URL", e2);
            clientException2 = clientException;
        }
        StringBuilder sb2 = new StringBuilder();
        String str2 = TAG;
        sb2.append(str2);
        sb2.append(":getKnownAuthorityResult");
        Logger.info(sb2.toString(), "Cloud discovery complete.");
        boolean z = false;
        if (clientException2 == null) {
            if (isKnownAuthority(authority)) {
                Logger.info(str2 + ":getKnownAuthorityResult", "Cloud is known.");
                z = true;
            } else {
                clientException2 = new ClientException("unknown_authority", "Provided authority is not known.  MSAL will only make requests to known authorities");
            }
        }
        return new KnownAuthorityResult(z, clientException2);
    }

    public static boolean isKnownAuthority(Authority authority) {
        boolean z;
        if (authority == null) {
            AbstractC4539a.m3189C(new StringBuilder(), TAG, ":isKnownAuthority", "Authority is null");
            return false;
        }
        Iterator<Authority> it = knownAuthorities.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Authority next = it.next();
            if (next.mAuthorityUrlString != null && authority.getAuthorityURL() != null && authority.getAuthorityURL().getAuthority() != null) {
                String str = next.mAuthorityUrlString;
                Locale locale = Locale.ROOT;
                if (str.toLowerCase(locale).contains(authority.getAuthorityURL().getAuthority().toLowerCase(locale))) {
                    z = true;
                    break;
                }
            }
        }
        boolean zHasCloudHost = AzureActiveDirectory.hasCloudHost(authority.getAuthorityURL());
        boolean z2 = z || zHasCloudHost;
        StringBuilder sb = new StringBuilder();
        String str2 = TAG;
        Logger.verbose(AbstractC0622a.m1170p(str2, ":isKnownAuthority", sb), "Authority is known to developer? [" + z + "]");
        Logger.verbose(str2 + ":isKnownAuthority", "Authority is known to Microsoft? [" + zHasCloudHost + "]");
        return z2;
    }

    private static void performCloudDiscovery() {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        sb.append(str);
        sb.append(":performCloudDiscovery");
        Logger.info(sb.toString(), "Performing cloud discovery...");
        synchronized (sLock) {
            try {
                Logger.info(str + ":performCloudDiscovery", "Acquired lock.");
                if (!AzureActiveDirectory.isInitialized()) {
                    Logger.info(str + ":performCloudDiscovery", "Not initialized. Starting request.");
                    AzureActiveDirectory.performCloudDiscovery();
                    Logger.info(str + ":performCloudDiscovery", "Loaded cloud metadata.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract OAuth2Strategy createOAuth2Strategy(@NonNull OAuth2StrategyParameters oAuth2StrategyParameters);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Authority)) {
            return false;
        }
        Authority authority = (Authority) obj;
        if (this.mAuthorityTypeString.equals(authority.mAuthorityTypeString)) {
            return getAuthorityUri().equals(authority.getAuthorityUri());
        }
        return false;
    }

    public String getAuthorityTypeString() {
        return this.mAuthorityTypeString;
    }

    public URL getAuthorityURL() {
        try {
            return getAuthorityUri().toURL();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Authority URI is not a URL.", e);
        }
    }

    public URI getAuthorityUri() {
        try {
            return new URI(this.mAuthorityUrlString);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Authority URL is not a URI.", e);
        }
    }

    public boolean getDefault() {
        return this.mIsDefault;
    }

    public AzureActiveDirectorySlice getSlice() {
        return this.mSlice;
    }

    public int hashCode() {
        return getAuthorityUri().hashCode() + (this.mAuthorityTypeString.hashCode() * 31);
    }

    public void setDefault(Boolean bool) {
        this.mIsDefault = bool.booleanValue();
    }

    public void setSlice(AzureActiveDirectorySlice azureActiveDirectorySlice) {
        this.mSlice = azureActiveDirectorySlice;
    }
}
