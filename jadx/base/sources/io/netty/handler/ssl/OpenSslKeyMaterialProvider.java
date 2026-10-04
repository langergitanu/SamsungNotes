package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.internal.tcnative.SSL;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509KeyManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class OpenSslKeyMaterialProvider {
    private final X509KeyManager keyManager;
    private final String password;

    public OpenSslKeyMaterialProvider(X509KeyManager x509KeyManager, String str) {
        this.keyManager = x509KeyManager;
        this.password = str;
    }

    public static void validateKeyMaterialSupported(X509Certificate[] x509CertificateArr, PrivateKey privateKey, String str) throws Throwable {
        validateSupported(x509CertificateArr);
        validateSupported(privateKey, str);
    }

    private static void validateSupported(PrivateKey privateKey, String str) throws Throwable {
        long bio;
        if (privateKey == null) {
            return;
        }
        long j = 0;
        try {
            try {
                bio = ReferenceCountedOpenSslContext.toBIO(UnpooledByteBufAllocator.DEFAULT, privateKey);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            long privateKey2 = SSL.parsePrivateKey(bio, str);
            SSL.freeBIO(bio);
            if (privateKey2 != 0) {
                SSL.freePrivateKey(privateKey2);
            }
        } catch (Exception e2) {
            e = e2;
            throw new SSLException("PrivateKey type not supported " + privateKey.getFormat(), e);
        } catch (Throwable th2) {
            th = th2;
            j = bio;
            SSL.freeBIO(j);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OpenSslKeyMaterial chooseKeyMaterial(ByteBufAllocator byteBufAllocator, String str) throws Throwable {
        long x509Chain;
        long privateKey;
        long bio;
        long bio2;
        OpenSslKeyMaterial defaultOpenSslKeyMaterial;
        X509Certificate[] certificateChain = this.keyManager.getCertificateChain(str);
        if (certificateChain == null || certificateChain.length == 0) {
            return null;
        }
        PrivateKey privateKey2 = this.keyManager.getPrivateKey(str);
        PemEncoded pem = PemX509Certificate.toPEM(byteBufAllocator, true, certificateChain);
        long j = 0;
        try {
            bio = ReferenceCountedOpenSslContext.toBIO(byteBufAllocator, pem.retain());
            try {
                x509Chain = SSL.parseX509Chain(bio);
                try {
                    if (privateKey2 instanceof OpenSslPrivateKey) {
                        defaultOpenSslKeyMaterial = ((OpenSslPrivateKey) privateKey2).newKeyMaterial(x509Chain, certificateChain);
                    } else {
                        bio2 = ReferenceCountedOpenSslContext.toBIO(byteBufAllocator, privateKey2);
                        if (privateKey2 == null) {
                            privateKey = 0;
                        } else {
                            try {
                                privateKey = SSL.parsePrivateKey(bio2, this.password);
                            } catch (Throwable th) {
                                th = th;
                                privateKey = 0;
                                SSL.freeBIO(bio);
                                SSL.freeBIO(bio2);
                                if (x509Chain != 0) {
                                }
                                if (privateKey != 0) {
                                }
                                pem.release();
                                throw th;
                            }
                        }
                        try {
                            defaultOpenSslKeyMaterial = new DefaultOpenSslKeyMaterial(x509Chain, privateKey, certificateChain);
                            j = bio2;
                        } catch (Throwable th2) {
                            th = th2;
                            SSL.freeBIO(bio);
                            SSL.freeBIO(bio2);
                            if (x509Chain != 0) {
                            }
                            if (privateKey != 0) {
                            }
                            pem.release();
                            throw th;
                        }
                    }
                    SSL.freeBIO(bio);
                    SSL.freeBIO(j);
                    pem.release();
                    return defaultOpenSslKeyMaterial;
                } catch (Throwable th3) {
                    th = th3;
                    privateKey = 0;
                    bio2 = privateKey;
                    SSL.freeBIO(bio);
                    SSL.freeBIO(bio2);
                    if (x509Chain != 0) {
                        SSL.freeX509Chain(x509Chain);
                    }
                    if (privateKey != 0) {
                        SSL.freePrivateKey(privateKey);
                    }
                    pem.release();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                x509Chain = 0;
                privateKey = 0;
            }
        } catch (Throwable th5) {
            th = th5;
            x509Chain = 0;
            privateKey = 0;
            bio = 0;
            bio2 = 0;
        }
    }

    public X509KeyManager keyManager() {
        return this.keyManager;
    }

    private static void validateSupported(X509Certificate[] x509CertificateArr) throws Throwable {
        long bio;
        if (x509CertificateArr == null || x509CertificateArr.length == 0) {
            return;
        }
        long j = 0;
        PemEncoded pem = null;
        try {
            try {
                UnpooledByteBufAllocator unpooledByteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
                pem = PemX509Certificate.toPEM(unpooledByteBufAllocator, true, x509CertificateArr);
                bio = ReferenceCountedOpenSslContext.toBIO(unpooledByteBufAllocator, pem.retain());
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            long x509Chain = SSL.parseX509Chain(bio);
            SSL.freeBIO(bio);
            if (x509Chain != 0) {
                SSL.freeX509Chain(x509Chain);
            }
            pem.release();
        } catch (Exception e2) {
            e = e2;
            throw new SSLException("Certificate type not supported", e);
        } catch (Throwable th2) {
            th = th2;
            j = bio;
            SSL.freeBIO(j);
            if (pem != null) {
                pem.release();
            }
            throw th;
        }
    }

    public void destroy() {
    }
}
