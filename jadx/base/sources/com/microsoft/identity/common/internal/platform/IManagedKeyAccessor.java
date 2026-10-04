package com.microsoft.identity.common.internal.platform;

import com.microsoft.identity.common.java.crypto.IKeyAccessor;
import com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager;
import java.security.KeyStore;
import java.security.KeyStore.Entry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IManagedKeyAccessor<K extends KeyStore.Entry> extends IKeyAccessor {
    IKeyStoreKeyManager<K> getManager();
}
