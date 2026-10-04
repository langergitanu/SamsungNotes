package com.microsoft.identity.common.internal.cache;

import androidx.annotation.NonNull;
import com.microsoft.identity.common.internal.cache.IMultiTypeNameValueStorageReencrypter;
import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DefaultMultiTypeNameValueStorageReencrypter implements IMultiTypeNameValueStorageReencrypter {
    @Override // com.microsoft.identity.common.internal.cache.IMultiTypeNameValueStorageReencrypter
    public void reencrypt(@NonNull IMultiTypeNameValueStorage iMultiTypeNameValueStorage, @NonNull IMultiTypeNameValueStorageReencrypter.IStringEncrypter iStringEncrypter, @NonNull IMultiTypeNameValueStorageReencrypter.IStringDecrypter iStringDecrypter, @NonNull IMultiTypeNameValueStorageReencrypter.ReencryptionParams reencryptionParams) throws Exception {
        for (Map.Entry entry : new HashMap(iMultiTypeNameValueStorage.getAll()).entrySet()) {
            String str = (String) entry.getKey();
            try {
                iMultiTypeNameValueStorage.putString(str, iStringEncrypter.encrypt(iStringDecrypter.decrypt((String) entry.getValue())));
            } catch (Exception e) {
                if (reencryptionParams.eraseEntryOnError()) {
                    iMultiTypeNameValueStorage.remove(str);
                }
                if (reencryptionParams.eraseAllOnError()) {
                    iMultiTypeNameValueStorage.clear();
                    if (reencryptionParams.abortOnError()) {
                        throw e;
                    }
                    return;
                } else if (reencryptionParams.abortOnError()) {
                    throw e;
                }
            }
        }
    }

    @Override // com.microsoft.identity.common.internal.cache.IMultiTypeNameValueStorageReencrypter
    public void reencryptAsync(@NonNull final IMultiTypeNameValueStorage iMultiTypeNameValueStorage, @NonNull final IMultiTypeNameValueStorageReencrypter.IStringEncrypter iStringEncrypter, @NonNull final IMultiTypeNameValueStorageReencrypter.IStringDecrypter iStringDecrypter, @NonNull final IMultiTypeNameValueStorageReencrypter.ReencryptionParams reencryptionParams, @NonNull final TaskCompletedCallbackWithError<Void, Exception> taskCompletedCallbackWithError) {
        new Thread(new Runnable() { // from class: com.microsoft.identity.common.internal.cache.DefaultMultiTypeNameValueStorageReencrypter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DefaultMultiTypeNameValueStorageReencrypter.this.reencrypt(iMultiTypeNameValueStorage, iStringEncrypter, iStringDecrypter, reencryptionParams);
                    taskCompletedCallbackWithError.onTaskCompleted(null);
                } catch (Exception e) {
                    taskCompletedCallbackWithError.onError(e);
                }
            }
        }).start();
    }
}
