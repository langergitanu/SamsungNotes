package com.microsoft.identity.common.java.interfaces;

import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH&¨\u0006\r"}, m13886d2 = {"Lcom/microsoft/identity/common/java/interfaces/IStorageSupplier;", "", "getEncryptedFileStore", "Lcom/microsoft/identity/common/java/cache/IMultiTypeNameValueStorage;", "storeName", "", "getEncryptedNameValueStore", "Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;", "T", "clazz", "Ljava/lang/Class;", "getUnencryptedFileStore", "getUnencryptedNameValueStore", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface IStorageSupplier {
    @NotNull
    IMultiTypeNameValueStorage getEncryptedFileStore(@NotNull String storeName);

    @NotNull
    <T> INameValueStorage<T> getEncryptedNameValueStore(@NotNull String storeName, @NotNull Class<T> clazz);

    @NotNull
    IMultiTypeNameValueStorage getUnencryptedFileStore(@NotNull String storeName);

    @NotNull
    <T> INameValueStorage<T> getUnencryptedNameValueStore(@NotNull String storeName, @NotNull Class<T> clazz);
}
