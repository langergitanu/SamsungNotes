package com.microsoft.identity.common.java.opentelemetry;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.StatusCode;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CertBasedAuthTelemetryHelper implements ICertBasedAuthTelemetryHelper {
    private final Span mSpan;

    /* JADX INFO: renamed from: com.microsoft.identity.common.java.opentelemetry.CertBasedAuthTelemetryHelper$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C64291 {

        /* JADX INFO: renamed from: $SwitchMap$com$microsoft$identity$common$java$opentelemetry$CertBasedAuthChoice */
        static final /* synthetic */ int[] f3602xf96f0aad;

        static {
            int[] iArr = new int[CertBasedAuthChoice.values().length];
            f3602xf96f0aad = iArr;
            try {
                iArr[CertBasedAuthChoice.ON_DEVICE_CHOICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3602xf96f0aad[CertBasedAuthChoice.SMARTCARD_CHOICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public CertBasedAuthTelemetryHelper(@NonNull SpanContext spanContext) {
        if (spanContext == null) {
            throw new NullPointerException("spanContext is marked non-null but is null");
        }
        this.mSpan = OTelUtility.createSpanFromParent(SpanName.CertBasedAuth.name(), spanContext);
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper
    public void setCertBasedAuthChallengeHandler(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("challengeHandlerName is marked non-null but is null");
        }
        this.mSpan.setAttribute(AttributeName.cert_based_auth_challenge_handler.name(), str);
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper
    public void setExistingPivProviderPresent(boolean z) {
        this.mSpan.setAttribute(AttributeName.cert_based_auth_existing_piv_provider_present.name(), z);
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper
    public void setPublicKeyAlgoType(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("type is marked non-null but is null");
        }
        this.mSpan.setAttribute(AttributeName.cert_based_auth_public_key_algo_type.name(), str);
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper
    @SuppressFBWarnings
    public void setResultFailure(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("message is marked non-null but is null");
        }
        this.mSpan.setStatus(StatusCode.ERROR, str);
        this.mSpan.end();
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper
    @SuppressFBWarnings
    public void setResultSuccess() {
        this.mSpan.setStatus(StatusCode.OK);
        this.mSpan.end();
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper
    public void setUserChoice(@NonNull CertBasedAuthChoice certBasedAuthChoice) {
        if (certBasedAuthChoice == null) {
            throw new NullPointerException("choice is marked non-null but is null");
        }
        int i = C64291.f3602xf96f0aad[certBasedAuthChoice.ordinal()];
        if (i == 1) {
            this.mSpan.setAttribute(AttributeName.cert_based_auth_user_choice.name(), "on-device");
        } else if (i != 2) {
            this.mSpan.setAttribute(AttributeName.cert_based_auth_user_choice.name(), "N/A");
        } else {
            this.mSpan.setAttribute(AttributeName.cert_based_auth_user_choice.name(), "smartcard");
        }
    }

    public CertBasedAuthTelemetryHelper() {
        this.mSpan = OTelUtility.createSpan(SpanName.CertBasedAuth.name());
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper
    @SuppressFBWarnings
    public void setResultFailure(@NonNull Exception exc) {
        if (exc != null) {
            this.mSpan.recordException(exc);
            this.mSpan.setStatus(StatusCode.ERROR);
            this.mSpan.end();
            return;
        }
        throw new NullPointerException("exception is marked non-null but is null");
    }
}
