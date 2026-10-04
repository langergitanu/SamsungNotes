package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.UserChoiceDialog;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationActivity;
import com.microsoft.identity.common.java.opentelemetry.CertBasedAuthChoice;
import com.microsoft.identity.common.java.opentelemetry.CertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CertBasedAuthFactory {
    private static final String NON_APPLICABLE = "N/A";
    private static final String TAG = "CertBasedAuthFactory";
    private static final String USER_CANCEL_MESSAGE = "User canceled smartcard CBA flow.";
    private final Activity mActivity;
    private final IDialogHolder mDialogHolder;
    private final AbstractNfcSmartcardCertBasedAuthManager mNfcSmartcardCertBasedAuthManager;
    private final AbstractUsbSmartcardCertBasedAuthManager mUsbSmartcardCertBasedAuthManager;
    private boolean wasCertBasedAuthInitiated;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CertBasedAuthChallengeHandlerCallback {
        void onReceived(@Nullable AbstractCertBasedAuthChallengeHandler abstractCertBasedAuthChallengeHandler);
    }

    public CertBasedAuthFactory(@NonNull Activity activity) {
        this.mActivity = activity;
        AbstractUsbSmartcardCertBasedAuthManager abstractUsbSmartcardCertBasedAuthManagerCreateUsbSmartcardCertBasedAuthManager = SmartcardCertBasedAuthManagerFactory.createUsbSmartcardCertBasedAuthManager(activity.getApplicationContext());
        this.mUsbSmartcardCertBasedAuthManager = abstractUsbSmartcardCertBasedAuthManagerCreateUsbSmartcardCertBasedAuthManager;
        this.mNfcSmartcardCertBasedAuthManager = SmartcardCertBasedAuthManagerFactory.createNfcSmartcardCertBasedAuthManager(activity.getApplicationContext());
        this.mDialogHolder = new DialogHolder(activity);
        this.wasCertBasedAuthInitiated = false;
        if (abstractUsbSmartcardCertBasedAuthManagerCreateUsbSmartcardCertBasedAuthManager != null) {
            abstractUsbSmartcardCertBasedAuthManagerCreateUsbSmartcardCertBasedAuthManager.startDiscovery(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancelHelper(@NonNull CertBasedAuthChallengeHandlerCallback certBasedAuthChallengeHandlerCallback, @NonNull ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper) {
        this.mDialogHolder.dismissDialog();
        iCertBasedAuthTelemetryHelper.setResultFailure(USER_CANCEL_MESSAGE);
        AbstractNfcSmartcardCertBasedAuthManager abstractNfcSmartcardCertBasedAuthManager = this.mNfcSmartcardCertBasedAuthManager;
        if (abstractNfcSmartcardCertBasedAuthManager != null) {
            abstractNfcSmartcardCertBasedAuthManager.clearConnectionCallback();
        }
        AbstractUsbSmartcardCertBasedAuthManager abstractUsbSmartcardCertBasedAuthManager = this.mUsbSmartcardCertBasedAuthManager;
        if (abstractUsbSmartcardCertBasedAuthManager != null) {
            abstractUsbSmartcardCertBasedAuthManager.clearConnectionCallback();
        }
        certBasedAuthChallengeHandlerCallback.onReceived(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpForSmartcardCertBasedAuth(@NonNull final CertBasedAuthChallengeHandlerCallback certBasedAuthChallengeHandlerCallback, @NonNull final ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper) {
        AbstractUsbSmartcardCertBasedAuthManager abstractUsbSmartcardCertBasedAuthManager = this.mUsbSmartcardCertBasedAuthManager;
        if (abstractUsbSmartcardCertBasedAuthManager != null && abstractUsbSmartcardCertBasedAuthManager.isDeviceConnected()) {
            certBasedAuthChallengeHandlerCallback.onReceived(new UsbSmartcardCertBasedAuthChallengeHandler(this.mActivity, this.mUsbSmartcardCertBasedAuthManager, this.mDialogHolder, iCertBasedAuthTelemetryHelper));
            return;
        }
        AbstractNfcSmartcardCertBasedAuthManager abstractNfcSmartcardCertBasedAuthManager = this.mNfcSmartcardCertBasedAuthManager;
        if (abstractNfcSmartcardCertBasedAuthManager == null || !abstractNfcSmartcardCertBasedAuthManager.startDiscovery(this.mActivity)) {
            showSmartcardPromptDialogAndSetConnectionCallback(certBasedAuthChallengeHandlerCallback, iCertBasedAuthTelemetryHelper);
        } else {
            this.mDialogHolder.showSmartcardNfcReminderDialog(new IDismissCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.CertBasedAuthFactory.3
                @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDismissCallback
                public void onDismiss() {
                    if (CertBasedAuthFactory.this.mUsbSmartcardCertBasedAuthManager == null || !CertBasedAuthFactory.this.mUsbSmartcardCertBasedAuthManager.isDeviceConnected()) {
                        CertBasedAuthFactory.this.showSmartcardPromptDialogAndSetConnectionCallback(certBasedAuthChallengeHandlerCallback, iCertBasedAuthTelemetryHelper);
                    } else {
                        certBasedAuthChallengeHandlerCallback.onReceived(new UsbSmartcardCertBasedAuthChallengeHandler(CertBasedAuthFactory.this.mActivity, CertBasedAuthFactory.this.mUsbSmartcardCertBasedAuthManager, CertBasedAuthFactory.this.mDialogHolder, iCertBasedAuthTelemetryHelper));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSmartcardPromptDialogAndSetConnectionCallback(@NonNull final CertBasedAuthChallengeHandlerCallback certBasedAuthChallengeHandlerCallback, @NonNull final ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper) {
        this.mDialogHolder.showSmartcardPromptDialog(new ICancelCbaCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.CertBasedAuthFactory.4
            @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.ICancelCbaCallback
            @RequiresApi(api = 21)
            public void onCancel() {
                if (CertBasedAuthFactory.this.mNfcSmartcardCertBasedAuthManager != null) {
                    CertBasedAuthFactory.this.mNfcSmartcardCertBasedAuthManager.stopDiscovery(CertBasedAuthFactory.this.mActivity);
                }
                CertBasedAuthFactory.this.onCancelHelper(certBasedAuthChallengeHandlerCallback, iCertBasedAuthTelemetryHelper);
            }
        });
        AbstractUsbSmartcardCertBasedAuthManager abstractUsbSmartcardCertBasedAuthManager = this.mUsbSmartcardCertBasedAuthManager;
        if (abstractUsbSmartcardCertBasedAuthManager != null) {
            abstractUsbSmartcardCertBasedAuthManager.setConnectionCallback(new IConnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.CertBasedAuthFactory.5
                @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IConnectionCallback
                @RequiresApi(api = 21)
                public void onCreateConnection() {
                    if (CertBasedAuthFactory.this.mNfcSmartcardCertBasedAuthManager != null) {
                        CertBasedAuthFactory.this.mNfcSmartcardCertBasedAuthManager.stopDiscovery(CertBasedAuthFactory.this.mActivity);
                        CertBasedAuthFactory.this.clearAllSmartcardConnectionAndDisconnectionCallbacks();
                    }
                    certBasedAuthChallengeHandlerCallback.onReceived(new UsbSmartcardCertBasedAuthChallengeHandler(CertBasedAuthFactory.this.mActivity, CertBasedAuthFactory.this.mUsbSmartcardCertBasedAuthManager, CertBasedAuthFactory.this.mDialogHolder, iCertBasedAuthTelemetryHelper));
                }
            });
        }
        AbstractNfcSmartcardCertBasedAuthManager abstractNfcSmartcardCertBasedAuthManager = this.mNfcSmartcardCertBasedAuthManager;
        if (abstractNfcSmartcardCertBasedAuthManager == null) {
            return;
        }
        abstractNfcSmartcardCertBasedAuthManager.setConnectionCallback(new IConnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.CertBasedAuthFactory.6
            @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IConnectionCallback
            @RequiresApi(api = 21)
            public void onCreateConnection() {
                if (CertBasedAuthFactory.this.mUsbSmartcardCertBasedAuthManager != null) {
                    CertBasedAuthFactory.this.clearAllSmartcardConnectionAndDisconnectionCallbacks();
                }
                CertBasedAuthFactory.this.mDialogHolder.showSmartcardNfcLoadingDialog();
                certBasedAuthChallengeHandlerCallback.onReceived(new NfcSmartcardCertBasedAuthChallengeHandler(CertBasedAuthFactory.this.mActivity, CertBasedAuthFactory.this.mNfcSmartcardCertBasedAuthManager, CertBasedAuthFactory.this.mDialogHolder, iCertBasedAuthTelemetryHelper));
            }
        });
    }

    public void clearAllSmartcardConnectionAndDisconnectionCallbacks() {
        AbstractUsbSmartcardCertBasedAuthManager abstractUsbSmartcardCertBasedAuthManager = this.mUsbSmartcardCertBasedAuthManager;
        if (abstractUsbSmartcardCertBasedAuthManager != null) {
            abstractUsbSmartcardCertBasedAuthManager.clearConnectionCallback();
            this.mUsbSmartcardCertBasedAuthManager.clearDisconnectionCallback();
        }
        AbstractNfcSmartcardCertBasedAuthManager abstractNfcSmartcardCertBasedAuthManager = this.mNfcSmartcardCertBasedAuthManager;
        if (abstractNfcSmartcardCertBasedAuthManager != null) {
            abstractNfcSmartcardCertBasedAuthManager.clearConnectionCallback();
        }
    }

    public void createCertBasedAuthChallengeHandler(@NonNull final CertBasedAuthChallengeHandlerCallback certBasedAuthChallengeHandlerCallback) {
        Activity activity = this.mActivity;
        final CertBasedAuthTelemetryHelper certBasedAuthTelemetryHelper = (!(activity instanceof AuthorizationActivity) || ((AuthorizationActivity) activity).getSpanContext() == null) ? new CertBasedAuthTelemetryHelper() : new CertBasedAuthTelemetryHelper(((AuthorizationActivity) this.mActivity).getSpanContext());
        certBasedAuthTelemetryHelper.setUserChoice(CertBasedAuthChoice.NON_APPLICABLE);
        certBasedAuthTelemetryHelper.setCertBasedAuthChallengeHandler(NON_APPLICABLE);
        certBasedAuthTelemetryHelper.setPublicKeyAlgoType(NON_APPLICABLE);
        this.wasCertBasedAuthInitiated = true;
        AbstractUsbSmartcardCertBasedAuthManager abstractUsbSmartcardCertBasedAuthManager = this.mUsbSmartcardCertBasedAuthManager;
        if (abstractUsbSmartcardCertBasedAuthManager == null || !abstractUsbSmartcardCertBasedAuthManager.isDeviceConnected()) {
            this.mDialogHolder.showUserChoiceDialog(new UserChoiceDialog.PositiveButtonListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.CertBasedAuthFactory.1
                @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.UserChoiceDialog.PositiveButtonListener
                @RequiresApi(api = 21)
                public void onClick(int i) {
                    if (i != 0) {
                        certBasedAuthTelemetryHelper.setUserChoice(CertBasedAuthChoice.SMARTCARD_CHOICE);
                        CertBasedAuthFactory.this.setUpForSmartcardCertBasedAuth(certBasedAuthChallengeHandlerCallback, certBasedAuthTelemetryHelper);
                    } else {
                        CertBasedAuthFactory.this.mDialogHolder.dismissDialog();
                        certBasedAuthTelemetryHelper.setUserChoice(CertBasedAuthChoice.ON_DEVICE_CHOICE);
                        certBasedAuthChallengeHandlerCallback.onReceived(new OnDeviceCertBasedAuthChallengeHandler(CertBasedAuthFactory.this.mActivity, certBasedAuthTelemetryHelper));
                    }
                }
            }, new ICancelCbaCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.CertBasedAuthFactory.2
                @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.ICancelCbaCallback
                @RequiresApi(api = 21)
                public void onCancel() {
                    CertBasedAuthFactory.this.onCancelHelper(certBasedAuthChallengeHandlerCallback, certBasedAuthTelemetryHelper);
                }
            });
        } else {
            certBasedAuthTelemetryHelper.setUserChoice(CertBasedAuthChoice.SMARTCARD_CHOICE);
            certBasedAuthChallengeHandlerCallback.onReceived(new UsbSmartcardCertBasedAuthChallengeHandler(this.mActivity, this.mUsbSmartcardCertBasedAuthManager, this.mDialogHolder, certBasedAuthTelemetryHelper));
        }
    }

    public void onDestroy() {
        StringBuilder sb = new StringBuilder();
        sb.append(TAG);
        sb.append(":onDestroy");
        AbstractUsbSmartcardCertBasedAuthManager abstractUsbSmartcardCertBasedAuthManager = this.mUsbSmartcardCertBasedAuthManager;
        if (abstractUsbSmartcardCertBasedAuthManager != null) {
            abstractUsbSmartcardCertBasedAuthManager.onDestroy(this.mActivity);
        }
        AbstractNfcSmartcardCertBasedAuthManager abstractNfcSmartcardCertBasedAuthManager = this.mNfcSmartcardCertBasedAuthManager;
        if (abstractNfcSmartcardCertBasedAuthManager != null) {
            abstractNfcSmartcardCertBasedAuthManager.onDestroy(this.mActivity);
        }
        if (this.wasCertBasedAuthInitiated) {
            WebView.clearClientCertPreferences(null);
        }
    }

    @VisibleForTesting
    public CertBasedAuthFactory(@NonNull Activity activity, AbstractUsbSmartcardCertBasedAuthManager abstractUsbSmartcardCertBasedAuthManager, AbstractNfcSmartcardCertBasedAuthManager abstractNfcSmartcardCertBasedAuthManager, @NonNull IDialogHolder iDialogHolder) {
        this.mActivity = activity;
        this.mUsbSmartcardCertBasedAuthManager = abstractUsbSmartcardCertBasedAuthManager;
        this.mNfcSmartcardCertBasedAuthManager = abstractNfcSmartcardCertBasedAuthManager;
        this.mDialogHolder = iDialogHolder;
        this.wasCertBasedAuthInitiated = false;
    }
}
