package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import org.conscrypt.OpenSSLX509Certificate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class PemX509Certificate extends X509Certificate implements PemEncoded {
    private static final byte[] BEGIN_CERT;
    private static final byte[] END_CERT;
    private final ByteBuf content;

    static {
        Charset charset = CharsetUtil.US_ASCII;
        BEGIN_CERT = "-----BEGIN CERTIFICATE-----\n".getBytes(charset);
        END_CERT = "\n-----END CERTIFICATE-----\n".getBytes(charset);
    }

    private PemX509Certificate(ByteBuf byteBuf) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
    }

    private static ByteBuf append(ByteBufAllocator byteBufAllocator, boolean z, PemEncoded pemEncoded, int i, ByteBuf byteBuf) {
        ByteBuf byteBufContent = pemEncoded.content();
        if (byteBuf == null) {
            byteBuf = newBuffer(byteBufAllocator, z, byteBufContent.readableBytes() * i);
        }
        byteBuf.writeBytes(byteBufContent.slice());
        return byteBuf;
    }

    private static ByteBuf newBuffer(ByteBufAllocator byteBufAllocator, boolean z, int i) {
        return z ? byteBufAllocator.directBuffer(i) : byteBufAllocator.buffer(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PemEncoded toPEM(ByteBufAllocator byteBufAllocator, boolean z, X509Certificate... x509CertificateArr) {
        ObjectUtil.checkNonEmpty(x509CertificateArr, "chain");
        if (x509CertificateArr.length == 1) {
            Object[] objArr = x509CertificateArr[0];
            if (objArr instanceof PemEncoded) {
                return ((PemEncoded) objArr).retain();
            }
        }
        ByteBuf byteBufAppend = null;
        try {
            for (OpenSSLX509Certificate openSSLX509Certificate : x509CertificateArr) {
                if (openSSLX509Certificate == 0) {
                    throw new IllegalArgumentException("Null element in chain: " + Arrays.toString(x509CertificateArr));
                }
                byteBufAppend = openSSLX509Certificate instanceof PemEncoded ? append(byteBufAllocator, z, (PemEncoded) openSSLX509Certificate, x509CertificateArr.length, byteBufAppend) : append(byteBufAllocator, z, openSSLX509Certificate, x509CertificateArr.length, byteBufAppend);
            }
            return new PemValue(byteBufAppend, false);
        } catch (Throwable th) {
            if (0 != 0) {
                byteBufAppend.release();
            }
            throw th;
        }
    }

    public static PemX509Certificate valueOf(byte[] bArr) {
        return valueOf(Unpooled.wrappedBuffer(bArr));
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        int iRefCnt = refCnt();
        if (iRefCnt > 0) {
            return this.content;
        }
        throw new IllegalReferenceCountException(iRefCnt);
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PemX509Certificate) {
            return this.content.equals(((PemX509Certificate) obj).content);
        }
        return false;
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        return this.content.hashCode();
    }

    @Override // io.netty.handler.ssl.PemEncoded
    public boolean isSensitive() {
        return false;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.content.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.content.release();
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        return this.content.toString(CharsetUtil.UTF_8);
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey) {
        throw new UnsupportedOperationException();
    }

    public static PemX509Certificate valueOf(ByteBuf byteBuf) {
        return new PemX509Certificate(byteBuf);
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i) {
        return this.content.release(i);
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemX509Certificate copy() {
        return replace(this.content.copy());
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemX509Certificate duplicate() {
        return replace(this.content.duplicate());
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemX509Certificate replace(ByteBuf byteBuf) {
        return new PemX509Certificate(byteBuf);
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemX509Certificate retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    private static ByteBuf append(ByteBufAllocator byteBufAllocator, boolean z, X509Certificate x509Certificate, int i, ByteBuf byteBuf) {
        ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer(x509Certificate.getEncoded());
        try {
            ByteBuf base64 = SslUtils.toBase64(byteBufAllocator, byteBufWrappedBuffer);
            if (byteBuf == null) {
                try {
                    byteBuf = newBuffer(byteBufAllocator, z, (BEGIN_CERT.length + base64.readableBytes() + END_CERT.length) * i);
                } catch (Throwable th) {
                    base64.release();
                    throw th;
                }
            }
            byteBuf.writeBytes(BEGIN_CERT);
            byteBuf.writeBytes(base64);
            byteBuf.writeBytes(END_CERT);
            base64.release();
            return byteBuf;
        } finally {
            byteBufWrappedBuffer.release();
        }
    }

    @Override // io.netty.util.ReferenceCounted
    public PemX509Certificate retain() {
        this.content.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public PemX509Certificate touch() {
        this.content.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public PemX509Certificate retain(int i) {
        this.content.retain(i);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public PemX509Certificate touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
