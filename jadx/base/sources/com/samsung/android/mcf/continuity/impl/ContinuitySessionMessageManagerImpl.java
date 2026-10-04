package com.samsung.android.mcf.continuity.impl;

import androidx.annotation.NonNull;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.mcf.continuity.api.ContinuityMessageManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionMessageManager;
import com.samsung.android.mcf.continuity.common.DLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuitySessionMessageManagerImpl implements ContinuitySessionMessageManager {
    private static final String TAG = "ContinuitySessionMessageManagerImpl";

    @NonNull
    private final ContinuitySession mContinuitySession;

    public ContinuitySessionMessageManagerImpl(@NonNull ContinuitySession continuitySession) {
        this.mContinuitySession = continuitySession;
    }

    public void destroy() {
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityMessageManager
    public boolean registerMessageListener(@NonNull ContinuityMessageManager.MessageListener messageListener) {
        DLog.m5610i(TAG, "registerMessageListener", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        return this.mContinuitySession.registerMessageListener(messageListener);
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionMessageManager
    public boolean sendMessage(@NonNull String str, @NonNull byte[] bArr, int i, @NonNull ContinuitySessionMessageManager.SendMessageCallback sendMessageCallback) {
        DLog.m5610i(TAG, "sendMessage", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        return this.mContinuitySession.sendMessage(str, bArr, i, sendMessageCallback);
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityMessageManager
    public void unregisterMessageListener() {
        DLog.m5610i(TAG, "unregisterMessageListener", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        this.mContinuitySession.unregisterMessageListener();
    }
}
