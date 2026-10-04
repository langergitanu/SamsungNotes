package com.microsoft.identity.common.internal.providers.oauth2;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.microsoft.identity.common.C6228R;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.p131ui.webview.AzureActiveDirectoryWebViewClient;
import com.microsoft.identity.common.internal.p131ui.webview.ISendResultCallback;
import com.microsoft.identity.common.internal.p131ui.webview.OnPageLoadedCallback;
import com.microsoft.identity.common.internal.p131ui.webview.WebViewUtil;
import com.microsoft.identity.common.java.constants.FidoConstants;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightManager;
import com.microsoft.identity.common.java.p132ui.webview.authorization.IAuthorizationCompletionCallback;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.logging.Logger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import p017D1.C0061b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class WebViewAuthorizationFragment extends AuthorizationFragment {

    @VisibleForTesting
    private static final String PKEYAUTH_STATUS = "pkeyAuthStatus";
    private static final String TAG = "WebViewAuthorizationFragment";
    private AzureActiveDirectoryWebViewClient mAADWebViewClient;
    private Intent mAuthIntent;
    private String mAuthorizationRequestUrl;
    private PermissionRequest mCameraPermissionRequest;
    private String mPostPageLoadedJavascript;
    private ProgressBar mProgressBar;
    private String mRedirectUri;
    private HashMap<String, String> mRequestHeaders;
    private WebView mWebView;
    private boolean webViewZoomControlsEnabled;
    private boolean webViewZoomEnabled;
    private boolean mPkeyAuthStatus = false;
    private final ActivityResultLauncher<String> cameraRequestActivity = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new C0061b(this, 19));

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AuthorizationCompletionCallback implements IAuthorizationCompletionCallback {
        public AuthorizationCompletionCallback() {
        }

        @Override // com.microsoft.identity.common.java.p132ui.webview.authorization.IAuthorizationCompletionCallback
        public void onChallengeResponseReceived(@NonNull final RawAuthorizationResult rawAuthorizationResult) {
            Logger.info(WebViewAuthorizationFragment.TAG + ":onChallengeResponseReceived", null, "onChallengeResponseReceived:" + rawAuthorizationResult.getResultCode());
            if (WebViewAuthorizationFragment.this.mAADWebViewClient != null) {
                WebViewAuthorizationFragment.this.mAADWebViewClient.finalizeBeforeSendingResult(rawAuthorizationResult, new ISendResultCallback() { // from class: com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment.AuthorizationCompletionCallback.1
                    @Override // com.microsoft.identity.common.internal.p131ui.webview.ISendResultCallback
                    public void onResultReady() {
                        WebViewAuthorizationFragment.this.sendResult(rawAuthorizationResult);
                        WebViewAuthorizationFragment.this.finish();
                    }
                });
            } else {
                WebViewAuthorizationFragment.this.sendResult(rawAuthorizationResult);
                WebViewAuthorizationFragment.this.finish();
            }
        }

        @Override // com.microsoft.identity.common.java.p132ui.webview.authorization.IAuthorizationCompletionCallback
        public void setPKeyAuthStatus(boolean z) {
            String str = WebViewAuthorizationFragment.TAG + ":setPKeyAuthStatus";
            WebViewAuthorizationFragment.this.mPkeyAuthStatus = z;
            Logger.info(str, null, "setPKeyAuthStatus:" + z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acceptCameraRequest() {
        String[] strArr = {"android.webkit.resource.VIDEO_CAPTURE"};
        PermissionRequest permissionRequest = this.mCameraPermissionRequest;
        if (permissionRequest != null) {
            permissionRequest.grant(strArr);
        }
    }

    private void denyCameraRequest() {
        PermissionRequest permissionRequest = this.mCameraPermissionRequest;
        if (permissionRequest != null) {
            permissionRequest.deny();
        }
    }

    private HashMap<String, String> getRequestHeaders(Bundle bundle) {
        try {
            HashMap<String, String> map = (HashMap) bundle.getSerializable(AuthenticationConstants.AuthorizationIntentKey.REQUEST_HEADERS);
            if (CommonFlightManager.isFlightEnabled(CommonFlight.ENABLE_PASSKEY_FEATURE)) {
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(FidoConstants.PASSKEY_PROTOCOL_HEADER_NAME, FidoConstants.PASSKEY_PROTOCOL_HEADER_VALUE);
            }
            return map;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 21)
    public void handleRepeatedRequests(@NonNull PermissionRequest permissionRequest) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":handleRepeatedRequests", new StringBuilder());
        if (isCameraPermissionGranted()) {
            Logger.info(strM1170p, "Repeated request, granting the permission.");
            permissionRequest.grant(new String[]{"android.webkit.resource.VIDEO_CAPTURE"});
        } else {
            Logger.info(strM1170p, "Repeated request, denying the permission");
            permissionRequest.deny();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCameraPermissionGranted() {
        return ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPermissionRequestForCamera(PermissionRequest permissionRequest) {
        return permissionRequest.getResources().length == 1 && "android.webkit.resource.VIDEO_CAPTURE".equals(permissionRequest.getResources()[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Boolean bool) {
        Logger.info(TAG, "Camera permission granted: " + bool);
        if (bool.booleanValue()) {
            acceptCameraRequest();
        } else {
            denyCameraRequest();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCameraRationale$1(DialogInterface dialogInterface, int i) {
        requestCameraPermissionFromUser();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCameraRationale$2(DialogInterface dialogInterface, int i) {
        denyCameraRequest();
    }

    private void launchWebView() {
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":launchWebView", new StringBuilder());
        this.mWebView.post(new Runnable() { // from class: com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment.4
            @Override // java.lang.Runnable
            public void run() {
                Logger.info(strM1170p, "Launching embedded WebView for acquiring auth code.");
                Logger.infoPII(strM1170p, "The start url is " + WebViewAuthorizationFragment.this.mAuthorizationRequestUrl);
                WebViewAuthorizationFragment.this.mAADWebViewClient.setRequestHeaders(WebViewAuthorizationFragment.this.mRequestHeaders);
                WebViewAuthorizationFragment.this.mWebView.loadUrl(WebViewAuthorizationFragment.this.mAuthorizationRequestUrl, WebViewAuthorizationFragment.this.mRequestHeaders);
                WebViewAuthorizationFragment.this.mProgressBar.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestCameraPermissionFromUser() {
        Logger.info(TAG + ":requestCameraPermissionFromUser", "Requesting camera permission.");
        this.cameraRequestActivity.launch("android.permission.CAMERA");
    }

    @SuppressLint({"SetJavaScriptEnabled", "ClickableViewAccessibility"})
    private void setUpWebView(@NonNull View view, @NonNull AzureActiveDirectoryWebViewClient azureActiveDirectoryWebViewClient) {
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":setUpWebView", new StringBuilder());
        WebView webView = (WebView) view.findViewById(C6228R.id.common_auth_webview);
        this.mWebView = webView;
        String userAgentString = webView.getSettings().getUserAgentString();
        this.mWebView.getSettings().setUserAgentString(userAgentString + AuthenticationConstants.Broker.CLIENT_TLS_NOT_SUPPORTED);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.requestFocus(130);
        this.mWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view2.hasFocus()) {
                    return false;
                }
                view2.requestFocus();
                return false;
            }
        });
        this.mWebView.getSettings().setLoadWithOverviewMode(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        this.mWebView.getSettings().setUseWideViewPort(true);
        this.mWebView.getSettings().setBuiltInZoomControls(this.webViewZoomControlsEnabled);
        this.mWebView.getSettings().setSupportZoom(this.webViewZoomEnabled);
        this.mWebView.setVisibility(4);
        this.mWebView.setWebViewClient(azureActiveDirectoryWebViewClient);
        this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment.3
            @Override // android.webkit.WebChromeClient
            @RequiresApi(api = 21)
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                Logger.info(strM1170p, "Permission requested from:" + permissionRequest.getOrigin() + " for resources:" + Arrays.toString(permissionRequest.getResources()));
                if (!WebViewAuthorizationFragment.this.isPermissionRequestForCamera(permissionRequest)) {
                    Logger.warn(strM1170p, "Permission request is not for camera.");
                    permissionRequest.deny();
                    return;
                }
                if (WebViewAuthorizationFragment.this.mCameraPermissionRequest != null) {
                    WebViewAuthorizationFragment.this.handleRepeatedRequests(permissionRequest);
                    return;
                }
                Logger.info(strM1170p, "New camera request.");
                WebViewAuthorizationFragment.this.mCameraPermissionRequest = permissionRequest;
                if (WebViewAuthorizationFragment.this.isCameraPermissionGranted()) {
                    Logger.info(strM1170p, "Camera permission already granted.");
                    WebViewAuthorizationFragment.this.acceptCameraRequest();
                } else if (!WebViewAuthorizationFragment.this.shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                    WebViewAuthorizationFragment.this.requestCameraPermissionFromUser();
                } else {
                    Logger.info(strM1170p, "Show camera rationale.");
                    WebViewAuthorizationFragment.this.showCameraRationale();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCameraRationale() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        final int i = 0;
        final int i2 = 1;
        builder.setMessage(C6228R.string.qr_code_rationale_message).setTitle(C6228R.string.qr_code_rationale_header).setCancelable(false).setPositiveButton(C6228R.string.qr_code_rationale_allow, new DialogInterface.OnClickListener(this) { // from class: com.microsoft.identity.common.internal.providers.oauth2.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ WebViewAuthorizationFragment f3590b;

            {
                this.f3590b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                switch (i) {
                    case 0:
                        this.f3590b.lambda$showCameraRationale$1(dialogInterface, i4);
                        break;
                    default:
                        this.f3590b.lambda$showCameraRationale$2(dialogInterface, i4);
                        break;
                }
            }
        }).setNegativeButton(C6228R.string.qr_code_rationale_block, new DialogInterface.OnClickListener(this) { // from class: com.microsoft.identity.common.internal.providers.oauth2.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ WebViewAuthorizationFragment f3590b;

            {
                this.f3590b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                switch (i2) {
                    case 0:
                        this.f3590b.lambda$showCameraRationale$1(dialogInterface, i4);
                        break;
                    default:
                        this.f3590b.lambda$showCameraRationale$2(dialogInterface, i4);
                        break;
                }
            }
        });
        builder.show();
    }

    @Override // com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment
    public void extractState(@NonNull Bundle bundle) {
        super.extractState(bundle);
        this.mAuthIntent = (Intent) bundle.getParcelable(AuthenticationConstants.AuthorizationIntentKey.AUTH_INTENT);
        this.mPkeyAuthStatus = bundle.getBoolean(PKEYAUTH_STATUS, false);
        this.mAuthorizationRequestUrl = bundle.getString(AuthenticationConstants.AuthorizationIntentKey.REQUEST_URL);
        this.mRedirectUri = bundle.getString(AuthenticationConstants.AuthorizationIntentKey.REDIRECT_URI);
        this.mRequestHeaders = getRequestHeaders(bundle);
        this.mPostPageLoadedJavascript = bundle.getString(AuthenticationConstants.AuthorizationIntentKey.POST_PAGE_LOADED_URL);
        this.webViewZoomEnabled = bundle.getBoolean(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_ZOOM_ENABLED, true);
        this.webViewZoomControlsEnabled = bundle.getBoolean(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_ZOOM_CONTROLS_ENABLED, true);
    }

    @Override // com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment
    public void handleBackButtonPressed() {
        Logger.info(TAG + ":handleBackButtonPressed", "Back button is pressed");
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
        } else {
            cancelAuthorization(true);
        }
    }

    @Override // com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            WebViewUtil.setDataDirectorySuffix(activity.getApplicationContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":onCreateView", new StringBuilder());
        View viewInflate = layoutInflater.inflate(C6228R.layout.common_activity_authentication, viewGroup, false);
        this.mProgressBar = (ProgressBar) viewInflate.findViewById(C6228R.id.common_auth_webview_progressbar);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return null;
        }
        AzureActiveDirectoryWebViewClient azureActiveDirectoryWebViewClient = new AzureActiveDirectoryWebViewClient(activity, new AuthorizationCompletionCallback(), new OnPageLoadedCallback() { // from class: com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment.1
            @Override // com.microsoft.identity.common.internal.p131ui.webview.OnPageLoadedCallback
            public void onPageLoaded(String str) {
                WebViewAuthorizationFragment.this.mCameraPermissionRequest = null;
                String[] strArr = new String[1];
                WebViewAuthorizationFragment.this.mProgressBar.setVisibility(4);
                try {
                    strArr[0] = String.format("window.expectedUrl = '%s';%n%s", URLEncoder.encode(str, "UTF-8"), WebViewAuthorizationFragment.this.mPostPageLoadedJavascript);
                } catch (UnsupportedEncodingException unused) {
                    Logger.warn(strM1170p, "Inject expectedUrl failed.");
                }
                if (WebViewAuthorizationFragment.this.mAuthResultSent || StringExtensions.isNullOrBlank(strArr[0])) {
                    return;
                }
                WebViewAuthorizationFragment.this.mWebView.evaluateJavascript(strArr[0], null);
            }
        }, this.mRedirectUri);
        this.mAADWebViewClient = azureActiveDirectoryWebViewClient;
        setUpWebView(viewInflate, azureActiveDirectoryWebViewClient);
        launchWebView();
        return viewInflate;
    }

    @Override // com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        String strM1170p = AbstractC0622a.m1170p(TAG, ":onDestroy", new StringBuilder());
        AzureActiveDirectoryWebViewClient azureActiveDirectoryWebViewClient = this.mAADWebViewClient;
        if (azureActiveDirectoryWebViewClient != null) {
            azureActiveDirectoryWebViewClient.onDestroy();
        } else {
            Logger.error(strM1170p, "Fragment destroyed, but smartcard usb discovery was unable to be stopped.", null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(AuthenticationConstants.AuthorizationIntentKey.AUTH_INTENT, this.mAuthIntent);
        bundle.putBoolean(PKEYAUTH_STATUS, this.mPkeyAuthStatus);
        bundle.putString(AuthenticationConstants.AuthorizationIntentKey.REDIRECT_URI, this.mRedirectUri);
        bundle.putString(AuthenticationConstants.AuthorizationIntentKey.REQUEST_URL, this.mAuthorizationRequestUrl);
        bundle.putSerializable(AuthenticationConstants.AuthorizationIntentKey.REQUEST_HEADERS, this.mRequestHeaders);
        bundle.putSerializable(AuthenticationConstants.AuthorizationIntentKey.POST_PAGE_LOADED_URL, this.mPostPageLoadedJavascript);
        bundle.putBoolean(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_ZOOM_CONTROLS_ENABLED, this.webViewZoomControlsEnabled);
        bundle.putBoolean(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_ZOOM_ENABLED, this.webViewZoomEnabled);
    }
}
