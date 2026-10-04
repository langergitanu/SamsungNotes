package com.microsoft.identity.client;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.client.configuration.AccountMode;
import com.microsoft.identity.client.configuration.HttpConfiguration;
import com.microsoft.identity.client.configuration.LoggerConfiguration;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.AuthenticationSettings;
import com.microsoft.identity.common.internal.authorities.UnknownAudience;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import com.microsoft.identity.common.internal.telemetry.TelemetryConfiguration;
import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAuthority;
import com.microsoft.identity.common.java.authorities.Environment;
import com.microsoft.identity.common.java.authorities.UnknownAuthority;
import com.microsoft.identity.common.java.configuration.LibraryConfiguration;
import com.microsoft.identity.common.java.p132ui.AuthorizationAgent;
import com.microsoft.identity.common.java.p132ui.BrowserDescriptor;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PublicClientApplicationConfiguration {
    private static final String BROKER_REDIRECT_URI_SCHEME_AND_SEPARATOR = "msauth://";
    public static final String INVALID_REDIRECT_MSG = "Invalid, null, or malformed redirect_uri supplied";
    private static final String TAG = "PublicClientApplicationConfiguration";

    @SerializedName("handle_null_taskaffinity")
    private Boolean handleNullTaskAffinity;

    @SerializedName("authorization_in_current_task")
    private Boolean isAuthorizationInCurrentTask;

    @SerializedName("account_mode")
    private AccountMode mAccountMode;
    private transient Context mAppContext;

    @SerializedName("authorities")
    private List<Authority> mAuthorities;

    @SerializedName("authorization_user_agent")
    private AuthorizationAgent mAuthorizationAgent;

    @SerializedName("browser_safelist")
    private List<BrowserDescriptor> mBrowserSafeList;

    @SerializedName("client_capabilities")
    private String mClientCapabilities;

    @SerializedName("client_id")
    private String mClientId;

    @SerializedName("environment")
    private Environment mEnvironment;

    @SerializedName("http")
    private HttpConfiguration mHttpConfiguration;
    private transient boolean mIsSharedDevice = false;

    @SerializedName("logging")
    private LoggerConfiguration mLoggerConfiguration;

    @SerializedName("multiple_clouds_supported")
    private Boolean mMultipleCloudsSupported;
    private transient OAuth2TokenCache mOAuth2TokenCache;

    @SerializedName("preferred_browser")
    private BrowserDescriptor mPreferredBrowser;

    @SerializedName("redirect_uri")
    private String mRedirectUri;

    @SerializedName("minimum_required_broker_protocol_version")
    private String mRequiredBrokerProtocolVersion;

    @SerializedName("telemetry")
    private TelemetryConfiguration mTelemetryConfiguration;

    @SerializedName("broker_redirect_uri_registered")
    private Boolean mUseBroker;

    @SerializedName("power_opt_check_for_network_req_enabled")
    private Boolean powerOptCheckEnabled;

    @SerializedName("web_view_zoom_controls_enabled")
    private Boolean webViewZoomControlsEnabled;

    @SerializedName("web_view_zoom_enabled")
    private Boolean webViewZoomEnabled;

    @SerializedName("webauthn_capable")
    private Boolean webauthnCapable;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SerializedNames {
        static final String ACCOUNT_MODE = "account_mode";
        static final String AUTHORITIES = "authorities";
        static final String AUTHORIZATION_IN_CURRENT_TASK = "authorization_in_current_task";
        static final String AUTHORIZATION_USER_AGENT = "authorization_user_agent";
        static final String BROWSER_SAFE_LIST = "browser_safelist";
        static final String CLIENT_CAPABILITIES = "client_capabilities";
        static final String CLIENT_ID = "client_id";
        static final String ENVIRONMENT = "environment";
        static final String HANDLE_TASKS_WITH_NULL_TASKAFFINITY = "handle_null_taskaffinity";
        static final String HTTP = "http";
        static final String LOGGING = "logging";
        static final String MULTIPLE_CLOUDS_SUPPORTED = "multiple_clouds_supported";
        static final String POWER_OPT_CHECK_FOR_NETWORK_REQUEST_ENABLED = "power_opt_check_for_network_req_enabled";
        static final String PREFERRED_BROWSER = "preferred_browser";
        static final String REDIRECT_URI = "redirect_uri";
        static final String REQUIRED_BROKER_PROTOCOL_VERSION = "minimum_required_broker_protocol_version";
        static final String TELEMETRY = "telemetry";
        static final String USE_BROKER = "broker_redirect_uri_registered";
        static final String WEBAUTHN_CAPABLE = "webauthn_capable";
        static final String WEB_VIEW_ZOOM_CONTROLS_ENABLED = "web_view_zoom_controls_enabled";
        static final String WEB_VIEW_ZOOM_ENABLED = "web_view_zoom_enabled";
    }

    private void checkDefaultAuthoritySpecified() {
        List<Authority> list = this.mAuthorities;
        if (list == null || list.size() <= 1) {
            return;
        }
        Iterator<Authority> it = this.mAuthorities.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getDefault()) {
                i++;
            }
        }
        if (i == 0) {
            throw new IllegalArgumentException("One authority in your configuration must be marked as default.");
        }
        if (i > 1) {
            throw new IllegalArgumentException("More than one authority in your configuration is marked as default.  Only one authority may be default.");
        }
    }

    private void checkManifestPermissions() {
        Boolean bool = this.handleNullTaskAffinity;
        if (bool != null && bool.booleanValue() && this.mAppContext.getPackageManager().checkPermission("android.permission.REORDER_TASKS", this.mAppContext.getPackageName()) != 0) {
            throw new IllegalStateException("You requested that we handle null taskAffinity but your manifest does not include the REORDER_TASKS permission");
        }
    }

    private boolean hasSchemeAndAuthority(@NonNull String str) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":hasSchemeAndAuthority", new StringBuilder());
        try {
            Uri uri = Uri.parse(str);
            return (TextUtils.isEmpty(uri.getScheme()) || TextUtils.isEmpty(uri.getAuthority())) ? false : true;
        } catch (NullPointerException e) {
            com.microsoft.identity.common.internal.logging.Logger.errorPII(strM1170p, INVALID_REDIRECT_MSG, e);
            return false;
        }
    }

    @VisibleForTesting
    public static boolean isBrokerRedirectUri(@NonNull String str, @NonNull String str2) {
        return str != null && str.startsWith(AbstractC0541b.m773o("msauth://", str2, "/"));
    }

    private boolean isValidAuthenticatorRedirectUri() {
        Signature[] signatureArr;
        String strM1170p = AbstractC0622a.m1170p(TAG, ":isValidAuthenticatorRedirectUri", new StringBuilder());
        try {
            PackageInfo packageInfo = this.mAppContext.getPackageManager().getPackageInfo(AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_PACKAGE_NAME, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                Signature signature = signatureArr[0];
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
                messageDigest.update(signature.toByteArray());
                String strEncodeToString = Base64.encodeToString(messageDigest.digest(), 2);
                if (AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_RELEASE_SIGNATURE_SHA512.equalsIgnoreCase(strEncodeToString) || AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_DEBUG_SIGNATURE_SHA512.equalsIgnoreCase(strEncodeToString)) {
                    MessageDigest messageDigest2 = MessageDigest.getInstance("SHA");
                    messageDigest2.update(signature.toByteArray());
                    if (this.mRedirectUri.equalsIgnoreCase(new Uri.Builder().scheme("msauth").authority(this.mAppContext.getPackageName()).appendPath(Base64.encodeToString(messageDigest2.digest(), 2)).build().toString()) || this.mRedirectUri.equalsIgnoreCase("urn:ietf:wg:oauth:2.0:oob")) {
                        return true;
                    }
                    if (this.mRedirectUri.equalsIgnoreCase(AuthenticationConstants.Broker.NEW_BROKER_REDIRECT_URI)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            com.microsoft.identity.common.internal.logging.Logger.error(strM1170p, "Unexpected error in getting package info/signature for Authenticator", e);
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            com.microsoft.identity.common.internal.logging.Logger.error(strM1170p, "Unexpected error in getting package info/signature for Authenticator", e);
        }
        return false;
    }

    private static void nullConfigurationCheck(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException(AbstractC0541b.m756B(str, " cannot be null.  Invalid configuration."));
        }
    }

    private void validateAzureActiveDirectoryAuthority(@NonNull AzureActiveDirectoryAuthority azureActiveDirectoryAuthority) {
        AzureActiveDirectoryAudience azureActiveDirectoryAudience = azureActiveDirectoryAuthority.mAudience;
        if (azureActiveDirectoryAudience != null && (azureActiveDirectoryAudience instanceof UnknownAudience)) {
            throw new IllegalArgumentException("Unrecognized audience type for AzureActiveDirectoryAuthority -- null, invalid, or unknown type specified");
        }
    }

    private static boolean validateCustomTabRedirectActivity(@NonNull Context context, @NonNull String str) throws MsalClientException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":validateCustomTabRedirectActivity", new StringBuilder());
        PackageManager packageManager = context.getPackageManager();
        boolean z = false;
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setDataAndNormalize(Uri.parse(str));
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 64).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            String name = BrowserTabActivity.class.getName();
            if (LibraryConfiguration.getInstance().isAuthorizationInCurrentTask()) {
                name = CurrentTaskBrowserTabActivity.class.getName();
            }
            if (!activityInfo.name.equals(name) || !activityInfo.packageName.equals(context.getPackageName())) {
                com.microsoft.identity.common.logging.Logger.warn(strM1170p, "Another application " + activityInfo.packageName + " is listening for the URL scheme " + str);
                throw new MsalClientException(MsalClientException.MULTIPLE_APPS_LISTENING_CUSTOM_URL_SCHEME, "More than one app is listening for the URL scheme defined for BrowserTabActivity in the AndroidManifest. The package name of this other app is: " + activityInfo.packageName);
            }
            z = true;
        }
        return z;
    }

    private void validateRedirectUri(@NonNull String str) {
        boolean z;
        Context context = this.mAppContext;
        boolean z2 = true;
        if (context == null || !AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_PACKAGE_NAME.equalsIgnoreCase(context.getPackageName())) {
            if (!TextUtils.isEmpty(str) && hasSchemeAndAuthority(str)) {
                z2 = false;
            }
            z = z2;
        } else {
            z = !isValidAuthenticatorRedirectUri();
        }
        if (z) {
            throw new IllegalArgumentException(INVALID_REDIRECT_MSG);
        }
    }

    private void verifyRedirectUriWithAppSignature() throws MsalClientException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":verifyRedirectUriWithAppSignature", new StringBuilder());
        String packageName = this.mAppContext.getPackageName();
        try {
            Signature[] signatures = PackageHelper.getSignatures(PackageHelper.getPackageInfo(this.mAppContext.getPackageManager(), packageName));
            if (signatures.length > 0) {
                Signature signature = signatures[0];
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                Uri uriBuild = new Uri.Builder().scheme("msauth").authority(packageName).appendPath(Base64.encodeToString(messageDigest.digest(), 2)).build();
                if (this.mRedirectUri.equalsIgnoreCase(uriBuild.toString())) {
                    return;
                }
                throw new MsalClientException(MsalClientException.REDIRECT_URI_VALIDATION_ERROR, "The redirect URI in the configuration file doesn't match with the one generated with package name and signature hash. Please verify the uri in the config file and your app registration in Azure portal.We expected '" + uriBuild.toString() + "' and we received '" + this.mRedirectUri + "'.");
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            com.microsoft.identity.common.internal.logging.Logger.error(strM1170p, "Unexpected error in verifyRedirectUriWithAppSignature()", e);
            throw new MsalClientException("unknown_error", "Unexpected error in verifyRedirectUriWithAppSignature()", e);
        }
    }

    public Boolean authorizationInCurrentTask() {
        return this.isAuthorizationInCurrentTask;
    }

    public void checkIntentFilterAddedToAppManifestForBrokerFlow() throws MsalClientException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":checkIntentFilterAddedToAppManifestForBrokerFlow", new StringBuilder());
        if ((getAuthorizationAgent() == AuthorizationAgent.DEFAULT || getAuthorizationAgent() == AuthorizationAgent.BROWSER) && !validateCustomTabRedirectActivity(this.mAppContext, this.mRedirectUri)) {
            String str = LibraryConfiguration.getInstance().isAuthorizationInCurrentTask() ? "CurrentTaskBrowserTabActivity" : "BrowserTabActivity";
            Uri uri = Uri.parse(this.mRedirectUri);
            StringBuilder sbM16m = AbstractC0000a.m16m("Intent filter for: ", str, " is missing.  Please make sure you have the following activity in your AndroidManifest.xml \n\n<activity android:name=\"com.microsoft.identity.client.", str, "\">\n\t<intent-filter>\n\t\t<action android:name=\"android.intent.action.VIEW\" />\n\t\t<category android:name=\"android.intent.category.DEFAULT\" />\n\t\t<category android:name=\"android.intent.category.BROWSABLE\" />\n\t\t<data\n\t\t\tandroid:host=\"");
            sbM16m.append(uri.getHost());
            sbM16m.append("\"\n\t\t\tandroid:path=\"");
            sbM16m.append(uri.getPath());
            sbM16m.append("\"\n\t\t\tandroid:scheme=\"");
            sbM16m.append(uri.getScheme());
            sbM16m.append("\" />\n\t</intent-filter>\n</activity>\n");
            throw new MsalClientException(MsalClientException.APP_MANIFEST_VALIDATION_ERROR, sbM16m.toString());
        }
        if (this.mUseBroker.booleanValue()) {
            Context context = this.mAppContext;
            if (context != null && AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_PACKAGE_NAME.equalsIgnoreCase(context.getPackageName()) && isValidAuthenticatorRedirectUri()) {
                return;
            }
            Context context2 = this.mAppContext;
            if (context2 == null || isBrokerRedirectUri(this.mRedirectUri, context2.getPackageName())) {
                verifyRedirectUriWithAppSignature();
            } else {
                com.microsoft.identity.common.internal.logging.Logger.warn(strM1170p, "The app is still using legacy MSAL redirect uri. Switch to MSAL local auth.  For brokered auth, the redirect URI is expected to conform to 'msauth://<authority>/.*' where the authority in that uri is the package name of the app. This package name is listed as 'applicationId' in the build.gradle file.");
                this.mUseBroker = Boolean.FALSE;
            }
        }
    }

    public AccountMode getAccountMode() {
        return this.mAccountMode;
    }

    public Context getAppContext() {
        return this.mAppContext;
    }

    public List<Authority> getAuthorities() {
        return this.mAuthorities;
    }

    public AuthorizationAgent getAuthorizationAgent() {
        return this.mAuthorizationAgent;
    }

    public List<BrowserDescriptor> getBrowserSafeList() {
        return this.mBrowserSafeList;
    }

    public String getClientCapabilities() {
        return this.mClientCapabilities;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public Authority getDefaultAuthority() {
        List<Authority> list = this.mAuthorities;
        if (list == null) {
            return null;
        }
        if (list.size() <= 1) {
            return this.mAuthorities.get(0);
        }
        for (Authority authority : this.mAuthorities) {
            if (authority.getDefault()) {
                return authority;
            }
        }
        return null;
    }

    public Environment getEnvironment() {
        return this.mEnvironment;
    }

    public HttpConfiguration getHttpConfiguration() {
        return this.mHttpConfiguration;
    }

    public boolean getIsSharedDevice() {
        return this.mIsSharedDevice;
    }

    public LoggerConfiguration getLoggerConfiguration() {
        return this.mLoggerConfiguration;
    }

    public Boolean getMultipleCloudsSupported() {
        return this.mMultipleCloudsSupported;
    }

    public OAuth2TokenCache getOAuth2TokenCache() {
        return this.mOAuth2TokenCache;
    }

    public BrowserDescriptor getPreferredBrowser() {
        return this.mPreferredBrowser;
    }

    public String getRedirectUri() {
        return this.mRedirectUri;
    }

    public String getRequiredBrokerProtocolVersion() {
        return this.mRequiredBrokerProtocolVersion;
    }

    public TelemetryConfiguration getTelemetryConfiguration() {
        return this.mTelemetryConfiguration;
    }

    public Boolean getUseBroker() {
        return this.mUseBroker;
    }

    public boolean isDefaultAuthorityConfigured() {
        return getDefaultAuthority() != null;
    }

    public Boolean isHandleNullTaskAffinityEnabled() {
        return this.handleNullTaskAffinity;
    }

    public Boolean isPowerOptCheckForEnabled() {
        return this.powerOptCheckEnabled;
    }

    public boolean isWebViewZoomControlsEnabled() {
        return this.webViewZoomControlsEnabled.booleanValue();
    }

    public boolean isWebViewZoomEnabled() {
        return this.webViewZoomEnabled.booleanValue();
    }

    public Boolean isWebauthnCapable() {
        return Boolean.valueOf(Boolean.TRUE.equals(this.webauthnCapable));
    }

    public void mergeConfiguration(PublicClientApplicationConfiguration publicClientApplicationConfiguration) {
        String str = publicClientApplicationConfiguration.mClientId;
        if (str == null) {
            str = this.mClientId;
        }
        this.mClientId = str;
        String str2 = publicClientApplicationConfiguration.mRedirectUri;
        if (str2 == null) {
            str2 = this.mRedirectUri;
        }
        this.mRedirectUri = str2;
        List<Authority> list = publicClientApplicationConfiguration.mAuthorities;
        if (list == null) {
            list = this.mAuthorities;
        }
        this.mAuthorities = list;
        AuthorizationAgent authorizationAgent = publicClientApplicationConfiguration.mAuthorizationAgent;
        if (authorizationAgent == null) {
            authorizationAgent = this.mAuthorizationAgent;
        }
        this.mAuthorizationAgent = authorizationAgent;
        Environment environment = publicClientApplicationConfiguration.mEnvironment;
        if (environment == null) {
            environment = this.mEnvironment;
        }
        this.mEnvironment = environment;
        HttpConfiguration httpConfiguration = publicClientApplicationConfiguration.mHttpConfiguration;
        if (httpConfiguration == null) {
            httpConfiguration = this.mHttpConfiguration;
        }
        this.mHttpConfiguration = httpConfiguration;
        Boolean bool = publicClientApplicationConfiguration.mMultipleCloudsSupported;
        if (bool == null) {
            bool = this.mMultipleCloudsSupported;
        }
        this.mMultipleCloudsSupported = bool;
        Boolean bool2 = publicClientApplicationConfiguration.mUseBroker;
        if (bool2 == null) {
            bool2 = this.mUseBroker;
        }
        this.mUseBroker = bool2;
        TelemetryConfiguration telemetryConfiguration = publicClientApplicationConfiguration.mTelemetryConfiguration;
        if (telemetryConfiguration == null) {
            telemetryConfiguration = this.mTelemetryConfiguration;
        }
        this.mTelemetryConfiguration = telemetryConfiguration;
        String str3 = publicClientApplicationConfiguration.mRequiredBrokerProtocolVersion;
        if (str3 == null) {
            str3 = this.mRequiredBrokerProtocolVersion;
        }
        this.mRequiredBrokerProtocolVersion = str3;
        BrowserDescriptor browserDescriptor = publicClientApplicationConfiguration.mPreferredBrowser;
        if (browserDescriptor == null) {
            browserDescriptor = this.mPreferredBrowser;
        }
        this.mPreferredBrowser = browserDescriptor;
        List<BrowserDescriptor> list2 = this.mBrowserSafeList;
        if (list2 == null) {
            this.mBrowserSafeList = publicClientApplicationConfiguration.mBrowserSafeList;
        } else {
            List<BrowserDescriptor> list3 = publicClientApplicationConfiguration.mBrowserSafeList;
            if (list3 != null) {
                list2.addAll(list3);
            }
        }
        AccountMode accountMode = publicClientApplicationConfiguration.mAccountMode;
        if (accountMode == AccountMode.MULTIPLE || accountMode == null) {
            accountMode = this.mAccountMode;
        }
        this.mAccountMode = accountMode;
        String str4 = publicClientApplicationConfiguration.mClientCapabilities;
        if (str4 == null) {
            str4 = this.mClientCapabilities;
        }
        this.mClientCapabilities = str4;
        boolean z = publicClientApplicationConfiguration.mIsSharedDevice;
        if (z) {
            z = this.mIsSharedDevice;
        }
        this.mIsSharedDevice = z;
        LoggerConfiguration loggerConfiguration = publicClientApplicationConfiguration.mLoggerConfiguration;
        if (loggerConfiguration == null) {
            loggerConfiguration = this.mLoggerConfiguration;
        }
        this.mLoggerConfiguration = loggerConfiguration;
        Boolean bool3 = publicClientApplicationConfiguration.webViewZoomControlsEnabled;
        if (bool3 == null) {
            bool3 = this.webViewZoomControlsEnabled;
        }
        this.webViewZoomControlsEnabled = bool3;
        Boolean bool4 = publicClientApplicationConfiguration.webViewZoomEnabled;
        if (bool4 == null) {
            bool4 = this.webViewZoomEnabled;
        }
        this.webViewZoomEnabled = bool4;
        Boolean bool5 = publicClientApplicationConfiguration.powerOptCheckEnabled;
        if (bool5 == null) {
            bool5 = this.powerOptCheckEnabled;
        }
        this.powerOptCheckEnabled = bool5;
        Boolean bool6 = publicClientApplicationConfiguration.handleNullTaskAffinity;
        if (bool6 == null) {
            bool6 = this.handleNullTaskAffinity;
        }
        this.handleNullTaskAffinity = bool6;
        Boolean bool7 = publicClientApplicationConfiguration.isAuthorizationInCurrentTask;
        if (bool7 == null) {
            bool7 = this.isAuthorizationInCurrentTask;
        }
        this.isAuthorizationInCurrentTask = bool7;
        Boolean bool8 = publicClientApplicationConfiguration.webauthnCapable;
        if (bool8 == null) {
            bool8 = this.webauthnCapable;
        }
        this.webauthnCapable = bool8;
    }

    public void setAccountMode(AccountMode accountMode) {
        this.mAccountMode = accountMode;
    }

    public void setAppContext(Context context) {
        this.mAppContext = context;
    }

    public void setClientId(String str) {
        this.mClientId = str;
    }

    public void setIsSharedDevice(boolean z) {
        this.mIsSharedDevice = z;
    }

    public void setOAuth2TokenCache(OAuth2TokenCache oAuth2TokenCache) {
        this.mOAuth2TokenCache = oAuth2TokenCache;
    }

    public void setPowerOptCheckEnabled(Boolean bool) {
        this.powerOptCheckEnabled = bool;
    }

    public void setRedirectUri(@NonNull String str) {
        this.mRedirectUri = str;
    }

    public void setTokenCacheSecretKeys(@NonNull byte[] bArr) {
        AuthenticationSettings.INSTANCE.setSecretKey(bArr);
    }

    public void setWebViewZoomControlsEnabled(boolean z) {
        this.webViewZoomControlsEnabled = Boolean.valueOf(z);
    }

    public void setWebViewZoomEnabled(boolean z) {
        this.webViewZoomEnabled = Boolean.valueOf(z);
    }

    public void validateConfiguration() {
        List<BrowserDescriptor> list;
        validateRedirectUri(this.mRedirectUri);
        nullConfigurationCheck("client_id", this.mClientId);
        checkDefaultAuthoritySpecified();
        checkManifestPermissions();
        if (!this.mAuthorizationAgent.equals(AuthorizationAgent.WEBVIEW) && ((list = this.mBrowserSafeList) == null || list.isEmpty())) {
            throw new IllegalArgumentException("Null browser safe list configured.");
        }
        for (Authority authority : this.mAuthorities) {
            if (authority instanceof UnknownAuthority) {
                throw new IllegalArgumentException("Unrecognized authority type -- null, invalid or unknown type specified.");
            }
            if (authority instanceof AzureActiveDirectoryAuthority) {
                validateAzureActiveDirectoryAuthority((AzureActiveDirectoryAuthority) authority);
            }
        }
    }
}
