package org.conscrypt;

import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import org.conscrypt.OpenSSLCipher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class OpenSSLEvpCipherARC4 extends OpenSSLEvpCipher {
    public OpenSSLEvpCipherARC4() {
        super(OpenSSLCipher.Mode.ECB, OpenSSLCipher.Padding.NOPADDING);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
        if (mode == OpenSSLCipher.Mode.NONE || mode == OpenSSLCipher.Mode.ECB) {
            return;
        }
        throw new NoSuchAlgorithmException("Unsupported mode " + mode.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedPadding(OpenSSLCipher.Padding padding) throws NoSuchPaddingException {
        if (padding == OpenSSLCipher.Padding.NOPADDING) {
            return;
        }
        throw new NoSuchPaddingException("Unsupported padding " + padding.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    public String getBaseCipherName() {
        return "ARCFOUR";
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getCipherBlockSize() {
        return 0;
    }

    @Override // org.conscrypt.OpenSSLEvpCipher
    public String getCipherName(int i, OpenSSLCipher.Mode mode) {
        return "rc4";
    }

    @Override // org.conscrypt.OpenSSLCipher
    public boolean supportsVariableSizeKey() {
        return true;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedKeySize(int i) {
    }
}
