package com.nimbusds.jose.crypto.impl;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.nimbusds.jose.CompressionAlgorithm;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.util.DeflateUtils;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class DeflateHelper {
    public static byte[] applyCompression(JWEHeader jWEHeader, byte[] bArr) {
        CompressionAlgorithm compressionAlgorithm = jWEHeader.getCompressionAlgorithm();
        if (compressionAlgorithm == null) {
            return bArr;
        }
        if (compressionAlgorithm.equals(CompressionAlgorithm.DEF)) {
            try {
                return DeflateUtils.compress(bArr);
            } catch (Exception e) {
                throw new JOSEException(AbstractC2322a.m1619i(e, new StringBuilder("Couldn't compress plain text: ")), e);
            }
        }
        throw new JOSEException("Unsupported compression algorithm: " + compressionAlgorithm);
    }

    public static byte[] applyDecompression(JWEHeader jWEHeader, byte[] bArr) throws JOSEException {
        CompressionAlgorithm compressionAlgorithm = jWEHeader.getCompressionAlgorithm();
        if (compressionAlgorithm == null) {
            return bArr;
        }
        if (compressionAlgorithm.equals(CompressionAlgorithm.DEF)) {
            try {
                return DeflateUtils.decompress(bArr);
            } catch (Exception e) {
                throw new JOSEException(AbstractC2322a.m1619i(e, new StringBuilder("Couldn't decompress plain text: ")), e);
            }
        }
        throw new JOSEException("Unsupported compression algorithm: " + compressionAlgorithm);
    }
}
