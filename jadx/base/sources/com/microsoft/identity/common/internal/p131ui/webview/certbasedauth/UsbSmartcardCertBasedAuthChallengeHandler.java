package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import android.webkit.ClientCertRequest;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.C6228R;
import com.microsoft.identity.common.internal.p131ui.webview.ISendResultCallback;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardPinDialog;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class UsbSmartcardCertBasedAuthChallengeHandler extends AbstractSmartcardCertBasedAuthChallengeHandler<AbstractUsbSmartcardCertBasedAuthManager> {
    public UsbSmartcardCertBasedAuthChallengeHandler(@NonNull Activity activity, @NonNull AbstractUsbSmartcardCertBasedAuthManager abstractUsbSmartcardCertBasedAuthManager, @NonNull IDialogHolder iDialogHolder, @NonNull ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper) {
        super(activity, abstractUsbSmartcardCertBasedAuthManager, iDialogHolder, iCertBasedAuthTelemetryHelper, "UsbSmartcardCertBasedAuthChallengeHandler");
        ((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).setConnectionCallback(new IConnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UsbSmartcardCertBasedAuthChallengeHandler.1
            @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IConnectionCallback
            public void onCreateConnection() {
                UsbSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.dismissDialog();
            }
        });
        ((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).setDisconnectionCallback(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UsbSmartcardCertBasedAuthChallengeHandler.2
            @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDisconnectionCallback
            public void onClosedConnection() {
                if (UsbSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.isDialogShowing()) {
                    UsbSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.onUnexpectedUnplug();
                    if (UsbSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.isSmartcardRemovalPromptDialogShowing()) {
                        return;
                    }
                    UsbSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.showErrorDialog(C6228R.string.smartcard_early_unplug_dialog_title, C6228R.string.smartcard_early_unplug_dialog_message);
                    Logger.verbose(UsbSmartcardCertBasedAuthChallengeHandler.this.TAG, "Smartcard was disconnected while dialog was still displayed.");
                }
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    public void clearAllManagerCallbacks() {
        ((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).clearConnectionCallback();
        ((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).clearDisconnectionCallback();
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    public SmartcardPinDialog.PositiveButtonListener getSmartcardPinDialogPositiveButtonListener(@NonNull final ICertDetails iCertDetails, @NonNull final ClientCertRequest clientCertRequest) {
        final String strM1170p = AbstractC0622a.m1170p(this.TAG, ":getSmartcardPinDialogPositiveButtonListener", new StringBuilder());
        return new SmartcardPinDialog.PositiveButtonListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UsbSmartcardCertBasedAuthChallengeHandler.3
            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPinDialog.PositiveButtonListener
            @RequiresApi(api = 21)
            public void onClick(@NonNull final char[] cArr) {
                ((AbstractUsbSmartcardCertBasedAuthManager) UsbSmartcardCertBasedAuthChallengeHandler.this.mCbaManager).requestDeviceSession(new AbstractSmartcardCertBasedAuthManager.ISessionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UsbSmartcardCertBasedAuthChallengeHandler.3.1
                    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager.ISessionCallback
                    public void onException(@NonNull Exception exc) {
                        C63363 c63363 = C63363.this;
                        UsbSmartcardCertBasedAuthChallengeHandler.this.indicateGeneralException(strM1170p, exc);
                        UsbSmartcardCertBasedAuthChallengeHandler.this.clearAllManagerCallbacks();
                        clientCertRequest.cancel();
                        UsbSmartcardCertBasedAuthChallengeHandler.this.clearPin(cArr);
                    }

                    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager.ISessionCallback
                    public void onGetSession(@NonNull ISmartcardSession iSmartcardSession) {
                        C63363 c63363 = C63363.this;
                        UsbSmartcardCertBasedAuthChallengeHandler.this.tryUsingSmartcardWithPin(cArr, iCertDetails, clientCertRequest, iSmartcardSession);
                        UsbSmartcardCertBasedAuthChallengeHandler.this.clearPin(cArr);
                    }
                });
            }
        };
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    public void indicateDisconnectionError(@NonNull String str) {
        String strM1626p = AbstractC2322a.m1626p(new StringBuilder(), this.TAG, ":", str);
        this.mDialogHolder.showErrorDialog(C6228R.string.smartcard_early_unplug_dialog_title, C6228R.string.smartcard_early_unplug_dialog_message);
        Logger.verbose(strM1626p, "Smartcard was disconnected while dialog was still displayed.");
        ((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).clearDisconnectionCallback();
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    public void prepForNextUserInteraction(@NonNull IDisconnectionCallback iDisconnectionCallback) {
        iDisconnectionCallback.onClosedConnection();
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    public void promptSmartcardRemovalForResult(@NonNull final ISendResultCallback iSendResultCallback) {
        if (!((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).isDeviceConnected() || ((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).isUsbDeviceInitiallyPluggedIn()) {
            iSendResultCallback.onResultReady();
        } else {
            ((AbstractUsbSmartcardCertBasedAuthManager) this.mCbaManager).setDisconnectionCallback(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UsbSmartcardCertBasedAuthChallengeHandler.4
                @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDisconnectionCallback
                public void onClosedConnection() {
                    UsbSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.dismissDialog();
                    iSendResultCallback.onResultReady();
                }
            });
            this.mDialogHolder.showSmartcardRemovalPromptDialog(new IDismissCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UsbSmartcardCertBasedAuthChallengeHandler.5
                @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDismissCallback
                public void onDismiss() {
                    iSendResultCallback.onResultReady();
                }
            });
        }
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    @RequiresApi(api = 21)
    public void setPinDialogForIncorrectAttempt(@NonNull ICertDetails iCertDetails, @NonNull ClientCertRequest clientCertRequest) {
        this.mDialogHolder.setPinDialogErrorMode();
    }
}
