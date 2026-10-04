package com.microsoft.identity.common.migration;

import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.util.TaskCompletedCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IMultiTypeNameValueStorageReencrypter {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IStringDecrypter {
        String decrypt(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IStringEncrypter {
        String encrypt(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReencryptionParams {
        private final boolean mAbortOnError;
        private final boolean mEraseAllOnError;
        private final boolean mEraseEntryOnError;

        public ReencryptionParams(boolean z, boolean z2, boolean z3) {
            this.mAbortOnError = z;
            this.mEraseEntryOnError = z2;
            this.mEraseAllOnError = z3;
        }

        public boolean abortOnError() {
            return this.mAbortOnError;
        }

        public boolean eraseAllOnError() {
            return this.mEraseAllOnError;
        }

        public boolean eraseEntryOnError() {
            return this.mEraseEntryOnError;
        }
    }

    IMigrationOperationResult reencrypt(INameValueStorage<String> iNameValueStorage, IStringEncrypter iStringEncrypter, IStringDecrypter iStringDecrypter, ReencryptionParams reencryptionParams);

    void reencryptAsync(INameValueStorage<String> iNameValueStorage, IStringEncrypter iStringEncrypter, IStringDecrypter iStringDecrypter, ReencryptionParams reencryptionParams, TaskCompletedCallback<IMigrationOperationResult> taskCompletedCallback);
}
