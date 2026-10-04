package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import android.security.KeyChain;
import android.security.KeyChainAliasCallback;
import android.security.KeyChainException;
import android.webkit.ClientCertRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.logging.Logger;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class OnDeviceCertBasedAuthChallengeHandler extends AbstractCertBasedAuthChallengeHandler {
    private static final String ECDSA_CONSTANT = "ECDSA";
    private static final String TAG = "OnDeviceCertBasedAuthChallengeHandler";
    private final Activity mActivity;

    public OnDeviceCertBasedAuthChallengeHandler(@NonNull Activity activity, @NonNull ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper) {
        this.mActivity = activity;
        this.mTelemetryHelper = iCertBasedAuthTelemetryHelper;
        iCertBasedAuthTelemetryHelper.setCertBasedAuthChallengeHandler(TAG);
        this.mIsCertBasedAuthProceeding = false;
    }

    @Nullable
    @RequiresApi(api = 23)
    public static String[] mapKeyTypes(@Nullable String[] strArr) {
        if (strArr == null) {
            return null;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(ECDSA_CONSTANT)) {
                strArr[i] = "EC";
                return strArr;
            }
        }
        return strArr;
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.challengehandlers.IChallengeHandler
    @RequiresApi(api = 23)
    public Void processChallenge(final ClientCertRequest clientCertRequest) {
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":processChallenge", new StringBuilder());
        KeyChain.choosePrivateKeyAlias(this.mActivity, new KeyChainAliasCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.OnDeviceCertBasedAuthChallengeHandler.1
            @Override // android.security.KeyChainAliasCallback
            public void alias(String str) {
                if (str == null) {
                    Logger.info(strM1170p, "No certificate chosen by user, cancelling the TLS request.");
                    OnDeviceCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure("No certificate chosen by user, cancelling the TLS request.");
                    clientCertRequest.cancel();
                    return;
                }
                try {
                    X509Certificate[] certificateChain = KeyChain.getCertificateChain(OnDeviceCertBasedAuthChallengeHandler.this.mActivity.getApplicationContext(), str);
                    if (certificateChain.length > 0) {
                        OnDeviceCertBasedAuthChallengeHandler.this.mTelemetryHelper.setPublicKeyAlgoType(certificateChain[0].getPublicKey().getAlgorithm());
                    }
                    PrivateKey privateKey = KeyChain.getPrivateKey(OnDeviceCertBasedAuthChallengeHandler.this.mActivity, str);
                    Logger.info(strM1170p, "Certificate is chosen by user, proceed with TLS request.");
                    OnDeviceCertBasedAuthChallengeHandler.this.mIsCertBasedAuthProceeding = true;
                    clientCertRequest.proceed(privateKey, certificateChain);
                } catch (KeyChainException e) {
                    Logger.errorPII(strM1170p, "KeyChain exception", e);
                    OnDeviceCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure(e);
                    OnDeviceCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure("ClientCertRequest unexpectedly cancelled.");
                    clientCertRequest.cancel();
                } catch (InterruptedException e2) {
                    Logger.errorPII(strM1170p, "InterruptedException exception", e2);
                    OnDeviceCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure(e2);
                    OnDeviceCertBasedAuthChallengeHandler.this.mTelemetryHelper.setResultFailure("ClientCertRequest unexpectedly cancelled.");
                    clientCertRequest.cancel();
                }
            }
        }, mapKeyTypes(clientCertRequest.getKeyTypes()), clientCertRequest.getPrincipals(), clientCertRequest.getHost(), clientCertRequest.getPort(), null);
        return null;
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractCertBasedAuthChallengeHandler
    public void cleanUp() {
    }
}
