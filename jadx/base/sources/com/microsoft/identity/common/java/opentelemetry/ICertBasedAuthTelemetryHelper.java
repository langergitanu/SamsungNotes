package com.microsoft.identity.common.java.opentelemetry;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ICertBasedAuthTelemetryHelper {
    void setCertBasedAuthChallengeHandler(@NonNull String str);

    void setExistingPivProviderPresent(boolean z);

    void setPublicKeyAlgoType(@NonNull String str);

    @SuppressFBWarnings
    void setResultFailure(@NonNull Exception exc);

    @SuppressFBWarnings
    void setResultFailure(@NonNull String str);

    @SuppressFBWarnings
    void setResultSuccess();

    void setUserChoice(@NonNull CertBasedAuthChoice certBasedAuthChoice);
}
