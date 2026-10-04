package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import androidx.annotation.NonNull;
import java.security.PrivateKey;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ISmartcardSession {
    @NonNull
    List<ICertDetails> getCertDetailsList();

    @NonNull
    PrivateKey getKeyForAuth(@NonNull ICertDetails iCertDetails, @NonNull char[] cArr);

    int getPinAttemptsRemaining();

    boolean verifyPin(@NonNull char[] cArr);
}
