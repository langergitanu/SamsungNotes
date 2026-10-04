package io.netty.handler.ssl;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.internal.tcnative.CertificateVerifier;
import java.security.cert.CertificateException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class OpenSslCertificateException extends CertificateException {
    private static final long serialVersionUID = 5542675253797129798L;
    private final int errorCode;

    public OpenSslCertificateException(int i) {
        this((String) null, i);
    }

    private static int checkErrorCode(int i) {
        if (!OpenSsl.isAvailable() || CertificateVerifier.isValid(i)) {
            return i;
        }
        throw new IllegalArgumentException(AbstractC0541b.m767i(i, "errorCode '", "' invalid, see https://www.openssl.org/docs/man1.0.2/apps/verify.html."));
    }

    public int errorCode() {
        return this.errorCode;
    }

    public OpenSslCertificateException(String str, int i) {
        super(str);
        this.errorCode = checkErrorCode(i);
    }

    public OpenSslCertificateException(String str, Throwable th, int i) {
        super(str, th);
        this.errorCode = checkErrorCode(i);
    }

    public OpenSslCertificateException(Throwable th, int i) {
        this(null, th, i);
    }
}
