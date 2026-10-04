package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import androidx.annotation.NonNull;
import com.yubico.yubikit.piv.Slot;
import java.security.cert.X509Certificate;
import javax.annotation.Nonnull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class YubiKitCertDetails implements ICertDetails {
    private final X509Certificate mCert;
    private final Slot mSlot;

    public YubiKitCertDetails(@NonNull X509Certificate x509Certificate, @NonNull Slot slot) {
        this.mCert = x509Certificate;
        this.mSlot = slot;
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.ICertDetails
    @NonNull
    public X509Certificate getCertificate() {
        return this.mCert;
    }

    @Nonnull
    public Slot getSlot() {
        return this.mSlot;
    }
}
