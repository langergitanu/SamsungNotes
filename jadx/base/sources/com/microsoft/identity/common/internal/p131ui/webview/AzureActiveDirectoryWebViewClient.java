package com.microsoft.identity.common.internal.p131ui.webview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.webkit.ClientCertRequest;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import com.microsoft.identity.common.internal.fido.AuthFidoChallengeHandler;
import com.microsoft.identity.common.internal.fido.CredManFidoManager;
import com.microsoft.identity.common.internal.fido.FidoChallenge;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractCertBasedAuthChallengeHandler;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.CertBasedAuthFactory;
import com.microsoft.identity.common.internal.p131ui.webview.challengehandlers.PKeyAuthChallengeHandler;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationActivity;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.challengehandlers.PKeyAuthChallengeFactory;
import com.microsoft.identity.common.java.constants.FidoConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightManager;
import com.microsoft.identity.common.java.p132ui.webview.authorization.IAuthorizationCompletionCallback;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.logging.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryWebViewClient extends OAuth2WebViewClient {
    private static final String DEVICE_CERT_ISSUER = "CN=MS-Organization-Access";
    public static final String ERROR = "error";
    public static final String ERROR_DESCRIPTION = "error_description";
    public static final String ERROR_SUBCODE = "error_subcode";
    private static final String TAG = "AzureActiveDirectoryWebViewClient";
    private AbstractCertBasedAuthChallengeHandler mCertBasedAuthChallengeHandler;
    private final CertBasedAuthFactory mCertBasedAuthFactory;
    private final String mRedirectUrl;
    private HashMap<String, String> mRequestHeaders;

    public AzureActiveDirectoryWebViewClient(@NonNull Activity activity, @NonNull IAuthorizationCompletionCallback iAuthorizationCompletionCallback, @NonNull OnPageLoadedCallback onPageLoadedCallback, @NonNull String str) {
        super(activity, iAuthorizationCompletionCallback, onPageLoadedCallback);
        this.mRedirectUrl = str;
        this.mCertBasedAuthFactory = new CertBasedAuthFactory(activity);
    }

    private boolean handleUrl(WebView webView, String str) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":handleUrl", new StringBuilder());
        String lowerCase = str.toLowerCase(Locale.US);
        try {
            if (isPkeyAuthUrl(lowerCase)) {
                Logger.info(strM1170p, "WebView detected request for pkeyauth challenge.");
                new PKeyAuthChallengeHandler(webView, getCompletionCallback()).processChallenge(new PKeyAuthChallengeFactory().getPKeyAuthChallengeFromWebViewRedirect(str));
                return true;
            }
            if (CommonFlightManager.isFlightEnabled(CommonFlight.ENABLE_PASSKEY_FEATURE) && isPasskeyUrl(lowerCase)) {
                Logger.info(strM1170p, "WebView detected request for passkey protocol.");
                new AuthFidoChallengeHandler(new CredManFidoManager(webView.getContext()), webView, getActivity() instanceof AuthorizationActivity ? ((AuthorizationActivity) getActivity()).getSpanContext() : null, ViewTreeLifecycleOwner.get(webView)).processChallenge(FidoChallenge.createFromRedirectUri(str));
                return true;
            }
            if (isRedirectUrl(lowerCase)) {
                Logger.info(strM1170p, "Navigation starts with the redirect uri.");
                processRedirectUrl(webView, str);
                return true;
            }
            if (isWebsiteRequestUrl(lowerCase)) {
                Logger.info(strM1170p, "It is an external website request");
                processWebsiteRequest(webView, str);
                return true;
            }
            if (isInstallRequestUrl(lowerCase)) {
                Logger.info(strM1170p, "It is an install request");
                processInstallRequest(webView, str);
                return true;
            }
            if (isWebCpUrl(lowerCase)) {
                Logger.info(strM1170p, "It is a request from WebCP");
                processWebCpRequest(webView, str);
                return true;
            }
            if (isPlayStoreUrl(lowerCase)) {
                Logger.info(strM1170p, "Request to open PlayStore.");
                return processPlayStoreURL(webView, str);
            }
            if (isAuthAppMFAUrl(lowerCase)) {
                Logger.info(strM1170p, "Request to link account with Authenticator.");
                processAuthAppMFAUrl(str);
                return true;
            }
            if (isAmazonAppRedirect(lowerCase)) {
                Logger.info(strM1170p, "It is an Amazon app request");
                processAmazonAppUri(str);
                return true;
            }
            if (isInvalidRedirectUri(str)) {
                Logger.info(strM1170p, "Check for Redirect Uri.");
                processInvalidRedirectUri(webView, str);
                return true;
            }
            if (isBlankPageRequest(lowerCase)) {
                Logger.info(strM1170p, "It is an blank page request");
                return true;
            }
            if (!isUriSSLProtected(lowerCase)) {
                Logger.info(strM1170p, "Check for SSL protection");
                processSSLProtectionCheck(webView, str);
                return true;
            }
            if (isHeaderForwardingRequiredUri(str)) {
                processHeaderForwardingRequiredUri(webView, str);
                return true;
            }
            Logger.info(strM1170p, "This maybe a valid URI, but no special handling for this mentioned URI, hence deferring to WebView for loading.");
            processInvalidUrl(str);
            return false;
        } catch (ClientException e) {
            Logger.error(strM1170p, e.getErrorCode(), null);
            Logger.errorPII(strM1170p, e.getMessage(), e);
            returnError(e.getErrorCode(), e.getMessage());
            webView.stopLoading();
            return true;
        }
    }

    private boolean isAmazonAppRedirect(@NonNull String str) {
        return str.startsWith(AuthenticationConstants.Broker.AMAZON_APP_REDIRECT_PREFIX);
    }

    private boolean isAuthAppMFAUrl(@NonNull String str) {
        return str.startsWith(AuthenticationConstants.Broker.AUTHENTICATOR_MFA_LINKING_PREFIX);
    }

    private boolean isBlankPageRequest(@NonNull String str) {
        return "about:blank".equals(str);
    }

    private boolean isBrokerRequest(Intent intent) {
        return (intent == null || StringExtensions.isNullOrBlank(intent.getStringExtra(AuthenticationConstants.Broker.BROKER_REQUEST))) ? false : true;
    }

    private boolean isHeaderForwardingRequiredUri(@NonNull String str) {
        boolean zStartsWith = str.startsWith("https://login.live.com/");
        HashMap<String, String> map = this.mRequestHeaders;
        return zStartsWith && (map != null && !map.isEmpty());
    }

    private boolean isInstallRequestUrl(@NonNull String str) {
        return str.startsWith(AuthenticationConstants.Broker.BROWSER_EXT_INSTALL_PREFIX);
    }

    private boolean isInvalidRedirectUri(@NonNull String str) {
        return isBrokerRequest(getActivity().getIntent()) && str.startsWith("msauth");
    }

    private boolean isPasskeyUrl(@NonNull String str) {
        return str.startsWith(FidoConstants.PASSKEY_PROTOCOL_REDIRECT.toLowerCase(Locale.ROOT));
    }

    private boolean isPkeyAuthUrl(@NonNull String str) {
        return str.startsWith(AuthenticationConstants.Broker.PKEYAUTH_REDIRECT.toLowerCase(Locale.ROOT));
    }

    private boolean isPlayStoreUrl(@NonNull String str) {
        return str.startsWith(AuthenticationConstants.Broker.PLAY_STORE_INSTALL_PREFIX);
    }

    private boolean isRedirectUrl(@NonNull String str) {
        return str.startsWith(this.mRedirectUrl.toLowerCase(Locale.US));
    }

    private boolean isUriSSLProtected(@NonNull String str) {
        return str.startsWith("https://");
    }

    private boolean isWebCpUrl(@NonNull String str) {
        return str.startsWith(AuthenticationConstants.Broker.BROWSER_EXT_WEB_CP);
    }

    private boolean isWebsiteRequestUrl(@NonNull String str) {
        return str.startsWith(AuthenticationConstants.Broker.BROWSER_EXT_PREFIX);
    }

    private void launchCompanyPortal() {
        Logger.verbose(TAG + ":launchCompanyPortal", "Sending intent to launch the CompanyPortal.");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(AuthenticationConstants.Broker.COMPANY_PORTAL_APP_PACKAGE_NAME, AuthenticationConstants.Broker.COMPANY_PORTAL_APP_LAUNCH_ACTIVITY_NAME));
        intent.addFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        getActivity().startActivity(intent);
        returnResult(RawAuthorizationResult.ResultCode.MDM_FLOW);
    }

    private void openLinkInBrowser(String str) {
        String str2 = TAG + ":openLinkInBrowser";
        Logger.info(str2, "Try to open url link in browser");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str.replace(AuthenticationConstants.Broker.BROWSER_EXT_PREFIX, "https://")));
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            getActivity().startActivity(intent);
        } else {
            Logger.warn(str2, "Unable to find an app to resolve the activity.");
        }
    }

    private void processAmazonAppUri(@NonNull String str) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":processAmazonAppUri", new StringBuilder());
        getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        Logger.info(strM1170p, "Sent Intent to launch Amazon app");
    }

    private void processAuthAppMFAUrl(String str) {
        String str2 = TAG + ":processAuthAppMFAUrl";
        Logger.verbose(str2, "Linking Account in Broker for MFA.");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            getActivity().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Logger.error(str2, "Failed to open the Authenticator application.", e);
        }
    }

    private void processHeaderForwardingRequiredUri(@NonNull WebView webView, @NonNull String str) {
        Logger.infoPII(AbstractC0622a.m1170p(TAG, ":processHeaderForwardingRequiredUri", new StringBuilder()), "We are loading this new URL: '" + removeQueryParametersOrRedact(str) + "' with original requestHeaders appended.");
        webView.loadUrl(str, this.mRequestHeaders);
    }

    private void processInstallRequest(@NonNull final WebView webView, @NonNull String str) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":processInstallRequest", new StringBuilder());
        RawAuthorizationResult rawAuthorizationResultFromRedirectUri = RawAuthorizationResult.fromRedirectUri(str);
        if (rawAuthorizationResultFromRedirectUri.getResultCode() != RawAuthorizationResult.ResultCode.BROKER_INSTALLATION_TRIGGERED) {
            getCompletionCallback().onChallengeResponseReceived(rawAuthorizationResultFromRedirectUri);
            webView.stopLoading();
            return;
        }
        final String str2 = StringExtensions.getUrlParameters(str).get(AuthenticationConstants.AAD.APP_LINK_KEY);
        Logger.info(strM1170p, "Launching the link to app:" + str2);
        getCompletionCallback().onChallengeResponseReceived(rawAuthorizationResultFromRedirectUri);
        new Handler().postDelayed(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.AzureActiveDirectoryWebViewClient.1
            @Override // java.lang.Runnable
            public void run() {
                AzureActiveDirectoryWebViewClient.this.getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2.replace(AuthenticationConstants.Broker.BROWSER_EXT_PREFIX, "https://"))));
                webView.stopLoading();
            }
        }, 1000L);
        webView.stopLoading();
    }

    private void processInvalidRedirectUri(@NonNull WebView webView, @NonNull String str) {
        String str2 = TAG + ":processInvalidRedirectUri";
        Logger.error(str2, "The RedirectUri is not as expected.", null);
        Logger.errorPII(str2, AbstractC0541b.m774p("Received ", str, " and expected ", this.mRedirectUrl), null);
        returnError(ErrorStrings.DEVELOPER_REDIRECTURI_INVALID, AbstractC0541b.m774p("The RedirectUri is not as expected. Received ", str, " and expected ", this.mRedirectUrl));
        webView.stopLoading();
    }

    private void processInvalidUrl(@NonNull String str) {
        Logger.infoPII(AbstractC0622a.m1170p(TAG, ":processInvalidUrl", new StringBuilder()), "We are declining to override loading and redirect to invalid URL: '" + removeQueryParametersOrRedact(str) + "' the user's url pattern is '" + this.mRedirectUrl + "'");
    }

    private boolean processPlayStoreURL(@NonNull WebView webView, @NonNull String str) {
        String str2 = TAG + ":processPlayStoreURL";
        webView.stopLoading();
        if (!str.startsWith("market://details?id=com.microsoft.windowsintune.companyportal") && !str.startsWith("market://details?id=com.azure.authenticator")) {
            Logger.info(str2, "The URI is either trying to open an unknown application or contains unknown query parameters");
            return false;
        }
        String str3 = AuthenticationConstants.Broker.COMPANY_PORTAL_APP_PACKAGE_NAME;
        if (!str.contains(AuthenticationConstants.Broker.COMPANY_PORTAL_APP_PACKAGE_NAME)) {
            str3 = AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_PACKAGE_NAME;
        }
        Logger.info(str2, "Request to open PlayStore to install package : '" + str3 + "'");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(AuthenticationConstants.Broker.PLAY_STORE_INSTALL_PREFIX.concat(str3)));
            intent.addFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
            getActivity().startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            Logger.error(str2, "PlayStore is not present on the device", e);
            return true;
        }
    }

    private void processSSLProtectionCheck(@NonNull WebView webView, @NonNull String str) {
        Logger.error(AbstractC0622a.m1170p(TAG, ":processSSLProtectionCheck", new StringBuilder()), "The webView was redirected to an unsafe URL: " + removeQueryParametersOrRedact(str), null);
        returnError(ErrorStrings.WEBVIEW_REDIRECTURL_NOT_SSL_PROTECTED, "The webView was redirected to an unsafe URL.");
        webView.stopLoading();
    }

    private void processWebCpRequest(@NonNull WebView webView, @NonNull String str) {
        webView.stopLoading();
        if (str.equalsIgnoreCase(AuthenticationConstants.Broker.WEBCP_LAUNCH_COMPANY_PORTAL_URL)) {
            launchCompanyPortal();
        } else {
            returnError(ErrorStrings.WEBCP_URI_INVALID, "Unexpected URL from WebCP: ".concat(str));
        }
    }

    private void processWebsiteRequest(@NonNull WebView webView, @NonNull String str) {
        String str2 = TAG + ":processWebsiteRequest";
        webView.stopLoading();
        if (!str.contains(AuthenticationConstants.Broker.BROWSER_DEVICE_CA_URL_QUERY_STRING_PARAMETER)) {
            openLinkInBrowser(str);
            returnResult(RawAuthorizationResult.ResultCode.CANCELLED);
            return;
        }
        Logger.info(str2, "This is a device CA request.");
        PackageHelper packageHelper = new PackageHelper(getActivity().getPackageManager());
        if (packageHelper.isPackageInstalledAndEnabled(AuthenticationConstants.Broker.IPPHONE_APP_PACKAGE_NAME) && AuthenticationConstants.Broker.IPPHONE_APP_SIGNATURE.equals(packageHelper.getSha1SignatureForPackage(AuthenticationConstants.Broker.IPPHONE_APP_PACKAGE_NAME)) && packageHelper.isPackageInstalledAndEnabled(AuthenticationConstants.Broker.COMPANY_PORTAL_APP_PACKAGE_NAME)) {
            try {
                launchCompanyPortal();
                return;
            } catch (Exception unused) {
                Logger.warn(str2, "Failed to launch Company Portal, falling back to browser.");
            }
        }
        openLinkInBrowser(str);
        returnResult(RawAuthorizationResult.ResultCode.MDM_FLOW);
    }

    private String removeQueryParametersOrRedact(@NonNull String str) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":removeQueryParametersOrRedact", new StringBuilder());
        try {
            return StringExtensions.removeQueryParameterFromUrl(str);
        } catch (URISyntaxException e) {
            Logger.errorPII(strM1170p, "Redirect URI has invalid syntax, unable to parse", e);
            return "redacted";
        }
    }

    private void returnError(String str, String str2) {
        getCompletionCallback().onChallengeResponseReceived(RawAuthorizationResult.fromException(new ClientException(str, str2)));
    }

    private void returnResult(RawAuthorizationResult.ResultCode resultCode) {
        getCompletionCallback().onChallengeResponseReceived(RawAuthorizationResult.fromResultCode(resultCode));
    }

    public void finalizeBeforeSendingResult(@NonNull RawAuthorizationResult rawAuthorizationResult, @NonNull ISendResultCallback iSendResultCallback) {
        AbstractCertBasedAuthChallengeHandler abstractCertBasedAuthChallengeHandler = this.mCertBasedAuthChallengeHandler;
        if (abstractCertBasedAuthChallengeHandler == null) {
            iSendResultCallback.onResultReady();
            return;
        }
        abstractCertBasedAuthChallengeHandler.emitTelemetryForCertBasedAuthResults(rawAuthorizationResult);
        AbstractCertBasedAuthChallengeHandler abstractCertBasedAuthChallengeHandler2 = this.mCertBasedAuthChallengeHandler;
        if (abstractCertBasedAuthChallengeHandler2 instanceof AbstractSmartcardCertBasedAuthChallengeHandler) {
            ((AbstractSmartcardCertBasedAuthChallengeHandler) abstractCertBasedAuthChallengeHandler2).promptSmartcardRemovalForResult(iSendResultCallback);
        } else {
            iSendResultCallback.onResultReady();
        }
    }

    public void onDestroy() {
        AbstractCertBasedAuthChallengeHandler abstractCertBasedAuthChallengeHandler = this.mCertBasedAuthChallengeHandler;
        if (abstractCertBasedAuthChallengeHandler != null) {
            abstractCertBasedAuthChallengeHandler.cleanUp();
        }
        this.mCertBasedAuthFactory.onDestroy();
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public void onReceivedClientCertRequest(@NonNull WebView webView, @NonNull final ClientCertRequest clientCertRequest) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":onReceivedClientCertRequest", new StringBuilder());
        Principal[] principals = clientCertRequest.getPrincipals();
        if (principals != null) {
            for (Principal principal : principals) {
                if (principal.getName().contains(DEVICE_CERT_ISSUER)) {
                    Logger.info(strM1170p, "Cancelling the TLS request, not responding to TLS challenge triggered by device authentication.");
                    clientCertRequest.cancel();
                    return;
                }
            }
        }
        AbstractCertBasedAuthChallengeHandler abstractCertBasedAuthChallengeHandler = this.mCertBasedAuthChallengeHandler;
        if (abstractCertBasedAuthChallengeHandler != null) {
            abstractCertBasedAuthChallengeHandler.cleanUp();
        }
        this.mCertBasedAuthFactory.createCertBasedAuthChallengeHandler(new CertBasedAuthFactory.CertBasedAuthChallengeHandlerCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.AzureActiveDirectoryWebViewClient.2
            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.CertBasedAuthFactory.CertBasedAuthChallengeHandlerCallback
            public void onReceived(@Nullable AbstractCertBasedAuthChallengeHandler abstractCertBasedAuthChallengeHandler2) {
                AzureActiveDirectoryWebViewClient.this.mCertBasedAuthChallengeHandler = abstractCertBasedAuthChallengeHandler2;
                if (AzureActiveDirectoryWebViewClient.this.mCertBasedAuthChallengeHandler == null) {
                    clientCertRequest.cancel();
                } else {
                    AzureActiveDirectoryWebViewClient.this.mCertBasedAuthChallengeHandler.processChallenge(clientCertRequest);
                }
            }
        });
    }

    public void processRedirectUrl(@NonNull WebView webView, @NonNull String str) {
        Logger.info(TAG + ":processRedirectUrl", "It is pointing to redirect. Final url can be processed to get the code or error.");
        getCompletionCallback().onChallengeResponseReceived(RawAuthorizationResult.fromRedirectUri(str));
        webView.stopLoading();
    }

    public void setRequestHeaders(HashMap<String, String> map) {
        this.mRequestHeaders = map;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("Redirect to empty url in web view.");
        }
        return handleUrl(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(24)
    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return handleUrl(webView, webResourceRequest.getUrl().toString());
    }
}
