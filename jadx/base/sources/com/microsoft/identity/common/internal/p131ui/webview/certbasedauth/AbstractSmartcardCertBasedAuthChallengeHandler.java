package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import android.webkit.ClientCertRequest;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.C6228R;
import com.microsoft.identity.common.internal.p131ui.webview.ISendResultCallback;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardCertPickerDialog;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardPinDialog;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.logging.Logger;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractSmartcardCertBasedAuthChallengeHandler<T extends AbstractSmartcardCertBasedAuthManager> extends AbstractCertBasedAuthChallengeHandler {
    protected static final String MAX_ATTEMPTS_MESSAGE = "User has reached the maximum failed attempts allowed.";
    protected static final String NO_PIV_CERTS_FOUND_MESSAGE = "No PIV certificates found on smartcard device.";
    protected static final String USER_CANCEL_MESSAGE = "User canceled smartcard CBA flow.";
    protected final String TAG;
    protected final Activity mActivity;
    protected final T mCbaManager;
    protected final IDialogHolder mDialogHolder;

    public AbstractSmartcardCertBasedAuthChallengeHandler(@NonNull Activity activity, @NonNull T t, @NonNull IDialogHolder iDialogHolder, @NonNull ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper, @NonNull String str) {
        this.TAG = str;
        this.mActivity = activity;
        this.mIsCertBasedAuthProceeding = false;
        this.mCbaManager = t;
        this.mDialogHolder = iDialogHolder;
        this.mTelemetryHelper = iCertBasedAuthTelemetryHelper;
        iCertBasedAuthTelemetryHelper.setCertBasedAuthChallengeHandler(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SmartcardCertPickerDialog.PositiveButtonListener getSmartcardCertPickerDialogPositiveButtonListener(@NonNull final ClientCertRequest clientCertRequest) {
        return new SmartcardCertPickerDialog.PositiveButtonListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler.3
            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardCertPickerDialog.PositiveButtonListener
            @RequiresApi(api = 21)
            public void onClick(@NonNull ICertDetails iCertDetails) {
                AbstractSmartcardCertBasedAuthChallengeHandler abstractSmartcardCertBasedAuthChallengeHandler = AbstractSmartcardCertBasedAuthChallengeHandler.this;
                abstractSmartcardCertBasedAuthChallengeHandler.mDialogHolder.showPinDialog(abstractSmartcardCertBasedAuthChallengeHandler.getSmartcardPinDialogPositiveButtonListener(iCertDetails, clientCertRequest), AbstractSmartcardCertBasedAuthChallengeHandler.this.getGeneralCancelCbaCallback(clientCertRequest));
            }
        };
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractCertBasedAuthChallengeHandler
    public void cleanUp() {
        this.mDialogHolder.dismissDialog();
        clearAllManagerCallbacks();
    }

    public abstract void clearAllManagerCallbacks();

    public void clearPin(@NonNull char[] cArr) {
        Arrays.fill(cArr, (char) 0);
    }

    @NonNull
    public ICancelCbaCallback getGeneralCancelCbaCallback(@NonNull final ClientCertRequest clientCertRequest) {
        return new ICancelCbaCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler.2
            @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.ICancelCbaCallback
            @RequiresApi(api = 21)
            public void onCancel() {
                AbstractSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.dismissDialog();
                AbstractSmartcardCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure(AbstractSmartcardCertBasedAuthChallengeHandler.USER_CANCEL_MESSAGE);
                clientCertRequest.cancel();
            }
        };
    }

    public abstract SmartcardPinDialog.PositiveButtonListener getSmartcardPinDialogPositiveButtonListener(@NonNull ICertDetails iCertDetails, @NonNull ClientCertRequest clientCertRequest);

    public abstract void indicateDisconnectionError(@NonNull String str);

    public void indicateGeneralException(@NonNull String str, @NonNull Exception exc) {
        Logger.error(str, exc.getMessage(), exc);
        this.mTelemetryHelper.setResultFailure(exc);
        this.mDialogHolder.showErrorDialog(C6228R.string.smartcard_general_error_dialog_title, C6228R.string.smartcard_general_error_dialog_message);
    }

    public abstract void prepForNextUserInteraction(@NonNull IDisconnectionCallback iDisconnectionCallback);

    public abstract void promptSmartcardRemovalForResult(@NonNull ISendResultCallback iSendResultCallback);

    public void promptTooManyFailedPinAttempts(@NonNull String str) {
        Logger.info(str, MAX_ATTEMPTS_MESSAGE);
        this.mTelemetryHelper.setResultFailure(MAX_ATTEMPTS_MESSAGE);
        this.mDialogHolder.showErrorDialog(C6228R.string.smartcard_max_attempt_dialog_title, C6228R.string.smartcard_max_attempt_dialog_message);
    }

    public abstract void setPinDialogForIncorrectAttempt(@NonNull ICertDetails iCertDetails, @NonNull ClientCertRequest clientCertRequest);

    @RequiresApi(api = 21)
    public void tryUsingSmartcardWithPin(@NonNull char[] cArr, @NonNull final ICertDetails iCertDetails, @NonNull final ClientCertRequest clientCertRequest, @NonNull ISmartcardSession iSmartcardSession) {
        final String strM1170p = AbstractC0622a.m1170p(this.TAG, ":tryUsingSmartcardWithPin", new StringBuilder());
        if (iSmartcardSession.verifyPin(cArr)) {
            useSmartcardCertForAuth(iCertDetails, cArr, iSmartcardSession, clientCertRequest);
        } else {
            final int pinAttemptsRemaining = iSmartcardSession.getPinAttemptsRemaining();
            prepForNextUserInteraction(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler.4
                @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDisconnectionCallback
                public void onClosedConnection() {
                    if (pinAttemptsRemaining != 0) {
                        AbstractSmartcardCertBasedAuthChallengeHandler.this.setPinDialogForIncorrectAttempt(iCertDetails, clientCertRequest);
                    } else {
                        AbstractSmartcardCertBasedAuthChallengeHandler.this.promptTooManyFailedPinAttempts(strM1170p);
                        clientCertRequest.cancel();
                    }
                }
            });
        }
    }

    @RequiresApi(api = 21)
    public void useSmartcardCertForAuth(@NonNull ICertDetails iCertDetails, @NonNull char[] cArr, @NonNull ISmartcardSession iSmartcardSession, @NonNull ClientCertRequest clientCertRequest) {
        this.mCbaManager.initBeforeProceedingWithRequest(this.mTelemetryHelper);
        PrivateKey keyForAuth = iSmartcardSession.getKeyForAuth(iCertDetails, cArr);
        X509Certificate[] x509CertificateArr = {iCertDetails.getCertificate()};
        this.mTelemetryHelper.setPublicKeyAlgoType(x509CertificateArr[0].getPublicKey().getAlgorithm());
        this.mDialogHolder.dismissDialog();
        this.mIsCertBasedAuthProceeding = true;
        clientCertRequest.proceed(keyForAuth, x509CertificateArr);
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.challengehandlers.IChallengeHandler
    @RequiresApi(api = 21)
    public Void processChallenge(final ClientCertRequest clientCertRequest) {
        final String strM1170p = AbstractC0622a.m1170p(this.TAG, ":processChallenge", new StringBuilder());
        this.mCbaManager.requestDeviceSession(new AbstractSmartcardCertBasedAuthManager.ISessionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler.1
            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager.ISessionCallback
            public void onException(@NonNull final Exception exc) {
                clientCertRequest.cancel();
                AbstractSmartcardCertBasedAuthChallengeHandler.this.prepForNextUserInteraction(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler.1.2
                    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDisconnectionCallback
                    public void onClosedConnection() {
                        C63031 c63031 = C63031.this;
                        AbstractSmartcardCertBasedAuthChallengeHandler.this.indicateGeneralException(strM1170p, exc);
                    }
                });
            }

            @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager.ISessionCallback
            public void onGetSession(@NonNull ISmartcardSession iSmartcardSession) {
                final int pinAttemptsRemaining = iSmartcardSession.getPinAttemptsRemaining();
                final List<ICertDetails> certDetailsList = iSmartcardSession.getCertDetailsList();
                AbstractSmartcardCertBasedAuthChallengeHandler.this.prepForNextUserInteraction(new IDisconnectionCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthChallengeHandler.1.1
                    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDisconnectionCallback
                    public void onClosedConnection() {
                        if (pinAttemptsRemaining == 0) {
                            C63031 c63031 = C63031.this;
                            AbstractSmartcardCertBasedAuthChallengeHandler.this.promptTooManyFailedPinAttempts(strM1170p);
                            clientCertRequest.cancel();
                        } else {
                            if (certDetailsList.isEmpty()) {
                                Logger.info(strM1170p, AbstractSmartcardCertBasedAuthChallengeHandler.NO_PIV_CERTS_FOUND_MESSAGE);
                                AbstractSmartcardCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure(AbstractSmartcardCertBasedAuthChallengeHandler.NO_PIV_CERTS_FOUND_MESSAGE);
                                AbstractSmartcardCertBasedAuthChallengeHandler.this.mDialogHolder.showErrorDialog(C6228R.string.smartcard_no_cert_dialog_title, C6228R.string.smartcard_no_cert_dialog_message);
                                clientCertRequest.cancel();
                                return;
                            }
                            C63031 c630312 = C63031.this;
                            AbstractSmartcardCertBasedAuthChallengeHandler abstractSmartcardCertBasedAuthChallengeHandler = AbstractSmartcardCertBasedAuthChallengeHandler.this;
                            IDialogHolder iDialogHolder = abstractSmartcardCertBasedAuthChallengeHandler.mDialogHolder;
                            List<ICertDetails> list = certDetailsList;
                            SmartcardCertPickerDialog.PositiveButtonListener smartcardCertPickerDialogPositiveButtonListener = abstractSmartcardCertBasedAuthChallengeHandler.getSmartcardCertPickerDialogPositiveButtonListener(clientCertRequest);
                            C63031 c630313 = C63031.this;
                            iDialogHolder.showCertPickerDialog(list, smartcardCertPickerDialogPositiveButtonListener, AbstractSmartcardCertBasedAuthChallengeHandler.this.getGeneralCancelCbaCallback(clientCertRequest));
                        }
                    }
                });
            }
        });
        return null;
    }
}
