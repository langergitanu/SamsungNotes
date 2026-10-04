package com.samsung.android.kmxservice.sdk.e2ee.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.kmxservice.sdk.e2ee.CryptoProgressListener;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;
import com.samsung.android.kmxservice.sdk.e2ee.manager.KmxCipher;
import com.samsung.android.kmxservice.sdk.util.AndroidKeystoreHelper;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class KmxCipherImpl implements KmxCipher {
    private static final String TAG = "KmxCipherImpl";

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxCipher
    public byte[] decryptData(@NonNull Key key, byte[] bArr) throws KmxException {
        byte[] bArrDecryptData = AndroidKeystoreHelper.decryptData(key, bArr);
        KmxErrorHandler.throwIfNull(bArrDecryptData, "6-2|Fail to decrypt data. Invalid service key id", 305);
        return bArrDecryptData;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxCipher
    public boolean decryptStream(@NonNull Key key, InputStream inputStream, OutputStream outputStream, @Nullable CryptoProgressListener cryptoProgressListener) throws KmxException {
        boolean zDecryptStream = cryptoProgressListener == null ? AndroidKeystoreHelper.decryptStream(key, inputStream, outputStream) : AndroidKeystoreHelper.decryptStream(key, inputStream, outputStream, cryptoProgressListener);
        if (!zDecryptStream) {
            KmxErrorHandler.throwIfNotSuccess("6(1)-2|Fail to decrypt stream data. Invalid service key id", 305);
        }
        return zDecryptStream;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxCipher
    public byte[] encryptData(@NonNull Key key, byte[] bArr) throws KmxException {
        byte[] bArrEncryptData = AndroidKeystoreHelper.encryptData(key, bArr);
        KmxErrorHandler.throwIfNull(bArrEncryptData, "4-2|Fail to encrypt data. Invalid service key id", 305);
        return bArrEncryptData;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxCipher
    public boolean encryptStream(@NonNull Key key, InputStream inputStream, OutputStream outputStream, @Nullable CryptoProgressListener cryptoProgressListener) throws KmxException {
        boolean zEncryptStream = cryptoProgressListener == null ? AndroidKeystoreHelper.encryptStream(key, inputStream, outputStream) : AndroidKeystoreHelper.encryptStream(key, inputStream, outputStream, cryptoProgressListener);
        if (!zEncryptStream) {
            KmxErrorHandler.throwIfNotSuccess("4(1)-2|Fail to encrypt stream data. Invalid service key id", 305);
        }
        return zEncryptStream;
    }
}
