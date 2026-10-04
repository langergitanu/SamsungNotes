package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import android.webkit.ClientCertRequest;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.C6228R;
import com.microsoft.identity.common.internal.p131ui.webview.ISendResultCallback;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardPinDialog;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.logging.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class NfcSmartcardCertBasedAuthChallengeHandler extends AbstractSmartcardCertBasedAuthChallengeHandler<AbstractNfcSmartcardCertBasedAuthManager> {

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C63183 implements SmartcardPinDialog.PositiveButtonListener {
        final /* synthetic */ ICertDetails val$certDetails;
        final /* synthetic */ String val$methodTag;
        final /* synthetic */ ClientCertRequest val$request;

        /* JADX INFO: renamed from: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class AnonymousClass2 implements IConnectionCallback {
            final /* synthetic */ char[] val$pin;

            public AnonymousClass2(char[] cArr) {
                this.val$pin = cArr;
            }

            @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IConnectionCallback
            public void onCreateConnection() {
                NfcSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.showSmartcardNfcLoadingDialog();
                if (!((AbstractNfcSmartcardCertBasedAuthManager) NfcSmartcardCertBasedAuthChallengeHandler.this.mCbaManager).isDeviceChanged()) {
                    ((AbstractNfcSmartcardCertBasedAuthManager) NfcSmartcardCertBasedAuthChallengeHandler.this.mCbaManager).requestDeviceSession(new AbstractSmartcardCertBasedAuthManager.ISessionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler.3.2.2
                        @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager.ISessionCallback
                        public void onException(@NonNull final Exception exc) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            NfcSmartcardCertBasedAuthChallengeHandler.this.clearPin(anonymousClass2.val$pin);
                            C63183.this.val$request.cancel();
                            NfcSmartcardCertBasedAuthChallengeHandler.this.prepForNextUserInteraction(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler.3.2.2.1
                                @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDisconnectionCallback
                                public void onClosedConnection() {
                                    C63183 c63183 = C63183.this;
                                    NfcSmartcardCertBasedAuthChallengeHandler.this.indicateGeneralException(c63183.val$methodTag, exc);
                                }
                            });
                        }

                        @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager.ISessionCallback
                        public void onGetSession(@NonNull ISmartcardSession iSmartcardSession) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            C63183 c63183 = C63183.this;
                            NfcSmartcardCertBasedAuthChallengeHandler.this.tryUsingSmartcardWithPin(anonymousClass2.val$pin, c63183.val$certDetails, c63183.val$request, iSmartcardSession);
                            AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                            NfcSmartcardCertBasedAuthChallengeHandler.this.clearPin(anonymousClass22.val$pin);
                        }
                    });
                    return;
                }
                NfcSmartcardCertBasedAuthChallengeHandler.this.clearPin(this.val$pin);
                C63183.this.val$request.cancel();
                NfcSmartcardCertBasedAuthChallengeHandler.this.prepForNextUserInteraction(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler.3.2.1
                    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDisconnectionCallback
                    public void onClosedConnection() {
                        Logger.info(C63183.this.val$methodTag, "Device connected via NFC is different from initially connected device.");
                        NfcSmartcardCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure("Device connected via NFC is different from initially connected device.");
                        NfcSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.showErrorDialog(C6228R.string.smartcard_nfc_diff_connected_title, C6228R.string.smartcard_nfc_diff_connected_message, C6228R.string.smartcard_nfc_diff_connected_positive_button);
                    }
                });
            }
        }

        public C63183(ClientCertRequest clientCertRequest, String str, ICertDetails iCertDetails) {
            this.val$request = clientCertRequest;
            this.val$methodTag = str;
            this.val$certDetails = iCertDetails;
        }

        @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPinDialog.PositiveButtonListener
        @RequiresApi(api = 21)
        public void onClick(@NonNull char[] cArr) {
            NfcSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.showSmartcardNfcPromptDialog(new ICancelCbaCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler.3.1
                @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.ICancelCbaCallback
                public void onCancel() {
                    C63183 c63183 = C63183.this;
                    NfcSmartcardCertBasedAuthChallengeHandler.this.getGeneralCancelCbaCallback(c63183.val$request).onCancel();
                    NfcSmartcardCertBasedAuthChallengeHandler nfcSmartcardCertBasedAuthChallengeHandler = NfcSmartcardCertBasedAuthChallengeHandler.this;
                    ((AbstractNfcSmartcardCertBasedAuthManager) nfcSmartcardCertBasedAuthChallengeHandler.mCbaManager).stopDiscovery(nfcSmartcardCertBasedAuthChallengeHandler.mActivity);
                }
            });
            ((AbstractNfcSmartcardCertBasedAuthManager) NfcSmartcardCertBasedAuthChallengeHandler.this.mCbaManager).setConnectionCallback(new AnonymousClass2(cArr));
            NfcSmartcardCertBasedAuthChallengeHandler nfcSmartcardCertBasedAuthChallengeHandler = NfcSmartcardCertBasedAuthChallengeHandler.this;
            ((AbstractNfcSmartcardCertBasedAuthManager) nfcSmartcardCertBasedAuthChallengeHandler.mCbaManager).startDiscovery(nfcSmartcardCertBasedAuthChallengeHandler.mActivity);
        }
    }

    public NfcSmartcardCertBasedAuthChallengeHandler(@NonNull Activity activity, @NonNull AbstractNfcSmartcardCertBasedAuthManager abstractNfcSmartcardCertBasedAuthManager, @NonNull IDialogHolder iDialogHolder, @NonNull ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper) {
        super(activity, abstractNfcSmartcardCertBasedAuthManager, iDialogHolder, iCertBasedAuthTelemetryHelper, "NfcSmartcardCertBasedAuthChallengeHandler");
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    public void clearAllManagerCallbacks() {
        ((AbstractNfcSmartcardCertBasedAuthManager) this.mCbaManager).clearConnectionCallback();
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    public SmartcardPinDialog.PositiveButtonListener getSmartcardPinDialogPositiveButtonListener(@NonNull ICertDetails iCertDetails, @NonNull ClientCertRequest clientCertRequest) {
        return new C63183(clientCertRequest, AbstractC0622a.m1170p(this.TAG, ":getSmartcardPinDialogPositiveButtonListener", new StringBuilder()), iCertDetails);
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    public void prepForNextUserInteraction(@NonNull final IDisconnectionCallback iDisconnectionCallback) {
        if (!((AbstractNfcSmartcardCertBasedAuthManager) this.mCbaManager).isDeviceConnected()) {
            iDisconnectionCallback.onClosedConnection();
            return;
        }
        clearAllManagerCallbacks();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mDialogHolder.showSmartcardRemovalPromptDialog(new IDismissCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler.1
            @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDismissCallback
            public void onDismiss() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    NfcSmartcardCertBasedAuthChallengeHandler nfcSmartcardCertBasedAuthChallengeHandler = NfcSmartcardCertBasedAuthChallengeHandler.this;
                    ((AbstractNfcSmartcardCertBasedAuthManager) nfcSmartcardCertBasedAuthChallengeHandler.mCbaManager).stopDiscovery(nfcSmartcardCertBasedAuthChallengeHandler.mActivity);
                    iDisconnectionCallback.onClosedConnection();
                }
            }
        });
        ((AbstractNfcSmartcardCertBasedAuthManager) this.mCbaManager).disconnect(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler.2
            @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDisconnectionCallback
            public void onClosedConnection() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    NfcSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.dismissDialog();
                    NfcSmartcardCertBasedAuthChallengeHandler nfcSmartcardCertBasedAuthChallengeHandler = NfcSmartcardCertBasedAuthChallengeHandler.this;
                    ((AbstractNfcSmartcardCertBasedAuthManager) nfcSmartcardCertBasedAuthChallengeHandler.mCbaManager).stopDiscovery(nfcSmartcardCertBasedAuthChallengeHandler.mActivity);
                    iDisconnectionCallback.onClosedConnection();
                }
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    public void promptSmartcardRemovalForResult(@NonNull final ISendResultCallback iSendResultCallback) {
        if (((AbstractNfcSmartcardCertBasedAuthManager) this.mCbaManager).isDeviceConnected()) {
            prepForNextUserInteraction(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.NfcSmartcardCertBasedAuthChallengeHandler.4
                @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDisconnectionCallback
                public void onClosedConnection() {
                    iSendResultCallback.onResultReady();
                }
            });
        } else {
            iSendResultCallback.onResultReady();
        }
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    @RequiresApi(api = 21)
    public void setPinDialogForIncorrectAttempt(@NonNull ICertDetails iCertDetails, @NonNull ClientCertRequest clientCertRequest) {
        this.mDialogHolder.showPinDialog(getSmartcardPinDialogPositiveButtonListener(iCertDetails, clientCertRequest), getGeneralCancelCbaCallback(clientCertRequest));
        this.mDialogHolder.setPinDialogErrorMode();
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler
    public void indicateDisconnectionError(@NonNull String str) {
    }
}
