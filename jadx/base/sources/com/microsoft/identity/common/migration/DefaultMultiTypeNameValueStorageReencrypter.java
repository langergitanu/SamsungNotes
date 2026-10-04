package com.microsoft.identity.common.migration;

import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.util.TaskCompletedCallback;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.identity.common.migration.IMultiTypeNameValueStorageReencrypter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DefaultMultiTypeNameValueStorageReencrypter implements IMultiTypeNameValueStorageReencrypter {
    private static final String TAG = "DefaultMultiTypeNameValueStorageReencrypter";
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callable<T> {
        void call(T t);
    }

    private void applyCacheMutation(@NonNull Map<String, String> map, @NonNull Callable<Map.Entry<String, String>> callable, @NonNull MigrationOperationResult migrationOperationResult, @NonNull IMultiTypeNameValueStorageReencrypter.ReencryptionParams reencryptionParams, @NonNull Set<String> set, @NonNull Set<String> set2, @NonNull AtomicBoolean atomicBoolean) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":applyCacheMutation", new StringBuilder());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                if (set2.contains(entry.getKey())) {
                    Logger.warn(strM1170p, "Skipping entry.");
                } else {
                    callable.call(entry);
                }
            } catch (Exception e) {
                Logger.error(strM1170p, "Error during mutation", e);
                Logger.errorPII(strM1170p, "Failed key: " + entry.getKey(), e);
                migrationOperationResult.addFailure(e);
                set2.add(entry.getKey());
                if (reencryptionParams.eraseEntryOnError()) {
                    Logger.warn(strM1170p, "Marking key for removal.");
                    set.add(entry.getKey());
                }
                if (reencryptionParams.eraseAllOnError()) {
                    Logger.warn(strM1170p, "Marking all keys for removal.");
                    set.addAll(map.keySet());
                    atomicBoolean.set(true);
                    return;
                } else if (reencryptionParams.abortOnError()) {
                    atomicBoolean.set(true);
                    return;
                }
            }
        }
    }

    private void clearEntriesMarkedForRemoval(@NonNull INameValueStorage<String> iNameValueStorage, @NonNull Map<String, String> map, @NonNull Set<String> set) {
        Logger.warn(TAG + ":clearEntriesMarkedForRemoval", "Removing entries marked for removal");
        for (String str : set) {
            map.remove(str);
            iNameValueStorage.remove(str);
        }
    }

    @Override // com.microsoft.identity.common.migration.IMultiTypeNameValueStorageReencrypter
    public IMigrationOperationResult reencrypt(@NonNull INameValueStorage<String> iNameValueStorage, @NonNull final IMultiTypeNameValueStorageReencrypter.IStringEncrypter iStringEncrypter, @NonNull final IMultiTypeNameValueStorageReencrypter.IStringDecrypter iStringDecrypter, @NonNull IMultiTypeNameValueStorageReencrypter.ReencryptionParams reencryptionParams) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":reencrypt", new StringBuilder());
        HashMap map = new HashMap(iNameValueStorage.getAll());
        Logger.verbose(strM1170p, "Attempting to migrate cache entries: " + map.size());
        MigrationOperationResult migrationOperationResult = new MigrationOperationResult();
        migrationOperationResult.setCountOfTotalRecords(map.size());
        Set<String> hashSet = new HashSet<>();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Set<String> hashSet2 = new HashSet<>();
        applyCacheMutation(map, new Callable<Map.Entry<String, String>>() { // from class: com.microsoft.identity.common.migration.DefaultMultiTypeNameValueStorageReencrypter.1
            @Override // com.microsoft.identity.common.migration.DefaultMultiTypeNameValueStorageReencrypter.Callable
            public void call(Map.Entry<String, String> entry) {
                entry.setValue(iStringDecrypter.decrypt(entry.getValue()));
            }
        }, migrationOperationResult, reencryptionParams, hashSet, hashSet2, atomicBoolean);
        clearEntriesMarkedForRemoval(iNameValueStorage, map, hashSet);
        if (atomicBoolean.get()) {
            Logger.info(strM1170p, "Aborting after decrypt.");
            return migrationOperationResult;
        }
        applyCacheMutation(map, new Callable<Map.Entry<String, String>>() { // from class: com.microsoft.identity.common.migration.DefaultMultiTypeNameValueStorageReencrypter.2
            @Override // com.microsoft.identity.common.migration.DefaultMultiTypeNameValueStorageReencrypter.Callable
            public void call(Map.Entry<String, String> entry) {
                entry.setValue(iStringEncrypter.encrypt(entry.getValue()));
            }
        }, migrationOperationResult, reencryptionParams, hashSet, hashSet2, atomicBoolean);
        clearEntriesMarkedForRemoval(iNameValueStorage, map, hashSet);
        if (atomicBoolean.get()) {
            Logger.info(strM1170p, "Aborting after reencrypt.");
            return migrationOperationResult;
        }
        Logger.info(strM1170p, "Writing reencrypted cache entries.");
        for (Map.Entry entry : map.entrySet()) {
            iNameValueStorage.put((String) entry.getKey(), (String) entry.getValue());
        }
        return migrationOperationResult;
    }

    @Override // com.microsoft.identity.common.migration.IMultiTypeNameValueStorageReencrypter
    public void reencryptAsync(@NonNull final INameValueStorage<String> iNameValueStorage, @NonNull final IMultiTypeNameValueStorageReencrypter.IStringEncrypter iStringEncrypter, @NonNull final IMultiTypeNameValueStorageReencrypter.IStringDecrypter iStringDecrypter, @NonNull final IMultiTypeNameValueStorageReencrypter.ReencryptionParams reencryptionParams, @NonNull final TaskCompletedCallback<IMigrationOperationResult> taskCompletedCallback) {
        executor.execute(new Runnable() { // from class: com.microsoft.identity.common.migration.DefaultMultiTypeNameValueStorageReencrypter.3
            @Override // java.lang.Runnable
            public void run() {
                taskCompletedCallback.onTaskCompleted(DefaultMultiTypeNameValueStorageReencrypter.this.reencrypt(iNameValueStorage, iStringEncrypter, iStringDecrypter, reencryptionParams));
            }
        });
    }
}
