package com.samsung.android.kmxservice.sdk.e2ee.manager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.kmxservice.sdk.e2ee.CryptoProgressListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface KmxCipher {
    byte[] decryptData(@NonNull Key key, byte[] bArr);

    default boolean decryptStream(@NonNull Key key, InputStream inputStream, OutputStream outputStream) {
        return decryptStream(key, inputStream, outputStream, null);
    }

    boolean decryptStream(@NonNull Key key, InputStream inputStream, OutputStream outputStream, @Nullable CryptoProgressListener cryptoProgressListener);

    byte[] encryptData(@NonNull Key key, byte[] bArr);

    default boolean encryptStream(@NonNull Key key, InputStream inputStream, OutputStream outputStream) {
        return encryptStream(key, inputStream, outputStream, null);
    }

    boolean encryptStream(@NonNull Key key, InputStream inputStream, OutputStream outputStream, @Nullable CryptoProgressListener cryptoProgressListener);
}
