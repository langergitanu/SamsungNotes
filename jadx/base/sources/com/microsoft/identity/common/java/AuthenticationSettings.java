package com.microsoft.identity.common.java;

import com.microsoft.identity.common.java.challengehandlers.IDeviceCertificateLoader;
import com.microsoft.identity.common.java.constants.SpotbugsWarning;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum AuthenticationSettings {
    INSTANCE;


    @SuppressFBWarnings(justification = "by design (for now), allowing common to use the data initialized by broker.", value = {SpotbugsWarning.ME_ENUM_FIELD_SETTER})
    private IDeviceCertificateLoader mCertificateLoader;

    public IDeviceCertificateLoader getCertificateLoader() {
        return this.mCertificateLoader;
    }

    public void setCertificateLoader(IDeviceCertificateLoader iDeviceCertificateLoader) {
        this.mCertificateLoader = iDeviceCertificateLoader;
    }
}
