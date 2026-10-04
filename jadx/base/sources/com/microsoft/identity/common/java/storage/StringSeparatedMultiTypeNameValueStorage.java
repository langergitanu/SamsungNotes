package com.microsoft.identity.common.java.storage;

import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.interfaces.AbstractPerSeparatorMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class StringSeparatedMultiTypeNameValueStorage extends AbstractPerSeparatorMultiTypeNameValueStorage<String> {
    private static final int MAX_ITEM_COUNT = 25;
    private static final Map<String, IMultiTypeNameValueStorage> sStringSeparatedStorageCache = Collections.synchronizedMap(new LinkedHashMap<String, IMultiTypeNameValueStorage>(2, 0.75f, true) { // from class: com.microsoft.identity.common.java.storage.StringSeparatedMultiTypeNameValueStorage.1
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, IMultiTypeNameValueStorage> entry) {
            return size() > 25;
        }
    });

    @NonNull
    private final IPlatformComponents mPlatformComponents;
    private final boolean mShouldEncrypt;

    public StringSeparatedMultiTypeNameValueStorage(@NonNull IPlatformComponents iPlatformComponents, boolean z) {
        if (iPlatformComponents == null) {
            throw new NullPointerException("mPlatformComponents is marked non-null but is null");
        }
        this.mPlatformComponents = iPlatformComponents;
        this.mShouldEncrypt = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ IMultiTypeNameValueStorage lambda$getStoreForSeparator$0(String str, String str2) {
        return this.mShouldEncrypt ? this.mPlatformComponents.getStorageSupplier().getEncryptedFileStore(str) : this.mPlatformComponents.getStorageSupplier().getUnencryptedFileStore(str);
    }

    @Override // com.microsoft.identity.common.java.interfaces.AbstractPerSeparatorMultiTypeNameValueStorage
    @NonNull
    public synchronized IMultiTypeNameValueStorage getStoreForSeparator(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        return sStringSeparatedStorageCache.computeIfAbsent(str, new C6438a(this, str, 0));
    }
}
