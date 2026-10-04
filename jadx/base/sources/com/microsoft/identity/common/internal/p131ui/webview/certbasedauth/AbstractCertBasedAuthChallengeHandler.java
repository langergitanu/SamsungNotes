package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.webkit.ClientCertRequest;
import androidx.annotation.NonNull;
import com.microsoft.identity.common.internal.p131ui.webview.challengehandlers.IChallengeHandler;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractCertBasedAuthChallengeHandler implements IChallengeHandler<ClientCertRequest, Void> {
    protected boolean mIsCertBasedAuthProceeding;
    protected ICertBasedAuthTelemetryHelper mTelemetryHelper;

    public abstract void cleanUp();

    public void emitTelemetryForCertBasedAuthResults(@NonNull RawAuthorizationResult rawAuthorizationResult) {
        if (this.mIsCertBasedAuthProceeding) {
            RawAuthorizationResult.ResultCode resultCode = rawAuthorizationResult.getResultCode();
            if (resultCode != RawAuthorizationResult.ResultCode.NON_OAUTH_ERROR && resultCode != RawAuthorizationResult.ResultCode.SDK_CANCELLED && resultCode != RawAuthorizationResult.ResultCode.CANCELLED) {
                this.mTelemetryHelper.setResultSuccess();
                return;
            }
            BaseException exception = rawAuthorizationResult.getException();
            if (exception != null) {
                this.mTelemetryHelper.setResultFailure(exception);
            } else {
                this.mTelemetryHelper.setResultFailure(resultCode.toString());
            }
        }
    }
}
